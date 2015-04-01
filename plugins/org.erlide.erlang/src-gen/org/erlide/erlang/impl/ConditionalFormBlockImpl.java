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
import org.erlide.erlang.ConditionalFormBlock;
import org.erlide.erlang.EndifAttribute;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Form;
import org.erlide.erlang.IfdefAttribute;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Conditional Form Block</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.ConditionalFormBlockImpl#getCondition <em>
 * Condition</em>}</li>
 * <li>{@link org.erlide.erlang.impl.ConditionalFormBlockImpl#getIfForms <em>If
 * Forms</em>}</li>
 * <li>{@link org.erlide.erlang.impl.ConditionalFormBlockImpl#isHasElse <em>Has
 * Else</em>}</li>
 * <li>{@link org.erlide.erlang.impl.ConditionalFormBlockImpl#getElseForms <em>
 * Else Forms</em>}</li>
 * <li>{@link org.erlide.erlang.impl.ConditionalFormBlockImpl#getEnd <em>End
 * </em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConditionalFormBlockImpl extends FormImpl implements
        ConditionalFormBlock {
    /**
     * The cached value of the '{@link #getCondition() <em>Condition</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getCondition()
     * @generated
     * @ordered
     */
    protected IfdefAttribute condition;

    /**
     * The cached value of the '{@link #getIfForms() <em>If Forms</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getIfForms()
     * @generated
     * @ordered
     */
    protected EList<Form> ifForms;

    /**
     * The default value of the '{@link #isHasElse() <em>Has Else</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isHasElse()
     * @generated
     * @ordered
     */
    protected static final boolean HAS_ELSE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isHasElse() <em>Has Else</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isHasElse()
     * @generated
     * @ordered
     */
    protected boolean hasElse = HAS_ELSE_EDEFAULT;

    /**
     * The cached value of the '{@link #getElseForms() <em>Else Forms</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getElseForms()
     * @generated
     * @ordered
     */
    protected EList<Form> elseForms;

    /**
     * The cached value of the '{@link #getEnd() <em>End</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getEnd()
     * @generated
     * @ordered
     */
    protected EndifAttribute end;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ConditionalFormBlockImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.CONDITIONAL_FORM_BLOCK;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public IfdefAttribute getCondition() {
        return condition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetCondition(
            final IfdefAttribute newCondition, NotificationChain msgs) {
        final IfdefAttribute oldCondition = condition;
        condition = newCondition;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET,
                    ErlangPackage.CONDITIONAL_FORM_BLOCK__CONDITION,
                    oldCondition, newCondition);
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
    public void setCondition(final IfdefAttribute newCondition) {
        if (newCondition != condition) {
            NotificationChain msgs = null;
            if (condition != null) {
                msgs = ((InternalEObject) condition)
                        .eInverseRemove(
                                this,
                                EOPPOSITE_FEATURE_BASE
                                        - ErlangPackage.CONDITIONAL_FORM_BLOCK__CONDITION,
                                null, msgs);
            }
            if (newCondition != null) {
                msgs = ((InternalEObject) newCondition)
                        .eInverseAdd(
                                this,
                                EOPPOSITE_FEATURE_BASE
                                        - ErlangPackage.CONDITIONAL_FORM_BLOCK__CONDITION,
                                null, msgs);
            }
            msgs = basicSetCondition(newCondition, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.CONDITIONAL_FORM_BLOCK__CONDITION,
                    newCondition, newCondition));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Form> getIfForms() {
        if (ifForms == null) {
            ifForms = new EObjectContainmentEList<Form>(Form.class, this,
                    ErlangPackage.CONDITIONAL_FORM_BLOCK__IF_FORMS);
        }
        return ifForms;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isHasElse() {
        return hasElse;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setHasElse(final boolean newHasElse) {
        final boolean oldHasElse = hasElse;
        hasElse = newHasElse;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.CONDITIONAL_FORM_BLOCK__HAS_ELSE, oldHasElse,
                    hasElse));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Form> getElseForms() {
        if (elseForms == null) {
            elseForms = new EObjectContainmentEList<Form>(Form.class, this,
                    ErlangPackage.CONDITIONAL_FORM_BLOCK__ELSE_FORMS);
        }
        return elseForms;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EndifAttribute getEnd() {
        return end;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetEnd(final EndifAttribute newEnd,
            NotificationChain msgs) {
        final EndifAttribute oldEnd = end;
        end = newEnd;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET,
                    ErlangPackage.CONDITIONAL_FORM_BLOCK__END, oldEnd, newEnd);
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
    public void setEnd(final EndifAttribute newEnd) {
        if (newEnd != end) {
            NotificationChain msgs = null;
            if (end != null) {
                msgs = ((InternalEObject) end).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.CONDITIONAL_FORM_BLOCK__END,
                        null, msgs);
            }
            if (newEnd != null) {
                msgs = ((InternalEObject) newEnd).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.CONDITIONAL_FORM_BLOCK__END,
                        null, msgs);
            }
            msgs = basicSetEnd(newEnd, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.CONDITIONAL_FORM_BLOCK__END, newEnd, newEnd));
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
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__CONDITION:
            return basicSetCondition(null, msgs);
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__IF_FORMS:
            return ((InternalEList<?>) getIfForms())
                    .basicRemove(otherEnd, msgs);
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__ELSE_FORMS:
            return ((InternalEList<?>) getElseForms()).basicRemove(otherEnd,
                    msgs);
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__END:
            return basicSetEnd(null, msgs);
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
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__CONDITION:
            return getCondition();
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__IF_FORMS:
            return getIfForms();
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__HAS_ELSE:
            return isHasElse();
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__ELSE_FORMS:
            return getElseForms();
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__END:
            return getEnd();
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
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__CONDITION:
            setCondition((IfdefAttribute) newValue);
            return;
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__IF_FORMS:
            getIfForms().clear();
            getIfForms().addAll((Collection<? extends Form>) newValue);
            return;
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__HAS_ELSE:
            setHasElse((Boolean) newValue);
            return;
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__ELSE_FORMS:
            getElseForms().clear();
            getElseForms().addAll((Collection<? extends Form>) newValue);
            return;
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__END:
            setEnd((EndifAttribute) newValue);
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
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__CONDITION:
            setCondition((IfdefAttribute) null);
            return;
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__IF_FORMS:
            getIfForms().clear();
            return;
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__HAS_ELSE:
            setHasElse(HAS_ELSE_EDEFAULT);
            return;
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__ELSE_FORMS:
            getElseForms().clear();
            return;
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__END:
            setEnd((EndifAttribute) null);
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
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__CONDITION:
            return condition != null;
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__IF_FORMS:
            return ifForms != null && !ifForms.isEmpty();
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__HAS_ELSE:
            return hasElse != HAS_ELSE_EDEFAULT;
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__ELSE_FORMS:
            return elseForms != null && !elseForms.isEmpty();
        case ErlangPackage.CONDITIONAL_FORM_BLOCK__END:
            return end != null;
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
        result.append(" (hasElse: ");
        result.append(hasElse);
        result.append(')');
        return result.toString();
    }

} // ConditionalFormBlockImpl
