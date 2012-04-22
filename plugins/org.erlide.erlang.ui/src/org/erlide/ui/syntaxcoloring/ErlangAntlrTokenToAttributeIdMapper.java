/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.erlide.ui.syntaxcoloring;

import java.util.regex.Pattern;

import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;

import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class ErlangAntlrTokenToAttributeIdMapper extends
        AbstractAntlrTokenToAttributeIdMapper {

    private static final Pattern QUOTED = Pattern.compile(
            "(?:^'([^']*)'$)|(?:^\"([^\"]*)\")$", Pattern.MULTILINE);

    private static final Pattern PUNCTUATION = Pattern.compile("\\p{Punct}*");

    @Override
    protected String calculateId(final String tokenName, final int tokenType) {
        if ("RULE_STRING".equals(tokenName)) {
            return DefaultHighlightingConfiguration.STRING_ID;
        }
        if ("RULE_MACRO".equals(tokenName)) {
            return ErlangSemanticHighlightingConfiguration.MACRO_ID;
        }
        if ("RULE_VARIABLE".equals(tokenName)) {
            return ErlangSemanticHighlightingConfiguration.VARIABLE_ID;
        }
        if ("RULE_INT".equals(tokenName)) {
            return DefaultHighlightingConfiguration.NUMBER_ID;
        }
        if ("RULE_ML_COMMENT".equals(tokenName)
                || "RULE_SL_COMMENT".equals(tokenName)) {
            return DefaultHighlightingConfiguration.COMMENT_ID;
        }
        if (PUNCTUATION.matcher(tokenName).matches()) {
            return DefaultHighlightingConfiguration.PUNCTUATION_ID;
        }
        if (QUOTED.matcher(tokenName).matches()) {
            return DefaultHighlightingConfiguration.KEYWORD_ID;
        }
        return DefaultHighlightingConfiguration.DEFAULT_ID;
    }

}
