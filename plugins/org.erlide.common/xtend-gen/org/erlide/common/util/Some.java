package org.erlide.common.util;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.common.util.Option;

@SuppressWarnings("all")
public class Some<T extends Object> extends Option<T> {
  private final T obj;
  
  public Some(final T obj) {
    boolean _equals = Objects.equal(obj, null);
    if (_equals) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("Some cannot contain null. Use None instead.");
      throw _illegalArgumentException;
    }
    this.obj = obj;
  }
  
  public T get() {
    return this.obj;
  }
  
  public boolean isEmpty() {
    return false;
  }
  
  public Iterator<T> iterator() {
    ArrayList<T> _arrayList = new ArrayList<T>();
    final Procedure1<ArrayList<T>> _function = new Procedure1<ArrayList<T>>() {
        public void apply(final ArrayList<T> it) {
          it.add(Some.this.obj);
        }
      };
    ArrayList<T> _doubleArrow = ObjectExtensions.<ArrayList<T>>operator_doubleArrow(_arrayList, _function);
    Iterator<T> _iterator = _doubleArrow.iterator();
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
        if (o instanceof Some) {
          final Some<T> _some = (Some<T>)o;
          _matched=true;
          boolean _equals = _some.obj.equals(this.obj);
          _switchResult = _equals;
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
    int _hashCode = this.obj.hashCode();
    int _plus = (_hashCode + 31);
    return _plus;
  }
  
  public String toString() {
    String _plus = ("Some(" + this.obj);
    String _plus_1 = (_plus + ")");
    return _plus_1;
  }
}
