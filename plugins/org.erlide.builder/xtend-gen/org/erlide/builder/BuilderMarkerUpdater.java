package org.erlide.builder;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import javax.inject.Singleton;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.erlide.builder.AddMarkerEvent;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.ErlangBuilder;
import org.erlide.builder.RemoveMarkersEvent;
import org.erlide.common.util.ErlLogger;

@Singleton
@SuppressWarnings("all")
public class BuilderMarkerUpdater {
  private EventBus builderEventBus;
  
  @Inject
  public BuilderMarkerUpdater(@Named(value = "erlangBuilder") final EventBus builderEventBus) {
    this.builderEventBus = builderEventBus;
    builderEventBus.register(this);
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
  
  public void deleteMarkers(final IResource resource, final String markerType) {
    try {
      resource.deleteMarkers(markerType, false, IResource.DEPTH_ZERO);
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
        ErlLogger _instance = ErlLogger.getInstance();
        String _plus = ("Could not delete markers for " + resource);
        String _plus_1 = (_plus + ": ");
        String _message = e.getMessage();
        String _plus_2 = (_plus_1 + _message);
        _instance.warn(_plus_2);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Subscribe
  public void handleRemoveMarkers(final RemoveMarkersEvent event) {
    ErlLogger _instance = ErlLogger.getInstance();
    String _plus = ("" + event);
    _instance.debug(_plus);
    IResource _resource = event.getResource();
    String _markerType = event.getMarkerType();
    this.deleteMarkers(_resource, _markerType);
  }
  
  @Subscribe
  public void handleAddMarker(final AddMarkerEvent event) {
    ErlLogger _instance = ErlLogger.getInstance();
    String _plus = ("" + event);
    _instance.debug(_plus);
    IFile _file = event.getFile();
    CompilerProblem _problem = event.getProblem();
    this.addMarker(_file, _problem);
  }
}
