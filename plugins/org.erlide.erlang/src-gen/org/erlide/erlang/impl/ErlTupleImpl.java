/**
 */
package org.erlide.erlang.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.erlide.erlang.ErlTuple;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Erl Tuple</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.ErlTupleImpl#getElements <em>Elements</em>}
 * </li>
 * </ul>
 *
 * @generated
 */
public class ErlTupleImpl extends ExpressionImpl implements ErlTuple {
    /**
     * The cached value of the '{@link #getElements() <em>Elements</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getElements()
     * @generated
     * @ordered
     */
    protected EList<Expression> elements;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ErlTupleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.ERL_TUPLE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Expression> getElements() {
        if (elements == null) {
            elements = new EObjectContainmentEList<Expression>(
                    Expression.class, this, ErlangPackage.ERL_TUPLE__ELEMENTS);
        }
        return elements;
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
        case ErlangPackage.ERL_TUPLE__ELEMENTS:
            return ((InternalEList<?>) getElements()).basicRemove(otherEnd,
                    msgs);
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
        case ErlangPackage.ERL_TUPLE__ELEMENTS:
            return getElements();
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
        case ErlangPackage.ERL_TUPLE__ELEMENTS:
            getElements().clear();
            getElements().addAll((Collection<? extends Expression>) newValue);
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
        case ErlangPackage.ERL_TUPLE__ELEMENTS:
            getElements().clear();
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
        case ErlangPackage.ERL_TUPLE__ELEMENTS:
            return elements != null && !elements.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // ErlTupleImpl
