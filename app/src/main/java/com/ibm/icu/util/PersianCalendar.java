package com.ibm.icu.util;

import com.ibm.icu.lang.UCharacter;
import java.util.BitSet;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class PersianCalendar extends Calendar {
    private static final int PERSIAN_CALENDAR_RELATED_YEAR_DIFFERENCE = 622;
    private static final int PERSIAN_EPOCH = 1948320;
    private static final long serialVersionUID = -6727306982975111643L;
    private static final int[][] MONTH_COUNT = {new int[]{31, 31, 0}, new int[]{31, 31, 31}, new int[]{31, 31, 62}, new int[]{31, 31, 93}, new int[]{31, 31, 124}, new int[]{31, 31, 155}, new int[]{30, 30, 186}, new int[]{30, 30, UCharacter.UnicodeBlock.MIAO_ID}, new int[]{30, 30, UCharacter.UnicodeBlock.PSALTER_PAHLAVI_ID}, new int[]{30, 30, UCharacter.UnicodeBlock.MASARAM_GONDI_ID}, new int[]{30, 30, UCharacter.UnicodeBlock.SYMBOLS_FOR_LEGACY_COMPUTING_ID}, new int[]{29, 30, UCharacter.UnicodeBlock.SYMBOLS_FOR_LEGACY_COMPUTING_SUPPLEMENT_ID}};
    private static NonLeapYears LEAP_CORRECTION = new NonLeapYears();
    private static final int[][] LIMITS = {new int[]{0, 0, 0, 0}, new int[]{-5000000, -5000000, 5000000, 5000000}, new int[]{0, 0, 11, 11}, new int[]{1, 1, 52, 53}, new int[0], new int[]{1, 1, 29, 31}, new int[]{1, 1, 365, 366}, new int[0], new int[]{-1, -1, 5, 5}, new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[]{-5000000, -5000000, 5000000, 5000000}, new int[0], new int[]{-5000000, -5000000, 5000000, 5000000}, new int[0], new int[0], new int[0], new int[]{0, 0, 11, 11}};

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NonLeapYears {
        private static final int[] NON_LEAP_YEARS = {1502, 1601, 1634, 1667, 1700, 1733, 1766, 1799, 1832, 1865, 1898, 1931, 1964, 1997, 2030, 2059, 2063, 2096, 2129, 2158, 2162, 2191, 2195, 2224, 2228, 2257, 2261, 2290, 2294, 2323, 2327, 2356, 2360, 2389, 2393, 2422, 2426, 2455, 2459, 2488, 2492, 2521, 2525, 2554, 2558, 2587, 2591, 2620, 2624, 2653, 2657, 2686, 2690, 2719, 2723, 2748, 2752, 2756, 2781, 2785, 2789, 2818, 2822, 2847, 2851, 2855, 2880, 2884, 2888, 2913, 2917, 2921, 2946, 2950, 2954, 2979, 2983, 2987};
        private int maxYear;
        private int minYear;
        private BitSet offsetYears;

        public NonLeapYears() {
            int[] iArr = NON_LEAP_YEARS;
            this.minYear = iArr[0];
            this.maxYear = iArr[iArr.length - 1];
            this.offsetYears = new BitSet((this.maxYear - this.minYear) + 1);
            for (int i : iArr) {
                this.offsetYears.set(i - this.minYear);
            }
        }

        public boolean contains(int i) {
            int i2 = this.minYear;
            return i2 <= i && i <= this.maxYear && this.offsetYears.get(i - i2);
        }
    }

    @Deprecated
    public PersianCalendar(int i, int i2, int i3, int i4, int i5, int i6) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        set(1, i);
        set(2, i2);
        set(5, i3);
        set(11, i4);
        set(12, i5);
        set(13, i6);
    }

    private static long firstJulianOfYear(int i) {
        long j = i;
        long jFloorDivide = Calendar.floorDivide((j * 8) + 21, 33L) + ((j - 1) * 365);
        return LEAP_CORRECTION.contains(i + (-1)) ? jFloorDivide - 1 : jFloorDivide;
    }

    private static final boolean isLeapYear(int i) {
        if (LEAP_CORRECTION.contains(i)) {
            return false;
        }
        if (LEAP_CORRECTION.contains(i - 1)) {
            return true;
        }
        int[] iArr = new int[1];
        Calendar.floorDivide((i * 25) + 11, 33, iArr);
        return iArr[0] < 8;
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public final int getRelatedYearDifference() {
        return PERSIAN_CALENDAR_RELATED_YEAR_DIFFERENCE;
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public String getType() {
        return "persian";
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public void handleComputeFields(int i) {
        long j = i - PERSIAN_EPOCH;
        int iFloorDivide = (int) Calendar.floorDivide((33 * j) + 3, 12053L);
        int i2 = iFloorDivide + 1;
        int iFirstJulianOfYear = (int) (j - firstJulianOfYear(i2));
        if (iFirstJulianOfYear == 365 && LEAP_CORRECTION.contains(i2)) {
            i2 = iFloorDivide + 2;
            iFirstJulianOfYear = 0;
        }
        int i3 = iFirstJulianOfYear < 216 ? iFirstJulianOfYear / 31 : (iFirstJulianOfYear - 6) / 30;
        int i4 = iFirstJulianOfYear + 1;
        int i5 = i4 - MONTH_COUNT[i3][2];
        internalSet(0, 0);
        internalSet(1, i2);
        internalSet(19, i2);
        internalSet(2, i3);
        internalSet(23, i3);
        internalSet(5, i5);
        internalSet(6, i4);
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public int handleComputeMonthStart(int i, int i2, boolean z) {
        if (i2 < 0 || i2 > 11) {
            int[] iArr = new int[1];
            i += Calendar.floorDivide(i2, 12, iArr);
            i2 = iArr[0];
        }
        long jFirstJulianOfYear = firstJulianOfYear(i) + 1948319;
        if (i2 != 0) {
            jFirstJulianOfYear += (long) MONTH_COUNT[i2][2];
        }
        return (int) jFirstJulianOfYear;
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public int handleGetExtendedYear() {
        return newerField(19, 1) == 19 ? internalGet(19, 1) : internalGet(1, 1);
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public int handleGetLimit(int i, int i2) {
        return LIMITS[i][i2];
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public int handleGetMonthLength(int i, int i2) {
        if (i2 < 0 || i2 > 11) {
            int[] iArr = new int[1];
            i += Calendar.floorDivide(i2, 12, iArr);
            i2 = iArr[0];
        }
        return MONTH_COUNT[i2][isLeapYear(i) ? 1 : 0];
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public int handleGetYearLength(int i) {
        return isLeapYear(i) ? 366 : 365;
    }

    @Deprecated
    public PersianCalendar(TimeZone timeZone) {
        this(timeZone, ULocale.getDefault(ULocale.Category.FORMAT));
    }

    @Deprecated
    public PersianCalendar(Locale locale) {
        this(TimeZone.forLocaleOrDefault(locale), locale);
    }

    @Deprecated
    public PersianCalendar(ULocale uLocale) {
        this(TimeZone.forULocaleOrDefault(uLocale), uLocale);
    }

    @Deprecated
    public PersianCalendar(TimeZone timeZone, Locale locale) {
        super(timeZone, locale);
        setTimeInMillis(System.currentTimeMillis());
    }

    @Deprecated
    public PersianCalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
        setTimeInMillis(System.currentTimeMillis());
    }

    @Deprecated
    public PersianCalendar(Date date) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        setTime(date);
    }

    @Deprecated
    public PersianCalendar(int i, int i2, int i3) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        set(1, i);
        set(2, i2);
        set(5, i3);
    }

    @Deprecated
    public PersianCalendar() {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
    }
}
