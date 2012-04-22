package org.erlide.project.internal;

import org.erlide.common.AbstractErlidePlugin;
import org.erlide.project.ErlideProjectModule;
import org.osgi.framework.BundleContext;

import com.google.inject.Module;

public class ErlangProjectPlugin extends AbstractErlidePlugin {

    @Override
    public void start(final BundleContext theContext) throws Exception {
        super.start(theContext);
    }

    @Override
    public void stop(final BundleContext theContext) throws Exception {
        super.stop(theContext);
    }

    @Override
    public Module getModule() {
        return new ErlideProjectModule();
    }

}
