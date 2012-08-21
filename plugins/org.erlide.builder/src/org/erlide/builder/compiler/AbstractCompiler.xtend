package org.erlide.builder.compiler

import java.io.File
import java.io.IOException
import java.util.List
import org.eclipse.core.resources.IFile
import org.erlide.builder.compiler.IErlangCompiler
import org.erlide.builder.StreamListener

abstract class AbstractCompiler implements IErlangCompiler {
	
	def Process launchProcess(IFile file, List<String> cmdLine,
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
    
    def protected void parseLine(String line, IFile file, (IFile, String, int, int)=>void callback) {
		throw new UnsupportedOperationException("AbstractCompiler needs to be subclassed")
    }
    
}