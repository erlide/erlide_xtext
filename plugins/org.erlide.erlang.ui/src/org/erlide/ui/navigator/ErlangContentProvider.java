package org.erlide.ui.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.erlide.erlang.Function;
import org.erlide.erlang.Module;

import com.google.inject.Inject;

public class ErlangContentProvider implements ITreeContentProvider {

    @Inject
    IOutlineTreeProvider outlineProvider;
    @Inject
    private IResourceSetProvider resourceSetProvider;
    @Inject
    private IWorkspace workspace;

    private IOutlineNode node;

    @Override
    public void dispose() {
    }

    @Override
    public void inputChanged(final Viewer viewer, final Object oldInput,
            final Object newInput) {
    }

    @Override
    public Object[] getElements(final Object inputElement) {
        System.out.println("i=" + inputElement);
        return node.getChildren().toArray();
    }

    public EObject getModelForResource(final IFile file) {
        final URI uri = URI.createURI("platform:/resource/"
                + file.getProject().getName() + "/"
                + file.getProjectRelativePath());
        final ResourceSet set = resourceSetProvider.get(file.getProject());
        try {
            final Resource res = set.getResource(uri, true);
            if (res != null) {
                return res.getContents().get(0);
            }
        } catch (final Exception e) {
        }
        return null;
    }

    public IResource getResourceForModel(final EObject obj) {
        final URI uri = obj.eResource().getURI();
        final String project = uri.segment(1);
        final IPath path = new Path(uri.path()).removeFirstSegments(2);
        return workspace.getRoot().getProject(project).findMember(path);
    }

    @Override
    public Object[] getChildren(final Object element) {
        System.out.println("c=" + element);
        if (element instanceof IFile) {
            final IFile file = (IFile) element;
            final Module module = (Module) getModelForResource(file);
            if (module != null) {
                return module.getForms().toArray();
            }
        }
        if (element instanceof Function) {
            final Function function = (Function) element;
            return function.getClauses().toArray();
        }
        return null;
    }

    @Override
    public Object getParent(final Object element) {
        if (element instanceof IResource) {
            return ((IResource) element).getParent();
        }
        return null;
    }

    @Override
    public boolean hasChildren(final Object element) {
        System.out.println("C?=" + element);
        if (element instanceof IFile) {
            final IFile file = (IFile) element;
            final EObject model = getModelForResource(file);
            if (model instanceof Module) {
                final Module module = (Module) model;
                return !module.getForms().isEmpty();
            }
        }
        if (element instanceof Function) {
            final Function function = (Function) element;
            return !function.getClauses().isEmpty();
        }
        return false;
    }

}
