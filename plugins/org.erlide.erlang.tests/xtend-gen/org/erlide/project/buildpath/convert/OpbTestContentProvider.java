package org.erlide.project.buildpath.convert;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.erlide.project.buildpath.convert.AbstractContentProvider;

@SuppressWarnings("all")
public class OpbTestContentProvider extends AbstractContentProvider {
  public Collection<String> get(final IPath path) {
    Collection<String> _switchResult = null;
    String _portableString = path.toPortableString();
    final String _switchValue = _portableString;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,"demo.erlidex")) {
        _matched=true;
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("AAA");
        _switchResult = _newArrayList;
      }
    }
    if (!_matched) {
      _switchResult = AbstractContentProvider.NOTHING;
    }
    return _switchResult;
  }
}
