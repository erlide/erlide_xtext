package org.erlide.project.buildpath.convert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class AbstractContentProvider {
  public final static Collection<String> NOTHING = new Function0<Collection<String>>() {
    public Collection<String> apply() {
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
      Collection<String> _unmodifiableCollection = Collections.<String>unmodifiableCollection(_newArrayList);
      return _unmodifiableCollection;
    }
  }.apply();
  
  public Collection<String> get(final IPath path) {
    return AbstractContentProvider.NOTHING;
  }
}
