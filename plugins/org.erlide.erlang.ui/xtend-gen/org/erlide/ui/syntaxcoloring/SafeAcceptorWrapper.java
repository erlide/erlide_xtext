package org.erlide.ui.syntaxcoloring;

import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;

@SuppressWarnings("all")
public class SafeAcceptorWrapper implements IHighlightedPositionAcceptor {
  private IHighlightedPositionAcceptor wrapped;
  
  public SafeAcceptorWrapper(final IHighlightedPositionAcceptor wrapped) {
    this.wrapped = wrapped;
  }
  
  @Override
  public void addPosition(final int offset, final int length, final String... id) {
    if ((length == 0)) {
      return;
    }
    if ((length < 0)) {
      return;
    }
    this.wrapped.addPosition(offset, length, id);
  }
}
