package org.erlide.builder;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.core.resources.IMarker;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.ILineParser;

@SuppressWarnings("all")
public class DefaultLineParser implements ILineParser<CompilerProblem> {
  @Override
  public CompilerProblem parseLine(final String line) {
    Object _xtrycatchfinallyexpression = null;
    try {
      final List<String> parts = (List<String>)Conversions.doWrapArray(line.split(":"));
      String _get = parts.get(2);
      final boolean warning = Objects.equal(_get, " Warning");
      String _xifexpression = null;
      if (warning) {
        Iterable<String> _tail = IterableExtensions.<String>tail(parts);
        Iterable<String> _tail_1 = IterableExtensions.<String>tail(_tail);
        Iterable<String> _tail_2 = IterableExtensions.<String>tail(_tail_1);
        String _join = IterableExtensions.join(_tail_2, ":");
        _xifexpression = _join.trim();
      } else {
        Iterable<String> _tail_3 = IterableExtensions.<String>tail(parts);
        Iterable<String> _tail_4 = IterableExtensions.<String>tail(_tail_3);
        String _join_1 = IterableExtensions.join(_tail_4, ":");
        _xifexpression = _join_1.trim();
      }
      final String msg = _xifexpression;
      int _xifexpression_1 = (int) 0;
      if (warning) {
        _xifexpression_1 = IMarker.SEVERITY_WARNING;
      } else {
        _xifexpression_1 = IMarker.SEVERITY_ERROR;
      }
      final int severity = _xifexpression_1;
      Iterable<String> _tail_5 = IterableExtensions.<String>tail(parts);
      String _head = IterableExtensions.<String>head(_tail_5);
      final int nline = this.getLine(_head);
      String _head_1 = IterableExtensions.<String>head(parts);
      final CompilerProblem result = new CompilerProblem(_head_1, msg, nline, severity);
      return result;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        _xtrycatchfinallyexpression = null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return ((CompilerProblem)_xtrycatchfinallyexpression);
  }
  
  private int getLine(final String str) {
    int _xtrycatchfinallyexpression = (int) 0;
    try {
      _xtrycatchfinallyexpression = Integer.parseInt(str);
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
