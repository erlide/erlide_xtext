package org.erlide.scoping;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.erlide.erlang.Atom;
import org.erlide.erlang.AtomRefTarget;
import org.erlide.erlang.ErlangPackage.Literals;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Expressions;
import org.erlide.erlang.FunCall;
import org.erlide.erlang.FunRef;
import org.erlide.erlang.Macro;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.RecordExpr;
import org.erlide.erlang.RecordFieldExpr;
import org.erlide.erlang.RecordTuple;
import org.erlide.erlang.RemoteTarget;
import org.erlide.scoping.ErlangLinkCategory;

@SuppressWarnings("all")
public class ErlangLinkingHelper {
  @Inject
  private ModelExtensions _modelExtensions;
  
  @Inject
  private ResourceDescriptionsProvider indexProvider;
  
  public ErlangLinkCategory classifyAtom(final Atom obj) {
    EObject _eContainer = obj.eContainer();
    ErlangLinkCategory _classifyAtom = this.classifyAtom(obj, _eContainer);
    return _classifyAtom;
  }
  
  private ErlangLinkCategory _classifyAtom(final Atom atom, final EObject context) {
    return ErlangLinkCategory.NONE;
  }
  
  private ErlangLinkCategory _classifyAtom(final Atom atom, final RemoteTarget context) {
    Expression _module = context.getModule();
    boolean _equals = Objects.equal(atom, _module);
    if (_equals) {
      return ErlangLinkCategory.MODULE;
    }
    Expression _function = context.getFunction();
    boolean _equals_1 = Objects.equal(atom, _function);
    if (_equals_1) {
      Expression _module_1 = context.getModule();
      if ((_module_1 instanceof Atom)) {
        Expression _function_1 = context.getFunction();
        if ((_function_1 instanceof Atom)) {
          return ErlangLinkCategory.FUNCTION_CALL_REMOTE;
        }
      }
      Expression _module_2 = context.getModule();
      if ((_module_2 instanceof Macro)) {
        Expression _module_3 = context.getModule();
        final Macro macro = ((Macro) _module_3);
        String _sourceText = this._modelExtensions.getSourceText(macro);
        boolean _equals_2 = Objects.equal(_sourceText, "? MODULE");
        if (_equals_2) {
          return ErlangLinkCategory.FUNCTION_CALL_REMOTE;
        }
      }
    }
    return ErlangLinkCategory.NONE;
  }
  
  private ErlangLinkCategory _classifyAtom(final Atom atom, final FunCall context) {
    return ErlangLinkCategory.FUNCTION_CALL_LOCAL;
  }
  
  private ErlangLinkCategory _classifyAtom(final Atom atom, final FunRef context) {
    ErlangLinkCategory _xblockexpression = null;
    {
      Expression _module = context.getModule();
      boolean _equals = Objects.equal(atom, _module);
      if (_equals) {
        return ErlangLinkCategory.MODULE;
      }
      Expression _function = context.getFunction();
      boolean _equals_1 = Objects.equal(atom, _function);
      if (_equals_1) {
        boolean _or = false;
        Expression _module_1 = context.getModule();
        if ((_module_1 instanceof Atom)) {
          _or = true;
        } else {
          Expression _module_2 = context.getModule();
          boolean _equals_2 = Objects.equal(_module_2, null);
          _or = ((_module_1 instanceof Atom) || _equals_2);
        }
        if (_or) {
          return ErlangLinkCategory.FUNCTION_REF;
        }
        Expression _module_3 = context.getModule();
        if ((_module_3 instanceof Macro)) {
          Expression _module_4 = context.getModule();
          final Macro macro = ((Macro) _module_4);
          String _sourceText = this._modelExtensions.getSourceText(macro);
          boolean _equals_3 = Objects.equal(_sourceText, "? MODULE");
          if (_equals_3) {
            return ErlangLinkCategory.FUNCTION_REF;
          }
        }
      }
      _xblockexpression = (ErlangLinkCategory.NONE);
    }
    return _xblockexpression;
  }
  
