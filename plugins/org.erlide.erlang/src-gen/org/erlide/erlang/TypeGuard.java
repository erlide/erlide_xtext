/**
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Type Guard</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.TypeGuard#getTypeName <em>Type Name</em>}</li>
 * <li>{@link org.erlide.erlang.TypeGuard#getTypes <em>Types</em>}</li>
 * <li>{@link org.erlide.erlang.TypeGuard#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getTypeGuard()
 * @model
 * @generated
 */
public interface TypeGuard extends EObject {
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
     * @see org.erlide.erlang.ErlangPackage#getTypeGuard_TypeName()
     * @model containment="true"
     * @generated
     */
    Expression getTypeName();

    /**
     * Sets the value of the '{@link org.erlide.erlang.TypeGuard#getTypeName
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
     * Returns the value of the '<em><b>Types</b></em>' containment reference
     * list. The list contents are of type {@link org.erlide.erlang.TopType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Types</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Types</em>' containment reference list.
     * @see org.erlide.erlang.ErlangPackage#getTypeGuard_Types()
     * @model containment="true"
     * @generated
     */
    EList<TopType> getTypes();

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
     * @see #setType(TopType)
     * @see org.erlide.erlang.ErlangPackage#getTypeGuard_Type()
     * @model containment="true"
     * @generated
     */
    TopType getType();

    /**
     * Sets the value of the '{@link org.erlide.erlang.TypeGuard#getType
     * <em>Type</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Type</em>' containment reference.
     * @see #getType()
     * @generated
     */
    void setType(TopType value);

} // TypeGuard
