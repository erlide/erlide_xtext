package org.erlide.erlang;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.erlide.erlang.Atom;
import org.erlide.erlang.CompileAttribute;
import org.erlide.erlang.ConditionalAttribute;
import org.erlide.erlang.ConditionalFormBlock;
import org.erlide.erlang.CustomAttribute;
import org.erlide.erlang.ErlList;
import org.erlide.erlang.ErlTuple;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.ExportAttribute;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Expressions;
import org.erlide.erlang.Form;
import org.erlide.erlang.FunRef;
import org.erlide.erlang.FunType;
import org.erlide.erlang.Function;
import org.erlide.erlang.FunctionClause;
import org.erlide.erlang.ImportAttribute;
import org.erlide.erlang.IncludeAttribute;
import org.erlide.erlang.IncludeLibAttribute;
import org.erlide.erlang.Macro;
import org.erlide.erlang.Module;
import org.erlide.erlang.ModuleAttribute;
import org.erlide.erlang.SpecAttribute;
import org.erlide.erlang.TopType;
import org.erlide.erlang.TypeSig;

@SuppressWarnings("all")
public class ModelExtensions {
  @Inject
  private IQualifiedNameProvider namer;
  
  public Module findModule(final IResourceDescriptions index, final String name, final ResourceSet rset) {
    Module _xblockexpression = null;
    {
      final QualifiedName qname = QualifiedName.create(name);
      final Iterable<IEObjectDescription> descr = index.getExportedObjects(ErlangPackage.Literals.MODULE, qname, false);
      boolean _isEmpty = IterableExtensions.isEmpty(descr);
      if (_isEmpty) {
        return null;
      }
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(descr);
      URI _eObjectURI = _head.getEObjectURI();
      EObject _eObject = rset.getEObject(_eObjectURI, false);
      _xblockexpression = ((Module) _eObject);
    }
    return _xblockexpression;
  }
  
