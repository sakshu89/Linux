package com.ibm.icu.text;

import com.ibm.icu.number.FormattedNumber;
import com.ibm.icu.number.LocalizedNumberFormatter;
import com.ibm.icu.util.ULocale;
import defpackage.cq;
import defpackage.og;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class PluralFormat extends UFormat {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 1;
    private transient MessagePattern msgPattern;
    private NumberFormat numberFormat;
    private transient double offset;
    private Map<String, String> parsedValues;
    private String pattern;
    private PluralRules pluralRules;
    private transient PluralSelectorAdapter pluralRulesWrapper;
    private ULocale ulocale;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface PluralSelector {
        String select(Object obj, double d);
    }

    public PluralFormat(String str) {
        this.ulocale = null;
        this.pluralRules = null;
        this.pattern = null;
        this.parsedValues = null;
        this.numberFormat = null;
        this.offset = 0.0d;
        this.pluralRulesWrapper = new PluralSelectorAdapter(this, 0);
        init(null, PluralRules.PluralType.CARDINAL, ULocale.getDefault(ULocale.Category.FORMAT), null);
        applyPattern(str);
    }

    public static int findSubMessage(MessagePattern messagePattern, int i, PluralSelector pluralSelector, Object obj, double d) {
        double numericValue;
        int iCountParts = messagePattern.countParts();
        MessagePattern.Part part = messagePattern.getPart(i);
        if (part.getType().hasNumericValue()) {
            numericValue = messagePattern.getNumericValue(part);
            i++;
        } else {
            numericValue = 0.0d;
        }
        boolean z = false;
        String strSelect = null;
        int i2 = 0;
        do {
            int i3 = i + 1;
            MessagePattern.Part part2 = messagePattern.getPart(i);
            if (part2.getType() == MessagePattern.Part.Type.ARG_LIMIT) {
                return i2;
            }
            if (messagePattern.getPartType(i3).hasNumericValue()) {
                int i4 = i + 2;
                if (d == messagePattern.getNumericValue(messagePattern.getPart(i3))) {
                    return i4;
                }
                i3 = i4;
            } else {
                if (!z) {
                    if (!messagePattern.partSubstringMatches(part2, PluralRules.KEYWORD_OTHER)) {
                        if (strSelect == null) {
                            strSelect = pluralSelector.select(obj, d - numericValue);
                            if (i2 != 0 && strSelect.equals(PluralRules.KEYWORD_OTHER)) {
                                z = true;
                            }
                        }
                        if (!z && messagePattern.partSubstringMatches(part2, strSelect)) {
                            i2 = i3;
                            z = true;
                        }
                    } else if (i2 == 0) {
                        if (strSelect == null || !strSelect.equals(PluralRules.KEYWORD_OTHER)) {
                            i2 = i3;
                        } else {
                            i2 = i3;
                            z = true;
                        }
                    }
                }
                i = messagePattern.getLimitPartIndex(i3) + 1;
            }
            i = messagePattern.getLimitPartIndex(i3) + 1;
        } while (i < iCountParts);
        return i2;
    }

    private String format(Number number, double d) {
        PluralRules.IFixedDecimal fixedDecimal;
        String string;
        int index;
        MessagePattern messagePattern = this.msgPattern;
        if (messagePattern == null || messagePattern.countParts() == 0) {
            return this.numberFormat.format(number);
        }
        double d2 = this.offset;
        double d3 = d - d2;
        NumberFormat numberFormat = this.numberFormat;
        if (numberFormat == null) {
            fixedDecimal = new PluralRules.FixedDecimal(d3);
            string = "";
        } else if (numberFormat instanceof DecimalFormat) {
            LocalizedNumberFormatter numberFormatter = ((DecimalFormat) numberFormat).toNumberFormatter();
            FormattedNumber formattedNumber = this.offset == 0.0d ? numberFormatter.format(number) : numberFormatter.format(d3);
            string = formattedNumber.toString();
            fixedDecimal = formattedNumber.getFixedDecimal();
        } else {
            string = d2 == 0.0d ? numberFormat.format(number) : numberFormat.format(d3);
            fixedDecimal = new PluralRules.FixedDecimal(d3);
        }
        int iFindSubMessage = findSubMessage(this.msgPattern, 0, this.pluralRulesWrapper, fixedDecimal, d);
        int limit = this.msgPattern.getPart(iFindSubMessage).getLimit();
        StringBuilder sb = null;
        while (true) {
            iFindSubMessage++;
            MessagePattern.Part part = this.msgPattern.getPart(iFindSubMessage);
            MessagePattern.Part.Type type = part.getType();
            index = part.getIndex();
            if (type == MessagePattern.Part.Type.MSG_LIMIT) {
                break;
            }
            MessagePattern.Part.Type type2 = MessagePattern.Part.Type.REPLACE_NUMBER;
            if (type == type2 || (type == MessagePattern.Part.Type.SKIP_SYNTAX && this.msgPattern.jdkAposMode())) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) this.pattern, limit, index);
                if (type == type2) {
                    sb.append(string);
                }
                limit = part.getLimit();
            } else if (type == MessagePattern.Part.Type.ARG_START) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) this.pattern, limit, index);
                iFindSubMessage = this.msgPattern.getLimitPartIndex(iFindSubMessage);
                limit = this.msgPattern.getPart(iFindSubMessage).getLimit();
                MessagePattern.appendReducedApostrophes(this.pattern, index, limit, sb);
            }
        }
        String str = this.pattern;
        if (sb == null) {
            return str.substring(limit, index);
        }
        sb.append((CharSequence) str, limit, index);
        return sb.toString();
    }

    private void init(PluralRules pluralRules, PluralRules.PluralType pluralType, ULocale uLocale, NumberFormat numberFormat) {
        this.ulocale = uLocale;
        if (pluralRules == null) {
            pluralRules = PluralRules.forLocale(uLocale, pluralType);
        }
        this.pluralRules = pluralRules;
        resetPattern();
        this.numberFormat = numberFormat;
        initializeNumberFormat();
    }

    private void initializeNumberFormat() {
        String str;
        if (this.numberFormat == null) {
            MessagePattern messagePattern = this.msgPattern;
            if (messagePattern == null || messagePattern.countParts() == 0 || ((str = this.pattern) != null && str.indexOf(35) >= 0)) {
                this.numberFormat = NumberFormat.getInstance(this.ulocale);
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.pluralRulesWrapper = new PluralSelectorAdapter(this, 0);
        this.parsedValues = null;
        String str = this.pattern;
        if (str != null) {
            applyPattern(str);
        }
    }

    private void resetPattern() {
        this.pattern = null;
        MessagePattern messagePattern = this.msgPattern;
        if (messagePattern != null) {
            messagePattern.clear();
        }
        this.offset = 0.0d;
    }

    public void applyPattern(String str) {
        this.pattern = str;
        if (this.msgPattern == null) {
            this.msgPattern = new MessagePattern();
        }
        try {
            this.msgPattern.parsePluralStyle(str);
            this.offset = this.msgPattern.getPluralOffset(0);
            initializeNumberFormat();
        } catch (RuntimeException e) {
            resetPattern();
            throw e;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PluralFormat pluralFormat = (PluralFormat) obj;
            if (Objects.equals(this.ulocale, pluralFormat.ulocale) && Objects.equals(this.pluralRules, pluralFormat.pluralRules) && Objects.equals(this.msgPattern, pluralFormat.msgPattern) && Objects.equals(this.numberFormat, pluralFormat.numberFormat)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.parsedValues.hashCode() ^ this.pluralRules.hashCode();
    }

    public Number parse(String str, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }

    public String parseType(String str, FieldPosition fieldPosition) {
        MessagePattern messagePattern = this.msgPattern;
        if (messagePattern == null || messagePattern.countParts() == 0) {
            fieldPosition.setBeginIndex(-1);
            fieldPosition.setEndIndex(-1);
            return null;
        }
        int iCountParts = this.msgPattern.countParts();
        int beginIndex = fieldPosition.getBeginIndex();
        int i = 0;
        if (beginIndex < 0) {
            beginIndex = 0;
        }
        int i2 = -1;
        String strSubstring = null;
        String str2 = null;
        while (i < iCountParts) {
            int i3 = i + 1;
            if (this.msgPattern.getPart(i).getType() != MessagePattern.Part.Type.ARG_SELECTOR) {
                i = i3;
            } else {
                int i4 = i + 2;
                MessagePattern.Part part = this.msgPattern.getPart(i3);
                if (part.getType() != MessagePattern.Part.Type.MSG_START) {
                    i = i4;
                } else {
                    i += 3;
                    MessagePattern.Part part2 = this.msgPattern.getPart(i4);
                    if (part2.getType() == MessagePattern.Part.Type.MSG_LIMIT) {
                        String strSubstring2 = this.pattern.substring(part.getLimit(), part2.getIndex());
                        int iIndexOf = str.indexOf(strSubstring2, beginIndex);
                        if (iIndexOf >= 0 && iIndexOf >= i2) {
                            if (str2 == null || strSubstring2.length() > str2.length()) {
                                strSubstring = this.pattern.substring(part.getLimit(), part2.getIndex());
                                str2 = strSubstring2;
                                i2 = iIndexOf;
                            }
                        }
                    }
                }
            }
        }
        if (strSubstring != null) {
            fieldPosition.setBeginIndex(i2);
            fieldPosition.setEndIndex(str2.length() + i2);
            return strSubstring;
        }
        fieldPosition.setBeginIndex(-1);
        fieldPosition.setEndIndex(-1);
        return null;
    }

    @Deprecated
    public void setLocale(ULocale uLocale) {
        if (uLocale == null) {
            uLocale = ULocale.getDefault(ULocale.Category.FORMAT);
        }
        init(null, PluralRules.PluralType.CARDINAL, uLocale, null);
    }

    public void setNumberFormat(NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
    }

    public String toPattern() {
        return this.pattern;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("locale=".concat(String.valueOf(this.ulocale)));
        sb.append(", rules='" + String.valueOf(this.pluralRules) + "'");
        sb.append(", pattern='" + this.pattern + "'");
        sb.append(", format='" + String.valueOf(this.numberFormat) + "'");
        return sb.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public final class PluralSelectorAdapter implements PluralSelector {
        private PluralSelectorAdapter() {
        }

        @Override // com.ibm.icu.text.PluralFormat.PluralSelector
        public String select(Object obj, double d) {
            return PluralFormat.this.pluralRules.select((PluralRules.IFixedDecimal) obj);
        }

        public /* synthetic */ PluralSelectorAdapter(PluralFormat pluralFormat, int i) {
            this();
        }
    }

    public PluralFormat(ULocale uLocale) {
        this.ulocale = null;
        this.pluralRules = null;
        this.pattern = null;
        this.parsedValues = null;
        this.numberFormat = null;
        this.offset = 0.0d;
        this.pluralRulesWrapper = new PluralSelectorAdapter(this, 0);
        init(null, PluralRules.PluralType.CARDINAL, uLocale, null);
    }

    public PluralFormat(Locale locale) {
        this(ULocale.forLocale(locale));
    }

    public PluralFormat(PluralRules pluralRules) {
        this.ulocale = null;
        this.pluralRules = null;
        this.pattern = null;
        this.parsedValues = null;
        this.numberFormat = null;
        this.offset = 0.0d;
        this.pluralRulesWrapper = new PluralSelectorAdapter(this, 0);
        init(pluralRules, PluralRules.PluralType.CARDINAL, ULocale.getDefault(ULocale.Category.FORMAT), null);
    }

    public PluralFormat(ULocale uLocale, PluralRules pluralRules) {
        this.ulocale = null;
        this.pluralRules = null;
        this.pattern = null;
        this.parsedValues = null;
        this.numberFormat = null;
        this.offset = 0.0d;
        this.pluralRulesWrapper = new PluralSelectorAdapter(this, 0);
        init(pluralRules, PluralRules.PluralType.CARDINAL, uLocale, null);
    }

    public boolean equals(PluralFormat pluralFormat) {
        return equals((Object) pluralFormat);
    }

    public PluralFormat(Locale locale, PluralRules pluralRules) {
        this(ULocale.forLocale(locale), pluralRules);
    }

    public PluralFormat(ULocale uLocale, PluralRules.PluralType pluralType) {
        this.ulocale = null;
        this.pluralRules = null;
        this.pattern = null;
        this.parsedValues = null;
        this.numberFormat = null;
        this.offset = 0.0d;
        this.pluralRulesWrapper = new PluralSelectorAdapter(this, 0);
        init(null, pluralType, uLocale, null);
    }

    public PluralFormat(Locale locale, PluralRules.PluralType pluralType) {
        this(ULocale.forLocale(locale), pluralType);
    }

    public PluralFormat() {
        this.ulocale = null;
        this.pluralRules = null;
        this.pattern = null;
        this.parsedValues = null;
        this.numberFormat = null;
        this.offset = 0.0d;
        this.pluralRulesWrapper = new PluralSelectorAdapter(this, 0);
        init(null, PluralRules.PluralType.CARDINAL, ULocale.getDefault(ULocale.Category.FORMAT), null);
    }

    public PluralFormat(ULocale uLocale, String str) {
        this.ulocale = null;
        this.pluralRules = null;
        this.pattern = null;
        this.parsedValues = null;
        this.numberFormat = null;
        this.offset = 0.0d;
        this.pluralRulesWrapper = new PluralSelectorAdapter(this, 0);
        init(null, PluralRules.PluralType.CARDINAL, uLocale, null);
        applyPattern(str);
    }

    public PluralFormat(PluralRules pluralRules, String str) {
        this.ulocale = null;
        this.pluralRules = null;
        this.pattern = null;
        this.parsedValues = null;
        this.numberFormat = null;
        this.offset = 0.0d;
        this.pluralRulesWrapper = new PluralSelectorAdapter(this, 0);
        init(pluralRules, PluralRules.PluralType.CARDINAL, ULocale.getDefault(ULocale.Category.FORMAT), null);
        applyPattern(str);
    }

    public PluralFormat(ULocale uLocale, PluralRules pluralRules, String str) {
        this.ulocale = null;
        this.pluralRules = null;
        this.pattern = null;
        this.parsedValues = null;
        this.numberFormat = null;
        this.offset = 0.0d;
        this.pluralRulesWrapper = new PluralSelectorAdapter(this, 0);
        init(pluralRules, PluralRules.PluralType.CARDINAL, uLocale, null);
        applyPattern(str);
    }

    public PluralFormat(ULocale uLocale, PluralRules.PluralType pluralType, String str) {
        this.ulocale = null;
        this.pluralRules = null;
        this.pattern = null;
        this.parsedValues = null;
        this.numberFormat = null;
        this.offset = 0.0d;
        this.pluralRulesWrapper = new PluralSelectorAdapter(this, 0);
        init(null, pluralType, uLocale, null);
        applyPattern(str);
    }

    public PluralFormat(ULocale uLocale, PluralRules.PluralType pluralType, String str, NumberFormat numberFormat) {
        this.ulocale = null;
        this.pluralRules = null;
        this.pattern = null;
        this.parsedValues = null;
        this.numberFormat = null;
        this.offset = 0.0d;
        this.pluralRulesWrapper = new PluralSelectorAdapter(this, 0);
        init(null, pluralType, uLocale, numberFormat);
        applyPattern(str);
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Number) {
            Number number = (Number) obj;
            stringBuffer.append(format(number, number.doubleValue()));
            return stringBuffer;
        }
        og.i(cq.v("'", String.valueOf(obj), "' is not a Number"));
        return null;
    }

    public final String format(double d) {
        return format(Double.valueOf(d), d);
    }
}
