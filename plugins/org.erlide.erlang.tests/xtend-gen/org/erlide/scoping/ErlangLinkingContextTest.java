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
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.scoping.ErlangLinkingHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(ErlangInjectorProvider.class)
@SuppressWarnings("all")
public class ErlangLinkingContextTest {
  @Inject
  private ParseHelper<Module> parser;
  
  @Inject
  @Extension
  private ModelExtensions _modelExtensions;
  
  @Inject
  @Extension
  private ErlangLinkingHelper _erlangLinkingHelper;
  
  @Test
  public void simpleAtom() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(m).");
      _builder.newLine();
      _builder.append("f() ->");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("g(3),");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ok.");
      _builder.newLine();
      _builder.append("g(X) -> ok.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      Resource _eResource = module.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
        @Override
        public Boolean apply(final EObject it) {
          EList<EObject> _eCrossReferences = it.eCrossReferences();
          boolean _isEmpty = _eCrossReferences.isEmpty();
          return Boolean.valueOf((!_isEmpty));
        }
      };
      Iterator<EObject> _filter = IteratorExtensions.<EObject>filter(_allContents, _function);
      final Function1<EObject, EObject> _function_1 = new Function1<EObject, EObject>() {
        @Override
        public EObject apply(final EObject it) {
          EList<EObject> _eCrossReferences = it.eCrossReferences();
          return IterableExtensions.<EObject>head(_eCrossReferences);
        }
      };
      Iterator<EObject> _map = IteratorExtensions.<EObject, EObject>map(_filter, _function_1);
      final Function1<EObject, Boolean> _function_2 = new Function1<EObject, Boolean>() {
        @Override
        public Boolean apply(final EObject it) {
          boolean _eIsProxy = it.eIsProxy();
          return Boolean.valueOf((!_eIsProxy));
        }
      };
      Iterator<EObject> _filter_1 = IteratorExtensions.<EObject>filter(_map, _function_2);
      final List<EObject> refs = IteratorExtensions.<EObject>toList(_filter_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
