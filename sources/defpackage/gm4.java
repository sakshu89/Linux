package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class gm4 {
    public static final void a(yv yvVar, x50 x50Var, boolean z) {
        Object objW = yvVar.w();
        Throwable thE = yvVar.e(objW);
        Object h72Var = thE != null ? new h72(thE) : yvVar.g(objW);
        if (!z) {
            x50Var.h(h72Var);
            return;
        }
        x50Var.getClass();
        hd0 hd0Var = (hd0) x50Var;
        y50 y50Var = hd0Var.f;
        Object obj = hd0Var.j;
        j70 j70VarF = y50Var.f();
        Object objE = ab4.e(j70VarF, obj);
        l43 l43VarC = objE != ab4.a ? ql4.c(y50Var, j70VarF, objE) : null;
        try {
            y50Var.h(h72Var);
        } finally {
            if (l43VarC == null || l43VarC.w0()) {
                ab4.a(j70VarF, objE);
            }
        }
    }
}
