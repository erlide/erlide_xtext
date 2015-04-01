/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;
import org.erlide.erlang.UndefAttribute;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Undef Attribute</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.UndefAttributeImpl#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UndefAttributeImpl extends AbstractDefineAttributeImpl implements
        UndefAttribute {
    /**
     * The cached value of the '{@link #getRef() <em>Ref</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRef()
     * @generated
     * @ordered
     */
    protected Expression ref;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected UndefAttributeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.UNDEF_ATTRIBUTE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expression getRef() {
        return ref;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetRef(final Expression newRef,
            NotificationChain msgs) {
        final Expression oldRef = ref;
        ref = newRef;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.UNDEF_ATTRIBUTE__REF,
                    oldRef, newRef);
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
    public void setRef(final Expression newRef) {
        if (newRef != ref) {
            NotificationChain msgs = null;
            if (ref != null) {
                msgs = ((InternalEObject) ref).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.UNDEF_ATTRIBUTE__REF, null,
                        msgs);
            }
            if (newRef != null) {
                msgs = ((InternalEObject) newRef).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.UNDEF_ATTRIBUTE__REF, null,
                        msgs);
            }
            msgs = basicSetRef(newRef, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.UNDEF_ATTRIBUTE__REF, newRef, newRef));
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
        case ErlangPackage.UNDEF_ATTRIBUTE__REF:
            return basicSetRef(null, msgs);
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
        case ErlangPackage.UNDEF_ATTRIBUTE__REF:
            return getRef();
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
        case ErlangPackage.UNDEF_ATTRIBUTE__REF:
            setRef((Expression) newValue);
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
        case ErlangPackage.UNDEF_ATTRIBUTE__REF:
            setRef((Expression) null);
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
        case ErlangPackage.UNDEF_ATTRIBUTE__REF:
            return ref != null;
        }
        return super.eIsSet(featureID);
    }

} // UndefAttributeImpl
