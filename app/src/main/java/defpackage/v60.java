package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v60 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ny2 b;

    public /* synthetic */ v60(ny2 ny2Var, int i) {
        this.a = i;
        this.b = ny2Var;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0120  */
    @Override // defpackage.hq0
    public final Object j(Object obj) {
        l42 l42Var;
        y61 y61VarC;
        char c;
        float fIntBitsToFloat;
        y61 y61VarC2;
        y61 y61VarC3;
        y61 y61VarC4;
        y61 y61VarC5;
        int i = this.a;
        ny2 ny2Var = this.b;
        switch (i) {
            case 0:
                return new g8(5, ny2Var);
            case 1:
                ny2Var.r();
                return q43.a;
            default:
                y61 y61Var = (y61) obj;
                ua1 ua1Var = ny2Var.d;
                l42 l42Var2 = l42.e;
                if (ua1Var == null) {
                    l42Var = l42Var2;
                } else {
                    if (ua1Var.p) {
                        ua1Var = null;
                    }
                    if (ua1Var != null) {
                        mp1 mp1Var = ny2Var.b;
                        long j = ny2Var.n().b;
                        int i2 = oz2.c;
                        int iL = mp1Var.l((int) (j >> 32));
                        int iL2 = ny2Var.b.l((int) (ny2Var.n().b & 4294967295L));
                        ua1 ua1Var2 = ny2Var.d;
                        long jU = 0;
                        long jU2 = (ua1Var2 == null || (y61VarC5 = ua1Var2.c()) == null) ? 0L : y61VarC5.U(ny2Var.l(true));
                        ua1 ua1Var3 = ny2Var.d;
                        if (ua1Var3 != null && (y61VarC4 = ua1Var3.c()) != null) {
                            jU = y61VarC4.U(ny2Var.l(false));
                        }
                        ua1 ua1Var4 = ny2Var.d;
                        float fIntBitsToFloat2 = 0.0f;
                        if (ua1Var4 == null || (y61VarC3 = ua1Var4.c()) == null) {
                            c = ' ';
                            fIntBitsToFloat = 0.0f;
                        } else {
                            hz2 hz2VarD = ua1Var.d();
                            c = ' ';
                            fIntBitsToFloat = Float.intBitsToFloat((int) (y61VarC3.U((((long) Float.floatToRawIntBits(hz2VarD != null ? hz2VarD.a.c(iL).b : 0.0f)) & 4294967295L) | (((long) Float.floatToRawIntBits(0.0f)) << 32)) & 4294967295L));
                        }
                        ua1 ua1Var5 = ny2Var.d;
                        if (ua1Var5 != null && (y61VarC2 = ua1Var5.c()) != null) {
                            hz2 hz2VarD2 = ua1Var.d();
                            fIntBitsToFloat2 = Float.intBitsToFloat((int) (y61VarC2.U((((long) Float.floatToRawIntBits(0.0f)) << c) | (((long) Float.floatToRawIntBits(hz2VarD2 != null ? hz2VarD2.a.c(iL2).b : 0.0f)) & 4294967295L)) & 4294967295L));
                        }
                        int i3 = (int) (jU2 >> c);
                        int i4 = (int) (jU >> c);
                        l42Var = new l42(Math.min(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4)), Math.min(fIntBitsToFloat, fIntBitsToFloat2), Math.max(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4)), (ua1Var.a.g.b() * 25.0f) + Math.max(Float.intBitsToFloat((int) (jU2 & 4294967295L)), Float.intBitsToFloat((int) (jU & 4294967295L))));
                    } else {
                        l42Var = l42Var2;
                    }
                }
                ua1 ua1Var6 = ny2Var.d;
                if (ua1Var6 == null || (y61VarC = ua1Var6.c()) == null) {
                    return null;
                }
                return (y61VarC.B() && y61Var.B()) ? ry3.a(y61Var.u(pp4.c(y61VarC), l42Var.d()), l42Var.c()) : l42Var2;
        }
    }
}