  private ErlangLinkCategory _classifyAtom(final Atom atom, final RecordExpr context) {
    ErlangLinkCategory _xblockexpression = null;
    {
      Expression _rec = context.getRec();
      if ((_rec instanceof Atom)) {
        Expression _rec_1 = context.getRec();
        boolean _equals = Objects.equal(_rec_1, atom);
        if (_equals) {
          return ErlangLinkCategory.RECORD;
        }
        Expression _field = context.getField();
        boolean _equals_1 = Objects.equal(_field, atom);
        if (_equals_1) {
          return ErlangLinkCategory.RECORD_FIELD;
        }
      }
      _xblockexpression = (ErlangLinkCategory.NONE);
    }
    return _xblockexpression;
  }
  
  private ErlangLinkCategory _classifyAtom(final Atom atom, final RecordFieldExpr context) {
    ErlangLinkCategory _xblockexpression = null;
    {
      EObject _eContainer = context.eContainer();
      if ((_eContainer instanceof RecordExpr)) {
        EObject _eContainer_1 = context.eContainer();
        final RecordExpr expr = ((RecordExpr) _eContainer_1);
        Expression _rec = expr.getRec();
        if ((_rec instanceof Atom)) {
          return ErlangLinkCategory.RECORD_FIELD;
        }
      }
      EObject _eContainer_2 = context.eContainer();
      if ((_eContainer_2 instanceof RecordTuple)) {
        EObject _eContainer_3 = context.eContainer();
        EObject _eContainer_4 = _eContainer_3.eContainer();
        if ((_eContainer_4 instanceof RecordExpr)) {
          EObject _eContainer_5 = context.eContainer();
          EObject _eContainer_6 = _eContainer_5.eContainer();
          final RecordExpr expr_1 = ((RecordExpr) _eContainer_6);
          Expression _rec_1 = expr_1.getRec();
          if ((_rec_1 instanceof Atom)) {
            return ErlangLinkCategory.RECORD_FIELD;
          }
        }
      }
      _xblockexpression = (ErlangLinkCategory.NONE);
    }
    return _xblockexpression;
  }
  
  public boolean isLinkableAtom(final Atom atom) {
    ErlangLinkCategory _classifyAtom = this.classifyAtom(atom);
    boolean _notEquals = (!Objects.equal(_classifyAtom, ErlangLinkCategory.NONE));
    return _notEquals;
  }
  
