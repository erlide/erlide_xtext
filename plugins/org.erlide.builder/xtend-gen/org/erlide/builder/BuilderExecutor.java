package org.erlide.builder;

import com.google.common.base.Objects;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.BuilderHandler;
import org.erlide.builder.ILineParser;
import org.erlide.common.process.StreamListener;
import org.erlide.common.util.ErlLogger;

@SuppressWarnings("all")
public class BuilderExecutor {
  private List<BuilderHandler<?>> handlers;
  
  public BuilderExecutor() {
    ArrayList<BuilderHandler<?>> _newArrayList = CollectionLiterals.<BuilderHandler<?>>newArrayList();
    this.handlers = _newArrayList;
  }
  
  public void executeProcess(final List<String> cmdLine, final String workingDirectory, final IProgressMonitor monitor) {
    boolean _or = false;
    boolean _equals = Objects.equal(cmdLine, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = Objects.equal(workingDirectory, null);
      _or = _equals_1;
    }
    if (_or) {
      return;
    }
    final ProcessBuilder builder = new ProcessBuilder(cmdLine);
    File _file = new File(workingDirectory);
    builder.directory(_file);
    try {
      final Process process = builder.start();
      InputStream _inputStream = process.getInputStream();
      final Procedure1<String> _function = new Procedure1<String>() {
        @Override
        public void apply(final String it) {
          boolean _isCanceled = monitor.isCanceled();
          if (_isCanceled) {
            process.destroy();
            throw new OperationCanceledException();
          }
          for (final BuilderHandler<?> handler : BuilderExecutor.this.handlers) {
            handler.eval(it);
          }
        }
      };
      final StreamListener listener = new StreamListener(_inputStream, _function);
      while (listener.isAlive()) {
        try {
          listener.join();
        } catch (final Throwable _t) {
          if (_t instanceof InterruptedException) {
            final InterruptedException e = (InterruptedException)_t;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
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
  
  private <T extends Object> BuilderHandler<T> registerHandler(final ILineParser<T> lineParser, final Procedure1<? super T> callback) {
    final BuilderHandler<T> handler = new BuilderHandler<T>(lineParser, callback);
    this.handlers.add(handler);
    return handler;
  }
  
  private <T extends Object> boolean unregisterHandler(final BuilderHandler<T> handler) {
    return this.handlers.remove(handler);
  }
  
  public <T extends Object> void withHandler(final ILineParser<T> lineParser, final Procedure1<? super T> callback, final Procedure1<? super BuilderExecutor> handlerCallback) {
    final BuilderHandler<T> handler = this.<T>registerHandler(lineParser, callback);
    try {
      handlerCallback.apply(this);
    } finally {
      this.<T>unregisterHandler(handler);
    }
  }
}
