package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class iw2 {
    public final et4 a = new et4();

    public iw2(wj1 wj1Var) {
        py0 py0Var = new py0(29, this);
        wj1Var.getClass();
        py0 py0Var2 = new py0(27, py0Var);
        et4 et4Var = (et4) wj1Var.b;
        w31 w31Var = jw2.a;
        et4Var.getClass();
        et4Var.b.o(new xd4(w31Var, py0Var2));
        et4Var.i();
    }

    public final boolean a(Exception exc) {
        et4 et4Var = this.a;
        et4Var.getClass();
        jg1.e(exc, "Exception must not be null");
        synchronized (et4Var.a) {
            try {
                if (et4Var.c) {
                    return false;
                }
                et4Var.c = true;
                et4Var.f = exc;
                et4Var.b.q(et4Var);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public iw2() {
    }
}
