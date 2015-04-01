package org.erlide.project.buildpath.convert

import java.io.FileNotFoundException
import java.util.Collection
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.Path
import org.erlide.project.buildpath.BuildpathApp
import org.erlide.project.buildpath.BuildpathEntry
import org.erlide.project.buildpath.BuildpathFolder
import org.erlide.project.buildpath.BuildpathLibrary
import org.erlide.project.buildpath.FolderKind

class OldProjectBuildpathConverter {

   /**
     * Old-style projects will be converted to a buildpath consisting of the
     * following containers:
     * <ul>
     * <li>the project proper, with folders for all source & include paths</li>
     * <li>the OTP library</li>
     * <li>referenced projects</li>
     * </ul>
     *
     * If "external modules" has references to modules not in any referenced
     * project, they will be lost. We could scan and compare to the projects, in
     * order to extract the real external libraries, but at the moment it feels
     * too much work for too little benefit.
     *
     * Project must have an old Erlang nature.
     */
	def BuildpathEntry convert(IProject project) {
		val externals = new PathExpander().expandFile(new Path(".settings/modules.erlidex"), newHashMap())
		convert(getOldProjectProperties(project), project.name, project.referencedProjects.map[name], externals)
	}

	def BuildpathEntry convert(OldErlangProjectProperties properties, String name,
		Collection<String>refProjects, Collection<IPath> externals) {
		println("CONVERTING "+properties.debugPrint)
		val result = new BuildpathLibrary(null, "root")
		val crt = newApp(result)
		properties.sourceDirs.forEach [
			newFolder(crt, it, FolderKind::SOURCE)
		]
		properties.includeDirs.forEach [
			newFolder(crt, it, FolderKind::INCLUDE)
		]
		properties.outputDirs.forEach [
			newFolder(crt, it, FolderKind::EBIN)
		]

		val otp = newLibrary(result, properties.runtimeVersion.toString)

		refProjects.forEach [
			newLibrary(result, it)
		]

		try {
			val roots = externals.map[segments.head].toSet
			for(root: roots) {
				newLibrary(result, root)
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
				src = �PathSerializer::packList(props.sourceDirs)�
				inc = �PathSerializer::packList(props.includeDirs)�
				out = �PathSerializer::packList(props.outputDirs)�
				ver = �props.runtimeVersion�
				xmd = �props.externalModulesFile�
				xin = �props.externalIncludesFile�
			}
		'''
	}

	def BuildpathLibrary newLibrary(BuildpathLibrary parent, String name) {
		val result = new BuildpathLibrary(parent, name)
		parent.addChild(result)
		return result
	}

	def BuildpathApp newApp(BuildpathLibrary parent) {
		val result = new BuildpathApp(parent)
		parent.addChild(result)
		return result
	}

	def BuildpathFolder newFolder(BuildpathApp parent, IPath path, FolderKind kind) {
		val result = new BuildpathFolder(parent, null, path, kind)
		parent.addFolder(result)
		return result
	}



}