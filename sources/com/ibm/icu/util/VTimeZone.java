package com.ibm.icu.util;

import com.ibm.icu.impl.CalendarAstronomer;
import com.ibm.icu.impl.Grego;
import defpackage.cq;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class VTimeZone extends BasicTimeZone implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String COLON = ":";
    private static final String COMMA = ",";
    private static final int DEF_DSTSAVINGS = 3600000;
    private static final long DEF_TZSTARTTIME = 0;
    private static final String EQUALS_SIGN = "=";
    private static final int ERR = 3;
    private static final String ICAL_BEGIN = "BEGIN";
    private static final String ICAL_BEGIN_VTIMEZONE = "BEGIN:VTIMEZONE";
    private static final String ICAL_BYDAY = "BYDAY";
    private static final String ICAL_BYMONTH = "BYMONTH";
    private static final String ICAL_BYMONTHDAY = "BYMONTHDAY";
    private static final String ICAL_DAYLIGHT = "DAYLIGHT";
    private static final String ICAL_DTSTART = "DTSTART";
    private static final String ICAL_END = "END";
    private static final String ICAL_END_VTIMEZONE = "END:VTIMEZONE";
    private static final String ICAL_FREQ = "FREQ";
    private static final String ICAL_LASTMOD = "LAST-MODIFIED";
    private static final String ICAL_RDATE = "RDATE";
    private static final String ICAL_RRULE = "RRULE";
    private static final String ICAL_STANDARD = "STANDARD";
    private static final String ICAL_TZID = "TZID";
    private static final String ICAL_TZNAME = "TZNAME";
    private static final String ICAL_TZOFFSETFROM = "TZOFFSETFROM";
    private static final String ICAL_TZOFFSETTO = "TZOFFSETTO";
    private static final String ICAL_TZURL = "TZURL";
    private static final String ICAL_UNTIL = "UNTIL";
    private static final String ICAL_VTIMEZONE = "VTIMEZONE";
    private static final String ICAL_YEARLY = "YEARLY";
    private static final String ICU_TZINFO_PROP = "X-TZINFO";
    private static String ICU_TZVERSION = null;
    private static final int INI = 0;
    private static final long MAX_TIME = Long.MAX_VALUE;
    private static final long MIN_TIME = Long.MIN_VALUE;
    private static final String NEWLINE = "\r\n";
    private static final String SEMICOLON = ";";
    private static final int TZI = 2;
    private static final int VTZ = 1;
    private static final long serialVersionUID = -6851467294127795902L;
    private volatile transient boolean isFrozen;
    private Date lastmod;
    private String olsonzid;
    private BasicTimeZone tz;
    private String tzurl;
    private List<String> vtzlines;
    private static final String[] ICAL_DOW_NAMES = {"SU", "MO", "TU", "WE", "TH", "FR", "SA"};
    private static final int[] MONTHLENGTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static {
        try {
            ICU_TZVERSION = TimeZone.getTZDataVersion();
        } catch (MissingResourceException unused) {
            ICU_TZVERSION = null;
        }
    }

    private VTimeZone() {
        this.olsonzid = null;
        this.tzurl = null;
        this.lastmod = null;
        this.isFrozen = false;
    }

    private static void appendUNTIL(Writer writer, String str) throws IOException {
        if (str != null) {
            writer.write(SEMICOLON);
            writer.write(ICAL_UNTIL);
            writer.write(EQUALS_SIGN);
            writer.write(str);
        }
    }

    private static void beginRRULE(Writer writer, int i) throws IOException {
        writer.write(ICAL_RRULE);
        writer.write(COLON);
        writer.write(ICAL_FREQ);
        writer.write(EQUALS_SIGN);
        writer.write(ICAL_YEARLY);
        writer.write(SEMICOLON);
        writer.write(ICAL_BYMONTH);
        writer.write(EQUALS_SIGN);
        writer.write(Integer.toString(i + 1));
        writer.write(SEMICOLON);
    }

    private static void beginZoneProps(Writer writer, boolean z, String str, int i, int i2, long j) throws IOException {
        writer.write(ICAL_BEGIN);
        writer.write(COLON);
        if (z) {
            writer.write(ICAL_DAYLIGHT);
        } else {
            writer.write(ICAL_STANDARD);
        }
        writer.write(NEWLINE);
        writer.write(ICAL_TZOFFSETTO);
        writer.write(COLON);
        writer.write(millisToOffset(i2));
        writer.write(NEWLINE);
        writer.write(ICAL_TZOFFSETFROM);
        writer.write(COLON);
        writer.write(millisToOffset(i));
        writer.write(NEWLINE);
        writer.write(ICAL_TZNAME);
        writer.write(COLON);
        writer.write(str);
        writer.write(NEWLINE);
        writer.write(ICAL_DTSTART);
        writer.write(COLON);
        writer.write(getDateTimeString(j + ((long) i)));
        writer.write(NEWLINE);
    }

    public static VTimeZone create(String str) {
        BasicTimeZone frozenICUTimeZone = TimeZone.getFrozenICUTimeZone(str, true);
        if (frozenICUTimeZone == null) {
            return null;
        }
        VTimeZone vTimeZone = new VTimeZone(str);
        BasicTimeZone basicTimeZone = (BasicTimeZone) frozenICUTimeZone.cloneAsThawed();
        vTimeZone.tz = basicTimeZone;
        vTimeZone.olsonzid = basicTimeZone.getID();
        return vTimeZone;
    }

    private static TimeZoneRule createRuleByRDATE(String str, int i, int i2, long j, List<String> list, int i3) {
        long[] jArr;
        int i4 = 0;
        if (list == null || list.size() == 0) {
            jArr = new long[]{j};
        } else {
            long[] jArr2 = new long[list.size()];
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    int i5 = i4 + 1;
                    jArr2[i4] = parseDateTimeString(it.next(), i3);
                    i4 = i5;
                }
                jArr = jArr2;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return new TimeArrayTimeZoneRule(str, i, i2, jArr, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static TimeZoneRule createRuleByRRULE(String str, int i, int i2, long j, List<String> list, int i3) {
        TimeZoneRule timeZoneRule;
        int i4;
        int i5;
        int i6;
        DateTimeRule dateTimeRule;
        DateTimeRule dateTimeRule2;
        TimeZoneRule timeZoneRule2 = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        int i7 = 0;
        int i8 = 1;
        long[] jArr = new long[1];
        int[] rrule = parseRRULE(list.get(0), jArr);
        if (rrule == null) {
            return null;
        }
        int i9 = rrule[0];
        int i10 = rrule[1];
        int i11 = rrule[2];
        char c = 3;
        int i12 = rrule[3];
        if (list.size() == 1) {
            if (rrule.length > 4) {
                if (rrule.length != 10 || i9 == -1 || i10 == 0) {
                    return null;
                }
                int[] iArr = new int[7];
                i12 = 31;
                for (int i13 = 0; i13 < 7; i13++) {
                    int i14 = rrule[i13 + 3];
                    iArr[i13] = i14;
                    if (i14 <= 0) {
                        i14 = MONTHLENGTH[i9] + i14 + 1;
                    }
                    iArr[i13] = i14;
                    if (i14 < i12) {
                        i12 = i14;
                    }
                }
                for (int i15 = 1; i15 < 7; i15++) {
                    for (int i16 = 0; i16 < 7; i16++) {
                        if (iArr[i16] == i12 + i15) {
                        }
                    }
                    return null;
                }
            }
            timeZoneRule = null;
            i4 = 0;
        } else {
            if (i9 == -1 || i10 == 0 || i12 == 0) {
                return null;
            }
            if (list.size() > 7) {
                return null;
            }
            int length = rrule.length - 3;
            int i17 = 0;
            int i18 = 31;
            while (i17 < length) {
                int i19 = rrule[i17 + 3];
                if (i19 <= 0) {
                    i19 = MONTHLENGTH[i9] + i19 + 1;
                }
                char c2 = c;
                int i20 = i19;
                if (i20 < i18) {
                    i18 = i20;
                }
                i17++;
                c = c2;
            }
            char c3 = c;
            int i21 = 1;
            int i22 = i9;
            int i23 = -1;
            while (i21 < list.size()) {
                int i24 = i7;
                long[] jArr2 = new long[i8];
                int[] rrule2 = parseRRULE(list.get(i21), jArr2);
                if (jArr2[i24] > jArr[i24]) {
                    jArr = jArr2;
                }
                int i25 = rrule2[i24];
                TimeZoneRule timeZoneRule3 = timeZoneRule2;
                if (i25 == -1 || (i5 = rrule2[i8]) == 0 || rrule2[c3] == 0) {
                    return timeZoneRule3;
                }
                int length2 = rrule2.length - 3;
                length += length2;
                if (length > 7) {
                    return timeZoneRule3;
                }
                if (i5 != i10) {
                    return timeZoneRule3;
                }
                if (i25 != i9) {
                    if (i23 == -1) {
                        int i26 = i25 - i9;
                        if (i26 == -11 || i26 == -1) {
                            i22 = i25;
                            i18 = 31;
                        } else if (i26 != 11 && i26 != 1) {
                            return timeZoneRule3;
                        }
                        i23 = i25;
                    } else if (i25 != i9 && i25 != i23) {
                        return timeZoneRule3;
                    }
                }
                if (i25 == i22) {
                    for (int i27 = i24; i27 < length2; i27++) {
                        int i28 = rrule2[i27 + 3];
                        if (i28 <= 0) {
                            i28 = MONTHLENGTH[rrule2[i24]] + i28 + 1;
                        }
                        if (i28 < i18) {
                            i18 = i28;
                        }
                    }
                }
                i21++;
                i7 = i24;
                timeZoneRule2 = timeZoneRule3;
                i8 = 1;
            }
            timeZoneRule = timeZoneRule2;
            i4 = i7;
            if (length != 7) {
                return timeZoneRule;
            }
            i12 = i18;
            i9 = i22;
        }
        int[] iArrTimeToFields = Grego.timeToFields(j + ((long) i3), timeZoneRule);
        int i29 = iArrTimeToFields[i4];
        if (i9 == -1) {
            i9 = iArrTimeToFields[1];
        }
        int i30 = i9;
        if (i10 == 0 && i11 == 0 && i12 == 0) {
            i12 = iArrTimeToFields[2];
        }
        int i31 = iArrTimeToFields[5];
        long j2 = jArr[i4];
        if (j2 != MIN_TIME) {
            Grego.timeToFields(j2, iArrTimeToFields);
            i6 = iArrTimeToFields[i4];
        } else {
            i6 = Integer.MAX_VALUE;
        }
        int i32 = i6;
        if (i10 == 0 && i11 == 0 && i12 != 0) {
            dateTimeRule2 = new DateTimeRule(i30, i12, i31, i4);
        } else {
            if (i10 == 0 || i11 == 0 || i12 != 0) {
                if (i10 == 0 || i11 != 0 || i12 == 0) {
                    return null;
                }
                dateTimeRule = new DateTimeRule(i30, i12, i10, true, i31, 0);
            } else {
                dateTimeRule = new DateTimeRule(i30, i11, i10, i31, 0);
            }
            dateTimeRule2 = dateTimeRule;
        }
        return new AnnualTimeZoneRule(str, i, i2, dateTimeRule2, i29, i32);
    }

    private static void endZoneProps(Writer writer, boolean z) throws IOException {
        writer.write(ICAL_END);
        writer.write(COLON);
        if (z) {
            writer.write(ICAL_DAYLIGHT);
        } else {
            writer.write(ICAL_STANDARD);
        }
        writer.write(NEWLINE);
    }

    private static String getDateTimeString(long j) {
        int[] iArrTimeToFields = Grego.timeToFields(j, null);
        StringBuilder sb = new StringBuilder(15);
        sb.append(numToString(iArrTimeToFields[0], 4));
        sb.append(numToString(iArrTimeToFields[1] + 1, 2));
        sb.append(numToString(iArrTimeToFields[2], 2));
        sb.append('T');
        int i = iArrTimeToFields[5];
        int i2 = i / 3600000;
        int i3 = i % 3600000;
        sb.append(numToString(i2, 2));
        sb.append(numToString(i3 / 60000, 2));
        sb.append(numToString((i3 % 60000) / 1000, 2));
        return sb.toString();
    }

    private static String getDefaultTZName(String str, boolean z) {
        return z ? ky0.j(str, "(DST)") : ky0.j(str, "(STD)");
    }

    private static String getUTCDateTimeString(long j) {
        return ky0.j(getDateTimeString(j), "Z");
    }

    private static boolean isEquivalentDateRule(int i, int i2, int i3, DateTimeRule dateTimeRule) {
        if (i != dateTimeRule.getRuleMonth() || i3 != dateTimeRule.getRuleDayOfWeek() || dateTimeRule.getTimeRuleType() != 0) {
            return false;
        }
        if (dateTimeRule.getDateRuleType() == 1 && dateTimeRule.getRuleWeekInMonth() == i2) {
            return true;
        }
        int ruleDayOfMonth = dateTimeRule.getRuleDayOfMonth();
        if (dateTimeRule.getDateRuleType() == 2) {
            if (ruleDayOfMonth % 7 == 1 && (ruleDayOfMonth + 6) / 7 == i2) {
                return true;
            }
            if (i != 1) {
                int i4 = MONTHLENGTH[i];
                if ((i4 - ruleDayOfMonth) % 7 == 6 && i2 == (((i4 - ruleDayOfMonth) + 1) / 7) * (-1)) {
                    return true;
                }
            }
        }
        if (dateTimeRule.getDateRuleType() == 3) {
            if (ruleDayOfMonth % 7 == 0 && ruleDayOfMonth / 7 == i2) {
                return true;
            }
            if (i != 1) {
                int i5 = MONTHLENGTH[i];
                if ((i5 - ruleDayOfMonth) % 7 == 0 && i2 == (((i5 - ruleDayOfMonth) / 7) + 1) * (-1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean load(Reader reader) {
        try {
            this.vtzlines = new LinkedList();
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            boolean z2 = false;
            while (true) {
                int i = reader.read();
                if (i == -1) {
                    if (!z || !sb.toString().startsWith(ICAL_END_VTIMEZONE)) {
                        return false;
                    }
                    this.vtzlines.add(sb.toString());
                    break;
                }
                if (i != 13) {
                    if (z2) {
                        if (i != 9 && i != 32) {
                            if (z && sb.length() > 0) {
                                this.vtzlines.add(sb.toString());
                            }
                            sb.setLength(0);
                            if (i != 10) {
                                sb.append((char) i);
                            }
                        }
                    } else if (i == 10) {
                        z2 = true;
                        if (z) {
                            if (sb.toString().startsWith(ICAL_END_VTIMEZONE)) {
                                this.vtzlines.add(sb.toString());
                                break;
                            }
                        } else if (sb.toString().startsWith(ICAL_BEGIN_VTIMEZONE)) {
                            this.vtzlines.add(sb.toString());
                            sb.setLength(0);
                            z = true;
                        }
                    } else {
                        sb.append((char) i);
                    }
                    z2 = false;
                }
            }
            return parse();
        } catch (IOException unused) {
            return false;
        }
    }

    private static String millisToOffset(int i) {
        StringBuilder sb = new StringBuilder(7);
        if (i >= 0) {
            sb.append('+');
        } else {
            sb.append('-');
            i = -i;
        }
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 - i3) / 60;
        sb.append(numToString(i4 / 60, 2));
        sb.append(numToString(i4 % 60, 2));
        sb.append(numToString(i3, 2));
        return sb.toString();
    }

    private static String numToString(int i, int i2) {
        String string = Integer.toString(i);
        int length = string.length();
        if (length >= i2) {
            return string.substring(length - i2, length);
        }
        StringBuilder sb = new StringBuilder(i2);
        while (length < i2) {
            sb.append('0');
            length++;
        }
        sb.append(string);
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0044  */
    private static int offsetStrToMillis(String str) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        int length;
        if (str != null && ((length = str.length()) == 5 || length == 7)) {
            char cCharAt = str.charAt(0);
            z = true;
            if (cCharAt == '+') {
                i2 = 1;
            } else if (cCharAt == '-') {
                i2 = -1;
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
                z = false;
                i4 = 0;
            }
            try {
                i4 = Integer.parseInt(str.substring(1, 3));
                try {
                    i3 = Integer.parseInt(str.substring(3, 5));
                    if (length == 7) {
                        try {
                            i = Integer.parseInt(str.substring(5, 7));
                        } catch (NumberFormatException unused) {
                            i = 0;
                            z = false;
                        }
                    } else {
                        i = 0;
                    }
                } catch (NumberFormatException unused2) {
                    i3 = 0;
                }
            } catch (NumberFormatException unused3) {
                i3 = 0;
                i4 = 0;
            }
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            z = false;
            i4 = 0;
        }
        if (z) {
            return ((((i4 * 60) + i3) * 60) + i) * i2 * 1000;
        }
        og.i("Bad offset string");
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:87:0x0160 A[PHI: r2 r5 r6 r12
      0x0160: PHI (r2v26 com.ibm.icu.util.TimeZoneRule) = 
      (r2v25 com.ibm.icu.util.TimeZoneRule)
      (r2v33 com.ibm.icu.util.TimeZoneRule)
      (r2v33 com.ibm.icu.util.TimeZoneRule)
      (r2v33 com.ibm.icu.util.TimeZoneRule)
     binds: [B:72:0x012a, B:75:0x013a, B:162:0x0160, B:78:0x0147] A[DONT_GENERATE, DONT_INLINE]
      0x0160: PHI (r5v37 java.lang.String) = (r5v36 java.lang.String), (r5v46 java.lang.String), (r5v46 java.lang.String), (r5v46 java.lang.String) binds: [B:72:0x012a, B:75:0x013a, B:162:0x0160, B:78:0x0147] A[DONT_GENERATE, DONT_INLINE]
      0x0160: PHI (r6v14 boolean) = (r6v13 boolean), (r14v1 boolean), (r14v1 boolean), (r14v1 boolean) binds: [B:72:0x012a, B:75:0x013a, B:162:0x0160, B:78:0x0147] A[DONT_GENERATE, DONT_INLINE]
      0x0160: PHI (r12v23 java.lang.String) = (r12v22 java.lang.String), (r12v30 java.lang.String), (r12v30 java.lang.String), (r12v30 java.lang.String) binds: [B:72:0x012a, B:75:0x013a, B:162:0x0160, B:78:0x0147] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    private boolean parse() {
        long j;
        String str;
        boolean z;
        char c;
        TimeZoneRule timeZoneRuleCreateRuleByRDATE;
        int i;
        int i2;
        int i3;
        List<String> list = this.vtzlines;
        int i4 = 0;
        if (list == null || list.size() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.vtzlines.iterator();
        long time = MAX_TIME;
        int i5 = 0;
        int i6 = 0;
        char c2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String defaultTZName = null;
        LinkedList linkedList = null;
        String str4 = null;
        String str5 = null;
        while (it.hasNext()) {
            String next = it.next();
            int iIndexOf = next.indexOf(COLON);
            if (iIndexOf >= 0) {
                Iterator<String> it2 = it;
                String strSubstring = next.substring(i4, iIndexOf);
                String strSubstring2 = next.substring(iIndexOf + 1);
                if (c2 != 0) {
                    j = time;
                    if (c2 != 1) {
                        if (c2 == 2) {
                            if (strSubstring.equals(ICAL_DTSTART)) {
                                str3 = strSubstring2;
                            } else if (strSubstring.equals(ICAL_TZNAME)) {
                                defaultTZName = strSubstring2;
                            } else if (strSubstring.equals(ICAL_TZOFFSETFROM)) {
                                str4 = strSubstring2;
                            } else if (strSubstring.equals(ICAL_TZOFFSETTO)) {
                                str5 = strSubstring2;
                            } else {
                                if (strSubstring.equals(ICAL_RDATE)) {
                                    if (!z2) {
                                        if (linkedList == null) {
                                            linkedList = new LinkedList();
                                        }
                                        LinkedList linkedList2 = linkedList;
                                        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(strSubstring2, COMMA);
                                        while (stringTokenizer.hasMoreTokens()) {
                                            linkedList2.add(stringTokenizer.nextToken());
                                        }
                                        linkedList = linkedList2;
                                    }
                                } else if (strSubstring.equals(ICAL_RRULE)) {
                                    if (z2 || linkedList == null) {
                                        if (linkedList == null) {
                                            linkedList = new LinkedList();
                                        }
                                        LinkedList linkedList3 = linkedList;
                                        linkedList3.add(strSubstring2);
                                        linkedList = linkedList3;
                                        time = j;
                                        c = 3;
                                        z2 = true;
                                    }
                                } else if (strSubstring.equals(ICAL_END)) {
                                    if (str3 == null || str4 == null || str5 == null) {
                                        str = str3;
                                        z = z3;
                                        str3 = str;
                                        z3 = z;
                                    } else {
                                        if (defaultTZName == null) {
                                            defaultTZName = getDefaultTZName(str2, z3);
                                        }
                                        try {
                                            int iOffsetStrToMillis = offsetStrToMillis(str4);
                                            int iOffsetStrToMillis2 = offsetStrToMillis(str5);
                                            i = 3600000;
                                            if (z3) {
                                                int i7 = iOffsetStrToMillis2 - iOffsetStrToMillis;
                                                if (i7 > 0) {
                                                    i3 = i7;
                                                    i2 = iOffsetStrToMillis;
                                                } else {
                                                    i2 = iOffsetStrToMillis2 - 3600000;
                                                    i3 = 3600000;
                                                }
                                            } else {
                                                i2 = iOffsetStrToMillis2;
                                                i3 = 0;
                                            }
                                            try {
                                                long dateTimeString = parseDateTimeString(str3, iOffsetStrToMillis);
                                                if (z2) {
                                                    String str6 = defaultTZName;
                                                    int i8 = i2;
                                                    str3 = str3;
                                                    defaultTZName = str6;
                                                    try {
                                                        timeZoneRuleCreateRuleByRDATE = createRuleByRRULE(defaultTZName, i8, i3, dateTimeString, linkedList, iOffsetStrToMillis);
                                                        i5 = iOffsetStrToMillis;
                                                    } catch (IllegalArgumentException unused) {
                                                        timeZoneRuleCreateRuleByRDATE = null;
                                                    }
                                                } else {
                                                    String str7 = defaultTZName;
                                                    int i9 = i2;
                                                    str3 = str3;
                                                    defaultTZName = str7;
                                                    timeZoneRuleCreateRuleByRDATE = createRuleByRDATE(defaultTZName, i9, i3, dateTimeString, linkedList, iOffsetStrToMillis);
                                                    i5 = iOffsetStrToMillis;
                                                }
                                                if (timeZoneRuleCreateRuleByRDATE != null) {
                                                    try {
                                                        Date firstStart = timeZoneRuleCreateRuleByRDATE.getFirstStart(i5, 0);
                                                        if (firstStart.getTime() < j) {
                                                            time = firstStart.getTime();
                                                            if (i3 <= 0 && i5 - iOffsetStrToMillis2 == 3600000) {
                                                                i5 -= 3600000;
                                                            } else {
                                                                i = 0;
                                                            }
                                                        } else {
                                                            i5 = i5;
                                                            i = i6;
                                                            time = j;
                                                        }
                                                    } catch (IllegalArgumentException unused2) {
                                                    }
                                                } else {
                                                    i5 = i5;
                                                    i = i6;
                                                    time = j;
                                                }
                                            } catch (IllegalArgumentException unused3) {
                                                str3 = str3;
                                                defaultTZName = defaultTZName;
                                            }
                                        } catch (IllegalArgumentException unused4) {
                                            str3 = str3;
                                            defaultTZName = defaultTZName;
                                            z3 = z3;
                                        }
                                        if (timeZoneRuleCreateRuleByRDATE == null) {
                                            c = 3;
                                            c2 = 3;
                                        } else {
                                            arrayList.add(timeZoneRuleCreateRuleByRDATE);
                                            c = 3;
                                            c2 = 1;
                                        }
                                        i6 = i;
                                    }
                                }
                                time = j;
                                c = 3;
                                c2 = 3;
                            }
                            time = j;
                            c = 3;
                        }
                        str = str3;
                        z = z3;
                        str3 = str;
                        z3 = z;
                        time = j;
                        c = 3;
                    } else {
                        str = str3;
                        z = z3;
                        if (strSubstring.equals(ICAL_TZID)) {
                            str2 = strSubstring2;
                        } else if (strSubstring.equals(ICAL_TZURL)) {
                            this.tzurl = strSubstring2;
                        } else if (strSubstring.equals(ICAL_LASTMOD)) {
                            this.lastmod = new Date(parseDateTimeString(strSubstring2, 0));
                        } else if (strSubstring.equals(ICAL_BEGIN)) {
                            boolean zEquals = strSubstring2.equals(ICAL_DAYLIGHT);
                            if ((strSubstring2.equals(ICAL_STANDARD) || zEquals) && str2 != null) {
                                z3 = zEquals;
                                str3 = str;
                                time = j;
                                c = 3;
                                c2 = 2;
                                z2 = false;
                                defaultTZName = null;
                                linkedList = null;
                                str4 = null;
                                str5 = null;
                            } else {
                                str3 = str;
                                z3 = z;
                                time = j;
                                c = 3;
                                c2 = 3;
                            }
                        } else {
                            strSubstring.equals(ICAL_END);
                        }
                        str3 = str;
                        z3 = z;
                        time = j;
                        c = 3;
                    }
                } else {
                    j = time;
                    str = str3;
                    z = z3;
                    if (strSubstring.equals(ICAL_BEGIN) && strSubstring2.equals(ICAL_VTIMEZONE)) {
                        str3 = str;
                        z3 = z;
                        time = j;
                        c = 3;
                        c2 = 1;
                    } else {
                        str3 = str;
                        z3 = z;
                        time = j;
                        c = 3;
                    }
                }
                if (c2 == c) {
                    this.vtzlines = null;
                    return false;
                }
                it = it2;
                i4 = 0;
            }
        }
        boolean z4 = i4;
        if (arrayList.size() == 0) {
            return z4;
        }
        RuleBasedTimeZone ruleBasedTimeZone = new RuleBasedTimeZone(str2, new InitialTimeZoneRule(getDefaultTZName(str2, z4), i5, i6));
        int i10 = -1;
        int i11 = 0;
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            TimeZoneRule timeZoneRule = (TimeZoneRule) arrayList.get(i12);
            if ((timeZoneRule instanceof AnnualTimeZoneRule) && ((AnnualTimeZoneRule) timeZoneRule).getEndYear() == Integer.MAX_VALUE) {
                i11++;
                i10 = i12;
            }
        }
        if (i11 > 2) {
            return false;
        }
        if (i11 == 1) {
            if (arrayList.size() == 1) {
                arrayList.clear();
            } else {
                AnnualTimeZoneRule annualTimeZoneRule = (AnnualTimeZoneRule) arrayList.get(i10);
                int rawOffset = annualTimeZoneRule.getRawOffset();
                int dSTSavings = annualTimeZoneRule.getDSTSavings();
                Date firstStart2 = annualTimeZoneRule.getFirstStart(i5, i6);
                Date nextStart = firstStart2;
                for (int i13 = 0; i13 < arrayList.size(); i13++) {
                    if (i10 != i13) {
                        TimeZoneRule timeZoneRule2 = (TimeZoneRule) arrayList.get(i13);
                        Date finalStart = timeZoneRule2.getFinalStart(rawOffset, dSTSavings);
                        if (finalStart.after(nextStart)) {
                            nextStart = annualTimeZoneRule.getNextStart(finalStart.getTime(), timeZoneRule2.getRawOffset(), timeZoneRule2.getDSTSavings(), false);
                        }
                    }
                }
                arrayList.set(i10, nextStart.equals(firstStart2) ? new TimeArrayTimeZoneRule(annualTimeZoneRule.getName(), annualTimeZoneRule.getRawOffset(), annualTimeZoneRule.getDSTSavings(), new long[]{firstStart2.getTime()}, 2) : new AnnualTimeZoneRule(annualTimeZoneRule.getName(), annualTimeZoneRule.getRawOffset(), annualTimeZoneRule.getDSTSavings(), annualTimeZoneRule.getRule(), annualTimeZoneRule.getStartYear(), Grego.timeToYear(nextStart.getTime())));
            }
        }
        int size = arrayList.size();
        int i14 = 0;
        while (i14 < size) {
            Object obj = arrayList.get(i14);
            i14++;
            ruleBasedTimeZone.addTransitionRule((TimeZoneRule) obj);
        }
        this.tz = ruleBasedTimeZone;
        setID(str2);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0027  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    private static long parseDateTimeString(String str, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        long jFieldsToDay;
        int length;
        boolean z2 = false;
        if (str != null && (((length = str.length()) == 15 || length == 16) && str.charAt(8) == 'T')) {
            if (length != 16) {
                z = false;
            } else if (str.charAt(15) != 'Z') {
                i2 = 0;
                z = false;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
            } else {
                z = true;
            }
            try {
                i5 = Integer.parseInt(str.substring(0, 4));
                try {
                    i3 = Integer.parseInt(str.substring(4, 6)) - 1;
                    try {
                        i4 = Integer.parseInt(str.substring(6, 8));
                        try {
                            i6 = Integer.parseInt(str.substring(9, 11));
                            try {
                                i7 = Integer.parseInt(str.substring(11, 13));
                                try {
                                    i2 = Integer.parseInt(str.substring(13, 15));
                                    int iMonthLength = Grego.monthLength(i5, i3);
                                    if (i5 >= 0 && i3 >= 0 && i3 <= 11 && i4 >= 1 && i4 <= iMonthLength && i6 >= 0 && i6 < 24 && i7 >= 0 && i7 < 60 && i2 >= 0 && i2 < 60) {
                                        z2 = true;
                                    }
                                } catch (NumberFormatException unused) {
                                    i2 = 0;
                                }
                            } catch (NumberFormatException unused2) {
                                i7 = 0;
                            }
                        } catch (NumberFormatException unused3) {
                            i6 = 0;
                            i7 = i6;
                            i2 = 0;
                            if (!z2) {
                                og.i("Invalid date time string format");
                                return DEF_TZSTARTTIME;
                            }
                            jFieldsToDay = (Grego.fieldsToDay(i5, i3, i4) * CalendarAstronomer.DAY_MS) + ((long) ((i2 * 1000) + (i7 * 60000) + (i6 * 3600000)));
                            if (z) {
                                return jFieldsToDay;
                            }
                            return jFieldsToDay - ((long) i);
                        }
                    } catch (NumberFormatException unused4) {
                        i4 = 0;
                        i6 = i4;
                        i7 = i6;
                        i2 = 0;
                        if (!z2) {
                            og.i("Invalid date time string format");
                            return DEF_TZSTARTTIME;
                        }
                        jFieldsToDay = (Grego.fieldsToDay(i5, i3, i4) * CalendarAstronomer.DAY_MS) + ((long) ((i2 * 1000) + (i7 * 60000) + (i6 * 3600000)));
                        if (z) {
                            return jFieldsToDay - ((long) i);
                        }
                        return jFieldsToDay;
                    }
                } catch (NumberFormatException unused5) {
                    i3 = 0;
                    i4 = 0;
                }
            } catch (NumberFormatException unused6) {
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
            }
        } else {
            i2 = 0;
            z = false;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!z2) {
            og.i("Invalid date time string format");
            return DEF_TZSTARTTIME;
        }
        jFieldsToDay = (Grego.fieldsToDay(i5, i3, i4) * CalendarAstronomer.DAY_MS) + ((long) ((i2 * 1000) + (i7 * 60000) + (i6 * 3600000)));
        if (z) {
            return jFieldsToDay - ((long) i);
        }
        return jFieldsToDay;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0049 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0094  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b1 A[ADDED_TO_REGION] */
    private static int[] parseRRULE(String str, long[] jArr) {
        char c;
        int[] iArr;
        int[] iArr2;
        String[] strArr;
        int i;
        int i2;
        int i3;
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, SEMICOLON);
        int i4 = -1;
        long dateTimeString = MIN_TIME;
        int i5 = -1;
        int i6 = 0;
        int i7 = 0;
        boolean z = false;
        boolean z2 = false;
        int[] iArr3 = null;
        while (true) {
            if (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                iArr = null;
                int iIndexOf = strNextToken.indexOf(EQUALS_SIGN);
                if (iIndexOf != i4) {
                    String strSubstring = strNextToken.substring(0, iIndexOf);
                    String strSubstring2 = strNextToken.substring(iIndexOf + 1);
                    if (!strSubstring.equals(ICAL_FREQ)) {
                        if (strSubstring.equals(ICAL_UNTIL)) {
                            try {
                                dateTimeString = parseDateTimeString(strSubstring2, 0);
                            } catch (NumberFormatException | IllegalArgumentException unused) {
                            }
                        } else if (strSubstring.equals(ICAL_BYMONTH)) {
                            if (strSubstring2.length() <= 2 && (i5 = Integer.parseInt(strSubstring2) - 1) >= 0 && i5 < 12) {
                            }
                        } else if (strSubstring.equals(ICAL_BYDAY)) {
                            int length = strSubstring2.length();
                            if (length >= 2 && length <= 4) {
                                if (length > 2) {
                                    c = 2;
                                    if (strSubstring2.charAt(0) == '+') {
                                        i = 1;
                                        int i8 = length - 3;
                                        i2 = length - 2;
                                        i3 = Integer.parseInt(strSubstring2.substring(i8, i2));
                                        if (i3 == 0) {
                                        }
                                    } else if (strSubstring2.charAt(0) == '-') {
                                        i = -1;
                                        int i9 = length - 3;
                                        i2 = length - 2;
                                        try {
                                            i3 = Integer.parseInt(strSubstring2.substring(i9, i2));
                                            if (i3 == 0 && i3 <= 4) {
                                                i7 = i3 * i;
                                                strSubstring2 = strSubstring2.substring(i2);
                                            }
                                        } catch (NumberFormatException unused2) {
                                        }
                                    } else if (length != 4) {
                                        i = 1;
                                        int i10 = length - 3;
                                        i2 = length - 2;
                                        i3 = Integer.parseInt(strSubstring2.substring(i10, i2));
                                        if (i3 == 0) {
                                        }
                                    }
                                } else {
                                    c = 2;
                                }
                                int i11 = 0;
                                while (true) {
                                    strArr = ICAL_DOW_NAMES;
                                    if (i11 >= strArr.length || strSubstring2.equals(strArr[i11])) {
                                        break;
                                    }
                                    i11++;
                                }
                                if (i11 < strArr.length) {
                                    i6 = i11 + 1;
                                }
                            }
                        } else if (strSubstring.equals(ICAL_BYMONTHDAY)) {
                            java.util.StringTokenizer stringTokenizer2 = new java.util.StringTokenizer(strSubstring2, COMMA);
                            iArr3 = new int[stringTokenizer2.countTokens()];
                            int i12 = 0;
                            while (stringTokenizer2.hasMoreTokens()) {
                                int i13 = i12 + 1;
                                try {
                                    iArr3[i12] = Integer.parseInt(stringTokenizer2.nextToken());
                                    i12 = i13;
                                } catch (NumberFormatException unused3) {
                                    z2 = true;
                                }
                            }
                        }
                        i4 = -1;
                    } else if (strSubstring2.equals(ICAL_YEARLY)) {
                        z = true;
                        i4 = -1;
                    }
                    z2 = true;
                }
                c = 2;
                z2 = true;
            } else {
                c = 2;
                iArr = null;
            }
            if (z2 || !z) {
                return iArr;
            }
            jArr[0] = dateTimeString;
            if (iArr3 == null) {
                iArr2 = new int[4];
                iArr2[3] = 0;
            } else {
                iArr2 = new int[iArr3.length + 3];
                for (int i14 = 0; i14 < iArr3.length; i14++) {
                    iArr2[i14 + 3] = iArr3[i14];
                }
            }
            iArr2[0] = i5;
            iArr2[1] = i6;
            iArr2[c] = i7;
            return iArr2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0041  */
    /* JADX WARN: Code duplicated, block: B:22:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x004a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x005d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0061  */
    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    /* JADX WARN: Code duplicated, block: B:34:0x006e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0072  */
    /* JADX WARN: Code duplicated, block: B:39:0x0076  */
    /* JADX WARN: Code duplicated, block: B:41:0x0079  */
    /* JADX WARN: Code duplicated, block: B:42:0x007e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0080  */
    /* JADX WARN: Code duplicated, block: B:45:0x0085 A[PHI: r0 r1 r4 r5
      0x0085: PHI (r0v6 int) = (r0v5 int), (r0v11 int), (r0v11 int) binds: [B:19:0x003f, B:38:0x0074, B:42:0x007e] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r1v2 int) = (r1v1 int), (r1v6 int), (r1v6 int) binds: [B:19:0x003f, B:38:0x0074, B:42:0x007e] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r4v1 int) = (r4v0 int), (r4v0 int), (r4v3 int) binds: [B:19:0x003f, B:38:0x0074, B:42:0x007e] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r5v1 int) = (r5v0 int), (r5v5 int), (r5v5 int) binds: [B:19:0x003f, B:38:0x0074, B:42:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:47:0x008a  */
    /* JADX WARN: Code duplicated, block: B:49:0x0090  */
    /* JADX WARN: Code duplicated, block: B:51:0x0094  */
    /* JADX WARN: Code duplicated, block: B:52:0x0096  */
    private static DateTimeRule toWallTimeRule(DateTimeRule dateTimeRule, int i, int i2) {
        int i3;
        int i4;
        int ruleMonth;
        int ruleDayOfMonth;
        int ruleDayOfWeek;
        int dateRuleType;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        int ruleWeekInMonth;
        if (dateTimeRule.getTimeRuleType() == 0) {
            return dateTimeRule;
        }
        int ruleMillisInDay = dateTimeRule.getRuleMillisInDay();
        if (dateTimeRule.getTimeRuleType() == 2) {
            ruleMillisInDay += i + i2;
        } else if (dateTimeRule.getTimeRuleType() == 1) {
            ruleMillisInDay += i2;
        }
        if (ruleMillisInDay >= 0) {
            if (ruleMillisInDay >= 86400000) {
                i4 = ruleMillisInDay - Grego.MILLIS_PER_DAY;
                i3 = 1;
            } else {
                i3 = 0;
            }
            ruleMonth = dateTimeRule.getRuleMonth();
            ruleDayOfMonth = dateTimeRule.getRuleDayOfMonth();
            ruleDayOfWeek = dateTimeRule.getRuleDayOfWeek();
            dateRuleType = dateTimeRule.getDateRuleType();
            if (i3 == 0) {
                i5 = ruleDayOfMonth;
                i6 = ruleDayOfWeek;
                i7 = dateRuleType;
                i8 = ruleMonth;
            } else {
                if (dateRuleType == 1) {
                    ruleWeekInMonth = dateTimeRule.getRuleWeekInMonth();
                    if (ruleWeekInMonth > 0) {
                        ruleDayOfMonth = ((ruleWeekInMonth - 1) * 7) + 1;
                        dateRuleType = 2;
                    } else {
                        ruleDayOfMonth = MONTHLENGTH[ruleMonth] + ((ruleWeekInMonth + 1) * 7);
                        dateRuleType = 3;
                    }
                }
                ruleDayOfMonth += i3;
                if (ruleDayOfMonth == 0) {
                    ruleMonth--;
                    if (ruleMonth < 0) {
                        ruleMonth = 11;
                    }
                    ruleDayOfMonth = MONTHLENGTH[ruleMonth];
                } else if (ruleDayOfMonth > MONTHLENGTH[ruleMonth]) {
                    ruleMonth++;
                    if (ruleMonth > 11) {
                        ruleMonth = 0;
                    }
                    ruleDayOfMonth = 1;
                }
                if (dateRuleType == 0) {
                    i5 = ruleDayOfMonth;
                    i6 = ruleDayOfWeek;
                    i7 = dateRuleType;
                    i8 = ruleMonth;
                } else {
                    ruleDayOfWeek += i3;
                    if (ruleDayOfWeek < 1) {
                        i7 = dateRuleType;
                        i6 = 7;
                        i8 = ruleMonth;
                        i5 = ruleDayOfMonth;
                    } else {
                        if (ruleDayOfWeek > 7) {
                            i5 = ruleDayOfMonth;
                            i6 = 1;
                        } else {
                            i5 = ruleDayOfMonth;
                            i6 = ruleDayOfWeek;
                        }
                        i7 = dateRuleType;
                        i8 = ruleMonth;
                    }
                }
            }
            if (i7 == 0) {
                return new DateTimeRule(i8, i5, i4, 0);
            }
            if (i7 == 2) {
                z = true;
            } else {
                z = false;
            }
            return new DateTimeRule(i8, i5, i6, z, i4, 0);
        }
        ruleMillisInDay += Grego.MILLIS_PER_DAY;
        i3 = -1;
        i4 = ruleMillisInDay;
        ruleMonth = dateTimeRule.getRuleMonth();
        ruleDayOfMonth = dateTimeRule.getRuleDayOfMonth();
        ruleDayOfWeek = dateTimeRule.getRuleDayOfWeek();
        dateRuleType = dateTimeRule.getDateRuleType();
        if (i3 == 0) {
            i5 = ruleDayOfMonth;
            i6 = ruleDayOfWeek;
            i7 = dateRuleType;
            i8 = ruleMonth;
        } else {
            if (dateRuleType == 1) {
                ruleWeekInMonth = dateTimeRule.getRuleWeekInMonth();
                if (ruleWeekInMonth > 0) {
                    ruleDayOfMonth = ((ruleWeekInMonth - 1) * 7) + 1;
                    dateRuleType = 2;
                } else {
                    ruleDayOfMonth = MONTHLENGTH[ruleMonth] + ((ruleWeekInMonth + 1) * 7);
                    dateRuleType = 3;
                }
            }
            ruleDayOfMonth += i3;
            if (ruleDayOfMonth == 0) {
                ruleMonth--;
                if (ruleMonth < 0) {
                    ruleMonth = 11;
                }
                ruleDayOfMonth = MONTHLENGTH[ruleMonth];
            } else if (ruleDayOfMonth > MONTHLENGTH[ruleMonth]) {
                ruleMonth++;
                if (ruleMonth > 11) {
                    ruleMonth = 0;
                }
                ruleDayOfMonth = 1;
            }
            if (dateRuleType == 0) {
                i5 = ruleDayOfMonth;
                i6 = ruleDayOfWeek;
                i7 = dateRuleType;
                i8 = ruleMonth;
            } else {
                ruleDayOfWeek += i3;
                if (ruleDayOfWeek < 1) {
                    i7 = dateRuleType;
                    i6 = 7;
                    i8 = ruleMonth;
                    i5 = ruleDayOfMonth;
                } else {
                    if (ruleDayOfWeek > 7) {
                        i5 = ruleDayOfMonth;
                        i6 = 1;
                    } else {
                        i5 = ruleDayOfMonth;
                        i6 = ruleDayOfWeek;
                    }
                    i7 = dateRuleType;
                    i8 = ruleMonth;
                }
            }
        }
        if (i7 == 0) {
            return new DateTimeRule(i8, i5, i4, 0);
        }
        if (i7 == 2) {
            z = true;
        } else {
            z = false;
        }
        return new DateTimeRule(i8, i5, i6, z, i4, 0);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0038  */
    /* JADX WARN: Code duplicated, block: B:14:0x003b  */
    /* JADX WARN: Code duplicated, block: B:16:0x003e  */
    /* JADX WARN: Code duplicated, block: B:18:0x0041 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x0042  */
    /* JADX WARN: Code duplicated, block: B:21:0x0061  */
    /* JADX WARN: Code duplicated, block: B:23:0x0080  */
    /* JADX WARN: Code duplicated, block: B:25:0x009f  */
    private static void writeFinalRule(Writer writer, boolean z, AnnualTimeZoneRule annualTimeZoneRule, int i, int i2, long j) throws IOException {
        long j2;
        long j3;
        int dSTSavings;
        int dateRuleType;
        DateTimeRule wallTimeRule = toWallTimeRule(annualTimeZoneRule.getRule(), i, i2);
        int ruleMillisInDay = wallTimeRule.getRuleMillisInDay();
        if (ruleMillisInDay >= 0) {
            if (ruleMillisInDay >= 86400000) {
                j3 = j - ((long) (ruleMillisInDay - 86399999));
            } else {
                j2 = j;
            }
            dSTSavings = annualTimeZoneRule.getDSTSavings() + annualTimeZoneRule.getRawOffset();
            dateRuleType = wallTimeRule.getDateRuleType();
            if (dateRuleType != 0) {
                writeZonePropsByDOM(writer, z, annualTimeZoneRule.getName(), i + i2, dSTSavings, wallTimeRule.getRuleMonth(), wallTimeRule.getRuleDayOfMonth(), j2, MAX_TIME);
                return;
            }
            if (dateRuleType != 1) {
                writeZonePropsByDOW(writer, z, annualTimeZoneRule.getName(), i + i2, dSTSavings, wallTimeRule.getRuleMonth(), wallTimeRule.getRuleWeekInMonth(), wallTimeRule.getRuleDayOfWeek(), j2, MAX_TIME);
            } else if (dateRuleType != 2) {
                writeZonePropsByDOW_GEQ_DOM(writer, z, annualTimeZoneRule.getName(), i + i2, dSTSavings, wallTimeRule.getRuleMonth(), wallTimeRule.getRuleDayOfMonth(), wallTimeRule.getRuleDayOfWeek(), j2, MAX_TIME);
            } else {
                if (dateRuleType != 3) {
                    return;
                }
                writeZonePropsByDOW_LEQ_DOM(writer, z, annualTimeZoneRule.getName(), i + i2, dSTSavings, wallTimeRule.getRuleMonth(), wallTimeRule.getRuleDayOfMonth(), wallTimeRule.getRuleDayOfWeek(), j2, MAX_TIME);
            }
        }
        j3 = j + ((long) (0 - ruleMillisInDay));
        j2 = j3;
        dSTSavings = annualTimeZoneRule.getDSTSavings() + annualTimeZoneRule.getRawOffset();
        dateRuleType = wallTimeRule.getDateRuleType();
        if (dateRuleType != 0) {
            writeZonePropsByDOM(writer, z, annualTimeZoneRule.getName(), i + i2, dSTSavings, wallTimeRule.getRuleMonth(), wallTimeRule.getRuleDayOfMonth(), j2, MAX_TIME);
            return;
        }
        if (dateRuleType != 1) {
            writeZonePropsByDOW(writer, z, annualTimeZoneRule.getName(), i + i2, dSTSavings, wallTimeRule.getRuleMonth(), wallTimeRule.getRuleWeekInMonth(), wallTimeRule.getRuleDayOfWeek(), j2, MAX_TIME);
        } else if (dateRuleType != 2) {
            writeZonePropsByDOW_GEQ_DOM(writer, z, annualTimeZoneRule.getName(), i + i2, dSTSavings, wallTimeRule.getRuleMonth(), wallTimeRule.getRuleDayOfMonth(), wallTimeRule.getRuleDayOfWeek(), j2, MAX_TIME);
        } else {
            if (dateRuleType != 3) {
                return;
            }
            writeZonePropsByDOW_LEQ_DOM(writer, z, annualTimeZoneRule.getName(), i + i2, dSTSavings, wallTimeRule.getRuleMonth(), wallTimeRule.getRuleDayOfMonth(), wallTimeRule.getRuleDayOfWeek(), j2, MAX_TIME);
        }
    }

    private static void writeFooter(Writer writer) throws IOException {
        writer.write(ICAL_END);
        writer.write(COLON);
        writer.write(ICAL_VTIMEZONE);
        writer.write(NEWLINE);
    }

    private void writeHeader(Writer writer) throws IOException {
        writer.write(ICAL_BEGIN);
        writer.write(COLON);
        writer.write(ICAL_VTIMEZONE);
        writer.write(NEWLINE);
        writer.write(ICAL_TZID);
        writer.write(COLON);
        writer.write(this.tz.getID());
        writer.write(NEWLINE);
        if (this.tzurl != null) {
            writer.write(ICAL_TZURL);
            writer.write(COLON);
            writer.write(this.tzurl);
            writer.write(NEWLINE);
        }
        if (this.lastmod != null) {
            writer.write(ICAL_LASTMOD);
            writer.write(COLON);
            writer.write(getUTCDateTimeString(this.lastmod.getTime()));
            writer.write(NEWLINE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:95:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:97:0x0300  */
    /* JADX WARN: Code duplicated, block: B:98:0x031c  */
    /* JADX WARN: Code duplicated, block: B:99:0x033b  */
    private void writeZone(Writer writer, BasicTimeZone basicTimeZone, String[] strArr) throws IOException {
        AnnualTimeZoneRule annualTimeZoneRule;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        int i7;
        int i8;
        int i9;
        long j;
        long j2;
        String str;
        int i10;
        int i11;
        String str2;
        AnnualTimeZoneRule annualTimeZoneRule2;
        String str3;
        int i12;
        int i13;
        int i14;
        int i15;
        long j3;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z2;
        String str4;
        int i20;
        int i21;
        int i22;
        int i23;
        boolean z3;
        long j4;
        int i24;
        int i25;
        int i26;
        long j5;
        int i27;
        int i28;
        boolean z4;
        int i29;
        int i30;
        boolean z5;
        long j6;
        writeHeader(writer);
        boolean z6 = false;
        if (strArr != null && strArr.length > 0) {
            for (String str5 : strArr) {
                if (str5 != null) {
                    writer.write(str5);
                    writer.write(NEWLINE);
                }
            }
        }
        int[] iArr = new int[6];
        String str6 = null;
        AnnualTimeZoneRule annualTimeZoneRule3 = null;
        AnnualTimeZoneRule annualTimeZoneRule4 = null;
        long j7 = Long.MIN_VALUE;
        int i31 = 0;
        int i32 = 0;
        int i33 = 0;
        int i34 = 0;
        int i35 = 0;
        int i36 = 0;
        int i37 = 0;
        int i38 = 0;
        int i39 = 0;
        int i40 = 0;
        int i41 = 0;
        int i42 = 0;
        int i43 = 0;
        int i44 = 0;
        int i45 = 0;
        int i46 = 0;
        int i47 = 0;
        int i48 = 0;
        long j8 = DEF_TZSTARTTIME;
        long j9 = DEF_TZSTARTTIME;
        long j10 = DEF_TZSTARTTIME;
        long j11 = DEF_TZSTARTTIME;
        String str7 = null;
        int i49 = 0;
        while (true) {
            TimeZoneTransition nextTransition = basicTimeZone.getNextTransition(j7, z6);
            if (nextTransition == null) {
                str6 = str6;
                annualTimeZoneRule = annualTimeZoneRule3;
                i = i49;
                i2 = i31;
                i3 = i33;
                i4 = i34;
                i5 = i35;
                i6 = i37;
                z = z6;
                i7 = i39;
                i8 = i41;
                i9 = i43;
                j = j8;
                j2 = j9;
                break;
            }
            long time = nextTransition.getTime();
            String name = nextTransition.getTo().getName();
            boolean z7 = nextTransition.getTo().getDSTSavings() != 0 ? true : z6;
            z = z6;
            int dSTSavings = nextTransition.getFrom().getDSTSavings() + nextTransition.getFrom().getRawOffset();
            int dSTSavings2 = nextTransition.getFrom().getDSTSavings();
            int i50 = 1;
            int dSTSavings3 = nextTransition.getTo().getDSTSavings() + nextTransition.getTo().getRawOffset();
            i6 = i37;
            Grego.timeToFields(nextTransition.getTime() + ((long) dSTSavings), iArr);
            int dayOfWeekInMonth = Grego.getDayOfWeekInMonth(iArr[z ? 1 : 0], iArr[1], iArr[2]);
            int i51 = iArr[z ? 1 : 0];
            if (!z7) {
                i10 = i49;
                int i52 = dSTSavings3;
                int i53 = i31;
                int i54 = i33;
                int i55 = i34;
                int i56 = i35;
                i11 = i36;
                iArr = iArr;
                long j12 = j8;
                str2 = str7;
                int i57 = dayOfWeekInMonth;
                int i58 = i38;
                String str8 = str6;
                annualTimeZoneRule2 = (annualTimeZoneRule3 == null && (nextTransition.getTo() instanceof AnnualTimeZoneRule) && ((AnnualTimeZoneRule) nextTransition.getTo()).getEndYear() == Integer.MAX_VALUE) ? (AnnualTimeZoneRule) nextTransition.getTo() : annualTimeZoneRule3;
                if (i39 > 0) {
                    if (i51 == i40 + i39 && name.equals(str8)) {
                        i18 = dSTSavings;
                        i13 = i53;
                        if (i6 == i18) {
                            i52 = i52;
                            if (i13 == i52) {
                                i23 = i48;
                                if (i23 == iArr[1]) {
                                    i22 = i45;
                                    i57 = i57;
                                    if (i22 == iArr[3]) {
                                        i15 = i46;
                                        if (i15 == i57) {
                                            i16 = i47;
                                            if (i16 == iArr[5]) {
                                                i19 = i39 + 1;
                                                j10 = time;
                                                z3 = true;
                                            }
                                            if (z3) {
                                                i12 = i6;
                                                i17 = i23;
                                                i14 = i22;
                                                str3 = str8;
                                                j4 = j10;
                                                j3 = j11;
                                            } else if (i19 == 1) {
                                                i12 = i6;
                                                str3 = str8;
                                                long j13 = j11;
                                                writeZonePropsByTime(writer, false, str3, i12, i13, j13, true);
                                                i14 = i22;
                                                i15 = i15;
                                                j3 = j13;
                                                i17 = i23;
                                                j4 = j10;
                                            } else {
                                                i12 = i6;
                                                str3 = str8;
                                                int i59 = i15;
                                                i14 = i22;
                                                j3 = j11;
                                                i17 = i23;
                                                j4 = j10;
                                                writeZonePropsByDOW(writer, false, str3, i12, i13, i17, i59, i14, j3, j4);
                                                i15 = i59;
                                            }
                                            j10 = j4;
                                            z2 = z3;
                                        }
                                    }
                                    i16 = i47;
                                } else {
                                    i57 = i57;
                                    i22 = i45;
                                }
                                i15 = i46;
                                i16 = i47;
                            } else {
                                i57 = i57;
                                i22 = i45;
                                i15 = i46;
                                i16 = i47;
                                i23 = i48;
                            }
                        }
                        i19 = i39;
                        z3 = z ? 1 : 0;
                        if (z3) {
                            i12 = i6;
                            i17 = i23;
                            i14 = i22;
                            str3 = str8;
                            j4 = j10;
                            j3 = j11;
                        } else if (i19 == 1) {
                            i12 = i6;
                            str3 = str8;
                            long j14 = j11;
                            writeZonePropsByTime(writer, false, str3, i12, i13, j14, true);
                            i14 = i22;
                            i15 = i15;
                            j3 = j14;
                            i17 = i23;
                            j4 = j10;
                        } else {
                            i12 = i6;
                            str3 = str8;
                            int i510 = i15;
                            i14 = i22;
                            j3 = j11;
                            i17 = i23;
                            j4 = j10;
                            writeZonePropsByDOW(writer, false, str3, i12, i13, i17, i510, i14, j3, j4);
                            i15 = i510;
                        }
                        j10 = j4;
                        z2 = z3;
                    } else {
                        i18 = dSTSavings;
                        i13 = i53;
                    }
                    i57 = i57;
                    i22 = i45;
                    i15 = i46;
                    i16 = i47;
                    i23 = i48;
                    i52 = i52;
                    i19 = i39;
                    z3 = z ? 1 : 0;
                    if (z3) {
                        i12 = i6;
                        i17 = i23;
                        i14 = i22;
                        str3 = str8;
                        j4 = j10;
                        j3 = j11;
                    } else if (i19 == 1) {
                        i12 = i6;
                        str3 = str8;
                        long j15 = j11;
                        writeZonePropsByTime(writer, false, str3, i12, i13, j15, true);
                        i14 = i22;
                        i15 = i15;
                        j3 = j15;
                        i17 = i23;
                        j4 = j10;
                    } else {
                        i12 = i6;
                        str3 = str8;
                        int i511 = i15;
                        i14 = i22;
                        j3 = j11;
                        i17 = i23;
                        j4 = j10;
                        writeZonePropsByDOW(writer, false, str3, i12, i13, i17, i511, i14, j3, j4);
                        i15 = i511;
                    }
                    j10 = j4;
                    z2 = z3;
                } else {
                    str3 = str8;
                    i12 = i6;
                    i13 = i53;
                    i14 = i45;
                    i15 = i46;
                    j3 = j11;
                    i16 = i47;
                    i17 = i48;
                    i18 = dSTSavings;
                    i19 = i39;
                    z2 = z ? 1 : 0;
                }
                if (z2) {
                    i46 = i15;
                    str4 = str3;
                    i37 = i12;
                    i20 = i17;
                    i45 = i14;
                    j11 = j3;
                    i47 = i16;
                    i39 = i19;
                    i31 = i13;
                } else {
                    int i60 = iArr[1];
                    i45 = iArr[3];
                    i47 = iArr[5];
                    i37 = i18;
                    i40 = i51;
                    str4 = name;
                    i46 = i57;
                    j10 = time;
                    j11 = j10;
                    i44 = dSTSavings2;
                    i31 = i52;
                    i39 = 1;
                    i20 = i60;
                }
                if (annualTimeZoneRule2 != null && annualTimeZoneRule4 != null) {
                    i2 = i31;
                    str6 = str4;
                    i6 = i37;
                    i48 = i20;
                    i7 = i39;
                    i8 = i41;
                    i9 = i43;
                    i = i10;
                    j2 = j9;
                    annualTimeZoneRule = annualTimeZoneRule2;
                    str7 = str2;
                    i3 = i54;
                    i4 = i55;
                    i5 = i56;
                    i36 = i11;
                    j = j12;
                    i32 = 1;
                    break;
                }
                i21 = 1;
                i48 = i20;
                i38 = i58;
                i33 = i54;
                i34 = i55;
                i35 = i56;
                j8 = j12;
                str6 = str4;
                i32 = i21;
                j7 = time;
                annualTimeZoneRule3 = annualTimeZoneRule2;
                str7 = str2;
                z6 = z ? 1 : 0;
                iArr = iArr;
                i36 = i11;
                i49 = i10;
            } else {
                if (annualTimeZoneRule4 == null && (nextTransition.getTo() instanceof AnnualTimeZoneRule) && ((AnnualTimeZoneRule) nextTransition.getTo()).getEndYear() == Integer.MAX_VALUE) {
                    annualTimeZoneRule4 = (AnnualTimeZoneRule) nextTransition.getTo();
                }
                if (i41 > 0) {
                    if (i51 == i42 + i41 && name.equals(str7) && i49 == dSTSavings && i33 == dSTSavings3 && i34 == iArr[1] && i35 == iArr[3] && i36 == dayOfWeekInMonth && i38 == iArr[5]) {
                        i30 = i41 + 1;
                        j9 = time;
                        z5 = true;
                    } else {
                        i30 = i41;
                        z5 = z ? 1 : 0;
                    }
                    if (z5) {
                        i28 = i30;
                        i24 = i49;
                        i25 = dSTSavings3;
                        i2 = i31;
                        i26 = i33;
                        j5 = j8;
                        i27 = i38;
                    } else {
                        if (i30 == 1) {
                            i50 = 1;
                            int i61 = i49;
                            int i62 = i33;
                            int i63 = i31;
                            i28 = i30;
                            long j16 = j8;
                            i27 = i38;
                            writeZonePropsByTime(writer, true, str7, i61, i62, j16, true);
                            i24 = i61;
                            i26 = i62;
                            j5 = j16;
                            i25 = dSTSavings3;
                            i2 = i63;
                        } else {
                            i28 = i30;
                            i50 = 1;
                            iArr = iArr;
                            int i64 = i49;
                            int i65 = i31;
                            int i66 = i33;
                            int i67 = i38;
                            name = name;
                            long j17 = j8;
                            dayOfWeekInMonth = dayOfWeekInMonth;
                            i27 = i67;
                            int i68 = i35;
                            i25 = dSTSavings3;
                            i2 = i65;
                            i6 = i6;
                            str6 = str6;
                            int i69 = i34;
                            int i70 = i36;
                            j6 = j9;
                            writeZonePropsByDOW(writer, true, str7, i64, i66, i69, i70, i68, j17, j6);
                            str7 = str7;
                            i24 = i64;
                            i26 = i66;
                            i34 = i69;
                            i36 = i70;
                            i35 = i68;
                            j5 = j17;
                        }
                        j9 = j6;
                        z4 = z5;
                    }
                    j6 = j9;
                    j9 = j6;
                    z4 = z5;
                } else {
                    i24 = i49;
                    i25 = dSTSavings3;
                    i2 = i31;
                    i26 = i33;
                    i34 = i34;
                    i35 = i35;
                    i36 = i36;
                    iArr = iArr;
                    j5 = j8;
                    i6 = i6;
                    str7 = str7;
                    dayOfWeekInMonth = dayOfWeekInMonth;
                    i27 = i38;
                    str6 = str6;
                    name = name;
                    dSTSavings = dSTSavings;
                    i51 = i51;
                    i28 = i41;
                    z4 = z ? 1 : 0;
                }
                if (z4) {
                    i29 = i24;
                    i38 = i27;
                    i41 = i28;
                    str7 = str7;
                    i33 = i26;
                    i34 = i34;
                    i35 = i35;
                    i36 = i36;
                    j8 = j5;
                } else {
                    i34 = iArr[i50];
                    i35 = iArr[3];
                    i29 = dSTSavings;
                    i42 = i51;
                    str7 = name;
                    i36 = dayOfWeekInMonth;
                    j8 = time;
                    j9 = j8;
                    i43 = dSTSavings2;
                    i41 = i50;
                    i33 = i25;
                    i38 = iArr[5];
                }
                if (annualTimeZoneRule3 != null && annualTimeZoneRule4 != null) {
                    annualTimeZoneRule = annualTimeZoneRule3;
                    i = i29;
                    i3 = i33;
                    i4 = i34;
                    i5 = i35;
                    i7 = i39;
                    i8 = i41;
                    i9 = i43;
                    j = j8;
                    j2 = j9;
                    i32 = i50;
                    break;
                }
                annualTimeZoneRule2 = annualTimeZoneRule3;
                i10 = i29;
                str2 = str7;
                i11 = i36;
                str4 = str6;
                i37 = i6;
                i31 = i2;
                i21 = i50;
                str6 = str4;
                i32 = i21;
                j7 = time;
                annualTimeZoneRule3 = annualTimeZoneRule2;
                str7 = str2;
                z6 = z ? 1 : 0;
                iArr = iArr;
                i36 = i11;
                i49 = i10;
            }
        }
        if (i32 == 0) {
            int offset = basicTimeZone.getOffset(DEF_TZSTARTTIME);
            boolean z8 = offset != basicTimeZone.getRawOffset() ? true : z;
            writeZonePropsByTime(writer, z8, getDefaultTZName(basicTimeZone.getID(), z8), offset, offset, DEF_TZSTARTTIME - ((long) offset), false);
        } else {
            String str9 = str7;
            int i71 = i;
            if (i8 <= 0) {
                str = str6;
            } else if (annualTimeZoneRule4 != null) {
                int i72 = i36;
                str = str6;
                long j18 = j2;
                if (i8 == 1) {
                    writeFinalRule(writer, true, annualTimeZoneRule4, i71 - i9, i9, j);
                } else if (isEquivalentDateRule(i4, i72, i5, annualTimeZoneRule4.getRule())) {
                    writeZonePropsByDOW(writer, true, str9, i71, i3, i4, i72, i5, j, MAX_TIME);
                } else {
                    writeZonePropsByDOW(writer, true, str9, i71, i3, i4, i72, i5, j, j18);
                    int i73 = i71 - i9;
                    Date nextStart = annualTimeZoneRule4.getNextStart(j18, i73, i9, false);
                    int i74 = i9;
                    if (nextStart != null) {
                        writeFinalRule(writer, true, annualTimeZoneRule4, i73, i74, nextStart.getTime());
                    }
                }
            } else if (i8 == 1) {
                writeZonePropsByTime(writer, true, str9, i71, i3, j, true);
                str = str6;
            } else {
                str = str6;
                writeZonePropsByDOW(writer, true, str9, i71, i3, i4, i36, i5, j, j2);
            }
            if (i7 > 0) {
                if (annualTimeZoneRule != null) {
                    String str10 = str;
                    int i75 = i6;
                    int i76 = i2;
                    long j19 = j10;
                    int i77 = i45;
                    int i78 = i46;
                    long j20 = j11;
                    int i79 = i48;
                    if (i7 == 1) {
                        writeFinalRule(writer, false, annualTimeZoneRule, i75 - i44, i44, j20);
                    } else {
                        int i80 = i44;
                        if (isEquivalentDateRule(i79, i78, i77, annualTimeZoneRule.getRule())) {
                            writeZonePropsByDOW(writer, false, str10, i75, i76, i79, i78, i77, j20, MAX_TIME);
                        } else {
                            writeZonePropsByDOW(writer, false, str10, i75, i76, i79, i78, i77, j20, j19);
                            int i81 = i75 - i80;
                            Date nextStart2 = annualTimeZoneRule.getNextStart(j19, i81, i80, false);
                            if (nextStart2 != null) {
                                writeFinalRule(writer, false, annualTimeZoneRule, i81, i80, nextStart2.getTime());
                            }
                        }
                    }
                } else if (i7 == 1) {
                    writeZonePropsByTime(writer, false, str, i6, i2, j11, true);
                } else {
                    writeZonePropsByDOW(writer, false, str, i6, i2, i48, i46, i45, j11, j10);
                }
            }
        }
        writeFooter(writer);
    }

    private static void writeZonePropsByDOM(Writer writer, boolean z, String str, int i, int i2, int i3, int i4, long j, long j2) throws IOException {
        beginZoneProps(writer, z, str, i, i2, j);
        beginRRULE(writer, i3);
        writer.write(ICAL_BYMONTHDAY);
        writer.write(EQUALS_SIGN);
        writer.write(Integer.toString(i4));
        if (j2 != MAX_TIME) {
            appendUNTIL(writer, getUTCDateTimeString(j2));
        }
        writer.write(NEWLINE);
        endZoneProps(writer, z);
    }

    private static void writeZonePropsByDOW(Writer writer, boolean z, String str, int i, int i2, int i3, int i4, int i5, long j, long j2) throws IOException {
        beginZoneProps(writer, z, str, i, i2, j);
        beginRRULE(writer, i3);
        writer.write(ICAL_BYDAY);
        writer.write(EQUALS_SIGN);
        writer.write(Integer.toString(i4));
        writer.write(ICAL_DOW_NAMES[i5 - 1]);
        if (j2 != MAX_TIME) {
            appendUNTIL(writer, getUTCDateTimeString(j2));
        }
        writer.write(NEWLINE);
        endZoneProps(writer, z);
    }

    private static void writeZonePropsByDOW_GEQ_DOM(Writer writer, boolean z, String str, int i, int i2, int i3, int i4, int i5, long j, long j2) throws IOException {
        int i6;
        int i7;
        int i8 = 7;
        if (i4 % 7 == 1) {
            writeZonePropsByDOW(writer, z, str, i, i2, i3, (i4 + 6) / 7, i5, j, j2);
            return;
        }
        if (i3 != 1) {
            int i9 = MONTHLENGTH[i3];
            if ((i9 - i4) % 7 == 6) {
                writeZonePropsByDOW(writer, z, str, i, i2, i3, (((i9 - i4) + 1) / 7) * (-1), i5, j, j2);
                return;
            }
        }
        beginZoneProps(writer, z, str, i, i2, j);
        if (i4 <= 0) {
            int i10 = 1 - i4;
            int i11 = 7 - i10;
            int i12 = i3 - 1;
            writeZonePropsByDOW_GEQ_DOM_sub(writer, i12 < 0 ? 11 : i12, -i10, i5, i10, MAX_TIME, i);
            i6 = i11;
            i7 = 1;
        } else {
            int i13 = i4 + 6;
            int i14 = MONTHLENGTH[i3];
            if (i13 > i14) {
                int i15 = i13 - i14;
                i8 = 7 - i15;
                int i16 = i3 + 1;
                if (i16 > 11) {
                    i16 = 0;
                }
                writeZonePropsByDOW_GEQ_DOM_sub(writer, i16, 1, i5, i15, MAX_TIME, i);
            }
            i6 = i8;
            i7 = i4;
        }
        writeZonePropsByDOW_GEQ_DOM_sub(writer, i3, i7, i5, i6, j2, i);
        endZoneProps(writer, z);
    }

    private static void writeZonePropsByDOW_GEQ_DOM_sub(Writer writer, int i, int i2, int i3, int i4, long j, int i5) throws IOException {
        boolean z = i == 1;
        if (i2 < 0 && !z) {
            i2 = MONTHLENGTH[i] + i2 + 1;
        }
        beginRRULE(writer, i);
        writer.write(ICAL_BYDAY);
        writer.write(EQUALS_SIGN);
        writer.write(ICAL_DOW_NAMES[i3 - 1]);
        writer.write(SEMICOLON);
        writer.write(ICAL_BYMONTHDAY);
        writer.write(EQUALS_SIGN);
        writer.write(Integer.toString(i2));
        for (int i6 = 1; i6 < i4; i6++) {
            writer.write(COMMA);
            writer.write(Integer.toString(i2 + i6));
        }
        if (j != MAX_TIME) {
            appendUNTIL(writer, getDateTimeString(j + ((long) i5)));
        }
        writer.write(NEWLINE);
    }

    private static void writeZonePropsByDOW_LEQ_DOM(Writer writer, boolean z, String str, int i, int i2, int i3, int i4, int i5, long j, long j2) throws IOException {
        if (i4 % 7 == 0) {
            writeZonePropsByDOW(writer, z, str, i, i2, i3, i4 / 7, i5, j, j2);
            return;
        }
        if (i3 != 1) {
            int i6 = MONTHLENGTH[i3];
            if ((i6 - i4) % 7 == 0) {
                writeZonePropsByDOW(writer, z, str, i, i2, i3, (((i6 - i4) / 7) + 1) * (-1), i5, j, j2);
                return;
            }
        }
        if (i3 == 1 && i4 == 29) {
            writeZonePropsByDOW(writer, z, str, i, i2, 1, -1, i5, j, j2);
        } else {
            writeZonePropsByDOW_GEQ_DOM(writer, z, str, i, i2, i3, i4 - 6, i5, j, j2);
        }
    }

    private static void writeZonePropsByTime(Writer writer, boolean z, String str, int i, int i2, long j, boolean z2) throws IOException {
        beginZoneProps(writer, z, str, i, i2, j);
        if (z2) {
            writer.write(ICAL_RDATE);
            writer.write(COLON);
            writer.write(getDateTimeString(j + ((long) i)));
            writer.write(NEWLINE);
        }
        endZoneProps(writer, z);
    }

    @Override // com.ibm.icu.util.TimeZone
    /* JADX INFO: renamed from: clone */
    public VTimeZone mo3clone() {
        return isFrozen() ? this : cloneAsThawed();
    }

    @Override // com.ibm.icu.util.TimeZone, com.ibm.icu.util.Freezable
    public VTimeZone cloneAsThawed() {
        VTimeZone vTimeZone = (VTimeZone) super.cloneAsThawed();
        vTimeZone.tz = (BasicTimeZone) this.tz.cloneAsThawed();
        vTimeZone.isFrozen = false;
        return vTimeZone;
    }

    public Date getLastModified() {
        return this.lastmod;
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneTransition getNextTransition(long j, boolean z) {
        return this.tz.getNextTransition(j, z);
    }

    @Override // com.ibm.icu.util.TimeZone
    public int getOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.tz.getOffset(i, i2, i3, i4, i5, i6);
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public void getOffsetFromLocal(long j, BasicTimeZone.LocalOption localOption, BasicTimeZone.LocalOption localOption2, int[] iArr) {
        this.tz.getOffsetFromLocal(j, localOption, localOption2, iArr);
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneTransition getPreviousTransition(long j, boolean z) {
        return this.tz.getPreviousTransition(j, z);
    }

    @Override // com.ibm.icu.util.TimeZone
    public int getRawOffset() {
        return this.tz.getRawOffset();
    }

    public String getTZURL() {
        return this.tzurl;
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneRule[] getTimeZoneRules() {
        return this.tz.getTimeZoneRules();
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public boolean hasEquivalentTransitions(TimeZone timeZone, long j, long j2) {
        if (this == timeZone) {
            return true;
        }
        return this.tz.hasEquivalentTransitions(timeZone, j, j2);
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean hasSameRules(TimeZone timeZone) {
        if (this == timeZone) {
            return true;
        }
        boolean z = timeZone instanceof VTimeZone;
        BasicTimeZone basicTimeZone = this.tz;
        return z ? basicTimeZone.hasSameRules(((VTimeZone) timeZone).tz) : basicTimeZone.hasSameRules(timeZone);
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean inDaylightTime(Date date) {
        return this.tz.inDaylightTime(date);
    }

    @Override // com.ibm.icu.util.TimeZone, com.ibm.icu.util.Freezable
    public boolean isFrozen() {
        return this.isFrozen;
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean observesDaylightTime() {
        return this.tz.observesDaylightTime();
    }

    public void setLastModified(Date date) {
        if (isFrozen()) {
            dk0.r("Attempt to modify a frozen VTimeZone instance.");
        } else {
            this.lastmod = date;
        }
    }

    @Override // com.ibm.icu.util.TimeZone
    public void setRawOffset(int i) {
        if (isFrozen()) {
            dk0.r("Attempt to modify a frozen VTimeZone instance.");
        } else {
            this.tz.setRawOffset(i);
        }
    }

    public void setTZURL(String str) {
        if (isFrozen()) {
            dk0.r("Attempt to modify a frozen VTimeZone instance.");
        } else {
            this.tzurl = str;
        }
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean useDaylightTime() {
        return this.tz.useDaylightTime();
    }

    public void write(Writer writer) throws IOException {
        String str;
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        List<String> list = this.vtzlines;
        if (list == null) {
            String str2 = this.olsonzid;
            writeZone(writer, this.tz, (str2 == null || (str = ICU_TZVERSION) == null) ? null : new String[]{ky0.l("X-TZINFO:", str2, "[", str, "]")});
            return;
        }
        for (String str3 : list) {
            if (str3.startsWith("TZURL:")) {
                if (this.tzurl != null) {
                    bufferedWriter.write(ICAL_TZURL);
                    bufferedWriter.write(COLON);
                    bufferedWriter.write(this.tzurl);
                    bufferedWriter.write(NEWLINE);
                }
            } else if (!str3.startsWith("LAST-MODIFIED:")) {
                bufferedWriter.write(str3);
                bufferedWriter.write(NEWLINE);
            } else if (this.lastmod != null) {
                bufferedWriter.write(ICAL_LASTMOD);
                bufferedWriter.write(COLON);
                bufferedWriter.write(getUTCDateTimeString(this.lastmod.getTime()));
                bufferedWriter.write(NEWLINE);
            }
        }
        bufferedWriter.flush();
    }

    public void writeSimple(Writer writer, long j) throws IOException {
        String[] strArr;
        String str;
        TimeZoneRule[] simpleTimeZoneRulesNear = this.tz.getSimpleTimeZoneRulesNear(j);
        RuleBasedTimeZone ruleBasedTimeZone = new RuleBasedTimeZone(this.tz.getID(), (InitialTimeZoneRule) simpleTimeZoneRulesNear[0]);
        for (int i = 1; i < simpleTimeZoneRulesNear.length; i++) {
            ruleBasedTimeZone.addTransitionRule(simpleTimeZoneRulesNear[i]);
        }
        String str2 = this.olsonzid;
        if (str2 == null || (str = ICU_TZVERSION) == null) {
            strArr = null;
        } else {
            StringBuilder sbQ = cq.q("X-TZINFO:", str2, "[", str, "/Simple@");
            sbQ.append(j);
            sbQ.append("]");
            strArr = new String[]{sbQ.toString()};
        }
        writeZone(writer, ruleBasedTimeZone, strArr);
    }

    @Override // com.ibm.icu.util.TimeZone, com.ibm.icu.util.Freezable
    public TimeZone freeze() {
        this.isFrozen = true;
        return this;
    }

    @Override // com.ibm.icu.util.TimeZone
    public void getOffset(long j, boolean z, int[] iArr) {
        this.tz.getOffset(j, z, iArr);
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneRule[] getTimeZoneRules(long j) {
        return this.tz.getTimeZoneRules(j);
    }

    private VTimeZone(String str) {
        super(str);
        this.olsonzid = null;
        this.tzurl = null;
        this.lastmod = null;
        this.isFrozen = false;
    }

    public static VTimeZone create(Reader reader) {
        VTimeZone vTimeZone = new VTimeZone();
        if (vTimeZone.load(reader)) {
            return vTimeZone;
        }
        return null;
    }

    public void write(Writer writer, long j) throws IOException {
        String[] strArr;
        String str;
        TimeZoneRule[] timeZoneRules = this.tz.getTimeZoneRules(j);
        RuleBasedTimeZone ruleBasedTimeZone = new RuleBasedTimeZone(this.tz.getID(), (InitialTimeZoneRule) timeZoneRules[0]);
        for (int i = 1; i < timeZoneRules.length; i++) {
            ruleBasedTimeZone.addTransitionRule(timeZoneRules[i]);
        }
        String str2 = this.olsonzid;
        if (str2 == null || (str = ICU_TZVERSION) == null) {
            strArr = null;
        } else {
            StringBuilder sbQ = cq.q("X-TZINFO:", str2, "[", str, "/Partial@");
            sbQ.append(j);
            sbQ.append("]");
            strArr = new String[]{sbQ.toString()};
        }
        writeZone(writer, ruleBasedTimeZone, strArr);
    }
}
