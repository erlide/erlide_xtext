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
import org.erlide.erlang.Expressions;
import org.erlide.erlang.FunCall;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Fun Call</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.FunCallImpl#getTarget <em>Target</em>}</li>
 * <li>{@link org.erlide.erlang.impl.FunCallImpl#getArgs <em>Args</em>}</li>
 * <li>{@link org.erlide.erlang.impl.FunCallImpl#getArgs2 <em>Args2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunCallImpl extends ExpressionImpl implements FunCall {
    /**
     * The cached value of the '{@link #getTarget() <em>Target</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTarget()
     * @generated
     * @ordered
     */
    protected Expression target;

    /**
     * The cached value of the '{@link #getArgs() <em>Args</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getArgs()
     * @generated
     * @ordered
     */
    protected Expressions args;

    /**
     * The cached value of the '{@link #getArgs2() <em>Args2</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getArgs2()
     * @generated
     * @ordered
     */
    protected Expressions args2;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected FunCallImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.FUN_CALL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expression getTarget() {
        return target;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetTarget(final Expression newTarget,
            NotificationChain msgs) {
        final Expression oldTarget = target;
        target = newTarget;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.FUN_CALL__TARGET,
                    oldTarget, newTarget);
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
    public void setTarget(final Expression newTarget) {
        if (newTarget != target) {
            NotificationChain msgs = null;
            if (target != null) {
                msgs = ((InternalEObject) target)
                        .eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.FUN_CALL__TARGET, null, msgs);
            }
            if (newTarget != null) {
                msgs = ((InternalEObject) newTarget)
                        .eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.FUN_CALL__TARGET, null, msgs);
            }
            msgs = basicSetTarget(newTarget, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.FUN_CALL__TARGET, newTarget, newTarget));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expressions getArgs() {
        return args;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetArgs(final Expressions newArgs,
            NotificationChain msgs) {
        final Expressions oldArgs = args;
        args = newArgs;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.FUN_CALL__ARGS, oldArgs,
                    newArgs);
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
    public void setArgs(final Expressions newArgs) {
        if (newArgs != args) {
            NotificationChain msgs = null;
            if (args != null) {
                msgs = ((InternalEObject) args).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_CALL__ARGS,
                        null, msgs);
            }
            if (newArgs != null) {
                msgs = ((InternalEObject) newArgs).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_CALL__ARGS,
                        null, msgs);
            }
            msgs = basicSetArgs(newArgs, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.FUN_CALL__ARGS, newArgs, newArgs));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expressions getArgs2() {
        return args2;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetArgs2(final Expressions newArgs2,
            NotificationChain msgs) {
        final Expressions oldArgs2 = args2;
        args2 = newArgs2;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.FUN_CALL__ARGS2, oldArgs2,
                    newArgs2);
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
    public void setArgs2(final Expressions newArgs2) {
        if (newArgs2 != args2) {
            NotificationChain msgs = null;
            if (args2 != null) {
                msgs = ((InternalEObject) args2).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_CALL__ARGS2,
                        null, msgs);
            }
            if (newArgs2 != null) {
                msgs = ((InternalEObject) newArgs2).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_CALL__ARGS2,
                        null, msgs);
            }
            msgs = basicSetArgs2(newArgs2, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.FUN_CALL__ARGS2, newArgs2, newArgs2));
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
        case ErlangPackage.FUN_CALL__TARGET:
            return basicSetTarget(null, msgs);
        case ErlangPackage.FUN_CALL__ARGS:
            return basicSetArgs(null, msgs);
        case ErlangPackage.FUN_CALL__ARGS2:
            return basicSetArgs2(null, msgs);
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
        case ErlangPackage.FUN_CALL__TARGET:
            return getTarget();
        case ErlangPackage.FUN_CALL__ARGS:
            return getArgs();
        case ErlangPackage.FUN_CALL__ARGS2:
            return getArgs2();
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
        case ErlangPackage.FUN_CALL__TARGET:
            setTarget((Expression) newValue);
            return;
        case ErlangPackage.FUN_CALL__ARGS:
            setArgs((Expressions) newValue);
            return;
        case ErlangPackage.FUN_CALL__ARGS2:
            setArgs2((Expressions) newValue);
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
        case ErlangPackage.FUN_CALL__TARGET:
            setTarget((Expression) null);
            return;
        case ErlangPackage.FUN_CALL__ARGS:
            setArgs((Expressions) null);
            return;
        case ErlangPackage.FUN_CALL__ARGS2:
            setArgs2((Expressions) null);
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
        case ErlangPackage.FUN_CALL__TARGET:
            return target != null;
        case ErlangPackage.FUN_CALL__ARGS:
            return args != null;
        case ErlangPackage.FUN_CALL__ARGS2:
            return args2 != null;
        }
        return super.eIsSet(featureID);
    }

} // FunCallImpl
