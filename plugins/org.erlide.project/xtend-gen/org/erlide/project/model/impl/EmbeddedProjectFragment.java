package org.erlide.project.model.impl;

import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.IProjectFragment;

/**
 * Explain what it is!
 * 
 * 
 */
@SuppressWarnings("all")
public class EmbeddedProjectFragment extends ProjectFragment {
    private final IProjectFragment parent;

    public EmbeddedProjectFragment(final IErlangProject project,
            final String name, final IProjectFragment parent) {
        super(project, name);
        this.parent = parent;
    }
}
