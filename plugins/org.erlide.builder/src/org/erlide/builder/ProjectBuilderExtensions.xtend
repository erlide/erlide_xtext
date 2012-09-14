package org.erlide.builder

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.Path
import org.erlide.common.util.ErlLogger

class ProjectBuilderExtensions {
	
	def static getLinkedContent(IProject project) {
		val links = project.members.filter [linked]
		if(links.size>1) {
			ErlLogger::instance.warn("too many links in project %s...", project.name)
		}
		return links.head
	}
	
	def static getPathInProject(IProject project, IPath path) {
		val link =  getLinkedContent(project)
		new Path(link.name).append(path)
	}	
}