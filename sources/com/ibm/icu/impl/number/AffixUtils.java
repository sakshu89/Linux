package com.ibm.icu.impl.number;

import com.ibm.icu.impl.FormattedStringBuilder;
import com.ibm.icu.impl.PatternTokenizer;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.UnicodeSet;
import defpackage.cq;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class AffixUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int STATE_AFTER_QUOTE = 3;
    private static final int STATE_BASE = 0;
    private static final int STATE_FIFTH_CURR = 8;
    private static final int STATE_FIRST_CURR = 4;
    private static final int STATE_FIRST_QUOTE = 1;
    private static final int STATE_FOURTH_CURR = 7;
    private static final int STATE_INSIDE_QUOTE = 2;
    private static final int STATE_OVERFLOW_CURR = 9;
    private static final int STATE_SECOND_CURR = 5;
    private static final int STATE_THIRD_CURR = 6;
    public static final int TYPE_APPROXIMATELY_SIGN = -3;
    private static final int TYPE_CODEPOINT = 0;
    public static final int TYPE_CURRENCY_DOUBLE = -7;
    public static final int TYPE_CURRENCY_OVERFLOW = -15;
    public static final int TYPE_CURRENCY_QUAD = -9;
    public static final int TYPE_CURRENCY_QUINT = -10;
    public static final int TYPE_CURRENCY_SINGLE = -6;
    public static final int TYPE_CURRENCY_TRIPLE = -8;
    public static final int TYPE_MINUS_SIGN = -1;
    public static final int TYPE_PERCENT = -4;
    public static final int TYPE_PERMILLE = -5;
    public static final int TYPE_PLUS_SIGN = -2;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface SymbolProvider {
        CharSequence getSymbol(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface TokenConsumer {
        void consumeToken(int i);
    }

    public static boolean containsOnlySymbolsAndIgnorables(CharSequence charSequence, UnicodeSet unicodeSet) {
        if (charSequence == null) {
            return true;
        }
        long jNextToken = 0;
        while (hasNext(jNextToken, charSequence)) {
            jNextToken = nextToken(jNextToken, charSequence);
            int typeOrCp = getTypeOrCp(jNextToken);
            if (typeOrCp >= 0 && !unicodeSet.contains(typeOrCp)) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsType(CharSequence charSequence, int i) {
        if (charSequence != null && charSequence.length() != 0) {
            long jNextToken = 0;
            while (hasNext(jNextToken, charSequence)) {
                jNextToken = nextToken(jNextToken, charSequence);
                if (getTypeOrCp(jNextToken) == i) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0041 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0043  */
    /* JADX WARN: Code duplicated, block: B:25:0x004b  */
    public static int escape(CharSequence charSequence, StringBuilder sb) {
        if (charSequence == null) {
            return 0;
        }
        int length = sb.length();
        int iCharCount = 0;
        char c = 0;
        while (iCharCount < charSequence.length()) {
            int iCodePointAt = Character.codePointAt(charSequence, iCharCount);
            if (iCodePointAt == 37) {
                if (c == 0) {
                    sb.append(PatternTokenizer.SINGLE_QUOTE);
                    sb.appendCodePoint(iCodePointAt);
                    c = 2;
                } else {
                    sb.appendCodePoint(iCodePointAt);
                }
            } else if (iCodePointAt == 39) {
                sb.append("''");
            } else if (iCodePointAt == 43 || iCodePointAt == 45 || iCodePointAt == 164 || iCodePointAt == 8240) {
                if (c == 0) {
                    sb.append(PatternTokenizer.SINGLE_QUOTE);
                    sb.appendCodePoint(iCodePointAt);
                    c = 2;
                } else {
                    sb.appendCodePoint(iCodePointAt);
                }
            } else if (c == 2) {
                sb.append(PatternTokenizer.SINGLE_QUOTE);
                sb.appendCodePoint(iCodePointAt);
                c = 0;
            } else {
                sb.appendCodePoint(iCodePointAt);
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        if (c == 2) {
            sb.append(PatternTokenizer.SINGLE_QUOTE);
        }
        return sb.length() - length;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x002f A[PHI: r6
      0x002f: PHI (r6v1 char) = (r6v0 char), (r6v2 char) binds: [B:23:0x0037, B:19:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    public static int estimateLength(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        int iCharCount = 0;
        char c = 0;
        int i = 0;
        while (true) {
            char c2 = 1;
            if (iCharCount >= charSequence.length()) {
                if (c != 1 && c != 2) {
                    return i;
                }
                og.i(cq.v("Unterminated quote: \"", String.valueOf(charSequence), "\""));
                return 0;
            }
            int iCodePointAt = Character.codePointAt(charSequence, iCharCount);
            if (c != 0) {
                if (c != 1) {
                    c2 = 3;
                    if (c != 2) {
                        if (c != 3) {
                            throw new AssertionError();
                        }
                        if (iCodePointAt == 39) {
                        }
                    } else if (iCodePointAt == 39) {
                        c = c2;
                    }
                    i++;
                } else if (iCodePointAt == 39) {
                    i++;
                    c = 0;
                }
                i++;
                c = 2;
            } else if (iCodePointAt == 39) {
                c = c2;
            } else {
                i++;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
    }

    private static int getCodePoint(long j) {
        return (int) (j >>> 40);
    }

    public static final NumberFormat.Field getFieldForType(int i) {
        if (i == -15) {
            return NumberFormat.Field.CURRENCY;
        }
        switch (i) {
            case TYPE_CURRENCY_QUINT /* -10 */:
                return NumberFormat.Field.CURRENCY;
            case TYPE_CURRENCY_QUAD /* -9 */:
                return NumberFormat.Field.CURRENCY;
            case TYPE_CURRENCY_TRIPLE /* -8 */:
                return NumberFormat.Field.CURRENCY;
            case TYPE_CURRENCY_DOUBLE /* -7 */:
                return NumberFormat.Field.CURRENCY;
            case TYPE_CURRENCY_SINGLE /* -6 */:
                return NumberFormat.Field.CURRENCY;
            case TYPE_PERMILLE /* -5 */:
                return NumberFormat.Field.PERMILLE;
            case TYPE_PERCENT /* -4 */:
                return NumberFormat.Field.PERCENT;
            case -3:
                return NumberFormat.Field.APPROXIMATELY_SIGN;
            case -2:
                return NumberFormat.Field.SIGN;
            case -1:
                return NumberFormat.Field.SIGN;
            default:
                throw new AssertionError();
        }
    }

    private static int getOffset(long j) {
        return (int) j;
    }

    private static int getState(long j) {
        return (int) ((j >>> 36) & 15);
    }

    private static int getType(long j) {
        return (int) ((j >>> 32) & 15);
    }

    private static int getTypeOrCp(long j) {
        int type = getType(j);
        return type == 0 ? getCodePoint(j) : -type;
    }

    public static boolean hasCurrencySymbols(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            long jNextToken = 0;
            while (hasNext(jNextToken, charSequence)) {
                jNextToken = nextToken(jNextToken, charSequence);
                int typeOrCp = getTypeOrCp(jNextToken);
                if (typeOrCp < 0 && getFieldForType(typeOrCp) == NumberFormat.Field.CURRENCY) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasNext(long j, CharSequence charSequence) {
        int state = getState(j);
        int offset = getOffset(j);
        if (state == 2 && offset == charSequence.length() - 1 && charSequence.charAt(offset) == '\'') {
            return false;
        }
        return state != 0 || offset < charSequence.length();
    }

    public static void iterateWithConsumer(CharSequence charSequence, TokenConsumer tokenConsumer) {
        long jNextToken = 0;
        while (hasNext(jNextToken, charSequence)) {
            jNextToken = nextToken(jNextToken, charSequence);
            tokenConsumer.consumeToken(getTypeOrCp(jNextToken));
        }
    }

    private static long makeTag(int i, int i2, int i3, int i4) {
        return ((-i2) << 32) | ((long) i) | (((long) i3) << 36) | (((long) i4) << 40);
    }

    private static long nextToken(long j, CharSequence charSequence) {
        int offset = getOffset(j);
        int state = getState(j);
        while (offset < charSequence.length()) {
            int iCodePointAt = Character.codePointAt(charSequence, offset);
            int iCharCount = Character.charCount(iCodePointAt);
            switch (state) {
                case 0:
                    if (iCodePointAt == 37) {
                        return makeTag(offset + iCharCount, -4, 0, 0);
                    }
                    if (iCodePointAt == 39) {
                        offset += iCharCount;
                        state = 1;
                    } else {
                        if (iCodePointAt == 43) {
                            return makeTag(offset + iCharCount, -2, 0, 0);
                        }
                        if (iCodePointAt == 45) {
                            return makeTag(offset + iCharCount, -1, 0, 0);
                        }
                        if (iCodePointAt == 126) {
                            return makeTag(offset + iCharCount, -3, 0, 0);
                        }
                        if (iCodePointAt != 164) {
                            return iCodePointAt != 8240 ? makeTag(offset + iCharCount, 0, 0, iCodePointAt) : makeTag(offset + iCharCount, -5, 0, 0);
                        }
                        offset += iCharCount;
                        state = 4;
                    }
                    break;
                    break;
                case 1:
                    return iCodePointAt == 39 ? makeTag(offset + iCharCount, 0, 0, iCodePointAt) : makeTag(offset + iCharCount, 0, 2, iCodePointAt);
                case 2:
                    if (iCodePointAt != 39) {
                        return makeTag(offset + iCharCount, 0, 2, iCodePointAt);
                    }
                    offset += iCharCount;
                    state = 3;
                    break;
                    break;
                case 3:
                    if (iCodePointAt == 39) {
                        return makeTag(offset + iCharCount, 0, 2, iCodePointAt);
                    }
                    state = 0;
                    break;
                case 4:
                    if (iCodePointAt != 164) {
                        return makeTag(offset, -6, 0, 0);
                    }
                    offset += iCharCount;
                    state = 5;
                    break;
                    break;
                case 5:
                    if (iCodePointAt != 164) {
                        return makeTag(offset, -7, 0, 0);
                    }
                    offset += iCharCount;
                    state = 6;
                    break;
                    break;
                case 6:
                    if (iCodePointAt != 164) {
                        return makeTag(offset, -8, 0, 0);
                    }
                    offset += iCharCount;
                    state = 7;
                    break;
                    break;
                case 7:
                    if (iCodePointAt != 164) {
                        return makeTag(offset, -9, 0, 0);
                    }
                    offset += iCharCount;
                    state = 8;
                    break;
                    break;
                case 8:
                    if (iCodePointAt != 164) {
                        return makeTag(offset, -10, 0, 0);
                    }
                    offset += iCharCount;
                    state = 9;
                    break;
                    break;
                case 9:
                    if (iCodePointAt != 164) {
                        return makeTag(offset, -15, 0, 0);
                    }
                    offset += iCharCount;
                    break;
                    break;
                default:
                    throw new AssertionError();
            }
        }
        switch (state) {
            case 0:
                return -1L;
            case 1:
            case 2:
                og.i(cq.v("Unterminated quote in pattern affix: \"", String.valueOf(charSequence), "\""));
                return 0L;
            case 3:
                return -1L;
            case 4:
                return makeTag(offset, -6, 0, 0);
            case 5:
                return makeTag(offset, -7, 0, 0);
            case 6:
                return makeTag(offset, -8, 0, 0);
            case 7:
                return makeTag(offset, -9, 0, 0);
            case 8:
                return makeTag(offset, -10, 0, 0);
            case 9:
                return makeTag(offset, -15, 0, 0);
            default:
                throw new AssertionError();
        }
    }

    public static String replaceType(CharSequence charSequence, int i, char c) {
        if (charSequence == null || charSequence.length() == 0) {
            return "";
        }
        char[] charArray = charSequence.toString().toCharArray();
        long jNextToken = 0;
        while (hasNext(jNextToken, charSequence)) {
            jNextToken = nextToken(jNextToken, charSequence);
            if (getTypeOrCp(jNextToken) == i) {
                charArray[getOffset(jNextToken) - 1] = c;
            }
        }
        return new String(charArray);
    }

    public static int unescape(CharSequence charSequence, FormattedStringBuilder formattedStringBuilder, int i, SymbolProvider symbolProvider, NumberFormat.Field field) {
        int iInsert;
        int i2 = 0;
        long jNextToken = 0;
        while (hasNext(jNextToken, charSequence)) {
            jNextToken = nextToken(jNextToken, charSequence);
            int typeOrCp = getTypeOrCp(jNextToken);
            if (typeOrCp == -15) {
                iInsert = formattedStringBuilder.insertCodePoint(i + i2, UCharacter.REPLACEMENT_CHAR, NumberFormat.Field.CURRENCY);
            } else {
                iInsert = typeOrCp < 0 ? formattedStringBuilder.insert(i + i2, symbolProvider.getSymbol(typeOrCp), getFieldForType(typeOrCp)) : formattedStringBuilder.insertCodePoint(i + i2, typeOrCp, field);
            }
            i2 = iInsert + i2;
        }
        return i2;
    }

    public static int unescapedCount(CharSequence charSequence, boolean z, SymbolProvider symbolProvider) {
        int iCharCount;
        long jNextToken = 0;
        int i = 0;
        while (hasNext(jNextToken, charSequence)) {
            jNextToken = nextToken(jNextToken, charSequence);
            int typeOrCp = getTypeOrCp(jNextToken);
            if (typeOrCp == -15) {
                i++;
            } else {
                if (typeOrCp < 0) {
                    CharSequence symbol = symbolProvider.getSymbol(typeOrCp);
                    iCharCount = z ? symbol.length() : Character.codePointCount(symbol, 0, symbol.length());
                } else {
                    iCharCount = z ? Character.charCount(typeOrCp) : 1;
                }
                i += iCharCount;
            }
        }
        return i;
    }

    public static String escape(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        escape(charSequence, sb);
        return sb.toString();
    }
}
