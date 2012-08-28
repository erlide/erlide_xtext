package org.erlide.builder

import java.io.File
import java.util.List
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.erlide.common.process.OutputParser
import org.erlide.common.process.ProcessLauncher

public class SimpleErlangBuilder {

    def static void compileResource(IFile file, (IFile, String, int, int)=>void callback) {
        ProcessLauncher::launchProcess(file, newArrayList("erlc", file.getName()), new File(
            file.getParent().getLocation().toPortableString()), new ErlParser(file, callback))
    }

}

class ErlParser extends OutputParser {
	
	new(IFile file, (IFile, String, int, int)=>void callback) {
		super(file, callback)
	}
	
   override void parseLine(String line) {
        val List<String> parts = line.split(": ")
        val List<String> heads = parts.head.split(":") 
        val warning = parts.size==3
        val msg = if(warning) parts.get(2) else parts.get(1) 
        val severity = if(warning) IMarker::SEVERITY_WARNING else IMarker::SEVERITY_ERROR
        val nline = Integer::parseInt(heads.tail.head)
        
        callback.apply(file, msg, nline, severity)                
    }
    
}