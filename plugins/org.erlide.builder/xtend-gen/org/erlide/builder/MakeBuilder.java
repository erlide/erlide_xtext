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
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.BuilderExecutor;
import org.erlide.builder.BuilderMarkerUpdater;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.ExternalBuilder;

@SuppressWarnings("all")
public class MakeBuilder extends ExternalBuilder {
  public MakeBuilder() {
    super();
  }
  
  public MakeBuilder(final IProject project, final BuilderMarkerUpdater markerUpdater) {
    super(project, markerUpdater);
  }
  
  public MakeBuilder(final IProject project, final BuilderMarkerUpdater markerUpdater, final BuilderExecutor executor) {
    super(project, markerUpdater, executor);
  }
  
  public void clean(final IProgressMonitor monitor) throws CoreException {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("make", "clean");
    List<String> _list = IterableExtensions.<String>toList(_newArrayList);
    final List<CompilerProblem> errors = this.execute(_list, monitor);
  }
  
  public void fullBuild(final IProgressMonitor monitor) throws CoreException {
    BuilderMarkerUpdater _markerUpdater = this.getMarkerUpdater();
    IProject _project = this.getProject();
    _markerUpdater.clean(_project);
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("make", "beam");
    List<String> _list = IterableExtensions.<String>toList(_newArrayList);
    final List<CompilerProblem> errors = this.execute(_list, monitor);
    final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
        public void apply(final CompilerProblem it) {
          InputOutput.<CompilerProblem>println(it);
          IProject _project = MakeBuilder.this.getProject();
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
            BuilderMarkerUpdater _markerUpdater = MakeBuilder.this.getMarkerUpdater();
            String _message = it.getMessage();
            int _line = it.getLine();
            int _severity = it.getSeverity();
            _markerUpdater.addMarker(file, _message, _line, _severity);
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
              MakeBuilder.this.compileResource(((IFile) _resource_1), monitor);
            }
          }
          if (!_matched) {
            if (Objects.equal(getKind,IResourceDelta.CHANGED)) {
              _matched=true;
              IResource _resource_2 = it.getResource();
              MakeBuilder.this.compileResource(((IFile) _resource_2), monitor);
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
  
  public void compileResource(final IFile file, final IProgressMonitor monitor) {
    BuilderMarkerUpdater _markerUpdater = this.getMarkerUpdater();
    _markerUpdater.deleteMarkers(file);
    IPath _location = file.getLocation();
    String _oSString = _location.toOSString();
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("make", "-W", _oSString);
    List<String> _list = IterableExtensions.<String>toList(_newArrayList);
    final List<CompilerProblem> errors = this.execute(_list, monitor);
    final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
        public void apply(final CompilerProblem it) {
          InputOutput.<CompilerProblem>println(it);
          BuilderMarkerUpdater _markerUpdater = MakeBuilder.this.getMarkerUpdater();
          String _message = it.getMessage();
          int _line = it.getLine();
          int _severity = it.getSeverity();
          _markerUpdater.addMarker(file, _message, _line, _severity);
        }
      };
    IterableExtensions.<CompilerProblem>forEach(errors, _function);
  }
}
