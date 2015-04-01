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
      _xifexpression = OptionExtensions.<T>None();
    } else {
      _xifexpression = OptionExtensions.<T>Some(obj);
    }
    return _xifexpression;
  }
  
  public static <T extends Object> Some<T> Some(final T obj) {
    return new Some<T>(obj);
  }
  
  public static <T extends Object> None<T> None() {
    return new None<T>();
  }
}
