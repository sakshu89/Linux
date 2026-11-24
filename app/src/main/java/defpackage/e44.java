package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class e44 {
    public static final q91 a = new q91(26, new ag(11), new va1(11));

    public static List a(rl2 rl2Var, int i, rl2 rl2Var2, boolean z, boolean z2, boolean z3) {
        List list;
        boolean z4;
        int iU = rl2Var.u(i);
        int i2 = i + iU;
        int iF = rl2Var.f(i);
        int iF2 = rl2Var.f(i2);
        int i3 = iF2 - iF;
        boolean z5 = i >= 0 && (rl2Var.b[(rl2Var.r(i) * 5) + 1] & 201326592) != 0;
        rl2Var2.w(iU);
        rl2Var2.x(i3, rl2Var2.t);
        if (rl2Var.g < i2) {
            rl2Var.B(i2);
        }
        if (rl2Var.k < iF2) {
            rl2Var.C(iF2, i2);
        }
        int[] iArr = rl2Var2.b;
        int i4 = rl2Var2.t;
        int i5 = i4 * 5;
        qg.e(rl2Var.b, i5, iArr, i * 5, i2 * 5);
        Object[] objArr = rl2Var2.c;
        int i6 = rl2Var2.i;
        System.arraycopy(rl2Var.c, iF, objArr, i6, i3);
        int i7 = rl2Var2.v;
        iArr[i5 + 2] = i7;
        int i8 = i4 - i;
        int i9 = i4 + iU;
        int iG = i6 - rl2Var2.g(i4, iArr);
        int i10 = rl2Var2.m;
        int i11 = rl2Var2.l;
        int length = objArr.length;
        boolean z6 = z5;
        int i12 = i10;
        int i13 = i4;
        while (i13 < i9) {
            if (i13 != i4) {
                int i14 = (i13 * 5) + 2;
                iArr[i14] = iArr[i14] + i8;
            }
            int[] iArr2 = iArr;
            iArr2[(i13 * 5) + 4] = rl2.i(rl2Var2.g(i13, iArr) + iG, i12 < i13 ? 0 : rl2Var2.k, i11, length);
            if (i13 == i12) {
                i12++;
            }
            i13++;
            i4 = i4;
            iArr = iArr2;
        }
        int[] iArr3 = iArr;
        rl2Var2.m = i12;
        int iA = ql2.a(rl2Var.d, i, rl2Var.p());
        int iA2 = ql2.a(rl2Var.d, i2, rl2Var.p());
        if (iA < iA2) {
            ArrayList arrayList = rl2Var.d;
            ArrayList arrayList2 = new ArrayList(iA2 - iA);
            for (int i15 = iA; i15 < iA2; i15++) {
                j6 j6Var = (j6) arrayList.get(i15);
                j6Var.a += i8;
                arrayList2.add(j6Var);
            }
            rl2Var2.d.addAll(ql2.a(rl2Var2.d, rl2Var2.t, rl2Var2.p()), arrayList2);
            arrayList.subList(iA, iA2).clear();
            list = arrayList2;
        } else {
            list = ii0.a;
        }
        if (!list.isEmpty()) {
            HashMap map = rl2Var.e;
            HashMap map2 = rl2Var2.e;
            if (map != null && map2 != null) {
                int size = list.size();
                for (int i16 = 0; i16 < size; i16++) {
                }
            }
        }
        int i17 = rl2Var2.v;
        rl2Var2.O(i7);
        int iE = rl2Var.E(i, rl2Var.b);
        if (!z3) {
            z4 = false;
        } else if (z) {
            boolean z7 = iE >= 0;
            if (z7) {
                rl2Var.P();
                rl2Var.a(iE - rl2Var.t);
                rl2Var.P();
            }
            rl2Var.a(i - rl2Var.t);
            boolean zH = rl2Var.H();
            if (z7) {
                rl2Var.M();
                rl2Var.j();
                rl2Var.M();
                rl2Var.j();
            }
            z4 = zH;
        } else {
            boolean zI = rl2Var.I(i, iU);
            rl2Var.J(iF, i3, i - 1);
            z4 = zI;
        }
        if (z4) {
            y20.a("Unexpectedly removed anchors");
        }
        int i18 = rl2Var2.o;
        int i19 = iArr3[i5 + 1];
        rl2Var2.o = i18 + ((1073741824 & i19) != 0 ? 1 : i19 & 67108863);
        if (z2) {
            rl2Var2.t = i9;
            rl2Var2.i = i6 + i3;
        }
        if (z6) {
            rl2Var2.T(i7);
        }
        return list;
    }
}
