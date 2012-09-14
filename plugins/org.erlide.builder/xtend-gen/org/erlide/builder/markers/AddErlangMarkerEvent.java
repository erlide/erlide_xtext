package org.erlide.builder.markers;

import org.eclipse.core.resources.IFile;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.ErlangBuilder;
import org.erlide.builder.markers.AddMarkerEvent;

@SuppressWarnings("all")
public class AddErlangMarkerEvent extends AddMarkerEvent {
  public AddErlangMarkerEvent(final IFile file, final CompilerProblem problem) {
    super(file, ErlangBuilder.MARKER_TYPE, problem);
  }
}
