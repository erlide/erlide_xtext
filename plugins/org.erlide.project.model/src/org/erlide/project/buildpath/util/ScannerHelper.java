/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.erlide.project.buildpath.util;

public class ScannerHelper {
    // extended unicode support
    public static final int LOW_SURROGATE_MIN_VALUE = 0xDC00;
    public static final int HIGH_SURROGATE_MIN_VALUE = 0xD800;
    public static final int HIGH_SURROGATE_MAX_VALUE = 0xDBFF;
    public static final int LOW_SURROGATE_MAX_VALUE = 0xDFFF;

    private static final int START_INDEX = 0;

    private static final int PART_INDEX = 1;

    private static long[][][] Tables;

    public final static int MAX_OBVIOUS = 128;

    public final static int[] OBVIOUS_IDENT_CHAR_NATURES = new int[MAX_OBVIOUS];

    public final static int C_JLS_SPACE = 0x100;

    public final static int C_SPECIAL = 0x80;

    public final static int C_IDENT_START = 0x40;

    public final static int C_UPPER_LETTER = 0x20;

    public final static int C_LOWER_LETTER = 0x10;

    public final static int C_IDENT_PART = 0x8;

    public final static int C_DIGIT = 0x4;

    public final static int C_SEPARATOR = 0x2;

    public final static int C_SPACE = 0x1;

