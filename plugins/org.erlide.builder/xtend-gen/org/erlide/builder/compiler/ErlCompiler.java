package org.erlide.builder.compiler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure4;
import org.erlide.builder.BuilderPlugin;
import org.erlide.builder.compiler.AbstractCompiler;
import org.erlide.builder.compiler.CompilerOptions;

@SuppressWarnings("all")
public class ErlCompiler extends AbstractCompiler {
  public final static String COMPILER_ID = new Function0<String>() {
    public String apply() {
      String _plus = (BuilderPlugin.PLUGIN_ID + ".compiler.erl");
      return _plus;
    }
  }.apply();
  
  public String getId() {
    return ErlCompiler.COMPILER_ID;
  }
  
  public void compileResource(final IFile file, final CompilerOptions options, final Procedure4<? super IFile,? super String,? super Integer,? super Integer> resultsHandler) {
    String _name = file.getName();
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("erlc", _name);
    IContainer _parent = file.getParent();
    IPath _location = _parent.getLocation();
    String _portableString = _location.toPortableString();
    File _file = new File(_portableString);
    this.launchProcess(file, _newArrayList, _file, resultsHandler);
  }
  
  protected void parseLine(final String line, final IFile file, final Procedure4<? super IFile,? super String,? super Integer,? super Integer> callback) {
    final List<String> parts = ((List<String>)Conversions.doWrapArray(line.split(": ")));
    String _head = IterableExtensions.<String>head(parts);
    final List<String> heads = ((List<String>)Conversions.doWrapArray(_head.split(":")));
    int _size = parts.size();
    final boolean warning = (_size == 3);
    String _xifexpression = null;
    if (warning) {
      String _get = parts.get(2);
      _xifexpression = _get;
    } else {
      String _get_1 = parts.get(1);
      _xifexpression = _get_1;
    }
    final String msg = _xifexpression;
    int _xifexpression_1 = (int) 0;
    if (warning) {
      _xifexpression_1 = IMarker.SEVERITY_WARNING;
    } else {
      _xifexpression_1 = IMarker.SEVERITY_ERROR;
    }
    final int severity = _xifexpression_1;
    Iterable<String> _tail = IterableExtensions.<String>tail(heads);
    String _head_1 = IterableExtensions.<String>head(_tail);
    final int nline = Integer.parseInt(_head_1);
    callback.apply(file, msg, Integer.valueOf(nline), Integer.valueOf(severity));
  }
}
