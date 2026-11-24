package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nf1 extends yw1 {
    public final /* synthetic */ int b;
    public final Object c;

    public /* synthetic */ nf1(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    @Override // defpackage.jc0
    public final float b() {
        int i = this.b;
        Object obj = this.c;
        switch (i) {
            case 0:
                return ((mf1) obj).b();
            default:
                return ((r7) obj).getDensity().b();
        }
    }

    @Override // defpackage.yw1
    public float d(tw0 tw0Var) {
        float fIntBitsToFloat;
        int iQ;
        switch (this.b) {
            case 0:
                vq0 vq0Var = tw0Var.a;
                if (vq0Var != null) {
                    return ((Number) vq0Var.e(this, Float.valueOf(Float.NaN))).floatValue();
                }
                mf1 mf1Var = (mf1) this.c;
                if (mf1Var.t) {
                    return Float.NaN;
                }
                mf1 mf1Var2 = mf1Var;
                while (true) {
                    we weVar = mf1Var2.v;
                    float f = (weVar == null || (iQ = qg.q((tw0[]) weVar.b, tw0Var)) < 0) ? Float.NaN : ((float[]) weVar.c)[iQ];
                    if (!Float.isNaN(f)) {
                        mf1Var2.s0(mf1Var.C0(), tw0Var);
                        y61 y61VarA0 = mf1Var2.A0();
                        y61 y61VarA1 = mf1Var.A0();
                        switch (tw0Var.b) {
                            case 0:
                                fIntBitsToFloat = Float.intBitsToFloat((int) (y61VarA1.u(y61VarA0, (((long) Float.floatToRawIntBits(f)) & 4294967295L) | (((long) Float.floatToRawIntBits(((int) (y61VarA0.S() >> 32)) / 2.0f)) << 32)) & 4294967295L));
                                break;
                            default:
                                fIntBitsToFloat = Float.intBitsToFloat((int) (y61VarA1.u(y61VarA0, (((long) Float.floatToRawIntBits(f)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(((int) (y61VarA0.S() & 4294967295L)) / 2.0f)))) >> 32));
                                break;
                        }
                        return fIntBitsToFloat;
                    }
                    mf1 mf1VarE0 = mf1Var2.E0();
                    if (mf1VarE0 == null) {
                        mf1Var2.s0(mf1Var.C0(), tw0Var);
                        return Float.NaN;
                    }
                    mf1Var2 = mf1VarE0;
                }
                break;
            default:
                return super.d(tw0Var);
        }
    }

    @Override // defpackage.yw1
    public final z61 e() {
        int i = this.b;
        Object obj = this.c;
        switch (i) {
            case 0:
                return ((mf1) obj).getLayoutDirection();
            default:
                return ((r7) obj).getLayoutDirection();
        }
    }

    @Override // defpackage.yw1
    public final int f() {
        int i = this.b;
        Object obj = this.c;
        switch (i) {
            case 0:
                return ((mf1) obj).i0();
            default:
                return ((r7) obj).getRoot().p0.p.a;
        }
    }

    @Override // defpackage.jc0
    public final float l() {
        int i = this.b;
        Object obj = this.c;
        switch (i) {
            case 0:
                return ((mf1) obj).l();
            default:
                return ((r7) obj).getDensity().l();
        }
    }
}
