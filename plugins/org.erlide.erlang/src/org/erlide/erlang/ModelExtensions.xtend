package org.erlide.erlang

import com.google.common.collect.Iterables
import java.util.Collection
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

import static extension org.erlide.erlang.ModelExtensions.*
import org.erlide.erlang.ConditionalFormBlock
import org.erlide.erlang.ConditionalAttribute

class ModelExtensions {
    
    // Module
    
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

    def Collection<Attribute> getAttributes(Module module) {
        module.eContents.filter(typeof(Attribute)).toList
    }

    def Collection<CustomAttribute> getCustomAttributesWithTag(Module module, String mytag) {
        module.eContents.filter(typeof(CustomAttribute)).filter[
            tag == mytag
        ].toList
    }

    def Collection<ExportAttribute> getExportAttributes(Module module) {
    	module.getAttributes(typeof(ExportAttribute))
    }

    def Collection<ImportAttribute> getImportAttributes(Module module) {
    	module.getAttributes(typeof(ImportAttribute))
    }

	def Collection<SpecAttribute> getSpecs(Module module) {
		module.getAttributes(typeof(SpecAttribute))
	}
	
	def Collection<String> getIncludes(Module module) {
		module.getAttributes(typeof(IncludeAttribute)).map[importURI].toList
	}
	
	def Collection<String> getIncludeLibs(Module module) {
		module.getAttributes(typeof(IncludeLibAttribute)).map[importURI].toList
	}
	
//	def Collection<Module> getIncludes(Module module) {
//		module.getAttributes(typeof(IncludeAttribute)).map[value].toList
//	}
//	
//	def Collection<Module> getIncludeLibs(Module module) {
//		module.getAttributes(typeof(IncludeLibAttribute)).map[value].toList
//	}
	
    def boolean exportsFunction(Module module, Function function) {
        module.exportedFunctions.contains(function)
    } 

    def boolean exports(Module module, FunRef function) {
        module.exportedFunctions.contains(function)
    } 

	def Collection<Function> getExportedFunctions(Module module) {
		val exportedRefs = getExportedFunRefs(module)
		exportedRefs.map[module.getFunction(it)].toList
	}
	
	def Collection<FunRef> getExportedFunRefs(Module module) {
		val exportAttributes = getExportAttributes(module)
		Iterables::concat(exportAttributes.map[funs]).toList
	}
	
	def Collection<EObject> getAllContents(EObject module) {
		val result = module.eContents
		result.map[
			if(it instanceof ConditionalFormBlock) {
				it.getAllContents 
			} else if(it instanceof ConditionalAttribute) {
				newArrayList()
			} else {
				newArrayList(it)
			}
		].flatten.toList
	} 
	
	def Function getFunction(Module module, String fname, int farity) {
		module.allContents.filter(typeof(Function)).findFirst[
			it.name==fname && it.arity==farity
		]
	}
	
 	def Function getFunction(Module module, FunRef ref) {
 		//ref.function
 		module.getFunction(ref.function, Integer::parseInt(ref.arity))
 	}
    
 	def Function getFunction(Module module, SpecFun ref) {
 		module.getFunction(ref.function, Integer::parseInt(ref.arity))
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
			ref.function==fname && it.specArity==farity
		]		
	}
	
    // Function
    
    def int getArity(Function fun) {
    	fun.clauses.head?.params?.size
    }
    
    def boolean isExported(Function function) {
    	function.module.exportsFunction(function)
    }
 
 	def SpecAttribute getSpec(Function function) {
		val module = function.module
		val specs = module.specs
		specs.findFirst[
			ref.function==function.name && it.specArity==function.arity
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
    	val node = NodeModelUtils::getNode(obj)
    	if(node==null){
    		return null
    	}
        node.leafNodes.filter[!isHidden].map[text].join(" ")
    }
 
  	def int getSpecArity(SpecAttribute spec) {
 		if (spec.ref.arity!=null) {
 			0 //spec.ref.arity
		} else {
	 		spec.signatures.head.decl.args.size
 		}
 	}
   
   // Utilities
   
    def static <T> Collection<T> getAttributes(Module module, Class<T> type) {
        module.eContents.filter(type).toList
    }

 	def static Collection<Expression> getRawCompileOptions(Module module) {
		module.getAttributes(typeof(CompileAttribute)).map[options].toList
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
	
}


