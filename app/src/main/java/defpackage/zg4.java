package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class zg4 {
    public static final yv a(x50 x50Var) {
        if (!(x50Var instanceof hd0)) {
            return new yv(1, x50Var);
        }
        yv yvVarO = ((hd0) x50Var).o();
        if (yvVarO != null) {
            if (!yvVarO.F()) {
                yvVarO = null;
            }
            if (yvVarO != null) {
                return yvVarO;
            }
        }
        return new yv(2, x50Var);
    }

    public static boolean b(byte b) {
        return b > -65;
    }
}
