/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.erlide.project.buildpath.access;

import com.google.common.base.Objects;

public class AccessRule {

    public char[] pattern;
    public IBuildpathProblem problemId;

    public AccessRule(final char[] pattern, final IBuildpathProblem problemId) {
        this.pattern = pattern;
        this.problemId = problemId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(problemId, pattern);
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof AccessRule)) {
            return false;
        }
        final AccessRule other = (AccessRule) obj;
        if (this.problemId != other.problemId) {
            return false;
        }
        return Objects.equal(this.pattern, other.pattern);
    }

    public IBuildpathProblem getProblemId() {
        return this.problemId;
    }

    @Override
    public String toString() {
        final StringBuffer buffer = new StringBuffer();
        buffer.append("pattern="); //$NON-NLS-1$
        buffer.append(this.pattern);

        switch (getProblemId()) {
        case ForbiddenReference:
            buffer.append(" (NON ACCESSIBLE"); //$NON-NLS-1$
            break;
        case DiscouragedReference:
            buffer.append(" (DISCOURAGED"); //$NON-NLS-1$
            break;
        default:
            buffer.append(" (ACCESSIBLE"); //$NON-NLS-1$
            break;
        }
        buffer.append(')');
        return buffer.toString();
    }
}
