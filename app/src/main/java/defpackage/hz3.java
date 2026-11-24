package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class hz3 {
    public static final zz a = zz.f;
    public static final zz b = zz.b;
    public static final float c = 0.1f;
    public static final zz d = zz.c;
    public static final float e = 0.38f;
    public static final float f = 1.0f;
    public static final zz g = zz.a;

    public static final ph1 a(b92 b92Var, int i, int i2, int i3, int i4, int i5, qh1 qh1Var, List list, zw1[] zw1VarArr, int i6, int i7, int[] iArr, int i8) {
        int i9;
        float f2;
        int i10;
        int i11;
        int i12;
        List list2 = list;
        long j = i5;
        int i13 = i7 - i6;
        int[] iArr2 = new int[i13];
        int i14 = i6;
        int iMax = 0;
        int i15 = 0;
        int i16 = 0;
        int iMin = 0;
        float f3 = 0.0f;
        while (i14 < i7) {
            jh1 jh1Var = (jh1) list2.get(i14);
            float fB = fz3.b(fz3.a(jh1Var));
            if (fB > 0.0f) {
                f3 += fB;
                i15++;
                i10 = i14;
            } else {
                int i17 = i3 - i16;
                zw1 zw1VarE = zw1VarArr[i14];
                if (zw1VarE == null) {
                    if (i3 == Integer.MAX_VALUE) {
                        i10 = i14;
                        i11 = i15;
                        i12 = Integer.MAX_VALUE;
                    } else {
                        i10 = i14;
                        i11 = i15;
                        i12 = i17 < 0 ? 0 : i17;
                    }
                    zw1VarE = jh1Var.e(b92Var.d(0, i12, i4, false));
                } else {
                    i10 = i14;
                    i11 = i15;
                }
                zw1 zw1Var = zw1VarE;
                int iH = b92Var.h(zw1Var);
                int iE = b92Var.e(zw1Var);
                iArr2[i10 - i6] = iH;
                int i18 = i17 - iH;
                if (i18 < 0) {
                    i18 = 0;
                }
                iMin = Math.min(i5, i18);
                i16 += iH + iMin;
                iMax = Math.max(iMax, iE);
                zw1VarArr[i10] = zw1Var;
                i15 = i11;
            }
            i14 = i10 + 1;
            j = j;
        }
        long j2 = j;
        int i19 = i15;
        if (i19 == 0) {
            i16 -= iMin;
            i9 = 0;
        } else {
            long j3 = ((long) (i19 - 1)) * j2;
            long jRound = ((long) ((i3 != Integer.MAX_VALUE ? i3 : i) - i16)) - j3;
            if (jRound < 0) {
                jRound = 0;
            }
            float f4 = jRound / f3;
            for (int i20 = i6; i20 < i7; i20++) {
                jRound -= (long) Math.round(fz3.b(fz3.a((jh1) list2.get(i20))) * f4);
            }
            int i21 = i6;
            int i22 = iMax;
            int i23 = 0;
            while (i21 < i7) {
                if (zw1VarArr[i21] == null) {
                    jh1 jh1Var2 = (jh1) list2.get(i21);
                    f2 = f4;
                    c92 c92VarA = fz3.a(jh1Var2);
                    float fB2 = fz3.b(c92VarA);
                    if (fB2 <= 0.0f) {
                        x01.b("All weights <= 0 should have placeables");
                    }
                    int iSignum = Long.signum(jRound);
                    long j4 = jRound - ((long) iSignum);
                    int iMax2 = Math.max(0, Math.round(fB2 * f2) + iSignum);
                    zw1 zw1VarE2 = jh1Var2.e(b92Var.d((!(c92VarA != null ? c92VarA.b : true) || iMax2 == Integer.MAX_VALUE) ? 0 : iMax2, iMax2, i4, true));
                    int iH2 = b92Var.h(zw1VarE2);
                    int iE2 = b92Var.e(zw1VarE2);
                    iArr2[i21 - i6] = iH2;
                    i23 += iH2;
                    int iMax3 = Math.max(i22, iE2);
                    zw1VarArr[i21] = zw1VarE2;
                    i22 = iMax3;
                    jRound = j4;
                } else {
                    f2 = f4;
                }
                i21++;
                list2 = list;
                f4 = f2;
            }
            i9 = (int) (((long) i23) + j3);
            int i24 = i3 - i16;
            if (i9 < 0) {
                i9 = 0;
            }
            if (i9 > i24) {
                i9 = i24;
            }
            iMax = i22;
        }
        int i25 = i9 + i16;
        if (i25 < 0) {
            i25 = 0;
        }
        int iMax4 = Math.max(i25, i);
        int iMax5 = Math.max(iMax, Math.max(i2, 0));
        int[] iArr3 = new int[i13];
        b92Var.b(iMax4, qh1Var, iArr2, iArr3);
        return b92Var.j(zw1VarArr, qh1Var, iArr3, iMax4, iMax5, iArr, i8, i6, i7);
    }
}
