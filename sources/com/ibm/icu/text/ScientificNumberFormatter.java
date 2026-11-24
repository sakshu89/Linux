package com.ibm.icu.text;

import com.ibm.icu.impl.StaticUnicodeSets;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.util.ULocale;
import defpackage.dk0;
import java.text.AttributedCharacterIterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ScientificNumberFormatter {
    private static final Style SUPER_SCRIPT = new SuperscriptStyle(0);
    private final DecimalFormat fmt;
    private final String preExponent;
    private final Style style;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class MarkupStyle extends Style {
        private final String beginMarkup;
        private final String endMarkup;

        public MarkupStyle(String str, String str2) {
            super(0);
            this.beginMarkup = str;
            this.endMarkup = str2;
        }

        @Override // com.ibm.icu.text.ScientificNumberFormatter.Style
        public String format(AttributedCharacterIterator attributedCharacterIterator, String str) {
            StringBuilder sb = new StringBuilder();
            attributedCharacterIterator.first();
            int runLimit = 0;
            while (attributedCharacterIterator.current() != 65535) {
                Map<AttributedCharacterIterator.Attribute, Object> attributes = attributedCharacterIterator.getAttributes();
                NumberFormat.Field field = NumberFormat.Field.EXPONENT_SYMBOL;
                if (attributes.containsKey(field)) {
                    Style.append(attributedCharacterIterator, runLimit, attributedCharacterIterator.getRunStart(field), sb);
                    runLimit = attributedCharacterIterator.getRunLimit(field);
                    attributedCharacterIterator.setIndex(runLimit);
                    sb.append(str);
                    sb.append(this.beginMarkup);
                } else {
                    NumberFormat.Field field2 = NumberFormat.Field.EXPONENT;
                    if (attributes.containsKey(field2)) {
                        int runLimit2 = attributedCharacterIterator.getRunLimit(field2);
                        Style.append(attributedCharacterIterator, runLimit, runLimit2, sb);
                        attributedCharacterIterator.setIndex(runLimit2);
                        sb.append(this.endMarkup);
                        runLimit = runLimit2;
                    } else {
                        attributedCharacterIterator.next();
                    }
                }
            }
            Style.append(attributedCharacterIterator, runLimit, attributedCharacterIterator.getEndIndex(), sb);
            return sb.toString();
        }
    }

    private ScientificNumberFormatter(DecimalFormat decimalFormat, String str, Style style) {
        this.fmt = decimalFormat;
        this.preExponent = str;
        this.style = style;
    }

    private static ScientificNumberFormatter getInstance(DecimalFormat decimalFormat, Style style) {
        return new ScientificNumberFormatter(decimalFormat.clone(), getPreExponent(decimalFormat.getDecimalFormatSymbols()), style);
    }

    private static ScientificNumberFormatter getInstanceForLocale(ULocale uLocale, Style style) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getScientificInstance(uLocale);
        return new ScientificNumberFormatter(decimalFormat, getPreExponent(decimalFormat.getDecimalFormatSymbols()), style);
    }

    public static ScientificNumberFormatter getMarkupInstance(ULocale uLocale, String str, String str2) {
        return getInstanceForLocale(uLocale, new MarkupStyle(str, str2));
    }

    private static String getPreExponent(DecimalFormatSymbols decimalFormatSymbols) {
        StringBuilder sb = new StringBuilder();
        sb.append(decimalFormatSymbols.getExponentMultiplicationSign());
        char[] digits = decimalFormatSymbols.getDigits();
        sb.append(digits[1]);
        sb.append(digits[0]);
        return sb.toString();
    }

    public static ScientificNumberFormatter getSuperscriptInstance(ULocale uLocale) {
        return getInstanceForLocale(uLocale, SUPER_SCRIPT);
    }

    public String format(Object obj) {
        String str;
        synchronized (this.fmt) {
            str = this.style.format(this.fmt.formatToCharacterIterator(obj), this.preExponent);
        }
        return str;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class Style {
        public /* synthetic */ Style(int i) {
            this();
        }

        public static void append(AttributedCharacterIterator attributedCharacterIterator, int i, int i2, StringBuilder sb) {
            int index = attributedCharacterIterator.getIndex();
            attributedCharacterIterator.setIndex(i);
            while (i < i2) {
                sb.append(attributedCharacterIterator.current());
                attributedCharacterIterator.next();
                i++;
            }
            attributedCharacterIterator.setIndex(index);
        }

        public abstract String format(AttributedCharacterIterator attributedCharacterIterator, String str);

        private Style() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class SuperscriptStyle extends Style {
        private static final char[] SUPERSCRIPT_DIGITS = {8304, 185, 178, 179, 8308, 8309, 8310, 8311, 8312, 8313};
        private static final char SUPERSCRIPT_MINUS_SIGN = 8315;
        private static final char SUPERSCRIPT_PLUS_SIGN = 8314;

        private SuperscriptStyle() {
            super(0);
        }

        private static int char32AtAndAdvance(AttributedCharacterIterator attributedCharacterIterator) {
            char cCurrent = attributedCharacterIterator.current();
            char next = attributedCharacterIterator.next();
            if (!UCharacter.isHighSurrogate(cCurrent) || !UCharacter.isLowSurrogate(next)) {
                return cCurrent;
            }
            attributedCharacterIterator.next();
            return UCharacter.toCodePoint(cCurrent, next);
        }

        private static void copyAsSuperscript(AttributedCharacterIterator attributedCharacterIterator, int i, int i2, StringBuilder sb) {
            int index = attributedCharacterIterator.getIndex();
            attributedCharacterIterator.setIndex(i);
            while (attributedCharacterIterator.getIndex() < i2) {
                int iDigit = UCharacter.digit(char32AtAndAdvance(attributedCharacterIterator));
                if (iDigit < 0) {
                    dk0.v();
                    return;
                }
                sb.append(SUPERSCRIPT_DIGITS[iDigit]);
            }
            attributedCharacterIterator.setIndex(index);
        }

        @Override // com.ibm.icu.text.ScientificNumberFormatter.Style
        public String format(AttributedCharacterIterator attributedCharacterIterator, String str) {
            int runLimit;
            StringBuilder sb = new StringBuilder();
            attributedCharacterIterator.first();
            int runLimit2 = 0;
            while (attributedCharacterIterator.current() != 65535) {
                Map<AttributedCharacterIterator.Attribute, Object> attributes = attributedCharacterIterator.getAttributes();
                NumberFormat.Field field = NumberFormat.Field.EXPONENT_SYMBOL;
                if (attributes.containsKey(field)) {
                    Style.append(attributedCharacterIterator, runLimit2, attributedCharacterIterator.getRunStart(field), sb);
                    runLimit2 = attributedCharacterIterator.getRunLimit(field);
                    attributedCharacterIterator.setIndex(runLimit2);
                    sb.append(str);
                } else {
                    NumberFormat.Field field2 = NumberFormat.Field.EXPONENT_SIGN;
                    if (attributes.containsKey(field2)) {
                        int runStart = attributedCharacterIterator.getRunStart(field2);
                        runLimit = attributedCharacterIterator.getRunLimit(field2);
                        int iChar32AtAndAdvance = char32AtAndAdvance(attributedCharacterIterator);
                        if (StaticUnicodeSets.get(StaticUnicodeSets.Key.MINUS_SIGN).contains(iChar32AtAndAdvance)) {
                            Style.append(attributedCharacterIterator, runLimit2, runStart, sb);
                            sb.append(SUPERSCRIPT_MINUS_SIGN);
                        } else {
                            if (!StaticUnicodeSets.get(StaticUnicodeSets.Key.PLUS_SIGN).contains(iChar32AtAndAdvance)) {
                                dk0.v();
                                return null;
                            }
                            Style.append(attributedCharacterIterator, runLimit2, runStart, sb);
                            sb.append(SUPERSCRIPT_PLUS_SIGN);
                        }
                        attributedCharacterIterator.setIndex(runLimit);
                    } else {
                        NumberFormat.Field field3 = NumberFormat.Field.EXPONENT;
                        if (attributes.containsKey(field3)) {
                            int runStart2 = attributedCharacterIterator.getRunStart(field3);
                            runLimit = attributedCharacterIterator.getRunLimit(field3);
                            Style.append(attributedCharacterIterator, runLimit2, runStart2, sb);
                            copyAsSuperscript(attributedCharacterIterator, runStart2, runLimit, sb);
                            attributedCharacterIterator.setIndex(runLimit);
                        } else {
                            attributedCharacterIterator.next();
                        }
                    }
                    runLimit2 = runLimit;
                }
            }
            Style.append(attributedCharacterIterator, runLimit2, attributedCharacterIterator.getEndIndex(), sb);
            return sb.toString();
        }

        public /* synthetic */ SuperscriptStyle(int i) {
            this();
        }
    }

    public static ScientificNumberFormatter getSuperscriptInstance(DecimalFormat decimalFormat) {
        return getInstance(decimalFormat, SUPER_SCRIPT);
    }

    public static ScientificNumberFormatter getMarkupInstance(DecimalFormat decimalFormat, String str, String str2) {
        return getInstance(decimalFormat, new MarkupStyle(str, str2));
    }
}
