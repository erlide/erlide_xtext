package org.erlide.builder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class StreamListener extends Thread {
  private InputStream stream;
  
  private Procedure1<? super String> callback;
  
  public StreamListener(final InputStream stream, final Procedure1<? super String> callback) {
    this.stream = stream;
    this.callback = callback;
    this.start();
  }
  
  public void run() {
    try {
      InputStreamReader _inputStreamReader = new InputStreamReader(this.stream);
      BufferedReader _bufferedReader = new BufferedReader(_inputStreamReader);
      final BufferedReader reader = _bufferedReader;
      String line = null;
      String _readLine = reader.readLine();
      String _line = line = _readLine;
      boolean _notEquals = ObjectExtensions.operator_notEquals(_line, null);
      boolean _while = _notEquals;
      while (_while) {
        this.callback.apply(line);
        String _readLine_1 = reader.readLine();
        String _line_1 = line = _readLine_1;
        boolean _notEquals_1 = ObjectExtensions.operator_notEquals(_line_1, null);
        _while = _notEquals_1;
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
