package org.erlide.project.model.impl;

import java.util.Collection;

import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.IProjectFragment;

/**
 * Explain what it is!
 * 
 * 
 */
@SuppressWarnings("all")
public class ComposedProjectFragment extends ProjectFragment {
    private final Collection<IProjectFragment> fragments;

    public ComposedProjectFragment(final IErlangProject project,
            final String name, final Collection<IProjectFragment> fragments) {
        super(project, name);
        this.fragments = fragments;
    }
}
