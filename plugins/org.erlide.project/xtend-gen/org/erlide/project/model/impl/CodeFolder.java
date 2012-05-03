package org.erlide.project.model.impl;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.erlide.project.model.ICodeFolder;
import org.erlide.project.model.ICodeUnit;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.IProjectFragment;
import org.erlide.project.model.impl.ErlangModelElement;

@SuppressWarnings("all")
public class CodeFolder extends ErlangModelElement implements ICodeFolder {
  private List<ICodeUnit> sourceUnits;
  
  private IFolder folder = null;
  
  private IPath path = null;
  
  private IPath outputPath = null;
  
  private IProjectFragment fragment;
  
  public CodeFolder() {
    super();
  }
  
  public List<ICodeUnit> getCodeUnits() {
    boolean _equals = ObjectExtensions.operator_equals(this.sourceUnits, null);
    if (_equals) {
      ArrayList<ICodeUnit> _newArrayList = CollectionLiterals.<ICodeUnit>newArrayList();
      this.sourceUnits = _newArrayList;
    }
    return this.sourceUnits;
  }
  
  public IPath getPath() {
    return this.path;
  }
  
  public IFolder getFolder() {
    return this.folder;
  }
  
  public IPath setFolder(final IFolder folder) {
    IPath _xblockexpression = null;
    {
      this.folder = folder;
      IPath _projectRelativePath = folder.getProjectRelativePath();
      IPath _path = this.path = _projectRelativePath;
      _xblockexpression = (_path);
    }
    return _xblockexpression;
  }
  
  public IPath getOutputPath() {
    return this.outputPath;
  }
  
  public IPath setOutputPath(final IPath newOutputPath) {
    IPath _outputPath = this.outputPath = newOutputPath;
    return _outputPath;
  }
  
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    String _string = super.toString();
    _builder.append(_string, "");
    _builder.append(" (folder: ");
    IPath _projectRelativePath = this.folder.getProjectRelativePath();
    _builder.append(_projectRelativePath, "");
    _builder.append(", outputPath: ");
    _builder.append(this.outputPath, "");
    _builder.append(")");
    String _string_1 = _builder.toString();
    return _string_1;
  }
  
  public String getName() {
    return this.folder==null?(String)null:this.folder.getName();
  }
  
  public IErlangModelElement getParent() {
    return this.fragment;
  }
}
