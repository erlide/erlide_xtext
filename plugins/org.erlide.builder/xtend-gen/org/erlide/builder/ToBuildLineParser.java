package org.erlide.builder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.erlide.builder.ILineParser;

@SuppressWarnings("all")
public class ToBuildLineParser implements ILineParser<String> {
  private static Pattern patNewer = Pattern.compile("^.*rl\' is newer.*$");
  
  private static Pattern patRemake = Pattern.compile("^.*Must remake target.*\\.beam.*$");
  
  private static Pattern patDo3 = Pattern.compile("^.*do3/.*$");
  
  @Override
  public String parseLine(final String line) {
    Object _xtrycatchfinallyexpression = null;
    try {
      Matcher _matcher = ToBuildLineParser.patNewer.matcher(line);
      boolean _matches = _matcher.matches();
      if (_matches) {
        return this.extractFile(line);
      }
      Matcher _matcher_1 = ToBuildLineParser.patRemake.matcher(line);
      boolean _matches_1 = _matcher_1.matches();
      if (_matches_1) {
        Matcher _matcher_2 = ToBuildLineParser.patDo3.matcher(line);
        boolean _matches_2 = _matcher_2.matches();
        if (_matches_2) {
          return null;
        }
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
      final int start = str.indexOf("`");
      final int end = str.indexOf("\'", (start + 1));
      String _substring = str.substring((start + 1), end);
      _xblockexpression = new String(_substring);
    }
    return _xblockexpression;
  }
}
