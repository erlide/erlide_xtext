package org.erlide.builder;

import com.google.common.base.Objects;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.CompilerProblemEvent;
import org.erlide.builder.ErlangBuilder;
import org.erlide.builder.MarkerOperation;
import org.erlide.common.util.ErlLogger;

@Singleton
@SuppressWarnings("all")
public class BuilderMarkerUpdater {
  @Inject
  @Named(value = "erlangBuilder")
  private EventBus builderEventBus;
  
  public BuilderMarkerUpdater() {
    this.builderEventBus.register(this);
  }
  
  public void addMarker(final IFile file, final CompilerProblem problem) {
    String _message = problem.getMessage();
    int _line = problem.getLine();
    int _severity = problem.getSeverity();
    this.addMarker(file, ErlangBuilder.MARKER_TYPE, _message, _line, _severity);
  }
  
  public void addMarker(final IFile file, final String markerType, final String message, final int lineNumber, final int severity) {
    int ln = lineNumber;
    try {
      final IMarker marker = file.createMarker(markerType);
      marker.setAttribute(IMarker.MESSAGE, message);
      marker.setAttribute(IMarker.SEVERITY, severity);
      int _max = Math.max(lineNumber, 1);
      ln = _max;
      marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
        ErlLogger _instance = ErlLogger.getInstance();
        String _plus = ("Could not add marker for " + file);
        String _plus_1 = (_plus + ": ");
        String _message = e.getMessage();
        String _plus_2 = (_plus_1 + _message);
        _instance.warn(_plus_2);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void deleteMarkers(final IFile file, final String markerType) {
    try {
      file.deleteMarkers(markerType, false, IResource.DEPTH_ZERO);
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
        ErlLogger _instance = ErlLogger.getInstance();
        String _plus = ("Could not delete markers for " + file);
        String _plus_1 = (_plus + ": ");
        String _message = e.getMessage();
        String _plus_2 = (_plus_1 + _message);
        _instance.warn(_plus_2);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void clean(final IProject project, final String markerType) {
    try {
      project.deleteMarkers(markerType, false, IResource.DEPTH_INFINITE);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Subscribe
  public void handleCompilerProblem(final CompilerProblemEvent event) {
    MarkerOperation _op = event.getOp();
    final MarkerOperation _switchValue = _op;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,MarkerOperation.ADD)) {
        _matched=true;
        InputOutput.<String>println("addMarker(event.resource as IFile, event.problem)");
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,MarkerOperation.DELETE)) {
        _matched=true;
        InputOutput.<String>println("deleteMarkers(event.resource as IFile, ErlangBuilder::MARKER_TYPE)");
      }
    }
  }
}
