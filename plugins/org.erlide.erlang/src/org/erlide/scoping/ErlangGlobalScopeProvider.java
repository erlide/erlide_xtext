package org.erlide.scoping;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

public class ErlangGlobalScopeProvider extends AbstractGlobalScopeProvider {

    @Inject
    ImportUriGlobalScopeProvider uriScopeProvider;
    @Inject
    DefaultGlobalScopeProvider pathScopeProvider;

    @Override
    public IScope getScope(final Resource context, final EReference reference,
            final Predicate<IEObjectDescription> filter) {

        final IScope x = uriScopeProvider.getScope(context, reference, filter);
        final IScope y = pathScopeProvider.getScope(context, reference, filter);

        return x;
    }

}
