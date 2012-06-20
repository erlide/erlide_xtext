package org.erlide.naming;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.AbstractErlangTests;
import org.erlide.erlang.Form;
import org.erlide.erlang.Module;
import org.erlide.erlang.util.ErlangTestingHelper;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = ErlangInjectorProvider.class)
@SuppressWarnings("all")
public class ErlangNamingTest extends AbstractErlangTests {
  @Inject
  private ErlangTestingHelper parser;
  
  @Inject
  private IQualifiedNameProvider namer;
  
  @Inject
  private IQualifiedNameConverter nameCvtr;
  
  @Test
  public void moduleName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(x).");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    Module _key = module.getKey();
    final QualifiedName name = this.namer.getFullyQualifiedName(_key);
    String _string = this.nameCvtr.toString(name);
    Matcher<? super String> _is = Matchers.<String>is("x");
    MatcherAssert.<String>assertThat(_string, _is);
  }
  
  @Test
  public void moduleNameQuoted() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(\'X\').");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    Module _key = module.getKey();
    final QualifiedName name = this.namer.getFullyQualifiedName(_key);
    String _string = this.nameCvtr.toString(name);
    Matcher<? super String> _is = Matchers.<String>is("\'X\'");
    MatcherAssert.<String>assertThat(_string, _is);
  }
  
  @Test
  public void headerName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-define(X, x).");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    Module _key = module.getKey();
    final QualifiedName name = this.namer.getFullyQualifiedName(_key);
    String _string = this.nameCvtr.toString(name);
    Matcher<? super String> _is = Matchers.<String>is("__synthetic0_erl");
    MatcherAssert.<String>assertThat(_string, _is);
  }
  
  @Test
  public void typeName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(x).");
    _builder.newLine();
    _builder.append("-type(y::integer()).");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    Module _key = module.getKey();
    EList<Form> _forms = _key.getForms();
    Iterable<Form> _tail = IterableExtensions.<Form>tail(_forms);
    Form _head = IterableExtensions.<Form>head(_tail);
    final QualifiedName name = this.namer.getFullyQualifiedName(_head);
    String _string = this.nameCvtr.toString(name);
    Matcher<? super String> _is = Matchers.<String>is("x:y");
    MatcherAssert.<String>assertThat(_string, _is);
  }
  
  @Test
  public void ifdef_name() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(x).");
    _builder.newLine();
    _builder.append("-ifdef(M).");
    _builder.newLine();
    _builder.append("\u00A7-record(y, {}).");
    _builder.newLine();
    _builder.append("-else.");
    _builder.newLine();
    _builder.append("\u00A7-record(y, {}).");
    _builder.newLine();
    _builder.append("-endif.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    List<Integer> _value = module.getValue();
    int _size = _value.size();
    Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(2));
    MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
    EObject _objectAtOffset = this.getObjectAtOffset(module, 0);
    final QualifiedName name1 = this.namer.getFullyQualifiedName(_objectAtOffset);
    String _string = this.nameCvtr.toString(name1);
    Matcher<? super String> _is_1 = Matchers.<String>is("x:y");
    MatcherAssert.<String>assertThat(_string, _is_1);
    EObject _objectAtOffset_1 = this.getObjectAtOffset(module, 1);
    final QualifiedName name2 = this.namer.getFullyQualifiedName(_objectAtOffset_1);
    String _string_1 = this.nameCvtr.toString(name2);
    Matcher<? super String> _is_2 = Matchers.<String>is("x:y");
    MatcherAssert.<String>assertThat(_string_1, _is_2);
  }
  
  @Test
  public void functionName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(x).");
    _builder.newLine();
    _builder.append("f() -> ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    Module _key = module.getKey();
    EList<Form> _forms = _key.getForms();
    Iterable<Form> _tail = IterableExtensions.<Form>tail(_forms);
    Form _head = IterableExtensions.<Form>head(_tail);
    final QualifiedName name = this.namer.getFullyQualifiedName(_head);
    String _string = this.nameCvtr.toString(name);
    Matcher<? super String> _is = Matchers.<String>is("x:f/0");
    MatcherAssert.<String>assertThat(_string, _is);
  }
  
  @Test
  public void functionName_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(x).");
    _builder.newLine();
    _builder.append("f(X) -> ok.");
    _builder.newLine();
    _builder.append("f() -> ok.");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    Module _key = module.getKey();
    EList<Form> _forms = _key.getForms();
    Iterable<Form> _tail = IterableExtensions.<Form>tail(_forms);
    Form _head = IterableExtensions.<Form>head(_tail);
    final QualifiedName name1 = this.namer.getFullyQualifiedName(_head);
    String _string = this.nameCvtr.toString(name1);
    Matcher<? super String> _is = Matchers.<String>is("x:f/1");
    MatcherAssert.<String>assertThat(_string, _is);
    Module _key_1 = module.getKey();
    EList<Form> _forms_1 = _key_1.getForms();
    Iterable<Form> _tail_1 = IterableExtensions.<Form>tail(_forms_1);
    Iterable<Form> _tail_2 = IterableExtensions.<Form>tail(_tail_1);
    Form _head_1 = IterableExtensions.<Form>head(_tail_2);
    final QualifiedName name2 = this.namer.getFullyQualifiedName(_head_1);
    String _string_1 = this.nameCvtr.toString(name2);
    Matcher<? super String> _is_1 = Matchers.<String>is("x:f/0");
    MatcherAssert.<String>assertThat(_string_1, _is_1);
  }
  
  @Test
  public void macroName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(x).");
    _builder.newLine();
    _builder.append("-define(X, x).");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    Module _key = module.getKey();
    EList<Form> _forms = _key.getForms();
    Iterable<Form> _tail = IterableExtensions.<Form>tail(_forms);
    final Form obj = IterableExtensions.<Form>head(_tail);
    final QualifiedName name1 = this.namer.getFullyQualifiedName(obj);
    String _string = this.nameCvtr.toString(name1);
    Matcher<? super String> _is = Matchers.<String>is("x:X");
    MatcherAssert.<String>assertThat(_string, _is);
  }
  
  @Test
  public void recordName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(x).");
    _builder.newLine();
    _builder.append("-record(y, {}).");
    _builder.newLine();
    final Pair<Module,List<Integer>> module = this.parser.parse(_builder.toString());
    Module _key = module.getKey();
    EList<Form> _forms = _key.getForms();
    Iterable<Form> _tail = IterableExtensions.<Form>tail(_forms);
    Form _head = IterableExtensions.<Form>head(_tail);
    final QualifiedName name = this.namer.getFullyQualifiedName(_head);
    String _string = this.nameCvtr.toString(name);
    Matcher<? super String> _is = Matchers.<String>is("x:y");
    MatcherAssert.<String>assertThat(_string, _is);
  }
}
