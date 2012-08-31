package org.erlide.project.buildpath.convert;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.erlide.project.buildpath.convert.AbstractContentProvider;

@SuppressWarnings("all")
public class PeTestContentProvider extends AbstractContentProvider {
  public Collection<String> get(final IPath path) {
    ArrayList<String> _switchResult = null;
    String _portableString = path.toPortableString();
    final String _switchValue = _portableString;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,"demo.erlidex")) {
        _matched=true;
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("AAA", "inc1.erlidex", "BBB", "bbb");
        _switchResult = _newArrayList;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"inc1.erlidex")) {
        _matched=true;
        ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList("aaa", "bbb");
        _switchResult = _newArrayList_1;
      }
    }
    if (!_matched) {
      ArrayList<String> _newArrayList_2 = CollectionLiterals.<String>newArrayList();
      _switchResult = _newArrayList_2;
    }
    return _switchResult;
  }
}
