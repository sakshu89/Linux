package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ux2 {
    public final be a;
    public final yz2 b;
    public final boolean e;
    public final jc0 g;
    public final qo0 h;
    public cj j;
    public z61 k;
    public final int c = Integer.MAX_VALUE;
    public final int d = 1;
    public final int f = 1;
    public final List i = ii0.a;

    public ux2(be beVar, yz2 yz2Var, boolean z, jc0 jc0Var, qo0 qo0Var, int i) {
        this.a = beVar;
        this.b = yz2Var;
        this.e = z;
        this.g = jc0Var;
        this.h = qo0Var;
    }

    public final void a(z61 z61Var) {
        cj cjVar = this.j;
        if (cjVar == null || z61Var != this.k || cjVar.b()) {
            this.k = z61Var;
            cjVar = new cj(this.a, lc4.b(this.b, z61Var), this.i, this.g, this.h);
        }
        this.j = cjVar;
    }
}
