package org.erlide.ui.labeling;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.TextStyle;

public class ErlideStyler extends Styler {
    private final Color color;
    private final Font font;

    public ErlideStyler(final @Nullable Font font, final @Nullable Color color) {
        this.font = font;
        this.color = color;
    }

    @Override
    public void applyStyles(final TextStyle textStyle) {
        if (color != null) {
            textStyle.foreground = color;
        }
        if (font != null) {
            textStyle.font = font;
        }
    }

}
