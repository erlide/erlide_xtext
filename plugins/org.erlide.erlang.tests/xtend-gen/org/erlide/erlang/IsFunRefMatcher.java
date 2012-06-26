package org.erlide.erlang;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.erlide.erlang.Expression;
import org.erlide.erlang.FunRef;
import org.erlide.erlang.Function;
import org.erlide.erlang.ModelExtensions;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

@SuppressWarnings("all")
public class IsFunRefMatcher extends BaseMatcher {
  private String name;
  
  private int arity;
  
  private ModelExtensions _modelExtensions = new Function0<ModelExtensions>() {
    public ModelExtensions apply() {
      ModelExtensions _modelExtensions = new ModelExtensions();
      return _modelExtensions;
    }
  }.apply();
  
  public IsFunRefMatcher(final String name, final int arity) {
    this.name = name;
    this.arity = arity;
  }
  
  public void describeTo(final Description description) {
    String _plus = (this.name + "/");
    String _plus_1 = (_plus + Integer.valueOf(this.arity));
    description.appendText(_plus_1);
  }
  
  @Factory
  public static Matcher<Function> isFunction(final String name, final int arity) {
    IsFunRefMatcher _isFunRefMatcher = new IsFunRefMatcher(name, arity);
    return _isFunRefMatcher;
  }
  
  @Factory
  public static Matcher<FunRef> isFunRef(final String name, final int arity) {
    IsFunRefMatcher _isFunRefMatcher = new IsFunRefMatcher(name, arity);
    return _isFunRefMatcher;
  }
  
  protected boolean _matches(final Function item) {
    boolean _and = false;
    String _name = item.getName();
    boolean _equals = Objects.equal(_name, this.name);
    if (!_equals) {
      _and = false;
    } else {
      int _arity = this._modelExtensions.getArity(item);
      boolean _equals_1 = (_arity == this.arity);
      _and = (_equals && _equals_1);
    }
    return _and;
  }
  
  protected boolean _matches(final FunRef item) {
    boolean _and = false;
    Expression _function = item.getFunction();
    boolean _equals = Objects.equal(_function, this.name);
    if (!_equals) {
      _and = false;
    } else {
      Expression _arity = item.getArity();
      String _string = Integer.toString(this.arity);
      boolean _equals_1 = Objects.equal(_arity, _string);
      _and = (_equals && _equals_1);
    }
    return _and;
  }
  
  protected boolean _matches(final Object item) {
    return false;
  }
  
  public boolean matches(final Object item) {
    if (item instanceof FunRef) {
      return _matches((FunRef)item);
    } else if (item instanceof Function) {
      return _matches((Function)item);
    } else if (item != null) {
      return _matches(item);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(item).toString());
    }
  }
}
