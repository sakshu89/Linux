package defpackage;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rt0 extends y50 {
    public long e;
    public Object f;
    public List i;
    public Throwable j;
    public Object k;
    public String n;
    public xr0 s;
    public /* synthetic */ Object t;
    public final /* synthetic */ tt0 u;
    public int v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rt0(tt0 tt0Var, y50 y50Var) {
        super(y50Var);
        this.u = tt0Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        this.t = obj;
        this.v |= Integer.MIN_VALUE;
        Serializable serializableA = tt0.a(this.u, this);
        return serializableA == t70.a ? serializableA : new i72(serializableA);
    }
}
