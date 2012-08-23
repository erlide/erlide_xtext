package org.erlide.project.model.impl

import org.erlide.project.model.IErlangModel
import org.erlide.project.model.IErlangModelElement
import org.erlide.project.model.IErlangProject

abstract class ErlangModelElement implements IErlangModelElement {

    protected new(){
    }

    override IErlangProject getProject() {
        return getParentOfType(typeof(IErlangProject))
    }

    override IErlangModel getModel() {
        return getParentOfType(typeof(IErlangModel))
    }

    @SuppressWarnings("unchecked")
    def private <T> T getParentOfType(Class<? extends T> clazz) {
        var IErlangModelElement crt = this
        while (!crt.getClass().isAssignableFrom(clazz)) {
            crt = crt.getParent()
        }
        return crt as T
    }

}
