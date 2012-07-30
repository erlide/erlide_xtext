package org.erlide.project.model.impl

import org.erlide.project.model.ErlangModelException
import org.junit.Test
import org.eclipse.core.runtime.Path

class OtpProjectFragmentTests {
    
    @Test
    def void createOtpFragment() {
        val fragment = new OtpProjectFragment(null, "myFrag")      
        val folder = new CodeFolder(new Path(""))
        fragment.addSourceFolder(folder)
    }
    
    @Test(expected=typeof(ErlangModelException))
    def void createBadOtpFragment() {
        val fragment = new OtpProjectFragment(null, "myFrag")      
        val folder = new CodeFolder(new Path(""))
        fragment.addSourceFolder(folder)
        fragment.addSourceFolder(folder)
    }
    
    @Test
    def void realizeOtpFragment() {
        val fragment = new OtpProjectFragment(null, "myFrag")      
        val folder = new CodeFolder(new Path(""))
        fragment.addSourceFolder(folder)
    }
    
    
}
