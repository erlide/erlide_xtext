package org.erlide.builder

import java.util.Map
import org.eclipse.core.runtime.IExtensionRegistry
import org.eclipse.core.runtime.IConfigurationElement
import org.eclipse.core.runtime.Platform
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.resources.IProject
import org.erlide.builder.resourcecompiler.ErlCompiler
import javax.inject.Inject

class BuildersProvider {
	    Map<String, IErlangBuilder> builders;
	    
		new() {
			builders = newHashMap()
		}
	
	    def void loadBuilders() {
        val IExtensionRegistry reg = Platform::getExtensionRegistry()
        val IConfigurationElement[] elements = reg.getConfigurationElementsFor("org.erlide.builder.builders")
        for (element : elements) {
            try {
            	val builder = element.createExecutableExtension("class") as IErlangBuilder
            	// TODO builder.setProject(project)
            	builder.loadConfiguration()
                //builders.put(getBuilderId(project), builder);
            } catch (CoreException e) {
                // ignore
            }
        }
    }
	
	def String getBuilderId(IProject project) {
		// TODO get compilerId from project settings
		ErlCompiler::COMPILER_ID
	}

	
}