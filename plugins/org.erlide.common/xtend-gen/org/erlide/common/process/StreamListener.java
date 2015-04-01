package org.erlide.common.process;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
  
  @Override
  public void run() {
    try {
      InputStreamReader _inputStreamReader = new InputStreamReader(this.stream);
      final BufferedReader reader = new BufferedReader(_inputStreamReader);
      String line = null;
      try {
        while ((!Objects.equal((line = reader.readLine()), null))) {
          this.callback.apply(line);
        }
      } catch (final Throwable _t) {
        if (_t instanceof OperationCanceledException) {
          final OperationCanceledException e = (OperationCanceledException)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
