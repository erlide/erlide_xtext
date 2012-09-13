package org.erlide.builder

import java.io.File
import java.io.IOException
import java.util.List
import org.erlide.common.process.StreamListener
import org.erlide.common.util.ErlLogger
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException

class BuilderExecutor {
	
		def <T> void executeProcess(List<String> cmdLine,
            String workingDirectory, IProgressMonitor monitor, ILineParser<T> lineParser, 
            (T)=>void callback) {
        val ProcessBuilder builder = new ProcessBuilder(cmdLine)
        builder.directory(new File(workingDirectory))
        //builder.redirectErrorStream(true)
        try {
            val Process process = builder.start()
            val listener = new StreamListener(process.inputStream) [
            	if(monitor.canceled) {
            		process.destroy
	           		throw new OperationCanceledException()
           		}
	           		
            	val problem = lineParser.parseLine(it)
            	if(problem!=null) {
            		callback.apply(problem)
           		} 
            ]
            while(listener.alive) {
            	try { 
            		listener.join 
            	} 
            	catch (InterruptedException e) {
            	}
           	}
            return 
        } catch (IOException e) {
        	ErlLogger::instance.error(e)
        }
    }
    
}