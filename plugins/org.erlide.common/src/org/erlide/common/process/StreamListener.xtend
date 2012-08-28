package org.erlide.common.process

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

public class StreamListener extends Thread {

    InputStream stream
    (String)=>void callback

    new(InputStream stream, (String)=>void callback) {
        this.stream = stream
        this.callback = callback
        start()
    }
 
    override void run() {
        val BufferedReader reader = new BufferedReader(new InputStreamReader(stream))
        var String line
        while ((line = reader.readLine()) != null) {
            callback.apply(line)
        }
    }
    
}
