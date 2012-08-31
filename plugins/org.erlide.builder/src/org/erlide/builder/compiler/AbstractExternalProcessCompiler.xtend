package org.erlide.builder.compiler

import java.io.File
import java.io.IOException
import java.util.List
import org.eclipse.core.resources.IFile
import org.erlide.common.process.StreamListener
import org.erlide.common.util.ErlLogger

abstract class AbstractExternalProcessCompiler extends AbstractCompiler {
	
	def void executeProcess(IFile file, List<String> cmdLine,
            String workingDirectory, IProblemLineParser lineParser, 
            (CompilerProblem)=>void callback) {
        val ProcessBuilder builder = new ProcessBuilder(cmdLine)
        builder.directory(new File(workingDirectory))
        // builder.redirectErrorStream(true)
        try {
            val Process process = builder.start()
            val listener = new StreamListener(process.getInputStream()) [ 
            	val problem = lineParser.parseLine(it)
            	if(problem!=null)
            		callback.apply(problem) 
            ]
            while(listener.alive) {
            	try { listener.join } catch (InterruptedException e) {}
           	}
            return 
        } catch (IOException e) {
        	ErlLogger::error(e)
        }
    }
    
	
}