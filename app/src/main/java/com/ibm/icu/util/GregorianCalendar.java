package com.ibm.icu.util;

import com.ibm.icu.impl.CalendarAstronomer;
import com.ibm.icu.impl.Grego;
import com.ibm.icu.lang.UCharacter;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class GregorianCalendar extends Calendar implements Cloneable {
    public static final int AD = 1;
    public static final int BC = 0;
    private static final int EPOCH_YEAR = 1970;
    private static final int kCutoverJulianDay = 2299161;
    private static final int kEpochStartAsJulianDay = 2440588;
    private static final long serialVersionUID = 9199388694351062137L;
    private transient int cutoverJulianDay;
    private long gregorianCutover;
    private transient int gregorianCutoverYear;
    protected transient boolean invertGregorian;
    protected transient boolean isGregorian;
    private static final int[][] MONTH_COUNT = {new int[]{31, 31, 0, 0}, new int[]{28, 29, 31, 31}, new int[]{31, 31, 59, 60}, new int[]{30, 30, 90, 91}, new int[]{31, 31, 120, 121}, new int[]{30, 30, 151, 152}, new int[]{31, 31, 181, 182}, new int[]{31, 31, 212, 213}, new int[]{30, 30, UCharacter.UnicodeBlock.PAHAWH_HMONG_ID, UCharacter.UnicodeBlock.PALMYRENE_ID}, new int[]{31, 31, UCharacter.UnicodeBlock.TANGUT_COMPONENTS_ID, UCharacter.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_F_ID}, new int[]{30, 30, UCharacter.UnicodeBlock.KHITAN_SMALL_SCRIPT_ID, UCharacter.UnicodeBlock.LISU_SUPPLEMENT_ID}, new int[]{31, 31, UCharacter.UnicodeBlock.OL_ONAL_ID, UCharacter.UnicodeBlock.SUNUWAR_ID}};
    private static final int[][] LIMITS = {new int[]{0, 0, 1, 1}, new int[]{1, 1, 5828963, 5838270}, new int[]{0, 0, 11, 11}, new int[]{1, 1, 52, 53}, new int[0], new int[]{1, 1, 28, 31}, new int[]{1, 1, 365, 366}, new int[0], new int[]{-1, -1, 4, 5}, new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[]{-5838270, -5838270, 5828964, 5838271}, new int[0], new int[]{-5838269, -5838269, 5828963, 5838270}, new int[0], new int[0], new int[0], new int[]{0, 0, 11, 11}};

    public GregorianCalendar(int i, int i2, int i3, int i4, int i5, int i6) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        this.gregorianCutover = -12219292800000L;
        this.cutoverJulianDay = kCutoverJulianDay;
        this.gregorianCutoverYear = 1582;
        set(0, 1);
        set(1, i);
        set(2, i2);
        set(5, i3);
        set(11, i4);
        set(12, i5);
        set(13, i6);
    }

    @Override // com.ibm.icu.util.Calendar
    /* JADX INFO: renamed from: clone */
    public GregorianCalendar mo22clone() {
        return (GregorianCalendar) super.mo22clone();
    }

    @Override // com.ibm.icu.util.Calendar
    public int getActualMaximum(int i) {
        if (i != 1) {
            return super.getActualMaximum(i);
        }
        GregorianCalendar gregorianCalendarMo22clone = mo22clone();
        gregorianCalendarMo22clone.setLenient(true);
        int i2 = gregorianCalendarMo22clone.get(0);
        Date time = gregorianCalendarMo22clone.getTime();
        int[] iArr = LIMITS[1];
        int i3 = iArr[1];
        int i4 = iArr[2] + 1;
        while (i3 + 1 < i4) {
            int i5 = (i3 + i4) / 2;
            gregorianCalendarMo22clone.set(1, i5);
            if (gregorianCalendarMo22clone.get(1) == i5 && gregorianCalendarMo22clone.get(0) == i2) {
                i3 = i5;
            } else {
                gregorianCalendarMo22clone.setTime(time);
                i4 = i5;
            }
        }
        return i3;
    }

    @Override // com.ibm.icu.util.Calendar
    public int getActualMinimum(int i) {
        return getMinimum(i);
    }

    public final Date getGregorianChange() {
        return new Date(this.gregorianCutover);
    }

    @Override // com.ibm.icu.util.Calendar
    public String getType() {
        return "gregorian";
    }

    @Override // com.ibm.icu.util.Calendar
    public void handleComputeFields(int i) {
        int i2;
        int gregorianYear;
        int gregorianMonth;
        int iGregorianShift;
        int gregorianDayOfMonth;
        int i3;
        if (i >= this.cutoverJulianDay) {
            gregorianMonth = getGregorianMonth();
            gregorianDayOfMonth = getGregorianDayOfMonth();
            iGregorianShift = getGregorianDayOfYear();
            gregorianYear = getGregorianYear();
        } else {
            long j = i - 1721424;
            int iFloorDivide = (int) Calendar.floorDivide((j * 4) + 1464, 1461L);
            long j2 = ((long) iFloorDivide) - 1;
            int iFloorDivide2 = (int) (j - (Calendar.floorDivide(j2, 4L) + (365 * j2)));
            boolean z = (iFloorDivide & 3) == 0;
            if (iFloorDivide2 >= (z ? 60 : 59)) {
                i2 = z ? 1 : 2;
            } else {
                i2 = 0;
            }
            int i4 = (((i2 + iFloorDivide2) * 12) + 6) / 367;
            int i5 = (iFloorDivide2 - MONTH_COUNT[i4][z ? (char) 3 : (char) 2]) + 1;
            gregorianYear = iFloorDivide;
            gregorianMonth = i4;
            iGregorianShift = iFloorDivide2 + 1;
            gregorianDayOfMonth = i5;
        }
        if (gregorianYear == this.gregorianCutoverYear && i >= this.cutoverJulianDay) {
            iGregorianShift += Grego.gregorianShift(gregorianYear);
        }
        internalSet(2, gregorianMonth);
        internalSet(23, gregorianMonth);
        internalSet(5, gregorianDayOfMonth);
        internalSet(6, iGregorianShift);
        internalSet(19, gregorianYear);
        if (gregorianYear < 1) {
            gregorianYear = 1 - gregorianYear;
            i3 = 0;
        } else {
            i3 = 1;
        }
        internalSet(0, i3);
        internalSet(1, gregorianYear);
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleComputeJulianDay(int i) {
        this.invertGregorian = false;
        int iHandleComputeJulianDay = super.handleComputeJulianDay(i);
        if (i == 3 && internalGet(19) == this.gregorianCutoverYear && iHandleComputeJulianDay >= this.cutoverJulianDay) {
            this.invertGregorian = true;
            return super.handleComputeJulianDay(i);
        }
        if (this.isGregorian != (iHandleComputeJulianDay >= this.cutoverJulianDay)) {
            this.invertGregorian = true;
            iHandleComputeJulianDay = super.handleComputeJulianDay(i);
        }
        if (!this.isGregorian || internalGet(19) != this.gregorianCutoverYear) {
            return iHandleComputeJulianDay;
        }
        int iGregorianShift = Grego.gregorianShift(internalGet(19));
        if (i == 6) {
            return iHandleComputeJulianDay - iGregorianShift;
        }
        return (i == 4 && internalGetMonth() == Grego.timeToFields(this.gregorianCutover, null)[1]) ? iHandleComputeJulianDay + 14 : iHandleComputeJulianDay;
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleComputeMonthStart(int i, int i2, boolean z) {
        boolean z2 = false;
        if (i2 < 0 || i2 > 11) {
            int[] iArr = new int[1];
            i += Calendar.floorDivide(i2, 12, iArr);
            i2 = iArr[0];
        }
        boolean z3 = i % 4 == 0;
        int i3 = i - 1;
        int iFloorDivide = Calendar.floorDivide(i3, 4) + (i3 * 365) + 1721423;
        boolean z4 = i >= this.gregorianCutoverYear;
        this.isGregorian = z4;
        if (this.invertGregorian) {
            this.isGregorian = !z4;
        }
        if (this.isGregorian) {
            if (z3 && (i % 100 != 0 || i % 400 == 0)) {
                z2 = true;
            }
            iFloorDivide += (Calendar.floorDivide(i3, 400) - Calendar.floorDivide(i3, 100)) + 2;
            z3 = z2;
        }
        if (i2 != 0) {
            return iFloorDivide + MONTH_COUNT[i2][z3 ? (char) 3 : (char) 2];
        }
        return iFloorDivide;
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleGetExtendedYear() {
        if (newerField(19, 1) == 19) {
            return internalGet(19, EPOCH_YEAR);
        }
        return internalGet(0, 1) == 0 ? 1 - internalGet(1, 1) : internalGet(1, EPOCH_YEAR);
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleGetLimit(int i, int i2) {
        return LIMITS[i][i2];
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleGetMonthLength(int i, int i2) {
        if (i2 < 0 || i2 > 11) {
            int[] iArr = new int[1];
            i += Calendar.floorDivide(i2, 12, iArr);
            i2 = iArr[0];
        }
        return MONTH_COUNT[i2][isLeapYear(i) ? 1 : 0];
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleGetYearLength(int i) {
        return isLeapYear(i) ? 366 : 365;
    }

    @Override // com.ibm.icu.util.Calendar
    public int hashCode() {
        return ((int) this.gregorianCutover) ^ super.hashCode();
    }

    public boolean inDaylightTime() {
        if (!getTimeZone().useDaylightTime()) {
            return false;
        }
        complete();
        return internalGet(16) != 0;
    }

    @Override // com.ibm.icu.util.Calendar
    public boolean isEquivalentTo(Calendar calendar) {
        return super.isEquivalentTo(calendar) && this.gregorianCutover == ((GregorianCalendar) calendar).gregorianCutover;
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public boolean isEra0CountingBackward() {
        return true;
    }

    public boolean isLeapYear(int i) {
        if (i >= this.gregorianCutoverYear) {
            return i % 4 == 0 && (i % 100 != 0 || i % 400 == 0);
        }
        return i % 4 == 0;
    }

    @Override // com.ibm.icu.util.Calendar
    public void roll(int i, int i2) {
        if (i != 3) {
            super.roll(i, i2);
            return;
        }
        int i3 = get(3);
        int i4 = get(17);
        int iInternalGet = internalGet(6);
        if (internalGetMonth() == 0) {
            if (i3 >= 52) {
                iInternalGet += handleGetYearLength(i4);
            }
        } else if (i3 == 1) {
            iInternalGet -= handleGetYearLength(i4 - 1);
        }
        int i5 = i3 + i2;
        if (i5 < 1 || i5 > 52) {
            int iHandleGetYearLength = handleGetYearLength(i4);
            int iInternalGet2 = ((internalGet(7) + (iHandleGetYearLength - iInternalGet)) - getFirstDayOfWeek()) % 7;
            if (iInternalGet2 < 0) {
                iInternalGet2 += 7;
            }
            if (6 - iInternalGet2 >= getMinimalDaysInFirstWeek()) {
                iHandleGetYearLength -= 7;
            }
            int iWeekNumber = weekNumber(iHandleGetYearLength, iInternalGet2 + 1);
            i5 = (((i5 + iWeekNumber) - 1) % iWeekNumber) + 1;
        }
        set(3, i5);
        set(1, i4);
    }

    public void setGregorianChange(Date date) {
        long time = date.getTime();
        this.gregorianCutover = time;
        if (time <= Grego.MIN_MILLIS) {
            this.cutoverJulianDay = Integer.MIN_VALUE;
            this.gregorianCutoverYear = Integer.MIN_VALUE;
            return;
        }
        if (time >= Grego.MAX_MILLIS) {
            this.cutoverJulianDay = Integer.MAX_VALUE;
            this.gregorianCutoverYear = Integer.MAX_VALUE;
            return;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(getTimeZone());
        gregorianCalendar.setTime(date);
        this.gregorianCutoverYear = gregorianCalendar.get(19);
        long jFloorDivide = Calendar.floorDivide(this.gregorianCutover, CalendarAstronomer.DAY_MS) + 2440588;
        if (jFloorDivide <= -2147483648L) {
            this.cutoverJulianDay = Integer.MIN_VALUE;
        } else if (jFloorDivide >= 2147483647L) {
            this.cutoverJulianDay = Integer.MAX_VALUE;
        } else {
            this.cutoverJulianDay = (int) jFloorDivide;
        }
    }

    public GregorianCalendar(TimeZone timeZone) {
        this(timeZone, ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public GregorianCalendar(Locale locale) {
        this(TimeZone.forLocaleOrDefault(locale), locale);
    }

    public GregorianCalendar(ULocale uLocale) {
        this(TimeZone.forULocaleOrDefault(uLocale), uLocale);
    }

    public GregorianCalendar(TimeZone timeZone, Locale locale) {
        super(timeZone, locale);
        this.gregorianCutover = -12219292800000L;
        this.cutoverJulianDay = kCutoverJulianDay;
        this.gregorianCutoverYear = 1582;
        setTimeInMillis(System.currentTimeMillis());
    }

    public GregorianCalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
        this.gregorianCutover = -12219292800000L;
        this.cutoverJulianDay = kCutoverJulianDay;
        this.gregorianCutoverYear = 1582;
        setTimeInMillis(System.currentTimeMillis());
    }

    public GregorianCalendar(int i, int i2, int i3) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        this.gregorianCutover = -12219292800000L;
        this.cutoverJulianDay = kCutoverJulianDay;
        this.gregorianCutoverYear = 1582;
        set(0, 1);
        set(1, i);
        set(2, i2);
        set(5, i3);
    }

    public GregorianCalendar(int i, int i2, int i3, int i4, int i5) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        this.gregorianCutover = -12219292800000L;
        this.cutoverJulianDay = kCutoverJulianDay;
        this.gregorianCutoverYear = 1582;
        set(0, 1);
        set(1, i);
        set(2, i2);
        set(5, i3);
        set(11, i4);
        set(12, i5);
    }

    public GregorianCalendar() {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
    }
}
