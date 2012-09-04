package org.erlide.builder

import org.eclipse.core.resources.IProject

abstract class AbstractErlangBuilder implements IErlangBuilder {
	@Property IProject project
	@Property BuilderMarkerUpdater markerUpdater
	
	new()  {
	}

	new(IProject project, BuilderMarkerUpdater markerUpdater) {
		this._project = project
		this._markerUpdater = markerUpdater
	}
	
	override getId() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
}