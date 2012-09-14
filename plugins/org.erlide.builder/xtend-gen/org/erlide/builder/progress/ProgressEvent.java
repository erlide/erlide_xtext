package org.erlide.builder.progress;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class ProgressEvent {
  private final IFile _file;
  
  public IFile getFile() {
    return this._file;
  }
  
  public ProgressEvent(final IFile file) {
    super();
    this._file = file;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_file== null) ? 0 : _file.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ProgressEvent other = (ProgressEvent) obj;
    if (_file == null) {
      if (other._file != null)
        return false;
    } else if (!_file.equals(other._file))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
