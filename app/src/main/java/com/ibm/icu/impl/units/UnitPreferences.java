package com.ibm.icu.impl.units;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class UnitPreferences {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Map<String, String> measurementSystem;
    private HashMap<String, HashMap<String, UnitPreference[]>> mapToUnitPreferences;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class UnitPreference {
        private final BigDecimal geq;
        private final String skeleton;
        private final String unit;

        public UnitPreference(String str, String str2, String str3) {
            this.unit = str;
            this.geq = str2 == null ? BigDecimal.valueOf(Double.MIN_VALUE) : new BigDecimal(str2);
            this.skeleton = str3 == null ? "" : str3;
        }

        public BigDecimal getGeq() {
            return this.geq;
        }

        public String getSkeleton() {
            return this.skeleton;
        }

        public String getUnit() {
            return this.unit;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class UnitPreferencesSink extends UResource.Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private HashMap<String, HashMap<String, UnitPreference[]>> mapToUnitPreferences = new HashMap<>();

        private void insertUnitPreferences(String str, String str2, String str3, UnitPreference[] unitPreferenceArr) {
            HashMap<String, UnitPreference[]> map;
            String strFormMapKey = UnitPreferences.formMapKey(str, str2);
            if (this.mapToUnitPreferences.containsKey(strFormMapKey)) {
                map = this.mapToUnitPreferences.get(strFormMapKey);
            } else {
                HashMap<String, UnitPreference[]> map2 = new HashMap<>();
                this.mapToUnitPreferences.put(strFormMapKey, map2);
                map = map2;
            }
            map.put(str3, unitPreferenceArr);
        }

        public HashMap<String, HashMap<String, UnitPreference[]>> getMapToUnitPreferences() {
            return this.mapToUnitPreferences;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Value value2 = value;
            UResource.Table table = value2.getTable();
            int i = 0;
            while (table.getKeyAndValue(i, key, value2)) {
                String string = key.toString();
                UResource.Table table2 = value2.getTable();
                int i2 = 0;
                while (table2.getKeyAndValue(i2, key, value2)) {
                    String string2 = key.toString();
                    UResource.Table table3 = value2.getTable();
                    int i3 = 0;
                    while (table3.getKeyAndValue(i3, key, value2)) {
                        String string3 = key.toString();
                        UResource.Array array = value2.getArray();
                        ArrayList arrayList = new ArrayList();
                        int i4 = 0;
                        while (array.getValue(i4, value2)) {
                            UResource.Table table4 = value2.getTable();
                            String string4 = null;
                            UResource.Table table5 = table;
                            String string5 = "1";
                            int i5 = i;
                            String string6 = "";
                            UResource.Table table6 = table2;
                            int i6 = 0;
                            while (table4.getKeyAndValue(i6, key, value2)) {
                                String string7 = key.toString();
                                if ("unit".equals(string7)) {
                                    string4 = value.getString();
                                } else if ("geq".equals(string7)) {
                                    string5 = value.getString();
                                } else if ("skeleton".equals(string7)) {
                                    string6 = value.getString();
                                }
                                i6++;
                                key = key;
                                value2 = value;
                            }
                            arrayList.add(new UnitPreference(string4, string5, string6));
                            i4++;
                            key = key;
                            value2 = value;
                            table = table5;
                            i = i5;
                            table2 = table6;
                        }
                        insertUnitPreferences(string, string2, string3, (UnitPreference[]) arrayList.toArray(new UnitPreference[0]));
                        i3++;
                        key = key;
                        value2 = value;
                        table = table;
                    }
                    i2++;
                    key = key;
                    value2 = value;
                    table = table;
                }
                i++;
                value2 = value;
                table = table;
            }
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("metric", UnitsData.Constants.DEFAULT_REGION);
        map.put("ussystem", "US");
        map.put("uksystem", "GB");
        measurementSystem = Collections.unmodifiableMap(map);
    }

    public UnitPreferences() {
        this.mapToUnitPreferences = new HashMap<>();
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "units");
        UnitPreferencesSink unitPreferencesSink = new UnitPreferencesSink();
        iCUResourceBundle.getAllItemsWithFallback(UnitsData.Constants.UNIT_PREFERENCE_TABLE_NAME, unitPreferencesSink);
        this.mapToUnitPreferences = unitPreferencesSink.getMapToUnitPreferences();
    }

    public static String formMapKey(String str, String str2) {
        return cq.k(str, "++", str2);
    }

    private static String[] getAllUsages(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        int length = str.length();
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            if (str.charAt(length) == '-') {
                arrayList.add(str.substring(0, length));
            }
        }
        if (!str.equals(UnitsData.Constants.DEFAULT_USAGE)) {
            arrayList.add(UnitsData.Constants.DEFAULT_USAGE);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private UnitPreference[] getUnitPreferences(String str, String str2, String str3) {
        String strFormMapKey = formMapKey(str, str2);
        if (!this.mapToUnitPreferences.containsKey(strFormMapKey)) {
            return null;
        }
        HashMap<String, UnitPreference[]> map = this.mapToUnitPreferences.get(strFormMapKey);
        return map.containsKey(str3) ? map.get(str3) : map.get(UnitsData.Constants.DEFAULT_REGION);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00cd A[LOOP:0: B:18:0x0057->B:40:0x00cd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:45:0x00d3 A[EDGE_INSN: B:45:0x00d3->B:41:0x00d3 BREAK  A[LOOP:0: B:18:0x0057->B:40:0x00cd], SYNTHETIC] */
    public UnitPreference[] getPreferencesFor(String str, String str2, ULocale uLocale, UnitsData unitsData) {
        String str3;
        String category;
        UnitPreference[] unitPreferences = null;
        if ("temperature".equals(str)) {
            String keywordValue = uLocale.getKeywordValue("mu");
            if ("fahrenhe".equals(keywordValue)) {
                keywordValue = "fahrenheit";
            }
            if (keywordValue == null) {
                category = null;
            } else {
                try {
                    category = unitsData.getCategory(MeasureUnitImpl.forIdentifier(keywordValue));
                } catch (Exception unused) {
                    category = null;
                }
            }
            if (category != null && str.equals(category)) {
                return new UnitPreference[]{new UnitPreference(keywordValue, null, null)};
            }
        }
        boolean z = true;
        String regionForSupplementalData = ULocale.getRegionForSupplementalData(uLocale, true);
        String keywordValue2 = uLocale.getKeywordValue("measure");
        boolean zContainsKey = measurementSystem.containsKey(keywordValue2);
        String[] allUsages = getAllUsages(str2);
        int length = allUsages.length;
        int i = 0;
        while (i < length) {
            String str4 = allUsages[i];
            UnitPreference[] unitPreferences2 = getUnitPreferences(str, str4, regionForSupplementalData);
            if (unitPreferences2 == null || !zContainsKey) {
                str3 = regionForSupplementalData;
            } else {
                ConversionRates conversionRates = new ConversionRates();
                int length2 = unitPreferences2.length;
                boolean z2 = z;
                int i2 = 0;
                while (i2 < length2) {
                    ArrayList arrayList = new ArrayList(MeasureUnitImpl.forIdentifier(unitPreferences2[i2].getUnit()).getSingleUnits());
                    int size = arrayList.size();
                    String str5 = regionForSupplementalData;
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        int i4 = i3 + 1;
                        ArrayList arrayList2 = arrayList;
                        String strExtractSystems = conversionRates.extractSystems((SingleUnitImpl) obj);
                        if (!strExtractSystems.contains("metric_adjacent") && !strExtractSystems.contains(keywordValue2)) {
                            z2 = false;
                        }
                        arrayList = arrayList2;
                        i3 = i4;
                    }
                    i2++;
                    regionForSupplementalData = str5;
                }
                str3 = regionForSupplementalData;
                if (!z2) {
                    unitPreferences = getUnitPreferences(str, str4, measurementSystem.get(keywordValue2));
                }
                if (unitPreferences != null) {
                    break;
                }
                i++;
                regionForSupplementalData = str3;
                z = true;
            }
            unitPreferences = unitPreferences2;
            if (unitPreferences != null) {
                break;
                break;
            }
            i++;
            regionForSupplementalData = str3;
            z = true;
        }
        return unitPreferences;
    }
}
