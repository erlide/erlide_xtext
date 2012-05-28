package org.erlide.project.model.impl

import org.eclipse.core.runtime.IPath
import org.erlide.project.model.IErlangProject
import org.erlide.project.model.ICodeFolder
import org.erlide.project.model.ErlangModelException
import org.eclipse.core.runtime.Path

public class OtpProjectFragment extends ProjectFragment {

    /**
     * Creates an OtpProjectFragment from the file structure found in the directory 'root'.
     * 
     * TODO maybe we want this to be done in builder? here we can have just basic setters and getters
     */
    new(IErlangProject project, String name, IPath root) {
        this(project, name)
        sourceFolders = <ICodeFolder>newHashSet(new CodeFolder(new Path("src")))
        sourceFolders = <ICodeFolder>newHashSet(new CodeFolder(new Path("include")))
        docPath = new Path("doc")
        privPath = new Path("priv")
    }
    
    new(IErlangProject project,
            String name) {
        super(project, name)
        // TODO Auto-generated constructor stub
    }
    
    override void addSourceFolder(ICodeFolder folder) {
        if(sourceFolders.size > 0) 
            throw new ErlangModelException("OtpProjectFragment can only have one source folder")
        sourceFolders.add(folder)
    }

    override void realize() {
        
    }

}
