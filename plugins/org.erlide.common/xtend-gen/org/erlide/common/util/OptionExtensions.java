package org.erlide.common.util;

import com.google.common.base.Objects;
import org.erlide.common.util.None;
import org.erlide.common.util.Option;
import org.erlide.common.util.Some;

@SuppressWarnings("all")
public abstract class OptionExtensions {
  public static <T extends Object> Option<T> Option(final T obj) {
    Option<T> _xifexpression = null;
    boolean _equals = Objects.equal(obj, null);
    if (_equals) {
      None<T> _None = OptionExtensions.<T>None();
      _xifexpression = _None;
    } else {
      Some<T> _Some = OptionExtensions.<T>Some(obj);
      _xifexpression = _Some;
    }
    return _xifexpression;
  }
  
  public static <T extends Object> Some<T> Some(final T obj) {
    Some<T> _some = new Some<T>(obj);
    return _some;
  }
  
  public static <T extends Object> None<T> None() {
    None<T> _none = new None<T>();
    return _none;
  }
}
