/**
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Erl String</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.ErlString#getString <em>String</em>}</li>
 *   <li>{@link org.erlide.erlang.ErlString#getMore <em>More</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getErlString()
 * @model
 * @generated
 */
public interface ErlString extends Expression
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
   * @see org.erlide.erlang.ErlangPackage#getErlString_String()
   * @model
   * @generated
   */
  String getString();

  /**
   * Sets the value of the '{@link org.erlide.erlang.ErlString#getString <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String</em>' attribute.
   * @see #getString()
   * @generated
   */
  void setString(String value);

  /**
   * Returns the value of the '<em><b>More</b></em>' containment reference list.
   * The list contents are of type {@link org.erlide.erlang.ErlStringPart}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>More</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>More</em>' containment reference list.
   * @see org.erlide.erlang.ErlangPackage#getErlString_More()
   * @model containment="true"
   * @generated
   */
  EList<ErlStringPart> getMore();

} // ErlString
