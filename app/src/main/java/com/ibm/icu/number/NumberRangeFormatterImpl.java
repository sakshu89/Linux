package com.ibm.icu.number;

import com.ibm.icu.impl.FormattedStringBuilder;
import com.ibm.icu.impl.FormattedValueStringBuilderImpl;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.impl.number.DecimalQuantity;
import com.ibm.icu.impl.number.MacroProps;
import com.ibm.icu.impl.number.MicroProps;
import com.ibm.icu.impl.number.Modifier;
import com.ibm.icu.impl.number.SimpleModifier;
import com.ibm.icu.impl.number.range.PrefixInfixSuffixLengthHelper;
import com.ibm.icu.impl.number.range.RangeMacroProps;
import com.ibm.icu.impl.number.range.StandardPluralRanges;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.og;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class NumberRangeFormatterImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final NumberFormatterImpl fApproximatelyFormatter;
    final NumberRangeFormatter.RangeCollapse fCollapse;
    final NumberRangeFormatter.RangeIdentityFallback fIdentityFallback;
    final StandardPluralRanges fPluralRanges;
    String fRangePattern;
    final boolean fSameFormatters;
    final NumberFormatterImpl formatterImpl1;
    final NumberFormatterImpl formatterImpl2;

    /* JADX INFO: renamed from: com.ibm.icu.number.NumberRangeFormatterImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$number$NumberRangeFormatter$RangeCollapse;

        static {
            int[] iArr = new int[NumberRangeFormatter.RangeCollapse.values().length];
            $SwitchMap$com$ibm$icu$number$NumberRangeFormatter$RangeCollapse = iArr;
            try {
                iArr[NumberRangeFormatter.RangeCollapse.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberRangeFormatter$RangeCollapse[NumberRangeFormatter.RangeCollapse.AUTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$number$NumberRangeFormatter$RangeCollapse[NumberRangeFormatter.RangeCollapse.UNIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NumberRangeDataSink extends UResource.Sink {
        String rangePattern;
        StringBuilder sb;

        public NumberRangeDataSink(StringBuilder sb) {
            this.sb = sb;
        }

        private boolean hasRangeData() {
            return this.rangePattern != null;
        }

        public void fillInDefaults() {
            if (hasRangeData()) {
                return;
            }
            this.rangePattern = SimpleFormatterImpl.compileToStringMinMaxArguments("{0}–{1}", this.sb, 2, 2);
        }

        public boolean isComplete() {
            return hasRangeData();
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (key.contentEquals("range") && !hasRangeData()) {
                    this.rangePattern = SimpleFormatterImpl.compileToStringMinMaxArguments(value.getString(), this.sb, 2, 2);
                }
            }
        }
    }

    public NumberRangeFormatterImpl(RangeMacroProps rangeMacroProps) {
        UnlocalizedNumberFormatter unlocalizedNumberFormatter = rangeMacroProps.formatter1;
        ULocale uLocale = rangeMacroProps.loc;
        LocalizedNumberFormatter localizedNumberFormatterLocale = unlocalizedNumberFormatter != null ? unlocalizedNumberFormatter.locale(uLocale) : NumberFormatter.withLocale(uLocale);
        UnlocalizedNumberFormatter unlocalizedNumberFormatter2 = rangeMacroProps.formatter2;
        ULocale uLocale2 = rangeMacroProps.loc;
        LocalizedNumberFormatter localizedNumberFormatterLocale2 = unlocalizedNumberFormatter2 != null ? unlocalizedNumberFormatter2.locale(uLocale2) : NumberFormatter.withLocale(uLocale2);
        NumberFormatterImpl numberFormatterImpl = new NumberFormatterImpl(localizedNumberFormatterLocale.resolve());
        this.formatterImpl1 = numberFormatterImpl;
        NumberFormatterImpl numberFormatterImpl2 = new NumberFormatterImpl(localizedNumberFormatterLocale2.resolve());
        this.formatterImpl2 = numberFormatterImpl2;
        boolean z = rangeMacroProps.sameFormatters != 0;
        this.fSameFormatters = z;
        NumberRangeFormatter.RangeCollapse rangeCollapse = rangeMacroProps.collapse;
        this.fCollapse = rangeCollapse == null ? NumberRangeFormatter.RangeCollapse.AUTO : rangeCollapse;
        NumberRangeFormatter.RangeIdentityFallback rangeIdentityFallback = rangeMacroProps.identityFallback;
        rangeIdentityFallback = rangeIdentityFallback == null ? NumberRangeFormatter.RangeIdentityFallback.APPROXIMATELY : rangeIdentityFallback;
        this.fIdentityFallback = rangeIdentityFallback;
        String str = numberFormatterImpl.getRawMicroProps().nsName;
        if (str == null || !(z || str.equals(numberFormatterImpl2.getRawMicroProps().nsName))) {
            og.i("Both formatters must have same numbering system");
            throw null;
        }
        getNumberRangeData(rangeMacroProps.loc, str, this);
        if (z && (rangeIdentityFallback == NumberRangeFormatter.RangeIdentityFallback.APPROXIMATELY || rangeIdentityFallback == NumberRangeFormatter.RangeIdentityFallback.APPROXIMATELY_OR_SINGLE_VALUE)) {
            MacroProps macroProps = new MacroProps();
            macroProps.approximately = Boolean.TRUE;
            this.fApproximatelyFormatter = new NumberFormatterImpl(localizedNumberFormatterLocale.macros(macroProps).resolve());
        } else {
            this.fApproximatelyFormatter = null;
        }
        this.fPluralRanges = StandardPluralRanges.forLocale(rangeMacroProps.loc);
    }

    private void formatApproximately(DecimalQuantity decimalQuantity, DecimalQuantity decimalQuantity2, DecimalQuantity decimalQuantity3, FormattedStringBuilder formattedStringBuilder, MicroProps microProps, MicroProps microProps2) {
        if (!this.fSameFormatters) {
            formatRange(decimalQuantity2, decimalQuantity3, formattedStringBuilder, microProps, microProps2);
            return;
        }
        MicroProps microPropsPreProcess = this.fApproximatelyFormatter.preProcess(decimalQuantity);
        int iWriteNumber = NumberFormatterImpl.writeNumber(microPropsPreProcess, decimalQuantity, formattedStringBuilder, 0);
        int iApply = microPropsPreProcess.modInner.apply(formattedStringBuilder, 0, iWriteNumber) + iWriteNumber;
        microPropsPreProcess.modOuter.apply(formattedStringBuilder, 0, microPropsPreProcess.modMiddle.apply(formattedStringBuilder, 0, iApply) + iApply);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002e A[PHI: r3
      0x002e: PHI (r3v5 boolean) = (r3v2 boolean), (r3v3 boolean), (r3v3 boolean) binds: [B:14:0x002c, B:28:0x0055, B:30:0x005b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:38:0x007d  */
    /* JADX WARN: Code duplicated, block: B:43:0x008a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0097  */
    /* JADX WARN: Code duplicated, block: B:52:0x009e  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:60:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:61:0x0127  */
    /* JADX WARN: Code duplicated, block: B:63:0x014f  */
    /* JADX WARN: Code duplicated, block: B:64:0x017b  */
    /* JADX WARN: Code duplicated, block: B:66:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:67:0x01cf  */
    private void formatRange(DecimalQuantity decimalQuantity, DecimalQuantity decimalQuantity2, FormattedStringBuilder formattedStringBuilder, MicroProps microProps, MicroProps microProps2) {
        boolean zSemanticallyEquivalent;
        boolean zSemanticallyEquivalent2;
        boolean zSemanticallyEquivalent3;
        PrefixInfixSuffixLengthHelper prefixInfixSuffixLengthHelper;
        boolean z;
        boolean z2;
        boolean z3;
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$number$NumberRangeFormatter$RangeCollapse[this.fCollapse.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            zSemanticallyEquivalent = microProps.modOuter.semanticallyEquivalent(microProps2.modOuter);
            if (zSemanticallyEquivalent) {
                zSemanticallyEquivalent2 = microProps.modMiddle.semanticallyEquivalent(microProps2.modMiddle);
                if (zSemanticallyEquivalent2) {
                    Modifier modifier = microProps.modMiddle;
                    NumberRangeFormatter.RangeCollapse rangeCollapse = this.fCollapse;
                    if (rangeCollapse != NumberRangeFormatter.RangeCollapse.UNIT ? !(rangeCollapse != NumberRangeFormatter.RangeCollapse.AUTO || modifier.getCodePointCount() > 1) : !(modifier.containsField(NumberFormat.Field.CURRENCY) || modifier.containsField(NumberFormat.Field.PERCENT))) {
                        zSemanticallyEquivalent2 = false;
                    }
                    if (zSemanticallyEquivalent2 && this.fCollapse == NumberRangeFormatter.RangeCollapse.ALL) {
                        zSemanticallyEquivalent3 = microProps.modInner.semanticallyEquivalent(microProps2.modInner);
                    } else {
                        zSemanticallyEquivalent3 = false;
                    }
                } else {
                    zSemanticallyEquivalent3 = false;
                }
            } else {
                zSemanticallyEquivalent2 = false;
            }
            prefixInfixSuffixLengthHelper = new PrefixInfixSuffixLengthHelper();
            SimpleModifier.formatTwoArgPattern(this.fRangePattern, formattedStringBuilder, 0, prefixInfixSuffixLengthHelper, null);
            if (!zSemanticallyEquivalent3 || microProps.modInner.getCodePointCount() <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (!zSemanticallyEquivalent2 || microProps.modMiddle.getCodePointCount() <= 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!zSemanticallyEquivalent || microProps.modOuter.getCodePointCount() <= 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z || z2 || z3) {
                if (!PatternProps.isWhiteSpace(formattedStringBuilder.charAt(prefixInfixSuffixLengthHelper.index1()))) {
                    prefixInfixSuffixLengthHelper.lengthInfix = formattedStringBuilder.insertCodePoint(prefixInfixSuffixLengthHelper.index1(), 32, null) + prefixInfixSuffixLengthHelper.lengthInfix;
                }
                if (!PatternProps.isWhiteSpace(formattedStringBuilder.charAt(prefixInfixSuffixLengthHelper.index2() - 1))) {
                    prefixInfixSuffixLengthHelper.lengthInfix = formattedStringBuilder.insertCodePoint(prefixInfixSuffixLengthHelper.index2(), 32, null) + prefixInfixSuffixLengthHelper.lengthInfix;
                }
            }
            prefixInfixSuffixLengthHelper.length1 += NumberFormatterImpl.writeNumber(microProps, decimalQuantity, formattedStringBuilder, prefixInfixSuffixLengthHelper.index0());
            FormattedStringBuilder formattedStringBuilder2 = new FormattedStringBuilder();
            NumberFormatterImpl.writeNumber(microProps2, decimalQuantity2, formattedStringBuilder2, 0);
            prefixInfixSuffixLengthHelper.length2 = formattedStringBuilder.insert(prefixInfixSuffixLengthHelper.index2(), formattedStringBuilder2) + prefixInfixSuffixLengthHelper.length2;
            if (zSemanticallyEquivalent3) {
                Modifier modifierResolveModifierPlurals = resolveModifierPlurals(microProps.modInner, microProps2.modInner);
                prefixInfixSuffixLengthHelper.lengthSuffix = modifierResolveModifierPlurals.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index0(), prefixInfixSuffixLengthHelper.index4()) + prefixInfixSuffixLengthHelper.lengthSuffix;
                prefixInfixSuffixLengthHelper.lengthPrefix = modifierResolveModifierPlurals.getPrefixLength() + prefixInfixSuffixLengthHelper.lengthPrefix;
                prefixInfixSuffixLengthHelper.lengthSuffix -= modifierResolveModifierPlurals.getPrefixLength();
            } else {
                prefixInfixSuffixLengthHelper.length1 = microProps.modInner.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index0(), prefixInfixSuffixLengthHelper.index1()) + prefixInfixSuffixLengthHelper.length1;
                prefixInfixSuffixLengthHelper.length2 = microProps2.modInner.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index2(), prefixInfixSuffixLengthHelper.index4()) + prefixInfixSuffixLengthHelper.length2;
            }
            if (zSemanticallyEquivalent2) {
                Modifier modifierResolveModifierPlurals2 = resolveModifierPlurals(microProps.modMiddle, microProps2.modMiddle);
                prefixInfixSuffixLengthHelper.lengthSuffix = modifierResolveModifierPlurals2.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index0(), prefixInfixSuffixLengthHelper.index4()) + prefixInfixSuffixLengthHelper.lengthSuffix;
                prefixInfixSuffixLengthHelper.lengthPrefix = modifierResolveModifierPlurals2.getPrefixLength() + prefixInfixSuffixLengthHelper.lengthPrefix;
                prefixInfixSuffixLengthHelper.lengthSuffix -= modifierResolveModifierPlurals2.getPrefixLength();
            } else {
                prefixInfixSuffixLengthHelper.length1 = microProps.modMiddle.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index0(), prefixInfixSuffixLengthHelper.index1()) + prefixInfixSuffixLengthHelper.length1;
                prefixInfixSuffixLengthHelper.length2 = microProps2.modMiddle.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index2(), prefixInfixSuffixLengthHelper.index4()) + prefixInfixSuffixLengthHelper.length2;
            }
            if (zSemanticallyEquivalent) {
                Modifier modifierResolveModifierPlurals3 = resolveModifierPlurals(microProps.modOuter, microProps2.modOuter);
                prefixInfixSuffixLengthHelper.lengthSuffix = modifierResolveModifierPlurals3.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index0(), prefixInfixSuffixLengthHelper.index4()) + prefixInfixSuffixLengthHelper.lengthSuffix;
                prefixInfixSuffixLengthHelper.lengthPrefix = modifierResolveModifierPlurals3.getPrefixLength() + prefixInfixSuffixLengthHelper.lengthPrefix;
                prefixInfixSuffixLengthHelper.lengthSuffix -= modifierResolveModifierPlurals3.getPrefixLength();
            } else {
                prefixInfixSuffixLengthHelper.length1 = microProps.modOuter.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index0(), prefixInfixSuffixLengthHelper.index1()) + prefixInfixSuffixLengthHelper.length1;
                prefixInfixSuffixLengthHelper.length2 = microProps2.modOuter.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index2(), prefixInfixSuffixLengthHelper.index4()) + prefixInfixSuffixLengthHelper.length2;
            }
            NumberRangeFormatter.SpanField spanField = NumberRangeFormatter.SpanField.NUMBER_RANGE_SPAN;
            FormattedValueStringBuilderImpl.applySpanRange(formattedStringBuilder, spanField, 0, prefixInfixSuffixLengthHelper.index0(), prefixInfixSuffixLengthHelper.index1());
            FormattedValueStringBuilderImpl.applySpanRange(formattedStringBuilder, spanField, 1, prefixInfixSuffixLengthHelper.index2(), prefixInfixSuffixLengthHelper.index3());
        }
        zSemanticallyEquivalent = false;
        zSemanticallyEquivalent2 = false;
        zSemanticallyEquivalent3 = zSemanticallyEquivalent2;
        prefixInfixSuffixLengthHelper = new PrefixInfixSuffixLengthHelper();
        SimpleModifier.formatTwoArgPattern(this.fRangePattern, formattedStringBuilder, 0, prefixInfixSuffixLengthHelper, null);
        if (zSemanticallyEquivalent3) {
            z = false;
        } else {
            z = false;
        }
        if (zSemanticallyEquivalent2) {
            z2 = false;
        } else {
            z2 = false;
        }
        if (zSemanticallyEquivalent) {
            z3 = false;
        } else {
            z3 = false;
        }
        if (z) {
            if (!PatternProps.isWhiteSpace(formattedStringBuilder.charAt(prefixInfixSuffixLengthHelper.index1()))) {
                prefixInfixSuffixLengthHelper.lengthInfix = formattedStringBuilder.insertCodePoint(prefixInfixSuffixLengthHelper.index1(), 32, null) + prefixInfixSuffixLengthHelper.lengthInfix;
            }
            if (!PatternProps.isWhiteSpace(formattedStringBuilder.charAt(prefixInfixSuffixLengthHelper.index2() - 1))) {
                prefixInfixSuffixLengthHelper.lengthInfix = formattedStringBuilder.insertCodePoint(prefixInfixSuffixLengthHelper.index2(), 32, null) + prefixInfixSuffixLengthHelper.lengthInfix;
            }
        } else {
            if (!PatternProps.isWhiteSpace(formattedStringBuilder.charAt(prefixInfixSuffixLengthHelper.index1()))) {
                prefixInfixSuffixLengthHelper.lengthInfix = formattedStringBuilder.insertCodePoint(prefixInfixSuffixLengthHelper.index1(), 32, null) + prefixInfixSuffixLengthHelper.lengthInfix;
            }
            if (!PatternProps.isWhiteSpace(formattedStringBuilder.charAt(prefixInfixSuffixLengthHelper.index2() - 1))) {
                prefixInfixSuffixLengthHelper.lengthInfix = formattedStringBuilder.insertCodePoint(prefixInfixSuffixLengthHelper.index2(), 32, null) + prefixInfixSuffixLengthHelper.lengthInfix;
            }
        }
        prefixInfixSuffixLengthHelper.length1 += NumberFormatterImpl.writeNumber(microProps, decimalQuantity, formattedStringBuilder, prefixInfixSuffixLengthHelper.index0());
        FormattedStringBuilder formattedStringBuilder3 = new FormattedStringBuilder();
        NumberFormatterImpl.writeNumber(microProps2, decimalQuantity2, formattedStringBuilder3, 0);
        prefixInfixSuffixLengthHelper.length2 = formattedStringBuilder.insert(prefixInfixSuffixLengthHelper.index2(), formattedStringBuilder3) + prefixInfixSuffixLengthHelper.length2;
        if (zSemanticallyEquivalent3) {
            Modifier modifierResolveModifierPlurals4 = resolveModifierPlurals(microProps.modInner, microProps2.modInner);
            prefixInfixSuffixLengthHelper.lengthSuffix = modifierResolveModifierPlurals4.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index0(), prefixInfixSuffixLengthHelper.index4()) + prefixInfixSuffixLengthHelper.lengthSuffix;
            prefixInfixSuffixLengthHelper.lengthPrefix = modifierResolveModifierPlurals4.getPrefixLength() + prefixInfixSuffixLengthHelper.lengthPrefix;
            prefixInfixSuffixLengthHelper.lengthSuffix -= modifierResolveModifierPlurals4.getPrefixLength();
        } else {
            prefixInfixSuffixLengthHelper.length1 = microProps.modInner.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index0(), prefixInfixSuffixLengthHelper.index1()) + prefixInfixSuffixLengthHelper.length1;
            prefixInfixSuffixLengthHelper.length2 = microProps2.modInner.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index2(), prefixInfixSuffixLengthHelper.index4()) + prefixInfixSuffixLengthHelper.length2;
        }
        if (zSemanticallyEquivalent2) {
            Modifier modifierResolveModifierPlurals5 = resolveModifierPlurals(microProps.modMiddle, microProps2.modMiddle);
            prefixInfixSuffixLengthHelper.lengthSuffix = modifierResolveModifierPlurals5.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index0(), prefixInfixSuffixLengthHelper.index4()) + prefixInfixSuffixLengthHelper.lengthSuffix;
            prefixInfixSuffixLengthHelper.lengthPrefix = modifierResolveModifierPlurals5.getPrefixLength() + prefixInfixSuffixLengthHelper.lengthPrefix;
            prefixInfixSuffixLengthHelper.lengthSuffix -= modifierResolveModifierPlurals5.getPrefixLength();
        } else {
            prefixInfixSuffixLengthHelper.length1 = microProps.modMiddle.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index0(), prefixInfixSuffixLengthHelper.index1()) + prefixInfixSuffixLengthHelper.length1;
            prefixInfixSuffixLengthHelper.length2 = microProps2.modMiddle.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index2(), prefixInfixSuffixLengthHelper.index4()) + prefixInfixSuffixLengthHelper.length2;
        }
        if (zSemanticallyEquivalent) {
            Modifier modifierResolveModifierPlurals6 = resolveModifierPlurals(microProps.modOuter, microProps2.modOuter);
            prefixInfixSuffixLengthHelper.lengthSuffix = modifierResolveModifierPlurals6.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index0(), prefixInfixSuffixLengthHelper.index4()) + prefixInfixSuffixLengthHelper.lengthSuffix;
            prefixInfixSuffixLengthHelper.lengthPrefix = modifierResolveModifierPlurals6.getPrefixLength() + prefixInfixSuffixLengthHelper.lengthPrefix;
            prefixInfixSuffixLengthHelper.lengthSuffix -= modifierResolveModifierPlurals6.getPrefixLength();
        } else {
            prefixInfixSuffixLengthHelper.length1 = microProps.modOuter.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index0(), prefixInfixSuffixLengthHelper.index1()) + prefixInfixSuffixLengthHelper.length1;
            prefixInfixSuffixLengthHelper.length2 = microProps2.modOuter.apply(formattedStringBuilder, prefixInfixSuffixLengthHelper.index2(), prefixInfixSuffixLengthHelper.index4()) + prefixInfixSuffixLengthHelper.length2;
        }
        NumberRangeFormatter.SpanField spanField2 = NumberRangeFormatter.SpanField.NUMBER_RANGE_SPAN;
        FormattedValueStringBuilderImpl.applySpanRange(formattedStringBuilder, spanField2, 0, prefixInfixSuffixLengthHelper.index0(), prefixInfixSuffixLengthHelper.index1());
        FormattedValueStringBuilderImpl.applySpanRange(formattedStringBuilder, spanField2, 1, prefixInfixSuffixLengthHelper.index2(), prefixInfixSuffixLengthHelper.index3());
    }

    private void formatSingleValue(DecimalQuantity decimalQuantity, DecimalQuantity decimalQuantity2, FormattedStringBuilder formattedStringBuilder, MicroProps microProps, MicroProps microProps2) {
        if (this.fSameFormatters) {
            NumberFormatterImpl.writeAffixes(microProps, formattedStringBuilder, 0, NumberFormatterImpl.writeNumber(microProps, decimalQuantity, formattedStringBuilder, 0));
        } else {
            formatRange(decimalQuantity, decimalQuantity2, formattedStringBuilder, microProps, microProps2);
        }
    }

    private static void getNumberRangeData(ULocale uLocale, String str, NumberRangeFormatterImpl numberRangeFormatterImpl) {
        StringBuilder sb = new StringBuilder();
        NumberRangeDataSink numberRangeDataSink = new NumberRangeDataSink(sb);
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale);
        sb.append("NumberElements/");
        sb.append(str);
        sb.append("/miscPatterns");
        try {
            iCUResourceBundle.getAllItemsWithFallback(sb.toString(), numberRangeDataSink);
        } catch (MissingResourceException unused) {
        }
        if (!numberRangeDataSink.isComplete()) {
            iCUResourceBundle.getAllItemsWithFallback("NumberElements/latn/miscPatterns", numberRangeDataSink);
        }
        numberRangeDataSink.fillInDefaults();
        numberRangeFormatterImpl.fRangePattern = numberRangeDataSink.rangePattern;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006f A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:32:0x0073  */
    /* JADX WARN: Code duplicated, block: B:33:0x007a  */
    public FormattedNumberRange format(DecimalQuantity decimalQuantity, DecimalQuantity decimalQuantity2, boolean z) {
        NumberRangeFormatter.RangeIdentityResult rangeIdentityResult;
        DecimalQuantity decimalQuantity3;
        DecimalQuantity decimalQuantity4;
        DecimalQuantity decimalQuantityCreateCopy = decimalQuantity.createCopy();
        FormattedStringBuilder formattedStringBuilder = new FormattedStringBuilder();
        MicroProps microPropsPreProcess = this.formatterImpl1.preProcess(decimalQuantity);
        MicroProps microPropsPreProcess2 = this.fSameFormatters ? this.formatterImpl1.preProcess(decimalQuantity2) : this.formatterImpl2.preProcess(decimalQuantity2);
        if (!microPropsPreProcess.modInner.semanticallyEquivalent(microPropsPreProcess2.modInner) || !microPropsPreProcess.modMiddle.semanticallyEquivalent(microPropsPreProcess2.modMiddle) || !microPropsPreProcess.modOuter.semanticallyEquivalent(microPropsPreProcess2.modOuter)) {
            formatRange(decimalQuantity, decimalQuantity2, formattedStringBuilder, microPropsPreProcess, microPropsPreProcess2);
            return new FormattedNumberRange(formattedStringBuilder, decimalQuantity, decimalQuantity2, NumberRangeFormatter.RangeIdentityResult.NOT_EQUAL);
        }
        if (z) {
            rangeIdentityResult = NumberRangeFormatter.RangeIdentityResult.EQUAL_BEFORE_ROUNDING;
        } else {
            rangeIdentityResult = decimalQuantity.equals(decimalQuantity2) ? NumberRangeFormatter.RangeIdentityResult.EQUAL_AFTER_ROUNDING : NumberRangeFormatter.RangeIdentityResult.NOT_EQUAL;
        }
        int iIdentity2d = identity2d(this.fIdentityFallback, rangeIdentityResult);
        if (iIdentity2d == 0 || iIdentity2d == 1) {
            decimalQuantity3 = decimalQuantity;
            decimalQuantity4 = decimalQuantity2;
            formatSingleValue(decimalQuantity3, decimalQuantity4, formattedStringBuilder, microPropsPreProcess, microPropsPreProcess2);
        } else if (iIdentity2d == 2) {
            formatApproximately(decimalQuantityCreateCopy, decimalQuantity, decimalQuantity2, formattedStringBuilder, microPropsPreProcess, microPropsPreProcess2);
            formattedStringBuilder = formattedStringBuilder;
            decimalQuantity4 = decimalQuantity2;
            decimalQuantity3 = decimalQuantity;
        } else if (iIdentity2d != 3) {
            switch (iIdentity2d) {
                case 16:
                    decimalQuantity3 = decimalQuantity;
                    decimalQuantity4 = decimalQuantity2;
                    formatSingleValue(decimalQuantity3, decimalQuantity4, formattedStringBuilder, microPropsPreProcess, microPropsPreProcess2);
                    break;
                case 17:
                case 18:
                    formatApproximately(decimalQuantityCreateCopy, decimalQuantity, decimalQuantity2, formattedStringBuilder, microPropsPreProcess, microPropsPreProcess2);
                    formattedStringBuilder = formattedStringBuilder;
                    decimalQuantity4 = decimalQuantity2;
                    decimalQuantity3 = decimalQuantity;
                    break;
                default:
                    switch (iIdentity2d) {
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                            break;
                        default:
                            decimalQuantity3 = decimalQuantity;
                            decimalQuantity4 = decimalQuantity2;
                            break;
                    }
                case 19:
                    decimalQuantity3 = decimalQuantity;
                    decimalQuantity4 = decimalQuantity2;
                    formatRange(decimalQuantity3, decimalQuantity4, formattedStringBuilder, microPropsPreProcess, microPropsPreProcess2);
                    break;
            }
        } else {
            decimalQuantity3 = decimalQuantity;
            decimalQuantity4 = decimalQuantity2;
            formatRange(decimalQuantity3, decimalQuantity4, formattedStringBuilder, microPropsPreProcess, microPropsPreProcess2);
        }
        return new FormattedNumberRange(formattedStringBuilder, decimalQuantity3, decimalQuantity4, rangeIdentityResult);
    }

    public int identity2d(NumberRangeFormatter.RangeIdentityFallback rangeIdentityFallback, NumberRangeFormatter.RangeIdentityResult rangeIdentityResult) {
        return rangeIdentityFallback.ordinal() | (rangeIdentityResult.ordinal() << 4);
    }

    public Modifier resolveModifierPlurals(Modifier modifier, Modifier modifier2) {
        Modifier.Parameters parameters;
        Modifier.Parameters parameters2 = modifier.getParameters();
        return (parameters2 == null || (parameters = modifier2.getParameters()) == null) ? modifier : parameters2.obj.getModifier(parameters2.signum, this.fPluralRanges.resolve(parameters2.plural, parameters.plural));
    }
}
