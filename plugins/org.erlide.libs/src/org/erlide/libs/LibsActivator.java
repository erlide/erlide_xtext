package org.erlide.libs;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.core.resources.ResourcesPlugin;
import org.erlide.common.util.DebugStream;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class LibsActivator implements BundleActivator {

    @Override
    public void start(final BundleContext context) throws Exception {
        DebugStream.activate();
        System.out.println("START ERLIDE " + context.getBundle().getVersion());

        final Properties props = new Properties();
        final InputStream fis = context.getBundle()
                .getEntry("/log4j.properties").openStream();
        props.load(fis);
        fis.close();
        props.putAll(System.getProperties());
        PropertyConfigurator.configure(props);

        setLogFileName();
        Logger.getLogger("org.erlide").setAdditivity(false);
    }

    private void setLogFileName() {
        final FileAppender fsa = (FileAppender) Logger.getLogger("org.erlide")
                .getAppender("erlide_log");
        fsa.setFile(getLogDir() + "/erlide.log");
        fsa.activateOptions();
    }

    @Override
    public void stop(final BundleContext context) throws Exception {
    }

    private static String getLogDir() {
        return ResourcesPlugin.getWorkspace().getRoot().getLocation()
                .toPortableString();
    }

}
