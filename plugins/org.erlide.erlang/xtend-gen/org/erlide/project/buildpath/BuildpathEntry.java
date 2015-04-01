package org.erlide.project.buildpath;

import org.eclipse.core.resources.IResource;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.xbase.lib.Pure;
import org.erlide.project.buildpath.BuildpathAttributes;

@SuppressWarnings("all")
public abstract class BuildpathEntry {
  @Property
  private BuildpathEntry _parent;
  
  @Property
  private BuildpathAttributes _attributes;
  
  public BuildpathEntry(final BuildpathEntry aParent, final BuildpathAttributes attrs) {
    this._parent = aParent;
    this._attributes = attrs;
  }
  
  public BuildpathEntry(final BuildpathEntry aParent, final String aName) {
    this(aParent, new BuildpathAttributes());
  }
  
  public boolean hasResource(final IResource resource) {
    return true;
  }
  
  @Pure
  public BuildpathEntry getParent() {
    return this._parent;
  }
  
  public void setParent(final BuildpathEntry parent) {
    this._parent = parent;
  }
  
  @Pure
  public BuildpathAttributes getAttributes() {
    return this._attributes;
  }
  
  public void setAttributes(final BuildpathAttributes attributes) {
    this._attributes = attributes;
  }
}
