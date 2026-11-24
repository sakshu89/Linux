package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nv1 {
    public final ArrayList a;
    public final int b;
    public int c;
    public final ArrayList d;
    public final ml1 e;
    public final cv2 f;

    public nv1(int i, ArrayList arrayList) {
        this.a = arrayList;
        this.b = i;
        if (i < 0) {
            dz1.a("Invalid start index");
        }
        this.d = new ArrayList();
        ml1 ml1Var = new ml1();
        int size = arrayList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i51 i51Var = (i51) this.a.get(i3);
            int i4 = i51Var.c;
            int i5 = i51Var.d;
            ml1Var.h(i4, new lv0(i3, i2, i5));
            i2 += i5;
        }
        this.e = ml1Var;
        this.f = new cv2(new gg1(9, this));
    }

    public final boolean a(int i, int i2) {
        lv0 lv0Var;
        int i3;
        int i4;
        ml1 ml1Var = this.e;
        lv0 lv0Var2 = (lv0) ml1Var.b(i);
        if (lv0Var2 == null) {
            return false;
        }
        int i5 = lv0Var2.b;
        int i6 = i2 - lv0Var2.c;
        lv0Var2.c = i2;
        if (i6 == 0) {
            return true;
        }
        Object[] objArr = ml1Var.c;
        long[] jArr = ml1Var.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i7 = 0;
        while (true) {
            long j = jArr[i7];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8 - ((~(i7 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j) < 128 && (i3 = (lv0Var = (lv0) objArr[(i7 << 3) + i9]).b) >= i5 && lv0Var != lv0Var2 && (i4 = i3 + i6) >= 0) {
                        lv0Var.b = i4;
                    }
                    j >>= 8;
                }
                if (i8 != 8) {
                    return true;
                }
            }
            if (i7 == length) {
                return true;
            }
            i7++;
        }
    }
}
