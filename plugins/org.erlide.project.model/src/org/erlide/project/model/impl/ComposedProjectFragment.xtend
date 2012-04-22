package org.erlide.project.model.impl

import java.util.Collection

import org.erlide.project.model.IErlangProject
import org.erlide.project.model.IProjectFragment

public class ComposedProjectFragment extends ProjectFragment {

    private Collection<IProjectFragment> fragments

    new(IErlangProject project, String name,
            Collection<IProjectFragment> fragments) {
        super(project, name)
        this.fragments = fragments
    }

}
