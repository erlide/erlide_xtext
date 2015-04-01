package org.erlide.project.model.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.erlide.project.model.ICodeUnit;
import org.erlide.project.model.IErlangModel;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.IErlangProject;

@SuppressWarnings("all")
public class ModelResourceListener implements IResourceChangeListener {
  private IErlangModel model;
  
  public ModelResourceListener(final IErlangModel model) {
    this.model = model;
    IWorkspace _workspace = ResourcesPlugin.getWorkspace();
    _workspace.addResourceChangeListener(this);
  }
  
  public void dispose() {
    IWorkspace _workspace = ResourcesPlugin.getWorkspace();
    _workspace.removeResourceChangeListener(this);
  }
  
  @Override
  public void resourceChanged(final IResourceChangeEvent event) {
    this.updateModel(this.model, event);
  }
  
  protected void _updateModel(final IErlangModel model, final IResourceChangeEvent event) {
    Collection<IErlangProject> _projects = model.getProjects();
    final Consumer<IErlangProject> _function = new Consumer<IErlangProject>() {
      @Override
      public void accept(final IErlangProject it) {
        ModelResourceListener.this.updateModel(it, event);
      }
    };
    _projects.forEach(_function);
  }
  
  protected void _updateModel(final IErlangProject project, final IResourceChangeEvent event) {
  }
  
  protected void _updateModel(final ICodeUnit unit, final IResourceChangeEvent event) {
  }
  
  public void updateModel(final IErlangModelElement unit, final IResourceChangeEvent event) {
    if (unit instanceof ICodeUnit) {
      _updateModel((ICodeUnit)unit, event);
      return;
    } else if (unit instanceof IErlangModel) {
      _updateModel((IErlangModel)unit, event);
      return;
    } else if (unit instanceof IErlangProject) {
      _updateModel((IErlangProject)unit, event);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(unit, event).toString());
    }
  }
}
