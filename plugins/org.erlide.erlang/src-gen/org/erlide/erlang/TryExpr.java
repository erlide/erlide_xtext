/**
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Try Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.TryExpr#getBody <em>Body</em>}</li>
 *   <li>{@link org.erlide.erlang.TryExpr#getOf_clauses <em>Of clauses</em>}</li>
 *   <li>{@link org.erlide.erlang.TryExpr#getCatch <em>Catch</em>}</li>
 *   <li>{@link org.erlide.erlang.TryExpr#getAfter_body <em>After body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getTryExpr()
 * @model
 * @generated
 */
public interface TryExpr extends Expression
{
  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(Expressions)
   * @see org.erlide.erlang.ErlangPackage#getTryExpr_Body()
   * @model containment="true"
   * @generated
   */
  Expressions getBody();

  /**
   * Sets the value of the '{@link org.erlide.erlang.TryExpr#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(Expressions value);

  /**
   * Returns the value of the '<em><b>Of clauses</b></em>' containment reference list.
   * The list contents are of type {@link org.erlide.erlang.CrClause}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Of clauses</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Of clauses</em>' containment reference list.
   * @see org.erlide.erlang.ErlangPackage#getTryExpr_Of_clauses()
   * @model containment="true"
   * @generated
   */
  EList<CrClause> getOf_clauses();

  /**
   * Returns the value of the '<em><b>Catch</b></em>' containment reference list.
   * The list contents are of type {@link org.erlide.erlang.TryClause}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Catch</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Catch</em>' containment reference list.
   * @see org.erlide.erlang.ErlangPackage#getTryExpr_Catch()
   * @model containment="true"
   * @generated
   */
  EList<TryClause> getCatch();

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
   * @see org.erlide.erlang.ErlangPackage#getTryExpr_After_body()
   * @model containment="true"
   * @generated
   */
  Expressions getAfter_body();

  /**
   * Sets the value of the '{@link org.erlide.erlang.TryExpr#getAfter_body <em>After body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>After body</em>' containment reference.
   * @see #getAfter_body()
   * @generated
   */
  void setAfter_body(Expressions value);

} // TryExpr
