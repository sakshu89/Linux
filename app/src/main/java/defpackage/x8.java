package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x8 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;

    public /* synthetic */ x8(int i, long j) {
        this.a = i;
        this.b = j;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        yv yvVar;
        Object h72Var;
        int i = this.a;
        long j = this.b;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                so soVar = (so) obj;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (soVar.a.c() >> 32)) / 2.0f;
                return soVar.a(new y8(fIntBitsToFloat, vd4.d(soVar, fIntBitsToFloat), new nl(5, j), 0));
            case 1:
                fn fnVar = (fn) obj;
                hq0 hq0Var = fnVar.b;
                if (hq0Var != null && (yvVar = fnVar.a) != null) {
                    try {
                        h72Var = hq0Var.j(Long.valueOf(j));
                    } catch (Throwable th) {
                        h72Var = new h72(th);
                    }
                    yvVar.h(h72Var);
                    break;
                }
                return q43Var;
            default:
                ((og2) obj).a(wf2.a, new vf2(pv0.a, this.b, uf2.b, true));
                return q43Var;
        }
    }
}
