package org.erlide.erlang;

import com.google.inject.Inject;
import java.util.Collection;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.Atom;
import org.erlide.erlang.Attribute;
import org.erlide.erlang.CustomAttribute;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Function;
import org.erlide.erlang.IsFunRefMatcher;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = ErlangInjectorProvider.class)
@SuppressWarnings("all")
public class ModuleExtensionsTest {
  @Inject
  private ParseHelper<Module> parser;
  
  @Inject
  private ModelExtensions _modelExtensions;
  
  @Test
  public void moduleName() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final String myname = this._modelExtensions.getName(module);
      Matcher<? super String> _is = Matchers.<String>is("x");
      MatcherAssert.<String>assertThat(myname, _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void moduleNameWithComments() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("%% comment");
      _builder.newLine();
      _builder.append("-module(x).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final String myname = this._modelExtensions.getName(module);
      Matcher<? super String> _is = Matchers.<String>is("x");
      MatcherAssert.<String>assertThat(myname, _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void noModuleName() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-include(\"x\").");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final String myname = this._modelExtensions.getName(module);
      Matcher<String> _nullValue = Matchers.<String>nullValue();
      Matcher<String> _is = Matchers.<String>is(_nullValue);
      MatcherAssert.<String>assertThat(myname, _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void headerHasNoName() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-include(\"x\").");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      boolean _isHeader = this._modelExtensions.isHeader(module);
      Matcher<? super Boolean> _is = Matchers.<Boolean>is(Boolean.valueOf(true));
      MatcherAssert.<Boolean>assertThat(Boolean.valueOf(_isHeader), _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void fullModuleHasName() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      boolean _isHeader = this._modelExtensions.isHeader(module);
      Matcher<? super Boolean> _is = Matchers.<Boolean>is(Boolean.valueOf(false));
      MatcherAssert.<Boolean>assertThat(Boolean.valueOf(_isHeader), _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void getAttributes() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-define(X, ok).");
      _builder.newLine();
      _builder.append("foo() -> ok.");
      _builder.newLine();
      _builder.append("-foo(bar).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Collection<Attribute> attrs = this._modelExtensions.getAllItemsOfType(module);
      int _size = attrs.size();
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(3));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void getCustomAttributesByTag() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-foo(baz).");
      _builder.newLine();
      _builder.append("-define(X, ok).");
      _builder.newLine();
      _builder.append("foo() -> ok.");
      _builder.newLine();
      _builder.append("-foo(bar).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Collection<CustomAttribute> attrs = this._modelExtensions.getCustomAttributesWithTag(module, "foo");
      int _size = attrs.size();
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(2));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
      CustomAttribute _head = IterableExtensions.<CustomAttribute>head(attrs);
      String _tag = _head.getTag();
      Matcher<? super String> _is_1 = Matchers.<String>is("foo");
      MatcherAssert.<String>assertThat(_tag, _is_1);
      Iterable<CustomAttribute> _tail = IterableExtensions.<CustomAttribute>tail(attrs);
      CustomAttribute _head_1 = IterableExtensions.<CustomAttribute>head(_tail);
      String _tag_1 = _head_1.getTag();
      Matcher<? super String> _is_2 = Matchers.<String>is("foo");
      MatcherAssert.<String>assertThat(_tag_1, _is_2);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void getExportedFunctions() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-export([bar/0, baz/1]).");
      _builder.newLine();
      _builder.append("-export([foo/0]).");
      _builder.newLine();
      _builder.append("bar()->ok.");
      _builder.newLine();
      _builder.append("baz(X)->ok.");
      _builder.newLine();
      _builder.append("foo()->ok.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Collection<Function> attrs = this._modelExtensions.getDeclaredExports(module);
      int _size = attrs.size();
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(3));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
      Function _head = IterableExtensions.<Function>head(attrs);
      Matcher<Function> _isFunction = IsFunRefMatcher.isFunction("bar", 0);
      MatcherAssert.<Function>assertThat(_head, _isFunction);
      Iterable<Function> _tail = IterableExtensions.<Function>tail(attrs);
      Function _head_1 = IterableExtensions.<Function>head(_tail);
      Matcher<Function> _isFunction_1 = IsFunRefMatcher.isFunction("baz", 1);
      MatcherAssert.<Function>assertThat(_head_1, _isFunction_1);
      Iterable<Function> _tail_1 = IterableExtensions.<Function>tail(attrs);
      Iterable<Function> _tail_2 = IterableExtensions.<Function>tail(_tail_1);
      Function _head_2 = IterableExtensions.<Function>head(_tail_2);
      Matcher<Function> _isFunction_2 = IsFunRefMatcher.isFunction("foo", 0);
      MatcherAssert.<Function>assertThat(_head_2, _isFunction_2);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void getFunction() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("bar()->ok.");
      _builder.newLine();
      _builder.append("baz(X)->ok.");
      _builder.newLine();
      _builder.append("foo()->ok.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Function bar = this._modelExtensions.getFunction(module, "bar", 0);
      Matcher<Function> _notNullValue = Matchers.<Function>notNullValue();
      Matcher<Function> _is = Matchers.<Function>is(_notNullValue);
      MatcherAssert.<Function>assertThat(bar, _is);
      Matcher<Function> _isFunction = IsFunRefMatcher.isFunction("bar", 0);
      MatcherAssert.<Function>assertThat(bar, _isFunction);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void getUndefinedFunction() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("bar()->ok.");
      _builder.newLine();
      _builder.append("baz(X)->ok.");
      _builder.newLine();
      _builder.append("foo()->ok.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Function bar1 = this._modelExtensions.getFunction(module, "bar", 1);
      Matcher<Function> _nullValue = Matchers.<Function>nullValue();
      Matcher<Function> _is = Matchers.<Function>is(_nullValue);
      MatcherAssert.<Function>assertThat(bar1, _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void getIncludes() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-include(\"bar.hrl\").");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Collection<String> bar1 = this._modelExtensions.getIncludes(module);
      String _head = IterableExtensions.<String>head(bar1);
      Matcher<? super String> _is = Matchers.<String>is("\"bar.hrl\"");
      MatcherAssert.<String>assertThat(_head, _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void getIncludeLibs() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-include_lib(\"foo.hrl\").");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Collection<String> bar1 = this._modelExtensions.getIncludeLibs(module);
      String _head = IterableExtensions.<String>head(bar1);
      Matcher<? super String> _is = Matchers.<String>is("\"foo.hrl\"");
      MatcherAssert.<String>assertThat(_head, _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void exportsAll() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-compile(export_all).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final boolean bar1 = this._modelExtensions.exportsAll(module);
      Matcher<? super Boolean> _is = Matchers.<Boolean>is(Boolean.valueOf(true));
      MatcherAssert.<Boolean>assertThat(Boolean.valueOf(bar1), _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void exportsAll_no() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final boolean bar1 = this._modelExtensions.exportsAll(module);
      Matcher<? super Boolean> _is = Matchers.<Boolean>is(Boolean.valueOf(false));
      MatcherAssert.<Boolean>assertThat(Boolean.valueOf(bar1), _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void exportsAll_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-compile([debug_info, export_all]).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final boolean bar1 = this._modelExtensions.exportsAll(module);
      Matcher<? super Boolean> _is = Matchers.<Boolean>is(Boolean.valueOf(true));
      MatcherAssert.<Boolean>assertThat(Boolean.valueOf(bar1), _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void getParseTransform() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-compile({parse_transform, x}).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Collection<Atom> bar1 = this._modelExtensions.getParseTransforms(module);
      Atom _head = IterableExtensions.<Atom>head(bar1);
      String _sourceText = this._modelExtensions.getSourceText(_head);
      Matcher<? super String> _is = Matchers.<String>is("x");
      MatcherAssert.<String>assertThat(_sourceText, _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void getParseTransform_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-compile([debug_info, {parse_transform, x}]).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Collection<Atom> bar1 = this._modelExtensions.getParseTransforms(module);
      int _size = bar1.size();
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(1));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
      Atom _head = IterableExtensions.<Atom>head(bar1);
      String _sourceText = this._modelExtensions.getSourceText(_head);
      Matcher<? super String> _is_1 = Matchers.<String>is("x");
      MatcherAssert.<String>assertThat(_sourceText, _is_1);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void getParseTransform_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-compile([{parse_transform, x}]).");
      _builder.newLine();
      _builder.append("-compile({parse_transform, y}).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Collection<Atom> bar1 = this._modelExtensions.getParseTransforms(module);
      int _size = bar1.size();
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(2));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
      final Function1<Atom,String> _function = new Function1<Atom,String>() {
          public String apply(final Atom it) {
            String _sourceText = ModuleExtensionsTest.this._modelExtensions.getSourceText(it);
            return _sourceText;
          }
        };
      Iterable<String> _map = IterableExtensions.<Atom, String>map(bar1, _function);
      Matcher<Iterable<? super String>> _hasItem = Matchers.<String>hasItem("x");
      MatcherAssert.<Iterable<String>>assertThat(_map, _hasItem);
      final Function1<Atom,String> _function_1 = new Function1<Atom,String>() {
          public String apply(final Atom it) {
            String _sourceText = ModuleExtensionsTest.this._modelExtensions.getSourceText(it);
            return _sourceText;
          }
        };
      Iterable<String> _map_1 = IterableExtensions.<Atom, String>map(bar1, _function_1);
      Matcher<Iterable<? super String>> _hasItem_1 = Matchers.<String>hasItem("y");
      MatcherAssert.<Iterable<String>>assertThat(_map_1, _hasItem_1);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void getCompileOptions() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-compile([debug_info, {parse_transform, x}]).");
      _builder.newLine();
      _builder.append("-compile([debug_info, {parse_transform, x}]).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Collection<Expression> opts = this._modelExtensions.getCompileOptions(module);
      int _size = opts.size();
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(2));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
