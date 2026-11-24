package com.ibm.icu.util;

import com.ibm.icu.impl.CalendarAstronomer;
import com.ibm.icu.impl.CalendarCache;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.DateFormat;
import defpackage.cq;
import defpackage.og;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ChineseCalendar extends Calendar {
    private static final int CHINESE_EPOCH_YEAR = 1;
    private static final int CYCLE_EPOCH = -2636;
    private static final int SYNODIC_GAP = 25;
    private static final long serialVersionUID = 7312110751940929420L;
    private transient boolean hasLeapMonthBetweenWinterSolstices;
    private transient CalendarCache newYearCache;
    private transient CalendarCache winterSolsticeCache;
    private TimeZone zoneAstro;
    private static final int[][] LIMITS = {new int[]{1, 1, 83333, 83333}, new int[]{1, 1, 60, 60}, new int[]{0, 0, 11, 11}, new int[]{1, 1, 50, 55}, new int[0], new int[]{1, 1, 29, 30}, new int[]{1, 1, UCharacter.UnicodeBlock.SEAL_ID, 385}, new int[0], new int[]{-1, -1, 5, 5}, new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[]{-5000000, -5000000, 5000000, 5000000}, new int[0], new int[]{-5000000, -5000000, 5000000, 5000000}, new int[0], new int[0], new int[]{0, 0, 1, 1}, new int[]{0, 0, 11, 12}};
    static final int[][][] CHINESE_DATE_PRECEDENCE = {new int[][]{new int[]{5}, new int[]{3, 7}, new int[]{4, 7}, new int[]{8, 7}, new int[]{3, 18}, new int[]{4, 18}, new int[]{8, 18}, new int[]{6}, new int[]{37, 22}}, new int[][]{new int[]{3}, new int[]{4}, new int[]{8}, new int[]{40, 7}, new int[]{40, 18}}};
    private static final TimeZone CHINA_ZONE = new SimpleTimeZone(28800000, "CHINA_ZONE").freeze();
    private static String[] gTemporalLeapMonthCodes = {"M01L", "M02L", "M03L", "M04L", "M05L", "M06L", "M07L", "M08L", "M09L", "M10L", "M11L", "M12L"};

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class MonthInfo {
        boolean hasLeapMonthBetweenWinterSolstices;
        boolean isLeapMonth;
        int month;
        int ordinalMonth;
        int thisMoon;

        public MonthInfo(int i, int i2, int i3, boolean z, boolean z2) {
            this.month = i;
            this.ordinalMonth = i2;
            this.thisMoon = i3;
            this.isLeapMonth = z;
            this.hasLeapMonthBetweenWinterSolstices = z2;
        }
    }

    public ChineseCalendar(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT), CHINA_ZONE);
        set(14, 0);
        set(0, i);
        set(1, i2);
        set(2, i3);
        set(22, i4);
        set(5, i5);
        set(11, i6);
        set(12, i7);
        set(13, i8);
    }

    private MonthInfo computeMonthInfo(int i, int i2) {
        int iWinterSolstice;
        int iWinterSolstice2 = winterSolstice(i2);
        if (i < iWinterSolstice2) {
            iWinterSolstice = iWinterSolstice2;
            iWinterSolstice2 = winterSolstice(i2 - 1);
        } else {
            iWinterSolstice = winterSolstice(i2 + 1);
        }
        int iNewMoonNear = newMoonNear(iWinterSolstice2 + 1, true);
        int iNewMoonNear2 = newMoonNear(iWinterSolstice + 1, false);
        int iNewMoonNear3 = newMoonNear(i + 1, false);
        boolean z = synodicMonthsBetween(iNewMoonNear, iNewMoonNear2) == 12;
        int iSynodicMonthsBetween = synodicMonthsBetween(iNewMoonNear, iNewMoonNear3);
        int iNewYear = newYear(i2);
        if (i < iNewYear) {
            iNewYear = newYear(i2 - 1);
        }
        if (z && isLeapMonthBetween(iNewMoonNear, iNewMoonNear3)) {
            iSynodicMonthsBetween--;
        }
        if (iSynodicMonthsBetween < 1) {
            iSynodicMonthsBetween += 12;
        }
        int iSynodicMonthsBetween2 = synodicMonthsBetween(iNewYear, iNewMoonNear3);
        if (iSynodicMonthsBetween2 < 0) {
            iSynodicMonthsBetween2 += 12;
        }
        return new MonthInfo(iSynodicMonthsBetween - 1, iSynodicMonthsBetween2, iNewMoonNear3, z && hasNoMajorSolarTerm(iNewMoonNear3) && !isLeapMonthBetween(iNewMoonNear, newMoonNear(iNewMoonNear3 + (-25), false)), z);
    }

    private final long daysToMillis(int i) {
        long j = ((long) i) * CalendarAstronomer.DAY_MS;
        return j - ((long) this.zoneAstro.getOffset(j));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0039  */
    private int handleComputeMonthStartWithLeap(int i, int i2, int i3) {
        if (i2 < 0 || i2 > 11) {
            int[] iArr = new int[1];
            i += Calendar.floorDivide(i2, 12, iArr);
            i2 = iArr[0];
        }
        int iNewMoonNear = newMoonNear((i2 * 29) + newYear(i), true);
        int iNewMoonNear2 = iNewMoonNear + 2440588;
        computeGregorianFields(iNewMoonNear2);
        MonthInfo monthInfoComputeMonthInfo = computeMonthInfo(iNewMoonNear, getGregorianYear());
        if (i2 == monthInfoComputeMonthInfo.month) {
            if (monthInfoComputeMonthInfo.isLeapMonth != (i3 != 0)) {
                iNewMoonNear2 = newMoonNear(iNewMoonNear + 25, true) + 2440588;
            }
        } else {
            iNewMoonNear2 = newMoonNear(iNewMoonNear + 25, true) + 2440588;
        }
        return iNewMoonNear2 - 1;
    }

    private int handleGetMonthLengthWithLeap(int i, int i2, int i3) {
        int iHandleComputeMonthStartWithLeap = handleComputeMonthStartWithLeap(i, i2, i3);
        return newMoonNear(iHandleComputeMonthStartWithLeap - 2440562, true) - (iHandleComputeMonthStartWithLeap - 2440587);
    }

    private boolean hasNoMajorSolarTerm(int i) {
        return majorSolarTerm(i) == majorSolarTerm(newMoonNear(i + 25, true));
    }

    private boolean isLeapMonthBetween(int i, int i2) {
        if (synodicMonthsBetween(i, i2) < 50) {
            return i2 >= i && (isLeapMonthBetween(i, newMoonNear(i2 + (-25), false)) || hasNoMajorSolarTerm(i2));
        }
        og.i(cq.i("isLeapMonthBetween(", i, ", ", i2, "): Invalid parameters"));
        return false;
    }

    private int majorSolarTerm(int i) {
        int iFloor = (((int) Math.floor((new CalendarAstronomer(daysToMillis(i)).getSunLongitude() * 6.0d) / 3.141592653589793d)) + 2) % 12;
        return iFloor < 1 ? iFloor + 12 : iFloor;
    }

    private final int millisToDays(long j) {
        return (int) Calendar.floorDivide(j + ((long) this.zoneAstro.getOffset(j)), CalendarAstronomer.DAY_MS);
    }

    private int newMoonNear(int i, boolean z) {
        return millisToDays(new CalendarAstronomer(daysToMillis(i)).getMoonTime(CalendarAstronomer.NEW_MOON, z));
    }

    private int newYear(int i) {
        long j = i;
        long jNewMoonNear = this.newYearCache.get(j);
        if (jNewMoonNear == CalendarCache.EMPTY) {
            int iWinterSolstice = winterSolstice(i - 1);
            int iWinterSolstice2 = winterSolstice(i);
            int iNewMoonNear = newMoonNear(iWinterSolstice + 1, true);
            int iNewMoonNear2 = newMoonNear(iNewMoonNear + 25, true);
            jNewMoonNear = (synodicMonthsBetween(iNewMoonNear, newMoonNear(iWinterSolstice2 + 1, false)) == 12 && (hasNoMajorSolarTerm(iNewMoonNear) || hasNoMajorSolarTerm(iNewMoonNear2))) ? newMoonNear(iNewMoonNear2 + 25, true) : iNewMoonNear2;
            this.newYearCache.put(j, jNewMoonNear);
        }
        return (int) jNewMoonNear;
    }

    private void offsetMonth(int i, int i2, int i3) {
        int iNewMoonNear = newMoonNear(i + ((int) ((((double) i3) - 0.5d) * 29.530588853d)), true) + 2440587 + i2;
        if (i2 <= 29) {
            set(20, iNewMoonNear);
            return;
        }
        set(20, iNewMoonNear - 1);
        complete();
        if (getActualMaximum(5) >= i2) {
            set(20, iNewMoonNear);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        this.zoneAstro = CHINA_ZONE;
        objectInputStream.defaultReadObject();
        this.winterSolsticeCache = new CalendarCache();
        this.newYearCache = new CalendarCache();
    }

    private int synodicMonthsBetween(int i, int i2) {
        return (int) Math.round(((double) (i2 - i)) / 29.530588853d);
    }

    private int winterSolstice(int i) {
        long j = i;
        long jMillisToDays = this.winterSolsticeCache.get(j);
        if (jMillisToDays == CalendarCache.EMPTY) {
            jMillisToDays = millisToDays(new CalendarAstronomer(daysToMillis(computeGregorianMonthStart(i, 11) - 2440587)).getSunTime(CalendarAstronomer.WINTER_SOLSTICE, true));
            this.winterSolsticeCache.put(j, jMillisToDays);
        }
        return (int) jMillisToDays;
    }

    @Override // com.ibm.icu.util.Calendar
    public void add(int i, int i2) {
        if (i != 2 && i != 23) {
            super.add(i, i2);
        } else if (i2 != 0) {
            int i3 = get(5);
            offsetMonth(((get(20) - 2440588) - i3) + 1, i3, i2);
        }
    }

    @Override // com.ibm.icu.util.Calendar
    public int getActualMaximum(int i) {
        if (i != 5) {
            return super.getActualMaximum(i);
        }
        Calendar calendarMo22clone = mo22clone();
        calendarMo22clone.setLenient(true);
        calendarMo22clone.prepareGetActual(i, false);
        return handleGetMonthLengthWithLeap(calendarMo22clone.get(19), calendarMo22clone.get(2), calendarMo22clone.get(22));
    }

    @Override // com.ibm.icu.util.Calendar
    public int[][][] getFieldResolutionTable() {
        return CHINESE_DATE_PRECEDENCE;
    }

    @Override // com.ibm.icu.util.Calendar
    public String getTemporalMonthCode() {
        return get(22) != 0 ? gTemporalLeapMonthCodes[get(2)] : super.getTemporalMonthCode();
    }

    @Override // com.ibm.icu.util.Calendar
    public String getType() {
        return "chinese";
    }

    @Override // com.ibm.icu.util.Calendar
    public void handleComputeFields(int i) {
        int i2;
        int i3 = i - 2440588;
        int gregorianYear = getGregorianYear();
        int gregorianMonth = getGregorianMonth();
        MonthInfo monthInfoComputeMonthInfo = computeMonthInfo(i3, gregorianYear);
        int i4 = gregorianYear - 1;
        int i5 = gregorianYear + 2636;
        if (monthInfoComputeMonthInfo.month < 10 || gregorianMonth >= 6) {
            i5 = gregorianYear + 2637;
            i2 = gregorianYear;
        } else {
            i2 = i4;
        }
        int i6 = (i3 - monthInfoComputeMonthInfo.thisMoon) + 1;
        int[] iArr = new int[1];
        int iFloorDivide = Calendar.floorDivide(i5 - 1, 60, iArr);
        int iNewYear = newYear(gregorianYear);
        if (i3 < iNewYear) {
            iNewYear = newYear(i4);
        }
        this.hasLeapMonthBetweenWinterSolstices = monthInfoComputeMonthInfo.hasLeapMonthBetweenWinterSolstices;
        internalSet(19, i2);
        internalSet(0, iFloorDivide + 1);
        internalSet(1, iArr[0] + 1);
        internalSet(2, monthInfoComputeMonthInfo.month);
        internalSet(23, monthInfoComputeMonthInfo.ordinalMonth);
        internalSet(5, i6);
        internalSet(22, monthInfoComputeMonthInfo.isLeapMonth ? 1 : 0);
        internalSet(6, (i3 - iNewYear) + 1);
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleComputeMonthStart(int i, int i2, boolean z) {
        return handleComputeMonthStartWithLeap(i, i2, z ? internalGet(22) : 0);
    }

    @Override // com.ibm.icu.util.Calendar
    public DateFormat handleGetDateFormat(String str, String str2, ULocale uLocale) {
        return super.handleGetDateFormat(str, str2, uLocale);
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleGetExtendedYear() {
        if (newestStamp(0, 1, 0) <= getStamp(19)) {
            return internalGet(19, 1);
        }
        return (internalGet(1, 1) + ((internalGet(0, 1) - 1) * 60)) - 2637;
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleGetLimit(int i, int i2) {
        return LIMITS[i][i2];
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleGetMonthLength(int i, int i2) {
        return handleGetMonthLengthWithLeap(i, i2, internalGet(22));
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public boolean haveDefaultCentury() {
        return false;
    }

    @Override // com.ibm.icu.util.Calendar
    public boolean inTemporalLeapYear() {
        return getActualMaximum(6) > 360;
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public int internalGetMonth() {
        if (resolveFields(Calendar.MONTH_PRECEDENCE) == 2) {
            return internalGet(2);
        }
        Calendar calendarMo22clone = mo22clone();
        calendarMo22clone.set(2, 0);
        calendarMo22clone.set(22, 0);
        calendarMo22clone.set(5, 1);
        calendarMo22clone.roll(2, internalGet(23));
        internalSet(22, calendarMo22clone.get(22));
        int i = calendarMo22clone.get(2);
        internalSet(2, i);
        return i;
    }

    @Override // com.ibm.icu.util.Calendar
    public void roll(int i, int i2) {
        if (i != 2 && i != 23) {
            super.roll(i, i2);
            return;
        }
        if (i2 != 0) {
            int i3 = get(5);
            int i4 = ((get(20) - 2440588) - i3) + 1;
            int i5 = get(2);
            if (this.hasLeapMonthBetweenWinterSolstices && (get(22) == 1 || isLeapMonthBetween(newMoonNear(i4 - ((int) ((((double) i5) - 0.5d) * 29.530588853d)), true), i4))) {
                i5++;
            }
            int i6 = this.hasLeapMonthBetweenWinterSolstices ? 13 : 12;
            int i7 = (i2 + i5) % i6;
            if (i7 < 0) {
                i7 += i6;
            }
            if (i7 != i5) {
                offsetMonth(i4, i3, i7 - i5);
            }
        }
    }

    @Override // com.ibm.icu.util.Calendar
    public void setTemporalMonthCode(String str) {
        int i = 0;
        if (str.length() != 4 || str.charAt(0) != 'M' || str.charAt(3) != 'L') {
            set(22, 0);
            super.setTemporalMonthCode(str);
            return;
        }
        while (true) {
            String[] strArr = gTemporalLeapMonthCodes;
            if (i >= strArr.length) {
                og.i("Incorrect temporal Month code: ".concat(str));
                return;
            } else {
                if (str.equals(strArr[i])) {
                    set(2, i);
                    set(22, 1);
                    return;
                }
                i++;
            }
        }
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public int internalGetMonth(int i) {
        if (resolveFields(Calendar.MONTH_PRECEDENCE) == 2) {
            return internalGet(2, i);
        }
        return internalGetMonth();
    }

    public ChineseCalendar(Date date) {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT), CHINA_ZONE);
        setTime(date);
    }

    public ChineseCalendar(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, 0, 0, 0);
    }

    public ChineseCalendar(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT), CHINA_ZONE);
        set(14, 0);
        set(1, i);
        set(2, i2);
        set(22, i3);
        set(5, i4);
        set(11, i5);
        set(12, i6);
        set(13, i7);
    }

    public ChineseCalendar(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3, i4, i5, 0, 0, 0);
    }

    public ChineseCalendar() {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT), CHINA_ZONE);
    }

    public ChineseCalendar(Locale locale) {
        this(TimeZone.forLocaleOrDefault(locale), ULocale.forLocale(locale), CHINA_ZONE);
    }

    public ChineseCalendar(TimeZone timeZone) {
        this(timeZone, ULocale.getDefault(ULocale.Category.FORMAT), CHINA_ZONE);
    }

    public ChineseCalendar(TimeZone timeZone, Locale locale) {
        this(timeZone, ULocale.forLocale(locale), CHINA_ZONE);
    }

    public ChineseCalendar(ULocale uLocale) {
        this(TimeZone.forULocaleOrDefault(uLocale), uLocale, CHINA_ZONE);
    }

    public ChineseCalendar(TimeZone timeZone, ULocale uLocale) {
        this(timeZone, uLocale, CHINA_ZONE);
    }

    @Deprecated
    public ChineseCalendar(TimeZone timeZone, ULocale uLocale, TimeZone timeZone2) {
        super(timeZone, uLocale);
        this.winterSolsticeCache = new CalendarCache();
        this.newYearCache = new CalendarCache();
        this.zoneAstro = timeZone2;
        setTimeInMillis(System.currentTimeMillis());
    }
}
