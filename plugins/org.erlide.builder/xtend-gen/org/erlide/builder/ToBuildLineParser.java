package org.erlide.builder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.erlide.builder.ILineParser;

@SuppressWarnings("all")
public class ToBuildLineParser implements ILineParser<String> {
  private static Pattern patNewer = new Function0<Pattern>() {
    public Pattern apply() {
      Pattern _compile = Pattern.compile("^.*rl\' is newer.*$");
      return _compile;
    }
  }.apply();
  
  private static Pattern patRemake = new Function0<Pattern>() {
    public Pattern apply() {
      Pattern _compile = Pattern.compile("^.*Must remake target.*\\.beam.*$");
      return _compile;
    }
  }.apply();
  
  private static Pattern patDo3 = new Function0<Pattern>() {
    public Pattern apply() {
      Pattern _compile = Pattern.compile("^.*do3/.*$");
      return _compile;
    }
  }.apply();
  
  public String parseLine(final String line) {
    String _xtrycatchfinallyexpression = null;
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
    return _xtrycatchfinallyexpression;
  }
  
  private String extractFile(final String str) {
    String _xblockexpression = null;
    {
      final int start = str.indexOf("`");
      int _plus = (start + 1);
      final int end = str.indexOf("\'", _plus);
      int _plus_1 = (start + 1);
      String _substring = str.substring(_plus_1, end);
      String _string = new String(_substring);
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
}
