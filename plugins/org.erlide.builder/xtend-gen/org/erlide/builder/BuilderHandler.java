package org.erlide.builder;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.erlide.builder.ILineParser;

@Data
@SuppressWarnings("all")
public class BuilderHandler<T extends Object> {
  private final ILineParser<T> _lineParser;
  
  public ILineParser<T> getLineParser() {
    return this._lineParser;
  }
  
  private final Procedure1<? super T> _callback;
  
  public Procedure1<? super T> getCallback() {
    return this._callback;
  }
  
  public void eval(final String line) {
    ILineParser<T> _lineParser = this.getLineParser();
    final T item = _lineParser.parseLine(line);
    boolean _notEquals = (!Objects.equal(item, null));
    if (_notEquals) {
      Procedure1<? super T> _callback = this.getCallback();
      _callback.apply(item);
    }
  }
  
  public BuilderHandler(final ILineParser<T> lineParser, final Procedure1<? super T> callback) {
    super();
    this._lineParser = lineParser;
    this._callback = callback;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_lineParser== null) ? 0 : _lineParser.hashCode());
    result = prime * result + ((_callback== null) ? 0 : _callback.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    BuilderHandler other = (BuilderHandler) obj;
    if (_lineParser == null) {
      if (other._lineParser != null)
        return false;
    } else if (!_lineParser.equals(other._lineParser))
      return false;
    if (_callback == null) {
      if (other._callback != null)
        return false;
    } else if (!_callback.equals(other._callback))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
