package org.erlide.common;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class CommonPlugin extends Plugin {

    private static CommonPlugin instance;

    public CommonPlugin() {
        instance = this;
    }

    @Override
    public void start(final BundleContext aContext) throws Exception {
        super.start(aContext);
    }

    @Override
    public void stop(final BundleContext aContext) throws Exception {
        super.stop(aContext);
    }

    public static CommonPlugin getInstance() {
        return instance;
    }

}
