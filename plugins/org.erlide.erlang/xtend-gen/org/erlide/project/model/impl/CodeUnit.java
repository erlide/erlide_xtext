package org.erlide.project.model.impl;

import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.erlide.common.util.ErlLogger;
import org.erlide.project.model.ICodeFolder;
import org.erlide.project.model.ICodeUnit;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.impl.ErlangModelElement;
import org.erlide.project.model.impl.ErlangModelFactory;

@SuppressWarnings("all")
public class CodeUnit extends ErlangModelElement implements ICodeUnit {
  private ICodeFolder folder;
  
  private String name;
  
  private IFile file;
  
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
  
  public IResource getResource() {
    boolean _equals = ObjectExtensions.operator_equals(this.file, null);
    if (_equals) {
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot _root = _workspace.getRoot();
      IPath _path = this.getPath();
      final List<IFile> possibleFiles = ((List<IFile>)Conversions.doWrapArray(_root.findFilesForLocation(_path)));
      int _size = possibleFiles.size();
      boolean _equals_1 = IntegerExtensions.operator_equals(_size, 1);
      if (_equals_1) {
        IFile _head = IterableExtensions.<IFile>head(possibleFiles);
        this.file = _head;
      }
      IPath _path_1 = this.getPath();
      ErlLogger.warn("not able to find file %s", _path_1);
    }
    return this.file;
  }
  
  public void realize() {
    IPath _path = this.getPath();
    ErlangModelFactory.createFile(_path);
  }
}
