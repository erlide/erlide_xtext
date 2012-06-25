package org.erlide.project.compiler;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.erlide.common.util.TermParser;

import com.ericsson.otp.erlang.OtpErlang;
import com.ericsson.otp.erlang.OtpErlangAtom;
import com.ericsson.otp.erlang.OtpErlangList;
import com.ericsson.otp.erlang.OtpErlangObject;
import com.ericsson.otp.erlang.OtpErlangTuple;
import com.google.common.base.Strings;

@SuppressWarnings("all")
public class DefineOption extends CompilerOption {
    private final List<String> fieldLabels;

    public DefineOption(final String name, final String[] fieldLabels,
            final String description, final String tooltip) {
        super(name, description, tooltip);
        this.fieldLabels = (List<String>) Conversions.doWrapArray(fieldLabels);
        final int _size = ((List<String>) Conversions.doWrapArray(fieldLabels))
                .size();
        final boolean _equals = _size == 2;
        Assert.isLegal(_equals);
    }

    public String[] getFieldLabels() {
        return (String[]) Conversions.unwrapArray(fieldLabels, String.class);
    }

    public OtpErlangList toTerm(final Collection<Pair<String, String>> values) {
        try {
            final List<OtpErlangObject> defines = CollectionLiterals
                    .<OtpErlangObject> newArrayList();
            for (final Pair<String, String> value : values) {
                {
                    final String key = value.getKey();
                    final String val1 = value.getValue();
                    final OtpErlangAtom _otpErlangAtom = new OtpErlangAtom(name);
                    final OtpErlangAtom tag = _otpErlangAtom;
                    final OtpErlangAtom _otpErlangAtom_1 = new OtpErlangAtom(
                            key);
                    final OtpErlangAtom okey = _otpErlangAtom_1;
                    final boolean _isNullOrEmpty = Strings.isNullOrEmpty(val1);
                    if (_isNullOrEmpty) {
                        final OtpErlangTuple _mkTuple = OtpErlang.mkTuple(tag,
                                okey);
                        defines.add(_mkTuple);
                    } else {
                        final TermParser _parser = TermParser.getParser();
                        final OtpErlangObject ovalue = _parser.parse(val1);
                        final OtpErlangTuple _mkTuple_1 = OtpErlang.mkTuple(
                                tag, okey, ovalue);
                        defines.add(_mkTuple_1);
                    }
                }
            }
            return OtpErlang.mkList(defines);
        } catch (final Exception _e) {
            throw Exceptions.sneakyThrow(_e);
        }
    }
}
