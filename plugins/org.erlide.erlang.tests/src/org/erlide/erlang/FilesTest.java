package org.erlide.erlang;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.erlide.ErlangInjectorProvider;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@Ignore
@RunWith(XtextRunner2.class)
@InjectWith(ErlangInjectorProvider.class)
public class FilesTest extends XtextTest {

	@Before
	public void setup() {
		ignoreFormattingDifferences();
		// ignoreSerializationDifferences();
	}

	@Test
	public void test1() {
		testFile("test1.erl");
	}

	@Test
	public void test2() {
		testFile("test2.erl");
	}

	@Test
	public void test3() {
		testFile("test3.erl");
	}

	@Test
	public void testDocs() {
		// testFile("test_docs.erl");
	}

	@Test
	public void erlide_scan() {
		testFileNoSerializer("reference/erlide_scan.erl");
	}
}
