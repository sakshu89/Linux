package defpackage;

import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qt2 implements ch {
    public final /* synthetic */ st2 a;
    public final /* synthetic */ rt2 b;
    public final /* synthetic */ int c;
    public final /* synthetic */ ij e;
    public final /* synthetic */ ij f;

    public /* synthetic */ qt2(st2 st2Var, rt2 rt2Var, int i, ij ijVar, ij ijVar2) {
        this.a = st2Var;
        this.b = rt2Var;
        this.c = i;
        this.e = ijVar;
        this.f = ijVar2;
    }

    @Override // defpackage.ch
    /* JADX INFO: renamed from: apply */
    public final wc1 mo28apply(Object obj) {
        rt2 rt2Var = this.b;
        Surface surface = (Surface) obj;
        st2 st2Var = this.a;
        st2Var.getClass();
        surface.getClass();
        try {
            rt2Var.d();
            xt2 xt2Var = new xt2(surface, this.c, st2Var.g.a, this.e, this.f);
            xt2Var.s.b.a(new nt2(rt2Var, 1), xg4.a());
            hh1.e("Consumer can only be linked once.", rt2Var.r == null);
            rt2Var.r = xt2Var;
            return oz3.d(xt2Var);
        } catch (nb0 e) {
            return new mz0(1, e);
        }
    }
}
