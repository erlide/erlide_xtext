package org.erlide.erlang;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Pair;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;

@SuppressWarnings("all")
public class ErlangTestExtensions {
  @Inject
  private ModelExtensions modelHelper;
  
  public EObject getObjectAtMarker(final Pair<Module, List<Integer>> src, final int index) {
    EObject _xblockexpression = null;
    {
      List<Integer> _value = src.getValue();
      int _size = _value.size();
      boolean _greaterEqualsThan = (index >= _size);
      if (_greaterEqualsThan) {
        return null;
      }
      List<Integer> _value_1 = src.getValue();
      final Integer pos = _value_1.get(index);
      Module _key = src.getKey();
      _xblockexpression = this.modelHelper.getObjectAtOffset(_key, (pos).intValue());
    }
    return _xblockexpression;
  }
  
  public EObject getObjectAtMarker(final Pair<Module, List<Integer>> src) {
    return this.getObjectAtMarker(src, 0);
  }
}
