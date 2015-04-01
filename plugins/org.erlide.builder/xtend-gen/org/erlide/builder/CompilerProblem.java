package org.erlide.builder;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class CompilerProblem {
  private final String fileName;
  
  private final String message;
  
  private final int line;
  
  private final int severity;
  
  public CompilerProblem(final String fileName, final String message, final int line, final int severity) {
    super();
    this.fileName = fileName;
    this.message = message;
    this.line = line;
    this.severity = severity;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.fileName== null) ? 0 : this.fileName.hashCode());
    result = prime * result + ((this.message== null) ? 0 : this.message.hashCode());
    result = prime * result + this.line;
    result = prime * result + this.severity;
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CompilerProblem other = (CompilerProblem) obj;
    if (this.fileName == null) {
      if (other.fileName != null)
        return false;
    } else if (!this.fileName.equals(other.fileName))
      return false;
    if (this.message == null) {
      if (other.message != null)
        return false;
    } else if (!this.message.equals(other.message))
      return false;
    if (other.line != this.line)
      return false;
    if (other.severity != this.severity)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("fileName", this.fileName);
    b.add("message", this.message);
    b.add("line", this.line);
    b.add("severity", this.severity);
    return b.toString();
  }
  
  @Pure
  public String getFileName() {
    return this.fileName;
  }
  
  @Pure
  public String getMessage() {
    return this.message;
  }
  
  @Pure
  public int getLine() {
    return this.line;
  }
  
  @Pure
  public int getSeverity() {
    return this.severity;
  }
}
