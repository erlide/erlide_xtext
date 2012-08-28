package org.erlide.project.buildpath;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.erlide.project.buildpath.BuildpathAttributes;
import org.erlide.project.buildpath.BuildpathEntry;
import org.erlide.project.buildpath.IBuildpathContainer;
import org.erlide.project.buildpath.IBuildpathContainer.ContainerKind;
import org.erlide.project.buildpath.IBuildpathEntry;

@SuppressWarnings("all")
public class BuildpathContainer extends BuildpathEntry implements IBuildpathContainer {
  private ContainerKind _kind;
  
  public ContainerKind getKind() {
    return this._kind;
  }
  
  public void setKind(final ContainerKind kind) {
    this._kind = kind;
  }
  
  private Collection<IBuildpathEntry> children = new Function0<Collection<IBuildpathEntry>>() {
    public Collection<IBuildpathEntry> apply() {
      ArrayList<IBuildpathEntry> _newArrayList = CollectionLiterals.<IBuildpathEntry>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public BuildpathContainer(final IBuildpathContainer parent, final String name, final BuildpathAttributes attributes, final ContainerKind kind) {
    super(parent, name, attributes);
    this._kind = kind;
  }
  
  public BuildpathContainer(final IBuildpathContainer parent, final String name, final ContainerKind kind) {
    super(parent, name, new Function0<BuildpathAttributes>() {
      public BuildpathAttributes apply() {
        BuildpathAttributes _buildpathAttributes = new BuildpathAttributes();
        return _buildpathAttributes;
      }
    }.apply());
    this._kind = kind;
  }
  
  public void addChild(final IBuildpathEntry entry) {
    this.children.add(entry);
    entry.setParent(this);
  }
  
  public void removeChild(final IBuildpathEntry entry) {
    this.children.remove(entry);
    entry.setParent(null);
  }
  
  public Collection<IBuildpathEntry> getChildren() {
    return Collections.<IBuildpathEntry>unmodifiableCollection(this.children);
  }
}
