package org.erlide.project.model.impl;

import com.google.common.base.Objects;
import java.io.File;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.project.model.IBinaryCodeUnit;
import org.erlide.project.model.ICodeUnit;
import org.erlide.project.model.IErlangModel;
import org.erlide.project.model.IErlangModelFactory;
import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.impl.BinaryCodeUnit;
import org.erlide.project.model.impl.CodeUnit;
import org.erlide.project.model.impl.ErlangModel;
import org.erlide.project.model.impl.ErlangProject;

@SuppressWarnings("all")
public class ErlangModelFactory implements IErlangModelFactory {
  private ErlangModel erlModel;
  
  public ErlangModelFactory() {
    IWorkspace _workspace = ResourcesPlugin.getWorkspace();
    ErlangModel _erlangModel = new ErlangModel(_workspace);
    this.erlModel = _erlangModel;
    this.populateProjects();
  }
  
  public IErlangModel getModel() {
    return this.erlModel;
  }
  
  public IErlangProject createErlangProject(final IProject workspaceProject) {
    ErlangProject _erlangProject = new ErlangProject(this.erlModel, workspaceProject);
    return _erlangProject;
  }
  
  public ICodeUnit createCodeUnit(final IErlangProject folder, final String name) {
    CodeUnit _codeUnit = new CodeUnit(folder, name);
    return _codeUnit;
  }
  
  public IBinaryCodeUnit createBinaryCodeUnit(final IErlangProject folder, final String name) {
    BinaryCodeUnit _binaryCodeUnit = new BinaryCodeUnit(folder, name);
    return _binaryCodeUnit;
  }
  
  public static void createFolder(final IPath fullPath) {
    boolean _equals = Objects.equal(fullPath, null);
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
        String _plus = ("could not create folder " + _string_1);
        InputOutput.<String>println(_plus);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public static void createFile(final IPath fullPath) {
    boolean _equals = Objects.equal(fullPath, null);
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
        String _plus = ("could not create file " + _string_1);
        InputOutput.<String>println(_plus);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  private void populateProjects() {
    IErlangModel _model = this.getModel();
    IWorkspace _workspace = _model.getWorkspace();
    IWorkspaceRoot _root = _workspace.getRoot();
    IProject[] _projects = _root.getProjects();
    final Procedure1<IProject> _function = new Procedure1<IProject>() {
        public void apply(final IProject it) {
          ErlangModelFactory.this.createErlangProject(it);
        }
      };
    IterableExtensions.<IProject>forEach(((Iterable<IProject>)Conversions.doWrapArray(_projects)), _function);
  }
}
