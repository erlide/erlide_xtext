package org.erlide.project.buildpath.convert

import java.util.Collection
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IPath
import org.erlide.project.buildpath.BuildpathContainer
import org.erlide.project.buildpath.BuildpathFolder
import org.erlide.project.buildpath.IBuildpathContainer
import org.erlide.project.buildpath.IBuildpathContainer$ContainerKind
import org.erlide.project.buildpath.IBuildpathEntry
import org.erlide.project.buildpath.IBuildpathFolder
import org.erlide.project.buildpath.IBuildpathFolder$FolderKind
import java.util.Map
import org.eclipse.core.runtime.Path
import java.io.FileNotFoundException

class OldProjectBuildpathConverter implements IOldProjectBuildpathConverter {

	override IBuildpathEntry convert(IProject project) {
		val externals = new PathExpander().expandFile(new Path(".settings/modules.erlidex"), newHashMap())
		convert(getOldProjectProperties(project), project.name, project.referencedProjects.map[name], externals)
	}
	
	def IBuildpathEntry convert(OldErlangProjectProperties properties, String name, 
		Collection<String>refProjects, Collection<IPath> externals) {
		println("CONVERTING "+properties.debugPrint)
		val result = new BuildpathContainer(null, "root", ContainerKind::ROOT)
		val IBuildpathContainer crt = newContainer(result, name,  ContainerKind::FRAGMENT)
		properties.sourceDirs.forEach [
			newFolder(crt, it.lastSegment,  it, FolderKind::SOURCE)
		]
		properties.includeDirs.forEach [
			newFolder(crt, it.lastSegment,  it, FolderKind::INCLUDE)
		]
		properties.outputDirs.forEach [
			newFolder(crt, it.lastSegment,  it, FolderKind::EBIN)
		]
		
		val otp = newContainer(result, properties.runtimeVersion.toString, ContainerKind::OTP)

		refProjects.forEach [
			newContainer(result, it, ContainerKind::LIBRARY)
		]
		
		try {
			val roots = externals.map[segments.head].toSet
			for(root: roots) {
				newContainer(result, root, ContainerKind::LIBRARY)
			}
		} catch (FileNotFoundException e) {
			// ignore? 
			println("? "+e)
		}
		
		return result
	}
	
	def OldErlangProjectProperties getOldProjectProperties(IProject project) {
		new OldErlangProjectProperties(project)
	}
	
	def String debugPrint(OldErlangProjectProperties props) {
		'''
			Properties {
				src = «PathSerializer::packList(props.sourceDirs)»
				inc = «PathSerializer::packList(props.includeDirs)»
				out = «PathSerializer::packList(props.outputDirs)»
				ver = «props.runtimeVersion»
				xmd = «props.externalModulesFile»
				xin = «props.externalIncludesFile»
			}
		'''
	}
	
	def IBuildpathContainer newContainer(IBuildpathContainer parent, String name, ContainerKind kind) {
		val result = new BuildpathContainer(parent, name, kind)
		parent.addChild(result)
		return result
	}

	def IBuildpathFolder newFolder(IBuildpathContainer parent, String name, IPath path, FolderKind kind) {
		val result = new BuildpathFolder(parent, name, null, path, kind)
		parent.addChild(result)
		return result
	}
	
	
		
}