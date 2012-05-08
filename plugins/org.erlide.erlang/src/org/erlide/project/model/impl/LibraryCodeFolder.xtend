package org.erlide.project.model.impl

import org.eclipse.core.runtime.IPath
import org.erlide.project.model.IProjectFragment

public class LibraryCodeFolder extends CodeFolder {

    new(IProjectFragment fragment, IPath path) {
        super(path)
    }

} // LibraryCodeFolder
