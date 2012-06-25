package org.erlide.project.compiler;

import com.ericsson.otp.erlang.OtpErlangAtom;
import com.ericsson.otp.erlang.OtpErlangObject;

@SuppressWarnings("all")
public class WarningOption extends BooleanOption {
    public WarningOption(final String name, final boolean defaultValue,
            final String description, final String tooltip) {
        super(name, defaultValue, description, tooltip);
    }

    public OtpErlangObject toTerm(final boolean currentValue) {
        OtpErlangAtom _xifexpression = null;
        if (currentValue) {
            final OtpErlangAtom _otpErlangAtom = new OtpErlangAtom(name);
            _xifexpression = _otpErlangAtom;
        } else {
            final String _plus = "no" + name;
            final OtpErlangAtom _otpErlangAtom_1 = new OtpErlangAtom(_plus);
            _xifexpression = _otpErlangAtom_1;
        }
        return _xifexpression;
    }
}
