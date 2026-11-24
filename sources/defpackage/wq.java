package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wq implements Runnable {
    public final Executor a;
    public boolean b = false;
    public final /* synthetic */ xq c;

    public wq(xq xqVar, ch2 ch2Var) {
        this.c = xqVar;
        this.a = ch2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.execute(new s7(6, this));
    }
}
