package org.erlide.project.buildpath;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.erlide.project.buildpath.BuildpathApp;
import org.erlide.project.buildpath.BuildpathAttributes;
import org.erlide.project.buildpath.BuildpathEntry;
import org.erlide.project.buildpath.FolderKind;

@Data
@SuppressWarnings("all")
public class BuildpathFolder extends BuildpathEntry {
  private final IPath _path;
  
  public IPath getPath() {
    return this._path;
  }
  
  private final FolderKind _kind;
  
  public FolderKind getKind() {
    return this._kind;
  }
  
  private final List<IPath> _inclusionPatterns = new Function0<List<IPath>>() {
    public List<IPath> apply() {
      ArrayList<IPath> _newArrayList = CollectionLiterals.<IPath>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  private final List<IPath> _exclusionPatterns = new Function0<List<IPath>>() {
    public List<IPath> apply() {
      ArrayList<IPath> _newArrayList = CollectionLiterals.<IPath>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public Collection<IPath> getInclusionPatterns() {
    return Collections.<IPath>unmodifiableList(this._inclusionPatterns);
  }
  
  public Collection<IPath> getExclusionPatterns() {
    return Collections.<IPath>unmodifiableList(this._exclusionPatterns);
  }
  
  public BuildpathFolder(final BuildpathApp aParent, final BuildpathAttributes attrs, final IPath path, final FolderKind kind) {
    super(aParent, attrs);
    this._path = path;
    this._kind = kind;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((_path== null) ? 0 : _path.hashCode());
    result = prime * result + ((_kind== null) ? 0 : _kind.hashCode());
    result = prime * result + ((_inclusionPatterns== null) ? 0 : _inclusionPatterns.hashCode());
    result = prime * result + ((_exclusionPatterns== null) ? 0 : _exclusionPatterns.hashCode());
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
    BuildpathFolder other = (BuildpathFolder) obj;
    if (_path == null) {
      if (other._path != null)
        return false;
    } else if (!_path.equals(other._path))
      return false;
    if (_kind == null) {
      if (other._kind != null)
        return false;
    } else if (!_kind.equals(other._kind))
      return false;
    if (_inclusionPatterns == null) {
      if (other._inclusionPatterns != null)
        return false;
    } else if (!_inclusionPatterns.equals(other._inclusionPatterns))
      return false;
    if (_exclusionPatterns == null) {
      if (other._exclusionPatterns != null)
        return false;
    } else if (!_exclusionPatterns.equals(other._exclusionPatterns))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
