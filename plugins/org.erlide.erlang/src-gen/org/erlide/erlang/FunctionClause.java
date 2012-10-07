/**
 */
package org.erlide.erlang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.FunctionClause#getRef <em>Ref</em>}</li>
 *   <li>{@link org.erlide.erlang.FunctionClause#getParams <em>Params</em>}</li>
 *   <li>{@link org.erlide.erlang.FunctionClause#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.erlide.erlang.FunctionClause#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getFunctionClause()
 * @model
 * @generated
 */
public interface FunctionClause extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' attribute.
   * @see #setRef(String)
   * @see org.erlide.erlang.ErlangPackage#getFunctionClause_Ref()
   * @model
   * @generated
   */
  String getRef();

  /**
   * Sets the value of the '{@link org.erlide.erlang.FunctionClause#getRef <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' attribute.
   * @see #getRef()
   * @generated
   */
  void setRef(String value);

  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference.
   * @see #setParams(Expressions)
   * @see org.erlide.erlang.ErlangPackage#getFunctionClause_Params()
   * @model containment="true"
   * @generated
   */
  Expressions getParams();

  /**
   * Sets the value of the '{@link org.erlide.erlang.FunctionClause#getParams <em>Params</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Params</em>' containment reference.
   * @see #getParams()
   * @generated
   */
  void setParams(Expressions value);

  /**
   * Returns the value of the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guard</em>' containment reference.
   * @see #setGuard(Guard)
   * @see org.erlide.erlang.ErlangPackage#getFunctionClause_Guard()
   * @model containment="true"
   * @generated
   */
  Guard getGuard();

  /**
   * Sets the value of the '{@link org.erlide.erlang.FunctionClause#getGuard <em>Guard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guard</em>' containment reference.
   * @see #getGuard()
   * @generated
   */
  void setGuard(Guard value);

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
   * @see org.erlide.erlang.ErlangPackage#getFunctionClause_Body()
   * @model containment="true"
   * @generated
   */
  Expressions getBody();

  /**
   * Sets the value of the '{@link org.erlide.erlang.FunctionClause#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(Expressions value);

} // FunctionClause
