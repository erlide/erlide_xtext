package org.erlide.project;

import org.eclipse.xtext.service.AbstractGenericModule;
import org.erlide.project.model.IErlangModelFactory;
import org.erlide.project.model.impl.ErlangModelFactory;

public class ErlideProjectModule extends AbstractGenericModule {

    public ErlideProjectModule() {
    }

    public Class<? extends IErlangModelFactory> bindIErlangModelFactory() {
        return ErlangModelFactory.class;
    }

}
