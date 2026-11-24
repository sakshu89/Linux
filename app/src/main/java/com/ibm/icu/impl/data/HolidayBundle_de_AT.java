package com.ibm.icu.impl.data;

import com.ibm.icu.util.EasterHoliday;
import com.ibm.icu.util.Holiday;
import com.ibm.icu.util.SimpleHoliday;
import java.util.ListResourceBundle;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class HolidayBundle_de_AT extends ListResourceBundle {
    private static final Object[][] fContents;
    private static final Holiday[] fHolidays;

    static {
        Holiday[] holidayArr = {SimpleHoliday.NEW_YEARS_DAY, SimpleHoliday.EPIPHANY, EasterHoliday.GOOD_FRIDAY, EasterHoliday.EASTER_SUNDAY, EasterHoliday.EASTER_MONDAY, EasterHoliday.ASCENSION, EasterHoliday.WHIT_SUNDAY, EasterHoliday.WHIT_MONDAY, EasterHoliday.CORPUS_CHRISTI, SimpleHoliday.ASSUMPTION, SimpleHoliday.ALL_SAINTS_DAY, SimpleHoliday.IMMACULATE_CONCEPTION, SimpleHoliday.CHRISTMAS, SimpleHoliday.ST_STEPHENS_DAY, new SimpleHoliday(4, 1, 0, "National Holiday"), new SimpleHoliday(9, 31, -2, "National Holiday")};
        fHolidays = holidayArr;
        fContents = new Object[][]{new Object[]{"holidays", holidayArr}, new Object[]{"Christmas", "Christtag"}, new Object[]{"New Year's Day", "Neujahrstag"}};
    }

    @Override // java.util.ListResourceBundle
    public synchronized Object[][] getContents() {
        return fContents;
    }
}