  public AtomRefTarget getAtomReference(final Atom atom) {
    AtomRefTarget _switchResult = null;
    ErlangLinkCategory _classifyAtom = this.classifyAtom(atom);
    final ErlangLinkCategory _switchValue = _classifyAtom;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,ErlangLinkCategory.NONE)) {
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,ErlangLinkCategory.MODULE)) {
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,ErlangLinkCategory.FUNCTION_CALL_LOCAL)) {
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,ErlangLinkCategory.FUNCTION_CALL_REMOTE)) {
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,ErlangLinkCategory.FUNCTION_REF)) {
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,ErlangLinkCategory.RECORD)) {
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,ErlangLinkCategory.RECORD_FIELD)) {
        _matched=true;
        _switchResult = null;
      }
    }
    return _switchResult;
  }
  
  private AtomRefTarget _getAtomReferenceFor(final EObject parent, final Atom atom) {
    return null;
  }
  
  private AtomRefTarget _getAtomReferenceFor(final RemoteTarget parent, final Atom atom) {
    Resource _eResource = atom.eResource();
    final IResourceDescriptions index = this.indexProvider.getResourceDescriptions(_eResource);
    Resource _eResource_1 = atom.eResource();
    final ResourceSet rset = _eResource_1.getResourceSet();
    Expression _module = parent.getModule();
    if ((_module instanceof Atom)) {
      Expression _module_1 = parent.getModule();
      boolean _equals = Objects.equal(atom, _module_1);
      if (_equals) {
        String _sourceText = this._modelExtensions.getSourceText(atom);
        return this._modelExtensions.findModule(index, _sourceText, rset);
      }
      Expression _function = parent.getFunction();
      if ((_function instanceof Atom)) {
        Expression _function_1 = parent.getFunction();
        boolean _equals_1 = Objects.equal(atom, _function_1);
        if (_equals_1) {
          EObject _eContainer = parent.eContainer();
          Expressions _args = ((FunCall) _eContainer).getArgs();
          EList<Expression> _exprs = _args.getExprs();
          final int arity = _exprs.size();
          Expression _module_2 = parent.getModule();
          String _sourceText_1 = this._modelExtensions.getSourceText(_module_2);
          Expression _function_2 = parent.getFunction();
          String _sourceText_2 = this._modelExtensions.getSourceText(_function_2);
          String _plus = (_sourceText_2 + "/");
          String _plus_1 = (_plus + Integer.valueOf(arity));
          final QualifiedName qname = QualifiedName.create(_sourceText_1, _plus_1);
          final Iterable<IEObjectDescription> rfun = index.getExportedObjects(Literals.FUNCTION, qname, false);
          boolean _isEmpty = IterableExtensions.isEmpty(rfun);
          boolean _not = (!_isEmpty);
          if (_not) {
            IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(rfun);
            URI _eObjectURI = _head.getEObjectURI();
            EObject _eObject = rset.getEObject(_eObjectURI, true);
            return ((AtomRefTarget) _eObject);
          }
        }
      }
      return null;
    }
    return null;
  }
  
  private AtomRefTarget _getAtomReferenceFor(final FunCall parent, final Atom atom) {
    Module _owningModule = this._modelExtensions.getOwningModule(parent);
    Expression _target = parent.getTarget();
    String _sourceText = this._modelExtensions.getSourceText(_target);
    Expressions _args = parent.getArgs();
    EList<Expression> _exprs = _args.getExprs();
    int _size = _exprs.size();
    return this._modelExtensions.getFunction(_owningModule, _sourceText, _size);
  }
  
  private AtomRefTarget _getAtomReferenceFor(final FunRef parent, final Atom atom) {
    Expression _arity = parent.getArity();
    final String arity = this._modelExtensions.getSourceText(_arity);
    try {
      Module _owningModule = this._modelExtensions.getOwningModule(parent);
      Expression _function = parent.getFunction();
      String _sourceText = this._modelExtensions.getSourceText(_function);
      int _parseInt = Integer.parseInt(arity);
      return this._modelExtensions.getFunction(_owningModule, _sourceText, _parseInt);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  private ErlangLinkCategory classifyAtom(final Atom atom, final EObject context) {
    if (context instanceof FunRef) {
      return _classifyAtom(atom, (FunRef)context);
    } else if (context instanceof FunCall) {
      return _classifyAtom(atom, (FunCall)context);
    } else if (context instanceof RecordExpr) {
      return _classifyAtom(atom, (RecordExpr)context);
    } else if (context instanceof RemoteTarget) {
      return _classifyAtom(atom, (RemoteTarget)context);
    } else if (context instanceof RecordFieldExpr) {
      return _classifyAtom(atom, (RecordFieldExpr)context);
    } else if (context != null) {
      return _classifyAtom(atom, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(atom, context).toString());
    }
  }
  
  private AtomRefTarget getAtomReferenceFor(final EObject parent, final Atom atom) {
    if (parent instanceof FunRef) {
      return _getAtomReferenceFor((FunRef)parent, atom);
    } else if (parent instanceof FunCall) {
      return _getAtomReferenceFor((FunCall)parent, atom);
    } else if (parent instanceof RemoteTarget) {
      return _getAtomReferenceFor((RemoteTarget)parent, atom);
    } else if (parent != null) {
      return _getAtomReferenceFor(parent, atom);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(parent, atom).toString());
    }
  }
}
