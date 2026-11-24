package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cb0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ tp b;

    public /* synthetic */ cb0(tp tpVar, int i) {
        this.a = i;
        this.b = tpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        tp tpVar = this.b;
        switch (i) {
            case 0:
                tpVar.b(new Exception("Failed to snapshot: OpenGLRenderer not ready."));
                break;
            default:
                tpVar.a(null);
                break;
        }
    }
}
