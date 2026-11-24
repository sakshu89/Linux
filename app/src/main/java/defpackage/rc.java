package defpackage;

import android.view.Choreographer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rc implements Choreographer.FrameCallback {
    public final /* synthetic */ yv a;
    public final /* synthetic */ hq0 b;

    public rc(yv yvVar, sc scVar, hq0 hq0Var) {
        this.a = yvVar;
        this.b = hq0Var;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        Object h72Var;
        try {
            h72Var = this.b.j(Long.valueOf(j));
        } catch (Throwable th) {
            h72Var = new h72(th);
        }
        this.a.h(h72Var);
    }
}
