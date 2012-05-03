package org.erlide.project.model.impl

import org.eclipse.core.runtime.IPath
import org.erlide.project.model.ICodeFolder
import org.erlide.project.model.ICodeUnit
import org.erlide.project.model.IErlangModelElement
import org.eclipse.core.resources.IFile

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
        return file
    }
    
    override realize() {
        throw new UnsupportedOperationException("Code unit creation is not yet implemented")
    }
} // CodeUnit
