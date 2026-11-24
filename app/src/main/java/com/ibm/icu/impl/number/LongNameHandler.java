package com.ibm.icu.impl.number;

import com.ibm.icu.impl.CurrencyData;
import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.impl.locale.BaseLocale;
import com.ibm.icu.impl.units.MeasureUnitImpl;
import com.ibm.icu.impl.units.SingleUnitImpl;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.number.NumberFormatter;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.MeasureUnit;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class LongNameHandler implements MicroPropsGenerator, ModifierStore, LongNameMultiplexer.ParentlessMicroPropsGenerator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ARRAY_LENGTH;
    private static final int CONSTANT_DENOMINATOR_INDEX;
    private static final int DNAM_INDEX;
    private static final int GENDER_INDEX;
    private static final int PER_INDEX;
    private static int i;
    private String gender = "";
    private final Map<StandardPlural, SimpleModifier> modifiers;
    private final MicroPropsGenerator parent;
    private final PluralRules rules;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class DerivedComponents {
        private String value0;
        private String value1;

        public DerivedComponents(ULocale uLocale, String str, String str2) {
            ICUResourceBundle iCUResourceBundle;
            this.value0 = "";
            this.value1 = "";
            try {
                ICUResourceBundle iCUResourceBundle2 = (ICUResourceBundle) ((ICUResourceBundle) ((ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "grammaticalFeatures")).get("grammaticalData")).get("derivations");
                try {
                    iCUResourceBundle = (ICUResourceBundle) iCUResourceBundle2.get(uLocale.getLanguage());
                } catch (MissingResourceException unused) {
                    iCUResourceBundle = (ICUResourceBundle) iCUResourceBundle2.get("root");
                }
                ICUResourceBundle iCUResourceBundle3 = (ICUResourceBundle) ((ICUResourceBundle) ((ICUResourceBundle) iCUResourceBundle.get("component")).get(str)).get(str2);
                String string = iCUResourceBundle3.getString(0);
                if (string.compareTo("compound") == 0) {
                    this.value0 = null;
                } else {
                    this.value0 = string;
                }
                String string2 = iCUResourceBundle3.getString(1);
                if (string2.compareTo("compound") == 0) {
                    this.value1 = null;
                } else {
                    this.value1 = string2;
                }
            } catch (MissingResourceException unused2) {
            }
        }

        public String value0(String str) {
            String str2 = this.value0;
            return str2 != null ? str2 : str;
        }

        public String value1(String str) {
            String str2 = this.value1;
            return str2 != null ? str2 : str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class InflectedPluralSink extends UResource.Sink {
        String caseVariant;
        String gender;
        String[] outArray;

        public InflectedPluralSink(String str, String str2, String[] strArr) {
            this.gender = str;
            this.caseVariant = str2;
            this.outArray = strArr;
            for (int i = 0; i < LongNameHandler.ARRAY_LENGTH; i++) {
                strArr[i] = null;
            }
        }

        private boolean loadForCase(UResource.Table table, String str, UResource.Value value) {
            return table.findValue(str, value);
        }

        private boolean loadForGender(UResource.Table table, String str, UResource.Value value) {
            if (!table.findValue(str, value)) {
                return false;
            }
            UResource.Table table2 = value.getTable();
            String str2 = this.caseVariant;
            if (str2 != null && !str2.isEmpty()) {
                if (loadForCase(table2, this.caseVariant, value)) {
                    return true;
                }
                if (!this.caseVariant.equals("nominative") && loadForCase(table2, "nominative", value)) {
                    return true;
                }
            }
            return loadForCase(table2, BaseLocale.SEP, value);
        }

        private boolean loadForPluralForm(UResource.Table table, UResource.Value value) {
            String str = this.gender;
            if (str != null && !str.isEmpty()) {
                if (loadForGender(table, this.gender, value)) {
                    return true;
                }
                if (!this.gender.equals("neuter") && loadForGender(table, "neuter", value)) {
                    return true;
                }
            }
            return loadForGender(table, BaseLocale.SEP, value);
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                int index = LongNameHandler.getIndex(key.toString());
                if (this.outArray[index] == null && loadForPluralForm(value.getTable(), value)) {
                    this.outArray[index] = value.getString();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum PlaceholderPosition {
        NONE,
        BEGINNING,
        MIDDLE,
        END
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class PluralTableSink extends UResource.Sink {
        String[] outArray;

        public PluralTableSink(String[] strArr) {
            this.outArray = strArr;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                String string = key.toString();
                if (!string.equals("case")) {
                    int index = LongNameHandler.getIndex(string);
                    if (this.outArray[index] == null) {
                        this.outArray[index] = value.getString();
                    }
                }
            }
        }
    }

    static {
        int i2 = StandardPlural.COUNT;
        int i3 = i;
        DNAM_INDEX = i2 + i3;
        PER_INDEX = i3 + 1 + i2;
        GENDER_INDEX = i3 + 2 + i2;
        CONSTANT_DENOMINATOR_INDEX = i3 + 3 + i2;
        i = i3 + 5;
        ARRAY_LENGTH = i2 + i3 + 4;
    }

    private LongNameHandler(Map<StandardPlural, SimpleModifier> map, PluralRules pluralRules, MicroPropsGenerator microPropsGenerator) {
        this.modifiers = map;
        this.rules = pluralRules;
        this.parent = microPropsGenerator;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0078  */
    private static String calculateGenderForUnit(ULocale uLocale, MeasureUnit measureUnit) {
        int i2;
        MeasureUnitImpl copyOfMeasureUnitImpl = measureUnit.getCopyOfMeasureUnitImpl();
        ArrayList<SingleUnitImpl> singleUnits = copyOfMeasureUnitImpl.getSingleUnits();
        int i3 = 0;
        if (copyOfMeasureUnitImpl.getComplexity() == MeasureUnit.Complexity.COMPOUND) {
            int size = singleUnits.size() - 1;
            if (singleUnits.get(size).getDimensionality() < 0) {
                String deriveCompoundRule = getDeriveCompoundRule(uLocale, "gender", "per");
                if (deriveCompoundRule.length() != 1) {
                    return deriveCompoundRule;
                }
                if (deriveCompoundRule.charAt(0) == '1') {
                    i2 = 0;
                    while (singleUnits.get(i2).getDimensionality() >= 0) {
                        i2++;
                    }
                } else {
                    while (size >= 0 && singleUnits.get(size).getDimensionality() < 0) {
                        size--;
                    }
                    if (size < 0) {
                        return "";
                    }
                    i2 = 0;
                }
            } else {
                i2 = 0;
            }
            if (size > i2) {
                String deriveCompoundRule2 = getDeriveCompoundRule(uLocale, "gender", "times");
                if (deriveCompoundRule2.length() != 1) {
                    return deriveCompoundRule2;
                }
                if (deriveCompoundRule2.charAt(0) == '0') {
                    i3 = i2;
                } else {
                    i3 = size;
                }
            } else {
                i3 = i2;
            }
        } else if (copyOfMeasureUnitImpl.getComplexity() == MeasureUnit.Complexity.MIXED) {
            og.q("calculateGenderForUnit does not support MIXED units");
            return null;
        }
        SingleUnitImpl singleUnitImpl = singleUnits.get(i3);
        if (Math.abs(singleUnitImpl.getDimensionality()) != 1) {
            String deriveCompoundRule3 = getDeriveCompoundRule(uLocale, "gender", "power");
            if (deriveCompoundRule3.length() != 1) {
                return deriveCompoundRule3;
            }
        }
        if (Math.abs(singleUnitImpl.getDimensionality()) != 1) {
            String deriveCompoundRule4 = getDeriveCompoundRule(uLocale, "gender", "prefix");
            if (deriveCompoundRule4.length() != 1) {
                return deriveCompoundRule4;
            }
        }
        return getGenderForBuiltin(uLocale, MeasureUnit.forIdentifier(singleUnitImpl.getSimpleUnitID()));
    }

    private static ExtractCorePatternResult extractCorePattern(String str) {
        ExtractCorePatternResult extractCorePatternResult = new ExtractCorePatternResult(0);
        extractCorePatternResult.joinerChar = (char) 0;
        int length = str.length();
        if (str.startsWith("{0}")) {
            extractCorePatternResult.placeholderPosition = PlaceholderPosition.BEGINNING;
            if (length <= 3 || !Character.isSpaceChar(str.charAt(3))) {
                extractCorePatternResult.coreUnit = str.substring(3);
                return extractCorePatternResult;
            }
            extractCorePatternResult.joinerChar = str.charAt(3);
            extractCorePatternResult.coreUnit = str.substring(4);
            return extractCorePatternResult;
        }
        if (!str.endsWith("{0}")) {
            if (str.indexOf("{0}", 1) == -1) {
                extractCorePatternResult.placeholderPosition = PlaceholderPosition.NONE;
                extractCorePatternResult.coreUnit = str;
                return extractCorePatternResult;
            }
            extractCorePatternResult.placeholderPosition = PlaceholderPosition.MIDDLE;
            extractCorePatternResult.coreUnit = str;
            return extractCorePatternResult;
        }
        extractCorePatternResult.placeholderPosition = PlaceholderPosition.END;
        int i2 = length - 4;
        if (!Character.isSpaceChar(str.charAt(i2))) {
            extractCorePatternResult.coreUnit = str.substring(0, length - 3);
            return extractCorePatternResult;
        }
        extractCorePatternResult.coreUnit = str.substring(0, i2);
        extractCorePatternResult.joinerChar = str.charAt(i2);
        return extractCorePatternResult;
    }

    private static LongNameHandler forArbitraryUnit(ULocale uLocale, MeasureUnit measureUnit, NumberFormatter.UnitWidth unitWidth, String str, PluralRules pluralRules, MicroPropsGenerator microPropsGenerator) {
        MeasureUnit measureUnitBuild;
        MeasureUnitImpl copyOfMeasureUnitImpl = measureUnit.getCopyOfMeasureUnitImpl();
        if (copyOfMeasureUnitImpl.getConstantDenominator() != 0) {
            MeasureUnitImpl measureUnitImpl = new MeasureUnitImpl();
            measureUnitImpl.setConstantDenominator(copyOfMeasureUnitImpl.getConstantDenominator());
            measureUnitBuild = measureUnitImpl.build();
        } else {
            measureUnitBuild = null;
        }
        ArrayList<SingleUnitImpl> singleUnits = copyOfMeasureUnitImpl.getSingleUnits();
        int size = singleUnits.size();
        MeasureUnit measureUnitBuild2 = null;
        int i2 = 0;
        while (i2 < size) {
            SingleUnitImpl singleUnitImpl = singleUnits.get(i2);
            i2++;
            SingleUnitImpl singleUnitImpl2 = singleUnitImpl;
            if (singleUnitImpl2.getDimensionality() > 0) {
                measureUnitBuild2 = measureUnitBuild2 == null ? singleUnitImpl2.build() : measureUnitBuild2.product(singleUnitImpl2.build());
            } else {
                singleUnitImpl2.setDimensionality(singleUnitImpl2.getDimensionality() * (-1));
                measureUnitBuild = measureUnitBuild == null ? singleUnitImpl2.build() : measureUnitBuild.product(singleUnitImpl2.build());
            }
        }
        MeasureUnitImpl copyOfMeasureUnitImpl2 = measureUnitBuild2 == null ? null : measureUnitBuild2.getCopyOfMeasureUnitImpl();
        MeasureUnitImpl copyOfMeasureUnitImpl3 = measureUnitBuild != null ? measureUnitBuild.getCopyOfMeasureUnitImpl() : null;
        DerivedComponents derivedComponents = new DerivedComponents(uLocale, "case", "per");
        int i3 = ARRAY_LENGTH;
        String[] strArr = new String[i3];
        processPatternTimes(copyOfMeasureUnitImpl2, uLocale, unitWidth, derivedComponents.value0(str), strArr);
        String[] strArr2 = new String[i3];
        processPatternTimes(copyOfMeasureUnitImpl3, uLocale, unitWidth, derivedComponents.value1(str), strArr2);
        String compiledPattern = strArr2[PER_INDEX];
        if (compiledPattern == null) {
            StringBuilder sb = new StringBuilder();
            compiledPattern = SimpleFormatterImpl.formatCompiledPattern(SimpleFormatterImpl.compileToStringMinMaxArguments(getCompoundValue("per", uLocale, unitWidth), sb, 2, 2), "{0}", PatternProps.trimSpaceChar(SimpleFormatterImpl.getTextWithNoArguments(SimpleFormatterImpl.compileToStringMinMaxArguments(getWithPlural(strArr2, StandardPlural.ONE), sb, 0, 1))));
        }
        LongNameHandler longNameHandler = new LongNameHandler(new EnumMap(StandardPlural.class), pluralRules, microPropsGenerator);
        if (compiledPattern.length() == 0) {
            longNameHandler.simpleFormatsToModifiers(strArr, NumberFormat.Field.MEASURE_UNIT);
        } else {
            longNameHandler.multiSimpleFormatsToModifiers(strArr, compiledPattern, NumberFormat.Field.MEASURE_UNIT);
        }
        longNameHandler.gender = getDerivedGender(uLocale, "per", strArr, strArr2);
        return longNameHandler;
    }

    public static LongNameHandler forCurrencyLongNames(ULocale uLocale, Currency currency, PluralRules pluralRules, MicroPropsGenerator microPropsGenerator) {
        String[] strArr = new String[ARRAY_LENGTH];
        getCurrencyLongNameData(uLocale, currency, strArr);
        LongNameHandler longNameHandler = new LongNameHandler(new EnumMap(StandardPlural.class), pluralRules, microPropsGenerator);
        longNameHandler.simpleFormatsToModifiers(strArr, NumberFormat.Field.CURRENCY);
        return longNameHandler;
    }

    public static LongNameHandler forMeasureUnit(ULocale uLocale, MeasureUnit measureUnit, NumberFormatter.UnitWidth unitWidth, String str, PluralRules pluralRules, MicroPropsGenerator microPropsGenerator) {
        if (measureUnit.getType() == null) {
            return forArbitraryUnit(uLocale, measureUnit, unitWidth, str, pluralRules, microPropsGenerator);
        }
        String[] strArr = new String[ARRAY_LENGTH];
        getMeasureData(uLocale, measureUnit, unitWidth, str, strArr);
        maybeCalculateGender(uLocale, measureUnit, strArr);
        LongNameHandler longNameHandler = new LongNameHandler(new EnumMap(StandardPlural.class), pluralRules, microPropsGenerator);
        longNameHandler.simpleFormatsToModifiers(strArr, NumberFormat.Field.MEASURE_UNIT);
        String str2 = strArr[GENDER_INDEX];
        if (str2 != null) {
            longNameHandler.gender = str2;
        }
        return longNameHandler;
    }

    private static String getCompoundValue(String str, ULocale uLocale, NumberFormatter.UnitWidth unitWidth) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_UNIT_BASE_NAME, uLocale);
        StringBuilder sb = new StringBuilder("units");
        if (unitWidth == NumberFormatter.UnitWidth.NARROW) {
            sb.append("Narrow");
        } else if (unitWidth == NumberFormatter.UnitWidth.SHORT) {
            sb.append("Short");
        }
        sb.append("/compound/");
        sb.append(str);
        try {
            return iCUResourceBundle.getStringWithFallback(sb.toString());
        } catch (MissingResourceException unused) {
            if (unitWidth == NumberFormatter.UnitWidth.SHORT) {
                return "";
            }
            try {
                return iCUResourceBundle.getStringWithFallback(sb.toString());
            } catch (MissingResourceException unused2) {
                return "";
            }
        }
    }

    private static void getCurrencyLongNameData(ULocale uLocale, Currency currency, String[] strArr) {
        Map<String, String> unitPatterns = CurrencyData.provider.getInstance(uLocale, true).getUnitPatterns();
        Set<String> keywords = PluralRules.forLocale(uLocale).getKeywords();
        String str = unitPatterns.get(PluralRules.KEYWORD_OTHER);
        if (keywords != null && str != null) {
            for (String str2 : keywords) {
                if (!str2.equals(PluralRules.KEYWORD_OTHER) && !unitPatterns.containsKey(str2)) {
                    unitPatterns.put(str2, str);
                }
            }
        }
        for (Map.Entry<String, String> entry : unitPatterns.entrySet()) {
            String key = entry.getKey();
            strArr[getIndex(key)] = entry.getValue().replace("{1}", currency.getName(uLocale, 2, key, (boolean[]) null));
        }
    }

    private static String getDeriveCompoundRule(ULocale uLocale, String str, String str2) {
        ICUResourceBundle iCUResourceBundle;
        ICUResourceBundle iCUResourceBundle2 = (ICUResourceBundle) ((ICUResourceBundle) ((ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "grammaticalFeatures")).get("grammaticalData")).get("derivations");
        try {
            iCUResourceBundle = (ICUResourceBundle) iCUResourceBundle2.get(uLocale.getLanguage());
        } catch (MissingResourceException unused) {
            iCUResourceBundle = (ICUResourceBundle) iCUResourceBundle2.get("root");
        }
        return ((ICUResourceBundle) ((ICUResourceBundle) iCUResourceBundle.get("compound")).get(str)).getString(str2);
    }

    private static String getDerivedGender(ULocale uLocale, String str, String[] strArr, String[] strArr2) {
        String deriveCompoundRule = getDeriveCompoundRule(uLocale, "gender", str);
        if (deriveCompoundRule.length() != 1) {
            return deriveCompoundRule;
        }
        char cCharAt = deriveCompoundRule.charAt(0);
        if (cCharAt == '0') {
            return strArr[GENDER_INDEX];
        }
        if (cCharAt != '1') {
            return deriveCompoundRule;
        }
        if (strArr2 == null) {
            return null;
        }
        return strArr2[GENDER_INDEX];
    }

    private static String getGenderForBuiltin(ULocale uLocale, MeasureUnit measureUnit) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_UNIT_BASE_NAME, uLocale);
        StringBuilder sb = new StringBuilder("units/");
        sb.append(measureUnit.getType());
        sb.append("/");
        if (measureUnit.getSubtype() == null || !measureUnit.getSubtype().endsWith("-person")) {
            sb.append(measureUnit.getSubtype());
        } else {
            sb.append((CharSequence) measureUnit.getSubtype(), 0, measureUnit.getSubtype().length() - 7);
        }
        sb.append("/gender");
        try {
            return iCUResourceBundle.getWithFallback(sb.toString()).getString();
        } catch (MissingResourceException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getIndex(String str) {
        str.getClass();
        switch (str) {
            case "gender":
                return GENDER_INDEX;
            case "per":
                return PER_INDEX;
            case "dnam":
                return DNAM_INDEX;
            default:
                return StandardPlural.fromString(str).ordinal();
        }
    }

    public static void getInflectedMeasureData(String str, ULocale uLocale, NumberFormatter.UnitWidth unitWidth, String str2, String str3, String[] strArr) {
        InflectedPluralSink inflectedPluralSink = new InflectedPluralSink(str2, str3, strArr);
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_UNIT_BASE_NAME, uLocale);
        StringBuilder sb = new StringBuilder("units");
        if (unitWidth == NumberFormatter.UnitWidth.NARROW) {
            sb.append("Narrow");
        } else if (unitWidth == NumberFormatter.UnitWidth.SHORT) {
            sb.append("Short");
        }
        sb.append("/");
        sb.append(str);
        try {
            iCUResourceBundle.getAllItemsWithFallback(sb.toString(), inflectedPluralSink);
            if (unitWidth == NumberFormatter.UnitWidth.SHORT) {
                return;
            }
        } catch (MissingResourceException unused) {
        }
        iCUResourceBundle.getAllItemsWithFallback(sb.toString(), inflectedPluralSink);
    }

    public static void getMeasureData(ULocale uLocale, MeasureUnit measureUnit, NumberFormatter.UnitWidth unitWidth, String str, String[] strArr) {
        PluralTableSink pluralTableSink = new PluralTableSink(strArr);
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_UNIT_BASE_NAME, uLocale);
        StringBuilder sb = new StringBuilder("/");
        sb.append(measureUnit.getType());
        sb.append("/");
        String subtype = measureUnit.getSubtype();
        ICUResourceBundle iCUResourceBundle2 = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "metadata");
        AliasSink aliasSink = new AliasSink(0);
        iCUResourceBundle2.getAllItemsWithFallbackNoFail("alias/unit/" + subtype, aliasSink);
        String str2 = aliasSink.replacement;
        if (str2 != null) {
            subtype = str2;
        }
        if (subtype == null || !subtype.endsWith("-person")) {
            sb.append(subtype);
        } else {
            sb.append((CharSequence) subtype, 0, subtype.length() - 7);
        }
        if (unitWidth != NumberFormatter.UnitWidth.FULL_NAME) {
            try {
                strArr[GENDER_INDEX] = iCUResourceBundle.getWithFallback("units" + ((CharSequence) sb) + "/gender").getString();
            } catch (MissingResourceException unused) {
            }
        }
        StringBuilder sb2 = new StringBuilder("units");
        if (unitWidth == NumberFormatter.UnitWidth.NARROW) {
            sb2.append("Narrow");
        } else if (unitWidth == NumberFormatter.UnitWidth.SHORT) {
            sb2.append("Short");
        }
        sb2.append((CharSequence) sb);
        if (unitWidth == NumberFormatter.UnitWidth.FULL_NAME && str != null && !str.isEmpty()) {
            try {
                iCUResourceBundle.getAllItemsWithFallback(((CharSequence) sb2) + "/case/" + str, pluralTableSink);
            } catch (MissingResourceException unused2) {
            }
        }
        try {
            iCUResourceBundle.getAllItemsWithFallback(sb2.toString(), pluralTableSink);
        } catch (MissingResourceException e) {
            throw new IllegalArgumentException(cq.l("No data for unit ", String.valueOf(measureUnit), ", width ", String.valueOf(unitWidth)), e);
        }
    }

    public static String getUnitDisplayName(ULocale uLocale, MeasureUnit measureUnit, NumberFormatter.UnitWidth unitWidth) {
        String[] strArr = new String[ARRAY_LENGTH];
        getMeasureData(uLocale, measureUnit, unitWidth, "", strArr);
        return strArr[DNAM_INDEX];
    }

    public static String getWithPlural(String[] strArr, StandardPlural standardPlural) {
        String str = strArr[standardPlural.ordinal()];
        if (str == null) {
            str = strArr[StandardPlural.OTHER.ordinal()];
        }
        if (str != null) {
            return str;
        }
        og.q("Could not find data in 'other' plural variant");
        return null;
    }

    private static void maybeCalculateGender(ULocale uLocale, MeasureUnit measureUnit, String[] strArr) {
        int i2 = GENDER_INDEX;
        if (strArr[i2] != null || getGenderForBuiltin(uLocale, MeasureUnit.METER).isEmpty()) {
            return;
        }
        strArr[i2] = calculateGenderForUnit(uLocale, measureUnit);
    }

    private void multiSimpleFormatsToModifiers(String[] strArr, String str, NumberFormat.Field field) {
        StringBuilder sb = new StringBuilder();
        String strCompileToStringMinMaxArguments = SimpleFormatterImpl.compileToStringMinMaxArguments(str, sb, 1, 1);
        for (StandardPlural standardPlural : StandardPlural.VALUES) {
            String withPlural = getWithPlural(strArr, standardPlural);
            String strCompileToStringMinMaxArguments2 = SimpleFormatterImpl.compileToStringMinMaxArguments(withPlural.length() == 0 ? str : SimpleFormatterImpl.formatCompiledPattern(strCompileToStringMinMaxArguments, withPlural), sb, 0, 1);
            Modifier.Parameters parameters = new Modifier.Parameters();
            parameters.obj = this;
            parameters.signum = null;
            parameters.plural = standardPlural;
            this.modifiers.put(standardPlural, new SimpleModifier(strCompileToStringMinMaxArguments2, field, false, parameters));
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x024e  */
    /* JADX WARN: Code duplicated, block: B:105:0x026c  */
    /* JADX WARN: Code duplicated, block: B:106:0x0272  */
    /* JADX WARN: Code duplicated, block: B:151:0x0296 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:88:0x020a  */
    /* JADX WARN: Code duplicated, block: B:90:0x020e  */
    /* JADX WARN: Code duplicated, block: B:93:0x0218  */
    /* JADX WARN: Code duplicated, block: B:95:0x0221  */
    /* JADX WARN: Code duplicated, block: B:97:0x023d  */
    /* JADX WARN: Code duplicated, block: B:99:0x0242  */
    private static void processPatternTimes(MeasureUnitImpl measureUnitImpl, ULocale uLocale, NumberFormatter.UnitWidth unitWidth, String str, String[] strArr) {
        String strValue1;
        int i2;
        char c;
        Integer numValueOf;
        String strValue2;
        String strValue3;
        DerivedComponents derivedComponents;
        SingleUnitImpl singleUnitImpl;
        NumberFormatter.UnitWidth unitWidth2;
        String compoundValue;
        StandardPlural[] standardPluralArr;
        ExtractCorePatternResult extractCorePatternResultExtractCorePattern;
        int i3;
        PlaceholderPosition placeholderPosition;
        int i4;
        String str2;
        String[] strArr2;
        String[] strArr3 = strArr;
        if (measureUnitImpl == null) {
            strArr3[StandardPlural.OTHER.ordinal()] = "";
            strArr3[PER_INDEX] = "";
            return;
        }
        if (measureUnitImpl.getComplexity() == MeasureUnit.Complexity.MIXED) {
            dk0.r("Mixed units not supported by LongNameHandler");
            return;
        }
        if (measureUnitImpl.getIdentifier() == null) {
            measureUnitImpl.serialize();
        }
        if (measureUnitImpl.getIdentifier().length() == 0) {
            return;
        }
        MeasureUnit measureUnitFindBySubType = MeasureUnit.findBySubType(measureUnitImpl.getIdentifier());
        if (measureUnitFindBySubType != null) {
            getMeasureData(uLocale, measureUnitFindBySubType, unitWidth, str, strArr3);
            maybeCalculateGender(uLocale, measureUnitFindBySubType, strArr3);
            return;
        }
        String strValue4 = str;
        String compoundValue2 = getCompoundValue("times", uLocale, unitWidth);
        StringBuilder sb = new StringBuilder();
        String strCompileToStringMinMaxArguments = SimpleFormatterImpl.compileToStringMinMaxArguments(compoundValue2, sb, 2, 2);
        PlaceholderPosition[] placeholderPositionArr = new PlaceholderPosition[ARRAY_LENGTH];
        StandardPlural[] standardPluralArrValues = StandardPlural.values();
        int length = standardPluralArrValues.length;
        int i5 = 0;
        while (true) {
            strValue1 = null;
            if (i5 >= length) {
                break;
            }
            StandardPlural standardPlural = standardPluralArrValues[i5];
            int iOrdinal = standardPlural.ordinal();
            if (standardPlural == StandardPlural.OTHER) {
                strArr3[iOrdinal] = "";
            } else {
                strArr3[iOrdinal] = null;
            }
            placeholderPositionArr[iOrdinal] = null;
            i5++;
        }
        DerivedComponents derivedComponents2 = new DerivedComponents(uLocale, "plural", "times");
        DerivedComponents derivedComponents3 = new DerivedComponents(uLocale, "case", "times");
        String str3 = "power";
        DerivedComponents derivedComponents4 = new DerivedComponents(uLocale, "case", "power");
        ArrayList<SingleUnitImpl> singleUnits = measureUnitImpl.getSingleUnits();
        char c2 = 0;
        int i6 = 0;
        while (true) {
            PlaceholderPosition[] placeholderPositionArr2 = placeholderPositionArr;
            if (i6 >= singleUnits.size()) {
                char c3 = c2;
                String str4 = strCompileToStringMinMaxArguments;
                if (measureUnitImpl.getConstantDenominator() != 0) {
                    strArr[CONSTANT_DENOMINATOR_INDEX] = String.valueOf(measureUnitImpl.getConstantDenominator());
                    StandardPlural[] standardPluralArrValues2 = StandardPlural.values();
                    int length2 = standardPluralArrValues2.length;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= length2) {
                            numValueOf = null;
                            break;
                        }
                        StandardPlural standardPlural2 = standardPluralArrValues2[i7];
                        if (strArr[standardPlural2.ordinal()] != null) {
                            numValueOf = Integer.valueOf(standardPlural2.ordinal());
                            break;
                        }
                        i7++;
                    }
                    if (strArr[numValueOf.intValue()].length() == 0) {
                        strArr[numValueOf.intValue()] = strArr[CONSTANT_DENOMINATOR_INDEX];
                        i2 = 0;
                    } else {
                        i2 = 0;
                        strArr[numValueOf.intValue()] = SimpleFormatterImpl.formatCompiledPattern(str4, strArr[CONSTANT_DENOMINATOR_INDEX], strArr[numValueOf.intValue()]);
                    }
                } else {
                    i2 = 0;
                }
                StandardPlural[] standardPluralArrValues3 = StandardPlural.values();
                int length3 = standardPluralArrValues3.length;
                int i8 = i2;
                while (i8 < length3) {
                    int iOrdinal2 = standardPluralArrValues3[i8].ordinal();
                    PlaceholderPosition placeholderPosition2 = placeholderPositionArr2[iOrdinal2];
                    if (placeholderPosition2 == PlaceholderPosition.BEGINNING) {
                        StringBuilder sb2 = new StringBuilder("{0}");
                        c = c3;
                        if (c3 != 0) {
                            sb2.append(c);
                        }
                        sb2.append(strArr[iOrdinal2]);
                        strArr[iOrdinal2] = sb2.toString();
                    } else {
                        c = c3;
                        if (placeholderPosition2 == PlaceholderPosition.END) {
                            if (c != 0) {
                                strArr[iOrdinal2] = strArr[iOrdinal2] + c;
                            }
                            strArr[iOrdinal2] = ky0.j(strArr[iOrdinal2], "{0}");
                        }
                    }
                    i8++;
                    c3 = c;
                }
                return;
            }
            SingleUnitImpl singleUnitImpl2 = singleUnits.get(i6);
            if (i6 < singleUnits.size() - 1) {
                strValue2 = derivedComponents2.value0(strValue1);
                strValue3 = derivedComponents3.value0(strValue4);
                strValue1 = derivedComponents2.value1(strValue1);
                strValue4 = derivedComponents3.value1(strValue4);
            } else {
                strValue2 = derivedComponents2.value1(strValue1);
                strValue3 = derivedComponents3.value1(strValue4);
            }
            String str5 = strValue2;
            String str6 = strValue4;
            DerivedComponents derivedComponents5 = derivedComponents4;
            String strValue0 = strValue3;
            String str7 = strValue1;
            ArrayList<SingleUnitImpl> arrayList = singleUnits;
            MeasureUnit measureUnitFindBySubType2 = MeasureUnit.findBySubType(singleUnitImpl2.getSimpleUnitID());
            if (measureUnitFindBySubType2 == null) {
                dk0.r(cq.j("Unsupported sinlgeUnit: ", singleUnitImpl2.getSimpleUnitID()));
                return;
            }
            String genderForBuiltin = getGenderForBuiltin(uLocale, measureUnitFindBySubType2);
            DerivedComponents derivedComponents6 = derivedComponents2;
            int dimensionality = singleUnitImpl2.getDimensionality();
            int i9 = ARRAY_LENGTH;
            String str8 = str3;
            String[] strArr4 = new String[i9];
            if (dimensionality != 1) {
                try {
                    derivedComponents = derivedComponents5;
                    singleUnitImpl = singleUnitImpl2;
                    unitWidth2 = unitWidth;
                    getInflectedMeasureData("compound/power" + dimensionality, uLocale, unitWidth2, genderForBuiltin, strValue0, strArr4);
                    strValue0 = derivedComponents.value0(strValue0);
                    singleUnitImpl.setDimensionality(1);
                } catch (MissingResourceException e) {
                    if (dimensionality <= 3) {
                        throw e;
                    }
                    dk0.r(cq.j("powerN not supported for N > 3: ", measureUnitImpl.getIdentifier()));
                    return;
                }
            } else {
                derivedComponents = derivedComponents5;
                singleUnitImpl = singleUnitImpl2;
                unitWidth2 = unitWidth;
            }
            MeasureUnit.MeasurePrefix prefix = singleUnitImpl.getPrefix();
            MeasureUnit.MeasurePrefix measurePrefix = MeasureUnit.MeasurePrefix.ONE;
            if (prefix != measurePrefix) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(prefix.getBase());
                sb3.append('p');
                sb3.append(prefix.getPower());
                compoundValue = getCompoundValue(sb3.toString(), uLocale, unitWidth2);
                singleUnitImpl.setPrefix(measurePrefix);
            } else {
                compoundValue = "";
            }
            String[] strArr5 = new String[i9];
            getMeasureData(uLocale, singleUnitImpl.build(), unitWidth2, strValue0, strArr5);
            int i10 = GENDER_INDEX;
            if (strArr5[i10] != null) {
                if (prefix != measurePrefix) {
                    strArr2 = null;
                    strArr5[i10] = getDerivedGender(uLocale, "prefix", strArr5, null);
                } else {
                    strArr2 = null;
                }
                if (dimensionality != 1) {
                    strArr5[i10] = getDerivedGender(uLocale, str8, strArr5, strArr2);
                }
                String deriveCompoundRule = getDeriveCompoundRule(uLocale, "gender", "times");
                if (deriveCompoundRule.length() == 1) {
                    char cCharAt = deriveCompoundRule.charAt(0);
                    if (cCharAt != '0') {
                        if (cCharAt == '1' && i6 == arrayList.size() - 1) {
                            strArr3[i10] = strArr5[i10];
                        }
                    } else if (i6 == 0) {
                        strArr3[i10] = strArr5[i10];
                    }
                } else if (strArr3[i10] == null) {
                    strArr3[i10] = deriveCompoundRule;
                }
            }
            StandardPlural[] standardPluralArrValues4 = StandardPlural.values();
            int length4 = standardPluralArrValues4.length;
            int i11 = 0;
            while (i11 < length4) {
                StandardPlural standardPluralFromString = standardPluralArrValues4[i11];
                int iOrdinal3 = standardPluralFromString.ordinal();
                if (strArr3[iOrdinal3] != null) {
                    if (str5 != null) {
                        standardPluralFromString = StandardPlural.fromString(str5);
                    }
                    standardPluralArr = standardPluralArrValues4;
                    extractCorePatternResultExtractCorePattern = extractCorePattern(getWithPlural(strArr5, standardPluralFromString));
                    i3 = length4;
                    placeholderPosition = extractCorePatternResultExtractCorePattern.placeholderPosition;
                    if (placeholderPosition != PlaceholderPosition.MIDDLE) {
                        dk0.p();
                        return;
                    }
                    if (placeholderPositionArr2[iOrdinal3] == null) {
                        placeholderPositionArr2[iOrdinal3] = placeholderPosition;
                        c2 = extractCorePatternResultExtractCorePattern.joinerChar;
                    }
                    if (prefix != MeasureUnit.MeasurePrefix.ONE) {
                        String strCompileToStringMinMaxArguments2 = SimpleFormatterImpl.compileToStringMinMaxArguments(compoundValue, sb, 1, 1);
                        if (unitWidth2 == NumberFormatter.UnitWidth.FULL_NAME) {
                            extractCorePatternResultExtractCorePattern.coreUnit = UCharacter.toLowerCase(uLocale, extractCorePatternResultExtractCorePattern.coreUnit);
                        }
                        i4 = 1;
                        extractCorePatternResultExtractCorePattern.coreUnit = SimpleFormatterImpl.formatCompiledPattern(strCompileToStringMinMaxArguments2, extractCorePatternResultExtractCorePattern.coreUnit);
                    } else {
                        i4 = 1;
                    }
                    if (dimensionality != i4) {
                        String strCompileToStringMinMaxArguments3 = SimpleFormatterImpl.compileToStringMinMaxArguments(getWithPlural(strArr4, standardPluralFromString), sb, i4, i4);
                        if (unitWidth2 == NumberFormatter.UnitWidth.FULL_NAME) {
                            extractCorePatternResultExtractCorePattern.coreUnit = UCharacter.toLowerCase(uLocale, extractCorePatternResultExtractCorePattern.coreUnit);
                        }
                        CharSequence[] charSequenceArr = new CharSequence[i4];
                        charSequenceArr[0] = extractCorePatternResultExtractCorePattern.coreUnit;
                        extractCorePatternResultExtractCorePattern.coreUnit = SimpleFormatterImpl.formatCompiledPattern(strCompileToStringMinMaxArguments3, charSequenceArr);
                    }
                    if (strArr[iOrdinal3].length() == 0) {
                        strArr[iOrdinal3] = extractCorePatternResultExtractCorePattern.coreUnit;
                        str2 = strCompileToStringMinMaxArguments;
                    } else {
                        str2 = strCompileToStringMinMaxArguments;
                        strArr[iOrdinal3] = SimpleFormatterImpl.formatCompiledPattern(str2, strArr[iOrdinal3], extractCorePatternResultExtractCorePattern.coreUnit);
                    }
                } else {
                    if (strArr5[iOrdinal3] == null) {
                        prefix = prefix;
                        standardPluralArr = standardPluralArrValues4;
                        i3 = length4;
                    } else {
                        strArr3[iOrdinal3] = getWithPlural(strArr3, standardPluralFromString);
                        if (str5 != null) {
                            standardPluralFromString = StandardPlural.fromString(str5);
                        }
                        standardPluralArr = standardPluralArrValues4;
                        extractCorePatternResultExtractCorePattern = extractCorePattern(getWithPlural(strArr5, standardPluralFromString));
                        i3 = length4;
                        placeholderPosition = extractCorePatternResultExtractCorePattern.placeholderPosition;
                        if (placeholderPosition != PlaceholderPosition.MIDDLE) {
                            dk0.p();
                            return;
                        }
                        if (placeholderPositionArr2[iOrdinal3] == null) {
                            placeholderPositionArr2[iOrdinal3] = placeholderPosition;
                            c2 = extractCorePatternResultExtractCorePattern.joinerChar;
                        }
                        if (prefix != MeasureUnit.MeasurePrefix.ONE) {
                            String strCompileToStringMinMaxArguments4 = SimpleFormatterImpl.compileToStringMinMaxArguments(compoundValue, sb, 1, 1);
                            if (unitWidth2 == NumberFormatter.UnitWidth.FULL_NAME) {
                                extractCorePatternResultExtractCorePattern.coreUnit = UCharacter.toLowerCase(uLocale, extractCorePatternResultExtractCorePattern.coreUnit);
                            }
                            i4 = 1;
                            extractCorePatternResultExtractCorePattern.coreUnit = SimpleFormatterImpl.formatCompiledPattern(strCompileToStringMinMaxArguments4, extractCorePatternResultExtractCorePattern.coreUnit);
                        } else {
                            i4 = 1;
                        }
                        if (dimensionality != i4) {
                            String strCompileToStringMinMaxArguments5 = SimpleFormatterImpl.compileToStringMinMaxArguments(getWithPlural(strArr4, standardPluralFromString), sb, i4, i4);
                            if (unitWidth2 == NumberFormatter.UnitWidth.FULL_NAME) {
                                extractCorePatternResultExtractCorePattern.coreUnit = UCharacter.toLowerCase(uLocale, extractCorePatternResultExtractCorePattern.coreUnit);
                            }
                            CharSequence[] charSequenceArr2 = new CharSequence[i4];
                            charSequenceArr2[0] = extractCorePatternResultExtractCorePattern.coreUnit;
                            extractCorePatternResultExtractCorePattern.coreUnit = SimpleFormatterImpl.formatCompiledPattern(strCompileToStringMinMaxArguments5, charSequenceArr2);
                        }
                        if (strArr[iOrdinal3].length() == 0) {
                            strArr[iOrdinal3] = extractCorePatternResultExtractCorePattern.coreUnit;
                        } else {
                            str2 = strCompileToStringMinMaxArguments;
                            strArr[iOrdinal3] = SimpleFormatterImpl.formatCompiledPattern(str2, strArr[iOrdinal3], extractCorePatternResultExtractCorePattern.coreUnit);
                        }
                    }
                    str2 = strCompileToStringMinMaxArguments;
                }
                i11++;
                strArr3 = strArr;
                strCompileToStringMinMaxArguments = str2;
                length4 = i3;
                standardPluralArrValues4 = standardPluralArr;
                prefix = prefix;
            }
            i6++;
            strArr3 = strArr;
            strCompileToStringMinMaxArguments = strCompileToStringMinMaxArguments;
            str3 = str8;
            placeholderPositionArr = placeholderPositionArr2;
            strValue1 = str7;
            derivedComponents2 = derivedComponents6;
            singleUnits = arrayList;
            strValue4 = str6;
            derivedComponents3 = derivedComponents3;
            c2 = c2;
            derivedComponents4 = derivedComponents;
        }
    }

    private void simpleFormatsToModifiers(String[] strArr, NumberFormat.Field field) {
        StringBuilder sb = new StringBuilder();
        for (StandardPlural standardPlural : StandardPlural.VALUES) {
            String strCompileToStringMinMaxArguments = SimpleFormatterImpl.compileToStringMinMaxArguments(getWithPlural(strArr, standardPlural), sb, 0, 1);
            Modifier.Parameters parameters = new Modifier.Parameters();
            parameters.obj = this;
            parameters.signum = null;
            parameters.plural = standardPlural;
            this.modifiers.put(standardPlural, new SimpleModifier(strCompileToStringMinMaxArguments, field, false, parameters));
        }
    }

    @Override // com.ibm.icu.impl.number.ModifierStore
    public Modifier getModifier(Modifier.Signum signum, StandardPlural standardPlural) {
        return this.modifiers.get(standardPlural);
    }

    @Override // com.ibm.icu.impl.number.MicroPropsGenerator
    public MicroProps processQuantity(DecimalQuantity decimalQuantity) {
        MicroProps microPropsProcessQuantity = this.parent.processQuantity(decimalQuantity);
        microPropsProcessQuantity.modOuter = this.modifiers.get(RoundingUtils.getPluralSafe(microPropsProcessQuantity.rounder, this.rules, decimalQuantity));
        microPropsProcessQuantity.gender = this.gender;
        return microPropsProcessQuantity;
    }

    @Override // com.ibm.icu.impl.number.LongNameMultiplexer.ParentlessMicroPropsGenerator
    public MicroProps processQuantityWithMicros(DecimalQuantity decimalQuantity, MicroProps microProps) {
        microProps.modOuter = this.modifiers.get(RoundingUtils.getPluralSafe(microProps.rounder, this.rules, decimalQuantity));
        return microProps;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class AliasSink extends UResource.Sink {
        String replacement;

        public /* synthetic */ AliasSink(int i) {
            this();
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (key.toString().equals("replacement")) {
                    this.replacement = value.toString();
                }
            }
        }

        private AliasSink() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ExtractCorePatternResult {
        String coreUnit;
        char joinerChar;
        PlaceholderPosition placeholderPosition;

        public /* synthetic */ ExtractCorePatternResult(int i) {
            this();
        }

        private ExtractCorePatternResult() {
        }
    }
}
