/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.erlide.erlang.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ErlangFactoryImpl extends EFactoryImpl implements ErlangFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ErlangFactory init()
  {
    try
    {
      ErlangFactory theErlangFactory = (ErlangFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.erlide.org/Erlang"); 
      if (theErlangFactory != null)
      {
        return theErlangFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ErlangFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErlangFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ErlangPackage.MODULE: return createModule();
      case ErlangPackage.ATOM_REF_TARGET: return createAtomRefTarget();
      case ErlangPackage.FORM: return createForm();
      case ErlangPackage.CONDITIONAL_FORM_BLOCK: return createConditionalFormBlock();
      case ErlangPackage.ATTRIBUTE: return createAttribute();
      case ErlangPackage.CONDITIONAL_ATTRIBUTE: return createConditionalAttribute();
      case ErlangPackage.ABSTRACT_DEFINE_ATTRIBUTE: return createAbstractDefineAttribute();
      case ErlangPackage.DEFINE_ATTRIBUTE: return createDefineAttribute();
      case ErlangPackage.UNDEF_ATTRIBUTE: return createUndefAttribute();
      case ErlangPackage.IFDEF_ATTRIBUTE: return createIfdefAttribute();
      case ErlangPackage.ELSE_ATTRIBUTE: return createElseAttribute();
      case ErlangPackage.ENDIF_ATTRIBUTE: return createEndifAttribute();
      case ErlangPackage.ABSTRACT_INCLUDE_ATTRIBUTE: return createAbstractIncludeAttribute();
      case ErlangPackage.INCLUDE_ATTRIBUTE: return createIncludeAttribute();
      case ErlangPackage.INCLUDE_LIB_ATTRIBUTE: return createIncludeLibAttribute();
      case ErlangPackage.FILE_ATTRIBUTE: return createFileAttribute();
      case ErlangPackage.MODULE_ATTRIBUTE: return createModuleAttribute();
      case ErlangPackage.RECORD_ATTRIBUTE: return createRecordAttribute();
      case ErlangPackage.RECORD_FIELD_DEF: return createRecordFieldDef();
      case ErlangPackage.EXPORT_ATTRIBUTE: return createExportAttribute();
      case ErlangPackage.IMPORT_ATTRIBUTE: return createImportAttribute();
      case ErlangPackage.COMPILE_ATTRIBUTE: return createCompileAttribute();
      case ErlangPackage.ABSTRACT_TYPE_ATTRIBUTE: return createAbstractTypeAttribute();
      case ErlangPackage.SPEC_ATTRIBUTE: return createSpecAttribute();
      case ErlangPackage.TYPE_ATTRIBUTE: return createTypeAttribute();
      case ErlangPackage.CUSTOM_ATTRIBUTE: return createCustomAttribute();
      case ErlangPackage.FUNCTION: return createFunction();
      case ErlangPackage.FUNCTION_CLAUSE: return createFunctionClause();
      case ErlangPackage.GUARD: return createGuard();
      case ErlangPackage.EXPRESSIONS: return createExpressions();
      case ErlangPackage.EXPRESSION: return createExpression();
      case ErlangPackage.MACRO_CALL: return createMacroCall();
      case ErlangPackage.RECORD_EXPR: return createRecordExpr();
      case ErlangPackage.QUERY_EXPR: return createQueryExpr();
      case ErlangPackage.COND_EXPR: return createCondExpr();
      case ErlangPackage.LET_EXPR: return createLetExpr();
      case ErlangPackage.RECORD_TUPLE: return createRecordTuple();
      case ErlangPackage.RECORD_FIELD_EXPR: return createRecordFieldExpr();
      case ErlangPackage.STRING_LITERAL_PART: return createStringLiteralPart();
      case ErlangPackage.IF_EXPR: return createIfExpr();
      case ErlangPackage.IF_CLAUSE: return createIfClause();
      case ErlangPackage.CASE_EXPR: return createCaseExpr();
      case ErlangPackage.CR_CLAUSE: return createCrClause();
      case ErlangPackage.RECEIVE_EXPR: return createReceiveExpr();
      case ErlangPackage.FUN_EXPR: return createFunExpr();
      case ErlangPackage.FUN_REF: return createFunRef();
      case ErlangPackage.TRY_EXPR: return createTryExpr();
      case ErlangPackage.TRY_CLAUSE: return createTryClause();
      case ErlangPackage.ERL_LIST: return createErlList();
      case ErlangPackage.LIST_COMPREHENSION: return createListComprehension();
      case ErlangPackage.ERL_TUPLE: return createErlTuple();
      case ErlangPackage.BINARY_COMPREHENSION: return createBinaryComprehension();
      case ErlangPackage.ERL_BINARY: return createErlBinary();
      case ErlangPackage.BINARY_ITEM: return createBinaryItem();
      case ErlangPackage.BIT_TYPE: return createBitType();
      case ErlangPackage.LC_EXPR: return createLCExpr();
      case ErlangPackage.TYPE_SIG: return createTypeSig();
      case ErlangPackage.FUN_TYPE: return createFunType();
      case ErlangPackage.TYPE_GUARDS: return createTypeGuards();
      case ErlangPackage.TYPE_GUARD: return createTypeGuard();
      case ErlangPackage.TOP_TYPE: return createTopType();
      case ErlangPackage.TYPE100: return createType100();
      case ErlangPackage.TYPE200: return createType200();
      case ErlangPackage.TYPE300: return createType300();
      case ErlangPackage.TYPE400: return createType400();
      case ErlangPackage.TYPE500: return createType500();
      case ErlangPackage.TYPE: return createType();
      case ErlangPackage.FIELD_TYPE: return createFieldType();
      case ErlangPackage.BINARY_TYPE: return createBinaryType();
      case ErlangPackage.BIN_BASE_TYPE: return createBinBaseType();
      case ErlangPackage.BIN_UNIT_TYPE: return createBinUnitType();
      case ErlangPackage.FUN_TYPE100: return createFunType100();
      case ErlangPackage.MACRO_FORM: return createMacroForm();
      case ErlangPackage.CATCH_EXPR: return createCatchExpr();
      case ErlangPackage.MATCH_EXPR: return createMatchExpr();
      case ErlangPackage.BIN_OP: return createBinOp();
      case ErlangPackage.ADD_OP: return createAddOp();
      case ErlangPackage.MULT_OP: return createMultOp();
      case ErlangPackage.UNARY_EXPR: return createUnaryExpr();
      case ErlangPackage.FUN_CALL: return createFunCall();
      case ErlangPackage.REMOTE_TARGET: return createRemoteTarget();
      case ErlangPackage.BLOCK_EXPR: return createBlockExpr();
      case ErlangPackage.ERL_CHAR: return createErlChar();
      case ErlangPackage.ATOM: return createAtom();
      case ErlangPackage.MACRO: return createMacro();
      case ErlangPackage.VARIABLE: return createVariable();
      case ErlangPackage.ERL_FLOAT: return createErlFloat();
      case ErlangPackage.ERL_INTEGER: return createErlInteger();
      case ErlangPackage.UNARY_TYPE: return createUnaryType();
      case ErlangPackage.REMOTE_TYPE: return createRemoteType();
      case ErlangPackage.LIST_TYPE: return createListType();
      case ErlangPackage.TUPLE_TYPE: return createTupleType();
      case ErlangPackage.RECORD_TYPE: return createRecordType();
      case ErlangPackage.FUN_TYPE_LIST: return createFunTypeList();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Module createModule()
  {
    ModuleImpl module = new ModuleImpl();
    return module;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AtomRefTarget createAtomRefTarget()
  {
    AtomRefTargetImpl atomRefTarget = new AtomRefTargetImpl();
    return atomRefTarget;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Form createForm()
  {
    FormImpl form = new FormImpl();
    return form;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalFormBlock createConditionalFormBlock()
  {
    ConditionalFormBlockImpl conditionalFormBlock = new ConditionalFormBlockImpl();
    return conditionalFormBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalAttribute createConditionalAttribute()
  {
    ConditionalAttributeImpl conditionalAttribute = new ConditionalAttributeImpl();
    return conditionalAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractDefineAttribute createAbstractDefineAttribute()
  {
    AbstractDefineAttributeImpl abstractDefineAttribute = new AbstractDefineAttributeImpl();
    return abstractDefineAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefineAttribute createDefineAttribute()
  {
    DefineAttributeImpl defineAttribute = new DefineAttributeImpl();
    return defineAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UndefAttribute createUndefAttribute()
  {
    UndefAttributeImpl undefAttribute = new UndefAttributeImpl();
    return undefAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfdefAttribute createIfdefAttribute()
  {
    IfdefAttributeImpl ifdefAttribute = new IfdefAttributeImpl();
    return ifdefAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElseAttribute createElseAttribute()
  {
    ElseAttributeImpl elseAttribute = new ElseAttributeImpl();
    return elseAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EndifAttribute createEndifAttribute()
  {
    EndifAttributeImpl endifAttribute = new EndifAttributeImpl();
    return endifAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractIncludeAttribute createAbstractIncludeAttribute()
  {
    AbstractIncludeAttributeImpl abstractIncludeAttribute = new AbstractIncludeAttributeImpl();
    return abstractIncludeAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IncludeAttribute createIncludeAttribute()
  {
    IncludeAttributeImpl includeAttribute = new IncludeAttributeImpl();
    return includeAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IncludeLibAttribute createIncludeLibAttribute()
  {
    IncludeLibAttributeImpl includeLibAttribute = new IncludeLibAttributeImpl();
    return includeLibAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FileAttribute createFileAttribute()
  {
    FileAttributeImpl fileAttribute = new FileAttributeImpl();
    return fileAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModuleAttribute createModuleAttribute()
  {
    ModuleAttributeImpl moduleAttribute = new ModuleAttributeImpl();
    return moduleAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordAttribute createRecordAttribute()
  {
    RecordAttributeImpl recordAttribute = new RecordAttributeImpl();
    return recordAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordFieldDef createRecordFieldDef()
  {
    RecordFieldDefImpl recordFieldDef = new RecordFieldDefImpl();
    return recordFieldDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExportAttribute createExportAttribute()
  {
    ExportAttributeImpl exportAttribute = new ExportAttributeImpl();
    return exportAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportAttribute createImportAttribute()
  {
    ImportAttributeImpl importAttribute = new ImportAttributeImpl();
    return importAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompileAttribute createCompileAttribute()
  {
    CompileAttributeImpl compileAttribute = new CompileAttributeImpl();
    return compileAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractTypeAttribute createAbstractTypeAttribute()
  {
    AbstractTypeAttributeImpl abstractTypeAttribute = new AbstractTypeAttributeImpl();
    return abstractTypeAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecAttribute createSpecAttribute()
  {
    SpecAttributeImpl specAttribute = new SpecAttributeImpl();
    return specAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeAttribute createTypeAttribute()
  {
    TypeAttributeImpl typeAttribute = new TypeAttributeImpl();
    return typeAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CustomAttribute createCustomAttribute()
  {
    CustomAttributeImpl customAttribute = new CustomAttributeImpl();
    return customAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function createFunction()
  {
    FunctionImpl function = new FunctionImpl();
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionClause createFunctionClause()
  {
    FunctionClauseImpl functionClause = new FunctionClauseImpl();
    return functionClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Guard createGuard()
  {
    GuardImpl guard = new GuardImpl();
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expressions createExpressions()
  {
    ExpressionsImpl expressions = new ExpressionsImpl();
    return expressions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MacroCall createMacroCall()
  {
    MacroCallImpl macroCall = new MacroCallImpl();
    return macroCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordExpr createRecordExpr()
  {
    RecordExprImpl recordExpr = new RecordExprImpl();
    return recordExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryExpr createQueryExpr()
  {
    QueryExprImpl queryExpr = new QueryExprImpl();
    return queryExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CondExpr createCondExpr()
  {
    CondExprImpl condExpr = new CondExprImpl();
    return condExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LetExpr createLetExpr()
  {
    LetExprImpl letExpr = new LetExprImpl();
    return letExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordTuple createRecordTuple()
  {
    RecordTupleImpl recordTuple = new RecordTupleImpl();
    return recordTuple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordFieldExpr createRecordFieldExpr()
  {
    RecordFieldExprImpl recordFieldExpr = new RecordFieldExprImpl();
    return recordFieldExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringLiteralPart createStringLiteralPart()
  {
    StringLiteralPartImpl stringLiteralPart = new StringLiteralPartImpl();
    return stringLiteralPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfExpr createIfExpr()
  {
    IfExprImpl ifExpr = new IfExprImpl();
    return ifExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfClause createIfClause()
  {
    IfClauseImpl ifClause = new IfClauseImpl();
    return ifClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CaseExpr createCaseExpr()
  {
    CaseExprImpl caseExpr = new CaseExprImpl();
    return caseExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CrClause createCrClause()
  {
    CrClauseImpl crClause = new CrClauseImpl();
    return crClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReceiveExpr createReceiveExpr()
  {
    ReceiveExprImpl receiveExpr = new ReceiveExprImpl();
    return receiveExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunExpr createFunExpr()
  {
    FunExprImpl funExpr = new FunExprImpl();
    return funExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunRef createFunRef()
  {
    FunRefImpl funRef = new FunRefImpl();
    return funRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TryExpr createTryExpr()
  {
    TryExprImpl tryExpr = new TryExprImpl();
    return tryExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TryClause createTryClause()
  {
    TryClauseImpl tryClause = new TryClauseImpl();
    return tryClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErlList createErlList()
  {
    ErlListImpl erlList = new ErlListImpl();
    return erlList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListComprehension createListComprehension()
  {
    ListComprehensionImpl listComprehension = new ListComprehensionImpl();
    return listComprehension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErlTuple createErlTuple()
  {
    ErlTupleImpl erlTuple = new ErlTupleImpl();
    return erlTuple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinaryComprehension createBinaryComprehension()
  {
    BinaryComprehensionImpl binaryComprehension = new BinaryComprehensionImpl();
    return binaryComprehension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErlBinary createErlBinary()
  {
    ErlBinaryImpl erlBinary = new ErlBinaryImpl();
    return erlBinary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinaryItem createBinaryItem()
  {
    BinaryItemImpl binaryItem = new BinaryItemImpl();
    return binaryItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitType createBitType()
  {
    BitTypeImpl bitType = new BitTypeImpl();
    return bitType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LCExpr createLCExpr()
  {
    LCExprImpl lcExpr = new LCExprImpl();
    return lcExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSig createTypeSig()
  {
    TypeSigImpl typeSig = new TypeSigImpl();
    return typeSig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunType createFunType()
  {
    FunTypeImpl funType = new FunTypeImpl();
    return funType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeGuards createTypeGuards()
  {
    TypeGuardsImpl typeGuards = new TypeGuardsImpl();
    return typeGuards;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeGuard createTypeGuard()
  {
    TypeGuardImpl typeGuard = new TypeGuardImpl();
    return typeGuard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TopType createTopType()
  {
    TopTypeImpl topType = new TopTypeImpl();
    return topType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type100 createType100()
  {
    Type100Impl type100 = new Type100Impl();
    return type100;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type200 createType200()
  {
    Type200Impl type200 = new Type200Impl();
    return type200;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type300 createType300()
  {
    Type300Impl type300 = new Type300Impl();
    return type300;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type400 createType400()
  {
    Type400Impl type400 = new Type400Impl();
    return type400;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type500 createType500()
  {
    Type500Impl type500 = new Type500Impl();
    return type500;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createType()
  {
    TypeImpl type = new TypeImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FieldType createFieldType()
  {
    FieldTypeImpl fieldType = new FieldTypeImpl();
    return fieldType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinaryType createBinaryType()
  {
    BinaryTypeImpl binaryType = new BinaryTypeImpl();
    return binaryType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinBaseType createBinBaseType()
  {
    BinBaseTypeImpl binBaseType = new BinBaseTypeImpl();
    return binBaseType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinUnitType createBinUnitType()
  {
    BinUnitTypeImpl binUnitType = new BinUnitTypeImpl();
    return binUnitType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunType100 createFunType100()
  {
    FunType100Impl funType100 = new FunType100Impl();
    return funType100;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MacroForm createMacroForm()
  {
    MacroFormImpl macroForm = new MacroFormImpl();
    return macroForm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CatchExpr createCatchExpr()
  {
    CatchExprImpl catchExpr = new CatchExprImpl();
    return catchExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatchExpr createMatchExpr()
  {
    MatchExprImpl matchExpr = new MatchExprImpl();
    return matchExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinOp createBinOp()
  {
    BinOpImpl binOp = new BinOpImpl();
    return binOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AddOp createAddOp()
  {
    AddOpImpl addOp = new AddOpImpl();
    return addOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultOp createMultOp()
  {
    MultOpImpl multOp = new MultOpImpl();
    return multOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryExpr createUnaryExpr()
  {
    UnaryExprImpl unaryExpr = new UnaryExprImpl();
    return unaryExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunCall createFunCall()
  {
    FunCallImpl funCall = new FunCallImpl();
    return funCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RemoteTarget createRemoteTarget()
  {
    RemoteTargetImpl remoteTarget = new RemoteTargetImpl();
    return remoteTarget;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BlockExpr createBlockExpr()
  {
    BlockExprImpl blockExpr = new BlockExprImpl();
    return blockExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErlChar createErlChar()
  {
    ErlCharImpl erlChar = new ErlCharImpl();
    return erlChar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Atom createAtom()
  {
    AtomImpl atom = new AtomImpl();
    return atom;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Macro createMacro()
  {
    MacroImpl macro = new MacroImpl();
    return macro;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErlFloat createErlFloat()
  {
    ErlFloatImpl erlFloat = new ErlFloatImpl();
    return erlFloat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErlInteger createErlInteger()
  {
    ErlIntegerImpl erlInteger = new ErlIntegerImpl();
    return erlInteger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryType createUnaryType()
  {
    UnaryTypeImpl unaryType = new UnaryTypeImpl();
    return unaryType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RemoteType createRemoteType()
  {
    RemoteTypeImpl remoteType = new RemoteTypeImpl();
    return remoteType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListType createListType()
  {
    ListTypeImpl listType = new ListTypeImpl();
    return listType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TupleType createTupleType()
  {
    TupleTypeImpl tupleType = new TupleTypeImpl();
    return tupleType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordType createRecordType()
  {
    RecordTypeImpl recordType = new RecordTypeImpl();
    return recordType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunTypeList createFunTypeList()
  {
    FunTypeListImpl funTypeList = new FunTypeListImpl();
    return funTypeList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErlangPackage getErlangPackage()
  {
    return (ErlangPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ErlangPackage getPackage()
  {
    return ErlangPackage.eINSTANCE;
  }

} //ErlangFactoryImpl
