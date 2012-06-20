/**
 */
package org.erlide.erlang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Erl String Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.ErlStringPart#getString <em>String</em>}</li>
 *   <li>{@link org.erlide.erlang.ErlStringPart#getMacro <em>Macro</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getErlStringPart()
 * @model
 * @generated
 */
public interface ErlStringPart extends EObject
{
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
   * @see org.erlide.erlang.ErlangPackage#getErlStringPart_String()
   * @model
   * @generated
   */
  String getString();

  /**
   * Sets the value of the '{@link org.erlide.erlang.ErlStringPart#getString <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String</em>' attribute.
   * @see #getString()
   * @generated
   */
  void setString(String value);

  /**
   * Returns the value of the '<em><b>Macro</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Macro</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Macro</em>' reference.
   * @see #setMacro(DefineAttribute)
   * @see org.erlide.erlang.ErlangPackage#getErlStringPart_Macro()
   * @model
   * @generated
   */
  DefineAttribute getMacro();

  /**
   * Sets the value of the '{@link org.erlide.erlang.ErlStringPart#getMacro <em>Macro</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Macro</em>' reference.
   * @see #getMacro()
   * @generated
   */
  void setMacro(DefineAttribute value);

} // ErlStringPart
