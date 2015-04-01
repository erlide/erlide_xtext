package org.erlide.builder;

import com.ericsson.otp.erlang.OtpErlangAtom;
import com.ericsson.otp.erlang.OtpErlangObject;
import org.erlide.builder.CompilerOption;

@SuppressWarnings("all")
public class BooleanOption extends CompilerOption {
  private boolean defaultValue;
  
  public BooleanOption(final String name, final boolean defaultValue, final String description, final String tooltip) {
    super(name, description, tooltip);
    this.defaultValue = defaultValue;
  }
  
  public boolean getDefaultValue() {
    return this.defaultValue;
  }
  
  public OtpErlangObject toTerm(final boolean currentValue) {
    OtpErlangAtom _xifexpression = null;
    if (currentValue) {
      _xifexpression = new OtpErlangAtom(this.name);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
}
