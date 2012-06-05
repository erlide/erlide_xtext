package org.erlide.project.model.impl

import java.util.List
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IPath
import org.erlide.common.util.ErlLogger
import org.erlide.project.model.ICodeFolder
import org.erlide.project.model.ICodeUnit
import org.erlide.project.model.IErlangModelElement

public class CodeUnit extends ErlangModelElement implements ICodeUnit {

    ICodeFolder folder
    String name
    IFile file 

    new(ICodeFolder folder, String name) {
        this.folder = folder
        this.name = name
    }

    override IPath getPath() {
        return folder.getFolder().getProjectRelativePath().append(name)
    }

    override String getName() {
        return name
    }

    override IErlangModelElement getParent() {
        return folder
    }

    override getResource() {
        if(file==null) {
            val List<IFile> possibleFiles = ResourcesPlugin::workspace.root.findFilesForLocation(path)
            if(possibleFiles.size == 1) {
                file = possibleFiles.head
            }
            ErlLogger::warn("not able to find file %s", path)
        }
        return file
    }
    
    override realize() {
        ErlangModelFactory::createFile(path)
    }
} // CodeUnit