    static {
        OBVIOUS_IDENT_CHAR_NATURES[0] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[1] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[2] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[3] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[4] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[5] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[6] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[7] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[8] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[14] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[15] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[16] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[17] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[18] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[19] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[20] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[21] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[22] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[23] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[24] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[25] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[26] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[27] = C_IDENT_PART;
        OBVIOUS_IDENT_CHAR_NATURES[127] = C_IDENT_PART;

        for (int i = '0'; i <= '9'; i++) {
            OBVIOUS_IDENT_CHAR_NATURES[i] = C_DIGIT | C_IDENT_PART;
        }

        for (int i = 'a'; i <= 'z'; i++) {
            OBVIOUS_IDENT_CHAR_NATURES[i] = C_LOWER_LETTER | C_IDENT_PART
                    | C_IDENT_START;
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            OBVIOUS_IDENT_CHAR_NATURES[i] = C_UPPER_LETTER | C_IDENT_PART
                    | C_IDENT_START;
        }

        OBVIOUS_IDENT_CHAR_NATURES['_'] = C_SPECIAL | C_IDENT_PART
                | C_IDENT_START;
        OBVIOUS_IDENT_CHAR_NATURES['$'] = C_SPECIAL | C_IDENT_PART
                | C_IDENT_START;

        OBVIOUS_IDENT_CHAR_NATURES[9] = C_SPACE | C_JLS_SPACE; // \ u0009:
                                                               // HORIZONTAL
                                                               // TABULATION
        OBVIOUS_IDENT_CHAR_NATURES[10] = C_SPACE | C_JLS_SPACE; // \ u000a: LINE
                                                                // FEED
        OBVIOUS_IDENT_CHAR_NATURES[11] = C_SPACE;
        OBVIOUS_IDENT_CHAR_NATURES[12] = C_SPACE | C_JLS_SPACE; // \ u000c: FORM
                                                                // FEED
        OBVIOUS_IDENT_CHAR_NATURES[13] = C_SPACE | C_JLS_SPACE; // \ u000d:
                                                                // CARRIAGE
                                                                // RETURN
        OBVIOUS_IDENT_CHAR_NATURES[28] = C_SPACE;
        OBVIOUS_IDENT_CHAR_NATURES[29] = C_SPACE;
        OBVIOUS_IDENT_CHAR_NATURES[30] = C_SPACE;
        OBVIOUS_IDENT_CHAR_NATURES[31] = C_SPACE;
        OBVIOUS_IDENT_CHAR_NATURES[32] = C_SPACE | C_JLS_SPACE; // \ u0020:
                                                                // SPACE

        OBVIOUS_IDENT_CHAR_NATURES['.'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES[':'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES[';'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES[','] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['['] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES[']'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['('] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES[')'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['{'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['}'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['+'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['-'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['*'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['/'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['='] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['&'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['|'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['?'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['<'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['>'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['!'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['%'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['^'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['~'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['"'] = C_SEPARATOR;
        OBVIOUS_IDENT_CHAR_NATURES['\''] = C_SEPARATOR;
    }

    public static boolean isScriptIdentifierPart(final char c) {
        if (c < MAX_OBVIOUS) {
            return (ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[c] & ScannerHelper.C_IDENT_PART) != 0;
        }
        return Character.isJavaIdentifierPart(c);
    }

    public static boolean isScriptIdentifierStart(final char c) {
        if (c < MAX_OBVIOUS) {
            return (ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[c] & ScannerHelper.C_IDENT_START) != 0;
        }
        return Character.isJavaIdentifierStart(c);
    }

    private static int toCodePoint(final char high, final char low) {
        return (high - HIGH_SURROGATE_MIN_VALUE) * 0x400 + low
                - LOW_SURROGATE_MIN_VALUE + 0x10000;
    }

    public static boolean isDigit(final char c) throws InvalidInputException {
        if (c < ScannerHelper.MAX_OBVIOUS) {
            return (ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[c] & ScannerHelper.C_DIGIT) != 0;
        }
        if (Character.isDigit(c)) {
            throw new InvalidInputException("Invalid_Digit"); //$NON-NLS-1$
        }
        return false;
    }

    public static int digit(final char c, final int radix) {
        if (c < ScannerHelper.MAX_OBVIOUS) {
            switch (radix) {
            case 8:
                if (c >= 48 && c <= 55) {
                    return c - 48;
                }
                return -1;
            case 10:
                if (c >= 48 && c <= 57) {
                    return c - 48;
                }
                return -1;
            case 16:
                if (c >= 48 && c <= 57) {
                    return c - 48;
                }
                if (c >= 65 && c <= 70) {
                    return c - 65 + 10;
                }
                if (c >= 97 && c <= 102) {
                    return c - 97 + 10;
                }
                return -1;
            }
        }
        return Character.digit(c, radix);
    }

    public static int getNumericValue(final char c) {
        if (c < ScannerHelper.MAX_OBVIOUS) {
            switch (ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[c]) {
            case C_DIGIT:
                return c - '0';
            case C_LOWER_LETTER:
                return 10 + c - 'a';
            case C_UPPER_LETTER:
                return 10 + c - 'A';
            }
        }
        return Character.getNumericValue(c);
    }

    public static char toUpperCase(final char c) {
        if (c < MAX_OBVIOUS) {
            if ((ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[c] & ScannerHelper.C_UPPER_LETTER) != 0) {
                return c;
            } else if ((ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[c] & ScannerHelper.C_LOWER_LETTER) != 0) {
                return (char) (c - 32);
            }
        }
        return Character.toLowerCase(c);
    }

    public static char toLowerCase(final char c) {
        if (c < MAX_OBVIOUS) {
            if ((ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[c] & ScannerHelper.C_LOWER_LETTER) != 0) {
                return c;
            } else if ((ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[c] & ScannerHelper.C_UPPER_LETTER) != 0) {
                return (char) (32 + c);
            }
        }
        return Character.toLowerCase(c);
    }

    public static boolean isLowerCase(final char c) {
        if (c < MAX_OBVIOUS) {
            return (ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[c] & ScannerHelper.C_LOWER_LETTER) != 0;
        }
        return Character.isLowerCase(c);
    }

    public static boolean isUpperCase(final char c) {
        if (c < MAX_OBVIOUS) {
            return (ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[c] & ScannerHelper.C_UPPER_LETTER) != 0;
        }
        return Character.isUpperCase(c);
    }

    /**
     * Include also non JLS whitespaces.
     * 
     * return true if Character.isWhitespace(c) would return true
     */
    public static boolean isWhitespace(final char c) {
        if (c < MAX_OBVIOUS) {
            return (ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[c] & ScannerHelper.C_SPACE) != 0;
        }
        return Character.isWhitespace(c);
    }

    public static boolean isLetter(final char c) {
        if (c < MAX_OBVIOUS) {
            return (ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[c] & (ScannerHelper.C_UPPER_LETTER | ScannerHelper.C_LOWER_LETTER)) != 0;
        }
        return Character.isLetter(c);
    }

    public static boolean isLetterOrDigit(final char c) {
        if (c < MAX_OBVIOUS) {
            return (ScannerHelper.OBVIOUS_IDENT_CHAR_NATURES[c] & (ScannerHelper.C_UPPER_LETTER
                    | ScannerHelper.C_LOWER_LETTER | ScannerHelper.C_DIGIT)) != 0;
        }
        return Character.isLetterOrDigit(c);
    }
}
