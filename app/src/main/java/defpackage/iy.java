package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class iy extends ik1 {
    public final ol1 a;
    public final c01 b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final m82 f;
    public final fq0 g;

    public iy(ol1 ol1Var, c01 c01Var, boolean z, boolean z2, String str, m82 m82Var, fq0 fq0Var) {
        this.a = ol1Var;
        this.b = c01Var;
        this.c = z;
        this.d = z2;
        this.e = str;
        this.f = m82Var;
        this.g = fq0Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        return new ky(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || iy.class != obj.getClass()) {
            return false;
        }
        iy iyVar = (iy) obj;
        return g31.a(this.a, iyVar.a) && g31.a(this.b, iyVar.b) && this.c == iyVar.c && this.d == iyVar.d && g31.a(this.e, iyVar.e) && g31.a(this.f, iyVar.f) && this.g == iyVar.g;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0085  */
    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        boolean z;
        boolean z2;
        xb0 xb0Var;
        ky kyVar = (ky) dk1Var;
        no0 no0Var = kyVar.g0;
        ol1 ol1Var = kyVar.o0;
        ol1 ol1Var2 = this.a;
        if (g31.a(ol1Var, ol1Var2)) {
            z = false;
        } else {
            kyVar.L0();
            kyVar.o0 = ol1Var2;
            kyVar.X = ol1Var2;
            z = true;
        }
        c01 c01Var = kyVar.Y;
        c01 c01Var2 = this.b;
        if (!g31.a(c01Var, c01Var2)) {
            kyVar.Y = c01Var2;
            z = true;
        }
        boolean z3 = kyVar.Z;
        boolean z4 = this.c;
        if (z3 != z4) {
            kyVar.Z = z4;
            if (z4) {
                kyVar.J();
            }
            z = true;
        }
        boolean z5 = kyVar.e0;
        boolean z6 = this.d;
        if (z5 != z6) {
            if (z6) {
                kyVar.I0(no0Var);
            } else {
                kyVar.J0(no0Var);
                kyVar.L0();
            }
            a34.a(kyVar);
            kyVar.e0 = z6;
        }
        String str = kyVar.c0;
        String str2 = this.e;
        if (!g31.a(str, str2)) {
            kyVar.c0 = str2;
            a34.a(kyVar);
        }
        m82 m82Var = kyVar.d0;
        m82 m82Var2 = this.f;
        if (!g31.a(m82Var, m82Var2)) {
            kyVar.d0 = m82Var2;
            a34.a(kyVar);
        }
        kyVar.f0 = this.g;
        boolean z7 = kyVar.p0;
        ol1 ol1Var3 = kyVar.o0;
        if (z7 != (ol1Var3 == null)) {
            boolean z8 = ol1Var3 == null;
            kyVar.p0 = z8;
            z2 = (z8 || kyVar.i0 != null) ? z : true;
        }
        if (z2 && ((xb0Var = kyVar.i0) != null || !kyVar.p0)) {
            if (xb0Var != null) {
                kyVar.J0(xb0Var);
            }
            kyVar.i0 = null;
            kyVar.P0();
        }
        no0Var.N0(kyVar.X);
    }

    public final int hashCode() {
        ol1 ol1Var = this.a;
        int iHashCode = (ol1Var != null ? ol1Var.hashCode() : 0) * 31;
        c01 c01Var = this.b;
        int iE = ky0.e(ky0.e((iHashCode + (c01Var != null ? c01Var.hashCode() : 0)) * 31, 31, this.c), 31, this.d);
        String str = this.e;
        return this.g.hashCode() + ((((iE + (str != null ? str.hashCode() : 0)) * 31) + (this.f != null ? Integer.hashCode(0) : 0)) * 31);
    }
}
