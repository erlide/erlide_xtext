package org.erlide.scoping;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Collection;
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
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.erlide.erlang.Atom;
import org.erlide.erlang.AtomRefTarget;
import org.erlide.erlang.DefineAttribute;
import org.erlide.erlang.ErlangPackage.Literals;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Expressions;
import org.erlide.erlang.FunCall;
import org.erlide.erlang.FunRef;
import org.erlide.erlang.FunType;
import org.erlide.erlang.Function;
import org.erlide.erlang.Macro;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.RecordAttribute;
import org.erlide.erlang.RecordExpr;
import org.erlide.erlang.RecordFieldDef;
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
      boolean _and = false;
      Expression _module_1 = context.getModule();
      if (!(_module_1 instanceof Atom)) {
        _and = false;
      } else {
        Expression _function_1 = context.getFunction();
        _and = ((_module_1 instanceof Atom) && (_function_1 instanceof Atom));
      }
      if (_and) {
        return ErlangLinkCategory.FUNCTION_CALL_REMOTE;
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
        Expression _module_1 = context.getModule();
        if ((_module_1 instanceof Atom)) {
          final EObject parent = context.eContainer();
          if ((parent instanceof SpecAttribute)) {
            return ErlangLinkCategory.FUNCTION_CALL_REMOTE;
          }
          return ErlangLinkCategory.FUNCTION_REF_REMOTE;
        }
        Expression _module_2 = context.getModule();
        boolean _equals_2 = Objects.equal(_module_2, null);
        if (_equals_2) {
          final EObject parent_1 = context.eContainer();
          if ((parent_1 instanceof SpecAttribute)) {
            return ErlangLinkCategory.FUNCTION_CALL_LOCAL;
          }
          return ErlangLinkCategory.FUNCTION_REF_LOCAL;
        }
        Expression _module_3 = context.getModule();
        boolean _isModuleMacro = this._modelExtensions.isModuleMacro(_module_3);
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
      boolean _equals = Objects.equal(_rec, atom);
      if (_equals) {
        return ErlangLinkCategory.RECORD;
      }
      boolean _and = false;
      Expression _rec_1 = context.getRec();
      if (!(_rec_1 instanceof Atom)) {
        _and = false;
      } else {
        Expression _field = context.getField();
        boolean _equals_1 = Objects.equal(_field, atom);
        _and = ((_rec_1 instanceof Atom) && _equals_1);
      }
      if (_and) {
        return ErlangLinkCategory.RECORD_FIELD;
      }
      _xblockexpression = (ErlangLinkCategory.NONE);
    }
    return _xblockexpression;
  }
  
  private ErlangLinkCategory _classifyAtom(final Atom atom, final RecordFieldExpr context) {
    ErlangLinkCategory _xblockexpression = null;
    {
      final EObject parent = context.eContainer();
      boolean _matched = false;
      if (!_matched) {
        if (parent instanceof RecordExpr) {
          final RecordExpr _recordExpr = (RecordExpr)parent;
          _matched=true;
          Expression _rec = _recordExpr.getRec();
          if ((_rec instanceof Atom)) {
            return ErlangLinkCategory.RECORD_FIELD;
          }
        }
      }
      if (!_matched) {
        if (parent instanceof RecordTuple) {
          final RecordTuple _recordTuple = (RecordTuple)parent;
          _matched=true;
          EObject _eContainer = context.eContainer();
          EObject _eContainer_1 = _eContainer.eContainer();
          if ((_eContainer_1 instanceof RecordExpr)) {
            EObject _eContainer_2 = context.eContainer();
            EObject _eContainer_3 = _eContainer_2.eContainer();
            final RecordExpr expr = ((RecordExpr) _eContainer_3);
            Expression _rec = expr.getRec();
            if ((_rec instanceof Atom)) {
              return ErlangLinkCategory.RECORD_FIELD;
            }
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
      ErlangLinkCategory _classifyAtom = this.classifyAtom(atom);
      AtomRefTarget _ref = _classifyAtom.getRef(index, atom, rset);
      _xblockexpression = (_ref);
    }
    return _xblockexpression;
  }
  
  public AtomRefTarget getModuleRef(final IResourceDescriptions index, final Atom atom, final ResourceSet rset) {
    String _sourceText = this._modelExtensions.getSourceText(atom);
    Module _findModule = this._modelExtensions.findModule(index, _sourceText, rset);
    return _findModule;
  }
  
  public AtomRefTarget getLocalCallRef(final IResourceDescriptions index, final Atom atom, final ResourceSet rset) {
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
    AtomRefTarget _xblockexpression = null;
    {
      Module _owningModule = this._modelExtensions.getOwningModule(atom);
      final String moduleName = this._modelExtensions.getName(_owningModule);
      String _sourceText = this._modelExtensions.getSourceText(atom);
      final QualifiedName qname = QualifiedName.create(moduleName, _sourceText);
      final Iterable<IEObjectDescription> rfun = index.getExportedObjects(Literals.RECORD_ATTRIBUTE, qname, false);
      AtomRefTarget _xifexpression = null;
      boolean _isEmpty = IterableExtensions.isEmpty(rfun);
      boolean _not = (!_isEmpty);
      if (_not) {
        IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(rfun);
        URI _eObjectURI = _head.getEObjectURI();
        EObject _eObject = rset.getEObject(_eObjectURI, true);
        _xifexpression = ((AtomRefTarget) _eObject);
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  private RecordExpr getRecordExprForField(final EObject field) {
    RecordExpr _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (field instanceof RecordExpr) {
        final RecordExpr _recordExpr = (RecordExpr)field;
        _matched=true;
        _switchResult = ((RecordExpr) _recordExpr);
      }
    }
    if (!_matched) {
      EObject _eContainer = field.eContainer();
      RecordExpr _recordExprForField = this.getRecordExprForField(_eContainer);
      _switchResult = _recordExprForField;
    }
    return _switchResult;
  }
  
  public AtomRefTarget getRecordFieldRef(final IResourceDescriptions index, final Atom atom, final ResourceSet rset) {
    RecordFieldDef _xblockexpression = null;
    {
      final RecordExpr recExpr = this.getRecordExprForField(atom);
      Expression _rec = recExpr.getRec();
      AtomRefTarget _recordRef = this.getRecordRef(index, ((Atom) _rec), rset);
      final RecordAttribute record = ((RecordAttribute) _recordRef);
      EList<RecordFieldDef> _fields = record.getFields();
      final Function1<RecordFieldDef,Boolean> _function = new Function1<RecordFieldDef,Boolean>() {
          public Boolean apply(final RecordFieldDef it) {
            String _name = it.getName();
            String _sourceText = ErlangLinkingHelper.this._modelExtensions.getSourceText(atom);
            boolean _equals = Objects.equal(_name, _sourceText);
            return Boolean.valueOf(_equals);
          }
        };
      RecordFieldDef _findFirst = IterableExtensions.<RecordFieldDef>findFirst(_fields, _function);
      _xblockexpression = (_findFirst);
    }
    return _xblockexpression;
  }
  
  public AtomRefTarget getMacroRef(final IResourceDescriptions index, final Atom atom, final ResourceSet rset) {
    Module _owningModule = this._modelExtensions.getOwningModule(atom);
    Collection<DefineAttribute> _allItemsOfType = this._modelExtensions.<DefineAttribute>getAllItemsOfType(_owningModule, DefineAttribute.class);
    final Function1<DefineAttribute,Boolean> _function = new Function1<DefineAttribute,Boolean>() {
        public Boolean apply(final DefineAttribute it) {
          String _macroName = it.getMacroName();
          String _sourceText = ErlangLinkingHelper.this._modelExtensions.getSourceText(atom);
          boolean _equals = Objects.equal(_macroName, _sourceText);
          return Boolean.valueOf(_equals);
        }
      };
    DefineAttribute _findFirst = IterableExtensions.<DefineAttribute>findFirst(_allItemsOfType, _function);
    return _findFirst;
  }
  
  public DefineAttribute getMacroReference(final Macro macro) {
    Module _owningModule = this._modelExtensions.getOwningModule(macro);
    Collection<DefineAttribute> _allItemsOfType = this._modelExtensions.<DefineAttribute>getAllItemsOfType(_owningModule, DefineAttribute.class);
    final Function1<DefineAttribute,Boolean> _function = new Function1<DefineAttribute,Boolean>() {
        public Boolean apply(final DefineAttribute it) {
          String _macroName = it.getMacroName();
          String _macroName_1 = ErlangLinkingHelper.this.getMacroName(macro);
          boolean _equals = Objects.equal(_macroName, _macroName_1);
          return Boolean.valueOf(_equals);
        }
      };
    DefineAttribute _findFirst = IterableExtensions.<DefineAttribute>findFirst(_allItemsOfType, _function);
    return _findFirst;
  }
  
  public String getMacroName(final Macro macro) {
    String _xblockexpression = null;
    {
      final String txt = this._modelExtensions.getSourceText(macro);
      String _xifexpression = null;
      boolean _startsWith = txt.startsWith("? ");
      if (_startsWith) {
        String _substring = txt.substring(2);
        _xifexpression = _substring;
      } else {
        _xifexpression = txt;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
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
