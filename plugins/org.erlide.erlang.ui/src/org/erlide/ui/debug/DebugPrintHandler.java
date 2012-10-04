package org.erlide.ui.debug;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.erlide.erlang.ModelDebugExtensions;

import com.google.inject.Inject;

public class DebugPrintHandler extends AbstractHandler {

    @Inject
    ModelDebugExtensions debugExt;

    @Override
    public Object execute(final ExecutionEvent event) throws ExecutionException {

        final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
        if (activeEditor instanceof XtextEditor) {
            ((XtextEditor) activeEditor).getDocument().readOnly(
                    new IUnitOfWork<Boolean, XtextResource>() {
                        @Override
                        public Boolean exec(final XtextResource state)
                                throws Exception {

                            System.out.println("-----------------------");
                            for (final EObject obj : state.getContents()) {
                                System.out.println(debugExt.debugPrint(obj));
                                System.out.println("-----------------------");
                            }
                            System.out.println("-----------------------");

                            return Boolean.TRUE;
                        }
                    });
        }
        return null;
    }
}
