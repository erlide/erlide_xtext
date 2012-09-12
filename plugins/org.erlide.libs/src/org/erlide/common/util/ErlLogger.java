package org.erlide.common.util;

/*******************************************************************************
 * Copyright (c) 2007 Vlad Dumitrescu and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Vlad Dumitrescu
 *******************************************************************************/

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.google.inject.Singleton;

@Singleton
public class ErlLogger {

    private static ErlLogger instance;
    private Logger logger;
    private String logDir;

    @Deprecated
    public static ErlLogger getInstance() {
        if (instance == null) {
            instance = new ErlLogger();
        }
        return instance;
    }

    public ErlLogger() {
        logger = Logger.getLogger("org.erlide");
        logger.setLevel(Level.DEBUG);
    }

    public void dispose() {
        logger = null;
    }

    public final void setLogDir(final String dir) {
        logDir = dir == null ? "./" : dir;
    }

    public String getLogLocation() {
        return logDir + "/erlide.log";
    }

    private static String format(final String fmt, final Object... o) {
        final StackTraceElement el = getCaller();
        final String str = o.length == 0 ? fmt : String.format(fmt, o);
        final String msg = "(" + el.getFileName() + ":" + el.getLineNumber()
                + ") : " + str;
        return msg;
    }

    public void erlangLog(final String module, final int line,
            final String skind, final String fmt, final Object... o) {
        final Level kind = Level.toLevel(skind);
        final String str = o.length == 0 ? fmt : String.format(fmt, o);
        final String msg = "(" + module + ":" + line + ") : " + str;
        if (logger != null) {
            logger.log(kind, msg);
        }
    }

    public void debug(final String fmt, final Object... o) {
        if (logger.isDebugEnabled()) {
            logger.debug(format(fmt, o));
        }
    }

    public void info(final String fmt, final Object... o) {
        if (logger.isInfoEnabled()) {
            logger.info(format(fmt, o));
        }
    }

    public void warn(final String fmt, final Object... o) {
        logger.warn(format(fmt, o));
    }

    public void error(final String fmt, final Object... o) {
        logger.error(format(fmt, o));
    }

    public void debug(final Throwable e) {
        debug(e);
    }

    public void info(final Throwable e) {
        info(e);
    }

    public void warn(final Throwable e) {
        warn(e);
    }

    public void error(final Throwable exception) {
        error(exception);
    }

    private static StackTraceElement getCaller() {
        final StackTraceElement[] st = Thread.currentThread().getStackTrace();
        StackTraceElement el = null;
        int i = 2;
        do {
            el = st[i++];
        } while (el.getClassName().equals(ErlLogger.class.getName()));
        return el;
    }

    public static class ErlSimpleFormatter extends Formatter {

        Date dat = new Date();
        private static final String FORMAT_STRING = "{0,time,HH:mm:ss,SSS}";
        private MessageFormat formatter;

        private final Object[] args = new Object[1];

        private final String lineSeparator = System
                .getProperty("line.separator");

        @Override
        public synchronized String format(final LogRecord record) {
            final StringBuffer sb = new StringBuffer();
            // Minimize memory allocations here.
            dat.setTime(record.getMillis());
            args[0] = dat;
            final StringBuffer text = new StringBuffer();
            if (formatter == null) {
                formatter = new MessageFormat(FORMAT_STRING);
            }
            formatter.format(args, text, null);
            sb.append(text);
            sb.append(' ');
            final String message = formatMessage(record);
            sb.append(record.getLevel().toString().charAt(0));
            sb.append(": ");
            sb.append(message);
            sb.append(lineSeparator);
            if (record.getThrown() != null) {
                try {
                    final StringWriter sw = new StringWriter();
                    final PrintWriter pw = new PrintWriter(sw);
                    record.getThrown().printStackTrace(pw);
                    pw.close();
                    sb.append(sw.toString());
                } catch (final Exception ex) {
                    // ignore
                }
            }
            return sb.toString();
        }
    }

}
