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
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.erlide.erlang.Atom;
import org.erlide.erlang.AtomRefTarget;
import org.erlide.erlang.ErlangPackage.Literals;
import org.erlide.erlang.Expression;
import org.erlide.erlang.FunCall;
import org.erlide.erlang.FunRef;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.RemoteTarget;

@SuppressWarnings("all")
public class ErlangLinkingHelper {
  @Inject
  private ModelExtensions _modelExtensions;
  
  @Inject
  private ResourceDescriptionsProvider indexProvider;
  
  protected boolean _isLinkableContext(final EObject context) {
    return true;
  }
  
  protected boolean _isLinkableContext(final Expression context) {
    return false;
  }
  
  protected boolean _isLinkableContext(final Atom context) {
    boolean _xblockexpression = false;
    {
      final EObject parent = context.eContainer();
      boolean _or = false;
      boolean _or_1 = false;
      boolean _and = false;
      if (!(parent instanceof RemoteTarget)) {
        _and = false;
      } else {
        _and = ((parent instanceof RemoteTarget) && true);
      }
      if (_and) {
        _or_1 = true;
      } else {
        _or_1 = (_and || (parent instanceof FunCall));
      }
      if (_or_1) {
        _or = true;
      } else {
        boolean _and_1 = false;
        if (!(parent instanceof FunRef)) {
          _and_1 = false;
        } else {
          _and_1 = ((parent instanceof FunRef) && true);
        }
        _or = (_or_1 || _and_1);
      }
      final boolean result = _or;
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  protected AtomRefTarget _getAtomReference(final EObject obj, final INode node) {
    return null;
  }
  
  protected AtomRefTarget _getAtomReference(final Atom atom, final INode node) {
    AtomRefTarget _xblockexpression = null;
    {
      final EObject parent = atom.eContainer();
      AtomRefTarget _atomReferenceFor = this.getAtomReferenceFor(parent, atom, node);
      _xblockexpression = (_atomReferenceFor);
    }
    return _xblockexpression;
  }
  
  private AtomRefTarget _getAtomReferenceFor(final EObject parent, final Atom atom, final INode node) {
    return null;
  }
  
  private AtomRefTarget _getAtomReferenceFor(final RemoteTarget parent, final Atom atom, final INode node) {
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
          EList<Expression> _args = ((FunCall) _eContainer).getArgs();
          final int arity = _args.size();
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
  
  private AtomRefTarget _getAtomReferenceFor(final FunCall parent, final Atom atom, final INode node) {
    Module _module = this._modelExtensions.getModule(parent);
    Expression _target = parent.getTarget();
    String _sourceText = this._modelExtensions.getSourceText(_target);
    EList<Expression> _args = parent.getArgs();
    int _size = _args.size();
    return this._modelExtensions.getFunction(_module, _sourceText, _size);
  }
  
  private AtomRefTarget _getAtomReferenceFor(final FunRef parent, final Atom atom, final INode node) {
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
  
  public boolean isLinkableContext(final EObject context) {
    if (context instanceof Atom) {
      return _isLinkableContext((Atom)context);
    } else if (context instanceof Expression) {
      return _isLinkableContext((Expression)context);
    } else if (context != null) {
      return _isLinkableContext(context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(context).toString());
    }
  }
  
  public AtomRefTarget getAtomReference(final EObject atom, final INode node) {
    if (atom instanceof Atom) {
      return _getAtomReference((Atom)atom, node);
    } else if (atom != null) {
      return _getAtomReference(atom, node);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(atom, node).toString());
    }
  }
  
  private AtomRefTarget getAtomReferenceFor(final EObject parent, final Atom atom, final INode node) {
    if (parent instanceof FunRef) {
      return _getAtomReferenceFor((FunRef)parent, atom, node);
    } else if (parent instanceof FunCall) {
      return _getAtomReferenceFor((FunCall)parent, atom, node);
    } else if (parent instanceof RemoteTarget) {
      return _getAtomReferenceFor((RemoteTarget)parent, atom, node);
    } else if (parent != null) {
      return _getAtomReferenceFor(parent, atom, node);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(parent, atom, node).toString());
    }
  }
}
