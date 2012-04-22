package org.erlide.ui.syntaxcoloring;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.erlide.services.ErlangGrammarAccess;

import com.google.inject.Inject;

public class ErlangSemanticHighlightingCalculator implements
        ISemanticHighlightingCalculator {

    @Inject
    private ErlangGrammarAccess grammarAccess;

    @Override
    public void provideHighlightingFor(final XtextResource resource,
            final IHighlightedPositionAcceptor acceptor) {
        if (resource == null) {
            return;
        }

        final Iterator<INode> allNodes = resource.getParseResult()
                .getRootNode().getAsTreeIterable().iterator();
        while (allNodes.hasNext()) {
            final INode node = allNodes.next();
            final EObject grammarElement = node.getGrammarElement();

            if (matchesRule(grammarElement,
                    grammarAccess.getIfdefAttributeRule())
                    || matchesRule(grammarElement,
                            grammarAccess.getElseAttributeRule())
                    || matchesRule(grammarElement,
                            grammarAccess.getEndifAttributeRule())) {
                highlightNode(
                        node,
                        ErlangSemanticHighlightingConfiguration.STRUCTURAL_ATTRIBUTE_ID,
                        acceptor);
            }
            if (matchesRule(grammarElement, grammarAccess.getMacroRule())) {
                highlightNode(node,
                        ErlangSemanticHighlightingConfiguration.MACRO_ID,
                        acceptor);
            }
        }
    }

    private boolean matchesRule(final EObject grammarElement,
            final ParserRule rule) {
        final boolean ruleCall = grammarElement instanceof RuleCall
                && ((RuleCall) grammarElement).getRule() == rule;
        return grammarElement == rule || ruleCall;
    }

    protected void highlightNode(final INode node, final String id,
            final IHighlightedPositionAcceptor acceptor) {
        if (node == null) {
            return;
        }
        if (node instanceof ILeafNode) {
            acceptor.addPosition(node.getOffset(), node.getLength(), id);
        } else {
            for (final ILeafNode leaf : node.getLeafNodes()) {
                if (!leaf.isHidden()) {
                    acceptor.addPosition(leaf.getOffset(), leaf.getLength(), id);
                }
            }
        }
    }

    public INode getFirstFeatureNode(final EObject semantic,
            final EStructuralFeature feature) {
        if (feature == null) {
            return NodeModelUtils.findActualNodeFor(semantic);
        }
        final List<INode> nodes = NodeModelUtils.findNodesForFeature(semantic,
                feature);
        if (!nodes.isEmpty()) {
            return nodes.get(0);
        }
        return null;
    }

}
