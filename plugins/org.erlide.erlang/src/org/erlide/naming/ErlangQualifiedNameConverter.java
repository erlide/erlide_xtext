package org.erlide.naming;

import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;

import com.google.inject.Singleton;

@Singleton
public class ErlangQualifiedNameConverter extends
		IQualifiedNameConverter.DefaultImpl {

	@Override
	public String getDelimiter() {
		return ":";
	}

	@Override
	public QualifiedName toQualifiedName(String qualifiedNameAsString) {
		// TODO Auto-generated method stub
		return super.toQualifiedName(qualifiedNameAsString);
	}

	@Override
	public String toString(QualifiedName qualifiedName) {
		// TODO Auto-generated method stub
		return super.toString(qualifiedName);
	}
}
