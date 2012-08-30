package org.erlide.project.model.impl

import java.util.List
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IPath
import org.erlide.common.util.ErlLogger
import org.erlide.project.model.ICodeUnit
import org.erlide.project.model.IErlangModelElement
import org.erlide.project.model.IErlangProject

public class CodeUnit extends ErlangModelElement implements ICodeUnit {

    IErlangProject folder
    String name
    IFile file 

    new(IErlangProject folder, String name) {
        this.folder = folder
        this.name = name
    }

    override IPath getPath() {
        return null; //folder.getFolder().getProjectRelativePath().append(name)
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
    
} // CodeUnit
