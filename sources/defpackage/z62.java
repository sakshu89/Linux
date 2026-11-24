package defpackage;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z62 implements Closeable {
    public final lj1 a;
    public final y12 b;
    public final String c;
    public final int e;
    public final yv0 f;
    public final ew0 i;
    public final b72 j;
    public final z62 k;
    public final z62 n;
    public final z62 s;
    public final long t;
    public final long u;
    public final ux v;

    public z62(lj1 lj1Var, y12 y12Var, String str, int i, yv0 yv0Var, ew0 ew0Var, b72 b72Var, z62 z62Var, z62 z62Var2, z62 z62Var3, long j, long j2, ux uxVar) {
        lj1Var.getClass();
        y12Var.getClass();
        str.getClass();
        this.a = lj1Var;
        this.b = y12Var;
        this.c = str;
        this.e = i;
        this.f = yv0Var;
        this.i = ew0Var;
        this.j = b72Var;
        this.k = z62Var;
        this.n = z62Var2;
        this.s = z62Var3;
        this.t = j;
        this.u = j2;
        this.v = uxVar;
    }

    public static String c(z62 z62Var, String str) {
        z62Var.getClass();
        String strA = z62Var.i.a(str);
        if (strA == null) {
            return null;
        }
        return strA;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        b72 b72Var = this.j;
        if (b72Var != null) {
            b72Var.close();
        } else {
            og.n("response is not eligible for a body and must not be closed");
        }
    }

    public final y62 e() {
        y62 y62Var = new y62();
        y62Var.a = this.a;
        y62Var.b = this.b;
        y62Var.c = this.e;
        y62Var.d = this.c;
        y62Var.e = this.f;
        y62Var.f = this.i.d();
        y62Var.g = this.j;
        y62Var.h = this.k;
        y62Var.i = this.n;
        y62Var.j = this.s;
        y62Var.k = this.t;
        y62Var.l = this.u;
        y62Var.m = this.v;
        return y62Var;
    }

    public final String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.e + ", message=" + this.c + ", url=" + ((ey0) this.a.b) + '}';
    }
}
