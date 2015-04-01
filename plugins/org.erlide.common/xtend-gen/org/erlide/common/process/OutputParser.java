package org.erlide.common.process;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure4;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class OutputParser {
  @Property
  private IFile _file;
  
  @Property
  private Procedure4<? super IFile, ? super String, ? super Integer, ? super Integer> _callback;
  
  public OutputParser(final IFile file, final Procedure4<? super IFile, ? super String, ? super Integer, ? super Integer> callback) {
    this.setFile(file);
    this.setCallback(callback);
  }
  
  public void parseLine(final String line) {
  }
  
  @Pure
  public IFile getFile() {
    return this._file;
  }
  
  public void setFile(final IFile file) {
    this._file = file;
  }
  
  @Pure
  public Procedure4<? super IFile, ? super String, ? super Integer, ? super Integer> getCallback() {
    return this._callback;
  }
  
  public void setCallback(final Procedure4<? super IFile, ? super String, ? super Integer, ? super Integer> callback) {
    this._callback = callback;
  }
}
