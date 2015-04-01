/**
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Remote Type</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.RemoteType#getM <em>M</em>}</li>
 * <li>{@link org.erlide.erlang.RemoteType#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getRemoteType()
 * @model
 * @generated
 */
public interface RemoteType extends Type {
    /**
     * Returns the value of the '<em><b>M</b></em>' containment reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>M</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>M</em>' containment reference.
     * @see #setM(Expression)
     * @see org.erlide.erlang.ErlangPackage#getRemoteType_M()
     * @model containment="true"
     * @generated
     */
    Expression getM();

    /**
     * Sets the value of the '{@link org.erlide.erlang.RemoteType#getM
     * <em>M</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>M</em>' containment reference.
     * @see #getM()
     * @generated
     */
    void setM(Expression value);

    /**
     * Returns the value of the '<em><b>Args</b></em>' containment reference
     * list. The list contents are of type {@link org.erlide.erlang.TopType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Args</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Args</em>' containment reference list.
     * @see org.erlide.erlang.ErlangPackage#getRemoteType_Args()
     * @model containment="true"
     * @generated
     */
    EList<TopType> getArgs();

} // RemoteType
