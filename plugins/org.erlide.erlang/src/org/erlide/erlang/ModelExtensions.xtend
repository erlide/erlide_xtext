package org.erlide.erlang

import com.google.common.collect.Iterables
import com.google.inject.Inject
import java.util.Collection
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.IResourceDescriptions

import static org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

import static extension org.erlide.erlang.ModelExtensions.*
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.emf.ecore.resource.ResourceSet

class ModelExtensions {
    
	@Inject
	IQualifiedNameProvider namer
    
    // Module

	def Module getModule(IResourceDescriptions index, String name, ResourceSet rset) {
		val qname = QualifiedName::create(name)
		val descr = index.getExportedObjects(ErlangPackage$Literals::MODULE, qname, false)
		if(descr.empty)
			return null
		rset.getEObject(descr.head.EObjectURI, true) as Module
	}
    
    def String getName(Module module) {
        val attr = module.forms.head
        if(attr instanceof ModuleAttribute) { 
            (attr as ModuleAttribute).moduleName.replaceAll("\\.", "_")
        } else {
            null
        }     
    }

    def boolean isHeader(Module module) {
        module.name == null
    }

    def Collection<Attribute> getAllItemsOfType(Module module) {
        module.eContents.filter(typeof(Attribute)).toList
    }

    def Collection<CustomAttribute> getCustomAttributesWithTag(Module module, String mytag) {
        module.eContents.filter(typeof(CustomAttribute)).filter[
            tag == mytag
        ].toList
    }

    def Collection<ExportAttribute> getExportAttributes(Module module) {
    	module.getAllItemsOfType(typeof(ExportAttribute))
    }

    def Collection<ImportAttribute> getImportAttributes(Module module) {
    	module.getAllItemsOfType(typeof(ImportAttribute))
    }

	def Collection<SpecAttribute> getSpecs(Module module) {
		module.getAllItemsOfType(typeof(SpecAttribute))
	}
	
	def Collection<String> getIncludes(Module module) {
		module.getAllItemsOfType(typeof(IncludeAttribute)).map[importURI].toList
	}
	
	def Collection<String> getIncludeLibs(Module module) {
		module.getAllItemsOfType(typeof(IncludeLibAttribute)).map[importURI].toList
	}
	
//	def Collection<Module> getIncludes(Module module) {
//		module.getAttributes(typeof(IncludeAttribute)).map[value].toList
//	}
//	
//	def Collection<Module> getIncludeLibs(Module module) {
//		module.getAttributes(typeof(IncludeLibAttribute)).map[value].toList
//	}
	
    def boolean exportsFunction(Module module, Function function) {
        module.declaredExportNames.contains(namer.getFullyQualifiedName(function).lastSegment) || module.exportsAll
    } 

	def Collection<Function> getDeclaredExports(Module module) {
		val exported = getExportAttributes(module)
		val refs = Iterables::concat(exported.map[funs])
		val xx = refs.map[module.getFunction(it)].toList
		println("!"+xx)
		xx
	}
	
	def Collection<String> getDeclaredExportNames(Module module) {
		val exported = getExportAttributes(module)
		val refs = Iterables::concat(exported.map[funs])
		refs.map[getTokenText(findActualNodeFor(it))].toList
	}
	
	def Collection<EObject> getAllContents(EObject element) {
		val result = element.eContents
		result.map[
			switch it {
				ConditionalFormBlock: it.getAllContents 
				ConditionalAttribute: newArrayList()
				default: newArrayList(it)
			}
		].flatten.toList
	} 
	
	def Function getFunction(Module module, String fname, int farity) {
		module.allContents.filter(typeof(Function)).findFirst[
			it.name==fname && it.arity==farity
		]
	}
	
	def Function getFunction(Module module, FunRef ref) {
		module.allContents.filter(typeof(Function)).findFirst[
			it.name==ref.function_.sourceText && it.arity==Integer::parseInt(ref.arity_.sourceText)
		]
	}
	
    def boolean exportsAll(Module module) {
    	module.compileOptions.exists[it.hasAtom("export_all")]
    }
    
	def Collection<Atom> getParseTransforms(Module module) {
		val options = module.compileOptions
		val tuples = options.filter(typeof(ErlTuple))
		tuples.filter[it.parseTransformTuple].map[elements.tail.head as Atom].toList
	}

 	def SpecAttribute getSpec(Module module, String fname, int farity) {
		val specs = getSpecs(module)
		specs.findFirst[
			ref.function_.sourceText==fname && it.specArity==farity
		]		
	}
	
    // Function
    
    def int getArity(Function fun) {
    	fun.clauses.head?.params?.exprs?.size
    }
    
    def boolean isExported(Function function) {
    	function.module.exportsFunction(function)
    }
 
 	def SpecAttribute getSpec(Function function) {
		val module = function.module
		val specs = module.specs
		specs.findFirst[
			ref.function_.sourceText==function.name && it.specArity==function.arity
		]		
	}

    // Other
    
    def dispatch Module getModule(Module element) {
        element
    }

    def dispatch Module getModule(EObject element) {
        element.eContainer.module
    }
 
    def String getSourceText(EObject obj) {
    	val node = getNode(obj)
    	if(node==null){
    		return null
    	}
        node.leafNodes.filter[!isHidden].map[text].join(" ")
    }
 
  	def int getSpecArity(SpecAttribute spec) {
 		if (spec.ref.arity_!=null) {
 			Integer::parseInt(spec.ref.arity_.sourceText)
		} else {
	 		spec.signatures.head.decl.args.size
 		}
 	}
   
   // Utilities
   
    def static <T> Collection<T> getItemsOfType(EObject obj, Class<T> type) {
        obj.eContents.filter(type).toList
    }

    def static <T> Collection<T> getAllItemsOfType(EObject obj, Class<T> type) {
        val direct = obj.getItemsOfType(type).toList
        val ifblocks = obj.getItemsOfType(typeof(ConditionalFormBlock))
        direct.addAll(ifblocks.map[it.getAllItemsOfType(type)].flatten.toList)
        direct
    }

 	def static Collection<Expression> getRawCompileOptions(Module module) {
		module.getAllItemsOfType(typeof(CompileAttribute)).map[options].toList
 	}
    
    def private dispatch Set<Expression> merge(Set<Expression> acc, ErlList x) {
    	acc.addAll(x.elements)
    	acc
    }
    def private dispatch Set<Expression> merge(Set<Expression> acc, Expression x) {
    	acc.add(x)
    	acc
    }
    
  	def Collection<Expression> getCompileOptions(Module module) {
 		val Set<Expression> seed = newTreeSet[a, b | a.sourceText.compareTo(b.sourceText)]
		module.rawCompileOptions.fold(seed)[acc, item | merge(acc, item)]
 	}
    
    def private dispatch boolean hasAtom(Atom atom, String s){
		atom.sourceText == s    	
    }
    def private dispatch boolean hasAtom(ErlList list, String s){
		list.elements.exists[it.hasAtom(s)]    	
    }
    def private dispatch boolean hasAtom(Expression expr, String s){
		false    	
    }

	def private boolean parseTransformTuple(ErlTuple expr) {
		if(expr.elements.size!=2 || !(expr.elements.head instanceof Atom)) return false
		val hd = expr.elements.head as Atom
		return hd.sourceText=="parse_transform" && expr.elements.tail.head instanceof Atom
	}
	
	def EObject getObjectAtOffset(EObject src, int offset){
		val elem = findLeafNodeAtOffset(getNode(src), offset)
       	findActualSemanticObjectFor(elem)
	}

}


