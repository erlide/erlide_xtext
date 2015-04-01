package org.erlide.builder;

import com.google.inject.Injector;
import org.erlide.builder.BuilderPlugin;
import org.erlide.common.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

@SuppressWarnings("all")
public class BuilderExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {
  @Override
  protected Bundle getBundle() {
    BuilderPlugin _instance = BuilderPlugin.getInstance();
    return _instance.getBundle();
  }
  
  @Override
  protected Injector getInjector() {
    BuilderPlugin _instance = BuilderPlugin.getInstance();
    return _instance.getInjector();
  }
}
