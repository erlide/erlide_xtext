package org.erlide.project.model.impl;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.erlide.common.NatureConstants;
import org.erlide.project.ErlangCore;
import org.erlide.project.model.IErlangModel;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.IErlangModelFactory;
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
  
  @Override
  public Collection<IErlangProject> getProjects() {
    return Collections.<IErlangProject>unmodifiableCollection(this.projects);
  }
  
  @Nullable
  @Override
  public IErlangProject getErlangProject(final IProject project) {
    boolean _exists = project.exists();
    boolean _not = (!_exists);
    if (_not) {
      return null;
    }
    for (final IErlangProject prj : this.projects) {
      IProject _workspaceProject = prj.getWorkspaceProject();
      boolean _equals = Objects.equal(_workspaceProject, project);
      if (_equals) {
        return prj;
      }
    }
    boolean _isErlangProject = this.isErlangProject(project);
    boolean _not_1 = (!_isErlangProject);
    if (_not_1) {
      return null;
    }
    IErlangModelFactory _modelFactory = ErlangCore.getModelFactory();
    final IErlangProject erlPrj = _modelFactory.createErlangProject(project);
    this.projects.add(erlPrj);
    return erlPrj;
  }
  
  @Override
  public IWorkspace getWorkspace() {
    return this.workspace;
  }
  
  @Override
  public String getName() {
    return "Erlang model";
  }
  
  @Override
  public IErlangModelElement getParent() {
    return null;
  }
  
  @Override
  public IResource getResource() {
    return this.workspace.getRoot();
  }
  
  public boolean isErlangProject(final IProject project) {
    try {
      boolean _or = false;
      boolean _hasNature = project.hasNature(NatureConstants.NATURE_ID);
      if (_hasNature) {
        _or = true;
      } else {
        boolean _hasNature_1 = project.hasNature(NatureConstants.OLD_NATURE_ID);
        _or = _hasNature_1;
      }
      return _or;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
