package org.erlide.ui;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.progress.IProgressConstants;

public class ErlangPerspective implements IPerspectiveFactory {

    /**
     * Erlang perspective id
     */
    public static final String ID = "org.erlide.project.ui.erlangPerspective";

    /**
     * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
     */
    @Override
    public void createInitialLayout(final IPageLayout layout) {
        defineActions(layout);
        defineLayout(layout);
        defineShortcuts(layout);
    }

    /**
     * The action objects Define the actions
     * 
     * @param layout
     */
    private void defineActions(final IPageLayout layout) {
        // layout.addActionSet(IDebugUIConstants.LAUNCH_ACTION_SET);
        // layout.addActionSet(IDebugUIConstants.DEBUG_ACTION_SET);
        layout.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET);
        layout.addActionSet("org.erlide.ui.actions.openActionSet");
    }

    /**
     * Define the layout of the editor and views
     * 
     * @param layout
     *            the layout object
     */
    private void defineLayout(final IPageLayout layout) {
        final String editorArea = layout.getEditorArea();

        final IFolderLayout left = layout.createFolder("left",
                IPageLayout.LEFT, (float) 0.2, editorArea);
        // left.addView(IPageLayout.ID_RES_NAV);
        left.addView(IPageLayout.ID_PROJECT_EXPLORER);

        final IFolderLayout bottom = layout.createFolder("bottom",
                IPageLayout.BOTTOM, (float) 0.65, editorArea);
        bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
        // bottom.addView(IConsoleConstants.ID_CONSOLE_VIEW);
        // bottom.addView(ProcessListView.ID);
        // bottom.addView(LiveExpressionsView.ID);
        // bottom.addPlaceholder(NewSearchUI.SEARCH_VIEW_ID);
        bottom.addPlaceholder(IPageLayout.ID_BOOKMARKS);
        bottom.addPlaceholder(IProgressConstants.PROGRESS_VIEW_ID);

        final float d = 0.7f;
        layout.addView(IPageLayout.ID_OUTLINE, IPageLayout.RIGHT, d, editorArea);

    }

    private void defineShortcuts(final IPageLayout layout) {
        // views - search
        // layout.addShowViewShortcut(NewSearchUI.SEARCH_VIEW_ID);

        layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
        // layout.addShowViewShortcut(IConsoleConstants.ID_CONSOLE_VIEW);
        // layout.addShowViewShortcut(LiveExpressionsView.ID);
        layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
        layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
    }

}
