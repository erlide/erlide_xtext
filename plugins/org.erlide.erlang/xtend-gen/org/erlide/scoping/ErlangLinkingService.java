package org.erlide.scoping;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.erlide.erlang.Atom;
import org.erlide.erlang.AtomRefTarget;
import org.erlide.erlang.DefineAttribute;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Macro;
import org.erlide.scoping.ErlangLinkingHelper;

@SuppressWarnings("all")
public class ErlangLinkingService extends DefaultLinkingService {
  @Inject
  private ErlangLinkingHelper linkHelper;
  
  public List<EObject> getLinkedObjects(final EObject context, final EReference ref, final INode node) {
    EObject aref = null;
    EReference _atom_Value = ErlangPackage.eINSTANCE.getAtom_Value();
    boolean _equals = Objects.equal(ref, _atom_Value);
    if (_equals) {
      AtomRefTarget _atomReference = this.linkHelper.getAtomReference(((Atom) context));
      aref = _atomReference;
      return this.wrap(aref);
    }
    EReference _macro_Value = ErlangPackage.eINSTANCE.getMacro_Value();
    boolean _equals_1 = Objects.equal(ref, _macro_Value);
    if (_equals_1) {
      DefineAttribute _macroReference = this.linkHelper.getMacroReference(((Macro) context));
      aref = _macroReference;
      return this.wrap(aref);
    }
    return super.getLinkedObjects(context, ref, node);
  }
  
  private List<EObject> wrap(final EObject aref) {
    boolean _equals = Objects.equal(aref, null);
    if (_equals) {
      return CollectionLiterals.<EObject>newArrayList();
    } else {
      return CollectionLiterals.<EObject>newArrayList(aref);
    }
  }
}
