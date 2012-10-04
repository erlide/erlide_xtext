package org.erlide.erlang.ui.views;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.erlide.erlang.ModelDebugExtensions;

public class ParseDebugView extends ViewPart {

    /**
     * The ID of the view as specified by the extension.
     */
    public static final String ID = "org.erlide.erlang.ui.views.ParseDebugView";

    private TextViewer viewer;
    private Action action1;
    private Action action2;
    String crtResult;

    public ParseDebugView() {
    }

    @Override
    public void createPartControl(final Composite parent) {
        viewer = new TextViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        viewer.setInput(getViewSite());
        final Document doc = new Document();
        viewer.setDocument(doc);

        // Create the help context id for the viewer's control
        PlatformUI.getWorkbench().getHelpSystem()
                .setHelp(viewer.getControl(), "org.erlide.erlang.ui.viewer");
        makeActions();
        hookContextMenu();
        contributeToActionBars();

        getSite().getPage().addPartListener(new PartListener());
    }

    private void hookContextMenu() {
        final MenuManager menuMgr = new MenuManager("#PopupMenu");
        menuMgr.setRemoveAllWhenShown(true);
        menuMgr.addMenuListener(new IMenuListener() {
            @Override
            public void menuAboutToShow(final IMenuManager manager) {
                ParseDebugView.this.fillContextMenu(manager);
            }
        });
        final Menu menu = menuMgr.createContextMenu(viewer.getControl());
        viewer.getControl().setMenu(menu);
        getSite().registerContextMenu(menuMgr, viewer);
    }

    private void contributeToActionBars() {
        final IActionBars bars = getViewSite().getActionBars();
        fillLocalPullDown(bars.getMenuManager());
        fillLocalToolBar(bars.getToolBarManager());
    }

    private void fillLocalPullDown(final IMenuManager manager) {
        manager.add(action1);
        manager.add(new Separator());
        manager.add(action2);
    }

    private void fillContextMenu(final IMenuManager manager) {
        manager.add(action1);
        manager.add(action2);
        // Other plug-ins can contribute there actions here
        manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
    }

    private void fillLocalToolBar(final IToolBarManager manager) {
        manager.add(action1);
        manager.add(action2);
    }

    private void makeActions() {
        action1 = new Action() {
            @Override
            public void run() {
                showMessage("Action 1 executed");
            }
        };
        action1.setText("Action 1");
        action1.setToolTipText("Action 1 tooltip");
        action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
                .getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

        action2 = new Action() {
            @Override
            public void run() {
                showMessage("Action 2 executed");
            }
        };
        action2.setText("Action 2");
        action2.setToolTipText("Action 2 tooltip");
        action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
                .getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
    }

    private void showMessage(final String message) {
        MessageDialog.openInformation(viewer.getControl().getShell(),
                "Parser debug view", message);
    }

    /**
     * Passing the focus request to the viewer's control.
     */
    @Override
    public void setFocus() {
        viewer.getControl().setFocus();
    }

    private class PartListener implements IPartListener2, IPropertyListener {

        IWorkbenchPart part;

        @Override
        public void partActivated(final IWorkbenchPartReference partRef) {
            if (viewer == null || viewer.getDocument() == null) {
                return;
            }
            part = partRef.getPart(false);
            updateViewer();
            part.addPropertyListener(this);
        }

        @Override
        public void partDeactivated(final IWorkbenchPartReference partRef) {
            if (part == partRef.getPart(false)) {
                part.removePropertyListener(this);
                part = null;
            }
        }

        @Override
        public void propertyChanged(final Object source, final int propId) {
            if (propId == IEditorPart.PROP_DIRTY) {
                updateViewer();
            }
        }

        private void updateViewer() {
            if (part instanceof XtextEditor) {
                updateParsedContentFor((XtextEditor) part);
                viewer.getDocument().set(crtResult);
            }
        }

        @Override
        public void partBroughtToTop(final IWorkbenchPartReference partRef) {
        }

        @Override
        public void partClosed(final IWorkbenchPartReference partRef) {
        }

        @Override
        public void partOpened(final IWorkbenchPartReference partRef) {
        }

        @Override
        public void partHidden(final IWorkbenchPartReference partRef) {
        }

        @Override
        public void partVisible(final IWorkbenchPartReference partRef) {
        }

        @Override
        public void partInputChanged(final IWorkbenchPartReference partRef) {
        }
    }

    private String updateParsedContentFor(final XtextEditor part) {
        part.getDocument().readOnly(new IUnitOfWork<Boolean, XtextResource>() {
            @Override
            public Boolean exec(final XtextResource state) throws Exception {
                String result = "";
                for (final EObject obj : state.getContents()) {
                    result += new ModelDebugExtensions().debugPrint(obj);
                }
                crtResult = result;
                return Boolean.TRUE;
            }
        });
        return crtResult;
    }

}
