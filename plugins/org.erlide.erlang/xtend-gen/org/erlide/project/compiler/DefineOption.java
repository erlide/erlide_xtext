package org.erlide.project.compiler;

import com.ericsson.otp.erlang.OtpErlang;
import com.ericsson.otp.erlang.OtpErlangAtom;
import com.ericsson.otp.erlang.OtpErlangList;
import com.ericsson.otp.erlang.OtpErlangObject;
import com.ericsson.otp.erlang.OtpErlangTuple;
import com.google.common.base.Strings;
import java.util.Collection;
import java.util.List;
import org.eclipse.core.runtime.Assert;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.erlide.common.util.TermParser;
import org.erlide.project.compiler.CompilerOption;

@SuppressWarnings("all")
public class DefineOption extends CompilerOption {
  private List<String> fieldLabels;
  
  public DefineOption(final String name, final String[] fieldLabels, final String description, final String tooltip) {
    super(name, description, tooltip);
    this.fieldLabels = ((List<String>)Conversions.doWrapArray(fieldLabels));
    int _size = ((List<String>)Conversions.doWrapArray(fieldLabels)).size();
    boolean _equals = (_size == 2);
    Assert.isLegal(_equals);
  }
  
  public String[] getFieldLabels() {
    return ((String[])Conversions.unwrapArray(this.fieldLabels, String.class));
  }
  
  public OtpErlangList toTerm(final Collection<Pair<String,String>> values) {
    try {
      final List<OtpErlangObject> defines = CollectionLiterals.<OtpErlangObject>newArrayList();
      for (final Pair<String,String> value : values) {
        {
          final String key = value.getKey();
          final String val1 = value.getValue();
          OtpErlangAtom _otpErlangAtom = new OtpErlangAtom(this.name);
          final OtpErlangAtom tag = _otpErlangAtom;
          OtpErlangAtom _otpErlangAtom_1 = new OtpErlangAtom(key);
          final OtpErlangAtom okey = _otpErlangAtom_1;
          boolean _isNullOrEmpty = Strings.isNullOrEmpty(val1);
          if (_isNullOrEmpty) {
            OtpErlangTuple _mkTuple = OtpErlang.mkTuple(tag, okey);
            defines.add(_mkTuple);
          } else {
            TermParser _parser = TermParser.getParser();
            final OtpErlangObject ovalue = _parser.parse(val1);
            OtpErlangTuple _mkTuple_1 = OtpErlang.mkTuple(tag, okey, ovalue);
            defines.add(_mkTuple_1);
          }
        }
      }
      return OtpErlang.mkList(defines);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
