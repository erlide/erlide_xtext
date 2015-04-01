package org.erlide.project.buildpath;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.erlide.project.buildpath.BuildpathApp;
import org.erlide.project.buildpath.BuildpathAttributes;
import org.erlide.project.buildpath.BuildpathEntry;
import org.erlide.project.buildpath.FolderKind;

@Data
@SuppressWarnings("all")
public class BuildpathFolder extends BuildpathEntry {
  private final IPath path;
  
  private final FolderKind kind;
  
  private final List<IPath> inclusionPatterns = CollectionLiterals.<IPath>newArrayList();
  
  private final List<IPath> exclusionPatterns = CollectionLiterals.<IPath>newArrayList();
  
  public Collection<IPath> getInclusionPatterns() {
    return Collections.<IPath>unmodifiableList(this.inclusionPatterns);
  }
  
  public Collection<IPath> getExclusionPatterns() {
    return Collections.<IPath>unmodifiableList(this.exclusionPatterns);
  }
  
  public BuildpathFolder(final BuildpathApp aParent, final BuildpathAttributes attrs, final IPath path, final FolderKind kind) {
    super(aParent, attrs);
    this.path = path;
    this.kind = kind;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.path== null) ? 0 : this.path.hashCode());
    result = prime * result + ((this.kind== null) ? 0 : this.kind.hashCode());
    result = prime * result + ((this.inclusionPatterns== null) ? 0 : this.inclusionPatterns.hashCode());
    result = prime * result + ((this.exclusionPatterns== null) ? 0 : this.exclusionPatterns.hashCode());
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
    BuildpathFolder other = (BuildpathFolder) obj;
    if (this.path == null) {
      if (other.path != null)
        return false;
    } else if (!this.path.equals(other.path))
      return false;
    if (this.kind == null) {
      if (other.kind != null)
        return false;
    } else if (!this.kind.equals(other.kind))
      return false;
    if (this.inclusionPatterns == null) {
      if (other.inclusionPatterns != null)
        return false;
    } else if (!this.inclusionPatterns.equals(other.inclusionPatterns))
      return false;
    if (this.exclusionPatterns == null) {
      if (other.exclusionPatterns != null)
        return false;
    } else if (!this.exclusionPatterns.equals(other.exclusionPatterns))
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
  
  @Pure
  public IPath getPath() {
    return this.path;
  }
  
  @Pure
  public FolderKind getKind() {
    return this.kind;
  }
}
