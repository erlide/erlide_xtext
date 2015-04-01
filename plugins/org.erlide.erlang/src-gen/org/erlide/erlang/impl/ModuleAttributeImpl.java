/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.ModuleAttribute;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Module Attribute</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.ModuleAttributeImpl#getModuleName <em>
 * Module Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModuleAttributeImpl extends AttributeImpl implements
        ModuleAttribute {
    /**
     * The default value of the '{@link #getModuleName() <em>Module Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getModuleName()
     * @generated
     * @ordered
     */
    protected static final String MODULE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getModuleName() <em>Module Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getModuleName()
     * @generated
     * @ordered
     */
    protected String moduleName = MODULE_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ModuleAttributeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.MODULE_ATTRIBUTE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getModuleName() {
        return moduleName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setModuleName(final String newModuleName) {
        final String oldModuleName = moduleName;
        moduleName = newModuleName;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.MODULE_ATTRIBUTE__MODULE_NAME, oldModuleName,
                    moduleName));
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
        case ErlangPackage.MODULE_ATTRIBUTE__MODULE_NAME:
            return getModuleName();
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
        case ErlangPackage.MODULE_ATTRIBUTE__MODULE_NAME:
            setModuleName((String) newValue);
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
        case ErlangPackage.MODULE_ATTRIBUTE__MODULE_NAME:
            setModuleName(MODULE_NAME_EDEFAULT);
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
        case ErlangPackage.MODULE_ATTRIBUTE__MODULE_NAME:
            return MODULE_NAME_EDEFAULT == null ? moduleName != null
                    : !MODULE_NAME_EDEFAULT.equals(moduleName);
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
        result.append(" (moduleName: ");
        result.append(moduleName);
        result.append(')');
        return result.toString();
    }

} // ModuleAttributeImpl
