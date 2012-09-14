package org.erlide.builder;

import org.eclipse.core.resources.IResource;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class RemoveMarkersEvent {
  private final IResource _resource;
  
  public IResource getResource() {
    return this._resource;
  }
  
  private final String _markerType;
  
  public String getMarkerType() {
    return this._markerType;
  }
  
  public RemoveMarkersEvent(final IResource resource, final String markerType) {
    super();
    this._resource = resource;
    this._markerType = markerType;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_resource== null) ? 0 : _resource.hashCode());
    result = prime * result + ((_markerType== null) ? 0 : _markerType.hashCode());
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
    RemoveMarkersEvent other = (RemoveMarkersEvent) obj;
    if (_resource == null) {
      if (other._resource != null)
        return false;
    } else if (!_resource.equals(other._resource))
      return false;
    if (_markerType == null) {
      if (other._markerType != null)
        return false;
    } else if (!_markerType.equals(other._markerType))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
