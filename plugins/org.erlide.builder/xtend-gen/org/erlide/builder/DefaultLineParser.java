package org.erlide.builder;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.core.resources.IMarker;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.IProblemLineParser;

@SuppressWarnings("all")
public class DefaultLineParser implements IProblemLineParser {
  public CompilerProblem parseLine(final String line) {
    CompilerProblem _xtrycatchfinallyexpression = null;
    try {
      final List<String> parts = ((List<String>)Conversions.doWrapArray(line.split(":")));
      String _get = parts.get(2);
      final boolean warning = Objects.equal(_get, " Warning");
      Iterable<String> _tail = IterableExtensions.<String>tail(parts);
      Iterable<String> _tail_1 = IterableExtensions.<String>tail(_tail);
      String _join = IterableExtensions.join(_tail_1, ":");
      final String msg = _join.trim();
      int _xifexpression = (int) 0;
      if (warning) {
        _xifexpression = IMarker.SEVERITY_WARNING;
      } else {
        _xifexpression = IMarker.SEVERITY_ERROR;
      }
      final int severity = _xifexpression;
      Iterable<String> _tail_2 = IterableExtensions.<String>tail(parts);
      String _head = IterableExtensions.<String>head(_tail_2);
      final int nline = this.getLine(_head);
      String _head_1 = IterableExtensions.<String>head(parts);
      CompilerProblem _compilerProblem = new CompilerProblem(_head_1, msg, nline, severity);
      return _compilerProblem;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        CompilerProblem _xblockexpression = null;
        {
          String _plus = ("ERR>" + line);
          String _plus_1 = (_plus + "<");
          InputOutput.<String>println(_plus_1);
          _xblockexpression = (null);
        }
        _xtrycatchfinallyexpression = _xblockexpression;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  private int getLine(final String str) {
    int _xtrycatchfinallyexpression = (int) 0;
    try {
      int _parseInt = Integer.parseInt(str);
      _xtrycatchfinallyexpression = _parseInt;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        _xtrycatchfinallyexpression = 0;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
}
