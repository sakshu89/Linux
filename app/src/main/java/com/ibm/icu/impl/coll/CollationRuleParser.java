package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.IllegalIcuArgumentException;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.PatternTokenizer;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UProperty;
import com.ibm.icu.text.Normalizer2;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.ULocale;
import defpackage.cq;
import java.text.ParseException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CollationRuleParser {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String BEFORE = "[before";
    private static final int OFFSET_SHIFT = 8;
    static final char POS_BASE = 10240;
    static final char POS_LEAD = 65534;
    private static final int STARRED_FLAG = 16;
    private static final int STRENGTH_MASK = 15;
    private static final int UCOL_DEFAULT = -1;
    private static final int UCOL_OFF = 0;
    private static final int UCOL_ON = 1;
    private static final int U_PARSE_CONTEXT_LEN = 16;
    private final CollationData baseData;
    private Importer importer;
    private int ruleIndex;
    private String rules;
    private CollationSettings settings;
    private Sink sink;
    static final Position[] POSITION_VALUES = Position.values();
    private static final String[] positions = {"first tertiary ignorable", "last tertiary ignorable", "first secondary ignorable", "last secondary ignorable", "first primary ignorable", "last primary ignorable", "first variable", "last variable", "first regular", "last regular", "first implicit", "last implicit", "first trailing", "last trailing"};
    private static final String[] gSpecialReorderCodes = {"space", "punct", "symbol", "currency", "digit"};
    private final StringBuilder rawBuilder = new StringBuilder();
    private Normalizer2 nfd = Normalizer2.getNFDInstance();
    private Normalizer2 nfc = Normalizer2.getNFCInstance();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface Importer {
        String getRules(String str, String str2);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Position {
        FIRST_TERTIARY_IGNORABLE,
        LAST_TERTIARY_IGNORABLE,
        FIRST_SECONDARY_IGNORABLE,
        LAST_SECONDARY_IGNORABLE,
        FIRST_PRIMARY_IGNORABLE,
        LAST_PRIMARY_IGNORABLE,
        FIRST_VARIABLE,
        LAST_VARIABLE,
        FIRST_REGULAR,
        LAST_REGULAR,
        FIRST_IMPLICIT,
        LAST_IMPLICIT,
        FIRST_TRAILING,
        LAST_TRAILING
    }

    public CollationRuleParser(CollationData collationData) {
        this.baseData = collationData;
    }

    private String appendErrorContext(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(" at index ");
        sb.append(this.ruleIndex);
        sb.append(" near \"");
        int i = this.ruleIndex;
        int i2 = i - 15;
        int i3 = 14;
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > 0 && Character.isLowSurrogate(this.rules.charAt(i2))) {
            i2 = i - 14;
        }
        sb.append((CharSequence) this.rules, i2, this.ruleIndex);
        sb.append('!');
        int length = this.rules.length();
        int i4 = this.ruleIndex;
        int i5 = length - i4;
        if (i5 < 16) {
            i3 = i5;
        } else if (!Character.isHighSurrogate(this.rules.charAt(i4 + 14))) {
            i3 = 15;
        }
        String str2 = this.rules;
        int i6 = this.ruleIndex;
        sb.append((CharSequence) str2, i6, i3 + i6);
        sb.append('\"');
        return sb.toString();
    }

    private static int getOnOffValue(String str) {
        if (str.equals("on")) {
            return 1;
        }
        return str.equals("off") ? 0 : -1;
    }

    public static int getReorderCode(String str) {
        int i = 0;
        while (true) {
            String[] strArr = gSpecialReorderCodes;
            if (i >= strArr.length) {
                try {
                    int propertyValueEnum = UCharacter.getPropertyValueEnum(UProperty.SCRIPT, str);
                    if (propertyValueEnum >= 0) {
                        return propertyValueEnum;
                    }
                } catch (IllegalIcuArgumentException unused) {
                }
                return str.equalsIgnoreCase("others") ? 103 : -1;
            }
            if (str.equalsIgnoreCase(strArr[i])) {
                return i + 4096;
            }
            i++;
        }
    }

    private static final boolean isSurrogate(int i) {
        return (i & (-2048)) == 55296;
    }

    private static boolean isSyntaxChar(int i) {
        if (33 > i || i > 126) {
            return false;
        }
        if (i <= 47) {
            return true;
        }
        if (58 > i || i > 64) {
            return (91 <= i && i <= 96) || 123 <= i;
        }
        return true;
    }

    private ParseException makeParseException(String str) {
        return new ParseException(appendErrorContext(str), this.ruleIndex);
    }

    private void parse(String str) throws ParseException {
        this.rules = str;
        this.ruleIndex = 0;
        while (this.ruleIndex < this.rules.length()) {
            char cCharAt = this.rules.charAt(this.ruleIndex);
            if (PatternProps.isWhiteSpace(cCharAt)) {
                this.ruleIndex++;
            } else if (cCharAt == '!') {
                this.ruleIndex++;
            } else if (cCharAt == '#') {
                this.ruleIndex = skipComment(this.ruleIndex + 1);
            } else if (cCharAt == '&') {
                parseRuleChain();
            } else if (cCharAt == '@') {
                this.settings.setFlag(2048, true);
                this.ruleIndex++;
            } else if (cCharAt != '[') {
                setParseError("expected a reset or setting or comment");
            } else {
                parseSetting();
            }
        }
    }

    private int parseRelationOperator() {
        int iSkipWhiteSpace = skipWhiteSpace(this.ruleIndex);
        this.ruleIndex = iSkipWhiteSpace;
        if (iSkipWhiteSpace >= this.rules.length()) {
            return -1;
        }
        int i = this.ruleIndex;
        int i2 = i + 1;
        char cCharAt = this.rules.charAt(i);
        int i3 = 2;
        if (cCharAt != ',') {
            switch (cCharAt) {
                case ';':
                    i3 = 1;
                    break;
                case '<':
                    if (i2 >= this.rules.length() || this.rules.charAt(i2) != '<') {
                        i3 = 0;
                    } else {
                        i2 = i + 2;
                        if (i2 >= this.rules.length() || this.rules.charAt(i2) != '<') {
                            i3 = 1;
                        } else {
                            i2 = i + 3;
                            if (i2 < this.rules.length() && this.rules.charAt(i2) == '<') {
                                i2 = i + 4;
                                i3 = 3;
                            }
                        }
                    }
                    if (i2 < this.rules.length() && this.rules.charAt(i2) == '*') {
                        i2++;
                        i3 |= 16;
                    }
                    break;
                case '=':
                    if (i2 < this.rules.length() && this.rules.charAt(i2) == '*') {
                        i2 = i + 2;
                        i3 = 31;
                    } else {
                        i3 = 15;
                    }
                    break;
                default:
                    return -1;
            }
        }
        return ((i2 - this.ruleIndex) << 8) | i3;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void parseRelationStrings(int i, int i2) throws ParseException {
        String str;
        int tailoringString = parseTailoringString(i2, this.rawBuilder);
        char cCharAt = tailoringString < this.rules.length() ? this.rules.charAt(tailoringString) : (char) 0;
        String str2 = "";
        if (cCharAt == '|') {
            String string = this.rawBuilder.toString();
            tailoringString = parseTailoringString(tailoringString + 1, this.rawBuilder);
            str = string;
            cCharAt = tailoringString < this.rules.length() ? this.rules.charAt(tailoringString) : (char) 0;
        } else {
            str = "";
        }
        CharSequence charSequence = str2;
        if (cCharAt == '/') {
            StringBuilder sb = new StringBuilder();
            tailoringString = parseTailoringString(tailoringString + 1, sb);
            charSequence = sb;
        }
        if (str.length() != 0) {
            int iCodePointAt = str.codePointAt(0);
            int iCodePointAt2 = this.rawBuilder.codePointAt(0);
            if (!this.nfc.hasBoundaryBefore(iCodePointAt) || !this.nfc.hasBoundaryBefore(iCodePointAt2)) {
                setParseError("in 'prefix|str', prefix and str must each start with an NFC boundary");
                return;
            }
        }
        try {
            this.sink.addRelation(i, str, this.rawBuilder, charSequence);
            this.ruleIndex = tailoringString;
        } catch (Exception e) {
            setParseError("adding relation failed", e);
        }
    }

    private void parseReordering(CharSequence charSequence) throws ParseException {
        int i;
        if (7 == charSequence.length()) {
            this.settings.resetReordering();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 7; i2 < charSequence.length(); i2 = i) {
            int i3 = i2 + 1;
            i = i3;
            while (i < charSequence.length() && charSequence.charAt(i) != ' ') {
                i++;
            }
            int reorderCode = getReorderCode(charSequence.subSequence(i3, i).toString());
            if (reorderCode < 0) {
                setParseError("unknown script or reorder code");
                return;
            }
            arrayList.add(Integer.valueOf(reorderCode));
        }
        if (arrayList.isEmpty()) {
            this.settings.resetReordering();
            return;
        }
        int[] iArr = new int[arrayList.size()];
        int size = arrayList.size();
        int i4 = 0;
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            iArr[i4] = ((Integer) obj).intValue();
            i4++;
        }
        this.settings.setReordering(this.baseData, iArr);
    }

    private int parseResetAndPosition() throws ParseException {
        int i;
        int i2;
        int iSkipWhiteSpace;
        int iSkipWhiteSpace2;
        char cCharAt;
        int iSkipWhiteSpace3 = skipWhiteSpace(this.ruleIndex + 1);
        if (!this.rules.regionMatches(iSkipWhiteSpace3, BEFORE, 0, 7) || (i2 = iSkipWhiteSpace3 + 7) >= this.rules.length() || !PatternProps.isWhiteSpace(this.rules.charAt(i2)) || (iSkipWhiteSpace2 = (iSkipWhiteSpace = skipWhiteSpace(iSkipWhiteSpace3 + 8)) + 1) >= this.rules.length() || '1' > (cCharAt = this.rules.charAt(iSkipWhiteSpace)) || cCharAt > '3' || this.rules.charAt(iSkipWhiteSpace2) != ']') {
            i = 15;
        } else {
            i = cCharAt - '1';
            iSkipWhiteSpace3 = skipWhiteSpace(iSkipWhiteSpace + 2);
        }
        if (iSkipWhiteSpace3 >= this.rules.length()) {
            setParseError("reset without position");
            return -1;
        }
        char cCharAt2 = this.rules.charAt(iSkipWhiteSpace3);
        StringBuilder sb = this.rawBuilder;
        int specialPosition = cCharAt2 == '[' ? parseSpecialPosition(iSkipWhiteSpace3, sb) : parseTailoringString(iSkipWhiteSpace3, sb);
        try {
            this.sink.addReset(i, this.rawBuilder);
            this.ruleIndex = specialPosition;
            return i;
        } catch (Exception e) {
            setParseError("adding reset failed", e);
            return -1;
        }
    }

    private void parseRuleChain() throws ParseException {
        int resetAndPosition = parseResetAndPosition();
        boolean z = true;
        while (true) {
            int relationOperator = parseRelationOperator();
            if (relationOperator >= 0) {
                int i = relationOperator & 15;
                if (resetAndPosition < 15) {
                    if (z) {
                        if (i != resetAndPosition) {
                            setParseError("reset-before strength differs from its first relation");
                            return;
                        }
                    } else if (i < resetAndPosition) {
                        setParseError("reset-before strength followed by a stronger relation");
                        return;
                    }
                }
                int i2 = this.ruleIndex + (relationOperator >> 8);
                if ((relationOperator & 16) == 0) {
                    parseRelationStrings(i, i2);
                } else {
                    parseStarredCharacters(i, i2);
                }
                z = false;
            } else if (this.ruleIndex >= this.rules.length() || this.rules.charAt(this.ruleIndex) != '#') {
                break;
            } else {
                this.ruleIndex = skipComment(this.ruleIndex + 1);
            }
        }
        if (z) {
            setParseError("reset not followed by a relation");
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void parseSetting() throws ParseException {
        String strSubstring;
        char c;
        int i;
        int i2 = 1;
        int i3 = this.ruleIndex + 1;
        int words = readWords(i3, this.rawBuilder);
        if (words <= i3 || this.rawBuilder.length() == 0) {
            setParseError("expected a setting/option at '['");
        }
        String string = this.rawBuilder.toString();
        if (this.rules.charAt(words) == ']') {
            int i4 = words + 1;
            if (string.startsWith("reorder") && (string.length() == 7 || string.charAt(7) == ' ')) {
                parseReordering(string);
                this.ruleIndex = i4;
                return;
            }
            if (string.equals("backwards 2")) {
                this.settings.setFlag(2048, true);
                this.ruleIndex = i4;
                return;
            }
            int iLastIndexOf = string.lastIndexOf(32);
            int i5 = 0;
            if (iLastIndexOf >= 0) {
                strSubstring = string.substring(iLastIndexOf + 1);
                string = string.substring(0, iLastIndexOf);
            } else {
                strSubstring = "";
            }
            if (string.equals("strength") && strSubstring.length() == 1) {
                char cCharAt = strSubstring.charAt(0);
                if ('1' > cCharAt || cCharAt > '4') {
                    i = cCharAt == 'I' ? 15 : -1;
                } else {
                    i = cCharAt - '1';
                }
                if (i != -1) {
                    this.settings.setStrength(i);
                    this.ruleIndex = i4;
                    return;
                }
            } else if (string.equals("alternate")) {
                if (strSubstring.equals("non-ignorable")) {
                    c = 0;
                } else {
                    c = strSubstring.equals("shifted") ? (char) 1 : (char) 65535;
                }
                if (c != 65535) {
                    this.settings.setAlternateHandlingShifted(c > 0);
                    this.ruleIndex = i4;
                    return;
                }
            } else if (string.equals("maxVariable")) {
                if (strSubstring.equals("space")) {
                    i2 = 0;
                } else if (!strSubstring.equals("punct")) {
                    if (strSubstring.equals("symbol")) {
                        i2 = 2;
                    } else {
                        i2 = strSubstring.equals("currency") ? 3 : -1;
                    }
                }
                if (i2 != -1) {
                    this.settings.setMaxVariable(i2, 0);
                    this.settings.variableTop = this.baseData.getLastPrimaryForGroup(i2 + 4096);
                    this.ruleIndex = i4;
                    return;
                }
            } else if (string.equals("caseFirst")) {
                if (!strSubstring.equals("off")) {
                    if (strSubstring.equals("lower")) {
                        i5 = 512;
                    } else {
                        i5 = strSubstring.equals("upper") ? 768 : -1;
                    }
                }
                if (i5 != -1) {
                    this.settings.setCaseFirst(i5);
                    this.ruleIndex = i4;
                    return;
                }
            } else if (string.equals("caseLevel")) {
                int onOffValue = getOnOffValue(strSubstring);
                if (onOffValue != -1) {
                    this.settings.setFlag(1024, onOffValue > 0);
                    this.ruleIndex = i4;
                    return;
                }
            } else if (string.equals("normalization")) {
                int onOffValue2 = getOnOffValue(strSubstring);
                if (onOffValue2 != -1) {
                    this.settings.setFlag(1, onOffValue2 > 0);
                    this.ruleIndex = i4;
                    return;
                }
            } else if (string.equals("numericOrdering")) {
                int onOffValue3 = getOnOffValue(strSubstring);
                if (onOffValue3 != -1) {
                    this.settings.setFlag(2, onOffValue3 > 0);
                    this.ruleIndex = i4;
                    return;
                }
            } else if (string.equals("hiraganaQ")) {
                int onOffValue4 = getOnOffValue(strSubstring);
                if (onOffValue4 != -1) {
                    if (onOffValue4 == 1) {
                        setParseError("[hiraganaQ on] is not supported");
                    }
                    this.ruleIndex = i4;
                    return;
                }
            } else if (string.equals("import")) {
                try {
                    ULocale uLocaleBuild = new ULocale.Builder().setLanguageTag(strSubstring).build();
                    String baseName = uLocaleBuild.getBaseName();
                    String keywordValue = uLocaleBuild.getKeywordValue("collation");
                    Importer importer = this.importer;
                    if (importer == null) {
                        setParseError("[import langTag] is not supported");
                        return;
                    }
                    if (keywordValue == null) {
                        keywordValue = "standard";
                    }
                    try {
                        String rules = importer.getRules(baseName, keywordValue);
                        String str = this.rules;
                        int i6 = this.ruleIndex;
                        try {
                            parse(rules);
                        } catch (Exception e) {
                            this.ruleIndex = i6;
                            setParseError("parsing imported rules failed", e);
                        }
                        this.rules = str;
                        this.ruleIndex = i4;
                        return;
                    } catch (Exception e2) {
                        setParseError("[import langTag] failed", e2);
                        return;
                    }
                } catch (Exception e3) {
                    setParseError("expected language tag in [import langTag]", e3);
                    return;
                }
            }
        } else if (this.rules.charAt(words) == '[') {
            UnicodeSet unicodeSet = new UnicodeSet();
            int unicodeSet2 = parseUnicodeSet(words, unicodeSet);
            if (string.equals("optimize")) {
                try {
                    this.sink.optimize(unicodeSet);
                } catch (Exception e4) {
                    setParseError("[optimize set] failed", e4);
                }
                this.ruleIndex = unicodeSet2;
                return;
            }
            if (string.equals("suppressContractions")) {
                try {
                    this.sink.suppressContractions(unicodeSet);
                } catch (Exception e5) {
                    setParseError("[suppressContractions set] failed", e5);
                }
                this.ruleIndex = unicodeSet2;
                return;
            }
        }
        setParseError("not a valid setting/option");
    }

    private int parseSpecialPosition(int i, StringBuilder sb) throws ParseException {
        int words = readWords(i + 1, this.rawBuilder);
        if (words > i && this.rules.charAt(words) == ']' && this.rawBuilder.length() != 0) {
            int i2 = words + 1;
            String string = this.rawBuilder.toString();
            int i3 = 0;
            sb.setLength(0);
            while (true) {
                String[] strArr = positions;
                if (i3 >= strArr.length) {
                    if (!string.equals("top")) {
                        if (!string.equals("variable top")) {
                            break;
                        }
                        sb.append(POS_LEAD);
                        sb.append((char) (Position.LAST_VARIABLE.ordinal() + 10240));
                        return i2;
                    }
                    sb.append(POS_LEAD);
                    sb.append((char) (Position.LAST_REGULAR.ordinal() + 10240));
                    return i2;
                }
                if (string.equals(strArr[i3])) {
                    sb.append(POS_LEAD);
                    sb.append((char) (i3 + 10240));
                    return i2;
                }
                i3++;
            }
        }
        setParseError("not a valid special reset position");
        return i;
    }

    private void parseStarredCharacters(int i, int i2) throws ParseException {
        int string = parseString(skipWhiteSpace(i2), this.rawBuilder);
        if (this.rawBuilder.length() == 0) {
            setParseError("missing starred-relation string");
            return;
        }
        int iCharCount = 0;
        while (true) {
            int iCodePointAt = -1;
            while (iCharCount < this.rawBuilder.length()) {
                iCodePointAt = this.rawBuilder.codePointAt(iCharCount);
                if (!this.nfd.isInert(iCodePointAt)) {
                    setParseError("starred-relation string is not all NFD-inert");
                    return;
                }
                try {
                    this.sink.addRelation(i, "", UTF16.valueOf(iCodePointAt), "");
                    iCharCount += Character.charCount(iCodePointAt);
                } catch (Exception e) {
                    setParseError("adding relation failed", e);
                    return;
                }
            }
            if (string >= this.rules.length() || this.rules.charAt(string) != '-') {
                this.ruleIndex = skipWhiteSpace(string);
                return;
            }
            if (iCodePointAt < 0) {
                setParseError("range without start in starred-relation string");
                return;
            }
            string = parseString(string + 1, this.rawBuilder);
            if (this.rawBuilder.length() == 0) {
                setParseError("range without end in starred-relation string");
                return;
            }
            int iCodePointAt2 = this.rawBuilder.codePointAt(0);
            if (iCodePointAt2 < iCodePointAt) {
                setParseError("range start greater than end in starred-relation string");
                return;
            }
            while (true) {
                iCodePointAt++;
                if (iCodePointAt <= iCodePointAt2) {
                    if (!this.nfd.isInert(iCodePointAt)) {
                        setParseError("starred-relation string range is not all NFD-inert");
                        return;
                    }
                    if (isSurrogate(iCodePointAt)) {
                        setParseError("starred-relation string range contains a surrogate");
                        return;
                    }
                    if (65533 <= iCodePointAt && iCodePointAt <= 65535) {
                        setParseError("starred-relation string range contains U+FFFD, U+FFFE or U+FFFF");
                        return;
                    }
                    try {
                        this.sink.addRelation(i, "", UTF16.valueOf(iCodePointAt), "");
                    } catch (Exception e2) {
                        setParseError("adding relation failed", e2);
                        return;
                    }
                }
            }
            iCharCount = Character.charCount(iCodePointAt2);
        }
    }

    private int parseString(int i, StringBuilder sb) throws ParseException {
        int i2;
        int iCharCount = 0;
        sb.setLength(0);
        while (i < this.rules.length()) {
            int i3 = i + 1;
            char cCharAt = this.rules.charAt(i);
            if (isSyntaxChar(cCharAt)) {
                if (cCharAt != '\'') {
                    if (cCharAt != '\\') {
                        break;
                    }
                    if (i3 == this.rules.length()) {
                        setParseError("backslash escape at the end of the rule string");
                        return i3;
                    }
                    int iCodePointAt = this.rules.codePointAt(i3);
                    sb.appendCodePoint(iCodePointAt);
                    i = Character.charCount(iCodePointAt) + i3;
                } else if (i3 >= this.rules.length() || this.rules.charAt(i3) != '\'') {
                    while (true) {
                        if (i3 == this.rules.length()) {
                            setParseError("quoted literal text missing terminating apostrophe");
                            return i3;
                        }
                        i2 = i3 + 1;
                        char cCharAt2 = this.rules.charAt(i3);
                        if (cCharAt2 != '\'') {
                            i3 = i2;
                        } else {
                            if (i2 >= this.rules.length() || this.rules.charAt(i2) != '\'') {
                                break;
                            }
                            i3 += 2;
                        }
                        sb.append(cCharAt2);
                    }
                    i = i2;
                } else {
                    sb.append(PatternTokenizer.SINGLE_QUOTE);
                    i += 2;
                }
            } else {
                if (PatternProps.isWhiteSpace(cCharAt)) {
                    break;
                }
                sb.append(cCharAt);
                i = i3;
            }
        }
        while (iCharCount < sb.length()) {
            int iCodePointAt2 = sb.codePointAt(iCharCount);
            if (isSurrogate(iCodePointAt2)) {
                setParseError("string contains an unpaired surrogate");
                return i;
            }
            if (65533 <= iCodePointAt2 && iCodePointAt2 <= 65535) {
                setParseError("string contains U+FFFD, U+FFFE or U+FFFF");
                return i;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return i;
    }

    private int parseTailoringString(int i, StringBuilder sb) throws ParseException {
        int string = parseString(skipWhiteSpace(i), sb);
        if (sb.length() == 0) {
            setParseError("missing relation string");
        }
        return skipWhiteSpace(string);
    }

    private int parseUnicodeSet(int i, UnicodeSet unicodeSet) throws ParseException {
        int i2 = 0;
        int i3 = i;
        while (i3 != this.rules.length()) {
            int i4 = i3 + 1;
            char cCharAt = this.rules.charAt(i3);
            if (cCharAt == '[') {
                i2++;
            } else if (cCharAt == ']' && (i2 = i2 - 1) == 0) {
                try {
                    unicodeSet.applyPattern(this.rules.substring(i, i4));
                } catch (Exception e) {
                    setParseError(cq.j("not a valid UnicodeSet pattern: ", e.getMessage()));
                }
                int iSkipWhiteSpace = skipWhiteSpace(i4);
                if (iSkipWhiteSpace != this.rules.length() && this.rules.charAt(iSkipWhiteSpace) == ']') {
                    return iSkipWhiteSpace + 1;
                }
                setParseError("missing option-terminating ']' after UnicodeSet pattern");
                return iSkipWhiteSpace;
            }
            i3 = i4;
        }
        setParseError("unbalanced UnicodeSet pattern brackets");
        return i3;
    }

    private int readWords(int i, StringBuilder sb) {
        sb.setLength(0);
        int iSkipWhiteSpace = skipWhiteSpace(i);
        while (iSkipWhiteSpace < this.rules.length()) {
            char cCharAt = this.rules.charAt(iSkipWhiteSpace);
            if (isSyntaxChar(cCharAt) && cCharAt != '-' && cCharAt != '_') {
                if (sb.length() != 0) {
                    int length = sb.length() - 1;
                    if (sb.charAt(length) == ' ') {
                        sb.setLength(length);
                    }
                }
                return iSkipWhiteSpace;
            }
            if (PatternProps.isWhiteSpace(cCharAt)) {
                sb.append(' ');
                iSkipWhiteSpace = skipWhiteSpace(iSkipWhiteSpace + 1);
            } else {
                sb.append(cCharAt);
                iSkipWhiteSpace++;
            }
        }
        return 0;
    }

    private void setParseError(String str, Exception exc) throws ParseException {
        ParseException parseExceptionMakeParseException = makeParseException(cq.k(str, ": ", exc.getMessage()));
        parseExceptionMakeParseException.initCause(exc);
        throw parseExceptionMakeParseException;
    }

    private int skipComment(int i) {
        while (i < this.rules.length()) {
            int i2 = i + 1;
            char cCharAt = this.rules.charAt(i);
            if (cCharAt == '\n' || cCharAt == '\f' || cCharAt == '\r' || cCharAt == 133 || cCharAt == 8232 || cCharAt == 8233) {
                return i2;
            }
            i = i2;
        }
        return i;
    }

    private int skipWhiteSpace(int i) {
        while (i < this.rules.length() && PatternProps.isWhiteSpace(this.rules.charAt(i))) {
            i++;
        }
        return i;
    }

    public void setImporter(Importer importer) {
        this.importer = importer;
    }

    public void setSink(Sink sink) {
        this.sink = sink;
    }

    private void setParseError(String str) throws ParseException {
        throw makeParseException(str);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class Sink {
        public abstract void addRelation(int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3);

        public abstract void addReset(int i, CharSequence charSequence);

        public void optimize(UnicodeSet unicodeSet) {
        }

        public void suppressContractions(UnicodeSet unicodeSet) {
        }
    }

    public void parse(String str, CollationSettings collationSettings) throws ParseException {
        this.settings = collationSettings;
        parse(str);
    }
}
