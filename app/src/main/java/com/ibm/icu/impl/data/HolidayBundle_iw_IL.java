package com.ibm.icu.impl.data;

import com.ibm.icu.util.HebrewHoliday;
import com.ibm.icu.util.Holiday;
import java.util.ListResourceBundle;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class HolidayBundle_iw_IL extends ListResourceBundle {
    private static final Object[][] fContents;
    private static final Holiday[] fHolidays;

    static {
        Holiday[] holidayArr = {HebrewHoliday.ROSH_HASHANAH, HebrewHoliday.YOM_KIPPUR, HebrewHoliday.HANUKKAH, HebrewHoliday.PURIM, HebrewHoliday.PASSOVER, HebrewHoliday.SHAVUOT, HebrewHoliday.SELIHOT};
        fHolidays = holidayArr;
        fContents = new Object[][]{new Object[]{"holidays", holidayArr}};
    }

    @Override // java.util.ListResourceBundle
    public synchronized Object[][] getContents() {
        return fContents;
    }
}
