package org.erlide.project.model.impl

import java.util.List
import org.eclipse.core.resources.IFolder
import org.eclipse.core.runtime.IPath
import org.erlide.project.model.ICodeFolder
import org.erlide.project.model.ICodeUnit
import org.erlide.project.model.IErlangModelElement
import org.erlide.project.model.IProjectFragment

public class CodeFolder extends ErlangModelElement implements ICodeFolder {

    List<ICodeUnit> sourceUnits
    IFolder folder = null
    IPath path = null
    IPath outputPath = null
    IProjectFragment fragment

    new() {
        super()
    }
    
    override List<ICodeUnit> getCodeUnits() {
        if (sourceUnits == null) {
            sourceUnits = newArrayList()
        }
        return sourceUnits
    }

    override IPath getPath() {
        return path
    }

    override IFolder getFolder() {
        return folder
    }

    def setFolder(IFolder folder) {
        this.folder = folder
        path = folder.projectRelativePath
    }

    override IPath getOutputPath() {
        return outputPath
    }

    def setOutputPath(IPath newOutputPath) {
        outputPath = newOutputPath
    }

    override String toString() {
        '''«super.toString()» (folder: «folder.getProjectRelativePath()», outputPath: «outputPath»)'''.toString
    }

    override String getName() {
        return folder?.getName()
    }

    override IErlangModelElement getParent() {
        return fragment
    }

} // CodeFolder
