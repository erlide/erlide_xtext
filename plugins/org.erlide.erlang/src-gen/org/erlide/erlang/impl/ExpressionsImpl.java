/**
 */
package org.erlide.erlang.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Expressions;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Expressions</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.ExpressionsImpl#getExprs <em>Exprs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpressionsImpl extends MinimalEObjectImpl.Container implements
        Expressions {
    /**
     * The cached value of the '{@link #getExprs() <em>Exprs</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getExprs()
     * @generated
     * @ordered
     */
    protected EList<Expression> exprs;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ExpressionsImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.EXPRESSIONS;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Expression> getExprs() {
        if (exprs == null) {
            exprs = new EObjectContainmentEList<Expression>(Expression.class,
                    this, ErlangPackage.EXPRESSIONS__EXPRS);
        }
        return exprs;
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
        case ErlangPackage.EXPRESSIONS__EXPRS:
            return ((InternalEList<?>) getExprs()).basicRemove(otherEnd, msgs);
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
        case ErlangPackage.EXPRESSIONS__EXPRS:
            return getExprs();
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
        case ErlangPackage.EXPRESSIONS__EXPRS:
            getExprs().clear();
            getExprs().addAll((Collection<? extends Expression>) newValue);
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
        case ErlangPackage.EXPRESSIONS__EXPRS:
            getExprs().clear();
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
        case ErlangPackage.EXPRESSIONS__EXPRS:
            return exprs != null && !exprs.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // ExpressionsImpl
