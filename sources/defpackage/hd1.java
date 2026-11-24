package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hd1 {
    public String a;
    public volatile boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public long f;
    public boolean g;
    public long h;
    public Long i;
    public boolean j;

    public final synchronized fd1 a(String str) {
        fd1 fd1Var;
        str.getClass();
        if (cs2.A(str)) {
            return fd1.a;
        }
        if (this.d || this.e) {
            this.f++;
            this.a = "";
            this.b = false;
            this.c = false;
            this.j = false;
            this.d = false;
            this.e = false;
            this.g = false;
        }
        if (this.i == null) {
            this.i = Long.valueOf(this.f);
        }
        Set set = mt0.b0;
        String strB = co4.b(this.a, str);
        this.a = strB;
        if (xy.o(strB)) {
            this.j = true;
            this.c = true;
            this.b = true;
            fd1Var = fd1.c;
        } else if (xy.q(this.a, false)) {
            this.j = true;
            this.c = false;
            this.b = true;
            fd1Var = fd1.b;
        } else {
            if (this.j) {
                this.b = false;
            }
            this.j = false;
            this.c = false;
            fd1Var = fd1.a;
        }
        return fd1Var;
    }

    public final synchronized boolean b(gd1 gd1Var) {
        boolean z;
        Long l;
        try {
            gd1Var.getClass();
            z = false;
            if (!this.g) {
                long j = gd1Var.a;
                if (j == this.f || ((l = this.i) != null && j == l.longValue())) {
                    String str = gd1Var.b;
                    str.getClass();
                    if (!this.b || xy.o(str) || xy.q(str, false)) {
                        z = true;
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    public final synchronized gd1 c() {
        return (!this.e || this.g || cs2.A(this.a)) ? null : new gd1(this.f, this.a);
    }

    public final synchronized void d() {
        if (!this.d) {
            this.e = true;
        }
    }

    public final synchronized void e() {
        if (!this.d) {
            Long l = this.i;
            long j = this.f;
            if (l != null && l.longValue() == j) {
                this.e = true;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0017  */
    public final synchronized boolean f() {
        boolean z;
        Long l = this.i;
        if (l != null) {
            long j = this.f;
            if (l != null && l.longValue() == j) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = true;
        }
        return z;
    }

    public final synchronized void g() {
        this.d = true;
        this.g = true;
        this.i = null;
        this.h++;
    }

    public final synchronized void h() {
        try {
            Long l = this.i;
            long j = this.f;
            if (l != null && l.longValue() == j) {
                this.d = true;
            }
            this.i = (this.d || this.g) ? null : Long.valueOf(this.f);
            this.h++;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized Long i() {
        return this.i;
    }

    public final synchronized long j() {
        return this.f;
    }

    public final synchronized gd1 k() {
        return (this.d || cs2.A(this.a)) ? null : new gd1(this.f, this.a);
    }
}
