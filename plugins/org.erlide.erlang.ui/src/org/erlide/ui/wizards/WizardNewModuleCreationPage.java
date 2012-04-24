package org.erlide.ui.wizards;

import java.io.InputStream;

import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.xtext.util.StringInputStream;

import com.ericsson.otp.erlang.OtpErlangAtom;

public class WizardNewModuleCreationPage extends WizardNewFileCreationPage {

    public WizardNewModuleCreationPage(final String pageName,
            final IStructuredSelection selection) {
        super(pageName, selection);
    }

    @Override
    protected InputStream getInitialContents() {
        return new StringInputStream("-module(" + getModuleName() + ").\n\n");
    }

    private String getModuleName() {
        return new OtpErlangAtom(new Path(getFileName()).removeFileExtension()
                .toPortableString()).toString();
    }
}
