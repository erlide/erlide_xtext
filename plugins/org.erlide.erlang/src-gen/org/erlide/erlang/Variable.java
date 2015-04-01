/**
 */
package org.erlide.erlang;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Variable</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.Variable#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends Expression {
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
     * @see #setValue(Expression)
     * @see org.erlide.erlang.ErlangPackage#getVariable_Value()
     * @model
     * @generated
     */
    Expression getValue();

    /**
     * Sets the value of the '{@link org.erlide.erlang.Variable#getValue
     * <em>Value</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Value</em>' reference.
     * @see #getValue()
     * @generated
     */
    void setValue(Expression value);

} // Variable
