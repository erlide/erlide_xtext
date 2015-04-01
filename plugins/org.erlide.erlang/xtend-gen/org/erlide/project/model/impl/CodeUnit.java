package org.erlide.project.model.impl;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.erlide.common.util.ErlLogger;
import org.erlide.project.model.ICodeUnit;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.impl.ErlangModelElement;

@SuppressWarnings("all")
public class CodeUnit extends ErlangModelElement implements ICodeUnit {
  private IErlangProject folder;
  
  private String name;
  
  private IFile file;
  
  public CodeUnit(final IErlangProject folder, final String name) {
    this.folder = folder;
    this.name = name;
  }
  
  @Override
  public IPath getPath() {
    return null;
  }
  
  @Override
  public String getName() {
    return this.name;
  }
  
  @Override
  public IErlangModelElement getParent() {
    return this.folder;
  }
  
  @Override
  public IResource getResource() {
    boolean _equals = Objects.equal(this.file, null);
    if (_equals) {
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot _root = _workspace.getRoot();
      IPath _path = this.getPath();
      final List<IFile> possibleFiles = (List<IFile>)Conversions.doWrapArray(_root.findFilesForLocation(_path));
      int _size = possibleFiles.size();
      boolean _equals_1 = (_size == 1);
      if (_equals_1) {
        IFile _head = IterableExtensions.<IFile>head(possibleFiles);
        this.file = _head;
      }
      ErlLogger _instance = ErlLogger.getInstance();
      IPath _path_1 = this.getPath();
      _instance.warn("not able to find file %s", _path_1);
    }
    return this.file;
  }
}
