package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class s34 {
    public static final byte[] a = {112, 114, 111, 0};
    public static final byte[] b = {112, 114, 109, 0};
    public static final /* synthetic */ int c = 0;

    public static byte[] a(xc0[] xc0VarArr, byte[] bArr) throws IOException {
        int i = 0;
        int length = 0;
        for (xc0 xc0Var : xc0VarArr) {
            length += ((((xc0Var.g * 2) + 7) & (-8)) / 8) + (xc0Var.e * 2) + b(xc0Var.a, xc0Var.b, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + xc0Var.f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        if (Arrays.equals(bArr, u34.c)) {
            int length2 = xc0VarArr.length;
            while (i < length2) {
                xc0 xc0Var2 = xc0VarArr[i];
                k(byteArrayOutputStream, xc0Var2, b(xc0Var2.a, xc0Var2.b, bArr));
                j(byteArrayOutputStream, xc0Var2);
                i++;
            }
        } else {
            for (xc0 xc0Var3 : xc0VarArr) {
                k(byteArrayOutputStream, xc0Var3, b(xc0Var3.a, xc0Var3.b, bArr));
            }
            int length3 = xc0VarArr.length;
            while (i < length3) {
                j(byteArrayOutputStream, xc0VarArr[i]);
                i++;
            }
        }
        if (byteArrayOutputStream.size() == length) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + length);
    }

    public static String b(String str, String str2, byte[] bArr) {
        byte[] bArr2 = u34.e;
        boolean zEquals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = u34.d;
        Object obj = (zEquals || Arrays.equals(bArr, bArr3)) ? ":" : "!";
        if (str.length() <= 0) {
            if ("!".equals(obj)) {
                return str2.replace(":", "!");
            }
            if (":".equals(obj)) {
                return str2.replace("!", ":");
            }
        } else {
            if (str2.equals("classes.dex")) {
                return str;
            }
            if (str2.contains("!") || str2.contains(":")) {
                if ("!".equals(obj)) {
                    return str2.replace(":", "!");
                }
                if (":".equals(obj)) {
                    return str2.replace("!", ":");
                }
            } else if (!str2.endsWith(".apk")) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                return cq.n(sb, (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) ? ":" : "!", str2);
            }
        }
        return str2;
    }

    public static int[] c(ByteArrayInputStream byteArrayInputStream, int i) {
        int[] iArr = new int[i];
        int iD = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iD += (int) en4.d(byteArrayInputStream, 2);
            iArr[i2] = iD;
        }
        return iArr;
    }

    public static xc0[] d(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, xc0[] xc0VarArr) throws IOException {
        byte[] bArr3 = u34.f;
        if (!Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(bArr, u34.g)) {
                og.n("Unsupported meta version");
                return null;
            }
            int iD = (int) en4.d(fileInputStream, 2);
            byte[] bArrC = en4.c(fileInputStream, (int) en4.d(fileInputStream, 4), (int) en4.d(fileInputStream, 4));
            if (fileInputStream.read() > 0) {
                og.n("Content found after the end of file");
                return null;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrC);
            try {
                xc0[] xc0VarArrF = f(byteArrayInputStream, bArr2, iD, xc0VarArr);
                byteArrayInputStream.close();
                return xc0VarArrF;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (Arrays.equals(u34.a, bArr2)) {
            og.n("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            return null;
        }
        if (!Arrays.equals(bArr, bArr3)) {
            og.n("Unsupported meta version");
            return null;
        }
        int iD2 = (int) en4.d(fileInputStream, 1);
        byte[] bArrC2 = en4.c(fileInputStream, (int) en4.d(fileInputStream, 4), (int) en4.d(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            og.n("Content found after the end of file");
            return null;
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArrC2);
        try {
            xc0[] xc0VarArrE = e(byteArrayInputStream2, iD2, xc0VarArr);
            byteArrayInputStream2.close();
            return xc0VarArrE;
        } catch (Throwable th3) {
            try {
                byteArrayInputStream2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static xc0[] e(ByteArrayInputStream byteArrayInputStream, int i, xc0[] xc0VarArr) {
        if (byteArrayInputStream.available() == 0) {
            return new xc0[0];
        }
        if (i != xc0VarArr.length) {
            og.n("Mismatched number of dex files found in metadata");
            return null;
        }
        String[] strArr = new String[i];
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            int iD = (int) en4.d(byteArrayInputStream, 2);
            iArr[i2] = (int) en4.d(byteArrayInputStream, 2);
            strArr[i2] = new String(en4.b(byteArrayInputStream, iD), StandardCharsets.UTF_8);
        }
        for (int i3 = 0; i3 < i; i3++) {
            xc0 xc0Var = xc0VarArr[i3];
            if (!xc0Var.b.equals(strArr[i3])) {
                og.n("Order of dexfiles in metadata did not match baseline");
                return null;
            }
            int i4 = iArr[i3];
            xc0Var.e = i4;
            xc0Var.h = c(byteArrayInputStream, i4);
        }
        return xc0VarArr;
    }

    public static xc0[] f(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i, xc0[] xc0VarArr) throws IOException {
        xc0 xc0Var;
        if (byteArrayInputStream.available() == 0) {
            return new xc0[0];
        }
        if (i != xc0VarArr.length) {
            og.n("Mismatched number of dex files found in metadata");
            return null;
        }
        for (int i2 = 0; i2 < i; i2++) {
            en4.d(byteArrayInputStream, 2);
            String str = new String(en4.b(byteArrayInputStream, (int) en4.d(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
            long jD = en4.d(byteArrayInputStream, 4);
            int iD = (int) en4.d(byteArrayInputStream, 2);
            if (xc0VarArr.length <= 0) {
                xc0Var = null;
                break;
            }
            int iIndexOf = str.indexOf("!");
            if (iIndexOf < 0) {
                iIndexOf = str.indexOf(":");
            }
            String strSubstring = iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
            int i3 = 0;
            while (true) {
                if (i3 >= xc0VarArr.length) {
                    xc0Var = null;
                    break;
                }
                if (xc0VarArr[i3].b.equals(strSubstring)) {
                    xc0Var = xc0VarArr[i3];
                    break;
                }
                i3++;
            }
            if (xc0Var == null) {
                og.n("Missing profile key: ".concat(str));
                return null;
            }
            xc0Var.d = jD;
            int[] iArrC = c(byteArrayInputStream, iD);
            if (Arrays.equals(bArr, u34.e)) {
                xc0Var.e = iD;
                xc0Var.h = iArrC;
            }
        }
        return xc0VarArr;
    }

    public static xc0[] g(FileInputStream fileInputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, u34.b)) {
            og.n("Unsupported version");
            return null;
        }
        int iD = (int) en4.d(fileInputStream, 1);
        byte[] bArrC = en4.c(fileInputStream, (int) en4.d(fileInputStream, 4), (int) en4.d(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            og.n("Content found after the end of file");
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrC);
        try {
            xc0[] xc0VarArrH = h(byteArrayInputStream, str, iD);
            byteArrayInputStream.close();
            return xc0VarArrH;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static xc0[] h(ByteArrayInputStream byteArrayInputStream, String str, int i) throws IOException {
        int i2 = 0;
        if (byteArrayInputStream.available() == 0) {
            return new xc0[0];
        }
        xc0[] xc0VarArr = new xc0[i];
        for (int i3 = 0; i3 < i; i3++) {
            int iD = (int) en4.d(byteArrayInputStream, 2);
            int iD2 = (int) en4.d(byteArrayInputStream, 2);
            xc0VarArr[i3] = new xc0(str, new String(en4.b(byteArrayInputStream, iD), StandardCharsets.UTF_8), en4.d(byteArrayInputStream, 4), iD2, (int) en4.d(byteArrayInputStream, 4), (int) en4.d(byteArrayInputStream, 4), new int[iD2], new TreeMap());
        }
        int i4 = 0;
        while (i4 < i) {
            xc0 xc0Var = xc0VarArr[i4];
            int iAvailable = byteArrayInputStream.available();
            int i5 = xc0Var.f;
            int i6 = xc0Var.g;
            TreeMap treeMap = xc0Var.i;
            int i7 = iAvailable - i5;
            int iD3 = i2;
            while (byteArrayInputStream.available() > i7) {
                iD3 += (int) en4.d(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(iD3), 1);
                int iD4 = (int) en4.d(byteArrayInputStream, 2);
                while (iD4 > 0) {
                    en4.d(byteArrayInputStream, 2);
                    int iD5 = (int) en4.d(byteArrayInputStream, 1);
                    if (iD5 != 6 && iD5 != 7) {
                        while (iD5 > 0) {
                            en4.d(byteArrayInputStream, 1);
                            int i8 = i2;
                            int i9 = i4;
                            for (int iD6 = (int) en4.d(byteArrayInputStream, 1); iD6 > 0; iD6--) {
                                en4.d(byteArrayInputStream, 2);
                            }
                            iD5--;
                            i2 = i8;
                            i4 = i9;
                        }
                    }
                    iD4--;
                    i2 = i2;
                    i4 = i4;
                }
            }
            int i10 = i2;
            int i11 = i4;
            if (byteArrayInputStream.available() != i7) {
                og.n("Read too much data during profile line parse");
                return null;
            }
            xc0Var.h = c(byteArrayInputStream, xc0Var.e);
            BitSet bitSetValueOf = BitSet.valueOf(en4.b(byteArrayInputStream, (((i6 * 2) + 7) & (-8)) / 8));
            for (int i12 = i10; i12 < i6; i12++) {
                int i13 = bitSetValueOf.get(i12) ? 2 : i10;
                if (bitSetValueOf.get(i12 + i6)) {
                    i13 |= 4;
                }
                if (i13 != 0) {
                    Integer numValueOf = (Integer) treeMap.get(Integer.valueOf(i12));
                    if (numValueOf == null) {
                        numValueOf = Integer.valueOf(i10);
                    }
                    treeMap.put(Integer.valueOf(i12), Integer.valueOf(i13 | numValueOf.intValue()));
                }
            }
            i4 = i11 + 1;
            i2 = i10;
        }
        return xc0VarArr;
    }

    public static boolean i(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, xc0[] xc0VarArr) throws IOException {
        long j;
        ArrayList arrayList;
        int length;
        byte[] bArr2 = u34.a;
        int i = 0;
        if (!Arrays.equals(bArr, bArr2)) {
            byte[] bArr3 = u34.b;
            if (Arrays.equals(bArr, bArr3)) {
                byte[] bArrA = a(xc0VarArr, bArr3);
                en4.e(byteArrayOutputStream, xc0VarArr.length, 1);
                en4.e(byteArrayOutputStream, bArrA.length, 4);
                byte[] bArrA2 = en4.a(bArrA);
                en4.e(byteArrayOutputStream, bArrA2.length, 4);
                byteArrayOutputStream.write(bArrA2);
                return true;
            }
            byte[] bArr4 = u34.d;
            if (Arrays.equals(bArr, bArr4)) {
                en4.e(byteArrayOutputStream, xc0VarArr.length, 1);
                for (xc0 xc0Var : xc0VarArr) {
                    int size = xc0Var.i.size() * 4;
                    String strB = b(xc0Var.a, xc0Var.b, bArr4);
                    Charset charset = StandardCharsets.UTF_8;
                    en4.f(byteArrayOutputStream, strB.getBytes(charset).length);
                    en4.f(byteArrayOutputStream, xc0Var.h.length);
                    en4.e(byteArrayOutputStream, size, 4);
                    en4.e(byteArrayOutputStream, xc0Var.c, 4);
                    byteArrayOutputStream.write(strB.getBytes(charset));
                    Iterator it = xc0Var.i.keySet().iterator();
                    while (it.hasNext()) {
                        en4.f(byteArrayOutputStream, ((Integer) it.next()).intValue());
                        en4.f(byteArrayOutputStream, 0);
                    }
                    for (int i2 : xc0Var.h) {
                        en4.f(byteArrayOutputStream, i2);
                    }
                }
                return true;
            }
            byte[] bArr5 = u34.c;
            if (Arrays.equals(bArr, bArr5)) {
                byte[] bArrA3 = a(xc0VarArr, bArr5);
                en4.e(byteArrayOutputStream, xc0VarArr.length, 1);
                en4.e(byteArrayOutputStream, bArrA3.length, 4);
                byte[] bArrA4 = en4.a(bArrA3);
                en4.e(byteArrayOutputStream, bArrA4.length, 4);
                byteArrayOutputStream.write(bArrA4);
                return true;
            }
            byte[] bArr6 = u34.e;
            if (!Arrays.equals(bArr, bArr6)) {
                return false;
            }
            en4.f(byteArrayOutputStream, xc0VarArr.length);
            for (xc0 xc0Var2 : xc0VarArr) {
                String str = xc0Var2.a;
                TreeMap treeMap = xc0Var2.i;
                String strB2 = b(str, xc0Var2.b, bArr6);
                Charset charset2 = StandardCharsets.UTF_8;
                en4.f(byteArrayOutputStream, strB2.getBytes(charset2).length);
                en4.f(byteArrayOutputStream, treeMap.size());
                en4.f(byteArrayOutputStream, xc0Var2.h.length);
                en4.e(byteArrayOutputStream, xc0Var2.c, 4);
                byteArrayOutputStream.write(strB2.getBytes(charset2));
                Iterator it2 = treeMap.keySet().iterator();
                while (it2.hasNext()) {
                    en4.f(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                }
                for (int i3 : xc0Var2.h) {
                    en4.f(byteArrayOutputStream, i3);
                }
            }
            return true;
        }
        ArrayList arrayList2 = new ArrayList(3);
        ArrayList arrayList3 = new ArrayList(3);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            en4.f(byteArrayOutputStream2, xc0VarArr.length);
            int i4 = 2;
            int i5 = 2;
            for (xc0 xc0Var3 : xc0VarArr) {
                en4.e(byteArrayOutputStream2, xc0Var3.c, 4);
                en4.e(byteArrayOutputStream2, xc0Var3.d, 4);
                en4.e(byteArrayOutputStream2, xc0Var3.g, 4);
                String strB3 = b(xc0Var3.a, xc0Var3.b, bArr2);
                Charset charset3 = StandardCharsets.UTF_8;
                int length2 = strB3.getBytes(charset3).length;
                en4.f(byteArrayOutputStream2, length2);
                i5 = i5 + 14 + length2;
                byteArrayOutputStream2.write(strB3.getBytes(charset3));
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            if (i5 != byteArray.length) {
                throw new IllegalStateException("Expected size " + i5 + ", does not match actual size " + byteArray.length);
            }
            tc3 tc3Var = new tc3(1, byteArray, false);
            byteArrayOutputStream2.close();
            arrayList2.add(tc3Var);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i6 = 0;
            int i7 = 0;
            while (i6 < xc0VarArr.length) {
                try {
                    xc0 xc0Var4 = xc0VarArr[i6];
                    en4.f(byteArrayOutputStream3, i6);
                    en4.f(byteArrayOutputStream3, xc0Var4.e);
                    i7 = i7 + 4 + (xc0Var4.e * i4);
                    int[] iArr = xc0Var4.h;
                    int length3 = iArr.length;
                    int i8 = i;
                    while (i < length3) {
                        int i9 = iArr[i];
                        en4.f(byteArrayOutputStream3, i9 - i8);
                        i++;
                        i4 = i4;
                        i8 = i9;
                    }
                    i6++;
                    i = 0;
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream3.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
            int i10 = i4;
            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
            if (i7 != byteArray2.length) {
                throw new IllegalStateException("Expected size " + i7 + ", does not match actual size " + byteArray2.length);
            }
            tc3 tc3Var2 = new tc3(3, byteArray2, true);
            byteArrayOutputStream3.close();
            arrayList2.add(tc3Var2);
            ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
            int i11 = 0;
            int i12 = 0;
            while (i11 < xc0VarArr.length) {
                try {
                    xc0 xc0Var5 = xc0VarArr[i11];
                    Iterator it3 = xc0Var5.i.entrySet().iterator();
                    int iIntValue = 0;
                    while (it3.hasNext()) {
                        iIntValue |= ((Integer) ((Map.Entry) it3.next()).getValue()).intValue();
                    }
                    ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
                    try {
                        l(byteArrayOutputStream5, iIntValue, xc0Var5);
                        byte[] byteArray3 = byteArrayOutputStream5.toByteArray();
                        byteArrayOutputStream5.close();
                        ByteArrayOutputStream byteArrayOutputStream6 = new ByteArrayOutputStream();
                        try {
                            m(byteArrayOutputStream6, xc0Var5);
                            byte[] byteArray4 = byteArrayOutputStream6.toByteArray();
                            byteArrayOutputStream6.close();
                            en4.f(byteArrayOutputStream4, i11);
                            int length4 = byteArray3.length + 2 + byteArray4.length;
                            int i13 = i12 + 6;
                            ArrayList arrayList4 = arrayList3;
                            en4.e(byteArrayOutputStream4, length4, 4);
                            en4.f(byteArrayOutputStream4, iIntValue);
                            byteArrayOutputStream4.write(byteArray3);
                            byteArrayOutputStream4.write(byteArray4);
                            i12 = i13 + length4;
                            i11++;
                            arrayList3 = arrayList4;
                        } catch (Throwable th3) {
                            try {
                                byteArrayOutputStream6.close();
                                throw th3;
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                                throw th3;
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            byteArrayOutputStream5.close();
                            throw th5;
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                            throw th5;
                        }
                    }
                } catch (Throwable th7) {
                    try {
                        byteArrayOutputStream4.close();
                        throw th7;
                    } catch (Throwable th8) {
                        th7.addSuppressed(th8);
                        throw th7;
                    }
                }
            }
            ArrayList arrayList5 = arrayList3;
            byte[] byteArray5 = byteArrayOutputStream4.toByteArray();
            if (i12 != byteArray5.length) {
                throw new IllegalStateException("Expected size " + i12 + ", does not match actual size " + byteArray5.length);
            }
            tc3 tc3Var3 = new tc3(4, byteArray5, true);
            byteArrayOutputStream4.close();
            arrayList2.add(tc3Var3);
            long size2 = 12 + ((long) (arrayList2.size() * 16));
            en4.e(byteArrayOutputStream, arrayList2.size(), 4);
            int i14 = 0;
            while (i14 < arrayList2.size()) {
                tc3 tc3Var4 = (tc3) arrayList2.get(i14);
                int i15 = tc3Var4.a;
                byte[] bArr7 = tc3Var4.b;
                int i16 = i10;
                if (i15 == 1) {
                    j = 0;
                } else if (i15 == i16) {
                    j = 1;
                } else if (i15 == 3) {
                    j = 2;
                } else if (i15 == 4) {
                    j = 3;
                } else {
                    if (i15 != 5) {
                        throw null;
                    }
                    j = 4;
                }
                en4.e(byteArrayOutputStream, j, 4);
                en4.e(byteArrayOutputStream, size2, 4);
                if (tc3Var4.c) {
                    long length5 = bArr7.length;
                    byte[] bArrA5 = en4.a(bArr7);
                    arrayList = arrayList5;
                    arrayList.add(bArrA5);
                    en4.e(byteArrayOutputStream, bArrA5.length, 4);
                    en4.e(byteArrayOutputStream, length5, 4);
                    length = bArrA5.length;
                } else {
                    arrayList = arrayList5;
                    arrayList.add(bArr7);
                    en4.e(byteArrayOutputStream, bArr7.length, 4);
                    en4.e(byteArrayOutputStream, 0L, 4);
                    length = bArr7.length;
                }
                size2 += (long) length;
                i14++;
                arrayList5 = arrayList;
                i10 = i16;
            }
            ArrayList arrayList6 = arrayList5;
            for (int i17 = 0; i17 < arrayList6.size(); i17++) {
                byteArrayOutputStream.write((byte[]) arrayList6.get(i17));
            }
            return true;
        } catch (Throwable th9) {
            try {
                byteArrayOutputStream2.close();
                throw th9;
            } catch (Throwable th10) {
                th9.addSuppressed(th10);
                throw th9;
            }
        }
    }

    public static void j(ByteArrayOutputStream byteArrayOutputStream, xc0 xc0Var) throws IOException {
        m(byteArrayOutputStream, xc0Var);
        int i = xc0Var.g;
        int[] iArr = xc0Var.h;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = iArr[i2];
            en4.f(byteArrayOutputStream, i4 - i3);
            i2++;
            i3 = i4;
        }
        byte[] bArr = new byte[(((i * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : xc0Var.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                int i5 = iIntValue / 8;
                bArr[i5] = (byte) (bArr[i5] | (1 << (iIntValue % 8)));
            }
            if ((iIntValue2 & 4) != 0) {
                int i6 = iIntValue + i;
                int i7 = i6 / 8;
                bArr[i7] = (byte) ((1 << (i6 % 8)) | bArr[i7]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void k(ByteArrayOutputStream byteArrayOutputStream, xc0 xc0Var, String str) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        en4.f(byteArrayOutputStream, str.getBytes(charset).length);
        en4.f(byteArrayOutputStream, xc0Var.e);
        en4.e(byteArrayOutputStream, xc0Var.f, 4);
        en4.e(byteArrayOutputStream, xc0Var.c, 4);
        en4.e(byteArrayOutputStream, xc0Var.g, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void l(ByteArrayOutputStream byteArrayOutputStream, int i, xc0 xc0Var) throws IOException {
        int i2 = xc0Var.g;
        byte[] bArr = new byte[(((Integer.bitCount(i & (-2)) * i2) + 7) & (-8)) / 8];
        for (Map.Entry entry : xc0Var.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            int i3 = 0;
            for (int i4 = 1; i4 <= 4; i4 <<= 1) {
                if (i4 != 1 && (i4 & i) != 0) {
                    if ((i4 & iIntValue2) == i4) {
                        int i5 = (i3 * i2) + iIntValue;
                        int i6 = i5 / 8;
                        bArr[i6] = (byte) ((1 << (i5 % 8)) | bArr[i6]);
                    }
                    i3++;
                }
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void m(ByteArrayOutputStream byteArrayOutputStream, xc0 xc0Var) throws IOException {
        int i = 0;
        for (Map.Entry entry : xc0Var.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                en4.f(byteArrayOutputStream, iIntValue - i);
                en4.f(byteArrayOutputStream, 0);
                i = iIntValue;
            }
        }
    }
}
