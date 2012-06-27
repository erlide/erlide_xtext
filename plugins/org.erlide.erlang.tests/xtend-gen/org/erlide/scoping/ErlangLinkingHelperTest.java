package org.erlide.scoping;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.lib.Pair;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.Atom;
import org.erlide.erlang.ErlangTestExtensions;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.util.ErlangTestingHelper;
import org.erlide.scoping.ErlangLinkCategory;
import org.erlide.scoping.ErlangLinkingHelper;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
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
  public void classify_noLink() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("[\u00A7ok, 0].");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.NONE);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_localCall() {
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
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.FUNCTION_CALL_LOCAL);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_localCall_spec() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("-spec \u00A7f() -> \'ok\'.");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("g(3),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.FUNCTION_CALL_LOCAL);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_remoteCall() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("w:\u00A7g(3),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.FUNCTION_CALL_REMOTE);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_remoteCall_moduleMacro() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("?MODULE:\u00A7g(3),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.FUNCTION_CALL_REMOTE);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_remoteCall_bad() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("W:\u00A7g(3),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.NONE);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_moduleCall() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\u00A7w:g(3),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.MODULE);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_moduleCall_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\u00A7w:G(3),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.MODULE);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_moduleRef() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fun \u00A7w:g/3,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.MODULE);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_functionRef_local() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fun \u00A7g/2,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.FUNCTION_REF_LOCAL);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_functionRef_remote() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fun w:\u00A7g/2,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.FUNCTION_REF_REMOTE);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_functionRef_moduleMacro() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fun ?MODULE:\u00A7g/2,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.FUNCTION_REF_REMOTE);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_functionRef_bad() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fun W:\u00A7g/2,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.NONE);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_record() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#\u00A7myrec{},");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.RECORD);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_record_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#\u00A7myrec.az,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.RECORD);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_recordField() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#myrec.\u00A7ff,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.RECORD_FIELD);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_recordField_bad() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#Myrec.\u00A7ff,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.NONE);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_recordField_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#myrec{\u00A7ff=2},");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.RECORD_FIELD);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
  
  @Test
  public void classify_recordField_1_bad() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#Myrec{\u00A7ff=2},");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    ErlangLinkCategory _classifyAtom = this._erlangLinkingHelper.classifyAtom(atom);
    Matcher<? super ErlangLinkCategory> _is = Matchers.<ErlangLinkCategory>is(ErlangLinkCategory.NONE);
    MatcherAssert.<ErlangLinkCategory>assertThat(_classifyAtom, _is);
  }
}
