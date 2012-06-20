package org.erlide.erlang;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.Atom;
import org.erlide.erlang.CustomAttribute;
import org.erlide.erlang.DefineAttribute;
import org.erlide.erlang.ErlList;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Form;
import org.erlide.erlang.Function;
import org.erlide.erlang.FunctionClause;
import org.erlide.erlang.Module;
import org.erlide.erlang.ModuleAttribute;
import org.erlide.erlang.RecordAttribute;
import org.erlide.erlang.SpecAttribute;
import org.erlide.erlang.TypeAttribute;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = ErlangInjectorProvider.class)
@SuppressWarnings("all")
public class ParserTest {
  @Inject
  private ParseHelper<Module> parser;
  
  @Test
  public void moduleAttributeTest() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      final Module model = this.parser.parse(_builder);
      EList<Form> _forms = model.getForms();
      Form _head = IterableExtensions.<Form>head(_forms);
      final ModuleAttribute entity = ((ModuleAttribute) _head);
      String _tag = entity.getTag();
      Assert.assertEquals(_tag, "module");
      final String mod = entity.getModuleName();
      Assert.assertEquals(mod, "x");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void moduleAttributeTest1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("x+1.");
      _builder.newLine();
      final Module model = this.parser.parse(_builder);
      InputOutput.<Module>print(model);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void specAttributeTest() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-spec f()-> void().");
      _builder.newLine();
      final Module model = this.parser.parse(_builder);
      EList<Form> _forms = model.getForms();
      Form _head = IterableExtensions.<Form>head(_forms);
      final SpecAttribute entity = ((SpecAttribute) _head);
      String _tag = entity.getTag();
      Assert.assertEquals(_tag, "spec");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void typeAttributeTest() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-type myType() :: integer().");
      _builder.newLine();
      final Module model = this.parser.parse(_builder);
      EList<Form> _forms = model.getForms();
      Form _head = IterableExtensions.<Form>head(_forms);
      final TypeAttribute entity = ((TypeAttribute) _head);
      String _tag = entity.getTag();
      Assert.assertEquals(_tag, "type");
      final String key = entity.getName();
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void recordAttributeTest() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-record(x, {a, b}).");
      _builder.newLine();
      final Module model = this.parser.parse(_builder);
      EList<Form> _forms = model.getForms();
      Form _head = IterableExtensions.<Form>head(_forms);
      final RecordAttribute entity = ((RecordAttribute) _head);
      String _tag = entity.getTag();
      Assert.assertEquals(_tag, "record");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void defineAttributeTest_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-define(X, ofx, abb). ");
      _builder.newLine();
      final Module model = this.parser.parse(_builder);
      EList<Form> _forms = model.getForms();
      Form _head = IterableExtensions.<Form>head(_forms);
      final DefineAttribute entity = ((DefineAttribute) _head);
      String _tag = entity.getTag();
      Assert.assertEquals(_tag, "define");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void defineAttributeTest_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-define(X).");
      _builder.newLine();
      final Module model = this.parser.parse(_builder);
      EList<Form> _forms = model.getForms();
      Form _head = IterableExtensions.<Form>head(_forms);
      final DefineAttribute entity = ((DefineAttribute) _head);
      String _tag = entity.getTag();
      Assert.assertEquals(_tag, "define");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genericAttributeTest_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-myTag([x, aa, bb]).");
      _builder.newLine();
      final Module model = this.parser.parse(_builder);
      EList<Form> _forms = model.getForms();
      Form _head = IterableExtensions.<Form>head(_forms);
      final CustomAttribute entity = ((CustomAttribute) _head);
      String _tag = entity.getTag();
      Assert.assertEquals(_tag, "myTag");
      final EList<Expression> mod = entity.getValue();
      Expression _get = mod.get(0);
      Assert.assertTrue((_get instanceof ErlList));
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void LineAttributeTest_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("f() -> ?line ok, ok, ?line ok.");
      _builder.newLine();
      final Module model = this.parser.parse(_builder);
      EList<Form> _forms = model.getForms();
      Form _head = IterableExtensions.<Form>head(_forms);
      final Function fun = ((Function) _head);
      EList<FunctionClause> _clauses = fun.getClauses();
      FunctionClause _head_1 = IterableExtensions.<FunctionClause>head(_clauses);
      final EList<Expression> body = _head_1.getBody();
      int _size = body.size();
      Assert.assertEquals(3, _size);
      Expression _head_2 = IterableExtensions.<Expression>head(body);
      boolean _isLine = _head_2.isLine();
      Assert.assertTrue(_isLine);
      Iterable<Expression> _tail = IterableExtensions.<Expression>tail(body);
      Expression _head_3 = IterableExtensions.<Expression>head(_tail);
      boolean _isLine_1 = _head_3.isLine();
      Assert.assertFalse(_isLine_1);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void fullStopTest_1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("f() -> ok.% comment");
      _builder.newLine();
      final Module model = this.parser.parse(_builder);
      EList<Form> _forms = model.getForms();
      Form _head = IterableExtensions.<Form>head(_forms);
      final Function fun = ((Function) _head);
      EList<FunctionClause> _clauses = fun.getClauses();
      FunctionClause _head_1 = IterableExtensions.<FunctionClause>head(_clauses);
      final EList<Expression> body = _head_1.getBody();
      int _size = body.size();
      Assert.assertEquals(1, _size);
      final Expression expr = IterableExtensions.<Expression>head(body);
      Assert.assertTrue((expr instanceof Atom));
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void fullStopTest_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("f() -> ok.");
      final Module model = this.parser.parse(_builder);
      EList<Form> _forms = model.getForms();
      Form _head = IterableExtensions.<Form>head(_forms);
      final Function fun = ((Function) _head);
      EList<FunctionClause> _clauses = fun.getClauses();
      FunctionClause _head_1 = IterableExtensions.<FunctionClause>head(_clauses);
      final EList<Expression> body = _head_1.getBody();
      int _size = body.size();
      Assert.assertEquals(1, _size);
      final Expression expr = IterableExtensions.<Expression>head(body);
      Assert.assertTrue((expr instanceof Atom));
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
