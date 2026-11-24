package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hp2 implements xd {
    public final uy2 a;
    public final long b;
    public final np0 c;
    public final lp0 d;
    public final mp0 e;
    public final ev2 f;
    public final String g;
    public final long h;
    public final rk i;
    public final vy2 j;
    public final ne1 k;
    public final long l;
    public final sx2 m;
    public final vj2 n;
    public final wm4 o;

    public hp2(long j, long j2, np0 np0Var, lp0 lp0Var, mp0 mp0Var, ev2 ev2Var, String str, long j3, rk rkVar, vy2 vy2Var, ne1 ne1Var, long j4, sx2 sx2Var, vj2 vj2Var, int i) {
        this((i & 1) != 0 ? sz.g : j, (i & 2) != 0 ? b03.c : j2, (i & 4) != 0 ? null : np0Var, (i & 8) != 0 ? null : lp0Var, (i & 16) != 0 ? null : mp0Var, (i & 32) != 0 ? null : ev2Var, (i & 64) != 0 ? null : str, (i & 128) != 0 ? b03.c : j3, (i & 256) != 0 ? null : rkVar, (i & 512) != 0 ? null : vy2Var, (i & 1024) != 0 ? null : ne1Var, (i & 2048) != 0 ? sz.g : j4, (i & 4096) != 0 ? null : sx2Var, (i & 8192) != 0 ? null : vj2Var);
    }

    public final boolean a(hp2 hp2Var) {
        if (this == hp2Var) {
            return true;
        }
        return b03.a(this.b, hp2Var.b) && g31.a(this.c, hp2Var.c) && g31.a(this.d, hp2Var.d) && g31.a(this.e, hp2Var.e) && g31.a(this.f, hp2Var.f) && g31.a(this.g, hp2Var.g) && b03.a(this.h, hp2Var.h) && g31.a(this.i, hp2Var.i) && g31.a(this.j, hp2Var.j) && g31.a(this.k, hp2Var.k) && sz.c(this.l, hp2Var.l);
    }

    public final boolean b(hp2 hp2Var) {
        return g31.a(this.a, hp2Var.a) && g31.a(this.m, hp2Var.m) && g31.a(this.n, hp2Var.n) && g31.a(this.o, hp2Var.o);
    }

    public final hp2 c(hp2 hp2Var) {
        if (hp2Var == null) {
            return this;
        }
        uy2 uy2Var = hp2Var.a;
        return ip2.a(this, uy2Var.c(), uy2Var.d(), uy2Var.a(), hp2Var.b, hp2Var.c, hp2Var.d, hp2Var.e, hp2Var.f, hp2Var.g, hp2Var.h, hp2Var.i, hp2Var.j, hp2Var.k, hp2Var.l, hp2Var.m, hp2Var.n, hp2Var.o);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hp2)) {
            return false;
        }
        hp2 hp2Var = (hp2) obj;
        return a(hp2Var) && b(hp2Var);
    }

    public final int hashCode() {
        uy2 uy2Var = this.a;
        long jC = uy2Var.c();
        int i = sz.h;
        int iHashCode = Long.hashCode(jC) * 31;
        hn hnVarD = uy2Var.d();
        int iHashCode2 = (Float.hashCode(uy2Var.a()) + ((iHashCode + (hnVarD != null ? hnVarD.hashCode() : 0)) * 31)) * 31;
        c03[] c03VarArr = b03.b;
        int iC = cq.c(iHashCode2, 31, this.b);
        np0 np0Var = this.c;
        int i2 = (iC + (np0Var != null ? np0Var.a : 0)) * 31;
        lp0 lp0Var = this.d;
        int iHashCode3 = (i2 + (lp0Var != null ? Integer.hashCode(lp0Var.a) : 0)) * 31;
        mp0 mp0Var = this.e;
        int iHashCode4 = (iHashCode3 + (mp0Var != null ? Integer.hashCode(mp0Var.a) : 0)) * 31;
        ev2 ev2Var = this.f;
        int iHashCode5 = (iHashCode4 + (ev2Var != null ? ev2Var.hashCode() : 0)) * 31;
        String str = this.g;
        int iC2 = cq.c((iHashCode5 + (str != null ? str.hashCode() : 0)) * 31, 31, this.h);
        rk rkVar = this.i;
        int iHashCode6 = (iC2 + (rkVar != null ? Float.hashCode(rkVar.a) : 0)) * 31;
        vy2 vy2Var = this.j;
        int iHashCode7 = (iHashCode6 + (vy2Var != null ? vy2Var.hashCode() : 0)) * 31;
        ne1 ne1Var = this.k;
        int iC3 = cq.c((iHashCode7 + (ne1Var != null ? ne1Var.a.hashCode() : 0)) * 31, 31, this.l);
        sx2 sx2Var = this.m;
        int i3 = (iC3 + (sx2Var != null ? sx2Var.a : 0)) * 31;
        vj2 vj2Var = this.n;
        int iHashCode8 = (i3 + (vj2Var != null ? vj2Var.hashCode() : 0)) * 961;
        wm4 wm4Var = this.o;
        return iHashCode8 + (wm4Var != null ? wm4Var.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SpanStyle(color=");
        uy2 uy2Var = this.a;
        sb.append((Object) sz.i(uy2Var.c()));
        sb.append(", brush=");
        sb.append(uy2Var.d());
        sb.append(", alpha=");
        sb.append(uy2Var.a());
        sb.append(", fontSize=");
        sb.append((Object) b03.d(this.b));
        sb.append(", fontWeight=");
        sb.append(this.c);
        sb.append(", fontStyle=");
        sb.append(this.d);
        sb.append(", fontSynthesis=");
        sb.append(this.e);
        sb.append(", fontFamily=");
        sb.append(this.f);
        sb.append(", fontFeatureSettings=");
        sb.append(this.g);
        sb.append(", letterSpacing=");
        sb.append((Object) b03.d(this.h));
        sb.append(", baselineShift=");
        sb.append(this.i);
        sb.append(", textGeometricTransform=");
        sb.append(this.j);
        sb.append(", localeList=");
        sb.append(this.k);
        sb.append(", background=");
        ky0.v(this.l, sb, ", textDecoration=");
        sb.append(this.m);
        sb.append(", shadow=");
        sb.append(this.n);
        sb.append(", platformStyle=null, drawStyle=");
        sb.append(this.o);
        sb.append(')');
        return sb.toString();
    }

    public hp2(uy2 uy2Var, long j, np0 np0Var, lp0 lp0Var, mp0 mp0Var, ev2 ev2Var, String str, long j2, rk rkVar, vy2 vy2Var, ne1 ne1Var, long j3, sx2 sx2Var, vj2 vj2Var, wm4 wm4Var) {
        this.a = uy2Var;
        this.b = j;
        this.c = np0Var;
        this.d = lp0Var;
        this.e = mp0Var;
        this.f = ev2Var;
        this.g = str;
        this.h = j2;
        this.i = rkVar;
        this.j = vy2Var;
        this.k = ne1Var;
        this.l = j3;
        this.m = sx2Var;
        this.n = vj2Var;
        this.o = wm4Var;
    }

    public hp2(long j, long j2, np0 np0Var, lp0 lp0Var, mp0 mp0Var, ev2 ev2Var, String str, long j3, rk rkVar, vy2 vy2Var, ne1 ne1Var, long j4, sx2 sx2Var, vj2 vj2Var) {
        this(j != 16 ? new f00(j) : el1.j, j2, np0Var, lp0Var, mp0Var, ev2Var, str, j3, rkVar, vy2Var, ne1Var, j4, sx2Var, vj2Var, (wm4) null);
    }
}
