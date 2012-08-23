package org.erlide.project;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdapterFactory;
import org.erlide.project.model.IErlangModel;
import org.erlide.project.model.IErlangProject;

public class ProjectAdapterFactory implements IAdapterFactory {

    @Override
    public Object getAdapter(final Object adaptableObject,
            @SuppressWarnings("rawtypes") final Class adapterType) {
        if (adapterType == IErlangProject.class) {
            return getErlangModel()
                    .getErlangProject((IProject) adaptableObject);
        }
        return null;
    }

    private IErlangModel getErlangModel() {
        return ErlangCore.getModel();
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class[] getAdapterList() {
        return new Class[] { IErlangProject.class };
    }

}
