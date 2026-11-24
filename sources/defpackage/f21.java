package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class f21 implements Iterable, x41 {
    public final int a;
    public final int b;
    public final int c;

    public f21(int i, int i2, int i3) {
        if (i3 == 0) {
            og.i("Step must be non-zero.");
            throw null;
        }
        if (i3 == Integer.MIN_VALUE) {
            og.i("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw null;
        }
        this.a = i;
        this.b = dy3.a(i, i2, i3);
        this.c = i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f21)) {
            return false;
        }
        if (isEmpty() && ((f21) obj).isEmpty()) {
            return true;
        }
        f21 f21Var = (f21) obj;
        return this.a == f21Var.a && this.b == f21Var.b && this.c == f21Var.c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public boolean isEmpty() {
        int i = this.b;
        int i2 = this.c;
        int i3 = this.a;
        if (i2 > 0) {
            return i3 > i;
        }
        return i3 < i;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new g21(this.a, this.b, this.c);
    }

    public String toString() {
        StringBuilder sb;
        int i = this.b;
        int i2 = this.c;
        int i3 = this.a;
        if (i2 > 0) {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append("..");
            sb.append(i);
            sb.append(" step ");
            sb.append(i2);
        } else {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append(" downTo ");
            sb.append(i);
            sb.append(" step ");
            sb.append(-i2);
        }
        return sb.toString();
    }
}
