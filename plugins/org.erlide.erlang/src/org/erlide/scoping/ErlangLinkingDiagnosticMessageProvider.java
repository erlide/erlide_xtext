package org.erlide.scoping;

import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.erlide.erlang.Atom;
import org.erlide.erlang.ModelExtensions;

import com.google.inject.Inject;

public class ErlangLinkingDiagnosticMessageProvider extends
        LinkingDiagnosticMessageProvider {

    @Inject
    ModelExtensions me;
    @Inject
    ErlangLinkingHelper linkHelper;

    @Override
    public DiagnosticMessage getUnresolvedProxyMessage(
            final ILinkingDiagnosticContext context) {
        final DiagnosticMessage org = super.getUnresolvedProxyMessage(context);
        if (org == null) {
            return null;
        }
        // if this isn't really a link that can be resolved, return null
        if (context.getContext() instanceof Atom) {
            final Atom atom = (Atom) context.getContext();
            final boolean linkableContext = linkHelper.isLinkableAtom(atom);
            if (linkableContext) {
                return org;
            }
        }
        return null;
    }
}
