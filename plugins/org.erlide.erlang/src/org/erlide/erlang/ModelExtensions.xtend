package org.erlide.erlang

import java.util.Collection
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import com.google.common.collect.Iterables
class ModelExtensions {
    
    // Module
    
    def static String getName(Module module) {
        val attr = module.forms.head
        if(attr instanceof ModuleAttribute) { 
            (attr as ModuleAttribute).name
        } else {
            null
        }     
    }

    def static boolean isHeader(Module module) {
        getName(module) == null
    }

    def static Collection<Attribute> getAttributes(Module module) {
        module.eContents.filter(typeof(Attribute)).toList
    }

    def static Collection<CustomAttribute> getCustomAttributesWithTag(Module module, String mytag) {
        module.eContents.filter(typeof(CustomAttribute)).filter[
            tag == mytag
        ].toList
    }

    def static Collection<ExportAttribute> getExportAttributes(Module module) {
    	getAttributes(module, typeof(ExportAttribute))
    }

    def static Collection<ImportAttribute> getImportAttributes(Module module) {
    	getAttributes(module, typeof(ImportAttribute))
    }

	def static Collection<SpecAttribute> getSpecs(Module module) {
		getAttributes(module, typeof(SpecAttribute))
	}
	
    def private static <T> Collection<T> getAttributes(Module module, Class<T> type) {
        module.eContents.filter(type).toList
    }

    def static boolean exportsFunction(Module module, Function function) {
        getExportedFunctions(module).contains(function)
    } 

    def static boolean exports(Module module, FunRef function) {
        getExportedFunctions(module).contains(function)
    } 

	def static Collection<Function> getExportedFunctions(Module module) {
		val exportAttributes = getExportedFunRefs(module)
		exportAttributes.map[getFunction(module, it)].toList
	}
	
	def static Collection<FunRef> getExportedFunRefs(Module module) {
		val exportAttributes = getExportAttributes(module)
		Iterables::concat(exportAttributes.map[funs]).toList
	}
	
	def static Function getFunction(Module module, String fname, int farity) {
		module.eContents.filter(typeof(Function)).findFirst[
			name==fname && getArity(it)==farity
		]
	}
	
 	def static Function getFunction(Module module, FunRef ref) {
 		getFunction(module, ref.function, Integer::parseInt(ref.arity))
 	}
    
 	def static Function getFunction(Module module, SpecFun ref) {
 		getFunction(module, ref.function, Integer::parseInt(ref.arity))
 	}
 	
 	def static Collection<CompilerOptionsAttribute> getCompilerOptions(Module module) {
		getAttributes(module, typeof(CompilerOptionsAttribute))
 	}
    
 	def static SpecAttribute getSpec(Module module, String fname, int farity) {
		val specs = getSpecs(module)
		specs.findFirst[
			ref.function==fname && getSpecArity(it)==farity
		]		
	}

    // Function
    
    def static int getArity(Function fun) {
    	fun.clauses.head.params.size
    }
    
    def static boolean isExported(Function function) {
    	exportsFunction(getModule(function), function)
    }
 
 	def static SpecAttribute getSpec(Function function) {
		val module = getModule(function)
		val specs = getSpecs(module)
		specs.findFirst[
			ref.function==function.name && getSpecArity(it)==getArity(function)
		]		
	}

    // Other
    
    def static dispatch Module getModule(Module element) {
        element
    }

    def static dispatch Module getModule(EObject element) {
        val parent = element.eContainer
        getModule(parent)
    }
 
    def static String getSourceName(EObject atom) {
        val nodes = NodeModelUtils::getNode(atom).leafNodes
        nodes.filter[!isHidden].head.text
   }
 
 	def static int getSpecArity(SpecAttribute spec) {
 		if (spec.ref.arity!=null) {
 			Integer::parseInt(spec.ref.arity)
		} else {
	 		spec.signatures.head.decl.args.size
 		}
 	}
   
}