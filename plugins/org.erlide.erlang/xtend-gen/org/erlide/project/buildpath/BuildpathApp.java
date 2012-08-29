package org.erlide.project.buildpath;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.erlide.project.buildpath.BuildpathAttributes;
import org.erlide.project.buildpath.BuildpathEntry;
import org.erlide.project.buildpath.BuildpathFolder;
import org.erlide.project.buildpath.BuildpathLibrary;

@Data
@SuppressWarnings("all")
public class BuildpathApp extends BuildpathEntry {
  private final Collection<BuildpathFolder> _folders = new Function0<Collection<BuildpathFolder>>() {
    public Collection<BuildpathFolder> apply() {
      ArrayList<BuildpathFolder> _newArrayList = CollectionLiterals.<BuildpathFolder>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public BuildpathApp(final BuildpathLibrary parent, final BuildpathAttributes attributes) {
    super(parent, attributes);
  }
  
  public BuildpathApp(final BuildpathLibrary parent) {
    super(parent, new Function0<BuildpathAttributes>() {
      public BuildpathAttributes apply() {
        BuildpathAttributes _buildpathAttributes = new BuildpathAttributes();
        return _buildpathAttributes;
      }
    }.apply());
  }
  
  public Collection<BuildpathFolder> getFolders() {
    return Collections.<BuildpathFolder>unmodifiableCollection(this._folders);
  }
  
  public void addFolder(final BuildpathFolder entry) {
    boolean _add = this._folders.add(entry);
    if (_add) {
      entry.setParent(this);
    }
  }
  
  public boolean removeFolder(final BuildpathFolder entry) {
    boolean _xblockexpression = false;
    {
      entry.setParent(null);
      boolean _remove = this._folders.remove(entry);
      _xblockexpression = (_remove);
    }
    return _xblockexpression;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((_folders== null) ? 0 : _folders.hashCode());
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
    if (!super.equals(obj))
      return false;
    BuildpathApp other = (BuildpathApp) obj;
    if (_folders == null) {
      if (other._folders != null)
        return false;
    } else if (!_folders.equals(other._folders))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
