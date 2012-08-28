package org.erlide.project.buildpath;

import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.erlide.project.buildpath.BuildpathAttributes;
import org.erlide.project.buildpath.IBuildpathContainer;
import org.erlide.project.buildpath.IBuildpathEntry;

@SuppressWarnings("all")
public abstract class BuildpathEntry implements IBuildpathEntry {
  private IBuildpathContainer _parent;
  
  public IBuildpathContainer getParent() {
    return this._parent;
  }
  
  public void setParent(final IBuildpathContainer parent) {
    this._parent = parent;
  }
  
  private String _name;
  
  public String getName() {
    return this._name;
  }
  
  public void setName(final String name) {
    this._name = name;
  }
  
  private BuildpathAttributes _attributes;
  
  public BuildpathAttributes getAttributes() {
    return this._attributes;
  }
  
  public void setAttributes(final BuildpathAttributes attributes) {
    this._attributes = attributes;
  }
  
  public BuildpathEntry(final IBuildpathContainer aParent, final String aName, final BuildpathAttributes attrs) {
    this._parent = aParent;
    this._name = aName;
    this._attributes = attrs;
  }
  
  public BuildpathEntry(final IBuildpathContainer aParent, final String aName) {
    this(aParent, aName, new Function0<BuildpathAttributes>() {
      public BuildpathAttributes apply() {
        BuildpathAttributes _buildpathAttributes = new BuildpathAttributes();
        return _buildpathAttributes;
      }
    }.apply());
  }
}
