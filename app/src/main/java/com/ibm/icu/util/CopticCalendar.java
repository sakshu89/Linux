package com.ibm.icu.util;

import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CopticCalendar extends CECalendar {
    public static final int AMSHIR = 5;
    public static final int BABA = 1;
    public static final int BARAMHAT = 6;
    public static final int BARAMOUDA = 7;
    public static final int BASHANS = 8;
    private static final int BCE = 0;
    private static final int CE = 1;
    private static final int COPTIC_CALENDAR_RELATED_YEAR_DIFFERENCE = 284;
    public static final int EPEP = 10;
    public static final int HATOR = 2;
    private static final int JD_EPOCH_OFFSET = 1824665;
    public static final int KIAHK = 3;
    public static final int MESRA = 11;
    public static final int NASIE = 12;
    public static final int PAONA = 9;
    public static final int TOBA = 4;
    public static final int TOUT = 0;
    private static final long serialVersionUID = 5903818751846742911L;

    public CopticCalendar() {
    }

    public static int copticToJD(long j, int i, int i2) {
        return CECalendar.ceToJD(j, i, i2, JD_EPOCH_OFFSET);
    }

    @Override // com.ibm.icu.util.CECalendar
    @Deprecated
    public int extendedYearToEra(int i) {
        return i <= 0 ? 0 : 1;
    }

    @Override // com.ibm.icu.util.CECalendar
    @Deprecated
    public int extendedYearToYear(int i) {
        return i <= 0 ? 1 - i : i;
    }

    @Override // com.ibm.icu.util.CECalendar
    @Deprecated
    public int getJDEpochOffset() {
        return JD_EPOCH_OFFSET;
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public final int getRelatedYearDifference() {
        return 284;
    }

    @Override // com.ibm.icu.util.CECalendar, com.ibm.icu.util.Calendar
    public /* bridge */ /* synthetic */ String getTemporalMonthCode() {
        return super.getTemporalMonthCode();
    }

    @Override // com.ibm.icu.util.Calendar
    public String getType() {
        return "coptic";
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public int handleGetExtendedYear() {
        if (newerField(19, 1) == 19) {
            return internalGet(19, 1);
        }
        return internalGet(0, 1) == 0 ? 1 - internalGet(1, 1) : internalGet(1, 1);
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public boolean isEra0CountingBackward() {
        return true;
    }

    @Override // com.ibm.icu.util.CECalendar, com.ibm.icu.util.Calendar
    public /* bridge */ /* synthetic */ void setTemporalMonthCode(String str) {
        super.setTemporalMonthCode(str);
    }

    public CopticCalendar(TimeZone timeZone) {
        super(timeZone);
    }

    public CopticCalendar(Locale locale) {
        super(locale);
    }

    public CopticCalendar(ULocale uLocale) {
        super(uLocale);
    }

    public CopticCalendar(TimeZone timeZone, Locale locale) {
        super(timeZone, locale);
    }

    public CopticCalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
    }

    public CopticCalendar(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public CopticCalendar(Date date) {
        super(date);
    }

    public CopticCalendar(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5, i6);
    }
}
