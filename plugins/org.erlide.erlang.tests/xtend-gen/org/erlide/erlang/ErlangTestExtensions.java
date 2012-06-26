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
  
  public EObject getObjectAtMarker(final Pair<Module,List<Integer>> src, final int index) {
    Module _key = src.getKey();
    List<Integer> _value = src.getValue();
    Integer _get = _value.get(index);
    EObject _objectAtOffset = this.modelHelper.getObjectAtOffset(_key, (_get).intValue());
    return _objectAtOffset;
  }
  
  public EObject getObjectAtMarker(final Pair<Module,List<Integer>> src) {
    EObject _objectAtMarker = this.getObjectAtMarker(src, 0);
    return _objectAtMarker;
  }
}
