/**
 */
package org.erlide.erlang;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Macro</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.Macro#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getMacro()
 * @model
 * @generated
 */
public interface Macro extends Expression {
    /**
     * Returns the value of the '<em><b>Value</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Value</em>' reference.
     * @see #setValue(DefineAttribute)
     * @see org.erlide.erlang.ErlangPackage#getMacro_Value()
     * @model
     * @generated
     */
    DefineAttribute getValue();

    /**
     * Sets the value of the '{@link org.erlide.erlang.Macro#getValue
     * <em>Value</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Value</em>' reference.
     * @see #getValue()
     * @generated
     */
    void setValue(DefineAttribute value);

} // Macro
