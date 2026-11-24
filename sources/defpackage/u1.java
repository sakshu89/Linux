package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class u1 extends bc4 {
    @Override // defpackage.bc4
    public final boolean a(w1 w1Var, s1 s1Var, s1 s1Var2) {
        synchronized (w1Var) {
            try {
                if (w1Var.b != s1Var) {
                    return false;
                }
                w1Var.b = s1Var2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.bc4
    public final boolean b(w1 w1Var, Object obj, Object obj2) {
        synchronized (w1Var) {
            try {
                if (w1Var.a != obj) {
                    return false;
                }
                w1Var.a = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.bc4
    public final boolean c(w1 w1Var, v1 v1Var, v1 v1Var2) {
        synchronized (w1Var) {
            try {
                if (w1Var.c != v1Var) {
                    return false;
                }
                w1Var.c = v1Var2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.bc4
    public final void g(v1 v1Var, v1 v1Var2) {
        v1Var.b = v1Var2;
    }

    @Override // defpackage.bc4
    public final void h(v1 v1Var, Thread thread) {
        v1Var.a = thread;
    }
}
