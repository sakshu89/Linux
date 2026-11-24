package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pt0 extends y50 {
    public long e;
    public long f;
    public String i;
    public Object j;
    public /* synthetic */ Object k;
    public final /* synthetic */ tt0 n;
    public int s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pt0(tt0 tt0Var, y50 y50Var) {
        super(y50Var);
        this.n = tt0Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        this.k = obj;
        this.s |= Integer.MIN_VALUE;
        Object objB = this.n.b(this);
        return objB == t70.a ? objB : new i72(objB);
    }
}
