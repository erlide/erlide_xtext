package org.erlide.scoping

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.linking.impl.DefaultLinkingService
import org.eclipse.xtext.nodemodel.INode
import org.erlide.erlang.ErlangPackage
import org.erlide.erlang.Atom
import org.erlide.erlang.Macro

class ErlangLinkingService extends DefaultLinkingService {

    @Inject
    ErlangLinkingHelper linkHelper

	override List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) {
		var EObject aref
		if(ref==ErlangPackage::eINSTANCE.atom_Value) {
			aref = linkHelper.getAtomReference(context as Atom)
			return wrap(aref)
		}
		if(ref==ErlangPackage::eINSTANCE.macro_Value) {
			aref = linkHelper.getMacroReference(context as Macro)
			return wrap(aref)
		}
		return super.getLinkedObjects(context, ref, node)		
	}

	def private List<EObject> wrap(EObject aref) {
		if(aref==null) 
			return newArrayList() 
		else {
			return newArrayList(aref)
		}
	}
}
