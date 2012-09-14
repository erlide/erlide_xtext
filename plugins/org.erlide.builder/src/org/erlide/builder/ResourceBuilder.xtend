package org.erlide.builder

import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor

class ResourceBuilder extends AbstractErlangBuilder {
	

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