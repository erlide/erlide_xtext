package org.erlide.ui.syntaxcoloring;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.erlide.erlang.Atom;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Macro;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.RemoteTarget;
import org.erlide.services.ErlangGrammarAccess;
import org.erlide.ui.syntaxcoloring.ErlangSemanticHighlightingConfiguration;
import org.erlide.ui.syntaxcoloring.SafeAcceptorWrapper;

@SuppressWarnings("all")
public class ErlangSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {
  @Inject
  private ErlangGrammarAccess grammarAccess;
  
  @Inject
  private ModelExtensions modelExtensions;
  
  public void provideHighlightingFor(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    boolean _equals = Objects.equal(resource, null);
    if (_equals) {
      return;
    }
    SafeAcceptorWrapper _safeAcceptorWrapper = new SafeAcceptorWrapper(acceptor);
    final SafeAcceptorWrapper myacceptor = _safeAcceptorWrapper;
    this.provideNodeBasedHighlighting(resource, myacceptor);
    this.provideSemanticHighlighting(resource, myacceptor);
    this.provideTextualHighlighting(resource, myacceptor);
    this.provideResourceLevelHighlighting(resource, myacceptor);
  }
  
  protected void _highlight(final RuleCall grammarElement, final INode node, final IHighlightedPositionAcceptor acceptor) {
    AbstractRule _rule = grammarElement.getRule();
    boolean _equals = Objects.equal(_rule, null);
    if (_equals) {
      return;
    }
    AbstractRule _rule_1 = grammarElement.getRule();
    ParserRule _kWRule = this.grammarAccess.getKWRule();
    boolean _equals_1 = Objects.equal(_rule_1, _kWRule);
    if (_equals_1) {
      this.highlightNode(node, DefaultHighlightingConfiguration.DEFAULT_ID, acceptor);
    }
    boolean _or = false;
    boolean _or_1 = false;
    AbstractRule _rule_2 = grammarElement.getRule();
    ParserRule _ifdefAttributeRule = this.grammarAccess.getIfdefAttributeRule();
    boolean _equals_2 = Objects.equal(_rule_2, _ifdefAttributeRule);
    if (_equals_2) {
      _or_1 = true;
    } else {
      AbstractRule _rule_3 = grammarElement.getRule();
      ParserRule _elseAttributeRule = this.grammarAccess.getElseAttributeRule();
      boolean _equals_3 = Objects.equal(_rule_3, _elseAttributeRule);
      _or_1 = (_equals_2 || _equals_3);
    }
    if (_or_1) {
      _or = true;
    } else {
      AbstractRule _rule_4 = grammarElement.getRule();
      ParserRule _endifAttributeRule = this.grammarAccess.getEndifAttributeRule();
      boolean _equals_4 = Objects.equal(_rule_4, _endifAttributeRule);
      _or = (_or_1 || _equals_4);
    }
    if (_or) {
      this.highlightNode(node, 
        ErlangSemanticHighlightingConfiguration.STRUCTURAL_ATTRIBUTE_ID, acceptor);
    }
  }
  
  protected void _highlight(final Keyword grammarElement, final INode node, final IHighlightedPositionAcceptor acceptor) {
  }
  
  protected void _highlight(final EObject grammarElement, final INode node, final IHighlightedPositionAcceptor acceptor) {
    String _plus = ("!!! highlight -- " + grammarElement);
    InputOutput.<String>println(_plus);
  }
  
  private void highlightNode(final INode node, final String id, final IHighlightedPositionAcceptor acceptor) {
    boolean _equals = Objects.equal(node, null);
    if (_equals) {
      return;
    }
    int _offset = node.getOffset();
    int _length = node.getLength();
    acceptor.addPosition(_offset, _length, id);
    if ((node instanceof ILeafNode)) {
      int _offset_1 = node.getOffset();
      int _length_1 = node.getLength();
      acceptor.addPosition(_offset_1, _length_1, id);
    } else {
      Iterable<ILeafNode> _leafNodes = node.getLeafNodes();
      for (final ILeafNode leaf : _leafNodes) {
        boolean _isHidden = leaf.isHidden();
        boolean _not = (!_isHidden);
        if (_not) {
          int _offset_2 = leaf.getOffset();
          int _length_2 = leaf.getLength();
          acceptor.addPosition(_offset_2, _length_2, id);
        }
      }
    }
  }
  
