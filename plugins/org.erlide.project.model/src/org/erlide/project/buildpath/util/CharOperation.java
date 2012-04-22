/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.erlide.project.buildpath.util;

/**
 * This class is a collection of helper methods to manipulate char arrays.
 * 
 * 
 */
public final class CharOperation {

    private static final char MAX_OBVIOUS = 128;

    /**
     * Answers the first index in the array for which the corresponding
     * character is equal to toBeFound. Answers -1 if no occurrence of this
     * character is found. <br>
     * <br>
     * For example:
     * <ol>
     * <li>
     * 
     * <pre>
     *     toBeFound = 'c'
     *     array = { ' a', 'b', 'c', 'd' }
     *     result =&gt; 2
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *     toBeFound = 'e'
     *     array = { ' a', 'b', 'c', 'd' }
     *     result =&gt; -1
     * </pre>
     * 
     * </li>
     * </ol>
     * 
     * @param toBeFound
     *            the character to search
     * @param array
     *            the array to be searched
     * @return the first index in the array for which the corresponding
     *         character is equal to toBeFound, -1 otherwise
     * @throws NullPointerException
     *             if array is null
     */
    public static final int indexOf(final char toBeFound, final char[] array) {
        return indexOf(toBeFound, array, 0);
    }

    /**
     * Answers the first index in the array for which the toBeFound array is a
     * matching subarray following the case rule. Answers -1 if no match is
     * found. <br>
     * <br>
     * For example:
     * <ol>
     * <li>
     * 
     * <pre>
     *     toBeFound = { 'c' }
     *     array = { ' a', 'b', 'c', 'd' }
     *     result =&gt; 2
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *     toBeFound = { 'e' }
     *     array = { ' a', 'b', 'c', 'd' }
     *     result =&gt; -1
     * </pre>
     * 
     * </li>
     * </ol>
     * 
     * @param toBeFound
     *            the subarray to search
     * @param array
     *            the array to be searched
     * @param isCaseSensitive
     *            flag to know if the matching should be case sensitive
     * @return the first index in the array for which the toBeFound array is a
     *         matching subarray following the case rule, -1 otherwise
     * @throws NullPointerException
     *             if array is null or toBeFound is null
     * 
     */
    public static final int indexOf(final char[] toBeFound, final char[] array,
            final boolean isCaseSensitive) {
        return indexOf(toBeFound, array, isCaseSensitive, 0);
    }

    /**
     * Answers the first index in the array for which the toBeFound array is a
     * matching subarray following the case rule starting at the index start.
     * Answers -1 if no match is found. <br>
     * <br>
     * For example:
     * <ol>
     * <li>
     * 
     * <pre>
     *     toBeFound = { 'c' }
     *     array = { ' a', 'b', 'c', 'd' }
     *     result =&gt; 2
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *     toBeFound = { 'e' }
     *     array = { ' a', 'b', 'c', 'd' }
     *     result =&gt; -1
     * </pre>
     * 
     * </li>
     * </ol>
     * 
     * @param toBeFound
     *            the subarray to search
     * @param array
     *            the array to be searched
     * @param isCaseSensitive
     *            flag to know if the matching should be case sensitive
     * @param start
     *            the starting index
     * @return the first index in the array for which the toBeFound array is a
     *         matching subarray following the case rule starting at the index
     *         start, -1 otherwise
     * @throws NullPointerException
     *             if array is null or toBeFound is null
     * 
     */
    public static final int indexOf(final char[] toBeFound, final char[] array,
            final boolean isCaseSensitive, final int start) {
        return indexOf(toBeFound, array, isCaseSensitive, start, array.length);
    }

