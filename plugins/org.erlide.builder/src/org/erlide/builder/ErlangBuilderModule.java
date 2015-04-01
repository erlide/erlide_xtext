package org.erlide.builder;

import org.eclipse.core.resources.IncrementalProjectBuilder;

import com.google.inject.Binder;
import com.google.inject.Module;

public class ErlangBuilderModule implements Module {

    public ErlangBuilderModule() {
    }

    @Override
    public void configure(final Binder binder) {
        binder.bind(IncrementalProjectBuilder.class).to(
                ErlideXtextBuilder.class);
    }

}
