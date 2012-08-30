package org.erlide.project.model.impl

import java.util.Collection
import java.util.List
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IWorkspace
import org.erlide.project.model.IErlangModel
import org.erlide.project.model.IErlangModelElement
import org.erlide.project.model.IErlangProject

import static extension java.util.Collections.*
import org.erlide.project.ErlangCore
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

    override IErlangProject getErlangProject(IProject project) {
    	if (!project.exists) {
    		return null
    	}
        for (IErlangProject prj : projects) {
            if (prj.workspaceProject== project) {
                return prj
            }
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
	
} // ErlModel
