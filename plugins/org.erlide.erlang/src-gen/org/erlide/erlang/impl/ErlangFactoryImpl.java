/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.erlide.erlang.AbstractDefineAttribute;
import org.erlide.erlang.AbstractIncludeAttribute;
import org.erlide.erlang.AbstractTypeAttribute;
import org.erlide.erlang.AddOp;
import org.erlide.erlang.Atom;
import org.erlide.erlang.AtomRef;
import org.erlide.erlang.AtomRefTarget;
import org.erlide.erlang.Attribute;
import org.erlide.erlang.BinBaseType;
import org.erlide.erlang.BinOp;
import org.erlide.erlang.BinUnitType;
import org.erlide.erlang.BinaryComprehension;
import org.erlide.erlang.BinaryItem;
import org.erlide.erlang.BinaryType;
import org.erlide.erlang.BitType;
import org.erlide.erlang.BlockExpr;
import org.erlide.erlang.CaseExpr;
import org.erlide.erlang.CatchExpr;
import org.erlide.erlang.CompileAttribute;
import org.erlide.erlang.CondExpr;
import org.erlide.erlang.ConditionalAttribute;
import org.erlide.erlang.ConditionalFormBlock;
import org.erlide.erlang.CrClause;
import org.erlide.erlang.CustomAttribute;
import org.erlide.erlang.DefineAttribute;
import org.erlide.erlang.ElseAttribute;
import org.erlide.erlang.EncodingAttribute;
import org.erlide.erlang.EndifAttribute;
import org.erlide.erlang.ErlBinary;
import org.erlide.erlang.ErlChar;
import org.erlide.erlang.ErlFloat;
import org.erlide.erlang.ErlInteger;
import org.erlide.erlang.ErlList;
import org.erlide.erlang.ErlTuple;
import org.erlide.erlang.ErlangFactory;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.ExportAttribute;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Expressions;
import org.erlide.erlang.FieldType;
import org.erlide.erlang.FileAttribute;
import org.erlide.erlang.Form;
import org.erlide.erlang.FunCall;
import org.erlide.erlang.FunExpr;
import org.erlide.erlang.FunRef;
import org.erlide.erlang.FunType;
import org.erlide.erlang.FunType100;
import org.erlide.erlang.FunTypeList;
import org.erlide.erlang.Function;
import org.erlide.erlang.FunctionClause;
import org.erlide.erlang.Guard;
import org.erlide.erlang.IfClause;
import org.erlide.erlang.IfExpr;
import org.erlide.erlang.IfdefAttribute;
import org.erlide.erlang.ImportAttribute;
import org.erlide.erlang.IncludeAttribute;
import org.erlide.erlang.IncludeLibAttribute;
import org.erlide.erlang.LCExpr;
import org.erlide.erlang.LetExpr;
import org.erlide.erlang.ListComprehension;
import org.erlide.erlang.ListType;
import org.erlide.erlang.Macro;
import org.erlide.erlang.MacroCall;
import org.erlide.erlang.MacroForm;
import org.erlide.erlang.MatchExpr;
import org.erlide.erlang.Module;
import org.erlide.erlang.ModuleAttribute;
import org.erlide.erlang.MultOp;
import org.erlide.erlang.QueryExpr;
import org.erlide.erlang.ReceiveExpr;
import org.erlide.erlang.RecordAttribute;
import org.erlide.erlang.RecordExpr;
import org.erlide.erlang.RecordFieldDef;
import org.erlide.erlang.RecordFieldExpr;
import org.erlide.erlang.RecordTuple;
import org.erlide.erlang.RecordType;
import org.erlide.erlang.RemoteTarget;
import org.erlide.erlang.RemoteType;
import org.erlide.erlang.SpecAttribute;
import org.erlide.erlang.StringLiteralPart;
import org.erlide.erlang.TopType;
import org.erlide.erlang.TryClause;
import org.erlide.erlang.TryExpr;
import org.erlide.erlang.TupleType;
import org.erlide.erlang.Type;
import org.erlide.erlang.Type100;
import org.erlide.erlang.Type200;
import org.erlide.erlang.Type300;
import org.erlide.erlang.Type400;
import org.erlide.erlang.Type500;
import org.erlide.erlang.TypeAttribute;
import org.erlide.erlang.TypeGuard;
import org.erlide.erlang.TypeGuards;
import org.erlide.erlang.TypeSig;
import org.erlide.erlang.UnaryExpr;
import org.erlide.erlang.UnaryType;
import org.erlide.erlang.UndefAttribute;
import org.erlide.erlang.Variable;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class ErlangFactoryImpl extends EFactoryImpl implements ErlangFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static ErlangFactory init() {
        try {
            final ErlangFactory theErlangFactory = (ErlangFactory) EPackage.Registry.INSTANCE
                    .getEFactory(ErlangPackage.eNS_URI);
            if (theErlangFactory != null) {
                return theErlangFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ErlangFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public ErlangFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(final EClass eClass) {
        switch (eClass.getClassifierID()) {
        case ErlangPackage.MODULE:
            return createModule();
        case ErlangPackage.ATOM_REF_TARGET:
            return createAtomRefTarget();
        case ErlangPackage.FORM:
            return createForm();
        case ErlangPackage.CONDITIONAL_FORM_BLOCK:
            return createConditionalFormBlock();
        case ErlangPackage.ATTRIBUTE:
            return createAttribute();
        case ErlangPackage.CONDITIONAL_ATTRIBUTE:
            return createConditionalAttribute();
        case ErlangPackage.ABSTRACT_DEFINE_ATTRIBUTE:
            return createAbstractDefineAttribute();
        case ErlangPackage.DEFINE_ATTRIBUTE:
            return createDefineAttribute();
        case ErlangPackage.UNDEF_ATTRIBUTE:
            return createUndefAttribute();
        case ErlangPackage.IFDEF_ATTRIBUTE:
            return createIfdefAttribute();
        case ErlangPackage.ELSE_ATTRIBUTE:
            return createElseAttribute();
        case ErlangPackage.ENDIF_ATTRIBUTE:
            return createEndifAttribute();
        case ErlangPackage.ABSTRACT_INCLUDE_ATTRIBUTE:
            return createAbstractIncludeAttribute();
        case ErlangPackage.INCLUDE_ATTRIBUTE:
            return createIncludeAttribute();
        case ErlangPackage.INCLUDE_LIB_ATTRIBUTE:
            return createIncludeLibAttribute();
        case ErlangPackage.FILE_ATTRIBUTE:
            return createFileAttribute();
        case ErlangPackage.MODULE_ATTRIBUTE:
            return createModuleAttribute();
        case ErlangPackage.ENCODING_ATTRIBUTE:
            return createEncodingAttribute();
        case ErlangPackage.RECORD_ATTRIBUTE:
            return createRecordAttribute();
        case ErlangPackage.RECORD_FIELD_DEF:
            return createRecordFieldDef();
        case ErlangPackage.EXPORT_ATTRIBUTE:
            return createExportAttribute();
        case ErlangPackage.IMPORT_ATTRIBUTE:
            return createImportAttribute();
        case ErlangPackage.COMPILE_ATTRIBUTE:
            return createCompileAttribute();
        case ErlangPackage.ABSTRACT_TYPE_ATTRIBUTE:
            return createAbstractTypeAttribute();
        case ErlangPackage.SPEC_ATTRIBUTE:
            return createSpecAttribute();
        case ErlangPackage.TYPE_ATTRIBUTE:
            return createTypeAttribute();
        case ErlangPackage.CUSTOM_ATTRIBUTE:
            return createCustomAttribute();
        case ErlangPackage.FUNCTION:
            return createFunction();
        case ErlangPackage.FUNCTION_CLAUSE:
            return createFunctionClause();
        case ErlangPackage.GUARD:
            return createGuard();
        case ErlangPackage.EXPRESSIONS:
            return createExpressions();
        case ErlangPackage.EXPRESSION:
            return createExpression();
        case ErlangPackage.MACRO_CALL:
            return createMacroCall();
        case ErlangPackage.RECORD_EXPR:
            return createRecordExpr();
        case ErlangPackage.QUERY_EXPR:
            return createQueryExpr();
        case ErlangPackage.COND_EXPR:
            return createCondExpr();
        case ErlangPackage.LET_EXPR:
            return createLetExpr();
        case ErlangPackage.RECORD_TUPLE:
            return createRecordTuple();
        case ErlangPackage.RECORD_FIELD_EXPR:
            return createRecordFieldExpr();
        case ErlangPackage.STRING_LITERAL_PART:
            return createStringLiteralPart();
        case ErlangPackage.IF_EXPR:
            return createIfExpr();
        case ErlangPackage.IF_CLAUSE:
            return createIfClause();
        case ErlangPackage.CASE_EXPR:
            return createCaseExpr();
        case ErlangPackage.CR_CLAUSE:
            return createCrClause();
        case ErlangPackage.RECEIVE_EXPR:
            return createReceiveExpr();
        case ErlangPackage.FUN_EXPR:
            return createFunExpr();
        case ErlangPackage.FUN_REF:
            return createFunRef();
        case ErlangPackage.TRY_EXPR:
            return createTryExpr();
        case ErlangPackage.TRY_CLAUSE:
            return createTryClause();
        case ErlangPackage.ERL_LIST:
            return createErlList();
        case ErlangPackage.ERL_TUPLE:
            return createErlTuple();
        case ErlangPackage.ERL_BINARY:
            return createErlBinary();
        case ErlangPackage.BINARY_ITEM:
            return createBinaryItem();
        case ErlangPackage.BIT_TYPE:
            return createBitType();
        case ErlangPackage.LC_EXPR:
            return createLCExpr();
        case ErlangPackage.TYPE_SIG:
            return createTypeSig();
        case ErlangPackage.FUN_TYPE:
            return createFunType();
        case ErlangPackage.TYPE_GUARDS:
            return createTypeGuards();
        case ErlangPackage.TYPE_GUARD:
            return createTypeGuard();
        case ErlangPackage.TOP_TYPE:
            return createTopType();
        case ErlangPackage.TYPE100:
            return createType100();
        case ErlangPackage.TYPE200:
            return createType200();
        case ErlangPackage.TYPE300:
            return createType300();
        case ErlangPackage.TYPE400:
            return createType400();
        case ErlangPackage.TYPE500:
            return createType500();
        case ErlangPackage.TYPE:
            return createType();
        case ErlangPackage.FIELD_TYPE:
            return createFieldType();
        case ErlangPackage.BINARY_TYPE:
            return createBinaryType();
        case ErlangPackage.BIN_BASE_TYPE:
            return createBinBaseType();
        case ErlangPackage.BIN_UNIT_TYPE:
            return createBinUnitType();
        case ErlangPackage.FUN_TYPE100:
            return createFunType100();
        case ErlangPackage.MACRO_FORM:
            return createMacroForm();
        case ErlangPackage.CATCH_EXPR:
            return createCatchExpr();
        case ErlangPackage.MATCH_EXPR:
            return createMatchExpr();
        case ErlangPackage.BIN_OP:
            return createBinOp();
        case ErlangPackage.ADD_OP:
            return createAddOp();
        case ErlangPackage.MULT_OP:
            return createMultOp();
        case ErlangPackage.UNARY_EXPR:
            return createUnaryExpr();
        case ErlangPackage.FUN_CALL:
            return createFunCall();
        case ErlangPackage.REMOTE_TARGET:
            return createRemoteTarget();
        case ErlangPackage.BLOCK_EXPR:
            return createBlockExpr();
        case ErlangPackage.ATOM:
            return createAtom();
        case ErlangPackage.ERL_CHAR:
            return createErlChar();
        case ErlangPackage.ATOM_REF:
            return createAtomRef();
        case ErlangPackage.MACRO:
            return createMacro();
        case ErlangPackage.VARIABLE:
            return createVariable();
        case ErlangPackage.ERL_FLOAT:
            return createErlFloat();
        case ErlangPackage.ERL_INTEGER:
            return createErlInteger();
        case ErlangPackage.LIST_COMPREHENSION:
            return createListComprehension();
        case ErlangPackage.BINARY_COMPREHENSION:
            return createBinaryComprehension();
        case ErlangPackage.UNARY_TYPE:
            return createUnaryType();
        case ErlangPackage.REMOTE_TYPE:
            return createRemoteType();
        case ErlangPackage.LIST_TYPE:
            return createListType();
        case ErlangPackage.TUPLE_TYPE:
            return createTupleType();
        case ErlangPackage.RECORD_TYPE:
            return createRecordType();
        case ErlangPackage.FUN_TYPE_LIST:
            return createFunTypeList();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName()
                    + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Module createModule() {
        final ModuleImpl module = new ModuleImpl();
        return module;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AtomRefTarget createAtomRefTarget() {
        final AtomRefTargetImpl atomRefTarget = new AtomRefTargetImpl();
        return atomRefTarget;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Form createForm() {
        final FormImpl form = new FormImpl();
        return form;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ConditionalFormBlock createConditionalFormBlock() {
        final ConditionalFormBlockImpl conditionalFormBlock = new ConditionalFormBlockImpl();
        return conditionalFormBlock;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Attribute createAttribute() {
        final AttributeImpl attribute = new AttributeImpl();
        return attribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ConditionalAttribute createConditionalAttribute() {
        final ConditionalAttributeImpl conditionalAttribute = new ConditionalAttributeImpl();
        return conditionalAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AbstractDefineAttribute createAbstractDefineAttribute() {
        final AbstractDefineAttributeImpl abstractDefineAttribute = new AbstractDefineAttributeImpl();
        return abstractDefineAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DefineAttribute createDefineAttribute() {
        final DefineAttributeImpl defineAttribute = new DefineAttributeImpl();
        return defineAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public UndefAttribute createUndefAttribute() {
        final UndefAttributeImpl undefAttribute = new UndefAttributeImpl();
        return undefAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public IfdefAttribute createIfdefAttribute() {
        final IfdefAttributeImpl ifdefAttribute = new IfdefAttributeImpl();
        return ifdefAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ElseAttribute createElseAttribute() {
        final ElseAttributeImpl elseAttribute = new ElseAttributeImpl();
        return elseAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EndifAttribute createEndifAttribute() {
        final EndifAttributeImpl endifAttribute = new EndifAttributeImpl();
        return endifAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AbstractIncludeAttribute createAbstractIncludeAttribute() {
        final AbstractIncludeAttributeImpl abstractIncludeAttribute = new AbstractIncludeAttributeImpl();
        return abstractIncludeAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public IncludeAttribute createIncludeAttribute() {
        final IncludeAttributeImpl includeAttribute = new IncludeAttributeImpl();
        return includeAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public IncludeLibAttribute createIncludeLibAttribute() {
        final IncludeLibAttributeImpl includeLibAttribute = new IncludeLibAttributeImpl();
        return includeLibAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FileAttribute createFileAttribute() {
        final FileAttributeImpl fileAttribute = new FileAttributeImpl();
        return fileAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ModuleAttribute createModuleAttribute() {
        final ModuleAttributeImpl moduleAttribute = new ModuleAttributeImpl();
        return moduleAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EncodingAttribute createEncodingAttribute() {
        final EncodingAttributeImpl encodingAttribute = new EncodingAttributeImpl();
        return encodingAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RecordAttribute createRecordAttribute() {
        final RecordAttributeImpl recordAttribute = new RecordAttributeImpl();
        return recordAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RecordFieldDef createRecordFieldDef() {
        final RecordFieldDefImpl recordFieldDef = new RecordFieldDefImpl();
        return recordFieldDef;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ExportAttribute createExportAttribute() {
        final ExportAttributeImpl exportAttribute = new ExportAttributeImpl();
        return exportAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ImportAttribute createImportAttribute() {
        final ImportAttributeImpl importAttribute = new ImportAttributeImpl();
        return importAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CompileAttribute createCompileAttribute() {
        final CompileAttributeImpl compileAttribute = new CompileAttributeImpl();
        return compileAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AbstractTypeAttribute createAbstractTypeAttribute() {
        final AbstractTypeAttributeImpl abstractTypeAttribute = new AbstractTypeAttributeImpl();
        return abstractTypeAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SpecAttribute createSpecAttribute() {
        final SpecAttributeImpl specAttribute = new SpecAttributeImpl();
        return specAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TypeAttribute createTypeAttribute() {
        final TypeAttributeImpl typeAttribute = new TypeAttributeImpl();
        return typeAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CustomAttribute createCustomAttribute() {
        final CustomAttributeImpl customAttribute = new CustomAttributeImpl();
        return customAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Function createFunction() {
        final FunctionImpl function = new FunctionImpl();
        return function;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FunctionClause createFunctionClause() {
        final FunctionClauseImpl functionClause = new FunctionClauseImpl();
        return functionClause;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Guard createGuard() {
        final GuardImpl guard = new GuardImpl();
        return guard;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expressions createExpressions() {
        final ExpressionsImpl expressions = new ExpressionsImpl();
        return expressions;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expression createExpression() {
        final ExpressionImpl expression = new ExpressionImpl();
        return expression;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MacroCall createMacroCall() {
        final MacroCallImpl macroCall = new MacroCallImpl();
        return macroCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RecordExpr createRecordExpr() {
        final RecordExprImpl recordExpr = new RecordExprImpl();
        return recordExpr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public QueryExpr createQueryExpr() {
        final QueryExprImpl queryExpr = new QueryExprImpl();
        return queryExpr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CondExpr createCondExpr() {
        final CondExprImpl condExpr = new CondExprImpl();
        return condExpr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public LetExpr createLetExpr() {
        final LetExprImpl letExpr = new LetExprImpl();
        return letExpr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RecordTuple createRecordTuple() {
        final RecordTupleImpl recordTuple = new RecordTupleImpl();
        return recordTuple;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RecordFieldExpr createRecordFieldExpr() {
        final RecordFieldExprImpl recordFieldExpr = new RecordFieldExprImpl();
        return recordFieldExpr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public StringLiteralPart createStringLiteralPart() {
        final StringLiteralPartImpl stringLiteralPart = new StringLiteralPartImpl();
        return stringLiteralPart;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public IfExpr createIfExpr() {
        final IfExprImpl ifExpr = new IfExprImpl();
        return ifExpr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public IfClause createIfClause() {
        final IfClauseImpl ifClause = new IfClauseImpl();
        return ifClause;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CaseExpr createCaseExpr() {
        final CaseExprImpl caseExpr = new CaseExprImpl();
        return caseExpr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CrClause createCrClause() {
        final CrClauseImpl crClause = new CrClauseImpl();
        return crClause;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ReceiveExpr createReceiveExpr() {
        final ReceiveExprImpl receiveExpr = new ReceiveExprImpl();
        return receiveExpr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FunExpr createFunExpr() {
        final FunExprImpl funExpr = new FunExprImpl();
        return funExpr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FunRef createFunRef() {
        final FunRefImpl funRef = new FunRefImpl();
        return funRef;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TryExpr createTryExpr() {
        final TryExprImpl tryExpr = new TryExprImpl();
        return tryExpr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TryClause createTryClause() {
        final TryClauseImpl tryClause = new TryClauseImpl();
        return tryClause;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ErlList createErlList() {
        final ErlListImpl erlList = new ErlListImpl();
        return erlList;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ErlTuple createErlTuple() {
        final ErlTupleImpl erlTuple = new ErlTupleImpl();
        return erlTuple;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ErlBinary createErlBinary() {
        final ErlBinaryImpl erlBinary = new ErlBinaryImpl();
        return erlBinary;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public BinaryItem createBinaryItem() {
        final BinaryItemImpl binaryItem = new BinaryItemImpl();
        return binaryItem;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public BitType createBitType() {
        final BitTypeImpl bitType = new BitTypeImpl();
        return bitType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public LCExpr createLCExpr() {
        final LCExprImpl lcExpr = new LCExprImpl();
        return lcExpr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TypeSig createTypeSig() {
        final TypeSigImpl typeSig = new TypeSigImpl();
        return typeSig;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FunType createFunType() {
        final FunTypeImpl funType = new FunTypeImpl();
        return funType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TypeGuards createTypeGuards() {
        final TypeGuardsImpl typeGuards = new TypeGuardsImpl();
        return typeGuards;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TypeGuard createTypeGuard() {
        final TypeGuardImpl typeGuard = new TypeGuardImpl();
        return typeGuard;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TopType createTopType() {
        final TopTypeImpl topType = new TopTypeImpl();
        return topType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Type100 createType100() {
        final Type100Impl type100 = new Type100Impl();
        return type100;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Type200 createType200() {
        final Type200Impl type200 = new Type200Impl();
        return type200;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Type300 createType300() {
        final Type300Impl type300 = new Type300Impl();
        return type300;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Type400 createType400() {
        final Type400Impl type400 = new Type400Impl();
        return type400;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Type500 createType500() {
        final Type500Impl type500 = new Type500Impl();
        return type500;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Type createType() {
        final TypeImpl type = new TypeImpl();
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FieldType createFieldType() {
        final FieldTypeImpl fieldType = new FieldTypeImpl();
        return fieldType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public BinaryType createBinaryType() {
        final BinaryTypeImpl binaryType = new BinaryTypeImpl();
        return binaryType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public BinBaseType createBinBaseType() {
        final BinBaseTypeImpl binBaseType = new BinBaseTypeImpl();
        return binBaseType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public BinUnitType createBinUnitType() {
        final BinUnitTypeImpl binUnitType = new BinUnitTypeImpl();
        return binUnitType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FunType100 createFunType100() {
        final FunType100Impl funType100 = new FunType100Impl();
        return funType100;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MacroForm createMacroForm() {
        final MacroFormImpl macroForm = new MacroFormImpl();
        return macroForm;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CatchExpr createCatchExpr() {
        final CatchExprImpl catchExpr = new CatchExprImpl();
        return catchExpr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MatchExpr createMatchExpr() {
        final MatchExprImpl matchExpr = new MatchExprImpl();
        return matchExpr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public BinOp createBinOp() {
        final BinOpImpl binOp = new BinOpImpl();
        return binOp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AddOp createAddOp() {
        final AddOpImpl addOp = new AddOpImpl();
        return addOp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MultOp createMultOp() {
        final MultOpImpl multOp = new MultOpImpl();
        return multOp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public UnaryExpr createUnaryExpr() {
        final UnaryExprImpl unaryExpr = new UnaryExprImpl();
        return unaryExpr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FunCall createFunCall() {
        final FunCallImpl funCall = new FunCallImpl();
        return funCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RemoteTarget createRemoteTarget() {
        final RemoteTargetImpl remoteTarget = new RemoteTargetImpl();
        return remoteTarget;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public BlockExpr createBlockExpr() {
        final BlockExprImpl blockExpr = new BlockExprImpl();
        return blockExpr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Atom createAtom() {
        final AtomImpl atom = new AtomImpl();
        return atom;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ErlChar createErlChar() {
        final ErlCharImpl erlChar = new ErlCharImpl();
        return erlChar;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AtomRef createAtomRef() {
        final AtomRefImpl atomRef = new AtomRefImpl();
        return atomRef;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Macro createMacro() {
        final MacroImpl macro = new MacroImpl();
        return macro;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Variable createVariable() {
        final VariableImpl variable = new VariableImpl();
        return variable;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ErlFloat createErlFloat() {
        final ErlFloatImpl erlFloat = new ErlFloatImpl();
        return erlFloat;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ErlInteger createErlInteger() {
        final ErlIntegerImpl erlInteger = new ErlIntegerImpl();
        return erlInteger;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ListComprehension createListComprehension() {
        final ListComprehensionImpl listComprehension = new ListComprehensionImpl();
        return listComprehension;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public BinaryComprehension createBinaryComprehension() {
        final BinaryComprehensionImpl binaryComprehension = new BinaryComprehensionImpl();
        return binaryComprehension;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public UnaryType createUnaryType() {
        final UnaryTypeImpl unaryType = new UnaryTypeImpl();
        return unaryType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RemoteType createRemoteType() {
        final RemoteTypeImpl remoteType = new RemoteTypeImpl();
        return remoteType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ListType createListType() {
        final ListTypeImpl listType = new ListTypeImpl();
        return listType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TupleType createTupleType() {
        final TupleTypeImpl tupleType = new TupleTypeImpl();
        return tupleType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RecordType createRecordType() {
        final RecordTypeImpl recordType = new RecordTypeImpl();
        return recordType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FunTypeList createFunTypeList() {
        final FunTypeListImpl funTypeList = new FunTypeListImpl();
        return funTypeList;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ErlangPackage getErlangPackage() {
        return (ErlangPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ErlangPackage getPackage() {
        return ErlangPackage.eINSTANCE;
    }

} // ErlangFactoryImpl
