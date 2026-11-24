package com.ibm.icu.impl.data;

import com.ibm.icu.util.EasterHoliday;
import com.ibm.icu.util.Holiday;
import com.ibm.icu.util.SimpleHoliday;
import java.util.ListResourceBundle;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class HolidayBundle_da_DK extends ListResourceBundle {
    private static final Object[][] fContents;
    private static final Holiday[] fHolidays;

    static {
        Holiday[] holidayArr = {SimpleHoliday.NEW_YEARS_DAY, new SimpleHoliday(3, 30, -6, "General Prayer Day"), new SimpleHoliday(5, 5, "Constitution Day"), SimpleHoliday.CHRISTMAS_EVE, SimpleHoliday.CHRISTMAS, SimpleHoliday.BOXING_DAY, SimpleHoliday.NEW_YEARS_EVE, EasterHoliday.MAUNDY_THURSDAY, EasterHoliday.GOOD_FRIDAY, EasterHoliday.EASTER_SUNDAY, EasterHoliday.EASTER_MONDAY, EasterHoliday.ASCENSION, EasterHoliday.WHIT_MONDAY};
        fHolidays = holidayArr;
        fContents = new Object[][]{new Object[]{"holidays", holidayArr}};
    }

    @Override // java.util.ListResourceBundle
    public synchronized Object[][] getContents() {
        return fContents;
    }
}
