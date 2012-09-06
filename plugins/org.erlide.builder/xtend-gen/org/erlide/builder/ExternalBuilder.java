package org.erlide.builder;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.AbstractErlangBuilder;
import org.erlide.builder.BuilderExecutor;
import org.erlide.builder.BuilderMarkerUpdater;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.DefaultLineParser;
import org.erlide.builder.ErlangBuilder;

@SuppressWarnings("all")
public abstract class ExternalBuilder extends AbstractErlangBuilder {
  private BuilderExecutor executor;
  
  private IPath _workingDir;
  
  public IPath getWorkingDir() {
    return this._workingDir;
  }
  
  public void setWorkingDir(final IPath workingDir) {
    this._workingDir = workingDir;
  }
  
  private List<String> _cleanCmdLine;
  
  public List<String> getCleanCmdLine() {
    return this._cleanCmdLine;
  }
  
  public void setCleanCmdLine(final List<String> cleanCmdLine) {
    this._cleanCmdLine = cleanCmdLine;
  }
  
  private List<String> _fullCmdLine;
  
  public List<String> getFullCmdLine() {
    return this._fullCmdLine;
  }
  
  public void setFullCmdLine(final List<String> fullCmdLine) {
    this._fullCmdLine = fullCmdLine;
  }
  
  private List<String> _singleCmdLine;
  
  public List<String> getSingleCmdLine() {
    return this._singleCmdLine;
  }
  
  public void setSingleCmdLine(final List<String> singleCmdLine) {
    this._singleCmdLine = singleCmdLine;
  }
  
  private final List<String> NONE = new Function0<List<String>>() {
    public List<String> apply() {
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public ExternalBuilder() {
    super();
    BuilderExecutor _builderExecutor = new BuilderExecutor();
    this.executor = _builderExecutor;
    this.setCleanCmdLine(this.NONE);
    this.setFullCmdLine(this.NONE);
    this.setSingleCmdLine(this.NONE);
  }
  
  public ExternalBuilder(final IProject project, final BuilderMarkerUpdater markerUpdater) {
    this(project, markerUpdater, new Function0<BuilderExecutor>() {
      public BuilderExecutor apply() {
        BuilderExecutor _builderExecutor = new BuilderExecutor();
        return _builderExecutor;
      }
    }.apply());
  }
  
  public ExternalBuilder(final IProject project, final BuilderMarkerUpdater markerUpdater, final BuilderExecutor executor) {
    super(project, markerUpdater);
    this.executor = executor;
    this.setCleanCmdLine(this.NONE);
    this.setFullCmdLine(this.NONE);
    this.setSingleCmdLine(this.NONE);
  }
  
  public void clean(final IProgressMonitor monitor) {
    List<String> _cleanCmdLine = this.getCleanCmdLine();
    this.execute(_cleanCmdLine, monitor);
  }
  
  public void fullBuild(final IProgressMonitor monitor) throws CoreException {
    BuilderMarkerUpdater _markerUpdater = this.getMarkerUpdater();
    IProject _project = this.getProject();
    _markerUpdater.clean(_project, ErlangBuilder.MARKER_TYPE);
    List<String> _fullCmdLine = this.getFullCmdLine();
    final List<CompilerProblem> errors = this.execute(_fullCmdLine, monitor);
    final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
        public void apply(final CompilerProblem it) {
          InputOutput.<CompilerProblem>println(it);
          IProject _project = ExternalBuilder.this.getProject();
          String _fileName = it.getFileName();
          IResource _findMember = _project.findMember(_fileName);
          final IFile file = ((IFile) _findMember);
          String _fileName_1 = it.getFileName();
          String _plus = ("FILE " + _fileName_1);
          String _plus_1 = (_plus + " = ");
          String _plus_2 = (_plus_1 + file);
          InputOutput.<String>println(_plus_2);
          boolean _notEquals = (!Objects.equal(file, null));
          if (_notEquals) {
            BuilderMarkerUpdater _markerUpdater = ExternalBuilder.this.getMarkerUpdater();
            String _message = it.getMessage();
            int _line = it.getLine();
            int _severity = it.getSeverity();
            _markerUpdater.addMarker(file, ErlangBuilder.MARKER_TYPE, _message, _line, _severity);
          }
        }
      };
    IterableExtensions.<CompilerProblem>forEach(errors, _function);
  }
  
  public void incrementalBuild(final IResourceDelta delta, final IProgressMonitor monitor) throws CoreException {
    final Function1<IResourceDelta,Boolean> _function = new Function1<IResourceDelta,Boolean>() {
        public Boolean apply(final IResourceDelta it) {
          boolean _isCanceled = monitor.isCanceled();
          if (_isCanceled) {
            OperationCanceledException _operationCanceledException = new OperationCanceledException();
            throw _operationCanceledException;
          }
          IResource _resource = it.getResource();
          boolean _not = (!(_resource instanceof IFile));
          if (_not) {
            return true;
          }
          int _kind = it.getKind();
          final int getKind = _kind;
          boolean _matched = false;
          if (!_matched) {
            if (Objects.equal(getKind,IResourceDelta.ADDED)) {
              _matched=true;
              IResource _resource_1 = it.getResource();
              ExternalBuilder.this.singleBuild(((IFile) _resource_1), monitor);
            }
          }
          if (!_matched) {
            if (Objects.equal(getKind,IResourceDelta.CHANGED)) {
              _matched=true;
              IResource _resource_2 = it.getResource();
              ExternalBuilder.this.singleBuild(((IFile) _resource_2), monitor);
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
  
  public void singleBuild(final IFile file, final IProgressMonitor monitor) {
    BuilderMarkerUpdater _markerUpdater = this.getMarkerUpdater();
    _markerUpdater.deleteMarkers(file, ErlangBuilder.MARKER_TYPE);
    List<String> _singleCmdLine = this.getSingleCmdLine();
    final List<CompilerProblem> errors = this.execute(_singleCmdLine, monitor);
    final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
        public void apply(final CompilerProblem it) {
          InputOutput.<CompilerProblem>println(it);
          BuilderMarkerUpdater _markerUpdater = ExternalBuilder.this.getMarkerUpdater();
          String _message = it.getMessage();
          int _line = it.getLine();
          int _severity = it.getSeverity();
          _markerUpdater.addMarker(file, ErlangBuilder.MARKER_TYPE, _message, _line, _severity);
        }
      };
    IterableExtensions.<CompilerProblem>forEach(errors, _function);
  }
  
  private List<CompilerProblem> execute(final List<String> cmds, final IProgressMonitor monitor) {
    String _plus = ("EXEC \'" + cmds);
    String _plus_1 = (_plus + "\' in ");
    IProject _project = this.getProject();
    String _name = _project.getName();
    String _plus_2 = (_plus_1 + _name);
    InputOutput.<String>println(_plus_2);
    final List<CompilerProblem> result = CollectionLiterals.<CompilerProblem>newArrayList();
    DefaultLineParser _defaultLineParser = new DefaultLineParser();
    final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
        public void apply(final CompilerProblem problem) {
          result.add(problem);
        }
      };
    this.executor.executeProcess(cmds, 
      "/vobs/gsn/product/code/sgsn-w/ups", monitor, _defaultLineParser, _function);
    return result;
  }
  
  public void loadConfiguration() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
}
