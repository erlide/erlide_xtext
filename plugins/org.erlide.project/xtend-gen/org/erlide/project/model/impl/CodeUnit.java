package org.erlide.project.model.impl;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;
import org.erlide.project.model.ICodeFolder;
import org.erlide.project.model.ICodeUnit;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.impl.ErlangModelElement;

@SuppressWarnings("all")
public class CodeUnit extends ErlangModelElement implements ICodeUnit {
  private ICodeFolder folder;
  
  private String name;
  
  public CodeUnit(final ICodeFolder folder, final String name) {
    this.folder = folder;
    this.name = name;
  }
  
  public IPath getPath() {
    IFolder _folder = this.folder.getFolder();
    IPath _projectRelativePath = _folder.getProjectRelativePath();
    return _projectRelativePath.append(this.name);
  }
  
  public String getName() {
    return this.name;
  }
  
  public IErlangModelElement getParent() {
    return this.folder;
  }
}
