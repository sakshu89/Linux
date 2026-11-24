package defpackage;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class m8 implements ComponentCallbacks2 {
    public final /* synthetic */ q62 a;

    public m8(q62 q62Var) {
        this.a = q62Var;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        q62 q62Var = this.a;
        synchronized (q62Var) {
            q62Var.a.c();
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        q62 q62Var = this.a;
        synchronized (q62Var) {
            q62Var.a.c();
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        q62 q62Var = this.a;
        synchronized (q62Var) {
            q62Var.a.c();
        }
    }
}
