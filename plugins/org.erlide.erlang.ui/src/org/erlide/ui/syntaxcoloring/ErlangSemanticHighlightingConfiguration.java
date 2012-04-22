package org.erlide.ui.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class ErlangSemanticHighlightingConfiguration extends
        DefaultHighlightingConfiguration {
    public static final String ATTRIBUTE_ID = "attribute";
    public static final String STRUCTURAL_ATTRIBUTE_ID = "structural_attribute";
    public static final String VARIABLE_ID = "variable";
    public static final String MACRO_ID = "macro";

    @Override
    public void configure(final IHighlightingConfigurationAcceptor acceptor) {
        super.configure(acceptor);
        acceptor.acceptDefaultHighlighting(VARIABLE_ID, "Variable",
                variableTextStyle());
        acceptor.acceptDefaultHighlighting(ATTRIBUTE_ID, "Attribute",
                attributeTextStyle());
        acceptor.acceptDefaultHighlighting(STRUCTURAL_ATTRIBUTE_ID,
                "Structural attribute", structuralAttributeTextStyle());
        acceptor.acceptDefaultHighlighting(MACRO_ID, "Macro", macroTextStyle());
    }

    private TextStyle attributeTextStyle() {
        final TextStyle textStyle = defaultTextStyle().copy();
        textStyle.setStyle(SWT.UNDERLINE_DOUBLE);
        return textStyle;
    }

    private TextStyle structuralAttributeTextStyle() {
        final TextStyle textStyle = defaultTextStyle().copy();
        textStyle.setColor(new RGB(0x44, 0x44, 0x44));
        return textStyle;
    }

    public TextStyle variableTextStyle() {
        final TextStyle textStyle = defaultTextStyle().copy();
        textStyle.setColor(new RGB(0, 125, 0));
        return textStyle;
    }

    public TextStyle macroTextStyle() {
        final TextStyle textStyle = defaultTextStyle().copy();
        textStyle.setColor(new RGB(0, 125, 0));
        return textStyle;
    }

}
