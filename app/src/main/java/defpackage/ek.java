package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ek implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;

    public /* synthetic */ ek(x20 x20Var, yw ywVar, nl2 nl2Var, bl1 bl1Var) {
        this.a = 2;
        this.b = x20Var;
        this.c = ywVar;
        this.e = nl2Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        int i;
        l42 l42Var;
        int i2 = this.a;
        q43 q43Var = q43.a;
        Object obj = this.e;
        Object obj2 = this.c;
        Object obj3 = this.b;
        switch (i2) {
            case 0:
                ((fk) obj3).a();
                hh hhVar = (hh) ((cj) obj2).e;
                int i3 = ((r42) obj).a;
                do {
                    i = hhVar.get();
                } while (!hhVar.compareAndSet(i, ((i >>> 27) & 15) == i3 ? i - 1 : i));
                return q43Var;
            case 1:
                zm zmVar = (zm) obj3;
                l42 l42VarI0 = zm.I0(zmVar, (co1) obj2, (h7) obj);
                if (l42VarI0 == null) {
                    return null;
                }
                k50 k50Var = zmVar.x;
                if (l21.a(k50Var.d0, 0L)) {
                    c11.c("Expected BringIntoViewRequester to not be used before parents are placed.");
                }
                return l42VarI0.i(k50Var.L0(l42VarI0, k50Var.d0, 0L) ^ (-9223372034707292160L));
            case 2:
                x20 x20Var = (x20) obj3;
                yw ywVar = (yw) obj2;
                nl2 nl2Var = (nl2) obj;
                s20 s20Var = x20Var.M;
                yw ywVar2 = s20Var.b;
                try {
                    s20Var.b = ywVar;
                    nl2 nl2Var2 = x20Var.G;
                    int[] iArr = x20Var.o;
                    ml1 ml1Var = x20Var.v;
                    x20Var.o = null;
                    x20Var.v = null;
                    try {
                        x20Var.G = nl2Var;
                        boolean z = s20Var.e;
                        try {
                            s20Var.e = false;
                            throw null;
                        } catch (Throwable th) {
                            s20Var.e = z;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        x20Var.G = nl2Var2;
                        x20Var.o = iArr;
                        x20Var.v = ml1Var;
                        throw th2;
                    }
                } catch (Throwable th3) {
                    s20Var.b = ywVar2;
                    throw th3;
                }
            case 3:
                k50 k50Var2 = (k50) obj3;
                i53 i53Var = (i53) obj2;
                cn cnVar = (cn) obj;
                tm tmVar = k50Var2.Z;
                while (true) {
                    pm1 pm1Var = tmVar.a;
                    int i4 = pm1Var.c;
                    if (i4 != 0) {
                        if (i4 == 0) {
                            kf2.g("MutableVector is empty.");
                            return null;
                        }
                        l42 l42Var2 = (l42) ((h50) pm1Var.a[i4 - 1]).a.a();
                        if (l42Var2 == null ? true : k50.J0(k50Var2, l42Var2, 0L, 0L, 3)) {
                            pm1 pm1Var2 = tmVar.a;
                            ((h50) pm1Var2.l(pm1Var2.c - 1)).b.h(q43Var);
                        }
                    }
                }
                if (k50Var2.c0 && (l42Var = (l42) k50Var2.Y.a()) != null && k50.J0(k50Var2, l42Var, 0L, 0L, 3)) {
                    k50Var2.c0 = false;
                }
                i53Var.e = k50.I0(k50Var2, cnVar, 0L);
                return q43Var;
            case 4:
                ea1 ea1Var = (ea1) obj2;
                r91 r91Var = (r91) ((qc0) obj3).getValue();
                return new t91(ea1Var, r91Var, (k81) obj, new t9((h21) ((z81) ea1Var.e.e).getValue(), r91Var));
            case 5:
                j6 j6Var = (j6) obj3;
                rl2 rl2Var = (rl2) obj2;
                as1 as1Var = (as1) obj;
                if (j6Var != null) {
                    rl2Var.a(rl2Var.c(j6Var) - rl2Var.t);
                }
                List listA = cj4.a(rl2Var, null, rl2Var.t, null);
                m20 m20Var = (m20) mz.E(listA);
                Integer num = m20Var != null ? m20Var.b : null;
                List listG = as1Var.g(num);
                if (num != null && !listG.isEmpty()) {
                    listG = mz.G(nz.h(new m20(((m20) mz.x(listG)).a, null, num)), mz.u(1, listG));
                }
                return new l20(mz.G(listA, listG));
            default:
                gj2 gj2Var = (gj2) obj3;
                zm2 zm2Var = (zm2) obj2;
                fq0 fq0Var = (fq0) obj;
                if (gj2Var.d && !(gj2Var.f instanceof q51)) {
                    if (zm2Var != null) {
                        ((ac0) zm2Var).a();
                    }
                    fq0Var.a();
                }
                return q43Var;
        }
    }

    public /* synthetic */ ek(Object obj, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.e = obj3;
    }
}
