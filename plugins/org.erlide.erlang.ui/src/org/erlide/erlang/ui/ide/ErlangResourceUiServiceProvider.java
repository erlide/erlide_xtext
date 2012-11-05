package org.erlide.erlang.ui.ide;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.resource.DefaultResourceUIServiceProvider;
import org.erlide.project.ErlangCore;
import org.erlide.project.model.IErlangProject;

import com.google.inject.Inject;

public class ErlangResourceUiServiceProvider extends
        DefaultResourceUIServiceProvider {

    @Inject
    public ErlangResourceUiServiceProvider(
            final IResourceServiceProvider delegate) {
        super(delegate);
    }

    @Override
    public boolean canHandle(final URI uri) {
        return super.canHandle(uri);
    }

    @Override
    public boolean canHandle(final URI uri, final IStorage storage) {
        final boolean canHandle = super.canHandle(uri, storage);
        if (canHandle && (storage instanceof IResource)) {
            final IResource resource = (IResource) storage;
            final IProject project = resource.getProject();
            final IErlangProject erlangProject = ErlangCore.getModel()
                    .getErlangProject(project);
            if (erlangProject != null) {
                return erlangProject.getBuildpath().hasResource(resource);
            }
        }
        return canHandle;
    }

}
