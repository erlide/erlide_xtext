package org.erlide.builder

import java.io.File
import java.io.IOException
import java.util.List
import org.erlide.common.process.StreamListener
import org.erlide.common.util.ErlLogger
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException

class BuilderExecutor {

	List<BuilderHandler<?>> handlers
	
	new() {
		handlers = newArrayList()
	}

	def void executeProcess(List<String> cmdLine,
            String workingDirectory, IProgressMonitor monitor) {
            	
        if (cmdLine==null || workingDirectory==null) return
            	
        val ProcessBuilder builder = new ProcessBuilder(cmdLine)
        builder.directory(new File(workingDirectory))
        //builder.redirectErrorStream(true)
        try {
            val Process process = builder.start()
            val listener = new StreamListener(process.inputStream) [
            	if (monitor.canceled) {
            		process.destroy
	           		throw new OperationCanceledException()
           		}
           		for(handler: handlers) {
           			handler.eval(it)
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

	def private <T> registerHandler(ILineParser<T> lineParser, 
            (T)=>void callback) {
        val handler = new BuilderHandler<T>(lineParser, callback)
    	handlers.add(handler)        	
    	return handler
    }
 
	def private <T> unregisterHandler(BuilderHandler<T> handler) {
    	handlers.remove(handler)        	
    }
 
 	def <T> withHandler(ILineParser<T> lineParser, 
            (T)=>void callback, (BuilderExecutor)=>void handlerCallback) {
 		val handler = registerHandler(lineParser, callback)
 		try {
 			handlerCallback.apply(this)
 		} finally {
 			unregisterHandler(handler)
 		}
 	}
 
 }

@Data
class BuilderHandler<T> {
	ILineParser<T> lineParser 
    (T)=>void callback
    
    def eval(String line) {
 		val T item = lineParser.parseLine(line)
    	if(item!=null) {
    		callback.apply(item)
   		}
    }
}