package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class co0 extends k61 implements hq0 {
    public final /* synthetic */ t42 b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public co0(int i, t42 t42Var) {
        super(1);
        this.b = t42Var;
        this.c = i;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        Boolean boolValueOf = Boolean.valueOf(((ko0) obj).P0(this.c));
        this.b.a = boolValueOf;
        return boolValueOf;
    }
}
