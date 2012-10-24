/*******************************************************************************
 * Copyright (c) 2004 Eric Merritt and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eric Merritt
 *     Vlad Dumitrescu
 *******************************************************************************/
package org.erlide.ui.autoedit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategy;
import org.erlide.common.util.ErlLogger;

/**
 * The erlang auto indent strategy
 * 
 * Not used yet!
 */
public class ErlangAutoEditStrategy extends AbstractEditStrategy {

    private void autoIndentAfterNewLine(final IDocument d,
            final DocumentCommand c) {
        try {
            indentAfterNewLine(d, c);
        } catch (final BadLocationException e) {
            ErlLogger.getInstance().warn(e);
        }
    }

    // so far, copy indentation of prev line
    protected void indentAfterNewLine(final IDocument d, final DocumentCommand c)
            throws BadLocationException {

        if (c.offset == -1 || d.getLength() == 0) {
            return;
        }

        try {
            // find start of line
            final int p = (c.offset == d.getLength() ? c.offset - 1 : c.offset);
            final IRegion info = d.getLineInformationOfOffset(p);
            final int start = info.getOffset();

            // find white spaces
            final int end = findEndOfWhiteSpace(d, start, c.offset);

            final StringBuffer buf = new StringBuffer(c.text);
            if (end > start) {
                // append to input
                buf.append(d.get(start, end - start));
            }

            c.text = buf.toString();

        } catch (final BadLocationException excp) {
            // stop work
        }
        // final int offset = c.offset;
        // String txt = null;
        // final IErlMember member = getMemberNearOffset(offset);
        // if (member != null) {
        // final int start = member.getSourceRange().getOffset();
        // if (offset >= start) {
        // txt = d.get(start, offset - start);
        // }
        // }
        // if (txt == null) {
        // txt = "";
        // }
        // final int lineN = d.getLineOfOffset(offset);
        // final int lineOffset = d.getLineOffset(lineN);
        // final int lineLength = d.getLineLength(lineN);
        // final String oldLine = d.get(offset, lineLength + lineOffset -
        // offset);
        // try {
        // final IBackend b = BackendCore.getBackendManager().getIdeBackend();
        // final int tabw = getTabWidthFromPreferences();
        //
        // final Map<String, String> prefs = new TreeMap<String, String>();
        // IndentationPreferencePage.addKeysAndPrefs(prefs);
        // SmartTypingPreferencePage.addAutoNLKeysAndPrefs(prefs);
        // final boolean useTabs = getUseTabsFromPreferences();
        // final IndentResult res = ErlideIndent.indentLine(b, oldLine, txt,
        // c.text, tabw, useTabs, prefs);
        //
        // if (res.isAddNewLine()) {
        // c.text += "\n";
        // }
        // c.text += res.getText();
        // c.length += res.getRemoveNext();
        // } catch (final Exception e) {
        // ErlLogger.warn(e);
        // }
    }

    // private IErlMember getMemberNearOffset(final int offset) {
    // if (fEditor == null) {
    // return null;
    // }
    // final IErlElement element = fEditor.getElementAt(offset, false);
    // IErlMember member = (IErlMember) element;
    // final IErlModule module = fEditor.getModule();
    // try {
    // if (member == null) {
    // member = (IErlMember) module.getChildren().get(
    // module.getChildCount() - 1);
    // }
    // } catch (final Exception e1) {
    // // ignore
    // }
    // return member;
    // }

    protected int findEndOfWhiteSpace(final IDocument document, int offset,
            final int end) throws BadLocationException {
        while (offset < end) {
            final char c = document.getChar(offset);
            if (c != ' ' && c != '\t') {
                return offset;
            }
            offset++;
        }
        return end;
    }

    @Override
    public void internalCustomizeDocumentCommand(final IDocument d,
            final DocumentCommand c) {
        if (c.length == 0 && c.text != null) {
            if (TextUtilities.endsWith(d.getLegalLineDelimiters(), c.text) != -1) {
                autoIndentAfterNewLine(d, c);
            } else if (c.text.endsWith(",")) {
                autoIndentAfterNewLine(d, c);
            } else if (c.text.endsWith(";")) {
                autoIndentAfterNewLine(d, c);
            } else if (c.text.endsWith(".")) {
                autoIndentAfterNewLine(d, c);
            } else if (c.text.endsWith(">")) {
                try {
                    if (c.offset > 0 && c.offset <= d.getLength()
                            && d.getChar(c.offset - 1) == '-') {
                        autoIndentAfterNewLine(d, c);
                    }
                } catch (final BadLocationException e) {
                    // never mind...
                }
            }
        }
    }
}
