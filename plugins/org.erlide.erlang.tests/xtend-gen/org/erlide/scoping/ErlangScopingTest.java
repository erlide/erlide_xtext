package org.erlide.scoping;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.Module;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = ErlangInjectorProvider.class)
@SuppressWarnings("all")
public class ErlangScopingTest {
  @Inject
  private ParseHelper<Module> parser;
  
  @Inject
  private ResourceDescriptionsProvider indexProvider;
  
  @Test
  public void exportedFunctions() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-module(x).");
      _builder.newLine();
      _builder.append("f() -> ok.");
      _builder.newLine();
      _builder.append("g(X) -> X.");
      _builder.newLine();
      final Module module = this.parser.parse(_builder);
      final Resource res = module.eResource();
      final IResourceDescriptions descriptionIndex = this.indexProvider.getResourceDescriptions(res);
      URI _uRI = res.getURI();
      final IResourceDescription descr = descriptionIndex.getResourceDescription(_uRI);
      InputOutput.<IResourceDescription>println(descr);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
