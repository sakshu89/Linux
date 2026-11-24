package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class vo4 {
    public static final void a(py0 py0Var, e01 e01Var, js1 js1Var, d01 d01Var, m01 m01Var, long j) {
        float fIntBitsToFloat;
        ArrayList arrayList = m01Var.b;
        long j2 = e01Var.c;
        boolean z = e01Var.d;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (e01Var.c & 4294967295L));
        boolean z2 = e01Var.h;
        if (!z2 && z) {
            m01Var.a = 0;
            arrayList.clear();
        }
        if (!b(e01Var) && (z2 || !z)) {
            if (arrayList.size() == 3) {
                int i = m01Var.a;
                m01Var.a = i + 1;
                arrayList.set(i, e01Var);
            } else {
                arrayList.add(e01Var);
            }
            if (m01Var.a == 3) {
                m01Var.a = 0;
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(Float.valueOf(Float.intBitsToFloat((int) (((e01) arrayList.get(i2)).c >> 32))));
            }
            fIntBitsToFloat2 = (float) mz.r(arrayList2);
            ArrayList arrayList3 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList3.add(Float.valueOf(Float.intBitsToFloat((int) (((e01) arrayList.get(i3)).c & 4294967295L))));
            }
            fIntBitsToFloat3 = (float) mz.r(arrayList3);
        }
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat3)) & 4294967295L);
        if (js1Var != null) {
            int i4 = d01Var.a;
            if (i4 == 1) {
                fIntBitsToFloat = Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32));
            } else if (i4 == 2) {
                fIntBitsToFloat = Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L));
            }
            jFloatToRawIntBits = js1Var == js1.b ? (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L) : (((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L);
        }
        ((kb0) py0Var.b).c(e01Var.b, jp1.e(jFloatToRawIntBits, j));
    }

    public static final boolean b(e01 e01Var) {
        return e01Var.h && !e01Var.d;
    }

    public static final long c(e01 e01Var, js1 js1Var, d01 d01Var) {
        float fIntBitsToFloat;
        long jFloatToRawIntBits;
        long j;
        if (js1Var == null) {
            return e01Var.c;
        }
        int i = d01Var.a;
        if (i == 1) {
            fIntBitsToFloat = Float.intBitsToFloat((int) (e01Var.c >> 32));
        } else {
            if (i != 2) {
                return e01Var.c;
            }
            fIntBitsToFloat = Float.intBitsToFloat((int) (e01Var.c & 4294967295L));
        }
        if (js1Var == js1.b) {
            long jFloatToRawIntBits2 = Float.floatToRawIntBits(fIntBitsToFloat);
            jFloatToRawIntBits = Float.floatToRawIntBits(0.0f);
            j = jFloatToRawIntBits2 << 32;
        } else {
            long jFloatToRawIntBits3 = Float.floatToRawIntBits(0.0f);
            jFloatToRawIntBits = Float.floatToRawIntBits(fIntBitsToFloat);
            j = jFloatToRawIntBits3 << 32;
        }
        return j | (4294967295L & jFloatToRawIntBits);
    }

    public static final long d(e01 e01Var, js1 js1Var, d01 d01Var) {
        float fIntBitsToFloat;
        long j = e01Var.g;
        if (js1Var == null) {
            return j;
        }
        int i = d01Var.a;
        if (i == 1) {
            fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        } else {
            if (i != 2) {
                return j;
            }
            fIntBitsToFloat = Float.intBitsToFloat((int) (j & 4294967295L));
        }
        if (js1Var == js1.b) {
            return (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L);
        }
        return (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32);
    }
}
