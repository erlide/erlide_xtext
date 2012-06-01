package org.erlide.scoping;

import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;

public class ErlangLinkingDiagnosticMessageProvider extends
		LinkingDiagnosticMessageProvider {

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(
			final ILinkingDiagnosticContext context) {
		DiagnosticMessage org = super.getUnresolvedProxyMessage(context);
		// TODO if this isn't really a link, return null
		if (context.getLinkText().equals("ok")) {
			return null;
		}
		// TODO if an AbstractElement isn't found, include precise type in
		// message

		return org;
	}

}
