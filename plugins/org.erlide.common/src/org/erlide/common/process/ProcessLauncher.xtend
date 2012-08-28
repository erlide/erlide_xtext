package org.erlide.common.process

import org.eclipse.core.resources.IFile
import java.util.List
import java.io.File
import java.io.IOException
import org.erlide.common.process.OutputParser

class ProcessLauncher {

	    def static Process launchProcess(IFile file, List<String> cmdLine,
            File workingDirectory, OutputParser parser) {
        val ProcessBuilder builder = new ProcessBuilder(cmdLine)
        builder.directory(workingDirectory)
        // builder.redirectErrorStream(true)
        try {
            val Process process = builder.start()
            new StreamListener(process.getInputStream()) [ parser.parseLine(it) ] 
            return process
        } catch (IOException e) {
            return null
        }
    }
 
}