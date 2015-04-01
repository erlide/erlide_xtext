/**
 */
package org.erlide.erlang.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * 
 * @see org.erlide.erlang.ErlangPackage
 * @generated
 */
public class ErlangAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static ErlangPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public ErlangAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = ErlangPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc --> This implementation returns <code>true</code> if
     * the object is either the model's package or is an instance object of the
     * model. <!-- end-user-doc -->
     * 
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(final Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ErlangSwitch<Adapter> modelSwitch = new ErlangSwitch<Adapter>() {
        @Override
        public Adapter caseModule(final Module object) {
            return createModuleAdapter();
        }

        @Override
        public Adapter caseAtomRefTarget(final AtomRefTarget object) {
            return createAtomRefTargetAdapter();
        }

        @Override
        public Adapter caseForm(final Form object) {
            return createFormAdapter();
        }

        @Override
        public Adapter caseConditionalFormBlock(
                final ConditionalFormBlock object) {
            return createConditionalFormBlockAdapter();
        }

        @Override
        public Adapter caseAttribute(final Attribute object) {
            return createAttributeAdapter();
        }

        @Override
        public Adapter caseConditionalAttribute(
                final ConditionalAttribute object) {
            return createConditionalAttributeAdapter();
        }

        @Override
        public Adapter caseAbstractDefineAttribute(
                final AbstractDefineAttribute object) {
            return createAbstractDefineAttributeAdapter();
        }

        @Override
        public Adapter caseDefineAttribute(final DefineAttribute object) {
            return createDefineAttributeAdapter();
        }

        @Override
        public Adapter caseUndefAttribute(final UndefAttribute object) {
            return createUndefAttributeAdapter();
        }

        @Override
        public Adapter caseIfdefAttribute(final IfdefAttribute object) {
            return createIfdefAttributeAdapter();
        }

        @Override
        public Adapter caseElseAttribute(final ElseAttribute object) {
            return createElseAttributeAdapter();
        }

        @Override
        public Adapter caseEndifAttribute(final EndifAttribute object) {
            return createEndifAttributeAdapter();
        }

        @Override
        public Adapter caseAbstractIncludeAttribute(
                final AbstractIncludeAttribute object) {
            return createAbstractIncludeAttributeAdapter();
        }

        @Override
        public Adapter caseIncludeAttribute(final IncludeAttribute object) {
            return createIncludeAttributeAdapter();
        }

        @Override
        public Adapter caseIncludeLibAttribute(final IncludeLibAttribute object) {
            return createIncludeLibAttributeAdapter();
        }

        @Override
        public Adapter caseFileAttribute(final FileAttribute object) {
            return createFileAttributeAdapter();
        }

        @Override
        public Adapter caseModuleAttribute(final ModuleAttribute object) {
            return createModuleAttributeAdapter();
        }

        @Override
        public Adapter caseEncodingAttribute(final EncodingAttribute object) {
            return createEncodingAttributeAdapter();
        }

        @Override
        public Adapter caseRecordAttribute(final RecordAttribute object) {
            return createRecordAttributeAdapter();
        }

        @Override
        public Adapter caseRecordFieldDef(final RecordFieldDef object) {
            return createRecordFieldDefAdapter();
        }

        @Override
        public Adapter caseExportAttribute(final ExportAttribute object) {
            return createExportAttributeAdapter();
        }

        @Override
        public Adapter caseImportAttribute(final ImportAttribute object) {
            return createImportAttributeAdapter();
        }

        @Override
        public Adapter caseCompileAttribute(final CompileAttribute object) {
            return createCompileAttributeAdapter();
        }

        @Override
        public Adapter caseAbstractTypeAttribute(
                final AbstractTypeAttribute object) {
            return createAbstractTypeAttributeAdapter();
        }

        @Override
        public Adapter caseSpecAttribute(final SpecAttribute object) {
            return createSpecAttributeAdapter();
        }

        @Override
        public Adapter caseTypeAttribute(final TypeAttribute object) {
            return createTypeAttributeAdapter();
        }

        @Override
        public Adapter caseCustomAttribute(final CustomAttribute object) {
            return createCustomAttributeAdapter();
        }

        @Override
        public Adapter caseFunction(final Function object) {
            return createFunctionAdapter();
        }

        @Override
        public Adapter caseFunctionClause(final FunctionClause object) {
            return createFunctionClauseAdapter();
        }

        @Override
        public Adapter caseGuard(final Guard object) {
            return createGuardAdapter();
        }

        @Override
        public Adapter caseExpressions(final Expressions object) {
            return createExpressionsAdapter();
        }

        @Override
        public Adapter caseExpression(final Expression object) {
            return createExpressionAdapter();
        }

        @Override
        public Adapter caseMacroCall(final MacroCall object) {
            return createMacroCallAdapter();
        }

        @Override
        public Adapter caseRecordExpr(final RecordExpr object) {
            return createRecordExprAdapter();
        }

        @Override
        public Adapter caseQueryExpr(final QueryExpr object) {
            return createQueryExprAdapter();
        }

        @Override
        public Adapter caseCondExpr(final CondExpr object) {
            return createCondExprAdapter();
        }

        @Override
        public Adapter caseLetExpr(final LetExpr object) {
            return createLetExprAdapter();
        }

        @Override
        public Adapter caseRecordTuple(final RecordTuple object) {
            return createRecordTupleAdapter();
        }

        @Override
        public Adapter caseRecordFieldExpr(final RecordFieldExpr object) {
            return createRecordFieldExprAdapter();
        }

        @Override
        public Adapter caseStringLiteralPart(final StringLiteralPart object) {
            return createStringLiteralPartAdapter();
        }

        @Override
        public Adapter caseIfExpr(final IfExpr object) {
            return createIfExprAdapter();
        }

        @Override
        public Adapter caseIfClause(final IfClause object) {
            return createIfClauseAdapter();
        }

        @Override
        public Adapter caseCaseExpr(final CaseExpr object) {
            return createCaseExprAdapter();
        }

        @Override
        public Adapter caseCrClause(final CrClause object) {
            return createCrClauseAdapter();
        }

        @Override
        public Adapter caseReceiveExpr(final ReceiveExpr object) {
            return createReceiveExprAdapter();
        }

        @Override
        public Adapter caseFunExpr(final FunExpr object) {
            return createFunExprAdapter();
        }

        @Override
        public Adapter caseFunRef(final FunRef object) {
            return createFunRefAdapter();
        }

        @Override
        public Adapter caseTryExpr(final TryExpr object) {
            return createTryExprAdapter();
        }

        @Override
        public Adapter caseTryClause(final TryClause object) {
            return createTryClauseAdapter();
        }

        @Override
        public Adapter caseErlList(final ErlList object) {
            return createErlListAdapter();
        }

        @Override
        public Adapter caseErlTuple(final ErlTuple object) {
            return createErlTupleAdapter();
        }

        @Override
        public Adapter caseErlBinary(final ErlBinary object) {
            return createErlBinaryAdapter();
        }

        @Override
        public Adapter caseBinaryItem(final BinaryItem object) {
            return createBinaryItemAdapter();
        }

        @Override
        public Adapter caseBitType(final BitType object) {
            return createBitTypeAdapter();
        }

        @Override
        public Adapter caseLCExpr(final LCExpr object) {
            return createLCExprAdapter();
        }

        @Override
        public Adapter caseTypeSig(final TypeSig object) {
            return createTypeSigAdapter();
        }

        @Override
        public Adapter caseFunType(final FunType object) {
            return createFunTypeAdapter();
        }

        @Override
        public Adapter caseTypeGuards(final TypeGuards object) {
            return createTypeGuardsAdapter();
        }

        @Override
        public Adapter caseTypeGuard(final TypeGuard object) {
            return createTypeGuardAdapter();
        }

        @Override
        public Adapter caseTopType(final TopType object) {
            return createTopTypeAdapter();
        }

        @Override
        public Adapter caseType100(final Type100 object) {
            return createType100Adapter();
        }

        @Override
        public Adapter caseType200(final Type200 object) {
            return createType200Adapter();
        }

        @Override
        public Adapter caseType300(final Type300 object) {
            return createType300Adapter();
        }

        @Override
        public Adapter caseType400(final Type400 object) {
            return createType400Adapter();
        }

        @Override
        public Adapter caseType500(final Type500 object) {
            return createType500Adapter();
        }

        @Override
        public Adapter caseType(final Type object) {
            return createTypeAdapter();
        }

        @Override
        public Adapter caseFieldType(final FieldType object) {
            return createFieldTypeAdapter();
        }

        @Override
        public Adapter caseBinaryType(final BinaryType object) {
            return createBinaryTypeAdapter();
        }

        @Override
        public Adapter caseBinBaseType(final BinBaseType object) {
            return createBinBaseTypeAdapter();
        }

        @Override
        public Adapter caseBinUnitType(final BinUnitType object) {
            return createBinUnitTypeAdapter();
        }

        @Override
        public Adapter caseFunType100(final FunType100 object) {
            return createFunType100Adapter();
        }

        @Override
        public Adapter caseMacroForm(final MacroForm object) {
            return createMacroFormAdapter();
        }

        @Override
        public Adapter caseCatchExpr(final CatchExpr object) {
            return createCatchExprAdapter();
        }

        @Override
        public Adapter caseMatchExpr(final MatchExpr object) {
            return createMatchExprAdapter();
        }

        @Override
        public Adapter caseBinOp(final BinOp object) {
            return createBinOpAdapter();
        }

        @Override
        public Adapter caseAddOp(final AddOp object) {
            return createAddOpAdapter();
        }

        @Override
        public Adapter caseMultOp(final MultOp object) {
            return createMultOpAdapter();
        }

        @Override
        public Adapter caseUnaryExpr(final UnaryExpr object) {
            return createUnaryExprAdapter();
        }

        @Override
        public Adapter caseFunCall(final FunCall object) {
            return createFunCallAdapter();
        }

        @Override
        public Adapter caseRemoteTarget(final RemoteTarget object) {
            return createRemoteTargetAdapter();
        }

        @Override
        public Adapter caseBlockExpr(final BlockExpr object) {
            return createBlockExprAdapter();
        }

        @Override
        public Adapter caseAtom(final Atom object) {
            return createAtomAdapter();
        }

        @Override
        public Adapter caseErlChar(final ErlChar object) {
            return createErlCharAdapter();
        }

        @Override
        public Adapter caseAtomRef(final AtomRef object) {
            return createAtomRefAdapter();
        }

        @Override
        public Adapter caseMacro(final Macro object) {
            return createMacroAdapter();
        }

        @Override
        public Adapter caseVariable(final Variable object) {
            return createVariableAdapter();
        }

        @Override
        public Adapter caseErlFloat(final ErlFloat object) {
            return createErlFloatAdapter();
        }

        @Override
        public Adapter caseErlInteger(final ErlInteger object) {
            return createErlIntegerAdapter();
        }

        @Override
        public Adapter caseListComprehension(final ListComprehension object) {
            return createListComprehensionAdapter();
        }

        @Override
        public Adapter caseBinaryComprehension(final BinaryComprehension object) {
            return createBinaryComprehensionAdapter();
        }

        @Override
        public Adapter caseUnaryType(final UnaryType object) {
            return createUnaryTypeAdapter();
        }

        @Override
        public Adapter caseRemoteType(final RemoteType object) {
            return createRemoteTypeAdapter();
        }

        @Override
        public Adapter caseListType(final ListType object) {
            return createListTypeAdapter();
        }

        @Override
        public Adapter caseTupleType(final TupleType object) {
            return createTupleTypeAdapter();
        }

        @Override
        public Adapter caseRecordType(final RecordType object) {
            return createRecordTypeAdapter();
        }

        @Override
        public Adapter caseFunTypeList(final FunTypeList object) {
            return createFunTypeListAdapter();
        }

        @Override
        public Adapter defaultCase(final EObject object) {
            return createEObjectAdapter();
        }
            };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(final Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.Module <em>Module</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.Module
     * @generated
     */
    public Adapter createModuleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.AtomRefTarget <em>Atom Ref Target</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.AtomRefTarget
     * @generated
     */
    public Adapter createAtomRefTargetAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.Form <em>Form</em>}'. <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.Form
     * @generated
     */
    public Adapter createFormAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.ConditionalFormBlock
     * <em>Conditional Form Block</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's
     * useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.ConditionalFormBlock
     * @generated
     */
    public Adapter createConditionalFormBlockAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.Attribute <em>Attribute</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.Attribute
     * @generated
     */
    public Adapter createAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.ConditionalAttribute
     * <em>Conditional Attribute</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's
     * useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.ConditionalAttribute
     * @generated
     */
    public Adapter createConditionalAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.AbstractDefineAttribute
     * <em>Abstract Define Attribute</em>}'. <!-- begin-user-doc --> This
     * default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.AbstractDefineAttribute
     * @generated
     */
    public Adapter createAbstractDefineAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.DefineAttribute <em>Define Attribute</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.DefineAttribute
     * @generated
     */
    public Adapter createDefineAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.UndefAttribute <em>Undef Attribute</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.UndefAttribute
     * @generated
     */
    public Adapter createUndefAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.IfdefAttribute <em>Ifdef Attribute</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.IfdefAttribute
     * @generated
     */
    public Adapter createIfdefAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.ElseAttribute <em>Else Attribute</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.ElseAttribute
     * @generated
     */
    public Adapter createElseAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.EndifAttribute <em>Endif Attribute</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.EndifAttribute
     * @generated
     */
    public Adapter createEndifAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.AbstractIncludeAttribute
     * <em>Abstract Include Attribute</em>}'. <!-- begin-user-doc --> This
     * default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.AbstractIncludeAttribute
     * @generated
     */
    public Adapter createAbstractIncludeAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.IncludeAttribute <em>Include Attribute</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.IncludeAttribute
     * @generated
     */
    public Adapter createIncludeAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.IncludeLibAttribute
     * <em>Include Lib Attribute</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's
     * useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.IncludeLibAttribute
     * @generated
     */
    public Adapter createIncludeLibAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.FileAttribute <em>File Attribute</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.FileAttribute
     * @generated
     */
    public Adapter createFileAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.ModuleAttribute <em>Module Attribute</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.ModuleAttribute
     * @generated
     */
    public Adapter createModuleAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.EncodingAttribute <em>Encoding Attribute</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.EncodingAttribute
     * @generated
     */
    public Adapter createEncodingAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.RecordAttribute <em>Record Attribute</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.RecordAttribute
     * @generated
     */
    public Adapter createRecordAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.RecordFieldDef <em>Record Field Def</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.RecordFieldDef
     * @generated
     */
    public Adapter createRecordFieldDefAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.ExportAttribute <em>Export Attribute</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.ExportAttribute
     * @generated
     */
    public Adapter createExportAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.ImportAttribute <em>Import Attribute</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.ImportAttribute
     * @generated
     */
    public Adapter createImportAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.CompileAttribute <em>Compile Attribute</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.CompileAttribute
     * @generated
     */
    public Adapter createCompileAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.AbstractTypeAttribute
     * <em>Abstract Type Attribute</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's
     * useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.AbstractTypeAttribute
     * @generated
     */
    public Adapter createAbstractTypeAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.SpecAttribute <em>Spec Attribute</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.SpecAttribute
     * @generated
     */
    public Adapter createSpecAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.TypeAttribute <em>Type Attribute</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.TypeAttribute
     * @generated
     */
    public Adapter createTypeAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.CustomAttribute <em>Custom Attribute</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.CustomAttribute
     * @generated
     */
    public Adapter createCustomAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.Function <em>Function</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.Function
     * @generated
     */
    public Adapter createFunctionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.FunctionClause <em>Function Clause</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.FunctionClause
     * @generated
     */
    public Adapter createFunctionClauseAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.Guard <em>Guard</em>}'. <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.Guard
     * @generated
     */
    public Adapter createGuardAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.Expressions <em>Expressions</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.Expressions
     * @generated
     */
    public Adapter createExpressionsAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.Expression <em>Expression</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.Expression
     * @generated
     */
    public Adapter createExpressionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.MacroCall <em>Macro Call</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.MacroCall
     * @generated
     */
    public Adapter createMacroCallAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.RecordExpr <em>Record Expr</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.RecordExpr
     * @generated
     */
    public Adapter createRecordExprAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.QueryExpr <em>Query Expr</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.QueryExpr
     * @generated
     */
    public Adapter createQueryExprAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.CondExpr <em>Cond Expr</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.CondExpr
     * @generated
     */
    public Adapter createCondExprAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.LetExpr <em>Let Expr</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.LetExpr
     * @generated
     */
    public Adapter createLetExprAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.RecordTuple <em>Record Tuple</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.RecordTuple
     * @generated
     */
    public Adapter createRecordTupleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.RecordFieldExpr <em>Record Field Expr</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.RecordFieldExpr
     * @generated
     */
    public Adapter createRecordFieldExprAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.StringLiteralPart <em>String Literal Part</em>}
     * '. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.StringLiteralPart
     * @generated
     */
    public Adapter createStringLiteralPartAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.IfExpr <em>If Expr</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.IfExpr
     * @generated
     */
    public Adapter createIfExprAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.IfClause <em>If Clause</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.IfClause
     * @generated
     */
    public Adapter createIfClauseAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.CaseExpr <em>Case Expr</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.CaseExpr
     * @generated
     */
    public Adapter createCaseExprAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.CrClause <em>Cr Clause</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.CrClause
     * @generated
     */
    public Adapter createCrClauseAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.ReceiveExpr <em>Receive Expr</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.ReceiveExpr
     * @generated
     */
    public Adapter createReceiveExprAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.FunExpr <em>Fun Expr</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.FunExpr
     * @generated
     */
    public Adapter createFunExprAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.FunRef <em>Fun Ref</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.FunRef
     * @generated
     */
    public Adapter createFunRefAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.TryExpr <em>Try Expr</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.TryExpr
     * @generated
     */
    public Adapter createTryExprAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.TryClause <em>Try Clause</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.TryClause
     * @generated
     */
    public Adapter createTryClauseAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.ErlList <em>Erl List</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.ErlList
     * @generated
     */
    public Adapter createErlListAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.ErlTuple <em>Erl Tuple</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.ErlTuple
     * @generated
     */
    public Adapter createErlTupleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.ErlBinary <em>Erl Binary</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.ErlBinary
     * @generated
     */
    public Adapter createErlBinaryAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.BinaryItem <em>Binary Item</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.BinaryItem
     * @generated
     */
    public Adapter createBinaryItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.BitType <em>Bit Type</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.BitType
     * @generated
     */
    public Adapter createBitTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.LCExpr <em>LC Expr</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.LCExpr
     * @generated
     */
    public Adapter createLCExprAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.TypeSig <em>Type Sig</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.TypeSig
     * @generated
     */
    public Adapter createTypeSigAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.FunType <em>Fun Type</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.FunType
     * @generated
     */
    public Adapter createFunTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.TypeGuards <em>Type Guards</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.TypeGuards
     * @generated
     */
    public Adapter createTypeGuardsAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.TypeGuard <em>Type Guard</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.TypeGuard
     * @generated
     */
    public Adapter createTypeGuardAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.TopType <em>Top Type</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.TopType
     * @generated
     */
    public Adapter createTopTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.Type100 <em>Type100</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.Type100
     * @generated
     */
    public Adapter createType100Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.Type200 <em>Type200</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.Type200
     * @generated
     */
    public Adapter createType200Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.Type300 <em>Type300</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.Type300
     * @generated
     */
    public Adapter createType300Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.Type400 <em>Type400</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.Type400
     * @generated
     */
    public Adapter createType400Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.Type500 <em>Type500</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.Type500
     * @generated
     */
    public Adapter createType500Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.Type <em>Type</em>}'. <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.Type
     * @generated
     */
    public Adapter createTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.FieldType <em>Field Type</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.FieldType
     * @generated
     */
    public Adapter createFieldTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.BinaryType <em>Binary Type</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.BinaryType
     * @generated
     */
    public Adapter createBinaryTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.BinBaseType <em>Bin Base Type</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.BinBaseType
     * @generated
     */
    public Adapter createBinBaseTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.BinUnitType <em>Bin Unit Type</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.BinUnitType
     * @generated
     */
    public Adapter createBinUnitTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.FunType100 <em>Fun Type100</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.FunType100
     * @generated
     */
    public Adapter createFunType100Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.MacroForm <em>Macro Form</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.MacroForm
     * @generated
     */
    public Adapter createMacroFormAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.CatchExpr <em>Catch Expr</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.CatchExpr
     * @generated
     */
    public Adapter createCatchExprAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.MatchExpr <em>Match Expr</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.MatchExpr
     * @generated
     */
    public Adapter createMatchExprAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.BinOp <em>Bin Op</em>}'. <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.BinOp
     * @generated
     */
    public Adapter createBinOpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.AddOp <em>Add Op</em>}'. <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.AddOp
     * @generated
     */
    public Adapter createAddOpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.MultOp <em>Mult Op</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.MultOp
     * @generated
     */
    public Adapter createMultOpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.UnaryExpr <em>Unary Expr</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.UnaryExpr
     * @generated
     */
    public Adapter createUnaryExprAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.FunCall <em>Fun Call</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.FunCall
     * @generated
     */
    public Adapter createFunCallAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.RemoteTarget <em>Remote Target</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.RemoteTarget
     * @generated
     */
    public Adapter createRemoteTargetAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.BlockExpr <em>Block Expr</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.BlockExpr
     * @generated
     */
    public Adapter createBlockExprAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.Atom <em>Atom</em>}'. <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.Atom
     * @generated
     */
    public Adapter createAtomAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.ErlChar <em>Erl Char</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.ErlChar
     * @generated
     */
    public Adapter createErlCharAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.AtomRef <em>Atom Ref</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.AtomRef
     * @generated
     */
    public Adapter createAtomRefAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.Macro <em>Macro</em>}'. <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.Macro
     * @generated
     */
    public Adapter createMacroAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.Variable <em>Variable</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.Variable
     * @generated
     */
    public Adapter createVariableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.ErlFloat <em>Erl Float</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.ErlFloat
     * @generated
     */
    public Adapter createErlFloatAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.ErlInteger <em>Erl Integer</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.ErlInteger
     * @generated
     */
    public Adapter createErlIntegerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.ListComprehension <em>List Comprehension</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.ListComprehension
     * @generated
     */
    public Adapter createListComprehensionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.BinaryComprehension
     * <em>Binary Comprehension</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's
     * useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.BinaryComprehension
     * @generated
     */
    public Adapter createBinaryComprehensionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.UnaryType <em>Unary Type</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.UnaryType
     * @generated
     */
    public Adapter createUnaryTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.RemoteType <em>Remote Type</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.RemoteType
     * @generated
     */
    public Adapter createRemoteTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.ListType <em>List Type</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.ListType
     * @generated
     */
    public Adapter createListTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.TupleType <em>Tuple Type</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.TupleType
     * @generated
     */
    public Adapter createTupleTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.RecordType <em>Record Type</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.RecordType
     * @generated
     */
    public Adapter createRecordTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.erlide.erlang.FunTypeList <em>Fun Type List</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.erlide.erlang.FunTypeList
     * @generated
     */
    public Adapter createFunTypeListAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This
     * default implementation returns null. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // ErlangAdapterFactory
