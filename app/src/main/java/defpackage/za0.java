package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class za0 implements zk0 {
    public final c22 a;
    public final c22 b;
    public final cb2 c;
    public final c22 d;
    public final c22 e;

    public za0(c22 c22Var, c22 c22Var2, cb2 cb2Var, c22 c22Var3, c22 c22Var4) {
        this.a = c22Var;
        this.b = c22Var2;
        this.c = cb2Var;
        this.d = c22Var3;
        this.e = c22Var4;
    }

    @Override // defpackage.c22
    public final Object get() {
        return new ya0((Executor) this.a.get(), (dj1) this.b.get(), (kf) this.c.get(), (l92) this.d.get(), (l92) this.e.get());
    }
}
