package org.erlide.erlang;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.Path;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipselabs.xtext.utils.unittesting.FluentIssueCollection;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.erlide.ErlangInjectorProvider;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@RunWith(XtextRunner2.class)
@InjectWith(ErlangInjectorProvider.class)
@Ignore
public class OtpTest extends XtextTest {
    private static final boolean TESTS = false;
    private final String root;
    private static boolean SIMPLE = true;

    private static Collection<String> apps = Lists.newArrayList("common_test",
            "cosEventDomain", "cosTime", "dialyzer", "erl_interface", "hipe",
            "jinterface", "observer", "otp_mibs", "public_key", "snmp",
            "syntax_tools", "tv", "xmerl", "appmon", "compiler",
            "cosFileTransfer", "cosTransactions", "diameter", "et ", "ic",
            "kernel", "odbc", "parsetools", "reltool", "ssh", "test_server",
            "typer", "asn1", "cosNotification", "crypto", "edoc", "eunit",
            "inets", "megaco", "orber", "percept", "runtime_tools", "ssl",
            "toolbar", "webtool", "cosEvent", "cosProperty", "debugger",
            "erl_docgen", "gs ", "inviso", "mnesia", "os_mon", "pman", "sasl",
            "stdlib", "tools", "wx");
    private static int ok;
    private static int tested;
    private static Map<String, String> results;

    public OtpTest() {
        // super("file://c:/users/vlad/projects/otp/lib/");
        super("file:///proj/uz/erlide/otp_src_R15B/lib");
        root = resourceRoot.substring(7);
    }

    @BeforeClass
    public static void init() {
        ok = 0;
        tested = 0;
        results = Maps.newHashMap();
    }

    @AfterClass
    public static void shutdown() throws FileNotFoundException {
        final PrintStream out = new PrintStream(new File(
                System.getProperty("user.home") + "/OtpTest.txt"));

        out.println("==========================================");
        for (final Entry<String, String> entry : results.entrySet()) {
            out.println("--- " + entry.getKey());
            out.println(entry.getValue());
            out.println();
        }
        out.println(">>>> TOTAL:: " + ok + " / " + tested + "   "
                + (results.entrySet().size() + ok));
    }

    @Before
    public void setup() {
        ignoreFormattingDifferences();
        // ignoreSerializationDifferences();
    }

    private FluentIssueCollection doTest(final String file) {
        if (SIMPLE) {
            return testFileNoSerializer(file);
        } else {
            return testFile(file);
        }
    }

    public void testDir(final String dir) {
        int ok1 = 0;
        final Collection<String> files = findAllFiles(
                new File(root + "/" + dir), TESTS);
        if (files.size() == 0) {
            System.out.println("!!!! --- nothing to do in " + dir);
        }
        for (final String s : files) {
            try {
                before();
                tested++;
                doTest(s);
                ok++;
                ok1++;
            } catch (final AssertionError e) {
                results.put(s, e.getMessage());
            } catch (final Throwable e) {
                System.out.println(e.getMessage());
            }
            after();
        }
        System.out.println(">>>> " + ok1 + " / " + files.size());
    }

    private Collection<String> findAllFiles(final File root, final boolean tests) {
        final java.util.List<String> result = Lists.newArrayList();
        traverse(root, result, tests);
        return result;
    }

    private void processDir(final File dir,
            final java.util.List<String> result, final boolean tests) {
        final String name = dir.getName();
        if (dir.isFile() && (name.endsWith("erl") || name.endsWith("hrl"))) {
            final String path = new Path(dir.getAbsolutePath())
                    .toPortableString();
            if (path.contains("/src/") || path.contains("/include/")
                    || path.contains("/test/")) {
                if (!path.contains("/test/") && !name.contains("_SUITE")
                        || tests) {
                    result.add(path.replaceAll("\\\\", "/").replace(root, ""));
                }
            }
        }
    }

