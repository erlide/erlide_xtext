package org.erlide.project;

import org.erlide.project.model.IErlangModel;
import org.erlide.project.model.IErlangModelFactory;
import org.erlide.project.model.impl.ErlangModelFactory;

public class ErlangCore {

    private static IErlangModelFactory modelFactory;

    private ErlangCore() {
    }

    public static IErlangModelFactory getModelFactory() {
        if (modelFactory == null) {
            modelFactory = new ErlangModelFactory();
        }
        return modelFactory;
    }

    public static IErlangModel getModel() {
        return getModelFactory().getModel();
    }

}
