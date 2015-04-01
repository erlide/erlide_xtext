/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.erlide.erlang.ConditionalAttribute;
import org.erlide.erlang.ErlangPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Conditional Attribute</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.ConditionalAttributeImpl#getTag <em>Tag
 * </em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConditionalAttributeImpl extends MinimalEObjectImpl.Container
        implements ConditionalAttribute {
    /**
     * The default value of the '{@link #getTag() <em>Tag</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTag()
     * @generated
     * @ordered
     */
    protected static final String TAG_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTag() <em>Tag</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTag()
     * @generated
     * @ordered
     */
    protected String tag = TAG_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ConditionalAttributeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.CONDITIONAL_ATTRIBUTE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getTag() {
        return tag;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setTag(final String newTag) {
        final String oldTag = tag;
        tag = newTag;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.CONDITIONAL_ATTRIBUTE__TAG, oldTag, tag));
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
        case ErlangPackage.CONDITIONAL_ATTRIBUTE__TAG:
            return getTag();
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
        case ErlangPackage.CONDITIONAL_ATTRIBUTE__TAG:
            setTag((String) newValue);
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
        case ErlangPackage.CONDITIONAL_ATTRIBUTE__TAG:
            setTag(TAG_EDEFAULT);
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
        case ErlangPackage.CONDITIONAL_ATTRIBUTE__TAG:
            return TAG_EDEFAULT == null ? tag != null : !TAG_EDEFAULT
                    .equals(tag);
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
        result.append(" (tag: ");
        result.append(tag);
        result.append(')');
        return result.toString();
    }

} // ConditionalAttributeImpl
