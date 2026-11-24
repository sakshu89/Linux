package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class b83 {
    public final c83 a = new c83();

    public final void a(String str, AutoCloseable autoCloseable) {
        AutoCloseable autoCloseable2;
        c83 c83Var = this.a;
        if (c83Var != null) {
            if (c83Var.d) {
                c83.a(autoCloseable);
                return;
            }
            synchronized (c83Var.a) {
                autoCloseable2 = (AutoCloseable) c83Var.b.put(str, autoCloseable);
            }
            c83.a(autoCloseable2);
        }
    }

    public final void b() {
        c83 c83Var = this.a;
        if (c83Var != null && !c83Var.d) {
            c83Var.d = true;
            synchronized (c83Var.a) {
                try {
                    Iterator it = c83Var.b.values().iterator();
                    while (it.hasNext()) {
                        c83.a((AutoCloseable) it.next());
                    }
                    Iterator it2 = c83Var.c.iterator();
                    while (it2.hasNext()) {
                        c83.a((AutoCloseable) it2.next());
                    }
                    c83Var.c.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        d();
    }

    public final AutoCloseable c(String str) {
        AutoCloseable autoCloseable;
        c83 c83Var = this.a;
        if (c83Var == null) {
            return null;
        }
        synchronized (c83Var.a) {
            autoCloseable = (AutoCloseable) c83Var.b.get(str);
        }
        return autoCloseable;
    }

    public void d() {
    }
}
