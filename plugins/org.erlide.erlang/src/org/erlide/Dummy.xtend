package org.erlide

import static extension org.eclipse.xtext.xbase.lib.LongExtensions.*

class Dummy {
	long time
	
	new() {
	    time = System::currentTimeMillis
	    println(">>>"+shiftRight(time, 2))
	}
}