    private void traverse(final File dir, final java.util.List<String> result,
            final boolean tests) {
        processDir(dir, result, tests);

        if (dir.isDirectory()) {
            final String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                traverse(new File(dir, children[i]), result, tests);
            }
        }
    }

    @Test
    public void testStdlib() {
        testDir("stdlib");
    }

    @Test
    public void testKernel() {
        testDir("kernel");
    }

    @Test
    public void testCommonTest() {
        testDir("common_test");
    }

    @Test
    public void testCosEventDomain() {
        testDir("cosEventDomain");
    }

    @Test
    public void testCosTime() {
        testDir("cosTime");
    }

    @Test
    public void testdialyzer() {
        testDir("dialyzer");
    }

    @Test
    public void tester_interface() {
        testDir("erl_interface");
    }

    @Test
    public void testhipe() {
        testDir("hipe");
    }

    @Test
    public void testjinterface() {
        testDir("jinterface");
    }

    @Test
    public void testobserver() {
        testDir("observer");
    }

    @Test
    public void testotp_mibs() {
        testDir("otp_mibs");
    }

    @Test
    public void testpublic_key() {
        testDir("public_key");
    }

    @Test
    public void testsnmp() {
        testDir("snmp");
    }

    @Test
    public void testsyntax_tools() {
        testDir("syntax_tools");
    }

    @Test
    public void testtv() {
        testDir("tv");
    }

    @Test
    public void testxmerl() {
        testDir("xmerl");
    }

    @Test
    public void testappmon() {
        testDir("appmon");
    }

    @Test
    public void testcompiler() {
        testDir("compiler");
    }

    @Test
    public void testcosFileTransfer() {
        testDir("cosFileTransfer");
    }

    @Test
    public void testcosTransactions() {
        testDir("cosTransactions");
    }

    @Test
    public void testdiameter() {
        testDir("diameter");
    }

    @Test
    public void testet() {
        testDir("et");
    }

    @Test
    public void testic() {
        testDir("ic");
    }

    @Test
    public void testodbc() {
        testDir("odbc");
    }

    @Test
    public void testparsetools() {
        testDir("parsetools");
    }

    @Test
    public void testreltool() {
        testDir("reltool");
    }

    @Test
    public void testssh() {
        testDir("ssh");
    }

    @Test
    public void testtest_server() {
        testDir("test_server");
    }

    @Test
    public void testtyper() {
        testDir("typer");
    }

    @Test
    public void testasn1() {
        testDir("asn1");
    }

    @Test
    public void testcosNotification() {
        testDir("cosNotification");
    }

    @Test
    public void testcrypto() {
        testDir("crypto");
    }

    @Test
    public void testedoc() {
        testDir("edoc");
    }

    @Test
    public void testeunit() {
        testDir("eunit");
    }

    @Test
    public void testinets() {
        testDir("inets");
    }

    @Test
    public void testmegaco() {
        testDir("megaco");
    }

    @Test
    public void testorber() {
        testDir("orber");
    }

    @Test
    public void testpercept() {
        testDir("percept");
    }

    @Test
    public void testruntime_tools() {
        testDir("runtime_tools");
    }

    @Test
    public void testssl() {
        testDir("ssl");
    }

    @Test
    public void testtoolbar() {
        testDir("toolbar");
    }

    @Test
    public void testwebtool() {
        testDir("webtool");
    }

    @Test
    public void testcosEvent() {
        testDir("cosEvent");
    }

    @Test
    public void testcosProperty() {
        testDir("cosProperty");
    }

    @Test
    public void testdebugger() {
        testDir("debugger");
    }

    @Test
    public void testerl_docgen() {
        testDir("erl_docgen");
    }

    @Test
    public void testgs() {
        testDir("gs");
    }

    @Test
    public void testinviso() {
        testDir("inviso");
    }

    @Test
    public void testmnesia() {
        testDir("mnesia");
    }

    @Test
    public void testos_mon() {
        testDir("os_mon");
    }

    @Test
    public void testpman() {
        testDir("pman");
    }

    @Test
    public void testsasl() {
        testDir("sasl");
    }

    @Test
    public void testtools() {
        testDir("tools");
    }

    @Test
    public void testwx() {
        testDir("wx");
    }

}
