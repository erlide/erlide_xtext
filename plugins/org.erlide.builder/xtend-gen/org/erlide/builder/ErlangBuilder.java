package org.erlide.builder;

import com.google.common.base.Objects;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.BuilderMarkerUpdater;
import org.erlide.builder.compiler.CompilerOptions;
import org.erlide.builder.compiler.CompilerProblem;
import org.erlide.builder.compiler.ErlCompiler;
import org.erlide.builder.compiler.IErlangCompiler;
import org.erlide.project.model.IErlangProject;

@SuppressWarnings("all")
public class ErlangBuilder extends IncrementalProjectBuilder {
  public static String BUILDER_ID = "org.erlide.builder.erlangBuilder";
  
  public static String MARKER_TYPE = "org.erlide.builder.erlangBuildProblem";
  
  private Map<String,IErlangCompiler> compilers;
  
  private BuilderMarkerUpdater markerUpdater;
  
  public ErlangBuilder() {
    HashMap<String,IErlangCompiler> _newHashMap = CollectionLiterals.<String, IErlangCompiler>newHashMap();
    this.compilers = _newHashMap;
    BuilderMarkerUpdater _builderMarkerUpdater = new BuilderMarkerUpdater(ErlangBuilder.MARKER_TYPE);
    this.markerUpdater = _builderMarkerUpdater;
  }
  
  protected IProject[] build(final int kind, final Map<String,String> args, final IProgressMonitor monitor) throws CoreException {
    this.loadCompilers();
    InputOutput.<String>println("HHHHHHHHHHHHHHHHHHHHHHHH");
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
  
  protected void clean(final IProgressMonitor monitor) throws CoreException {
    IProject _project = this.getProject();
    this.markerUpdater.clean(_project);
  }
  
  private void compileResource(final IResource resource) {
    boolean _ignoreResource = this.ignoreResource(resource);
    if (_ignoreResource) {
      return;
    }
    final IFile erlFile = ((IFile) resource);
    this.markerUpdater.deleteMarkers(erlFile);
    IProject _project = this.getProject();
    String _compilerId = this.getCompilerId(_project);
    final IErlangCompiler compiler = this.compilers.get(_compilerId);
    boolean _equals = Objects.equal(compiler, null);
    if (_equals) {
    } else {
      CompilerOptions _compilerOptions = new CompilerOptions();
      final CompilerOptions options = _compilerOptions;
      Collection<CompilerProblem> _compileResource = compiler.compileResource(erlFile, options);
      final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
          public void apply(final CompilerProblem it) {
            String _message = it.getMessage();
            int _line = it.getLine();
            int _severity = it.getSeverity();
            ErlangBuilder.this.markerUpdater.addMarker(erlFile, _message, _line, _severity);
          }
        };
      IterableExtensions.<CompilerProblem>forEach(_compileResource, _function);
    }
  }
  
  private boolean ignoreResource(final IResource resource) {
    final boolean isFile = (resource instanceof IFile);
    IAdapterManager _adapterManager = Platform.getAdapterManager();
    IProject _project = this.getProject();
    final Object erlProject = _adapterManager.getAdapter(_project, IErlangProject.class);
    IProject _project_1 = this.getProject();
    String _plus = ("!!! " + _project_1);
    String _plus_1 = (_plus + " ");
    String _plus_2 = (_plus_1 + erlProject);
    InputOutput.<String>println(_plus_2);
    boolean _or = false;
    if (true) {
      _or = true;
    } else {
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(erlProject, null));
      if (!_notEquals) {
        _and = false;
      } else {
        _and = (_notEquals && true);
      }
      _or = (true || _and);
    }
    final boolean onSourcePath = _or;
    boolean _or_1 = false;
    boolean _or_2 = false;
    boolean _not = (!isFile);
    if (_not) {
      _or_2 = true;
    } else {
      boolean _isErlangResource = this.isErlangResource(resource);
      boolean _not_1 = (!_isErlangResource);
      _or_2 = (_not || _not_1);
    }
    if (_or_2) {
      _or_1 = true;
    } else {
      boolean _not_2 = (!onSourcePath);
      _or_1 = (_or_2 || _not_2);
    }
    return _or_1;
  }
  
  private String getCompilerId(final IProject project) {
    return ErlCompiler.COMPILER_ID;
  }
  
  private boolean isErlangResource(final IResource resource) {
    IPath _projectRelativePath = resource.getProjectRelativePath();
    String _fileExtension = _projectRelativePath.getFileExtension();
    return Objects.equal(_fileExtension, "erl");
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
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }
}
