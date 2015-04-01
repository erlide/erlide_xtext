package org.erlide.builder.markers;

import org.eclipse.core.resources.IResource;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class RemoveMarkersEvent {
  private final IResource resource;
  
  private final String markerType;
  
  public RemoveMarkersEvent(final IResource resource, final String markerType) {
    super();
    this.resource = resource;
    this.markerType = markerType;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.resource== null) ? 0 : this.resource.hashCode());
    result = prime * result + ((this.markerType== null) ? 0 : this.markerType.hashCode());
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
    RemoveMarkersEvent other = (RemoveMarkersEvent) obj;
    if (this.resource == null) {
      if (other.resource != null)
        return false;
    } else if (!this.resource.equals(other.resource))
      return false;
    if (this.markerType == null) {
      if (other.markerType != null)
        return false;
    } else if (!this.markerType.equals(other.markerType))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("resource", this.resource);
    b.add("markerType", this.markerType);
    return b.toString();
  }
  
  @Pure
  public IResource getResource() {
    return this.resource;
  }
  
  @Pure
  public String getMarkerType() {
    return this.markerType;
  }
}
