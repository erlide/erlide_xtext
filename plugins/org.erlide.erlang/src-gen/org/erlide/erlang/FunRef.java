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
 *   <li>{@link org.erlide.erlang.FunRef#getModule <em>Module</em>}</li>
 *   <li>{@link org.erlide.erlang.FunRef#getFunction <em>Function</em>}</li>
 *   <li>{@link org.erlide.erlang.FunRef#getArity <em>Arity</em>}</li>
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
   * Returns the value of the '<em><b>Module</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Module</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Module</em>' reference.
   * @see #setModule(ReferenceableElement)
   * @see org.erlide.erlang.ErlangPackage#getFunRef_Module()
   * @model
   * @generated
   */
  ReferenceableElement getModule();

  /**
   * Sets the value of the '{@link org.erlide.erlang.FunRef#getModule <em>Module</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Module</em>' reference.
   * @see #getModule()
   * @generated
   */
  void setModule(ReferenceableElement value);

  /**
   * Returns the value of the '<em><b>Function</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function</em>' reference.
   * @see #setFunction(ReferenceableElement)
   * @see org.erlide.erlang.ErlangPackage#getFunRef_Function()
   * @model
   * @generated
   */
  ReferenceableElement getFunction();

  /**
   * Sets the value of the '{@link org.erlide.erlang.FunRef#getFunction <em>Function</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function</em>' reference.
   * @see #getFunction()
   * @generated
   */
  void setFunction(ReferenceableElement value);

  /**
   * Returns the value of the '<em><b>Arity</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arity</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arity</em>' reference.
   * @see #setArity(ReferenceableElement)
   * @see org.erlide.erlang.ErlangPackage#getFunRef_Arity()
   * @model
   * @generated
   */
  ReferenceableElement getArity();

  /**
   * Sets the value of the '{@link org.erlide.erlang.FunRef#getArity <em>Arity</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arity</em>' reference.
   * @see #getArity()
   * @generated
   */
  void setArity(ReferenceableElement value);

} // FunRef
