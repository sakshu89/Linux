package com.ibm.icu.text;

import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.RuleCharacterIterator;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.util.VersionInfo;
import defpackage.cq;
import defpackage.ky0;
import defpackage.og;
import java.text.ParsePosition;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class UnicodeSetLexer {
    private String AHEAD = "☞";
    private String BEHIND = "☜";
    LexicalElement ahead2_;
    LexicalElement ahead_;
    LexicalElement behind_;
    final int charsOptions_;
    RuleCharacterIterator chars_;
    final ParsePosition parsePosition_;
    final String pattern_;
    final SymbolTable symbols_;
    final int unicodeSetOptions_;
    final UnicodeSet.XSymbolTable xsymbols_;

    /* JADX INFO: renamed from: com.ibm.icu.text.UnicodeSetLexer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$text$UnicodeSetLexer$LexicalElement$Category;

        static {
            int[] iArr = new int[LexicalElement.Category.values().length];
            $SwitchMap$com$ibm$icu$text$UnicodeSetLexer$LexicalElement$Category = iArr;
            try {
                iArr[LexicalElement.Category.LITERAL_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$UnicodeSetLexer$LexicalElement$Category[LexicalElement.Category.ESCAPED_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$UnicodeSetLexer$LexicalElement$Category[LexicalElement.Category.NAMED_ELEMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$UnicodeSetLexer$LexicalElement$Category[LexicalElement.Category.BRACKETED_ELEMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$UnicodeSetLexer$LexicalElement$Category[LexicalElement.Category.STRING_LITERAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ibm$icu$text$UnicodeSetLexer$LexicalElement$Category[LexicalElement.Category.PROPERTY_QUERY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class LexicalElement {
        RuleCharacterIterator.Position after_;
        Category category_;
        UnicodeSet set_;
        CharSequence sourceText_;
        String string_;

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public enum Category {
            SET_OPERATOR,
            LITERAL_ELEMENT,
            ESCAPED_ELEMENT,
            NAMED_ELEMENT,
            BRACKETED_ELEMENT,
            STRING_LITERAL,
            PROPERTY_QUERY,
            VARIABLE,
            END_OF_TEXT;

            @Override // java.lang.Enum
            public String toString() {
                return this == END_OF_TEXT ? "(end of text)" : super.toString().toLowerCase(Locale.ROOT).replace('_', '-');
            }
        }

        public LexicalElement(Category category, String str, RuleCharacterIterator.Position position, UnicodeSet unicodeSet, CharSequence charSequence, boolean z, LexicalElement lexicalElement, UnicodeSetLexer unicodeSetLexer) {
            this.category_ = category;
            this.string_ = str;
            this.after_ = position;
            this.set_ = unicodeSet;
            this.sourceText_ = charSequence;
            if (z || lexicalElement == null) {
                return;
            }
            if (lexicalElement.isSetOperator('[') && category == Category.LITERAL_ELEMENT && codePoint().intValue() == 58) {
                unicodeSetLexer.chars_.setPos(lexicalElement.after_);
                throw unicodeSetLexer.lexicalError("white-space other than ignorable-format-control is required between set-operator [ and literal-element :");
            }
            Category category2 = lexicalElement.category_;
            Category category3 = Category.ESCAPED_ELEMENT;
            if (category2 == category3) {
                if (UCharacter.isHighSurrogate(lexicalElement.codePoint().intValue()) && this.category_ == category3 && UCharacter.isLowSurrogate(codePoint().intValue())) {
                    unicodeSetLexer.chars_.setPos(lexicalElement.after_);
                    throw unicodeSetLexer.lexicalError("white-space other than ignorable-format-control is required between escaped-elements representing high and low surrogates");
                }
                if (lexicalElement.sourceText_.length() > 3 || category != Category.LITERAL_ELEMENT) {
                    return;
                }
                int iIntValue = codePoint().intValue();
                if (lexicalElement.sourceText_.charAt(1) != 'x') {
                    if (lexicalElement.sourceText_.charAt(1) < '0' || lexicalElement.sourceText_.charAt(1) > '7' || iIntValue < 48 || iIntValue > 55) {
                        return;
                    }
                    unicodeSetLexer.chars_.setPos(lexicalElement.after_);
                    throw unicodeSetLexer.lexicalError(cq.l("white-space other than ignorable-format-control is required between escaped-element ", String.valueOf(lexicalElement.sourceText_), " and literal-element ", String.valueOf(this.sourceText_)));
                }
                if ((iIntValue < 48 || iIntValue > 57) && ((iIntValue < 65 || iIntValue > 70) && (iIntValue < 97 || iIntValue > 102))) {
                    return;
                }
                unicodeSetLexer.chars_.setPos(lexicalElement.after_);
                throw unicodeSetLexer.lexicalError(cq.l("white-space other than ignorable-format-control is required between escaped-element ", String.valueOf(lexicalElement.sourceText_), " and literal-element ", String.valueOf(this.sourceText_)));
            }
        }

        public Integer codePoint() {
            Category category = this.category_;
            if (category == Category.LITERAL_ELEMENT || category == Category.ESCAPED_ELEMENT || category == Category.BRACKETED_ELEMENT || category == Category.NAMED_ELEMENT) {
                return Integer.valueOf(this.string_.codePointAt(0));
            }
            return null;
        }

        public String debugString() {
            return ky0.k(this.category_.toString(), " '", String.valueOf(this.sourceText_), "'");
        }

        public String element() {
            Category category = this.category_;
            if (category == Category.LITERAL_ELEMENT || category == Category.ESCAPED_ELEMENT || category == Category.BRACKETED_ELEMENT || category == Category.STRING_LITERAL) {
                return this.string_;
            }
            return null;
        }

        public boolean isBracketedElement() {
            return this.category_ == Category.BRACKETED_ELEMENT;
        }

        public boolean isNamedElement() {
            return this.category_ == Category.NAMED_ELEMENT;
        }

        public boolean isSetOperator(char c) {
            return this.category_ == Category.SET_OPERATOR && this.string_.charAt(0) == c;
        }

        public boolean isStringLiteral() {
            return this.category_ == Category.STRING_LITERAL;
        }

        public UnicodeSet set() {
            Category category = this.category_;
            if (category == Category.PROPERTY_QUERY || category == Category.VARIABLE) {
                return this.set_;
            }
            return null;
        }
    }

    public UnicodeSetLexer(String str, ParsePosition parsePosition, RuleCharacterIterator ruleCharacterIterator, int i, SymbolTable symbolTable) {
        this.pattern_ = str;
        this.parsePosition_ = parsePosition;
        this.chars_ = ruleCharacterIterator;
        this.unicodeSetOptions_ = i;
        this.charsOptions_ = ((i & 1) != 0 ? 4 : 0) | 2;
        this.symbols_ = symbolTable;
        if (symbolTable instanceof UnicodeSet.XSymbolTable) {
            this.xsymbols_ = (UnicodeSet.XSymbolTable) symbolTable;
        } else {
            this.xsymbols_ = null;
        }
    }

    private LexicalElement evaluateVariable(String str, CharSequence charSequence) {
        ParsePosition parsePosition = new ParsePosition(0);
        UnicodeSetLexer unicodeSetLexer = new UnicodeSetLexer(str, parsePosition, new RuleCharacterIterator(str, this.symbols_, parsePosition), this.unicodeSetOptions_, null);
        LexicalElement lexicalElementLookahead = unicodeSetLexer.lookahead();
        if (!lexicalElementLookahead.isSetOperator('[')) {
            unicodeSetLexer.advance();
            if (!unicodeSetLexer.atEnd()) {
                throw lexicalError(ky0.l("Variable ", String.valueOf(charSequence), " expands to '", str, "' which consists of several lexical elements that do not form a UnicodeSet expression"));
            }
            switch (AnonymousClass1.$SwitchMap$com$ibm$icu$text$UnicodeSetLexer$LexicalElement$Category[lexicalElementLookahead.category_.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return new LexicalElement(lexicalElementLookahead.category_, lexicalElementLookahead.string_, getPos(), lexicalElementLookahead.set_, charSequence, true, null, this);
                default:
                    StringBuilder sbQ = cq.q("Value of variable ", String.valueOf(charSequence), " expands to invalid lexical element of type ", String.valueOf(lexicalElementLookahead.category_), " :");
                    sbQ.append(str);
                    throw lexicalError(sbQ.toString());
            }
        }
        StringBuilder sb = new StringBuilder();
        try {
            UnicodeSet unicodeSet = UnicodeSet.parseUnicodeSet(unicodeSetLexer, sb, this.unicodeSetOptions_, 0);
            unicodeSet.setPattern(sb.toString());
            if (unicodeSetLexer.atEnd()) {
                return new LexicalElement(LexicalElement.Category.VARIABLE, null, getPos(), unicodeSet, charSequence, true, null, this);
            }
            StringBuilder sbQ2 = cq.q("Variable ", String.valueOf(charSequence), " expands to '", str, "' which contains additional text beyond a UnicodeSet expression: ");
            sbQ2.append(str);
            throw lexicalError(sbQ2.toString());
        } catch (IllegalArgumentException e) {
            String strValueOf = String.valueOf(charSequence);
            String message = e.getMessage();
            throw lexicalError(cq.n(cq.q("The value of variable ", strValueOf, " failed to parse as a UnicodeSet (", message, "). See usage of "), String.valueOf(charSequence), ":"));
        }
    }

    private RuleCharacterIterator.Position getPos() {
        RuleCharacterIterator.Position position = new RuleCharacterIterator.Position();
        this.chars_.getPos(position);
        return position;
    }

    private String getPositionForDebugging(String str) {
        return cq.k(String.valueOf(this.pattern_.subSequence(0, this.parsePosition_.getIndex())), str, String.valueOf(this.pattern_.subSequence(this.parsePosition_.getIndex(), Math.min(this.pattern_.length(), this.parsePosition_.getIndex() + 60))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IllegalArgumentException lexicalError(String str) {
        return new IllegalArgumentException(cq.k(str, Padder.FALLBACK_PADDING_STRING, getPositionForDebugging(this.BEHIND)));
    }

    private LexicalElement lookupVariable(String str, int i, int i2, ParsePosition parsePosition) {
        this.chars_.jumpahead(parsePosition.getIndex() - i2);
        CharSequence charSequenceSubSequence = this.pattern_.subSequence(i, this.parsePosition_.getIndex());
        UnicodeSet unicodeSetLookupSet = this.symbols_.lookupSet(str);
        if (unicodeSetLookupSet != null) {
            return new LexicalElement(LexicalElement.Category.VARIABLE, null, getPos(), unicodeSetLookupSet, charSequenceSubSequence, true, null, this);
        }
        char[] cArrLookup = this.symbols_.lookup(str);
        if (cArrLookup != null) {
            return evaluateVariable(new String(cArrLookup), charSequenceSubSequence);
        }
        throw lexicalError(cq.j("Undefined variable ", str));
    }

    private LexicalElement nextToken(LexicalElement lexicalElement) {
        boolean z;
        int next;
        boolean zIsEscaped;
        if ((this.charsOptions_ & 4) != 0) {
            RuleCharacterIterator.Position position = new RuleCharacterIterator.Position();
            boolean z2 = false;
            while (true) {
                this.chars_.getPos(position);
                int next2 = this.chars_.next(this.charsOptions_ & (-7));
                if (!PatternProps.isWhiteSpace(next2)) {
                    break;
                }
                if (next2 != 8206 && next2 != 8207) {
                    z2 = true;
                }
            }
            this.chars_.setPos(position);
            z = z2;
        } else {
            z = false;
        }
        this.chars_.skipIgnored(this.charsOptions_);
        if (this.chars_.atEnd()) {
            return new LexicalElement(LexicalElement.Category.END_OF_TEXT, null, getPos(), null, "", z, lexicalElement, this);
        }
        int index = this.parsePosition_.getIndex();
        RuleCharacterIterator.Position pos = getPos();
        if (this.xsymbols_ != null) {
            ParsePosition parsePosition = new ParsePosition(this.parsePosition_.getIndex());
            UnicodeSet.XSymbolTable xSymbolTable = this.xsymbols_;
            String str = this.pattern_;
            String strScanVariable = xSymbolTable.scanVariable(str, parsePosition, str.length());
            if (strScanVariable != null) {
                return lookupVariable(strScanVariable, index, index, parsePosition);
            }
        }
        int next3 = this.chars_.next(this.charsOptions_ & (-3));
        if (next3 == 91 || next3 == 92) {
            RuleCharacterIterator.Position pos2 = getPos();
            int next4 = this.chars_.next(this.charsOptions_ & (-7));
            if ((next3 == 91 && next4 == 58) || (next3 == 92 && (next4 == 112 || next4 == 80 || next4 == 78))) {
                if (next4 == 78) {
                    return new LexicalElement(LexicalElement.Category.NAMED_ELEMENT, new String(Character.toChars(scanNamedElementBrackets())), getPos(), null, this.pattern_.subSequence(index, this.parsePosition_.getIndex()), z, lexicalElement, this);
                }
                return new LexicalElement(LexicalElement.Category.PROPERTY_QUERY, null, getPos(), scanPropertyQueryAfterStart(next3, next4, index), this.pattern_.subSequence(index, this.parsePosition_.getIndex()), z, lexicalElement, this);
            }
            this.chars_.setPos(pos2);
        }
        if (next3 == 36 && this.symbols_ != null && this.xsymbols_ == null) {
            ParsePosition parsePosition2 = new ParsePosition(this.parsePosition_.getIndex());
            SymbolTable symbolTable = this.symbols_;
            String str2 = this.pattern_;
            String reference = symbolTable.parseReference(str2, parsePosition2, str2.length());
            if (reference != null) {
                return lookupVariable(reference, index, index + 1, parsePosition2);
            }
        }
        if (next3 != 36 && next3 != 38 && next3 != 45) {
            if (next3 == 123) {
                StringBuilder sb = new StringBuilder();
                int i = 0;
                while (!this.chars_.atEnd()) {
                    RuleCharacterIterator.Position pos3 = getPos();
                    int next5 = this.chars_.next(this.charsOptions_ & (-7));
                    if (next5 == 92) {
                        int next6 = this.chars_.next(this.charsOptions_ & (-7));
                        if (next6 == 78) {
                            next = scanNamedElementBrackets();
                            zIsEscaped = true;
                        } else {
                            if (next6 == 112 || next6 == 80) {
                                throw lexicalError(cq.v("Invalid escape sequence \\", new String(Character.toChars(next6)), " in UnicodeSet string"));
                            }
                            this.chars_.setPos(pos3);
                            next = this.chars_.next(this.charsOptions_);
                            zIsEscaped = this.chars_.isEscaped();
                        }
                    } else {
                        if (VersionInfo.ICU_VERSION.getMajor() >= 81) {
                            og.i("Remove this transitional check, see ICU-23307 and ICU-TC minutes of 2026-01-16.");
                            return null;
                        }
                        if (PatternProps.isWhiteSpace(next5)) {
                            throw lexicalError(cq.v("Unescaped Pattern_White_Space in UnicodeSet string literals is prohibited until ICU 81.  Escape U+", Utility.hex(next5), "."));
                        }
                        next = next5;
                        zIsEscaped = false;
                    }
                    if (!zIsEscaped && next == 125) {
                        return new LexicalElement(i == 1 ? LexicalElement.Category.BRACKETED_ELEMENT : LexicalElement.Category.STRING_LITERAL, sb.toString(), getPos(), null, this.pattern_.subSequence(index, this.parsePosition_.getIndex()), z, lexicalElement, this);
                    }
                    sb.append(new String(Character.toChars(next)));
                    i++;
                }
                throw lexicalError("String literal was not terminated: ".concat(String.valueOf(this.pattern_.subSequence(index, this.parsePosition_.getIndex()))));
            }
            switch (next3) {
                case 91:
                    return new LexicalElement(LexicalElement.Category.SET_OPERATOR, "[", getPos(), null, this.pattern_.subSequence(index, this.parsePosition_.getIndex()), z, lexicalElement, this);
                case 92:
                    this.chars_.setPos(pos);
                    return new LexicalElement(LexicalElement.Category.ESCAPED_ELEMENT, new String(Character.toChars(this.chars_.next(this.charsOptions_))), getPos(), null, this.pattern_.subSequence(index, this.parsePosition_.getIndex()), z, lexicalElement, this);
                case 93:
                case 94:
                    break;
                default:
                    return new LexicalElement(LexicalElement.Category.LITERAL_ELEMENT, new String(Character.toChars(next3)), getPos(), null, this.pattern_.subSequence(index, this.parsePosition_.getIndex()), z, lexicalElement, this);
            }
        }
        return new LexicalElement(LexicalElement.Category.SET_OPERATOR, new String(Character.toChars(next3)), getPos(), null, this.pattern_.subSequence(index, this.parsePosition_.getIndex()), z, lexicalElement, this);
    }

    private int scanNamedElementBrackets() {
        int i;
        int charFromExtendedName;
        String strConcat;
        if (this.chars_.next(this.charsOptions_ & (-7)) == 123) {
            int index = this.parsePosition_.getIndex();
            Integer num = null;
            Integer numValueOf = null;
            while (!this.chars_.atEnd()) {
                int next = this.chars_.next(this.charsOptions_ & (-7));
                if (next == 58) {
                    if (num == null) {
                        num = 0;
                        if (index == this.parsePosition_.getIndex() - 1) {
                            throw lexicalError("Empty hexadecimal-digits in named-element");
                        }
                        IntStream intStreamChars = this.pattern_.subSequence(index, this.parsePosition_.getIndex() - 1).chars();
                        Objects.requireNonNull(intStreamChars);
                        Iterator<Integer> it = intStreamChars.iterator();
                        while (it.hasNext()) {
                            int iIntValue = it.next().intValue();
                            if (iIntValue < 48 || iIntValue > 57) {
                                int i2 = iIntValue & (-33);
                                if (i2 < 65 || i2 > 70) {
                                    throw lexicalError("Ill-formed hexadecimal-digits: ".concat(String.valueOf(this.pattern_.subSequence(index, this.parsePosition_.getIndex() - 1))));
                                }
                                i = i2 - 55;
                            } else {
                                i = iIntValue - 48;
                            }
                            int iIntValue2 = (num.intValue() << 4) + i;
                            Integer numValueOf2 = Integer.valueOf(iIntValue2);
                            if (iIntValue2 > 1114111) {
                                throw lexicalError("hexadecimal-digits out of range: ".concat(String.valueOf(this.pattern_.subSequence(index, this.parsePosition_.getIndex() - 1))));
                            }
                            num = numValueOf2;
                        }
                    } else {
                        if (numValueOf != null) {
                            throw lexicalError("Too many colons in named-element");
                        }
                        int[] array = this.pattern_.subSequence(index, this.parsePosition_.getIndex() - 1).codePoints().toArray();
                        if (array.length != 1) {
                            throw lexicalError("Ill-formed named-literal-element '" + String.valueOf(this.pattern_.subSequence(index, this.parsePosition_.getIndex() - 1)) + "' (" + array.length + " code points)");
                        }
                        numValueOf = Integer.valueOf(array[0]);
                    }
                    index = this.parsePosition_.getIndex();
                } else if (next == 125) {
                    String strSubstring = this.pattern_.substring(index, this.parsePosition_.getIndex() - 1);
                    SymbolTable symbolTable = this.symbols_;
                    if ((symbolTable == null || !(symbolTable instanceof UnicodeSet.XSymbolTable)) && UnicodeSet.getDefaultXSymbolTable() == null) {
                        charFromExtendedName = UCharacter.getCharFromExtendedName(strSubstring);
                    } else {
                        UnicodeSet unicodeSet = new UnicodeSet();
                        unicodeSet.applyPropertyAlias("Name", strSubstring, this.symbols_);
                        charFromExtendedName = unicodeSet.charAt(0);
                    }
                    if (charFromExtendedName >= 0 && ((num == null || charFromExtendedName == num.intValue()) && (numValueOf == null || charFromExtendedName == numValueOf.intValue()))) {
                        return charFromExtendedName;
                    }
                    if (charFromExtendedName >= 0) {
                        strConcat = cq.v("inconsistent with ", num != null ? ky0.j(Utility.hex(num.intValue()), ":") : "", numValueOf != null ? new String(Character.toChars(numValueOf.intValue())).concat(":") : "");
                    } else {
                        strConcat = strSubstring.concat(" not found");
                    }
                    throw lexicalError("Ill-formed named-element: ".concat(strConcat));
                }
            }
        }
        throw lexicalError("Ill-formed named-element");
    }

    private UnicodeSet scanPropertyQueryAfterStart(int i, int i2, int i3) {
        boolean z;
        int index = this.parsePosition_.getIndex();
        int next = this.chars_.next(this.charsOptions_ & (-7));
        boolean z2 = false;
        if (i == 92) {
            if (next != 123) {
                throw lexicalError("Missing { in property-query");
            }
            z = i2 == 80;
            index = this.parsePosition_.getIndex();
        } else if (next == 94) {
            index = this.parsePosition_.getIndex();
            z = true;
        } else {
            z = false;
        }
        RuleCharacterIterator.Position pos = getPos();
        int next2 = this.chars_.next(this.charsOptions_ & (-7));
        Integer numValueOf = null;
        while (true) {
            if (this.chars_.atEnd()) {
                throw lexicalError("property-query was not terminated");
            }
            RuleCharacterIterator.Position pos2 = getPos();
            int next3 = this.chars_.next(this.charsOptions_ & (-7));
            if (next2 == 92) {
                if (next3 == 78) {
                    scanNamedElementBrackets();
                } else {
                    this.chars_.setPos(pos);
                    this.chars_.next(this.charsOptions_ & (-5));
                }
                next2 = -1;
            } else {
                if (numValueOf == null && next3 == 61) {
                    numValueOf = Integer.valueOf(this.parsePosition_.getIndex() - 1);
                } else if (numValueOf != null || next3 != 8800) {
                    if ((i == 91 && next2 == 58 && next3 == 93) || (i == 92 && next3 == 125)) {
                        break;
                    }
                } else {
                    if (z) {
                        throw lexicalError("Found doubly negated property-query");
                    }
                    numValueOf = Integer.valueOf(this.parsePosition_.getIndex() - 1);
                    z2 = true;
                }
                next2 = next3;
            }
            pos = pos2;
        }
        ParsePosition parsePosition = this.parsePosition_;
        int index2 = i == 91 ? parsePosition.getIndex() - 2 : parsePosition.getIndex() - 1;
        String strSubstring = numValueOf != null ? this.pattern_.substring(numValueOf.intValue() + 1, index2) : null;
        UnicodeSet unicodeSet = new UnicodeSet();
        String str = this.pattern_;
        if (numValueOf != null) {
            index2 = numValueOf.intValue();
        }
        unicodeSet.applyPropertyAlias(str.substring(index, index2), strSubstring, this.symbols_);
        if (z != z2) {
            unicodeSet.complement().removeAllStrings();
        }
        unicodeSet.setPattern(this.pattern_.substring(i3, this.parsePosition_.getIndex()));
        return unicodeSet;
    }

    public boolean acceptSetOperator(char c) {
        if (!lookahead().isSetOperator(c)) {
            return false;
        }
        advance();
        return true;
    }

    public void advance() {
        this.chars_.setPos(lookahead().after_);
        this.behind_ = this.ahead_;
        this.ahead_ = this.ahead2_;
        this.ahead2_ = null;
    }

    public boolean atEnd() {
        return this.chars_.atEnd();
    }

    public RuleCharacterIterator getCharacterIterator() {
        lookahead();
        return this.chars_;
    }

    public LexicalElement lookahead() {
        if (this.ahead_ == null) {
            RuleCharacterIterator.Position pos = getPos();
            this.ahead_ = nextToken(this.behind_);
            this.chars_.setPos(pos);
        }
        return this.ahead_;
    }

    public LexicalElement lookahead2() {
        if (this.ahead2_ == null) {
            RuleCharacterIterator.Position pos = getPos();
            this.chars_.setPos(lookahead().after_);
            this.ahead2_ = nextToken(this.ahead_);
            this.chars_.setPos(pos);
        }
        return this.ahead2_;
    }

    public IllegalArgumentException syntaxError(String str, String str2) {
        String positionForDebugging = getPositionForDebugging();
        StringBuilder sbQ = cq.q("Expected ", str, ", got ", str2, Padder.FALLBACK_PADDING_STRING);
        sbQ.append(positionForDebugging);
        return new IllegalArgumentException(sbQ.toString());
    }

    private String getPositionForDebugging() {
        return getPositionForDebugging(this.AHEAD);
    }
}
