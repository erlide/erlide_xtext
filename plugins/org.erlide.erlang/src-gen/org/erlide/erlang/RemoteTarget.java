/**
 */
package org.erlide.erlang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remote Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.RemoteTarget#getModule <em>Module</em>}</li>
 *   <li>{@link org.erlide.erlang.RemoteTarget#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getRemoteTarget()
 * @model
 * @generated
 */
public interface RemoteTarget extends Expression
{
  /**
   * Returns the value of the '<em><b>Module</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Module</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Module</em>' containment reference.
   * @see #setModule(Expression)
   * @see org.erlide.erlang.ErlangPackage#getRemoteTarget_Module()
   * @model containment="true"
   * @generated
   */
  Expression getModule();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RemoteTarget#getModule <em>Module</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Module</em>' containment reference.
   * @see #getModule()
   * @generated
   */
  void setModule(Expression value);

  /**
   * Returns the value of the '<em><b>Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function</em>' containment reference.
   * @see #setFunction(Expression)
   * @see org.erlide.erlang.ErlangPackage#getRemoteTarget_Function()
   * @model containment="true"
   * @generated
   */
  Expression getFunction();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RemoteTarget#getFunction <em>Function</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function</em>' containment reference.
   * @see #getFunction()
   * @generated
   */
  void setFunction(Expression value);

} // RemoteTarget
