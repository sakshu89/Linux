package com.ibm.icu.impl.number;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.text.CompactDecimalFormat;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.og;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class CompactData implements MultiplierProducer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int COMPACT_MAX_DIGITS = 20;
    private static final String USE_FALLBACK = "<USE FALLBACK>";
    private final String[] patterns = new String[StandardPlural.COUNT * 21];
    private final byte[] multipliers = new byte[21];
    private byte largestMagnitude = 0;
    private boolean isEmpty = true;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class CompactDataSink extends UResource.Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        CompactData data;

        public CompactDataSink(CompactData compactData) {
            this.data = compactData;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            int iCountZeros;
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                byte length = (byte) (key.length() - 1);
                if (length < 20) {
                    byte b = this.data.multipliers[length];
                    UResource.Table table2 = value.getTable();
                    for (int i2 = 0; table2.getKeyAndValue(i2, key, value); i2++) {
                        StandardPlural standardPluralFromString = StandardPlural.fromString(key.toString());
                        if (this.data.patterns[CompactData.getIndex(length, standardPluralFromString)] == null) {
                            String string = value.toString();
                            if (string.equals("0")) {
                                string = CompactData.USE_FALLBACK;
                            }
                            this.data.patterns[CompactData.getIndex(length, standardPluralFromString)] = string;
                            if (b == 0 && (iCountZeros = CompactData.countZeros(string)) > 0) {
                                b = (byte) ((iCountZeros - length) - 1);
                            }
                        }
                    }
                    if (this.data.multipliers[length] == 0) {
                        this.data.multipliers[length] = b;
                        if (length > this.data.largestMagnitude) {
                            this.data.largestMagnitude = length;
                        }
                        this.data.isEmpty = false;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum CompactType {
        DECIMAL,
        CURRENCY
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int countZeros(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) != '0') {
                if (i > 0) {
                    break;
                }
            } else {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getIndex(int i, StandardPlural standardPlural) {
        return standardPlural.ordinal() + (i * StandardPlural.COUNT);
    }

    private static void getResourceBundleKey(String str, CompactDecimalFormat.CompactStyle compactStyle, CompactType compactType, StringBuilder sb) {
        sb.setLength(0);
        sb.append("NumberElements/");
        sb.append(str);
        sb.append(compactStyle == CompactDecimalFormat.CompactStyle.SHORT ? "/patternsShort" : "/patternsLong");
        sb.append(compactType == CompactType.DECIMAL ? "/decimalFormat" : "/currencyFormat");
    }

    @Override // com.ibm.icu.impl.number.MultiplierProducer
    public int getMultiplier(int i) {
        if (i < 0) {
            return 0;
        }
        byte b = this.largestMagnitude;
        if (i > b) {
            i = b;
        }
        return this.multipliers[i];
    }

    public String getPattern(int i, PluralRules pluralRules, DecimalQuantity decimalQuantity) {
        StandardPlural standardPlural;
        String str;
        if (i < 0) {
            return null;
        }
        byte b = this.largestMagnitude;
        if (i > b) {
            i = b;
        }
        if (decimalQuantity.isHasIntegerValue()) {
            long j = decimalQuantity.toLong(true);
            if (j == 0) {
                str = this.patterns[getIndex(i, StandardPlural.EQ_0)];
            } else {
                str = j == 1 ? this.patterns[getIndex(i, StandardPlural.EQ_1)] : null;
            }
            if (str != null) {
                return str;
            }
        }
        StandardPlural standardPlural2 = decimalQuantity.getStandardPlural(pluralRules);
        String str2 = this.patterns[getIndex(i, standardPlural2)];
        if (str2 == null && standardPlural2 != (standardPlural = StandardPlural.OTHER)) {
            str2 = this.patterns[getIndex(i, standardPlural)];
        }
        if (str2 == USE_FALLBACK) {
            return null;
        }
        return str2;
    }

    public void getUniquePatterns(Set<String> set) {
        set.addAll(Arrays.asList(this.patterns));
        set.remove(USE_FALLBACK);
        set.remove(null);
    }

    public void populate(Map<String, Map<String, String>> map) {
        for (Map.Entry<String, Map<String, String>> entry : map.entrySet()) {
            byte length = (byte) (entry.getKey().length() - 1);
            for (Map.Entry<String, String> entry2 : entry.getValue().entrySet()) {
                StandardPlural standardPluralFromString = StandardPlural.fromString(entry2.getKey().toString());
                String string = entry2.getValue().toString();
                this.patterns[getIndex(length, standardPluralFromString)] = string;
                int iCountZeros = countZeros(string);
                if (iCountZeros > 0) {
                    this.multipliers[length] = (byte) ((iCountZeros - length) - 1);
                    if (length > this.largestMagnitude) {
                        this.largestMagnitude = length;
                    }
                    this.isEmpty = false;
                }
            }
        }
    }

    public void populate(ULocale uLocale, String str, CompactDecimalFormat.CompactStyle compactStyle, CompactType compactType) {
        CompactDataSink compactDataSink = new CompactDataSink(this);
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale);
        boolean zEquals = str.equals("latn");
        CompactDecimalFormat.CompactStyle compactStyle2 = CompactDecimalFormat.CompactStyle.SHORT;
        boolean z = compactStyle == compactStyle2;
        StringBuilder sb = new StringBuilder();
        getResourceBundleKey(str, compactStyle, compactType, sb);
        iCUResourceBundle.getAllItemsWithFallbackNoFail(sb.toString(), compactDataSink);
        if (this.isEmpty && !zEquals) {
            getResourceBundleKey("latn", compactStyle, compactType, sb);
            iCUResourceBundle.getAllItemsWithFallbackNoFail(sb.toString(), compactDataSink);
        }
        if (this.isEmpty && !z) {
            getResourceBundleKey(str, compactStyle2, compactType, sb);
            iCUResourceBundle.getAllItemsWithFallbackNoFail(sb.toString(), compactDataSink);
        }
        if (this.isEmpty && !zEquals && !z) {
            getResourceBundleKey("latn", compactStyle2, compactType, sb);
            iCUResourceBundle.getAllItemsWithFallbackNoFail(sb.toString(), compactDataSink);
        }
        if (this.isEmpty) {
            og.q("Could not load compact decimal data for locale ".concat(String.valueOf(uLocale)));
        }
    }
}
