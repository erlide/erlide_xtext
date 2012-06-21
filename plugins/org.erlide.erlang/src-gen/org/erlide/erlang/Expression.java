/**
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.Expression#isLine <em>Line</em>}</li>
 *   <li>{@link org.erlide.erlang.Expression#getExpr <em>Expr</em>}</li>
 *   <li>{@link org.erlide.erlang.Expression#getString <em>String</em>}</li>
 *   <li>{@link org.erlide.erlang.Expression#getMore <em>More</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends ReferenceableElement, AtomVarMacro, AtomVar, AtomMacro, IntVarMacro
{
  /**
   * Returns the value of the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Line</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Line</em>' attribute.
   * @see #setLine(boolean)
   * @see org.erlide.erlang.ErlangPackage#getExpression_Line()
   * @model
   * @generated
   */
  boolean isLine();

  /**
   * Sets the value of the '{@link org.erlide.erlang.Expression#isLine <em>Line</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Line</em>' attribute.
   * @see #isLine()
   * @generated
   */
  void setLine(boolean value);

  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expression)
   * @see org.erlide.erlang.ErlangPackage#getExpression_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link org.erlide.erlang.Expression#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

  /**
   * Returns the value of the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>String</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>String</em>' attribute.
   * @see #setString(String)
   * @see org.erlide.erlang.ErlangPackage#getExpression_String()
   * @model
   * @generated
   */
  String getString();

  /**
   * Sets the value of the '{@link org.erlide.erlang.Expression#getString <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String</em>' attribute.
   * @see #getString()
   * @generated
   */
  void setString(String value);

  /**
   * Returns the value of the '<em><b>More</b></em>' containment reference list.
   * The list contents are of type {@link org.erlide.erlang.StringLiteralPart}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>More</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>More</em>' containment reference list.
   * @see org.erlide.erlang.ErlangPackage#getExpression_More()
   * @model containment="true"
   * @generated
   */
  EList<StringLiteralPart> getMore();

} // Expression
