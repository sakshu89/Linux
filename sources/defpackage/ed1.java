package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ed1 extends y50 {
    public vq0 e;
    public Iterator f;
    public int i;
    public /* synthetic */ Object j;
    public final /* synthetic */ p6 k;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ed1(p6 p6Var, y50 y50Var) {
        super(y50Var);
        this.k = p6Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        this.j = obj;
        this.n |= Integer.MIN_VALUE;
        return this.k.i(null, this);
    }
}
