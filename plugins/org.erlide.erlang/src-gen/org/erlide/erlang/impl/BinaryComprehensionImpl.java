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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.erlide.erlang.BinaryComprehension;
import org.erlide.erlang.ErlBinary;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.LCExpr;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Binary Comprehension</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.BinaryComprehensionImpl#getRoot <em>Root
 * </em>}</li>
 * <li>{@link org.erlide.erlang.impl.BinaryComprehensionImpl#getGenerators <em>
 * Generators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BinaryComprehensionImpl extends ErlBinaryImpl implements
        BinaryComprehension {
    /**
     * The cached value of the '{@link #getRoot() <em>Root</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRoot()
     * @generated
     * @ordered
     */
    protected ErlBinary root;

    /**
     * The cached value of the '{@link #getGenerators() <em>Generators</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getGenerators()
     * @generated
     * @ordered
     */
    protected EList<LCExpr> generators;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected BinaryComprehensionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.BINARY_COMPREHENSION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ErlBinary getRoot() {
        return root;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetRoot(final ErlBinary newRoot,
            NotificationChain msgs) {
        final ErlBinary oldRoot = root;
        root = newRoot;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.BINARY_COMPREHENSION__ROOT,
                    oldRoot, newRoot);
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
    public void setRoot(final ErlBinary newRoot) {
        if (newRoot != root) {
            NotificationChain msgs = null;
            if (root != null) {
                msgs = ((InternalEObject) root).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.BINARY_COMPREHENSION__ROOT,
                        null, msgs);
            }
            if (newRoot != null) {
                msgs = ((InternalEObject) newRoot).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.BINARY_COMPREHENSION__ROOT,
                        null, msgs);
            }
            msgs = basicSetRoot(newRoot, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.BINARY_COMPREHENSION__ROOT, newRoot, newRoot));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<LCExpr> getGenerators() {
        if (generators == null) {
            generators = new EObjectContainmentEList<LCExpr>(LCExpr.class,
                    this, ErlangPackage.BINARY_COMPREHENSION__GENERATORS);
        }
        return generators;
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
        case ErlangPackage.BINARY_COMPREHENSION__ROOT:
            return basicSetRoot(null, msgs);
        case ErlangPackage.BINARY_COMPREHENSION__GENERATORS:
            return ((InternalEList<?>) getGenerators()).basicRemove(otherEnd,
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
        case ErlangPackage.BINARY_COMPREHENSION__ROOT:
            return getRoot();
        case ErlangPackage.BINARY_COMPREHENSION__GENERATORS:
            return getGenerators();
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
        case ErlangPackage.BINARY_COMPREHENSION__ROOT:
            setRoot((ErlBinary) newValue);
            return;
        case ErlangPackage.BINARY_COMPREHENSION__GENERATORS:
            getGenerators().clear();
            getGenerators().addAll((Collection<? extends LCExpr>) newValue);
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
        case ErlangPackage.BINARY_COMPREHENSION__ROOT:
            setRoot((ErlBinary) null);
            return;
        case ErlangPackage.BINARY_COMPREHENSION__GENERATORS:
            getGenerators().clear();
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
        case ErlangPackage.BINARY_COMPREHENSION__ROOT:
            return root != null;
        case ErlangPackage.BINARY_COMPREHENSION__GENERATORS:
            return generators != null && !generators.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // BinaryComprehensionImpl
