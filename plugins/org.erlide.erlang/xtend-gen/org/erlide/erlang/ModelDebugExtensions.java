package org.erlide.erlang;

import com.google.common.base.Objects;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class ModelDebugExtensions {
  public String debugPrint(final EObject m) {
    try {
      EObject _copy = EcoreUtil.<EObject>copy(m);
      return this.serialize(_copy);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String serialize(final EObject root) throws IOException {
    boolean _equals = Objects.equal(root, null);
    if (_equals) {
      throw new NullPointerException("ModelUtils.NullSaveRoot");
    }
    final XMIResource newResource = new XMIResourceImpl();
    final StringWriter writer = new StringWriter();
    EList<EObject> _contents = newResource.getContents();
    _contents.add(root);
    newResource.save(writer, Collections.EMPTY_MAP);
    return writer.toString();
  }
}
