package org.erlide.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.erlide.services.ErlangGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractErlangSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ErlangGrammarAccess grammarAccess;
	protected AbstractElementAlias match_DefineAttribute_CommaKeyword_4_0_q;
	protected AbstractElementAlias match_DefineAttribute___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q;
	protected AbstractElementAlias match_Expr700___LeftParenthesisKeyword_1_0_4_0_RightParenthesisKeyword_1_0_4_2__q;
	protected AbstractElementAlias match_ExprMax_LeftParenthesisKeyword_1_0_a;
	protected AbstractElementAlias match_ExprMax_LeftParenthesisKeyword_1_0_p;
	protected AbstractElementAlias match_FunType100_FullStopFullStopFullStopKeyword_2_0_q;
	protected AbstractElementAlias match_FunctionClause_WhenKeyword_4_0_q;
	protected AbstractElementAlias match_MacroCall___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q;
	protected AbstractElementAlias match_Type___CommaKeyword_4_2_1_0_FullStopFullStopFullStopKeyword_4_2_1_1__q;
	protected AbstractElementAlias match_Type___LeftParenthesisKeyword_1_3_0_RightParenthesisKeyword_1_3_2__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ErlangGrammarAccess) access;
		match_DefineAttribute_CommaKeyword_4_0_q = new TokenAlias(false, true, grammarAccess.getDefineAttributeAccess().getCommaKeyword_4_0());
		match_DefineAttribute___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDefineAttributeAccess().getLeftParenthesisKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getDefineAttributeAccess().getRightParenthesisKeyword_3_2()));
		match_Expr700___LeftParenthesisKeyword_1_0_4_0_RightParenthesisKeyword_1_0_4_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getExpr700Access().getLeftParenthesisKeyword_1_0_4_0()), new TokenAlias(false, false, grammarAccess.getExpr700Access().getRightParenthesisKeyword_1_0_4_2()));
		match_ExprMax_LeftParenthesisKeyword_1_0_a = new TokenAlias(true, true, grammarAccess.getExprMaxAccess().getLeftParenthesisKeyword_1_0());
		match_ExprMax_LeftParenthesisKeyword_1_0_p = new TokenAlias(true, false, grammarAccess.getExprMaxAccess().getLeftParenthesisKeyword_1_0());
		match_FunType100_FullStopFullStopFullStopKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getFunType100Access().getFullStopFullStopFullStopKeyword_2_0());
		match_FunctionClause_WhenKeyword_4_0_q = new TokenAlias(false, true, grammarAccess.getFunctionClauseAccess().getWhenKeyword_4_0());
		match_MacroCall___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getMacroCallAccess().getLeftParenthesisKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getMacroCallAccess().getRightParenthesisKeyword_1_2()));
		match_Type___CommaKeyword_4_2_1_0_FullStopFullStopFullStopKeyword_4_2_1_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getTypeAccess().getCommaKeyword_4_2_1_0()), new TokenAlias(false, false, grammarAccess.getTypeAccess().getFullStopFullStopFullStopKeyword_4_2_1_1()));
		match_Type___LeftParenthesisKeyword_1_3_0_RightParenthesisKeyword_1_3_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getTypeAccess().getLeftParenthesisKeyword_1_3_0()), new TokenAlias(false, false, grammarAccess.getTypeAccess().getRightParenthesisKeyword_1_3_2()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getLineExprRule())
			return getLineExprToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * LineExpr:
	 * 	'?' 'line'  
	 * ;
	 */
	protected String getLineExprToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "?line";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_DefineAttribute_CommaKeyword_4_0_q.equals(syntax))
				emit_DefineAttribute_CommaKeyword_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DefineAttribute___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q.equals(syntax))
				emit_DefineAttribute___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Expr700___LeftParenthesisKeyword_1_0_4_0_RightParenthesisKeyword_1_0_4_2__q.equals(syntax))
				emit_Expr700___LeftParenthesisKeyword_1_0_4_0_RightParenthesisKeyword_1_0_4_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ExprMax_LeftParenthesisKeyword_1_0_a.equals(syntax))
				emit_ExprMax_LeftParenthesisKeyword_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ExprMax_LeftParenthesisKeyword_1_0_p.equals(syntax))
				emit_ExprMax_LeftParenthesisKeyword_1_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_FunType100_FullStopFullStopFullStopKeyword_2_0_q.equals(syntax))
				emit_FunType100_FullStopFullStopFullStopKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_FunctionClause_WhenKeyword_4_0_q.equals(syntax))
				emit_FunctionClause_WhenKeyword_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_MacroCall___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q.equals(syntax))
				emit_MacroCall___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Type___CommaKeyword_4_2_1_0_FullStopFullStopFullStopKeyword_4_2_1_1__q.equals(syntax))
				emit_Type___CommaKeyword_4_2_1_0_FullStopFullStopFullStopKeyword_4_2_1_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Type___LeftParenthesisKeyword_1_3_0_RightParenthesisKeyword_1_3_2__q.equals(syntax))
				emit_Type___LeftParenthesisKeyword_1_3_0_RightParenthesisKeyword_1_3_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_DefineAttribute_CommaKeyword_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_DefineAttribute___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_Expr700___LeftParenthesisKeyword_1_0_4_0_RightParenthesisKeyword_1_0_4_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_ExprMax_LeftParenthesisKeyword_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_ExprMax_LeftParenthesisKeyword_1_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '...'?
	 */
	protected void emit_FunType100_FullStopFullStopFullStopKeyword_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'when'?
	 */
	protected void emit_FunctionClause_WhenKeyword_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_MacroCall___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (',' '...')?
	 */
	protected void emit_Type___CommaKeyword_4_2_1_0_FullStopFullStopFullStopKeyword_4_2_1_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_Type___LeftParenthesisKeyword_1_3_0_RightParenthesisKeyword_1_3_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
