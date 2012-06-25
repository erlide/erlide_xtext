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
import org.erlide.erlang.FunRef

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
			println("linkedObjects---> '"+context.sourceText+"' : '"+node.semanticElement.sourceText+"'")
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

	def dispatch AtomRefTarget getAtomReference(EObject obj, INode node) {
		null
	}
	def dispatch AtomRefTarget getAtomReference(Atom atom, INode node) {
		val parent = atom.eContainer()
		getAtomReferenceFor(parent, atom, node)
	}		
	
	def dispatch AtomRefTarget getAtomReferenceFor(EObject parent, Atom atom, INode node) {
		null
	}
	def dispatch AtomRefTarget getAtomReferenceFor(RemoteTarget parent, Atom atom, INode node) {
		if(parent.module instanceof Atom) {
			if(atom==parent.module) {
				val qname = QualifiedName::create(atom.sourceText)
				println("M="+qname)
				val mods = index.getExportedObjects(ErlangPackage$Literals::MODULE, QualifiedName::create(atom.sourceText), false)
				//println("M="+mods.size)
				return null
			} 
			if(parent.function instanceof Atom) {
				if(atom==parent.function) {
					val qname = QualifiedName::create(parent.module.sourceText, parent.function.sourceText+"/1")
					println("F="+qname)
					val rfun = index.getExportedObjects(ErlangPackage$Literals::FUNCTION, qname, false)
					//println("..."+rfun.size)
					//rfun.forEach[println("$$ "+it)]
					return null
				}
			} 
			println(" !!!! Can't resolve remote target "+parent.sourceText)
			return null
		}
		return null
	}
	def dispatch AtomRefTarget getAtomReferenceFor(FunCall parent, Atom atom, INode node) {
		return parent.module.getFunction(parent.target.sourceText, parent.args.size)
	}
	def dispatch AtomRefTarget getAtomReferenceFor(FunRef parent, Atom atom, INode node) {
		val arity = parent.arity_.sourceText
		println("FUNREF "+parent.sourceText)
		try {
			return parent.module.getFunction(parent.function_.sourceText, Integer::parseInt(arity))
		} catch (Exception e) {
			return null
		}
	}

}
