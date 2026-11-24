package defpackage;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface s30 {
    static void r(zl1 zl1Var, s30 s30Var, s30 s30Var2, bi biVar) {
        if (!Objects.equals(biVar, xy0.I)) {
            zl1Var.u(biVar, s30Var2.b(biVar), s30Var2.f(biVar));
            return;
        }
        l62 l62Var = (l62) s30Var2.d(biVar, null);
        l62 l62Var2 = (l62) s30Var.d(biVar, null);
        r30 r30VarB = s30Var2.b(biVar);
        if (l62Var == null) {
            l62Var = l62Var2;
        } else if (l62Var2 != null) {
            su0 su0Var = l62Var2.a;
            el1 el1Var = l62Var2.b;
            int i = l62Var2.c;
            su0 su0Var2 = l62Var.a;
            if (su0Var2 != null) {
                su0Var = su0Var2;
            }
            el1 el1Var2 = l62Var.b;
            if (el1Var2 != null) {
                el1Var = el1Var2;
            }
            int i2 = l62Var.c;
            if (i2 != 0) {
                i = i2;
            }
            l62Var = new l62(su0Var, el1Var, i);
        }
        zl1Var.u(biVar, r30VarB, l62Var);
    }

    static gs1 t(s30 s30Var, s30 s30Var2) {
        if (s30Var == null && s30Var2 == null) {
            return gs1.c;
        }
        zl1 zl1VarO = s30Var2 != null ? zl1.o(s30Var2) : zl1.m();
        if (s30Var != null) {
            Iterator it = s30Var.e().iterator();
            while (it.hasNext()) {
                r(zl1VarO, s30Var2, s30Var, (bi) it.next());
            }
        }
        return gs1.l(zl1VarO);
    }

    boolean a(bi biVar);

    r30 b(bi biVar);

    void c(qq qqVar);

    Object d(bi biVar, Object obj);

    Set e();

    Object f(bi biVar);

    Set g(bi biVar);

    Object h(bi biVar, r30 r30Var);
}
