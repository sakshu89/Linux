package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kr1 extends zr1 {
    public static final kr1 c = new kr1(1, 0, 2);

    @Override // defpackage.zr1
    public final void a(iz izVar, xf xfVar, rl2 rl2Var, i52 i52Var, as1 as1Var) {
        int[] iArr;
        j6 j6Var;
        int iC;
        int iD = izVar.d(0);
        if (rl2Var.n != 0) {
            y20.a("Cannot move a group while inserting");
        }
        if (iD < 0) {
            y20.a("Parameter offset is out of bounds");
        }
        if (iD == 0) {
            return;
        }
        int i = rl2Var.t;
        int i2 = rl2Var.v;
        int i3 = rl2Var.u;
        int i4 = i;
        while (true) {
            iArr = rl2Var.b;
            if (iD <= 0) {
                break;
            }
            i4 += iArr[(rl2Var.r(i4) * 5) + 3];
            if (i4 > i3) {
                y20.a("Parameter offset is out of bounds");
            }
            iD--;
        }
        int i5 = iArr[(rl2Var.r(i4) * 5) + 3];
        int iG = rl2Var.g(rl2Var.r(rl2Var.t), rl2Var.b);
        int iG2 = rl2Var.g(rl2Var.r(i4), rl2Var.b);
        int i6 = i4 + i5;
        int iG3 = rl2Var.g(rl2Var.r(i6), rl2Var.b);
        int i7 = iG3 - iG2;
        rl2Var.x(i7, Math.max(rl2Var.t - 1, 0));
        rl2Var.w(i5);
        int[] iArr2 = rl2Var.b;
        int iR = rl2Var.r(i6) * 5;
        qg.e(iArr2, rl2Var.r(i) * 5, iArr2, iR, (i5 * 5) + iR);
        if (i7 > 0) {
            Object[] objArr = rl2Var.c;
            int iH = rl2Var.h(iG2 + i7);
            System.arraycopy(objArr, iH, objArr, iG, rl2Var.h(iG3 + i7) - iH);
        }
        int i8 = iG2 + i7;
        int i9 = i8 - iG;
        int i10 = rl2Var.k;
        int i11 = rl2Var.l;
        int length = rl2Var.c.length;
        int i12 = rl2Var.m;
        int i13 = i + i5;
        int i14 = i;
        while (i14 < i13) {
            int iR2 = rl2Var.r(i14);
            int i15 = i9;
            int[] iArr3 = iArr2;
            iArr3[(iR2 * 5) + 4] = rl2.i(rl2.i(rl2Var.g(iR2, iArr2) - i15, i12 < iR2 ? 0 : i10, i11, length), rl2Var.k, rl2Var.l, rl2Var.c.length);
            i14++;
            i9 = i15;
            iArr2 = iArr3;
            i10 = i10;
        }
        int i16 = i6 + i5;
        int iP = rl2Var.p();
        int iA = ql2.a(rl2Var.d, i6, iP);
        ArrayList arrayList = new ArrayList();
        if (iA >= 0) {
            while (iA < rl2Var.d.size() && (iC = rl2Var.c((j6Var = (j6) rl2Var.d.get(iA)))) >= i6 && iC < i16) {
                arrayList.add(j6Var);
            }
        }
        int i17 = i - i6;
        int size = arrayList.size();
        for (int i18 = 0; i18 < size; i18++) {
            j6 j6Var2 = (j6) arrayList.get(i18);
            int iC2 = rl2Var.c(j6Var2) + i17;
            if (iC2 >= rl2Var.g) {
                j6Var2.a = -(iP - iC2);
            } else {
                j6Var2.a = iC2;
            }
            rl2Var.d.add(ql2.a(rl2Var.d, iC2, iP), j6Var2);
        }
        if (rl2Var.I(i6, i5)) {
            y20.a("Unexpectedly removed anchors");
        }
        rl2Var.m(i2, rl2Var.u, i);
        if (i7 > 0) {
            rl2Var.J(i8, i7, i6 - 1);
        }
    }
}
