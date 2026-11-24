package com.ibm.icu.text;

import com.ibm.icu.impl.IllegalIcuArgumentException;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.lang.UCharacter;
import defpackage.cq;
import defpackage.ky0;
import defpackage.og;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class TransliteratorParser {
    private static final char ALT_FORWARD_RULE_OP = 8594;
    private static final char ALT_FUNCTION = 8710;
    private static final char ALT_FWDREV_RULE_OP = 8596;
    private static final char ALT_REVERSE_RULE_OP = 8592;
    private static final char ANCHOR_START = '^';
    private static final char CONTEXT_ANTE = '{';
    private static final char CONTEXT_POST = '}';
    private static final char CURSOR_OFFSET = '@';
    private static final char CURSOR_POS = '|';
    private static final char DOT = '.';
    private static final String DOT_SET = "[^[:Zp:][:Zl:]\\r\\n$]";
    private static final char END_OF_RULE = ';';
    private static final char ESCAPE = '\\';
    private static final char FORWARD_RULE_OP = '>';
    private static final char FUNCTION = '&';
    private static final char FWDREV_RULE_OP = '~';
    private static final String HALF_ENDERS = "=><←→↔;";
    private static final String ID_TOKEN = "::";
    private static final int ID_TOKEN_LEN = 2;
    private static final char KLEENE_STAR = '*';
    private static final char ONE_OR_MORE = '+';
    private static final String OPERATORS = "=><←→↔";
    private static final char QUOTE = '\'';
    private static final char REVERSE_RULE_OP = '<';
    private static final char RULE_COMMENT_CHAR = '#';
    private static final char SEGMENT_CLOSE = ')';
    private static final char SEGMENT_OPEN = '(';
    private static final char VARIABLE_DEF_OP = '=';
    private static final char ZERO_OR_ONE = '?';
    public UnicodeSet compoundFilter;
    private RuleBasedTransliterator.Data curData;
    public List<RuleBasedTransliterator.Data> dataVector;
    private int direction;
    private int dotStandIn = -1;
    public List<String> idBlockVector;
    private ParseData parseData;
    private List<StringMatcher> segmentObjects;
    private StringBuilder segmentStandins;
    private String undefinedVariableName;
    private char variableLimit;
    private Map<String, char[]> variableNames;
    private char variableNext;
    private List<Object> variablesVector;
    private static final UnicodeSet ILLEGAL_TOP = new UnicodeSet("[\\)]").freeze();
    private static final UnicodeSet ILLEGAL_SEG = new UnicodeSet("[\\{\\}\\|\\@]").freeze();
    private static final UnicodeSet ILLEGAL_FUNC = new UnicodeSet("[\\^\\(\\.\\*\\+\\?\\{\\}\\|\\@]").freeze();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RuleArray extends RuleBody {
        String[] array;
        int i;

        public RuleArray(String[] strArr) {
            super(0);
            this.array = strArr;
            this.i = 0;
        }

        @Override // com.ibm.icu.text.TransliteratorParser.RuleBody
        public String handleNextLine() {
            int i = this.i;
            String[] strArr = this.array;
            if (i >= strArr.length) {
                return null;
            }
            this.i = i + 1;
            return strArr[i];
        }

        @Override // com.ibm.icu.text.TransliteratorParser.RuleBody
        public void reset() {
            this.i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appendVariableDef(String str, StringBuilder sb) {
        char[] cArr = this.variableNames.get(str);
        if (cArr != null) {
            sb.append(cArr);
            return;
        }
        if (this.undefinedVariableName != null) {
            throw new IllegalIcuArgumentException(cq.j("Undefined variable $", str));
        }
        this.undefinedVariableName = str;
        char c = this.variableNext;
        char c2 = this.variableLimit;
        if (c >= c2) {
            og.p("Private use variables exhausted");
            return;
        }
        char c3 = (char) (c2 - 1);
        this.variableLimit = c3;
        sb.append(c3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkVariableRange(int i, String str, int i2) {
        if (i < this.curData.variablesBase || i >= this.variableLimit) {
            return;
        }
        syntaxError("Variable range character in rule", str, i2);
    }

    private int parsePragma(String str, int i, int i2) {
        int[] iArr = new int[2];
        int i3 = i + 4;
        int pattern = Utility.parsePattern(str, i3, i2, "~variable range # #~;", iArr);
        if (pattern >= 0) {
            setVariableRange(iArr[0], iArr[1]);
            return pattern;
        }
        int pattern2 = Utility.parsePattern(str, i3, i2, "~maximum backup #~;", iArr);
        if (pattern2 >= 0) {
            pragmaMaximumBackup(iArr[0]);
            return pattern2;
        }
        int pattern3 = Utility.parsePattern(str, i3, i2, "~nfd rules~;", null);
        if (pattern3 >= 0) {
            pragmaNormalizeRules(Normalizer.NFD);
            return pattern3;
        }
        int pattern4 = Utility.parsePattern(str, i3, i2, "~nfc rules~;", null);
        if (pattern4 < 0) {
            return -1;
        }
        pragmaNormalizeRules(Normalizer.NFC);
        return pattern4;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x0188  */
    /* JADX WARN: Code duplicated, block: B:114:0x0195  */
    /* JADX WARN: Code duplicated, block: B:119:0x0109 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x005c  */
    /* JADX WARN: Code duplicated, block: B:19:0x0060  */
    /* JADX WARN: Code duplicated, block: B:21:0x0064  */
    /* JADX WARN: Code duplicated, block: B:22:0x0066  */
    /* JADX WARN: Code duplicated, block: B:23:0x0068  */
    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Code duplicated, block: B:29:0x007a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0087 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x0089  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:58:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:60:0x0106  */
    /* JADX WARN: Code duplicated, block: B:65:0x0115  */
    /* JADX WARN: Code duplicated, block: B:67:0x011d  */
    /* JADX WARN: Code duplicated, block: B:70:0x0125  */
    /* JADX WARN: Code duplicated, block: B:72:0x0129  */
    /* JADX WARN: Code duplicated, block: B:73:0x012b  */
    /* JADX WARN: Code duplicated, block: B:75:0x012e  */
    /* JADX WARN: Code duplicated, block: B:76:0x0130  */
    /* JADX WARN: Code duplicated, block: B:78:0x0133 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x0139  */
    /* JADX WARN: Code duplicated, block: B:84:0x0140  */
    /* JADX WARN: Code duplicated, block: B:87:0x014c  */
    /* JADX WARN: Code duplicated, block: B:90:0x0152  */
    private int parseRule(String str, int i, int i2) {
        char cCharAt;
        int i3;
        char c;
        int i4;
        String str2;
        int i5;
        int i6;
        boolean z;
        boolean z2;
        int i7;
        this.segmentStandins = new StringBuilder();
        this.segmentObjects = new ArrayList();
        int i8 = 0;
        RuleHalf ruleHalf = new RuleHalf(i8);
        RuleHalf ruleHalf2 = new RuleHalf(i8);
        UnicodeMatcher[] unicodeMatcherArr = null;
        this.undefinedVariableName = null;
        int i9 = ruleHalf.parse(str, i, i2, this);
        if (i9 != i2) {
            i9--;
            cCharAt = str.charAt(i9);
            if (OPERATORS.indexOf(cCharAt) < 0) {
            }
            i3 = i9 + 1;
            c = REVERSE_RULE_OP;
            if (cCharAt == '<' && i3 < i2 && str.charAt(i3) == '>') {
                i3 = i9 + 2;
                cCharAt = '~';
            }
            if (cCharAt != 8592) {
                if (cCharAt != 8594) {
                    c = '>';
                } else if (cCharAt != 8596) {
                    c = cCharAt;
                } else {
                    c = '~';
                }
            }
            i4 = ruleHalf2.parse(str, i3, i2, this);
            if (i4 < i2) {
                i7 = i4 - 1;
                if (str.charAt(i7) != ';') {
                    syntaxError("Unquoted operator", str, i);
                    i4 = i7;
                }
            }
            str2 = this.undefinedVariableName;
            if (c == '=') {
                if (str2 == null) {
                    syntaxError("Missing '$' or duplicate definition", str, i);
                }
                if (ruleHalf.text.length() == 1 || ruleHalf.text.charAt(0) != this.variableLimit) {
                    syntaxError("Malformed LHS", str, i);
                }
                if (ruleHalf.anchorStart || ruleHalf.anchorEnd || ruleHalf2.anchorStart || ruleHalf2.anchorEnd) {
                    syntaxError("Malformed variable def", str, i);
                }
                int length = ruleHalf2.text.length();
                char[] cArr = new char[length];
                ruleHalf2.text.getChars(0, length, cArr, 0);
                this.variableNames.put(this.undefinedVariableName, cArr);
                this.variableLimit = (char) (this.variableLimit + 1);
                return i4;
            }
            if (str2 != null) {
                syntaxError("Undefined variable $".concat(str2), str, i);
            }
            if (this.segmentStandins.length() > this.segmentObjects.size()) {
                syntaxError("Undefined segment reference", str, i);
            }
            for (i5 = 0; i5 < this.segmentStandins.length(); i5++) {
                if (this.segmentStandins.charAt(i5) == 0) {
                    syntaxError("Internal error", str, i);
                }
            }
            for (i6 = 0; i6 < this.segmentObjects.size(); i6++) {
                if (this.segmentObjects.get(i6) == null) {
                    syntaxError("Internal error", str, i);
                }
            }
            if (c != '~') {
                if (this.direction == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (c == '>') {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z != z2) {
                    return i4;
                }
            }
            if (this.direction != 1) {
                ruleHalf2 = ruleHalf;
                ruleHalf = ruleHalf2;
            }
            if (c == '~') {
                ruleHalf.removeContext();
                ruleHalf2.cursor = -1;
                ruleHalf2.cursorOffset = 0;
            }
            if (ruleHalf2.ante < 0) {
                ruleHalf2.ante = 0;
            }
            if (ruleHalf2.post < 0) {
                ruleHalf2.post = ruleHalf2.text.length();
            }
            if (ruleHalf.ante < 0 || ruleHalf.post >= 0 || ruleHalf2.cursor >= 0 || ((ruleHalf.cursorOffset != 0 && ruleHalf.cursor < 0) || ruleHalf.anchorStart || ruleHalf.anchorEnd || !ruleHalf2.isValidInput(this) || !ruleHalf.isValidOutput(this) || ruleHalf2.ante > ruleHalf2.post)) {
                syntaxError("Malformed rule", str, i);
            }
            if (this.segmentObjects.size() > 0) {
                unicodeMatcherArr = new UnicodeMatcher[this.segmentObjects.size()];
                this.segmentObjects.toArray(unicodeMatcherArr);
            }
            RuleBasedTransliterator.Data data = this.curData;
            data.ruleSet.addRule(new TransliterationRule(ruleHalf2.text, ruleHalf2.ante, ruleHalf2.post, ruleHalf.text, ruleHalf.cursor, ruleHalf.cursorOffset, unicodeMatcherArr, ruleHalf2.anchorStart, ruleHalf2.anchorEnd, data));
            return i4;
        }
        cCharAt = 0;
        syntaxError(ky0.h(i9, "No operator pos="), str, i);
        i3 = i9 + 1;
        c = REVERSE_RULE_OP;
        if (cCharAt == '<') {
            i3 = i9 + 2;
            cCharAt = '~';
        }
        if (cCharAt != 8592) {
            if (cCharAt != 8594) {
                c = '>';
            } else if (cCharAt != 8596) {
                c = cCharAt;
            } else {
                c = '~';
            }
        }
        i4 = ruleHalf2.parse(str, i3, i2, this);
        if (i4 < i2) {
            i7 = i4 - 1;
            if (str.charAt(i7) != ';') {
                syntaxError("Unquoted operator", str, i);
                i4 = i7;
            }
        }
        str2 = this.undefinedVariableName;
        if (c == '=') {
            if (str2 == null) {
                syntaxError("Missing '$' or duplicate definition", str, i);
            }
            if (ruleHalf.text.length() == 1) {
                syntaxError("Malformed LHS", str, i);
            } else {
                syntaxError("Malformed LHS", str, i);
            }
            if (ruleHalf.anchorStart) {
                syntaxError("Malformed variable def", str, i);
            } else {
                syntaxError("Malformed variable def", str, i);
            }
            int length2 = ruleHalf2.text.length();
            char[] cArr2 = new char[length2];
            ruleHalf2.text.getChars(0, length2, cArr2, 0);
            this.variableNames.put(this.undefinedVariableName, cArr2);
            this.variableLimit = (char) (this.variableLimit + 1);
            return i4;
        }
        if (str2 != null) {
            syntaxError("Undefined variable $".concat(str2), str, i);
        }
        if (this.segmentStandins.length() > this.segmentObjects.size()) {
            syntaxError("Undefined segment reference", str, i);
        }
        while (i5 < this.segmentStandins.length()) {
            if (this.segmentStandins.charAt(i5) == 0) {
                syntaxError("Internal error", str, i);
            }
        }
        while (i6 < this.segmentObjects.size()) {
            if (this.segmentObjects.get(i6) == null) {
                syntaxError("Internal error", str, i);
            }
        }
        if (c != '~') {
            if (this.direction == 0) {
                z = true;
            } else {
                z = false;
            }
            if (c == '>') {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z != z2) {
                return i4;
            }
        }
        if (this.direction != 1) {
            ruleHalf2 = ruleHalf;
            ruleHalf = ruleHalf2;
        }
        if (c == '~') {
            ruleHalf.removeContext();
            ruleHalf2.cursor = -1;
            ruleHalf2.cursorOffset = 0;
        }
        if (ruleHalf2.ante < 0) {
            ruleHalf2.ante = 0;
        }
        if (ruleHalf2.post < 0) {
            ruleHalf2.post = ruleHalf2.text.length();
        }
        if (ruleHalf.ante < 0) {
            syntaxError("Malformed rule", str, i);
        } else {
            syntaxError("Malformed rule", str, i);
        }
        if (this.segmentObjects.size() > 0) {
            unicodeMatcherArr = new UnicodeMatcher[this.segmentObjects.size()];
            this.segmentObjects.toArray(unicodeMatcherArr);
        }
        RuleBasedTransliterator.Data data2 = this.curData;
        data2.ruleSet.addRule(new TransliterationRule(ruleHalf2.text, ruleHalf2.ante, ruleHalf2.post, ruleHalf.text, ruleHalf.cursor, ruleHalf.cursorOffset, unicodeMatcherArr, ruleHalf2.anchorStart, ruleHalf2.anchorEnd, data2));
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final char parseSet(String str, ParsePosition parsePosition) {
        UnicodeSet unicodeSet = new UnicodeSet(str, parsePosition, this.parseData);
        if (this.variableNext < this.variableLimit) {
            unicodeSet.compact();
            return generateStandInFor(unicodeSet);
        }
        og.p("Private use variables exhausted");
        return (char) 0;
    }

    private void pragmaMaximumBackup(int i) {
        throw new IllegalIcuArgumentException("use maximum backup pragma not implemented yet");
    }

    private void pragmaNormalizeRules(Normalizer.Mode mode) {
        throw new IllegalIcuArgumentException("use normalize rules pragma not implemented yet");
    }

    public static boolean resemblesPragma(String str, int i, int i2) {
        return Utility.parsePattern(str, i, i2, "use ", null) >= 0;
    }

    public static final int ruleEnd(String str, int i, int i2) {
        int iQuotedIndexOf = Utility.quotedIndexOf(str, i, i2, ";");
        return iQuotedIndexOf < 0 ? i2 : iQuotedIndexOf;
    }

    private void setVariableRange(int i, int i2) {
        if (i > i2 || i < 0 || i2 > 65535) {
            throw new IllegalIcuArgumentException(ky0.i("Invalid variable range ", i, i2, ", "));
        }
        char c = (char) i;
        this.curData.variablesBase = c;
        if (this.dataVector.size() == 0) {
            this.variableNext = c;
            this.variableLimit = (char) (i2 + 1);
        }
    }

    public static final void syntaxError(String str, String str2, int i) {
        throw new IllegalIcuArgumentException(ky0.k(str, " in \"", Utility.escape(str2.substring(i, ruleEnd(str2, i, str2.length()))), "\""));
    }

    public char generateStandInFor(Object obj) {
        for (int i = 0; i < this.variablesVector.size(); i++) {
            if (this.variablesVector.get(i) == obj) {
                return (char) (this.curData.variablesBase + i);
            }
        }
        if (this.variableNext >= this.variableLimit) {
            og.p("Variable range exhausted");
            return (char) 0;
        }
        this.variablesVector.add(obj);
        char c = this.variableNext;
        this.variableNext = (char) (c + 1);
        return c;
    }

    public char getDotStandIn() {
        if (this.dotStandIn == -1) {
            this.dotStandIn = generateStandInFor(new UnicodeSet(DOT_SET));
        }
        return (char) this.dotStandIn;
    }

    public char getSegmentStandin(int i) {
        if (this.segmentStandins.length() < i) {
            this.segmentStandins.setLength(i);
        }
        int i2 = i - 1;
        char cCharAt = this.segmentStandins.charAt(i2);
        if (cCharAt != 0) {
            return cCharAt;
        }
        char c = this.variableNext;
        if (c >= this.variableLimit) {
            og.p("Variable range exhausted");
            return (char) 0;
        }
        this.variableNext = (char) (c + 1);
        this.variablesVector.add(null);
        this.segmentStandins.setCharAt(i2, c);
        return c;
    }

    public void parse(String str, int i) {
        parseRules(new RuleArray(new String[]{str}), i);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01b1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:105:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:106:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:110:0x01cd A[LOOP:2: B:108:0x01c5->B:110:0x01cd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:114:0x01f9 A[Catch: IllegalArgumentException -> 0x020d, TryCatch #3 {IllegalArgumentException -> 0x020d, blocks: (B:112:0x01f5, B:114:0x01f9, B:120:0x0205, B:121:0x020c, B:125:0x0210, B:127:0x0218, B:128:0x0228, B:130:0x0231, B:132:0x023f), top: B:157:0x01f5 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x0218 A[Catch: IllegalArgumentException -> 0x020d, LOOP:3: B:125:0x0210->B:127:0x0218, LOOP_END, TryCatch #3 {IllegalArgumentException -> 0x020d, blocks: (B:112:0x01f5, B:114:0x01f9, B:120:0x0205, B:121:0x020c, B:125:0x0210, B:127:0x0218, B:128:0x0228, B:130:0x0231, B:132:0x023f), top: B:157:0x01f5 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x0231 A[Catch: IllegalArgumentException -> 0x020d, TryCatch #3 {IllegalArgumentException -> 0x020d, blocks: (B:112:0x01f5, B:114:0x01f9, B:120:0x0205, B:121:0x020c, B:125:0x0210, B:127:0x0218, B:128:0x0228, B:130:0x0231, B:132:0x023f), top: B:157:0x01f5 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x0251  */
    /* JADX WARN: Code duplicated, block: B:139:0x025b  */
    /* JADX WARN: Code duplicated, block: B:142:0x0269 A[LOOP:5: B:140:0x0263->B:142:0x0269, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:146:0x0283 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:147:0x0284  */
    /* JADX WARN: Code duplicated, block: B:159:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0132 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x0134 A[Catch: IllegalArgumentException -> 0x00a3, TRY_LEAVE, TryCatch #1 {IllegalArgumentException -> 0x00a3, blocks: (B:21:0x0086, B:25:0x0094, B:28:0x009c, B:31:0x00a6, B:33:0x00ac, B:35:0x00b0, B:38:0x00b6, B:40:0x00bd, B:39:0x00ba, B:42:0x00c0, B:44:0x00ca, B:46:0x00d2, B:48:0x00d6, B:68:0x012c, B:49:0x00df, B:50:0x00f6, B:52:0x0102, B:54:0x010a, B:58:0x0111, B:63:0x011a, B:65:0x011e, B:66:0x0123, B:67:0x0127, B:72:0x0134, B:75:0x013a, B:77:0x0149, B:76:0x0142, B:82:0x0165, B:84:0x016b, B:86:0x0171, B:87:0x0177), top: B:153:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x013a A[Catch: IllegalArgumentException -> 0x00a3, TRY_ENTER, TryCatch #1 {IllegalArgumentException -> 0x00a3, blocks: (B:21:0x0086, B:25:0x0094, B:28:0x009c, B:31:0x00a6, B:33:0x00ac, B:35:0x00b0, B:38:0x00b6, B:40:0x00bd, B:39:0x00ba, B:42:0x00c0, B:44:0x00ca, B:46:0x00d2, B:48:0x00d6, B:68:0x012c, B:49:0x00df, B:50:0x00f6, B:52:0x0102, B:54:0x010a, B:58:0x0111, B:63:0x011a, B:65:0x011e, B:66:0x0123, B:67:0x0127, B:72:0x0134, B:75:0x013a, B:77:0x0149, B:76:0x0142, B:82:0x0165, B:84:0x016b, B:86:0x0171, B:87:0x0177), top: B:153:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0142 A[Catch: IllegalArgumentException -> 0x00a3, TryCatch #1 {IllegalArgumentException -> 0x00a3, blocks: (B:21:0x0086, B:25:0x0094, B:28:0x009c, B:31:0x00a6, B:33:0x00ac, B:35:0x00b0, B:38:0x00b6, B:40:0x00bd, B:39:0x00ba, B:42:0x00c0, B:44:0x00ca, B:46:0x00d2, B:48:0x00d6, B:68:0x012c, B:49:0x00df, B:50:0x00f6, B:52:0x0102, B:54:0x010a, B:58:0x0111, B:63:0x011a, B:65:0x011e, B:66:0x0123, B:67:0x0127, B:72:0x0134, B:75:0x013a, B:77:0x0149, B:76:0x0142, B:82:0x0165, B:84:0x016b, B:86:0x0171, B:87:0x0177), top: B:153:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x016b A[Catch: IllegalArgumentException -> 0x00a3, TryCatch #1 {IllegalArgumentException -> 0x00a3, blocks: (B:21:0x0086, B:25:0x0094, B:28:0x009c, B:31:0x00a6, B:33:0x00ac, B:35:0x00b0, B:38:0x00b6, B:40:0x00bd, B:39:0x00ba, B:42:0x00c0, B:44:0x00ca, B:46:0x00d2, B:48:0x00d6, B:68:0x012c, B:49:0x00df, B:50:0x00f6, B:52:0x0102, B:54:0x010a, B:58:0x0111, B:63:0x011a, B:65:0x011e, B:66:0x0123, B:67:0x0127, B:72:0x0134, B:75:0x013a, B:77:0x0149, B:76:0x0142, B:82:0x0165, B:84:0x016b, B:86:0x0171, B:87:0x0177), top: B:153:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0171 A[Catch: IllegalArgumentException -> 0x00a3, TryCatch #1 {IllegalArgumentException -> 0x00a3, blocks: (B:21:0x0086, B:25:0x0094, B:28:0x009c, B:31:0x00a6, B:33:0x00ac, B:35:0x00b0, B:38:0x00b6, B:40:0x00bd, B:39:0x00ba, B:42:0x00c0, B:44:0x00ca, B:46:0x00d2, B:48:0x00d6, B:68:0x012c, B:49:0x00df, B:50:0x00f6, B:52:0x0102, B:54:0x010a, B:58:0x0111, B:63:0x011a, B:65:0x011e, B:66:0x0123, B:67:0x0127, B:72:0x0134, B:75:0x013a, B:77:0x0149, B:76:0x0142, B:82:0x0165, B:84:0x016b, B:86:0x0171, B:87:0x0177), top: B:153:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0177 A[Catch: IllegalArgumentException -> 0x00a3, TRY_LEAVE, TryCatch #1 {IllegalArgumentException -> 0x00a3, blocks: (B:21:0x0086, B:25:0x0094, B:28:0x009c, B:31:0x00a6, B:33:0x00ac, B:35:0x00b0, B:38:0x00b6, B:40:0x00bd, B:39:0x00ba, B:42:0x00c0, B:44:0x00ca, B:46:0x00d2, B:48:0x00d6, B:68:0x012c, B:49:0x00df, B:50:0x00f6, B:52:0x0102, B:54:0x010a, B:58:0x0111, B:63:0x011a, B:65:0x011e, B:66:0x0123, B:67:0x0127, B:72:0x0134, B:75:0x013a, B:77:0x0149, B:76:0x0142, B:82:0x0165, B:84:0x016b, B:86:0x0171, B:87:0x0177), top: B:153:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0195  */
    public void parseRules(RuleBody ruleBody, int i) {
        RuleBasedTransliterator.Data data;
        int i2;
        List<RuleBasedTransliterator.Data> list;
        int i3;
        int size;
        Object cause;
        RuntimeException runtimeException;
        int i4;
        int i5;
        int iRuleEnd;
        boolean z;
        int i6;
        List<String> list2;
        this.dataVector = new ArrayList();
        this.idBlockVector = new ArrayList();
        this.curData = null;
        this.direction = i;
        this.compoundFilter = null;
        this.variablesVector = new ArrayList();
        this.variableNames = new HashMap();
        this.parseData = new ParseData(this, 0);
        ArrayList arrayList = new ArrayList();
        ruleBody.reset();
        StringBuilder sb = new StringBuilder();
        this.compoundFilter = null;
        boolean z2 = true;
        int i7 = 0;
        int i8 = 0;
        boolean z3 = true;
        int i9 = -1;
        loop0: while (true) {
            String strNextLine = ruleBody.nextLine();
            if (strNextLine == null) {
                break;
            }
            int length = strNextLine.length();
            int i10 = i7;
            boolean z4 = z3;
            int i11 = i10;
            int iIndexOf = 0;
            while (iIndexOf < length) {
                int i12 = iIndexOf + 1;
                char cCharAt = strNextLine.charAt(iIndexOf);
                if (!PatternProps.isWhiteSpace(cCharAt)) {
                    if (cCharAt == '#') {
                        iIndexOf = strNextLine.indexOf("\n", i12) + 1;
                        if (iIndexOf == 0) {
                            break;
                        }
                    } else if (cCharAt != ';') {
                        int i13 = i11 + 1;
                        int i14 = iIndexOf + 2;
                        if (iIndexOf + 3 <= length) {
                            try {
                                if (strNextLine.regionMatches(iIndexOf, ID_TOKEN, 0, 2)) {
                                    try {
                                        char cCharAt2 = strNextLine.charAt(i14);
                                        int i15 = i14;
                                        while (PatternProps.isWhiteSpace(cCharAt2) && i15 < length) {
                                            i15++;
                                            cCharAt2 = strNextLine.charAt(i15);
                                        }
                                        int[] iArr = {i15};
                                        if (!z4) {
                                            RuleBasedTransliterator.Data data2 = this.curData;
                                            if (data2 != null) {
                                                int i16 = this.direction;
                                                List<RuleBasedTransliterator.Data> list3 = this.dataVector;
                                                if (i16 == 0) {
                                                    list3.add(data2);
                                                } else {
                                                    list3.add(0, data2);
                                                }
                                                this.curData = null;
                                            }
                                            z4 = true;
                                        }
                                        TransliteratorIDParser.SingleID singleID = TransliteratorIDParser.parseSingleID(strNextLine, iArr, this.direction);
                                        if (iArr[0] == i15 || !Utility.parseChar(strNextLine, iArr, END_OF_RULE)) {
                                            int[] iArr2 = {-1};
                                            UnicodeSet globalFilter = TransliteratorIDParser.parseGlobalFilter(strNextLine, iArr, this.direction, iArr2, null);
                                            if (globalFilter == null || !Utility.parseChar(strNextLine, iArr, END_OF_RULE)) {
                                                syntaxError("Invalid ::ID", strNextLine, i15);
                                            } else if ((this.direction == 0) == (iArr2[0] == 0)) {
                                                if (this.compoundFilter != null) {
                                                    syntaxError("Multiple global filters", strNextLine, i15);
                                                }
                                                this.compoundFilter = globalFilter;
                                                i9 = i13;
                                            }
                                        } else if (this.direction == 0) {
                                            sb.append(singleID.canonID);
                                            sb.append(END_OF_RULE);
                                        } else {
                                            sb.insert(0, singleID.canonID + ";");
                                        }
                                        iRuleEnd = iArr[0];
                                    } catch (IllegalArgumentException e) {
                                        e = e;
                                        iIndexOf = i14;
                                        if (i8 == 30) {
                                            IllegalIcuArgumentException illegalIcuArgumentException = new IllegalIcuArgumentException("\nMore than 30 errors; further messages squelched");
                                            illegalIcuArgumentException.initCause((Throwable) e);
                                            arrayList.add(illegalIcuArgumentException);
                                            z3 = z4;
                                            i7 = i13;
                                            if (!z3) {
                                                if (!z3) {
                                                    i2 = this.direction;
                                                    list = this.dataVector;
                                                    if (i2 == 0) {
                                                        list.add(data);
                                                    } else {
                                                        list.add(0, data);
                                                    }
                                                }
                                            } else if (!z3) {
                                                i2 = this.direction;
                                                list = this.dataVector;
                                                if (i2 == 0) {
                                                    list.add(data);
                                                } else {
                                                    list.add(0, data);
                                                }
                                            }
                                            for (i3 = 0; i3 < this.dataVector.size(); i3++) {
                                                RuleBasedTransliterator.Data data3 = this.dataVector.get(i3);
                                                Object[] objArr = new Object[this.variablesVector.size()];
                                                data3.variables = objArr;
                                                this.variablesVector.toArray(objArr);
                                                HashMap map = new HashMap();
                                                data3.variableNames = map;
                                                map.putAll(this.variableNames);
                                            }
                                            this.variablesVector = null;
                                            if (this.compoundFilter != null) {
                                                throw new IllegalIcuArgumentException("Compound filters misplaced");
                                            }
                                            for (i4 = 0; i4 < this.dataVector.size(); i4++) {
                                                this.dataVector.get(i4).ruleSet.freeze();
                                            }
                                            if (this.idBlockVector.size() == 1) {
                                                this.idBlockVector.remove(0);
                                            }
                                            if (arrayList.size() != 0) {
                                                for (size = arrayList.size() - 1; size > 0; size--) {
                                                    cause = arrayList.get(size - 1);
                                                    while (true) {
                                                        runtimeException = (RuntimeException) cause;
                                                        if (runtimeException.getCause() != null) {
                                                            cause = runtimeException.getCause();
                                                        }
                                                    }
                                                    runtimeException.initCause((Throwable) arrayList.get(size));
                                                }
                                                throw ((RuntimeException) arrayList.get(0));
                                            }
                                        }
                                        e.fillInStackTrace();
                                        arrayList.add(e);
                                        i8++;
                                        z = true;
                                        iRuleEnd = ruleEnd(strNextLine, iIndexOf, length) + 1;
                                    }
                                } else {
                                    if (z4) {
                                        i6 = this.direction;
                                        list2 = this.idBlockVector;
                                        if (i6 == 0) {
                                            list2.add(sb.toString());
                                        } else {
                                            list2.add(0, sb.toString());
                                        }
                                        sb.delete(0, sb.length());
                                        try {
                                            this.curData = new RuleBasedTransliterator.Data();
                                            setVariableRange(61440, 63743);
                                            z4 = false;
                                        } catch (IllegalArgumentException e2) {
                                            e = e2;
                                            z4 = false;
                                            if (i8 == 30) {
                                                IllegalIcuArgumentException illegalIcuArgumentException2 = new IllegalIcuArgumentException("\nMore than 30 errors; further messages squelched");
                                                illegalIcuArgumentException2.initCause((Throwable) e);
                                                arrayList.add(illegalIcuArgumentException2);
                                                z3 = z4;
                                                i7 = i13;
                                                if (!z3) {
                                                    if (!z3) {
                                                        i2 = this.direction;
                                                        list = this.dataVector;
                                                        if (i2 == 0) {
                                                            list.add(data);
                                                        } else {
                                                            list.add(0, data);
                                                        }
                                                    }
                                                } else if (!z3) {
                                                    i2 = this.direction;
                                                    list = this.dataVector;
                                                    if (i2 == 0) {
                                                        list.add(data);
                                                    } else {
                                                        list.add(0, data);
                                                    }
                                                }
                                                while (i3 < this.dataVector.size()) {
                                                    RuleBasedTransliterator.Data data4 = this.dataVector.get(i3);
                                                    Object[] objArr2 = new Object[this.variablesVector.size()];
                                                    data4.variables = objArr2;
                                                    this.variablesVector.toArray(objArr2);
                                                    HashMap map2 = new HashMap();
                                                    data4.variableNames = map2;
                                                    map2.putAll(this.variableNames);
                                                }
                                                this.variablesVector = null;
                                                if (this.compoundFilter != null) {
                                                    throw new IllegalIcuArgumentException("Compound filters misplaced");
                                                }
                                                while (i4 < this.dataVector.size()) {
                                                    this.dataVector.get(i4).ruleSet.freeze();
                                                }
                                                if (this.idBlockVector.size() == 1) {
                                                    this.idBlockVector.remove(0);
                                                }
                                                if (arrayList.size() != 0) {
                                                    while (size > 0) {
                                                        cause = arrayList.get(size - 1);
                                                        while (true) {
                                                            runtimeException = (RuntimeException) cause;
                                                            if (runtimeException.getCause() != null) {
                                                                cause = runtimeException.getCause();
                                                            }
                                                        }
                                                        runtimeException.initCause((Throwable) arrayList.get(size));
                                                    }
                                                    throw ((RuntimeException) arrayList.get(0));
                                                }
                                            }
                                            e.fillInStackTrace();
                                            arrayList.add(e);
                                            i8++;
                                            z = true;
                                            iRuleEnd = ruleEnd(strNextLine, iIndexOf, length) + 1;
                                        }
                                    }
                                    if (resemblesPragma(strNextLine, iIndexOf, length)) {
                                        iRuleEnd = parsePragma(strNextLine, iIndexOf, length);
                                        if (iRuleEnd < 0) {
                                            syntaxError("Unrecognized pragma", strNextLine, iIndexOf);
                                        }
                                    } else {
                                        iRuleEnd = parseRule(strNextLine, iIndexOf, length);
                                    }
                                }
                                z = true;
                            } catch (IllegalArgumentException e3) {
                                e = e3;
                            }
                            iIndexOf = iRuleEnd;
                            i11 = i13;
                            z2 = z;
                        } else {
                            if (z4) {
                                i6 = this.direction;
                                list2 = this.idBlockVector;
                                if (i6 == 0) {
                                    list2.add(sb.toString());
                                } else {
                                    list2.add(0, sb.toString());
                                }
                                sb.delete(0, sb.length());
                                this.curData = new RuleBasedTransliterator.Data();
                                setVariableRange(61440, 63743);
                                z4 = false;
                            }
                            if (resemblesPragma(strNextLine, iIndexOf, length)) {
                                iRuleEnd = parsePragma(strNextLine, iIndexOf, length);
                                if (iRuleEnd < 0) {
                                    syntaxError("Unrecognized pragma", strNextLine, iIndexOf);
                                }
                            } else {
                                iRuleEnd = parseRule(strNextLine, iIndexOf, length);
                            }
                            z = true;
                            iIndexOf = iRuleEnd;
                            i11 = i13;
                            z2 = z;
                        }
                    }
                }
                iIndexOf = i12;
            }
            boolean z5 = z2;
            boolean z6 = z4;
            i7 = i11;
            z3 = z6;
            z2 = z5;
        }
        if (!z3 && sb.length() > 0) {
            int i17 = this.direction;
            List<String> list4 = this.idBlockVector;
            if (i17 == 0) {
                list4.add(sb.toString());
            } else {
                list4.add(0, sb.toString());
            }
        } else if (!z3 && (data = this.curData) != null) {
            i2 = this.direction;
            list = this.dataVector;
            if (i2 == 0) {
                list.add(data);
            } else {
                list.add(0, data);
            }
        }
        while (i3 < this.dataVector.size()) {
            RuleBasedTransliterator.Data data5 = this.dataVector.get(i3);
            Object[] objArr3 = new Object[this.variablesVector.size()];
            data5.variables = objArr3;
            this.variablesVector.toArray(objArr3);
            HashMap map3 = new HashMap();
            data5.variableNames = map3;
            map3.putAll(this.variableNames);
        }
        this.variablesVector = null;
        try {
            if (this.compoundFilter != null && (((i5 = this.direction) == 0 && i9 != 1) || (i5 == 1 && i9 != i7))) {
                throw new IllegalIcuArgumentException("Compound filters misplaced");
            }
            while (i4 < this.dataVector.size()) {
                this.dataVector.get(i4).ruleSet.freeze();
            }
            if (this.idBlockVector.size() == 1 && this.idBlockVector.get(0).length() == 0) {
                this.idBlockVector.remove(0);
            }
        } catch (IllegalArgumentException e4) {
            e4.fillInStackTrace();
            arrayList.add(e4);
        }
        if (arrayList.size() != 0) {
            while (size > 0) {
                cause = arrayList.get(size - 1);
                while (true) {
                    runtimeException = (RuntimeException) cause;
                    if (runtimeException.getCause() != null) {
                        cause = runtimeException.getCause();
                    }
                }
                runtimeException.initCause((Throwable) arrayList.get(size));
            }
            throw ((RuntimeException) arrayList.get(0));
        }
    }

    public void setSegmentObject(int i, StringMatcher stringMatcher) {
        while (this.segmentObjects.size() < i) {
            this.segmentObjects.add(null);
        }
        int segmentStandin = getSegmentStandin(i) - this.curData.variablesBase;
        int i2 = i - 1;
        if (this.segmentObjects.get(i2) != null || this.variablesVector.get(segmentStandin) != null) {
            throw new RuntimeException();
        }
        this.segmentObjects.set(i2, stringMatcher);
        this.variablesVector.set(segmentStandin, stringMatcher);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class RuleBody {
        public /* synthetic */ RuleBody(int i) {
            this();
        }

        public abstract String handleNextLine();

        public String nextLine() {
            String strHandleNextLine;
            String strHandleNextLine2 = handleNextLine();
            if (strHandleNextLine2 == null || strHandleNextLine2.length() <= 0 || strHandleNextLine2.charAt(strHandleNextLine2.length() - 1) != '\\') {
                return strHandleNextLine2;
            }
            StringBuilder sb = new StringBuilder(strHandleNextLine2);
            do {
                sb.deleteCharAt(sb.length() - 1);
                strHandleNextLine = handleNextLine();
                if (strHandleNextLine != null) {
                    sb.append(strHandleNextLine);
                    if (strHandleNextLine.length() <= 0) {
                        break;
                    }
                } else {
                    break;
                }
            } while (strHandleNextLine.charAt(strHandleNextLine.length() - 1) == '\\');
            return sb.toString();
        }

        public abstract void reset();

        private RuleBody() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class ParseData implements SymbolTable {
        private ParseData() {
        }

        public boolean isMatcher(int i) {
            int i2 = i - TransliteratorParser.this.curData.variablesBase;
            if (i2 < 0 || i2 >= TransliteratorParser.this.variablesVector.size()) {
                return true;
            }
            return TransliteratorParser.this.variablesVector.get(i2) instanceof UnicodeMatcher;
        }

        public boolean isReplacer(int i) {
            int i2 = i - TransliteratorParser.this.curData.variablesBase;
            if (i2 < 0 || i2 >= TransliteratorParser.this.variablesVector.size()) {
                return true;
            }
            return TransliteratorParser.this.variablesVector.get(i2) instanceof UnicodeReplacer;
        }

        @Override // com.ibm.icu.text.SymbolTable
        public char[] lookup(String str) {
            return (char[]) TransliteratorParser.this.variableNames.get(str);
        }

        @Override // com.ibm.icu.text.SymbolTable
        public UnicodeMatcher lookupMatcher(int i) {
            int i2 = i - TransliteratorParser.this.curData.variablesBase;
            if (i2 < 0 || i2 >= TransliteratorParser.this.variablesVector.size()) {
                return null;
            }
            return (UnicodeMatcher) TransliteratorParser.this.variablesVector.get(i2);
        }

        @Override // com.ibm.icu.text.SymbolTable
        public UnicodeSet lookupSet(String str) {
            int i;
            char[] cArr = (char[]) TransliteratorParser.this.variableNames.get(str);
            if (cArr != null && cArr.length == 1 && (i = cArr[0] - TransliteratorParser.this.curData.variablesBase) >= 0 && i < TransliteratorParser.this.variablesVector.size()) {
                Object obj = TransliteratorParser.this.variablesVector.get(i);
                if (obj instanceof UnicodeSet) {
                    return (UnicodeSet) obj;
                }
            }
            return null;
        }

        @Override // com.ibm.icu.text.SymbolTable
        public String parseReference(String str, ParsePosition parsePosition, int i) {
            int index = parsePosition.getIndex();
            int i2 = index;
            while (i2 < i) {
                char cCharAt = str.charAt(i2);
                if ((i2 == index && !UCharacter.isUnicodeIdentifierStart(cCharAt)) || !UCharacter.isUnicodeIdentifierPart(cCharAt)) {
                    break;
                }
                i2++;
            }
            if (i2 == index) {
                return null;
            }
            parsePosition.setIndex(i2);
            return str.substring(index, i2);
        }

        public /* synthetic */ ParseData(TransliteratorParser transliteratorParser, int i) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RuleHalf {
        public boolean anchorEnd;
        public boolean anchorStart;
        public int ante;
        public int cursor;
        public int cursorOffset;
        private int cursorOffsetPos;
        private int nextSegmentNumber;
        public int post;
        public String text;

        private RuleHalf() {
            this.cursor = -1;
            this.ante = -1;
            this.post = -1;
            this.cursorOffset = 0;
            this.cursorOffsetPos = 0;
            this.anchorStart = false;
            this.anchorEnd = false;
            this.nextSegmentNumber = 1;
        }

        /* JADX WARN: Code duplicated, block: B:131:0x0274  */
        /* JADX WARN: Code duplicated, block: B:132:0x0279  */
        /* JADX WARN: Code duplicated, block: B:134:0x027f  */
        /* JADX WARN: Code duplicated, block: B:135:0x0284  */
        /* JADX WARN: Code duplicated, block: B:139:0x02a8  */
        /* JADX WARN: Code duplicated, block: B:141:0x02ac  */
        /* JADX WARN: Code duplicated, block: B:142:0x02b2  */
        /* JADX WARN: Code duplicated, block: B:143:0x02b7  */
        /* JADX WARN: Code duplicated, block: B:97:0x018f  */
        private int parseSection(String str, int i, int i2, TransliteratorParser transliteratorParser, StringBuilder sb, UnicodeSet unicodeSet, boolean z) {
            int i3;
            int i4;
            ParsePosition parsePosition;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11 = 1;
            int[] iArr = new int[1];
            int length = sb.length();
            ParsePosition parsePosition2 = null;
            int index = i;
            int length2 = -1;
            int length3 = -1;
            int length4 = -1;
            int length5 = -1;
            while (index < i2) {
                int i12 = index + 1;
                int i13 = i11;
                char cCharAt = str.charAt(index);
                if (!PatternProps.isWhiteSpace(cCharAt)) {
                    if (TransliteratorParser.HALF_ENDERS.indexOf(cCharAt) < 0) {
                        if (this.anchorEnd) {
                            TransliteratorParser.syntaxError("Malformed variable reference", str, i);
                        }
                        int i14 = length2;
                        if (UnicodeSet.resemblesPattern(str, index)) {
                            if (parsePosition2 == null) {
                                parsePosition2 = new ParsePosition(0);
                            }
                            parsePosition2.setIndex(index);
                            sb.append(transliteratorParser.parseSet(str, parsePosition2));
                            index = parsePosition2.getIndex();
                        } else if (cCharAt == '\\') {
                            if (i12 == i2) {
                                TransliteratorParser.syntaxError("Trailing backslash", str, i);
                            }
                            int iUnescapeAndLengthAt = Utility.unescapeAndLengthAt(str, i12);
                            if (iUnescapeAndLengthAt < 0) {
                                TransliteratorParser.syntaxError("Malformed escape", str, i);
                            }
                            int iCpFromCodePointAndLength = Utility.cpFromCodePointAndLength(iUnescapeAndLengthAt);
                            index = Utility.lengthFromCodePointAndLength(iUnescapeAndLengthAt) + i12;
                            transliteratorParser.checkVariableRange(iCpFromCodePointAndLength, str, i);
                            sb.appendCodePoint(iCpFromCodePointAndLength);
                        } else if (cCharAt == '\'') {
                            int iIndexOf = str.indexOf(39, i12);
                            if (iIndexOf == i12) {
                                sb.append(cCharAt);
                                index += 2;
                            } else {
                                length3 = sb.length();
                                while (true) {
                                    if (iIndexOf < 0) {
                                        TransliteratorParser.syntaxError("Unterminated quote", str, i);
                                    }
                                    sb.append(str.substring(i12, iIndexOf));
                                    i12 = iIndexOf + 1;
                                    if (i12 < i2 && str.charAt(i12) == '\'') {
                                        iIndexOf = str.indexOf(39, iIndexOf + 2);
                                    }
                                }
                                length4 = sb.length();
                                for (int i15 = length3; i15 < length4; i15++) {
                                    transliteratorParser.checkVariableRange(sb.charAt(i15), str, i);
                                }
                                index = i12;
                            }
                        } else {
                            transliteratorParser.checkVariableRange(cCharAt, str, i);
                            if (unicodeSet.contains(cCharAt)) {
                                TransliteratorParser.syntaxError("Illegal character '" + cCharAt + "'", str, i);
                            }
                            if (cCharAt != '$') {
                                if (cCharAt != '&') {
                                    if (cCharAt == '.') {
                                        i3 = i12;
                                        length = length;
                                        i4 = i14;
                                        parsePosition = parsePosition2;
                                        sb.append(transliteratorParser.getDotStandIn());
                                    } else if (cCharAt == '^') {
                                        i3 = i12;
                                        length = length;
                                        i4 = i14;
                                        parsePosition = parsePosition2;
                                        if (sb.length() != 0 || this.anchorStart) {
                                            TransliteratorParser.syntaxError("Misplaced anchor start", str, i);
                                        } else {
                                            i6 = 1;
                                            this.anchorStart = true;
                                        }
                                        i5 = i6;
                                        index = i3;
                                        length2 = i4;
                                        parsePosition2 = parsePosition;
                                    } else if (cCharAt != 8710) {
                                        if (cCharAt == '?') {
                                            i3 = i12;
                                            i4 = i14;
                                            parsePosition = parsePosition2;
                                            if (z || sb.length() != length) {
                                                if (sb.length() == length4) {
                                                    i8 = length3;
                                                    i7 = length4;
                                                } else if (sb.length() == i4) {
                                                    i7 = i4;
                                                    i8 = length5;
                                                } else {
                                                    int length6 = sb.length();
                                                    i7 = length6;
                                                    i8 = length6 - 1;
                                                }
                                                try {
                                                    StringMatcher stringMatcher = new StringMatcher(sb.toString(), i8, i7, 0, transliteratorParser.curData);
                                                    int i16 = i8;
                                                    if (cCharAt != '+') {
                                                        i9 = Integer.MAX_VALUE;
                                                        i10 = 1;
                                                    } else if (cCharAt != '?') {
                                                        i9 = Integer.MAX_VALUE;
                                                        i10 = 0;
                                                    } else {
                                                        i10 = 0;
                                                        i9 = 1;
                                                    }
                                                    Quantifier quantifier = new Quantifier(stringMatcher, i10, i9);
                                                    sb.setLength(i16);
                                                    sb.append(transliteratorParser.generateStandInFor(quantifier));
                                                } catch (RuntimeException e) {
                                                    throw new IllegalIcuArgumentException(cq.l("Failure in rule: ", i3 < 50 ? str.substring(0, i3) : "...".concat(str.substring(index - 49, i3)), "$$$", i2 - i3 <= 50 ? str.substring(i3, i2) : str.substring(i3, index + 51).concat("..."))).initCause((Throwable) e);
                                                }
                                            } else {
                                                TransliteratorParser.syntaxError("Misplaced quantifier", str, i);
                                                length = length;
                                            }
                                        } else {
                                            if (cCharAt != '@') {
                                                switch (cCharAt) {
                                                    case '(':
                                                        int length7 = sb.length();
                                                        int i17 = this.nextSegmentNumber;
                                                        this.nextSegmentNumber = i17 + 1;
                                                        int section = parseSection(str, i12, i2, transliteratorParser, sb, TransliteratorParser.ILLEGAL_SEG, true);
                                                        transliteratorParser.setSegmentObject(i17, new StringMatcher(sb.substring(length7), i17, transliteratorParser.curData));
                                                        sb.setLength(length7);
                                                        sb.append(transliteratorParser.getSegmentStandin(i17));
                                                        length = length;
                                                        length2 = i14;
                                                        i5 = i13;
                                                        parsePosition2 = parsePosition2;
                                                        index = section;
                                                        break;
                                                    case ')':
                                                        break;
                                                    case '*':
                                                    case '+':
                                                        i3 = i12;
                                                        i4 = i14;
                                                        parsePosition = parsePosition2;
                                                        if (z) {
                                                        }
                                                        if (sb.length() == length4) {
                                                            i8 = length3;
                                                            i7 = length4;
                                                        } else if (sb.length() == i4) {
                                                            i7 = i4;
                                                            i8 = length5;
                                                        } else {
                                                            int length8 = sb.length();
                                                            i7 = length8;
                                                            i8 = length8 - 1;
                                                        }
                                                        StringMatcher stringMatcher2 = new StringMatcher(sb.toString(), i8, i7, 0, transliteratorParser.curData);
                                                        int i18 = i8;
                                                        if (cCharAt != '+') {
                                                            i9 = Integer.MAX_VALUE;
                                                            i10 = 1;
                                                        } else if (cCharAt != '?') {
                                                            i9 = Integer.MAX_VALUE;
                                                            i10 = 0;
                                                        } else {
                                                            i10 = 0;
                                                            i9 = 1;
                                                        }
                                                        Quantifier quantifier2 = new Quantifier(stringMatcher2, i10, i9);
                                                        sb.setLength(i18);
                                                        sb.append(transliteratorParser.generateStandInFor(quantifier2));
                                                        break;
                                                    default:
                                                        switch (cCharAt) {
                                                            case '{':
                                                                if (this.ante >= 0) {
                                                                    TransliteratorParser.syntaxError("Multiple ante contexts", str, i);
                                                                }
                                                                this.ante = sb.length();
                                                                break;
                                                            case '|':
                                                                if (this.cursor >= 0) {
                                                                    TransliteratorParser.syntaxError("Multiple cursors", str, i);
                                                                }
                                                                this.cursor = sb.length();
                                                                break;
                                                            case '}':
                                                                if (this.post >= 0) {
                                                                    TransliteratorParser.syntaxError("Multiple post contexts", str, i);
                                                                }
                                                                this.post = sb.length();
                                                                break;
                                                            default:
                                                                if (cCharAt >= '!' && cCharAt <= '~' && ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'A' || cCharAt > 'Z') && (cCharAt < 'a' || cCharAt > 'z')))) {
                                                                    TransliteratorParser.syntaxError("Unquoted " + cCharAt, str, i);
                                                                }
                                                                sb.append(cCharAt);
                                                                break;
                                                        }
                                                        i3 = i12;
                                                        length = length;
                                                        i6 = i13;
                                                        i4 = i14;
                                                        parsePosition = parsePosition2;
                                                        break;
                                                }
                                            } else {
                                                i3 = i12;
                                                i4 = i14;
                                                parsePosition = parsePosition2;
                                                int i19 = this.cursorOffset;
                                                if (i19 < 0) {
                                                    if (sb.length() > 0) {
                                                        TransliteratorParser.syntaxError("Misplaced " + cCharAt, str, i);
                                                    }
                                                    this.cursorOffset--;
                                                } else if (i19 > 0) {
                                                    if (sb.length() != this.cursorOffsetPos || this.cursor >= 0) {
                                                        TransliteratorParser.syntaxError("Misplaced " + cCharAt, str, i);
                                                    }
                                                    this.cursorOffset++;
                                                } else if (this.cursor == 0 && sb.length() == 0) {
                                                    this.cursorOffset = -1;
                                                } else if (this.cursor < 0) {
                                                    this.cursorOffsetPos = sb.length();
                                                    i6 = i13;
                                                    this.cursorOffset = i6;
                                                    length = length;
                                                } else {
                                                    TransliteratorParser.syntaxError("Misplaced " + cCharAt, str, i);
                                                    length = length;
                                                }
                                                length = length;
                                                i6 = i13;
                                            }
                                            i5 = i6;
                                            index = i3;
                                            length2 = i4;
                                            parsePosition2 = parsePosition;
                                        }
                                    }
                                    i6 = 1;
                                    i5 = i6;
                                    index = i3;
                                    length2 = i4;
                                    parsePosition2 = parsePosition;
                                }
                                length = length;
                                ParsePosition parsePosition3 = parsePosition2;
                                iArr[0] = i12;
                                TransliteratorIDParser.SingleID filterID = TransliteratorIDParser.parseFilterID(str, iArr);
                                if (filterID == null || !Utility.parseChar(str, iArr, TransliteratorParser.SEGMENT_OPEN)) {
                                    TransliteratorParser.syntaxError("Invalid function", str, i);
                                }
                                Transliterator singleID = filterID.getInstance();
                                if (singleID == null) {
                                    TransliteratorParser.syntaxError("Invalid function ID", str, i);
                                }
                                int length9 = sb.length();
                                int section2 = parseSection(str, iArr[0], i2, transliteratorParser, sb, TransliteratorParser.ILLEGAL_FUNC, true);
                                FunctionReplacer functionReplacer = new FunctionReplacer(singleID, new StringReplacer(sb.substring(length9), transliteratorParser.curData));
                                sb.setLength(length9);
                                sb.append(transliteratorParser.generateStandInFor(functionReplacer));
                                length2 = i14;
                                parsePosition2 = parsePosition3;
                                index = section2;
                                i5 = 1;
                            } else {
                                i3 = i12;
                                length = length;
                                i4 = i14;
                                parsePosition = parsePosition2;
                                if (i3 == i2) {
                                    i6 = 1;
                                    this.anchorEnd = true;
                                    i5 = i6;
                                    index = i3;
                                    length2 = i4;
                                    parsePosition2 = parsePosition;
                                } else {
                                    int iDigit = UCharacter.digit(str.charAt(i3), 10);
                                    if (iDigit < 1 || iDigit > 9) {
                                        parsePosition2 = parsePosition == null ? new ParsePosition(0) : parsePosition;
                                        parsePosition2.setIndex(i3);
                                        String reference = transliteratorParser.parseData.parseReference(str, parsePosition2, i2);
                                        if (reference == null) {
                                            i5 = 1;
                                            this.anchorEnd = true;
                                            index = i3;
                                            length2 = i4;
                                        } else {
                                            i5 = 1;
                                            int index2 = parsePosition2.getIndex();
                                            length5 = sb.length();
                                            transliteratorParser.appendVariableDef(reference, sb);
                                            length2 = sb.length();
                                            index = index2;
                                        }
                                    } else {
                                        iArr[0] = i3;
                                        int number = Utility.parseNumber(str, iArr, 10);
                                        if (number < 0) {
                                            TransliteratorParser.syntaxError("Undefined segment reference", str, i);
                                        }
                                        index = iArr[0];
                                        sb.append(transliteratorParser.getSegmentStandin(number));
                                        length2 = i4;
                                        parsePosition2 = parsePosition;
                                        i5 = 1;
                                    }
                                }
                            }
                            i11 = i5;
                            length = length;
                        }
                        i11 = i13;
                        length2 = i14;
                    } else if (z) {
                        TransliteratorParser.syntaxError("Unclosed segment", str, i);
                        return i12;
                    }
                    return i12;
                }
                index = i12;
                i11 = i13;
            }
            return index;
        }

        public boolean isValidInput(TransliteratorParser transliteratorParser) {
            int charCount = 0;
            while (charCount < this.text.length()) {
                int iCharAt = UTF16.charAt(this.text, charCount);
                charCount += UTF16.getCharCount(iCharAt);
                if (!transliteratorParser.parseData.isMatcher(iCharAt)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isValidOutput(TransliteratorParser transliteratorParser) {
            int charCount = 0;
            while (charCount < this.text.length()) {
                int iCharAt = UTF16.charAt(this.text, charCount);
                charCount += UTF16.getCharCount(iCharAt);
                if (!transliteratorParser.parseData.isReplacer(iCharAt)) {
                    return false;
                }
            }
            return true;
        }

        public int parse(String str, int i, int i2, TransliteratorParser transliteratorParser) {
            StringBuilder sb = new StringBuilder();
            int section = parseSection(str, i, i2, transliteratorParser, sb, TransliteratorParser.ILLEGAL_TOP, false);
            this.text = sb.toString();
            if (this.cursorOffset > 0 && this.cursor != this.cursorOffsetPos) {
                TransliteratorParser.syntaxError("Misplaced |", str, i);
            }
            return section;
        }

        public void removeContext() {
            String str = this.text;
            int i = this.ante;
            if (i < 0) {
                i = 0;
            }
            int length = this.post;
            if (length < 0) {
                length = str.length();
            }
            this.text = str.substring(i, length);
            this.post = -1;
            this.ante = -1;
            this.anchorEnd = false;
            this.anchorStart = false;
        }

        public /* synthetic */ RuleHalf(int i) {
            this();
        }
    }
}
