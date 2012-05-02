package org.erlide.project.model;

public class ErlangModelException extends Exception {

    public ErlangModelException() {
        super();
    }

    public ErlangModelException(final String msg) {
        super(msg);
    }

    public ErlangModelException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ErlangModelException(final Throwable cause) {
        super(cause);
    }
}
