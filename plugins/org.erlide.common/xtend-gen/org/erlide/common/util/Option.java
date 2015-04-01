package org.erlide.common.util;

@SuppressWarnings("all")
public abstract class Option<T extends Object> implements Iterable<T> {
  public abstract T get();
  
  public abstract boolean isEmpty();
  
  public T getOrElse(final T _default) {
    T _xifexpression = null;
    boolean _isEmpty = this.isEmpty();
    if (_isEmpty) {
      _xifexpression = _default;
    } else {
      _xifexpression = this.get();
    }
    return _xifexpression;
  }
}
