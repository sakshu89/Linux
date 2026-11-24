package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class h40 extends i40 {
    public final y72 e;
    public final y72 f;
    public final float[] g;

    public h40(y72 y72Var, y72 y72Var2) {
        float[] fArrF;
        super(y72Var2, y72Var, y72Var2, null);
        this.e = y72Var;
        this.f = y72Var2;
        float[] fArr = o4.c.b;
        ka3 ka3Var = y72Var.d;
        float[] fArr2 = y72Var.i;
        ka3 ka3Var2 = y72Var2.d;
        float[] fArr3 = y72Var2.j;
        if (oi4.c(ka3Var, ka3Var2)) {
            fArrF = oi4.f(fArr3, fArr2);
        } else {
            float[] fArrA = ka3Var.a();
            float[] fArrA2 = ka3Var2.a();
            ka3 ka3Var3 = qz3.b;
            fArrF = oi4.f(oi4.c(ka3Var2, ka3Var3) ? fArr3 : oi4.e(oi4.f(oi4.b(fArr, fArrA2, new float[]{0.964212f, 1.0f, 0.825188f}), y72Var2.i)), oi4.c(ka3Var, ka3Var3) ? fArr2 : oi4.f(oi4.b(fArr, fArrA, new float[]{0.964212f, 1.0f, 0.825188f}), fArr2));
        }
        this.g = fArrF;
    }

    @Override // defpackage.i40
    public final long a(long j) {
        float fH = sz.h(j);
        float fG = sz.g(j);
        float fE = sz.e(j);
        float fD = sz.d(j);
        u72 u72Var = this.e.p;
        float fC = (float) u72Var.c(fH);
        float fC2 = (float) u72Var.c(fG);
        float fC3 = (float) u72Var.c(fE);
        float[] fArr = this.g;
        float f = (fArr[6] * fC3) + (fArr[3] * fC2) + (fArr[0] * fC);
        float f2 = (fArr[7] * fC3) + (fArr[4] * fC2) + (fArr[1] * fC);
        float f3 = (fArr[8] * fC3) + (fArr[5] * fC2) + (fArr[2] * fC);
        y72 y72Var = this.f;
        float fC4 = (float) y72Var.m.c(f);
        u72 u72Var2 = y72Var.m;
        return ki4.a(fC4, (float) u72Var2.c(f2), (float) u72Var2.c(f3), fD, y72Var);
    }
}
