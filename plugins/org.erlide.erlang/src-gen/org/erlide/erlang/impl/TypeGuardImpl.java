/**
 */
package org.erlide.erlang.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;
import org.erlide.erlang.TopType;
import org.erlide.erlang.TypeGuard;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Type Guard</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.TypeGuardImpl#getTypeName <em>Type Name
 * </em>}</li>
 * <li>{@link org.erlide.erlang.impl.TypeGuardImpl#getTypes <em>Types</em>}</li>
 * <li>{@link org.erlide.erlang.impl.TypeGuardImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeGuardImpl extends MinimalEObjectImpl.Container implements
        TypeGuard {
    /**
     * The cached value of the '{@link #getTypeName() <em>Type Name</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTypeName()
     * @generated
     * @ordered
     */
    protected Expression typeName;

    /**
     * The cached value of the '{@link #getTypes() <em>Types</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTypes()
     * @generated
     * @ordered
     */
    protected EList<TopType> types;

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
    protected TypeGuardImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.TYPE_GUARD;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expression getTypeName() {
        return typeName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetTypeName(final Expression newTypeName,
            NotificationChain msgs) {
        final Expression oldTypeName = typeName;
        typeName = newTypeName;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.TYPE_GUARD__TYPE_NAME,
                    oldTypeName, newTypeName);
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
    public void setTypeName(final Expression newTypeName) {
        if (newTypeName != typeName) {
            NotificationChain msgs = null;
            if (typeName != null) {
                msgs = ((InternalEObject) typeName).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.TYPE_GUARD__TYPE_NAME, null,
                        msgs);
            }
            if (newTypeName != null) {
                msgs = ((InternalEObject) newTypeName).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.TYPE_GUARD__TYPE_NAME, null,
                        msgs);
            }
            msgs = basicSetTypeName(newTypeName, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.TYPE_GUARD__TYPE_NAME, newTypeName,
                    newTypeName));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<TopType> getTypes() {
        if (types == null) {
            types = new EObjectContainmentEList<TopType>(TopType.class, this,
                    ErlangPackage.TYPE_GUARD__TYPES);
        }
        return types;
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
                    Notification.SET, ErlangPackage.TYPE_GUARD__TYPE, oldType,
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
                                - ErlangPackage.TYPE_GUARD__TYPE, null, msgs);
            }
            if (newType != null) {
                msgs = ((InternalEObject) newType)
                        .eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.TYPE_GUARD__TYPE, null, msgs);
            }
            msgs = basicSetType(newType, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.TYPE_GUARD__TYPE, newType, newType));
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
        case ErlangPackage.TYPE_GUARD__TYPE_NAME:
            return basicSetTypeName(null, msgs);
        case ErlangPackage.TYPE_GUARD__TYPES:
            return ((InternalEList<?>) getTypes()).basicRemove(otherEnd, msgs);
        case ErlangPackage.TYPE_GUARD__TYPE:
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
        case ErlangPackage.TYPE_GUARD__TYPE_NAME:
            return getTypeName();
        case ErlangPackage.TYPE_GUARD__TYPES:
            return getTypes();
        case ErlangPackage.TYPE_GUARD__TYPE:
            return getType();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case ErlangPackage.TYPE_GUARD__TYPE_NAME:
            setTypeName((Expression) newValue);
            return;
        case ErlangPackage.TYPE_GUARD__TYPES:
            getTypes().clear();
            getTypes().addAll((Collection<? extends TopType>) newValue);
            return;
        case ErlangPackage.TYPE_GUARD__TYPE:
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
        case ErlangPackage.TYPE_GUARD__TYPE_NAME:
            setTypeName((Expression) null);
            return;
        case ErlangPackage.TYPE_GUARD__TYPES:
            getTypes().clear();
            return;
        case ErlangPackage.TYPE_GUARD__TYPE:
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
        case ErlangPackage.TYPE_GUARD__TYPE_NAME:
            return typeName != null;
        case ErlangPackage.TYPE_GUARD__TYPES:
            return types != null && !types.isEmpty();
        case ErlangPackage.TYPE_GUARD__TYPE:
            return type != null;
        }
        return super.eIsSet(featureID);
    }

} // TypeGuardImpl
