package org.erlide.project.buildpath.convert;

import org.eclipse.core.resources.IProject;
import org.erlide.project.buildpath.IBuildpathEntry;

public interface IOldProjectBuildpathConverter {

    /**
     * Old-style projects will be converted to a buildpath consisting of the
     * following containers:
     * <ul>
     * <li>the project proper, with folders for all source & include paths</li>
     * <li>the OTP library</li>
     * <li>referenced projects</li>
     * </ul>
     * 
     * If "external modules" has references to modules not in any refernced
     * project, they will be lost. We could scan and compare to the projects, in
     * order to extract the real external libraries, but at the moment it feels
     * too much work for too little benefit.
     * 
     * Project must have an old Erlang nature.
     */
    IBuildpathEntry convert(IProject project);

}
