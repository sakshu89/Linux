package com.ibm.icu.impl.duration;

import com.ibm.icu.impl.CalendarAstronomer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class TimeUnit {
    public static final TimeUnit DAY;
    public static final TimeUnit HOUR;
    public static final TimeUnit MILLISECOND;
    public static final TimeUnit MINUTE;
    public static final TimeUnit MONTH;
    public static final TimeUnit SECOND;
    public static final TimeUnit WEEK;
    public static final TimeUnit YEAR;
    static final long[] approxDurations;
    static final TimeUnit[] units;
    final String name;
    final byte ordinal;

    static {
        TimeUnit timeUnit = new TimeUnit("year", 0);
        YEAR = timeUnit;
        TimeUnit timeUnit2 = new TimeUnit("month", 1);
        MONTH = timeUnit2;
        TimeUnit timeUnit3 = new TimeUnit("week", 2);
        WEEK = timeUnit3;
        TimeUnit timeUnit4 = new TimeUnit("day", 3);
        DAY = timeUnit4;
        TimeUnit timeUnit5 = new TimeUnit("hour", 4);
        HOUR = timeUnit5;
        TimeUnit timeUnit6 = new TimeUnit("minute", 5);
        MINUTE = timeUnit6;
        TimeUnit timeUnit7 = new TimeUnit("second", 6);
        SECOND = timeUnit7;
        TimeUnit timeUnit8 = new TimeUnit("millisecond", 7);
        MILLISECOND = timeUnit8;
        units = new TimeUnit[]{timeUnit, timeUnit2, timeUnit3, timeUnit4, timeUnit5, timeUnit6, timeUnit7, timeUnit8};
        approxDurations = new long[]{31557600000L, 2630880000L, 604800000, CalendarAstronomer.DAY_MS, 3600000, 60000, 1000, 1};
    }

    private TimeUnit(String str, int i) {
        this.name = str;
        this.ordinal = (byte) i;
    }

    public TimeUnit larger() {
        byte b = this.ordinal;
        if (b == 0) {
            return null;
        }
        return units[b - 1];
    }

    public int ordinal() {
        return this.ordinal;
    }

    public TimeUnit smaller() {
        byte b = this.ordinal;
        TimeUnit[] timeUnitArr = units;
        if (b == timeUnitArr.length - 1) {
            return null;
        }
        return timeUnitArr[b + 1];
    }

    public String toString() {
        return this.name;
    }
}
