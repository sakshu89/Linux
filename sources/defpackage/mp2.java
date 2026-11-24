package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mp2 implements Cloneable {
    public /* synthetic */ int[] a;
    public /* synthetic */ Object[] b;
    public /* synthetic */ int c;

    public mp2(int i) {
        int i2;
        int i3 = 4;
        while (true) {
            i2 = 40;
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (40 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        int i5 = i2 / 4;
        this.a = new int[i5];
        this.b = new Object[i5];
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final mp2 clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        objClone.getClass();
        mp2 mp2Var = (mp2) objClone;
        mp2Var.a = (int[]) this.a.clone();
        mp2Var.b = (Object[]) this.b.clone();
        return mp2Var;
    }

    public final Object b(int i) {
        Object obj;
        int iA = ny3.a(this.a, this.c, i);
        if (iA < 0 || (obj = this.b[iA]) == m54.a) {
            return null;
        }
        return obj;
    }

    public final void c(int i, Object obj) {
        int iA = ny3.a(this.a, this.c, i);
        if (iA >= 0) {
            this.b[iA] = obj;
            return;
        }
        int i2 = ~iA;
        int i3 = this.c;
        if (i2 < i3) {
            Object[] objArr = this.b;
            if (objArr[i2] == m54.a) {
                this.a[i2] = i;
                objArr[i2] = obj;
                return;
            }
        }
        if (i3 >= this.a.length) {
            int i4 = (i3 + 1) * 4;
            for (int i5 = 4; i5 < 32; i5++) {
                int i6 = (1 << i5) - 12;
                if (i4 <= i6) {
                    i4 = i6;
                    break;
                }
            }
            int i7 = i4 / 4;
            this.a = Arrays.copyOf(this.a, i7);
            this.b = Arrays.copyOf(this.b, i7);
        }
        int i8 = this.c;
        if (i8 - i2 != 0) {
            int[] iArr = this.a;
            int i9 = i2 + 1;
            qg.e(iArr, i9, iArr, i2, i8);
            Object[] objArr2 = this.b;
            qg.g(objArr2, i9, objArr2, i2, this.c);
        }
        this.a[i2] = i;
        this.b[i2] = obj;
        this.c++;
    }

    public final Object d(int i) {
        Object[] objArr = this.b;
        if (i < objArr.length) {
            return objArr[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final String toString() {
        int i = this.c;
        if (i <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i * 28);
        sb.append('{');
        int i2 = this.c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(this.a[i3]);
            sb.append('=');
            Object objD = d(i3);
            if (objD != this) {
                sb.append(objD);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