  public String getName(final Module module) {
    String _xblockexpression = null;
    {
      EList<Form> _forms = module.getForms();
      final Form attr = IterableExtensions.<Form>head(_forms);
      String _xifexpression = null;
      if ((attr instanceof ModuleAttribute)) {
        String _moduleName = ((ModuleAttribute) attr).getModuleName();
        _xifexpression = _moduleName.replaceAll("\\.", "_");
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public boolean isHeader(final Module module) {
    String _name = this.getName(module);
    return Objects.equal(_name, null);
  }
  
  public Collection<CustomAttribute> getCustomAttributesWithTag(final Module module, final String mytag) {
    EList<EObject> _eContents = module.eContents();
    Iterable<CustomAttribute> _filter = Iterables.<CustomAttribute>filter(_eContents, CustomAttribute.class);
    final Function1<CustomAttribute, Boolean> _function = new Function1<CustomAttribute, Boolean>() {
      @Override
      public Boolean apply(final CustomAttribute it) {
        String _tag = it.getTag();
        return Boolean.valueOf(Objects.equal(_tag, mytag));
      }
    };
    Iterable<CustomAttribute> _filter_1 = IterableExtensions.<CustomAttribute>filter(_filter, _function);
    return IterableExtensions.<CustomAttribute>toList(_filter_1);
  }
  
  public Collection<ExportAttribute> getExportAttributes(final Module module) {
    return this.<ExportAttribute>getAllItemsOfType(module, ExportAttribute.class);
  }
  
  public Collection<ImportAttribute> getImportAttributes(final Module module) {
    return this.<ImportAttribute>getAllItemsOfType(module, ImportAttribute.class);
  }
  
  public Collection<SpecAttribute> getSpecs(final Module module) {
    return this.<SpecAttribute>getAllItemsOfType(module, SpecAttribute.class);
  }
  
  public Collection<String> getIncludes(final Module module) {
    Collection<IncludeAttribute> _allItemsOfType = this.<IncludeAttribute>getAllItemsOfType(module, IncludeAttribute.class);
    final Function1<IncludeAttribute, String> _function = new Function1<IncludeAttribute, String>() {
      @Override
      public String apply(final IncludeAttribute it) {
        return it.getImportURI();
      }
    };
    Iterable<String> _map = IterableExtensions.<IncludeAttribute, String>map(_allItemsOfType, _function);
    return IterableExtensions.<String>toList(_map);
  }
  
  public Collection<String> getIncludeLibs(final Module module) {
    Collection<IncludeLibAttribute> _allItemsOfType = this.<IncludeLibAttribute>getAllItemsOfType(module, IncludeLibAttribute.class);
    final Function1<IncludeLibAttribute, String> _function = new Function1<IncludeLibAttribute, String>() {
      @Override
      public String apply(final IncludeLibAttribute it) {
        return it.getImportURI();
      }
    };
    Iterable<String> _map = IterableExtensions.<IncludeLibAttribute, String>map(_allItemsOfType, _function);
    return IterableExtensions.<String>toList(_map);
  }
  
  public boolean exportsFunction(final Module module, final Function function) {
    boolean _or = false;
    Collection<String> _declaredExportNames = this.getDeclaredExportNames(module);
    String _funRef = this.funRef(function);
    boolean _contains = _declaredExportNames.contains(_funRef);
    if (_contains) {
      _or = true;
    } else {
      boolean _exportsAll = this.exportsAll(module);
      _or = _exportsAll;
    }
    return _or;
  }
  
  public Collection<Function> getDeclaredExports(final Module module) {
    List<Function> _xblockexpression = null;
    {
      final Collection<ExportAttribute> exported = this.getExportAttributes(module);
      final Function1<ExportAttribute, EList<FunRef>> _function = new Function1<ExportAttribute, EList<FunRef>>() {
        @Override
        public EList<FunRef> apply(final ExportAttribute it) {
          return it.getFuns();
        }
      };
      Iterable<EList<FunRef>> _map = IterableExtensions.<ExportAttribute, EList<FunRef>>map(exported, _function);
      final Iterable<FunRef> refs = Iterables.<FunRef>concat(_map);
      final Function1<FunRef, Function> _function_1 = new Function1<FunRef, Function>() {
        @Override
        public Function apply(final FunRef it) {
          return ModelExtensions.this.getFunction(module, it);
        }
      };
      Iterable<Function> _map_1 = IterableExtensions.<FunRef, Function>map(refs, _function_1);
      _xblockexpression = IterableExtensions.<Function>toList(_map_1);
    }
    return _xblockexpression;
  }
  
  public Collection<String> getDeclaredExportNames(final Module module) {
    List<String> _xblockexpression = null;
    {
      final Collection<ExportAttribute> exported = this.getExportAttributes(module);
      final Function1<ExportAttribute, EList<FunRef>> _function = new Function1<ExportAttribute, EList<FunRef>>() {
        @Override
        public EList<FunRef> apply(final ExportAttribute it) {
          return it.getFuns();
        }
      };
      Iterable<EList<FunRef>> _map = IterableExtensions.<ExportAttribute, EList<FunRef>>map(exported, _function);
      final Iterable<FunRef> refs = Iterables.<FunRef>concat(_map);
      final Function1<FunRef, String> _function_1 = new Function1<FunRef, String>() {
        @Override
        public String apply(final FunRef it) {
          ICompositeNode _findActualNodeFor = NodeModelUtils.findActualNodeFor(it);
          return NodeModelUtils.getTokenText(_findActualNodeFor);
        }
      };
      Iterable<String> _map_1 = IterableExtensions.<FunRef, String>map(refs, _function_1);
      _xblockexpression = IterableExtensions.<String>toList(_map_1);
    }
    return _xblockexpression;
  }
  
  public Collection<EObject> getAllContents(final EObject element) {
    List<EObject> _xblockexpression = null;
    {
      final EList<EObject> result = element.eContents();
      final Function1<EObject, Collection<EObject>> _function = new Function1<EObject, Collection<EObject>>() {
        @Override
        public Collection<EObject> apply(final EObject it) {
          Collection<EObject> _switchResult = null;
          boolean _matched = false;
          if (!_matched) {
            if (it instanceof ConditionalFormBlock) {
              _matched=true;
              _switchResult = ModelExtensions.this.getAllContents(it);
            }
          }
          if (!_matched) {
            if (it instanceof ConditionalAttribute) {
              _matched=true;
              _switchResult = CollectionLiterals.<EObject>newArrayList();
            }
          }
          if (!_matched) {
            _switchResult = CollectionLiterals.<EObject>newArrayList(it);
          }
          return _switchResult;
        }
      };
      List<Collection<EObject>> _map = ListExtensions.<EObject, Collection<EObject>>map(result, _function);
      Iterable<EObject> _flatten = Iterables.<EObject>concat(_map);
      _xblockexpression = IterableExtensions.<EObject>toList(_flatten);
    }
    return _xblockexpression;
  }
  
  public Function getFunction(final Module module, final String fname, final int farity) {
    Collection<EObject> _allContents = this.getAllContents(module);
    Iterable<Function> _filter = Iterables.<Function>filter(_allContents, Function.class);
    final Function1<Function, Boolean> _function = new Function1<Function, Boolean>() {
      @Override
      public Boolean apply(final Function it) {
        boolean _and = false;
        String _name = it.getName();
        boolean _equals = Objects.equal(_name, fname);
        if (!_equals) {
          _and = false;
        } else {
          int _arity = ModelExtensions.this.getArity(it);
          boolean _equals_1 = (_arity == farity);
          _and = _equals_1;
        }
        return Boolean.valueOf(_and);
      }
    };
    return IterableExtensions.<Function>findFirst(_filter, _function);
  }
  
  public Function getFunction(final Module module, final FunRef ref) {
    Collection<EObject> _allContents = this.getAllContents(module);
    Iterable<Function> _filter = Iterables.<Function>filter(_allContents, Function.class);
    final Function1<Function, Boolean> _function = new Function1<Function, Boolean>() {
      @Override
      public Boolean apply(final Function it) {
        boolean _and = false;
        String _name = it.getName();
        Expression _function = ref.getFunction();
        String _sourceText = ModelExtensions.this.getSourceText(_function);
        boolean _equals = Objects.equal(_name, _sourceText);
        if (!_equals) {
          _and = false;
        } else {
          int _arity = ModelExtensions.this.getArity(it);
          Expression _arity_1 = ref.getArity();
          String _sourceText_1 = ModelExtensions.this.getSourceText(_arity_1);
          int _parseInt = Integer.parseInt(_sourceText_1);
          boolean _equals_1 = (_arity == _parseInt);
          _and = _equals_1;
        }
        return Boolean.valueOf(_and);
      }
    };
    return IterableExtensions.<Function>findFirst(_filter, _function);
  }
  
  public boolean exportsAll(final Module module) {
    Collection<Expression> _compileOptions = this.getCompileOptions(module);
    final Function1<Expression, Boolean> _function = new Function1<Expression, Boolean>() {
      @Override
      public Boolean apply(final Expression it) {
        return Boolean.valueOf(ModelExtensions.this.hasAtom(it, "export_all"));
      }
    };
    return IterableExtensions.<Expression>exists(_compileOptions, _function);
  }
  
  public Collection<Atom> getParseTransforms(final Module module) {
    List<Atom> _xblockexpression = null;
    {
      final Collection<Expression> options = this.getCompileOptions(module);
      final Iterable<ErlTuple> tuples = Iterables.<ErlTuple>filter(options, ErlTuple.class);
      final Function1<ErlTuple, Boolean> _function = new Function1<ErlTuple, Boolean>() {
        @Override
        public Boolean apply(final ErlTuple it) {
          return Boolean.valueOf(ModelExtensions.this.isParseTransformTuple(it));
        }
      };
      Iterable<ErlTuple> _filter = IterableExtensions.<ErlTuple>filter(tuples, _function);
      final Function1<ErlTuple, Atom> _function_1 = new Function1<ErlTuple, Atom>() {
        @Override
        public Atom apply(final ErlTuple it) {
          EList<Expression> _elements = it.getElements();
          Iterable<Expression> _tail = IterableExtensions.<Expression>tail(_elements);
          Expression _head = IterableExtensions.<Expression>head(_tail);
          return ((Atom) _head);
        }
      };
      Iterable<Atom> _map = IterableExtensions.<ErlTuple, Atom>map(_filter, _function_1);
      _xblockexpression = IterableExtensions.<Atom>toList(_map);
    }
    return _xblockexpression;
  }
  
  public SpecAttribute getSpec(final Module module, final String fname, final int farity) {
    SpecAttribute _xblockexpression = null;
    {
      final Collection<SpecAttribute> specs = this.getSpecs(module);
      final Function1<SpecAttribute, Boolean> _function = new Function1<SpecAttribute, Boolean>() {
        @Override
        public Boolean apply(final SpecAttribute it) {
          boolean _and = false;
          FunRef _ref = it.getRef();
          Expression _function = _ref.getFunction();
          String _sourceText = ModelExtensions.this.getSourceText(_function);
          boolean _equals = Objects.equal(_sourceText, fname);
          if (!_equals) {
            _and = false;
          } else {
            int _specArity = ModelExtensions.this.getSpecArity(it);
            boolean _equals_1 = (_specArity == farity);
            _and = _equals_1;
          }
          return Boolean.valueOf(_and);
        }
      };
      _xblockexpression = IterableExtensions.<SpecAttribute>findFirst(specs, _function);
    }
    return _xblockexpression;
  }
  
  public int getArity(final Function fun) {
    EList<FunctionClause> _clauses = fun.getClauses();
    FunctionClause _head = IterableExtensions.<FunctionClause>head(_clauses);
    Expressions _params = null;
    if (_head!=null) {
      _params=_head.getParams();
    }
    EList<Expression> _exprs = null;
    if (_params!=null) {
      _exprs=_params.getExprs();
    }
    int _size = 0;
    if (_exprs!=null) {
      _size=_exprs.size();
    }
    return _size;
  }
  
  public boolean isExported(final Function function) {
    Resource _eResource = function.eResource();
    final OnChangeEvictingCache.CacheAdapter cache = this.moduleCache.getOrCreate(_eResource);
    Boolean value = cache.<Boolean>get(function);
    boolean _equals = Objects.equal(value, null);
    if (_equals) {
      Module _owningModule = this.getOwningModule(function);
      boolean _exportsFunction = this.exportsFunction(_owningModule, function);
      value = Boolean.valueOf(_exportsFunction);
      cache.set(function, value);
    }
    return (value).booleanValue();
  }
  
  public SpecAttribute getSpec(final Function function) {
    SpecAttribute _xblockexpression = null;
    {
      final Module module = this.getOwningModule(function);
      final Collection<SpecAttribute> specs = this.getSpecs(module);
      final Function1<SpecAttribute, Boolean> _function = new Function1<SpecAttribute, Boolean>() {
        @Override
        public Boolean apply(final SpecAttribute it) {
          boolean _and = false;
          FunRef _ref = it.getRef();
          Expression _function = _ref.getFunction();
          String _sourceText = ModelExtensions.this.getSourceText(_function);
          String _name = function.getName();
          boolean _equals = Objects.equal(_sourceText, _name);
          if (!_equals) {
            _and = false;
          } else {
            int _specArity = ModelExtensions.this.getSpecArity(it);
            int _arity = ModelExtensions.this.getArity(function);
            boolean _equals_1 = (_specArity == _arity);
            _and = _equals_1;
          }
          return Boolean.valueOf(_and);
        }
      };
      _xblockexpression = IterableExtensions.<SpecAttribute>findFirst(specs, _function);
    }
    return _xblockexpression;
  }
  
  private OnChangeEvictingCache moduleCache = new OnChangeEvictingCache();
  
  public Module getOwningModule(final EObject element) {
    return this.findOwningModule(element);
  }
  
  protected Module _findOwningModule(final Module element) {
    return element;
  }
  
  protected Module _findOwningModule(final EObject element) {
    EObject _eContainer = element.eContainer();
    return this.getOwningModule(_eContainer);
  }
  
  public String getSourceText(final EObject obj) {
    final ICompositeNode node = NodeModelUtils.getNode(obj);
    boolean _equals = Objects.equal(node, null);
    if (_equals) {
      return null;
    }
    Iterable<ILeafNode> _leafNodes = node.getLeafNodes();
    final Function1<ILeafNode, Boolean> _function = new Function1<ILeafNode, Boolean>() {
      @Override
      public Boolean apply(final ILeafNode it) {
        boolean _isHidden = it.isHidden();
        return Boolean.valueOf((!_isHidden));
      }
    };
    Iterable<ILeafNode> _filter = IterableExtensions.<ILeafNode>filter(_leafNodes, _function);
    final Function1<ILeafNode, String> _function_1 = new Function1<ILeafNode, String>() {
      @Override
      public String apply(final ILeafNode it) {
        return it.getText();
      }
    };
    final Iterable<String> texts = IterableExtensions.<ILeafNode, String>map(_filter, _function_1);
    int _size = IterableExtensions.size(texts);
    boolean _equals_1 = (_size == 1);
    if (_equals_1) {
      return IterableExtensions.<String>head(texts);
    } else {
      return IterableExtensions.join(texts, " ");
    }
  }
  
  public int getSpecArity(final SpecAttribute spec) {
    int _xifexpression = (int) 0;
    FunRef _ref = spec.getRef();
    Expression _arity = _ref.getArity();
    boolean _notEquals = (!Objects.equal(_arity, null));
    if (_notEquals) {
      FunRef _ref_1 = spec.getRef();
      Expression _arity_1 = _ref_1.getArity();
      String _sourceText = this.getSourceText(_arity_1);
      _xifexpression = Integer.parseInt(_sourceText);
    } else {
      EList<TypeSig> _signatures = spec.getSignatures();
      TypeSig _head = IterableExtensions.<TypeSig>head(_signatures);
      FunType _decl = _head.getDecl();
      EList<TopType> _args = _decl.getArgs();
      _xifexpression = _args.size();
    }
    return _xifexpression;
  }
  
  public static <T extends Object> Collection<T> getItemsOfType(final EObject obj, final Class<T> type) {
    EList<EObject> _eContents = obj.eContents();
    Iterable<T> _filter = Iterables.<T>filter(_eContents, type);
    return IterableExtensions.<T>toList(_filter);
  }
  
  public <T extends Object> Collection<T> getAllItemsOfType(final EObject obj, final Class<T> type) {
    List<T> _xblockexpression = null;
    {
      Collection<T> _itemsOfType = ModelExtensions.<T>getItemsOfType(obj, type);
      final List<T> direct = IterableExtensions.<T>toList(_itemsOfType);
      final Collection<ConditionalFormBlock> ifblocks = ModelExtensions.<ConditionalFormBlock>getItemsOfType(obj, ConditionalFormBlock.class);
      final Function1<ConditionalFormBlock, Collection<T>> _function = new Function1<ConditionalFormBlock, Collection<T>>() {
        @Override
        public Collection<T> apply(final ConditionalFormBlock it) {
          return ModelExtensions.this.<T>getAllItemsOfType(it, type);
        }
      };
      Iterable<Collection<T>> _map = IterableExtensions.<ConditionalFormBlock, Collection<T>>map(ifblocks, _function);
      Iterable<T> _flatten = Iterables.<T>concat(_map);
      List<T> _list = IterableExtensions.<T>toList(_flatten);
      direct.addAll(_list);
      _xblockexpression = direct;
    }
    return _xblockexpression;
  }
  
  public Collection<Expression> getRawCompileOptions(final Module module) {
    Collection<CompileAttribute> _allItemsOfType = this.<CompileAttribute>getAllItemsOfType(module, CompileAttribute.class);
    final Function1<CompileAttribute, Expression> _function = new Function1<CompileAttribute, Expression>() {
      @Override
      public Expression apply(final CompileAttribute it) {
        return it.getOptions();
      }
    };
    Iterable<Expression> _map = IterableExtensions.<CompileAttribute, Expression>map(_allItemsOfType, _function);
    return IterableExtensions.<Expression>toList(_map);
  }
  
  private Set<Expression> _merge(final Set<Expression> acc, final ErlList x) {
    Set<Expression> _xblockexpression = null;
    {
      EList<Expression> _elements = x.getElements();
      acc.addAll(_elements);
      _xblockexpression = acc;
    }
    return _xblockexpression;
  }
  
  private Set<Expression> _merge(final Set<Expression> acc, final Expression x) {
    Set<Expression> _xblockexpression = null;
    {
      acc.add(x);
      _xblockexpression = acc;
    }
    return _xblockexpression;
  }
  
  public Collection<Expression> getCompileOptions(final Module module) {
    return this.getRawCompileOptions(module);
  }
  
  private boolean _hasAtom(final Atom atom, final String s) {
    String _sourceText = this.getSourceText(atom);
    return Objects.equal(_sourceText, s);
  }
  
  private boolean _hasAtom(final ErlList list, final String s) {
    EList<Expression> _elements = list.getElements();
    final Function1<Expression, Boolean> _function = new Function1<Expression, Boolean>() {
      @Override
      public Boolean apply(final Expression it) {
        return Boolean.valueOf(ModelExtensions.this.hasAtom(it, s));
      }
    };
    return IterableExtensions.<Expression>exists(_elements, _function);
  }
  
  private boolean _hasAtom(final Expression expr, final String s) {
    return false;
  }
  
  private boolean isParseTransformTuple(final ErlTuple expr) {
    boolean _or = false;
    EList<Expression> _elements = expr.getElements();
    int _size = _elements.size();
    boolean _notEquals = (_size != 2);
    if (_notEquals) {
      _or = true;
    } else {
      _or = (!(IterableExtensions.<Expression>head(expr.getElements()) instanceof Atom));
    }
    if (_or) {
      return false;
    }
    EList<Expression> _elements_1 = expr.getElements();
    Expression _head = IterableExtensions.<Expression>head(_elements_1);
    final Atom hd = ((Atom) _head);
    boolean _and = false;
    String _sourceText = this.getSourceText(hd);
    boolean _equals = Objects.equal(_sourceText, "parse_transform");
    if (!_equals) {
      _and = false;
    } else {
      EList<Expression> _elements_2 = expr.getElements();
      Iterable<Expression> _tail = IterableExtensions.<Expression>tail(_elements_2);
      Expression _head_1 = IterableExtensions.<Expression>head(_tail);
      _and = (_head_1 instanceof Atom);
    }
    return _and;
  }
  
  public EObject getObjectAtOffset(final EObject src, final int offset) {
    EObject _xblockexpression = null;
    {
      ICompositeNode _node = NodeModelUtils.getNode(src);
      final ILeafNode elem = NodeModelUtils.findLeafNodeAtOffset(_node, offset);
      _xblockexpression = NodeModelUtils.findActualSemanticObjectFor(elem);
    }
    return _xblockexpression;
  }
  
  protected boolean _isModuleMacro(final EObject obj) {
    return false;
  }
  
  protected boolean _isModuleMacro(final Macro obj) {
    String _sourceText = this.getSourceText(obj);
    return Objects.equal(_sourceText, "? MODULE");
  }
  
  protected boolean _isPredefinedMacro(final EObject obj) {
    return false;
  }
  
  protected boolean _isPredefinedMacro(final Macro obj) {
    boolean _xblockexpression = false;
    {
      final String txt = this.getSourceText(obj);
      boolean _or = false;
      boolean _or_1 = false;
      boolean _equals = Objects.equal(txt, "? MODULE");
      if (_equals) {
        _or_1 = true;
      } else {
        boolean _equals_1 = Objects.equal(txt, "? FILE");
        _or_1 = _equals_1;
      }
      if (_or_1) {
        _or = true;
      } else {
        boolean _equals_2 = Objects.equal(txt, "? LINE");
        _or = _equals_2;
      }
      _xblockexpression = _or;
    }
    return _xblockexpression;
  }
  
  public boolean hasParentOfClass(final EObject obj, final Class<? extends EObject> c) {
    Class<? extends EObject> _class = obj.getClass();
    boolean _isAssignableFrom = c.isAssignableFrom(_class);
    if (_isAssignableFrom) {
      return true;
    }
    if ((obj instanceof Module)) {
      return false;
    }
    EObject _eContainer = obj.eContainer();
    return this.hasParentOfClass(_eContainer, c);
  }
  
  public String funRef(final Function f) {
    String _name = f.getName();
    String _plus = (_name + "/");
    int _arity = this.getArity(f);
    return (_plus + Integer.valueOf(_arity));
  }
  
  public Module findOwningModule(final EObject element) {
    if (element instanceof Module) {
      return _findOwningModule((Module)element);
    } else if (element != null) {
      return _findOwningModule(element);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element).toString());
    }
  }
  
  private Set<Expression> merge(final Set<Expression> acc, final Expression x) {
    if (x instanceof ErlList) {
      return _merge(acc, (ErlList)x);
    } else if (x != null) {
      return _merge(acc, x);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(acc, x).toString());
    }
  }
  
  private boolean hasAtom(final Expression atom, final String s) {
    if (atom instanceof Atom) {
      return _hasAtom((Atom)atom, s);
    } else if (atom instanceof ErlList) {
      return _hasAtom((ErlList)atom, s);
    } else if (atom != null) {
      return _hasAtom(atom, s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(atom, s).toString());
    }
  }
  
  public boolean isModuleMacro(final EObject obj) {
    if (obj instanceof Macro) {
      return _isModuleMacro((Macro)obj);
    } else if (obj != null) {
      return _isModuleMacro(obj);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(obj).toString());
    }
  }
  
  public boolean isPredefinedMacro(final EObject obj) {
    if (obj instanceof Macro) {
      return _isPredefinedMacro((Macro)obj);
    } else if (obj != null) {
      return _isPredefinedMacro(obj);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(obj).toString());
    }
  }
}
