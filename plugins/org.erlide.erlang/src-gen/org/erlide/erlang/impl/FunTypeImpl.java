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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.FunType;
import org.erlide.erlang.FunType100;
import org.erlide.erlang.TopType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Fun Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.FunTypeImpl#getArgs <em>Args</em>}</li>
 * <li>{@link org.erlide.erlang.impl.FunTypeImpl#getReturn <em>Return</em>}</li>
 * <li>{@link org.erlide.erlang.impl.FunTypeImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunTypeImpl extends TypeImpl implements FunType {
    /**
     * The cached value of the '{@link #getArgs() <em>Args</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getArgs()
     * @generated
     * @ordered
     */
    protected EList<TopType> args;

    /**
     * The cached value of the '{@link #getReturn() <em>Return</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getReturn()
     * @generated
     * @ordered
     */
    protected TopType return_;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected FunType100 type;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected FunTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.FUN_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<TopType> getArgs() {
        if (args == null) {
            args = new EObjectContainmentEList<TopType>(TopType.class, this,
                    ErlangPackage.FUN_TYPE__ARGS);
        }
        return args;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TopType getReturn() {
        return return_;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetReturn(final TopType newReturn,
            NotificationChain msgs) {
        final TopType oldReturn = return_;
        return_ = newReturn;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.FUN_TYPE__RETURN,
                    oldReturn, newReturn);
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
    public void setReturn(final TopType newReturn) {
        if (newReturn != return_) {
            NotificationChain msgs = null;
            if (return_ != null) {
                msgs = ((InternalEObject) return_)
                        .eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.FUN_TYPE__RETURN, null, msgs);
            }
            if (newReturn != null) {
                msgs = ((InternalEObject) newReturn)
                        .eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.FUN_TYPE__RETURN, null, msgs);
            }
            msgs = basicSetReturn(newReturn, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.FUN_TYPE__RETURN, newReturn, newReturn));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public FunType100 getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetType(final FunType100 newType,
            NotificationChain msgs) {
        final FunType100 oldType = type;
        type = newType;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.FUN_TYPE__TYPE, oldType,
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
    public void setType(final FunType100 newType) {
        if (newType != type) {
            NotificationChain msgs = null;
            if (type != null) {
                msgs = ((InternalEObject) type).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_TYPE__TYPE,
                        null, msgs);
            }
            if (newType != null) {
                msgs = ((InternalEObject) newType).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_TYPE__TYPE,
                        null, msgs);
            }
            msgs = basicSetType(newType, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.FUN_TYPE__TYPE, newType, newType));
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
        case ErlangPackage.FUN_TYPE__ARGS:
            return ((InternalEList<?>) getArgs()).basicRemove(otherEnd, msgs);
        case ErlangPackage.FUN_TYPE__RETURN:
            return basicSetReturn(null, msgs);
        case ErlangPackage.FUN_TYPE__TYPE:
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
        case ErlangPackage.FUN_TYPE__ARGS:
            return getArgs();
        case ErlangPackage.FUN_TYPE__RETURN:
            return getReturn();
        case ErlangPackage.FUN_TYPE__TYPE:
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
        case ErlangPackage.FUN_TYPE__ARGS:
            getArgs().clear();
            getArgs().addAll((Collection<? extends TopType>) newValue);
            return;
        case ErlangPackage.FUN_TYPE__RETURN:
            setReturn((TopType) newValue);
            return;
        case ErlangPackage.FUN_TYPE__TYPE:
            setType((FunType100) newValue);
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
        case ErlangPackage.FUN_TYPE__ARGS:
            getArgs().clear();
            return;
        case ErlangPackage.FUN_TYPE__RETURN:
            setReturn((TopType) null);
            return;
        case ErlangPackage.FUN_TYPE__TYPE:
            setType((FunType100) null);
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
        case ErlangPackage.FUN_TYPE__ARGS:
            return args != null && !args.isEmpty();
        case ErlangPackage.FUN_TYPE__RETURN:
            return return_ != null;
        case ErlangPackage.FUN_TYPE__TYPE:
            return type != null;
        }
        return super.eIsSet(featureID);
    }

} // FunTypeImpl
