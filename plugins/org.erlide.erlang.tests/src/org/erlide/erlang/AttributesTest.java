package org.erlide.erlang;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.erlide.ErlangInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner2.class)
@InjectWith(ErlangInjectorProvider.class)
public class AttributesTest extends XtextTest {

    @Test
    public void attributes() {
        testParserRule("-define(X). ", "Attribute");
        testParserRule("-define(X, y). ", "Attribute");
        testParserRule("-type X() :: f(). ", "Attribute");
        testParserRule("-spec ff(f()) -> void(). ", "Attribute");
        testParserRule("-opaque c() :: s(). ", "Attribute");
        testParserRule("-mytag({X, y}). ", "Attribute");
        testParserRule("-ifdef(X). ", "IfdefAttribute");
        testParserRule("-ifndef(X). ", "IfdefAttribute");
        testParserRule("-endif. ", "EndifAttribute");
        testParserRule("-else. ", "ElseAttribute");
    }

    @Test
    public void recordField() {
        testParserRule("a", "RecordFieldDef");
        testParserRule("a=3", "RecordFieldDef");
        testParserRule("a::integer()", "RecordFieldDef");
        testParserRule("a=3::integer()", "RecordFieldDef");
    }

    @Test
    public void recordAttributes() {
        testParserRule("-record(x, { }). ", "Attribute");
        testParserRule("-record(?x, { }). ", "Attribute");
        testParserRule("-record(x, { a, b }). ", "Attribute");
        testParserRule("-record(x, { a=3, b }). ", "Attribute");
        testParserRule("-record(x, { a }). ", "Attribute");
        testParserRule("-record(x, { a::integer() }). ", "Attribute");
        testParserRule("-record(x, { a=3::integer()} ). ", "Attribute");
    }
}
