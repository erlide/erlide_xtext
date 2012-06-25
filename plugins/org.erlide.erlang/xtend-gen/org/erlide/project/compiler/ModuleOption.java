package org.erlide.project.compiler;

import com.ericsson.otp.erlang.OtpErlang;
import com.ericsson.otp.erlang.OtpErlangAtom;
import com.ericsson.otp.erlang.OtpErlangObject;
import com.ericsson.otp.erlang.OtpErlangTuple;

@SuppressWarnings("all")
public class ModuleOption extends CompilerOption {
    public ModuleOption(final String name, final String description,
            final String tooltip) {
        super(name, description, tooltip);
    }

    public OtpErlangObject toTerm(final String value) {
        final OtpErlangAtom _otpErlangAtom = new OtpErlangAtom(name);
        final OtpErlangAtom _otpErlangAtom_1 = new OtpErlangAtom(value);
        final OtpErlangTuple _mkTuple = OtpErlang.mkTuple(_otpErlangAtom,
                _otpErlangAtom_1);
        return _mkTuple;
    }

    public static String toString(final String value) {
        return value;
    }

    public static String fromString(final String string) {
        return string;
    }
}
