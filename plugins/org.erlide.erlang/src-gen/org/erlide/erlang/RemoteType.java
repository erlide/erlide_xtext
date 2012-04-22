/**
 */
package org.erlide.erlang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remote Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.RemoteType#getM <em>M</em>}</li>
 *   <li>{@link org.erlide.erlang.RemoteType#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getRemoteType()
 * @model
 * @generated
 */
public interface RemoteType extends Type
{
  /**
   * Returns the value of the '<em><b>M</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>M</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>M</em>' reference.
   * @see #setM(Module)
   * @see org.erlide.erlang.ErlangPackage#getRemoteType_M()
   * @model
   * @generated
   */
  Module getM();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RemoteType#getM <em>M</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>M</em>' reference.
   * @see #getM()
   * @generated
   */
  void setM(Module value);

  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference.
   * @see #setArgs(TopTypes)
   * @see org.erlide.erlang.ErlangPackage#getRemoteType_Args()
   * @model containment="true"
   * @generated
   */
  TopTypes getArgs();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RemoteType#getArgs <em>Args</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Args</em>' containment reference.
   * @see #getArgs()
   * @generated
   */
  void setArgs(TopTypes value);

} // RemoteType
