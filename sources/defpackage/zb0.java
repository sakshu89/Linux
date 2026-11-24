package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class zb0 extends dk1 {
    public dk1 H;
    public final int x = do1.e(this);

    @Override // defpackage.dk1
    public final void D0() {
        super.D0();
        for (dk1 dk1Var = this.H; dk1Var != null; dk1Var = dk1Var.i) {
            dk1Var.D0();
        }
    }

    @Override // defpackage.dk1
    public final void E0() {
        for (dk1 dk1Var = this.H; dk1Var != null; dk1Var = dk1Var.i) {
            dk1Var.E0();
        }
        super.E0();
    }

    @Override // defpackage.dk1
    public final void F0() {
        super.F0();
        for (dk1 dk1Var = this.H; dk1Var != null; dk1Var = dk1Var.i) {
            dk1Var.F0();
        }
    }

    @Override // defpackage.dk1
    public final void G0(dk1 dk1Var) {
        this.a = dk1Var;
        for (dk1 dk1Var2 = this.H; dk1Var2 != null; dk1Var2 = dk1Var2.i) {
            dk1Var2.G0(dk1Var);
        }
    }

    @Override // defpackage.dk1
    public final void H0(co1 co1Var) {
        this.k = co1Var;
        for (dk1 dk1Var = this.H; dk1Var != null; dk1Var = dk1Var.i) {
            dk1Var.H0(co1Var);
        }
    }

    public final xb0 I0(xb0 xb0Var) {
        dk1 dk1Var = ((dk1) xb0Var).a;
        if (dk1Var != xb0Var) {
            dk1 dk1Var2 = xb0Var instanceof dk1 ? (dk1) xb0Var : null;
            dk1 dk1Var3 = dk1Var2 != null ? dk1Var2.f : null;
            if (dk1Var != this.a || !g31.a(dk1Var3, this)) {
                og.n("Cannot delegate to an already delegated node");
                return null;
            }
        } else {
            if (dk1Var.w) {
                z01.b("Cannot delegate to an already attached node");
            }
            dk1Var.G0(this.a);
            int i = this.c;
            int iF = do1.f(dk1Var);
            dk1Var.c = iF;
            int i2 = this.c;
            int i3 = iF & 2;
            if (i3 != 0 && (i2 & 2) != 0 && !(this instanceof f71)) {
                z01.b("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + dk1Var);
            }
            dk1Var.i = this.H;
            this.H = dk1Var;
            dk1Var.f = this;
            K0(iF | this.c, false);
            if (this.w) {
                if (i3 == 0 || (i & 2) != 0) {
                    H0(this.k);
                } else {
                    zn1 zn1Var = cm4.g(this).o0;
                    this.a.H0(null);
                    zn1Var.g();
                }
                dk1Var.y0();
                dk1Var.E0();
                if (!dk1Var.w) {
                    z01.b("autoInvalidateInsertedNode called on unattached node");
                }
                do1.a(dk1Var, -1, 1);
            }
        }
        return xb0Var;
    }

    public final void J0(xb0 xb0Var) {
        dk1 dk1Var = null;
        for (dk1 dk1Var2 = this.H; dk1Var2 != null; dk1Var2 = dk1Var2.i) {
            if (dk1Var2 == xb0Var) {
                boolean z = dk1Var2.w;
                if (z) {
                    ul1 ul1Var = do1.a;
                    if (!z) {
                        z01.b("autoInvalidateRemovedNode called on unattached node");
                    }
                    do1.a(dk1Var2, -1, 2);
                    dk1Var2.F0();
                    dk1Var2.z0();
                }
                dk1Var2.G0(dk1Var2);
                dk1Var2.e = 0;
                dk1 dk1Var3 = dk1Var2.i;
                if (dk1Var == null) {
                    this.H = dk1Var3;
                } else {
                    dk1Var.i = dk1Var3;
                }
                dk1Var2.i = null;
                dk1Var2.f = null;
                int i = this.c;
                int iF = do1.f(this);
                K0(iF, true);
                if (this.w && (i & 2) != 0 && (iF & 2) == 0) {
                    zn1 zn1Var = cm4.g(this).o0;
                    this.a.H0(null);
                    zn1Var.g();
                    return;
                }
                return;
            }
            dk1Var = dk1Var2;
        }
        og.h(xb0Var, "Could not find delegate: ");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [dk1] */
    /* JADX WARN: Type inference failed for: r2v2, types: [dk1] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final void K0(int i, boolean z) {
        dk1 dk1Var;
        int i2 = this.c;
        this.c = i;
        if (i2 != i) {
            dk1 dk1Var2 = this.a;
            if (dk1Var2 == this) {
                this.e = i;
            }
            boolean z2 = this.w;
            ?? r2 = this;
            if (z2) {
                while (r2 != 0) {
                    i |= r2.c;
                    r2.c = i;
                    if (r2 == dk1Var2) {
                        break;
                    } else {
                        r2 = r2.f;
                    }
                }
                if (z && r2 == dk1Var2) {
                    i = do1.f(dk1Var2);
                    dk1Var2.c = i;
                }
                int i3 = i | ((r2 == 0 || (dk1Var = r2.i) == null) ? 0 : dk1Var.e);
                for (?? r3 = r2; r3 != 0; r3 = r3.f) {
                    i3 |= r3.c;
                    r3.e = i3;
                }
            }
        }
    }

    @Override // defpackage.dk1
    public final void y0() {
        super.y0();
        for (dk1 dk1Var = this.H; dk1Var != null; dk1Var = dk1Var.i) {
            dk1Var.H0(this.k);
            if (!dk1Var.w) {
                dk1Var.y0();
            }
        }
    }

    @Override // defpackage.dk1
    public final void z0() {
        for (dk1 dk1Var = this.H; dk1Var != null; dk1Var = dk1Var.i) {
            dk1Var.z0();
        }
        super.z0();
    }
}
