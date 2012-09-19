package org.erlide.builder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.erlide.builder.ILineParser;

@SuppressWarnings("all")
public class ProgressLineParser implements ILineParser<String> {
  private static Pattern patErlc = new Function0<Pattern>() {
    public Pattern apply() {
      Pattern _compile = Pattern.compile("^.*ERLC_EMULATOR.*$");
      return _compile;
    }
  }.apply();
  
  public String parseLine(final String line) {
    String _xtrycatchfinallyexpression = null;
    try {
      Matcher _matcher = ProgressLineParser.patErlc.matcher(line);
      boolean _matches = _matcher.matches();
      if (_matches) {
        return this.extractFile(line);
      }
      return null;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        _xtrycatchfinallyexpression = null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  private String extractFile(final String str) {
    String _xblockexpression = null;
    {
      final int start = str.lastIndexOf(" ");
      int _plus = (start + 1);
      String _substring = str.substring(_plus);
      String _string = new String(_substring);
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
}
