package org.erlide.project.compiler;

import java.util.List;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

import com.ericsson.otp.erlang.OtpErlang;
import com.ericsson.otp.erlang.OtpErlangAtom;
import com.ericsson.otp.erlang.OtpErlangList;
import com.ericsson.otp.erlang.OtpErlangObject;
import com.ericsson.otp.erlang.OtpErlangString;
import com.ericsson.otp.erlang.OtpErlangTuple;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

@SuppressWarnings("all")
public class PathsOption extends CompilerOption {
    public PathsOption(final String name, final String description,
            final String tooltip) {
        super(name, description, tooltip);
    }

    public OtpErlangObject toTerm(final Iterable<String> value) {
        OtpErlangTuple _xblockexpression = null;
        {
            final List<OtpErlangObject> result = CollectionLiterals
                    .<OtpErlangObject> newArrayList();
            for (final String path : value) {
                final OtpErlangString _otpErlangString = new OtpErlangString(
                        path);
                result.add(_otpErlangString);
            }
            final OtpErlangAtom _otpErlangAtom = new OtpErlangAtom(name);
            final OtpErlangList _mkList = OtpErlang.mkList(result);
            final OtpErlangTuple _mkTuple = OtpErlang.mkTuple(_otpErlangAtom,
                    _mkList);
            _xblockexpression = _mkTuple;
        }
        return _xblockexpression;
    }

    public static String toString(final Iterable<String> value) {
        final Joiner _on = Joiner.on(",");
        final String _join = _on.join(value);
        return _join;
    }

    public static Iterable<String> fromString(final String string) {
        final Splitter _on = Splitter.on(",");
        final Splitter _trimResults = _on.trimResults();
        final Splitter _omitEmptyStrings = _trimResults.omitEmptyStrings();
        final Iterable<String> _split = _omitEmptyStrings.split(string);
        return _split;
    }
}
