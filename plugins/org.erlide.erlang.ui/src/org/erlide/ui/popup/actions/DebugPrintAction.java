package org.erlide.ui.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class DebugPrintAction implements IObjectActionDelegate {

    private IWorkbenchPart targetPart;

    public DebugPrintAction() {
        super();
    }

    @Override
    public void setActivePart(final IAction action,
            final IWorkbenchPart targetPart) {
        this.targetPart = targetPart;
    }

    @Override
    public void run(final IAction action) {
        final ISelection sel = targetPart.getSite().getSelectionProvider()
                .getSelection();
        if (sel instanceof IStructuredSelection) {
            final IStructuredSelection mysel = (IStructuredSelection) sel;
            final Object target = mysel.getFirstElement();
            if (target instanceof IFile) {

            }
        }
    }

    @Override
    public void selectionChanged(final IAction action,
            final ISelection selection) {
    }

}
