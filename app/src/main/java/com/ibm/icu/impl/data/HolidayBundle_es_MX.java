package com.ibm.icu.impl.data;

import com.ibm.icu.util.Holiday;
import com.ibm.icu.util.SimpleHoliday;
import java.util.ListResourceBundle;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class HolidayBundle_es_MX extends ListResourceBundle {
    private static final Object[][] fContents;
    private static final Holiday[] fHolidays;

    static {
        Holiday[] holidayArr = {SimpleHoliday.NEW_YEARS_DAY, new SimpleHoliday(1, 5, 0, "Constitution Day"), new SimpleHoliday(2, 21, 0, "Benito Juárez Day"), SimpleHoliday.MAY_DAY, new SimpleHoliday(4, 5, 0, "Cinco de Mayo"), new SimpleHoliday(5, 1, 0, "Navy Day"), new SimpleHoliday(8, 16, 0, "Independence Day"), new SimpleHoliday(9, 12, 0, "Día de la Raza"), SimpleHoliday.ALL_SAINTS_DAY, new SimpleHoliday(10, 2, 0, "Day of the Dead"), new SimpleHoliday(10, 20, 0, "Revolution Day"), new SimpleHoliday(11, 12, 0, "Flag Day"), SimpleHoliday.CHRISTMAS};
        fHolidays = holidayArr;
        fContents = new Object[][]{new Object[]{"holidays", holidayArr}};
    }

    @Override // java.util.ListResourceBundle
    public synchronized Object[][] getContents() {
        return fContents;
    }
}
