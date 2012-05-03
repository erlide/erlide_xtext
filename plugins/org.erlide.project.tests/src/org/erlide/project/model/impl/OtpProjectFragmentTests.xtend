package org.erlide.project.model.impl

import org.erlide.project.model.ErlangModelException
import org.junit.Test

class OtpProjectFragmentTests {
    
    @Test
    def void createOtpFragment() {
        val fragment = new OtpProjectFragment(null, "myFrag")      
        val folder = new CodeFolder()
        fragment.addSourceFolder(folder)
    }
    
    @Test(expected=typeof(ErlangModelException))
    def void createBadOtpFragment() {
        val fragment = new OtpProjectFragment(null, "myFrag")      
        val folder = new CodeFolder()
        fragment.addSourceFolder(folder)
        fragment.addSourceFolder(folder)
    }
}