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
import org.erlide.erlang.RemoteTarget;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Remote Target</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.RemoteTargetImpl#getModule <em>Module</em>}
 * </li>
 * <li>{@link org.erlide.erlang.impl.RemoteTargetImpl#getFunction <em>Function
 * </em>}</li>
 * </ul>
 *
 * @generated
 */
public class RemoteTargetImpl extends ExpressionImpl implements RemoteTarget {
    /**
     * The cached value of the '{@link #getModule() <em>Module</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getModule()
     * @generated
     * @ordered
     */
    protected Expression module;

    /**
     * The cached value of the '{@link #getFunction() <em>Function</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getFunction()
     * @generated
     * @ordered
     */
    protected Expression function;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected RemoteTargetImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.REMOTE_TARGET;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expression getModule() {
        return module;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetModule(final Expression newModule,
            NotificationChain msgs) {
        final Expression oldModule = module;
        module = newModule;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.REMOTE_TARGET__MODULE,
                    oldModule, newModule);
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
    public void setModule(final Expression newModule) {
        if (newModule != module) {
            NotificationChain msgs = null;
            if (module != null) {
                msgs = ((InternalEObject) module).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.REMOTE_TARGET__MODULE, null,
                        msgs);
            }
            if (newModule != null) {
                msgs = ((InternalEObject) newModule).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.REMOTE_TARGET__MODULE, null,
                        msgs);
            }
            msgs = basicSetModule(newModule, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.REMOTE_TARGET__MODULE, newModule, newModule));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expression getFunction() {
        return function;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetFunction(final Expression newFunction,
            NotificationChain msgs) {
        final Expression oldFunction = function;
        function = newFunction;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.REMOTE_TARGET__FUNCTION,
                    oldFunction, newFunction);
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
    public void setFunction(final Expression newFunction) {
        if (newFunction != function) {
            NotificationChain msgs = null;
            if (function != null) {
                msgs = ((InternalEObject) function).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.REMOTE_TARGET__FUNCTION, null,
                        msgs);
            }
            if (newFunction != null) {
                msgs = ((InternalEObject) newFunction).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.REMOTE_TARGET__FUNCTION, null,
                        msgs);
            }
            msgs = basicSetFunction(newFunction, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.REMOTE_TARGET__FUNCTION, newFunction,
                    newFunction));
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
        case ErlangPackage.REMOTE_TARGET__MODULE:
            return basicSetModule(null, msgs);
        case ErlangPackage.REMOTE_TARGET__FUNCTION:
            return basicSetFunction(null, msgs);
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
        case ErlangPackage.REMOTE_TARGET__MODULE:
            return getModule();
        case ErlangPackage.REMOTE_TARGET__FUNCTION:
            return getFunction();
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
        case ErlangPackage.REMOTE_TARGET__MODULE:
            setModule((Expression) newValue);
            return;
        case ErlangPackage.REMOTE_TARGET__FUNCTION:
            setFunction((Expression) newValue);
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
        case ErlangPackage.REMOTE_TARGET__MODULE:
            setModule((Expression) null);
            return;
        case ErlangPackage.REMOTE_TARGET__FUNCTION:
            setFunction((Expression) null);
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
        case ErlangPackage.REMOTE_TARGET__MODULE:
            return module != null;
        case ErlangPackage.REMOTE_TARGET__FUNCTION:
            return function != null;
        }
        return super.eIsSet(featureID);
    }

} // RemoteTargetImpl
