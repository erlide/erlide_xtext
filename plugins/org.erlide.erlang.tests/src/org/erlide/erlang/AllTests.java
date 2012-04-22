package org.erlide.erlang;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TerminalsTest.class, RulesTest.class, // FilesTest.class,
		ParserTest.class, AttributesTest.class })
public class AllTests {

}
