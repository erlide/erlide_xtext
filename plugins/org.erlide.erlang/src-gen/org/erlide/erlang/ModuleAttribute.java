/**
 */
package org.erlide.erlang;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Module Attribute</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.ModuleAttribute#getModuleName <em>Module Name
 * </em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getModuleAttribute()
 * @model
 * @generated
 */
public interface ModuleAttribute extends Attribute {
    /**
     * Returns the value of the '<em><b>Module Name</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Module Name</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Module Name</em>' attribute.
     * @see #setModuleName(String)
     * @see org.erlide.erlang.ErlangPackage#getModuleAttribute_ModuleName()
     * @model
     * @generated
     */
    String getModuleName();

    /**
     * Sets the value of the '
     * {@link org.erlide.erlang.ModuleAttribute#getModuleName
     * <em>Module Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Module Name</em>' attribute.
     * @see #getModuleName()
     * @generated
     */
    void setModuleName(String value);

} // ModuleAttribute
