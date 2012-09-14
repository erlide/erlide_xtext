package org.erlide.builder.markers;

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
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.markers.AddMarkerEvent;
import org.erlide.builder.markers.RemoveMarkersEvent;
import org.erlide.common.util.ErlLogger;

@Singleton
@SuppressWarnings("all")
public class BuilderMarkerUpdater {
  private EventBus builderEventBus;
  
  @Inject
  private ErlLogger log;
  
  @Inject
  public BuilderMarkerUpdater(@Named(value = "erlangBuilder") final EventBus builderEventBus) {
    this.builderEventBus = builderEventBus;
    builderEventBus.register(this);
  }
  
  public void addMarker(final IFile file, final String markerType, final CompilerProblem problem) {
    int ln = problem.getLine();
    try {
      final IMarker marker = file.createMarker(markerType);
      String _message = problem.getMessage();
      marker.setAttribute(IMarker.MESSAGE, _message);
      int _severity = problem.getSeverity();
      marker.setAttribute(IMarker.SEVERITY, _severity);
      int _line = problem.getLine();
      int _max = Math.max(_line, 1);
      ln = _max;
      marker.setAttribute(IMarker.LINE_NUMBER, ln);
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
        String _plus = ("Could not add marker for " + file);
        String _plus_1 = (_plus + ": ");
        String _message_1 = e.getMessage();
        String _plus_2 = (_plus_1 + _message_1);
        this.log.warn(_plus_2);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void deleteMarkers(final IResource resource, final String markerType) {
    try {
      resource.deleteMarkers(markerType, false, IResource.DEPTH_INFINITE);
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
        String _plus = ("Could not delete markers for " + resource);
        String _plus_1 = (_plus + ": ");
        String _message = e.getMessage();
        String _plus_2 = (_plus_1 + _message);
        this.log.warn(_plus_2);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Subscribe
  public void handleRemoveMarkers(final RemoveMarkersEvent event) {
    IResource _resource = event.getResource();
    String _markerType = event.getMarkerType();
    this.deleteMarkers(_resource, _markerType);
  }
  
  @Subscribe
  public void handleAddMarker(final AddMarkerEvent event) {
    IFile _file = event.getFile();
    String _markerType = event.getMarkerType();
    CompilerProblem _problem = event.getProblem();
    this.addMarker(_file, _markerType, _problem);
  }
}
