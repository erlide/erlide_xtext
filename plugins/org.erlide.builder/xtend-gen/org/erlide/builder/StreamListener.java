package org.erlide.builder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.base.Objects;

@SuppressWarnings("all")
public class StreamListener extends Thread {
    private final InputStream stream;

    private final Procedure1<? super String> callback;

    public StreamListener(final InputStream stream,
            final Procedure1<? super String> callback) {
        this.stream = stream;
        this.callback = callback;
        start();
    }

    public void run() {
        try {
            final InputStreamReader _inputStreamReader = new InputStreamReader(
                    stream);
            final BufferedReader _bufferedReader = new BufferedReader(
                    _inputStreamReader);
            final BufferedReader reader = _bufferedReader;
            String line = null;
            final String _readLine = reader.readLine();
            final String _line = line = _readLine;
            final boolean _notEquals = !Objects.equal(_line, null);
            boolean _while = _notEquals;
            while (_while) {
                callback.apply(line);
                final String _readLine_1 = reader.readLine();
                final String _line_1 = line = _readLine_1;
                final boolean _notEquals_1 = !Objects.equal(_line_1, null);
                _while = _notEquals_1;
            }
        } catch (final Exception _e) {
            throw Exceptions.sneakyThrow(_e);
        }
    }
}
