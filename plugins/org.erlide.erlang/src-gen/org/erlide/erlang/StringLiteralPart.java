/**
 */
package org.erlide.erlang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>String Literal Part</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.StringLiteralPart#getMacro <em>Macro</em>}</li>
 * <li>{@link org.erlide.erlang.StringLiteralPart#getString <em>String</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getStringLiteralPart()
 * @model
 * @generated
 */
public interface StringLiteralPart extends EObject {
    /**
     * Returns the value of the '<em><b>Macro</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Macro</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Macro</em>' containment reference.
     * @see #setMacro(MacroCall)
     * @see org.erlide.erlang.ErlangPackage#getStringLiteralPart_Macro()
     * @model containment="true"
     * @generated
     */
    MacroCall getMacro();

    /**
     * Sets the value of the '
     * {@link org.erlide.erlang.StringLiteralPart#getMacro <em>Macro</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Macro</em>' containment reference.
     * @see #getMacro()
     * @generated
     */
    void setMacro(MacroCall value);

    /**
     * Returns the value of the '<em><b>String</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>String</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>String</em>' attribute.
     * @see #setString(String)
     * @see org.erlide.erlang.ErlangPackage#getStringLiteralPart_String()
     * @model
     * @generated
     */
    String getString();

    /**
     * Sets the value of the '
     * {@link org.erlide.erlang.StringLiteralPart#getString <em>String</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>String</em>' attribute.
     * @see #getString()
     * @generated
     */
    void setString(String value);

} // StringLiteralPart
