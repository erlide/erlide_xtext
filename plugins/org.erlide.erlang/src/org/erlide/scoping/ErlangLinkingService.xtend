package org.erlide.scoping

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.linking.impl.DefaultLinkingService
import org.eclipse.xtext.nodemodel.INode
import org.erlide.erlang.ErlangPackage

class ErlangLinkingService extends DefaultLinkingService {

    @Inject
    ErlangLinkingHelper linkHelper

	override List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) {
		if(ref==ErlangPackage::eINSTANCE.atom_Value) {
			val aref = linkHelper.getAtomReference(context, node)
			if(aref==null) 
				return newArrayList() 
			else {
				val aref2 = aref as EObject
				return newArrayList(aref2)
			}
		}
		return super.getLinkedObjects(context, ref, node)		
	}


}
