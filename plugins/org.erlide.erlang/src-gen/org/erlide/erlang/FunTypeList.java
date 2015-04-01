/**
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Fun Type List</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.FunTypeList#getItems <em>Items</em>}</li>
 * <li>{@link org.erlide.erlang.FunTypeList#getReturn <em>Return</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getFunTypeList()
 * @model
 * @generated
 */
public interface FunTypeList extends FunType100 {
    /**
     * Returns the value of the '<em><b>Items</b></em>' containment reference
     * list. The list contents are of type {@link org.erlide.erlang.TopType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Items</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Items</em>' containment reference list.
     * @see org.erlide.erlang.ErlangPackage#getFunTypeList_Items()
     * @model containment="true"
     * @generated
     */
    EList<TopType> getItems();

    /**
     * Returns the value of the '<em><b>Return</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Return</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Return</em>' containment reference.
     * @see #setReturn(TopType)
     * @see org.erlide.erlang.ErlangPackage#getFunTypeList_Return()
     * @model containment="true"
     * @generated
     */
    TopType getReturn();

    /**
     * Sets the value of the '{@link org.erlide.erlang.FunTypeList#getReturn
     * <em>Return</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Return</em>' containment reference.
     * @see #getReturn()
     * @generated
     */
    void setReturn(TopType value);

} // FunTypeList
