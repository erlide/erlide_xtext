package org.erlide.project.buildpath.convert;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.erlide.project.buildpath.convert.AbstractContentProvider;

@SuppressWarnings("all")
public class PeTestContentProvider extends AbstractContentProvider {
  @Override
  public Collection<String> get(final IPath path) {
    ArrayList<String> _switchResult = null;
    String _portableString = path.toPortableString();
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_portableString, "demo.erlidex")) {
        _matched=true;
        _switchResult = CollectionLiterals.<String>newArrayList("AAA", "inc1.erlidex", "BBB", "bbb");
      }
    }
    if (!_matched) {
      if (Objects.equal(_portableString, "inc1.erlidex")) {
        _matched=true;
        _switchResult = CollectionLiterals.<String>newArrayList("aaa", "bbb");
      }
    }
    if (!_matched) {
      _switchResult = CollectionLiterals.<String>newArrayList();
    }
    return _switchResult;
  }
}
