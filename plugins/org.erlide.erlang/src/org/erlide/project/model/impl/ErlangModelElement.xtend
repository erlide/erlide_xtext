package org.erlide.project.model.impl

import org.erlide.project.model.IErlangModel
import org.erlide.project.model.IErlangModelElement
import org.erlide.project.model.IErlangProject

class ErlangModelElement implements IErlangModelElement {

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

    override getName() {
        throw new UnsupportedOperationException("Auto-generated function stub")
    }
    
    override getParent() {
        throw new UnsupportedOperationException("Auto-generated function stub")
    }

    override getResource() {
        throw new UnsupportedOperationException("Abstract operation")
    }
    
    override realize() {
        throw new UnsupportedOperationException("Abstract operation")
    }
    
}
