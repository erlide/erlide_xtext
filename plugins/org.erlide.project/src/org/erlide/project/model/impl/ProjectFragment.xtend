package org.erlide.project.model.impl

import java.util.Collection
import java.util.Set
import org.eclipse.core.runtime.IPath
import org.erlide.project.model.ICodeFolder
import org.erlide.project.model.IErlangModelElement
import org.erlide.project.model.IErlangProject
import org.erlide.project.model.IProjectFragment

import static extension java.util.Collections.*

public class ProjectFragment extends ErlangModelElement implements
        IProjectFragment {

    IErlangProject project
    String name
    protected Set<ICodeFolder> sourceFolders
    protected Set<ICodeFolder> includeFolders
    protected IPath docPath
    protected IPath privPath

    new(IErlangProject project, String name) {
        super()
        this.project = project
        this.name = name
        sourceFolders = newHashSet()
        includeFolders = newHashSet()
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

    def void addSourceFolder(ICodeFolder folder) {
        sourceFolders.add(folder)
    }

    def removeSourceFolder(ICodeFolder folder) {
        sourceFolders.remove(folder)
    }

    def void addIncludeFolder(ICodeFolder folder) {
        sourceFolders.add(folder)
    }
    
    def removeIncludeFolder(ICodeFolder folder) {
        sourceFolders.remove(folder)
    }
    
    def void setDocPath(IPath path) {
        docPath = path
    }
    
    def void setPrivPath(IPath path) {
        privPath = path
    }

    override getResource() {
        return null
    }
    
    override realize() {
        sourceFolders.forEach[realize]
        includeFolders.forEach[realize]
        // create docPath
        // create privPath
    }

} // ProjectFragment
