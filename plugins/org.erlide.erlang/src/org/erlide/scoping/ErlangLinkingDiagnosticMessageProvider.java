package org.erlide.scoping;

import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
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
		// TODO if this isn't really a link, return null
		final boolean linkableContext = linkHelper.isLinkableContext(context
				.getContext());
		System.out.println("@@ " + context.getLinkText() + " "
				+ linkableContext + " :: "
				+ me.getSourceText(context.getContext().eContainer()));
		if (linkableContext) {
			return org;
		}
		return null;
	}
}