    /**
     * Answers the first index in the array for which the toBeFound array is a
     * matching subarray following the case rule starting at the index start.
     * Answers -1 if no match is found. <br>
     * <br>
     * For example:
     * <ol>
     * <li>
     * 
     * <pre>
     *     toBeFound = { 'c' }
     *     array = { ' a', 'b', 'c', 'd' }
     *     result =&gt; 2
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *     toBeFound = { 'e' }
     *     array = { ' a', 'b', 'c', 'd' }
     *     result =&gt; -1
     * </pre>
     * 
     * </li>
     * </ol>
     * 
     * @param toBeFound
     *            the subarray to search
     * @param array
     *            the array to be searched
     * @param isCaseSensitive
     *            flag to know if the matching should be case sensitive
     * @param start
     *            the starting index (inclusive)
     * @param end
     *            the end index (exclusive)
     * @return the first index in the array for which the toBeFound array is a
     *         matching subarray following the case rule starting at the index
     *         start, -1 otherwise
     * @throws NullPointerException
     *             if array is null or toBeFound is null
     * 
     */
    public static final int indexOf(final char[] toBeFound, final char[] array,
            final boolean isCaseSensitive, final int start, final int end) {
        final int arrayLength = end;
        final int toBeFoundLength = toBeFound.length;
        if (toBeFoundLength > arrayLength) {
            return -1;
        }
        if (toBeFoundLength == 0) {
            return 0;
        }
        if (toBeFoundLength == arrayLength) {
            if (isCaseSensitive) {
                for (int i = start; i < arrayLength; i++) {
                    if (array[i] != toBeFound[i]) {
                        return -1;
                    }
                }
                return 0;
            } else {
                for (int i = start; i < arrayLength; i++) {
                    if (Character.toLowerCase(array[i]) != Character
                            .toLowerCase(toBeFound[i])) {
                        return -1;
                    }
                }
                return 0;
            }
        }
        if (isCaseSensitive) {
            arrayLoop:
            for (int i = start, max = arrayLength - toBeFoundLength + 1; i < max; i++) {
                if (array[i] == toBeFound[0]) {
                    for (int j = 1; j < toBeFoundLength; j++) {
                        if (array[i + j] != toBeFound[j]) {
                            continue arrayLoop;
                        }
                    }
                    return i;
                }
            }
        } else {
            arrayLoop:
            for (int i = start, max = arrayLength - toBeFoundLength + 1; i < max; i++) {
                if (Character.toLowerCase(array[i]) == Character
                        .toLowerCase(toBeFound[0])) {
                    for (int j = 1; j < toBeFoundLength; j++) {
                        if (Character.toLowerCase(array[i + j]) != Character
                                .toLowerCase(toBeFound[j])) {
                            continue arrayLoop;
                        }
                    }
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Answers the first index in the array for which the corresponding
     * character is equal to toBeFound starting the search at index start.
     * Answers -1 if no occurrence of this character is found. <br>
     * <br>
     * For example:
     * <ol>
     * <li>
     * 
     * <pre>
     *     toBeFound = 'c'
     *     array = { ' a', 'b', 'c', 'd' }
     *     start = 2
     *     result =&gt; 2
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *     toBeFound = 'c'
     *     array = { ' a', 'b', 'c', 'd' }
     *     start = 3
     *     result =&gt; -1
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *     toBeFound = 'e'
     *     array = { ' a', 'b', 'c', 'd' }
     *     start = 1
     *     result =&gt; -1
     * </pre>
     * 
     * </li>
     * </ol>
     * 
     * @param toBeFound
     *            the character to search
     * @param array
     *            the array to be searched
     * @param start
     *            the starting index
     * @return the first index in the array for which the corresponding
     *         character is equal to toBeFound, -1 otherwise
     * @throws NullPointerException
     *             if array is null
     * @throws ArrayIndexOutOfBoundsException
     *             if start is lower than 0
     */
    public static final int indexOf(final char toBeFound, final char[] array,
            final int start) {
        for (int i = start; i < array.length; i++) {
            if (toBeFound == array[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Answers the first index in the array for which the corresponding
     * character is equal to toBeFound starting the search at index start and
     * before the ending index. Answers -1 if no occurrence of this character is
     * found. <br>
     * <br>
     * For example:
     * <ol>
     * <li>
     * 
     * <pre>
     *     toBeFound = 'c'
     *     array = { ' a', 'b', 'c', 'd' }
     *     start = 2
     *     result =&gt; 2
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *     toBeFound = 'c'
     *     array = { ' a', 'b', 'c', 'd' }
     *     start = 3
     *     result =&gt; -1
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *     toBeFound = 'e'
     *     array = { ' a', 'b', 'c', 'd' }
     *     start = 1
     *     result =&gt; -1
     * </pre>
     * 
     * </li>
     * </ol>
     * 
     * @param toBeFound
     *            the character to search
     * @param array
     *            the array to be searched
     * @param start
     *            the starting index (inclusive)
     * @param end
     *            the ending index (exclusive)
     * @return the first index in the array for which the corresponding
     *         character is equal to toBeFound, -1 otherwise
     * @throws NullPointerException
     *             if array is null
     * @throws ArrayIndexOutOfBoundsException
     *             if start is lower than 0 or ending greater than array length
     * 
     */
    public static final int indexOf(final char toBeFound, final char[] array,
            final int start, final int end) {
        for (int i = start; i < end; i++) {
            if (toBeFound == array[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Answers true if the pattern matches the given name, false otherwise. This
     * char[] pattern matching accepts wild-cards '*' and '?'.
     * 
     * When not case sensitive, the pattern is assumed to already be lowercased,
     * the name will be lowercased character per character as comparing. If name
     * is null, the answer is false. If pattern is null, the answer is true if
     * name is not null. <br>
     * <br>
     * For example:
     * <ol>
     * <li>
     * 
     * <pre>
     *     pattern = { '?', 'b', '*' }
     *     name = { 'a', 'b', 'c' , 'd' }
     *     isCaseSensitive = true
     *     result =&gt; true
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *     pattern = { '?', 'b', '?' }
     *     name = { 'a', 'b', 'c' , 'd' }
     *     isCaseSensitive = true
     *     result =&gt; false
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *     pattern = { 'b', '*' }
     *     name = { 'a', 'b', 'c' , 'd' }
     *     isCaseSensitive = true
     *     result =&gt; false
     * </pre>
     * 
     * </li>
     * </ol>
     * 
     * @param pattern
     *            the given pattern
     * @param name
     *            the given name
     * @param isCaseSensitive
     *            flag to know whether or not the matching should be case
     *            sensitive
     * @return true if the pattern matches the given name, false otherwise
     */
    public static final boolean match(final char[] pattern, final char[] name,
            final boolean isCaseSensitive) {

        if (name == null) {
            return false; // null name cannot match
        }
        if (pattern == null) {
            return true; // null pattern is equivalent to '*'
        }

        return match(pattern, 0, pattern.length, name, 0, name.length,
                isCaseSensitive);
    }

    /**
     * Answers true if a sub-pattern matches the subpart of the given name,
     * false otherwise. char[] pattern matching, accepting wild-cards '*' and
     * '?'. Can match only subset of name/pattern. end positions are
     * non-inclusive. The subpattern is defined by the patternStart and
     * pattternEnd positions. When not case sensitive, the pattern is assumed to
     * already be lowercased, the name will be lowercased character per
     * character as comparing. <br>
     * <br>
     * For example:
     * <ol>
     * <li>
     * 
     * <pre>
     *     pattern = { '?', 'b', '*' }
     *     patternStart = 1
     *     patternEnd = 3
     *     name = { 'a', 'b', 'c' , 'd' }
     *     nameStart = 1
     *     nameEnd = 4
     *     isCaseSensitive = true
     *     result =&gt; true
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *     pattern = { '?', 'b', '*' }
     *     patternStart = 1
     *     patternEnd = 2
     *     name = { 'a', 'b', 'c' , 'd' }
     *     nameStart = 1
     *     nameEnd = 2
     *     isCaseSensitive = true
     *     result =&gt; false
     * </pre>
     * 
     * </li>
     * </ol>
     * 
     * @param pattern
     *            the given pattern
     * @param patternStart
     *            the given pattern start
     * @param patternEnd
     *            the given pattern end
     * @param name
     *            the given name
     * @param nameStart
     *            the given name start
     * @param nameEnd
     *            the given name end
     * @param isCaseSensitive
     *            flag to know if the matching should be case sensitive
     * @return true if a sub-pattern matches the subpart of the given name,
     *         false otherwise
     */
    public static final boolean match(final char[] pattern,
            final int patternStart, int patternEnd, final char[] name,
            final int nameStart, int nameEnd, final boolean isCaseSensitive) {

        if (name == null) {
            return false; // null name cannot match
        }
        if (pattern == null) {
            return true; // null pattern is equivalent to '*'
        }
        int iPattern = patternStart;
        int iName = nameStart;

        if (patternEnd < 0) {
            patternEnd = pattern.length;
        }
        if (nameEnd < 0) {
            nameEnd = name.length;
        }

        /* check first segment */
        char patternChar = 0;
        while (iPattern < patternEnd
                && (patternChar = pattern[iPattern]) != '*') {
            if (iName == nameEnd) {
                return false;
            }
            if (patternChar != (isCaseSensitive ? name[iName] : Character
                    .toLowerCase(name[iName])) && patternChar != '?') {
                return false;
            }
            iName++;
            iPattern++;
        }
        /* check sequence of star+segment */
        int segmentStart;
        if (patternChar == '*') {
            segmentStart = ++iPattern; // skip star
        } else {
            segmentStart = 0; // force iName check
        }
        int prefixStart = iName;
        checkSegment:
        while (iName < nameEnd) {
            if (iPattern == patternEnd) {
                iPattern = segmentStart; // mismatch - restart current
                // segment
                iName = ++prefixStart;
                continue checkSegment;
            }
            /* segment is ending */
            if ((patternChar = pattern[iPattern]) == '*') {
                segmentStart = ++iPattern; // skip start
                if (segmentStart == patternEnd) {
                    return true;
                }
                prefixStart = iName;
                continue checkSegment;
            }
            /* check current name character */
            if ((isCaseSensitive ? name[iName] : Character
                    .toLowerCase(name[iName])) != patternChar
                    && patternChar != '?') {
                iPattern = segmentStart; // mismatch - restart current
                // segment
                iName = ++prefixStart;
                continue checkSegment;
            }
            iName++;
            iPattern++;
        }

        return segmentStart == patternEnd || iName == nameEnd
                && iPattern == patternEnd || iPattern == patternEnd - 1
                && pattern[iPattern] == '*';
    }

    /**
     * Answers true if the pattern matches the filepath using the pathSepatator,
     * false otherwise.
     * 
     * Path char[] pattern matching, accepting wild-cards '**', '*' and '?'
     * (using Ant directory tasks conventions, also see
     * "http://jakarta.apache.org/ant/manual/dirtasks.html#defaultexcludes").
     * Path pattern matching is enhancing regular pattern matching in supporting
     * extra rule where '**' represent any folder combination. Special rule: -
     * foo\ is equivalent to foo\** When not case sensitive, the pattern is
     * assumed to already be lowercased, the name will be lowercased character
     * per character as comparing.
     * 
     * @param pattern
     *            the given pattern
     * @param filepath
     *            the given path
     * @param isCaseSensitive
     *            to find out whether or not the matching should be case
     *            sensitive
     * @param pathSeparator
     *            the given path separator
     * @return true if the pattern matches the filepath using the pathSepatator,
     *         false otherwise
     */
    public static final boolean pathMatch(final char[] pattern,
            final char[] filepath, final boolean isCaseSensitive,
            final char pathSeparator) {

        if (filepath == null) {
            return false; // null name cannot match
        }
        if (pattern == null) {
            return true; // null pattern is equivalent to '*'
        }

        // offsets inside pattern
        int pSegmentStart = pattern[0] == pathSeparator ? 1 : 0;
        final int pLength = pattern.length;
        int pSegmentEnd = CharOperation.indexOf(pathSeparator, pattern,
                pSegmentStart + 1);
        if (pSegmentEnd < 0) {
            pSegmentEnd = pLength;
        }

        // special case: pattern foo\ is equivalent to foo\**
        final boolean freeTrailingDoubleStar = pattern[pLength - 1] == pathSeparator;

        // offsets inside filepath
        int fSegmentStart;
        final int fLength = filepath.length;
        if (filepath[0] != pathSeparator) {
            fSegmentStart = 0;
        } else {
            fSegmentStart = 1;
        }
        if (fSegmentStart != pSegmentStart) {
            return false; // both must start with a separator or none.
        }
        int fSegmentEnd = CharOperation.indexOf(pathSeparator, filepath,
                fSegmentStart + 1);
        if (fSegmentEnd < 0) {
            fSegmentEnd = fLength;
        }

        // first segments
        while (pSegmentStart < pLength
                && !(pSegmentEnd == pLength && freeTrailingDoubleStar || pSegmentEnd == pSegmentStart + 2
                        && pattern[pSegmentStart] == '*'
                        && pattern[pSegmentStart + 1] == '*')) {

            if (fSegmentStart >= fLength) {
                return false;
            }
            if (!CharOperation.match(pattern, pSegmentStart, pSegmentEnd,
                    filepath, fSegmentStart, fSegmentEnd, isCaseSensitive)) {
                return false;
            }

            // jump to next segment
            pSegmentEnd = CharOperation.indexOf(pathSeparator, pattern,
                    pSegmentStart = pSegmentEnd + 1);
            // skip separator
            if (pSegmentEnd < 0) {
                pSegmentEnd = pLength;
            }

            fSegmentEnd = CharOperation.indexOf(pathSeparator, filepath,
                    fSegmentStart = fSegmentEnd + 1);
            // skip separator
            if (fSegmentEnd < 0) {
                fSegmentEnd = fLength;
            }
        }

        /* check sequence of doubleStar+segment */
        int pSegmentRestart;
        if (pSegmentStart >= pLength && freeTrailingDoubleStar
                || pSegmentEnd == pSegmentStart + 2
                && pattern[pSegmentStart] == '*'
                && pattern[pSegmentStart + 1] == '*') {
            pSegmentEnd = CharOperation.indexOf(pathSeparator, pattern,
                    pSegmentStart = pSegmentEnd + 1);
            // skip separator
            if (pSegmentEnd < 0) {
                pSegmentEnd = pLength;
            }
            pSegmentRestart = pSegmentStart;
        } else {
            if (pSegmentStart >= pLength) {
                return fSegmentStart >= fLength; // true if filepath is done
            }
            // too.
            pSegmentRestart = 0; // force fSegmentStart check
        }
        int fSegmentRestart = fSegmentStart;
        checkSegment:
        while (fSegmentStart < fLength) {

            if (pSegmentStart >= pLength) {
                if (freeTrailingDoubleStar) {
                    return true;
                }
                // mismatch - restart current path segment
                pSegmentEnd = CharOperation.indexOf(pathSeparator, pattern,
                        pSegmentStart = pSegmentRestart);
                if (pSegmentEnd < 0) {
                    pSegmentEnd = pLength;
                }

                fSegmentRestart = CharOperation.indexOf(pathSeparator,
                        filepath, fSegmentRestart + 1);
                // skip separator
                if (fSegmentRestart < 0) {
                    fSegmentRestart = fLength;
                } else {
                    fSegmentRestart++;
                }
                fSegmentEnd = CharOperation.indexOf(pathSeparator, filepath,
                        fSegmentStart = fSegmentRestart);
                if (fSegmentEnd < 0) {
                    fSegmentEnd = fLength;
                }
                continue checkSegment;
            }

            /* path segment is ending */
            if (pSegmentEnd == pSegmentStart + 2
                    && pattern[pSegmentStart] == '*'
                    && pattern[pSegmentStart + 1] == '*') {
                pSegmentEnd = CharOperation.indexOf(pathSeparator, pattern,
                        pSegmentStart = pSegmentEnd + 1);
                // skip separator
                if (pSegmentEnd < 0) {
                    pSegmentEnd = pLength;
                }
                pSegmentRestart = pSegmentStart;
                fSegmentRestart = fSegmentStart;
                if (pSegmentStart >= pLength) {
                    return true;
                }
                continue checkSegment;
            }
            /* chech current path segment */
            if (!CharOperation.match(pattern, pSegmentStart, pSegmentEnd,
                    filepath, fSegmentStart, fSegmentEnd, isCaseSensitive)) {
                // mismatch - restart current path segment
                pSegmentEnd = CharOperation.indexOf(pathSeparator, pattern,
                        pSegmentStart = pSegmentRestart);
                if (pSegmentEnd < 0) {
                    pSegmentEnd = pLength;
                }

                fSegmentRestart = CharOperation.indexOf(pathSeparator,
                        filepath, fSegmentRestart + 1);
                // skip separator
                if (fSegmentRestart < 0) {
                    fSegmentRestart = fLength;
                } else {
                    fSegmentRestart++;
                }
                fSegmentEnd = CharOperation.indexOf(pathSeparator, filepath,
                        fSegmentStart = fSegmentRestart);
                if (fSegmentEnd < 0) {
                    fSegmentEnd = fLength;
                }
                continue checkSegment;
            }
            // jump to next segment
            pSegmentEnd = CharOperation.indexOf(pathSeparator, pattern,
                    pSegmentStart = pSegmentEnd + 1);
            // skip separator
            if (pSegmentEnd < 0) {
                pSegmentEnd = pLength;
            }

            fSegmentEnd = CharOperation.indexOf(pathSeparator, filepath,
                    fSegmentStart = fSegmentEnd + 1);
            // skip separator
            if (fSegmentEnd < 0) {
                fSegmentEnd = fLength;
            }
        }

        return pSegmentRestart >= pSegmentEnd || fSegmentStart >= fLength
                && pSegmentStart >= pLength || pSegmentStart == pLength - 2
                && pattern[pSegmentStart] == '*'
                && pattern[pSegmentStart + 1] == '*'
                || pSegmentStart == pLength && freeTrailingDoubleStar;
    }

    /**
     * Answers true if the pattern matches the given name using CamelCase rules,
     * or false otherwise. char[] CamelCase matching does NOT accept explicit
     * wild-cards '*' and '?' and is inherently case sensitive. <br>
     * CamelCase denotes the convention of writing compound names without
     * spaces, and capitalizing every term. This function recognizes both upper
     * and lower CamelCase, depending whether the leading character is
     * capitalized or not. The leading part of an upper CamelCase pattern is
     * assumed to contain a sequence of capitals which are appearing in the
     * matching name; e.g. 'NPE' will match 'NullPointerException', but not
     * 'NewPerfData'. A lower CamelCase pattern uses a lowercase first
     * character. In Script, type names follow the upper CamelCase convention,
     * whereas method or field names follow the lower CamelCase convention. <br>
     * The pattern may contain lowercase characters, which will be match in a
     * case sensitive way. These characters must appear in sequence in the name.
     * For instance, 'NPExcep' will match 'NullPointerException', but not
     * 'NullPointerExCEPTION' or 'NuPoEx' will match 'NullPointerException', but
     * not 'NoPointerException'. <br>
     * <br>
     * Examples:
     * <ol>
     * <li>
     * 
     * <pre>
     *    pattern = { 'N', 'P', 'E' }
     *    name = { 'N', 'u','l', 'l', 'P', 'o', 'i', 'n', 't', 'e', 'r', 'E', 'x', 'c', 'e', 'p', 't', 'i', 'o', 'n' }
     *    result =&gt; true
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *    pattern = { 'N', 'P', 'E' }
     *    name = { 'N', 'o', 'P', 'e', 'r', 'm', 'i', 's', 's', 'i', 'o', 'n', 'E', 'x', 'c', 'e', 'p', 't', 'i', 'o', 'n' }
     *    result =&gt; true
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *    pattern = { 'N', 'u', 'P', 'o', 'E', 'x' }
     *    name = { 'N', 'u','l', 'l', 'P', 'o', 'i', 'n', 't', 'e', 'r', 'E', 'x', 'c', 'e', 'p', 't', 'i', 'o', 'n' }
     *    result =&gt; true
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *    pattern = { 'N', 'u', 'P', 'o', 'E', 'x' }
     *    name = { 'N', 'o', 'P', 'e', 'r', 'm', 'i', 's', 's', 'i', 'o', 'n', 'E', 'x', 'c', 'e', 'p', 't', 'i', 'o', 'n' }
     *    result =&gt; false
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *    pattern = { 'n', p', 'e' }
     *    name = { 'N', 'u','l', 'l', 'P', 'o', 'i', 'n', 't', 'e', 'r', 'E', 'x', 'c', 'e', 'p', 't', 'i', 'o', 'n' }
     *    result =&gt; false
     * </pre>
     * 
     * </li>
     * </ol>
     * 
     * @param pattern
     *            the given pattern
     * @param name
     *            the given name
     * @return true if the pattern matches the given name, false otherwise
     * 
     */
    public static final boolean camelCaseMatch(final char[] pattern,
            final char[] name) {
        if (pattern == null) {
            return true; // null pattern is equivalent to '*'
        }
        if (name == null) {
            return false; // null name cannot match
        }

        return camelCaseMatch(pattern, 0, pattern.length, name, 0, name.length);
    }

    /**
     * Answers true if a sub-pattern matches the subpart of the given name using
     * CamelCase rules, or false otherwise. char[] CamelCase matching does NOT
     * accept explicit wild-cards '*' and '?' and is inherently case sensitive.
     * Can match only subset of name/pattern, considering end positions as
     * non-inclusive. The subpattern is defined by the patternStart and
     * patternEnd positions. <br>
     * CamelCase denotes the convention of writing compound names without
     * spaces, and capitalizing every term. This function recognizes both upper
     * and lower CamelCase, depending whether the leading character is
     * capitalized or not. The leading part of an upper CamelCase pattern is
     * assumed to contain a sequence of capitals which are appearing in the
     * matching name; e.g. 'NPE' will match 'NullPointerException', but not
     * 'NewPerfData'. A lower CamelCase pattern uses a lowercase first
     * character. In Script, type names follow the upper CamelCase convention,
     * whereas method or field names follow the lower CamelCase convention. <br>
     * The pattern may contain lowercase characters, which will be match in a
     * case sensitive way. These characters must appear in sequence in the name.
     * For instance, 'NPExcep' will match 'NullPointerException', but not
     * 'NullPointerExCEPTION' or 'NuPoEx' will match 'NullPointerException', but
     * not 'NoPointerException'. <br>
     * <br>
     * Examples:
     * <ol>
     * <li>
     * 
     * <pre>
     *    pattern = { 'N', 'P', 'E' }
     *    patternStart = 0
     *    patternEnd = 3
     *    name = { 'N', 'u','l', 'l', 'P', 'o', 'i', 'n', 't', 'e', 'r', 'E', 'x', 'c', 'e', 'p', 't', 'i', 'o', 'n' }
     *    nameStart = 0
     *    nameEnd = 20
     *    result =&gt; true
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *    pattern = { 'N', 'P', 'E' }
     *    patternStart = 0
     *    patternEnd = 3
     *    name = { 'N', 'o', 'P', 'e', 'r', 'm', 'i', 's', 's', 'i', 'o', 'n', 'E', 'x', 'c', 'e', 'p', 't', 'i', 'o', 'n' }
     *    nameStart = 0
     *    nameEnd = 21
     *    result =&gt; true
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *    pattern = { 'N', 'u', 'P', 'o', 'E', 'x' }
     *    patternStart = 0
     *    patternEnd = 6
     *    name = { 'N', 'u','l', 'l', 'P', 'o', 'i', 'n', 't', 'e', 'r', 'E', 'x', 'c', 'e', 'p', 't', 'i', 'o', 'n' }
     *    nameStart = 0
     *    nameEnd = 20
     *    result =&gt; true
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *    pattern = { 'N', 'u', 'P', 'o', 'E', 'x' }
     *    patternStart = 0
     *    patternEnd = 6
     *    name = { 'N', 'o', 'P', 'e', 'r', 'm', 'i', 's', 's', 'i', 'o', 'n', 'E', 'x', 'c', 'e', 'p', 't', 'i', 'o', 'n' }
     *    nameStart = 0
     *    nameEnd = 21
     *    result =&gt; false
     * </pre>
     * 
     * </li>
     * <li>
     * 
     * <pre>
     *    pattern = { 'n', p', 'e' }
     *    patternStart = 0
     *    patternEnd = 3
     *    name = { 'N', 'u','l', 'l', 'P', 'o', 'i', 'n', 't', 'e', 'r', 'E', 'x', 'c', 'e', 'p', 't', 'i', 'o', 'n' }
     *    nameStart = 0
     *    nameEnd = 20
     *    result =&gt; false
     * </pre>
     * 
     * </li>
     * </ol>
     * 
     * @param pattern
     *            the given pattern
     * @param patternStart
     *            the start index of the pattern, inclusive
     * @param patternEnd
     *            the end index of the pattern, exclusive
     * @param name
     *            the given name
     * @param nameStart
     *            the start index of the name, inclusive
     * @param nameEnd
     *            the end index of the name, exclusive
     * @return true if a sub-pattern matches the subpart of the given name,
     *         false otherwise
     * 
     */
    public static final boolean camelCaseMatch(final char[] pattern,
            final int patternStart, int patternEnd, final char[] name,
            final int nameStart, int nameEnd) {
        if (name == null) {
            return false; // null name cannot match
        }
        if (pattern == null) {
            return true; // null pattern is equivalent to '*'
        }
        if (patternEnd < 0) {
            patternEnd = pattern.length;
        }
        if (nameEnd < 0) {
            nameEnd = name.length;
        }

        if (patternEnd <= patternStart) {
            return nameEnd <= nameStart;
        }
        if (nameEnd <= nameStart) {
            return false;
        }
        // check first pattern char
        if (name[nameStart] != pattern[patternStart]) {
            // first char must strictly match (upper/lower)
            return false;
        }

        char patternChar, nameChar;
        int iPattern = patternStart;
        int iName = nameStart;

        // Main loop is on pattern characters
        while (true) {

            iPattern++;
            iName++;

            if (iPattern == patternEnd) {
                // We have exhausted pattern, so it's a match
                return true;
            }

            if (iName == nameEnd) {
                // We have exhausted name (and not pattern), so it's not a match
                return false;
            }

            // For as long as we're exactly matching, bring it on (even if it's
            // a lower case character)
            if ((patternChar = pattern[iPattern]) == name[iName]) {
                continue;
            }

            // If characters are not equals, then it's not a match if
            // patternChar is lowercase
            if (patternChar < MAX_OBVIOUS) {
                if ((ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[patternChar] & ScannerHelper.C_UPPER_LETTER) == 0) {
                    return false;
                }
            } else if (Character.isJavaIdentifierPart(patternChar)
                    && !Character.isUpperCase(patternChar)) {
                return false;
            }

            // patternChar is uppercase, so let's find the next uppercase in
            // name
            while (true) {
                if (iName == nameEnd) {
                    // We have exhausted name (and not pattern), so it's not a
                    // match
                    return false;
                }

                nameChar = name[iName];
                if (nameChar < MAX_OBVIOUS) {
                    if ((ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[nameChar] & (ScannerHelper.C_LOWER_LETTER
                            | ScannerHelper.C_SPECIAL | ScannerHelper.C_DIGIT)) != 0) {
                        // nameChar is lowercase
                        iName++;
                        // nameChar is uppercase...
                    } else if (patternChar != nameChar) {
                        // .. and it does not match patternChar, so it's not a
                        // match
                        return false;
                    } else {
                        // .. and it matched patternChar. Back to the big loop
                        break;
                    }
                } else if (Character.isJavaIdentifierPart(nameChar)
                        && !Character.isUpperCase(nameChar)) {
                    // nameChar is lowercase
                    iName++;
                    // nameChar is uppercase...
                } else if (patternChar != nameChar) {
                    // .. and it does not match patternChar, so it's not a match
                    return false;
                } else {
                    // .. and it matched patternChar. Back to the big loop
                    break;
                }
            }
            // At this point, either name has been exhausted, or it is at an
            // uppercase letter.
            // Since pattern is also at an uppercase letter
        }
    }

}
