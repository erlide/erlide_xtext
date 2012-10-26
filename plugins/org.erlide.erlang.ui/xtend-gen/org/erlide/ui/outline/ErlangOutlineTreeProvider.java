package org.erlide.ui.outline;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.outline.impl.AbstractOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.erlide.erlang.DefineAttribute;
import org.erlide.erlang.ExportAttribute;
import org.erlide.erlang.Form;
import org.erlide.erlang.FunRef;
import org.erlide.erlang.FunctionClause;
import org.erlide.erlang.Module;
import org.erlide.erlang.ModuleAttribute;
import org.erlide.erlang.RecordAttribute;
import org.erlide.ui.outline.ErlangOutlineNode;

/**
 * outline structure -- group same type of forms under common parent
 */
@SuppressWarnings("all")
public class ErlangOutlineTreeProvider extends DefaultOutlineTreeProvider {
  protected boolean _isLeaf(final FunctionClause c) {
    return true;
  }
  
  protected boolean _isLeaf(final FunRef c) {
    return true;
  }
  
  protected void _createChildren(final DocumentRootNode parent, final Module module) {
    String _plus = (parent + " === ");
    String _plus_1 = (_plus + module);
    InputOutput.<String>println(_plus_1);
    ErlangOutlineNode _erlangOutlineNode = new ErlangOutlineNode(parent, 
      null, "Records:", false);
    final AbstractOutlineNode recordsNode = _erlangOutlineNode;
    ErlangOutlineNode _erlangOutlineNode_1 = new ErlangOutlineNode(parent, 
      null, "Exports:", false);
    final AbstractOutlineNode exportsNode = _erlangOutlineNode_1;
    ErlangOutlineNode _erlangOutlineNode_2 = new ErlangOutlineNode(parent, null, "Macros:", false);
    final AbstractOutlineNode macrosNode = _erlangOutlineNode_2;
    EList<Form> _forms = module.getForms();
    for (final Form element : _forms) {
      {
        AbstractOutlineNode _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (element instanceof ModuleAttribute) {
            final ModuleAttribute _moduleAttribute = (ModuleAttribute)element;
            _matched=true;
            _switchResult = null;
          }
        }
        if (!_matched) {
          if (element instanceof RecordAttribute) {
            final RecordAttribute _recordAttribute = (RecordAttribute)element;
            _matched=true;
            _switchResult = recordsNode;
          }
        }
        if (!_matched) {
          if (element instanceof ExportAttribute) {
            final ExportAttribute _exportAttribute = (ExportAttribute)element;
            _matched=true;
            _switchResult = exportsNode;
          }
        }
        if (!_matched) {
          if (element instanceof DefineAttribute) {
            final DefineAttribute _defineAttribute = (DefineAttribute)element;
            _matched=true;
            _switchResult = macrosNode;
          }
        }
        if (!_matched) {
          _switchResult = parent;
        }
        final AbstractOutlineNode theParent = _switchResult;
        boolean _notEquals = (!Objects.equal(theParent, null));
        if (_notEquals) {
          this.createChildren(theParent, element);
        }
      }
    }
  }
  
  protected void _createChildren(final ErlangOutlineNode parent, final ExportAttribute attr) {
    EList<EObject> _eContents = attr.eContents();
    for (final EObject element : _eContents) {
      this.createNode(parent, element);
    }
  }
}
