package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class rr4 {
    public static final dk1 a(xb0 xb0Var, int i) {
        dk1 dk1Var = ((dk1) xb0Var).a.i;
        if (dk1Var == null || (dk1Var.e & i) == 0) {
            return null;
        }
        while (dk1Var != null) {
            int i2 = dk1Var.c;
            if ((i2 & 2) != 0) {
                return null;
            }
            if ((i2 & i) != 0) {
                return dk1Var;
            }
            dk1Var = dk1Var.i;
        }
        return null;
    }
}
