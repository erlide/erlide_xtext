package org.erlide.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class BuilderMarkerUpdater {
  private String markerType;
  
  public BuilderMarkerUpdater(final String type) {
    this.markerType = type;
  }
  
  public void addMarker(final IFile file, final String message, final int lineNumber, final int severity) {
    int ln = lineNumber;
    try {
      final IMarker marker = file.createMarker(this.markerType);
      marker.setAttribute(IMarker.MESSAGE, message);
      marker.setAttribute(IMarker.SEVERITY, severity);
      int _minus = (-1);
      boolean _equals = (lineNumber == _minus);
      if (_equals) {
        ln = 1;
      } else {
        ln = lineNumber;
      }
      marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void deleteMarkers(final IFile file) {
    try {
      file.deleteMarkers(this.markerType, false, IResource.DEPTH_ZERO);
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException ce = (CoreException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
