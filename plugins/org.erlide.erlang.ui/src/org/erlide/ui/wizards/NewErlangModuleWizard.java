package org.erlide.ui.wizards;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.ISetSelectionTarget;

import com.google.common.collect.Lists;

public class NewErlangModuleWizard extends Wizard implements IWorkbenchWizard,
        INewWizard {

    private WizardNewFileCreationPage mainPage;
    private IStructuredSelection selection;
    private IWorkbench workbench;

    public NewErlangModuleWizard() {
        super();
        setNeedsProgressMonitor(true);
        setWindowTitle("New Erlang module");
    }

    @Override
    public void init(final IWorkbench aWorkbench,
            final IStructuredSelection aSelection) {
        workbench = aWorkbench;
        selection = aSelection;
    }

    @Override
    public void addPages() {
        mainPage = new WizardNewModuleCreationPage("New Erlang module",
                selection);
        mainPage.setTitle("New Erlang module");
        mainPage.setDescription("Create a new Erlang module.");
        addPage(mainPage);
    }

    @Override
    public boolean performFinish() {
        final IFile file = mainPage.createNewFile();
        if (file == null) {
            return false;
        }

        selectAndReveal(file);

        return true;
    }

    protected void selectAndReveal(final IResource newResource) {
        selectAndReveal(newResource, workbench.getActiveWorkbenchWindow());
    }

    public static void selectAndReveal(final IResource resource,
            final IWorkbenchWindow window) {
        // validate the input
        if (window == null || resource == null) {
            return;
        }
        final IWorkbenchPage page = window.getActivePage();
        if (page == null) {
            return;
        }

        // get all the view and editor parts
        final List<IWorkbenchPart> parts = Lists.newArrayList();
        IWorkbenchPartReference refs[] = page.getViewReferences();
        for (int i = 0; i < refs.length; i++) {
            final IWorkbenchPart part = refs[i].getPart(false);
            if (part != null) {
                parts.add(part);
            }
        }
        refs = page.getEditorReferences();
        for (int i = 0; i < refs.length; i++) {
            if (refs[i].getPart(false) != null) {
                parts.add(refs[i].getPart(false));
            }
        }

        final ISelection selection = new StructuredSelection(resource);
        final Iterator<IWorkbenchPart> itr = parts.iterator();
        while (itr.hasNext()) {
            final IWorkbenchPart part = itr.next();

            // get the part's ISetSelectionTarget implementation
            ISetSelectionTarget target = null;
            if (part instanceof ISetSelectionTarget) {
                target = (ISetSelectionTarget) part;
            } else {
                target = (ISetSelectionTarget) part
                        .getAdapter(ISetSelectionTarget.class);
            }

            if (target != null) {
                // select and reveal resource
                final ISetSelectionTarget finalTarget = target;
                window.getShell().getDisplay().asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        finalTarget.selectReveal(selection);
                    }
                });
            }
        }
    }
}
