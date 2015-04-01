package org.erlide.ui.outline;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.AbstractOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EStructuralFeatureNode;
import org.eclipse.xtext.xbase.lib.Extension;
import org.erlide.erlang.DefineAttribute;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.ExportAttribute;
import org.erlide.erlang.Form;
import org.erlide.erlang.FunRef;
import org.erlide.erlang.FunctionClause;
import org.erlide.erlang.Module;
import org.erlide.erlang.ModuleAttribute;
import org.erlide.erlang.RecordAttribute;
import org.erlide.erlang.ScopeExtensions;
import org.erlide.ui.outline.ErlangOutlineNode;

/**
 * outline structure -- group same type of forms under common parent
 */
@SuppressWarnings("all")
public class ErlangOutlineTreeProviderBase extends DefaultOutlineTreeProvider {
  @Inject
  @Extension
  private ScopeExtensions _scopeExtensions;
  
  protected boolean _isLeaf(final FunctionClause c) {
    return true;
  }
  
  protected boolean _isLeaf(final FunRef c) {
    return true;
  }
  
  @Inject
  private ResourceDescriptionsProvider provider;
  
  public void debug_test(final Module module) {
    final Resource resource = module.eResource();
    IResourceDescriptions descriptions = this.provider.getResourceDescriptions(resource);
    ResourceSet resourceSet = resource.getResourceSet();
  }
  
  protected void _createChildren(final DocumentRootNode parent, final Module module) {
    final ErlangOutlineNode recordsNode = new ErlangOutlineNode(parent, null, "Records:", false);
    final ErlangOutlineNode exportsNode = new ErlangOutlineNode(parent, null, "Exports:", false);
    final ErlangOutlineNode macrosNode = new ErlangOutlineNode(parent, null, "Macros:", false);
    EList<Form> _forms = module.getForms();
    for (final Form element : _forms) {
      {
        AbstractOutlineNode _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (element instanceof ModuleAttribute) {
            _matched=true;
            _switchResult = null;
          }
        }
        if (!_matched) {
          if (element instanceof RecordAttribute) {
            _matched=true;
            _switchResult = recordsNode;
          }
        }
        if (!_matched) {
          if (element instanceof ExportAttribute) {
            _matched=true;
            _switchResult = exportsNode;
          }
        }
        if (!_matched) {
          if (element instanceof DefineAttribute) {
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
    final EStructuralFeatureNode name = this.createEStructuralFeatureNode(parent, attr, ErlangPackage.Literals.DEFINE_ATTRIBUTE__MACRO_NAME, null, _macroName, true);
    EList<EObject> _eContents = attr.eContents();
    for (final EObject element : _eContents) {
      this.createNode(name, element);
    }
  }
  
  protected void _createChildren(final ErlangOutlineNode parent, final RecordAttribute attr) {
    String _name = attr.getName();
    final EStructuralFeatureNode name = this.createEStructuralFeatureNode(parent, attr, ErlangPackage.Literals.RECORD_ATTRIBUTE__NAME, null, _name, true);
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
  
  public void createChildren(final IOutlineNode parent, final EObject module) {
    if (parent instanceof ErlangOutlineNode
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
    } else if (parent instanceof DocumentRootNode
         && module instanceof Module) {
      _createChildren((DocumentRootNode)parent, (Module)module);
      return;
    } else if (parent instanceof DocumentRootNode
         && module != null) {
      _createChildren((DocumentRootNode)parent, module);
      return;
    } else if (parent instanceof EStructuralFeatureNode
         && module != null) {
      _createChildren((EStructuralFeatureNode)parent, module);
      return;
    } else if (parent != null
         && module != null) {
      _createChildren(parent, module);
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
