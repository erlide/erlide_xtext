package org.erlide.project.model.impl

import java.io.File
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IPath
import org.erlide.project.model.IBinaryCodeUnit
import org.erlide.project.model.ICodeUnit
import org.erlide.project.model.IErlangModel
import org.erlide.project.model.IErlangModelFactory
import org.erlide.project.model.IErlangProject

public class ErlangModelFactory implements IErlangModelFactory {

    ErlangModel erlModel

    new() {
        erlModel = new ErlangModel(ResourcesPlugin::getWorkspace())
        populateProjects
    }

    override IErlangModel getModel() {
        return erlModel
    }

    override IErlangProject createErlangProject(IProject workspaceProject) {
        return new ErlangProject(erlModel, workspaceProject)
    }

    override ICodeUnit createCodeUnit(IErlangProject folder, String name) {
        return new CodeUnit(folder, name)
    }

    override IBinaryCodeUnit createBinaryCodeUnit(IErlangProject folder,
            String name) {
        return new BinaryCodeUnit(folder, name)
    }

    def static void createFolder(IPath fullPath) {
        if(fullPath==null) {
            return
        }
        try {
            var File f = new File(fullPath.toString)
            f.mkdirs
        } catch (Exception e) {
            println("could not create folder "+fullPath.toString)            
        }
    }
    
    def static void createFile(IPath fullPath) {
        if(fullPath==null) {
            return
        }
        try {
        var File f = new File(fullPath.toString)
        f.createNewFile
        } catch (Exception e) {
            println("could not create file "+fullPath.toString)            
        }
    }
    
	def private populateProjects() {
		model.workspace.root.projects.forEach [
			createErlangProject
		]
	}    

} // ErlModelFactory
