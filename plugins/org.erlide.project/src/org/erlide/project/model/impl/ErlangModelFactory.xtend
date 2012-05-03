package org.erlide.project.model.impl

import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IPath
import org.erlide.project.model.IBinaryCodeUnit
import org.erlide.project.model.ICodeFolder
import org.erlide.project.model.ICodeUnit
import org.erlide.project.model.IErlangModel
import org.erlide.project.model.IErlangModelFactory
import org.erlide.project.model.IErlangProject
import org.erlide.project.model.IExternalErlangProject
import org.erlide.project.model.IProjectFragment

public class ErlangModelFactory implements IErlangModelFactory {

    ErlangModel erlModel

    new() {
        erlModel = new ErlangModel(ResourcesPlugin::getWorkspace())
    }

    override IErlangModel getModel() {
        return erlModel
    }

    override IErlangProject createErlangProject(IProject workspaceProject) {
        return new ErlangProject(erlModel, workspaceProject)
    }

    override IExternalErlangProject createExternalErlangProject() {
        return new ExternalErlangProject(erlModel)
    }

    override ICodeFolder createCodeFolder(IProjectFragment project,
            IPath path) {
        return new CodeFolder()
    }

    override IProjectFragment createErlangProjectFragment(
            IErlangProject project, String name) {
        return new ErlangProjectFragment(project, name)
    }

    override IProjectFragment createBterlProjectFragment(
            IErlangProject project, String name,
            IProjectFragment parent) {
        return new BterlProjectFragment(project, name, parent)
    }

    override ICodeUnit createCodeUnit(ICodeFolder folder, String name) {
        return new CodeUnit(folder, name)
    }

    override IBinaryCodeUnit createBinaryCodeUnit(ICodeFolder folder,
            String name) {
        return new BinaryCodeUnit(folder, name)
    }

} // ErlModelFactory
