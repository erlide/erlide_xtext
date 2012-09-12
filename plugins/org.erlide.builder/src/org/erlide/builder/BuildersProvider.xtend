package org.erlide.builder

import java.util.Map
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IConfigurationElement
import org.eclipse.core.runtime.IExtensionRegistry
import org.eclipse.core.runtime.Platform
import java.util.Collection
import java.util.Collections
import com.google.inject.Singleton

@Singleton
class BuildersProvider {
    Map<String, IErlangBuilder> builders;
    
	new() {
		builders = newHashMap()
	}

	def Collection<IErlangBuilder> get() {
		if(builders.empty) {
			loadBuilderExtensions()
		}
		Collections::unmodifiableCollection(builders.values)
	}

	def IErlangBuilder get(String id) {
		if(builders.empty) {
			loadBuilderExtensions()
		}
		builders.get(id)		
	}

    def private void loadBuilderExtensions() {
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

}