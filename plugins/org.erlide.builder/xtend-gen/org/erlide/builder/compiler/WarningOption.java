package org.erlide.builder.compiler;

import com.ericsson.otp.erlang.OtpErlangAtom;
import com.ericsson.otp.erlang.OtpErlangObject;
import org.erlide.builder.compiler.BooleanOption;

@SuppressWarnings("all")
public class WarningOption extends BooleanOption {
  public WarningOption(final String name, final boolean defaultValue, final String description, final String tooltip) {
    super(name, defaultValue, description, tooltip);
  }
  
  public OtpErlangObject toTerm(final boolean currentValue) {
    OtpErlangAtom _xifexpression = null;
    if (currentValue) {
      OtpErlangAtom _otpErlangAtom = new OtpErlangAtom(this.name);
      _xifexpression = _otpErlangAtom;
    } else {
      String _plus = ("no" + this.name);
      OtpErlangAtom _otpErlangAtom_1 = new OtpErlangAtom(_plus);
      _xifexpression = _otpErlangAtom_1;
    }
    return _xifexpression;
  }
}
