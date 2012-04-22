/**
 */
package org.erlide.erlang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fun Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.FunType#getArgs <em>Args</em>}</li>
 *   <li>{@link org.erlide.erlang.FunType#getReturn <em>Return</em>}</li>
 *   <li>{@link org.erlide.erlang.FunType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getFunType()
 * @model
 * @generated
 */
public interface FunType extends Type
{
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
   * @see org.erlide.erlang.ErlangPackage#getFunType_Args()
   * @model containment="true"
   * @generated
   */
  TopTypes getArgs();

  /**
   * Sets the value of the '{@link org.erlide.erlang.FunType#getArgs <em>Args</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Args</em>' containment reference.
   * @see #getArgs()
   * @generated
   */
  void setArgs(TopTypes value);

  /**
   * Returns the value of the '<em><b>Return</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Return</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return</em>' containment reference.
   * @see #setReturn(TopType)
   * @see org.erlide.erlang.ErlangPackage#getFunType_Return()
   * @model containment="true"
   * @generated
   */
  TopType getReturn();

  /**
   * Sets the value of the '{@link org.erlide.erlang.FunType#getReturn <em>Return</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return</em>' containment reference.
   * @see #getReturn()
   * @generated
   */
  void setReturn(TopType value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(FunType100)
   * @see org.erlide.erlang.ErlangPackage#getFunType_Type()
   * @model containment="true"
   * @generated
   */
  FunType100 getType();

  /**
   * Sets the value of the '{@link org.erlide.erlang.FunType#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(FunType100 value);

} // FunType
