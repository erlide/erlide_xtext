package org.erlide;

import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class Dummy {
  private long time;
  
  public Dummy() {
    long _currentTimeMillis = System.currentTimeMillis();
    this.time = _currentTimeMillis;
    long _shiftRight = (this.time >> 2);
    String _plus = (">>>" + Long.valueOf(_shiftRight));
    InputOutput.<String>println(_plus);
  }
}
