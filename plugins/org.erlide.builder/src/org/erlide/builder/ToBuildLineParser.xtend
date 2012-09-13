package org.erlide.builder

import java.util.regex.Pattern

class ToBuildLineParser implements ILineParser<String> {
	
	static Pattern patNewer = Pattern::compile("^.*rl' is newer.*$")
	static Pattern patRemake = Pattern::compile("^.*Must remake target.*\\.beam.*$")
	static Pattern patDo3 = Pattern::compile("^.*do3/.*$")
	
	override parseLine(String line) {
        //println("@@@>"+line+"<")
        try {
			if(patNewer.matcher(line).matches) {
				return extractFile(line)
			}     
			if(patRemake.matcher(line).matches) {
				if(patDo3.matcher(line).matches) 
					return null
				return extractFile(line)
			}     
			return null   
        } catch (Exception e) {
        	//println("ERR>"+line+"<")
        	null
        }
    }
    
    def private String extractFile(String str) {
    	val start = str.indexOf("`")
    	val end = str.indexOf("'", start+1)
    	new String(str.substring(start+1, end))
    }

}