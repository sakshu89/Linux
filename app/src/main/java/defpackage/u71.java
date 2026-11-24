package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class u71 implements ph1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ hq0 d;
    public final /* synthetic */ v71 e;
    public final /* synthetic */ b81 f;
    public final /* synthetic */ hq0 g;

    public u71(int i, int i2, Map map, hq0 hq0Var, v71 v71Var, b81 b81Var, hq0 hq0Var2) {
        this.a = i;
        this.b = i2;
        this.c = map;
        this.d = hq0Var;
        this.e = v71Var;
        this.f = b81Var;
        this.g = hq0Var2;
    }

    @Override // defpackage.ph1
    public final int a() {
        return this.b;
    }

    @Override // defpackage.ph1
    public final int b() {
        return this.a;
    }

    @Override // defpackage.ph1
    public final void c() {
        e11 e11Var;
        n71 n71Var = this.f.a;
        boolean zS = this.e.s();
        hq0 hq0Var = this.g;
        if (!zS || (e11Var = n71Var.o0.c.B0) == null) {
            hq0Var.j(n71Var.o0.c.u);
        } else {
            hq0Var.j(e11Var.u);
        }
    }

    @Override // defpackage.ph1
    public final Map d() {
        return this.c;
    }

    @Override // defpackage.ph1
    public final hq0 e() {
        return this.d;
    }
}
