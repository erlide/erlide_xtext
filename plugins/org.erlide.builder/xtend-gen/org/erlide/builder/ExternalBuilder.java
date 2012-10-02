package org.erlide.builder;

import com.google.common.base.Objects;
import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
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
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.AbstractErlangBuilder;
import org.erlide.builder.BuilderExecutor;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.DefaultLineParser;
import org.erlide.builder.ErlangBuilder;
import org.erlide.builder.ProgressLineParser;
import org.erlide.builder.ProjectBuilderExtensions;
import org.erlide.builder.ToBuildLineParser;
import org.erlide.common.util.ErlLogger;

@SuppressWarnings("all")
public abstract class ExternalBuilder extends AbstractErlangBuilder {
  @Inject
  private BuilderExecutor executor;
  
  @Inject
  private ErlLogger log;
  
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
    this.setCleanCmdLine(this.NONE);
    this.setFullCmdLine(this.NONE);
    this.setSingleCmdLine(this.NONE);
  }
  
  public ExternalBuilder(final IProject project, final BuilderExecutor executor, final EventBus eventBus) {
    super(project, eventBus);
    this.executor = executor;
    this.setCleanCmdLine(this.NONE);
    this.setFullCmdLine(this.NONE);
    this.setSingleCmdLine(this.NONE);
  }
  
  public void clean(final IProgressMonitor monitor) {
    final SubMonitor progress = SubMonitor.convert(monitor, 100);
    IProject _project = this.getProject();
    this.removeMarkers(_project, ErlangBuilder.MARKER_TYPE);
    List<String> _cleanCmdLine = this.getCleanCmdLine();
    final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
        public void apply(final CompilerProblem it) {
        }
      };
    this.execute(_cleanCmdLine, progress, _function);
    progress.worked(100);
  }
  
  public void fullBuild(final IProgressMonitor monitor) throws CoreException {
    try {
      SubMonitor progress = SubMonitor.convert(monitor, 100);
      List<String> _fullCmdLine = this.getFullCmdLine();
      final int work = this.estimateWork(_fullCmdLine);
      progress.worked(10);
      SubMonitor _newChild = progress.newChild(90);
      SubMonitor _convert = SubMonitor.convert(_newChild, work);
      progress = _convert;
      IntegerRange _upTo = new IntegerRange(0, work);
      for (final Integer i : _upTo) {
        {
          Thread.sleep(10);
          progress.newChild(1);
        }
      }
      Thread.sleep(1000);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void incrementalBuild(final IResourceDelta delta, final IProgressMonitor monitor) throws CoreException {
    List<String> _fullCmdLine = this.getFullCmdLine();
    final int work = this.estimateWork(_fullCmdLine);
    final SubMonitor progress = SubMonitor.convert(monitor, work);
    final Function1<IResourceDelta,Boolean> _function = new Function1<IResourceDelta,Boolean>() {
        public Boolean apply(final IResourceDelta it) {
          IResource _resource = it.getResource();
          boolean _not = (!(_resource instanceof IFile));
          if (_not) {
            return true;
          }
          boolean _isCanceled = progress.isCanceled();
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
              IResource _resource_1 = it.getResource();
              ExternalBuilder.this.singleBuild(((IFile) _resource_1), progress);
            }
          }
          if (!_matched) {
            if (Objects.equal(getKind,IResourceDelta.CHANGED)) {
              _matched=true;
              IResource _resource_2 = it.getResource();
              ExternalBuilder.this.singleBuild(((IFile) _resource_2), progress);
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
    List<String> _singleCmdLine = this.getSingleCmdLine();
    String _name = file.getName();
    final List<String> cmd = this.fillCmdLine(_singleCmdLine, _name);
    final int work = this.estimateWork(cmd, 1);
    final SubMonitor progress = SubMonitor.convert(monitor, work);
    this.removeMarkers(file, ErlangBuilder.MARKER_TYPE);
    final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
        public void apply(final CompilerProblem it) {
          ExternalBuilder.this.addMarker(file, it);
        }
      };
    this.execute(cmd, progress, _function);
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
    this.log.debug(_plus_2);
    ExternalBuilder.REZ();
    ProgressLineParser _progressLineParser = new ProgressLineParser();
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          monitor.worked(1);
          ExternalBuilder.INC();
          int _ASK = ExternalBuilder.ASK();
          InputOutput.<Integer>print(Integer.valueOf(_ASK));
          InputOutput.<String>print(" ");
        }
      };
    final Procedure1<BuilderExecutor> _function_1 = new Procedure1<BuilderExecutor>() {
        public void apply(final BuilderExecutor it) {
          DefaultLineParser _defaultLineParser = new DefaultLineParser();
          final Procedure1<BuilderExecutor> _function = new Procedure1<BuilderExecutor>() {
              public void apply(final BuilderExecutor it) {
                IPath _workingDir = ExternalBuilder.this.getWorkingDir();
                String _oSString = _workingDir.toOSString();
                it.executeProcess(cmds, _oSString, monitor);
              }
            };
          it.<CompilerProblem>withHandler(_defaultLineParser, callback, _function);
        }
      };
    this.executor.<String>withHandler(_progressLineParser, _function, _function_1);
  }
  
  private static int x = 0;
  
  public static void INC() {
    int _plus = (ExternalBuilder.x + 1);
    ExternalBuilder.x = _plus;
  }
  
  public static void REZ() {
    ExternalBuilder.x = 1;
  }
  
  public static int ASK() {
    return ExternalBuilder.x;
  }
  
  public void loadConfiguration() {
    IProject _project = this.getProject();
    IPath _location = _project.getLocation();
    String _portableString = _location.toPortableString();
    boolean _startsWith = _portableString.startsWith("/vobs/gsn");
    if (_startsWith) {
      IProject _project_1 = this.getProject();
      IResource _linkedContent = ProjectBuilderExtensions.getLinkedContent(_project_1);
      IPath _location_1 = _linkedContent==null?(IPath)null:_linkedContent.getLocation();
      this.setWorkingDir(_location_1);
      IPath _workingDir = this.getWorkingDir();
      String _plus = ("WD=" + _workingDir);
      this.log.debug(_plus);
    }
  }
  
  public int estimateWork(final List<String> cmds) {
    int _estimateWork = this.estimateWork(cmds, 0);
    return _estimateWork;
  }
  
  public int estimateWork(final List<String> cmds, final int extra) {
    int _xtrycatchfinallyexpression = (int) 0;
    try {
      int _xblockexpression = (int) 0;
      {
        ArrayList<String> _arrayList = new ArrayList<String>(cmds);
        final ArrayList<String> myCmds = _arrayList;
        myCmds.add(1, "-dn");
        final List<String> result = CollectionLiterals.<String>newArrayList();
        ToBuildLineParser _toBuildLineParser = new ToBuildLineParser();
        final Procedure1<String> _function = new Procedure1<String>() {
            public void apply(final String it) {
              result.add(it);
            }
          };
        final Procedure1<BuilderExecutor> _function_1 = new Procedure1<BuilderExecutor>() {
            public void apply(final BuilderExecutor it) {
              IPath _workingDir = ExternalBuilder.this.getWorkingDir();
              String _oSString = _workingDir.toOSString();
              NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
              it.executeProcess(myCmds, _oSString, _nullProgressMonitor);
            }
          };
        this.executor.<String>withHandler(_toBuildLineParser, _function, _function_1);
        final int guess = result.size();
        int _plus = (guess + extra);
        String _plus_1 = ("GUESS work::" + Integer.valueOf(_plus));
        InputOutput.<String>println(_plus_1);
        int _xifexpression = (int) 0;
        boolean _equals = (guess == 0);
        if (_equals) {
          _xifexpression = IProgressMonitor.UNKNOWN;
        } else {
          int _plus_2 = (guess + extra);
          _xifexpression = _plus_2;
        }
        _xblockexpression = (_xifexpression);
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof Throwable) {
        final Throwable e = (Throwable)_t;
        _xtrycatchfinallyexpression = IProgressMonitor.UNKNOWN;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
}
