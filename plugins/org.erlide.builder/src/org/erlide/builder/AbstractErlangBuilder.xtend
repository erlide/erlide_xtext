package org.erlide.builder

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IExecutableExtension
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IConfigurationElement
import com.google.inject.Inject
import com.google.inject.name.Named
import com.google.common.eventbus.EventBus

abstract class AbstractErlangBuilder implements IErlangBuilder, IExecutableExtension {
	@Property IProject project
	@Inject @Named("erlangBuilder") protected EventBus builderEventBus
	String id
	
	new()  {
		BuilderPlugin::instance.injector.injectMembers(this)
	}

	new(IProject project, EventBus eventBus) {
		this()
		this._project = project
		this.builderEventBus = eventBus
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