package org.erlide.builder.compiler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure4;
import org.erlide.builder.StreamListener;
import org.erlide.builder.compiler.IErlangCompiler;

@SuppressWarnings("all")
public abstract class AbstractCompiler implements IErlangCompiler {
  public Process launchProcess(final IFile file, final List<String> cmdLine, final File workingDirectory, final Procedure4<? super IFile,? super String,? super Integer,? super Integer> callback) {
    ProcessBuilder _processBuilder = new ProcessBuilder(cmdLine);
    final ProcessBuilder builder = _processBuilder;
    builder.directory(workingDirectory);
    try {
      final Process process = builder.start();
      InputStream _inputStream = process.getInputStream();
      final Procedure1<String> _function = new Procedure1<String>() {
          public void apply(final String it) {
            AbstractCompiler.this.parseLine(it, file, callback);
          }
        };
      new StreamListener(_inputStream, _function);
      return process;
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected void parseLine(final String line, final IFile file, final Procedure4<? super IFile,? super String,? super Integer,? super Integer> callback) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("AbstractCompiler needs to be subclassed");
    throw _unsupportedOperationException;
  }
}
