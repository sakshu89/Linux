package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class jq4 {
    public static final ib1 a(n10 n10Var) {
        qb1 qb1Var = n10Var.a;
        qb1Var.getClass();
        uf1 uf1Var = qb1Var.a;
        while (true) {
            ib1 ib1Var = (ib1) ((AtomicReference) uf1Var.b).get();
            if (ib1Var != null) {
                return ib1Var;
            }
            ft2 ft2VarA = wa4.a();
            xa0 xa0Var = ld0.a;
            ib1 ib1Var2 = new ib1(qb1Var, pl4.c(ft2VarA, ig1.a.i));
            AtomicReference atomicReference = (AtomicReference) uf1Var.b;
            do {
                x50 x50Var = null;
                if (atomicReference.compareAndSet(null, ib1Var2)) {
                    xa0 xa0Var2 = ld0.a;
                    uf4.b(ib1Var2, ig1.a.i, new y(ib1Var2, x50Var, 11), 2);
                    return ib1Var2;
                }
            } while (atomicReference.get() == null);
        }
    }
}
