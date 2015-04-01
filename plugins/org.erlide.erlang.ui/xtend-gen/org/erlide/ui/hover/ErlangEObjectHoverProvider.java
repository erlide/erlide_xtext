package org.erlide.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

@SuppressWarnings("all")
public class ErlangEObjectHoverProvider extends DefaultEObjectHoverProvider {
  @Override
  public String getFirstLine(final EObject obj) {
    return super.getFirstLine(obj);
  }
}
