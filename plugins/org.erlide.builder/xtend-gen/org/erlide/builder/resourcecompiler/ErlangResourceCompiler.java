package org.erlide.builder.resourcecompiler;

import com.google.common.base.Objects;
import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
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
import org.erlide.builder.AbstractErlangBuilder;
import org.erlide.builder.CompilerOptions;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.ErlangBuilder;
import org.erlide.builder.resourcecompiler.ErlCompiler;
import org.erlide.builder.resourcecompiler.IErlangCompiler;
import org.erlide.common.util.ErlLogger;
import org.erlide.project.model.IErlangProject;

@SuppressWarnings("all")
public class ErlangResourceCompiler extends AbstractErlangBuilder {
  private Map<String, IErlangCompiler> compilers;
  
  @Inject
  private ErlLogger log;
  
  public ErlangResourceCompiler(final IProject project, final EventBus eventBus) {
    super(project, eventBus);
    HashMap<String, IErlangCompiler> _newHashMap = CollectionLiterals.<String, IErlangCompiler>newHashMap();
    this.compilers = _newHashMap;
  }
  
  public ErlangResourceCompiler() {
    super();
    HashMap<String, IErlangCompiler> _newHashMap = CollectionLiterals.<String, IErlangCompiler>newHashMap();
    this.compilers = _newHashMap;
  }
  
  @Override
  public void setProject(final IProject project) {
    this.setProject(project);
  }
  
  @Override
  public String getId() {
    Class<? extends ErlangResourceCompiler> _class = this.getClass();
    String _name = _class.getName();
    return _name.toLowerCase();
  }
  
  @Override
  public void clean(final IProgressMonitor monitor) throws CoreException {
    IProject _project = this.getProject();
    this.removeMarkers(_project, ErlangBuilder.MARKER_TYPE);
  }
  
  private void compileResource(final IResource resource) {
    boolean _ignoreResource = this.ignoreResource(resource);
    if (_ignoreResource) {
      return;
    }
    final IFile erlFile = ((IFile) resource);
    this.removeMarkers(erlFile, ErlangBuilder.MARKER_TYPE);
    IProject _project = this.getProject();
    String _compilerId = this.getCompilerId(_project);
    final IErlangCompiler compiler = this.compilers.get(_compilerId);
    boolean _equals = Objects.equal(compiler, null);
    if (_equals) {
    } else {
      final CompilerOptions options = new CompilerOptions();
      this.log.debug(("compile " + erlFile));
      Collection<CompilerProblem> _compileResource = compiler.compileResource(erlFile, options);
      final Consumer<CompilerProblem> _function = new Consumer<CompilerProblem>() {
        @Override
        public void accept(final CompilerProblem it) {
          String _message = it.getMessage();
          int _line = it.getLine();
          int _severity = it.getSeverity();
          CompilerProblem _compilerProblem = new CompilerProblem(ErlangBuilder.MARKER_TYPE, _message, _line, _severity);
          ErlangResourceCompiler.this.addMarker(erlFile, _compilerProblem);
        }
      };
      _compileResource.forEach(_function);
    }
  }
  
  private boolean ignoreResource(final IResource resource) {
    final boolean isFile = (resource instanceof IFile);
    IAdapterManager _adapterManager = Platform.getAdapterManager();
    IProject _project = this.getProject();
    final IErlangProject erlProject = _adapterManager.<IErlangProject>getAdapter(_project, IErlangProject.class);
    boolean _or = false;
    if (true) {
      _or = true;
    } else {
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(erlProject, null));
      if (!_notEquals) {
        _and = false;
      } else {
        _and = true;
      }
      _or = _and;
    }
    final boolean onSourcePath = _or;
    boolean _or_1 = false;
    boolean _or_2 = false;
    if ((!isFile)) {
      _or_2 = true;
    } else {
      boolean _isErlangResource = this.isErlangResource(resource);
      boolean _not = (!_isErlangResource);
      _or_2 = _not;
    }
    if (_or_2) {
      _or_1 = true;
    } else {
      _or_1 = (!onSourcePath);
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
  
  @Override
  public void fullBuild(final IProgressMonitor monitor) throws CoreException {
    try {
      IProject _project = this.getProject();
      final IResourceVisitor _function = new IResourceVisitor() {
        @Override
        public boolean visit(final IResource it) throws CoreException {
          boolean _isCanceled = monitor.isCanceled();
          if (_isCanceled) {
            throw new OperationCanceledException();
          }
          ErlangResourceCompiler.this.compileResource(it);
          return true;
        }
      };
      _project.accept(_function);
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Override
  public void incrementalBuild(final IResourceDelta delta, final IProgressMonitor monitor) throws CoreException {
    final IResourceDeltaVisitor _function = new IResourceDeltaVisitor() {
      @Override
      public boolean visit(final IResourceDelta it) throws CoreException {
        boolean _isCanceled = monitor.isCanceled();
        if (_isCanceled) {
          throw new OperationCanceledException();
        }
        int _kind = it.getKind();
        switch (_kind) {
          case IResourceDelta.ADDED:
            IResource _resource = it.getResource();
            ErlangResourceCompiler.this.compileResource(_resource);
            break;
          case IResourceDelta.CHANGED:
            IResource _resource_1 = it.getResource();
            ErlangResourceCompiler.this.compileResource(_resource_1);
            break;
        }
        return true;
      }
    };
    delta.accept(_function);
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
