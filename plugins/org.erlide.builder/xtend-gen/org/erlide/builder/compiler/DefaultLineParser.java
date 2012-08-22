package org.erlide.builder.compiler;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.compiler.CompilerProblem;
import org.erlide.builder.compiler.IProblemLineParser;

@SuppressWarnings("all")
public class DefaultLineParser implements IProblemLineParser {
  public void parseLine(final String line, final IFile file, final Procedure1<? super CompilerProblem> callback) {
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
    final int nline = Integer.parseInt(_head);
    CompilerProblem _compilerProblem = new CompilerProblem(file, msg, nline, severity);
    final CompilerProblem problem = _compilerProblem;
    callback.apply(problem);
  }
}
