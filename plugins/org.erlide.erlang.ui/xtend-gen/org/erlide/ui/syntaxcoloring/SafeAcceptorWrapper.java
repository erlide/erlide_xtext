package org.erlide.ui.syntaxcoloring;

import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;

@SuppressWarnings("all")
public class SafeAcceptorWrapper implements IHighlightedPositionAcceptor {
  private IHighlightedPositionAcceptor wrapped;
  
  public SafeAcceptorWrapper(final IHighlightedPositionAcceptor wrapped) {
    this.wrapped = wrapped;
  }
  
  public void addPosition(final int offset, final int length, final String... id) {
    boolean _equals = (length == 0);
    if (_equals) {
      return;
    }
    boolean _lessThan = (length < 0);
    if (_lessThan) {
      return;
    }
    this.wrapped.addPosition(offset, length, id);
  }
}
