package org.erlide.ui.labeling;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.erlide.erlang.Attribute;
import org.erlide.erlang.CustomAttribute;
import org.erlide.erlang.DefineAttribute;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Expressions;
import org.erlide.erlang.FunRef;
import org.erlide.erlang.Function;
import org.erlide.erlang.FunctionClause;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.RecordAttribute;
import org.erlide.ui.labeling.ErlideStyler;

/**
 * Provides labels for a EObjects.
 * 
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
@SuppressWarnings("all")
public class ErlangLabelProviderBase extends DefaultEObjectLabelProvider {
  private final Styler grayStyler;
  
  @Inject
  private ModelExtensions _modelExtensions;
  
  @Inject
  public ErlangLabelProviderBase(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
    Display _current = Display.getCurrent();
    Color _systemColor = _current==null?(Color)null:_current.getSystemColor(SWT.COLOR_GRAY);
    Styler _createStyler = ErlangLabelProviderBase.createStyler(null, _systemColor);
    this.grayStyler = _createStyler;
  }
  
  public Object text(final Module module) {
    StyledString _styledString = new StyledString();
    final StyledString s = _styledString;
    s.append("module ", this.grayStyler);
    String _name = this._modelExtensions.getName(module);
    s.append(_name);
    return s;
  }
  
  public Object text(final DefineAttribute attribute) {
    StyledString _styledString = new StyledString();
    final StyledString s = _styledString;
    String _tag = attribute.getTag();
    s.append(_tag, this.grayStyler);
    s.append(" ");
    String _macroName = attribute.getMacroName();
    s.append(_macroName);
    return s;
  }
  
  public Object text(final RecordAttribute attribute) {
    StyledString _styledString = new StyledString();
    final StyledString s = _styledString;
    String _tag = attribute.getTag();
    s.append(_tag, this.grayStyler);
    s.append(" ");
    String _name = attribute.getName();
    s.append(_name);
    return s;
  }
  
  public Object text(final CustomAttribute attribute) {
    StyledString _styledString = new StyledString();
    final StyledString s = _styledString;
    String _tag = attribute.getTag();
    s.append(_tag, this.grayStyler);
    s.append(" ");
    EList<Expression> _value = attribute.getValue();
    String _string = _value.toString();
    s.append(_string);
    return s;
  }
  
  public Object text(final Function function) {
    boolean _or = false;
    EList<FunctionClause> _clauses = function.getClauses();
    boolean _equals = Objects.equal(_clauses, null);
    if (_equals) {
      _or = true;
    } else {
      EList<FunctionClause> _clauses_1 = function.getClauses();
      int _size = _clauses_1.size();
      boolean _equals_1 = (_size == 0);
      _or = (_equals || _equals_1);
    }
    if (_or) {
      return "???";
    }
    StyledString _styledString = new StyledString();
    final StyledString s = _styledString;
    s.append("function", this.grayStyler);
    s.append(" ");
    String _name = function.getName();
    s.append(_name);
    EList<FunctionClause> _clauses_2 = function.getClauses();
    FunctionClause _head = IterableExtensions.<FunctionClause>head(_clauses_2);
    Expressions _params = _head.getParams();
    final EList<Expression> params = _params.getExprs();
    Object _xifexpression = null;
    boolean _equals_2 = Objects.equal(params, null);
    if (_equals_2) {
      _xifexpression = "0";
    } else {
      int _size_1 = params.size();
      _xifexpression = _size_1;
    }
    String _plus = ("/" + ((Comparable<Object>)_xifexpression));
    s.append(_plus);
    return s;
  }
  
  public Object text(final FunctionClause clause) {
    StyledString _styledString = new StyledString();
    final StyledString s = _styledString;
    Expressions _params = clause.getParams();
    final String args = this._modelExtensions.getSourceText(_params);
    EObject _eContainer = clause.eContainer();
    String _name = ((Function) _eContainer).getName();
    s.append(_name, this.grayStyler);
    s.append(" (");
    s.append(args);
    s.append(")");
    return s;
  }
  
  public String text(final Attribute ele) {
    final String tag = ele.getTag();
    String _plus = ("-" + tag);
    return (_plus + " -- ");
  }
  
  public String text(final FunRef c) {
    return this._modelExtensions.getSourceText(c);
  }
  
  public String text(final EObject element) {
    String _sourceText = this._modelExtensions.getSourceText(element);
    String _plus = ("\u00A7 " + _sourceText);
    String _plus_1 = (_plus + " -- ");
    Class<? extends Object> _class = element.getClass();
    String _name = _class.getName();
    return (_plus_1 + _name);
  }
  
  public String getListText(final EList<Expression> list) {
    final Function1<Expression,String> _function = new Function1<Expression,String>() {
        public String apply(final Expression it) {
          String _sourceText = ErlangLabelProviderBase.this._modelExtensions.getSourceText(it);
          return _sourceText;
        }
      };
    List<String> _map = ListExtensions.<Expression, String>map(list, _function);
    return IterableExtensions.join(_map, ", ");
  }
  
  public String image(final FunctionClause clause) {
    return null;
  }
  
  public String image(final EObject element) {
    return "full/obj16/skip.gif";
  }
  
  public String image(final Attribute ele) {
    return "MyModel.gif";
  }
  
  public String image(final Function function) {
    String _xifexpression = null;
    boolean _isExported = this._modelExtensions.isExported(function);
    if (_isExported) {
      _xifexpression = "full/obj16/methpub_obj.gif";
    } else {
      _xifexpression = "full/obj16/methpri_obj.gif";
    }
    return _xifexpression;
  }
  
  private static Styler createStyler(final Font font, final Color color) {
    ErlideStyler _erlideStyler = new ErlideStyler(font, color);
    return _erlideStyler;
  }
}
