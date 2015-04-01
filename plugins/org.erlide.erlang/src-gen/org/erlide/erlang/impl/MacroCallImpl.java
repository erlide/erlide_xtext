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
import org.erlide.erlang.Expression;
import org.erlide.erlang.Expressions;
import org.erlide.erlang.MacroCall;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Macro Call</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.MacroCallImpl#getMacroName <em>Macro Name
 * </em>}</li>
 * <li>{@link org.erlide.erlang.impl.MacroCallImpl#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MacroCallImpl extends MinimalEObjectImpl.Container implements
        MacroCall {
    /**
     * The cached value of the '{@link #getMacroName() <em>Macro Name</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMacroName()
     * @generated
     * @ordered
     */
    protected Expression macroName;

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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MacroCallImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.MACRO_CALL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expression getMacroName() {
        return macroName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetMacroName(final Expression newMacroName,
            NotificationChain msgs) {
        final Expression oldMacroName = macroName;
        macroName = newMacroName;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.MACRO_CALL__MACRO_NAME,
                    oldMacroName, newMacroName);
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
    public void setMacroName(final Expression newMacroName) {
        if (newMacroName != macroName) {
            NotificationChain msgs = null;
            if (macroName != null) {
                msgs = ((InternalEObject) macroName).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.MACRO_CALL__MACRO_NAME, null,
                        msgs);
            }
            if (newMacroName != null) {
                msgs = ((InternalEObject) newMacroName).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.MACRO_CALL__MACRO_NAME, null,
                        msgs);
            }
            msgs = basicSetMacroName(newMacroName, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.MACRO_CALL__MACRO_NAME, newMacroName,
                    newMacroName));
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
                    Notification.SET, ErlangPackage.MACRO_CALL__ARGS, oldArgs,
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
                msgs = ((InternalEObject) args)
                        .eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.MACRO_CALL__ARGS, null, msgs);
            }
            if (newArgs != null) {
                msgs = ((InternalEObject) newArgs)
                        .eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.MACRO_CALL__ARGS, null, msgs);
            }
            msgs = basicSetArgs(newArgs, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.MACRO_CALL__ARGS, newArgs, newArgs));
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
        case ErlangPackage.MACRO_CALL__MACRO_NAME:
            return basicSetMacroName(null, msgs);
        case ErlangPackage.MACRO_CALL__ARGS:
            return basicSetArgs(null, msgs);
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
        case ErlangPackage.MACRO_CALL__MACRO_NAME:
            return getMacroName();
        case ErlangPackage.MACRO_CALL__ARGS:
            return getArgs();
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
        case ErlangPackage.MACRO_CALL__MACRO_NAME:
            setMacroName((Expression) newValue);
            return;
        case ErlangPackage.MACRO_CALL__ARGS:
            setArgs((Expressions) newValue);
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
        case ErlangPackage.MACRO_CALL__MACRO_NAME:
            setMacroName((Expression) null);
            return;
        case ErlangPackage.MACRO_CALL__ARGS:
            setArgs((Expressions) null);
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
        case ErlangPackage.MACRO_CALL__MACRO_NAME:
            return macroName != null;
        case ErlangPackage.MACRO_CALL__ARGS:
            return args != null;
        }
        return super.eIsSet(featureID);
    }

} // MacroCallImpl
