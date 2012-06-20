/**
 */
package org.erlide.erlang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.RecordExpr#getRef <em>Ref</em>}</li>
 *   <li>{@link org.erlide.erlang.RecordExpr#getRecord <em>Record</em>}</li>
 *   <li>{@link org.erlide.erlang.RecordExpr#getRec <em>Rec</em>}</li>
 *   <li>{@link org.erlide.erlang.RecordExpr#getField <em>Field</em>}</li>
 *   <li>{@link org.erlide.erlang.RecordExpr#getTuple <em>Tuple</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getRecordExpr()
 * @model
 * @generated
 */
public interface RecordExpr extends Expression
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' containment reference.
   * @see #setRef(Expression)
   * @see org.erlide.erlang.ErlangPackage#getRecordExpr_Ref()
   * @model containment="true"
   * @generated
   */
  Expression getRef();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RecordExpr#getRef <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' containment reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Expression value);

  /**
   * Returns the value of the '<em><b>Record</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Record</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Record</em>' containment reference.
   * @see #setRecord(RecordExpr)
   * @see org.erlide.erlang.ErlangPackage#getRecordExpr_Record()
   * @model containment="true"
   * @generated
   */
  RecordExpr getRecord();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RecordExpr#getRecord <em>Record</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Record</em>' containment reference.
   * @see #getRecord()
   * @generated
   */
  void setRecord(RecordExpr value);

  /**
   * Returns the value of the '<em><b>Rec</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rec</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rec</em>' reference.
   * @see #setRec(ReferenceableElement)
   * @see org.erlide.erlang.ErlangPackage#getRecordExpr_Rec()
   * @model
   * @generated
   */
  ReferenceableElement getRec();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RecordExpr#getRec <em>Rec</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rec</em>' reference.
   * @see #getRec()
   * @generated
   */
  void setRec(ReferenceableElement value);

  /**
   * Returns the value of the '<em><b>Field</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field</em>' reference.
   * @see #setField(ReferenceableElement)
   * @see org.erlide.erlang.ErlangPackage#getRecordExpr_Field()
   * @model
   * @generated
   */
  ReferenceableElement getField();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RecordExpr#getField <em>Field</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field</em>' reference.
   * @see #getField()
   * @generated
   */
  void setField(ReferenceableElement value);

  /**
   * Returns the value of the '<em><b>Tuple</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tuple</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tuple</em>' containment reference.
   * @see #setTuple(RecordTuple)
   * @see org.erlide.erlang.ErlangPackage#getRecordExpr_Tuple()
   * @model containment="true"
   * @generated
   */
  RecordTuple getTuple();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RecordExpr#getTuple <em>Tuple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tuple</em>' containment reference.
   * @see #getTuple()
   * @generated
   */
  void setTuple(RecordTuple value);

} // RecordExpr
