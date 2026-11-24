package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sb2 implements qy0 {
    public final qy0 a;
    public final Object b = new Object();
    public boolean c;
    public pr d;

    public sb2(qy0 qy0Var) {
        this.a = qy0Var;
    }

    @Override // defpackage.qy0
    public final void a(long j, pr prVar) {
        q43 q43Var;
        prVar.getClass();
        synchronized (this.b) {
            this.c = true;
            this.d = prVar;
        }
        qy0 qy0Var = this.a;
        if (qy0Var != null) {
            qy0Var.a(j, new pr(1, this));
            q43Var = q43.a;
        } else {
            q43Var = null;
        }
        if (q43Var == null) {
            xq4.a("ScreenFlashWrapper", "apply: screenFlash is null!");
            c();
        }
    }

    public final void b() {
        q43 q43Var;
        synchronized (this.b) {
            try {
                if (this.c) {
                    qy0 qy0Var = this.a;
                    if (qy0Var != null) {
                        qy0Var.clear();
                        q43Var = q43.a;
                    } else {
                        q43Var = null;
                    }
                    if (q43Var == null) {
                        xq4.a("ScreenFlashWrapper", "completePendingScreenFlashClear: screenFlash is null!");
                    }
                } else {
                    xq4.d("ScreenFlashWrapper", "completePendingScreenFlashClear: none pending!");
                }
                this.c = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        synchronized (this.b) {
            try {
                pr prVar = this.d;
                if (prVar != null) {
                    prVar.a();
                }
                this.d = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.qy0
    public final void clear() {
        b();
    }
}
