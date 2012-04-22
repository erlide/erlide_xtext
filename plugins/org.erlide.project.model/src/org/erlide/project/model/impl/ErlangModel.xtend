package org.erlide.project.model.impl

import java.util.Collection
import java.util.List
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IWorkspace
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
        return projects.unmodifiableCollection;
    }

    override IErlangProject getErlangProject(IProject project) {
        for (IErlangProject prj : projects) {
            if (prj.workspaceProject== project) {
                return prj;
            }
        }
        return null;
    }

    override IWorkspace getWorkspace() {
        return workspace;
    }

    override String getName() {
        return "Erlang model";
    }

    override IErlangModelElement getParent() {
        return null;
    }

} // ErlModel
