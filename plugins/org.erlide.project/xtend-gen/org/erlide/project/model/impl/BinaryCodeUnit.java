package org.erlide.project.model.impl;

import org.erlide.project.model.IBinaryCodeUnit;
import org.erlide.project.model.ICodeFolder;
import org.erlide.project.model.impl.CodeUnit;

@SuppressWarnings("all")
public class BinaryCodeUnit extends CodeUnit implements IBinaryCodeUnit {
  public BinaryCodeUnit(final ICodeFolder folder, final String name) {
    super(folder, name);
  }
}
