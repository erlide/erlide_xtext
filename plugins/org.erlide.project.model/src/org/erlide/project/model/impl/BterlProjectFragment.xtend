package org.erlide.project.model.impl

import org.erlide.project.model.IErlangProject
import org.erlide.project.model.IProjectFragment

public class BterlProjectFragment extends EmbeddedProjectFragment {

    new(IErlangProject project, String name,
            IProjectFragment parent) {
        super(project, name, parent)
    }
}
