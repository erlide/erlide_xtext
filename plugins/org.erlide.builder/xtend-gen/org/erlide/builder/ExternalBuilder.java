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
import org.eclipse.core.runtime.Path;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.AbstractErlangBuilder;
import org.erlide.builder.BuilderExecutor;
import org.erlide.builder.BuilderMarkerUpdater;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.DefaultLineParser;
import org.erlide.builder.ErlangBuilder;
import org.erlide.builder.ProjectBuilderExtensions;

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
    BuilderMarkerUpdater _markerUpdater = this.getMarkerUpdater();
    IProject _project = this.getProject();
    _markerUpdater.clean(_project, ErlangBuilder.MARKER_TYPE);
    List<String> _cleanCmdLine = this.getCleanCmdLine();
    final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
        public void apply(final CompilerProblem it) {
        }
      };
    this.execute(_cleanCmdLine, monitor, _function);
  }
  
  public void fullBuild(final IProgressMonitor monitor) throws CoreException {
    this.clean(monitor);
    List<String> _fullCmdLine = this.getFullCmdLine();
    final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
        public void apply(final CompilerProblem it) {
          IProject _project = ExternalBuilder.this.getProject();
          String _fileName = it.getFileName();
          Path _path = new Path(_fileName);
          final IPath fPath = ProjectBuilderExtensions.getPathInProject(_project, _path);
          IProject _project_1 = ExternalBuilder.this.getProject();
          IResource _findMember = _project_1.findMember(fPath);
          final IFile file = ((IFile) _findMember);
          boolean _notEquals = (!Objects.equal(file, null));
          if (_notEquals) {
            BuilderMarkerUpdater _markerUpdater = ExternalBuilder.this.getMarkerUpdater();
            String _message = it.getMessage();
            int _line = it.getLine();
            int _severity = it.getSeverity();
            _markerUpdater.addMarker(file, ErlangBuilder.MARKER_TYPE, _message, _line, _severity);
            monitor.worked(1);
          }
        }
      };
    this.execute(_fullCmdLine, monitor, _function);
  }
  
  public void incrementalBuild(final IResourceDelta delta, final IProgressMonitor monitor) throws CoreException {
    final Function1<IResourceDelta,Boolean> _function = new Function1<IResourceDelta,Boolean>() {
        public Boolean apply(final IResourceDelta it) {
          IResource _resource = it.getResource();
          boolean _not = (!(_resource instanceof IFile));
          if (_not) {
            return true;
          }
          monitor.worked(1);
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
    String _name = file.getName();
    final List<String> cmd = this.fillCmdLine(_singleCmdLine, _name);
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
    this.execute(cmd, monitor, _function);
  }
  
  private List<String> fillCmdLine(final List<String> cmds, final String file) {
    final Function1<String,String> _function = new Function1<String,String>() {
        public String apply(final String it) {
          String _xifexpression = null;
          boolean _equals = Objects.equal(it, "$file");
          if (_equals) {
            _xifexpression = file;
          } else {
            _xifexpression = it;
          }
          return _xifexpression;
        }
      };
    List<String> _map = ListExtensions.<String, String>map(cmds, _function);
    return _map;
  }
  
  private void execute(final List<String> cmds, final IProgressMonitor monitor, final Procedure1<? super CompilerProblem> callback) {
    String _plus = ("EXEC \'" + cmds);
    String _plus_1 = (_plus + "\' in ");
    IPath _workingDir = this.getWorkingDir();
    String _plus_2 = (_plus_1 + _workingDir);
    InputOutput.<String>println(_plus_2);
    IPath _workingDir_1 = this.getWorkingDir();
    String _oSString = _workingDir_1.toOSString();
    DefaultLineParser _defaultLineParser = new DefaultLineParser();
    final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
        public void apply(final CompilerProblem problem) {
          callback.apply(problem);
        }
      };
    this.executor.executeProcess(cmds, _oSString, monitor, _defaultLineParser, _function);
  }
  
  public void loadConfiguration() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
}
