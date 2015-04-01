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
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
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
  
  @Property
  private IPath _workingDir;
  
  @Property
  private List<String> _cleanCmdLine;
  
  @Property
  private List<String> _fullCmdLine;
  
  @Property
  private List<String> _singleCmdLine;
  
  private final List<String> NONE = CollectionLiterals.<String>newArrayList();
  
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
  
  @Override
  public void clean(final IProgressMonitor monitor) {
    final SubMonitor progress = SubMonitor.convert(monitor, 100);
    IProject _project = this.getProject();
    this.removeMarkers(_project, ErlangBuilder.MARKER_TYPE);
    List<String> _cleanCmdLine = this.getCleanCmdLine();
    final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
      @Override
      public void apply(final CompilerProblem it) {
      }
    };
    this.execute(_cleanCmdLine, progress, _function);
    progress.worked(100);
  }
  
  @Override
  public void fullBuild(final IProgressMonitor monitor) throws CoreException {
    SubMonitor progress = SubMonitor.convert(monitor, 1);
    List<String> _fullCmdLine = this.getFullCmdLine();
    final int work = this.estimateWork(_fullCmdLine);
    SubMonitor _newChild = progress.newChild(1);
    SubMonitor _convert = SubMonitor.convert(_newChild, work);
    progress = _convert;
    List<String> _fullCmdLine_1 = this.getFullCmdLine();
    final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
      @Override
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
            _matched=true;
            ExternalBuilder.this.addMarker(((IFile)file), it);
          }
        }
      }
    };
    this.execute(_fullCmdLine_1, progress, _function);
  }
  
  @Override
  public void incrementalBuild(final IResourceDelta delta, final IProgressMonitor monitor) throws CoreException {
    List<String> _fullCmdLine = this.getFullCmdLine();
    final int work = this.estimateWork(_fullCmdLine);
    final SubMonitor progress = SubMonitor.convert(monitor, work);
    final IResourceDeltaVisitor _function = new IResourceDeltaVisitor() {
      @Override
      public boolean visit(final IResourceDelta it) throws CoreException {
        IResource _resource = it.getResource();
        if ((!(_resource instanceof IFile))) {
          return true;
        }
        boolean _isCanceled = progress.isCanceled();
        if (_isCanceled) {
          throw new OperationCanceledException();
        }
        int _kind = it.getKind();
        switch (_kind) {
          case IResourceDelta.ADDED:
            IResource _resource_1 = it.getResource();
            ExternalBuilder.this.singleBuild(((IFile) _resource_1), progress);
            break;
          case IResourceDelta.CHANGED:
            IResource _resource_2 = it.getResource();
            ExternalBuilder.this.singleBuild(((IFile) _resource_2), progress);
            break;
        }
        return true;
      }
    };
    delta.accept(_function);
  }
  
  public void singleBuild(final IFile file, final IProgressMonitor monitor) {
    List<String> _singleCmdLine = this.getSingleCmdLine();
    String _name = file.getName();
    final List<String> cmd = this.fillCmdLine(_singleCmdLine, _name);
    final int work = this.estimateWork(cmd, 1);
    final SubMonitor progress = SubMonitor.convert(monitor, work);
    this.removeMarkers(file, ErlangBuilder.MARKER_TYPE);
    final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
      @Override
      public void apply(final CompilerProblem it) {
        ExternalBuilder.this.addMarker(file, it);
      }
    };
    this.execute(cmd, progress, _function);
  }
  
  private List<String> fillCmdLine(final List<String> cmds, final String file) {
    final Function1<String, String> _function = new Function1<String, String>() {
      @Override
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
    return ListExtensions.<String, String>map(cmds, _function);
  }
  
  private void execute(final List<String> cmds, final IProgressMonitor monitor, final Procedure1<? super CompilerProblem> callback) {
    IPath _workingDir = this.getWorkingDir();
    String _plus = ((("EXEC \'" + cmds) + "\' in ") + _workingDir);
    this.log.debug(_plus);
    ProgressLineParser _progressLineParser = new ProgressLineParser();
    final Procedure1<String> _function = new Procedure1<String>() {
      @Override
      public void apply(final String it) {
        monitor.worked(1);
      }
    };
    final Procedure1<BuilderExecutor> _function_1 = new Procedure1<BuilderExecutor>() {
      @Override
      public void apply(final BuilderExecutor it) {
        DefaultLineParser _defaultLineParser = new DefaultLineParser();
        final Procedure1<BuilderExecutor> _function = new Procedure1<BuilderExecutor>() {
          @Override
          public void apply(final BuilderExecutor it) {
            IPath _workingDir = ExternalBuilder.this.getWorkingDir();
            String _oSString = null;
            if (_workingDir!=null) {
              _oSString=_workingDir.toOSString();
            }
            it.executeProcess(cmds, _oSString, monitor);
          }
        };
        it.<CompilerProblem>withHandler(_defaultLineParser, callback, _function);
      }
    };
    this.executor.<String>withHandler(_progressLineParser, _function, _function_1);
  }
  
  @Override
  public void loadConfiguration() {
    IProject _project = this.getProject();
    IPath _location = _project.getLocation();
    String _portableString = _location.toPortableString();
    boolean _startsWith = _portableString.startsWith("/vobs/gsn");
    if (_startsWith) {
      IProject _project_1 = this.getProject();
      IResource _linkedContent = ProjectBuilderExtensions.getLinkedContent(_project_1);
      IPath _location_1 = null;
      if (_linkedContent!=null) {
        _location_1=_linkedContent.getLocation();
      }
      this.setWorkingDir(_location_1);
      IPath _workingDir = this.getWorkingDir();
      String _plus = ("WD=" + _workingDir);
      this.log.debug(_plus);
    }
  }
  
  public int estimateWork(final List<String> cmds) {
    return this.estimateWork(cmds, 0);
  }
  
  public int estimateWork(final List<String> cmds, final int extra) {
    int _xtrycatchfinallyexpression = (int) 0;
    try {
      int _xblockexpression = (int) 0;
      {
        final ArrayList<String> myCmds = new ArrayList<String>(cmds);
        myCmds.add(1, "-dn");
        final List<String> result = CollectionLiterals.<String>newArrayList();
        ToBuildLineParser _toBuildLineParser = new ToBuildLineParser();
        final Procedure1<String> _function = new Procedure1<String>() {
          @Override
          public void apply(final String it) {
            result.add(it);
          }
        };
        final Procedure1<BuilderExecutor> _function_1 = new Procedure1<BuilderExecutor>() {
          @Override
          public void apply(final BuilderExecutor it) {
            IPath _workingDir = ExternalBuilder.this.getWorkingDir();
            String _oSString = _workingDir.toOSString();
            NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
            it.executeProcess(myCmds, _oSString, _nullProgressMonitor);
          }
        };
        this.executor.<String>withHandler(_toBuildLineParser, _function, _function_1);
        final int guess = result.size();
        InputOutput.<String>println(("GUESS work::" + Integer.valueOf((guess + extra))));
        int _xifexpression = (int) 0;
        if ((guess == 0)) {
          _xifexpression = IProgressMonitor.UNKNOWN;
        } else {
          _xifexpression = (guess + extra);
        }
        _xblockexpression = _xifexpression;
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
  
  @Pure
  public IPath getWorkingDir() {
    return this._workingDir;
  }
  
  public void setWorkingDir(final IPath workingDir) {
    this._workingDir = workingDir;
  }
  
  @Pure
  public List<String> getCleanCmdLine() {
    return this._cleanCmdLine;
  }
  
  public void setCleanCmdLine(final List<String> cleanCmdLine) {
    this._cleanCmdLine = cleanCmdLine;
  }
  
  @Pure
  public List<String> getFullCmdLine() {
    return this._fullCmdLine;
  }
  
  public void setFullCmdLine(final List<String> fullCmdLine) {
    this._fullCmdLine = fullCmdLine;
  }
  
  @Pure
  public List<String> getSingleCmdLine() {
    return this._singleCmdLine;
  }
  
  public void setSingleCmdLine(final List<String> singleCmdLine) {
    this._singleCmdLine = singleCmdLine;
  }
}
