package org.erlide.builder

import java.util.Map
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IConfigurationElement
import org.eclipse.core.runtime.IExtensionRegistry
import org.eclipse.core.runtime.Platform

class BuildersProvider {
    Map<String, IErlangBuilder> builders;
    
	new() {
		builders = newHashMap()
	}

    def protected void loadBuilders() {
        val IExtensionRegistry reg = Platform::getExtensionRegistry()
        val IConfigurationElement[] elements = reg.getConfigurationElementsFor("org.erlide.builder.builders")
        for (element : elements) {
            try {
            	val builder = element.createExecutableExtension("class") as IErlangBuilder
            	BuilderPlugin::instance.injector.injectMembers(builder)
                builders.put(builder.id, builder)
            } catch (CoreException e) {
                // ignore
            }
        }
    }

	def IErlangBuilder get(String id) {
		if(builders.empty) {
			loadBuilders()
		}
		builders.get(id)		
	}

}