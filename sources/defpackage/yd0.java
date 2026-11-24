package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yd0 implements b22 {
    public static final Object c = new Object();
    public volatile b22 a;
    public volatile Object b;

    public static b22 a(b22 b22Var) {
        if (b22Var instanceof yd0) {
            return b22Var;
        }
        yd0 yd0Var = new yd0();
        yd0Var.b = c;
        yd0Var.a = b22Var;
        return yd0Var;
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
        }
        return obj;
    }
}
