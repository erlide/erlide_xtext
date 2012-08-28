package org.erlide.project.buildpath;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.erlide.project.buildpath.BuildpathAttributes;
import org.erlide.project.buildpath.BuildpathEntry;
import org.erlide.project.buildpath.IBuildpathContainer;
import org.erlide.project.buildpath.IBuildpathFolder;
import org.erlide.project.buildpath.IBuildpathFolder.FolderKind;

@SuppressWarnings("all")
public class BuildpathFolder extends BuildpathEntry implements IBuildpathFolder {
  private IPath _path;
  
  public IPath getPath() {
    return this._path;
  }
  
  public void setPath(final IPath path) {
    this._path = path;
  }
  
  private FolderKind _kind;
  
  public FolderKind getKind() {
    return this._kind;
  }
  
  public void setKind(final FolderKind kind) {
    this._kind = kind;
  }
  
  private List<IPath> inclusionPatterns = new Function0<List<IPath>>() {
    public List<IPath> apply() {
      ArrayList<IPath> _newArrayList = CollectionLiterals.<IPath>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  private List<IPath> exclusionPatterns = new Function0<List<IPath>>() {
    public List<IPath> apply() {
      ArrayList<IPath> _newArrayList = CollectionLiterals.<IPath>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public Collection<IPath> getInclusionPatterns() {
    return Collections.<IPath>unmodifiableList(this.inclusionPatterns);
  }
  
  public Collection<IPath> getExclusionPatterns() {
    return Collections.<IPath>unmodifiableList(this.exclusionPatterns);
  }
  
  public BuildpathFolder(final IBuildpathContainer aParent, final String aName, final BuildpathAttributes attrs, final IPath path, final FolderKind kind) {
    super(aParent, aName, attrs);
    this._path = path;
    this._kind = kind;
  }
}
