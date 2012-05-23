package org.erlide.ui;

import static com.windowtester.runtime.swt.locator.eclipse.EclipseLocators.view;
import static com.windowtester.runtime.swt.locator.eclipse.EclipseLocators.workbench;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;

import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.WT;
import com.windowtester.runtime.swt.UITestCaseSWT;
import com.windowtester.runtime.swt.condition.shell.ShellDisposedCondition;
import com.windowtester.runtime.swt.condition.shell.ShellShowingCondition;
import com.windowtester.runtime.swt.locator.ButtonLocator;
import com.windowtester.runtime.swt.locator.FilteredTreeItemLocator;
import com.windowtester.runtime.swt.locator.LabeledTextLocator;
import com.windowtester.runtime.swt.locator.MenuItemLocator;
import com.windowtester.runtime.swt.locator.TreeItemLocator;
import com.windowtester.runtime.swt.locator.eclipse.ViewLocator;

/**
 * Just a demo test
 */
public class CreateProjectTest extends UITestCaseSWT {

    /*
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        final IUIContext ui = getUI();
        ui.ensureThat(workbench().hasFocus());
        ui.ensureThat(view("Welcome").isClosed());
        ResourcesPlugin.getWorkspace().getRoot().delete(true, null);

    }

    /**
     * Main test method.
     */
    public void testCreateProject() throws Exception {
        final IUIContext ui = getUI();
        ui.click(new MenuItemLocator("File/New/Project..."));
        ui.wait(new ShellShowingCondition("New Project"));
        ui.click(2, new FilteredTreeItemLocator("General/Project"));
        ui.click(new LabeledTextLocator("&Project name:"));
        ui.enterText("poi");
        ui.click(new ButtonLocator("&Finish"));
        ui.wait(new ShellDisposedCondition("New Project"));
        ui.contextClick(new TreeItemLocator("poi", new ViewLocator(
                "org.eclipse.jdt.ui.PackageExplorer")), "New/Folder");
        ui.wait(new ShellShowingCondition("New Folder"));
        ui.enterText("fold");
        ui.keyClick(WT.CR);
        ui.wait(new ShellDisposedCondition("New Folder"));

        assert_folderExists();
    }

    private void assert_folderExists() throws URISyntaxException,
            MalformedURLException, IOException {
        final IWorkspaceRoot w = ResourcesPlugin.getWorkspace().getRoot();
        final IProject prj = w.getProject("poi");
        assertThat("prj exists", prj.exists());
        final IFolder fold = prj.getFolder("fold");
        assertThat("fld exists", fold.exists());
        final IFolder fold1 = prj.getFolder("fold1");
        assertThat("fld1 doesn't exists", !fold1.exists());
    }
}
