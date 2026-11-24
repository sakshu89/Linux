package com.ibm.icu.util;

import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
abstract class CECalendar extends Calendar {
    private static final int[][] LIMITS = {new int[]{0, 0, 1, 1}, new int[]{1, 1, 5000000, 5000000}, new int[]{0, 0, 12, 12}, new int[]{1, 1, 52, 53}, new int[0], new int[]{1, 1, 5, 30}, new int[]{1, 1, 365, 366}, new int[0], new int[]{-1, -1, 1, 5}, new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[]{-5000000, -5000000, 5000000, 5000000}, new int[0], new int[]{-5000000, -5000000, 5000000, 5000000}, new int[0], new int[0], new int[0], new int[]{0, 0, 12, 12}};
    private static final long serialVersionUID = -999547623066414271L;

    public CECalendar(int i, int i2, int i3) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        set(i, i2, i3);
    }

    public static int ceToJD(long j, int i, int i2, int i3) {
        long j2;
        int i4;
        if (i >= 0) {
            j2 = j + ((long) (i / 13));
            i4 = i % 13;
        } else {
            int i5 = i + 1;
            j2 = j + ((long) ((i5 / 13) - 1));
            i4 = (i5 % 13) + 12;
        }
        return (int) ((((Calendar.floorDivide(j2, 4L) + ((365 * j2) + ((long) i3))) + ((long) (i4 * 30))) + ((long) i2)) - 1);
    }

    public static void jdToCE(int i, int i2, int[] iArr) {
        int[] iArr2 = new int[1];
        int iFloorDivide = Calendar.floorDivide(i - i2, 1461, iArr2) * 4;
        int i3 = iArr2[0];
        iArr[0] = ((i3 / 365) - (i3 / 1460)) + iFloorDivide;
        int i4 = iArr2[0];
        int i5 = i4 != 1460 ? i4 % 365 : 365;
        iArr[1] = i5 / 30;
        iArr[2] = (i5 % 30) + 1;
    }

    @Deprecated
    public abstract int extendedYearToEra(int i);

    @Deprecated
    public abstract int extendedYearToYear(int i);

    public abstract int getJDEpochOffset();

    @Override // com.ibm.icu.util.Calendar
    public String getTemporalMonthCode() {
        return get(2) == 12 ? "M13" : super.getTemporalMonthCode();
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public void handleComputeFields(int i) {
        int[] iArr = new int[3];
        jdToCE(i, getJDEpochOffset(), iArr);
        internalSet(19, iArr[0]);
        internalSet(0, extendedYearToEra(iArr[0]));
        internalSet(1, extendedYearToYear(iArr[0]));
        internalSet(2, iArr[1]);
        internalSet(23, iArr[1]);
        internalSet(5, iArr[2]);
        internalSet(6, (iArr[1] * 30) + iArr[2]);
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleComputeMonthStart(int i, int i2, boolean z) {
        return ceToJD(i, i2, 0, getJDEpochOffset());
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleGetLimit(int i, int i2) {
        return LIMITS[i][i2];
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleGetMonthLength(int i, int i2) {
        if ((i2 + 1) % 13 != 0) {
            return 30;
        }
        return ((i % 4) / 3) + 5;
    }

    @Override // com.ibm.icu.util.Calendar
    public void setTemporalMonthCode(String str) {
        if (!str.equals("M13")) {
            super.setTemporalMonthCode(str);
        } else {
            set(2, 12);
            set(22, 0);
        }
    }

    public CECalendar(TimeZone timeZone) {
        this(timeZone, ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public CECalendar(Locale locale) {
        this(TimeZone.forLocaleOrDefault(locale), locale);
    }

    public CECalendar(ULocale uLocale) {
        this(TimeZone.forULocaleOrDefault(uLocale), uLocale);
    }

    public CECalendar(TimeZone timeZone, Locale locale) {
        super(timeZone, locale);
        setTimeInMillis(System.currentTimeMillis());
    }

    public CECalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
        setTimeInMillis(System.currentTimeMillis());
    }

    public CECalendar() {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public CECalendar(Date date) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        setTime(date);
    }

    public CECalendar(int i, int i2, int i3, int i4, int i5, int i6) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        set(i, i2, i3, i4, i5, i6);
    }
}
