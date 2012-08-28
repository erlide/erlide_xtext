package org.erlide.builder.compiler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.compiler.AbstractCompiler;
import org.erlide.builder.compiler.CompilerProblem;
import org.erlide.builder.compiler.IProblemLineParser;
import org.erlide.common.process.StreamListener;
import org.erlide.common.util.ErlLogger;

@SuppressWarnings("all")
public abstract class AbstractExternalProcessCompiler extends AbstractCompiler {
  public void executeProcess(final IFile file, final List<String> cmdLine, final String workingDirectory, final IProblemLineParser lineParser, final Procedure1<? super CompilerProblem> callback) {
    ProcessBuilder _processBuilder = new ProcessBuilder(cmdLine);
    final ProcessBuilder builder = _processBuilder;
    File _file = new File(workingDirectory);
    builder.directory(_file);
    try {
      final Process process = builder.start();
      InputStream _inputStream = process.getInputStream();
      final Procedure1<String> _function = new Procedure1<String>() {
          public void apply(final String it) {
            final CompilerProblem problem = lineParser.parseLine(it);
            callback.apply(problem);
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
        ErlLogger.error(e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
