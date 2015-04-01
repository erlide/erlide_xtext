package org.erlide.builder.markers;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.erlide.builder.CompilerProblem;

@Data
@SuppressWarnings("all")
public class AddMarkerEvent {
  private final IFile file;
  
  private final String markerType;
  
  private final CompilerProblem problem;
  
  public AddMarkerEvent(final IFile file, final String markerType, final CompilerProblem problem) {
    super();
    this.file = file;
    this.markerType = markerType;
    this.problem = problem;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.file== null) ? 0 : this.file.hashCode());
    result = prime * result + ((this.markerType== null) ? 0 : this.markerType.hashCode());
    result = prime * result + ((this.problem== null) ? 0 : this.problem.hashCode());
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
    AddMarkerEvent other = (AddMarkerEvent) obj;
    if (this.file == null) {
      if (other.file != null)
        return false;
    } else if (!this.file.equals(other.file))
      return false;
    if (this.markerType == null) {
      if (other.markerType != null)
        return false;
    } else if (!this.markerType.equals(other.markerType))
      return false;
    if (this.problem == null) {
      if (other.problem != null)
        return false;
    } else if (!this.problem.equals(other.problem))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("file", this.file);
    b.add("markerType", this.markerType);
    b.add("problem", this.problem);
    return b.toString();
  }
  
  @Pure
  public IFile getFile() {
    return this.file;
  }
  
  @Pure
  public String getMarkerType() {
    return this.markerType;
  }
  
  @Pure
  public CompilerProblem getProblem() {
    return this.problem;
  }
}
