package org.erlide.builder;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.erlide.builder.IErlangBuilder;
import org.erlide.builder.resourcecompiler.ErlCompiler;

@SuppressWarnings("all")
public class BuildersProvider {
  private Map<String,IErlangBuilder> builders;
  
  public BuildersProvider() {
    HashMap<String,IErlangBuilder> _newHashMap = CollectionLiterals.<String, IErlangBuilder>newHashMap();
    this.builders = _newHashMap;
  }
  
  protected void loadBuilders() {
    final IExtensionRegistry reg = Platform.getExtensionRegistry();
    final IConfigurationElement[] elements = reg.getConfigurationElementsFor("org.erlide.builder.builders");
    for (final IConfigurationElement element : elements) {
      try {
        Object _createExecutableExtension = element.createExecutableExtension("class");
        final IErlangBuilder builder = ((IErlangBuilder) _createExecutableExtension);
        builder.loadConfiguration();
      } catch (final Throwable _t) {
        if (_t instanceof CoreException) {
          final CoreException e = (CoreException)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }
  
  public String getBuilderId(final IProject project) {
    return ErlCompiler.COMPILER_ID;
  }
  
  public IErlangBuilder get(final String id) {
    IErlangBuilder _xblockexpression = null;
    {
      boolean _isEmpty = this.builders.isEmpty();
      if (_isEmpty) {
        this.loadBuilders();
      }
      IErlangBuilder _get = this.builders.get(id);
      _xblockexpression = (_get);
    }
    return _xblockexpression;
  }
}
