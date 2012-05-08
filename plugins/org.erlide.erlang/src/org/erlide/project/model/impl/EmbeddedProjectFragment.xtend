package org.erlide.project.model.impl

import org.erlide.project.model.IErlangProject
import org.erlide.project.model.IProjectFragment

public class EmbeddedProjectFragment extends ProjectFragment {

    private IProjectFragment parent

    new(IErlangProject project, String name,
            IProjectFragment parent) {
        super(project, name)
        this.parent = parent
    }

}
