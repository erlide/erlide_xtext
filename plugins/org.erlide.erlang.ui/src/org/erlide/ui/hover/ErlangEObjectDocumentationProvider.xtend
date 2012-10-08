package org.erlide.ui.hover

import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension
import java.util.List
import org.eclipse.xtext.nodemodel.INode
import java.util.Collections
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.TerminalRule

class ErlangEObjectDocumentationProvider implements IEObjectDocumentationProvider, IEObjectDocumentationProviderExtension {
	
	override getDocumentation(EObject o) {
		val comment = findComment(o)
		return "hello <strong>people</strong>!\n"+comment
	}
	
	String ruleName = "SL_COMMENT"
	String startTag = "%%"
	
	override getDocumentationNodes(EObject object) {
		val ICompositeNode node = NodeModelUtils::getNode(object)
		var List<INode> result = Collections::emptyList();
		if (node != null) {
			// get the last multi line comment before a non hidden leaf node
			
			// FIXME: get all consecutive comments before the element! 
			
			for (ILeafNode leafNode : node.getLeafNodes()) {
				if (leafNode.isHidden()) {
					if (leafNode.getGrammarElement() instanceof TerminalRule
							&& ruleName.equalsIgnoreCase((leafNode.getGrammarElement() as TerminalRule).getName())) {
						val comment = leafNode.getText()
						if (comment.matches("(?s)" + startTag + ".*")) {
							result = Collections::singletonList(leafNode as INode)
						}
					}
				}
			}
		}
		return result
	}
	
	def findComment(EObject o) {
		val List<INode> documentationNodes = getDocumentationNodes(o)
		if (!documentationNodes.empty) {
			return documentationNodes.get(0).text
		}
		return ""
	}
	
	
}