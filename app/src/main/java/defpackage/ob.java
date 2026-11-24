package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ob implements hq0 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Object e;

    public /* synthetic */ ob(op1 op1Var, boolean z, boolean z2) {
        this.e = op1Var;
        this.b = z;
        this.c = z2;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0054  */
    @Override // defpackage.hq0
    public final Object j(Object obj) {
        long jC;
        long j;
        float fSin;
        int i = this.a;
        q43 q43Var = q43.a;
        Object obj2 = this.e;
        boolean z = this.c;
        boolean z2 = this.b;
        switch (i) {
            case 0:
                og2 og2Var = (og2) obj;
                long jA = ((op1) obj2).a();
                og2Var.a(wf2.a, new vf2(z2 ? pv0.b : pv0.c, jA, z ? uf2.a : uf2.c, (9223372034707292159L & jA) != 9205357640488583168L));
                break;
            default:
                gr2 gr2Var = (gr2) obj2;
                rf0 rf0Var = (rf0) obj;
                rf0Var.getClass();
                if (z2) {
                    if (z) {
                        j = 4278250932L;
                    } else {
                        jC = uz.t;
                    }
                    long j2 = jC;
                    if (z || !z2) {
                        fSin = 0.8f;
                    } else {
                        fSin = (((((float) Math.sin(((Number) gr2Var.getValue()).floatValue() * 2.1f)) + 1.0f) / 2.0f) * 0.35f) + 0.65f;
                    }
                    rf0.P(rf0Var, sz.b(0.16f * fSin, j2), Float.intBitsToFloat((int) (rf0Var.c() >> 32)), 0L, 0.0f, 124);
                    rf0.P(rf0Var, sz.b(fSin, j2), Float.intBitsToFloat((int) (rf0Var.c() >> 32)) * 0.37f, 0L, 0.0f, 124);
                } else {
                    j = 4284866559L;
                }
                jC = ki4.c(j);
                long j3 = jC;
                if (z) {
                    fSin = 0.8f;
                } else {
                    fSin = 0.8f;
                }
                rf0.P(rf0Var, sz.b(0.16f * fSin, j3), Float.intBitsToFloat((int) (rf0Var.c() >> 32)), 0L, 0.0f, 124);
                rf0.P(rf0Var, sz.b(fSin, j3), Float.intBitsToFloat((int) (rf0Var.c() >> 32)) * 0.37f, 0L, 0.0f, 124);
                break;
        }
        return q43Var;
    }

    public /* synthetic */ ob(boolean z, boolean z2, gu1 gu1Var) {
        this.b = z;
        this.c = z2;
        this.e = gu1Var;
    }
}
