package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class my3 {
    public static final py0 a = new py0(16, "CLOSED");

    public static void a(rl2 rl2Var, List list, g30 g30Var) {
        if (list.isEmpty()) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int iC = rl2Var.c((j6) list.get(i));
            int iN = rl2Var.N(rl2Var.r(iC), rl2Var.b);
            Object obj = iN < rl2Var.g(rl2Var.r(iC + 1), rl2Var.b) ? rl2Var.c[rl2Var.h(iN)] : r20.a;
            a42 a42Var = obj instanceof a42 ? (a42) obj : null;
            if (a42Var != null) {
                a42Var.a = g30Var;
            }
        }
    }

    public static final Object b(af2 af2Var, long j, vq0 vq0Var) {
        while (true) {
            if (af2Var.f >= j && !af2Var.g()) {
                return af2Var;
            }
            Object objE = af2Var.e();
            py0 py0Var = a;
            if (objE == py0Var) {
                return py0Var;
            }
            af2 af2Var2 = (af2) ((q30) objE);
            if (af2Var2 == null) {
                af2Var2 = (af2) vq0Var.e(Long.valueOf(af2Var.f + 1), af2Var);
                if (af2Var.j(af2Var2)) {
                    if (af2Var.g()) {
                        af2Var.i();
                    }
                }
            }
            af2Var = af2Var2;
        }
    }
}
