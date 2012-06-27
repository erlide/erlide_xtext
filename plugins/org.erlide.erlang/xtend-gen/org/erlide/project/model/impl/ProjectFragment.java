package org.erlide.project.model.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.project.model.ICodeFolder;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.IProjectFragment;
import org.erlide.project.model.impl.ErlangModelElement;
import org.erlide.project.model.impl.ErlangModelFactory;

@SuppressWarnings("all")
public class ProjectFragment extends ErlangModelElement implements IProjectFragment {
  private IErlangProject project;
  
  private String name;
  
  protected Set<ICodeFolder> sourceFolders;
  
  protected Set<ICodeFolder> includeFolders;
  
  protected IPath docPath;
  
  protected IPath privPath;
  
  public ProjectFragment(final IErlangProject project, final String name) {
    super();
    this.project = project;
    this.name = name;
    HashSet<ICodeFolder> _newHashSet = CollectionLiterals.<ICodeFolder>newHashSet();
    this.sourceFolders = _newHashSet;
    HashSet<ICodeFolder> _newHashSet_1 = CollectionLiterals.<ICodeFolder>newHashSet();
    this.includeFolders = _newHashSet_1;
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
  
  public void addSourceFolder(final ICodeFolder folder) {
    this.sourceFolders.add(folder);
  }
  
  public boolean removeSourceFolder(final ICodeFolder folder) {
    boolean _remove = this.sourceFolders.remove(folder);
    return _remove;
  }
  
  public void addIncludeFolder(final ICodeFolder folder) {
    this.sourceFolders.add(folder);
  }
  
  public boolean removeIncludeFolder(final ICodeFolder folder) {
    boolean _remove = this.sourceFolders.remove(folder);
    return _remove;
  }
  
  public void setDocPath(final IPath path) {
    this.docPath = path;
  }
  
  public void setPrivPath(final IPath path) {
    this.privPath = path;
  }
  
  public IResource getResource() {
    return null;
  }
  
  public void realize() {
    final Procedure1<ICodeFolder> _function = new Procedure1<ICodeFolder>() {
        public void apply(final ICodeFolder it) {
          it.realize();
        }
      };
    IterableExtensions.<ICodeFolder>forEach(this.sourceFolders, _function);
    final Procedure1<ICodeFolder> _function_1 = new Procedure1<ICodeFolder>() {
        public void apply(final ICodeFolder it) {
          it.realize();
        }
      };
    IterableExtensions.<ICodeFolder>forEach(this.includeFolders, _function_1);
    ErlangModelFactory.createFolder(this.docPath);
    ErlangModelFactory.createFolder(this.privPath);
  }
}
