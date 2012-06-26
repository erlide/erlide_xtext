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
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.RecordExpr;
import org.erlide.erlang.RecordFieldExpr;
import org.erlide.erlang.RemoteTarget;
import org.erlide.scoping.ErlangLinkCategory;

@SuppressWarnings("all")
public class ErlangLinkingHelper {
  @Inject
  private ModelExtensions _modelExtensions;
  
  @Inject
  private ResourceDescriptionsProvider indexProvider;
  
  protected ErlangLinkCategory _classify(final EObject obj) {
    return ErlangLinkCategory.NONE;
  }
  
  protected ErlangLinkCategory _classify(final Atom obj) {
    EObject _eContainer = obj.eContainer();
    ErlangLinkCategory _classifyAtom = this.classifyAtom(obj, _eContainer);
    return _classifyAtom;
  }
  
  private ErlangLinkCategory _classifyAtom(final Atom atom, final EObject context) {
    return ErlangLinkCategory.NONE;
  }
  
  private ErlangLinkCategory _classifyAtom(final Atom atom, final RemoteTarget context) {
    Expression _module = context.getModule();
    if ((_module instanceof Atom)) {
      Expression _module_1 = context.getModule();
      boolean _equals = Objects.equal(atom, _module_1);
      if (_equals) {
        return ErlangLinkCategory.MODULE;
      }
      Expression _function = context.getFunction();
      if ((_function instanceof Atom)) {
        Expression _function_1 = context.getFunction();
        boolean _equals_1 = Objects.equal(atom, _function_1);
        if (_equals_1) {
          return ErlangLinkCategory.FUNCTION_CALL;
        }
      }
    }
    return ErlangLinkCategory.NONE;
  }
  
  private ErlangLinkCategory _classifyAtom(final Atom atom, final FunCall context) {
    return ErlangLinkCategory.FUNCTION_CALL;
  }
  
  private ErlangLinkCategory _classifyAtom(final Atom atom, final FunRef context) {
    return ErlangLinkCategory.FUNCTION_REF;
  }
  
  private ErlangLinkCategory _classifyAtom(final Atom atom, final RecordExpr context) {
    return ErlangLinkCategory.RECORD;
  }
  
  private ErlangLinkCategory _classifyAtom(final Atom atom, final RecordFieldExpr context) {
    return ErlangLinkCategory.RECORD_FIELD;
  }
  
  public boolean isLinkableAtom(final Atom atom) {
    ErlangLinkCategory _classify = this.classify(atom);
    boolean _notEquals = (!Objects.equal(_classify, ErlangLinkCategory.NONE));
    return _notEquals;
  }
  
  public AtomRefTarget getAtomReference(final EObject obj) {
    AtomRefTarget _switchResult = null;
    ErlangLinkCategory _classify = this.classify(obj);
    final ErlangLinkCategory classify = _classify;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(classify,ErlangLinkCategory.NONE)) {
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (Objects.equal(classify,ErlangLinkCategory.MODULE)) {
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (Objects.equal(classify,ErlangLinkCategory.FUNCTION_CALL)) {
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (Objects.equal(classify,ErlangLinkCategory.FUNCTION_REF)) {
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (Objects.equal(classify,ErlangLinkCategory.RECORD)) {
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (Objects.equal(classify,ErlangLinkCategory.RECORD_FIELD)) {
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
        return this._modelExtensions.getModule(index, _sourceText, rset);
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
    Module _module = this._modelExtensions.getModule(parent);
    Expression _target = parent.getTarget();
    String _sourceText = this._modelExtensions.getSourceText(_target);
    Expressions _args = parent.getArgs();
    EList<Expression> _exprs = _args.getExprs();
    int _size = _exprs.size();
    return this._modelExtensions.getFunction(_module, _sourceText, _size);
  }
  
  private AtomRefTarget _getAtomReferenceFor(final FunRef parent, final Atom atom) {
    Expression _arity_ = parent.getArity_();
    final String arity = this._modelExtensions.getSourceText(_arity_);
    try {
      Module _module = this._modelExtensions.getModule(parent);
      Expression _function_ = parent.getFunction_();
      String _sourceText = this._modelExtensions.getSourceText(_function_);
      int _parseInt = Integer.parseInt(arity);
      return this._modelExtensions.getFunction(_module, _sourceText, _parseInt);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public ErlangLinkCategory classify(final EObject obj) {
    if (obj instanceof Atom) {
      return _classify((Atom)obj);
    } else if (obj != null) {
      return _classify(obj);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(obj).toString());
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
