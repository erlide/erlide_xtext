package org.erlide.project.buildpath;

import java.util.Collection;
import java.util.Collections;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.erlide.project.buildpath.BuildpathAttributes;
import org.erlide.project.buildpath.BuildpathEntry;
import org.erlide.project.buildpath.BuildpathFolder;
import org.erlide.project.buildpath.BuildpathLibrary;

@Data
@SuppressWarnings("all")
public class BuildpathApp extends BuildpathEntry {
  private final Collection<BuildpathFolder> folders = CollectionLiterals.<BuildpathFolder>newArrayList();
  
  public BuildpathApp(final BuildpathLibrary parent, final BuildpathAttributes attributes) {
    super(parent, attributes);
  }
  
  public BuildpathApp(final BuildpathLibrary parent) {
    super(parent, new BuildpathAttributes());
  }
  
  public Collection<BuildpathFolder> getFolders() {
    return Collections.<BuildpathFolder>unmodifiableCollection(this.folders);
  }
  
  public void addFolder(final BuildpathFolder entry) {
    boolean _add = this.folders.add(entry);
    if (_add) {
      entry.setParent(this);
    }
  }
  
  public boolean removeFolder(final BuildpathFolder entry) {
    boolean _xblockexpression = false;
    {
      entry.setParent(null);
      _xblockexpression = this.folders.remove(entry);
    }
    return _xblockexpression;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.folders== null) ? 0 : this.folders.hashCode());
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
    BuildpathApp other = (BuildpathApp) obj;
    if (this.folders == null) {
      if (other.folders != null)
        return false;
    } else if (!this.folders.equals(other.folders))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    String result = new ToStringBuilder(this)
    	.addAllFields()
    	.toString();
    return result;
  }
}
