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
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Form;
import org.erlide.erlang.Module;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Module</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.ModuleImpl#getForms <em>Forms</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModuleImpl extends AtomRefTargetImpl implements Module {
    /**
     * The cached value of the '{@link #getForms() <em>Forms</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getForms()
     * @generated
     * @ordered
     */
    protected EList<Form> forms;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ModuleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.MODULE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Form> getForms() {
        if (forms == null) {
            forms = new EObjectContainmentEList<Form>(Form.class, this,
                    ErlangPackage.MODULE__FORMS);
        }
        return forms;
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
        case ErlangPackage.MODULE__FORMS:
            return ((InternalEList<?>) getForms()).basicRemove(otherEnd, msgs);
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
        case ErlangPackage.MODULE__FORMS:
            return getForms();
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
        case ErlangPackage.MODULE__FORMS:
            getForms().clear();
            getForms().addAll((Collection<? extends Form>) newValue);
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
        case ErlangPackage.MODULE__FORMS:
            getForms().clear();
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
        case ErlangPackage.MODULE__FORMS:
            return forms != null && !forms.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // ModuleImpl
