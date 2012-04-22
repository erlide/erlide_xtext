package org.erlide.project.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.erlide.project.model.ICodeFolder;
import org.erlide.project.model.IErlangModel;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.IProjectFragment;
import org.erlide.project.model.impl.ErlangModelElement;

@SuppressWarnings("all")
public class ProjectFragment extends ErlangModelElement implements IProjectFragment {
  private IErlangProject project;
  
  private IErlangModel model;
  
  private List<ICodeFolder> sourceFolders;
  
  private List<ICodeFolder> includeFolders;
  
  private IPath docFolder;
  
  private IPath privDir;
  
  private String name;
  
  public ProjectFragment(final IErlangProject project, final String name) {
    super();
    this.project = project;
    this.name = name;
    ArrayList<ICodeFolder> _newArrayList = CollectionLiterals.<ICodeFolder>newArrayList();
    this.sourceFolders = _newArrayList;
    ArrayList<ICodeFolder> _newArrayList_1 = CollectionLiterals.<ICodeFolder>newArrayList();
    this.includeFolders = _newArrayList_1;
  }
  
  public Collection<ICodeFolder> getSourceFolders() {
    return Collections.<ICodeFolder>unmodifiableCollection(this.sourceFolders);
  }
  
  public Collection<ICodeFolder> getIncludeFolders() {
    return Collections.<ICodeFolder>unmodifiableCollection(this.includeFolders);
  }
  
  public String getName() {
    return this.name;
  }
  
  public IErlangModelElement getParent() {
    return this.project;
  }
}
