package org.erlide.erlang;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.AbstractErlangTests;
import org.erlide.erlang.Function;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.SpecAttribute;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = ErlangInjectorProvider.class)
@SuppressWarnings("all")
public class FunctionExtensionsTest extends AbstractErlangTests {
  @Inject
  private ParseHelper<Module> parser;
  
  @Inject
  private ModelExtensions _modelExtensions;
  
  @Test
  public void isExported() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-export([ff/0]).");
      _builder.newLine();
      _builder.append("ff() -> ok.");
      _builder.newLine();
      _builder.append("gg() -> ok.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Function ff = this._modelExtensions.getFunction(module, "ff", 0);
      boolean _isExported = this._modelExtensions.isExported(ff);
      Matcher<? super Boolean> _is = Matchers.<Boolean>is(Boolean.valueOf(true));
      MatcherAssert.<Boolean>assertThat(Boolean.valueOf(_isExported), _is);
      final Function gg = this._modelExtensions.getFunction(module, "gg", 0);
      boolean _isExported_1 = this._modelExtensions.isExported(gg);
      Matcher<? super Boolean> _is_1 = Matchers.<Boolean>is(Boolean.valueOf(false));
      MatcherAssert.<Boolean>assertThat(Boolean.valueOf(_isExported_1), _is_1);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void getSpec_old() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-export([ff/0]).");
      _builder.newLine();
      _builder.append("-spec ff/0 :: any() -> any().");
      _builder.newLine();
      _builder.append("ff() -> ok.");
      _builder.newLine();
      _builder.append("ff(X) -> ok.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Function ff = this._modelExtensions.getFunction(module, "ff", 0);
      SpecAttribute _spec = this._modelExtensions.getSpec(ff);
      Matcher<SpecAttribute> _notNullValue = Matchers.<SpecAttribute>notNullValue();
      Matcher<SpecAttribute> _is = Matchers.<SpecAttribute>is(_notNullValue);
      MatcherAssert.<SpecAttribute>assertThat(_spec, _is);
      SpecAttribute _spec_1 = this._modelExtensions.getSpec(ff);
      SpecAttribute _spec_2 = this._modelExtensions.getSpec(module, "ff", 0);
      Matcher<? super SpecAttribute> _is_1 = Matchers.<SpecAttribute>is(_spec_2);
      MatcherAssert.<SpecAttribute>assertThat(_spec_1, _is_1);
      final Function gg = this._modelExtensions.getFunction(module, "ff", 1);
      SpecAttribute _spec_3 = this._modelExtensions.getSpec(gg);
      Matcher<SpecAttribute> _nullValue = Matchers.<SpecAttribute>nullValue();
      Matcher<SpecAttribute> _is_2 = Matchers.<SpecAttribute>is(_nullValue);
      MatcherAssert.<SpecAttribute>assertThat(_spec_3, _is_2);
      SpecAttribute _spec_4 = this._modelExtensions.getSpec(module, "gg", 0);
      Matcher<SpecAttribute> _nullValue_1 = Matchers.<SpecAttribute>nullValue();
      Matcher<SpecAttribute> _is_3 = Matchers.<SpecAttribute>is(_nullValue_1);
      MatcherAssert.<SpecAttribute>assertThat(_spec_4, _is_3);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void getSpec() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-export([ff/0]).");
      _builder.newLine();
      _builder.append("-spec ff(any()) -> any().");
      _builder.newLine();
      _builder.append("ff() -> ok.");
      _builder.newLine();
      _builder.append("ff(X) -> ok.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Function ff = this._modelExtensions.getFunction(module, "ff", 1);
      SpecAttribute _spec = this._modelExtensions.getSpec(ff);
      Matcher<SpecAttribute> _notNullValue = Matchers.<SpecAttribute>notNullValue();
      Matcher<SpecAttribute> _is = Matchers.<SpecAttribute>is(_notNullValue);
      MatcherAssert.<SpecAttribute>assertThat(_spec, _is);
      SpecAttribute _spec_1 = this._modelExtensions.getSpec(ff);
      SpecAttribute _spec_2 = this._modelExtensions.getSpec(module, "ff", 1);
      Matcher<? super SpecAttribute> _is_1 = Matchers.<SpecAttribute>is(_spec_2);
      MatcherAssert.<SpecAttribute>assertThat(_spec_1, _is_1);
      final Function gg = this._modelExtensions.getFunction(module, "ff", 0);
      SpecAttribute _spec_3 = this._modelExtensions.getSpec(gg);
      Matcher<SpecAttribute> _nullValue = Matchers.<SpecAttribute>nullValue();
      Matcher<SpecAttribute> _is_2 = Matchers.<SpecAttribute>is(_nullValue);
      MatcherAssert.<SpecAttribute>assertThat(_spec_3, _is_2);
      SpecAttribute _spec_4 = this._modelExtensions.getSpec(module, "gg", 0);
      Matcher<SpecAttribute> _nullValue_1 = Matchers.<SpecAttribute>nullValue();
      Matcher<SpecAttribute> _is_3 = Matchers.<SpecAttribute>is(_nullValue_1);
      MatcherAssert.<SpecAttribute>assertThat(_spec_4, _is_3);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
