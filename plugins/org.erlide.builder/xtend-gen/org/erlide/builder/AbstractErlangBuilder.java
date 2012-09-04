package org.erlide.builder;

import org.eclipse.core.resources.IProject;
import org.erlide.builder.BuilderMarkerUpdater;
import org.erlide.builder.IErlangBuilder;

@SuppressWarnings("all")
public abstract class AbstractErlangBuilder implements IErlangBuilder {
  private IProject _project;
  
  public IProject getProject() {
    return this._project;
  }
  
  public void setProject(final IProject project) {
    this._project = project;
  }
  
  private BuilderMarkerUpdater _markerUpdater;
  
  public BuilderMarkerUpdater getMarkerUpdater() {
    return this._markerUpdater;
  }
  
  public void setMarkerUpdater(final BuilderMarkerUpdater markerUpdater) {
    this._markerUpdater = markerUpdater;
  }
  
  public AbstractErlangBuilder() {
  }
  
  public AbstractErlangBuilder(final IProject project, final BuilderMarkerUpdater markerUpdater) {
    this.setProject(project);
    this.setMarkerUpdater(markerUpdater);
  }
  
  public String getId() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
}
