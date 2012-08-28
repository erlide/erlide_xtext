package org.erlide.project.model.impl

import java.util.Collection
import java.util.Collections
import java.util.List
import org.eclipse.core.resources.IProject
import org.erlide.common.util.ErlLogger
import org.erlide.project.model.IErlangModel
import org.erlide.project.model.IErlangModelElement
import org.erlide.project.model.IErlangProject
import org.erlide.project.model.IProjectFragment
import org.eclipse.core.runtime.IPath
import org.erlide.project.model.ILibrary

public class ErlangProject extends ErlangModelElement implements IErlangProject {

    IErlangModel model
    List<ILibrary> libraries
    List<IProjectFragment> sourceFragments
    List<IProjectFragment> binaryFragments
    IProject workspaceProject
    IPath outputPath = null

    new(IErlangModel model, IProject project) {
        super()
        this.model = model
        libraries = newArrayList()
        sourceFragments = newArrayList()
        binaryFragments = newArrayList()
        workspaceProject = project
     }

    override List<ILibrary> getLibraries() {
        return libraries
    }

    override Collection<IProjectFragment> getFragments() {
        return Collections::unmodifiableCollection(sourceFragments)
    }

    override IProject getWorkspaceProject() {
        return workspaceProject
    }

    override String toString() {
        val StringBuffer result = new StringBuffer(super.toString())
        result.append(" (workspaceProject: ")
        result.append(workspaceProject)
        result.append(')')
        return result.toString()
    }

    override String getName() {
        return workspaceProject.getName()
    }

    override IErlangModelElement getParent() {
        return model
    }

    override getResource() {
        return workspaceProject
    }
    
    override realize() {
        if(workspaceProject != null) {
            ErlLogger::error("Workspace project must exist for %s", name)
            // TODO create project 
        }
        sourceFragments.forEach[realize]
        // binaryFragments 
    }
    
	override getOutputPath() {
		return outputPath
	}
	

} // ErlangProject
