package org.erlide.builder

import java.util.regex.Pattern

class ProgressLineParser implements ILineParser<String> {
	
	static Pattern patErlc = Pattern::compile("^.*ERLC_EMULATOR.*$")
	
	override parseLine(String line) {
        try {
			if(patErlc.matcher(line).matches) {
				return extractFile(line)
			}     
			return null   
        } catch (Exception e) {
        	//println("ERR>"+line+"<")
        	null
        }
    }
    
    def private String extractFile(String str) {
    	val start = str.lastIndexOf(" ")
    	new String(str.substring(start+1))
    }

}