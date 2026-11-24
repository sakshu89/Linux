package defpackage;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class gl4 {
    public static int a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0094  */
    public static long b(int i, String str) {
        int iA = a(str, 0, i, false);
        Matcher matcher = j60.m.matcher(str);
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int iY = -1;
        int i5 = -1;
        int i6 = -1;
        while (iA < i) {
            int iA2 = a(str, iA + 1, i, true);
            matcher.region(iA, iA2);
            if (i3 == -1 && matcher.usePattern(j60.m).matches()) {
                String strGroup = matcher.group(1);
                strGroup.getClass();
                i3 = Integer.parseInt(strGroup);
                String strGroup2 = matcher.group(2);
                strGroup2.getClass();
                i5 = Integer.parseInt(strGroup2);
                String strGroup3 = matcher.group(3);
                strGroup3.getClass();
                i6 = Integer.parseInt(strGroup3);
            } else if (i4 == -1 && matcher.usePattern(j60.l).matches()) {
                String strGroup4 = matcher.group(1);
                strGroup4.getClass();
                i4 = Integer.parseInt(strGroup4);
            } else if (iY == -1) {
                Pattern pattern = j60.k;
                if (matcher.usePattern(pattern).matches()) {
                    String strGroup5 = matcher.group(1);
                    strGroup5.getClass();
                    Locale locale = Locale.US;
                    String strO = cq.o(locale, strGroup5, locale);
                    String strPattern = pattern.pattern();
                    strPattern.getClass();
                    iY = cs2.y(strPattern, strO, 0, false, 6) / 4;
                } else if (i2 != -1 && matcher.usePattern(j60.j).matches()) {
                    String strGroup6 = matcher.group(1);
                    strGroup6.getClass();
                    i2 = Integer.parseInt(strGroup6);
                }
            } else if (i2 != -1) {
            }
            iA = a(str, iA2 + 1, i, false);
        }
        if (70 <= i2 && i2 < 100) {
            i2 += 1900;
        }
        if (i2 >= 0 && i2 < 70) {
            i2 += 2000;
        }
        if (i2 < 1601) {
            og.i("Failed requirement.");
            return 0L;
        }
        if (iY == -1) {
            og.i("Failed requirement.");
            return 0L;
        }
        if (1 > i4 || i4 >= 32) {
            og.i("Failed requirement.");
            return 0L;
        }
        if (i3 < 0 || i3 >= 24) {
            og.i("Failed requirement.");
            return 0L;
        }
        if (i5 < 0 || i5 >= 60) {
            og.i("Failed requirement.");
            return 0L;
        }
        if (i6 < 0 || i6 >= 60) {
            og.i("Failed requirement.");
            return 0L;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(z53.e);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i2);
        gregorianCalendar.set(2, iY - 1);
        gregorianCalendar.set(5, i4);
        gregorianCalendar.set(11, i3);
        gregorianCalendar.set(12, i5);
        gregorianCalendar.set(13, i6);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }
}
