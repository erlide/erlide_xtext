package org.erlide.common;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Injector;

public abstract class AbstractErlidePlugin extends Plugin implements
        GuiceAwarePlugin {

    @Override
    public void start(final BundleContext aContext) throws Exception {
        super.start(aContext);
    }

    @Override
    public void stop(final BundleContext aContext) throws Exception {
        super.stop(aContext);
    }

    @Override
    public Injector getInjector() {
        return CommonPlugin.getInstance().getInjector();
    }

}
