package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pr {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ pr(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final void a() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                xq4.c(3, "Camera2CapturePipeline");
                ((tp) obj).a(null);
                return;
            default:
                sb2 sb2Var = (sb2) obj;
                synchronized (sb2Var.b) {
                    try {
                        if (sb2Var.d == null) {
                            xq4.d("ScreenFlashWrapper", "apply: pendingListener is null!");
                        }
                        sb2Var.c();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }
}
