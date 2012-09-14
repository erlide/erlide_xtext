package org.erlide.builder.progress

import com.google.common.eventbus.EventBus
import com.google.inject.Inject
import com.google.inject.name.Named
import org.erlide.common.util.ErlLogger
import com.google.common.eventbus.Subscribe
import org.erlide.builder.progress.ProgressEvent

class BuilderProgressUpdater {

	EventBus builderEventBus

	@Inject
	new(@Named("erlangBuilder") EventBus builderEventBus) {
		this.builderEventBus = builderEventBus
		builderEventBus.register(this)		
	}

	@Subscribe
	def handleProgressEvent(ProgressEvent event) {
		ErlLogger::instance.debug("PROGRESS "+event)
	}	
	
}