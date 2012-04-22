/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.erlide.project.buildpath;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.erlide.project.buildpath.access.AccessRule;
import org.erlide.project.buildpath.access.IBuildpathProblem;

public class BuildpathAccessRule extends AccessRule implements IAccessRule {

	public BuildpathAccessRule(IPath pattern, int kind) {
		this(pattern.toString().toCharArray(), toProblemId(kind));
	}

	public BuildpathAccessRule(char[] pattern, IBuildpathProblem problemId) {
		super(pattern, problemId);
	}

	private static IBuildpathProblem toProblemId(int kind) {
		switch (kind) {
		case K_NON_ACCESSIBLE:
			return IBuildpathProblem.ForbiddenReference;
		case K_DISCOURAGED:
			return IBuildpathProblem.DiscouragedReference;
		default:
			return IBuildpathProblem.None;
		}
	}

	@Override
	public IPath getPattern() {
		return new Path(new String(this.pattern));
	}

	@Override
	public int getKind() {
		switch (getProblemId()) {
		case ForbiddenReference:
			return K_NON_ACCESSIBLE;
		case DiscouragedReference:
			return K_DISCOURAGED;
		default:
			return K_ACCESSIBLE;
		}
	}

}
