package org.erlide.builder;

import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure4;
import org.erlide.common.process.OutputParser;

@SuppressWarnings("all")
public class ErlParser extends OutputParser {
  public ErlParser(final IFile file, final Procedure4<? super IFile,? super String,? super Integer,? super Integer> callback) {
    super(file, callback);
  }
  
  public void parseLine(final String line) {
    final List<String> parts = ((List<String>)Conversions.doWrapArray(line.split(": ")));
    String _head = IterableExtensions.<String>head(parts);
    final List<String> heads = ((List<String>)Conversions.doWrapArray(_head.split(":")));
    int _size = parts.size();
    final boolean warning = (_size == 3);
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
    Procedure4<? super IFile,? super String,? super Integer,? super Integer> _callback = this.getCallback();
    IFile _file = this.getFile();
    _callback.apply(_file, msg, Integer.valueOf(nline), Integer.valueOf(severity));
  }
}
