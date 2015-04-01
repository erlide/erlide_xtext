package org.erlide.common.util;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import org.erlide.common.util.Option;

@SuppressWarnings("all")
public class None<T extends Object> extends Option<T> {
  @Override
  public T get() {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public boolean isEmpty() {
    return true;
  }
  
  @Override
  public Iterator<T> iterator() {
    ArrayList<T> _arrayList = new ArrayList<T>();
    return _arrayList.iterator();
  }
  
  @Override
  public boolean equals(final Object o) {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(o, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _switchResult = false;
      boolean _matched = false;
      if (!_matched) {
        if (o instanceof None) {
          _matched=true;
          _switchResult = true;
        }
      }
      if (!_matched) {
        _switchResult = false;
      }
      _and = _switchResult;
    }
    return _and;
  }
  
  @Override
  public int hashCode() {
    return 0;
  }
  
  @Override
  public String toString() {
    return "None";
  }
}
