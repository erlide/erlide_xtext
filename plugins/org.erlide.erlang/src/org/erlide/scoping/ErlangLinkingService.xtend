package org.erlide.scoping

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.linking.impl.DefaultLinkingService
import org.eclipse.xtext.nodemodel.INode
import org.erlide.erlang.ErlangPackage
import org.erlide.erlang.FunCall
import org.erlide.erlang.ModelExtensions
import org.erlide.erlang.RemoteTarget
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.erlide.erlang.Atom
import org.erlide.erlang.AtomRefTarget

class ErlangLinkingService extends DefaultLinkingService {

	@Inject
	extension ModelExtensions
	@Inject
	IResourceDescription$Manager manager
	@Inject
	IResourceDescriptions index
	@Inject
	IQualifiedNameProvider nameProvider

	override List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) {
		if(ref==ErlangPackage::eINSTANCE.atom_Value) {
			println("---> '"+context.sourceText+"' : '"+node.semanticElement.sourceText+"'")
			val aref = getAtomReference(context, node)
			println("## aref ## "+aref)
			if(aref==null) 
				return newArrayList() 
			else {
				val aref2 = aref as EObject
				return newArrayList(aref2)
			}
		}
		return super.getLinkedObjects(context, ref, node)		
	}

	def AtomRefTarget getAtomReference(EObject atom, INode node) {
		if (atom.eContainer() instanceof RemoteTarget) {
			val RemoteTarget parent = atom.eContainer() as RemoteTarget
			if(parent.module instanceof Atom && parent.function instanceof Atom){
				val qname = QualifiedName::create(parent.module.sourceText, parent.function.sourceText+"/1")
				println("Q="+qname)
				val rfun = index.getExportedObjects(ErlangPackage$Literals::FUNCTION, qname, false)
				//println("..."+rfun)
				//rfun.forEach[println("$$ "+it)]
			} else {
				println("Can't resolve remote target "+parent.sourceText)
			}
			return null //parent.module
		} else if (atom.eContainer() instanceof FunCall) {
			val fc = atom.eContainer() as FunCall
			return fc.module.getFunction(fc.target.sourceText, fc.args.size)
		} 
		return null
	}

}
