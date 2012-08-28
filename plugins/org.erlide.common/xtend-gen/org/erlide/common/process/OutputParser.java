package org.erlide.common.process;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure4;

@SuppressWarnings("all")
public class OutputParser {
  private IFile _file;
  
  public IFile getFile() {
    return this._file;
  }
  
  public void setFile(final IFile file) {
    this._file = file;
  }
  
  private Procedure4<? super IFile,? super String,? super Integer,? super Integer> _callback;
  
  public Procedure4<? super IFile,? super String,? super Integer,? super Integer> getCallback() {
    return this._callback;
  }
  
  public void setCallback(final Procedure4<? super IFile,? super String,? super Integer,? super Integer> callback) {
    this._callback = callback;
  }
  
  public OutputParser(final IFile file, final Procedure4<? super IFile,? super String,? super Integer,? super Integer> callback) {
    this.setFile(file);
    this.setCallback(callback);
  }
  
  public void parseLine(final String line) {
  }
}
