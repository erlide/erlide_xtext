/**
 * <copyright>
 * </copyright>
 *
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Receive Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.ReceiveExpr#getClauses <em>Clauses</em>}</li>
 *   <li>{@link org.erlide.erlang.ReceiveExpr#getAfter_expr <em>After expr</em>}</li>
 *   <li>{@link org.erlide.erlang.ReceiveExpr#getAfter_body <em>After body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getReceiveExpr()
 * @model
 * @generated
 */
public interface ReceiveExpr extends Expression
{
  /**
   * Returns the value of the '<em><b>Clauses</b></em>' containment reference list.
   * The list contents are of type {@link org.erlide.erlang.CrClause}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Clauses</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Clauses</em>' containment reference list.
   * @see org.erlide.erlang.ErlangPackage#getReceiveExpr_Clauses()
   * @model containment="true"
   * @generated
   */
  EList<CrClause> getClauses();

  /**
   * Returns the value of the '<em><b>After expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>After expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>After expr</em>' containment reference.
   * @see #setAfter_expr(Expression)
   * @see org.erlide.erlang.ErlangPackage#getReceiveExpr_After_expr()
   * @model containment="true"
   * @generated
   */
  Expression getAfter_expr();

  /**
   * Sets the value of the '{@link org.erlide.erlang.ReceiveExpr#getAfter_expr <em>After expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>After expr</em>' containment reference.
   * @see #getAfter_expr()
   * @generated
   */
  void setAfter_expr(Expression value);

  /**
   * Returns the value of the '<em><b>After body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>After body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>After body</em>' containment reference.
   * @see #setAfter_body(Expressions)
   * @see org.erlide.erlang.ErlangPackage#getReceiveExpr_After_body()
   * @model containment="true"
   * @generated
   */
  Expressions getAfter_body();

  /**
   * Sets the value of the '{@link org.erlide.erlang.ReceiveExpr#getAfter_body <em>After body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>After body</em>' containment reference.
   * @see #getAfter_body()
   * @generated
   */
  void setAfter_body(Expressions value);

} // ReceiveExpr
