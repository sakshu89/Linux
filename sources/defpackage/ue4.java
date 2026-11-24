package defpackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ue4 {
    public static final void a(py0 py0Var, ny1 ny1Var, long j) {
        kb0 kb0Var = (kb0) py0Var.b;
        kb0Var.getClass();
        z63 z63Var = (z63) kb0Var.c;
        z63 z63Var2 = (z63) kb0Var.b;
        boolean zB = y11.b(ny1Var);
        long j2 = ny1Var.b;
        if (zB) {
            b90[] b90VarArr = z63Var2.d;
            qg.l(0, b90VarArr.length, null, b90VarArr);
            z63Var2.e = 0;
            b90[] b90VarArr2 = z63Var.d;
            qg.l(0, b90VarArr2.length, null, b90VarArr2);
            z63Var.e = 0;
            kb0Var.a = 0L;
        }
        if (!y11.d(ny1Var)) {
            List list = ny1Var.k;
            if (list == null) {
                list = ii0.a;
            }
            int i = 0;
            for (int size = list.size(); i < size; size = size) {
                lw0 lw0Var = (lw0) list.get(i);
                kb0Var.c(lw0Var.a, jp1.e(lw0Var.c, j));
                i++;
            }
            kb0Var.c(j2, jp1.e(ny1Var.l, j));
        }
        if (y11.d(ny1Var) && j2 - kb0Var.a > 40) {
            b90[] b90VarArr3 = z63Var2.d;
            qg.l(0, b90VarArr3.length, null, b90VarArr3);
            z63Var2.e = 0;
            b90[] b90VarArr4 = z63Var.d;
            qg.l(0, b90VarArr4.length, null, b90VarArr4);
            z63Var.e = 0;
            kb0Var.a = 0L;
        }
        kb0Var.a = j2;
    }

    public static gh b() throws InterruptedException {
        gh ghVar = gh.l;
        ghVar.getClass();
        gh ghVar2 = ghVar.f;
        if (ghVar2 == null) {
            long jNanoTime = System.nanoTime();
            gh.i.await(gh.j, TimeUnit.MILLISECONDS);
            gh ghVar3 = gh.l;
            ghVar3.getClass();
            if (ghVar3.f != null || System.nanoTime() - jNanoTime < gh.k) {
                return null;
            }
            return gh.l;
        }
        long jNanoTime2 = ghVar2.g - System.nanoTime();
        if (jNanoTime2 > 0) {
            gh.i.await(jNanoTime2, TimeUnit.NANOSECONDS);
            return null;
        }
        gh ghVar4 = gh.l;
        ghVar4.getClass();
        ghVar4.f = ghVar2.f;
        ghVar2.f = null;
        return ghVar2;
    }

    public static final float c(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        float f = 0.0f;
        for (int i = 0; i < length; i++) {
            f += fArr[i] * fArr2[i];
        }
        return f;
    }

    public static final void d(float[] fArr, float[] fArr2, int i, float[] fArr3) {
        if (i == 0) {
            z01.a("At least one point must be provided");
        }
        int i2 = 2 >= i ? i - 1 : 2;
        int i3 = i2 + 1;
        float[][] fArr4 = new float[i3][];
        for (int i4 = 0; i4 < i3; i4++) {
            fArr4[i4] = new float[i];
        }
        for (int i5 = 0; i5 < i; i5++) {
            fArr4[0][i5] = 1.0f;
            for (int i6 = 1; i6 < i3; i6++) {
                fArr4[i6][i5] = fArr4[i6 - 1][i5] * fArr[i5];
            }
        }
        float[][] fArr5 = new float[i3][];
        for (int i7 = 0; i7 < i3; i7++) {
            fArr5[i7] = new float[i];
        }
        float[][] fArr6 = new float[i3][];
        for (int i8 = 0; i8 < i3; i8++) {
            fArr6[i8] = new float[i3];
        }
        int i9 = 0;
        while (i9 < i3) {
            float[] fArr7 = fArr5[i9];
            float[] fArr8 = fArr4[i9];
            fArr8.getClass();
            fArr7.getClass();
            System.arraycopy(fArr8, 0, fArr7, 0, i);
            for (int i10 = 0; i10 < i9; i10++) {
                float[] fArr9 = fArr5[i10];
                float fC = c(fArr7, fArr9);
                for (int i11 = 0; i11 < i; i11++) {
                    fArr7[i11] = fArr7[i11] - (fArr9[i11] * fC);
                }
            }
            float fSqrt = (float) Math.sqrt(c(fArr7, fArr7));
            if (fSqrt < 1.0E-6f) {
                fSqrt = 1.0E-6f;
            }
            float f = 1.0f / fSqrt;
            for (int i12 = 0; i12 < i; i12++) {
                fArr7[i12] = fArr7[i12] * f;
            }
            float[] fArr10 = fArr6[i9];
            int i13 = 0;
            while (i13 < i3) {
                fArr10[i13] = i13 < i9 ? 0.0f : c(fArr7, fArr4[i13]);
                i13++;
            }
            i9++;
        }
        for (int i14 = i2; -1 < i14; i14--) {
            float fC2 = c(fArr5[i14], fArr2);
            float[] fArr11 = fArr6[i14];
            int i15 = i14 + 1;
            if (i15 <= i2) {
                int i16 = i2;
                while (true) {
                    fC2 -= fArr11[i16] * fArr3[i16];
                    if (i16 != i15) {
                        i16--;
                    }
                }
            }
            fArr3[i14] = fC2 / fArr11[i14];
        }
    }
}
