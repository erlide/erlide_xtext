/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.erlide.erlang.AbstractIncludeAttribute;
import org.erlide.erlang.ErlangPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract Include Attribute</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.AbstractIncludeAttributeImpl#getImportURI
 * <em>Import URI</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractIncludeAttributeImpl extends AttributeImpl implements
        AbstractIncludeAttribute {
    /**
     * The default value of the '{@link #getImportURI() <em>Import URI</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getImportURI()
     * @generated
     * @ordered
     */
    protected static final String IMPORT_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getImportURI() <em>Import URI</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getImportURI()
     * @generated
     * @ordered
     */
    protected String importURI = IMPORT_URI_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AbstractIncludeAttributeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.ABSTRACT_INCLUDE_ATTRIBUTE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getImportURI() {
        return importURI;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setImportURI(final String newImportURI) {
        final String oldImportURI = importURI;
        importURI = newImportURI;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.ABSTRACT_INCLUDE_ATTRIBUTE__IMPORT_URI,
                    oldImportURI, importURI));
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
        case ErlangPackage.ABSTRACT_INCLUDE_ATTRIBUTE__IMPORT_URI:
            return getImportURI();
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
        case ErlangPackage.ABSTRACT_INCLUDE_ATTRIBUTE__IMPORT_URI:
            setImportURI((String) newValue);
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
        case ErlangPackage.ABSTRACT_INCLUDE_ATTRIBUTE__IMPORT_URI:
            setImportURI(IMPORT_URI_EDEFAULT);
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
        case ErlangPackage.ABSTRACT_INCLUDE_ATTRIBUTE__IMPORT_URI:
            return IMPORT_URI_EDEFAULT == null ? importURI != null
                    : !IMPORT_URI_EDEFAULT.equals(importURI);
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
        result.append(" (importURI: ");
        result.append(importURI);
        result.append(')');
        return result.toString();
    }

} // AbstractIncludeAttributeImpl
