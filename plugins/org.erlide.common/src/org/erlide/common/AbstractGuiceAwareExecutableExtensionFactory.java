/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.erlide.common;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.erlide.common.util.ErlLogger;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractGuiceAwareExecutableExtensionFactory implements
        IExecutableExtensionFactory, IExecutableExtension {

    public static final String GUICEKEY = "guicekey";
    protected String clazzName;
    protected IConfigurationElement config;

    private final ErlLogger log = ErlLogger.getInstance();

    @Override
    @SuppressWarnings({ "unchecked" })
    public void setInitializationData(final IConfigurationElement config,
            final String propertyName, final Object data) throws CoreException {
        if (data instanceof String) {
            clazzName = (String) data;
        } else if (data instanceof Map<?, ?>) {
            clazzName = ((Map<String, String>) data).get(GUICEKEY);
        }
        if (clazzName == null) {
            throw new IllegalArgumentException("couldn't handle passed data : "
                    + data);
        }
        this.config = config;
    }

    @Override
    public Object create() throws CoreException {
        try {
            final Class<?> clazz = getBundle().loadClass(clazzName);
            final Injector injector = getInjector();
            final Object result = injector.getInstance(clazz);
            if (result instanceof IExecutableExtension) {
                ((IExecutableExtension) result).setInitializationData(config,
                        null, null);
            }
            return result;
        } catch (final Exception e) {
            log.error(e);
            throw new CoreException(new Status(IStatus.ERROR, getBundle()
                    .getSymbolicName(), e.getMessage() + " ExtensionFactory: "
                    + getClass().getName(), e));
        }
    }

    protected abstract Bundle getBundle();

    protected abstract Injector getInjector();
}
