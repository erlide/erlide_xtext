package org.erlide.ui.hover;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.erlide.erlang.Function;
import org.erlide.erlang.ModelExtensions;

@SuppressWarnings("all")
public class ErlangEObjectDocumentationProvider implements IEObjectDocumentationProvider, IEObjectDocumentationProviderExtension {
  @Inject
  private ModelExtensions modelExtensions;
  
  public String getDocumentation(final EObject obj) {
    StringBuilder _stringBuilder = new StringBuilder();
    final StringBuilder result = _stringBuilder;
    if ((obj instanceof Function)) {
      final EObject spec = this.findSpec(((Function) obj));
      boolean _notEquals = (!Objects.equal(spec, null));
      if (_notEquals) {
        final String specComment = this.findComment(spec);
        result.append(specComment);
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<pre>");
      String _sourceText = this.modelExtensions.getSourceText(spec);
      _builder.append(_sourceText, "");
      _builder.append("</pre>");
      StringBuilder _append = result.append(_builder.toString());
      _append.append("\n");
    }
    final String comment = this.findComment(obj);
    result.append(comment);
    return result.toString();
  }
  
  private String ruleName = "SL_COMMENT";
  
  private String startTag = "%%";
  
  public List<INode> getDocumentationNodes(final EObject object) {
    final ICompositeNode node = NodeModelUtils.getNode(object);
    List<INode> result = CollectionLiterals.<INode>newArrayList();
    boolean _notEquals = (!Objects.equal(node, null));
    if (_notEquals) {
      Iterable<ILeafNode> _leafNodes = node.getLeafNodes();
      for (final ILeafNode leafNode : _leafNodes) {
        boolean _isHidden = leafNode.isHidden();
        if (_isHidden) {
          EObject _grammarElement = leafNode.getGrammarElement();
          if ((_grammarElement instanceof TerminalRule)) {
            EObject _grammarElement_1 = leafNode.getGrammarElement();
            final TerminalRule rule = ((TerminalRule) _grammarElement_1);
            String _name = rule.getName();
            boolean _equalsIgnoreCase = this.ruleName.equalsIgnoreCase(_name);
            if (_equalsIgnoreCase) {
              String _text = leafNode.getText();
              final String comment = _text.trim();
              boolean _startsWith = comment.startsWith(this.startTag);
              if (_startsWith) {
                result.add(((INode) leafNode));
              }
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
      final Function1<INode,String> _function = new Function1<INode,String>() {
          public String apply(final INode it) {
            String _text = it.getText();
            String[] _split = _text.split("\n");
            final Function1<String,String> _function = new Function1<String,String>() {
                public String apply(final String it) {
                  String _skipCommentTag = ErlangEObjectDocumentationProvider.this.skipCommentTag(it);
                  return _skipCommentTag;
                }
              };
            List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(_split)), _function);
            String _join = IterableExtensions.join(_map);
            return _join;
          }
        };
      List<String> _map = ListExtensions.<INode, String>map(documentationNodes, _function);
      return IterableExtensions.join(_map);
    }
    return "";
  }
  
  public String skipCommentTag(final String str) {
    String result = str;
    boolean _startsWith = result.startsWith("%");
    boolean _while = _startsWith;
    while (_while) {
      String _substring = result.substring(1);
      result = _substring;
      boolean _startsWith_1 = result.startsWith("%");
      _while = _startsWith_1;
    }
    return result;
  }
  
  public EObject findSpec(final Function obj) {
    String _name = obj.getName();
    String _plus = ("documentation findSpec " + _name);
    String _plus_1 = (_plus + "/");
    int _arity = this.modelExtensions.getArity(obj);
    String _plus_2 = (_plus_1 + Integer.valueOf(_arity));
    InputOutput.<String>println(_plus_2);
    return null;
  }
}
