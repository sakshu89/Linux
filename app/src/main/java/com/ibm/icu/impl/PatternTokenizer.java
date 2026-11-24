package com.ibm.icu.impl;

import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeSet;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class PatternTokenizer {
    private static final int AFTER_QUOTE = -1;
    public static final char BACK_SLASH = '\\';
    public static final int BROKEN_ESCAPE = 4;
    public static final int BROKEN_QUOTE = 3;
    public static final int DONE = 0;
    private static final int HEX = 4;
    private static int IN_QUOTE = -2;
    public static final int LITERAL = 2;
    private static final int NONE = 0;
    private static final int NORMAL_QUOTE = 2;
    private static int NO_QUOTE = -1;
    public static final char SINGLE_QUOTE = '\'';
    private static final int SLASH_START = 3;
    private static final int START_QUOTE = 1;
    public static final int SYNTAX = 1;
    public static final int UNKNOWN = 5;
    private int limit;
    private String pattern;
    private int start;
    private UnicodeSet ignorableCharacters = new UnicodeSet();
    private UnicodeSet syntaxCharacters = new UnicodeSet();
    private UnicodeSet extraQuotingCharacters = new UnicodeSet();
    private UnicodeSet escapeCharacters = new UnicodeSet();
    private boolean usingSlash = false;
    private boolean usingQuote = false;
    private transient UnicodeSet needingQuoteCharacters = null;

    private void appendEscaped(StringBuffer stringBuffer, int i) {
        if (i <= 65535) {
            stringBuffer.append("\\u");
            stringBuffer.append(Utility.hex(i, 4));
        } else {
            stringBuffer.append("\\U");
            stringBuffer.append(Utility.hex(i, 8));
        }
    }

    public UnicodeSet getEscapeCharacters() {
        return this.escapeCharacters.m20clone();
    }

    public UnicodeSet getExtraQuotingCharacters() {
        return this.extraQuotingCharacters.m20clone();
    }

    public UnicodeSet getIgnorableCharacters() {
        return this.ignorableCharacters.m20clone();
    }

    public int getLimit() {
        return this.limit;
    }

    public int getStart() {
        return this.start;
    }

    public UnicodeSet getSyntaxCharacters() {
        return this.syntaxCharacters.m20clone();
    }

    public boolean isUsingQuote() {
        return this.usingQuote;
    }

    public boolean isUsingSlash() {
        return this.usingSlash;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x009c  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:63:0x00af  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:85:0x009a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x00be A[SYNTHETIC] */
    public int next(StringBuffer stringBuffer) {
        int i;
        int charCount = this.start;
        if (charCount >= this.limit) {
            return 0;
        }
        int i2 = 5;
        int i3 = 5;
        byte b = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = this.limit;
            if (charCount >= i6) {
                this.start = i6;
                if (b == 1 || b == 2) {
                    return 3;
                }
                if (b != 3) {
                    if (b != 4) {
                        return i3;
                    }
                    return 4;
                }
                if (this.usingSlash) {
                    return 4;
                }
                stringBuffer.append(BACK_SLASH);
                return i3;
            }
            int iCharAt = UTF16.charAt(this.pattern, charCount);
            if (b != -1) {
                if (b != 1) {
                    if (b != 2) {
                        if (b == 3) {
                            if (iCharAt == 85) {
                                i5 = 8;
                                b = 4;
                            } else if (iCharAt == 117) {
                                b = 4;
                                i5 = 4;
                            } else if (this.usingSlash) {
                                UTF16.append(stringBuffer, iCharAt);
                            } else {
                                stringBuffer.append(BACK_SLASH);
                                b = 0;
                                if (this.ignorableCharacters.contains(iCharAt)) {
                                    continue;
                                } else {
                                    if (this.syntaxCharacters.contains(iCharAt)) {
                                        if (i3 != 5) {
                                            this.start = charCount;
                                            return i3;
                                        }
                                        UTF16.append(stringBuffer, iCharAt);
                                        this.start = UTF16.getCharCount(iCharAt) + charCount;
                                        return 1;
                                    }
                                    if (iCharAt == 92) {
                                        b = 3;
                                    } else if (this.usingQuote) {
                                        UTF16.append(stringBuffer, iCharAt);
                                    } else {
                                        UTF16.append(stringBuffer, iCharAt);
                                    }
                                    i3 = 2;
                                }
                            }
                            i4 = 0;
                        } else if (b == 4) {
                            int i7 = (i4 << 4) + iCharAt;
                            switch (iCharAt) {
                                case 48:
                                case 49:
                                case 50:
                                case 51:
                                case 52:
                                case 53:
                                case 54:
                                case 55:
                                case 56:
                                case 57:
                                    i = i7 - 48;
                                    break;
                                default:
                                    switch (iCharAt) {
                                        case 65:
                                        case 66:
                                        case 67:
                                        case 68:
                                        case 69:
                                        case 70:
                                            i = i7 - 55;
                                            break;
                                        default:
                                            switch (iCharAt) {
                                                case 97:
                                                case 98:
                                                case 99:
                                                case 100:
                                                case 101:
                                                case 102:
                                                    i = i7 - 87;
                                                    break;
                                                default:
                                                    this.start = charCount;
                                                    return 4;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            i4 = i;
                            i5--;
                            if (i5 == 0) {
                                UTF16.append(stringBuffer, i4);
                            }
                        } else if (this.ignorableCharacters.contains(iCharAt)) {
                            continue;
                        } else {
                            if (this.syntaxCharacters.contains(iCharAt)) {
                                if (i3 != 5) {
                                    this.start = charCount;
                                    return i3;
                                }
                                UTF16.append(stringBuffer, iCharAt);
                                this.start = UTF16.getCharCount(iCharAt) + charCount;
                                return 1;
                            }
                            if (iCharAt == 92) {
                                b = 3;
                            } else if (this.usingQuote || iCharAt != 39) {
                                UTF16.append(stringBuffer, iCharAt);
                            } else {
                                i2 = iCharAt;
                                b = 1;
                            }
                            i3 = 2;
                        }
                    } else if (iCharAt == i2) {
                        b = -1;
                    } else {
                        UTF16.append(stringBuffer, iCharAt);
                    }
                } else if (iCharAt == i2) {
                    UTF16.append(stringBuffer, iCharAt);
                } else {
                    UTF16.append(stringBuffer, iCharAt);
                    b = 2;
                }
                b = 0;
            } else {
                if (iCharAt == i2) {
                    UTF16.append(stringBuffer, iCharAt);
                    b = 2;
                }
                b = 0;
                if (this.ignorableCharacters.contains(iCharAt)) {
                    continue;
                } else {
                    if (this.syntaxCharacters.contains(iCharAt)) {
                        if (i3 != 5) {
                            this.start = charCount;
                            return i3;
                        }
                        UTF16.append(stringBuffer, iCharAt);
                        this.start = UTF16.getCharCount(iCharAt) + charCount;
                        return 1;
                    }
                    if (iCharAt == 92) {
                        b = 3;
                    } else if (this.usingQuote) {
                        UTF16.append(stringBuffer, iCharAt);
                    } else {
                        UTF16.append(stringBuffer, iCharAt);
                    }
                    i3 = 2;
                }
            }
            charCount += UTF16.getCharCount(iCharAt);
        }
    }

    public String normalize() {
        int i = this.start;
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        while (true) {
            stringBuffer2.setLength(0);
            int next = next(stringBuffer2);
            if (next == 0) {
                this.start = i;
                return stringBuffer.toString();
            }
            if (next != 1) {
                stringBuffer.append(quoteLiteral(stringBuffer2));
            } else {
                stringBuffer.append(stringBuffer2);
            }
        }
    }

    public String quoteLiteral(String str) {
        if (this.needingQuoteCharacters == null) {
            UnicodeSet unicodeSetAddAll = new UnicodeSet().addAll(this.syntaxCharacters).addAll(this.ignorableCharacters).addAll(this.extraQuotingCharacters);
            this.needingQuoteCharacters = unicodeSetAddAll;
            if (this.usingSlash) {
                unicodeSetAddAll.add(92);
            }
            if (this.usingQuote) {
                this.needingQuoteCharacters.add(39);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = NO_QUOTE;
        int charCount = 0;
        while (charCount < str.length()) {
            int iCharAt = UTF16.charAt(str, charCount);
            if (this.escapeCharacters.contains(iCharAt)) {
                if (i == IN_QUOTE) {
                    stringBuffer.append(SINGLE_QUOTE);
                    i = NO_QUOTE;
                }
                appendEscaped(stringBuffer, iCharAt);
            } else if (!this.needingQuoteCharacters.contains(iCharAt)) {
                if (i == IN_QUOTE) {
                    stringBuffer.append(SINGLE_QUOTE);
                    i = NO_QUOTE;
                }
                UTF16.append(stringBuffer, iCharAt);
            } else if (i == IN_QUOTE) {
                UTF16.append(stringBuffer, iCharAt);
                if (this.usingQuote && iCharAt == 39) {
                    stringBuffer.append(SINGLE_QUOTE);
                }
            } else if (this.usingSlash) {
                stringBuffer.append(BACK_SLASH);
                UTF16.append(stringBuffer, iCharAt);
            } else if (!this.usingQuote) {
                appendEscaped(stringBuffer, iCharAt);
            } else if (iCharAt == 39) {
                stringBuffer.append(SINGLE_QUOTE);
                stringBuffer.append(SINGLE_QUOTE);
            } else {
                stringBuffer.append(SINGLE_QUOTE);
                UTF16.append(stringBuffer, iCharAt);
                i = IN_QUOTE;
            }
            charCount += UTF16.getCharCount(iCharAt);
        }
        if (i == IN_QUOTE) {
            stringBuffer.append(SINGLE_QUOTE);
        }
        return stringBuffer.toString();
    }

    public PatternTokenizer setEscapeCharacters(UnicodeSet unicodeSet) {
        this.escapeCharacters = unicodeSet.m20clone();
        return this;
    }

    public PatternTokenizer setExtraQuotingCharacters(UnicodeSet unicodeSet) {
        this.extraQuotingCharacters = unicodeSet.m20clone();
        this.needingQuoteCharacters = null;
        return this;
    }

    public PatternTokenizer setIgnorableCharacters(UnicodeSet unicodeSet) {
        this.ignorableCharacters = unicodeSet.m20clone();
        this.needingQuoteCharacters = null;
        return this;
    }

    public PatternTokenizer setLimit(int i) {
        this.limit = i;
        return this;
    }

    public PatternTokenizer setPattern(String str) {
        if (str == null) {
            og.i("Inconsistent arguments");
            return null;
        }
        this.start = 0;
        this.limit = str.length();
        this.pattern = str;
        return this;
    }

    public PatternTokenizer setStart(int i) {
        this.start = i;
        return this;
    }

    public PatternTokenizer setSyntaxCharacters(UnicodeSet unicodeSet) {
        this.syntaxCharacters = unicodeSet.m20clone();
        this.needingQuoteCharacters = null;
        return this;
    }

    public PatternTokenizer setUsingQuote(boolean z) {
        this.usingQuote = z;
        this.needingQuoteCharacters = null;
        return this;
    }

    public PatternTokenizer setUsingSlash(boolean z) {
        this.usingSlash = z;
        this.needingQuoteCharacters = null;
        return this;
    }

    public PatternTokenizer setPattern(CharSequence charSequence) {
        return setPattern(charSequence.toString());
    }

    public String quoteLiteral(CharSequence charSequence) {
        return quoteLiteral(charSequence.toString());
    }
}
