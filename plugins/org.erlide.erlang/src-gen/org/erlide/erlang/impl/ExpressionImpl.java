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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;
import org.erlide.erlang.StringLiteralPart;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Expression</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.ExpressionImpl#isLine <em>Line</em>}</li>
 * <li>{@link org.erlide.erlang.impl.ExpressionImpl#getExpr <em>Expr</em>}</li>
 * <li>{@link org.erlide.erlang.impl.ExpressionImpl#getParts <em>Parts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpressionImpl extends MinimalEObjectImpl.Container implements
        Expression {
    /**
     * The default value of the '{@link #isLine() <em>Line</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isLine()
     * @generated
     * @ordered
     */
    protected static final boolean LINE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isLine() <em>Line</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isLine()
     * @generated
     * @ordered
     */
    protected boolean line = LINE_EDEFAULT;

    /**
     * The cached value of the '{@link #getExpr() <em>Expr</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getExpr()
     * @generated
     * @ordered
     */
    protected Expression expr;

    /**
     * The cached value of the '{@link #getParts() <em>Parts</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getParts()
     * @generated
     * @ordered
     */
    protected EList<StringLiteralPart> parts;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ExpressionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.EXPRESSION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isLine() {
        return line;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setLine(final boolean newLine) {
        final boolean oldLine = line;
        line = newLine;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.EXPRESSION__LINE, oldLine, line));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expression getExpr() {
        return expr;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetExpr(final Expression newExpr,
            NotificationChain msgs) {
        final Expression oldExpr = expr;
        expr = newExpr;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.EXPRESSION__EXPR, oldExpr,
                    newExpr);
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
    public void setExpr(final Expression newExpr) {
        if (newExpr != expr) {
            NotificationChain msgs = null;
            if (expr != null) {
                msgs = ((InternalEObject) expr)
                        .eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.EXPRESSION__EXPR, null, msgs);
            }
            if (newExpr != null) {
                msgs = ((InternalEObject) newExpr)
                        .eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.EXPRESSION__EXPR, null, msgs);
            }
            msgs = basicSetExpr(newExpr, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.EXPRESSION__EXPR, newExpr, newExpr));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<StringLiteralPart> getParts() {
        if (parts == null) {
            parts = new EObjectContainmentEList<StringLiteralPart>(
                    StringLiteralPart.class, this,
                    ErlangPackage.EXPRESSION__PARTS);
        }
        return parts;
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
        case ErlangPackage.EXPRESSION__EXPR:
            return basicSetExpr(null, msgs);
        case ErlangPackage.EXPRESSION__PARTS:
            return ((InternalEList<?>) getParts()).basicRemove(otherEnd, msgs);
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
        case ErlangPackage.EXPRESSION__LINE:
            return isLine();
        case ErlangPackage.EXPRESSION__EXPR:
            return getExpr();
        case ErlangPackage.EXPRESSION__PARTS:
            return getParts();
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
        case ErlangPackage.EXPRESSION__LINE:
            setLine((Boolean) newValue);
            return;
        case ErlangPackage.EXPRESSION__EXPR:
            setExpr((Expression) newValue);
            return;
        case ErlangPackage.EXPRESSION__PARTS:
            getParts().clear();
            getParts().addAll(
                    (Collection<? extends StringLiteralPart>) newValue);
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
        case ErlangPackage.EXPRESSION__LINE:
            setLine(LINE_EDEFAULT);
            return;
        case ErlangPackage.EXPRESSION__EXPR:
            setExpr((Expression) null);
            return;
        case ErlangPackage.EXPRESSION__PARTS:
            getParts().clear();
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
        case ErlangPackage.EXPRESSION__LINE:
            return line != LINE_EDEFAULT;
        case ErlangPackage.EXPRESSION__EXPR:
            return expr != null;
        case ErlangPackage.EXPRESSION__PARTS:
            return parts != null && !parts.isEmpty();
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
        result.append(" (line: ");
        result.append(line);
        result.append(')');
        return result.toString();
    }

} // ExpressionImpl
