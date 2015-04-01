package org.erlide.project.model.impl

import java.util.Collection
import java.util.List
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IWorkspace
import org.eclipse.jdt.annotation.Nullable
import org.erlide.common.NatureConstants
import org.erlide.project.ErlangCore
import org.erlide.project.model.IErlangModel
import org.erlide.project.model.IErlangModelElement
import org.erlide.project.model.IErlangProject

import static extension java.util.Collections.*

public class ErlangModel extends ErlangModelElement implements IErlangModel {

    IWorkspace workspace
    List<IErlangProject> projects

    new(IWorkspace workspace) {
        super()
        this.workspace = workspace
        projects = newArrayList()
    }

    override Collection<IErlangProject> getProjects() {
        return projects.unmodifiableCollection
    }

	@Nullable
    override IErlangProject getErlangProject(IProject project) {
    	if (!project.exists) {
    		return null
    	}
        for (IErlangProject prj : projects) {
            if (prj.workspaceProject== project) {
                return prj
            }
        }
        
        if (!isErlangProject(project)) {
        	return null
       	}
        
        val IErlangProject erlPrj = ErlangCore::getModelFactory().createErlangProject(project)
        projects.add(erlPrj)
        return erlPrj
    }

    override IWorkspace getWorkspace() {
        workspace
    }

    override String getName() {
        "Erlang model"
    }

    override IErlangModelElement getParent() {
        return null
    }


	override getResource() {
		workspace.root
	}

	def isErlangProject(IProject project) {
		project.hasNature(NatureConstants::NATURE_ID) || project.hasNature(NatureConstants::OLD_NATURE_ID)
	}
	
} // ErlModel
