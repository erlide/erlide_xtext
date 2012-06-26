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
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.erlide.erlang.Atom;
import org.erlide.erlang.AtomRefTarget;
import org.erlide.erlang.ErlangPackage.Literals;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Expressions;
import org.erlide.erlang.FunCall;
import org.erlide.erlang.FunRef;
import org.erlide.erlang.FunType;
import org.erlide.erlang.Function;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.RecordExpr;
import org.erlide.erlang.RecordFieldExpr;
import org.erlide.erlang.RecordTuple;
import org.erlide.erlang.RemoteTarget;
import org.erlide.erlang.SpecAttribute;
import org.erlide.erlang.TopType;
import org.erlide.erlang.TypeSig;
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
      boolean _isModuleMacro = this._modelExtensions.isModuleMacro(_module_2);
      if (_isModuleMacro) {
        return ErlangLinkCategory.FUNCTION_CALL_REMOTE;
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
          final EObject parent = context.eContainer();
          if ((parent instanceof SpecAttribute)) {
            Expression _module_3 = context.getModule();
            boolean _equals_3 = Objects.equal(_module_3, null);
            if (_equals_3) {
              return ErlangLinkCategory.FUNCTION_CALL_LOCAL;
            } else {
              return ErlangLinkCategory.FUNCTION_CALL_REMOTE;
            }
          }
          Expression _module_4 = context.getModule();
          boolean _equals_4 = Objects.equal(_module_4, null);
          if (_equals_4) {
            return ErlangLinkCategory.FUNCTION_REF_LOCAL;
          } else {
            return ErlangLinkCategory.FUNCTION_REF_REMOTE;
          }
        }
        Expression _module_5 = context.getModule();
        boolean _isModuleMacro = this._modelExtensions.isModuleMacro(_module_5);
        if (_isModuleMacro) {
          return ErlangLinkCategory.FUNCTION_REF_REMOTE;
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
    AtomRefTarget _xblockexpression = null;
    {
      Resource _eResource = atom.eResource();
      final IResourceDescriptions index = this.indexProvider.getResourceDescriptions(_eResource);
      Resource _eResource_1 = atom.eResource();
      final ResourceSet rset = _eResource_1.getResourceSet();
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
          AtomRefTarget _moduleRef = this.getModuleRef(index, atom, rset);
          _switchResult = _moduleRef;
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,ErlangLinkCategory.FUNCTION_CALL_LOCAL)) {
          _matched=true;
          AtomRefTarget _localCallRef = this.getLocalCallRef(atom);
          _switchResult = _localCallRef;
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,ErlangLinkCategory.FUNCTION_CALL_REMOTE)) {
          _matched=true;
          AtomRefTarget _remoteCallRef = this.getRemoteCallRef(index, atom, rset);
          _switchResult = _remoteCallRef;
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,ErlangLinkCategory.FUNCTION_REF_LOCAL)) {
          _matched=true;
          AtomRefTarget _localFunRefRef = this.getLocalFunRefRef(index, atom, rset);
          _switchResult = _localFunRefRef;
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,ErlangLinkCategory.FUNCTION_REF_REMOTE)) {
          _matched=true;
          AtomRefTarget _remoteFunRefRef = this.getRemoteFunRefRef(index, atom, rset);
          _switchResult = _remoteFunRefRef;
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,ErlangLinkCategory.RECORD)) {
          _matched=true;
          AtomRefTarget _recordRef = this.getRecordRef(index, atom, rset);
          _switchResult = _recordRef;
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,ErlangLinkCategory.RECORD_FIELD)) {
          _matched=true;
          AtomRefTarget _recordFieldRef = this.getRecordFieldRef(index, atom, rset);
          _switchResult = _recordFieldRef;
        }
      }
      _xblockexpression = (_switchResult);
    }
    return _xblockexpression;
  }
  
  public AtomRefTarget getModuleRef(final IResourceDescriptions index, final Atom atom, final ResourceSet rset) {
    String _sourceText = this._modelExtensions.getSourceText(atom);
    Module _findModule = this._modelExtensions.findModule(index, _sourceText, rset);
    return _findModule;
  }
  
  public AtomRefTarget getLocalCallRef(final Atom atom) {
    Function _xblockexpression = null;
    {
      final EObject parent = atom.eContainer();
      Function _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (parent instanceof FunCall) {
          final FunCall _funCall = (FunCall)parent;
          _matched=true;
          Function _xblockexpression_1 = null;
          {
            Expressions _args = _funCall.getArgs();
            EList<Expression> _exprs = _args==null?(EList<Expression>)null:_args.getExprs();
            int _size = _exprs==null?0:_exprs.size();
            final Integer arity = ObjectExtensions.<Integer>operator_elvis(Integer.valueOf(_size), Integer.valueOf(0));
            Module _owningModule = this._modelExtensions.getOwningModule(_funCall);
            Expression _target = _funCall.getTarget();
            String _sourceText = this._modelExtensions.getSourceText(_target);
            Function _function = this._modelExtensions.getFunction(_owningModule, _sourceText, (arity).intValue());
            _xblockexpression_1 = (_function);
          }
          _switchResult = _xblockexpression_1;
        }
      }
      if (!_matched) {
        if (parent instanceof FunRef) {
          final FunRef _funRef = (FunRef)parent;
          _matched=true;
          Function _xblockexpression_1 = null;
          {
            EObject _eContainer = _funRef.eContainer();
            final SpecAttribute xparent = ((SpecAttribute) _eContainer);
            EList<TypeSig> _signatures = xparent.getSignatures();
            TypeSig _head = IterableExtensions.<TypeSig>head(_signatures);
            FunType _decl = _head.getDecl();
            EList<TopType> _args = _decl.getArgs();
            int _size = _args==null?0:_args.size();
            final Integer arity = ObjectExtensions.<Integer>operator_elvis(Integer.valueOf(_size), Integer.valueOf(0));
            Module _owningModule = this._modelExtensions.getOwningModule(_funRef);
            String _sourceText = this._modelExtensions.getSourceText(atom);
            Function _function = this._modelExtensions.getFunction(_owningModule, _sourceText, (arity).intValue());
            _xblockexpression_1 = (_function);
          }
          _switchResult = _xblockexpression_1;
        }
      }
      if (!_matched) {
        _switchResult = null;
      }
      _xblockexpression = (_switchResult);
    }
    return _xblockexpression;
  }
  
  public AtomRefTarget getRemoteCallRef(final IResourceDescriptions index, final Atom atom, final ResourceSet rset) {
    AtomRefTarget _xblockexpression = null;
    {
      EObject _eContainer = atom.eContainer();
      final RemoteTarget parent = ((RemoteTarget) _eContainer);
      EObject _eContainer_1 = parent.eContainer();
      final FunCall call = ((FunCall) _eContainer_1);
      Expressions _args = call.getArgs();
      EList<Expression> _exprs = _args==null?(EList<Expression>)null:_args.getExprs();
      int _size = _exprs==null?0:_exprs.size();
      final Integer arity = ObjectExtensions.<Integer>operator_elvis(Integer.valueOf(_size), Integer.valueOf(0));
      String _xifexpression = null;
      Expression _module = parent.getModule();
      boolean _isModuleMacro = this._modelExtensions.isModuleMacro(_module);
      if (_isModuleMacro) {
        Module _owningModule = this._modelExtensions.getOwningModule(atom);
        String _name = this._modelExtensions.getName(_owningModule);
        _xifexpression = _name;
      } else {
        Expression _module_1 = parent.getModule();
        String _sourceText = this._modelExtensions.getSourceText(_module_1);
        _xifexpression = _sourceText;
      }
      final String moduleName = _xifexpression;
      Expression _function = parent.getFunction();
      String _sourceText_1 = this._modelExtensions.getSourceText(_function);
      String _plus = (_sourceText_1 + "/");
      String _plus_1 = (_plus + arity);
      final QualifiedName qname = QualifiedName.create(moduleName, _plus_1);
      final Iterable<IEObjectDescription> rfun = index.getExportedObjects(Literals.FUNCTION, qname, false);
      AtomRefTarget _xifexpression_1 = null;
      boolean _isEmpty = IterableExtensions.isEmpty(rfun);
      boolean _not = (!_isEmpty);
      if (_not) {
        IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(rfun);
        URI _eObjectURI = _head.getEObjectURI();
        EObject _eObject = rset.getEObject(_eObjectURI, true);
        _xifexpression_1 = ((AtomRefTarget) _eObject);
      }
      _xblockexpression = (_xifexpression_1);
    }
    return _xblockexpression;
  }
  
  public AtomRefTarget getRemoteFunRefRef(final IResourceDescriptions index, final Atom atom, final ResourceSet rset) {
    AtomRefTarget _xblockexpression = null;
    {
      EObject _eContainer = atom.eContainer();
      final FunRef parent = ((FunRef) _eContainer);
      Expression _arity = parent.getArity();
      final String arity = this._modelExtensions.getSourceText(_arity);
      String _xifexpression = null;
      Expression _module = parent.getModule();
      boolean _isModuleMacro = this._modelExtensions.isModuleMacro(_module);
      if (_isModuleMacro) {
        Module _owningModule = this._modelExtensions.getOwningModule(atom);
        String _name = this._modelExtensions.getName(_owningModule);
        _xifexpression = _name;
      } else {
        Expression _module_1 = parent.getModule();
        String _sourceText = this._modelExtensions.getSourceText(_module_1);
        _xifexpression = _sourceText;
      }
      final String moduleName = _xifexpression;
      Expression _function = parent.getFunction();
      String _sourceText_1 = this._modelExtensions.getSourceText(_function);
      String _plus = (_sourceText_1 + "/");
      String _plus_1 = (_plus + arity);
      final QualifiedName qname = QualifiedName.create(moduleName, _plus_1);
      final Iterable<IEObjectDescription> rfun = index.getExportedObjects(Literals.FUNCTION, qname, false);
      AtomRefTarget _xifexpression_1 = null;
      boolean _isEmpty = IterableExtensions.isEmpty(rfun);
      boolean _not = (!_isEmpty);
      if (_not) {
        IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(rfun);
        URI _eObjectURI = _head.getEObjectURI();
        EObject _eObject = rset.getEObject(_eObjectURI, true);
        _xifexpression_1 = ((AtomRefTarget) _eObject);
      }
      _xblockexpression = (_xifexpression_1);
    }
    return _xblockexpression;
  }
  
  public AtomRefTarget getLocalFunRefRef(final IResourceDescriptions index, final Atom atom, final ResourceSet rset) {
    Function _xblockexpression = null;
    {
      EObject _eContainer = atom.eContainer();
      final FunRef parent = ((FunRef) _eContainer);
      Expression _arity = parent.getArity();
      final String arity = this._modelExtensions.getSourceText(_arity);
      Function _xtrycatchfinallyexpression = null;
      try {
        Module _owningModule = this._modelExtensions.getOwningModule(parent);
        Expression _function = parent.getFunction();
        String _sourceText = this._modelExtensions.getSourceText(_function);
        int _parseInt = Integer.parseInt(arity);
        Function _function_1 = this._modelExtensions.getFunction(_owningModule, _sourceText, _parseInt);
        _xtrycatchfinallyexpression = _function_1;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          return null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = (_xtrycatchfinallyexpression);
    }
    return _xblockexpression;
  }
  
  public AtomRefTarget getRecordRef(final IResourceDescriptions index, final Atom atom, final ResourceSet rset) {
    return null;
  }
  
  public AtomRefTarget getRecordFieldRef(final IResourceDescriptions index, final Atom atom, final ResourceSet rset) {
    return null;
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
}
