package org.erlide.common;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class CommonPlugin extends AbstractErlidePlugin implements
        GuiceAwarePlugin {

    private static AbstractErlidePlugin instance;
    private Injector injector;

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

    @Override
    public Module getModule() {
        return new CommonModule();
    }

    @Override
    public Injector getInjector() {
        if (injector == null) {
            injector = createInjector();
        }
        return injector;
    }

    private Injector createInjector() {
        System.out.println("-------------");
        final IConfigurationElement[] cfgs = Platform.getExtensionRegistry()
                .getConfigurationElementsFor("org.erlide.common.guiceModule");
        for (final IConfigurationElement cfg : cfgs) {
            Module obj;
            try {
                obj = (Module) cfg.createExecutableExtension("class");
                System.out.println(obj.getClass().getName());
            } catch (final CoreException e) {
                e.printStackTrace();
            }
        }
        System.out.println("========");
        return Guice.createInjector();
    }

    public static AbstractErlidePlugin getInstance() {
        return instance;
    }

}
