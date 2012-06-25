package org.erlide.scoping;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.erlide.erlang.Atom;
import org.erlide.erlang.AtomRefTarget;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.ErlangPackage.Literals;
import org.erlide.erlang.Expression;
import org.erlide.erlang.FunCall;
import org.erlide.erlang.FunRef;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.RemoteTarget;

@SuppressWarnings("all")
public class ErlangLinkingService extends DefaultLinkingService {
  @Inject
  private ModelExtensions _modelExtensions;
  
  @Inject
  private Manager manager;
  
  @Inject
  private IResourceDescriptions index;
  
  @Inject
  private IQualifiedNameProvider nameProvider;
  
  public List<EObject> getLinkedObjects(final EObject context, final EReference ref, final INode node) {
    EReference _atom_Value = ErlangPackage.eINSTANCE.getAtom_Value();
    boolean _equals = Objects.equal(ref, _atom_Value);
    if (_equals) {
      String _sourceText = this._modelExtensions.getSourceText(context);
      String _plus = ("linkedObjects---> \'" + _sourceText);
      String _plus_1 = (_plus + "\' : \'");
      EObject _semanticElement = node.getSemanticElement();
      String _sourceText_1 = this._modelExtensions.getSourceText(_semanticElement);
      String _plus_2 = (_plus_1 + _sourceText_1);
      String _plus_3 = (_plus_2 + "\'");
      InputOutput.<String>println(_plus_3);
      final AtomRefTarget aref = this.getAtomReference(context, node);
      String _plus_4 = ("## aref ## " + aref);
      InputOutput.<String>println(_plus_4);
      boolean _equals_1 = Objects.equal(aref, null);
      if (_equals_1) {
        return CollectionLiterals.<EObject>newArrayList();
      } else {
        final EObject aref2 = ((EObject) aref);
        return CollectionLiterals.<EObject>newArrayList(aref2);
      }
    }
    return super.getLinkedObjects(context, ref, node);
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
  
  protected AtomRefTarget _getAtomReferenceFor(final EObject parent, final Atom atom, final INode node) {
    return null;
  }
  
  protected AtomRefTarget _getAtomReferenceFor(final RemoteTarget parent, final Atom atom, final INode node) {
    Expression _module = parent.getModule();
    if ((_module instanceof Atom)) {
      Expression _module_1 = parent.getModule();
      boolean _equals = Objects.equal(atom, _module_1);
      if (_equals) {
        String _sourceText = this._modelExtensions.getSourceText(atom);
        final QualifiedName qname = QualifiedName.create(_sourceText);
        String _plus = ("M=" + qname);
        InputOutput.<String>println(_plus);
        String _sourceText_1 = this._modelExtensions.getSourceText(atom);
        QualifiedName _create = QualifiedName.create(_sourceText_1);
        final Iterable<IEObjectDescription> mods = this.index.getExportedObjects(Literals.MODULE, _create, false);
        return null;
      }
      Expression _function = parent.getFunction();
      if ((_function instanceof Atom)) {
        Expression _function_1 = parent.getFunction();
        boolean _equals_1 = Objects.equal(atom, _function_1);
        if (_equals_1) {
          Expression _module_2 = parent.getModule();
          String _sourceText_2 = this._modelExtensions.getSourceText(_module_2);
          Expression _function_2 = parent.getFunction();
          String _sourceText_3 = this._modelExtensions.getSourceText(_function_2);
          String _plus_1 = (_sourceText_3 + "/1");
          final QualifiedName qname_1 = QualifiedName.create(_sourceText_2, _plus_1);
          String _plus_2 = ("F=" + qname_1);
          InputOutput.<String>println(_plus_2);
          final Iterable<IEObjectDescription> rfun = this.index.getExportedObjects(Literals.FUNCTION, qname_1, false);
          return null;
        }
      }
      String _sourceText_4 = this._modelExtensions.getSourceText(parent);
      String _plus_3 = (" !!!! Can\'t resolve remote target " + _sourceText_4);
      InputOutput.<String>println(_plus_3);
      return null;
    }
    return null;
  }
  
  protected AtomRefTarget _getAtomReferenceFor(final FunCall parent, final Atom atom, final INode node) {
    Module _module = this._modelExtensions.getModule(parent);
    Expression _target = parent.getTarget();
    String _sourceText = this._modelExtensions.getSourceText(_target);
    EList<Expression> _args = parent.getArgs();
    int _size = _args.size();
    return this._modelExtensions.getFunction(_module, _sourceText, _size);
  }
  
  protected AtomRefTarget _getAtomReferenceFor(final FunRef parent, final Atom atom, final INode node) {
    Expression _arity_ = parent.getArity_();
    final String arity = this._modelExtensions.getSourceText(_arity_);
    String _sourceText = this._modelExtensions.getSourceText(parent);
    String _plus = ("FUNREF " + _sourceText);
    InputOutput.<String>println(_plus);
    try {
      Module _module = this._modelExtensions.getModule(parent);
      Expression _function_ = parent.getFunction_();
      String _sourceText_1 = this._modelExtensions.getSourceText(_function_);
      int _parseInt = Integer.parseInt(arity);
      return this._modelExtensions.getFunction(_module, _sourceText_1, _parseInt);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
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
  
  public AtomRefTarget getAtomReferenceFor(final EObject parent, final Atom atom, final INode node) {
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
