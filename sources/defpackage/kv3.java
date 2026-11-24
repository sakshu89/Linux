package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kv3 {
    public static final kv3 f = new kv3(0, new int[0], new Object[0], false);
    public int a;
    public int[] b;
    public Object[] c;
    public int d = -1;
    public boolean e;

    public kv3(int i, int[] iArr, Object[] objArr, boolean z) {
        this.a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }

    public static kv3 b() {
        return new kv3(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int iB;
        int iC;
        int iB2;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iB3 = 0;
        for (int i2 = 0; i2 < this.a; i2++) {
            int i3 = this.b[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2) {
                        int i6 = i4 << 3;
                        rt3 rt3Var = (rt3) this.c[i2];
                        int iB4 = st3.b(i6);
                        int iD = rt3Var.d();
                        iB3 = ky0.b(iD, iD, iB4, iB3);
                    } else if (i5 == 3) {
                        int iB5 = st3.b(i4 << 3);
                        iB = iB5 + iB5;
                        iC = ((kv3) this.c[i2]).a();
                    } else {
                        if (i5 != 5) {
                            throw new IllegalStateException(new ou3());
                        }
                        ((Integer) this.c[i2]).getClass();
                        iB2 = st3.b(i4 << 3) + 4;
                    }
                } else {
                    ((Long) this.c[i2]).getClass();
                    iB2 = st3.b(i4 << 3) + 8;
                }
                iB3 = iB2 + iB3;
            } else {
                int i7 = i4 << 3;
                long jLongValue = ((Long) this.c[i2]).longValue();
                iB = st3.b(i7);
                iC = st3.c(jLongValue);
            }
            iB3 = iC + iB + iB3;
        }
        this.d = iB3;
        return iB3;
    }

    public final void c(int i, Object obj) {
        if (!this.e) {
            dk0.p();
            return;
        }
        e(this.a + 1);
        int[] iArr = this.b;
        int i2 = this.a;
        iArr[i2] = i;
        this.c[i2] = obj;
        this.a = i2 + 1;
    }

    public final void d(py0 py0Var) {
        if (this.a != 0) {
            for (int i = 0; i < this.a; i++) {
                int i2 = this.b[i];
                Object obj = this.c[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    ((st3) py0Var.b).q(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    ((st3) py0Var.b).i(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    st3 st3Var = (st3) py0Var.b;
                    st3Var.p((i4 << 3) | 2);
                    st3Var.f((rt3) obj);
                } else if (i3 == 3) {
                    ((st3) py0Var.b).n(i4, 3);
                    ((kv3) obj).d(py0Var);
                    ((st3) py0Var.b).n(i4, 4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(new ou3());
                    }
                    ((st3) py0Var.b).g(i4, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final void e(int i) {
        int[] iArr = this.b;
        if (i > iArr.length) {
            int i2 = this.a;
            int i3 = (i2 / 2) + i2;
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.b = Arrays.copyOf(iArr, i);
            this.c = Arrays.copyOf(this.c, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof kv3)) {
            kv3 kv3Var = (kv3) obj;
            int i = this.a;
            if (i == kv3Var.a) {
                int[] iArr = this.b;
                int[] iArr2 = kv3Var.b;
                for (int i2 = 0; i2 < i; i2++) {
                    if (iArr[i2] == iArr2[i2]) {
                    }
                }
                Object[] objArr = this.c;
                Object[] objArr2 = kv3Var.c;
                int i3 = this.a;
                for (int i4 = 0; i4 < i3; i4++) {
                    if (objArr[i4].equals(objArr2[i4])) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.a;
        int i2 = i + 527;
        int[] iArr = this.b;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = ((i2 * 31) + i3) * 31;
        Object[] objArr = this.c;
        int i6 = this.a;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }
}
