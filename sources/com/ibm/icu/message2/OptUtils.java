package com.ibm.icu.message2;

import defpackage.cq;
import defpackage.og;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class OptUtils {
    private static final Pattern RE_NUMBER_LITERAL = Pattern.compile("^-?(0|[1-9][0-9]*)(\\.[0-9]+)?([eE][+\\-]?[0-9]+)?$");

    private OptUtils() {
    }

    public static Number asNumber(boolean z, String str, Object obj) {
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof CharSequence) {
            try {
                if (RE_NUMBER_LITERAL.matcher(obj.toString()).find()) {
                    return Double.valueOf(Double.parseDouble(obj.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
        if (!z) {
            return null;
        }
        og.i(cq.v("bad-operand: ", str, " must be numeric"));
        return null;
    }

    public static Directionality getBestDirectionality(Map<String, ?> map, Locale locale) {
        Directionality directionality = getDirectionality(map);
        return directionality == Directionality.UNKNOWN ? Directionality.of(locale) : directionality;
    }

    public static Locale getBestLocale(Map<String, ?> map, Locale locale) {
        String string = getString(map, "u:locale");
        Locale localeForLanguageTag = null;
        if (string != null) {
            try {
                localeForLanguageTag = Locale.forLanguageTag(string.replace('_', '-'));
            } catch (Exception unused) {
                if (reportErrors(map)) {
                    og.i("bad-operand: u:locale must be a valid BCP 47 language tag");
                    return null;
                }
            }
        }
        if (localeForLanguageTag == null) {
            return locale == null ? Locale.getDefault() : locale;
        }
        return localeForLanguageTag;
    }

    public static Integer getDigitSizeOption(Map<String, ?> map, boolean z, String str) {
        Integer integer = getInteger(map, z, str);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() >= 0) {
            return integer;
        }
        og.i(cq.v("bad-option: `", str, "` must be >= 0."));
        return null;
    }

    public static Directionality getDirectionality(Map<String, ?> map) {
        String string = getString(map, "u:dir");
        if (string == null) {
            return Directionality.UNKNOWN;
        }
        switch (string) {
            case "ltr":
                return Directionality.LTR;
            case "rtl":
                return Directionality.RTL;
            case "auto":
                return Directionality.AUTO;
            case "inherit":
                return Directionality.INHERIT;
            default:
                return Directionality.UNKNOWN;
        }
    }

    public static Integer getInteger(Map<String, ?> map, boolean z, String str) {
        Number numberAsNumber;
        Object obj = map.get(str);
        if (obj == null || (numberAsNumber = asNumber(z, str, obj)) == null) {
            return null;
        }
        return Integer.valueOf(numberAsNumber.intValue());
    }

    public static String getString(Map<String, ?> map, String str, String str2) {
        Object obj = map.get(str);
        return obj instanceof CharSequence ? obj.toString() : str2;
    }

    public static String getUId(Map<String, ?> map) {
        return getString(map, "u:id");
    }

    public static boolean reportErrors(Map<String, ?> map, Map<String, ?> map2) {
        return reportErrors(map) || reportErrors(map2);
    }

    public static String getString(Map<String, ?> map, String str) {
        return getString(map, str, null);
    }

    public static boolean reportErrors(Map<String, ?> map) {
        return Objects.equals(getString(map, "icu:impl:errorPolicy"), "STRICT");
    }

    public static Number asNumber(Object obj) {
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (!(obj instanceof CharSequence)) {
            return null;
        }
        try {
            if (RE_NUMBER_LITERAL.matcher(obj.toString()).find()) {
                return Double.valueOf(Double.parseDouble(obj.toString()));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
