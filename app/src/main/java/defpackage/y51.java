package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class y51 implements fg0 {
    public final x51 a;

    public y51(x51 x51Var) {
        this.a = x51Var;
    }

    @Override // defpackage.fg0, defpackage.pd
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final qq1 a(g33 g33Var) {
        int[] iArr;
        Object[] objArr;
        x51 x51Var = this.a;
        ml1 ml1Var = x51Var.b;
        ll1 ll1Var = new ll1(ml1Var.e + 2);
        ml1 ml1Var2 = new ml1(ml1Var.e);
        int[] iArr2 = ml1Var.b;
        Object[] objArr2 = ml1Var.c;
        long[] jArr = ml1Var.a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8;
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    int i4 = 0;
                    while (i4 < i3) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            int i6 = iArr2[i5];
                            w51 w51Var = (w51) objArr2[i5];
                            ll1Var.a(i6);
                            ml1Var2.h(i6, new w63((vd) g33Var.a.j(w51Var.a), w51Var.b));
                        }
                        j >>= i2;
                        i4++;
                        i2 = i2;
                        iArr2 = iArr2;
                        objArr2 = objArr2;
                    }
                    iArr = iArr2;
                    objArr = objArr2;
                    if (i3 != i2) {
                        break;
                    }
                } else {
                    iArr = iArr2;
                    objArr = objArr2;
                }
                if (i == length) {
                    break;
                }
                i++;
                iArr2 = iArr;
                objArr2 = objArr;
            }
        }
        if (!ml1Var.a(0)) {
            int i7 = ll1Var.b;
            if (i7 < 0) {
                og.o("Index must be between 0 and size");
                return null;
            }
            ll1Var.b(i7 + 1);
            int[] iArr3 = ll1Var.a;
            int i8 = ll1Var.b;
            if (i8 != 0) {
                qg.e(iArr3, 1, iArr3, 0, i8);
            }
            iArr3[0] = 0;
            ll1Var.b++;
        }
        if (!ml1Var.a(x51Var.a)) {
            ll1Var.a(x51Var.a);
        }
        int i9 = ll1Var.b;
        if (i9 != 0) {
            int[] iArr4 = ll1Var.a;
            iArr4.getClass();
            Arrays.sort(iArr4, 0, i9);
        }
        return new qq1(ll1Var, ml1Var2, x51Var.a, ug0.b);
    }
}
