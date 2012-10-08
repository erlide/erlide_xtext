/**
 * <copyright>
 * </copyright>
 *
 */
package org.erlide.erlang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LC Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.LCExpr#getO1 <em>O1</em>}</li>
 *   <li>{@link org.erlide.erlang.LCExpr#getOp <em>Op</em>}</li>
 *   <li>{@link org.erlide.erlang.LCExpr#getO2 <em>O2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getLCExpr()
 * @model
 * @generated
 */
public interface LCExpr extends EObject
{
  /**
   * Returns the value of the '<em><b>O1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>O1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>O1</em>' containment reference.
   * @see #setO1(Expression)
   * @see org.erlide.erlang.ErlangPackage#getLCExpr_O1()
   * @model containment="true"
   * @generated
   */
  Expression getO1();

  /**
   * Sets the value of the '{@link org.erlide.erlang.LCExpr#getO1 <em>O1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>O1</em>' containment reference.
   * @see #getO1()
   * @generated
   */
  void setO1(Expression value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see org.erlide.erlang.ErlangPackage#getLCExpr_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link org.erlide.erlang.LCExpr#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

  /**
   * Returns the value of the '<em><b>O2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>O2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>O2</em>' containment reference.
   * @see #setO2(Expression)
   * @see org.erlide.erlang.ErlangPackage#getLCExpr_O2()
   * @model containment="true"
   * @generated
   */
  Expression getO2();

  /**
   * Sets the value of the '{@link org.erlide.erlang.LCExpr#getO2 <em>O2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>O2</em>' containment reference.
   * @see #getO2()
   * @generated
   */
  void setO2(Expression value);

} // LCExpr
