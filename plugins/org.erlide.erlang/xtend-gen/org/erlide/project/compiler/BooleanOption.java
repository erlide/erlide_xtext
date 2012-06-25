package org.erlide.project.compiler;

import com.ericsson.otp.erlang.OtpErlangAtom;
import com.ericsson.otp.erlang.OtpErlangObject;

@SuppressWarnings("all")
public class BooleanOption extends CompilerOption {
    private final boolean defaultValue;

    public BooleanOption(final String name, final boolean defaultValue,
            final String description, final String tooltip) {
        super(name, description, tooltip);
        this.defaultValue = defaultValue;
    }

    public boolean getDefaultValue() {
        return defaultValue;
    }

    public OtpErlangObject toTerm(final boolean currentValue) {
        OtpErlangAtom _xifexpression = null;
        if (currentValue) {
            final OtpErlangAtom _otpErlangAtom = new OtpErlangAtom(name);
            _xifexpression = _otpErlangAtom;
        } else {
            _xifexpression = null;
        }
        return _xifexpression;
    }
}
