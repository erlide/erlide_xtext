package org.erlide.scoping;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.erlide.erlang.AtomRefTarget;
import org.erlide.erlang.ErlangPackage;
import org.erlide.scoping.ErlangLinkingHelper;

@SuppressWarnings("all")
public class ErlangLinkingService extends DefaultLinkingService {
  @Inject
  private ErlangLinkingHelper linkHelper;
  
  public List<EObject> getLinkedObjects(final EObject context, final EReference ref, final INode node) {
    EReference _atom_Value = ErlangPackage.eINSTANCE.getAtom_Value();
    boolean _equals = Objects.equal(ref, _atom_Value);
    if (_equals) {
      final AtomRefTarget aref = this.linkHelper.getAtomReference(context);
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
}
