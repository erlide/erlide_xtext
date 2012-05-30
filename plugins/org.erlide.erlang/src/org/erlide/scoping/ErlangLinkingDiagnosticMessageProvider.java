package org.erlide.scoping;

import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;

public class ErlangLinkingDiagnosticMessageProvider extends
		LinkingDiagnosticMessageProvider {

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(final ILinkingDiagnosticContext context) {
		DiagnosticMessage org = super.getUnresolvedProxyMessage(context);
		if(context.getLinkText().equals("ok")) return null;
		return org;
	}

}
