package org.erlide.naming;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pair;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.ErlangTestExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.util.ErlangTestingHelper;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(ErlangInjectorProvider.class)
@SuppressWarnings("all")
public class ErlangNamingTest {
  @Inject
  private ErlangTestingHelper parser;
  
  @Inject
  private IQualifiedNameProvider namer;
  
  @Inject
  private IQualifiedNameConverter nameCvtr;
  
  @Inject
  @Extension
  private ErlangTestExtensions _erlangTestExtensions;
  
  @Test
  public void moduleName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module(x).");
    _builder.newLine();
    final Pair<Module, List<Integer>> module = this.parser.parse(_builder.toString());
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
    final Pair<Module, List<Integer>> module = this.parser.parse(_builder.toString());
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
    final Pair<Module, List<Integer>> module = this.parser.parse(_builder.toString());
    Module _key = module.getKey();
    final QualifiedName name = this.namer.getFullyQualifiedName(_key);
    String _string = this.nameCvtr.toString(name);
    Matcher<? super String> _is = Matchers.<String>is("__synthetic0_erl");
    MatcherAssert.<String>assertThat(_string, _is);
  }
  
  @Test
  public void typeName() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void ifdef_name() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void exportedFunctionName() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void localFunctionName() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void exportedFunctionName_1() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void macroName() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void recordName() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
  
  @Test
  public void recordName_quoted() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Pair<Module, List<Integer>> to Pair<Module, List<Integer>>");
  }
}
