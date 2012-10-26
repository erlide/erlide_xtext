package org.erlide.erlang

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.IResourceServiceProvider

class ScopeExtensions {
    @Inject
    IResourceServiceProvider$Registry resourceProviderRegistry

 	def getIndexProvider(Resource res) {
 		resourceProviderRegistry.getResourceServiceProvider(res.URI).resourceDescriptionManager
 	}
    
	def getDescription(Module module) {
		val res = module.eResource
 		getIndexProvider(res).getResourceDescription(res)
	}

	def getExportedDescriptions(Module module) {
        module.description.exportedObjects
	}

	def getExportedFunctions(Module module) {
        module.description.getExportedObjectsByType(ErlangPackage$Literals::FUNCTION)
	}

	def getExportedMacros(Module module) {
        module.description.getExportedObjectsByType(ErlangPackage$Literals::DEFINE_ATTRIBUTE)
	}

	def getExportedRecords(Module module) {
        module.description.getExportedObjectsByType(ErlangPackage$Literals::RECORD_ATTRIBUTE)
	}
	
}