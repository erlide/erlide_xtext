package org.erlide.builder;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * The activator class controls the plug-in life cycle
 */
public class BuilderPlugin extends Plugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "org.erlide.builder"; //$NON-NLS-1$

    // The shared instance
    private static BuilderPlugin plugin;

    public BuilderPlugin() {
    }

    @Override
    public void start(final BundleContext context) throws Exception {
        super.start(context);
        plugin = this;

        final BuildersProvider builderProvider = getInjector().getInstance(
                BuildersProvider.class);
        builderProvider.loadBuilders();
    }

    @Override
    public void stop(final BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static BuilderPlugin getInstance() {
        return plugin;
    }

    public Injector getInjector() {
        return Guice.createInjector(new BuilderModule());
    }
}
