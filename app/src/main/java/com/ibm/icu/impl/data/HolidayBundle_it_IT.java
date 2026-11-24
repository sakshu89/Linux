package com.ibm.icu.impl.data;

import com.ibm.icu.util.EasterHoliday;
import com.ibm.icu.util.Holiday;
import com.ibm.icu.util.SimpleHoliday;
import java.util.ListResourceBundle;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class HolidayBundle_it_IT extends ListResourceBundle {
    private static final Object[][] fContents;
    private static final Holiday[] fHolidays;

    static {
        Holiday[] holidayArr = {SimpleHoliday.NEW_YEARS_DAY, SimpleHoliday.EPIPHANY, new SimpleHoliday(3, 1, 0, "Liberation Day"), new SimpleHoliday(4, 1, 0, "Labor Day"), SimpleHoliday.ASSUMPTION, SimpleHoliday.ALL_SAINTS_DAY, SimpleHoliday.IMMACULATE_CONCEPTION, SimpleHoliday.CHRISTMAS, new SimpleHoliday(11, 26, 0, "St. Stephens Day"), SimpleHoliday.NEW_YEARS_EVE, EasterHoliday.EASTER_SUNDAY, EasterHoliday.EASTER_MONDAY};
        fHolidays = holidayArr;
        fContents = new Object[][]{new Object[]{"holidays", holidayArr}};
    }

    @Override // java.util.ListResourceBundle
    public synchronized Object[][] getContents() {
        return fContents;
    }
}
