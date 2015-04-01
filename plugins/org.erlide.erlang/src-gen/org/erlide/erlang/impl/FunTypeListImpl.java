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
import org.erlide.erlang.FunTypeList;
import org.erlide.erlang.TopType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Fun Type List</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.FunTypeListImpl#getItems <em>Items</em>}</li>
 * <li>{@link org.erlide.erlang.impl.FunTypeListImpl#getReturn <em>Return</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunTypeListImpl extends FunType100Impl implements FunTypeList {
    /**
     * The cached value of the '{@link #getItems() <em>Items</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getItems()
     * @generated
     * @ordered
     */
    protected EList<TopType> items;

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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected FunTypeListImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.FUN_TYPE_LIST;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<TopType> getItems() {
        if (items == null) {
            items = new EObjectContainmentEList<TopType>(TopType.class, this,
                    ErlangPackage.FUN_TYPE_LIST__ITEMS);
        }
        return items;
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
                    Notification.SET, ErlangPackage.FUN_TYPE_LIST__RETURN,
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
                msgs = ((InternalEObject) return_).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.FUN_TYPE_LIST__RETURN, null,
                        msgs);
            }
            if (newReturn != null) {
                msgs = ((InternalEObject) newReturn).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.FUN_TYPE_LIST__RETURN, null,
                        msgs);
            }
            msgs = basicSetReturn(newReturn, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.FUN_TYPE_LIST__RETURN, newReturn, newReturn));
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
        case ErlangPackage.FUN_TYPE_LIST__ITEMS:
            return ((InternalEList<?>) getItems()).basicRemove(otherEnd, msgs);
        case ErlangPackage.FUN_TYPE_LIST__RETURN:
            return basicSetReturn(null, msgs);
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
        case ErlangPackage.FUN_TYPE_LIST__ITEMS:
            return getItems();
        case ErlangPackage.FUN_TYPE_LIST__RETURN:
            return getReturn();
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
        case ErlangPackage.FUN_TYPE_LIST__ITEMS:
            getItems().clear();
            getItems().addAll((Collection<? extends TopType>) newValue);
            return;
        case ErlangPackage.FUN_TYPE_LIST__RETURN:
            setReturn((TopType) newValue);
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
        case ErlangPackage.FUN_TYPE_LIST__ITEMS:
            getItems().clear();
            return;
        case ErlangPackage.FUN_TYPE_LIST__RETURN:
            setReturn((TopType) null);
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
        case ErlangPackage.FUN_TYPE_LIST__ITEMS:
            return items != null && !items.isEmpty();
        case ErlangPackage.FUN_TYPE_LIST__RETURN:
            return return_ != null;
        }
        return super.eIsSet(featureID);
    }

} // FunTypeListImpl
