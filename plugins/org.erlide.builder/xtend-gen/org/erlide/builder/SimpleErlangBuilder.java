package org.erlide.builder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure4;
import org.erlide.builder.StreamListener;

@SuppressWarnings("all")
public class SimpleErlangBuilder {
  public static void compileResource(final IFile file, final Procedure4<? super IFile,? super String,? super Integer,? super Integer> callback) {
    String _name = file.getName();
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("erlc", _name);
    IContainer _parent = file.getParent();
    IPath _location = _parent.getLocation();
    String _portableString = _location.toPortableString();
    File _file = new File(_portableString);
    SimpleErlangBuilder.launchProcess(file, _newArrayList, _file, callback);
  }
  
  public static Process launchProcess(final IFile file, final List<String> cmdLine, final File workingDirectory, final Procedure4<? super IFile,? super String,? super Integer,? super Integer> callback) {
    ProcessBuilder _processBuilder = new ProcessBuilder(cmdLine);
    final ProcessBuilder builder = _processBuilder;
    builder.directory(workingDirectory);
    try {
      final Process process = builder.start();
      InputStream _inputStream = process.getInputStream();
      final Procedure1<String> _function = new Procedure1<String>() {
          public void apply(final String it) {
            SimpleErlangBuilder.parseLine(it, file, callback);
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
  
  public static void parseLine(final String line, final IFile file, final Procedure4<? super IFile,? super String,? super Integer,? super Integer> callback) {
    final List<String> parts = ((List<String>)Conversions.doWrapArray(line.split(": ")));
    String _head = IterableExtensions.<String>head(parts);
    final List<String> heads = ((List<String>)Conversions.doWrapArray(_head.split(":")));
    int _size = parts.size();
    final boolean warning = IntegerExtensions.operator_equals(_size, 3);
    String _xifexpression = null;
    if (warning) {
      String _get = parts.get(2);
      _xifexpression = _get;
    } else {
      String _get_1 = parts.get(1);
      _xifexpression = _get_1;
    }
    final String msg = _xifexpression;
    int _xifexpression_1 = (int) 0;
    if (warning) {
      _xifexpression_1 = IMarker.SEVERITY_WARNING;
    } else {
      _xifexpression_1 = IMarker.SEVERITY_ERROR;
    }
    final int severity = _xifexpression_1;
    Iterable<String> _tail = IterableExtensions.<String>tail(heads);
    String _head_1 = IterableExtensions.<String>head(_tail);
    final int nline = Integer.parseInt(_head_1);
    callback.apply(file, msg, Integer.valueOf(nline), Integer.valueOf(severity));
  }
}
