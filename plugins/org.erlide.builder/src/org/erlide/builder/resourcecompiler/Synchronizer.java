package org.erlide.builder.resourcecompiler;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

public class Synchronizer {

    public static void execWithLock(final Object lock, final Procedure0 closure) {
        synchronized (lock) {
            closure.apply();
        }
    }

}
