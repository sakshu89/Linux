package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x71 extends k71 {
    public final /* synthetic */ b81 b;
    public final /* synthetic */ vq0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x71(b81 b81Var, vq0 vq0Var, String str) {
        super(str);
        this.b = b81Var;
        this.c = vq0Var;
    }

    @Override // defpackage.oh1
    public final ph1 f(qh1 qh1Var, List list, long j) {
        b81 b81Var = this.b;
        v71 v71Var = b81Var.k;
        v71Var.a = qh1Var.getLayoutDirection();
        v71Var.b = qh1Var.b();
        v71Var.c = qh1Var.l();
        boolean zS = qh1Var.s();
        vq0 vq0Var = this.c;
        if (zS || b81Var.a.n == null) {
            b81Var.e = 0;
            ph1 ph1Var = (ph1) vq0Var.e(v71Var, new q40(j));
            return new w71(ph1Var, b81Var, b81Var.e, ph1Var, 1);
        }
        b81Var.f = 0;
        ph1 ph1Var2 = (ph1) vq0Var.e(b81Var.n, new q40(j));
        return new w71(ph1Var2, b81Var, b81Var.f, ph1Var2, 0);
    }
}
