package org.erlide.project.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.erlide.project.model.IErlangModel;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.impl.ErlangModelElement;

@SuppressWarnings("all")
public class ErlangModel extends ErlangModelElement implements IErlangModel {
  private IWorkspace workspace;
  
  private List<IErlangProject> projects;
  
  public ErlangModel(final IWorkspace workspace) {
    super();
    this.workspace = workspace;
    ArrayList<IErlangProject> _newArrayList = CollectionLiterals.<IErlangProject>newArrayList();
    this.projects = _newArrayList;
  }
  
  public Collection<IErlangProject> getProjects() {
    return Collections.<IErlangProject>unmodifiableCollection(this.projects);
  }
  
  public IErlangProject getErlangProject(final IProject project) {
    for (final IErlangProject prj : this.projects) {
      IProject _workspaceProject = prj.getWorkspaceProject();
      boolean _equals = ObjectExtensions.operator_equals(_workspaceProject, project);
      if (_equals) {
        return prj;
      }
    }
    return null;
  }
  
  public IWorkspace getWorkspace() {
    return this.workspace;
  }
  
  public String getName() {
    return "Erlang model";
  }
  
  public IErlangModelElement getParent() {
    return null;
  }
}
