package org.erlide.builder;

import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.compiler.CompilerProblem;
import org.erlide.builder.compiler.ErlCompiler;
import org.erlide.builder.compiler.IErlangCompiler;

@SuppressWarnings("all")
public class ErlangBuilder extends IncrementalProjectBuilder {
  public static String BUILDER_ID = "org.erlide.builder.erlangBuilder";
  
  public static String MARKER_TYPE = "org.erlide.builder.erlangBuildProblem";
  
  private Map<String,IErlangCompiler> compilers;
  
  public ErlangBuilder() {
    HashMap<String,IErlangCompiler> _newHashMap = CollectionLiterals.<String, IErlangCompiler>newHashMap();
    this.compilers = _newHashMap;
  }
  
  public static void addMarker(final IFile file, final String message, final int lineNumber, final int severity) {
    int ln = lineNumber;
    try {
      final IMarker marker = file.createMarker(ErlangBuilder.MARKER_TYPE);
      marker.setAttribute(IMarker.MESSAGE, message);
      marker.setAttribute(IMarker.SEVERITY, severity);
      int _minus = (-1);
      boolean _equals = (lineNumber == _minus);
      if (_equals) {
        ln = 1;
      } else {
        ln = lineNumber;
      }
      marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected IProject[] build(final int kind, final Map<String,String> args, final IProgressMonitor monitor) throws CoreException {
    this.loadCompilers();
    boolean _equals = (kind == IncrementalProjectBuilder.FULL_BUILD);
    if (_equals) {
      this.fullBuild(monitor);
    } else {
      IProject _project = this.getProject();
      final IResourceDelta delta = this.getDelta(_project);
      boolean _equals_1 = Objects.equal(delta, null);
      if (_equals_1) {
        this.fullBuild(monitor);
      } else {
        this.incrementalBuild(delta, monitor);
      }
    }
    IProject _project_1 = this.getProject();
    SubProgressMonitor _subProgressMonitor = new SubProgressMonitor(monitor, 10);
    _project_1.refreshLocal(IResource.DEPTH_INFINITE, _subProgressMonitor);
    return null;
  }
  
  private void compileResource(final IResource resource) {
    boolean _or = false;
    boolean _not = (!(resource instanceof IFile));
    if (_not) {
      _or = true;
    } else {
      boolean _isErlangResource = this.isErlangResource(resource);
      boolean _not_1 = (!_isErlangResource);
      _or = (_not || _not_1);
    }
    if (_or) {
      return;
    }
    this.deleteMarkers(((IFile) resource));
    IErlangCompiler _get = this.compilers.get(ErlCompiler.COMPILER_ID);
    final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
        public void apply(final CompilerProblem it) {
          IFile _file = it.getFile();
          String _message = it.getMessage();
          int _line = it.getLine();
          int _severity = it.getSeverity();
          ErlangBuilder.addMarker(_file, _message, _line, _severity);
        }
      };
    _get.compileResource(((IFile) resource), null, _function);
  }
  
  private boolean isErlangResource(final IResource resource) {
    IPath _projectRelativePath = resource.getProjectRelativePath();
    String _fileExtension = _projectRelativePath.getFileExtension();
    return Objects.equal(_fileExtension, "erl");
  }
  
  public void deleteMarkers(final IFile file) {
    try {
      file.deleteMarkers(ErlangBuilder.MARKER_TYPE, false, IResource.DEPTH_ZERO);
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException ce = (CoreException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected void fullBuild(final IProgressMonitor monitor) throws CoreException {
    try {
      IProject _project = this.getProject();
      final Function1<IResource,Boolean> _function = new Function1<IResource,Boolean>() {
          public Boolean apply(final IResource it) {
            ErlangBuilder.this.compileResource(it);
            return true;
          }
        };
      _project.accept(new IResourceVisitor() {
          public boolean visit(IResource resource) {
            return _function.apply(resource);
          }
      });
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void incrementalBuild(final IResourceDelta delta, final IProgressMonitor monitor) throws CoreException {
    final Function1<IResourceDelta,Boolean> _function = new Function1<IResourceDelta,Boolean>() {
        public Boolean apply(final IResourceDelta it) {
          int _kind = it.getKind();
          final int getKind = _kind;
          boolean _matched = false;
          if (!_matched) {
            if (Objects.equal(getKind,IResourceDelta.ADDED)) {
              _matched=true;
              IResource _resource = it.getResource();
              ErlangBuilder.this.compileResource(_resource);
            }
          }
          if (!_matched) {
            if (Objects.equal(getKind,IResourceDelta.CHANGED)) {
              _matched=true;
              IResource _resource_1 = it.getResource();
              ErlangBuilder.this.compileResource(_resource_1);
            }
          }
          return true;
        }
      };
    delta.accept(new IResourceDeltaVisitor() {
        public boolean visit(IResourceDelta delta) {
          return _function.apply(delta);
        }
    });
  }
  
  private void loadCompilers() {
    final IExtensionRegistry reg = Platform.getExtensionRegistry();
    final IConfigurationElement[] elements = reg.getConfigurationElementsFor("org.erlide.builder.compilers");
    for (final IConfigurationElement element : elements) {
      try {
        Object _createExecutableExtension = element.createExecutableExtension("class");
        final IErlangCompiler compiler = ((IErlangCompiler) _createExecutableExtension);
        String _id = compiler.getId();
        this.compilers.put(_id, compiler);
      } catch (final Throwable _t) {
        if (_t instanceof CoreException) {
          final CoreException e = (CoreException)_t;
          e.printStackTrace();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }
}
