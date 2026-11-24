package defpackage;

import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.Normalizer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yz2 {
    public static final yz2 d = new yz2(0, 0, null, null, 0, 0, 0, 16777215);
    public final hp2 a;
    public final eu1 b;
    public final cy1 c;

    public yz2(long j, long j2, np0 np0Var, ev2 ev2Var, long j3, int i, long j4, int i2) {
        this(new hp2((i2 & 1) != 0 ? sz.g : j, (i2 & 2) != 0 ? b03.c : j2, (i2 & 4) != 0 ? null : np0Var, null, null, (i2 & 32) != 0 ? null : ev2Var, null, (i2 & 128) != 0 ? b03.c : j3, null, null, null, sz.g, null, null), new eu1((32768 & i2) != 0 ? 0 : i, 0, (i2 & Normalizer.INPUT_IS_FCD) != 0 ? b03.c : j4, null, null, null, 0, 0, null), null);
    }

    public static yz2 a(yz2 yz2Var, long j, long j2, np0 np0Var, ev2 ev2Var, long j3, vj2 vj2Var, long j4, bc1 bc1Var, int i) {
        uy2 f00Var;
        long jC = (i & 1) != 0 ? yz2Var.a.a.c() : j;
        long j5 = (i & 2) != 0 ? yz2Var.a.b : j2;
        np0 np0Var2 = (i & 4) != 0 ? yz2Var.a.c : np0Var;
        hp2 hp2Var = yz2Var.a;
        lp0 lp0Var = hp2Var.d;
        mp0 mp0Var = hp2Var.e;
        ev2 ev2Var2 = (i & 32) != 0 ? hp2Var.f : ev2Var;
        String str = hp2Var.g;
        long j6 = (i & 128) != 0 ? hp2Var.h : j3;
        rk rkVar = hp2Var.i;
        vy2 vy2Var = hp2Var.j;
        ne1 ne1Var = hp2Var.k;
        long j7 = hp2Var.l;
        sx2 sx2Var = hp2Var.m;
        vj2 vj2Var2 = (i & 8192) != 0 ? hp2Var.n : vj2Var;
        wm4 wm4Var = hp2Var.o;
        eu1 eu1Var = yz2Var.b;
        int i2 = eu1Var.a;
        int i3 = eu1Var.b;
        long j8 = (i & Normalizer.INPUT_IS_FCD) != 0 ? eu1Var.c : j4;
        wy2 wy2Var = eu1Var.d;
        cy1 cy1Var = (i & ArabicShaping.TASHKEEL_RESIZE) != 0 ? yz2Var.c : oy3.a;
        bc1 bc1Var2 = (i & 1048576) != 0 ? eu1Var.f : bc1Var;
        int i4 = eu1Var.g;
        int i5 = eu1Var.h;
        lz2 lz2Var = eu1Var.i;
        if (sz.c(jC, hp2Var.a.c())) {
            f00Var = hp2Var.a;
        } else {
            f00Var = jC != 16 ? new f00(jC) : el1.j;
        }
        return new yz2(new hp2(f00Var, j5, np0Var2, lp0Var, mp0Var, ev2Var2, str, j6, rkVar, vy2Var, ne1Var, j7, sx2Var, vj2Var2, wm4Var), new eu1(i2, i3, j8, wy2Var, cy1Var != null ? cy1Var.a : null, bc1Var2, i4, i5, lz2Var), cy1Var);
    }

    public static yz2 e(yz2 yz2Var, long j, long j2, np0 np0Var, ev2 ev2Var, long j3, int i, long j4, int i2) {
        long j5 = (i2 & 2) != 0 ? b03.c : j2;
        np0 np0Var2 = (i2 & 4) != 0 ? null : np0Var;
        ev2 ev2Var2 = (i2 & 32) != 0 ? null : ev2Var;
        long j6 = (i2 & 128) != 0 ? b03.c : j3;
        long j7 = sz.g;
        int i3 = (32768 & i2) != 0 ? 0 : i;
        long j8 = (i2 & Normalizer.INPUT_IS_FCD) != 0 ? b03.c : j4;
        hp2 hp2VarA = ip2.a(yz2Var.a, j, null, Float.NaN, j5, np0Var2, null, null, ev2Var2, null, j6, null, null, null, j7, null, null, null);
        eu1 eu1VarA = fu1.a(yz2Var.b, i3, 0, j8, null, null, null, 0, 0, null);
        return (yz2Var.a == hp2VarA && yz2Var.b == eu1VarA) ? yz2Var : new yz2(hp2VarA, eu1VarA);
    }

    public final long b() {
        return this.a.a.c();
    }

    public final boolean c(yz2 yz2Var) {
        if (this != yz2Var) {
            return g31.a(this.b, yz2Var.b) && this.a.a(yz2Var.a);
        }
        return true;
    }

    public final yz2 d(yz2 yz2Var) {
        return (yz2Var == null || yz2Var.equals(d)) ? this : new yz2(this.a.c(yz2Var.a), this.b.a(yz2Var.b));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yz2)) {
            return false;
        }
        yz2 yz2Var = (yz2) obj;
        return g31.a(this.a, yz2Var.a) && g31.a(this.b, yz2Var.b) && g31.a(this.c, yz2Var.c);
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        cy1 cy1Var = this.c;
        return iHashCode + (cy1Var != null ? cy1Var.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TextStyle(color=");
        sb.append((Object) sz.i(b()));
        sb.append(", brush=");
        hp2 hp2Var = this.a;
        sb.append(hp2Var.a.d());
        sb.append(", alpha=");
        sb.append(hp2Var.a.a());
        sb.append(", fontSize=");
        sb.append((Object) b03.d(hp2Var.b));
        sb.append(", fontWeight=");
        sb.append(hp2Var.c);
        sb.append(", fontStyle=");
        sb.append(hp2Var.d);
        sb.append(", fontSynthesis=");
        sb.append(hp2Var.e);
        sb.append(", fontFamily=");
        sb.append(hp2Var.f);
        sb.append(", fontFeatureSettings=");
        sb.append(hp2Var.g);
        sb.append(", letterSpacing=");
        sb.append((Object) b03.d(hp2Var.h));
        sb.append(", baselineShift=");
        sb.append(hp2Var.i);
        sb.append(", textGeometricTransform=");
        sb.append(hp2Var.j);
        sb.append(", localeList=");
        sb.append(hp2Var.k);
        sb.append(", background=");
        ky0.v(hp2Var.l, sb, ", textDecoration=");
        sb.append(hp2Var.m);
        sb.append(", shadow=");
        sb.append(hp2Var.n);
        sb.append(", drawStyle=");
        sb.append(hp2Var.o);
        sb.append(", textAlign=");
        eu1 eu1Var = this.b;
        sb.append((Object) vw2.a(eu1Var.a));
        sb.append(", textDirection=");
        sb.append((Object) vx2.a(eu1Var.b));
        sb.append(", lineHeight=");
        sb.append((Object) b03.d(eu1Var.c));
        sb.append(", textIndent=");
        sb.append(eu1Var.d);
        sb.append(", platformStyle=");
        sb.append(this.c);
        sb.append(", lineHeightStyle=");
        sb.append(eu1Var.f);
        sb.append(", lineBreak=");
        sb.append((Object) wb1.a(eu1Var.g));
        sb.append(", hyphens=");
        sb.append((Object) iy0.a(eu1Var.h));
        sb.append(", textMotion=");
        sb.append(eu1Var.i);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public yz2(hp2 hp2Var, eu1 eu1Var) {
        hp2Var.getClass();
        nx1 nx1Var = eu1Var.e;
        this(hp2Var, eu1Var, nx1Var == null ? null : new cy1(nx1Var));
    }

    public yz2(hp2 hp2Var, eu1 eu1Var, cy1 cy1Var) {
        this.a = hp2Var;
        this.b = eu1Var;
        this.c = cy1Var;
    }
}
