package org.erlide.ui.autoedit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

public class ErlangAutoEditStrategyProvider extends
        DefaultAutoEditStrategyProvider {

    @Override
    protected void configure(final IEditStrategyAcceptor acceptor) {
        super.configure(acceptor);
        configureBinaryBlock(acceptor);
    }

    protected void configureBinaryBlock(final IEditStrategyAcceptor acceptor) {
        acceptor.accept(singleLineTerminals.newInstance("<<", ">>"),
                IDocument.DEFAULT_CONTENT_TYPE);
    }

    @Override
    protected void configureIndentationEditStrategy(
            final IEditStrategyAcceptor acceptor) {
        super.configureIndentationEditStrategy(acceptor);

    }

    @Override
    protected void configureCompoundBracesBlocks(
            final IEditStrategyAcceptor acceptor) {
        super.configureCompoundBracesBlocks(acceptor);
        acceptor.accept(compoundMultiLineTerminals.newInstanceFor("<<", ">>"),
                IDocument.DEFAULT_CONTENT_TYPE);
    }
}
