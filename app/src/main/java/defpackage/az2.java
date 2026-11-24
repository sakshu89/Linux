package defpackage;

import android.view.Choreographer;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class az2 implements Executor {
    public final /* synthetic */ Choreographer a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.a.postFrameCallback(new m12(runnable));
    }
}
