package com.ibm.icu.text;

import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.number.NumberFormatter;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.ULocale;
import defpackage.cq;
import defpackage.dk0;
import defpackage.kf2;
import defpackage.og;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.CharacterIterator;
import java.text.ChoiceFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class MessageFormat extends UFormat implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final char CURLY_BRACE_LEFT = '{';
    private static final char CURLY_BRACE_RIGHT = '}';
    private static final int DATE_MODIFIER_EMPTY = 0;
    private static final int DATE_MODIFIER_FULL = 4;
    private static final int DATE_MODIFIER_LONG = 3;
    private static final int DATE_MODIFIER_MEDIUM = 2;
    private static final int DATE_MODIFIER_SHORT = 1;
    private static final int MODIFIER_CURRENCY = 1;
    private static final int MODIFIER_EMPTY = 0;
    private static final int MODIFIER_INTEGER = 3;
    private static final int MODIFIER_PERCENT = 2;
    private static final char SINGLE_QUOTE = '\'';
    private static final int STATE_INITIAL = 0;
    private static final int STATE_IN_QUOTE = 2;
    private static final int STATE_MSG_ELEMENT = 3;
    private static final int STATE_SINGLE_QUOTE = 1;
    private static final int TYPE_DATE = 1;
    private static final int TYPE_DURATION = 5;
    private static final int TYPE_NUMBER = 0;
    private static final int TYPE_ORDINAL = 4;
    private static final int TYPE_SPELLOUT = 3;
    private static final int TYPE_TIME = 2;
    static final long serialVersionUID = 7136212545847378652L;
    private transient Map<Integer, Format> cachedFormatters;
    private transient Set<Integer> customFormatArgStarts;
    private transient MessagePattern msgPattern;
    private transient PluralSelectorProvider ordinalProvider;
    private transient PluralSelectorProvider pluralProvider;
    private transient DateFormat stockDateFormatter;
    private transient NumberFormat stockNumberFormatter;
    private transient ULocale ulocale;
    private static final String[] typeList = {"number", "date", "time", "spellout", "ordinal", "duration"};
    private static final String[] modifierList = {"", "currency", "percent", "integer"};
    private static final String[] dateModifierList = {"", "short", "medium", "long", "full"};
    private static final Locale rootLocale = new Locale("");

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Field extends Format.Field {
        public static final Field ARGUMENT = new Field("message argument field");
        private static final long serialVersionUID = 7510380454602616157L;

        public Field(String str) {
            super(str);
        }

        @Override // java.text.AttributedCharacterIterator.Attribute
        public Object readResolve() throws InvalidObjectException {
            if (getClass() != Field.class) {
                kf2.i("A subclass of MessageFormat.Field must implement readResolve.");
                return null;
            }
            String name = getName();
            Field field = ARGUMENT;
            if (name.equals(field.getName())) {
                return field;
            }
            kf2.i("Unknown attribute name.");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class PluralSelectorProvider implements PluralFormat.PluralSelector {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private MessageFormat msgFormat;
        private PluralRules rules;
        private PluralRules.PluralType type;

        public PluralSelectorProvider(MessageFormat messageFormat, PluralRules.PluralType pluralType) {
            this.msgFormat = messageFormat;
            this.type = pluralType;
        }

        @Override // com.ibm.icu.text.PluralFormat.PluralSelector
        public String select(Object obj, double d) {
            if (this.rules == null) {
                this.rules = PluralRules.forLocale(this.msgFormat.ulocale, this.type);
            }
            PluralSelectorContext pluralSelectorContext = (PluralSelectorContext) obj;
            int iFindFirstPluralNumberArg = this.msgFormat.findFirstPluralNumberArg(this.msgFormat.findOtherSubMessage(pluralSelectorContext.startIndex), pluralSelectorContext.argName);
            pluralSelectorContext.numberArgIndex = iFindFirstPluralNumberArg;
            if (iFindFirstPluralNumberArg > 0 && this.msgFormat.cachedFormatters != null) {
                pluralSelectorContext.formatter = (Format) this.msgFormat.cachedFormatters.get(Integer.valueOf(pluralSelectorContext.numberArgIndex));
            }
            if (pluralSelectorContext.formatter == null) {
                pluralSelectorContext.formatter = this.msgFormat.getStockNumberFormatter();
                pluralSelectorContext.forReplaceNumber = true;
            }
            pluralSelectorContext.numberString = pluralSelectorContext.formatter.format(pluralSelectorContext.number);
            Format format = pluralSelectorContext.formatter;
            if (!(format instanceof DecimalFormat)) {
                return this.rules.select(d);
            }
            return this.rules.select(((DecimalFormat) format).getFixedDecimal(d));
        }
    }

    public MessageFormat(String str) {
        this.ulocale = ULocale.getDefault(ULocale.Category.FORMAT);
        applyPattern(str);
    }

    private boolean argNameMatches(int i, String str, int i2) {
        MessagePattern.Part part = this.msgPattern.getPart(i);
        if (part.getType() == MessagePattern.Part.Type.ARG_NAME) {
            return this.msgPattern.partSubstringMatches(part, str);
        }
        return part.getValue() == i2;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0043 A[PHI: r6
      0x0043: PHI (r6v4 int) = (r6v1 int), (r6v1 int), (r6v1 int), (r6v6 int) binds: [B:21:0x003a, B:24:0x0040, B:19:0x0037, B:16:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    public static String autoQuoteApostrophe(String str) {
        StringBuilder sb = new StringBuilder(str.length() * 2);
        int length = str.length();
        char c = 0;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c == 3) {
                            if (cCharAt == '{') {
                                i++;
                            } else if (cCharAt == '}' && (i = i - 1) == 0) {
                                c = 0;
                            }
                        }
                    } else if (cCharAt == '\'') {
                        c = 0;
                    }
                } else if (cCharAt == '\'') {
                    c = 0;
                } else if (cCharAt == '{' || cCharAt == '}') {
                    c = 2;
                } else {
                    sb.append('\'');
                    c = 0;
                }
            } else if (cCharAt == '\'') {
                c = 1;
            } else if (cCharAt == '{') {
                i++;
                c = 3;
            }
            sb.append(cCharAt);
        }
        if (c == 1 || c == 2) {
            sb.append('\'');
        }
        return new String(sb);
    }

    private void cacheExplicitFormats() {
        String substring;
        Map<Integer, Format> map = this.cachedFormatters;
        if (map != null) {
            map.clear();
        }
        this.customFormatArgStarts = null;
        int iCountParts = this.msgPattern.countParts() - 2;
        int i = 1;
        while (i < iCountParts) {
            MessagePattern.Part part = this.msgPattern.getPart(i);
            if (part.getType() == MessagePattern.Part.Type.ARG_START && part.getArgType() == MessagePattern.ArgType.SIMPLE) {
                MessagePattern messagePattern = this.msgPattern;
                int i2 = i + 3;
                String substring2 = messagePattern.getSubstring(messagePattern.getPart(i + 2));
                MessagePattern.Part part2 = this.msgPattern.getPart(i2);
                if (part2.getType() == MessagePattern.Part.Type.ARG_STYLE) {
                    substring = this.msgPattern.getSubstring(part2);
                    i2 = i + 4;
                } else {
                    substring = "";
                }
                setArgStartFormat(i, createAppropriateFormat(substring2, substring));
                i = i2;
            }
            i++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.text.Format] */
    /* JADX WARN: Type inference failed for: r7v12, types: [com.ibm.icu.text.RuleBasedNumberFormat] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14, types: [com.ibm.icu.text.RuleBasedNumberFormat] */
    /* JADX WARN: Type inference failed for: r7v15, types: [com.ibm.icu.text.RuleBasedNumberFormat] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    private Format createAppropriateFormat(String str, String str2) {
        int iFindKeyword = findKeyword(str, typeList);
        if (iFindKeyword == 0) {
            int iFindKeyword2 = findKeyword(str2, modifierList);
            if (iFindKeyword2 == 0) {
                return NumberFormat.getInstance(this.ulocale);
            }
            if (iFindKeyword2 == 1) {
                return NumberFormat.getCurrencyInstance(this.ulocale);
            }
            if (iFindKeyword2 == 2) {
                return NumberFormat.getPercentInstance(this.ulocale);
            }
            if (iFindKeyword2 == 3) {
                return NumberFormat.getIntegerInstance(this.ulocale);
            }
            int iSkipWhiteSpace = PatternProps.skipWhiteSpace(str2, 0);
            return str2.regionMatches(iSkipWhiteSpace, "::", 0, 2) ? NumberFormatter.forSkeleton(str2.substring(iSkipWhiteSpace + 2)).locale(this.ulocale).toFormat() : new DecimalFormat(str2, new DecimalFormatSymbols(this.ulocale));
        }
        if (iFindKeyword == 1) {
            int iFindKeyword3 = findKeyword(str2, dateModifierList);
            if (iFindKeyword3 == 0) {
                return DateFormat.getDateInstance(2, this.ulocale);
            }
            if (iFindKeyword3 == 1) {
                return DateFormat.getDateInstance(3, this.ulocale);
            }
            if (iFindKeyword3 == 2) {
                return DateFormat.getDateInstance(2, this.ulocale);
            }
            if (iFindKeyword3 != 3) {
                return iFindKeyword3 != 4 ? dateTimeFormatForPatternOrSkeleton(str2) : DateFormat.getDateInstance(0, this.ulocale);
            }
            return DateFormat.getDateInstance(1, this.ulocale);
        }
        if (iFindKeyword == 2) {
            int iFindKeyword4 = findKeyword(str2, dateModifierList);
            if (iFindKeyword4 == 0) {
                return DateFormat.getTimeInstance(2, this.ulocale);
            }
            if (iFindKeyword4 == 1) {
                return DateFormat.getTimeInstance(3, this.ulocale);
            }
            if (iFindKeyword4 == 2) {
                return DateFormat.getTimeInstance(2, this.ulocale);
            }
            if (iFindKeyword4 != 3) {
                return iFindKeyword4 != 4 ? dateTimeFormatForPatternOrSkeleton(str2) : DateFormat.getTimeInstance(0, this.ulocale);
            }
            return DateFormat.getTimeInstance(1, this.ulocale);
        }
        try {
            if (iFindKeyword == 3) {
                str = new RuleBasedNumberFormat(this.ulocale, 1);
                String strTrim = str2.trim();
                if (strTrim.length() != 0) {
                    str.setDefaultRuleSet(strTrim);
                    str = str;
                }
            } else if (iFindKeyword == 4) {
                str = new RuleBasedNumberFormat(this.ulocale, 2);
                String strTrim2 = str2.trim();
                if (strTrim2.length() != 0) {
                    str.setDefaultRuleSet(strTrim2);
                    str = str;
                }
            } else {
                if (iFindKeyword != 5) {
                    og.i(cq.v("Unknown format type \"", str, "\""));
                    return null;
                }
                str = new RuleBasedNumberFormat(this.ulocale, 3);
                String strTrim3 = str2.trim();
                if (strTrim3.length() != 0) {
                    str.setDefaultRuleSet(strTrim3);
                    str = str;
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }

    private static int findChoiceSubMessage(MessagePattern messagePattern, int i, double d) {
        int iCountParts = messagePattern.countParts();
        int i2 = i + 2;
        while (true) {
            int limitPartIndex = messagePattern.getLimitPartIndex(i2);
            int i3 = limitPartIndex + 1;
            if (i3 >= iCountParts) {
                break;
            }
            int i4 = limitPartIndex + 2;
            MessagePattern.Part part = messagePattern.getPart(i3);
            if (part.getType() == MessagePattern.Part.Type.ARG_LIMIT) {
                break;
            }
            double numericValue = messagePattern.getNumericValue(part);
            int i5 = limitPartIndex + 3;
            if (messagePattern.getPatternString().charAt(messagePattern.getPatternIndex(i4)) == '<') {
                if (d <= numericValue) {
                    break;
                }
                i2 = i5;
            } else {
                if (d < numericValue) {
                    break;
                }
                i2 = i5;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int findFirstPluralNumberArg(int i, String str) {
        while (true) {
            i++;
            MessagePattern.Part part = this.msgPattern.getPart(i);
            MessagePattern.Part.Type type = part.getType();
            if (type == MessagePattern.Part.Type.MSG_LIMIT) {
                return 0;
            }
            if (type == MessagePattern.Part.Type.REPLACE_NUMBER) {
                return -1;
            }
            if (type == MessagePattern.Part.Type.ARG_START) {
                MessagePattern.ArgType argType = part.getArgType();
                if (str.length() != 0 && (argType == MessagePattern.ArgType.NONE || argType == MessagePattern.ArgType.SIMPLE)) {
                    if (this.msgPattern.partSubstringMatches(this.msgPattern.getPart(i + 1), str)) {
                        return i;
                    }
                }
                i = this.msgPattern.getLimitPartIndex(i);
            }
        }
    }

    private static final int findKeyword(String str, String[] strArr) {
        String lowerCase = PatternProps.trimWhiteSpace(str).toLowerCase(rootLocale);
        for (int i = 0; i < strArr.length; i++) {
            if (lowerCase.equals(strArr[i])) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int findOtherSubMessage(int i) {
        int iCountParts = this.msgPattern.countParts();
        if (this.msgPattern.getPart(i).getType().hasNumericValue()) {
            i++;
        }
        do {
            int i2 = i + 1;
            MessagePattern.Part part = this.msgPattern.getPart(i);
            if (part.getType() == MessagePattern.Part.Type.ARG_LIMIT) {
                return 0;
            }
            if (this.msgPattern.partSubstringMatches(part, PluralRules.KEYWORD_OTHER)) {
                return i2;
            }
            if (this.msgPattern.getPartType(i2).hasNumericValue()) {
                i2 = i + 2;
            }
            i = this.msgPattern.getLimitPartIndex(i2) + 1;
        } while (i < iCountParts);
        return 0;
    }

    private void format(int i, PluralSelectorContext pluralSelectorContext, Object[] objArr, Map<String, ?> map, AppendableWrapper appendableWrapper, FieldPosition fieldPosition) {
        Object objValueOf;
        Object obj;
        FieldPosition fieldPosition2;
        int i2;
        Map<Integer, Format> map2;
        PluralSelectorProvider pluralSelectorProvider;
        Format format;
        Object obj2;
        AppendableWrapper appendableWrapper2 = appendableWrapper;
        CharSequence patternString = this.msgPattern.getPatternString();
        boolean z = true;
        int limit = this.msgPattern.getPart(i).getLimit();
        int i3 = i + 1;
        FieldPosition fieldPositionUpdateMetaData = fieldPosition;
        while (true) {
            MessagePattern.Part part = this.msgPattern.getPart(i3);
            MessagePattern.Part.Type type = part.getType();
            appendableWrapper2.append(patternString, limit, part.getIndex());
            if (type == MessagePattern.Part.Type.MSG_LIMIT) {
                return;
            }
            limit = part.getLimit();
            if (type != MessagePattern.Part.Type.REPLACE_NUMBER) {
                if (type == MessagePattern.Part.Type.ARG_START) {
                    int limitPartIndex = this.msgPattern.getLimitPartIndex(i3);
                    MessagePattern.ArgType argType = part.getArgType();
                    MessagePattern.Part part2 = this.msgPattern.getPart(i3 + 1);
                    String substring = this.msgPattern.getSubstring(part2);
                    boolean z2 = false;
                    if (objArr != 0) {
                        int value = part2.getValue();
                        objValueOf = appendableWrapper2.attributes != null ? Integer.valueOf(value) : null;
                        if (value < 0 || value >= objArr.length) {
                            z2 = z;
                            obj = null;
                        } else {
                            obj = objArr[value];
                        }
                    } else if (map != 0) {
                        obj = map.get(substring);
                        z2 = obj == null ? !map.containsKey(substring) : false;
                        objValueOf = substring;
                    } else {
                        objValueOf = substring;
                        z2 = z;
                        obj = null;
                    }
                    int i4 = i3 + 2;
                    int i5 = appendableWrapper2.length;
                    if (z2) {
                        appendableWrapper2.append("{");
                        appendableWrapper2.append(substring);
                        appendableWrapper2.append("}");
                    } else if (obj == null) {
                        appendableWrapper2.append("null");
                    } else {
                        if (pluralSelectorContext == null || pluralSelectorContext.numberArgIndex != i3) {
                            Map<Integer, Format> map3 = this.cachedFormatters;
                            FieldPosition fieldPosition3 = fieldPositionUpdateMetaData;
                            if (map3 == null || (format = map3.get(Integer.valueOf(i3))) == null) {
                                Object obj3 = objValueOf;
                                if (argType == MessagePattern.ArgType.NONE || ((map2 = this.cachedFormatters) != null && map2.containsKey(Integer.valueOf(i3)))) {
                                    fieldPosition2 = fieldPosition3;
                                    appendableWrapper2 = appendableWrapper;
                                    i2 = limitPartIndex;
                                    objValueOf = obj3;
                                    if (obj instanceof Number) {
                                        appendableWrapper2.formatAndAppend(getStockNumberFormatter(), obj);
                                    } else if ((obj instanceof Date) || (obj instanceof Calendar) || (obj instanceof java.util.Calendar) || (obj instanceof Temporal) || (obj instanceof DayOfWeek) || (obj instanceof Month)) {
                                        appendableWrapper2.formatAndAppend(getStockDateFormatter(), obj);
                                    } else {
                                        appendableWrapper2.append(obj.toString());
                                    }
                                } else if (argType != MessagePattern.ArgType.CHOICE) {
                                    fieldPosition2 = fieldPosition3;
                                    i2 = limitPartIndex;
                                    objValueOf = obj3;
                                    if (argType.hasPluralStyle()) {
                                        if (!(obj instanceof Number)) {
                                            og.i(cq.v("'", String.valueOf(obj), "' is not a Number"));
                                            return;
                                        }
                                        if (argType == MessagePattern.ArgType.PLURAL) {
                                            if (this.pluralProvider == null) {
                                                this.pluralProvider = new PluralSelectorProvider(this, PluralRules.PluralType.CARDINAL);
                                            }
                                            pluralSelectorProvider = this.pluralProvider;
                                        } else {
                                            if (this.ordinalProvider == null) {
                                                this.ordinalProvider = new PluralSelectorProvider(this, PluralRules.PluralType.ORDINAL);
                                            }
                                            pluralSelectorProvider = this.ordinalProvider;
                                        }
                                        Number number = (Number) obj;
                                        PluralSelectorContext pluralSelectorContext2 = new PluralSelectorContext(i4, substring, number, this.msgPattern.getPluralOffset(i4), 0);
                                        appendableWrapper2 = appendableWrapper;
                                        formatComplexSubMessage(PluralFormat.findSubMessage(this.msgPattern, i4, pluralSelectorProvider, pluralSelectorContext2, number.doubleValue()), pluralSelectorContext2, objArr, map, appendableWrapper2);
                                    } else if (argType != MessagePattern.ArgType.SELECT) {
                                        og.n("unexpected argType ".concat(String.valueOf(argType)));
                                        return;
                                    } else {
                                        appendableWrapper2 = appendableWrapper;
                                        formatComplexSubMessage(SelectFormat.findSubMessage(this.msgPattern, i4, obj.toString()), null, objArr, map, appendableWrapper2);
                                    }
                                } else {
                                    if (!(obj instanceof Number)) {
                                        og.i(cq.v("'", String.valueOf(obj), "' is not a Number"));
                                        return;
                                    }
                                    fieldPosition2 = fieldPosition3;
                                    appendableWrapper2 = appendableWrapper;
                                    objValueOf = obj3;
                                    i2 = limitPartIndex;
                                    formatComplexSubMessage(findChoiceSubMessage(this.msgPattern, i4, ((Number) obj).doubleValue()), null, objArr, map, appendableWrapper2);
                                }
                            } else if ((format instanceof ChoiceFormat) || (format instanceof PluralFormat) || (format instanceof SelectFormat)) {
                                String str = format.format(obj);
                                if (str.indexOf(123) >= 0 || (str.indexOf(39) >= 0 && !this.msgPattern.jdkAposMode())) {
                                    obj2 = objValueOf;
                                    new MessageFormat(str, this.ulocale).format(0, null, objArr, map, appendableWrapper2, null);
                                } else {
                                    if (appendableWrapper2.attributes == null) {
                                        appendableWrapper2.append(str);
                                    } else {
                                        appendableWrapper2.formatAndAppend(format, obj);
                                    }
                                    obj2 = objValueOf;
                                }
                                fieldPosition2 = fieldPosition3;
                                appendableWrapper2 = appendableWrapper;
                                i2 = limitPartIndex;
                                objValueOf = obj2;
                            } else {
                                appendableWrapper2.formatAndAppend(format, obj);
                                i2 = limitPartIndex;
                                fieldPosition2 = fieldPosition3;
                            }
                        } else {
                            double d = pluralSelectorContext.offset;
                            Format format2 = pluralSelectorContext.formatter;
                            if (d == 0.0d) {
                                appendableWrapper2.formatAndAppend(format2, pluralSelectorContext.number, pluralSelectorContext.numberString);
                            } else {
                                appendableWrapper2.formatAndAppend(format2, obj);
                            }
                        }
                        fieldPositionUpdateMetaData = updateMetaData(appendableWrapper2, i5, fieldPosition2, objValueOf);
                        limit = this.msgPattern.getPart(i2).getLimit();
                        i3 = i2;
                    }
                    i2 = limitPartIndex;
                    fieldPosition2 = fieldPositionUpdateMetaData;
                    fieldPositionUpdateMetaData = updateMetaData(appendableWrapper2, i5, fieldPosition2, objValueOf);
                    limit = this.msgPattern.getPart(i2).getLimit();
                    i3 = i2;
                }
                i3++;
                z = z;
            } else if (pluralSelectorContext.forReplaceNumber) {
                appendableWrapper2.formatAndAppend(pluralSelectorContext.formatter, pluralSelectorContext.number, pluralSelectorContext.numberString);
            } else {
                appendableWrapper2.formatAndAppend(getStockNumberFormatter(), pluralSelectorContext.number);
            }
            i3++;
            z = z;
        }
    }

    private void formatComplexSubMessage(int i, PluralSelectorContext pluralSelectorContext, Object[] objArr, Map<String, ?> map, AppendableWrapper appendableWrapper) {
        int index;
        String string;
        if (!this.msgPattern.jdkAposMode()) {
            format(i, pluralSelectorContext, objArr, map, appendableWrapper, null);
            return;
        }
        Map<String, ?> map2 = map;
        AppendableWrapper appendableWrapper2 = appendableWrapper;
        String patternString = this.msgPattern.getPatternString();
        StringBuilder sb = null;
        int limit = this.msgPattern.getPart(i).getLimit();
        int limitPartIndex = i;
        while (true) {
            limitPartIndex++;
            MessagePattern.Part part = this.msgPattern.getPart(limitPartIndex);
            MessagePattern.Part.Type type = part.getType();
            index = part.getIndex();
            if (type == MessagePattern.Part.Type.MSG_LIMIT) {
                break;
            }
            Map<String, ?> map3 = map2;
            AppendableWrapper appendableWrapper3 = appendableWrapper2;
            MessagePattern.Part.Type type2 = MessagePattern.Part.Type.REPLACE_NUMBER;
            if (type == type2 || type == MessagePattern.Part.Type.SKIP_SYNTAX) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) patternString, limit, index);
                if (type == type2) {
                    if (pluralSelectorContext.forReplaceNumber) {
                        sb.append(pluralSelectorContext.numberString);
                    } else {
                        sb.append(getStockNumberFormatter().format(pluralSelectorContext.number));
                    }
                }
                limit = part.getLimit();
            } else if (type == MessagePattern.Part.Type.ARG_START) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) patternString, limit, index);
                limitPartIndex = this.msgPattern.getLimitPartIndex(limitPartIndex);
                limit = this.msgPattern.getPart(limitPartIndex).getLimit();
                MessagePattern.appendReducedApostrophes(patternString, index, limit, sb);
            }
            appendableWrapper2 = appendableWrapper3;
            map2 = map3;
        }
        if (sb == null) {
            string = patternString.substring(limit, index);
        } else {
            sb.append((CharSequence) patternString, limit, index);
            string = sb.toString();
        }
        if (string.indexOf(123) < 0) {
            appendableWrapper2.append(string);
            return;
        }
        MessageFormat messageFormat = new MessageFormat("", this.ulocale);
        messageFormat.applyPattern(string, MessagePattern.ApostropheMode.DOUBLE_REQUIRED);
        messageFormat.format(0, null, objArr, map2, appendableWrapper2, null);
    }

    private String getArgName(int i) {
        MessagePattern.Part part = this.msgPattern.getPart(i);
        return part.getType() == MessagePattern.Part.Type.ARG_NAME ? this.msgPattern.getSubstring(part) : Integer.toString(part.getValue());
    }

    private String getLiteralStringUntilNextArgument(int i) {
        StringBuilder sb = new StringBuilder();
        String patternString = this.msgPattern.getPatternString();
        int limit = this.msgPattern.getPart(i).getLimit();
        while (true) {
            i++;
            MessagePattern.Part part = this.msgPattern.getPart(i);
            MessagePattern.Part.Type type = part.getType();
            sb.append((CharSequence) patternString, limit, part.getIndex());
            if (type == MessagePattern.Part.Type.ARG_START || type == MessagePattern.Part.Type.MSG_LIMIT) {
                break;
            }
            limit = part.getLimit();
        }
        return sb.toString();
    }

    private DateFormat getStockDateFormatter() {
        if (this.stockDateFormatter == null) {
            this.stockDateFormatter = DateFormat.getDateTimeInstance(3, 3, this.ulocale);
        }
        return this.stockDateFormatter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NumberFormat getStockNumberFormatter() {
        if (this.stockNumberFormatter == null) {
            this.stockNumberFormatter = NumberFormat.getInstance(this.ulocale);
        }
        return this.stockNumberFormatter;
    }

    private static int matchStringUntilLimitPart(MessagePattern messagePattern, int i, int i2, String str, int i3) {
        String patternString = messagePattern.getPatternString();
        int limit = messagePattern.getPart(i).getLimit();
        int i4 = 0;
        while (true) {
            i++;
            MessagePattern.Part part = messagePattern.getPart(i);
            if (i == i2 || part.getType() == MessagePattern.Part.Type.SKIP_SYNTAX) {
                int index = part.getIndex() - limit;
                if (index != 0 && !str.regionMatches(i3, patternString, limit, index)) {
                    return -1;
                }
                i4 += index;
                if (i == i2) {
                    return i4;
                }
                limit = part.getLimit();
            }
        }
    }

    private int nextTopLevelArgStart(int i) {
        MessagePattern.Part.Type partType;
        if (i != 0) {
            i = this.msgPattern.getLimitPartIndex(i);
        }
        do {
            i++;
            partType = this.msgPattern.getPartType(i);
            if (partType == MessagePattern.Part.Type.ARG_START) {
                return i;
            }
        } while (partType != MessagePattern.Part.Type.MSG_LIMIT);
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:77:0x0156 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x0158  */
    /* JADX WARN: Code duplicated, block: B:79:0x015b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x015d  */
    /* JADX WARN: Multi-variable type inference failed */
    private void parse(int i, String str, ParsePosition parsePosition, Object[] objArr, Map<String, Object> map) {
        boolean z;
        Object substring;
        int value;
        Object obj;
        boolean z2;
        int i2;
        Object objValueOf;
        Map<Integer, Format> map2;
        int index;
        Format format;
        if (str == null) {
            return;
        }
        String patternString = this.msgPattern.getPatternString();
        int limit = this.msgPattern.getPart(i).getLimit();
        int index2 = parsePosition.getIndex();
        int i3 = 0;
        ParsePosition parsePosition2 = new ParsePosition(0);
        boolean z3 = true;
        int i4 = i + 1;
        while (true) {
            MessagePattern.Part part = this.msgPattern.getPart(i4);
            MessagePattern.Part.Type type = part.getType();
            int index3 = part.getIndex() - limit;
            if (index3 != 0 && !patternString.regionMatches(limit, str, index2, index3)) {
                parsePosition.setErrorIndex(index2);
                return;
            }
            index2 += index3;
            if (type == MessagePattern.Part.Type.MSG_LIMIT) {
                parsePosition.setIndex(index2);
                return;
            }
            if (type == MessagePattern.Part.Type.SKIP_SYNTAX || type == MessagePattern.Part.Type.INSERT_CHAR) {
                z = z3;
                limit = part.getLimit();
            } else {
                int limitPartIndex = this.msgPattern.getLimitPartIndex(i4);
                MessagePattern.ArgType argType = part.getArgType();
                MessagePattern.Part part2 = this.msgPattern.getPart(i4 + 1);
                if (objArr != null) {
                    value = part2.getValue();
                    substring = Integer.valueOf(value);
                    obj = null;
                } else {
                    substring = part2.getType() == MessagePattern.Part.Type.ARG_NAME ? this.msgPattern.getSubstring(part2) : Integer.toString(part2.getValue());
                    value = i3;
                    obj = substring;
                }
                int i5 = i4 + 2;
                z = z3;
                Map<Integer, Format> map3 = this.cachedFormatters;
                if (map3 == null || (format = map3.get(Integer.valueOf(i4))) == null) {
                    if (argType == MessagePattern.ArgType.NONE || ((map2 = this.cachedFormatters) != null && map2.containsKey(Integer.valueOf(i4)))) {
                        String literalStringUntilNextArgument = getLiteralStringUntilNextArgument(limitPartIndex);
                        int iIndexOf = literalStringUntilNextArgument.length() != 0 ? str.indexOf(literalStringUntilNextArgument, index2) : str.length();
                        if (iIndexOf < 0) {
                            parsePosition.setErrorIndex(index2);
                            return;
                        }
                        String strSubstring = str.substring(index2, iIndexOf);
                        boolean zEquals = strSubstring.equals("{" + substring.toString() + "}");
                        Object obj2 = !zEquals ? strSubstring : null;
                        z2 = !zEquals;
                        i2 = iIndexOf;
                        objValueOf = obj2;
                    } else {
                        if (argType != MessagePattern.ArgType.CHOICE) {
                            if (argType.hasPluralStyle() || argType == MessagePattern.ArgType.SELECT) {
                                dk0.r("Parsing of plural/select/selectordinal argument is not supported.");
                                return;
                            } else {
                                og.n("unexpected argType ".concat(String.valueOf(argType)));
                                return;
                            }
                        }
                        parsePosition2.setIndex(index2);
                        double choiceArgument = parseChoiceArgument(this.msgPattern, i5, str, parsePosition2);
                        if (parsePosition2.getIndex() == index2) {
                            parsePosition.setErrorIndex(index2);
                            return;
                        } else {
                            objValueOf = Double.valueOf(choiceArgument);
                            index = parsePosition2.getIndex();
                        }
                    }
                    if (z2) {
                        if (objArr != null) {
                            objArr[value] = objValueOf;
                        } else if (map != 0) {
                            map.put(obj, objValueOf);
                        }
                    }
                    limit = this.msgPattern.getPart(limitPartIndex).getLimit();
                    i4 = limitPartIndex;
                    index2 = i2;
                } else {
                    parsePosition2.setIndex(index2);
                    objValueOf = format.parseObject(str, parsePosition2);
                    if (parsePosition2.getIndex() == index2) {
                        parsePosition.setErrorIndex(index2);
                        return;
                    }
                    index = parsePosition2.getIndex();
                }
                i2 = index;
                z2 = z;
                if (z2) {
                    if (objArr != null) {
                        objArr[value] = objValueOf;
                    } else if (map != 0) {
                        map.put(obj, objValueOf);
                    }
                }
                limit = this.msgPattern.getPart(limitPartIndex).getLimit();
                i4 = limitPartIndex;
                index2 = i2;
            }
            i4++;
            z3 = z;
            i3 = 0;
        }
    }

    private static double parseChoiceArgument(MessagePattern messagePattern, int i, String str, ParsePosition parsePosition) {
        int i2;
        int index = parsePosition.getIndex();
        double d = Double.NaN;
        int i3 = index;
        while (messagePattern.getPartType(i) != MessagePattern.Part.Type.ARG_LIMIT) {
            double numericValue = messagePattern.getNumericValue(messagePattern.getPart(i));
            int i4 = i + 2;
            int limitPartIndex = messagePattern.getLimitPartIndex(i4);
            int iMatchStringUntilLimitPart = matchStringUntilLimitPart(messagePattern, i4, limitPartIndex, str, index);
            if (iMatchStringUntilLimitPart >= 0 && (i2 = iMatchStringUntilLimitPart + index) > i3) {
                i3 = i2;
                if (i2 == str.length()) {
                    d = numericValue;
                    break;
                }
                d = numericValue;
            }
            i = limitPartIndex + 1;
        }
        if (i3 == index) {
            parsePosition.setErrorIndex(index);
            return d;
        }
        parsePosition.setIndex(i3);
        return d;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.ulocale = ULocale.forLanguageTag((String) objectInputStream.readObject());
        MessagePattern.ApostropheMode apostropheMode = (MessagePattern.ApostropheMode) objectInputStream.readObject();
        MessagePattern messagePattern = this.msgPattern;
        if (messagePattern == null || apostropheMode != messagePattern.getApostropheMode()) {
            this.msgPattern = new MessagePattern(apostropheMode);
        }
        String str = (String) objectInputStream.readObject();
        if (str != null) {
            applyPattern(str);
        }
        for (int i = objectInputStream.readInt(); i > 0; i--) {
            setFormat(objectInputStream.readInt(), (Format) objectInputStream.readObject());
        }
        for (int i2 = objectInputStream.readInt(); i2 > 0; i2--) {
            objectInputStream.readInt();
            objectInputStream.readObject();
        }
    }

    private void resetPattern() {
        MessagePattern messagePattern = this.msgPattern;
        if (messagePattern != null) {
            messagePattern.clear();
        }
        Map<Integer, Format> map = this.cachedFormatters;
        if (map != null) {
            map.clear();
        }
        this.customFormatArgStarts = null;
    }

    private void setArgStartFormat(int i, Format format) {
        if (this.cachedFormatters == null) {
            this.cachedFormatters = new HashMap();
        }
        this.cachedFormatters.put(Integer.valueOf(i), format);
    }

    private void setCustomArgStartFormat(int i, Format format) {
        setArgStartFormat(i, format);
        if (this.customFormatArgStarts == null) {
            this.customFormatArgStarts = new HashSet();
        }
        this.customFormatArgStarts.add(Integer.valueOf(i));
    }

    private FieldPosition updateMetaData(AppendableWrapper appendableWrapper, int i, FieldPosition fieldPosition, Object obj) {
        if (appendableWrapper.attributes != null && i < appendableWrapper.length) {
            appendableWrapper.attributes.add(new AttributeAndPosition(obj, i, appendableWrapper.length));
        }
        if (fieldPosition == null || !Field.ARGUMENT.equals(fieldPosition.getFieldAttribute())) {
            return fieldPosition;
        }
        fieldPosition.setBeginIndex(i);
        fieldPosition.setEndIndex(appendableWrapper.length);
        return null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.ulocale.toLanguageTag());
        if (this.msgPattern == null) {
            this.msgPattern = new MessagePattern();
        }
        objectOutputStream.writeObject(this.msgPattern.getApostropheMode());
        objectOutputStream.writeObject(this.msgPattern.getPatternString());
        Set<Integer> set = this.customFormatArgStarts;
        if (set != null && !set.isEmpty()) {
            objectOutputStream.writeInt(this.customFormatArgStarts.size());
            int iNextTopLevelArgStart = 0;
            int i = 0;
            while (true) {
                iNextTopLevelArgStart = nextTopLevelArgStart(iNextTopLevelArgStart);
                if (iNextTopLevelArgStart < 0) {
                    break;
                }
                if (this.customFormatArgStarts.contains(Integer.valueOf(iNextTopLevelArgStart))) {
                    objectOutputStream.writeInt(i);
                    objectOutputStream.writeObject(this.cachedFormatters.get(Integer.valueOf(iNextTopLevelArgStart)));
                }
                i++;
            }
        } else {
            objectOutputStream.writeInt(0);
        }
        objectOutputStream.writeInt(0);
    }

    public void applyPattern(String str, MessagePattern.ApostropheMode apostropheMode) {
        MessagePattern messagePattern = this.msgPattern;
        if (messagePattern == null) {
            this.msgPattern = new MessagePattern(apostropheMode);
        } else if (apostropheMode != messagePattern.getApostropheMode()) {
            this.msgPattern.clearPatternAndSetApostropheMode(apostropheMode);
        }
        applyPattern(str);
    }

    @Override // java.text.Format
    public MessageFormat clone() {
        MessageFormat messageFormat = (MessageFormat) super.clone();
        if (this.customFormatArgStarts != null) {
            messageFormat.customFormatArgStarts = new HashSet();
            Iterator<Integer> it = this.customFormatArgStarts.iterator();
            while (it.hasNext()) {
                messageFormat.customFormatArgStarts.add(it.next());
            }
        } else {
            messageFormat.customFormatArgStarts = null;
        }
        if (this.cachedFormatters != null) {
            messageFormat.cachedFormatters = new HashMap();
            for (Map.Entry<Integer, Format> entry : this.cachedFormatters.entrySet()) {
                messageFormat.cachedFormatters.put(entry.getKey(), entry.getValue());
            }
        } else {
            messageFormat.cachedFormatters = null;
        }
        MessagePattern messagePattern = this.msgPattern;
        messageFormat.msgPattern = messagePattern == null ? null : messagePattern.m18clone();
        DateFormat dateFormat = this.stockDateFormatter;
        messageFormat.stockDateFormatter = dateFormat == null ? null : dateFormat.clone();
        NumberFormat numberFormat = this.stockNumberFormatter;
        messageFormat.stockNumberFormatter = numberFormat == null ? null : numberFormat.clone();
        messageFormat.pluralProvider = null;
        messageFormat.ordinalProvider = null;
        return messageFormat;
    }

    public Format dateTimeFormatForPatternOrSkeleton(String str) {
        int iSkipWhiteSpace = PatternProps.skipWhiteSpace(str, 0);
        return str.regionMatches(iSkipWhiteSpace, "::", 0, 2) ? DateFormat.getInstanceForSkeleton(str.substring(iSkipWhiteSpace + 2), this.ulocale) : new SimpleDateFormat(str, this.ulocale);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MessageFormat messageFormat = (MessageFormat) obj;
            if (Objects.equals(this.ulocale, messageFormat.ulocale) && Objects.equals(this.msgPattern, messageFormat.msgPattern) && Objects.equals(this.cachedFormatters, messageFormat.cachedFormatters) && Objects.equals(this.customFormatArgStarts, messageFormat.customFormatArgStarts)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        if (obj == null) {
            dk0.n("formatToCharacterIterator must be passed non-null object");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        AppendableWrapper appendableWrapper = new AppendableWrapper(sb);
        appendableWrapper.useAttributes();
        format(obj, appendableWrapper, (FieldPosition) null);
        AttributedString attributedString = new AttributedString(sb.toString());
        for (AttributeAndPosition attributeAndPosition : appendableWrapper.attributes) {
            attributedString.addAttribute(attributeAndPosition.key, attributeAndPosition.value, attributeAndPosition.start, attributeAndPosition.limit);
        }
        return attributedString.getIterator();
    }

    public MessagePattern.ApostropheMode getApostropheMode() {
        if (this.msgPattern == null) {
            this.msgPattern = new MessagePattern();
        }
        return this.msgPattern.getApostropheMode();
    }

    public Set<String> getArgumentNames() {
        HashSet hashSet = new HashSet();
        int iNextTopLevelArgStart = 0;
        while (true) {
            iNextTopLevelArgStart = nextTopLevelArgStart(iNextTopLevelArgStart);
            if (iNextTopLevelArgStart < 0) {
                return hashSet;
            }
            hashSet.add(getArgName(iNextTopLevelArgStart + 1));
        }
    }

    public Format getFormatByArgumentName(String str) {
        int iValidateArgumentName;
        if (this.cachedFormatters == null || (iValidateArgumentName = MessagePattern.validateArgumentName(str)) < -1) {
            return null;
        }
        int iNextTopLevelArgStart = 0;
        do {
            iNextTopLevelArgStart = nextTopLevelArgStart(iNextTopLevelArgStart);
            if (iNextTopLevelArgStart < 0) {
                return null;
            }
        } while (!argNameMatches(iNextTopLevelArgStart + 1, str, iValidateArgumentName));
        return this.cachedFormatters.get(Integer.valueOf(iNextTopLevelArgStart));
    }

    public Format[] getFormats() {
        ArrayList arrayList = new ArrayList();
        int iNextTopLevelArgStart = 0;
        while (true) {
            iNextTopLevelArgStart = nextTopLevelArgStart(iNextTopLevelArgStart);
            if (iNextTopLevelArgStart < 0) {
                return (Format[]) arrayList.toArray(new Format[arrayList.size()]);
            }
            Map<Integer, Format> map = this.cachedFormatters;
            arrayList.add(map == null ? null : map.get(Integer.valueOf(iNextTopLevelArgStart)));
        }
    }

    public Format[] getFormatsByArgumentIndex() {
        if (this.msgPattern.hasNamedArguments()) {
            og.i("This method is not available in MessageFormat objects that use alphanumeric argument names.");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iNextTopLevelArgStart = 0;
        while (true) {
            iNextTopLevelArgStart = nextTopLevelArgStart(iNextTopLevelArgStart);
            if (iNextTopLevelArgStart < 0) {
                return (Format[]) arrayList.toArray(new Format[arrayList.size()]);
            }
            int value = this.msgPattern.getPart(iNextTopLevelArgStart + 1).getValue();
            while (value >= arrayList.size()) {
                arrayList.add(null);
            }
            Map<Integer, Format> map = this.cachedFormatters;
            arrayList.set(value, map == null ? null : map.get(Integer.valueOf(iNextTopLevelArgStart)));
        }
    }

    public Locale getLocale() {
        return this.ulocale.toLocale();
    }

    public ULocale getULocale() {
        return this.ulocale;
    }

    public int hashCode() {
        return this.msgPattern.getPatternString().hashCode();
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        return !this.msgPattern.hasNamedArguments() ? parse(str, parsePosition) : parseToMap(str, parsePosition);
    }

    public Map<String, Object> parseToMap(String str) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        HashMap map = new HashMap();
        parse(0, str, parsePosition, null, map);
        if (parsePosition.getIndex() != 0) {
            return map;
        }
        throw new ParseException("MessageFormat parse error!", parsePosition.getErrorIndex());
    }

    public void setFormat(int i, Format format) {
        int iNextTopLevelArgStart = 0;
        int i2 = 0;
        while (true) {
            iNextTopLevelArgStart = nextTopLevelArgStart(iNextTopLevelArgStart);
            if (iNextTopLevelArgStart < 0) {
                throw new ArrayIndexOutOfBoundsException(i);
            }
            if (i2 == i) {
                setCustomArgStartFormat(iNextTopLevelArgStart, format);
                return;
            }
            i2++;
        }
    }

    public void setFormatByArgumentIndex(int i, Format format) {
        if (this.msgPattern.hasNamedArguments()) {
            og.i("This method is not available in MessageFormat objects that use alphanumeric argument names.");
            return;
        }
        int iNextTopLevelArgStart = 0;
        while (true) {
            iNextTopLevelArgStart = nextTopLevelArgStart(iNextTopLevelArgStart);
            if (iNextTopLevelArgStart < 0) {
                return;
            }
            if (this.msgPattern.getPart(iNextTopLevelArgStart + 1).getValue() == i) {
                setCustomArgStartFormat(iNextTopLevelArgStart, format);
            }
        }
    }

    public void setFormatByArgumentName(String str, Format format) {
        int iValidateArgumentName = MessagePattern.validateArgumentName(str);
        if (iValidateArgumentName < -1) {
            return;
        }
        int iNextTopLevelArgStart = 0;
        while (true) {
            iNextTopLevelArgStart = nextTopLevelArgStart(iNextTopLevelArgStart);
            if (iNextTopLevelArgStart < 0) {
                return;
            }
            if (argNameMatches(iNextTopLevelArgStart + 1, str, iValidateArgumentName)) {
                setCustomArgStartFormat(iNextTopLevelArgStart, format);
            }
        }
    }

    public void setFormats(Format[] formatArr) {
        int iNextTopLevelArgStart = 0;
        for (int i = 0; i < formatArr.length && (iNextTopLevelArgStart = nextTopLevelArgStart(iNextTopLevelArgStart)) >= 0; i++) {
            setCustomArgStartFormat(iNextTopLevelArgStart, formatArr[i]);
        }
    }

    public void setFormatsByArgumentIndex(Format[] formatArr) {
        if (this.msgPattern.hasNamedArguments()) {
            og.i("This method is not available in MessageFormat objects that use alphanumeric argument names.");
            return;
        }
        int iNextTopLevelArgStart = 0;
        while (true) {
            iNextTopLevelArgStart = nextTopLevelArgStart(iNextTopLevelArgStart);
            if (iNextTopLevelArgStart < 0) {
                return;
            }
            int value = this.msgPattern.getPart(iNextTopLevelArgStart + 1).getValue();
            if (value < formatArr.length) {
                setCustomArgStartFormat(iNextTopLevelArgStart, formatArr[value]);
            }
        }
    }

    public void setFormatsByArgumentName(Map<String, Format> map) {
        int iNextTopLevelArgStart = 0;
        while (true) {
            iNextTopLevelArgStart = nextTopLevelArgStart(iNextTopLevelArgStart);
            if (iNextTopLevelArgStart < 0) {
                return;
            }
            String argName = getArgName(iNextTopLevelArgStart + 1);
            if (map.containsKey(argName)) {
                setCustomArgStartFormat(iNextTopLevelArgStart, map.get(argName));
            }
        }
    }

    public void setLocale(ULocale uLocale) {
        String pattern = toPattern();
        this.ulocale = uLocale;
        this.stockDateFormatter = null;
        this.stockNumberFormatter = null;
        this.pluralProvider = null;
        this.ordinalProvider = null;
        applyPattern(pattern);
    }

    public String toPattern() {
        String patternString;
        if (this.customFormatArgStarts == null) {
            MessagePattern messagePattern = this.msgPattern;
            return (messagePattern == null || (patternString = messagePattern.getPatternString()) == null) ? "" : patternString;
        }
        og.n("toPattern() is not supported after custom Format objects have been set via setFormat() or similar APIs");
        return null;
    }

    public boolean usesNamedArguments() {
        return this.msgPattern.hasNamedArguments();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class AttributeAndPosition {
        private AttributedCharacterIterator.Attribute key;
        private int limit;
        private int start;
        private Object value;

        public AttributeAndPosition(Object obj, int i, int i2) {
            init(Field.ARGUMENT, obj, i, i2);
        }

        public void init(AttributedCharacterIterator.Attribute attribute, Object obj, int i, int i2) {
            this.key = attribute;
            this.value = obj;
            this.start = i;
            this.limit = i2;
        }

        public AttributeAndPosition(AttributedCharacterIterator.Attribute attribute, Object obj, int i, int i2) {
            init(attribute, obj, i, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class AppendableWrapper {
        private Appendable app;
        private List<AttributeAndPosition> attributes = null;
        private int length;

        public AppendableWrapper(StringBuilder sb) {
            this.app = sb;
            this.length = sb.length();
        }

        public static int append(Appendable appendable, CharacterIterator characterIterator) {
            try {
                int beginIndex = characterIterator.getBeginIndex();
                int endIndex = characterIterator.getEndIndex();
                int i = endIndex - beginIndex;
                if (beginIndex < endIndex) {
                    appendable.append(characterIterator.first());
                    while (true) {
                        beginIndex++;
                        if (beginIndex >= endIndex) {
                            break;
                        }
                        appendable.append(characterIterator.next());
                    }
                }
                return i;
            } catch (IOException e) {
                kf2.h(e);
                return 0;
            }
        }

        public void formatAndAppend(Format format, Object obj) {
            if (this.attributes == null) {
                append(format.format(obj));
                return;
            }
            AttributedCharacterIterator toCharacterIterator = format.formatToCharacterIterator(obj);
            int i = this.length;
            append(toCharacterIterator);
            toCharacterIterator.first();
            int index = toCharacterIterator.getIndex();
            int endIndex = toCharacterIterator.getEndIndex();
            int i2 = i - index;
            while (index < endIndex) {
                Map<AttributedCharacterIterator.Attribute, Object> attributes = toCharacterIterator.getAttributes();
                int runLimit = toCharacterIterator.getRunLimit();
                if (attributes.size() != 0) {
                    for (Map.Entry<AttributedCharacterIterator.Attribute, Object> entry : attributes.entrySet()) {
                        this.attributes.add(new AttributeAndPosition(entry.getKey(), entry.getValue(), i2 + index, i2 + runLimit));
                    }
                }
                toCharacterIterator.setIndex(runLimit);
                index = runLimit;
            }
        }

        public void useAttributes() {
            this.attributes = new ArrayList();
        }

        public AppendableWrapper(StringBuffer stringBuffer) {
            this.app = stringBuffer;
            this.length = stringBuffer.length();
        }

        public void append(CharSequence charSequence, int i, int i2) {
            try {
                this.app.append(charSequence, i, i2);
                this.length = (i2 - i) + this.length;
            } catch (IOException e) {
                kf2.h(e);
            }
        }

        public void append(CharacterIterator characterIterator) {
            this.length += append(this.app, characterIterator);
        }

        public void append(CharSequence charSequence) {
            try {
                this.app.append(charSequence);
                this.length += charSequence.length();
            } catch (IOException e) {
                kf2.h(e);
            }
        }

        public void formatAndAppend(Format format, Object obj, String str) {
            if (this.attributes == null && str != null) {
                append(str);
            } else {
                formatAndAppend(format, obj);
            }
        }
    }

    public MessageFormat(String str, Locale locale) {
        this(str, ULocale.forLocale(locale));
    }

    public MessageFormat(String str, ULocale uLocale) {
        this.ulocale = uLocale;
        applyPattern(str);
    }

    public void setLocale(Locale locale) {
        setLocale(ULocale.forLocale(locale));
    }

    public void applyPattern(String str) {
        try {
            MessagePattern messagePattern = this.msgPattern;
            if (messagePattern == null) {
                this.msgPattern = new MessagePattern(str);
            } else {
                messagePattern.parse(str);
            }
            cacheExplicitFormats();
        } catch (RuntimeException e) {
            resetPattern();
            throw e;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class PluralSelectorContext {
        String argName;
        boolean forReplaceNumber;
        Format formatter;
        Number number;
        int numberArgIndex;
        String numberString;
        double offset;
        int startIndex;

        private PluralSelectorContext(int i, String str, Number number, double d) {
            this.startIndex = i;
            this.argName = str;
            if (d == 0.0d) {
                this.number = number;
            } else {
                this.number = Double.valueOf(number.doubleValue() - d);
            }
            this.offset = d;
        }

        public String toString() {
            throw new AssertionError("PluralSelectorContext being formatted, rather than its number");
        }

        public /* synthetic */ PluralSelectorContext(int i, String str, Number number, double d, int i2) {
            this(i, str, number, d);
        }
    }

    public Map<String, Object> parseToMap(String str, ParsePosition parsePosition) {
        HashMap map = new HashMap();
        int index = parsePosition.getIndex();
        parse(0, str, parsePosition, null, map);
        if (parsePosition.getIndex() == index) {
            return null;
        }
        return map;
    }

    public Object[] parse(String str) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Object[] objArr = parse(str, parsePosition);
        if (parsePosition.getIndex() != 0) {
            return objArr;
        }
        throw new ParseException("MessageFormat parse error!", parsePosition.getErrorIndex());
    }

    public Object[] parse(String str, ParsePosition parsePosition) {
        if (!this.msgPattern.hasNamedArguments()) {
            int i = -1;
            int iNextTopLevelArgStart = 0;
            while (true) {
                iNextTopLevelArgStart = nextTopLevelArgStart(iNextTopLevelArgStart);
                if (iNextTopLevelArgStart < 0) {
                    break;
                }
                int value = this.msgPattern.getPart(iNextTopLevelArgStart + 1).getValue();
                if (value > i) {
                    i = value;
                }
            }
            Object[] objArr = new Object[i + 1];
            int index = parsePosition.getIndex();
            parse(0, str, parsePosition, objArr, null);
            if (parsePosition.getIndex() == index) {
                return null;
            }
            return objArr;
        }
        og.i("This method is not available in MessageFormat objects that use named argument.");
        return null;
    }

    public final StringBuffer format(Map<String, ?> map, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        format(null, map, new AppendableWrapper(stringBuffer), fieldPosition);
        return stringBuffer;
    }

    public static String format(String str, Object... objArr) {
        return new MessageFormat(str).format(objArr);
    }

    public static String format(String str, Map<String, ?> map) {
        return new MessageFormat(str).format(map);
    }

    @Override // java.text.Format
    public final StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        format(obj, new AppendableWrapper(stringBuffer), fieldPosition);
        return stringBuffer;
    }

    public final StringBuffer format(Object[] objArr, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        format(objArr, null, new AppendableWrapper(stringBuffer), fieldPosition);
        return stringBuffer;
    }

    private void format(Object obj, AppendableWrapper appendableWrapper, FieldPosition fieldPosition) {
        if (obj != null && !(obj instanceof Map)) {
            format((Object[]) obj, null, appendableWrapper, fieldPosition);
        } else {
            format(null, (Map) obj, appendableWrapper, fieldPosition);
        }
    }

    private void format(Object[] objArr, Map<String, ?> map, AppendableWrapper appendableWrapper, FieldPosition fieldPosition) {
        if (objArr != null && this.msgPattern.hasNamedArguments()) {
            og.i("This method is not available in MessageFormat objects that use alphanumeric argument names.");
        } else {
            format(0, null, objArr, map, appendableWrapper, fieldPosition);
        }
    }
}
