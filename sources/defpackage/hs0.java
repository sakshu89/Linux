package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hs0 extends y50 {
    public /* synthetic */ Object e;
    public final /* synthetic */ ms0 f;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hs0(ms0 ms0Var, y50 y50Var) {
        super(y50Var);
        this.f = ms0Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) throws Throwable {
        this.e = obj;
        this.i |= Integer.MIN_VALUE;
        Object objN = this.f.n(null, this);
        return objN == t70.a ? objN : new i72(objN);
    }
}
