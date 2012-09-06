package org.erlide.builder

import org.erlide.common.AbstractGuiceAwareExecutableExtensionFactory

class BuilderExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	override protected getBundle() {
		BuilderPlugin::instance.bundle
	}
	
	override protected getInjector() {
		BuilderPlugin::instance.injector
	}
	
}