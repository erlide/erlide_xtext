package org.erlide.common.util;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import org.erlide.common.util.Option;

@SuppressWarnings("all")
public class None<T extends Object> extends Option<T> {
  public T get() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException();
    throw _unsupportedOperationException;
  }
  
  public boolean isEmpty() {
    return true;
  }
  
  public Iterator<T> iterator() {
    ArrayList<T> _arrayList = new ArrayList<T>();
    Iterator<T> _iterator = _arrayList.iterator();
    return _iterator;
  }
  
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
          final None<T> _none = (None<T>)o;
          _matched=true;
          _switchResult = true;
        }
      }
      if (!_matched) {
        _switchResult = false;
      }
      _and = (_notEquals && _switchResult);
    }
    return _and;
  }
  
  public int hashCode() {
    return 0;
  }
  
  public String toString() {
    return "None";
  }
}
