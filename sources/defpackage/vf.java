package defpackage;

import com.project.sonic.SonicApplication;
import dagger.hilt.internal.GeneratedComponentManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vf implements GeneratedComponentManager {
    public volatile v80 a;
    public final Object b = new Object();
    public final q82 c;

    public vf(q82 q82Var) {
        this.c = q82Var;
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        if (this.a == null) {
            synchronized (this.b) {
                try {
                    if (this.a == null) {
                        this.a = new v80(new wf((SonicApplication) this.c.a, false));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.a;
    }
}
