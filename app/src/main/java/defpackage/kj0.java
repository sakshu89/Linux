package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kj0 extends mj0 {
    public final yv c;
    public final /* synthetic */ oj0 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kj0(oj0 oj0Var, long j, yv yvVar) {
        super(j);
        this.e = oj0Var;
        this.c = yvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.H(this.e);
    }

    @Override // defpackage.mj0
    public final String toString() {
        return super.toString() + this.c;
    }
}
