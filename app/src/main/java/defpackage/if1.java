package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class if1 implements Cloneable {
    public /* synthetic */ boolean a;
    public /* synthetic */ long[] b;
    public /* synthetic */ Object[] c;
    public /* synthetic */ int e;

    public if1(int i) {
        if (i == 0) {
            this.b = ny3.b;
            this.c = ny3.c;
            return;
        }
        int i2 = i * 8;
        for (int i3 = 4; i3 < 32; i3++) {
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
        }
        int i5 = i2 / 8;
        this.b = new long[i5];
        this.c = new Object[i5];
    }

    public final void a() {
        int i = this.e;
        Object[] objArr = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.a = false;
    }

    public final Object b(long j) {
        Object obj;
        int iB = ny3.b(this.b, this.e, j);
        if (iB < 0 || (obj = this.c[iB]) == m24.a) {
            return null;
        }
        return obj;
    }

    public final long c(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.e)) {
            og.i(ky0.h(i, "Expected index to be within 0..size()-1, but was "));
            return 0L;
        }
        if (this.a) {
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != m24.a) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.a = false;
            this.e = i3;
        }
        return this.b[i];
    }

    public final Object clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        objClone.getClass();
        if1 if1Var = (if1) objClone;
        if1Var.b = (long[]) this.b.clone();
        if1Var.c = (Object[]) this.c.clone();
        return if1Var;
    }

    public final void d(long j, Object obj) {
        int iB = ny3.b(this.b, this.e, j);
        if (iB >= 0) {
            this.c[iB] = obj;
            return;
        }
        int i = ~iB;
        int i2 = this.e;
        Object obj2 = m24.a;
        if (i < i2) {
            Object[] objArr = this.c;
            if (objArr[i] == obj2) {
                this.b[i] = j;
                objArr[i] = obj;
                return;
            }
        }
        if (this.a) {
            long[] jArr = this.b;
            if (i2 >= jArr.length) {
                Object[] objArr2 = this.c;
                int i3 = 0;
                for (int i4 = 0; i4 < i2; i4++) {
                    Object obj3 = objArr2[i4];
                    if (obj3 != obj2) {
                        if (i4 != i3) {
                            jArr[i3] = jArr[i4];
                            objArr2[i3] = obj3;
                            objArr2[i4] = null;
                        }
                        i3++;
                    }
                }
                this.a = false;
                this.e = i3;
                i = ~ny3.b(this.b, i3, j);
            }
        }
        int i5 = this.e;
        if (i5 >= this.b.length) {
            int i6 = (i5 + 1) * 8;
            for (int i7 = 4; i7 < 32; i7++) {
                int i8 = (1 << i7) - 12;
                if (i6 <= i8) {
                    i6 = i8;
                    break;
                }
            }
            int i9 = i6 / 8;
            this.b = Arrays.copyOf(this.b, i9);
            this.c = Arrays.copyOf(this.c, i9);
        }
        int i10 = this.e;
        if (i10 - i != 0) {
            long[] jArr2 = this.b;
            int i11 = i + 1;
            qg.f(jArr2, jArr2, i11, i, i10);
            Object[] objArr3 = this.c;
            qg.g(objArr3, i11, objArr3, i, this.e);
        }
        this.b[i] = j;
        this.c[i] = obj;
        this.e++;
    }

    public final void e(long j) {
        int iB = ny3.b(this.b, this.e, j);
        if (iB >= 0) {
            Object[] objArr = this.c;
            Object obj = objArr[iB];
            Object obj2 = m24.a;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.a = true;
            }
        }
    }

    public final int f() {
        if (this.a) {
            int i = this.e;
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != m24.a) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.a = false;
            this.e = i2;
        }
        return this.e;
    }

    public final Object g(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.e)) {
            og.i(ky0.h(i, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        if (this.a) {
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != m24.a) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.a = false;
            this.e = i3;
        }
        return this.c[i];
    }

    public final String toString() {
        if (f() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        int i = this.e;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(c(i2));
            sb.append('=');
            Object objG = g(i2);
            if (objG != sb) {
                sb.append(objG);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public /* synthetic */ if1(Object obj) {
        this(10);
    }
}
