package com.ibm.icu.message2;

import com.ibm.icu.impl.JavaTimeConverters;
import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.util.GregorianCalendar;
import com.ibm.icu.util.SimpleTimeZone;
import com.ibm.icu.util.TimeZone;
import defpackage.cq;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.temporal.Temporal;
import java.util.AbstractMap;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class DateTimeFunctionFactory implements FunctionFactory {
    private static Map<String, String> DATE_STYLES_TO_SKELETON;
    private static final Pattern ISO_PATTERN;
    private static Map<String, String> TIME_STYLES_TO_SKELETON;
    private final String kind;

    static {
        Map.Entry[] entryArr = {new AbstractMap.SimpleImmutableEntry("weekday::long", DateFormat.WEEKDAY), new AbstractMap.SimpleImmutableEntry("weekday::medium", DateFormat.ABBR_WEEKDAY), new AbstractMap.SimpleImmutableEntry("weekday::short", "EEEEEE"), new AbstractMap.SimpleImmutableEntry("day-weekday::long", "dEEEE"), new AbstractMap.SimpleImmutableEntry("day-weekday::medium", "dE"), new AbstractMap.SimpleImmutableEntry("day-weekday::short", "dEEEEEE"), new AbstractMap.SimpleImmutableEntry("month-day::long", DateFormat.MONTH_DAY), new AbstractMap.SimpleImmutableEntry("month-day::medium", DateFormat.ABBR_MONTH_DAY), new AbstractMap.SimpleImmutableEntry("month-day::short", DateFormat.NUM_MONTH_DAY), new AbstractMap.SimpleImmutableEntry("month-day-weekday::long", "MMMMdEEEE"), new AbstractMap.SimpleImmutableEntry("month-day-weekday::medium", "MMMdE"), new AbstractMap.SimpleImmutableEntry("month-day-weekday::short", "MdEEEEEE"), new AbstractMap.SimpleImmutableEntry("year-month-day::long", DateFormat.YEAR_MONTH_DAY), new AbstractMap.SimpleImmutableEntry("year-month-day::medium", DateFormat.YEAR_ABBR_MONTH_DAY), new AbstractMap.SimpleImmutableEntry("year-month-day::short", DateFormat.YEAR_NUM_MONTH_DAY), new AbstractMap.SimpleImmutableEntry("year-month-day-weekday::long", "yMMMMdEEEE"), new AbstractMap.SimpleImmutableEntry("year-month-day-weekday::medium", "yMMMdE"), new AbstractMap.SimpleImmutableEntry("year-month-day-weekday::short", "yMdEEEEEE")};
        HashMap map = new HashMap(18);
        for (int i = 0; i < 18; i++) {
            Map.Entry entry = entryArr[i];
            Object key = entry.getKey();
            Objects.requireNonNull(key);
            Object value = entry.getValue();
            Objects.requireNonNull(value);
            if (map.put(key, value) != null) {
                dk0.y(key, "duplicate key: ");
                return;
            }
        }
        DATE_STYLES_TO_SKELETON = Collections.unmodifiableMap(map);
        Map.Entry[] entryArr2 = {new AbstractMap.SimpleImmutableEntry("hour::", DateFormat.HOUR), new AbstractMap.SimpleImmutableEntry("hour::true", "h"), new AbstractMap.SimpleImmutableEntry("hour::false", DateFormat.HOUR24), new AbstractMap.SimpleImmutableEntry("minute::", DateFormat.HOUR_MINUTE), new AbstractMap.SimpleImmutableEntry("minute::true", "hm"), new AbstractMap.SimpleImmutableEntry("minute::false", DateFormat.HOUR24_MINUTE), new AbstractMap.SimpleImmutableEntry("second::", DateFormat.HOUR_MINUTE_SECOND), new AbstractMap.SimpleImmutableEntry("second::true", "hms"), new AbstractMap.SimpleImmutableEntry("second::false", DateFormat.HOUR24_MINUTE_SECOND)};
        HashMap map2 = new HashMap(9);
        for (int i2 = 0; i2 < 9; i2++) {
            Map.Entry entry2 = entryArr2[i2];
            Object key2 = entry2.getKey();
            Objects.requireNonNull(key2);
            Object value2 = entry2.getValue();
            Objects.requireNonNull(value2);
            if (map2.put(key2, value2) != null) {
                dk0.y(key2, "duplicate key: ");
                return;
            }
        }
        TIME_STYLES_TO_SKELETON = Collections.unmodifiableMap(map2);
        ISO_PATTERN = Pattern.compile("^(([0-9]{4})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])){1}(T([01][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])(\\.[0-9]{1,3})?(Z|[+-]((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?)?$");
    }

    public DateTimeFunctionFactory(String str) {
        str.getClass();
        switch (str) {
            case "date":
            case "time":
            case "datetime":
                break;
            default:
                str = "datetime";
                break;
        }
        this.kind = str;
    }

    private static String getDateFieldOptions(Map<String, ?> map, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        String str3 = DATE_STYLES_TO_SKELETON.get(cq.k(OptUtils.getString(map, str, ""), "::", OptUtils.getString(map, str2, "")));
        if (str3 != null) {
            sb.append(str3);
        }
        return sb.toString();
    }

    private static String getTimeFieldOptions(Map<String, ?> map, String str) {
        StringBuilder sb = new StringBuilder();
        String str2 = TIME_STYLES_TO_SKELETON.get(cq.k(OptUtils.getString(map, str, ""), "::", OptUtils.getString(map, "hour12", "")));
        if (str2 != null) {
            sb.append(str2);
        }
        String string = OptUtils.getString(map, "timeZoneStyle", "");
        string.getClass();
        if (string.equals("long")) {
            sb.append(DateFormat.SPECIFIC_TZ);
        } else if (string.equals("short")) {
            sb.append(DateFormat.ABBR_SPECIFIC_TZ);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object parseIso8601(String str) {
        Integer numSafeParse;
        Integer num = 0;
        Matcher matcher = ISO_PATTERN.matcher(str);
        if (!matcher.find() || matcher.groupCount() != 12 || matcher.group().isEmpty()) {
            return str;
        }
        Integer numSafeParse2 = safeParse(matcher.group(2));
        Integer numSafeParse3 = safeParse(matcher.group(3));
        Integer numSafeParse4 = safeParse(matcher.group(4));
        Integer numSafeParse5 = safeParse(matcher.group(6));
        Integer numSafeParse6 = safeParse(matcher.group(7));
        Integer numSafeParse7 = safeParse(matcher.group(8));
        if (matcher.group(9) != null) {
            numSafeParse = safeParse((matcher.group(9) + "000").substring(1, 4));
        } else {
            numSafeParse = num;
        }
        String strGroup = matcher.group(10);
        if (numSafeParse5 == null) {
            numSafeParse6 = num;
            numSafeParse7 = numSafeParse6;
        } else {
            num = numSafeParse5;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(numSafeParse2.intValue(), numSafeParse3.intValue() - 1, numSafeParse4.intValue(), num.intValue(), numSafeParse6.intValue(), numSafeParse7.intValue());
        gregorianCalendar.set(14, numSafeParse.intValue());
        if (strGroup != null) {
            if (strGroup.equals("Z")) {
                gregorianCalendar.setTimeZone(TimeZone.GMT_ZONE);
                return gregorianCalendar;
            }
            int i = strGroup.startsWith(LanguageTag.SEP) ? -1 : 1;
            String[] strArrSplit = strGroup.substring(1).split(":");
            if (strArrSplit.length == 2) {
                Integer numSafeParse8 = safeParse(strArrSplit[0]);
                Integer numSafeParse9 = safeParse(strArrSplit[1]);
                if (numSafeParse8 != null && numSafeParse9 != null) {
                    gregorianCalendar.setTimeZone(new SimpleTimeZone((numSafeParse9.intValue() + (numSafeParse8.intValue() * 60)) * i * 60000, "offset"));
                }
            }
        }
        return gregorianCalendar;
    }

    private static Integer safeParse(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    @Override // com.ibm.icu.message2.FunctionFactory
    public Function create(Locale locale, Map<String, ?> map) {
        String dateFieldOptions;
        Locale bestLocale = OptUtils.getBestLocale(map, locale);
        OptUtils.getBestDirectionality(map, bestLocale);
        boolean zReportErrors = OptUtils.reportErrors(map);
        String str = this.kind;
        int iHashCode = str.hashCode();
        if (iHashCode != 3076014) {
            if (iHashCode != 3560141) {
                if (iHashCode == 1793702779) {
                    str.equals("datetime");
                }
            } else if (str.equals("time")) {
                dateFieldOptions = getTimeFieldOptions(map, "precision");
            }
        } else {
            dateFieldOptions = str.equals("date") ? getDateFieldOptions(map, "fields", "length") : ky0.j(getDateFieldOptions(map, "dateFields", "dateLength"), getTimeFieldOptions(map, "timePrecision"));
        }
        if (dateFieldOptions.isEmpty()) {
            dateFieldOptions = OptUtils.getString(map, "icu:skeleton", "");
        }
        if (dateFieldOptions.isEmpty()) {
            String str2 = this.kind;
            int iHashCode2 = str2.hashCode();
            if (iHashCode2 != 3076014) {
                if (iHashCode2 != 3560141) {
                    if (iHashCode2 == 1793702779) {
                        str2.equals("datetime");
                    }
                } else if (str2.equals("time")) {
                    dateFieldOptions = TIME_STYLES_TO_SKELETON.get("minute::");
                }
            } else {
                dateFieldOptions = str2.equals("date") ? DATE_STYLES_TO_SKELETON.get("year-month-day-weekday::medium") : ky0.j(DATE_STYLES_TO_SKELETON.get("year-month-day-weekday::medium"), TIME_STYLES_TO_SKELETON.get("minute::"));
            }
        }
        TimeZone timeZone = TimeZone.getDefault();
        String string = OptUtils.getString(map, "timeZone", "");
        if (!string.isEmpty()) {
            timeZone = TimeZone.getTimeZone(string);
        }
        String string2 = OptUtils.getString(map, "calendar", "");
        if (!string2.isEmpty()) {
            bestLocale = new Locale.Builder().setLocale(bestLocale).setUnicodeLocaleKeyword("ca", string2).build();
        }
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(dateFieldOptions, bestLocale);
        if (!timeZone.equals(TimeZone.UNKNOWN_ZONE)) {
            instanceForSkeleton.setTimeZone(timeZone);
        }
        return new DateTimeFunctionImpl(bestLocale, instanceForSkeleton, zReportErrors, 0);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class DateTimeFunctionImpl implements Function {
        private final DateFormat icuFormatter;
        private final Locale locale;
        private final boolean reportErrors;

        private DateTimeFunctionImpl(Locale locale, DateFormat dateFormat, boolean z) {
            this.locale = locale;
            this.icuFormatter = dateFormat;
            this.reportErrors = z;
        }

        @Override // com.ibm.icu.message2.Function
        public FormattedPlaceholder format(Object obj, Map<String, ?> map) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof CharSequence) {
                obj = DateTimeFunctionFactory.parseIso8601(obj.toString());
                if (obj instanceof CharSequence) {
                    if (!this.reportErrors) {
                        return new FormattedPlaceholder(obj, new PlainStringFormattedValue(cq.v("{|", String.valueOf(obj), "|}")));
                    }
                    og.i("bad-operand: argument must be ISO 8601");
                    return null;
                }
            } else if (obj instanceof Temporal) {
                obj = JavaTimeConverters.temporalToCalendar((Temporal) obj);
            } else if (obj instanceof DayOfWeek) {
                obj = JavaTimeConverters.dayOfWeekToCalendar((DayOfWeek) obj);
            } else if (obj instanceof Month) {
                obj = JavaTimeConverters.monthToCalendar((Month) obj);
            }
            if (obj instanceof Calendar) {
                obj = JavaTimeConverters.convertCalendar((Calendar) obj);
            }
            return new FormattedPlaceholder(obj, new PlainStringFormattedValue(this.icuFormatter.format(obj)));
        }

        @Override // com.ibm.icu.message2.Function
        public String formatToString(Object obj, Map<String, ?> map) {
            FormattedPlaceholder formattedPlaceholder = format(obj, map);
            if (formattedPlaceholder != null) {
                return formattedPlaceholder.toString();
            }
            return null;
        }

        public /* synthetic */ DateTimeFunctionImpl(Locale locale, DateFormat dateFormat, boolean z, int i) {
            this(locale, dateFormat, z);
        }
    }
}
