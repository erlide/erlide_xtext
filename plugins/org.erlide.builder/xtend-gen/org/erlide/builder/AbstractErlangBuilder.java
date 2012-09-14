package org.erlide.builder;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.erlide.builder.BuilderPlugin;
import org.erlide.builder.IErlangBuilder;

@SuppressWarnings("all")
public abstract class AbstractErlangBuilder implements IErlangBuilder, IExecutableExtension {
  private IProject _project;
  
  public IProject getProject() {
    return this._project;
  }
  
  public void setProject(final IProject project) {
    this._project = project;
  }
  
  @Inject
  @Named(value = "erlangBuilder")
  protected EventBus builderEventBus;
  
  private String id;
  
  public AbstractErlangBuilder() {
    BuilderPlugin _instance = BuilderPlugin.getInstance();
    Injector _injector = _instance.getInjector();
    _injector.injectMembers(this);
  }
  
  public AbstractErlangBuilder(final IProject project, final EventBus eventBus) {
    this();
    this._project = project;
    this.builderEventBus = eventBus;
  }
  
  public void setInitializationData(final IConfigurationElement config, final String propertyName, final Object data) throws CoreException {
    String _attribute = config.getAttribute("id");
    this.id = _attribute;
  }
  
  public String getId() {
    return this.id;
  }
  
  public void loadConfiguration() {
  }
}
