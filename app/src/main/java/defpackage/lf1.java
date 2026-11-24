package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lf1 implements ph1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ hq0 d;
    public final /* synthetic */ hq0 e;
    public final /* synthetic */ mf1 f;

    public lf1(int i, int i2, Map map, hq0 hq0Var, hq0 hq0Var2, mf1 mf1Var) {
        this.a = i;
        this.b = i2;
        this.c = map;
        this.d = hq0Var;
        this.e = hq0Var2;
        this.f = mf1Var;
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
        this.e.j(this.f.u);
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
