package org.erlide.scoping

import com.google.inject.Inject
import org.erlide.erlang.ModelExtensions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.erlide.erlang.AtomRefTarget
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.INode
import org.erlide.erlang.Atom
import org.erlide.erlang.RemoteTarget
import org.erlide.erlang.FunCall
import org.erlide.erlang.FunRef
import org.erlide.erlang.ErlangPackage
import org.eclipse.xtext.naming.QualifiedName
import org.erlide.erlang.Expression

class ErlangLinkingHelper {
	@Inject
	extension ModelExtensions
    @Inject
    ResourceDescriptionsProvider indexProvider

	def private AtomLinkingCategory classify(EObject obj) {
		return AtomLinkingCategory::NONE
	} 

	def dispatch boolean isLinkableContext(EObject context) {
		true
	}
	def dispatch boolean isLinkableContext(Expression context) {
		false
	}
	def dispatch boolean isLinkableContext(Atom context) {
		val parent = context.eContainer
		val result = ((parent instanceof RemoteTarget) && true) || 
			(parent instanceof FunCall) || 
			((parent instanceof FunRef) && true)
		result
	}
	
	def dispatch AtomRefTarget getAtomReference(EObject obj, INode node) {
		null
	}
	def dispatch AtomRefTarget getAtomReference(Atom atom, INode node) {
		val parent = atom.eContainer()
		getAtomReferenceFor(parent, atom, node)
	}		
	
	def private dispatch AtomRefTarget getAtomReferenceFor(EObject parent, Atom atom, INode node) {
		null
	}
	def private dispatch AtomRefTarget getAtomReferenceFor(RemoteTarget parent, Atom atom, INode node) {
		val index = indexProvider.getResourceDescriptions(atom.eResource)
		val rset = atom.eResource.resourceSet
		if(parent.module instanceof Atom) {
			if(atom==parent.module) {
				return index.getModule(atom.sourceText, rset)
			} 
			if(parent.function instanceof Atom) {
				if(atom==parent.function) {
					val arity = (parent.eContainer as FunCall).args.size
					val qname = QualifiedName::create(parent.module.sourceText, parent.function.sourceText+"/"+arity)
					val rfun = index.getExportedObjects(ErlangPackage$Literals::FUNCTION, qname, false)
					if(!rfun.empty) 
						return rset.getEObject(rfun.head.EObjectURI, true) as AtomRefTarget
				}
			} 
			return null
		}
		return null
	}
	def private dispatch AtomRefTarget getAtomReferenceFor(FunCall parent, Atom atom, INode node) {
		return parent.module.getFunction(parent.target.sourceText, parent.args.size)
	}
	def private dispatch AtomRefTarget getAtomReferenceFor(FunRef parent, Atom atom, INode node) {
		val arity = parent.arity_.sourceText
		try {
			return parent.module.getFunction(parent.function_.sourceText, Integer::parseInt(arity))
		} catch (Exception e) {
			return null
		}
	}

}