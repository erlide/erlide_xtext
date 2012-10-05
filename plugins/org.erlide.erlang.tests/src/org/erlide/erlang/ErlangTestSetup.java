package org.erlide.erlang;

import org.eclipse.xtext.resource.SynchronizedXtextResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.erlide.ErlangRuntimeModule;
import org.erlide.ErlangStandaloneSetup;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.util.Modules;

public class ErlangTestSetup extends ErlangStandaloneSetup {
    public static class ErlangTestModule extends AbstractGenericModule {

        public com.google.inject.Provider<XtextResourceSet> provideXtextResourceSet() {
            return new Provider<XtextResourceSet>() {

                @Override
                public XtextResourceSet get() {
                    final XtextResourceSet resourceSet = new SynchronizedXtextResourceSet();
                    return resourceSet;
                }

            };
        }

    }

    @Override
    public Injector createInjector() {
        return Guice.createInjector(Modules.override(new ErlangRuntimeModule())
                .with(new ErlangTestModule()));
    }
}
