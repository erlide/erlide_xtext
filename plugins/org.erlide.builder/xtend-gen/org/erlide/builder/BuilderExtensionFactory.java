package org.erlide.builder;

import com.google.inject.Injector;
import org.erlide.builder.BuilderPlugin;
import org.erlide.common.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

@SuppressWarnings("all")
public class BuilderExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {
  protected Bundle getBundle() {
    BuilderPlugin _instance = BuilderPlugin.getInstance();
    Bundle _bundle = _instance.getBundle();
    return _bundle;
  }
  
  protected Injector getInjector() {
    BuilderPlugin _instance = BuilderPlugin.getInstance();
    Injector _injector = _instance.getInjector();
    return _injector;
  }
}
