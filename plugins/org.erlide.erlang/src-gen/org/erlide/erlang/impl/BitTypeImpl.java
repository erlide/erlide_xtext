/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.erlide.erlang.AtomRefTarget;
import org.erlide.erlang.BitType;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Bit Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.BitTypeImpl#getTypeName <em>Type Name</em>}
 * </li>
 * <li>{@link org.erlide.erlang.impl.BitTypeImpl#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BitTypeImpl extends MinimalEObjectImpl.Container implements
        BitType {
    /**
     * The cached value of the '{@link #getTypeName() <em>Type Name</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTypeName()
     * @generated
     * @ordered
     */
    protected AtomRefTarget typeName;

    /**
     * The cached value of the '{@link #getSize() <em>Size</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSize()
     * @generated
     * @ordered
     */
    protected Expression size;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected BitTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.BIT_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AtomRefTarget getTypeName() {
        if (typeName != null && typeName.eIsProxy()) {
            final InternalEObject oldTypeName = (InternalEObject) typeName;
            typeName = (AtomRefTarget) eResolveProxy(oldTypeName);
            if (typeName != oldTypeName) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ErlangPackage.BIT_TYPE__TYPE_NAME, oldTypeName,
                            typeName));
                }
            }
        }
        return typeName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AtomRefTarget basicGetTypeName() {
        return typeName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setTypeName(final AtomRefTarget newTypeName) {
        final AtomRefTarget oldTypeName = typeName;
        typeName = newTypeName;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.BIT_TYPE__TYPE_NAME, oldTypeName, typeName));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expression getSize() {
        return size;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetSize(final Expression newSize,
            NotificationChain msgs) {
        final Expression oldSize = size;
        size = newSize;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.BIT_TYPE__SIZE, oldSize,
                    newSize);
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
    public void setSize(final Expression newSize) {
        if (newSize != size) {
            NotificationChain msgs = null;
            if (size != null) {
                msgs = ((InternalEObject) size).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.BIT_TYPE__SIZE,
                        null, msgs);
            }
            if (newSize != null) {
                msgs = ((InternalEObject) newSize).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.BIT_TYPE__SIZE,
                        null, msgs);
            }
            msgs = basicSetSize(newSize, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.BIT_TYPE__SIZE, newSize, newSize));
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
        case ErlangPackage.BIT_TYPE__SIZE:
            return basicSetSize(null, msgs);
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
        case ErlangPackage.BIT_TYPE__TYPE_NAME:
            if (resolve) {
                return getTypeName();
            }
            return basicGetTypeName();
        case ErlangPackage.BIT_TYPE__SIZE:
            return getSize();
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
        case ErlangPackage.BIT_TYPE__TYPE_NAME:
            setTypeName((AtomRefTarget) newValue);
            return;
        case ErlangPackage.BIT_TYPE__SIZE:
            setSize((Expression) newValue);
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
        case ErlangPackage.BIT_TYPE__TYPE_NAME:
            setTypeName((AtomRefTarget) null);
            return;
        case ErlangPackage.BIT_TYPE__SIZE:
            setSize((Expression) null);
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
        case ErlangPackage.BIT_TYPE__TYPE_NAME:
            return typeName != null;
        case ErlangPackage.BIT_TYPE__SIZE:
            return size != null;
        }
        return super.eIsSet(featureID);
    }

} // BitTypeImpl
