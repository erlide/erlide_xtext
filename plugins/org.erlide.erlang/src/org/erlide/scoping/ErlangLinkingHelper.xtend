package org.erlide.scoping

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.erlide.erlang.Atom
import org.erlide.erlang.AtomRefTarget
import org.erlide.erlang.DefineAttribute
import org.erlide.erlang.ErlangPackage$Literals
import org.erlide.erlang.FunCall
import org.erlide.erlang.FunRef
import org.erlide.erlang.Macro
import org.erlide.erlang.ModelExtensions
import org.erlide.erlang.RecordAttribute
import org.erlide.erlang.RecordExpr
import org.erlide.erlang.RecordFieldExpr
import org.erlide.erlang.RecordTuple
import org.erlide.erlang.RemoteTarget
import org.erlide.erlang.SpecAttribute

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
			if(context.module instanceof Atom && context.function instanceof Atom) {
				return ErlangLinkCategory::FUNCTION_CALL_REMOTE
			} 
			if(context.module.moduleMacro) {
				return ErlangLinkCategory::FUNCTION_CALL_REMOTE
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
			if(context.module instanceof Atom) {
				val parent = context.eContainer
				if(parent instanceof SpecAttribute) {
					return ErlangLinkCategory::FUNCTION_CALL_REMOTE
				}
				return ErlangLinkCategory::FUNCTION_REF_REMOTE
			}
			if(context.module==null) {
				val parent = context.eContainer
				if(parent instanceof SpecAttribute) {
					return ErlangLinkCategory::FUNCTION_CALL_LOCAL
				}
				return ErlangLinkCategory::FUNCTION_REF_LOCAL
			}
			if(context.module.moduleMacro) {
				return ErlangLinkCategory::FUNCTION_REF_REMOTE
			}
		}
		ErlangLinkCategory::NONE
	}
	def private dispatch ErlangLinkCategory classifyAtom(Atom atom, RecordExpr context) {
		if(context.rec==atom) 
			return ErlangLinkCategory::RECORD
		if(context.rec instanceof Atom && context.field==atom) 
			return ErlangLinkCategory::RECORD_FIELD
		ErlangLinkCategory::NONE
	}
	def private dispatch ErlangLinkCategory classifyAtom(Atom atom, RecordFieldExpr context) {
		val parent = context.eContainer
		switch(parent) {
			RecordExpr: {
				if(parent.rec instanceof Atom) { 
					return ErlangLinkCategory::RECORD_FIELD
				}
			}
			RecordTuple: {
				if(context.eContainer.eContainer instanceof RecordExpr) {
					val expr = context.eContainer.eContainer as RecordExpr
					if(expr.rec instanceof Atom) { 
						return ErlangLinkCategory::RECORD_FIELD
					}
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
		atom.classifyAtom.getRef(index, atom, rset)
	}
	
	def AtomRefTarget getModuleRef(IResourceDescriptions index, Atom atom, ResourceSet rset) { 
		index.findModule(atom.sourceText, rset)
	}
	
	def AtomRefTarget getLocalCallRef(IResourceDescriptions index, Atom atom, ResourceSet rset) { 
		val parent = atom.eContainer
		switch(parent) {
			FunCall: {
				val arity = parent.args?.exprs?.size?:0
				parent.owningModule.getFunction(parent.target.sourceText, arity)
			}
			FunRef: {
				val xparent = (parent.eContainer) as SpecAttribute
				val arity = xparent.signatures.head.decl.args?.size?:0
				parent.owningModule.getFunction(atom.sourceText, arity)
			}
			default:
				null	
		}
	}
		
	def AtomRefTarget getRemoteCallRef(IResourceDescriptions index, Atom atom, ResourceSet rset) { 
		val parent = atom.eContainer as RemoteTarget
		val call = parent.eContainer as FunCall
		val arity = call.args?.exprs?.size?:0
		val moduleName = if(parent.module.isModuleMacro) 
				atom.owningModule.name 
			else 
				parent.module.sourceText 
		val qname = QualifiedName::create(moduleName, parent.function.sourceText+"/"+arity)
		val rfun = index.getExportedObjects(ErlangPackage$Literals::FUNCTION, qname, false)
		if(!rfun.empty) 
			rset.getEObject(rfun.head.EObjectURI, true) as AtomRefTarget
	}
	
	def AtomRefTarget getRemoteFunRefRef(IResourceDescriptions index, Atom atom, ResourceSet rset) {
		val parent = atom.eContainer as FunRef
		val arity = parent.arity.sourceText
		val moduleName = if(parent.module.isModuleMacro) 
				atom.owningModule.name 
			else 
				parent.module.sourceText 
		val qname = QualifiedName::create(moduleName, parent.function.sourceText+"/"+arity)
		val rfun = index.getExportedObjects(ErlangPackage$Literals::FUNCTION, qname, false)
		if(!rfun.empty) 
			rset.getEObject(rfun.head.EObjectURI, true) as AtomRefTarget

	}
	
	def AtomRefTarget getLocalFunRefRef(IResourceDescriptions index, Atom atom, ResourceSet rset) { 
		val parent = atom.eContainer as FunRef
		val arity = parent.arity.sourceText
		try {
			parent.owningModule.getFunction(parent.function.sourceText, Integer::parseInt(arity))
		} catch (Exception e) {
			return null
		}
	}
	
	def AtomRefTarget getRecordRef(IResourceDescriptions index, Atom atom, ResourceSet rset) { 
		val moduleName = atom.owningModule.name
		val qname = QualifiedName::create(moduleName, atom.sourceText)
		val rfun = index.getExportedObjects(ErlangPackage$Literals::RECORD_ATTRIBUTE, qname, false)
		if(!rfun.empty) 
			rset.getEObject(rfun.head.EObjectURI, true) as AtomRefTarget
	}

	def private RecordExpr getRecordExprForField(EObject field) {
		switch(field){
			RecordExpr: {
				field as RecordExpr
			}
			default: {
				field.eContainer.recordExprForField
			}
		}
	}
	
	def AtomRefTarget getRecordFieldRef(IResourceDescriptions index, Atom atom, ResourceSet rset) {
		val recExpr = atom.recordExprForField
		val record = getRecordRef(index, recExpr.rec as Atom, rset) as RecordAttribute
		record.fields.findFirst[it.name==atom.sourceText]
	}
	
	def DefineAttribute getMacroReference(Macro macro) {
		macro.owningModule.getAllItemsOfType(typeof(DefineAttribute)).findFirst[macroName==macro.macroName]
	}

	def String getMacroName(Macro macro) {
		val txt = macro.sourceText
		if(txt.startsWith("? "))
			txt.substring(2)
		else 
			txt
	}
	
}