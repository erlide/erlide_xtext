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
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;
import org.erlide.erlang.RemoteType;
import org.erlide.erlang.TopType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Remote Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.RemoteTypeImpl#getM <em>M</em>}</li>
 * <li>{@link org.erlide.erlang.impl.RemoteTypeImpl#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RemoteTypeImpl extends TypeImpl implements RemoteType {
    /**
     * The cached value of the '{@link #getM() <em>M</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getM()
     * @generated
     * @ordered
     */
    protected Expression m;

    /**
     * The cached value of the '{@link #getArgs() <em>Args</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getArgs()
     * @generated
     * @ordered
     */
    protected EList<TopType> args;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected RemoteTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.REMOTE_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expression getM() {
        return m;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetM(final Expression newM,
            NotificationChain msgs) {
        final Expression oldM = m;
        m = newM;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.REMOTE_TYPE__M, oldM, newM);
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
    public void setM(final Expression newM) {
        if (newM != m) {
            NotificationChain msgs = null;
            if (m != null) {
                msgs = ((InternalEObject) m).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.REMOTE_TYPE__M,
                        null, msgs);
            }
            if (newM != null) {
                msgs = ((InternalEObject) newM).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.REMOTE_TYPE__M,
                        null, msgs);
            }
            msgs = basicSetM(newM, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.REMOTE_TYPE__M, newM, newM));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<TopType> getArgs() {
        if (args == null) {
            args = new EObjectContainmentEList<TopType>(TopType.class, this,
                    ErlangPackage.REMOTE_TYPE__ARGS);
        }
        return args;
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
        case ErlangPackage.REMOTE_TYPE__M:
            return basicSetM(null, msgs);
        case ErlangPackage.REMOTE_TYPE__ARGS:
            return ((InternalEList<?>) getArgs()).basicRemove(otherEnd, msgs);
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
        case ErlangPackage.REMOTE_TYPE__M:
            return getM();
        case ErlangPackage.REMOTE_TYPE__ARGS:
            return getArgs();
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
        case ErlangPackage.REMOTE_TYPE__M:
            setM((Expression) newValue);
            return;
        case ErlangPackage.REMOTE_TYPE__ARGS:
            getArgs().clear();
            getArgs().addAll((Collection<? extends TopType>) newValue);
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
        case ErlangPackage.REMOTE_TYPE__M:
            setM((Expression) null);
            return;
        case ErlangPackage.REMOTE_TYPE__ARGS:
            getArgs().clear();
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
        case ErlangPackage.REMOTE_TYPE__M:
            return m != null;
        case ErlangPackage.REMOTE_TYPE__ARGS:
            return args != null && !args.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // RemoteTypeImpl
