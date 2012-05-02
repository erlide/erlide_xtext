package org.erlide.project.model.impl;

import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.erlide.project.model.ErlangModelException;
import org.erlide.project.model.ICodeFolder;
import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.impl.ProjectFragment;

@SuppressWarnings("all")
public class OtpProjectFragment extends ProjectFragment {
  /**
   * Creates an OtpPreojectFragment from the file structure found in the directory 'root'.
   * 
   * TODO maybe we want this to be done in builder? here we can have just basic setters and getters
   */
  public OtpProjectFragment(final IErlangProject project, final String name, final IPath root) {
    super(project, name);
  }
  
  protected OtpProjectFragment(final IErlangProject project, final String name) {
    super(project, name);
  }
  
  public void addSourceFolder(final ICodeFolder folder) {
    try {
      int _size = this.sourceFolders.size();
      boolean _greaterThan = IntegerExtensions.operator_greaterThan(_size, 0);
      if (_greaterThan) {
        ErlangModelException _erlangModelException = new ErlangModelException("OtpProjectFragment can only have one source folder");
        throw _erlangModelException;
      }
      this.sourceFolders.add(folder);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
