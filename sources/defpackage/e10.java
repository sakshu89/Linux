package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e10 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ n10 b;

    public /* synthetic */ e10(n10 n10Var, int i) {
        this.a = i;
        this.b = n10Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        n10 n10Var = this.b;
        switch (i) {
            case 0:
                n10Var.invalidateOptionsMenu();
                break;
            default:
                n10.d(n10Var);
                break;
        }
    }
}
