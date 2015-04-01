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
      throw new IllegalArgumentException("Some cannot contain null. Use None instead.");
    }
    this.obj = obj;
  }
  
  @Override
  public T get() {
    return this.obj;
  }
  
  @Override
  public boolean isEmpty() {
    return false;
  }
  
  @Override
  public Iterator<T> iterator() {
    ArrayList<T> _arrayList = new ArrayList<T>();
    final Procedure1<ArrayList<T>> _function = new Procedure1<ArrayList<T>>() {
      @Override
      public void apply(final ArrayList<T> it) {
        it.add(Some.this.obj);
      }
    };
    ArrayList<T> _doubleArrow = ObjectExtensions.<ArrayList<T>>operator_doubleArrow(_arrayList, _function);
    return _doubleArrow.iterator();
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
        if (o instanceof Some) {
          _matched=true;
          _switchResult = ((Some<T>)o).obj.equals(this.obj);
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
    int _hashCode = this.obj.hashCode();
    return (_hashCode + 31);
  }
  
  @Override
  public String toString() {
    return (("Some(" + this.obj) + ")");
  }
}
