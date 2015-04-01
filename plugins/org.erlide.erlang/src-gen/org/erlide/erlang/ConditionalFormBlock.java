/**
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Conditional Form Block</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.ConditionalFormBlock#getCondition <em>Condition
 * </em>}</li>
 * <li>{@link org.erlide.erlang.ConditionalFormBlock#getIfForms <em>If Forms
 * </em>}</li>
 * <li>{@link org.erlide.erlang.ConditionalFormBlock#isHasElse <em>Has Else
 * </em>}</li>
 * <li>{@link org.erlide.erlang.ConditionalFormBlock#getElseForms <em>Else Forms
 * </em>}</li>
 * <li>{@link org.erlide.erlang.ConditionalFormBlock#getEnd <em>End</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getConditionalFormBlock()
 * @model
 * @generated
 */
public interface ConditionalFormBlock extends Form {
    /**
     * Returns the value of the '<em><b>Condition</b></em>' containment
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Condition</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Condition</em>' containment reference.
     * @see #setCondition(IfdefAttribute)
     * @see org.erlide.erlang.ErlangPackage#getConditionalFormBlock_Condition()
     * @model containment="true"
     * @generated
     */
    IfdefAttribute getCondition();

    /**
     * Sets the value of the '
     * {@link org.erlide.erlang.ConditionalFormBlock#getCondition
     * <em>Condition</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Condition</em>' containment
     *            reference.
     * @see #getCondition()
     * @generated
     */
    void setCondition(IfdefAttribute value);

    /**
     * Returns the value of the '<em><b>If Forms</b></em>' containment reference
     * list. The list contents are of type {@link org.erlide.erlang.Form}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>If Forms</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>If Forms</em>' containment reference list.
     * @see org.erlide.erlang.ErlangPackage#getConditionalFormBlock_IfForms()
     * @model containment="true"
     * @generated
     */
    EList<Form> getIfForms();

    /**
     * Returns the value of the '<em><b>Has Else</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Has Else</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Has Else</em>' attribute.
     * @see #setHasElse(boolean)
     * @see org.erlide.erlang.ErlangPackage#getConditionalFormBlock_HasElse()
     * @model
     * @generated
     */
    boolean isHasElse();

    /**
     * Sets the value of the '
     * {@link org.erlide.erlang.ConditionalFormBlock#isHasElse
     * <em>Has Else</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Has Else</em>' attribute.
     * @see #isHasElse()
     * @generated
     */
    void setHasElse(boolean value);

    /**
     * Returns the value of the '<em><b>Else Forms</b></em>' containment
     * reference list. The list contents are of type
     * {@link org.erlide.erlang.Form}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Else Forms</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Else Forms</em>' containment reference
     *         list.
     * @see org.erlide.erlang.ErlangPackage#getConditionalFormBlock_ElseForms()
     * @model containment="true"
     * @generated
     */
    EList<Form> getElseForms();

    /**
     * Returns the value of the '<em><b>End</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>End</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>End</em>' containment reference.
     * @see #setEnd(EndifAttribute)
     * @see org.erlide.erlang.ErlangPackage#getConditionalFormBlock_End()
     * @model containment="true"
     * @generated
     */
    EndifAttribute getEnd();

    /**
     * Sets the value of the '
     * {@link org.erlide.erlang.ConditionalFormBlock#getEnd <em>End</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>End</em>' containment reference.
     * @see #getEnd()
     * @generated
     */
    void setEnd(EndifAttribute value);

} // ConditionalFormBlock
