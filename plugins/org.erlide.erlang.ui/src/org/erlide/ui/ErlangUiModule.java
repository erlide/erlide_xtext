/*
 * generated by Xtext
 */
package org.erlide.ui;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.ResourceForIEditorInputFactory;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.SimpleResourceSetProvider;
import org.erlide.ui.folding.MyFoldingRegionProvider;
import org.erlide.ui.labeling.ErlangLabelProvider;
import org.erlide.ui.navigator.ErlangContentProvider;
import org.erlide.ui.syntaxcoloring.ErlangAntlrTokenToAttributeIdMapper;
import org.erlide.ui.syntaxcoloring.ErlangSemanticHighlightingCalculator;
import org.erlide.ui.syntaxcoloring.ErlangSemanticHighlightingConfiguration;

/**
 * Use this class to register components to be used within the IDE.
 */
public class ErlangUiModule extends org.erlide.ui.AbstractErlangUiModule {
    public ErlangUiModule(final AbstractUIPlugin plugin) {
        super(plugin);
    }

    @Override
    public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
        return ResourceForIEditorInputFactory.class;
    }

    @Override
    public Class<? extends IResourceSetProvider> bindIResourceSetProvider() {
        return SimpleResourceSetProvider.class;
    }

    public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
        return ErlangSemanticHighlightingCalculator.class;
    }

    public Class<? extends IHighlightingConfiguration> bindISemanticHighlightingConfiguration() {
        return ErlangSemanticHighlightingConfiguration.class;
    }

    public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindTokenToAttributeIdMapper() {
        return ErlangAntlrTokenToAttributeIdMapper.class;
    }

    public Class<? extends IFoldingRegionProvider> bindFoldingRegionProvider() {
        return MyFoldingRegionProvider.class;
    }

    public Class<? extends ITreeContentProvider> bindTreeContentProvider() {
        return ErlangContentProvider.class;
    }

    public Class<? extends ErlangLabelProvider> bindErlangLabelProvider() {
        return ErlangLabelProvider.class;
    }

    // This makes the editors update when opened (don't wait for a change and
    // rebuild)
    @Override
    public Class<? extends org.eclipse.xtext.ui.editor.IXtextEditorCallback> bindIXtextEditorCallback() {
        return org.eclipse.xtext.ui.editor.validation.ValidatingEditorCallback.class;
    }
}
