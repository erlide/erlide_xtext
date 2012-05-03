/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.erlide.project.buildpath;

public class BuildpathAttribute implements IBuildpathAttribute {

	private final String name;
	private final String value;

	public BuildpathAttribute(String name, String value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BuildpathAttribute)) {
			return false;
		}
		BuildpathAttribute other = (BuildpathAttribute) obj;
		return this.name.equals(other.name) && this.value.equals(other.value);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public int hashCode() {
		return Util.combineHashCodes(this.name.hashCode(),
				this.value.hashCode());
	}

	@Override
	public String toString() {
		return this.name + "=" + this.value; //$NON-NLS-1$
	}

}
