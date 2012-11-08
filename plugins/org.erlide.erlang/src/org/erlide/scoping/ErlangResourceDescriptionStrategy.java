package org.erlide.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;

import com.google.inject.Inject;

public class ErlangResourceDescriptionStrategy extends
        DefaultResourceDescriptionStrategy {

    @Inject
    private ModelExtensions modelExtensions;

    @Override
    public boolean createEObjectDescriptions(final EObject eObject,
            final IAcceptor<IEObjectDescription> acceptor) {
        if (getQualifiedNameProvider() == null) {
            return false;
        }
        // System.out.println("??? " + eObject);
        try {
            if (eObject instanceof Module) {
                final QualifiedName qualifiedName = getQualifiedNameProvider()
                        .getFullyQualifiedName(eObject);
                if (qualifiedName == null) {
                    System.out.println("ERR> null qname for " + eObject);
                } else {
                    // System.out.println("=== " + qualifiedName);
                    acceptor.accept(EObjectDescription.create(qualifiedName,
                            eObject));
                }
            }
        } catch (final Exception exc) {
            exc.printStackTrace();
        }
        return true;
    }

}
