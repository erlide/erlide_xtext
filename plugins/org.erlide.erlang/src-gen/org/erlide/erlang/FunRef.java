/**
 */
package org.erlide.erlang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fun Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.FunRef#getModule_ <em>Module </em>}</li>
 *   <li>{@link org.erlide.erlang.FunRef#getFunction_ <em>Function </em>}</li>
 *   <li>{@link org.erlide.erlang.FunRef#getArity_ <em>Arity </em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getFunRef()
 * @model
 * @generated
 */
public interface FunRef extends FunExpr
{
  /**
   * Returns the value of the '<em><b>Module </b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Module </em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Module </em>' containment reference.
   * @see #setModule_(Expression)
   * @see org.erlide.erlang.ErlangPackage#getFunRef_Module_()
   * @model containment="true"
   * @generated
   */
  Expression getModule_();

  /**
   * Sets the value of the '{@link org.erlide.erlang.FunRef#getModule_ <em>Module </em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Module </em>' containment reference.
   * @see #getModule_()
   * @generated
   */
  void setModule_(Expression value);

  /**
   * Returns the value of the '<em><b>Function </b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function </em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function </em>' containment reference.
   * @see #setFunction_(Expression)
   * @see org.erlide.erlang.ErlangPackage#getFunRef_Function_()
   * @model containment="true"
   * @generated
   */
  Expression getFunction_();

  /**
   * Sets the value of the '{@link org.erlide.erlang.FunRef#getFunction_ <em>Function </em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function </em>' containment reference.
   * @see #getFunction_()
   * @generated
   */
  void setFunction_(Expression value);

  /**
   * Returns the value of the '<em><b>Arity </b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arity </em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arity </em>' containment reference.
   * @see #setArity_(Expression)
   * @see org.erlide.erlang.ErlangPackage#getFunRef_Arity_()
   * @model containment="true"
   * @generated
   */
  Expression getArity_();

  /**
   * Sets the value of the '{@link org.erlide.erlang.FunRef#getArity_ <em>Arity </em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arity </em>' containment reference.
   * @see #getArity_()
   * @generated
   */
  void setArity_(Expression value);

} // FunRef
