package org.erlide.ui.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class NewErlangProjectWizard extends Wizard implements INewWizard {

    private WizardNewProjectCreationPage mainPage;

    public NewErlangProjectWizard() {
        super();
        setWindowTitle("New OTP Project");
        setNeedsProgressMonitor(true);
    }

    @Override
    public void init(final IWorkbench workbench,
            final IStructuredSelection selection) {
    }

    @Override
    public void addPages() {
        mainPage = new WizardNewProjectCreationPage("New Erlang project");
        mainPage.setTitle("New Erlang project");
        mainPage.setDescription("Create a new Erlang project with custom project structure.");
        addPage(mainPage);
    }

    @Override
    public boolean performFinish() {
        // TODO: create project
        return true;
    }

}
