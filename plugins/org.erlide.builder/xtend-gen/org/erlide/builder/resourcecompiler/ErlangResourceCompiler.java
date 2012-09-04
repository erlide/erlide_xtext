package org.erlide.builder.resourcecompiler;

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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.AbstractErlangBuilder;
import org.erlide.builder.BuilderMarkerUpdater;
import org.erlide.builder.CompilerOptions;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.resourcecompiler.ErlCompiler;
import org.erlide.builder.resourcecompiler.IErlangCompiler;
import org.erlide.project.model.IErlangProject;

@SuppressWarnings("all")
public class ErlangResourceCompiler extends AbstractErlangBuilder {
  private Map<String,IErlangCompiler> compilers;
  
  public ErlangResourceCompiler(final IProject project, final BuilderMarkerUpdater markerUpdater) {
    super(project, markerUpdater);
    HashMap<String,IErlangCompiler> _newHashMap = CollectionLiterals.<String, IErlangCompiler>newHashMap();
    this.compilers = _newHashMap;
  }
  
  public ErlangResourceCompiler() {
    super();
    HashMap<String,IErlangCompiler> _newHashMap = CollectionLiterals.<String, IErlangCompiler>newHashMap();
    this.compilers = _newHashMap;
  }
  
  public void setProject(final IProject project) {
    this.setProject(project);
  }
  
  public String getId() {
    Class<? extends Object> _class = this.getClass();
    String _name = _class.getName();
    String _lowerCase = _name.toLowerCase();
    return _lowerCase;
  }
  
  public void clean(final IProgressMonitor monitor) throws CoreException {
    BuilderMarkerUpdater _markerUpdater = this.getMarkerUpdater();
    IProject _project = this.getProject();
    _markerUpdater.clean(_project);
  }
  
  private void compileResource(final IResource resource) {
    boolean _ignoreResource = this.ignoreResource(resource);
    if (_ignoreResource) {
      return;
    }
    final IFile erlFile = ((IFile) resource);
    BuilderMarkerUpdater _markerUpdater = this.getMarkerUpdater();
    _markerUpdater.deleteMarkers(erlFile);
    IProject _project = this.getProject();
    String _compilerId = this.getCompilerId(_project);
    final IErlangCompiler compiler = this.compilers.get(_compilerId);
    boolean _equals = Objects.equal(compiler, null);
    if (_equals) {
    } else {
      CompilerOptions _compilerOptions = new CompilerOptions();
      final CompilerOptions options = _compilerOptions;
      String _plus = ("compile " + erlFile);
      InputOutput.<String>println(_plus);
      Collection<CompilerProblem> _compileResource = compiler.compileResource(erlFile, options);
      final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
          public void apply(final CompilerProblem it) {
            BuilderMarkerUpdater _markerUpdater = ErlangResourceCompiler.this.getMarkerUpdater();
            String _message = it.getMessage();
            int _line = it.getLine();
            int _severity = it.getSeverity();
            _markerUpdater.addMarker(erlFile, _message, _line, _severity);
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
  
  public void fullBuild(final IProgressMonitor monitor) throws CoreException {
    try {
      IProject _project = this.getProject();
      final Function1<IResource,Boolean> _function = new Function1<IResource,Boolean>() {
          public Boolean apply(final IResource it) {
            boolean _isCanceled = monitor.isCanceled();
            if (_isCanceled) {
              OperationCanceledException _operationCanceledException = new OperationCanceledException();
              throw _operationCanceledException;
            }
            ErlangResourceCompiler.this.compileResource(it);
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
          boolean _isCanceled = monitor.isCanceled();
          if (_isCanceled) {
            OperationCanceledException _operationCanceledException = new OperationCanceledException();
            throw _operationCanceledException;
          }
          int _kind = it.getKind();
          final int getKind = _kind;
          boolean _matched = false;
          if (!_matched) {
            if (Objects.equal(getKind,IResourceDelta.ADDED)) {
              _matched=true;
              IResource _resource = it.getResource();
              ErlangResourceCompiler.this.compileResource(_resource);
            }
          }
          if (!_matched) {
            if (Objects.equal(getKind,IResourceDelta.CHANGED)) {
              _matched=true;
              IResource _resource_1 = it.getResource();
              ErlangResourceCompiler.this.compileResource(_resource_1);
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
  
  public void setMarkerUpdater(final BuilderMarkerUpdater markerUpdater) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
}
