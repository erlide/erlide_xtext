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
import org.erlide.erlang.Expressions;
import org.erlide.erlang.Guard;
import org.erlide.erlang.IfClause;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>If Clause</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.IfClauseImpl#getGuard <em>Guard</em>}</li>
 * <li>{@link org.erlide.erlang.impl.IfClauseImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfClauseImpl extends MinimalEObjectImpl.Container implements
        IfClause {
    /**
     * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getGuard()
     * @generated
     * @ordered
     */
    protected Guard guard;

    /**
     * The cached value of the '{@link #getBody() <em>Body</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getBody()
     * @generated
     * @ordered
     */
    protected Expressions body;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IfClauseImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.IF_CLAUSE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Guard getGuard() {
        return guard;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetGuard(final Guard newGuard,
            NotificationChain msgs) {
        final Guard oldGuard = guard;
        guard = newGuard;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.IF_CLAUSE__GUARD, oldGuard,
                    newGuard);
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
    public void setGuard(final Guard newGuard) {
        if (newGuard != guard) {
            NotificationChain msgs = null;
            if (guard != null) {
                msgs = ((InternalEObject) guard)
                        .eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.IF_CLAUSE__GUARD, null, msgs);
            }
            if (newGuard != null) {
                msgs = ((InternalEObject) newGuard)
                        .eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.IF_CLAUSE__GUARD, null, msgs);
            }
            msgs = basicSetGuard(newGuard, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.IF_CLAUSE__GUARD, newGuard, newGuard));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expressions getBody() {
        return body;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetBody(final Expressions newBody,
            NotificationChain msgs) {
        final Expressions oldBody = body;
        body = newBody;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.IF_CLAUSE__BODY, oldBody,
                    newBody);
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
    public void setBody(final Expressions newBody) {
        if (newBody != body) {
            NotificationChain msgs = null;
            if (body != null) {
                msgs = ((InternalEObject) body).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.IF_CLAUSE__BODY,
                        null, msgs);
            }
            if (newBody != null) {
                msgs = ((InternalEObject) newBody).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.IF_CLAUSE__BODY,
                        null, msgs);
            }
            msgs = basicSetBody(newBody, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.IF_CLAUSE__BODY, newBody, newBody));
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
        case ErlangPackage.IF_CLAUSE__GUARD:
            return basicSetGuard(null, msgs);
        case ErlangPackage.IF_CLAUSE__BODY:
            return basicSetBody(null, msgs);
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
        case ErlangPackage.IF_CLAUSE__GUARD:
            return getGuard();
        case ErlangPackage.IF_CLAUSE__BODY:
            return getBody();
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
        case ErlangPackage.IF_CLAUSE__GUARD:
            setGuard((Guard) newValue);
            return;
        case ErlangPackage.IF_CLAUSE__BODY:
            setBody((Expressions) newValue);
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
        case ErlangPackage.IF_CLAUSE__GUARD:
            setGuard((Guard) null);
            return;
        case ErlangPackage.IF_CLAUSE__BODY:
            setBody((Expressions) null);
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
        case ErlangPackage.IF_CLAUSE__GUARD:
            return guard != null;
        case ErlangPackage.IF_CLAUSE__BODY:
            return body != null;
        }
        return super.eIsSet(featureID);
    }

} // IfClauseImpl
