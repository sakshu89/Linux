package defpackage;

import dagger.hilt.internal.GeneratedComponentManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l4 implements GeneratedComponentManager {
    public final n10 a;
    public final n10 b;
    public volatile s80 c;
    public final Object e = new Object();

    public l4(n10 n10Var) {
        this.a = n10Var;
        this.b = n10Var;
    }

    public static uf1 a(n10 n10Var, n10 n10Var2) {
        return new uf1(n10Var.c(), new h4(0, n10Var2), n10Var.a());
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        if (this.c == null) {
            synchronized (this.e) {
                try {
                    if (this.c == null) {
                        this.c = ((j4) a(this.a, this.b).o(u42.a(j4.class))).b;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.c;
    }
}
