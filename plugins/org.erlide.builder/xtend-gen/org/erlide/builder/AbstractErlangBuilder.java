package org.erlide.builder;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.xbase.lib.Pure;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.IErlangBuilder;
import org.erlide.builder.markers.AddErlangMarkerEvent;
import org.erlide.builder.markers.RemoveMarkersEvent;

@SuppressWarnings("all")
public abstract class AbstractErlangBuilder implements IErlangBuilder, IExecutableExtension {
  @Property
  private IProject _project;
  
  @Inject
  @Named("erlangBuilder")
  private EventBus builderEventBus;
  
  private String id;
  
  public AbstractErlangBuilder() {
  }
  
  public AbstractErlangBuilder(final IProject project, final EventBus eventBus) {
    this();
    this._project = project;
    this.builderEventBus = eventBus;
  }
  
  @Override
  public void setInitializationData(final IConfigurationElement config, final String propertyName, final Object data) throws CoreException {
    String _attribute = config.getAttribute("id");
    this.id = _attribute;
  }
  
  @Override
  public String getId() {
    return this.id;
  }
  
  @Override
  public void loadConfiguration() {
  }
  
  public void removeMarkers(final IResource resource, final String type) {
    RemoveMarkersEvent _removeMarkersEvent = new RemoveMarkersEvent(resource, type);
    this.builderEventBus.post(_removeMarkersEvent);
  }
  
  public void addMarker(final IFile file, final CompilerProblem problem) {
    AddErlangMarkerEvent _addErlangMarkerEvent = new AddErlangMarkerEvent(file, problem);
    this.builderEventBus.post(_addErlangMarkerEvent);
  }
  
  @Pure
  public IProject getProject() {
    return this._project;
  }
  
  public void setProject(final IProject project) {
    this._project = project;
  }
}
