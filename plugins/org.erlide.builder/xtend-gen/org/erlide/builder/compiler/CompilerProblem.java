package org.erlide.builder.compiler;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class CompilerProblem {
  private final IFile _file;
  
  public IFile getFile() {
    return this._file;
  }
  
  private final String _message;
  
  public String getMessage() {
    return this._message;
  }
  
  private final int _line;
  
  public int getLine() {
    return this._line;
  }
  
  private final int _severity;
  
  public int getSeverity() {
    return this._severity;
  }
  
  public CompilerProblem(final IFile file, final String message, final int line, final int severity) {
    super();
    this._file = file;
    this._message = message;
    this._line = line;
    this._severity = severity;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_file== null) ? 0 : _file.hashCode());
    result = prime * result + ((_message== null) ? 0 : _message.hashCode());
    result = prime * result + _line;
    result = prime * result + _severity;
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
    CompilerProblem other = (CompilerProblem) obj;
    if (_file == null) {
      if (other._file != null)
        return false;
    } else if (!_file.equals(other._file))
      return false;
    if (_message == null) {
      if (other._message != null)
        return false;
    } else if (!_message.equals(other._message))
      return false;
    if (other._line != _line)
      return false;
    if (other._severity != _severity)
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
