package org.erlide.project.model.impl;

import org.eclipse.core.runtime.Path;
import org.erlide.project.model.ErlangModelException;
import org.junit.Test;

@SuppressWarnings("all")
public class OtpProjectFragmentTests {
    @Test
    public void createOtpFragment() {
        final OtpProjectFragment _otpProjectFragment = new OtpProjectFragment(
                null, "myFrag");
        final OtpProjectFragment fragment = _otpProjectFragment;
        final Path _path = new Path("");
        final CodeFolder _codeFolder = new CodeFolder(_path);
        final CodeFolder folder = _codeFolder;
        fragment.addSourceFolder(folder);
    }

    @Test(expected = ErlangModelException.class)
    public void createBadOtpFragment() {
        final OtpProjectFragment _otpProjectFragment = new OtpProjectFragment(
                null, "myFrag");
        final OtpProjectFragment fragment = _otpProjectFragment;
        final Path _path = new Path("");
        final CodeFolder _codeFolder = new CodeFolder(_path);
        final CodeFolder folder = _codeFolder;
        fragment.addSourceFolder(folder);
        fragment.addSourceFolder(folder);
    }

    @Test
    public void realizeOtpFragment() {
        final OtpProjectFragment _otpProjectFragment = new OtpProjectFragment(
                null, "myFrag");
        final OtpProjectFragment fragment = _otpProjectFragment;
        final Path _path = new Path("");
        final CodeFolder _codeFolder = new CodeFolder(_path);
        final CodeFolder folder = _codeFolder;
        fragment.addSourceFolder(folder);
    }
}
