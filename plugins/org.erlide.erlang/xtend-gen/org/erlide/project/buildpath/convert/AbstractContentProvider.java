package org.erlide.project.buildpath.convert;

import java.util.Collection;
import java.util.Collections;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class AbstractContentProvider {
  public final static Collection<String> NOTHING = Collections.<String>unmodifiableCollection(CollectionLiterals.<String>newArrayList());
  
  public Collection<String> get(final IPath path) {
    return AbstractContentProvider.NOTHING;
  }
}
