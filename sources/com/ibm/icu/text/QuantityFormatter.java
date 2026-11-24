package com.ibm.icu.text;

import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.impl.StandardPlural;
import java.text.FieldPosition;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class QuantityFormatter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SimpleFormatter[] templates = new SimpleFormatter[StandardPlural.COUNT];

    public static StringBuilder format(String str, CharSequence charSequence, StringBuilder sb, FieldPosition fieldPosition) {
        int[] iArr = new int[1];
        SimpleFormatterImpl.formatAndAppend(str, sb, iArr, charSequence);
        if (fieldPosition.getBeginIndex() == 0 && fieldPosition.getEndIndex() == 0) {
            return sb;
        }
        if (iArr[0] >= 0) {
            fieldPosition.setBeginIndex(fieldPosition.getBeginIndex() + iArr[0]);
            fieldPosition.setEndIndex(fieldPosition.getEndIndex() + iArr[0]);
            return sb;
        }
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        return sb;
    }

    public static StandardPlural selectPlural(double d, NumberFormat numberFormat, PluralRules pluralRules) {
        return StandardPlural.orOtherFromString(numberFormat instanceof DecimalFormat ? pluralRules.select(((DecimalFormat) numberFormat).getFixedDecimal(d)) : pluralRules.select(d));
    }

    public void addIfAbsent(CharSequence charSequence, String str) {
        int iIndexFromString = StandardPlural.indexFromString(charSequence);
        SimpleFormatter[] simpleFormatterArr = this.templates;
        if (simpleFormatterArr[iIndexFromString] != null) {
            return;
        }
        simpleFormatterArr[iIndexFromString] = SimpleFormatter.compileMinMaxArguments(str, 0, 1);
    }

    public SimpleFormatter getByVariant(CharSequence charSequence) {
        int i;
        int iIndexOrOtherIndexFromString = StandardPlural.indexOrOtherIndexFromString(charSequence);
        SimpleFormatter[] simpleFormatterArr = this.templates;
        SimpleFormatter simpleFormatter = simpleFormatterArr[iIndexOrOtherIndexFromString];
        return (simpleFormatter != null || iIndexOrOtherIndexFromString == (i = StandardPlural.OTHER_INDEX)) ? simpleFormatter : simpleFormatterArr[i];
    }

    public boolean isValid() {
        return this.templates[StandardPlural.OTHER_INDEX] != null;
    }

    public String format(double d, NumberFormat numberFormat, PluralRules pluralRules) {
        String str = numberFormat.format(d);
        SimpleFormatter simpleFormatter = this.templates[selectPlural(d, numberFormat, pluralRules).ordinal()];
        if (simpleFormatter == null) {
            simpleFormatter = this.templates[StandardPlural.OTHER_INDEX];
        }
        return simpleFormatter.format(str);
    }
}
