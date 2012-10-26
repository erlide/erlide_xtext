package org.erlide.ui.outline;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.AbstractOutlineNode;

@SuppressWarnings("all")
public class ErlangOutlineNode extends AbstractOutlineNode {
  public ErlangOutlineNode(final IOutlineNode parent, final Image image, final Object text, final boolean isLeaf) {
    super(parent, image, text, isLeaf);
  }
}
