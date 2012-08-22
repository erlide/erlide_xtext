package org.erlide.builder.compiler;

import java.util.ArrayList;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.BuilderPlugin;
import org.erlide.builder.compiler.AbstractExternalProcessCompiler;
import org.erlide.builder.compiler.CompilerOptions;
import org.erlide.builder.compiler.CompilerProblem;

@SuppressWarnings("all")
public class MakeCompiler extends AbstractExternalProcessCompiler {
  public final static String COMPILER_ID = new Function0<String>() {
    public String apply() {
      String _plus = (BuilderPlugin.PLUGIN_ID + ".compiler.make");
      return _plus;
    }
  }.apply();
  
  public String getId() {
    return MakeCompiler.COMPILER_ID;
  }
  
  public void compileResource(final IFile file, final CompilerOptions options, final Procedure1<? super CompilerProblem> resultsHandler) {
    String _name = file.getName();
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("make", _name);
    IContainer _parent = file.getParent();
    IPath _location = _parent.getLocation();
    String _portableString = _location.toPortableString();
    this.launchProcess(file, _newArrayList, _portableString, resultsHandler);
  }
}
