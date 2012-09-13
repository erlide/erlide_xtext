package org.erlide.builder;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.xtext.service.AbstractGenericModule;

import com.google.common.eventbus.EventBus;
import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.name.Names;

public class BuilderModule extends AbstractGenericModule {

    public Provider<IWorkspace> provideIWorkspace() {
        return new Provider<IWorkspace>() {
            @Override
            public IWorkspace get() {
                return ResourcesPlugin.getWorkspace();
            }
        };
    }

    @Override
    public void configure(final Binder binder) {
        super.configure(binder);
        binder.bind(EventBus.class).annotatedWith(Names.named("erlangBuilder"))
                .toInstance(new EventBus("erlangBuilder"));
    }

}
