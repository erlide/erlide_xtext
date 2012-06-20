package org.erlide.scoping;

import com.google.inject.Inject;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.AbstractErlangTests;
import org.erlide.erlang.Function;
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
public class ErlangLinkingTest extends AbstractErlangTests {
  @Inject
  private ParseHelper<Module> parser;
  
  @Inject
  private IQualifiedNameConverter cvtr;
  
  @Inject
  private ModelExtensions _modelExtensions;
  
  @Test
  public void funcallRef() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(m).");
      _builder.newLine();
      _builder.append("f() ->");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("m:g(3),");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("g(3).");
      _builder.newLine();
      _builder.append("g(X) -> ok.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      Resource _eResource = module.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      final Function1<EObject,Boolean> _function = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject it) {
            EList<EObject> _eCrossReferences = it.eCrossReferences();
            boolean _isEmpty = _eCrossReferences.isEmpty();
            boolean _not = (!_isEmpty);
            return Boolean.valueOf(_not);
          }
        };
      Iterator<EObject> _filter = IteratorExtensions.<EObject>filter(_allContents, _function);
      final Function1<EObject,EObject> _function_1 = new Function1<EObject,EObject>() {
          public EObject apply(final EObject it) {
            EList<EObject> _eCrossReferences = it.eCrossReferences();
            EObject _head = IterableExtensions.<EObject>head(_eCrossReferences);
            return _head;
          }
        };
      Iterator<EObject> _map = IteratorExtensions.<EObject, EObject>map(_filter, _function_1);
      final Function1<EObject,Boolean> _function_2 = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject it) {
            boolean _eIsProxy = it.eIsProxy();
            boolean _not = (!_eIsProxy);
            return Boolean.valueOf(_not);
          }
        };
      Iterator<EObject> _filter_1 = IteratorExtensions.<EObject>filter(_map, _function_2);
      final List<EObject> refs = IteratorExtensions.<EObject>toList(_filter_1);
      int _size = refs.size();
      Matcher<? super Integer> _is = Matchers.<Integer>is(Integer.valueOf(1));
      MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is);
      EObject _head = IterableExtensions.<EObject>head(refs);
      Matcher<EObject> _instanceOf = Matchers.<EObject>instanceOf(Function.class);
      Matcher<EObject> _is_1 = Matchers.<EObject>is(_instanceOf);
      MatcherAssert.<EObject>assertThat(_head, _is_1);
      EObject _head_1 = IterableExtensions.<EObject>head(refs);
      Function _function_3 = this._modelExtensions.getFunction(module, "g", 1);
      Matcher<? super Function> _is_2 = Matchers.<Function>is(_function_3);
      MatcherAssert.<Function>assertThat(((Function) _head_1), _is_2);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
