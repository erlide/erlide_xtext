/**
 */
package org.erlide.erlang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Bin Base Type</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.BinBaseType#getTypeName <em>Type Name</em>}</li>
 * <li>{@link org.erlide.erlang.BinBaseType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getBinBaseType()
 * @model
 * @generated
 */
public interface BinBaseType extends EObject {
    /**
     * Returns the value of the '<em><b>Type Name</b></em>' containment
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type Name</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Type Name</em>' containment reference.
     * @see #setTypeName(Expression)
     * @see org.erlide.erlang.ErlangPackage#getBinBaseType_TypeName()
     * @model containment="true"
     * @generated
     */
    Expression getTypeName();

    /**
     * Sets the value of the '{@link org.erlide.erlang.BinBaseType#getTypeName
     * <em>Type Name</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Type Name</em>' containment
     *            reference.
     * @see #getTypeName()
     * @generated
     */
    void setTypeName(Expression value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Type</em>' containment reference.
     * @see #setType(Type)
     * @see org.erlide.erlang.ErlangPackage#getBinBaseType_Type()
     * @model containment="true"
     * @generated
     */
    Type getType();

    /**
     * Sets the value of the '{@link org.erlide.erlang.BinBaseType#getType
     * <em>Type</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Type</em>' containment reference.
     * @see #getType()
     * @generated
     */
    void setType(Type value);

} // BinBaseType
