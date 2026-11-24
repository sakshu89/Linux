package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class db0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ fu2 b;

    public /* synthetic */ db0(fu2 fu2Var, int i) {
        this.a = i;
        this.b = fu2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        fu2 fu2Var = this.b;
        switch (i) {
            case 0:
                fu2Var.c();
                break;
            default:
                fu2Var.f.cancel(true);
                break;
        }
    }
}
