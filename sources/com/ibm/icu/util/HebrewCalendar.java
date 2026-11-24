package com.ibm.icu.util;

import com.ibm.icu.impl.CalendarCache;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.lang.UCharacter;
import defpackage.ky0;
import defpackage.og;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class HebrewCalendar extends Calendar {
    public static final int ADAR = 6;
    public static final int ADAR_1 = 5;
    public static final int AV = 11;
    private static final long BAHARAD = 12084;
    private static final long DAY_PARTS = 25920;
    public static final int ELUL = 12;
    private static final int HEBREW_CALENDAR_RELATED_YEAR_DIFFERENCE = -3760;
    public static final int HESHVAN = 1;
    private static final long HOUR_PARTS = 1080;
    public static final int IYAR = 8;
    public static final int KISLEV = 2;
    private static final int MONTHS_IN_CYCLE = 235;
    private static final int MONTH_DAYS = 29;
    private static final long MONTH_FRACT = 13753;
    private static final long MONTH_PARTS = 765433;
    public static final int NISAN = 7;
    public static final int SHEVAT = 4;
    public static final int SIVAN = 9;
    public static final int TAMUZ = 10;
    public static final int TEVET = 3;
    public static final int TISHRI = 0;
    private static final int YEARS_IN_CYCLE = 19;
    private static final long serialVersionUID = -1952524560588825816L;
    private static final int[][] LIMITS = {new int[]{0, 0, 0, 0}, new int[]{-5000000, -5000000, 5000000, 5000000}, new int[]{0, 0, 12, 12}, new int[]{1, 1, 51, 56}, new int[0], new int[]{1, 1, 29, 30}, new int[]{1, 1, UCharacter.UnicodeBlock.SEAL_ID, 385}, new int[0], new int[]{-1, -1, 5, 5}, new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[]{-5000000, -5000000, 5000000, 5000000}, new int[0], new int[]{-5000000, -5000000, 5000000, 5000000}, new int[0], new int[0], new int[0], new int[]{0, 0, 11, 12}};
    private static final int[][] MONTH_LENGTH = {new int[]{30, 30, 30}, new int[]{29, 29, 30}, new int[]{29, 30, 30}, new int[]{29, 29, 29}, new int[]{30, 30, 30}, new int[]{30, 30, 30}, new int[]{29, 29, 29}, new int[]{30, 30, 30}, new int[]{29, 29, 29}, new int[]{30, 30, 30}, new int[]{29, 29, 29}, new int[]{30, 30, 30}, new int[]{29, 29, 29}};
    private static final int[][] MONTH_START = {new int[]{0, 0, 0}, new int[]{30, 30, 30}, new int[]{59, 59, 60}, new int[]{88, 89, 90}, new int[]{117, 118, 119}, new int[]{147, 148, 149}, new int[]{147, 148, 149}, new int[]{176, 177, 178}, new int[]{206, 207, 208}, new int[]{235, 236, 237}, new int[]{UCharacter.UnicodeBlock.CYRILLIC_EXTENDED_C_ID, UCharacter.UnicodeBlock.GLAGOLITIC_SUPPLEMENT_ID, UCharacter.UnicodeBlock.IDEOGRAPHIC_SYMBOLS_AND_PUNCTUATION_ID}, new int[]{UCharacter.UnicodeBlock.NANDINAGARI_ID, UCharacter.UnicodeBlock.NYIAKENG_PUACHUE_HMONG_ID, UCharacter.UnicodeBlock.OTTOMAN_SIYAQ_NUMBERS_ID}, new int[]{UCharacter.UnicodeBlock.DEVANAGARI_EXTENDED_A_ID, UCharacter.UnicodeBlock.KAKTOVIK_NUMERALS_ID, UCharacter.UnicodeBlock.KAWI_ID}, new int[]{UCharacter.UnicodeBlock.SEAL_ID, UCharacter.UnicodeBlock.COUNT, 355}};
    private static final int[][] LEAP_MONTH_START = {new int[]{0, 0, 0}, new int[]{30, 30, 30}, new int[]{59, 59, 60}, new int[]{88, 89, 90}, new int[]{117, 118, 119}, new int[]{147, 148, 149}, new int[]{177, 178, 179}, new int[]{206, 207, 208}, new int[]{236, 237, 238}, new int[]{UCharacter.UnicodeBlock.CYRILLIC_EXTENDED_C_ID, UCharacter.UnicodeBlock.GLAGOLITIC_SUPPLEMENT_ID, UCharacter.UnicodeBlock.IDEOGRAPHIC_SYMBOLS_AND_PUNCTUATION_ID}, new int[]{UCharacter.UnicodeBlock.NYIAKENG_PUACHUE_HMONG_ID, UCharacter.UnicodeBlock.OTTOMAN_SIYAQ_NUMBERS_ID, UCharacter.UnicodeBlock.SMALL_KANA_EXTENSION_ID}, new int[]{UCharacter.UnicodeBlock.DEVANAGARI_EXTENDED_A_ID, UCharacter.UnicodeBlock.KAKTOVIK_NUMERALS_ID, UCharacter.UnicodeBlock.KAWI_ID}, new int[]{UCharacter.UnicodeBlock.COUNT, 355, 356}, new int[]{CollationFastLatin.LATIN_MAX, CollationFastLatin.LATIN_LIMIT, 385}};
    private static CalendarCache cache = new CalendarCache();
    private static String[] gTemporalMonthCodesForHebrew = {"M01", "M02", "M03", "M04", "M05", "M05L", "M06", "M07", "M08", "M09", "M10", "M11", "M12"};

    public HebrewCalendar(int i, int i2, int i3, int i4, int i5, int i6) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        set(1, i);
        set(2, i2);
        set(5, i3);
        set(11, i4);
        set(12, i5);
        set(13, i6);
    }

    @Deprecated
    public static boolean isLeapYear(int i) {
        return ((((i * 12) + 17) % 19) + 19) % 19 >= 12;
    }

    private static int monthsInYear(int i) {
        return isLeapYear(i) ? 13 : 12;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0062  */
    private static long startOfYear(int i) {
        long j = i;
        long j2 = cache.get(j);
        if (j2 != CalendarCache.EMPTY) {
            return j2;
        }
        int iFloorDivide = (int) Calendar.floorDivide((235 * j) - 234, 19L);
        long j3 = (((long) iFloorDivide) * MONTH_FRACT) + BAHARAD;
        long jFloorDivide = Calendar.floorDivide(j3, DAY_PARTS);
        long j4 = ((long) (iFloorDivide * 29)) + jFloorDivide;
        long j5 = j3 - (jFloorDivide * DAY_PARTS);
        int i2 = (int) (((j4 % 7) + 7) % 7);
        if (i2 == 2 || i2 == 4 || i2 == 6) {
            j4++;
        } else if (i2 == 1 && j5 >= 16404 && !isLeapYear(i)) {
            j4 += 2;
        } else if (i2 == 0 && j5 >= 23269 && isLeapYear(i - 1)) {
            j4++;
        }
        cache.put(j, j4);
        return j4;
    }

    private final int yearType(int i) {
        int iHandleGetYearLength = handleGetYearLength(i);
        if (iHandleGetYearLength > 380) {
            iHandleGetYearLength -= 30;
        }
        switch (iHandleGetYearLength) {
            case UCharacter.UnicodeBlock.SEAL_ID /* 353 */:
                return 0;
            case UCharacter.UnicodeBlock.COUNT /* 354 */:
                return 1;
            case 355:
                return 2;
            default:
                og.i(ky0.i("Illegal year length ", iHandleGetYearLength, i, " in year "));
                return 0;
        }
    }

    @Override // com.ibm.icu.util.Calendar
    public void add(int i, int i2) {
        boolean z;
        int i3;
        if (i != 2 && i != 23) {
            super.add(i, i2);
            return;
        }
        int i4 = get(2);
        int i5 = get(1);
        if (i2 > 0) {
            z = i4 < 5;
            i3 = i4 + i2;
            while (true) {
                if (z && i3 >= 5 && !isLeapYear(i5)) {
                    i3++;
                }
                if (i3 <= 12) {
                    break;
                }
                i3 -= 13;
                i5++;
                z = true;
            }
        } else {
            z = i4 > 5;
            i3 = i4 + i2;
            while (true) {
                if (z && i3 <= 5 && !isLeapYear(i5)) {
                    i3--;
                }
                if (i3 >= 0) {
                    break;
                }
                i3 += 13;
                i5--;
                z = true;
            }
        }
        set(2, i3);
        set(1, i5);
        pinField(5);
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public final int getRelatedYearDifference() {
        return HEBREW_CALENDAR_RELATED_YEAR_DIFFERENCE;
    }

    @Override // com.ibm.icu.util.Calendar
    public String getTemporalMonthCode() {
        return gTemporalMonthCodesForHebrew[get(2)];
    }

    @Override // com.ibm.icu.util.Calendar
    public String getType() {
        return "hebrew";
    }

    @Override // com.ibm.icu.util.Calendar
    public void handleComputeFields(int i) {
        int i2;
        long j = i - 347997;
        int iFloorDivide = (int) (Calendar.floorDivide((Calendar.floorDivide(DAY_PARTS * j, MONTH_PARTS) * 19) + 234, 235L) + 1);
        long jStartOfYear = startOfYear(iFloorDivide);
        while (true) {
            i2 = (int) (j - jStartOfYear);
            if (i2 >= 1) {
                break;
            }
            iFloorDivide--;
            jStartOfYear = startOfYear(iFloorDivide);
        }
        int iYearType = yearType(iFloorDivide);
        boolean zIsLeapYear = isLeapYear(iFloorDivide);
        int[][] iArr = zIsLeapYear ? LEAP_MONTH_START : MONTH_START;
        int i3 = 0;
        while (i2 > iArr[i3][iYearType]) {
            i3++;
        }
        int i4 = i3 - 1;
        int i5 = i2 - iArr[i4][iYearType];
        internalSet(0, 0);
        internalSet(1, iFloorDivide);
        internalSet(19, iFloorDivide);
        internalSet(23, (zIsLeapYear || i4 <= 5) ? i4 : i3 - 2);
        internalSet(2, i4);
        internalSet(5, i5);
        internalSet(6, i2);
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleComputeMonthStart(int i, int i2, boolean z) {
        if (i2 <= -235 || 235 <= i2) {
            i += (i2 / 235) * 19;
            i2 %= 235;
        }
        while (i2 < 0) {
            i--;
            i2 += monthsInYear(i);
        }
        while (i2 > 12) {
            i2 -= monthsInYear(i);
            i++;
        }
        long jStartOfYear = startOfYear(i);
        if (i2 != 0) {
            jStartOfYear += (long) (isLeapYear(i) ? LEAP_MONTH_START[i2][yearType(i)] : MONTH_START[i2][yearType(i)]);
        }
        return (int) (jStartOfYear + 347997);
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleGetExtendedYear() {
        return newerField(19, 1) == 19 ? internalGet(19, 1) : internalGet(1, 1);
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleGetLimit(int i, int i2) {
        return LIMITS[i][i2];
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleGetMonthLength(int i, int i2) {
        if (i2 <= -235 || 235 <= i2) {
            i += (i2 / 235) * 19;
            i2 %= 235;
        }
        while (i2 < 0) {
            i--;
            i2 += monthsInYear(i);
        }
        while (i2 > 12) {
            i2 -= monthsInYear(i);
            i++;
        }
        return (i2 == 1 || i2 == 2) ? MONTH_LENGTH[i2][yearType(i)] : MONTH_LENGTH[i2][0];
    }

    @Override // com.ibm.icu.util.Calendar
    public int handleGetYearLength(int i) {
        return (int) (startOfYear(i + 1) - startOfYear(i));
    }

    @Override // com.ibm.icu.util.Calendar
    public boolean inTemporalLeapYear() {
        return isLeapYear(get(19));
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public int internalGetMonth() {
        if (resolveFields(Calendar.MONTH_PRECEDENCE) != 23) {
            return super.internalGetMonth();
        }
        int iInternalGet = internalGet(23);
        return iInternalGet + ((isLeapYear(handleGetExtendedYear()) || iInternalGet <= 5) ? 0 : 1);
    }

    @Override // com.ibm.icu.util.Calendar
    public void roll(int i, int i2) {
        if (i != 2 && i != 23) {
            super.roll(i, i2);
            return;
        }
        int i3 = get(2);
        int i4 = get(1);
        boolean zIsLeapYear = isLeapYear(i4);
        int iMonthsInYear = (i2 % monthsInYear(i4)) + i3;
        if (!zIsLeapYear) {
            if (i2 > 0 && i3 < 5 && iMonthsInYear >= 5) {
                iMonthsInYear++;
            } else if (i2 < 0 && i3 > 5 && iMonthsInYear <= 5) {
                iMonthsInYear--;
            }
        }
        set(2, (iMonthsInYear + 13) % 13);
        pinField(5);
    }

    @Override // com.ibm.icu.util.Calendar
    public void setTemporalMonthCode(String str) {
        if (str.length() == 3 || str.length() == 4) {
            int i = 0;
            while (true) {
                String[] strArr = gTemporalMonthCodesForHebrew;
                if (i >= strArr.length) {
                    break;
                }
                if (str.equals(strArr[i])) {
                    set(2, i);
                    return;
                }
                i++;
            }
        }
        og.i("Incorrect temporal Month code: ".concat(str));
    }

    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public void validateField(int i) {
        if ((i == 2 || i == 23) && !isLeapYear(handleGetExtendedYear()) && internalGetMonth() == 5) {
            og.i("MONTH cannot be ADAR_1(5) except leap years");
        } else {
            super.validateField(i);
        }
    }

    public HebrewCalendar(TimeZone timeZone) {
        this(timeZone, ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public HebrewCalendar(Locale locale) {
        this(TimeZone.forLocaleOrDefault(locale), locale);
    }

    public HebrewCalendar(ULocale uLocale) {
        this(TimeZone.forULocaleOrDefault(uLocale), uLocale);
    }

    public HebrewCalendar(TimeZone timeZone, Locale locale) {
        super(timeZone, locale);
        setTimeInMillis(System.currentTimeMillis());
    }

    public HebrewCalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
        setTimeInMillis(System.currentTimeMillis());
    }

    public HebrewCalendar(int i, int i2, int i3) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        set(1, i);
        set(2, i2);
        set(5, i3);
    }

    public HebrewCalendar(Date date) {
        super(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
        setTime(date);
    }

    public HebrewCalendar() {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
    }
}
