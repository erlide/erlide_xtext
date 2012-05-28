package org.erlide.project.model.impl;

import java.util.HashSet;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.erlide.project.model.ErlangModelException;
import org.erlide.project.model.ICodeFolder;
import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.impl.CodeFolder;
import org.erlide.project.model.impl.ProjectFragment;

@SuppressWarnings("all")
public class OtpProjectFragment extends ProjectFragment {
  /**
   * Creates an OtpProjectFragment from the file structure found in the directory 'root'.
   * 
   * TODO maybe we want this to be done in builder? here we can have just basic setters and getters
   */
  public OtpProjectFragment(final IErlangProject project, final String name, final IPath root) {
    this(project, name);
    Path _path = new Path("src");
    CodeFolder _codeFolder = new CodeFolder(_path);
    HashSet<ICodeFolder> _newHashSet = CollectionLiterals.<ICodeFolder>newHashSet(_codeFolder);
    this.sourceFolders = _newHashSet;
    Path _path_1 = new Path("include");
    CodeFolder _codeFolder_1 = new CodeFolder(_path_1);
    HashSet<ICodeFolder> _newHashSet_1 = CollectionLiterals.<ICodeFolder>newHashSet(_codeFolder_1);
    this.sourceFolders = _newHashSet_1;
    Path _path_2 = new Path("doc");
    this.docPath = _path_2;
    Path _path_3 = new Path("priv");
    this.privPath = _path_3;
  }
  
  public OtpProjectFragment(final IErlangProject project, final String name) {
    super(project, name);
  }
  
  public void addSourceFolder(final ICodeFolder folder) {
    try {
      int _size = this.sourceFolders.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        ErlangModelException _erlangModelException = new ErlangModelException("OtpProjectFragment can only have one source folder");
        throw _erlangModelException;
      }
      this.sourceFolders.add(folder);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void realize() {
  }
}
