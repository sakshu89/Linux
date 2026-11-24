package defpackage;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l53 implements zk0 {
    public final c22 a;
    public final c22 b;
    public final c22 c;
    public final cb2 d;
    public final c22 e;
    public final c22 f;

    public l53(c22 c22Var, c22 c22Var2, c22 c22Var3, cb2 cb2Var, c22 c22Var4, c22 c22Var5) {
        this.a = c22Var;
        this.b = c22Var2;
        this.c = c22Var3;
        this.d = cb2Var;
        this.e = c22Var4;
        this.f = c22Var5;
    }

    @Override // defpackage.c22
    public final Object get() {
        Context context = (Context) this.a.get();
        dj1 dj1Var = (dj1) this.b.get();
        l92 l92Var = (l92) this.c.get();
        kf kfVar = (kf) this.d.get();
        Executor executor = (Executor) this.e.get();
        l92 l92Var2 = (l92) this.f.get();
        nr4 nr4Var = new nr4(20);
        pi piVar = new pi();
        piVar.a = context;
        piVar.b = dj1Var;
        piVar.c = l92Var;
        piVar.d = kfVar;
        piVar.e = executor;
        piVar.f = l92Var2;
        piVar.g = nr4Var;
        return piVar;
    }
}
