package org.erlide.project.model.impl

import java.util.Collection
import java.util.List
import org.eclipse.core.runtime.IPath
import org.erlide.project.model.ICodeFolder
import org.erlide.project.model.IErlangModel
import org.erlide.project.model.IErlangModelElement
import org.erlide.project.model.IErlangProject
import org.erlide.project.model.IProjectFragment

import static extension java.util.Collections.*

public class ProjectFragment extends ErlangModelElement implements
        IProjectFragment {

    IErlangProject project
    IErlangModel model
    List<ICodeFolder> sourceFolders
    List<ICodeFolder> includeFolders
    IPath docFolder
    IPath privDir
    String name

    new(IErlangProject project, String name) {
        super()
        this.project = project
        this.name = name
        sourceFolders = newArrayList()
        includeFolders = newArrayList()
    }

    override Collection<ICodeFolder> getSourceFolders() {
        return sourceFolders.unmodifiableCollection
    }

    override Collection<ICodeFolder> getIncludeFolders() {
        return includeFolders.unmodifiableCollection
    }

    override String getName() {
        return name
    }

    override IErlangModelElement getParent() {
        return project
    }

} // ProjectFragment