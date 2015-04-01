package org.erlide.builder;

import com.ericsson.otp.erlang.OtpErlang;
import com.ericsson.otp.erlang.OtpErlangAtom;
import com.ericsson.otp.erlang.OtpErlangList;
import com.ericsson.otp.erlang.OtpErlangObject;
import com.ericsson.otp.erlang.OtpErlangString;
import com.ericsson.otp.erlang.OtpErlangTuple;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.erlide.builder.CompilerOption;

@SuppressWarnings("all")
public class PathsOption extends CompilerOption {
  public PathsOption(final String name, final String description, final String tooltip) {
    super(name, description, tooltip);
  }
  
  public OtpErlangObject toTerm(final Iterable<String> value) {
    OtpErlangTuple _xblockexpression = null;
    {
      final List<OtpErlangObject> result = CollectionLiterals.<OtpErlangObject>newArrayList();
      for (final String path : value) {
        OtpErlangString _otpErlangString = new OtpErlangString(path);
        result.add(_otpErlangString);
      }
      OtpErlangAtom _otpErlangAtom = new OtpErlangAtom(this.name);
      OtpErlangList _mkList = OtpErlang.mkList(result);
      _xblockexpression = OtpErlang.mkTuple(_otpErlangAtom, _mkList);
    }
    return _xblockexpression;
  }
  
  public static String toString(final Iterable<String> value) {
    Joiner _on = Joiner.on(",");
    return _on.join(value);
  }
  
  public static Iterable<String> fromString(final String string) {
    Splitter _on = Splitter.on(",");
    Splitter _trimResults = _on.trimResults();
    Splitter _omitEmptyStrings = _trimResults.omitEmptyStrings();
    return _omitEmptyStrings.split(string);
  }
}
