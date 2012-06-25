package org.erlide.conversion;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;

import com.google.inject.Singleton;

@Singleton
public class AtomValueConverter implements IValueConverter<String> {

    @Override
    public String toValue(final String string, final INode node)
            throws ValueConverterException {
        // this is just a demo
        if (string.startsWith("'") && !string.contains(" ")) {
            return string.substring(1, string.length() - 1);
        }
        return string;
    }

    @Override
    public String toString(final String value) throws ValueConverterException {
        if (value.contains(" ")) {
            return "'" + value + "'";
        }
        return value;
    }

}
