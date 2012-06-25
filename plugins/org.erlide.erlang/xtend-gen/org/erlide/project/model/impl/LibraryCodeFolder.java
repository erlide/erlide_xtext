package org.erlide.project.model.impl;

import org.eclipse.core.runtime.IPath;
import org.erlide.project.model.IProjectFragment;

@SuppressWarnings("all")
public class LibraryCodeFolder extends CodeFolder {
    public LibraryCodeFolder(final IProjectFragment fragment, final IPath path) {
        super(path);
    }
}
