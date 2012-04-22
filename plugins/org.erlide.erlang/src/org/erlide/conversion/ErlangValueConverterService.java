package org.erlide.conversion;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ErlangValueConverterService extends
        AbstractDeclarativeValueConverterService {

    @Inject
    private AtomValueConverter atomValueConverter;

    @ValueConverter(rule = "ATOM")
    public IValueConverter<String> ATOM() {
        return atomValueConverter;
    }

}
