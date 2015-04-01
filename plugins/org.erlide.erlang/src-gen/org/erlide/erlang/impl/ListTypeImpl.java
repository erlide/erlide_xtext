/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.ListType;
import org.erlide.erlang.TopType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>List Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.ListTypeImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ListTypeImpl extends TypeImpl implements ListType {
    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected TopType type;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ListTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.LIST_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TopType getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetType(final TopType newType,
            NotificationChain msgs) {
        final TopType oldType = type;
        type = newType;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.LIST_TYPE__TYPE, oldType,
                    newType);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setType(final TopType newType) {
        if (newType != type) {
            NotificationChain msgs = null;
            if (type != null) {
                msgs = ((InternalEObject) type).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.LIST_TYPE__TYPE,
                        null, msgs);
            }
            if (newType != null) {
                msgs = ((InternalEObject) newType).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.LIST_TYPE__TYPE,
                        null, msgs);
            }
            msgs = basicSetType(newType, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.LIST_TYPE__TYPE, newType, newType));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd,
            final int featureID, final NotificationChain msgs) {
        switch (featureID) {
        case ErlangPackage.LIST_TYPE__TYPE:
            return basicSetType(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
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
        case ErlangPackage.LIST_TYPE__TYPE:
            return getType();
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
        case ErlangPackage.LIST_TYPE__TYPE:
            setType((TopType) newValue);
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
        case ErlangPackage.LIST_TYPE__TYPE:
            setType((TopType) null);
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
        case ErlangPackage.LIST_TYPE__TYPE:
            return type != null;
        }
        return super.eIsSet(featureID);
    }

} // ListTypeImpl
