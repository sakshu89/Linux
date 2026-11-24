package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nt2 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ rt2 b;

    public /* synthetic */ nt2(rt2 rt2Var, int i) {
        this.a = i;
        this.b = rt2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        rt2 rt2Var = this.b;
        switch (i) {
            case 0:
                rt2Var.a();
                break;
            case 1:
                rt2Var.b();
                break;
            default:
                xt2 xt2Var = rt2Var.r;
                if (xt2Var != null) {
                    xt2Var.j();
                }
                if (rt2Var.q == null) {
                    tp tpVar = rt2Var.p;
                    tpVar.d = true;
                    wp wpVar = tpVar.b;
                    if (wpVar != null && wpVar.b.cancel(true)) {
                        tpVar.a = null;
                        tpVar.b = null;
                        tpVar.c = null;
                        break;
                    }
                }
                break;
        }
    }
}
