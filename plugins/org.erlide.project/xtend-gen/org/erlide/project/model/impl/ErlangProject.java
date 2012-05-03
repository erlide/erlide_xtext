package org.erlide.project.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.project.model.IErlangModel;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.IProjectFragment;
import org.erlide.project.model.impl.ErlangModelElement;

@SuppressWarnings("all")
public class ErlangProject extends ErlangModelElement implements IErlangProject {
  private IErlangModel model;
  
  private List<IErlangProject> referencedProjects;
  
  private List<IProjectFragment> sourceFragments;
  
  private List<IProjectFragment> binaryFragments;
  
  private IProject workspaceProject;
  
  public ErlangProject(final IErlangModel model, final IProject workspaceProject) {
    super();
    this.model = model;
    ArrayList<IErlangProject> _newArrayList = CollectionLiterals.<IErlangProject>newArrayList();
    this.referencedProjects = _newArrayList;
    ArrayList<IProjectFragment> _newArrayList_1 = CollectionLiterals.<IProjectFragment>newArrayList();
    this.sourceFragments = _newArrayList_1;
    ArrayList<IProjectFragment> _newArrayList_2 = CollectionLiterals.<IProjectFragment>newArrayList();
    this.binaryFragments = _newArrayList_2;
    this.workspaceProject = workspaceProject;
  }
  
  public List<IErlangProject> getReferencedProjects() {
    return this.referencedProjects;
  }
  
  public Collection<IProjectFragment> getSourceFragments() {
    return Collections.<IProjectFragment>unmodifiableCollection(this.sourceFragments);
  }
  
  public Collection<IProjectFragment> getBinaryFragments() {
    return Collections.<IProjectFragment>unmodifiableCollection(this.binaryFragments);
  }
  
  public IProject getWorkspaceProject() {
    return this.workspaceProject;
  }
  
  public String toString() {
    String _string = super.toString();
    StringBuffer _stringBuffer = new StringBuffer(_string);
    final StringBuffer result = _stringBuffer;
    result.append(" (workspaceProject: ");
    result.append(this.workspaceProject);
    result.append(")");
    return result.toString();
  }
  
  public String getName() {
    return this.workspaceProject.getName();
  }
  
  public IErlangModelElement getParent() {
    return this.model;
  }
  
  public IResource getResource() {
    return this.workspaceProject;
  }
  
  public void realize() {
    final Procedure1<IProjectFragment> _function = new Procedure1<IProjectFragment>() {
        public void apply(final IProjectFragment it) {
          it.realize();
        }
      };
    IterableExtensions.<IProjectFragment>forEach(this.sourceFragments, _function);
  }
}
