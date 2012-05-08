package org.erlide.project.model.impl;

import org.eclipse.core.runtime.IPath;
import org.erlide.project.model.IProjectFragment;
import org.erlide.project.model.impl.CodeFolder;

@SuppressWarnings("all")
public class LibraryCodeFolder extends CodeFolder {
  public LibraryCodeFolder(final IProjectFragment fragment, final IPath path) {
    super(path);
  }
}
