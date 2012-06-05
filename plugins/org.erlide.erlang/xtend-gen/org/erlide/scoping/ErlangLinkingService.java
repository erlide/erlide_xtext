package org.erlide.scoping;

import com.google.common.base.Objects;
import com.google.inject.Inject;
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
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.erlide.erlang.AbstractElement;
import org.erlide.erlang.Atom;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.ErlangPackage.Literals;
import org.erlide.erlang.Expression;
import org.erlide.erlang.FunCall;
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
      String _plus = ("---> \'" + _sourceText);
      String _plus_1 = (_plus + "\' : \'");
      EObject _semanticElement = node.getSemanticElement();
      String _sourceText_1 = this._modelExtensions.getSourceText(_semanticElement);
      String _plus_2 = (_plus_1 + _sourceText_1);
      String _plus_3 = (_plus_2 + "\'");
      InputOutput.<String>println(_plus_3);
      final AbstractElement aref = this.getAtomReference(context, node);
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
  
  public AbstractElement getAtomReference(final EObject atom, final INode node) {
    EObject _eContainer = atom.eContainer();
    if ((_eContainer instanceof RemoteTarget)) {
      EObject _eContainer_1 = atom.eContainer();
      final RemoteTarget parent = ((RemoteTarget) _eContainer_1);
      boolean _and = false;
      Expression _module = parent.getModule();
      if (!(_module instanceof Atom)) {
        _and = false;
      } else {
        Expression _function = parent.getFunction();
        _and = ((_module instanceof Atom) && (_function instanceof Atom));
      }
      if (_and) {
        Expression _module_1 = parent.getModule();
        String _sourceText = this._modelExtensions.getSourceText(_module_1);
        Expression _function_1 = parent.getFunction();
        String _sourceText_1 = this._modelExtensions.getSourceText(_function_1);
        String _plus = (_sourceText_1 + "/1");
        final QualifiedName qname = QualifiedName.create(_sourceText, _plus);
        String _plus_1 = ("Q=" + qname);
        InputOutput.<String>println(_plus_1);
        final Iterable<IEObjectDescription> rfun = this.index.getExportedObjects(Literals.FUNCTION, qname, false);
      } else {
        String _sourceText_2 = this._modelExtensions.getSourceText(parent);
        String _plus_2 = ("Can\'t resolve remote target " + _sourceText_2);
        InputOutput.<String>println(_plus_2);
      }
      return null;
    } else {
      EObject _eContainer_2 = atom.eContainer();
      if ((_eContainer_2 instanceof FunCall)) {
        EObject _eContainer_3 = atom.eContainer();
        final FunCall fc = ((FunCall) _eContainer_3);
        Module _module_2 = this._modelExtensions.getModule(fc);
        Expression _target = fc.getTarget();
        String _sourceText_3 = this._modelExtensions.getSourceText(_target);
        EList<Expression> _args = fc.getArgs();
        int _size = _args.size();
        return this._modelExtensions.getFunction(_module_2, _sourceText_3, _size);
      }
    }
    return null;
  }
}
