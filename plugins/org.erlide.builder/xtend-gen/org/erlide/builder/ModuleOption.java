package org.erlide.builder;

import com.ericsson.otp.erlang.OtpErlang;
import com.ericsson.otp.erlang.OtpErlangAtom;
import com.ericsson.otp.erlang.OtpErlangObject;
import org.erlide.builder.CompilerOption;

@SuppressWarnings("all")
public class ModuleOption extends CompilerOption {
  public ModuleOption(final String name, final String description, final String tooltip) {
    super(name, description, tooltip);
  }
  
  public OtpErlangObject toTerm(final String value) {
    OtpErlangAtom _otpErlangAtom = new OtpErlangAtom(this.name);
    OtpErlangAtom _otpErlangAtom_1 = new OtpErlangAtom(value);
    return OtpErlang.mkTuple(_otpErlangAtom, _otpErlangAtom_1);
  }
  
  public static String toString(final String value) {
    return value;
  }
  
  public static String fromString(final String string) {
    return string;
  }
}
