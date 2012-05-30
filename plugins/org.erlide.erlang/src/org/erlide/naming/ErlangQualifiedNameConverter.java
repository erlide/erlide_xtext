package org.erlide.naming;

import org.eclipse.xtext.naming.IQualifiedNameConverter;

import com.google.inject.Singleton;

@Singleton
public class ErlangQualifiedNameConverter extends
		IQualifiedNameConverter.DefaultImpl {

	@Override
	public String getDelimiter() {
		return ":";
	}

}
