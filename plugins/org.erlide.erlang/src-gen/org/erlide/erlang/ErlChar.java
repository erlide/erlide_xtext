/**
 */
package org.erlide.erlang;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Erl Char</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.ErlChar#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getErlChar()
 * @model
 * @generated
 */
public interface ErlChar extends Expression {
    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see org.erlide.erlang.ErlangPackage#getErlChar_Value()
     * @model
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link org.erlide.erlang.ErlChar#getValue
     * <em>Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(String value);

} // ErlChar
