package org.erlide.project.model.impl

import org.erlide.project.model.IErlangModel
import org.erlide.project.model.IExternalErlangProject

public class ExternalErlangProject extends ErlangProject implements
        IExternalErlangProject {

    new(IErlangModel model) {
        super(model, null)
    }

} // ExternalErlangProject
