package com.ibm.icu.util;

import com.ibm.icu.impl.CalendarUtil;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class EthiopicCalendar extends CECalendar {
    private static final int AMETE_ALEM = 0;
    private static final int AMETE_ALEM_ERA = 1;
    private static final int AMETE_MIHRET = 1;
    private static final int AMETE_MIHRET_DELTA = 5500;
    private static final int AMETE_MIHRET_ERA = 0;
    private static final int ETHIOPIC_CALENDAR_RELATED_YEAR_DIFFERENCE = 8;
    public static final int GENBOT = 8;
    public static final int HAMLE = 10;
    public static final int HEDAR = 2;
    private static final int JD_EPOCH_OFFSET_AMETE_ALEM = -285019;
    private static final int JD_EPOCH_OFFSET_AMETE_MIHRET = 1723856;
    public static final int MEGABIT = 6;
    public static final int MESKEREM = 0;
    public static final int MIAZIA = 7;
    public static final int NEHASSE = 11;
    public static final int PAGUMEN = 12;
    public static final int SENE = 9;
    public static final int TAHSAS = 3;
    public static final int TEKEMT = 1;
    public static final int TER = 4;
    public static final int YEKATIT = 5;
    private static final long serialVersionUID = -2438495771339315608L;
    private int eraType;

    public EthiopicCalendar() {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public static int EthiopicToJD(long j, int i, int i2) {
        return CECalendar.ceToJD(j, i, i2, JD_EPOCH_OFFSET_AMETE_MIHRET);
    }

    private void setCalcTypeForLocale(ULocale uLocale) {
        if ("ethiopic-amete-alem".equals(CalendarUtil.getCalendarType(uLocale))) {
            setAmeteAlemEra(true);
        } else {
            setAmeteAlemEra(false);
        }
    }

    @Override // com.ibm.icu.util.CECalendar
    @Deprecated
    public int extendedYearToEra(int i) {
        return (!isAmeteAlemEra() && i > 0) ? 1 : 0;
    }

    @Override // com.ibm.icu.util.CECalendar
    @Deprecated
    public int extendedYearToYear(int i) {
        return (!isAmeteAlemEra() && i <= 0) ? i + AMETE_MIHRET_DELTA : i;
    }

    @Override // com.ibm.icu.util.CECalendar
    @Deprecated
    public int getJDEpochOffset() {
        return isAmeteAlemEra() ? JD_EPOCH_OFFSET_AMETE_ALEM : JD_EPOCH_OFFSET_AMETE_MIHRET;
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public final int getRelatedYearDifference() {
        return 8;
    }

    @Override // com.ibm.icu.util.CECalendar, com.ibm.icu.util.Calendar
    public /* bridge */ /* synthetic */ String getTemporalMonthCode() {
        return super.getTemporalMonthCode();
    }

    @Override // com.ibm.icu.util.Calendar
    public String getType() {
        return isAmeteAlemEra() ? "ethiopic-amete-alem" : "ethiopic";
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public int handleGetExtendedYear() {
        if (newerField(19, 1) == 19) {
            return internalGet(19, 1);
        }
        if (isAmeteAlemEra()) {
            return internalGet(1, 1);
        }
        return internalGet(0, 1) == 1 ? internalGet(1, 1) : internalGet(1, 1) - 5500;
    }

    @Override // com.ibm.icu.util.CECalendar, com.ibm.icu.util.Calendar
    @Deprecated
    public int handleGetLimit(int i, int i2) {
        if (isAmeteAlemEra() && i == 0) {
            return 0;
        }
        return super.handleGetLimit(i, i2);
    }

    public boolean isAmeteAlemEra() {
        return this.eraType == 1;
    }

    public void setAmeteAlemEra(boolean z) {
        this.eraType = z ? 1 : 0;
    }

    @Override // com.ibm.icu.util.CECalendar, com.ibm.icu.util.Calendar
    public /* bridge */ /* synthetic */ void setTemporalMonthCode(String str) {
        super.setTemporalMonthCode(str);
    }

    public EthiopicCalendar(TimeZone timeZone) {
        this(timeZone, ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public EthiopicCalendar(Locale locale) {
        this(TimeZone.forLocaleOrDefault(locale), locale);
    }

    public EthiopicCalendar(ULocale uLocale) {
        this(TimeZone.forULocaleOrDefault(uLocale), uLocale);
    }

    public EthiopicCalendar(TimeZone timeZone, Locale locale) {
        this(timeZone, ULocale.forLocale(locale));
    }

    public EthiopicCalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
        this.eraType = 0;
        setCalcTypeForLocale(uLocale);
    }

    public EthiopicCalendar(int i, int i2, int i3) {
        super(i, i2, i3);
        this.eraType = 0;
    }

    public EthiopicCalendar(Date date) {
        super(date);
        this.eraType = 0;
    }

    public EthiopicCalendar(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5, i6);
        this.eraType = 0;
    }
}
