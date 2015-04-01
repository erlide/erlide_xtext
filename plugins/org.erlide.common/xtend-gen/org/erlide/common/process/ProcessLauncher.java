package org.erlide.common.process;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.common.process.OutputParser;
import org.erlide.common.process.StreamListener;

@SuppressWarnings("all")
public class ProcessLauncher {
  public static Process launchProcess(final IFile file, final List<String> cmdLine, final File workingDirectory, final OutputParser parser) {
    final ProcessBuilder builder = new ProcessBuilder(cmdLine);
    builder.directory(workingDirectory);
    try {
      final Process process = builder.start();
      InputStream _inputStream = process.getInputStream();
      final Procedure1<String> _function = new Procedure1<String>() {
        @Override
        public void apply(final String it) {
          parser.parseLine(it);
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
}
