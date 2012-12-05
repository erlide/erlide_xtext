package org.erlide.builder;

import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.xtext.builder.impl.XtextBuilder;

@SuppressWarnings("restriction")
public class ErlideXtextBuilder extends XtextBuilder {

    @Override
    public ISchedulingRule getRule() {
        return getProject();
    }
}
