package com.ibm.icu.impl.units;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.IllegalIcuArgumentException;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class UnitsData {
    private static List<UnitAliases.Alias> aliases;
    private static int[] simpleUnitCategories;
    private static String[] simpleUnits;
    private ConversionRates conversionRates = new ConversionRates();
    private UnitPreferences unitPreferences = new UnitPreferences();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Categories {
        static HashMap<String, Integer> baseUnitToIndex;
        static String[] indexToCategory;

        static {
            ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "units");
            CategoriesSink categoriesSink = new CategoriesSink();
            iCUResourceBundle.getAllItemsWithFallback(Constants.CATEGORY_TABLE_NAME, categoriesSink);
            baseUnitToIndex = categoriesSink.mapFromUnitToIndex;
            indexToCategory = (String[]) categoriesSink.categories.toArray(new String[0]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CategoriesSink extends UResource.Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        HashMap<String, Integer> mapFromUnitToIndex = new HashMap<>();
        ArrayList<String> categories = new ArrayList<>();

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Array array = value.getArray();
            for (int i = 0; array.getValue(i, value); i++) {
                value.getTable().getKeyAndValue(0, key, value);
                this.mapFromUnitToIndex.put(key.toString(), Integer.valueOf(this.categories.size()));
                this.categories.add(value.toString());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Constants {
        public static final String CATEGORY_TABLE_NAME = "unitQuantities";
        public static final String CONVERSION_UNIT_TABLE_NAME = "convertUnits";
        public static final String DEFAULT_REGION = "001";
        public static final String DEFAULT_USAGE = "default";
        public static final String UNIT_PREFERENCE_TABLE_NAME = "unitPreferenceData";
        public static final int kAliasOffset = 51200;
        public static final int kCompoundPartOffset = 128;
        public static final int kInitialCompoundPartOffset = 192;
        public static final int kPowerPartOffset = 256;
        public static final int kPrefixOffset = 64;
        public static final int kSimpleUnitOffset = 512;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class SimpleUnitIdentifiersSink extends UResource.Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        String[] simpleUnits = null;
        int[] simpleUnitCategories = null;

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            for (int i2 = 0; table.getKeyAndValue(i2, key, value); i2++) {
                if (!key.toString().equals("kilogram") && value.getTable().findValue("target", value)) {
                    String string = value.getString();
                    arrayList.add(key.toString());
                    arrayList2.add(Categories.baseUnitToIndex.get(string));
                }
            }
            this.simpleUnits = (String[]) arrayList.toArray(new String[0]);
            this.simpleUnitCategories = new int[arrayList2.size()];
            Iterator it = arrayList2.iterator();
            while (true) {
                int[] iArr = this.simpleUnitCategories;
                if (i >= iArr.length) {
                    return;
                }
                iArr[i] = ((Integer) it.next()).intValue();
                i++;
            }
        }
    }

    static {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "units");
        SimpleUnitIdentifiersSink simpleUnitIdentifiersSink = new SimpleUnitIdentifiersSink();
        iCUResourceBundle.getAllItemsWithFallback(Constants.CONVERSION_UNIT_TABLE_NAME, simpleUnitIdentifiersSink);
        simpleUnits = simpleUnitIdentifiersSink.simpleUnits;
        simpleUnitCategories = simpleUnitIdentifiersSink.simpleUnitCategories;
        aliases = new UnitAliases().getAliases();
    }

    public static List<UnitAliases.Alias> getAliases() {
        return aliases;
    }

    public static int getCategoryIndexOfSimpleUnit(int i) {
        return simpleUnitCategories[i];
    }

    public static String getReplacementFromAliasIndex(int i) {
        return aliases.get(i).replacement;
    }

    public static String[] getSimpleUnits() {
        return simpleUnits;
    }

    public String getCategory(MeasureUnitImpl measureUnitImpl) {
        MeasureUnitImpl measureUnitImplExtractCompoundBaseUnit = getConversionRates().extractCompoundBaseUnit(measureUnitImpl);
        measureUnitImplExtractCompoundBaseUnit.serialize();
        Integer num = Categories.baseUnitToIndex.get(measureUnitImplExtractCompoundBaseUnit.getIdentifier());
        if (num == null) {
            measureUnitImplExtractCompoundBaseUnit.takeReciprocal();
            measureUnitImplExtractCompoundBaseUnit.serialize();
            num = Categories.baseUnitToIndex.get(measureUnitImplExtractCompoundBaseUnit.getIdentifier());
        }
        measureUnitImplExtractCompoundBaseUnit.takeReciprocal();
        MeasureUnitImpl measureUnitImplCopyAndSimplify = measureUnitImplExtractCompoundBaseUnit.copyAndSimplify();
        if (num == null) {
            measureUnitImplCopyAndSimplify.serialize();
            num = Categories.baseUnitToIndex.get(measureUnitImplCopyAndSimplify.getIdentifier());
        }
        if (num == null) {
            measureUnitImplCopyAndSimplify.takeReciprocal();
            measureUnitImplCopyAndSimplify.serialize();
            num = Categories.baseUnitToIndex.get(measureUnitImplCopyAndSimplify.getIdentifier());
        }
        if (num != null) {
            return Categories.indexToCategory[num.intValue()];
        }
        throw new IllegalIcuArgumentException(cq.j("This unit does not has a category", measureUnitImpl.getIdentifier()));
    }

    public ConversionRates getConversionRates() {
        return this.conversionRates;
    }

    public UnitPreferences.UnitPreference[] getPreferencesFor(String str, String str2, ULocale uLocale) {
        return this.unitPreferences.getPreferencesFor(str, str2, uLocale, this);
    }

    public UnitPreferences getUnitPreferences() {
        return this.unitPreferences;
    }
}
