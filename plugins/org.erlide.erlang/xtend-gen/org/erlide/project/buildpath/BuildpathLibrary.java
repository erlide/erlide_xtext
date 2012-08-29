package org.erlide.project.buildpath;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.erlide.project.buildpath.BuildpathApp;
import org.erlide.project.buildpath.BuildpathAttributes;
import org.erlide.project.buildpath.BuildpathEntry;

@Data
@SuppressWarnings("all")
public class BuildpathLibrary extends BuildpathEntry {
  private final String _name;
  
  public String getName() {
    return this._name;
  }
  
  private final Collection<BuildpathLibrary> _libraries = new Function0<Collection<BuildpathLibrary>>() {
    public Collection<BuildpathLibrary> apply() {
      HashSet<BuildpathLibrary> _newHashSet = CollectionLiterals.<BuildpathLibrary>newHashSet();
      return _newHashSet;
    }
  }.apply();
  
  private final Collection<BuildpathApp> _apps = new Function0<Collection<BuildpathApp>>() {
    public Collection<BuildpathApp> apply() {
      HashSet<BuildpathApp> _newHashSet = CollectionLiterals.<BuildpathApp>newHashSet();
      return _newHashSet;
    }
  }.apply();
  
  public BuildpathLibrary(final BuildpathLibrary parent, final String name, final BuildpathAttributes attributes) {
    super(parent, attributes);
    this._name = name;
  }
  
  public BuildpathLibrary(final BuildpathLibrary parent, final String name) {
    super(parent, new Function0<BuildpathAttributes>() {
      public BuildpathAttributes apply() {
        BuildpathAttributes _buildpathAttributes = new BuildpathAttributes();
        return _buildpathAttributes;
      }
    }.apply());
    this._name = name;
  }
  
  protected void _addChild(final BuildpathLibrary entry) {
    String _name = entry.getName();
    String _plus = ("ADD " + _name);
    String _plus_1 = (_plus + " TO ");
    int _identityHashCode = System.identityHashCode(this);
    String _plus_2 = (_plus_1 + Integer.valueOf(_identityHashCode));
    InputOutput.<String>println(_plus_2);
    boolean _add = this._libraries.add(entry);
    if (_add) {
      InputOutput.<String>println("OK");
      entry.setParent(this);
    }
  }
  
  protected void _addChild(final BuildpathApp entry) {
    boolean _add = this._apps.add(entry);
    if (_add) {
      entry.setParent(this);
    }
  }
  
  public void removeChild(final BuildpathEntry entry) {
    entry.setParent(null);
  }
  
  public Collection<BuildpathLibrary> getLibraries() {
    return Collections.<BuildpathLibrary>unmodifiableCollection(this._libraries);
  }
  
  public Collection<BuildpathApp> getApps() {
    return Collections.<BuildpathApp>unmodifiableCollection(this._apps);
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
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((_name== null) ? 0 : _name.hashCode());
    result = prime * result + ((_libraries== null) ? 0 : _libraries.hashCode());
    result = prime * result + ((_apps== null) ? 0 : _apps.hashCode());
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
    BuildpathLibrary other = (BuildpathLibrary) obj;
    if (_name == null) {
      if (other._name != null)
        return false;
    } else if (!_name.equals(other._name))
      return false;
    if (_libraries == null) {
      if (other._libraries != null)
        return false;
    } else if (!_libraries.equals(other._libraries))
      return false;
    if (_apps == null) {
      if (other._apps != null)
        return false;
    } else if (!_apps.equals(other._apps))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
