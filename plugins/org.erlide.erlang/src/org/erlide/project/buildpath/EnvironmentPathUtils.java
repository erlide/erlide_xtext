/*******************************************************************************
 * Copyright (c) 2005, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.erlide.project.buildpath;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;

public class EnvironmentPathUtils {
    public static final String PATH_DELIMITER = ";"; //$NON-NLS-1$
    private static final char SEPARATOR = '/';

    public static boolean isFullPath(final IPath path) {
        final String device = path.getDevice();
        return device != null && device.indexOf(SEPARATOR) >= 0;
    }

    public static IPath getLocalPath(final IPath path) {
        // if( path.segment(0).startsWith("#special#")) {
        // return path;
        // }
        if (!isFullPath(path)) {
            return path;
            // throw new RuntimeException("Invalid path");
        }

        String device = path.getDevice();
        final int index = device.indexOf(SEPARATOR);
        Assert.isTrue(index >= 0);
        device = device.substring(index + 1);
        if (device.length() == 1 && device.charAt(0) == IPath.DEVICE_SEPARATOR) {
            device = null;
        }

        return path.setDevice(device);
    }
}
