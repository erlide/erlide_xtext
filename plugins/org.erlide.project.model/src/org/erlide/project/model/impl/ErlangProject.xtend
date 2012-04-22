package org.erlide.project.model.impl

import java.util.Collection
import java.util.Collections
import java.util.List
import org.eclipse.core.resources.IProject
import org.erlide.project.model.IErlangModel
import org.erlide.project.model.IErlangModelElement
import org.erlide.project.model.IErlangProject
import org.erlide.project.model.IProjectFragment

public class ErlangProject extends ErlangModelElement implements IErlangProject {

    IErlangModel model
    List<IErlangProject> referencedProjects
    List<IProjectFragment> sourceFragments
    List<IProjectFragment> binaryFragments
    IProject workspaceProject

    new(IErlangModel model, IProject workspaceProject) {
        super()
        this.model = model
        referencedProjects = newArrayList()
        sourceFragments = newArrayList()
        binaryFragments = newArrayList()
        this.workspaceProject = workspaceProject
    }

    override List<IErlangProject> getReferencedProjects() {
        return referencedProjects
    }

    override Collection<IProjectFragment> getSourceFragments() {
        return Collections::unmodifiableCollection(sourceFragments)
    }

    override Collection<IProjectFragment> getBinaryFragments() {
        return Collections::unmodifiableCollection(binaryFragments)
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

} // ErlangProject
