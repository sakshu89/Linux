package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ex extends dx {
    public final mm0 e;

    public ex(mm0 mm0Var, j70 j70Var, int i, nn nnVar) {
        super(j70Var, i, nnVar);
        this.e = mm0Var;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006e  */
    /* JADX WARN: Code duplicated, block: B:26:0x0074 A[RETURN] */
    @Override // defpackage.dx, defpackage.mm0
    public final Object a(nm0 nm0Var, x50 x50Var) {
        Object objA;
        int i = this.b;
        t70 t70Var = t70.a;
        if (i == -3) {
            j70 j70VarF = x50Var.f();
            Boolean bool = Boolean.FALSE;
            ag agVar = new ag(5);
            j70 j70Var = this.a;
            j70 j70VarR = !((Boolean) j70Var.y(agVar, bool)).booleanValue() ? j70VarF.r(j70Var) : ql4.a(j70VarF, j70Var, false);
            if (g31.a(j70VarR, j70VarF)) {
                Object objH = h(nm0Var, x50Var);
                if (objH == t70Var) {
                    return objH;
                }
            } else {
                qs4 qs4Var = qs4.c;
                if (g31.a(j70VarR.v(qs4Var), j70VarF.v(qs4Var))) {
                    j70 j70VarF2 = x50Var.f();
                    if (!(nm0Var instanceof wg2) && !(nm0Var instanceof lo1)) {
                        nm0Var = new gd(nm0Var, j70VarF2);
                    }
                    Object objA2 = lh4.a(j70VarR, nm0Var, ab4.d(j70VarR), new p0(this, null, 10), x50Var);
                    if (objA2 == t70Var) {
                        return objA2;
                    }
                } else {
                    objA = super.a(nm0Var, x50Var);
                    if (objA == t70Var) {
                        return objA;
                    }
                }
            }
        } else {
            objA = super.a(nm0Var, x50Var);
            if (objA == t70Var) {
                return objA;
            }
        }
        return q43.a;
    }

    @Override // defpackage.dx
    public final Object d(j12 j12Var, x50 x50Var) {
        Object objH = h(new wg2(j12Var), x50Var);
        return objH == t70.a ? objH : q43.a;
    }

    public abstract Object h(nm0 nm0Var, x50 x50Var);

    @Override // defpackage.dx
    public final String toString() {
        return this.e + " -> " + super.toString();
    }
}
