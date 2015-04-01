package org.erlide.scoping;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pair;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.Atom;
import org.erlide.erlang.AtomRefTarget;
import org.erlide.erlang.ErlangTestExtensions;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.util.ErlangTestingHelper;
import org.erlide.scoping.ErlangLinkingHelper;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(ErlangInjectorProvider.class)
@SuppressWarnings("all")
public class ErlangLinkingTest extends AbstractXtextTests {
  @Inject
  private ErlangTestingHelper parser;
  
  @Inject
  @Extension
  private ModelExtensions _modelExtensions;
  
  @Inject
  @Extension
  private ErlangLinkingHelper _erlangLinkingHelper;
  
  @Inject
  @Extension
  private ErlangTestExtensions _erlangTestExtensions;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Test
  public void resolve_noLink() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("[�ok, 0].");
    _builder.newLine();
    final Pair<Module, List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    AtomRefTarget _atomReference = this._erlangLinkingHelper.getAtomReference(atom);
    Matcher<AtomRefTarget> _nullValue = Matchers.<AtomRefTarget>nullValue();
    Matcher<AtomRefTarget> _is = Matchers.<AtomRefTarget>is(_nullValue);
    Assert.<AtomRefTarget>assertThat(_atomReference, _is);
  }
  
  @Test
  public void resolve_localCall() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void resolve_localCall_spec() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void resolve_remoteCall() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void resolve_remoteCall_2() {
    final XtextResourceSet rset = this.resourceSetProvider.get();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("w:�g(3),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module, List<Integer>> module = this.parser.parse(_builder.toString(), "m.erl", rset);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("-module(w).");
    _builder_1.newLine();
    _builder_1.append("-export([g/1]).");
    _builder_1.newLine();
    _builder_1.append("�g(X) -> ok.");
    _builder_1.newLine();
    final Pair<Module, List<Integer>> module2 = this.parser.parse(_builder_1.toString(), "w.erl", rset);
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    final EObject tgt = this._erlangTestExtensions.getObjectAtMarker(module2);
    AtomRefTarget _atomReference = this._erlangLinkingHelper.getAtomReference(atom);
    Matcher<? super EObject> _is = Matchers.<EObject>is(tgt);
    Assert.<EObject>assertThat(_atomReference, _is);
  }
  
  @Test
  public void resolve_remoteCall_bad_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("m:�g(3),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    _builder.append("g(X) -> ok.");
    _builder.newLine();
    final Pair<Module, List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    AtomRefTarget _atomReference = this._erlangLinkingHelper.getAtomReference(atom);
    Matcher<AtomRefTarget> _nullValue = Matchers.<AtomRefTarget>nullValue();
    Matcher<AtomRefTarget> _is = Matchers.<AtomRefTarget>is(_nullValue);
    Assert.<AtomRefTarget>assertThat(_atomReference, _is);
  }
  
  @Test
  public void resolve_remoteCall_moduleMacro() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void resolve_remoteCall_bad() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("W:�g(3),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module, List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    AtomRefTarget _atomReference = this._erlangLinkingHelper.getAtomReference(atom);
    Matcher<AtomRefTarget> _nullValue = Matchers.<AtomRefTarget>nullValue();
    Matcher<AtomRefTarget> _is = Matchers.<AtomRefTarget>is(_nullValue);
    Assert.<AtomRefTarget>assertThat(_atomReference, _is);
  }
  
  @Test
  public void resolve_remoteCall_moduleMacro_bad() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("?MODULE:�g(3),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    _builder.append("�g(X) -> X.");
    _builder.newLine();
    final Pair<Module, List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    AtomRefTarget _atomReference = this._erlangLinkingHelper.getAtomReference(atom);
    Matcher<AtomRefTarget> _nullValue = Matchers.<AtomRefTarget>nullValue();
    Matcher<AtomRefTarget> _is = Matchers.<AtomRefTarget>is(_nullValue);
    Assert.<AtomRefTarget>assertThat(_atomReference, _is);
  }
  
  @Test
  public void resolve_moduleCall() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void resolve_moduleCall_1() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void resolve_moduleRef() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fun �w:g/3,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module, List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    AtomRefTarget _atomReference = this._erlangLinkingHelper.getAtomReference(atom);
    Matcher<AtomRefTarget> _nullValue = Matchers.<AtomRefTarget>nullValue();
    Matcher<AtomRefTarget> _is = Matchers.<AtomRefTarget>is(_nullValue);
    Assert.<AtomRefTarget>assertThat(_atomReference, _is);
  }
  
  @Test
  public void resolve_functionRef_local() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void resolve_functionRef_remote() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void resolve_functionRef_remote_bad() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fun m:�g/2,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    _builder.append("�g(X,Y) -> ok.");
    _builder.newLine();
    final Pair<Module, List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    AtomRefTarget _atomReference = this._erlangLinkingHelper.getAtomReference(atom);
    Matcher<AtomRefTarget> _nullValue = Matchers.<AtomRefTarget>nullValue();
    Matcher<AtomRefTarget> _is = Matchers.<AtomRefTarget>is(_nullValue);
    Assert.<AtomRefTarget>assertThat(_atomReference, _is);
  }
  
  @Test
  public void resolve_functionRef_remote_2() {
    final XtextResourceSet rset = this.resourceSetProvider.get();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fun w:�g/2,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module, List<Integer>> module = this.parser.parse(_builder.toString(), "m.erl", rset);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("-module(w).");
    _builder_1.newLine();
    _builder_1.append("-export([g/2]).");
    _builder_1.newLine();
    _builder_1.append("�g(X,Y) -> ok.");
    _builder_1.newLine();
    final Pair<Module, List<Integer>> module2 = this.parser.parse(_builder_1.toString(), "w.erl", rset);
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    final EObject tgt = this._erlangTestExtensions.getObjectAtMarker(module2);
    AtomRefTarget _atomReference = this._erlangLinkingHelper.getAtomReference(atom);
    Matcher<? super EObject> _is = Matchers.<EObject>is(tgt);
    Assert.<EObject>assertThat(_atomReference, _is);
  }
  
  @Test
  public void resolve_functionRef_remote_2_bad() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fun w:�g/2,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module, List<Integer>> module = this.parser.parse(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("-module(m).");
    _builder_1.newLine();
    _builder_1.append("�g(X,Y) -> ok.");
    _builder_1.newLine();
    final Pair<Module, List<Integer>> module2 = this.parser.parse(_builder_1.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    AtomRefTarget _atomReference = this._erlangLinkingHelper.getAtomReference(atom);
    Matcher<AtomRefTarget> _nullValue = Matchers.<AtomRefTarget>nullValue();
    Matcher<AtomRefTarget> _is = Matchers.<AtomRefTarget>is(_nullValue);
    Assert.<AtomRefTarget>assertThat(_atomReference, _is);
  }
  
  @Test
  public void resolve_functionRef_moduleMacro() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void resolve_functionRef_bad() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fun W:�g/2,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module, List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    AtomRefTarget _atomReference = this._erlangLinkingHelper.getAtomReference(atom);
    Matcher<AtomRefTarget> _nullValue = Matchers.<AtomRefTarget>nullValue();
    Matcher<AtomRefTarget> _is = Matchers.<AtomRefTarget>is(_nullValue);
    Assert.<AtomRefTarget>assertThat(_atomReference, _is);
  }
  
  @Test
  public void resolve_record() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void resolve_record_bad() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void resolve_record_1() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void resolve_recordField() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void resolve_recordField_bad() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#Myrec.�ff,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module, List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    AtomRefTarget _atomReference = this._erlangLinkingHelper.getAtomReference(atom);
    Matcher<AtomRefTarget> _nullValue = Matchers.<AtomRefTarget>nullValue();
    Matcher<AtomRefTarget> _is = Matchers.<AtomRefTarget>is(_nullValue);
    Assert.<AtomRefTarget>assertThat(_atomReference, _is);
  }
  
  @Test
  public void resolve_recordField_bad_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("-record(myrec, {gg}).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#myrec.�ff,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module, List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    AtomRefTarget _atomReference = this._erlangLinkingHelper.getAtomReference(atom);
    Matcher<AtomRefTarget> _nullValue = Matchers.<AtomRefTarget>nullValue();
    Matcher<AtomRefTarget> _is = Matchers.<AtomRefTarget>is(_nullValue);
    Assert.<AtomRefTarget>assertThat(_atomReference, _is);
  }
  
  @Test
  public void resolve_recordField_1() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void resolve_recordField_1_bad() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(m).");
    _builder.newLine();
    _builder.append("-record(myrec, {gg}).");
    _builder.newLine();
    _builder.append("f() ->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#Myrec{�ff=2},");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ok.");
    _builder.newLine();
    final Pair<Module, List<Integer>> module = this.parser.parse(_builder.toString());
    EObject _objectAtMarker = this._erlangTestExtensions.getObjectAtMarker(module);
    final Atom atom = ((Atom) _objectAtMarker);
    AtomRefTarget _atomReference = this._erlangLinkingHelper.getAtomReference(atom);
    Matcher<AtomRefTarget> _nullValue = Matchers.<AtomRefTarget>nullValue();
    Matcher<AtomRefTarget> _is = Matchers.<AtomRefTarget>is(_nullValue);
    Assert.<AtomRefTarget>assertThat(_atomReference, _is);
  }
  
  @Test
  public void resolve_macro() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void resolve_macro_atom() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void resolve_macro_1() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void resolve_macro_1_atom() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
}
