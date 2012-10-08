package org.erlide.ui.hover

import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import org.eclipse.emf.ecore.EObject

class ErlangEObjectHoverProvider extends DefaultEObjectHoverProvider {
	
	override getFirstLine(EObject obj) {
		return super.getFirstLine(obj)
	}
	
}