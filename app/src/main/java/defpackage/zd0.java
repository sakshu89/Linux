package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zd0 implements c22 {
    public static final Object c = new Object();
    public volatile zk0 a;
    public volatile Object b;

    public static c22 a(zk0 zk0Var) {
        if (zk0Var instanceof zd0) {
            return zk0Var;
        }
        zd0 zd0Var = new zd0();
        zd0Var.b = c;
        zd0Var.a = zk0Var;
        return zd0Var;
    }

    @Override // defpackage.c22
    public final Object get() {
        Object obj;
        Object obj2 = this.b;
        Object obj3 = c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.b;
                if (obj == obj3) {
                    obj = this.a.get();
                    Object obj4 = this.b;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.b = obj;
                    this.a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
