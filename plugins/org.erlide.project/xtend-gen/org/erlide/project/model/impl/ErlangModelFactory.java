package org.erlide.project.model.impl;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.erlide.project.model.IBinaryCodeUnit;
import org.erlide.project.model.ICodeFolder;
import org.erlide.project.model.ICodeUnit;
import org.erlide.project.model.IErlangModel;
import org.erlide.project.model.IErlangModelFactory;
import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.IExternalErlangProject;
import org.erlide.project.model.IProjectFragment;
import org.erlide.project.model.impl.BinaryCodeUnit;
import org.erlide.project.model.impl.BterlProjectFragment;
import org.erlide.project.model.impl.CodeFolder;
import org.erlide.project.model.impl.CodeUnit;
import org.erlide.project.model.impl.ErlangModel;
import org.erlide.project.model.impl.ErlangProject;
import org.erlide.project.model.impl.ErlangProjectFragment;
import org.erlide.project.model.impl.ExternalErlangProject;

@SuppressWarnings("all")
public class ErlangModelFactory implements IErlangModelFactory {
  private ErlangModel erlModel;
  
  public ErlangModelFactory() {
    IWorkspace _workspace = ResourcesPlugin.getWorkspace();
    ErlangModel _erlangModel = new ErlangModel(_workspace);
    this.erlModel = _erlangModel;
  }
  
  public IErlangModel getModel() {
    return this.erlModel;
  }
  
  public IErlangProject createErlangProject(final IProject workspaceProject) {
    ErlangProject _erlangProject = new ErlangProject(this.erlModel, workspaceProject);
    return _erlangProject;
  }
  
  public IExternalErlangProject createExternalErlangProject() {
    ExternalErlangProject _externalErlangProject = new ExternalErlangProject(this.erlModel);
    return _externalErlangProject;
  }
  
  public ICodeFolder createCodeFolder(final IProjectFragment project, final IPath path) {
    CodeFolder _codeFolder = new CodeFolder();
    return _codeFolder;
  }
  
  public IProjectFragment createErlangProjectFragment(final IErlangProject project, final String name) {
    ErlangProjectFragment _erlangProjectFragment = new ErlangProjectFragment(project, name);
    return _erlangProjectFragment;
  }
  
  public IProjectFragment createBterlProjectFragment(final IErlangProject project, final String name, final IProjectFragment parent) {
    BterlProjectFragment _bterlProjectFragment = new BterlProjectFragment(project, name, parent);
    return _bterlProjectFragment;
  }
  
  public ICodeUnit createCodeUnit(final ICodeFolder folder, final String name) {
    CodeUnit _codeUnit = new CodeUnit(folder, name);
    return _codeUnit;
  }
  
  public IBinaryCodeUnit createBinaryCodeUnit(final ICodeFolder folder, final String name) {
    BinaryCodeUnit _binaryCodeUnit = new BinaryCodeUnit(folder, name);
    return _binaryCodeUnit;
  }
}
