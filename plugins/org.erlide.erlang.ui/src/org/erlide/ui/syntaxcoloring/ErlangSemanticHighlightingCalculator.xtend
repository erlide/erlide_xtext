package org.erlide.ui.syntaxcoloring

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.TreeIterator
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.nodemodel.BidiTreeIterable
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.erlide.erlang.FunCall
import org.erlide.erlang.Macro
import org.erlide.erlang.ModelExtensions
import org.erlide.erlang.Module
import org.erlide.services.ErlangGrammarAccess
import org.erlide.erlang.Atom
import org.erlide.erlang.RemoteTarget

public class ErlangSemanticHighlightingCalculator implements
        ISemanticHighlightingCalculator {

    @Inject
    ErlangGrammarAccess grammarAccess
    @Inject
    extension ModelExtensions modelExtensions
    

    override void provideHighlightingFor(XtextResource resource,
            IHighlightedPositionAcceptor acceptor) {
        if (resource == null) {
            return
        }
		val myacceptor = new SafeAcceptorWrapper(acceptor)

		// highligting based on inspection of parser nodes
		provideNodeBasedHighlighting(resource, myacceptor)

		// highlighting based on created model
		provideSemanticHighlighting(resource, myacceptor)

		// highligting based on the text itself
		provideTextualHighlighting(resource, myacceptor)

		provideResourceLevelHighlighting(resource, myacceptor)
    }

	def dispatch void highlight(RuleCall grammarElement, INode node, IHighlightedPositionAcceptor acceptor){
		if (grammarElement.rule==null) { return }
        if (grammarElement.rule == grammarAccess.KWRule) {
            // fake keywords should not get highlighted
            highlightNode(node, DefaultHighlightingConfiguration::DEFAULT_ID,
                    acceptor);
        }
        if (grammarElement.rule == grammarAccess.ifdefAttributeRule
                || grammarElement.rule ==
                        grammarAccess.elseAttributeRule
                || grammarElement.rule ==
                        grammarAccess.endifAttributeRule) {
            highlightNode(
                    node,
                    ErlangSemanticHighlightingConfiguration::STRUCTURAL_ATTRIBUTE_ID,
                    acceptor);
        }
	}
	def dispatch void highlight(Keyword grammarElement, INode node, IHighlightedPositionAcceptor acceptor) {
		// do nothing		
	}
	def dispatch void highlight(EObject grammarElement, INode node, IHighlightedPositionAcceptor acceptor) {
		// do nothing		
		println("!!! highlight -- "+grammarElement)
	}

    def private void highlightNode(INode node, String id,
            IHighlightedPositionAcceptor acceptor) {
        if (node == null) {
            return;
        }
            acceptor.addPosition(node.getOffset(), node.getLength(), id);
        if (node instanceof ILeafNode) {
            acceptor.addPosition(node.getOffset(), node.getLength(), id);
        } else {
            for (leaf : node.getLeafNodes()) {
                if (!leaf.isHidden()) {
                    acceptor.addPosition(leaf.getOffset(), leaf.getLength(), id);
                }
            }
        }
    }

    def INode getFirstFeatureNode(EObject semantic,
            EStructuralFeature feature) {
        if (feature == null) {
            return NodeModelUtils::findActualNodeFor(semantic);
        }
        val List<INode> nodes = NodeModelUtils::findNodesForFeature(semantic,
                feature);
        if (!nodes.isEmpty()) {
            return nodes.get(0);
        }
        return null;
    }

    /**
     * Iterate over parser nodes and provide highlighting based on rule calls.
     * 
     * @param resource
     * @param acceptor
     */
    def private void provideNodeBasedHighlighting(XtextResource resource,
            IHighlightedPositionAcceptor acceptor) {
        val BidiTreeIterable<INode> allNodes = resource.getParseResult()
                .getRootNode().getAsTreeIterable();
        for (node : allNodes) {
            val EObject gElem = node.getGrammarElement();
            if (gElem instanceof RuleCall) {
                highlight(gElem, node, acceptor);
            } else if (gElem instanceof Keyword) {
                highlight(gElem, node, acceptor);
            }
        }
    }

    def private void provideResourceLevelHighlighting(
            XtextResource resource,
            IHighlightedPositionAcceptor acceptor) {
        // for example for todo highlighting
    }

    /**
     * Iterate over the generated model and provide highlighting
     * 
     * @param resource
     * @param acceptor
     */
    def private void provideSemanticHighlighting(XtextResource resource,
            IHighlightedPositionAcceptor acceptor) {
        val EList<EObject> contents = resource.getContents();
        if (contents == null || contents.size() == 0) {
            return; // nothing there at all - probably an empty file
        }
        val model = contents.get(0) as Module;
        highlight(model, acceptor);
    }

    def private void provideTextualHighlighting(XtextResource resource,
            IHighlightedPositionAcceptor acceptor) {
        // not used
    }

	def dispatch void highlight(Module model, IHighlightedPositionAcceptor acceptor) {
		val TreeIterator<EObject> all = model.eAllContents()
		while(all.hasNext())
			highlight(all.next(), acceptor)
	}
	def dispatch void highlight(Macro model, IHighlightedPositionAcceptor acceptor) {
		val INode node = NodeModelUtils::getNode(model)
		highlightNode(node, ErlangSemanticHighlightingConfiguration::MACRO_ID, acceptor)
	}
	def dispatch void highlight(Atom model, IHighlightedPositionAcceptor acceptor) {
		val INode node = NodeModelUtils::getNode(model)
		
		// FIXME add config colors, etc
		
		if (model.eContainer instanceof RemoteTarget && (model.eContainer as RemoteTarget).module==model)
			highlightNode(node, ErlangSemanticHighlightingConfiguration::STRING_ID, acceptor)
		if (model.eContainer instanceof RemoteTarget && (model.eContainer as RemoteTarget).function==model)
			highlightNode(node, ErlangSemanticHighlightingConfiguration::COMMENT_ID, acceptor)
	}
	def dispatch void highlight(EObject o, IHighlightedPositionAcceptor acceptor) {
		// DO NOTHING

		// Uncomment next for debugging, and seeing opportunities for syntax highlighting
		//println("Missing highlight() method for: "+ o.getClass().getSimpleName())
	}

}

class SafeAcceptorWrapper implements IHighlightedPositionAcceptor {
		IHighlightedPositionAcceptor wrapped;

		new(IHighlightedPositionAcceptor wrapped) {
			this.wrapped = wrapped;
		}

		override void addPosition(int offset, int length, String... id) {
			if(length == 0)
				return;
			if(length < 0)
				return;
			wrapped.addPosition(offset, length, id);
		}

	}
