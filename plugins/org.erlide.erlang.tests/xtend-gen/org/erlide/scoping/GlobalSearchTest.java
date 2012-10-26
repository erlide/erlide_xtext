package org.erlide.scoping;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.Form;
import org.erlide.erlang.Function;
import org.erlide.erlang.Module;
import org.erlide.erlang.ScopeExtensions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = ErlangInjectorProvider.class)
@SuppressWarnings("all")
public class GlobalSearchTest {
  @Inject
  private ParseHelper<Module> parser;
  
  @Inject
  private IQualifiedNameConverter cvtr;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private ScopeExtensions _scopeExtensions;
  
  @Test
  public void canFindFunction() {
    try {
      final ResourceSet set = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("-export([f/0]).");
      _builder.newLine();
      _builder.append("g(X) -> X.");
      _builder.newLine();
      _builder.append("f() -> ok.");
      _builder.newLine();
      final Module module_x = this.parser.parse(_builder, set);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("-module(z).");
      _builder_1.newLine();
      _builder_1.append("-export([f/0]).");
      _builder_1.newLine();
      _builder_1.append("g(X) -> X.");
      _builder_1.newLine();
      _builder_1.append("f() -> ok.");
      _builder_1.newLine();
      final Module module_z = this.parser.parse(_builder_1, set);
      final Iterable<IEObjectDescription> eFuns_x = this._scopeExtensions.getExportedFunctions(module_x);
      final Iterable<IEObjectDescription> eFuns_z = this._scopeExtensions.getExportedFunctions(module_z);
      EList<Form> _forms = module_x.getForms();
      final Function1<Form,Boolean> _function = new Function1<Form,Boolean>() {
          public Boolean apply(final Form it) {
            Class<? extends Object> _class = it.getClass();
            boolean _isAssignableFrom = Function.class.isAssignableFrom(_class);
            return Boolean.valueOf(_isAssignableFrom);
          }
        };
      Form _findFirst = IterableExtensions.<Form>findFirst(_forms, _function);
      final Function f1 = ((Function) _findFirst);
      InputOutput.<Function>println(f1);
      InputOutput.<ResourceSet>println(set);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
