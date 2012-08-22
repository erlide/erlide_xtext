package org.erlide.builder.compiler;

import org.erlide.builder.compiler.IErlangCompiler;
import org.erlide.builder.compiler.IProblemLineParser;

@SuppressWarnings("all")
public abstract class AbstractCompiler implements IErlangCompiler {
  protected IProblemLineParser lineParser;
  
  public void setLineParser(final IProblemLineParser parser) {
    this.lineParser = parser;
  }
}
