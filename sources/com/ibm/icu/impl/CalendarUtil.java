package com.ibm.icu.impl;

import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CalendarUtil {
    private static final String CALKEY = "calendar";
    private static final String DEFCAL = "gregorian";

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class CalendarPreferences extends UResource.Sink {
        private static final CalendarPreferences INSTANCE = new CalendarPreferences();
        Map<String, String> prefs = new TreeMap();

        public CalendarPreferences() {
            try {
                ((ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "supplementalData")).getAllItemsWithFallback("calendarPreferenceData", this);
            } catch (MissingResourceException unused) {
            }
        }

        public String getCalendarTypeForRegion(String str) {
            String str2 = this.prefs.get(str);
            return str2 == null ? CalendarUtil.DEFCAL : str2;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (value.getArray().getValue(0, value)) {
                    String string = value.getString();
                    if (!string.equals(CalendarUtil.DEFCAL)) {
                        this.prefs.put(key.toString(), string);
                    }
                }
            }
        }
    }

    public static String getCalendarType(ULocale uLocale) {
        String keywordValue = uLocale.getKeywordValue(CALKEY);
        if (keywordValue != null) {
            return keywordValue.toLowerCase(Locale.ROOT);
        }
        ULocale uLocaleCreateCanonical = ULocale.createCanonical(uLocale.toString());
        String keywordValue2 = uLocaleCreateCanonical.getKeywordValue(CALKEY);
        if (keywordValue2 != null) {
            return keywordValue2;
        }
        return CalendarPreferences.INSTANCE.getCalendarTypeForRegion(ULocale.getRegionForSupplementalData(uLocaleCreateCanonical, true));
    }
}
