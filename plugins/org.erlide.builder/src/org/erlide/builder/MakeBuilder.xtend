package org.erlide.builder

import org.eclipse.core.resources.IProject

class MakeBuilder extends ExternalBuilder {

	new() {
		super()
	}

	new(IProject project, BuilderMarkerUpdater markerUpdater) {
		super(project, markerUpdater)
	}
	
	new(IProject project, BuilderMarkerUpdater markerUpdater, BuilderExecutor executor) {
		super(project, markerUpdater, executor)
		cleanCmdLine = newArrayList("make", "clean")
		fullCmdLine = newArrayList("make", "beam")
		singleCmdLine = newArrayList("make", "-W", "$file")
	}
	
}