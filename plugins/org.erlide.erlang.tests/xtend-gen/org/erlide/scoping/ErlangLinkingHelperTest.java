package org.erlide.scoping;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Pair;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.ErlangTestExtensions;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.util.ErlangTestingHelper;
import org.erlide.scoping.ErlangLinkCategory;
import org.erlide.scoping.ErlangLinkingHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = ErlangInjectorProvider.class)
@SuppressWarnings("all")
public class ErlangLinkingHelperTest {
  @Inject
  private ErlangTestingHelper parser;
  
  @Inject
  private ModelExtensions _modelExtensions;
  
  @Inject
  private ErlangLinkingHelper _erlangLinkingHelper;
  
  @Inject
  private ErlangTestExtensions _erlangTestExtensions;
  
  @Test
  public void macro() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("-define(X, x).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("g(\u00A7?X),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    _builder.append("g(X) -> ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    String _sourceText = this._modelExtensions.getSourceText(_objectAtMarker);
    InputOutput.<String>println(_sourceText);
    EObject _objectAtMarker_1 = this._erlangTestExtensions.getObjectAtMarker(module);
    EObject _eContainer = _objectAtMarker_1.eContainer();
    String _sourceText_1 = this._modelExtensions.getSourceText(_eContainer);
    InputOutput.<String>println(_sourceText_1);
    EObject _objectAtMarker_2 = this._erlangTestExtensions.getObjectAtMarker(module);
    ErlangLinkCategory _classify = this._erlangLinkingHelper.classify(_objectAtMarker_2);
    InputOutput.<ErlangLinkCategory>println(_classify);
  }
  
  @Test
  public void noLink() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\u00A7g(3),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    _builder.append("g(X) -> ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    String _sourceText = this._modelExtensions.getSourceText(_objectAtMarker);
    InputOutput.<String>println(_sourceText);
  }
}
