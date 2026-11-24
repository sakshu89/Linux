package defpackage;

import android.util.Pair;
import com.ibm.icu.impl.locale.LanguageTag;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bk0 {
    public static final Pattern c = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
    public static final Pattern d = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    public static final Pattern e = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    public static final ArrayList f;
    public final ArrayList a;
    public final ByteOrder b;

    static {
        zj0 zj0Var = new zj0(0);
        zj0Var.b = 0;
        f = Collections.list(zj0Var);
    }

    public bk0() {
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        zj0 zj0Var = new zj0(1);
        zj0Var.b = 0;
        this.a = Collections.list(zj0Var);
        this.b = byteOrder;
    }

    public static Pair a(String str) {
        if (str.contains(",")) {
            String[] strArrSplit = str.split(",", -1);
            Pair pairA = a(strArrSplit[0]);
            if (((Integer) pairA.first).intValue() == 2) {
                return pairA;
            }
            for (int i = 1; i < strArrSplit.length; i++) {
                Pair pairA2 = a(strArrSplit[i]);
                int iIntValue = (((Integer) pairA2.first).equals(pairA.first) || ((Integer) pairA2.second).equals(pairA.first)) ? ((Integer) pairA.first).intValue() : -1;
                int iIntValue2 = (((Integer) pairA.second).intValue() == -1 || !(((Integer) pairA2.first).equals(pairA.second) || ((Integer) pairA2.second).equals(pairA.second))) ? -1 : ((Integer) pairA.second).intValue();
                if (iIntValue == -1 && iIntValue2 == -1) {
                    return new Pair(2, -1);
                }
                if (iIntValue == -1) {
                    pairA = new Pair(Integer.valueOf(iIntValue2), -1);
                } else if (iIntValue2 == -1) {
                    pairA = new Pair(Integer.valueOf(iIntValue), -1);
                }
            }
            return pairA;
        }
        if (!str.contains("/")) {
            try {
                try {
                    long j = Long.parseLong(str);
                    if (j < 0 || j > 65535) {
                        return j < 0 ? new Pair(9, -1) : new Pair(4, -1);
                    }
                    return new Pair(3, 4);
                } catch (NumberFormatException unused) {
                    return new Pair(2, -1);
                }
            } catch (NumberFormatException unused2) {
                Double.parseDouble(str);
                return new Pair(12, -1);
            }
        }
        String[] strArrSplit2 = str.split("/", -1);
        if (strArrSplit2.length == 2) {
            try {
                long j2 = (long) Double.parseDouble(strArrSplit2[0]);
                long j3 = (long) Double.parseDouble(strArrSplit2[1]);
                if (j2 >= 0 && j3 >= 0) {
                    if (j2 <= 2147483647L && j3 <= 2147483647L) {
                        return new Pair(10, 5);
                    }
                    return new Pair(5, -1);
                }
                return new Pair(10, -1);
            } catch (NumberFormatException unused3) {
            }
        }
        return new Pair(2, -1);
    }

    public final void b(String str, String str2, ArrayList arrayList) {
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (((Map) obj).containsKey(str)) {
                return;
            }
        }
        c(str, str2, arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0315  */
    /* JADX WARN: Code duplicated, block: B:103:0x0326 A[LOOP:9: B:101:0x0323->B:103:0x0326, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:105:0x033f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0350 A[LOOP:10: B:106:0x034d->B:108:0x0350, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:111:0x0372 A[LOOP:11: B:110:0x0370->B:111:0x0372, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:114:0x038c  */
    /* JADX WARN: Code duplicated, block: B:115:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:117:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:119:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:122:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:62:0x0176  */
    /* JADX WARN: Code duplicated, block: B:66:0x0183  */
    /* JADX WARN: Code duplicated, block: B:69:0x018e A[LOOP:1: B:67:0x018b->B:69:0x018e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:72:0x01b2 A[LOOP:2: B:71:0x01b0->B:72:0x01b2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:77:0x01e2 A[LOOP:3: B:75:0x01df->B:77:0x01e2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:80:0x0228 A[LOOP:4: B:79:0x0226->B:80:0x0228, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:82:0x0250  */
    /* JADX WARN: Code duplicated, block: B:85:0x0260 A[LOOP:5: B:83:0x025d->B:85:0x0260, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:88:0x0284 A[LOOP:6: B:87:0x0282->B:88:0x0284, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:90:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:93:0x02b1 A[LOOP:7: B:91:0x02ae->B:93:0x02b1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:96:0x02ef A[LOOP:8: B:95:0x02ed->B:96:0x02ef, LOOP_END] */
    public final void c(String str, String str2, List list) {
        String str3;
        int i;
        int i2;
        ByteOrder byteOrder;
        yj0 yj0Var;
        String[] strArrSplit;
        int length;
        int[] iArr;
        int i3;
        ByteBuffer byteBufferWrap;
        int i4;
        int i5;
        String[] strArrSplit2;
        long[] jArr;
        int i6;
        int i7;
        String[] strArrSplit3;
        int length2;
        gf1[] gf1VarArr;
        int i8;
        ByteBuffer byteBufferWrap2;
        int i9;
        String[] strArrSplit4;
        int length3;
        int[] iArr2;
        int i10;
        ByteBuffer byteBufferWrap3;
        int i11;
        int i12;
        String[] strArrSplit5;
        int length4;
        gf1[] gf1VarArr2;
        int i13;
        ByteBuffer byteBufferWrap4;
        int i14;
        String[] strArrSplit6;
        int length5;
        double[] dArr;
        int i15;
        ByteBuffer byteBufferWrap5;
        int i16;
        String str4 = str;
        String strReplaceAll = str2;
        if (("DateTime".equals(str4) || "DateTimeOriginal".equals(str4) || "DateTimeDigitized".equals(str4)) && strReplaceAll != null) {
            boolean zFind = d.matcher(strReplaceAll).find();
            boolean zFind2 = e.matcher(strReplaceAll).find();
            if (strReplaceAll.length() != 19 || (!zFind && !zFind2)) {
                xq4.d("ExifData", "Invalid value for " + str4 + " : " + strReplaceAll);
                return;
            }
            if (zFind2) {
                strReplaceAll = strReplaceAll.replaceAll(LanguageTag.SEP, ":");
            }
        }
        if ("ISOSpeedRatings".equals(str4)) {
            str4 = "PhotographicSensitivity";
        }
        String str5 = str4;
        int i17 = 3;
        int i18 = 1;
        if (strReplaceAll != null && ck0.e.contains(str5)) {
            if (str5.equals("GPSTimeStamp")) {
                Matcher matcher = c.matcher(strReplaceAll);
                if (!matcher.find()) {
                    xq4.d("ExifData", "Invalid value for " + str5 + " : " + strReplaceAll);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                String strGroup = matcher.group(1);
                strGroup.getClass();
                sb.append(Integer.parseInt(strGroup));
                sb.append("/1,");
                String strGroup2 = matcher.group(2);
                strGroup2.getClass();
                sb.append(Integer.parseInt(strGroup2));
                sb.append("/1,");
                String strGroup3 = matcher.group(3);
                strGroup3.getClass();
                sb.append(Integer.parseInt(strGroup3));
                sb.append("/1");
                strReplaceAll = sb.toString();
            } else {
                try {
                    strReplaceAll = ((long) (Double.parseDouble(strReplaceAll) * 10000.0d)) + "/10000";
                } catch (NumberFormatException e2) {
                    xq4.e("ExifData", cq.l("Invalid value for ", str5, " : ", strReplaceAll), e2);
                    return;
                }
            }
        }
        int i19 = 0;
        int i20 = 0;
        while (true) {
            lk0[] lk0VarArr = ck0.c;
            if (i20 >= 4) {
                return;
            }
            lk0 lk0Var = (lk0) ((HashMap) f.get(i20)).get(str5);
            if (lk0Var != null) {
                int i21 = lk0Var.d;
                int i22 = lk0Var.c;
                if (strReplaceAll != null) {
                    Pair pairA = a(strReplaceAll);
                    int i23 = -1;
                    if (i22 == ((Integer) pairA.first).intValue() || i22 == ((Integer) pairA.second).intValue()) {
                        i21 = i22;
                        byteOrder = this.b;
                        switch (i21) {
                            case 1:
                                str3 = str5;
                                int i24 = i18;
                                i2 = i17;
                                Map map = (Map) list.get(i20);
                                Charset charset = yj0.d;
                                i = i24;
                                if (strReplaceAll.length() == i) {
                                    i19 = 0;
                                    if (strReplaceAll.charAt(0) < '0' && strReplaceAll.charAt(0) <= '1') {
                                        byte[] bArr = new byte[i];
                                        bArr[0] = (byte) (strReplaceAll.charAt(0) - '0');
                                        yj0Var = new yj0(i, bArr, i);
                                    }
                                    map.put(str3, yj0Var);
                                } else {
                                    i19 = 0;
                                }
                                byte[] bytes = strReplaceAll.getBytes(yj0.d);
                                yj0Var = new yj0(i, bytes, bytes.length);
                                map.put(str3, yj0Var);
                                break;
                            case 2:
                            case 7:
                                str3 = str5;
                                i2 = i17;
                                Map map2 = (Map) list.get(i20);
                                Charset charset2 = yj0.d;
                                byte[] bytes2 = strReplaceAll.concat("\u0000").getBytes(yj0.d);
                                map2.put(str3, new yj0(2, bytes2, bytes2.length));
                                i = i18;
                                i19 = 0;
                                break;
                            case 3:
                                int i25 = i17;
                                str3 = str5;
                                strArrSplit = strReplaceAll.split(",", -1);
                                length = strArrSplit.length;
                                iArr = new int[length];
                                while (i3 < strArrSplit.length) {
                                    iArr[i3] = Integer.parseInt(strArrSplit[i3]);
                                }
                                Map map3 = (Map) list.get(i20);
                                byteBufferWrap = ByteBuffer.wrap(new byte[yj0.f[i25] * length]);
                                byteBufferWrap.order(byteOrder);
                                while (i4 < length) {
                                    byteBufferWrap.putShort((short) iArr[i4]);
                                }
                                i2 = i25;
                                map3.put(str3, new yj0(i2, byteBufferWrap.array(), length));
                                i = i18;
                                i19 = 0;
                                break;
                            case 4:
                                str3 = str5;
                                i5 = i18;
                                strArrSplit2 = strReplaceAll.split(",", -1);
                                jArr = new long[strArrSplit2.length];
                                while (i6 < strArrSplit2.length) {
                                    jArr[i6] = Long.parseLong(strArrSplit2[i6]);
                                }
                                ((Map) list.get(i20)).put(str3, yj0.b(jArr, byteOrder));
                                i = i5;
                                i2 = i17;
                                i19 = 0;
                                break;
                            case 5:
                                i5 = i18;
                                i7 = -1;
                                strArrSplit3 = strReplaceAll.split(",", -1);
                                length2 = strArrSplit3.length;
                                gf1VarArr = new gf1[length2];
                                i8 = i19;
                                while (i8 < strArrSplit3.length) {
                                    String[] strArrSplit7 = strArrSplit3[i8].split("/", i7);
                                    gf1VarArr[i8] = new gf1((long) Double.parseDouble(strArrSplit7[i19]), (long) Double.parseDouble(strArrSplit7[i5]));
                                    i8++;
                                    str5 = str5;
                                    i7 = -1;
                                    i19 = 0;
                                }
                                String str6 = str5;
                                Map map4 = (Map) list.get(i20);
                                byteBufferWrap2 = ByteBuffer.wrap(new byte[yj0.f[5] * length2]);
                                byteBufferWrap2.order(byteOrder);
                                while (i9 < length2) {
                                    gf1 gf1Var = gf1VarArr[i9];
                                    byteBufferWrap2.putInt((int) gf1Var.a);
                                    byteBufferWrap2.putInt((int) gf1Var.b);
                                }
                                yj0 yj0Var2 = new yj0(5, byteBufferWrap2.array(), length2);
                                str3 = str6;
                                map4.put(str3, yj0Var2);
                                i = i5;
                                i2 = i17;
                                i19 = 0;
                                break;
                            case 9:
                                int i26 = i17;
                                int i27 = i18;
                                strArrSplit4 = strReplaceAll.split(",", -1);
                                length3 = strArrSplit4.length;
                                iArr2 = new int[length3];
                                while (i10 < strArrSplit4.length) {
                                    iArr2[i10] = Integer.parseInt(strArrSplit4[i10]);
                                }
                                Map map5 = (Map) list.get(i20);
                                byteBufferWrap3 = ByteBuffer.wrap(new byte[yj0.f[9] * length3]);
                                byteBufferWrap3.order(byteOrder);
                                while (i11 < length3) {
                                    byteBufferWrap3.putInt(iArr2[i11]);
                                }
                                map5.put(str5, new yj0(9, byteBufferWrap3.array(), length3));
                                String str7 = str5;
                                i19 = i19;
                                str3 = str7;
                                i = i27;
                                i2 = i26;
                                break;
                            case 10:
                                i12 = i18;
                                strArrSplit5 = strReplaceAll.split(",", -1);
                                length4 = strArrSplit5.length;
                                gf1VarArr2 = new gf1[length4];
                                i13 = i19;
                                while (i13 < strArrSplit5.length) {
                                    String[] strArrSplit8 = strArrSplit5[i13].split("/", i23);
                                    int i28 = i13;
                                    gf1VarArr2[i28] = new gf1((long) Double.parseDouble(strArrSplit8[i19]), (long) Double.parseDouble(strArrSplit8[i12]));
                                    i13 = i28 + 1;
                                    i17 = i17;
                                    strReplaceAll = strReplaceAll;
                                    i23 = -1;
                                }
                                int i29 = i17;
                                String str8 = strReplaceAll;
                                Map map6 = (Map) list.get(i20);
                                byteBufferWrap4 = ByteBuffer.wrap(new byte[yj0.f[10] * length4]);
                                byteBufferWrap4.order(byteOrder);
                                while (i14 < length4) {
                                    gf1 gf1Var2 = gf1VarArr2[i14];
                                    byteBufferWrap4.putInt((int) gf1Var2.a);
                                    byteBufferWrap4.putInt((int) gf1Var2.b);
                                }
                                map6.put(str5, new yj0(10, byteBufferWrap4.array(), length4));
                                String str9 = str5;
                                i19 = i19;
                                str3 = str9;
                                i = i12;
                                i2 = i29;
                                strReplaceAll = str8;
                                break;
                            case 12:
                                strArrSplit6 = strReplaceAll.split(",", -1);
                                length5 = strArrSplit6.length;
                                dArr = new double[length5];
                                while (i15 < strArrSplit6.length) {
                                    dArr[i15] = Double.parseDouble(strArrSplit6[i15]);
                                }
                                Map map7 = (Map) list.get(i20);
                                byteBufferWrap5 = ByteBuffer.wrap(new byte[yj0.f[12] * length5]);
                                byteBufferWrap5.order(byteOrder);
                                i16 = i19;
                                while (i16 < length5) {
                                    byteBufferWrap5.putDouble(dArr[i16]);
                                    i16++;
                                    i18 = i18;
                                }
                                map7.put(str5, new yj0(12, byteBufferWrap5.array(), length5));
                                str3 = str5;
                                i = i18;
                                i2 = i17;
                                break;
                        }
                    } else if (i21 != -1 && (i21 == ((Integer) pairA.first).intValue() || i21 == ((Integer) pairA.second).intValue())) {
                        byteOrder = this.b;
                        switch (i21) {
                            case 1:
                                str3 = str5;
                                int i210 = i18;
                                i2 = i17;
                                Map map8 = (Map) list.get(i20);
                                Charset charset3 = yj0.d;
                                i = i210;
                                if (strReplaceAll.length() == i) {
                                    i19 = 0;
                                    if (strReplaceAll.charAt(0) < '0') {
                                    }
                                    map8.put(str3, yj0Var);
                                } else {
                                    i19 = 0;
                                }
                                byte[] bytes3 = strReplaceAll.getBytes(yj0.d);
                                yj0Var = new yj0(i, bytes3, bytes3.length);
                                map8.put(str3, yj0Var);
                                break;
                            case 2:
                            case 7:
                                str3 = str5;
                                i2 = i17;
                                Map map9 = (Map) list.get(i20);
                                Charset charset4 = yj0.d;
                                byte[] bytes4 = strReplaceAll.concat("\u0000").getBytes(yj0.d);
                                map9.put(str3, new yj0(2, bytes4, bytes4.length));
                                i = i18;
                                i19 = 0;
                                break;
                            case 3:
                                int i211 = i17;
                                str3 = str5;
                                strArrSplit = strReplaceAll.split(",", -1);
                                length = strArrSplit.length;
                                iArr = new int[length];
                                for (i3 = 0; i3 < strArrSplit.length; i3++) {
                                    iArr[i3] = Integer.parseInt(strArrSplit[i3]);
                                }
                                Map map10 = (Map) list.get(i20);
                                byteBufferWrap = ByteBuffer.wrap(new byte[yj0.f[i211] * length]);
                                byteBufferWrap.order(byteOrder);
                                for (i4 = 0; i4 < length; i4++) {
                                    byteBufferWrap.putShort((short) iArr[i4]);
                                }
                                i2 = i211;
                                map10.put(str3, new yj0(i2, byteBufferWrap.array(), length));
                                i = i18;
                                i19 = 0;
                                break;
                            case 4:
                                str3 = str5;
                                i5 = i18;
                                strArrSplit2 = strReplaceAll.split(",", -1);
                                jArr = new long[strArrSplit2.length];
                                for (i6 = 0; i6 < strArrSplit2.length; i6++) {
                                    jArr[i6] = Long.parseLong(strArrSplit2[i6]);
                                }
                                ((Map) list.get(i20)).put(str3, yj0.b(jArr, byteOrder));
                                i = i5;
                                i2 = i17;
                                i19 = 0;
                                break;
                            case 5:
                                i5 = i18;
                                i7 = -1;
                                strArrSplit3 = strReplaceAll.split(",", -1);
                                length2 = strArrSplit3.length;
                                gf1VarArr = new gf1[length2];
                                i8 = i19;
                                while (i8 < strArrSplit3.length) {
                                    String[] strArrSplit9 = strArrSplit3[i8].split("/", i7);
                                    gf1VarArr[i8] = new gf1((long) Double.parseDouble(strArrSplit9[i19]), (long) Double.parseDouble(strArrSplit9[i5]));
                                    i8++;
                                    str5 = str5;
                                    i7 = -1;
                                    i19 = 0;
                                }
                                String str10 = str5;
                                Map map11 = (Map) list.get(i20);
                                byteBufferWrap2 = ByteBuffer.wrap(new byte[yj0.f[5] * length2]);
                                byteBufferWrap2.order(byteOrder);
                                for (i9 = 0; i9 < length2; i9++) {
                                    gf1 gf1Var3 = gf1VarArr[i9];
                                    byteBufferWrap2.putInt((int) gf1Var3.a);
                                    byteBufferWrap2.putInt((int) gf1Var3.b);
                                }
                                yj0 yj0Var3 = new yj0(5, byteBufferWrap2.array(), length2);
                                str3 = str10;
                                map11.put(str3, yj0Var3);
                                i = i5;
                                i2 = i17;
                                i19 = 0;
                                break;
                            case 9:
                                int i212 = i17;
                                int i213 = i18;
                                strArrSplit4 = strReplaceAll.split(",", -1);
                                length3 = strArrSplit4.length;
                                iArr2 = new int[length3];
                                for (i10 = i19; i10 < strArrSplit4.length; i10++) {
                                    iArr2[i10] = Integer.parseInt(strArrSplit4[i10]);
                                }
                                Map map12 = (Map) list.get(i20);
                                byteBufferWrap3 = ByteBuffer.wrap(new byte[yj0.f[9] * length3]);
                                byteBufferWrap3.order(byteOrder);
                                for (i11 = i19; i11 < length3; i11++) {
                                    byteBufferWrap3.putInt(iArr2[i11]);
                                }
                                map12.put(str5, new yj0(9, byteBufferWrap3.array(), length3));
                                String str11 = str5;
                                i19 = i19;
                                str3 = str11;
                                i = i213;
                                i2 = i212;
                                break;
                            case 10:
                                i12 = i18;
                                strArrSplit5 = strReplaceAll.split(",", -1);
                                length4 = strArrSplit5.length;
                                gf1VarArr2 = new gf1[length4];
                                i13 = i19;
                                while (i13 < strArrSplit5.length) {
                                    String[] strArrSplit10 = strArrSplit5[i13].split("/", i23);
                                    int i214 = i13;
                                    gf1VarArr2[i214] = new gf1((long) Double.parseDouble(strArrSplit10[i19]), (long) Double.parseDouble(strArrSplit10[i12]));
                                    i13 = i214 + 1;
                                    i17 = i17;
                                    strReplaceAll = strReplaceAll;
                                    i23 = -1;
                                }
                                int i215 = i17;
                                String str12 = strReplaceAll;
                                Map map13 = (Map) list.get(i20);
                                byteBufferWrap4 = ByteBuffer.wrap(new byte[yj0.f[10] * length4]);
                                byteBufferWrap4.order(byteOrder);
                                for (i14 = i19; i14 < length4; i14++) {
                                    gf1 gf1Var4 = gf1VarArr2[i14];
                                    byteBufferWrap4.putInt((int) gf1Var4.a);
                                    byteBufferWrap4.putInt((int) gf1Var4.b);
                                }
                                map13.put(str5, new yj0(10, byteBufferWrap4.array(), length4));
                                String str13 = str5;
                                i19 = i19;
                                str3 = str13;
                                i = i12;
                                i2 = i215;
                                strReplaceAll = str12;
                                break;
                            case 12:
                                strArrSplit6 = strReplaceAll.split(",", -1);
                                length5 = strArrSplit6.length;
                                dArr = new double[length5];
                                for (i15 = i19; i15 < strArrSplit6.length; i15++) {
                                    dArr[i15] = Double.parseDouble(strArrSplit6[i15]);
                                }
                                Map map14 = (Map) list.get(i20);
                                byteBufferWrap5 = ByteBuffer.wrap(new byte[yj0.f[12] * length5]);
                                byteBufferWrap5.order(byteOrder);
                                i16 = i19;
                                while (i16 < length5) {
                                    byteBufferWrap5.putDouble(dArr[i16]);
                                    i16++;
                                    i18 = i18;
                                }
                                map14.put(str5, new yj0(12, byteBufferWrap5.array(), length5));
                                str3 = str5;
                                i = i18;
                                i2 = i17;
                                break;
                        }
                    } else {
                        if (i22 == i18 || i22 == 7 || i22 == 2) {
                            i21 = i22;
                            byteOrder = this.b;
                            switch (i21) {
                                case 1:
                                    str3 = str5;
                                    int i216 = i18;
                                    i2 = i17;
                                    Map map15 = (Map) list.get(i20);
                                    Charset charset5 = yj0.d;
                                    i = i216;
                                    if (strReplaceAll.length() == i) {
                                        i19 = 0;
                                        if (strReplaceAll.charAt(0) < '0') {
                                        }
                                        map15.put(str3, yj0Var);
                                    } else {
                                        i19 = 0;
                                    }
                                    byte[] bytes5 = strReplaceAll.getBytes(yj0.d);
                                    yj0Var = new yj0(i, bytes5, bytes5.length);
                                    map15.put(str3, yj0Var);
                                    break;
                                case 2:
                                case 7:
                                    str3 = str5;
                                    i2 = i17;
                                    Map map16 = (Map) list.get(i20);
                                    Charset charset6 = yj0.d;
                                    byte[] bytes6 = strReplaceAll.concat("\u0000").getBytes(yj0.d);
                                    map16.put(str3, new yj0(2, bytes6, bytes6.length));
                                    i = i18;
                                    i19 = 0;
                                    break;
                                case 3:
                                    int i217 = i17;
                                    str3 = str5;
                                    strArrSplit = strReplaceAll.split(",", -1);
                                    length = strArrSplit.length;
                                    iArr = new int[length];
                                    while (i3 < strArrSplit.length) {
                                        iArr[i3] = Integer.parseInt(strArrSplit[i3]);
                                    }
                                    Map map17 = (Map) list.get(i20);
                                    byteBufferWrap = ByteBuffer.wrap(new byte[yj0.f[i217] * length]);
                                    byteBufferWrap.order(byteOrder);
                                    while (i4 < length) {
                                        byteBufferWrap.putShort((short) iArr[i4]);
                                    }
                                    i2 = i217;
                                    map17.put(str3, new yj0(i2, byteBufferWrap.array(), length));
                                    i = i18;
                                    i19 = 0;
                                    break;
                                case 4:
                                    str3 = str5;
                                    i5 = i18;
                                    strArrSplit2 = strReplaceAll.split(",", -1);
                                    jArr = new long[strArrSplit2.length];
                                    while (i6 < strArrSplit2.length) {
                                        jArr[i6] = Long.parseLong(strArrSplit2[i6]);
                                    }
                                    ((Map) list.get(i20)).put(str3, yj0.b(jArr, byteOrder));
                                    i = i5;
                                    i2 = i17;
                                    i19 = 0;
                                    break;
                                case 5:
                                    i5 = i18;
                                    i7 = -1;
                                    strArrSplit3 = strReplaceAll.split(",", -1);
                                    length2 = strArrSplit3.length;
                                    gf1VarArr = new gf1[length2];
                                    i8 = i19;
                                    while (i8 < strArrSplit3.length) {
                                        String[] strArrSplit11 = strArrSplit3[i8].split("/", i7);
                                        gf1VarArr[i8] = new gf1((long) Double.parseDouble(strArrSplit11[i19]), (long) Double.parseDouble(strArrSplit11[i5]));
                                        i8++;
                                        str5 = str5;
                                        i7 = -1;
                                        i19 = 0;
                                    }
                                    String str14 = str5;
                                    Map map18 = (Map) list.get(i20);
                                    byteBufferWrap2 = ByteBuffer.wrap(new byte[yj0.f[5] * length2]);
                                    byteBufferWrap2.order(byteOrder);
                                    while (i9 < length2) {
                                        gf1 gf1Var5 = gf1VarArr[i9];
                                        byteBufferWrap2.putInt((int) gf1Var5.a);
                                        byteBufferWrap2.putInt((int) gf1Var5.b);
                                    }
                                    yj0 yj0Var4 = new yj0(5, byteBufferWrap2.array(), length2);
                                    str3 = str14;
                                    map18.put(str3, yj0Var4);
                                    i = i5;
                                    i2 = i17;
                                    i19 = 0;
                                    break;
                                case 9:
                                    int i218 = i17;
                                    int i219 = i18;
                                    strArrSplit4 = strReplaceAll.split(",", -1);
                                    length3 = strArrSplit4.length;
                                    iArr2 = new int[length3];
                                    while (i10 < strArrSplit4.length) {
                                        iArr2[i10] = Integer.parseInt(strArrSplit4[i10]);
                                    }
                                    Map map19 = (Map) list.get(i20);
                                    byteBufferWrap3 = ByteBuffer.wrap(new byte[yj0.f[9] * length3]);
                                    byteBufferWrap3.order(byteOrder);
                                    while (i11 < length3) {
                                        byteBufferWrap3.putInt(iArr2[i11]);
                                    }
                                    map19.put(str5, new yj0(9, byteBufferWrap3.array(), length3));
                                    String str15 = str5;
                                    i19 = i19;
                                    str3 = str15;
                                    i = i219;
                                    i2 = i218;
                                    break;
                                case 10:
                                    i12 = i18;
                                    strArrSplit5 = strReplaceAll.split(",", -1);
                                    length4 = strArrSplit5.length;
                                    gf1VarArr2 = new gf1[length4];
                                    i13 = i19;
                                    while (i13 < strArrSplit5.length) {
                                        String[] strArrSplit12 = strArrSplit5[i13].split("/", i23);
                                        int i2110 = i13;
                                        gf1VarArr2[i2110] = new gf1((long) Double.parseDouble(strArrSplit12[i19]), (long) Double.parseDouble(strArrSplit12[i12]));
                                        i13 = i2110 + 1;
                                        i17 = i17;
                                        strReplaceAll = strReplaceAll;
                                        i23 = -1;
                                    }
                                    int i2111 = i17;
                                    String str16 = strReplaceAll;
                                    Map map110 = (Map) list.get(i20);
                                    byteBufferWrap4 = ByteBuffer.wrap(new byte[yj0.f[10] * length4]);
                                    byteBufferWrap4.order(byteOrder);
                                    while (i14 < length4) {
                                        gf1 gf1Var6 = gf1VarArr2[i14];
                                        byteBufferWrap4.putInt((int) gf1Var6.a);
                                        byteBufferWrap4.putInt((int) gf1Var6.b);
                                    }
                                    map110.put(str5, new yj0(10, byteBufferWrap4.array(), length4));
                                    String str17 = str5;
                                    i19 = i19;
                                    str3 = str17;
                                    i = i12;
                                    i2 = i2111;
                                    strReplaceAll = str16;
                                    break;
                                case 12:
                                    strArrSplit6 = strReplaceAll.split(",", -1);
                                    length5 = strArrSplit6.length;
                                    dArr = new double[length5];
                                    while (i15 < strArrSplit6.length) {
                                        dArr[i15] = Double.parseDouble(strArrSplit6[i15]);
                                    }
                                    Map map111 = (Map) list.get(i20);
                                    byteBufferWrap5 = ByteBuffer.wrap(new byte[yj0.f[12] * length5]);
                                    byteBufferWrap5.order(byteOrder);
                                    i16 = i19;
                                    while (i16 < length5) {
                                        byteBufferWrap5.putDouble(dArr[i16]);
                                        i16++;
                                        i18 = i18;
                                    }
                                    map111.put(str5, new yj0(12, byteBufferWrap5.array(), length5));
                                    str3 = str5;
                                    i = i18;
                                    break;
                            }
                        }
                        i2 = i17;
                    }
                } else {
                    ((Map) list.get(i20)).remove(str5);
                }
                str3 = str5;
                i = i18;
                i2 = i17;
            } else {
                str3 = str5;
                i = i18;
                i2 = i17;
            }
            i20++;
            int i30 = i19;
            str5 = str3;
            i19 = i30;
            i17 = i2;
            i18 = i;
        }
    }

    public final void d(int i) {
        int i2;
        if (i == 0) {
            i2 = 1;
        } else if (i == 90) {
            i2 = 6;
        } else if (i == 180) {
            i2 = 3;
        } else if (i != 270) {
            xq4.d("ExifData", "Unexpected orientation value: " + i + ". Must be one of 0, 90, 180, 270.");
            i2 = 0;
        } else {
            i2 = 8;
        }
        c("Orientation", String.valueOf(i2), this.a);
    }
}
