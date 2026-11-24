package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ns0 extends y50 {
    public /* synthetic */ Object H;
    public final /* synthetic */ ps0 X;
    public int Y;
    public boolean e;
    public an1 f;
    public Set i;
    public Object j;
    public String k;
    public int n;
    public int s;
    public int t;
    public long u;
    public long v;
    public long w;
    public long x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ns0(ps0 ps0Var, y50 y50Var) {
        super(y50Var);
        this.X = ps0Var;
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        this.H = obj;
        this.Y |= Integer.MIN_VALUE;
        Object objA = this.X.a(false, this);
        return objA == t70.a ? objA : new i72(objA);
    }
}
