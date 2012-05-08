package org.erlide.project.internal;

import org.erlide.common.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

public class ErlideProjectExecutableExtensionFactory extends
        AbstractGuiceAwareExecutableExtensionFactory {

    @Override
    protected Bundle getBundle() {
        return null; // ErlangProjectPlugin.context.getBundle();
    }

    @Override
    protected Injector getInjector() {
        return null;// ErlangProjectPlugin.getInjector();
    }

}
