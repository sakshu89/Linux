package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s90 extends y50 {
    public Object e;
    public Object f;
    public Serializable i;
    public t42 j;
    public boolean k;
    public int n;
    public /* synthetic */ Object s;
    public final /* synthetic */ w90 t;
    public int u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s90(w90 w90Var, y50 y50Var) {
        super(y50Var);
        this.t = w90Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        this.s = obj;
        this.u |= Integer.MIN_VALUE;
        return w90.g(this.t, false, this);
    }
}
