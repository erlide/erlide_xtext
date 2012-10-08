package org.erlide.ui.hover;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

@SuppressWarnings("all")
public class ErlangEObjectDocumentationProvider implements IEObjectDocumentationProvider, IEObjectDocumentationProviderExtension {
  public String getDocumentation(final EObject o) {
    final String comment = this.findComment(o);
    return ("hello <strong>people</strong>!\n" + comment);
  }
  
  private String ruleName = "SL_COMMENT";
  
  private String startTag = "%%";
  
  public List<INode> getDocumentationNodes(final EObject object) {
    final ICompositeNode node = NodeModelUtils.getNode(object);
    List<INode> result = Collections.<INode>emptyList();
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      Iterable<ILeafNode> _leafNodes = node.getLeafNodes();
      for (final ILeafNode leafNode : _leafNodes) {
        boolean _isHidden = leafNode.isHidden();
        if (_isHidden) {
          boolean _and = false;
          EObject _grammarElement = leafNode.getGrammarElement();
          if (!(_grammarElement instanceof TerminalRule)) {
            _and = false;
          } else {
            EObject _grammarElement_1 = leafNode.getGrammarElement();
            String _name = ((TerminalRule) _grammarElement_1).getName();
            boolean _equalsIgnoreCase = this.ruleName.equalsIgnoreCase(_name);
            _and = ((_grammarElement instanceof TerminalRule) && _equalsIgnoreCase);
          }
          if (_and) {
            final String comment = leafNode.getText();
            String _plus = ("(?s)" + this.startTag);
            String _plus_1 = (_plus + ".*");
            boolean _matches = comment.matches(_plus_1);
            if (_matches) {
              List<INode> _singletonList = Collections.<INode>singletonList(((INode) leafNode));
              result = _singletonList;
            }
          }
        }
      }
    }
    return result;
  }
  
  public String findComment(final EObject o) {
    final List<INode> documentationNodes = this.getDocumentationNodes(o);
    boolean _isEmpty = documentationNodes.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      INode _get = documentationNodes.get(0);
      return _get.getText();
    }
    return "";
  }
}
