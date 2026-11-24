package defpackage;

import android.content.Context;
import android.view.KeyEvent;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class h7 extends k61 implements fq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h7(int i, Object obj, Object obj2) {
        super(0);
        this.b = i;
        this.c = obj;
        this.e = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17, types: [dk1] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20, types: [dk1] */
    /* JADX WARN: Type inference failed for: r0v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [pm1] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [pm1] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v18 */
    @Override // defpackage.fq0
    public final Object a() {
        gg2 gg2Var;
        n71 n71Var;
        l42 l42Var;
        int i = this.b;
        q43 q43Var = q43.a;
        Object obj = this.e;
        Object obj2 = this.c;
        switch (i) {
            case 0:
                return Boolean.valueOf(super/*android.view.ViewGroup*/.dispatchKeyEvent((KeyEvent) obj));
            case 1:
                x7 x7Var = (x7) obj;
                jd2 jd2Var = (jd2) obj2;
                ed2 ed2Var = jd2Var.f;
                ed2 ed2Var2 = jd2Var.i;
                Float f = jd2Var.c;
                Float f2 = jd2Var.e;
                float fFloatValue = (ed2Var == null || f == null) ? 0.0f : ((Number) ed2Var.a.a()).floatValue() - f.floatValue();
                float fFloatValue2 = (ed2Var2 == null || f2 == null) ? 0.0f : ((Number) ed2Var2.a.a()).floatValue() - f2.floatValue();
                if (fFloatValue != 0.0f || fFloatValue2 != 0.0f) {
                    int iS = x7Var.s(jd2Var.a);
                    ig2 ig2Var = (ig2) x7Var.k().b(x7Var.u);
                    if (ig2Var != null) {
                        try {
                            h3 h3Var = x7Var.w;
                            if (h3Var != null) {
                                h3Var.a.setBoundsInScreen(x7Var.c(ig2Var));
                            }
                            break;
                        } catch (IllegalStateException unused) {
                        }
                    }
                    ig2 ig2Var2 = (ig2) x7Var.k().b(x7Var.v);
                    if (ig2Var2 != null) {
                        try {
                            h3 h3Var2 = x7Var.x;
                            if (h3Var2 != null) {
                                h3Var2.a.setBoundsInScreen(x7Var.c(ig2Var2));
                            }
                            break;
                        } catch (IllegalStateException unused2) {
                        }
                    }
                    x7Var.e.invalidate();
                    ig2 ig2Var3 = (ig2) x7Var.k().b(iS);
                    if (ig2Var3 != null && (gg2Var = ig2Var3.a) != null && (n71Var = gg2Var.c) != null) {
                        if (ed2Var != null) {
                            x7Var.X.h(iS, ed2Var);
                        }
                        if (ed2Var2 != null) {
                            x7Var.Y.h(iS, ed2Var2);
                        }
                        x7Var.o(n71Var);
                    }
                }
                if (ed2Var != null) {
                    jd2Var.c = (Float) ed2Var.a.a();
                }
                if (ed2Var2 != null) {
                    jd2Var.e = (Float) ed2Var2.a.a();
                }
                return q43Var;
            case 2:
                fq0 fq0Var = (fq0) obj2;
                if (fq0Var != null && (l42Var = (l42) fq0Var.a()) != null) {
                    return l42Var;
                }
                co1 co1Var = (co1) obj;
                if (!co1Var.V0().w) {
                    co1Var = null;
                }
                if (co1Var != null) {
                    return ry3.a(0L, cp4.a(co1Var.c));
                }
                return null;
            case 3:
                ((ro) obj2).X.j((so) obj);
                return q43Var;
            case 4:
                ((t42) obj2).a = ((ko0) obj).K0();
                return q43Var;
            case 5:
                ((mw0) obj2).d((dk1) obj);
                return q43Var;
            case 6:
                zn1 zn1Var = ((n71) obj2).o0;
                t42 t42Var = (t42) obj;
                if ((zn1Var.f.e & 8) != 0) {
                    for (dk1 dk1Var = zn1Var.e; dk1Var != null; dk1Var = dk1Var.f) {
                        if ((dk1Var.c & 8) != 0) {
                            ?? B = dk1Var;
                            ?? pm1Var = 0;
                            while (B != 0) {
                                if (B instanceof eg2) {
                                    eg2 eg2Var = (eg2) B;
                                    if (eg2Var.i0()) {
                                        cg2 cg2Var = new cg2();
                                        t42Var.a = cg2Var;
                                        cg2Var.e = true;
                                    }
                                    if (eg2Var.k0()) {
                                        ((cg2) t42Var.a).c = true;
                                    }
                                    eg2Var.e0((og2) t42Var.a);
                                } else if ((B.c & 8) != 0 && (B instanceof zb0)) {
                                    dk1 dk1Var2 = ((zb0) B).H;
                                    int i2 = 0;
                                    B = B;
                                    pm1Var = pm1Var;
                                    while (dk1Var2 != null) {
                                        if ((dk1Var2.c & 8) != 0) {
                                            i2++;
                                            pm1Var = pm1Var;
                                            if (i2 == 1) {
                                                B = dk1Var2;
                                            } else {
                                                if (pm1Var == 0) {
                                                    pm1Var = new pm1(new dk1[16]);
                                                }
                                                if (B != 0) {
                                                    pm1Var.b(B);
                                                    B = 0;
                                                }
                                                pm1Var.b(dk1Var2);
                                            }
                                        }
                                        dk1Var2 = dk1Var2.i;
                                        B = B;
                                        pm1Var = pm1Var;
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                B = cm4.b(pm1Var);
                            }
                        }
                    }
                }
                return q43Var;
            case 7:
                r72 r72Var = co1.v0;
                ((hq0) obj2).j(r72Var);
                co1 co1Var2 = (co1) obj;
                yj2 yj2Var = co1Var2.m0;
                yj2 yj2Var2 = r72Var.s;
                boolean z = yj2Var != yj2Var2;
                boolean z2 = co1Var2.n0;
                boolean z3 = r72Var.t;
                boolean z4 = z2 != z3;
                if (z || z4) {
                    co1Var2.m0 = yj2Var2;
                    co1Var2.n0 = z3;
                    if (co1Var2.o0 && (z4 || (z3 && z))) {
                        co1Var2.x.F();
                    }
                }
                co1Var2.o0 = true;
                r72Var.H = r72Var.s.a(r72Var.u, r72Var.w, r72Var.v);
                return q43Var;
            default:
                return new File(((Context) obj2).getApplicationContext().getFilesDir(), "datastore/".concat(((hz1) obj).a.concat(".preferences_pb")));
        }
    }
}
