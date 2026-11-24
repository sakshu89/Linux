package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ot2 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ ob0 b;

    public /* synthetic */ ot2(ob0 ob0Var, int i) {
        this.a = i;
        this.b = ob0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        ob0 ob0Var = this.b;
        switch (i) {
            case 0:
                ob0Var.a();
                break;
            default:
                ob0Var.b();
                break;
        }
    }
}
