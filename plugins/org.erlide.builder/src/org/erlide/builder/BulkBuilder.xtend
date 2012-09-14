package org.erlide.builder

import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.erlide.builder.BuilderMarkerUpdater

class BulkBuilder extends AbstractErlangBuilder {
	

	override clean(IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override fullBuild(IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	

}