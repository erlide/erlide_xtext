package org.erlide.builder

import java.util.List
import java.io.File
import java.io.IOException
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker

public class SimpleErlangBuilder {
    def static void compileResource(IFile file, (IFile, String, int, int)=>void callback) {
        launchProcess(file, newArrayList("erlc", file.getName()), new File(
            file.getParent().getLocation().toPortableString()), callback)
    }
    
    def static Process launchProcess(IFile file, List<String> cmdLine,
            File workingDirectory, (IFile, String, int, int)=>void callback) {
        val ProcessBuilder builder = new ProcessBuilder(cmdLine)
        builder.directory(workingDirectory)
        // builder.redirectErrorStream(true)
        try {
            val Process process = builder.start()
            new StreamListener(process.getInputStream()) [ parseLine(it, file, callback) ] 
            return process
        } catch (IOException e) {
            return null
        }
    }
    
    def static void parseLine(String line, IFile file, (IFile, String, int, int)=>void callback) {
        val List<String> parts = line.split(": ")
        val List<String> heads = parts.head.split(":") 
        val warning = parts.size==3
        val msg = if(warning) parts.get(2) else parts.get(1) 
        val severity = if(warning) IMarker::SEVERITY_WARNING else IMarker::SEVERITY_ERROR
        val nline = Integer::parseInt(heads.tail.head)
        
        callback.apply(file, msg, nline, severity)                
    }
    
}
