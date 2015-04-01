package org.erlide.scoping;

import com.google.inject.Inject;
import java.util.Collection;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.ScopeExtensions;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(ErlangInjectorProvider.class)
@SuppressWarnings("all")
public class ErlangGlobalScopingTest {
  @Inject
  private ParseHelper<Module> parser;
  
  @Inject
  private IQualifiedNameConverter cvtr;
  
  @Inject
  @Extension
  private ModelExtensions _modelExtensions;
  
  @Inject
  @Extension
  private ScopeExtensions _scopeExtensions;
  
  @Test
  public void allContents() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("f() -> ok.");
      _builder.newLine();
      _builder.append("-ifdef(A).");
      _builder.newLine();
      _builder.append("g(X) -> X.");
      _builder.newLine();
      _builder.append("-else.");
      _builder.newLine();
      _builder.append("-ifdef(B).");
      _builder.newLine();
      _builder.append("g(X) -> X.");
      _builder.newLine();
      _builder.append("-endif.");
      _builder.newLine();
      _builder.append("-endif.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Collection<EObject> eFuns = this._modelExtensions.getAllContents(module);
      int _size = eFuns.size();
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(4));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void noExportedFunctions() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("f() -> ok.");
      _builder.newLine();
      _builder.append("g(X) -> X.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Iterable<IEObjectDescription> eFuns = this._scopeExtensions.getExportedFunctions(module);
      int _size = IterableExtensions.size(eFuns);
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(0));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void exportedFunctions() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-export([f/0]).");
      _builder.newLine();
      _builder.append("g(X) -> X.");
      _builder.newLine();
      _builder.append("f() -> ok.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Iterable<IEObjectDescription> eFuns = this._scopeExtensions.getExportedFunctions(module);
      int _size = IterableExtensions.size(eFuns);
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(1));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(eFuns);
      QualifiedName _qualifiedName = _head.getQualifiedName();
      String _string = this.cvtr.toString(_qualifiedName);
      Matcher<? super String> _is_1 = Matchers.<String>is("x:f/0");
      MatcherAssert.<String>assertThat(_string, _is_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void exportedFunctions_multipleExports() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-export([f/0]).");
      _builder.newLine();
      _builder.append("-export([g/1]).");
      _builder.newLine();
      _builder.append("g(X) -> X.");
      _builder.newLine();
      _builder.append("f() -> ok.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Iterable<IEObjectDescription> eFuns = this._scopeExtensions.getExportedFunctions(module);
      int _size = IterableExtensions.size(eFuns);
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(2));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(eFuns);
      QualifiedName _qualifiedName = _head.getQualifiedName();
      String _string = this.cvtr.toString(_qualifiedName);
      Matcher<? super String> _is_1 = Matchers.<String>is("x:g/1");
      MatcherAssert.<String>assertThat(_string, _is_1);
      Iterable<IEObjectDescription> _tail = IterableExtensions.<IEObjectDescription>tail(eFuns);
      IEObjectDescription _head_1 = IterableExtensions.<IEObjectDescription>head(_tail);
      QualifiedName _qualifiedName_1 = _head_1.getQualifiedName();
      String _string_1 = this.cvtr.toString(_qualifiedName_1);
      Matcher<? super String> _is_2 = Matchers.<String>is("x:f/0");
      MatcherAssert.<String>assertThat(_string_1, _is_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void exportedFunctions_exportAll() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-compile([export_all]).");
      _builder.newLine();
      _builder.append("g(X) -> X.");
      _builder.newLine();
      _builder.append("f() -> ok.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Iterable<IEObjectDescription> eFuns = this._scopeExtensions.getExportedFunctions(module);
      int _size = IterableExtensions.size(eFuns);
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(2));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(eFuns);
      QualifiedName _qualifiedName = _head.getQualifiedName();
      String _string = this.cvtr.toString(_qualifiedName);
      Matcher<? super String> _is_1 = Matchers.<String>is("x:g/1");
      MatcherAssert.<String>assertThat(_string, _is_1);
      Iterable<IEObjectDescription> _tail = IterableExtensions.<IEObjectDescription>tail(eFuns);
      IEObjectDescription _head_1 = IterableExtensions.<IEObjectDescription>head(_tail);
      QualifiedName _qualifiedName_1 = _head_1.getQualifiedName();
      String _string_1 = this.cvtr.toString(_qualifiedName_1);
      Matcher<? super String> _is_2 = Matchers.<String>is("x:f/0");
      MatcherAssert.<String>assertThat(_string_1, _is_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void exportedFunctionsIfdef() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-export([f/0, f/1]).");
      _builder.newLine();
      _builder.append("-ifdef(Z).");
      _builder.newLine();
      _builder.append("f() -> ok.");
      _builder.newLine();
      _builder.append("-else.");
      _builder.newLine();
      _builder.append("f(X) -> ok.");
      _builder.newLine();
      _builder.append("-endif.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Iterable<IEObjectDescription> eFuns = this._scopeExtensions.getExportedFunctions(module);
      int _size = IterableExtensions.size(eFuns);
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(2));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(eFuns);
      QualifiedName _qualifiedName = _head.getQualifiedName();
      String _string = this.cvtr.toString(_qualifiedName);
      Matcher<? super String> _is_1 = Matchers.<String>is("x:f/0");
      MatcherAssert.<String>assertThat(_string, _is_1);
      Iterable<IEObjectDescription> _tail = IterableExtensions.<IEObjectDescription>tail(eFuns);
      IEObjectDescription _head_1 = IterableExtensions.<IEObjectDescription>head(_tail);
      QualifiedName _qualifiedName_1 = _head_1.getQualifiedName();
      String _string_1 = this.cvtr.toString(_qualifiedName_1);
      Matcher<? super String> _is_2 = Matchers.<String>is("x:f/1");
      MatcherAssert.<String>assertThat(_string_1, _is_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void exportedFunctionsIfdef_nested() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-ifdef(Z).");
      _builder.newLine();
      _builder.append("-export([f/0]).");
      _builder.newLine();
      _builder.append("f() -> ok.");
      _builder.newLine();
      _builder.append("-else.");
      _builder.newLine();
      _builder.append("-export([g/1]).");
      _builder.newLine();
      _builder.append("g(X) -> ok.");
      _builder.newLine();
      _builder.append("-endif.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Iterable<IEObjectDescription> eFuns = this._scopeExtensions.getExportedFunctions(module);
      int _size = IterableExtensions.size(eFuns);
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(2));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(eFuns);
      QualifiedName _qualifiedName = _head.getQualifiedName();
      String _string = this.cvtr.toString(_qualifiedName);
      Matcher<? super String> _is_1 = Matchers.<String>is("x:f/0");
      MatcherAssert.<String>assertThat(_string, _is_1);
      Iterable<IEObjectDescription> _tail = IterableExtensions.<IEObjectDescription>tail(eFuns);
      IEObjectDescription _head_1 = IterableExtensions.<IEObjectDescription>head(_tail);
      QualifiedName _qualifiedName_1 = _head_1.getQualifiedName();
      String _string_1 = this.cvtr.toString(_qualifiedName_1);
      Matcher<? super String> _is_2 = Matchers.<String>is("x:g/1");
      MatcherAssert.<String>assertThat(_string_1, _is_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void exportedFunctionsIfdef_deepNested() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-ifdef(Z).");
      _builder.newLine();
      _builder.append("-export([f/0]).");
      _builder.newLine();
      _builder.append("f() -> ok.");
      _builder.newLine();
      _builder.append("-ifdef(Z).");
      _builder.newLine();
      _builder.append("-export([ff/0]).");
      _builder.newLine();
      _builder.append("ff() -> ok.");
      _builder.newLine();
      _builder.append("-else.");
      _builder.newLine();
      _builder.append("-export([fg/1]).");
      _builder.newLine();
      _builder.append("fg(X) -> ok.");
      _builder.newLine();
      _builder.append("-endif.");
      _builder.newLine();
      _builder.append("-else.");
      _builder.newLine();
      _builder.append("-export([g/1]).");
      _builder.newLine();
      _builder.append("g(X) -> ok.");
      _builder.newLine();
      _builder.append("-ifdef(Z).");
      _builder.newLine();
      _builder.append("-export([gf/0]).");
      _builder.newLine();
      _builder.append("gf() -> ok.");
      _builder.newLine();
      _builder.append("-else.");
      _builder.newLine();
      _builder.append("-export([gg/1]).");
      _builder.newLine();
      _builder.append("gg(X) -> ok.");
      _builder.newLine();
      _builder.append("-endif.");
      _builder.newLine();
      _builder.append("-endif.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Iterable<IEObjectDescription> eFuns = this._scopeExtensions.getExportedFunctions(module);
      int _size = IterableExtensions.size(eFuns);
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(6));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(eFuns);
      QualifiedName _qualifiedName = _head.getQualifiedName();
      String _string = this.cvtr.toString(_qualifiedName);
      Matcher<? super String> _is_1 = Matchers.<String>is("x:f/0");
      MatcherAssert.<String>assertThat(_string, _is_1);
      IEObjectDescription _last = IterableExtensions.<IEObjectDescription>last(eFuns);
      QualifiedName _qualifiedName_1 = _last.getQualifiedName();
      String _string_1 = this.cvtr.toString(_qualifiedName_1);
      Matcher<? super String> _is_2 = Matchers.<String>is("x:gg/1");
      MatcherAssert.<String>assertThat(_string_1, _is_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void exportedMacros() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-define(XX, xx).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Iterable<IEObjectDescription> macros = this._scopeExtensions.getExportedMacros(module);
      int _size = IterableExtensions.size(macros);
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(1));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(macros);
      QualifiedName _qualifiedName = _head.getQualifiedName();
      String _string = this.cvtr.toString(_qualifiedName);
      Matcher<? super String> _is_1 = Matchers.<String>is("x:XX");
      MatcherAssert.<String>assertThat(_string, _is_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void exportedMacrosHeader() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-define(XX, xx).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Iterable<IEObjectDescription> macros = this._scopeExtensions.getExportedMacros(module);
      int _size = IterableExtensions.size(macros);
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(1));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(macros);
      QualifiedName _qualifiedName = _head.getQualifiedName();
      String _string = this.cvtr.toString(_qualifiedName);
      Matcher<? super String> _is_1 = Matchers.<String>is("__synthetic0_erl:XX");
      MatcherAssert.<String>assertThat(_string, _is_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void exportedRecords() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-record(rec, {}).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Iterable<IEObjectDescription> recs = this._scopeExtensions.getExportedRecords(module);
      int _size = IterableExtensions.size(recs);
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(1));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(recs);
      QualifiedName _qualifiedName = _head.getQualifiedName();
      String _string = this.cvtr.toString(_qualifiedName);
      Matcher<? super String> _is_1 = Matchers.<String>is("x:rec");
      MatcherAssert.<String>assertThat(_string, _is_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void exportedRecordsHeader() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-record(rec, {}).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Iterable<IEObjectDescription> recs = this._scopeExtensions.getExportedRecords(module);
      int _size = IterableExtensions.size(recs);
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(1));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(recs);
      QualifiedName _qualifiedName = _head.getQualifiedName();
      String _string = this.cvtr.toString(_qualifiedName);
      Matcher<? super String> _is_1 = Matchers.<String>is("__synthetic0_erl:rec");
      MatcherAssert.<String>assertThat(_string, _is_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
