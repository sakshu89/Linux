package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class kv2 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ lv2 b;

    public /* synthetic */ kv2(lv2 lv2Var, int i) {
        this.a = i;
        this.b = lv2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        lv2 lv2Var = this.b;
        switch (i) {
            case 0:
                lv2Var.e = null;
                lv2Var.b();
                break;
            default:
                lv2Var.b();
                break;
        }
    }
}
