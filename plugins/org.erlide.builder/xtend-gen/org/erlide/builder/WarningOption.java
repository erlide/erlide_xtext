package org.erlide.builder;

import com.ericsson.otp.erlang.OtpErlangAtom;
import com.ericsson.otp.erlang.OtpErlangObject;
import org.erlide.builder.BooleanOption;

@SuppressWarnings("all")
public class WarningOption extends BooleanOption {
  public WarningOption(final String name, final boolean defaultValue, final String description, final String tooltip) {
    super(name, defaultValue, description, tooltip);
  }
  
  @Override
  public OtpErlangObject toTerm(final boolean currentValue) {
    OtpErlangAtom _xifexpression = null;
    if (currentValue) {
      _xifexpression = new OtpErlangAtom(this.name);
    } else {
      _xifexpression = new OtpErlangAtom(("no" + this.name));
    }
    return _xifexpression;
  }
}
