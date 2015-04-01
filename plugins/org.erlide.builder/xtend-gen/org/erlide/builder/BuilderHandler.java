package org.erlide.builder;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.erlide.builder.ILineParser;

@Data
@SuppressWarnings("all")
public class BuilderHandler<T extends Object> {
  private final ILineParser<T> lineParser;
  
  private final Procedure1<? super T> callback;
  
  public void eval(final String line) {
    final T item = this.lineParser.parseLine(line);
    boolean _notEquals = (!Objects.equal(item, null));
    if (_notEquals) {
      this.callback.apply(item);
    }
  }
  
  public BuilderHandler(final ILineParser<T> lineParser, final Procedure1<? super T> callback) {
    super();
    this.lineParser = lineParser;
    this.callback = callback;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.lineParser== null) ? 0 : this.lineParser.hashCode());
    result = prime * result + ((this.callback== null) ? 0 : this.callback.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    BuilderHandler<?> other = (BuilderHandler<?>) obj;
    if (this.lineParser == null) {
      if (other.lineParser != null)
        return false;
    } else if (!this.lineParser.equals(other.lineParser))
      return false;
    if (this.callback == null) {
      if (other.callback != null)
        return false;
    } else if (!this.callback.equals(other.callback))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("lineParser", this.lineParser);
    b.add("callback", this.callback);
    return b.toString();
  }
  
  @Pure
  public ILineParser<T> getLineParser() {
    return this.lineParser;
  }
  
  @Pure
  public Procedure1<? super T> getCallback() {
    return this.callback;
  }
}
