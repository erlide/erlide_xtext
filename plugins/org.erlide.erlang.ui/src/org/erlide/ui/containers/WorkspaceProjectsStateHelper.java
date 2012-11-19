/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.erlide.ui.containers;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.containers.AbstractStorage2UriMapperClient;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class WorkspaceProjectsStateHelper extends
        AbstractStorage2UriMapperClient {

    private final static Logger log = Logger
            .getLogger(WorkspaceProjectsStateHelper.class);

    @Inject
    private IWorkspace workspace;

    public String initHandle(final URI uri) {
        if (!uri.isPlatform()) {
            return null;
        }
        final IFile file = getWorkspaceRoot().getFile(
                new Path(uri.toPlatformString(true)));
        if (file == null) {
            return null;
        }
        final IProject project = file.getProject();
        return project.getName();
    }

    public Collection<URI> initContainedURIs(final String containerHandle) {
        try {
            final IPath projectPath = new Path(null, containerHandle)
                    .makeAbsolute();
            if (projectPath.segmentCount() != 1) {
                return Collections.emptySet();
            }
            final IProject project = getWorkspaceRoot().getProject(
                    containerHandle);
            if (project != null && isAccessibleXtextProject(project)) {
                final List<URI> uris = Lists.newArrayList();
                try {
                    project.accept(new IResourceVisitor() {
                        @Override
                        public boolean visit(final IResource resource)
                                throws CoreException {
                            if (resource.getName().equals("test")) {
                                System.out.println("SKIP " + resource);
                                return false;
                            }
                            if (resource instanceof IStorage) {
                                final URI uri = getUri((IStorage) resource);
                                if (uri != null) {
                                    uris.add(uri);
                                }
                                return false;
                            }
                            return true;
                        }
                    });
                    return uris;
                } catch (final CoreException e) {
                    log.error(e.getMessage(), e);
                }
            }
        } catch (final IllegalArgumentException e) {
            if (log.isDebugEnabled()) {
                log.debug("Cannot init contained URIs for containerHandle '"
                        + containerHandle + "'", e);
            }
        }
        return Collections.emptyList();
    }

    public List<String> initVisibleHandles(final String handle) {
        try {
            final IProject project = getWorkspaceRoot().getProject(handle);
            if (isAccessibleXtextProject(project)) {
                try {
                    final IProject[] referencedProjects = project
                            .getReferencedProjects();
                    final List<String> result = Lists
                            .newArrayListWithExpectedSize(referencedProjects.length);
                    result.add(handle);
                    for (final IProject referencedProject : referencedProjects) {
                        if (isAccessibleXtextProject(referencedProject)) {
                            result.add(referencedProject.getName());
                        }
                    }
                    return result;
                } catch (final CoreException e) {
                    log.error(e.getMessage(), e);
                }
            }
        } catch (final IllegalArgumentException e) {
            if (log.isDebugEnabled()) {
                log.debug("Cannot init visible handles for containerHandle '"
                        + handle + "'", e);
            }
        }
        return Collections.emptyList();
    }

    protected boolean isAccessibleXtextProject(final IProject p) {
        return p != null && XtextProjectHelper.hasNature(p);
    }

    protected IWorkspaceRoot getWorkspaceRoot() {
        return workspace.getRoot();
    }

    public void setWorkspace(final IWorkspace workspace) {
        this.workspace = workspace;
    }
}
