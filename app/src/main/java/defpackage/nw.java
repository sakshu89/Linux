package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nw implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ m92 b;

    public /* synthetic */ nw(m92 m92Var, int i) {
        this.a = i;
        this.b = m92Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        m92 m92Var = this.b;
        switch (i) {
            case 0:
                m92Var.c();
                break;
            case 1:
                if (m92Var != null) {
                    m92Var.c();
                }
                break;
            default:
                m92Var.c();
                break;
        }
    }
}
