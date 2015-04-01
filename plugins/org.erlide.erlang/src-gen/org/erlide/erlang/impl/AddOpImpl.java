/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.erlide.erlang.AddOp;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Add Op</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.AddOpImpl#getOpLeft <em>Op Left</em>}</li>
 * <li>{@link org.erlide.erlang.impl.AddOpImpl#getOp <em>Op</em>}</li>
 * <li>{@link org.erlide.erlang.impl.AddOpImpl#getOpRight <em>Op Right</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AddOpImpl extends ExpressionImpl implements AddOp {
    /**
     * The cached value of the '{@link #getOpLeft() <em>Op Left</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOpLeft()
     * @generated
     * @ordered
     */
    protected Expression opLeft;

    /**
     * The default value of the '{@link #getOp() <em>Op</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOp()
     * @generated
     * @ordered
     */
    protected static final String OP_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOp() <em>Op</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOp()
     * @generated
     * @ordered
     */
    protected String op = OP_EDEFAULT;

    /**
     * The cached value of the '{@link #getOpRight() <em>Op Right</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOpRight()
     * @generated
     * @ordered
     */
    protected Expression opRight;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AddOpImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.ADD_OP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expression getOpLeft() {
        return opLeft;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetOpLeft(final Expression newOpLeft,
            NotificationChain msgs) {
        final Expression oldOpLeft = opLeft;
        opLeft = newOpLeft;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.ADD_OP__OP_LEFT, oldOpLeft,
                    newOpLeft);
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
    public void setOpLeft(final Expression newOpLeft) {
        if (newOpLeft != opLeft) {
            NotificationChain msgs = null;
            if (opLeft != null) {
                msgs = ((InternalEObject) opLeft).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.ADD_OP__OP_LEFT,
                        null, msgs);
            }
            if (newOpLeft != null) {
                msgs = ((InternalEObject) newOpLeft).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.ADD_OP__OP_LEFT,
                        null, msgs);
            }
            msgs = basicSetOpLeft(newOpLeft, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.ADD_OP__OP_LEFT, newOpLeft, newOpLeft));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getOp() {
        return op;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOp(final String newOp) {
        final String oldOp = op;
        op = newOp;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.ADD_OP__OP, oldOp, op));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expression getOpRight() {
        return opRight;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetOpRight(final Expression newOpRight,
            NotificationChain msgs) {
        final Expression oldOpRight = opRight;
        opRight = newOpRight;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.ADD_OP__OP_RIGHT,
                    oldOpRight, newOpRight);
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
    public void setOpRight(final Expression newOpRight) {
        if (newOpRight != opRight) {
            NotificationChain msgs = null;
            if (opRight != null) {
                msgs = ((InternalEObject) opRight)
                        .eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.ADD_OP__OP_RIGHT, null, msgs);
            }
            if (newOpRight != null) {
                msgs = ((InternalEObject) newOpRight)
                        .eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.ADD_OP__OP_RIGHT, null, msgs);
            }
            msgs = basicSetOpRight(newOpRight, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.ADD_OP__OP_RIGHT, newOpRight, newOpRight));
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
        case ErlangPackage.ADD_OP__OP_LEFT:
            return basicSetOpLeft(null, msgs);
        case ErlangPackage.ADD_OP__OP_RIGHT:
            return basicSetOpRight(null, msgs);
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
        case ErlangPackage.ADD_OP__OP_LEFT:
            return getOpLeft();
        case ErlangPackage.ADD_OP__OP:
            return getOp();
        case ErlangPackage.ADD_OP__OP_RIGHT:
            return getOpRight();
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
        case ErlangPackage.ADD_OP__OP_LEFT:
            setOpLeft((Expression) newValue);
            return;
        case ErlangPackage.ADD_OP__OP:
            setOp((String) newValue);
            return;
        case ErlangPackage.ADD_OP__OP_RIGHT:
            setOpRight((Expression) newValue);
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
        case ErlangPackage.ADD_OP__OP_LEFT:
            setOpLeft((Expression) null);
            return;
        case ErlangPackage.ADD_OP__OP:
            setOp(OP_EDEFAULT);
            return;
        case ErlangPackage.ADD_OP__OP_RIGHT:
            setOpRight((Expression) null);
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
        case ErlangPackage.ADD_OP__OP_LEFT:
            return opLeft != null;
        case ErlangPackage.ADD_OP__OP:
            return OP_EDEFAULT == null ? op != null : !OP_EDEFAULT.equals(op);
        case ErlangPackage.ADD_OP__OP_RIGHT:
            return opRight != null;
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
        result.append(" (op: ");
        result.append(op);
        result.append(')');
        return result.toString();
    }

} // AddOpImpl
