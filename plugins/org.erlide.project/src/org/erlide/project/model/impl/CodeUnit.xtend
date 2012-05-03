package org.erlide.project.model.impl

import org.eclipse.core.runtime.IPath
import org.erlide.project.model.ICodeFolder
import org.erlide.project.model.ICodeUnit
import org.erlide.project.model.IErlangModelElement

public class CodeUnit extends ErlangModelElement implements ICodeUnit {

    ICodeFolder folder
    String name

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

} // CodeUnit
