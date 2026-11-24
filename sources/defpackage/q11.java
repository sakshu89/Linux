package defpackage;

import android.graphics.Insets;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q11 {
    public static final q11 e = new q11(0, 0, 0, 0);
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public q11(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static q11 a(q11 q11Var, q11 q11Var2) {
        return b(Math.max(q11Var.a, q11Var2.a), Math.max(q11Var.b, q11Var2.b), Math.max(q11Var.c, q11Var2.c), Math.max(q11Var.d, q11Var2.d));
    }

    public static q11 b(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? e : new q11(i, i2, i3, i4);
    }

    public static q11 c(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets d() {
        return f50.h(this.a, this.b, this.c, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q11.class != obj.getClass()) {
            return false;
        }
        q11 q11Var = (q11) obj;
        return this.d == q11Var.d && this.a == q11Var.a && this.c == q11Var.c && this.b == q11Var.b;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Insets{left=");
        sb.append(this.a);
        sb.append(", top=");
        sb.append(this.b);
        sb.append(", right=");
        sb.append(this.c);
        sb.append(", bottom=");
        return ky0.m(sb, this.d, '}');
    }
}
