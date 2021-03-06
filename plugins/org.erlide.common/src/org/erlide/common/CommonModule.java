package org.erlide.common;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.service.AbstractGenericModule;

import com.google.inject.Provider;

public class CommonModule extends AbstractGenericModule {

    public CommonModule() {
    }

    public Provider<IWorkspace> provideIWorkspace() {
        return new Provider<IWorkspace>() {
            @Override
            public IWorkspace get() {
                return ResourcesPlugin.getWorkspace();
            }
        };
    }

    public Provider<IAdapterManager> provideIAdapterManager() {
        return new Provider<IAdapterManager>() {
            @Override
            public IAdapterManager get() {
                return Platform.getAdapterManager();
            }
        };
    }
    // public void configureIWorkbench(final Binder binder) {
    // if (PlatformUI.isWorkbenchRunning()) {
    // binder.bind(IWorkbench.class).toProvider(
    // new Provider<IWorkbench>() {
    // public IWorkbench get() {
    // return PlatformUI.isWorkbenchRunning() ? PlatformUI
    // .getWorkbench() : null;
    // }
    // });
    // }
    // }

}
