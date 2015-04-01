/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.erlide.erlang.EncodingAttribute;
import org.erlide.erlang.ErlangPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Encoding Attribute</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.EncodingAttributeImpl#getCharset <em>
 * Charset</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EncodingAttributeImpl extends AttributeImpl implements
        EncodingAttribute {
    /**
     * The default value of the '{@link #getCharset() <em>Charset</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getCharset()
     * @generated
     * @ordered
     */
    protected static final String CHARSET_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCharset() <em>Charset</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getCharset()
     * @generated
     * @ordered
     */
    protected String charset = CHARSET_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EncodingAttributeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.ENCODING_ATTRIBUTE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getCharset() {
        return charset;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setCharset(final String newCharset) {
        final String oldCharset = charset;
        charset = newCharset;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.ENCODING_ATTRIBUTE__CHARSET, oldCharset,
                    charset));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve,
            final boolean coreType) {
        switch (featureID) {
        case ErlangPackage.ENCODING_ATTRIBUTE__CHARSET:
            return getCharset();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case ErlangPackage.ENCODING_ATTRIBUTE__CHARSET:
            setCharset((String) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case ErlangPackage.ENCODING_ATTRIBUTE__CHARSET:
            setCharset(CHARSET_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case ErlangPackage.ENCODING_ATTRIBUTE__CHARSET:
            return CHARSET_EDEFAULT == null ? charset != null
                    : !CHARSET_EDEFAULT.equals(charset);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (charset: ");
        result.append(charset);
        result.append(')');
        return result.toString();
    }

} // EncodingAttributeImpl
