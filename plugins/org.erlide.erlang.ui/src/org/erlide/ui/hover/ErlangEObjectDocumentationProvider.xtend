package org.erlide.ui.hover

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.erlide.erlang.Function
import org.erlide.erlang.ModelExtensions

class ErlangEObjectDocumentationProvider implements IEObjectDocumentationProvider, IEObjectDocumentationProviderExtension {
	
	@Inject
	extension ModelExtensions modelExtensions
	
	override getDocumentation(EObject obj) {
		val result = new StringBuilder

		// TODO check if external docs exist

		if(obj instanceof Function) {
			// TODO extract header if no spec? 

			val spec = findSpec(obj as Function)
			if(spec!= null) {
				val specComment = findComment(spec)
				result.append(specComment)
			}
			result.append('''<pre>«spec.sourceText»</pre>''').append("\n")
		}
		
		val comment = findComment(obj)
		result.append(comment)
		
		return result.toString
	}
	
	String ruleName = "SL_COMMENT"
	String startTag = "%%"
	
	// TODO see gepetto.DocumentationAssociator
	override getDocumentationNodes(EObject object) {
		val ICompositeNode node = NodeModelUtils::getNode(object)
		var List<INode> result = newArrayList();
		if (node != null) {
			for (ILeafNode leafNode : node.getLeafNodes()) {
				if (leafNode.isHidden()) {
					if (leafNode.grammarElement instanceof TerminalRule) {
						val rule = leafNode.grammarElement as TerminalRule
						if(ruleName.equalsIgnoreCase(rule.name)) {
							val comment = leafNode.getText().trim
							if (comment.startsWith(startTag)) {
								result.add(leafNode as INode)
							}
						} 
						// TODO keep only the latest block of comments
						
						// TODO filter out comments from the body of the function
					}
				}
			}
		}
		return result
	}
	
	def findComment(EObject o) {
		val List<INode> documentationNodes = getDocumentationNodes(o)
		if (!documentationNodes.empty) {
			return documentationNodes.map[text.split("\n").map[skipCommentTag].join].join
		}
		return ""
	}
	
	def String skipCommentTag(String str) {
		var result = str
		while(result.startsWith("%")) { 
			result = result.substring(1)
		}
		return result
	}
	
	def EObject findSpec(Function obj) {
		// TODO implement this!
		println("documentation findSpec "+obj.name+"/"+obj.arity)
		return null;
	}
	
	
}