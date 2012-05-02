package org.erlide.project.model.impl

import org.eclipse.core.runtime.IPath
import org.erlide.project.model.IErlangProject
import org.erlide.project.model.ICodeFolder
import org.erlide.project.model.ErlangModelException

public class OtpProjectFragment extends ProjectFragment {

    /**
     * Creates an OtpPreojectFragment from the file structure found in the directory 'root'.
     * 
     * TODO maybe we want this to be done in builder? here we can have just basic setters and getters
     */
    new(IErlangProject project,
            String name, IPath root) {
        super(project, name)
    }
    
    protected new(IErlangProject project,
            String name) {
        super(project, name)
        // TODO Auto-generated constructor stub
    }
    
    override void addSourceFolder(ICodeFolder folder) {
        if(sourceFolders.size > 0) 
            throw new ErlangModelException("OtpProjectFragment can only have one source folder")
        sourceFolders.add(folder)
    }

}