  public INode getFirstFeatureNode(final EObject semantic, final EStructuralFeature feature) {
    boolean _equals = Objects.equal(feature, null);
    if (_equals) {
      return NodeModelUtils.findActualNodeFor(semantic);
    }
    final List<INode> nodes = NodeModelUtils.findNodesForFeature(semantic, feature);
    boolean _isEmpty = nodes.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
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
  private void provideNodeBasedHighlighting(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    IParseResult _parseResult = resource.getParseResult();
    ICompositeNode _rootNode = _parseResult.getRootNode();
    final BidiTreeIterable<INode> allNodes = _rootNode.getAsTreeIterable();
    for (final INode node : allNodes) {
      {
        final EObject gElem = node.getGrammarElement();
        if ((gElem instanceof RuleCall)) {
          this.highlight(gElem, node, acceptor);
        } else {
          if ((gElem instanceof Keyword)) {
            this.highlight(gElem, node, acceptor);
          }
        }
      }
    }
  }
  
  private void provideResourceLevelHighlighting(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
  }
  
  /**
   * Iterate over the generated model and provide highlighting
   * 
   * @param resource
   * @param acceptor
   */
  private void provideSemanticHighlighting(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    final EList<EObject> contents = resource.getContents();
    boolean _or = false;
    boolean _equals = Objects.equal(contents, null);
    if (_equals) {
      _or = true;
    } else {
      int _size = contents.size();
      boolean _equals_1 = (_size == 0);
      _or = (_equals || _equals_1);
    }
    if (_or) {
      return;
    }
    EObject _get = contents.get(0);
    final Module model = ((Module) _get);
    this.highlight(model, acceptor);
  }
  
  private void provideTextualHighlighting(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
  }
  
  protected void _highlight(final Module model, final IHighlightedPositionAcceptor acceptor) {
    final TreeIterator<EObject> all = model.eAllContents();
    boolean _hasNext = all.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      EObject _next = all.next();
      this.highlight(_next, acceptor);
      boolean _hasNext_1 = all.hasNext();
      _while = _hasNext_1;
    }
  }
  
  protected void _highlight(final Macro model, final IHighlightedPositionAcceptor acceptor) {
    final INode node = NodeModelUtils.getNode(model);
    this.highlightNode(node, ErlangSemanticHighlightingConfiguration.MACRO_ID, acceptor);
  }
  
  protected void _highlight(final Atom model, final IHighlightedPositionAcceptor acceptor) {
    final INode node = NodeModelUtils.getNode(model);
    boolean _and = false;
    EObject _eContainer = model.eContainer();
    if (!(_eContainer instanceof RemoteTarget)) {
      _and = false;
    } else {
      EObject _eContainer_1 = model.eContainer();
      Expression _module = ((RemoteTarget) _eContainer_1).getModule();
      boolean _equals = Objects.equal(_module, model);
      _and = ((_eContainer instanceof RemoteTarget) && _equals);
    }
    if (_and) {
      this.highlightNode(node, ErlangSemanticHighlightingConfiguration.STRING_ID, acceptor);
    }
    boolean _and_1 = false;
    EObject _eContainer_2 = model.eContainer();
    if (!(_eContainer_2 instanceof RemoteTarget)) {
      _and_1 = false;
    } else {
      EObject _eContainer_3 = model.eContainer();
      Expression _function = ((RemoteTarget) _eContainer_3).getFunction();
      boolean _equals_1 = Objects.equal(_function, model);
      _and_1 = ((_eContainer_2 instanceof RemoteTarget) && _equals_1);
    }
    if (_and_1) {
      this.highlightNode(node, ErlangSemanticHighlightingConfiguration.COMMENT_ID, acceptor);
    }
  }
  
  protected void _highlight(final EObject o, final IHighlightedPositionAcceptor acceptor) {
  }
  
  public void highlight(final EObject grammarElement, final INode node, final IHighlightedPositionAcceptor acceptor) {
    if (grammarElement instanceof Keyword) {
      _highlight((Keyword)grammarElement, node, acceptor);
      return;
    } else if (grammarElement instanceof RuleCall) {
      _highlight((RuleCall)grammarElement, node, acceptor);
      return;
    } else if (grammarElement != null) {
      _highlight(grammarElement, node, acceptor);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(grammarElement, node, acceptor).toString());
    }
  }
  
  public void highlight(final EObject model, final IHighlightedPositionAcceptor acceptor) {
    if (model instanceof Atom) {
      _highlight((Atom)model, acceptor);
      return;
    } else if (model instanceof Macro) {
      _highlight((Macro)model, acceptor);
      return;
    } else if (model instanceof Module) {
      _highlight((Module)model, acceptor);
      return;
    } else if (model != null) {
      _highlight(model, acceptor);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(model, acceptor).toString());
    }
  }
}
