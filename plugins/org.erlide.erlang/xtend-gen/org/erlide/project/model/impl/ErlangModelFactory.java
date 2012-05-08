package org.erlide.project.model.impl;

import java.io.File;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
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
import org.erlide.project.model.impl.ExternalErlangProject;
import org.erlide.project.model.impl.GenericProjectFragment;

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
    CodeFolder _codeFolder = new CodeFolder(path);
    return _codeFolder;
  }
  
  public IProjectFragment createErlangProjectFragment(final IErlangProject project, final String name) {
    GenericProjectFragment _genericProjectFragment = new GenericProjectFragment(project, name);
    return _genericProjectFragment;
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
  
  public static void createFolder(final IPath fullPath) {
    boolean _equals = ObjectExtensions.operator_equals(fullPath, null);
    if (_equals) {
      return;
    }
    try {
      String _string = fullPath.toString();
      File _file = new File(_string);
      File f = _file;
      f.mkdirs();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        String _string_1 = fullPath.toString();
        String _plus = StringExtensions.operator_plus("could not create folder ", _string_1);
        InputOutput.<String>println(_plus);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public static void createFile(final IPath fullPath) {
    boolean _equals = ObjectExtensions.operator_equals(fullPath, null);
    if (_equals) {
      return;
    }
    try {
      String _string = fullPath.toString();
      File _file = new File(_string);
      File f = _file;
      f.createNewFile();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        String _string_1 = fullPath.toString();
        String _plus = StringExtensions.operator_plus("could not create file ", _string_1);
        InputOutput.<String>println(_plus);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
