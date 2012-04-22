package org.erlide.ui.folding;

import java.util.Collection;
import java.util.List;

import org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.folding.FoldedPosition;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import com.google.common.collect.Lists;

public class MyFoldingRegionProvider extends DefaultFoldingRegionProvider {

    @Override
    public Collection<FoldedPosition> getFoldingRegions(
            final IXtextDocument xtextDocument) {
        if (xtextDocument.getNumberOfLines() < 5000) {
            return super.getFoldingRegions(xtextDocument);
        }
        final List<FoldedPosition> list = Lists.newArrayList();
        return list;
    }

}
