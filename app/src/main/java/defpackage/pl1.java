package defpackage;

import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class pl1 extends jd1 {
    @Override // defpackage.jd1
    public final void h(Object obj) {
        jd1.a("setValue");
        this.g++;
        this.e = obj;
        b(null);
    }

    public final void i(Object obj) {
        boolean z;
        synchronized (this.a) {
            z = this.f == jd1.k;
            this.f = obj;
        }
        if (z) {
            zf zfVarA = zf.a();
            o7 o7Var = this.j;
            gb0 gb0Var = zfVarA.j;
            if (gb0Var.k == null) {
                synchronized (gb0Var.j) {
                    try {
                        if (gb0Var.k == null) {
                            gb0Var.k = gb0.a(Looper.getMainLooper());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            gb0Var.k.post(o7Var);
        }
    }
}
