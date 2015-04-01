package org.erlide.builder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.erlide.builder.ILineParser;

@SuppressWarnings("all")
public class ProgressLineParser implements ILineParser<String> {
  private static Pattern patErlc = Pattern.compile("^.*ERLC_EMULATOR.*$");
  
  @Override
  public String parseLine(final String line) {
    Object _xtrycatchfinallyexpression = null;
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
    return ((String)_xtrycatchfinallyexpression);
  }
  
  private String extractFile(final String str) {
    String _xblockexpression = null;
    {
      final int start = str.lastIndexOf(" ");
      String _substring = str.substring((start + 1));
      _xblockexpression = new String(_substring);
    }
    return _xblockexpression;
  }
}
