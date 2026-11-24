package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class au2 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ eu2 b;
    public final /* synthetic */ lj c;

    public /* synthetic */ au2(eu2 eu2Var, lj ljVar, int i) {
        this.a = i;
        this.b = eu2Var;
        this.c = ljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        lj ljVar = this.c;
        eu2 eu2Var = this.b;
        switch (i) {
            case 0:
                eu2Var.b(ljVar);
                break;
            default:
                eu2Var.b(ljVar);
                break;
        }
    }
}
