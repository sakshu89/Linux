package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ef2 {
    public final Object a;
    public final wq0 b;
    public final wq0 c;
    public final Object d;
    public final nu2 e;
    public final wq0 f;
    public Object g;
    public int h = -1;
    public final /* synthetic */ gf2 i;

    public ef2(gf2 gf2Var, Object obj, wq0 wq0Var, wq0 wq0Var2, py0 py0Var, nu2 nu2Var, wq0 wq0Var3) {
        this.i = gf2Var;
        this.a = obj;
        this.b = wq0Var;
        this.c = wq0Var2;
        this.d = py0Var;
        this.e = nu2Var;
        this.f = wq0Var3;
    }

    public final void a() {
        Object obj = this.g;
        if (obj instanceof af2) {
            ((af2) obj).m(this.h, this.i.a);
            return;
        }
        rd0 rd0Var = obj instanceof rd0 ? (rd0) obj : null;
        if (rd0Var != null) {
            rd0Var.a();
        }
    }
}
