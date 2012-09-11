package org.erlide.builder

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IExecutableExtension
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IConfigurationElement
import com.google.inject.Inject

abstract class AbstractErlangBuilder implements IErlangBuilder, IExecutableExtension {
	@Property IProject project
	@Property @Inject BuilderMarkerUpdater markerUpdater
	String id
	
	new()  {
		BuilderPlugin::instance.injector.injectMembers(this)
	}

	new(IProject project, BuilderMarkerUpdater markerUpdater) {
		this()
		this._project = project
		this._markerUpdater = markerUpdater
	}
	
	override setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
		id = config.getAttribute("id")
	}
	
	override String getId() {
		id
	}
		
	override loadConfiguration() {
		// do nothing by default
	}
	
	
}