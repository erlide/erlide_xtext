package org.erlide.scoping

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.erlide.erlang.Atom
import org.erlide.erlang.AtomRefTarget
import org.erlide.erlang.ErlangPackage$Literals
import org.erlide.erlang.FunCall
import org.erlide.erlang.FunRef
import org.erlide.erlang.ModelExtensions
import org.erlide.erlang.RemoteTarget
import org.erlide.erlang.RecordExpr
import org.erlide.erlang.RecordFieldExpr

class ErlangLinkingHelper {
	@Inject
	extension ModelExtensions
    @Inject
    ResourceDescriptionsProvider indexProvider

	def private dispatch ErlangLinkCategory classify(EObject obj) {
		ErlangLinkCategory::NONE
	} 
	def private dispatch ErlangLinkCategory classify(Atom obj) {
		classifyAtom(obj, obj.eContainer)
	} 

	def private dispatch ErlangLinkCategory classifyAtom(Atom atom, EObject context) {
		ErlangLinkCategory::NONE
	}
	def private dispatch ErlangLinkCategory classifyAtom(Atom atom, RemoteTarget context) {
		if(context.module instanceof Atom) {
			if(atom==context.module) {
				return ErlangLinkCategory::MODULE
			} 
			if(context.function instanceof Atom) {
				if(atom==context.function) {
					return ErlangLinkCategory::FUNCTION_CALL
				}
			} 
		}
		return ErlangLinkCategory::NONE
	}
	def private dispatch ErlangLinkCategory classifyAtom(Atom atom, FunCall context) {
		ErlangLinkCategory::FUNCTION_CALL
	}
	def private dispatch ErlangLinkCategory classifyAtom(Atom atom, FunRef context) {
		ErlangLinkCategory::FUNCTION_REF
	}
	def private dispatch ErlangLinkCategory classifyAtom(Atom atom, RecordExpr context) {
		ErlangLinkCategory::RECORD
	}
	def private dispatch ErlangLinkCategory classifyAtom(Atom atom, RecordFieldExpr context) {
		ErlangLinkCategory::RECORD_FIELD
	}

	def boolean isLinkableAtom(Atom atom) {
		classify(atom) != ErlangLinkCategory::NONE
	}
	
	def AtomRefTarget getAtomReference(EObject obj) {
		switch(classify(obj)) {
			case ErlangLinkCategory::NONE:
				null
			case ErlangLinkCategory::MODULE:
				null
			case ErlangLinkCategory::FUNCTION_CALL:
				null
			case ErlangLinkCategory::FUNCTION_REF:
				null
			case ErlangLinkCategory::RECORD:
				null
			case ErlangLinkCategory::RECORD_FIELD:
				null
		}
	}		
	
	def private dispatch AtomRefTarget getAtomReferenceFor(EObject parent, Atom atom) {
		null
	}
	def private dispatch AtomRefTarget getAtomReferenceFor(RemoteTarget parent, Atom atom) {
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
	def private dispatch AtomRefTarget getAtomReferenceFor(FunCall parent, Atom atom) {
		return parent.module.getFunction(parent.target.sourceText, parent.args.size)
	}
	def private dispatch AtomRefTarget getAtomReferenceFor(FunRef parent, Atom atom) {
		val arity = parent.arity_.sourceText
		try {
			return parent.module.getFunction(parent.function_.sourceText, Integer::parseInt(arity))
		} catch (Exception e) {
			return null
		}
	}

}