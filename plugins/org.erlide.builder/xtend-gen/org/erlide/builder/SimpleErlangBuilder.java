package org.erlide.builder;

import java.io.File;
import java.util.ArrayList;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure4;
import org.erlide.builder.ErlParser;
import org.erlide.common.process.ProcessLauncher;

@SuppressWarnings("all")
public class SimpleErlangBuilder {
  public static void compileResource(final IFile file, final Procedure4<? super IFile,? super String,? super Integer,? super Integer> callback) {
    String _name = file.getName();
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("erlc", _name);
    IContainer _parent = file.getParent();
    IPath _location = _parent.getLocation();
    String _portableString = _location.toPortableString();
    File _file = new File(_portableString);
    ErlParser _erlParser = new ErlParser(file, callback);
    ProcessLauncher.launchProcess(file, _newArrayList, _file, _erlParser);
  }
}
