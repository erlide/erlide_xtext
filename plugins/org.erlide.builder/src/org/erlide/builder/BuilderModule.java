package org.erlide.builder;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.xtext.service.AbstractGenericModule;

import com.google.common.eventbus.EventBus;
import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

public class BuilderModule extends AbstractGenericModule {

    public Provider<IWorkspace> provideIWorkspace() {
        return new Provider<IWorkspace>() {
            @Override
            public IWorkspace get() {
                return ResourcesPlugin.getWorkspace();
            }
        };
    }

    private final EventBus builderEventBus = new EventBus("erlangBuilder");

    @Override
    public void configure(final Binder binder) {
        super.configure(binder);
        binder.bind(EventBus.class).annotatedWith(Names.named("erlangBuilder"))
                .toInstance(builderEventBus);

        // do this to automatically register all injected objects with the event
        // bus
        binder.bindListener(Matchers.any(), new TypeListener() {
            @Override
            public <I> void hear(final TypeLiteral<I> typeLiteral,
                    final TypeEncounter<I> typeEncounter) {
                typeEncounter.register(new InjectionListener<I>() {
                    @Override
                    public void afterInjection(final I i) {
                        // builderEventBus.register(i);
                    }
                });
            }
        });

    }

}
