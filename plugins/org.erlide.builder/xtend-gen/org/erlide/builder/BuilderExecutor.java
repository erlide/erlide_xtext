package org.erlide.builder;

import com.google.common.base.Objects;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.ILineParser;
import org.erlide.common.process.StreamListener;
import org.erlide.common.util.ErlLogger;

@SuppressWarnings("all")
public class BuilderExecutor {
  public <T extends Object> void executeProcess(final List<String> cmdLine, final String workingDirectory, final IProgressMonitor monitor, final ILineParser<T> lineParser, final Procedure1<? super T> callback) {
    ProcessBuilder _processBuilder = new ProcessBuilder(cmdLine);
    final ProcessBuilder builder = _processBuilder;
    File _file = new File(workingDirectory);
    builder.directory(_file);
    try {
      final Process process = builder.start();
      InputStream _inputStream = process.getInputStream();
      final Procedure1<String> _function = new Procedure1<String>() {
          public void apply(final String it) {
            boolean _isCanceled = monitor.isCanceled();
            if (_isCanceled) {
              process.destroy();
              OperationCanceledException _operationCanceledException = new OperationCanceledException();
              throw _operationCanceledException;
            }
            final T problem = lineParser.parseLine(it);
            boolean _notEquals = (!Objects.equal(problem, null));
            if (_notEquals) {
              callback.apply(problem);
            }
          }
        };
      StreamListener _streamListener = new StreamListener(_inputStream, _function);
      final StreamListener listener = _streamListener;
      boolean _isAlive = listener.isAlive();
      boolean _while = _isAlive;
      while (_while) {
        try {
          listener.join();
        } catch (final Throwable _t) {
          if (_t instanceof InterruptedException) {
            final InterruptedException e = (InterruptedException)_t;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        boolean _isAlive_1 = listener.isAlive();
        _while = _isAlive_1;
      }
      return;
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        ErlLogger _instance = ErlLogger.getInstance();
        _instance.error(e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
