package org.erlide.scoping

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.erlide.erlang.Atom
import org.erlide.erlang.AtomRefTarget
import org.erlide.erlang.ErlangPackage$Literals
import org.erlide.erlang.FunCall
import org.erlide.erlang.FunRef
import org.erlide.erlang.Macro
import org.erlide.erlang.ModelExtensions
import org.erlide.erlang.RecordExpr
import org.erlide.erlang.RecordFieldExpr
import org.erlide.erlang.RecordTuple
import org.erlide.erlang.RemoteTarget

class ErlangLinkingHelper {
	@Inject
	extension ModelExtensions
    @Inject
    ResourceDescriptionsProvider indexProvider

	def ErlangLinkCategory classifyAtom(Atom obj) {
		classifyAtom(obj, obj.eContainer)
	} 

	def private dispatch ErlangLinkCategory classifyAtom(Atom atom, EObject context) {
		ErlangLinkCategory::NONE
	}
	def private dispatch ErlangLinkCategory classifyAtom(Atom atom, RemoteTarget context) {
		if(atom==context.module) {
			return ErlangLinkCategory::MODULE
		} 
		if(atom==context.function) {
			if(context.module instanceof Atom) {
				if(context.function instanceof Atom) {
					return ErlangLinkCategory::FUNCTION_CALL_REMOTE
				}
			} 
			if(context.module instanceof Macro) {
				val macro = context.module as Macro
				if(macro.sourceText=="? MODULE") {
					return ErlangLinkCategory::FUNCTION_CALL_REMOTE
				}
			}
		}
		return ErlangLinkCategory::NONE
	}
	def private dispatch ErlangLinkCategory classifyAtom(Atom atom, FunCall context) {
		ErlangLinkCategory::FUNCTION_CALL_LOCAL
	}
	def private dispatch ErlangLinkCategory classifyAtom(Atom atom, FunRef context) {
		if(atom==context.module) {
			return ErlangLinkCategory::MODULE
		} 
		if(atom==context.function) {
			if(context.module instanceof Atom || context.module==null) {
				return ErlangLinkCategory::FUNCTION_REF
			}
			if(context.module instanceof Macro) {
				val macro = context.module as Macro
				if(macro.sourceText=="? MODULE") {
					return ErlangLinkCategory::FUNCTION_REF
				}
			}
		}
		ErlangLinkCategory::NONE
	}
	def private dispatch ErlangLinkCategory classifyAtom(Atom atom, RecordExpr context) {
		if(context.rec instanceof Atom) {
			if(context.rec==atom) 
				return ErlangLinkCategory::RECORD
			if(context.field==atom) 
				return ErlangLinkCategory::RECORD_FIELD
		}
		ErlangLinkCategory::NONE
	}
	def private dispatch ErlangLinkCategory classifyAtom(Atom atom, RecordFieldExpr context) {
		if(context.eContainer instanceof RecordExpr) {
			val expr = context.eContainer as RecordExpr
			if(expr.rec instanceof Atom) { 
				return ErlangLinkCategory::RECORD_FIELD
			}
		}
		if(context.eContainer instanceof RecordTuple) {
			if(context.eContainer.eContainer instanceof RecordExpr) {
				val expr = context.eContainer.eContainer as RecordExpr
				if(expr.rec instanceof Atom) { 
					return ErlangLinkCategory::RECORD_FIELD
				}
			}
		}
		ErlangLinkCategory::NONE
	}

	def boolean isLinkableAtom(Atom atom) {
		classifyAtom(atom) != ErlangLinkCategory::NONE
	}
	
	def AtomRefTarget getAtomReference(Atom atom) {
		val index = indexProvider.getResourceDescriptions(atom.eResource)
		val rset = atom.eResource.resourceSet
		switch(atom.classifyAtom) {
			case ErlangLinkCategory::NONE:
				null
			case ErlangLinkCategory::MODULE:
				index.findModule(atom.sourceText, rset)
			case ErlangLinkCategory::FUNCTION_CALL_LOCAL: {
				val parent = atom.eContainer as FunCall
				val arity = parent.args?.exprs?.size?:0
				parent.owningModule.getFunction(parent.target.sourceText, arity)
			}
			case ErlangLinkCategory::FUNCTION_CALL_REMOTE: {
				val parent = atom.eContainer as RemoteTarget
				val call = parent.eContainer as FunCall
				val arity = call.args?.exprs?.size?:0
				val qname = QualifiedName::create(parent.module.sourceText, parent.function.sourceText+"/"+arity)
				val rfun = index.getExportedObjects(ErlangPackage$Literals::FUNCTION, qname, false)
				if(!rfun.empty) 
					return rset.getEObject(rfun.head.EObjectURI, true) as AtomRefTarget
			}
			case ErlangLinkCategory::FUNCTION_REF: {
				val parent = atom.eContainer as FunRef
				val arity = parent.arity.sourceText
				try {
					return parent.owningModule.getFunction(parent.function.sourceText, Integer::parseInt(arity))
				} catch (Exception e) {
					return null
				}
			}
			case ErlangLinkCategory::RECORD:
				null
			case ErlangLinkCategory::RECORD_FIELD:
				null
		}
	}		
	
}