/**
 */
package org.erlide.erlang.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * 
 * @see org.erlide.erlang.ErlangPackage
 * @generated
 */
public class ErlangSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static ErlangPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public ErlangSwitch() {
        if (modelPackage == null) {
            modelPackage = ErlangPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param ePackage
     *            the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(final EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns
     * a non null result; it yields that result. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code>
     *         call.
     * @generated
     */
    @Override
    protected T doSwitch(final int classifierID, final EObject theEObject) {
        switch (classifierID) {
        case ErlangPackage.MODULE: {
            final Module module = (Module) theEObject;
            T result = caseModule(module);
            if (result == null) {
                result = caseAtomRefTarget(module);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.ATOM_REF_TARGET: {
            final AtomRefTarget atomRefTarget = (AtomRefTarget) theEObject;
            T result = caseAtomRefTarget(atomRefTarget);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.FORM: {
            final Form form = (Form) theEObject;
            T result = caseForm(form);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.CONDITIONAL_FORM_BLOCK: {
            final ConditionalFormBlock conditionalFormBlock = (ConditionalFormBlock) theEObject;
            T result = caseConditionalFormBlock(conditionalFormBlock);
            if (result == null) {
                result = caseForm(conditionalFormBlock);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.ATTRIBUTE: {
            final Attribute attribute = (Attribute) theEObject;
            T result = caseAttribute(attribute);
            if (result == null) {
                result = caseForm(attribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.CONDITIONAL_ATTRIBUTE: {
            final ConditionalAttribute conditionalAttribute = (ConditionalAttribute) theEObject;
            T result = caseConditionalAttribute(conditionalAttribute);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.ABSTRACT_DEFINE_ATTRIBUTE: {
            final AbstractDefineAttribute abstractDefineAttribute = (AbstractDefineAttribute) theEObject;
            T result = caseAbstractDefineAttribute(abstractDefineAttribute);
            if (result == null) {
                result = caseAttribute(abstractDefineAttribute);
            }
            if (result == null) {
                result = caseForm(abstractDefineAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.DEFINE_ATTRIBUTE: {
            final DefineAttribute defineAttribute = (DefineAttribute) theEObject;
            T result = caseDefineAttribute(defineAttribute);
            if (result == null) {
                result = caseAbstractDefineAttribute(defineAttribute);
            }
            if (result == null) {
                result = caseAttribute(defineAttribute);
            }
            if (result == null) {
                result = caseForm(defineAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.UNDEF_ATTRIBUTE: {
            final UndefAttribute undefAttribute = (UndefAttribute) theEObject;
            T result = caseUndefAttribute(undefAttribute);
            if (result == null) {
                result = caseAbstractDefineAttribute(undefAttribute);
            }
            if (result == null) {
                result = caseAttribute(undefAttribute);
            }
            if (result == null) {
                result = caseForm(undefAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.IFDEF_ATTRIBUTE: {
            final IfdefAttribute ifdefAttribute = (IfdefAttribute) theEObject;
            T result = caseIfdefAttribute(ifdefAttribute);
            if (result == null) {
                result = caseConditionalAttribute(ifdefAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.ELSE_ATTRIBUTE: {
            final ElseAttribute elseAttribute = (ElseAttribute) theEObject;
            T result = caseElseAttribute(elseAttribute);
            if (result == null) {
                result = caseConditionalAttribute(elseAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.ENDIF_ATTRIBUTE: {
            final EndifAttribute endifAttribute = (EndifAttribute) theEObject;
            T result = caseEndifAttribute(endifAttribute);
            if (result == null) {
                result = caseConditionalAttribute(endifAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.ABSTRACT_INCLUDE_ATTRIBUTE: {
            final AbstractIncludeAttribute abstractIncludeAttribute = (AbstractIncludeAttribute) theEObject;
            T result = caseAbstractIncludeAttribute(abstractIncludeAttribute);
            if (result == null) {
                result = caseAttribute(abstractIncludeAttribute);
            }
            if (result == null) {
                result = caseForm(abstractIncludeAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.INCLUDE_ATTRIBUTE: {
            final IncludeAttribute includeAttribute = (IncludeAttribute) theEObject;
            T result = caseIncludeAttribute(includeAttribute);
            if (result == null) {
                result = caseAbstractIncludeAttribute(includeAttribute);
            }
            if (result == null) {
                result = caseAttribute(includeAttribute);
            }
            if (result == null) {
                result = caseForm(includeAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.INCLUDE_LIB_ATTRIBUTE: {
            final IncludeLibAttribute includeLibAttribute = (IncludeLibAttribute) theEObject;
            T result = caseIncludeLibAttribute(includeLibAttribute);
            if (result == null) {
                result = caseAbstractIncludeAttribute(includeLibAttribute);
            }
            if (result == null) {
                result = caseAttribute(includeLibAttribute);
            }
            if (result == null) {
                result = caseForm(includeLibAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.FILE_ATTRIBUTE: {
            final FileAttribute fileAttribute = (FileAttribute) theEObject;
            T result = caseFileAttribute(fileAttribute);
            if (result == null) {
                result = caseAttribute(fileAttribute);
            }
            if (result == null) {
                result = caseForm(fileAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.MODULE_ATTRIBUTE: {
            final ModuleAttribute moduleAttribute = (ModuleAttribute) theEObject;
            T result = caseModuleAttribute(moduleAttribute);
            if (result == null) {
                result = caseAttribute(moduleAttribute);
            }
            if (result == null) {
                result = caseForm(moduleAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.ENCODING_ATTRIBUTE: {
            final EncodingAttribute encodingAttribute = (EncodingAttribute) theEObject;
            T result = caseEncodingAttribute(encodingAttribute);
            if (result == null) {
                result = caseAttribute(encodingAttribute);
            }
            if (result == null) {
                result = caseForm(encodingAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.RECORD_ATTRIBUTE: {
            final RecordAttribute recordAttribute = (RecordAttribute) theEObject;
            T result = caseRecordAttribute(recordAttribute);
            if (result == null) {
                result = caseAtomRefTarget(recordAttribute);
            }
            if (result == null) {
                result = caseAttribute(recordAttribute);
            }
            if (result == null) {
                result = caseForm(recordAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.RECORD_FIELD_DEF: {
            final RecordFieldDef recordFieldDef = (RecordFieldDef) theEObject;
            T result = caseRecordFieldDef(recordFieldDef);
            if (result == null) {
                result = caseAtomRefTarget(recordFieldDef);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.EXPORT_ATTRIBUTE: {
            final ExportAttribute exportAttribute = (ExportAttribute) theEObject;
            T result = caseExportAttribute(exportAttribute);
            if (result == null) {
                result = caseAttribute(exportAttribute);
            }
            if (result == null) {
                result = caseForm(exportAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.IMPORT_ATTRIBUTE: {
            final ImportAttribute importAttribute = (ImportAttribute) theEObject;
            T result = caseImportAttribute(importAttribute);
            if (result == null) {
                result = caseAttribute(importAttribute);
            }
            if (result == null) {
                result = caseForm(importAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.COMPILE_ATTRIBUTE: {
            final CompileAttribute compileAttribute = (CompileAttribute) theEObject;
            T result = caseCompileAttribute(compileAttribute);
            if (result == null) {
                result = caseAttribute(compileAttribute);
            }
            if (result == null) {
                result = caseForm(compileAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.ABSTRACT_TYPE_ATTRIBUTE: {
            final AbstractTypeAttribute abstractTypeAttribute = (AbstractTypeAttribute) theEObject;
            T result = caseAbstractTypeAttribute(abstractTypeAttribute);
            if (result == null) {
                result = caseAttribute(abstractTypeAttribute);
            }
            if (result == null) {
                result = caseForm(abstractTypeAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.SPEC_ATTRIBUTE: {
            final SpecAttribute specAttribute = (SpecAttribute) theEObject;
            T result = caseSpecAttribute(specAttribute);
            if (result == null) {
                result = caseAbstractTypeAttribute(specAttribute);
            }
            if (result == null) {
                result = caseAttribute(specAttribute);
            }
            if (result == null) {
                result = caseForm(specAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.TYPE_ATTRIBUTE: {
            final TypeAttribute typeAttribute = (TypeAttribute) theEObject;
            T result = caseTypeAttribute(typeAttribute);
            if (result == null) {
                result = caseAtomRefTarget(typeAttribute);
            }
            if (result == null) {
                result = caseAbstractTypeAttribute(typeAttribute);
            }
            if (result == null) {
                result = caseAttribute(typeAttribute);
            }
            if (result == null) {
                result = caseForm(typeAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.CUSTOM_ATTRIBUTE: {
            final CustomAttribute customAttribute = (CustomAttribute) theEObject;
            T result = caseCustomAttribute(customAttribute);
            if (result == null) {
                result = caseAttribute(customAttribute);
            }
            if (result == null) {
                result = caseForm(customAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.FUNCTION: {
            final Function function = (Function) theEObject;
            T result = caseFunction(function);
            if (result == null) {
                result = caseAtomRefTarget(function);
            }
            if (result == null) {
                result = caseForm(function);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.FUNCTION_CLAUSE: {
            final FunctionClause functionClause = (FunctionClause) theEObject;
            T result = caseFunctionClause(functionClause);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.GUARD: {
            final Guard guard = (Guard) theEObject;
            T result = caseGuard(guard);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.EXPRESSIONS: {
            final Expressions expressions = (Expressions) theEObject;
            T result = caseExpressions(expressions);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.EXPRESSION: {
            final Expression expression = (Expression) theEObject;
            T result = caseExpression(expression);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.MACRO_CALL: {
            final MacroCall macroCall = (MacroCall) theEObject;
            T result = caseMacroCall(macroCall);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.RECORD_EXPR: {
            final RecordExpr recordExpr = (RecordExpr) theEObject;
            T result = caseRecordExpr(recordExpr);
            if (result == null) {
                result = caseExpression(recordExpr);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.QUERY_EXPR: {
            final QueryExpr queryExpr = (QueryExpr) theEObject;
            T result = caseQueryExpr(queryExpr);
            if (result == null) {
                result = caseExpression(queryExpr);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.COND_EXPR: {
            final CondExpr condExpr = (CondExpr) theEObject;
            T result = caseCondExpr(condExpr);
            if (result == null) {
                result = caseExpression(condExpr);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.LET_EXPR: {
            final LetExpr letExpr = (LetExpr) theEObject;
            T result = caseLetExpr(letExpr);
            if (result == null) {
                result = caseExpression(letExpr);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.RECORD_TUPLE: {
            final RecordTuple recordTuple = (RecordTuple) theEObject;
            T result = caseRecordTuple(recordTuple);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.RECORD_FIELD_EXPR: {
            final RecordFieldExpr recordFieldExpr = (RecordFieldExpr) theEObject;
            T result = caseRecordFieldExpr(recordFieldExpr);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.STRING_LITERAL_PART: {
            final StringLiteralPart stringLiteralPart = (StringLiteralPart) theEObject;
            T result = caseStringLiteralPart(stringLiteralPart);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.IF_EXPR: {
            final IfExpr ifExpr = (IfExpr) theEObject;
            T result = caseIfExpr(ifExpr);
            if (result == null) {
                result = caseExpression(ifExpr);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.IF_CLAUSE: {
            final IfClause ifClause = (IfClause) theEObject;
            T result = caseIfClause(ifClause);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.CASE_EXPR: {
            final CaseExpr caseExpr = (CaseExpr) theEObject;
            T result = caseCaseExpr(caseExpr);
            if (result == null) {
                result = caseExpression(caseExpr);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.CR_CLAUSE: {
            final CrClause crClause = (CrClause) theEObject;
            T result = caseCrClause(crClause);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.RECEIVE_EXPR: {
            final ReceiveExpr receiveExpr = (ReceiveExpr) theEObject;
            T result = caseReceiveExpr(receiveExpr);
            if (result == null) {
                result = caseExpression(receiveExpr);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.FUN_EXPR: {
            final FunExpr funExpr = (FunExpr) theEObject;
            T result = caseFunExpr(funExpr);
            if (result == null) {
                result = caseExpression(funExpr);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.FUN_REF: {
            final FunRef funRef = (FunRef) theEObject;
            T result = caseFunRef(funRef);
            if (result == null) {
                result = caseFunExpr(funRef);
            }
            if (result == null) {
                result = caseExpression(funRef);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.TRY_EXPR: {
            final TryExpr tryExpr = (TryExpr) theEObject;
            T result = caseTryExpr(tryExpr);
            if (result == null) {
                result = caseExpression(tryExpr);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.TRY_CLAUSE: {
            final TryClause tryClause = (TryClause) theEObject;
            T result = caseTryClause(tryClause);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.ERL_LIST: {
            final ErlList erlList = (ErlList) theEObject;
            T result = caseErlList(erlList);
            if (result == null) {
                result = caseExpression(erlList);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.ERL_TUPLE: {
            final ErlTuple erlTuple = (ErlTuple) theEObject;
            T result = caseErlTuple(erlTuple);
            if (result == null) {
                result = caseExpression(erlTuple);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.ERL_BINARY: {
            final ErlBinary erlBinary = (ErlBinary) theEObject;
            T result = caseErlBinary(erlBinary);
            if (result == null) {
                result = caseExpression(erlBinary);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.BINARY_ITEM: {
            final BinaryItem binaryItem = (BinaryItem) theEObject;
            T result = caseBinaryItem(binaryItem);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.BIT_TYPE: {
            final BitType bitType = (BitType) theEObject;
            T result = caseBitType(bitType);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.LC_EXPR: {
            final LCExpr lcExpr = (LCExpr) theEObject;
            T result = caseLCExpr(lcExpr);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.TYPE_SIG: {
            final TypeSig typeSig = (TypeSig) theEObject;
            T result = caseTypeSig(typeSig);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.FUN_TYPE: {
            final FunType funType = (FunType) theEObject;
            T result = caseFunType(funType);
            if (result == null) {
                result = caseType(funType);
            }
            if (result == null) {
                result = caseType500(funType);
            }
            if (result == null) {
                result = caseType400(funType);
            }
            if (result == null) {
                result = caseType300(funType);
            }
            if (result == null) {
                result = caseType200(funType);
            }
            if (result == null) {
                result = caseType100(funType);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.TYPE_GUARDS: {
            final TypeGuards typeGuards = (TypeGuards) theEObject;
            T result = caseTypeGuards(typeGuards);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.TYPE_GUARD: {
            final TypeGuard typeGuard = (TypeGuard) theEObject;
            T result = caseTypeGuard(typeGuard);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.TOP_TYPE: {
            final TopType topType = (TopType) theEObject;
            T result = caseTopType(topType);
            if (result == null) {
                result = caseType(topType);
            }
            if (result == null) {
                result = caseType100(topType);
            }
            if (result == null) {
                result = caseType200(topType);
            }
            if (result == null) {
                result = caseType300(topType);
            }
            if (result == null) {
                result = caseType500(topType);
            }
            if (result == null) {
                result = caseType400(topType);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.TYPE100: {
            final Type100 type100 = (Type100) theEObject;
            T result = caseType100(type100);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.TYPE200: {
            final Type200 type200 = (Type200) theEObject;
            T result = caseType200(type200);
            if (result == null) {
                result = caseType100(type200);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.TYPE300: {
            final Type300 type300 = (Type300) theEObject;
            T result = caseType300(type300);
            if (result == null) {
                result = caseType200(type300);
            }
            if (result == null) {
                result = caseType100(type300);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.TYPE400: {
            final Type400 type400 = (Type400) theEObject;
            T result = caseType400(type400);
            if (result == null) {
                result = caseType300(type400);
            }
            if (result == null) {
                result = caseType200(type400);
            }
            if (result == null) {
                result = caseType100(type400);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.TYPE500: {
            final Type500 type500 = (Type500) theEObject;
            T result = caseType500(type500);
            if (result == null) {
                result = caseType400(type500);
            }
            if (result == null) {
                result = caseType300(type500);
            }
            if (result == null) {
                result = caseType200(type500);
            }
            if (result == null) {
                result = caseType100(type500);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.TYPE: {
            final Type type = (Type) theEObject;
            T result = caseType(type);
            if (result == null) {
                result = caseType500(type);
            }
            if (result == null) {
                result = caseType400(type);
            }
            if (result == null) {
                result = caseType300(type);
            }
            if (result == null) {
                result = caseType200(type);
            }
            if (result == null) {
                result = caseType100(type);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.FIELD_TYPE: {
            final FieldType fieldType = (FieldType) theEObject;
            T result = caseFieldType(fieldType);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.BINARY_TYPE: {
            final BinaryType binaryType = (BinaryType) theEObject;
            T result = caseBinaryType(binaryType);
            if (result == null) {
                result = caseType(binaryType);
            }
            if (result == null) {
                result = caseType500(binaryType);
            }
            if (result == null) {
                result = caseType400(binaryType);
            }
            if (result == null) {
                result = caseType300(binaryType);
            }
            if (result == null) {
                result = caseType200(binaryType);
            }
            if (result == null) {
                result = caseType100(binaryType);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.BIN_BASE_TYPE: {
            final BinBaseType binBaseType = (BinBaseType) theEObject;
            T result = caseBinBaseType(binBaseType);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.BIN_UNIT_TYPE: {
            final BinUnitType binUnitType = (BinUnitType) theEObject;
            T result = caseBinUnitType(binUnitType);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.FUN_TYPE100: {
            final FunType100 funType100 = (FunType100) theEObject;
            T result = caseFunType100(funType100);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.MACRO_FORM: {
            final MacroForm macroForm = (MacroForm) theEObject;
            T result = caseMacroForm(macroForm);
            if (result == null) {
                result = caseForm(macroForm);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.CATCH_EXPR: {
            final CatchExpr catchExpr = (CatchExpr) theEObject;
            T result = caseCatchExpr(catchExpr);
            if (result == null) {
                result = caseExpression(catchExpr);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.MATCH_EXPR: {
            final MatchExpr matchExpr = (MatchExpr) theEObject;
            T result = caseMatchExpr(matchExpr);
            if (result == null) {
                result = caseExpression(matchExpr);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.BIN_OP: {
            final BinOp binOp = (BinOp) theEObject;
            T result = caseBinOp(binOp);
            if (result == null) {
                result = caseExpression(binOp);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.ADD_OP: {
            final AddOp addOp = (AddOp) theEObject;
            T result = caseAddOp(addOp);
            if (result == null) {
                result = caseExpression(addOp);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.MULT_OP: {
            final MultOp multOp = (MultOp) theEObject;
            T result = caseMultOp(multOp);
            if (result == null) {
                result = caseExpression(multOp);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.UNARY_EXPR: {
            final UnaryExpr unaryExpr = (UnaryExpr) theEObject;
            T result = caseUnaryExpr(unaryExpr);
            if (result == null) {
                result = caseExpression(unaryExpr);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.FUN_CALL: {
            final FunCall funCall = (FunCall) theEObject;
            T result = caseFunCall(funCall);
            if (result == null) {
                result = caseExpression(funCall);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.REMOTE_TARGET: {
            final RemoteTarget remoteTarget = (RemoteTarget) theEObject;
            T result = caseRemoteTarget(remoteTarget);
            if (result == null) {
                result = caseExpression(remoteTarget);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.BLOCK_EXPR: {
            final BlockExpr blockExpr = (BlockExpr) theEObject;
            T result = caseBlockExpr(blockExpr);
            if (result == null) {
                result = caseExpression(blockExpr);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.ATOM: {
            final Atom atom = (Atom) theEObject;
            T result = caseAtom(atom);
            if (result == null) {
                result = caseExpression(atom);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.ERL_CHAR: {
            final ErlChar erlChar = (ErlChar) theEObject;
            T result = caseErlChar(erlChar);
            if (result == null) {
                result = caseExpression(erlChar);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.ATOM_REF: {
            final AtomRef atomRef = (AtomRef) theEObject;
            T result = caseAtomRef(atomRef);
            if (result == null) {
                result = caseExpression(atomRef);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.MACRO: {
            final Macro macro = (Macro) theEObject;
            T result = caseMacro(macro);
            if (result == null) {
                result = caseExpression(macro);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.VARIABLE: {
            final Variable variable = (Variable) theEObject;
            T result = caseVariable(variable);
            if (result == null) {
                result = caseExpression(variable);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.ERL_FLOAT: {
            final ErlFloat erlFloat = (ErlFloat) theEObject;
            T result = caseErlFloat(erlFloat);
            if (result == null) {
                result = caseExpression(erlFloat);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.ERL_INTEGER: {
            final ErlInteger erlInteger = (ErlInteger) theEObject;
            T result = caseErlInteger(erlInteger);
            if (result == null) {
                result = caseExpression(erlInteger);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.LIST_COMPREHENSION: {
            final ListComprehension listComprehension = (ListComprehension) theEObject;
            T result = caseListComprehension(listComprehension);
            if (result == null) {
                result = caseErlList(listComprehension);
            }
            if (result == null) {
                result = caseExpression(listComprehension);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.BINARY_COMPREHENSION: {
            final BinaryComprehension binaryComprehension = (BinaryComprehension) theEObject;
            T result = caseBinaryComprehension(binaryComprehension);
            if (result == null) {
                result = caseErlBinary(binaryComprehension);
            }
            if (result == null) {
                result = caseExpression(binaryComprehension);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.UNARY_TYPE: {
            final UnaryType unaryType = (UnaryType) theEObject;
            T result = caseUnaryType(unaryType);
            if (result == null) {
                result = caseType500(unaryType);
            }
            if (result == null) {
                result = caseType400(unaryType);
            }
            if (result == null) {
                result = caseType300(unaryType);
            }
            if (result == null) {
                result = caseType200(unaryType);
            }
            if (result == null) {
                result = caseType100(unaryType);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.REMOTE_TYPE: {
            final RemoteType remoteType = (RemoteType) theEObject;
            T result = caseRemoteType(remoteType);
            if (result == null) {
                result = caseType(remoteType);
            }
            if (result == null) {
                result = caseType500(remoteType);
            }
            if (result == null) {
                result = caseType400(remoteType);
            }
            if (result == null) {
                result = caseType300(remoteType);
            }
            if (result == null) {
                result = caseType200(remoteType);
            }
            if (result == null) {
                result = caseType100(remoteType);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.LIST_TYPE: {
            final ListType listType = (ListType) theEObject;
            T result = caseListType(listType);
            if (result == null) {
                result = caseType(listType);
            }
            if (result == null) {
                result = caseType500(listType);
            }
            if (result == null) {
                result = caseType400(listType);
            }
            if (result == null) {
                result = caseType300(listType);
            }
            if (result == null) {
                result = caseType200(listType);
            }
            if (result == null) {
                result = caseType100(listType);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.TUPLE_TYPE: {
            final TupleType tupleType = (TupleType) theEObject;
            T result = caseTupleType(tupleType);
            if (result == null) {
                result = caseType(tupleType);
            }
            if (result == null) {
                result = caseType500(tupleType);
            }
            if (result == null) {
                result = caseType400(tupleType);
            }
            if (result == null) {
                result = caseType300(tupleType);
            }
            if (result == null) {
                result = caseType200(tupleType);
            }
            if (result == null) {
                result = caseType100(tupleType);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.RECORD_TYPE: {
            final RecordType recordType = (RecordType) theEObject;
            T result = caseRecordType(recordType);
            if (result == null) {
                result = caseType(recordType);
            }
            if (result == null) {
                result = caseType500(recordType);
            }
            if (result == null) {
                result = caseType400(recordType);
            }
            if (result == null) {
                result = caseType300(recordType);
            }
            if (result == null) {
                result = caseType200(recordType);
            }
            if (result == null) {
                result = caseType100(recordType);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ErlangPackage.FUN_TYPE_LIST: {
            final FunTypeList funTypeList = (FunTypeList) theEObject;
            T result = caseFunTypeList(funTypeList);
            if (result == null) {
                result = caseFunType100(funTypeList);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Module</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModule(final Module object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Atom Ref Target</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Atom Ref Target</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAtomRefTarget(final AtomRefTarget object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Form</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Form</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseForm(final Form object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Conditional Form Block</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Conditional Form Block</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConditionalFormBlock(final ConditionalFormBlock object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Attribute</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAttribute(final Attribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Conditional Attribute</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Conditional Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConditionalAttribute(final ConditionalAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Abstract Define Attribute</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Abstract Define Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractDefineAttribute(final AbstractDefineAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Define Attribute</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Define Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDefineAttribute(final DefineAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Undef Attribute</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Undef Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUndefAttribute(final UndefAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Ifdef Attribute</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Ifdef Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIfdefAttribute(final IfdefAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Else Attribute</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Else Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseElseAttribute(final ElseAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Endif Attribute</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Endif Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEndifAttribute(final EndifAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Abstract Include Attribute</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Abstract Include Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractIncludeAttribute(final AbstractIncludeAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Include Attribute</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Include Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIncludeAttribute(final IncludeAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Include Lib Attribute</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Include Lib Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIncludeLibAttribute(final IncludeLibAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>File Attribute</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>File Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFileAttribute(final FileAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Module Attribute</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Module Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModuleAttribute(final ModuleAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Encoding Attribute</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Encoding Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEncodingAttribute(final EncodingAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Record Attribute</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Record Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRecordAttribute(final RecordAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Record Field Def</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Record Field Def</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRecordFieldDef(final RecordFieldDef object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Export Attribute</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Export Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExportAttribute(final ExportAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Import Attribute</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Import Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseImportAttribute(final ImportAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Compile Attribute</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Compile Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCompileAttribute(final CompileAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Abstract Type Attribute</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Abstract Type Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractTypeAttribute(final AbstractTypeAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Spec Attribute</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Spec Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSpecAttribute(final SpecAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Type Attribute</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Type Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypeAttribute(final TypeAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Custom Attribute</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Custom Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCustomAttribute(final CustomAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Function</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Function</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFunction(final Function object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Function Clause</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Function Clause</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFunctionClause(final FunctionClause object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Guard</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Guard</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGuard(final Guard object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Expressions</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Expressions</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExpressions(final Expressions object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Expression</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExpression(final Expression object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Macro Call</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Macro Call</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMacroCall(final MacroCall object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Record Expr</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Record Expr</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRecordExpr(final RecordExpr object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Query Expr</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Query Expr</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseQueryExpr(final QueryExpr object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Cond Expr</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Cond Expr</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCondExpr(final CondExpr object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Let Expr</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Let Expr</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLetExpr(final LetExpr object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Record Tuple</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Record Tuple</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRecordTuple(final RecordTuple object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Record Field Expr</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Record Field Expr</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRecordFieldExpr(final RecordFieldExpr object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>String Literal Part</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>String Literal Part</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStringLiteralPart(final StringLiteralPart object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>If Expr</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>If Expr</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIfExpr(final IfExpr object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>If Clause</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>If Clause</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIfClause(final IfClause object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Case Expr</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Case Expr</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCaseExpr(final CaseExpr object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Cr Clause</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Cr Clause</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCrClause(final CrClause object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Receive Expr</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Receive Expr</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseReceiveExpr(final ReceiveExpr object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Fun Expr</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Fun Expr</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFunExpr(final FunExpr object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Fun Ref</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Fun Ref</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFunRef(final FunRef object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Try Expr</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Try Expr</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTryExpr(final TryExpr object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Try Clause</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Try Clause</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTryClause(final TryClause object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Erl List</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Erl List</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseErlList(final ErlList object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Erl Tuple</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Erl Tuple</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseErlTuple(final ErlTuple object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Erl Binary</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Erl Binary</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseErlBinary(final ErlBinary object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Binary Item</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Binary Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBinaryItem(final BinaryItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Bit Type</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Bit Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBitType(final BitType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>LC Expr</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>LC Expr</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLCExpr(final LCExpr object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Type Sig</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Type Sig</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypeSig(final TypeSig object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Fun Type</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Fun Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFunType(final FunType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Type Guards</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Type Guards</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypeGuards(final TypeGuards object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Type Guard</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Type Guard</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypeGuard(final TypeGuard object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Top Type</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Top Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTopType(final TopType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Type100</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Type100</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseType100(final Type100 object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Type200</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Type200</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseType200(final Type200 object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Type300</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Type300</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseType300(final Type300 object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Type400</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Type400</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseType400(final Type400 object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Type500</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Type500</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseType500(final Type500 object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Type</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseType(final Type object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Field Type</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Field Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFieldType(final FieldType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Binary Type</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Binary Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBinaryType(final BinaryType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Bin Base Type</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Bin Base Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBinBaseType(final BinBaseType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Bin Unit Type</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Bin Unit Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBinUnitType(final BinUnitType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Fun Type100</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Fun Type100</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFunType100(final FunType100 object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Macro Form</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Macro Form</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMacroForm(final MacroForm object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Catch Expr</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Catch Expr</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCatchExpr(final CatchExpr object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Match Expr</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Match Expr</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMatchExpr(final MatchExpr object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Bin Op</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Bin Op</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBinOp(final BinOp object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Add Op</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Add Op</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAddOp(final AddOp object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Mult Op</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Mult Op</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMultOp(final MultOp object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Unary Expr</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Unary Expr</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUnaryExpr(final UnaryExpr object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Fun Call</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Fun Call</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFunCall(final FunCall object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Remote Target</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Remote Target</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRemoteTarget(final RemoteTarget object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Block Expr</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Block Expr</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBlockExpr(final BlockExpr object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Atom</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Atom</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAtom(final Atom object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Erl Char</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Erl Char</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseErlChar(final ErlChar object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Atom Ref</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Atom Ref</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAtomRef(final AtomRef object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Macro</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Macro</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMacro(final Macro object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Variable</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Variable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVariable(final Variable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Erl Float</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Erl Float</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseErlFloat(final ErlFloat object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Erl Integer</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Erl Integer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseErlInteger(final ErlInteger object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>List Comprehension</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>List Comprehension</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseListComprehension(final ListComprehension object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Binary Comprehension</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Binary Comprehension</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBinaryComprehension(final BinaryComprehension object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Unary Type</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Unary Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUnaryType(final UnaryType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Remote Type</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Remote Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRemoteType(final RemoteType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>List Type</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>List Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseListType(final ListType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Tuple Type</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Tuple Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTupleType(final TupleType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Record Type</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Record Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRecordType(final RecordType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Fun Type List</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Fun Type List</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFunTypeList(final FunTypeList object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>EObject</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch, but this is
     * the last case anyway. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(final EObject object) {
        return null;
    }

} // ErlangSwitch
