package org.erlide.erlang;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Function;
import org.erlide.erlang.FunctionClause;
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
public class ElementExtensionsTest {
  @Inject
  private ParseHelper<Module> parser;
  
  @Inject
  private ModelExtensions _modelExtensions;
  
  @Test
  public void getModule() {
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
      Module _module = this._modelExtensions.getModule(ff);
      Matcher<? super Module> _is = Matchers.<Module>is(module);
      MatcherAssert.<Module>assertThat(_module, _is);
      EList<FunctionClause> _clauses = ff.getClauses();
      FunctionClause _head = IterableExtensions.<FunctionClause>head(_clauses);
      EList<Expression> _body = _head.getBody();
      final Expression fexpr = IterableExtensions.<Expression>head(_body);
      Module _module_1 = this._modelExtensions.getModule(fexpr);
      Matcher<? super Module> _is_1 = Matchers.<Module>is(module);
      MatcherAssert.<Module>assertThat(_module_1, _is_1);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
