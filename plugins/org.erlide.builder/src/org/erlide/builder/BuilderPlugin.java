package org.erlide.builder;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

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
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static BuilderPlugin getDefault() {
		return plugin;
	}

}
