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
import org.erlide.erlang.UnaryExpr;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Unary Expr</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.UnaryExprImpl#getOp <em>Op</em>}</li>
 * <li>{@link org.erlide.erlang.impl.UnaryExprImpl#getOperand <em>Operand</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnaryExprImpl extends ExpressionImpl implements UnaryExpr {
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
     * The cached value of the '{@link #getOperand() <em>Operand</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOperand()
     * @generated
     * @ordered
     */
    protected Expression operand;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected UnaryExprImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.UNARY_EXPR;
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
                    ErlangPackage.UNARY_EXPR__OP, oldOp, op));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expression getOperand() {
        return operand;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetOperand(final Expression newOperand,
            NotificationChain msgs) {
        final Expression oldOperand = operand;
        operand = newOperand;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.UNARY_EXPR__OPERAND,
                    oldOperand, newOperand);
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
    public void setOperand(final Expression newOperand) {
        if (newOperand != operand) {
            NotificationChain msgs = null;
            if (operand != null) {
                msgs = ((InternalEObject) operand)
                        .eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.UNARY_EXPR__OPERAND, null, msgs);
            }
            if (newOperand != null) {
                msgs = ((InternalEObject) newOperand)
                        .eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.UNARY_EXPR__OPERAND, null, msgs);
            }
            msgs = basicSetOperand(newOperand, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.UNARY_EXPR__OPERAND, newOperand, newOperand));
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
        case ErlangPackage.UNARY_EXPR__OPERAND:
            return basicSetOperand(null, msgs);
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
        case ErlangPackage.UNARY_EXPR__OP:
            return getOp();
        case ErlangPackage.UNARY_EXPR__OPERAND:
            return getOperand();
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
        case ErlangPackage.UNARY_EXPR__OP:
            setOp((String) newValue);
            return;
        case ErlangPackage.UNARY_EXPR__OPERAND:
            setOperand((Expression) newValue);
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
        case ErlangPackage.UNARY_EXPR__OP:
            setOp(OP_EDEFAULT);
            return;
        case ErlangPackage.UNARY_EXPR__OPERAND:
            setOperand((Expression) null);
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
        case ErlangPackage.UNARY_EXPR__OP:
            return OP_EDEFAULT == null ? op != null : !OP_EDEFAULT.equals(op);
        case ErlangPackage.UNARY_EXPR__OPERAND:
            return operand != null;
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

} // UnaryExprImpl
