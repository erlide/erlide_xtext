package org.erlide.builder.compiler

import org.erlide.builder.compiler.AbstractCompiler
import org.eclipse.core.resources.IFile
import java.io.File
import java.util.List
import org.erlide.builder.StreamListener
import java.io.IOException
import org.erlide.common.util.ErlLogger

abstract class AbstractExternalProcessCompiler extends AbstractCompiler {
	
	def Process launchProcess(IFile file, List<String> cmdLine,
            String workingDirectory, (CompilerProblem)=>void callback) {
        val ProcessBuilder builder = new ProcessBuilder(cmdLine)
        builder.directory(new File(workingDirectory))
        // builder.redirectErrorStream(true)
        try {
            val Process process = builder.start()
            new StreamListener(process.getInputStream()) [ lineParser.parseLine(it, file, callback) ] 
            return process
        } catch (IOException e) {
        	ErlLogger::error(e)
            return null
        }
    }
    
	
}