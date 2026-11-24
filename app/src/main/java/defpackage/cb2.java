package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cb2 implements zk0 {
    public final /* synthetic */ int a;
    public final c22 b;
    public final c22 c;
    public final zk0 d;

    public /* synthetic */ cb2(c22 c22Var, c22 c22Var2, zk0 zk0Var, int i) {
        this.a = i;
        this.b = c22Var;
        this.c = c22Var2;
        this.d = zk0Var;
    }

    @Override // defpackage.c22
    public final Object get() {
        int i = this.a;
        zk0 zk0Var = this.d;
        c22 c22Var = this.c;
        c22 c22Var2 = this.b;
        switch (i) {
            case 0:
                return new kf((Context) c22Var2.get(), (l92) c22Var.get(), (aj) ((tj0) zk0Var).get(), 16, false);
            default:
                int i2 = 20;
                return new r23(new nr4(i2), new ak1(i2), (ya0) ((za0) c22Var2).get(), (pi) ((l53) c22Var).get(), (p6) ((lc3) zk0Var).get());
        }
    }
}
