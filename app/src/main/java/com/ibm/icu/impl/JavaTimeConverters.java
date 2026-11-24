package com.ibm.icu.impl;

import com.ibm.icu.util.BuddhistCalendar;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.GregorianCalendar;
import com.ibm.icu.util.JapaneseCalendar;
import com.ibm.icu.util.SimpleTimeZone;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;
import defpackage.og;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class JavaTimeConverters {
    private static final long MILLIS_PER_DAY = 86400000;
    private static final long MILLIS_PER_HOUR = 3600000;

    private JavaTimeConverters() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:15:0x0053  */
    @Deprecated
    public static Calendar convertCalendar(java.util.Calendar calendar) {
        GregorianCalendar gregorianCalendar;
        TimeZone timeZone = TimeZone.getTimeZone(calendar.getTimeZone().getID());
        String calendarType = calendar.getCalendarType();
        switch (calendarType.hashCode()) {
            case -1581060683:
                if (!calendarType.equals("buddhist")) {
                    gregorianCalendar = new GregorianCalendar(timeZone);
                } else {
                    gregorianCalendar = new BuddhistCalendar(timeZone);
                }
                break;
            case -752730191:
                if (!calendarType.equals("japanese")) {
                    gregorianCalendar = new GregorianCalendar(timeZone);
                } else {
                    gregorianCalendar = new JapaneseCalendar(timeZone);
                }
                break;
            case 283776265:
                calendarType.equals("gregory");
                gregorianCalendar = new GregorianCalendar(timeZone);
                break;
            case 2095190916:
                if (!calendarType.equals("iso8601")) {
                    gregorianCalendar = new GregorianCalendar(timeZone);
                } else {
                    gregorianCalendar = new GregorianCalendar(timeZone);
                    gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
                }
                break;
            default:
                gregorianCalendar = new GregorianCalendar(timeZone);
                break;
        }
        gregorianCalendar.setLenient(calendar.isLenient());
        gregorianCalendar.setFirstDayOfWeek(calendar.getFirstDayOfWeek());
        gregorianCalendar.setMinimalDaysInFirstWeek(calendar.getMinimalDaysInFirstWeek());
        gregorianCalendar.setTimeInMillis(calendar.getTimeInMillis());
        return gregorianCalendar;
    }

    @Deprecated
    public static Calendar dayOfWeekToCalendar(DayOfWeek dayOfWeek) {
        return millisToCalendar(dayOfWeekToMillis(dayOfWeek));
    }

    private static long dayOfWeekToMillis(DayOfWeek dayOfWeek) {
        return (((long) (dayOfWeek.getValue() + 3)) * 86400000) + 43200000;
    }

    private static Calendar millisToCalendar(long j, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, ULocale.US);
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        gregorianCalendar.setTimeInMillis(j);
        return gregorianCalendar;
    }

    @Deprecated
    public static Calendar monthToCalendar(Month month) {
        return millisToCalendar(monthToMilli(month));
    }

    private static long monthToMilli(Month month) {
        return (((long) (month.getValue() - 1)) * 2678400000L) + 43200000;
    }

    @Deprecated
    public static Calendar temporalToCalendar(Temporal temporal) {
        if (temporal instanceof Instant) {
            og.i("java.time.Instant cannot be formatted, it does not have enough information");
            return null;
        }
        if (temporal instanceof ZonedDateTime) {
            return temporalToCalendar((ZonedDateTime) temporal);
        }
        if (temporal instanceof OffsetDateTime) {
            return temporalToCalendar((OffsetDateTime) temporal);
        }
        if (temporal instanceof OffsetTime) {
            return temporalToCalendar((OffsetTime) temporal);
        }
        if (temporal instanceof LocalDate) {
            return temporalToCalendar((ChronoLocalDate) temporal);
        }
        if (temporal instanceof LocalDateTime) {
            return temporalToCalendar((LocalDateTime) temporal);
        }
        if (temporal instanceof LocalTime) {
            return temporalToCalendar((LocalTime) temporal);
        }
        if (temporal instanceof ChronoLocalDate) {
            return temporalToCalendar((ChronoLocalDate) temporal);
        }
        if (temporal instanceof ChronoLocalDateTime) {
            return temporalToCalendar((ChronoLocalDateTime) temporal);
        }
        og.i("This type cannot be formatted: ".concat(temporal.getClass().getName()));
        return null;
    }

    @Deprecated
    public static TimeZone zoneIdToTimeZone(ZoneId zoneId) {
        return TimeZone.getTimeZone(zoneId.getId());
    }

    @Deprecated
    public static TimeZone zoneOffsetToTimeZone(ZoneOffset zoneOffset) {
        return new SimpleTimeZone(zoneOffset.getTotalSeconds() * 1000, zoneOffset.getId());
    }

    private static Calendar millisToCalendar(long j) {
        return millisToCalendar(j, TimeZone.GMT_ZONE);
    }

    @Deprecated
    public static Calendar temporalToCalendar(OffsetTime offsetTime) {
        return temporalToCalendar(offsetTime.atDate(LocalDate.now()));
    }

    @Deprecated
    public static Calendar temporalToCalendar(OffsetDateTime offsetDateTime) {
        return millisToCalendar((offsetDateTime.toEpochSecond() * 1000) + ((long) offsetDateTime.get(ChronoField.MILLI_OF_SECOND)), zoneOffsetToTimeZone(offsetDateTime.getOffset()));
    }

    @Deprecated
    public static Calendar temporalToCalendar(ChronoLocalDate chronoLocalDate) {
        return millisToCalendar(chronoLocalDate.toEpochDay() * 86400000);
    }

    @Deprecated
    public static Calendar temporalToCalendar(LocalTime localTime) {
        return millisToCalendar(localTime.toNanoOfDay() / 1000000);
    }

    @Deprecated
    public static Calendar temporalToCalendar(LocalDateTime localDateTime) {
        return millisToCalendar((localDateTime.toEpochSecond(ZoneId.systemDefault().getRules().getOffset(localDateTime)) * 1000) + ((long) localDateTime.get(ChronoField.MILLI_OF_SECOND)), TimeZone.getDefault());
    }

    @Deprecated
    public static Calendar temporalToCalendar(ZonedDateTime zonedDateTime) {
        return millisToCalendar((zonedDateTime.toEpochSecond() * 1000) + ((long) zonedDateTime.get(ChronoField.MILLI_OF_SECOND)), zoneIdToTimeZone(zonedDateTime.getZone()));
    }
}
