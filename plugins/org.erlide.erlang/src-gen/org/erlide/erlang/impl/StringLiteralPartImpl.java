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
import org.erlide.erlang.MacroCall;
import org.erlide.erlang.StringLiteralPart;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>String Literal Part</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.StringLiteralPartImpl#getMacro <em>Macro
 * </em>}</li>
 * <li>{@link org.erlide.erlang.impl.StringLiteralPartImpl#getString <em>String
 * </em>}</li>
 * </ul>
 *
 * @generated
 */
public class StringLiteralPartImpl extends MinimalEObjectImpl.Container
        implements StringLiteralPart {
    /**
     * The cached value of the '{@link #getMacro() <em>Macro</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMacro()
     * @generated
     * @ordered
     */
    protected MacroCall macro;

    /**
     * The default value of the '{@link #getString() <em>String</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getString()
     * @generated
     * @ordered
     */
    protected static final String STRING_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getString() <em>String</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getString()
     * @generated
     * @ordered
     */
    protected String string = STRING_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected StringLiteralPartImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.STRING_LITERAL_PART;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MacroCall getMacro() {
        return macro;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetMacro(final MacroCall newMacro,
            NotificationChain msgs) {
        final MacroCall oldMacro = macro;
        macro = newMacro;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.STRING_LITERAL_PART__MACRO,
                    oldMacro, newMacro);
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
    public void setMacro(final MacroCall newMacro) {
        if (newMacro != macro) {
            NotificationChain msgs = null;
            if (macro != null) {
                msgs = ((InternalEObject) macro).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.STRING_LITERAL_PART__MACRO,
                        null, msgs);
            }
            if (newMacro != null) {
                msgs = ((InternalEObject) newMacro).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.STRING_LITERAL_PART__MACRO,
                        null, msgs);
            }
            msgs = basicSetMacro(newMacro, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.STRING_LITERAL_PART__MACRO, newMacro,
                    newMacro));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getString() {
        return string;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setString(final String newString) {
        final String oldString = string;
        string = newString;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.STRING_LITERAL_PART__STRING, oldString,
                    string));
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
        case ErlangPackage.STRING_LITERAL_PART__MACRO:
            return basicSetMacro(null, msgs);
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
        case ErlangPackage.STRING_LITERAL_PART__MACRO:
            return getMacro();
        case ErlangPackage.STRING_LITERAL_PART__STRING:
            return getString();
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
        case ErlangPackage.STRING_LITERAL_PART__MACRO:
            setMacro((MacroCall) newValue);
            return;
        case ErlangPackage.STRING_LITERAL_PART__STRING:
            setString((String) newValue);
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
        case ErlangPackage.STRING_LITERAL_PART__MACRO:
            setMacro((MacroCall) null);
            return;
        case ErlangPackage.STRING_LITERAL_PART__STRING:
            setString(STRING_EDEFAULT);
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
        case ErlangPackage.STRING_LITERAL_PART__MACRO:
            return macro != null;
        case ErlangPackage.STRING_LITERAL_PART__STRING:
            return STRING_EDEFAULT == null ? string != null : !STRING_EDEFAULT
                    .equals(string);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (string: ");
        result.append(string);
        result.append(')');
        return result.toString();
    }

} // StringLiteralPartImpl
