package org.erlide.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.erlide.erlang.AddOp;
import org.erlide.erlang.Atom;
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
import org.erlide.erlang.ConditionalFormBlock;
import org.erlide.erlang.CrClause;
import org.erlide.erlang.CustomAttribute;
import org.erlide.erlang.DefineAttribute;
import org.erlide.erlang.ElseAttribute;
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
import org.erlide.erlang.FunCall;
import org.erlide.erlang.FunExpr;
import org.erlide.erlang.FunRef;
import org.erlide.erlang.FunType;
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
import org.erlide.erlang.SpecFun;
import org.erlide.erlang.StringLiteralPart;
import org.erlide.erlang.TopType;
import org.erlide.erlang.TryClause;
import org.erlide.erlang.TryExpr;
import org.erlide.erlang.TupleType;
import org.erlide.erlang.Type;
import org.erlide.erlang.TypeAttribute;
import org.erlide.erlang.TypeGuard;
import org.erlide.erlang.TypeGuards;
import org.erlide.erlang.TypeSig;
import org.erlide.erlang.UnaryExpr;
import org.erlide.erlang.UnaryType;
import org.erlide.erlang.UndefAttribute;
import org.erlide.erlang.Variable;
import org.erlide.services.ErlangGrammarAccess;

@SuppressWarnings("all")
public class ErlangSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ErlangGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ErlangPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ErlangPackage.ADD_OP:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_Expr400(context, (AddOp) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.ATOM:
				if(context == grammarAccess.getAtomRefLiteralRule() ||
				   context == grammarAccess.getAtomVarMacroRule() ||
				   context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionNoNumberRule() ||
				   context == grammarAccess.getPatternExpressionRule() ||
				   context == grammarAccess.getPatternExpressionAccess().getFunCallTargetAction_1_1_0() ||
				   context == grammarAccess.getPatternExpressionAccess().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getTermExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_AtomRefLiteral(context, (Atom) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.BIN_BASE_TYPE:
				if(context == grammarAccess.getBinBaseTypeRule()) {
					sequence_BinBaseType(context, (BinBaseType) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.BIN_OP:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_Expr100_Expr150_Expr160_Expr200_Expr300(context, (BinOp) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.BIN_UNIT_TYPE:
				if(context == grammarAccess.getBinUnitTypeRule()) {
					sequence_BinUnitType(context, (BinUnitType) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.BINARY_COMPREHENSION:
				if(context == grammarAccess.getBinaryComprehensionRule() ||
				   context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getPatternExpressionRule() ||
				   context == grammarAccess.getPatternExpressionAccess().getFunCallTargetAction_1_1_0() ||
				   context == grammarAccess.getPatternExpressionAccess().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getTermExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_BinaryComprehension(context, (BinaryComprehension) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.BINARY_ITEM:
				if(context == grammarAccess.getBinaryItemRule()) {
					sequence_BinaryItem(context, (BinaryItem) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.BINARY_TYPE:
				if(context == grammarAccess.getBinaryTypeRule() ||
				   context == grammarAccess.getTypeRule() ||
				   context == grammarAccess.getType100Rule() ||
				   context == grammarAccess.getType100Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType200Rule() ||
				   context == grammarAccess.getType200Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType300Rule() ||
				   context == grammarAccess.getType300Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType400Rule() ||
				   context == grammarAccess.getType400Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType500Rule()) {
					sequence_BinaryType(context, (BinaryType) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.BIT_TYPE:
				if(context == grammarAccess.getBitTypeRule()) {
					sequence_BitType(context, (BitType) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.BLOCK_EXPR:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_ExprMax(context, (BlockExpr) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.CASE_EXPR:
				if(context == grammarAccess.getCaseExprRule() ||
				   context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_CaseExpr(context, (CaseExpr) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.CATCH_EXPR:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_Expression(context, (CatchExpr) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.COMPILE_ATTRIBUTE:
				if(context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getCompileAttributeRule() ||
				   context == grammarAccess.getFormRule()) {
					sequence_CompileAttribute(context, (CompileAttribute) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.COND_EXPR:
				if(context == grammarAccess.getCondExprRule() ||
				   context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_CondExpr(context, (CondExpr) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.CONDITIONAL_FORM_BLOCK:
				if(context == grammarAccess.getConditionalFormBlockRule() ||
				   context == grammarAccess.getFormRule()) {
					sequence_ConditionalFormBlock(context, (ConditionalFormBlock) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.CR_CLAUSE:
				if(context == grammarAccess.getCrClauseRule()) {
					sequence_CrClause(context, (CrClause) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.CUSTOM_ATTRIBUTE:
				if(context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getCustomAttributeRule() ||
				   context == grammarAccess.getFormRule()) {
					sequence_CustomAttribute(context, (CustomAttribute) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.DEFINE_ATTRIBUTE:
				if(context == grammarAccess.getAbstractDefineAttributeRule() ||
				   context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getDefineAttributeRule() ||
				   context == grammarAccess.getFormRule()) {
					sequence_DefineAttribute(context, (DefineAttribute) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.ELSE_ATTRIBUTE:
				if(context == grammarAccess.getConditionalAttributeRule() ||
				   context == grammarAccess.getElseAttributeRule()) {
					sequence_ElseAttribute(context, (ElseAttribute) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.ENDIF_ATTRIBUTE:
				if(context == grammarAccess.getConditionalAttributeRule() ||
				   context == grammarAccess.getEndifAttributeRule()) {
					sequence_EndifAttribute(context, (EndifAttribute) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.ERL_BINARY:
				if(context == grammarAccess.getBinaryRule() ||
				   context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getPatternExpressionRule() ||
				   context == grammarAccess.getPatternExpressionAccess().getFunCallTargetAction_1_1_0() ||
				   context == grammarAccess.getPatternExpressionAccess().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getTermExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_Binary(context, (ErlBinary) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.ERL_CHAR:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionNoNumberRule() ||
				   context == grammarAccess.getPatternExpressionRule() ||
				   context == grammarAccess.getPatternExpressionAccess().getFunCallTargetAction_1_1_0() ||
				   context == grammarAccess.getPatternExpressionAccess().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getTermExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_LiteralExpressionNoNumber(context, (ErlChar) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.ERL_FLOAT:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionRule() ||
				   context == grammarAccess.getPatternExpressionRule() ||
				   context == grammarAccess.getPatternExpressionAccess().getFunCallTargetAction_1_1_0() ||
				   context == grammarAccess.getPatternExpressionAccess().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getTermExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_LiteralExpression(context, (ErlFloat) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.ERL_INTEGER:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIntVarMacroRule() ||
				   context == grammarAccess.getIntegerLiteralRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionRule() ||
				   context == grammarAccess.getPatternExpressionRule() ||
				   context == grammarAccess.getPatternExpressionAccess().getFunCallTargetAction_1_1_0() ||
				   context == grammarAccess.getPatternExpressionAccess().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getTermExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_IntegerLiteral(context, (ErlInteger) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.ERL_LIST:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getListRule() ||
				   context == grammarAccess.getPatternExpressionRule() ||
				   context == grammarAccess.getPatternExpressionAccess().getFunCallTargetAction_1_1_0() ||
				   context == grammarAccess.getPatternExpressionAccess().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getTermExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_List(context, (ErlList) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.ERL_TUPLE:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getPatternExpressionRule() ||
				   context == grammarAccess.getPatternExpressionAccess().getFunCallTargetAction_1_1_0() ||
				   context == grammarAccess.getPatternExpressionAccess().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getTermExpressionRule() ||
				   context == grammarAccess.getTupleRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_Tuple(context, (ErlTuple) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.EXPORT_ATTRIBUTE:
				if(context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getExportAttributeRule() ||
				   context == grammarAccess.getFormRule()) {
					sequence_ExportAttribute(context, (ExportAttribute) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.EXPRESSION:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionNoNumberRule() ||
				   context == grammarAccess.getPatternExpressionRule() ||
				   context == grammarAccess.getPatternExpressionAccess().getFunCallTargetAction_1_1_0() ||
				   context == grammarAccess.getPatternExpressionAccess().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getStringLiteralRule() ||
				   context == grammarAccess.getTermExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_StringLiteral(context, (Expression) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.EXPRESSIONS:
				if(context == grammarAccess.getExpressionsRule()) {
					sequence_Expressions(context, (Expressions) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.FIELD_TYPE:
				if(context == grammarAccess.getFieldTypeRule()) {
					sequence_FieldType(context, (FieldType) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.FILE_ATTRIBUTE:
				if(context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getFileAttributeRule() ||
				   context == grammarAccess.getFormRule()) {
					sequence_FileAttribute(context, (FileAttribute) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.FUN_CALL:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_Expr700(context, (FunCall) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPatternExpressionRule()) {
					sequence_PatternExpression(context, (FunCall) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.FUN_EXPR:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getFunExprRule() ||
				   context == grammarAccess.getInlineFunRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_InlineFun(context, (FunExpr) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.FUN_REF:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getFunExprRule() ||
				   context == grammarAccess.getFunRefRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_FunRef(context, (FunRef) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.FUN_TYPE:
				if(context == grammarAccess.getFunTypeRule()) {
					sequence_FunType(context, (FunType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeRule() ||
				   context == grammarAccess.getType100Rule() ||
				   context == grammarAccess.getType100Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType200Rule() ||
				   context == grammarAccess.getType200Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType300Rule() ||
				   context == grammarAccess.getType300Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType400Rule() ||
				   context == grammarAccess.getType400Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType500Rule()) {
					sequence_Type(context, (FunType) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.FUN_TYPE_LIST:
				if(context == grammarAccess.getFunType100Rule()) {
					sequence_FunType100(context, (FunTypeList) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.FUNCTION:
				if(context == grammarAccess.getAtomRefTargetRule() ||
				   context == grammarAccess.getFormRule() ||
				   context == grammarAccess.getFunctionRule()) {
					sequence_Function(context, (Function) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.FUNCTION_CLAUSE:
				if(context == grammarAccess.getFunctionClauseRule()) {
					sequence_FunctionClause(context, (FunctionClause) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.GUARD:
				if(context == grammarAccess.getGuardRule()) {
					sequence_Guard(context, (Guard) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.IF_CLAUSE:
				if(context == grammarAccess.getIfClauseRule()) {
					sequence_IfClause(context, (IfClause) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.IF_EXPR:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIfExprRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_IfExpr(context, (IfExpr) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.IFDEF_ATTRIBUTE:
				if(context == grammarAccess.getConditionalAttributeRule() ||
				   context == grammarAccess.getIfdefAttributeRule()) {
					sequence_IfdefAttribute(context, (IfdefAttribute) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.IMPORT_ATTRIBUTE:
				if(context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getFormRule() ||
				   context == grammarAccess.getImportAttributeRule()) {
					sequence_ImportAttribute(context, (ImportAttribute) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.INCLUDE_ATTRIBUTE:
				if(context == grammarAccess.getAbstractIncludeAttributeRule() ||
				   context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getFormRule() ||
				   context == grammarAccess.getIncludeAttributeRule()) {
					sequence_IncludeAttribute(context, (IncludeAttribute) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.INCLUDE_LIB_ATTRIBUTE:
				if(context == grammarAccess.getAbstractIncludeAttributeRule() ||
				   context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getFormRule() ||
				   context == grammarAccess.getIncludeLibAttributeRule()) {
					sequence_IncludeLibAttribute(context, (IncludeLibAttribute) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.LC_EXPR:
				if(context == grammarAccess.getLCExprRule()) {
					sequence_LCExpr(context, (LCExpr) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.LET_EXPR:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getLetExprRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_LetExpr(context, (LetExpr) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.LIST_COMPREHENSION:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getListComprehensionRule() ||
				   context == grammarAccess.getPatternExpressionRule() ||
				   context == grammarAccess.getPatternExpressionAccess().getFunCallTargetAction_1_1_0() ||
				   context == grammarAccess.getPatternExpressionAccess().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getTermExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_ListComprehension(context, (ListComprehension) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.LIST_TYPE:
				if(context == grammarAccess.getTypeRule() ||
				   context == grammarAccess.getType100Rule() ||
				   context == grammarAccess.getType100Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType200Rule() ||
				   context == grammarAccess.getType200Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType300Rule() ||
				   context == grammarAccess.getType300Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType400Rule() ||
				   context == grammarAccess.getType400Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType500Rule()) {
					sequence_Type(context, (ListType) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.MACRO:
				if(context == grammarAccess.getAtomVarMacroRule() ||
				   context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIntVarMacroRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionNoNumberRule() ||
				   context == grammarAccess.getMacroLiteralRule() ||
				   context == grammarAccess.getPatternExpressionRule() ||
				   context == grammarAccess.getPatternExpressionAccess().getFunCallTargetAction_1_1_0() ||
				   context == grammarAccess.getPatternExpressionAccess().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getTermExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_MacroLiteral(context, (Macro) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getMacroRefRule()) {
					sequence_MacroRef(context, (Macro) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.MACRO_CALL:
				if(context == grammarAccess.getMacroCallRule()) {
					sequence_MacroCall(context, (MacroCall) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.MACRO_FORM:
				if(context == grammarAccess.getFormRule()) {
					sequence_Form(context, (MacroForm) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.MATCH_EXPR:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_Expr100(context, (MatchExpr) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPatternExpressionRule() ||
				   context == grammarAccess.getPatternExpressionAccess().getMatchExprOpLeftAction_1_0_0()) {
					sequence_PatternExpression(context, (MatchExpr) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.MODULE:
				if(context == grammarAccess.getAtomRefTargetRule() ||
				   context == grammarAccess.getModuleRule()) {
					sequence_Module(context, (Module) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.MODULE_ATTRIBUTE:
				if(context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getFormRule() ||
				   context == grammarAccess.getModuleAttributeRule()) {
					sequence_ModuleAttribute(context, (ModuleAttribute) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.MULT_OP:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_Expr500(context, (MultOp) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.QUERY_EXPR:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getQueryExprRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_QueryExpr(context, (QueryExpr) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.RECEIVE_EXPR:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getReceiveExprRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_ReceiveExpr(context, (ReceiveExpr) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.RECORD_ATTRIBUTE:
				if(context == grammarAccess.getAtomRefTargetRule() ||
				   context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getFormRule() ||
				   context == grammarAccess.getRecordAttributeRule()) {
					sequence_RecordAttribute(context, (RecordAttribute) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.RECORD_EXPR:
				if(context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_Expr700_ExprMax_RecordExpr(context, (RecordExpr) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_Expr700_RecordExpr(context, (RecordExpr) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPatternExpressionRule() ||
				   context == grammarAccess.getPatternExpressionAccess().getFunCallTargetAction_1_1_0() ||
				   context == grammarAccess.getPatternExpressionAccess().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getRecordExprRule() ||
				   context == grammarAccess.getTermExpressionRule()) {
					sequence_RecordExpr(context, (RecordExpr) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.RECORD_FIELD_DEF:
				if(context == grammarAccess.getAtomRefTargetRule() ||
				   context == grammarAccess.getRecordFieldDefRule()) {
					sequence_RecordFieldDef(context, (RecordFieldDef) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.RECORD_FIELD_EXPR:
				if(context == grammarAccess.getRecordFieldExprRule()) {
					sequence_RecordFieldExpr(context, (RecordFieldExpr) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.RECORD_TUPLE:
				if(context == grammarAccess.getRecordTupleRule()) {
					sequence_RecordTuple(context, (RecordTuple) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.RECORD_TYPE:
				if(context == grammarAccess.getTypeRule() ||
				   context == grammarAccess.getType100Rule() ||
				   context == grammarAccess.getType100Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType200Rule() ||
				   context == grammarAccess.getType200Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType300Rule() ||
				   context == grammarAccess.getType300Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType400Rule() ||
				   context == grammarAccess.getType400Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType500Rule()) {
					sequence_Type(context, (RecordType) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.REMOTE_TARGET:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_Expr800(context, (RemoteTarget) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.REMOTE_TYPE:
				if(context == grammarAccess.getTypeRule() ||
				   context == grammarAccess.getType100Rule() ||
				   context == grammarAccess.getType100Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType200Rule() ||
				   context == grammarAccess.getType200Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType300Rule() ||
				   context == grammarAccess.getType300Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType400Rule() ||
				   context == grammarAccess.getType400Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType500Rule()) {
					sequence_Type(context, (RemoteType) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.SPEC_ATTRIBUTE:
				if(context == grammarAccess.getAbstractTypeAttributeRule() ||
				   context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getFormRule() ||
				   context == grammarAccess.getSpecAttributeRule()) {
					sequence_SpecAttribute(context, (SpecAttribute) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.SPEC_FUN:
				if(context == grammarAccess.getSpecFunRule()) {
					sequence_SpecFun(context, (SpecFun) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.STRING_LITERAL_PART:
				if(context == grammarAccess.getStringLiteralPartRule()) {
					sequence_StringLiteralPart(context, (StringLiteralPart) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.TOP_TYPE:
				if(context == grammarAccess.getTopTypeRule() ||
				   context == grammarAccess.getTypeRule() ||
				   context == grammarAccess.getType500Rule()) {
					sequence_TopType(context, (TopType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getType100Rule() ||
				   context == grammarAccess.getType100Access().getTopTypeLeftOperandAction_1_0_0_0()) {
					sequence_TopType_Type100_Type200_Type300_Type400(context, (TopType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getType200Rule() ||
				   context == grammarAccess.getType200Access().getTopTypeLeftOperandAction_1_0_0_0()) {
					sequence_TopType_Type200_Type300_Type400(context, (TopType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getType300Rule() ||
				   context == grammarAccess.getType300Access().getTopTypeLeftOperandAction_1_0_0_0()) {
					sequence_TopType_Type300_Type400(context, (TopType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getType400Rule() ||
				   context == grammarAccess.getType400Access().getTopTypeLeftOperandAction_1_0_0_0()) {
					sequence_TopType_Type400(context, (TopType) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.TRY_CLAUSE:
				if(context == grammarAccess.getTryClauseRule()) {
					sequence_TryClause(context, (TryClause) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.TRY_EXPR:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getTryExprRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_TryExpr(context, (TryExpr) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.TUPLE_TYPE:
				if(context == grammarAccess.getTypeRule() ||
				   context == grammarAccess.getType100Rule() ||
				   context == grammarAccess.getType100Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType200Rule() ||
				   context == grammarAccess.getType200Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType300Rule() ||
				   context == grammarAccess.getType300Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType400Rule() ||
				   context == grammarAccess.getType400Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType500Rule()) {
					sequence_Type(context, (TupleType) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.TYPE:
				if(context == grammarAccess.getTypeRule() ||
				   context == grammarAccess.getType100Rule() ||
				   context == grammarAccess.getType100Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType200Rule() ||
				   context == grammarAccess.getType200Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType300Rule() ||
				   context == grammarAccess.getType300Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType400Rule() ||
				   context == grammarAccess.getType400Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType500Rule()) {
					sequence_Type(context, (Type) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.TYPE_ATTRIBUTE:
				if(context == grammarAccess.getAbstractTypeAttributeRule() ||
				   context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getFormRule() ||
				   context == grammarAccess.getTypeAttributeRule()) {
					sequence_TypeAttribute(context, (TypeAttribute) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.TYPE_GUARD:
				if(context == grammarAccess.getTypeGuardRule()) {
					sequence_TypeGuard(context, (TypeGuard) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.TYPE_GUARDS:
				if(context == grammarAccess.getTypeGuardsRule()) {
					sequence_TypeGuards(context, (TypeGuards) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.TYPE_SIG:
				if(context == grammarAccess.getTypeSigRule()) {
					sequence_TypeSig(context, (TypeSig) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.UNARY_EXPR:
				if(context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_UnaryExpr(context, (UnaryExpr) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getUnaryExprMaxRule()) {
					sequence_UnaryExpr_UnaryExprMax(context, (UnaryExpr) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.UNARY_TYPE:
				if(context == grammarAccess.getType100Rule() ||
				   context == grammarAccess.getType100Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType200Rule() ||
				   context == grammarAccess.getType200Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType300Rule() ||
				   context == grammarAccess.getType300Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType400Rule() ||
				   context == grammarAccess.getType400Access().getTopTypeLeftOperandAction_1_0_0_0() ||
				   context == grammarAccess.getType500Rule()) {
					sequence_Type500(context, (UnaryType) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.UNDEF_ATTRIBUTE:
				if(context == grammarAccess.getAbstractDefineAttributeRule() ||
				   context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getFormRule() ||
				   context == grammarAccess.getUndefAttributeRule()) {
					sequence_UndefAttribute(context, (UndefAttribute) semanticObject); 
					return; 
				}
				else break;
			case ErlangPackage.VARIABLE:
				if(context == grammarAccess.getAtomVarMacroRule() ||
				   context == grammarAccess.getExpr100Rule() ||
				   context == grammarAccess.getExpr100Access().getBinOpOpLeftAction_1_1_0() ||
				   context == grammarAccess.getExpr100Access().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getExpr150Rule() ||
				   context == grammarAccess.getExpr150Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr160Rule() ||
				   context == grammarAccess.getExpr160Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr200Rule() ||
				   context == grammarAccess.getExpr200Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr300Rule() ||
				   context == grammarAccess.getExpr300Access().getBinOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr400Rule() ||
				   context == grammarAccess.getExpr400Access().getAddOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr500Rule() ||
				   context == grammarAccess.getExpr500Access().getMultOpOpLeftAction_1_0() ||
				   context == grammarAccess.getExpr700Rule() ||
				   context == grammarAccess.getExpr700Access().getFunCallTargetAction_1_0_1() ||
				   context == grammarAccess.getExpr700Access().getRecordExprRefAction_1_1_1() ||
				   context == grammarAccess.getExpr800Rule() ||
				   context == grammarAccess.getExpr800Access().getRemoteTargetModuleAction_1_0() ||
				   context == grammarAccess.getExprMaxRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIntVarMacroRule() ||
				   context == grammarAccess.getLExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionNoNumberRule() ||
				   context == grammarAccess.getPatternExpressionRule() ||
				   context == grammarAccess.getPatternExpressionAccess().getFunCallTargetAction_1_1_0() ||
				   context == grammarAccess.getPatternExpressionAccess().getMatchExprOpLeftAction_1_0_0() ||
				   context == grammarAccess.getTermExpressionRule() ||
				   context == grammarAccess.getUnaryExprRule() ||
				   context == grammarAccess.getUnaryExprMaxRule() ||
				   context == grammarAccess.getVariableLiteralRule()) {
					sequence_VariableLiteral(context, (Variable) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     value=[AtomRefTarget|NAME]
	 */
	protected void sequence_AtomRefLiteral(EObject context, Atom semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=VARIABLE type=Type)
	 */
	protected void sequence_BinBaseType(EObject context, BinBaseType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.BIN_BASE_TYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.BIN_BASE_TYPE__NAME));
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.BIN_BASE_TYPE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.BIN_BASE_TYPE__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBinBaseTypeAccess().getNameVARIABLETerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getBinBaseTypeAccess().getTypeTypeParserRuleCall_2_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=VARIABLE m=VARIABLE type=Type)
	 */
	protected void sequence_BinUnitType(EObject context, BinUnitType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.BIN_UNIT_TYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.BIN_UNIT_TYPE__NAME));
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.BIN_UNIT_TYPE__M) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.BIN_UNIT_TYPE__M));
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.BIN_UNIT_TYPE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.BIN_UNIT_TYPE__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBinUnitTypeAccess().getNameVARIABLETerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getBinUnitTypeAccess().getMVARIABLETerminalRuleCall_2_0(), semanticObject.getM());
		feeder.accept(grammarAccess.getBinUnitTypeAccess().getTypeTypeParserRuleCall_4_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (expr=TermExpression generators+=LCExpr generators+=LCExpr*)
	 */
	protected void sequence_BinaryComprehension(EObject context, BinaryComprehension semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expr=UnaryExprMax size=ExprMax? (types+=BitType type+=BitType*)?)
	 */
	protected void sequence_BinaryItem(EObject context, BinaryItem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (((type+=BinBaseType type+=BinUnitType?) | type+=BinUnitType)?)
	 */
	protected void sequence_BinaryType(EObject context, BinaryType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {ErlBinary}
	 */
	protected void sequence_Binary(EObject context, ErlBinary semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=NAME size=INT?)
	 */
	protected void sequence_BitType(EObject context, BitType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expr=Expression clauses+=CrClause clauses+=CrClause*)
	 */
	protected void sequence_CaseExpr(EObject context, CaseExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tag='compile' options=Expression)
	 */
	protected void sequence_CompileAttribute(EObject context, CompileAttribute semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.COMPILE_ATTRIBUTE__TAG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.COMPILE_ATTRIBUTE__TAG));
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.COMPILE_ATTRIBUTE__OPTIONS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.COMPILE_ATTRIBUTE__OPTIONS));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCompileAttributeAccess().getTagCompileKeyword_1_0(), semanticObject.getTag());
		feeder.accept(grammarAccess.getCompileAttributeAccess().getOptionsExpressionParserRuleCall_3_0(), semanticObject.getOptions());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {CondExpr}
	 */
	protected void sequence_CondExpr(EObject context, CondExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (condition=IfdefAttribute ifForms+=Form* (hasElse?=ElseAttribute elseForms+=Form*)? end=EndifAttribute)
	 */
	protected void sequence_ConditionalFormBlock(EObject context, ConditionalFormBlock semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expr=Expression guard=Guard? body+=LExpression body+=LExpression*)
	 */
	protected void sequence_CrClause(EObject context, CrClause semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tag=ATOM (value+=Expression value+=Expression*)?)
	 */
	protected void sequence_CustomAttribute(EObject context, CustomAttribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tag='define' macroName=NAMEVAR (args+=PatternExpression args+=PatternExpression*)? value=Guard?)
	 */
	protected void sequence_DefineAttribute(EObject context, DefineAttribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     tag='else'
	 */
	protected void sequence_ElseAttribute(EObject context, ElseAttribute semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.CONDITIONAL_ATTRIBUTE__TAG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.CONDITIONAL_ATTRIBUTE__TAG));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getElseAttributeAccess().getTagElseKeyword_1_0(), semanticObject.getTag());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     tag='endif'
	 */
	protected void sequence_EndifAttribute(EObject context, EndifAttribute semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.CONDITIONAL_ATTRIBUTE__TAG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.CONDITIONAL_ATTRIBUTE__TAG));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEndifAttributeAccess().getTagEndifKeyword_1_0(), semanticObject.getTag());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (tag='export' (funs+=FunRef funs+=FunRef*)?)
	 */
	protected void sequence_ExportAttribute(EObject context, ExportAttribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (opLeft=Expr200_BinOp_1_0 op=COMPOP opRight=Expr300) | 
	 *         (opLeft=Expr300_BinOp_1_0 op=LISTOP opRight=Expr400) | 
	 *         (opLeft=Expr160_BinOp_1_0 op='andalso' opRight2=Expr200) | 
	 *         (opLeft=Expr150_BinOp_1_0 op='orelse' opRight=Expr160) | 
	 *         (opLeft=Expr100_BinOp_1_1_0 op=SENDOP opRight=Expr100)
	 *     )
	 */
	protected void sequence_Expr100_Expr150_Expr160_Expr200_Expr300(EObject context, BinOp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (opLeft=Expr100_MatchExpr_1_0_0 op='=' opRight=Expr100)
	 */
	protected void sequence_Expr100(EObject context, MatchExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (opLeft=Expr400_AddOp_1_0 op=ADDOP opRight=Expr500)
	 */
	protected void sequence_Expr400(EObject context, AddOp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (opLeft=Expr500_MultOp_1_0 op=MULTOP opRight=UnaryExpr)
	 */
	protected void sequence_Expr500(EObject context, MultOp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((rec=AtomVarMacro (field=AtomVarMacro | tuple=RecordTuple)) | (ref=Expr700_RecordExpr_1_1_1 record=RecordExpr))
	 */
	protected void sequence_Expr700_ExprMax_RecordExpr(EObject context, RecordExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (target=Expr700_FunCall_1_0_1 (args+=Expression args+=Expression*)? (args2+=Expression args2+=Expression*)?) | 
	 *         (target=Expr700_FunCall_1_0_1 (args2+=Expression args2+=Expression*)?) | 
	 *         target=Expr700_FunCall_1_0_1
	 *     )
	 */
	protected void sequence_Expr700(EObject context, FunCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((ref=Expr700_RecordExpr_1_1_1 record=RecordExpr) | (rec=AtomVarMacro (field=AtomVarMacro | tuple=RecordTuple)))
	 */
	protected void sequence_Expr700_RecordExpr(EObject context, RecordExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (module=Expr800_RemoteTarget_1_0 function=ExprMax)
	 */
	protected void sequence_Expr800(EObject context, RemoteTarget semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (body+=LExpression body+=LExpression*)
	 */
	protected void sequence_ExprMax(EObject context, BlockExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expr=Expression
	 */
	protected void sequence_Expression(EObject context, CatchExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exprs+=LExpression exprs+=LExpression*)
	 */
	protected void sequence_Expressions(EObject context, Expressions semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=NAME type=TopType)
	 */
	protected void sequence_FieldType(EObject context, FieldType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.FIELD_TYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.FIELD_TYPE__NAME));
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.FIELD_TYPE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.FIELD_TYPE__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFieldTypeAccess().getNameNAMEParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getFieldTypeAccess().getTypeTopTypeParserRuleCall_2_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (tag='file' file=STRING line=INTEGER)
	 */
	protected void sequence_FileAttribute(EObject context, FileAttribute semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.FILE_ATTRIBUTE__TAG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.FILE_ATTRIBUTE__TAG));
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.FILE_ATTRIBUTE__FILE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.FILE_ATTRIBUTE__FILE));
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.FILE_ATTRIBUTE__LINE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.FILE_ATTRIBUTE__LINE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFileAttributeAccess().getTagFileKeyword_1_0(), semanticObject.getTag());
		feeder.accept(grammarAccess.getFileAttributeAccess().getFileSTRINGTerminalRuleCall_3_0(), semanticObject.getFile());
		feeder.accept(grammarAccess.getFileAttributeAccess().getLineINTEGERParserRuleCall_5_0(), semanticObject.getLine());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     call=MacroCall
	 */
	protected void sequence_Form(EObject context, MacroForm semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.MACRO_FORM__CALL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.MACRO_FORM__CALL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFormAccess().getCallMacroCallParserRuleCall_3_1_0(), semanticObject.getCall());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (module_=AtomVarMacro? function_=AtomVarMacro arity_=IntVarMacro)
	 */
	protected void sequence_FunRef(EObject context, FunRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((items+=TopType items+=TopType*)? return=TopType)
	 */
	protected void sequence_FunType100(EObject context, FunTypeList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((args+=TopType args+=TopType*)? return=TopType)
	 */
	protected void sequence_FunType(EObject context, FunType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ref=NAME? (params+=Expression params+=Expression*)? guard=Guard? body+=LExpression body+=LExpression*)
	 */
	protected void sequence_FunctionClause(EObject context, FunctionClause semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=NAME clauses+=FunctionClause clauses+=FunctionClause*)
	 */
	protected void sequence_Function(EObject context, Function semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (guards+=Expressions guards+=Expressions*)
	 */
	protected void sequence_Guard(EObject context, Guard semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (guard=Guard body+=LExpression body+=LExpression*)
	 */
	protected void sequence_IfClause(EObject context, IfClause semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (clauses+=IfClause clauses+=IfClause*)
	 */
	protected void sequence_IfExpr(EObject context, IfExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((tag='ifdef' | tag='ifndef') ref=MacroRef)
	 */
	protected void sequence_IfdefAttribute(EObject context, IfdefAttribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tag='import' module=AtomVarMacro (funs+=FunRef funs+=FunRef*)?)
	 */
	protected void sequence_ImportAttribute(EObject context, ImportAttribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tag='include' importURI=STRING)
	 */
	protected void sequence_IncludeAttribute(EObject context, IncludeAttribute semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.ABSTRACT_INCLUDE_ATTRIBUTE__TAG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.ABSTRACT_INCLUDE_ATTRIBUTE__TAG));
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.ABSTRACT_INCLUDE_ATTRIBUTE__IMPORT_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.ABSTRACT_INCLUDE_ATTRIBUTE__IMPORT_URI));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIncludeAttributeAccess().getTagIncludeKeyword_1_0(), semanticObject.getTag());
		feeder.accept(grammarAccess.getIncludeAttributeAccess().getImportURISTRINGTerminalRuleCall_3_0(), semanticObject.getImportURI());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (tag='include_lib' importURI=STRING)
	 */
	protected void sequence_IncludeLibAttribute(EObject context, IncludeLibAttribute semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.ABSTRACT_INCLUDE_ATTRIBUTE__TAG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.ABSTRACT_INCLUDE_ATTRIBUTE__TAG));
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.ABSTRACT_INCLUDE_ATTRIBUTE__IMPORT_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.ABSTRACT_INCLUDE_ATTRIBUTE__IMPORT_URI));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIncludeLibAttributeAccess().getTagInclude_libKeyword_1_0(), semanticObject.getTag());
		feeder.accept(grammarAccess.getIncludeLibAttributeAccess().getImportURISTRINGTerminalRuleCall_3_0(), semanticObject.getImportURI());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (clauses+=FunctionClause clauses+=FunctionClause*)
	 */
	protected void sequence_InlineFun(EObject context, FunExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=INTEGER
	 */
	protected void sequence_IntegerLiteral(EObject context, ErlInteger semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (o1=Expression ((op='<-' | op='<=') o2=Expression)?)
	 */
	protected void sequence_LCExpr(EObject context, LCExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {LetExpr}
	 */
	protected void sequence_LetExpr(EObject context, LetExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (element=Expression generators+=LCExpr generators+=LCExpr*)
	 */
	protected void sequence_ListComprehension(EObject context, ListComprehension semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {ErlList}
	 */
	protected void sequence_List(EObject context, ErlList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=CHAR
	 */
	protected void sequence_LiteralExpressionNoNumber(EObject context, ErlChar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=FLOAT
	 */
	protected void sequence_LiteralExpression(EObject context, ErlFloat semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (macroName=MacroLiteral (args+=Expression args+=Expression*)?)
	 */
	protected void sequence_MacroCall(EObject context, MacroCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=[DefineAttribute|MACRO]
	 */
	protected void sequence_MacroLiteral(EObject context, Macro semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=[DefineAttribute|NAMEVAR]
	 */
	protected void sequence_MacroRef(EObject context, Macro semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tag='module' moduleName=NAME)
	 */
	protected void sequence_ModuleAttribute(EObject context, ModuleAttribute semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.MODULE_ATTRIBUTE__TAG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.MODULE_ATTRIBUTE__TAG));
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.MODULE_ATTRIBUTE__MODULE_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.MODULE_ATTRIBUTE__MODULE_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getModuleAttributeAccess().getTagModuleKeyword_1_0(), semanticObject.getTag());
		feeder.accept(grammarAccess.getModuleAttributeAccess().getModuleNameNAMEParserRuleCall_3_0(), semanticObject.getModuleName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     forms+=Form*
	 */
	protected void sequence_Module(EObject context, Module semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((target=PatternExpression_FunCall_1_1_0 (args+=Expression args+=Expression*)?) | target=PatternExpression_FunCall_1_1_0)
	 */
	protected void sequence_PatternExpression(EObject context, FunCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (opLeft=PatternExpression_MatchExpr_1_0_0 op='=' opRight=TermExpression)
	 */
	protected void sequence_PatternExpression(EObject context, MatchExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {QueryExpr}
	 */
	protected void sequence_QueryExpr(EObject context, QueryExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (clauses+=CrClause clauses+=CrClause* (after_expr=Expression after_body+=LExpression after_body+=LExpression*)?) | 
	 *         (after_expr=Expression after_body+=LExpression after_body+=LExpression*)
	 *     )
	 */
	protected void sequence_ReceiveExpr(EObject context, ReceiveExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tag='record' name=NAMEVAR ((fields+=RecordFieldDef fields+=RecordFieldDef*)? | recordMacro=MacroCall))
	 */
	protected void sequence_RecordAttribute(EObject context, RecordAttribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (rec=AtomVarMacro (field=AtomVarMacro | tuple=RecordTuple))
	 */
	protected void sequence_RecordExpr(EObject context, RecordExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=NAMEVAR value=Expression? type=TopType?)
	 */
	protected void sequence_RecordFieldDef(EObject context, RecordFieldDef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ref=AtomVarMacro value=Expression? type=TopType?)
	 */
	protected void sequence_RecordFieldExpr(EObject context, RecordFieldExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((fields+=RecordFieldExpr fields+=RecordFieldExpr*)?)
	 */
	protected void sequence_RecordTuple(EObject context, RecordTuple semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (tag='spec' | tag='callback') 
	 *         ((ref=SpecFun signatures+=TypeSig signatures+=TypeSig*) | (ref=SpecFun signatures+=TypeSig signatures+=TypeSig*))
	 *     )
	 */
	protected void sequence_SpecAttribute(EObject context, SpecAttribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (module_=AtomVarMacro? function_=AtomVarMacro arity_=IntVarMacro?)
	 */
	protected void sequence_SpecFun(EObject context, SpecFun semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (string=STRING | macro=MacroCall)
	 */
	protected void sequence_StringLiteralPart(EObject context, StringLiteralPart semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (string=STRING more+=StringLiteralPart*)
	 */
	protected void sequence_StringLiteral(EObject context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (var=VARIABLE? type=Type100)
	 */
	protected void sequence_TopType(EObject context, TopType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (leftOperand=Type400_TopType_1_0_0_0 op=MULTOP rightOperand=Type500) | 
	 *         (var=VARIABLE? type=Type100) | 
	 *         (leftOperand=Type300_TopType_1_0_0_0 op=ADDOP rightOperand=Type400) | 
	 *         (leftOperand=Type200_TopType_1_0_0_0 op='..' rightOperand=Type300) | 
	 *         (leftOperand=Type100_TopType_1_0_0_0 op='|' rightOperand=Type200)
	 *     )
	 */
	protected void sequence_TopType_Type100_Type200_Type300_Type400(EObject context, TopType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (leftOperand=Type400_TopType_1_0_0_0 op=MULTOP rightOperand=Type500) | 
	 *         (var=VARIABLE? type=Type100) | 
	 *         (leftOperand=Type300_TopType_1_0_0_0 op=ADDOP rightOperand=Type400) | 
	 *         (leftOperand=Type200_TopType_1_0_0_0 op='..' rightOperand=Type300)
	 *     )
	 */
	protected void sequence_TopType_Type200_Type300_Type400(EObject context, TopType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (leftOperand=Type400_TopType_1_0_0_0 op=MULTOP rightOperand=Type500) | 
	 *         (var=VARIABLE? type=Type100) | 
	 *         (leftOperand=Type300_TopType_1_0_0_0 op=ADDOP rightOperand=Type400)
	 *     )
	 */
	protected void sequence_TopType_Type300_Type400(EObject context, TopType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((leftOperand=Type400_TopType_1_0_0_0 op=MULTOP rightOperand=Type500) | (var=VARIABLE? type=Type100))
	 */
	protected void sequence_TopType_Type400(EObject context, TopType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (hdr=NAMEVAR? cond=PatternExpression guard=Guard? body+=LExpression body+=LExpression*)
	 */
	protected void sequence_TryClause(EObject context, TryClause semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         body+=LExpression 
	 *         body+=LExpression* 
	 *         (of_clauses+=CrClause of_clauses+=CrClause*)? 
	 *         ((catch+=TryClause catch+=TryClause* (after_body+=LExpression after_body+=LExpression*)?) | (after_body+=LExpression after_body+=LExpression*))
	 *     )
	 */
	protected void sequence_TryExpr(EObject context, TryExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {ErlTuple}
	 */
	protected void sequence_Tuple(EObject context, ErlTuple semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=PREFIXOP operand=Type)
	 */
	protected void sequence_Type500(EObject context, UnaryType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.UNARY_TYPE__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.UNARY_TYPE__OP));
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.UNARY_TYPE__OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.UNARY_TYPE__OPERAND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getType500Access().getOpPREFIXOPParserRuleCall_0_1_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getType500Access().getOperandTypeParserRuleCall_0_2_0(), semanticObject.getOperand());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (tag='type' | tag='opaque') 
	 *         (
	 *             (name=NAMEVAR (args+=PatternExpression args+=PatternExpression*)? type=TopType) | 
	 *             (name=NAMEVAR (args+=PatternExpression args+=PatternExpression*)? type=TopType)
	 *         )
	 *     )
	 */
	protected void sequence_TypeAttribute(EObject context, TypeAttribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=NAME types+=TopType types+=TopType*) | (name=VARIABLE type=TopType))
	 */
	protected void sequence_TypeGuard(EObject context, TypeGuard semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (items+=TypeGuard items+=TypeGuard*)
	 */
	protected void sequence_TypeGuards(EObject context, TypeGuards semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (decl=FunType guards=TypeGuards?)
	 */
	protected void sequence_TypeSig(EObject context, TypeSig semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=FunType100?)
	 */
	protected void sequence_Type(EObject context, FunType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=TopType?)
	 */
	protected void sequence_Type(EObject context, ListType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (rec=NAME (fields+=FieldType fields+=FieldType*)?)
	 */
	protected void sequence_Type(EObject context, RecordType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (m=AtomVarMacro? name=NAME (args+=TopType args+=TopType*)?)
	 */
	protected void sequence_Type(EObject context, RemoteType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((types+=TopType types+=TopType*)?)
	 */
	protected void sequence_Type(EObject context, TupleType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=VARIABLE | value=INTEGER)
	 */
	protected void sequence_Type(EObject context, Type semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=PREFIXOP operand=Expr700)
	 */
	protected void sequence_UnaryExpr(EObject context, UnaryExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((op=PREFIXOP operand=ExprMax) | (op=PREFIXOP operand=Expr700))
	 */
	protected void sequence_UnaryExpr_UnaryExprMax(EObject context, UnaryExpr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tag='undef' ref=MacroRef)
	 */
	protected void sequence_UndefAttribute(EObject context, UndefAttribute semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.UNDEF_ATTRIBUTE__TAG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.UNDEF_ATTRIBUTE__TAG));
			if(transientValues.isValueTransient(semanticObject, ErlangPackage.Literals.UNDEF_ATTRIBUTE__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ErlangPackage.Literals.UNDEF_ATTRIBUTE__REF));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUndefAttributeAccess().getTagUndefKeyword_1_0(), semanticObject.getTag());
		feeder.accept(grammarAccess.getUndefAttributeAccess().getRefMacroRefParserRuleCall_3_0(), semanticObject.getRef());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=[Expression|VARIABLE]
	 */
	protected void sequence_VariableLiteral(EObject context, Variable semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
