package org.erlide.naming;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.ConditionalFormBlock;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Form;
import org.erlide.erlang.FunExpr;
import org.erlide.erlang.Function;
import org.erlide.erlang.FunctionClause;
import org.erlide.erlang.Module;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = ErlangInjectorProvider.class)
@SuppressWarnings("all")
public class ErlangNamingTest {
  @Inject
  private ParseHelper<Module> parser;
  
  @Inject
  private IQualifiedNameProvider namer;
  
  @Inject
  private IQualifiedNameConverter nameCvtr;
  
  @Test
  public void moduleName() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final QualifiedName name = this.namer.getFullyQualifiedName(module);
      String _string = this.nameCvtr.toString(name);
      Matcher<? super String> _is = Matchers.<String>is("x");
      MatcherAssert.<String>assertThat(_string, _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void moduleNameQuoted() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(\'X\').");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final QualifiedName name = this.namer.getFullyQualifiedName(module);
      String _string = this.nameCvtr.toString(name);
      Matcher<? super String> _is = Matchers.<String>is("\'X\'");
      MatcherAssert.<String>assertThat(_string, _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void headerName() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-define(X, x).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final QualifiedName name = this.namer.getFullyQualifiedName(module);
      String _string = this.nameCvtr.toString(name);
      Matcher<? super String> _is = Matchers.<String>is("__synthetic0.erl,hrl");
      MatcherAssert.<String>assertThat(_string, _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void recordName() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-record(y, {}).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      EList<Form> _forms = module.getForms();
      Iterable<Form> _tail = IterableExtensions.<Form>tail(_forms);
      Form _head = IterableExtensions.<Form>head(_tail);
      final QualifiedName name = this.namer.getFullyQualifiedName(_head);
      String _string = this.nameCvtr.toString(name);
      Matcher<? super String> _is = Matchers.<String>is("x:#y_1");
      MatcherAssert.<String>assertThat(_string, _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void ifdefName() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-ifdef(M).");
      _builder.newLine();
      _builder.append("-record(y, {}).");
      _builder.newLine();
      _builder.append("-else.");
      _builder.newLine();
      _builder.append("-record(y, {}).");
      _builder.newLine();
      _builder.append("-endif.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      EList<Form> _forms = module.getForms();
      Form _get = _forms.get(1);
      final ConditionalFormBlock dfn = ((ConditionalFormBlock) _get);
      EList<Form> _ifForms = dfn.getIfForms();
      Form _head = IterableExtensions.<Form>head(_ifForms);
      final QualifiedName name1 = this.namer.getFullyQualifiedName(_head);
      String _string = this.nameCvtr.toString(name1);
      Matcher<? super String> _is = Matchers.<String>is("x:#y_1");
      MatcherAssert.<String>assertThat(_string, _is);
      EList<Form> _elseForms = dfn.getElseForms();
      Form _head_1 = IterableExtensions.<Form>head(_elseForms);
      final QualifiedName name2 = this.namer.getFullyQualifiedName(_head_1);
      String _string_1 = this.nameCvtr.toString(name2);
      Matcher<? super String> _is_1 = Matchers.<String>is("x:#y_2");
      MatcherAssert.<String>assertThat(_string_1, _is_1);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void functionName() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("f() -> ok.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      EList<Form> _forms = module.getForms();
      Iterable<Form> _tail = IterableExtensions.<Form>tail(_forms);
      Form _head = IterableExtensions.<Form>head(_tail);
      final QualifiedName name = this.namer.getFullyQualifiedName(_head);
      String _string = this.nameCvtr.toString(name);
      Matcher<? super String> _is = Matchers.<String>is("x:f/0");
      MatcherAssert.<String>assertThat(_string, _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void functionName_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("f(X) -> ok.");
      _builder.newLine();
      _builder.append("f() -> ok.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      EList<Form> _forms = module.getForms();
      Iterable<Form> _tail = IterableExtensions.<Form>tail(_forms);
      Form _head = IterableExtensions.<Form>head(_tail);
      final QualifiedName name1 = this.namer.getFullyQualifiedName(_head);
      String _string = this.nameCvtr.toString(name1);
      Matcher<? super String> _is = Matchers.<String>is("x:f/1");
      MatcherAssert.<String>assertThat(_string, _is);
      EList<Form> _forms_1 = module.getForms();
      Iterable<Form> _tail_1 = IterableExtensions.<Form>tail(_forms_1);
      Iterable<Form> _tail_2 = IterableExtensions.<Form>tail(_tail_1);
      Form _head_1 = IterableExtensions.<Form>head(_tail_2);
      final QualifiedName name2 = this.namer.getFullyQualifiedName(_head_1);
      String _string_1 = this.nameCvtr.toString(name2);
      Matcher<? super String> _is_1 = Matchers.<String>is("x:f/0");
      MatcherAssert.<String>assertThat(_string_1, _is_1);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void functionClause() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("f(a) -> ok;");
      _builder.newLine();
      _builder.append("f(b) -> ok.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      EList<Form> _forms = module.getForms();
      Iterable<Form> _tail = IterableExtensions.<Form>tail(_forms);
      Form _head = IterableExtensions.<Form>head(_tail);
      final EList<FunctionClause> clauses = ((Function) _head).getClauses();
      FunctionClause _head_1 = IterableExtensions.<FunctionClause>head(clauses);
      final QualifiedName name1 = this.namer.getFullyQualifiedName(_head_1);
      String _string = this.nameCvtr.toString(name1);
      Matcher<? super String> _is = Matchers.<String>is("x:f/1:0");
      MatcherAssert.<String>assertThat(_string, _is);
      Iterable<FunctionClause> _tail_1 = IterableExtensions.<FunctionClause>tail(clauses);
      FunctionClause _head_2 = IterableExtensions.<FunctionClause>head(_tail_1);
      final QualifiedName name2 = this.namer.getFullyQualifiedName(_head_2);
      String _string_1 = this.nameCvtr.toString(name2);
      Matcher<? super String> _is_1 = Matchers.<String>is("x:f/1:1");
      MatcherAssert.<String>assertThat(_string_1, _is_1);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void functionInline() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("f() -> fun() -> ok end.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      EList<Form> _forms = module.getForms();
      Iterable<Form> _tail = IterableExtensions.<Form>tail(_forms);
      Form _head = IterableExtensions.<Form>head(_tail);
      EList<FunctionClause> _clauses = ((Function) _head).getClauses();
      FunctionClause _head_1 = IterableExtensions.<FunctionClause>head(_clauses);
      EList<Expression> _body = _head_1.getBody();
      Expression _head_2 = IterableExtensions.<Expression>head(_body);
      final FunExpr fun = ((FunExpr) _head_2);
      final QualifiedName name1 = this.namer.getFullyQualifiedName(fun);
      String _string = this.nameCvtr.toString(name1);
      Matcher<? super String> _is = Matchers.<String>is("x:f/0:0:fun_0");
      MatcherAssert.<String>assertThat(_string, _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void functionInline_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("f() -> ok, fun() -> ok end.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      EList<Form> _forms = module.getForms();
      Form _get = _forms.get(1);
      EList<FunctionClause> _clauses = ((Function) _get).getClauses();
      FunctionClause _head = IterableExtensions.<FunctionClause>head(_clauses);
      EList<Expression> _body = _head.getBody();
      Expression _get_1 = _body.get(1);
      final FunExpr fun = ((FunExpr) _get_1);
      final QualifiedName name1 = this.namer.getFullyQualifiedName(fun);
      String _string = this.nameCvtr.toString(name1);
      Matcher<? super String> _is = Matchers.<String>is("x:f/0:0:fun_1");
      MatcherAssert.<String>assertThat(_string, _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void functionClauseInline() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("f() -> fun() -> ok end.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      EList<Form> _forms = module.getForms();
      Iterable<Form> _tail = IterableExtensions.<Form>tail(_forms);
      Form _head = IterableExtensions.<Form>head(_tail);
      EList<FunctionClause> _clauses = ((Function) _head).getClauses();
      FunctionClause _head_1 = IterableExtensions.<FunctionClause>head(_clauses);
      EList<Expression> _body = _head_1.getBody();
      Expression _head_2 = IterableExtensions.<Expression>head(_body);
      final FunExpr fun = ((FunExpr) _head_2);
      EList<FunctionClause> _clauses_1 = fun.getClauses();
      FunctionClause _head_3 = IterableExtensions.<FunctionClause>head(_clauses_1);
      final QualifiedName name1 = this.namer.getFullyQualifiedName(_head_3);
      String _string = this.nameCvtr.toString(name1);
      Matcher<? super String> _is = Matchers.<String>is("x:f/0:0:fun_0:0");
      MatcherAssert.<String>assertThat(_string, _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void macroName() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-define(X, x).");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      EList<Form> _forms = module.getForms();
      Iterable<Form> _tail = IterableExtensions.<Form>tail(_forms);
      final Form obj = IterableExtensions.<Form>head(_tail);
      final QualifiedName name1 = this.namer.getFullyQualifiedName(obj);
      String _string = this.nameCvtr.toString(name1);
      Matcher<? super String> _is = Matchers.<String>is("x:?X");
      MatcherAssert.<String>assertThat(_string, _is);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
