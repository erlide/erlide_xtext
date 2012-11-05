package org.erlide.project.buildpath;

import org.eclipse.core.resources.IResource;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.erlide.project.buildpath.BuildpathAttributes;

@SuppressWarnings("all")
public abstract class BuildpathEntry {
  private BuildpathEntry _parent;
  
  public BuildpathEntry getParent() {
    return this._parent;
  }
  
  public void setParent(final BuildpathEntry parent) {
    this._parent = parent;
  }
  
  private BuildpathAttributes _attributes;
  
  public BuildpathAttributes getAttributes() {
    return this._attributes;
  }
  
  public void setAttributes(final BuildpathAttributes attributes) {
    this._attributes = attributes;
  }
  
  public BuildpathEntry(final BuildpathEntry aParent, final BuildpathAttributes attrs) {
    this._parent = aParent;
    this._attributes = attrs;
  }
  
  public BuildpathEntry(final BuildpathEntry aParent, final String aName) {
    this(aParent, new Function0<BuildpathAttributes>() {
      public BuildpathAttributes apply() {
        BuildpathAttributes _buildpathAttributes = new BuildpathAttributes();
        return _buildpathAttributes;
      }
    }.apply());
  }
  
  public boolean hasResource(final IResource resource) {
    return true;
  }
}
