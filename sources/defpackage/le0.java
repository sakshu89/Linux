package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class le0 extends dk1 implements t23, w61 {
    public le0 H;
    public long X;
    public le0 x;

    @Override // defpackage.dk1
    public final void B0() {
        this.H = null;
        this.x = null;
    }

    public final boolean I0() {
        le0 le0Var = this.x;
        if (le0Var != null) {
            return le0Var.I0();
        }
        le0 le0Var2 = this.H;
        if (le0Var2 != null) {
            return le0Var2.I0();
        }
        return false;
    }

    public final void J0() {
        le0 le0Var = this.H;
        if (le0Var != null) {
            le0Var.J0();
            return;
        }
        le0 le0Var2 = this.x;
        if (le0Var2 != null) {
            le0Var2.J0();
        }
    }

    public final void K0() {
        le0 le0Var = this.H;
        if (le0Var != null) {
            le0Var.K0();
        }
        le0 le0Var2 = this.x;
        if (le0Var2 != null) {
            le0Var2.K0();
        }
        this.x = null;
    }

    public final void L0(q82 q82Var) {
        t23 t23Var;
        le0 le0Var;
        le0 le0Var2 = this.x;
        if (le0Var2 == null || !km4.a(le0Var2, lm4.a(q82Var))) {
            if (this.a.w) {
                t42 t42Var = new t42();
                jd4.e(this, new ke0(t42Var, this, q82Var, 0));
                t23Var = (t23) t42Var.a;
            } else {
                t23Var = null;
            }
            le0Var = (le0) t23Var;
        } else {
            le0Var = le0Var2;
        }
        if (le0Var != null && le0Var2 == null) {
            le0Var.J0();
            le0Var.L0(q82Var);
            le0 le0Var3 = this.H;
            if (le0Var3 != null) {
                le0Var3.K0();
            }
        } else if (le0Var == null && le0Var2 != null) {
            le0 le0Var4 = this.H;
            if (le0Var4 != null) {
                le0Var4.J0();
                le0Var4.L0(q82Var);
            }
            le0Var2.K0();
        } else if (!g31.a(le0Var, le0Var2)) {
            if (le0Var != null) {
                le0Var.J0();
                le0Var.L0(q82Var);
            }
            if (le0Var2 != null) {
                le0Var2.K0();
            }
        } else if (le0Var != null) {
            le0Var.L0(q82Var);
        } else {
            le0 le0Var5 = this.H;
            if (le0Var5 != null) {
                le0Var5.L0(q82Var);
            }
        }
        this.x = le0Var;
    }

    public final void M0() {
        le0 le0Var = this.H;
        if (le0Var != null) {
            le0Var.M0();
            return;
        }
        le0 le0Var2 = this.x;
        if (le0Var2 != null) {
            le0Var2.M0();
        }
    }

    @Override // defpackage.t23
    public final Object p() {
        return y74.c;
    }

    @Override // defpackage.w61
    public final void r(long j) {
        this.X = j;
    }
}
