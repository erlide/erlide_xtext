/**
 */
package org.erlide.erlang;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Encoding Attribute</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.EncodingAttribute#getCharset <em>Charset</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getEncodingAttribute()
 * @model
 * @generated
 */
public interface EncodingAttribute extends Attribute {
    /**
     * Returns the value of the '<em><b>Charset</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Charset</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Charset</em>' attribute.
     * @see #setCharset(String)
     * @see org.erlide.erlang.ErlangPackage#getEncodingAttribute_Charset()
     * @model
     * @generated
     */
    String getCharset();

    /**
     * Sets the value of the '
     * {@link org.erlide.erlang.EncodingAttribute#getCharset <em>Charset</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Charset</em>' attribute.
     * @see #getCharset()
     * @generated
     */
    void setCharset(String value);

} // EncodingAttribute
