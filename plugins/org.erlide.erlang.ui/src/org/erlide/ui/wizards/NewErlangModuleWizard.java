package org.erlide.ui.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class NewErlangModuleWizard extends Wizard implements IWorkbenchWizard,
        INewWizard {

    private WizardNewFileCreationPage mainPage;
    private IStructuredSelection selection;

    public NewErlangModuleWizard() {
        super();
        setNeedsProgressMonitor(true);
        setWindowTitle("New Erlang module");
    }

    @Override
    public void init(final IWorkbench workbench,
            final IStructuredSelection aSelection) {
        this.selection = aSelection;
    }

    @Override
    public void addPages() {
        mainPage = new WizardNewFileCreationPage("New Erlang module", selection);
        mainPage.setTitle("New Erlang module");
        mainPage.setDescription("Create a new Erlang module.");
        addPage(mainPage);
    }

    @Override
    public boolean performFinish() {
        return true;
    }

}
