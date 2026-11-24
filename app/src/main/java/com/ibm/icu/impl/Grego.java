package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacter;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class Grego {
    private static final int JULIAN_1970_CE = 2440588;
    private static final int JULIAN_1_CE = 1721426;
    public static final long MAX_MILLIS = 183882168921600000L;
    public static final int MILLIS_PER_DAY = 86400000;
    public static final int MILLIS_PER_HOUR = 3600000;
    public static final int MILLIS_PER_MINUTE = 60000;
    public static final int MILLIS_PER_SECOND = 1000;
    public static final long MIN_MILLIS = -184303902528000000L;
    private static final int[] MONTH_LENGTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] DAYS_BEFORE = {0, 31, 59, 90, 120, 151, 181, 212, UCharacter.UnicodeBlock.PAHAWH_HMONG_ID, UCharacter.UnicodeBlock.TANGUT_COMPONENTS_ID, UCharacter.UnicodeBlock.KHITAN_SMALL_SCRIPT_ID, UCharacter.UnicodeBlock.OL_ONAL_ID, 0, 31, 60, 91, 121, 152, 182, 213, UCharacter.UnicodeBlock.PALMYRENE_ID, UCharacter.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_F_ID, UCharacter.UnicodeBlock.LISU_SUPPLEMENT_ID, UCharacter.UnicodeBlock.SUNUWAR_ID};

    public static int dayOfWeek(long j) {
        int iIntValue = floorDivideAndRemainer(j + 5, 7).second.intValue();
        if (iIntValue == 0) {
            return 7;
        }
        return iIntValue;
    }

    public static int[] dayToFields(long j, int[] iArr) {
        int i;
        if (iArr == null || iArr.length < 5) {
            iArr = new int[5];
        }
        Pair<Integer, Integer> pairDayToYear = dayToYear(j);
        int iIntValue = pairDayToYear.first.intValue();
        int iIntValue2 = pairDayToYear.second.intValue();
        boolean zIsLeapYear = isLeapYear(iIntValue);
        if (iIntValue2 > (zIsLeapYear ? 60 : 59)) {
            i = zIsLeapYear ? 1 : 2;
        } else {
            i = 0;
        }
        int i2 = ((((iIntValue2 - 1) + i) * 12) + 6) / 367;
        int i3 = iIntValue2 - DAYS_BEFORE[zIsLeapYear ? i2 + 12 : i2];
        int i4 = (int) ((j + 719164) % 7);
        if (i4 < 1) {
            i4 += 7;
        }
        iArr[0] = iIntValue;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
        iArr[4] = iIntValue2;
        return iArr;
    }

    public static Pair<Integer, Integer> dayToYear(long j) {
        Pair<Long, Integer> pairFloorDivideAndRemainer = floorDivideAndRemainer(j + 719162, 146097);
        Pair<Long, Integer> pairFloorDivideAndRemainer2 = floorDivideAndRemainer(pairFloorDivideAndRemainer.second.intValue(), 36524);
        Pair<Long, Integer> pairFloorDivideAndRemainer3 = floorDivideAndRemainer(pairFloorDivideAndRemainer2.second.intValue(), 1461);
        int i = 365;
        Pair<Long, Integer> pairFloorDivideAndRemainer4 = floorDivideAndRemainer(pairFloorDivideAndRemainer3.second.intValue(), 365);
        int iLongValue = (int) (pairFloorDivideAndRemainer4.first.longValue() + (pairFloorDivideAndRemainer3.first.longValue() * 4) + (pairFloorDivideAndRemainer2.first.longValue() * 100) + (pairFloorDivideAndRemainer.first.longValue() * 400));
        int iIntValue = pairFloorDivideAndRemainer4.second.intValue();
        if (pairFloorDivideAndRemainer2.first.longValue() != 4 && pairFloorDivideAndRemainer4.first.longValue() != 4) {
            iLongValue++;
            i = iIntValue;
        }
        return new Pair<>(Integer.valueOf(iLongValue), Integer.valueOf(i + 1));
    }

    public static long fieldsToDay(int i, int i2, int i3) {
        int i4 = i - 1;
        long j = i4;
        return (((((floorDivide(j, 400L) + ((floorDivide(j, 4L) + ((long) (i4 * 365))) + 1721423)) - floorDivide(j, 100L)) + 2) + ((long) DAYS_BEFORE[i2 + (isLeapYear(i) ? 12 : 0)])) + ((long) i3)) - 2440588;
    }

    public static long floorDivide(long j, long j2) {
        return j >= 0 ? j / j2 : ((j + 1) / j2) - 1;
    }

    private static Pair<Long, Integer> floorDivideAndRemainer(long j, int i) {
        if (j >= 0) {
            long j2 = i;
            return new Pair<>(Long.valueOf(floorDivide(j, j2)), Integer.valueOf((int) (j % j2)));
        }
        long j3 = i;
        long jFloorDivide = floorDivide(j, j3);
        return new Pair<>(Long.valueOf(jFloorDivide), Integer.valueOf((int) (j - (jFloorDivide * j3))));
    }

    public static int getDayOfWeekInMonth(int i, int i2, int i3) {
        int i4 = (i3 + 6) / 7;
        if (i4 == 4) {
            if (i3 + 7 > monthLength(i, i2)) {
                return -1;
            }
        } else if (i4 == 5) {
            return -1;
        }
        return i4;
    }

    public static int gregorianShift(int i) {
        long j = i - 1;
        return (int) ((floorDivide(j, 400L) - floorDivide(j, 100L)) + 2);
    }

    public static final boolean isLeapYear(int i) {
        if ((i & 3) == 0) {
            return i % 100 != 0 || i % 400 == 0;
        }
        return false;
    }

    public static final int monthLength(int i, int i2) {
        return MONTH_LENGTH[i2 + (isLeapYear(i) ? 12 : 0)];
    }

    public static final int previousMonthLength(int i, int i2) {
        if (i2 > 0) {
            return monthLength(i, i2 - 1);
        }
        return 31;
    }

    public static int[] timeToFields(long j, int[] iArr) {
        if (iArr == null || iArr.length < 6) {
            iArr = new int[6];
        }
        Pair<Long, Integer> pairFloorDivideAndRemainer = floorDivideAndRemainer(j, MILLIS_PER_DAY);
        dayToFields(pairFloorDivideAndRemainer.first.longValue(), iArr);
        iArr[5] = pairFloorDivideAndRemainer.second.intValue();
        return iArr;
    }

    public static String timeToString(long j) {
        int[] iArrTimeToFields = timeToFields(j, null);
        int i = iArrTimeToFields[5];
        int i2 = i / 3600000;
        int i3 = i % 3600000;
        int i4 = i3 / 60000;
        int i5 = i3 % 60000;
        return String.format(null, "%04d-%02d-%02dT%02d:%02d:%02d.%03dZ", Integer.valueOf(iArrTimeToFields[0]), Integer.valueOf(iArrTimeToFields[1] + 1), Integer.valueOf(iArrTimeToFields[2]), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5 / 1000), Integer.valueOf(i5 % 1000));
    }

    public static int timeToYear(long j) {
        return dayToYear(floorDivideAndRemainer(j, MILLIS_PER_DAY).first.longValue()).first.intValue();
    }
}
