/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.MacroCall;
import org.erlide.erlang.MacroForm;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Macro Form</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.MacroFormImpl#getCall <em>Call</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MacroFormImpl extends FormImpl implements MacroForm {
    /**
     * The cached value of the '{@link #getCall() <em>Call</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getCall()
     * @generated
     * @ordered
     */
    protected MacroCall call;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MacroFormImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.MACRO_FORM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MacroCall getCall() {
        return call;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetCall(final MacroCall newCall,
            NotificationChain msgs) {
        final MacroCall oldCall = call;
        call = newCall;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.MACRO_FORM__CALL, oldCall,
                    newCall);
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
    public void setCall(final MacroCall newCall) {
        if (newCall != call) {
            NotificationChain msgs = null;
            if (call != null) {
                msgs = ((InternalEObject) call)
                        .eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.MACRO_FORM__CALL, null, msgs);
            }
            if (newCall != null) {
                msgs = ((InternalEObject) newCall)
                        .eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.MACRO_FORM__CALL, null, msgs);
            }
            msgs = basicSetCall(newCall, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.MACRO_FORM__CALL, newCall, newCall));
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
        case ErlangPackage.MACRO_FORM__CALL:
            return basicSetCall(null, msgs);
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
        case ErlangPackage.MACRO_FORM__CALL:
            return getCall();
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
        case ErlangPackage.MACRO_FORM__CALL:
            setCall((MacroCall) newValue);
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
        case ErlangPackage.MACRO_FORM__CALL:
            setCall((MacroCall) null);
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
        case ErlangPackage.MACRO_FORM__CALL:
            return call != null;
        }
        return super.eIsSet(featureID);
    }

} // MacroFormImpl
