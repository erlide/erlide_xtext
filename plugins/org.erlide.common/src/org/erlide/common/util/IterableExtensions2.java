package org.erlide.common.util;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

public class IterableExtensions2 {

    /**
     * Returns {@code true} if one or more elements in {@code iterable} satisfy
     * the predicate.
     * 
     * @param iterable
     *            the iterable. May not be <code>null</code>.
     * @param predicate
     *            the predicate. May not be <code>null</code>.
     * @return <code>true</code> if one or more elements in {@code iterable}
     *         satisfy the predicate.
     */
    public static <T> boolean hasAny(final Iterable<T> iterable,
            final Function1<? super T, Boolean> predicate) {
        return IterableExtensions.exists(iterable, predicate);
    }

}
