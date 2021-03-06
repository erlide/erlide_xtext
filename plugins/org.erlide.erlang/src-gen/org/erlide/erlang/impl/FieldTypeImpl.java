/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.FieldType;
import org.erlide.erlang.TopType;
import org.erlide.erlang.TypeAttribute;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Field Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.FieldTypeImpl#getTypeName <em>Type Name
 * </em>}</li>
 * <li>{@link org.erlide.erlang.impl.FieldTypeImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FieldTypeImpl extends MinimalEObjectImpl.Container implements
        FieldType {
    /**
     * The cached value of the '{@link #getTypeName() <em>Type Name</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTypeName()
     * @generated
     * @ordered
     */
    protected TypeAttribute typeName;

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
    protected FieldTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.FIELD_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TypeAttribute getTypeName() {
        if (typeName != null && typeName.eIsProxy()) {
            final InternalEObject oldTypeName = (InternalEObject) typeName;
            typeName = (TypeAttribute) eResolveProxy(oldTypeName);
            if (typeName != oldTypeName) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ErlangPackage.FIELD_TYPE__TYPE_NAME, oldTypeName,
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
    public TypeAttribute basicGetTypeName() {
        return typeName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setTypeName(final TypeAttribute newTypeName) {
        final TypeAttribute oldTypeName = typeName;
        typeName = newTypeName;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.FIELD_TYPE__TYPE_NAME, oldTypeName, typeName));
        }
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
                    Notification.SET, ErlangPackage.FIELD_TYPE__TYPE, oldType,
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
                msgs = ((InternalEObject) type)
                        .eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.FIELD_TYPE__TYPE, null, msgs);
            }
            if (newType != null) {
                msgs = ((InternalEObject) newType)
                        .eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.FIELD_TYPE__TYPE, null, msgs);
            }
            msgs = basicSetType(newType, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.FIELD_TYPE__TYPE, newType, newType));
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
        case ErlangPackage.FIELD_TYPE__TYPE:
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
        case ErlangPackage.FIELD_TYPE__TYPE_NAME:
            if (resolve) {
                return getTypeName();
            }
            return basicGetTypeName();
        case ErlangPackage.FIELD_TYPE__TYPE:
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
        case ErlangPackage.FIELD_TYPE__TYPE_NAME:
            setTypeName((TypeAttribute) newValue);
            return;
        case ErlangPackage.FIELD_TYPE__TYPE:
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
        case ErlangPackage.FIELD_TYPE__TYPE_NAME:
            setTypeName((TypeAttribute) null);
            return;
        case ErlangPackage.FIELD_TYPE__TYPE:
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
        case ErlangPackage.FIELD_TYPE__TYPE_NAME:
            return typeName != null;
        case ErlangPackage.FIELD_TYPE__TYPE:
            return type != null;
        }
        return super.eIsSet(featureID);
    }

} // FieldTypeImpl
