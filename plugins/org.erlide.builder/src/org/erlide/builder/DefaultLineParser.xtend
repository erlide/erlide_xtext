package org.erlide.builder

import java.util.List
import org.eclipse.core.resources.IMarker

class DefaultLineParser implements ILineParser<CompilerProblem> {
	
	override parseLine(String line) {
        //println("@@@>"+line+"<")
        try {
        	val List<String> parts = line.split(":")
	        val warning = parts.get(2)==" Warning"
	        val msg = if(warning) parts.tail.tail.tail.join(":").trim else parts.tail.tail.join(":").trim
	        val severity = if(warning) IMarker::SEVERITY_WARNING else IMarker::SEVERITY_ERROR
	        val nline = getLine(parts.tail.head)
	      
	      	val result = new CompilerProblem(parts.head, msg, nline, severity)
	        return result
        } catch (Exception e) {
        	//println("ERR>"+line+"<")
        	null
        }
    }
    
    def private getLine(String str) {
    	try { 
    		Integer::parseInt(str)
    	} catch (Exception e) { 
    		0
    	}
    }

}