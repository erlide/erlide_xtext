package org.erlide.project.buildpath;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.erlide.project.buildpath.BuildpathApp;
import org.erlide.project.buildpath.BuildpathAttributes;
import org.erlide.project.buildpath.BuildpathEntry;

@Data
@SuppressWarnings("all")
public class BuildpathLibrary extends BuildpathEntry {
  private final String name;
  
  private final Collection<BuildpathLibrary> libraries = CollectionLiterals.<BuildpathLibrary>newHashSet();
  
  private final Collection<BuildpathApp> apps = CollectionLiterals.<BuildpathApp>newHashSet();
  
  public BuildpathLibrary(final BuildpathLibrary parent, final String name, final BuildpathAttributes attributes) {
    super(parent, attributes);
    this.name = name;
  }
  
  public BuildpathLibrary(final BuildpathLibrary parent, final String name) {
    super(parent, new BuildpathAttributes());
    this.name = name;
  }
  
  protected void _addChild(final BuildpathLibrary entry) {
    int _identityHashCode = System.identityHashCode(this);
    String _plus = ((("ADD " + entry.name) + " TO ") + Integer.valueOf(_identityHashCode));
    InputOutput.<String>println(_plus);
    boolean _add = this.libraries.add(entry);
    if (_add) {
      InputOutput.<String>println("OK");
      entry.setParent(this);
    }
  }
  
  protected void _addChild(final BuildpathApp entry) {
    boolean _add = this.apps.add(entry);
    if (_add) {
      entry.setParent(this);
    }
  }
  
  public void removeChild(final BuildpathEntry entry) {
    entry.setParent(null);
  }
  
  public Collection<BuildpathLibrary> getLibraries() {
    return Collections.<BuildpathLibrary>unmodifiableCollection(this.libraries);
  }
  
  public Collection<BuildpathApp> getApps() {
    return Collections.<BuildpathApp>unmodifiableCollection(this.apps);
  }
  
  public void addChild(final BuildpathEntry entry) {
    if (entry instanceof BuildpathApp) {
      _addChild((BuildpathApp)entry);
      return;
    } else if (entry instanceof BuildpathLibrary) {
      _addChild((BuildpathLibrary)entry);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(entry).toString());
    }
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.libraries== null) ? 0 : this.libraries.hashCode());
    result = prime * result + ((this.apps== null) ? 0 : this.apps.hashCode());
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
    BuildpathLibrary other = (BuildpathLibrary) obj;
    if (this.name == null) {
      if (other.name != null)
        return false;
    } else if (!this.name.equals(other.name))
      return false;
    if (this.libraries == null) {
      if (other.libraries != null)
        return false;
    } else if (!this.libraries.equals(other.libraries))
      return false;
    if (this.apps == null) {
      if (other.apps != null)
        return false;
    } else if (!this.apps.equals(other.apps))
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
  public String getName() {
    return this.name;
  }
}
