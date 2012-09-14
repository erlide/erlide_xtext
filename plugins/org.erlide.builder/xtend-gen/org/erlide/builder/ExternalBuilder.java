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
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.AbstractErlangBuilder;
import org.erlide.builder.BuilderExecutor;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.DefaultLineParser;
import org.erlide.builder.ErlangBuilder;
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
    final SubMonitor progress = SubMonitor.convert(monitor, 1);
    try {
      IProject _project = this.getProject();
      this.removeMarkers(_project, ErlangBuilder.MARKER_TYPE);
      List<String> _cleanCmdLine = this.getCleanCmdLine();
      final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
          public void apply(final CompilerProblem it) {
          }
        };
      this.execute(_cleanCmdLine, progress, _function);
      progress.worked(1);
    } finally {
      if (monitor!=null) monitor.done();
    }
  }
  
  public void fullBuild(final IProgressMonitor monitor) throws CoreException {
    List<String> _fullCmdLine = this.getFullCmdLine();
    final int work = this.estimateWork(_fullCmdLine, 1);
    final SubMonitor progress = SubMonitor.convert(monitor, work);
    try {
      SubMonitor _newChild = progress.newChild(1);
      this.clean(_newChild);
      List<String> _fullCmdLine_1 = this.getFullCmdLine();
      final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
          public void apply(final CompilerProblem it) {
            IProject _project = ExternalBuilder.this.getProject();
            String _fileName = it.getFileName();
            Path _path = new Path(_fileName);
            final IPath fPath = ProjectBuilderExtensions.getPathInProject(_project, _path);
            IProject _project_1 = ExternalBuilder.this.getProject();
            final IResource file = _project_1.findMember(fPath);
            boolean _matched = false;
            if (!_matched) {
              if (file instanceof IFile) {
                final IFile _iFile = (IFile)file;
                _matched=true;
                boolean _notEquals = (!Objects.equal(_iFile, null));
                if (_notEquals) {
                  ExternalBuilder.this.addMarker(_iFile, it);
                  progress.worked(1);
                }
              }
            }
          }
        };
      this.execute(_fullCmdLine_1, progress, _function);
    } finally {
      if (monitor!=null) monitor.done();
    }
  }
  
  public void incrementalBuild(final IResourceDelta delta, final IProgressMonitor monitor) throws CoreException {
    List<String> _fullCmdLine = this.getFullCmdLine();
    final int work = this.estimateWork(_fullCmdLine);
    final SubMonitor progress = SubMonitor.convert(monitor, work);
    try {
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
                SubMonitor _newChild = progress.newChild(1);
                ExternalBuilder.this.singleBuild(((IFile) _resource_1), _newChild);
              }
            }
            if (!_matched) {
              if (Objects.equal(getKind,IResourceDelta.CHANGED)) {
                _matched=true;
                IResource _resource_2 = it.getResource();
                SubMonitor _newChild_1 = progress.newChild(1);
                ExternalBuilder.this.singleBuild(((IFile) _resource_2), _newChild_1);
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
    } finally {
      if (monitor!=null) monitor.done();
    }
  }
  
  public void singleBuild(final IFile file, final IProgressMonitor monitor) {
    List<String> _singleCmdLine = this.getSingleCmdLine();
    String _name = file.getName();
    final List<String> cmd = this.fillCmdLine(_singleCmdLine, _name);
    final int work = this.estimateWork(cmd, 2);
    final SubMonitor progress = SubMonitor.convert(monitor, work);
    try {
      this.removeMarkers(file, ErlangBuilder.MARKER_TYPE);
      progress.worked(1);
      final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
          public void apply(final CompilerProblem it) {
            ExternalBuilder.this.addMarker(file, it);
            progress.worked(1);
          }
        };
      this.execute(cmd, progress, _function);
    } finally {
      if (monitor!=null) monitor.done();
    }
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
    IPath _workingDir_1 = this.getWorkingDir();
    String _oSString = _workingDir_1.toOSString();
    DefaultLineParser _defaultLineParser = new DefaultLineParser();
    this.executor.<CompilerProblem>executeProcess(cmds, _oSString, monitor, _defaultLineParser, callback);
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
        String _plus = ("EXC::" + myCmds);
        InputOutput.<String>println(_plus);
        final List<String> result = CollectionLiterals.<String>newArrayList();
        IPath _workingDir = this.getWorkingDir();
        String _oSString = _workingDir.toOSString();
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        ToBuildLineParser _toBuildLineParser = new ToBuildLineParser();
        final Procedure1<String> _function = new Procedure1<String>() {
            public void apply(final String it) {
              String _plus = ("### " + it);
              InputOutput.<String>println(_plus);
              result.add(it);
            }
          };
        this.executor.<String>executeProcess(myCmds, _oSString, _nullProgressMonitor, _toBuildLineParser, _function);
        final int guess = result.size();
        int _xifexpression = (int) 0;
        boolean _equals = (guess == 0);
        if (_equals) {
          _xifexpression = IProgressMonitor.UNKNOWN;
        } else {
          int _plus_1 = (guess + extra);
          _xifexpression = _plus_1;
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
