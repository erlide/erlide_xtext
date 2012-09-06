package org.erlide.builder;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.xtext.service.AbstractGenericModule;

import com.google.inject.Provider;

public class BuilderModule extends AbstractGenericModule {

    public Provider<IWorkspace> provideIWorkspace() {
        return new Provider<IWorkspace>() {
            @Override
            public IWorkspace get() {
                return ResourcesPlugin.getWorkspace();
            }
        };
    }

}
