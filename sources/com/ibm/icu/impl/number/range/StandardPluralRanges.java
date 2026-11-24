package com.ibm.icu.impl.number.range;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceTypeMismatchException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class StandardPluralRanges {
    public static final StandardPluralRanges DEFAULT = new StandardPluralRanges();
    StandardPlural[] flatTriples;
    int numTriples = 0;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class LanguageToSetHolder {
        static final Map<String, String> LANGUAGE_TO_SET;

        static {
            HashMap map = new HashMap();
            ((ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "pluralRanges")).getAllItemsWithFallback("locales", new PluralRangeSetsDataSink(map));
            HashMap map2 = new HashMap(map.size());
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                Objects.requireNonNull(key);
                Object value = entry.getValue();
                Objects.requireNonNull(value);
                map2.put(key, value);
            }
            LANGUAGE_TO_SET = Collections.unmodifiableMap(map2);
        }

        private LanguageToSetHolder() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class PluralRangeSetsDataSink extends UResource.Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        Map<String, String> output;

        public PluralRangeSetsDataSink(Map<String, String> map) {
            this.output = map;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                this.output.put(key.toString(), value.toString());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class PluralRangesDataSink extends UResource.Sink {
        StandardPluralRanges output;

        public PluralRangesDataSink(StandardPluralRanges standardPluralRanges) {
            this.output = standardPluralRanges;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Array array = value.getArray();
            this.output.setCapacity(array.getSize());
            for (int i = 0; array.getValue(i, value); i++) {
                UResource.Array array2 = value.getArray();
                if (array2.getSize() != 3) {
                    throw new UResourceTypeMismatchException("Expected 3 elements in pluralRanges.txt array");
                }
                array2.getValue(0, value);
                StandardPlural standardPluralFromString = StandardPlural.fromString(value.getString());
                array2.getValue(1, value);
                StandardPlural standardPluralFromString2 = StandardPlural.fromString(value.getString());
                array2.getValue(2, value);
                this.output.addPluralRange(standardPluralFromString, standardPluralFromString2, StandardPlural.fromString(value.getString()));
            }
        }
    }

    private StandardPluralRanges() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPluralRange(StandardPlural standardPlural, StandardPlural standardPlural2, StandardPlural standardPlural3) {
        StandardPlural[] standardPluralArr = this.flatTriples;
        int i = this.numTriples;
        standardPluralArr[i * 3] = standardPlural;
        standardPluralArr[(i * 3) + 1] = standardPlural2;
        standardPluralArr[(i * 3) + 2] = standardPlural3;
        this.numTriples = i + 1;
    }

    public static StandardPluralRanges forLocale(ULocale uLocale) {
        return forSet(getSetForLocale(uLocale));
    }

    public static StandardPluralRanges forSet(String str) {
        StandardPluralRanges standardPluralRanges = new StandardPluralRanges();
        if (str == null) {
            return DEFAULT;
        }
        getPluralRangesData(str, standardPluralRanges);
        return standardPluralRanges;
    }

    private static Map<String, String> getLanguageToSet() {
        return LanguageToSetHolder.LANGUAGE_TO_SET;
    }

    private static void getPluralRangesData(String str, StandardPluralRanges standardPluralRanges) {
        StringBuilder sb = new StringBuilder();
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "pluralRanges");
        sb.setLength(0);
        sb.append("rules/");
        sb.append(str);
        iCUResourceBundle.getAllItemsWithFallback(sb.toString(), new PluralRangesDataSink(standardPluralRanges));
    }

    public static String getSetForLocale(ULocale uLocale) {
        return getLanguageToSet().get(uLocale.getLanguage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCapacity(int i) {
        this.flatTriples = new StandardPlural[i * 3];
    }

    public StandardPlural resolve(StandardPlural standardPlural, StandardPlural standardPlural2) {
        for (int i = 0; i < this.numTriples; i++) {
            StandardPlural[] standardPluralArr = this.flatTriples;
            int i2 = i * 3;
            if (standardPlural == standardPluralArr[i2] && standardPlural2 == standardPluralArr[i2 + 1]) {
                return standardPluralArr[i2 + 2];
            }
        }
        return StandardPlural.OTHER;
    }
}
