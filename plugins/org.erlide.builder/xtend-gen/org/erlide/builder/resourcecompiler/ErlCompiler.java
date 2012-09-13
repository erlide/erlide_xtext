package org.erlide.builder.resourcecompiler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.BuilderExecutor;
import org.erlide.builder.BuilderPlugin;
import org.erlide.builder.CompilerOptions;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.DefaultLineParser;
import org.erlide.builder.resourcecompiler.AbstractExternalProcessCompiler;

@SuppressWarnings("all")
public class ErlCompiler extends AbstractExternalProcessCompiler {
  public final static String COMPILER_ID = new Function0<String>() {
    public String apply() {
      String _plus = (BuilderPlugin.PLUGIN_ID + ".compiler.erl");
      return _plus;
    }
  }.apply();
  
  public String getId() {
    return ErlCompiler.COMPILER_ID;
  }
  
  public Collection<CompilerProblem> compileResource(final IFile file, final CompilerOptions options) {
    final List<CompilerProblem> result = CollectionLiterals.<CompilerProblem>newArrayList();
    BuilderExecutor _executor = this.getExecutor();
    String _name = file.getName();
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("erlc", _name);
    IContainer _parent = file.getParent();
    IPath _location = _parent.getLocation();
    String _portableString = _location.toPortableString();
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    DefaultLineParser _defaultLineParser = new DefaultLineParser();
    final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
        public void apply(final CompilerProblem problem) {
          result.add(problem);
        }
      };
    _executor.<CompilerProblem>executeProcess(_newArrayList, _portableString, _nullProgressMonitor, _defaultLineParser, _function);
    return result;
  }
}
