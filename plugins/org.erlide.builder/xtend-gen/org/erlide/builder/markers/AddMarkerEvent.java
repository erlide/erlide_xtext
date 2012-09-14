package org.erlide.builder.markers;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.erlide.builder.CompilerProblem;

@Data
@SuppressWarnings("all")
public class AddMarkerEvent {
  private final IFile _file;
  
  public IFile getFile() {
    return this._file;
  }
  
  private final String _markerType;
  
  public String getMarkerType() {
    return this._markerType;
  }
  
  private final CompilerProblem _problem;
  
  public CompilerProblem getProblem() {
    return this._problem;
  }
  
  public AddMarkerEvent(final IFile file, final String markerType, final CompilerProblem problem) {
    super();
    this._file = file;
    this._markerType = markerType;
    this._problem = problem;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_file== null) ? 0 : _file.hashCode());
    result = prime * result + ((_markerType== null) ? 0 : _markerType.hashCode());
    result = prime * result + ((_problem== null) ? 0 : _problem.hashCode());
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
    AddMarkerEvent other = (AddMarkerEvent) obj;
    if (_file == null) {
      if (other._file != null)
        return false;
    } else if (!_file.equals(other._file))
      return false;
    if (_markerType == null) {
      if (other._markerType != null)
        return false;
    } else if (!_markerType.equals(other._markerType))
      return false;
    if (_problem == null) {
      if (other._problem != null)
        return false;
    } else if (!_problem.equals(other._problem))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
