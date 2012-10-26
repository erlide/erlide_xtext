package org.erlide.ui.outline;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.AbstractOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EStructuralFeatureNode;
import org.erlide.erlang.DefineAttribute;
import org.erlide.erlang.ErlangPackage.Literals;
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
    ErlangOutlineNode _erlangOutlineNode = new ErlangOutlineNode(parent, null, "Records:", false);
    final ErlangOutlineNode recordsNode = _erlangOutlineNode;
    ErlangOutlineNode _erlangOutlineNode_1 = new ErlangOutlineNode(parent, null, "Exports:", false);
    final ErlangOutlineNode exportsNode = _erlangOutlineNode_1;
    ErlangOutlineNode _erlangOutlineNode_2 = new ErlangOutlineNode(parent, null, "Macros:", false);
    final ErlangOutlineNode macrosNode = _erlangOutlineNode_2;
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
  
  protected void _createChildren(final ErlangOutlineNode parent, final DefineAttribute attr) {
    String _macroName = attr.getMacroName();
    final EStructuralFeatureNode name = this.createEStructuralFeatureNode(parent, attr, Literals.DEFINE_ATTRIBUTE__MACRO_NAME, null, _macroName, true);
    EList<EObject> _eContents = attr.eContents();
    for (final EObject element : _eContents) {
      this.createNode(name, element);
    }
  }
  
  protected void _createChildren(final ErlangOutlineNode parent, final RecordAttribute attr) {
    String _name = attr.getName();
    final EStructuralFeatureNode name = this.createEStructuralFeatureNode(parent, attr, Literals.RECORD_ATTRIBUTE__NAME, null, _name, true);
    EList<EObject> _eContents = attr.eContents();
    for (final EObject element : _eContents) {
      this.createNode(name, element);
    }
  }
  
  public boolean isLeaf(final Object c) {
    if (c instanceof FunRef) {
      return _isLeaf((FunRef)c);
    } else if (c instanceof FunctionClause) {
      return _isLeaf((FunctionClause)c);
    } else if (c instanceof EObject) {
      return _isLeaf((EObject)c);
    } else if (c != null) {
      return _isLeaf(c);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(c).toString());
    }
  }
  
  public void createChildren(final Object parent, final Object module) {
    if (parent instanceof DocumentRootNode
         && module instanceof Module) {
      _createChildren((DocumentRootNode)parent, (Module)module);
      return;
    } else if (parent instanceof DocumentRootNode
         && module instanceof EObject) {
      _createChildren((DocumentRootNode)parent, (EObject)module);
      return;
    } else if (parent instanceof EStructuralFeatureNode
         && module instanceof EObject) {
      _createChildren((EStructuralFeatureNode)parent, (EObject)module);
      return;
    } else if (parent instanceof IOutlineNode
         && module instanceof EObject) {
      _createChildren((IOutlineNode)parent, (EObject)module);
      return;
    } else if (parent instanceof ErlangOutlineNode
         && module instanceof DefineAttribute) {
      _createChildren((ErlangOutlineNode)parent, (DefineAttribute)module);
      return;
    } else if (parent instanceof ErlangOutlineNode
         && module instanceof ExportAttribute) {
      _createChildren((ErlangOutlineNode)parent, (ExportAttribute)module);
      return;
    } else if (parent instanceof ErlangOutlineNode
         && module instanceof RecordAttribute) {
      _createChildren((ErlangOutlineNode)parent, (RecordAttribute)module);
      return;
    } else if (parent != null
         && module != null) {
      _createChildren(parent, module);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(parent, module).toString());
    }
  }
}
