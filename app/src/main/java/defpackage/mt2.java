package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mt2 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ st2 b;

    public /* synthetic */ mt2(st2 st2Var, int i) {
        this.a = i;
        this.b = st2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        st2 st2Var = this.b;
        switch (i) {
            case 0:
                xg4.c().execute(new mt2(st2Var, 1));
                break;
            default:
                if (!st2Var.n) {
                    st2Var.d();
                }
                break;
        }
    }
}
