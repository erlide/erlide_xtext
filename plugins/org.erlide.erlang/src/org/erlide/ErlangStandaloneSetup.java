package org.erlide;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
public class ErlangStandaloneSetup extends ErlangStandaloneSetupGenerated {

    public static void doSetup() {
        new ErlangStandaloneSetup().createInjectorAndDoEMFRegistration();
    }
}
