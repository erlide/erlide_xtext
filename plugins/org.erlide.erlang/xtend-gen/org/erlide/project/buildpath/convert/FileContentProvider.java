package org.erlide.project.buildpath.convert;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.File;
import java.util.Collection;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.erlide.project.buildpath.convert.AbstractContentProvider;

@SuppressWarnings("all")
public class FileContentProvider extends AbstractContentProvider {
  @Override
  public Collection<String> get(final IPath path) {
    try {
      String _oSString = path.toOSString();
      File _file = new File(_oSString);
      return Files.readLines(_file, Charsets.UTF_8);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
