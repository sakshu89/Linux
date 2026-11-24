package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m4 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ fq0 b;

    public /* synthetic */ m4(fq0 fq0Var, int i) {
        this.a = i;
        this.b = fq0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        fq0 fq0Var = this.b;
        switch (i) {
            case 0:
                fq0Var.a();
                break;
            case 1:
                fq0Var.a();
                break;
            case 2:
                fq0Var.a();
                break;
            case 3:
                fq0Var.a();
                break;
            default:
                if (fq0Var != null) {
                    fq0Var.a();
                }
                break;
        }
    }
}
