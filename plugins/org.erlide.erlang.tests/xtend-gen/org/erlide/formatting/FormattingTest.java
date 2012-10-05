package org.erlide.formatting;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.SaveOptions.Builder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Pair;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.ErlangTestSetup;
import org.erlide.erlang.Module;
import org.erlide.erlang.util.ErlangTestingHelper;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = ErlangInjectorProvider.class)
@SuppressWarnings("all")
public class FormattingTest extends AbstractXtextTests {
  @Inject
  private ErlangTestingHelper parser;
  
  public String dumpCode(final String code) {
    try {
      String _xblockexpression = null;
      {
        final XtextResource r = this.getResourceFromString(code);
        IParseResult _parseResult = r.getParseResult();
        ICompositeNode _rootNode = _parseResult.getRootNode();
        String _compactDump = NodeModelUtils.compactDump(_rootNode, false);
        String _println = InputOutput.<String>println(_compactDump);
        _xblockexpression = (_println);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String serializeFormatted(final EObject obj) {
    ISerializer _serializer = this.getSerializer();
    Builder _newBuilder = SaveOptions.newBuilder();
    Builder _format = _newBuilder.format();
    SaveOptions _options = _format.getOptions();
    return _serializer.serialize(obj, _options);
  }
  
  @Test
  public void test() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-module (x) .");
    final String code = _builder.toString();
    final Pair<Module,List<Integer>> module = this.parser.parse(code);
    Module _key = module.getKey();
    final String actual = this.serializeFormatted(_key);
    Matcher<? super String> _is = Matchers.<String>is(code);
    MatcherAssert.<String>assertThat(actual, _is);
  }
  
  @Before
  public void setUp() throws Exception {
    super.setUp();
    this.with(ErlangTestSetup.class);
  }
}
