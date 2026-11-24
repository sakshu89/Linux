package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ya4 {
    public static final va a = new va(1022);

    /* JADX WARN: Code duplicated, block: B:65:0x015a  */
    /* JADX WARN: Code duplicated, block: B:68:0x0167  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public static final Object a(qd qdVar, md mdVar, long j, final hq0 hq0Var, x50 x50Var) {
        mu2 mu2Var;
        final t42 t42Var;
        final qd qdVar2;
        qd qdVar3;
        t42 t42Var2;
        Object objA;
        hq0 hq0Var2;
        od odVar;
        od odVar2;
        Object objA2;
        final md mdVar2 = mdVar;
        if (x50Var instanceof mu2) {
            mu2Var = (mu2) x50Var;
            int i = mu2Var.n;
            if ((i & Integer.MIN_VALUE) != 0) {
                mu2Var.n = i - Integer.MIN_VALUE;
            } else {
                mu2Var = new mu2(x50Var);
            }
        } else {
            mu2Var = new mu2(x50Var);
        }
        mu2 mu2Var2 = mu2Var;
        j70 j70Var = mu2Var2.b;
        Object obj = mu2Var2.k;
        int i2 = mu2Var2.n;
        int i3 = 2;
        t70 t70Var = t70.a;
        if (i2 == 0) {
            bz3.g(obj);
            final Object objA3 = mdVar2.a(0L);
            final vd vdVarE = mdVar2.e(0L);
            t42Var = new t42();
            if (j == Long.MIN_VALUE) {
                try {
                    j70Var.getClass();
                    final float fE = e(j70Var);
                    qdVar2 = qdVar;
                    try {
                        hq0 hq0Var3 = new hq0() { // from class: ju2
                            @Override // defpackage.hq0
                            public final Object j(Object obj2) {
                                long jLongValue = ((Long) obj2).longValue();
                                md mdVar3 = mdVar2;
                                g33 g33VarC = mdVar3.c();
                                Object objD = mdVar3.d();
                                qd qdVar4 = qdVar2;
                                od odVar3 = new od(objA3, g33VarC, vdVarE, jLongValue, objD, jLongValue, new ku2(1, qdVar4));
                                ya4.d(odVar3, jLongValue, fE, mdVar3, qdVar4, hq0Var);
                                t42Var.a = odVar3;
                                return q43.a;
                            }
                        };
                        t42Var2 = t42Var;
                        try {
                            mu2Var2.e = qdVar2;
                            mu2Var2.f = mdVar2;
                            mu2Var2.i = hq0Var;
                            mu2Var2.j = t42Var2;
                            mu2Var2.n = 1;
                            if (mdVar2.isInfinite()) {
                                objA = wo4.a(hq0Var3, mu2Var2);
                            } else {
                                f2 f2Var = new f2(hq0Var3, i3);
                                j70Var.getClass();
                                objA = or4.a(j70Var).a(f2Var, mu2Var2);
                            }
                            if (objA != t70Var) {
                                qdVar3 = qdVar2;
                                hq0Var2 = hq0Var;
                                t42Var = t42Var2;
                            }
                            return t70Var;
                        } catch (CancellationException e) {
                            e = e;
                            qdVar3 = qdVar2;
                            t42Var = t42Var2;
                            odVar = (od) t42Var.a;
                            if (odVar != null) {
                                odVar.i.setValue(Boolean.FALSE);
                            }
                            odVar2 = (od) t42Var.a;
                            if (odVar2 != null) {
                                qdVar3.i = false;
                            }
                            throw e;
                        }
                    } catch (CancellationException e2) {
                        e = e2;
                        qdVar3 = qdVar2;
                        odVar = (od) t42Var.a;
                        if (odVar != null) {
                            odVar.i.setValue(Boolean.FALSE);
                        }
                        odVar2 = (od) t42Var.a;
                        if (odVar2 != null) {
                            qdVar3.i = false;
                        }
                        throw e;
                    }
                } catch (CancellationException e3) {
                    e = e3;
                    qdVar2 = qdVar;
                }
            } else {
                t42Var2 = t42Var;
                try {
                    od odVar3 = new od(objA3, mdVar2.c(), vdVarE, j, mdVar2.d(), j, new ku2(0, qdVar));
                    j70Var.getClass();
                    d(odVar3, j, e(j70Var), mdVar2, qdVar, hq0Var);
                    t42Var2.a = odVar3;
                    qdVar3 = qdVar;
                    mdVar2 = mdVar;
                    hq0Var2 = hq0Var;
                    t42Var = t42Var2;
                } catch (CancellationException e4) {
                    e = e4;
                    qdVar3 = qdVar;
                    t42Var = t42Var2;
                    odVar = (od) t42Var.a;
                    if (odVar != null) {
                        odVar.i.setValue(Boolean.FALSE);
                    }
                    odVar2 = (od) t42Var.a;
                    if (odVar2 != null && odVar2.g == qdVar3.e) {
                        qdVar3.i = false;
                    }
                    throw e;
                }
            }
        } else {
            if (i2 != 1 && i2 != 2) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            t42Var = mu2Var2.j;
            hq0Var2 = mu2Var2.i;
            mdVar2 = mu2Var2.f;
            qdVar3 = mu2Var2.e;
            try {
                bz3.g(obj);
            } catch (CancellationException e5) {
                e = e5;
                odVar = (od) t42Var.a;
                if (odVar != null) {
                    odVar.i.setValue(Boolean.FALSE);
                }
                odVar2 = (od) t42Var.a;
                if (odVar2 != null) {
                    qdVar3.i = false;
                }
                throw e;
            }
        }
        do {
            j70 j70Var2 = mu2Var2.b;
            Object obj2 = t42Var.a;
            obj2.getClass();
            if (!((Boolean) ((od) obj2).i.getValue()).booleanValue()) {
                return q43.a;
            }
            j70Var2.getClass();
            final float fE2 = e(j70Var2);
            final t42 t42Var3 = t42Var;
            final hq0 hq0Var4 = hq0Var2;
            final md mdVar3 = mdVar2;
            final qd qdVar4 = qdVar3;
            try {
                hq0 hq0Var5 = new hq0() { // from class: lu2
                    @Override // defpackage.hq0
                    public final Object j(Object obj3) {
                        long jLongValue = ((Long) obj3).longValue();
                        Object obj4 = t42Var3.a;
                        obj4.getClass();
                        ya4.d((od) obj4, jLongValue, fE2, mdVar3, qdVar4, hq0Var4);
                        return q43.a;
                    }
                };
                t42Var = t42Var3;
                mdVar2 = mdVar3;
                qdVar3 = qdVar4;
                hq0Var2 = hq0Var4;
                mu2Var2.e = qdVar3;
                mu2Var2.f = mdVar2;
                mu2Var2.i = hq0Var2;
                mu2Var2.j = t42Var;
                mu2Var2.n = 2;
                if (mdVar2.isInfinite()) {
                    objA2 = wo4.a(hq0Var5, mu2Var2);
                } else {
                    f2 f2Var2 = new f2(hq0Var5, i3);
                    j70Var2.getClass();
                    objA2 = or4.a(j70Var2).a(f2Var2, mu2Var2);
                }
            } catch (CancellationException e6) {
                e = e6;
                t42Var = t42Var3;
                qdVar3 = qdVar4;
                odVar = (od) t42Var.a;
                if (odVar != null) {
                    odVar.i.setValue(Boolean.FALSE);
                }
                odVar2 = (od) t42Var.a;
                if (odVar2 != null) {
                    qdVar3.i = false;
                }
                throw e;
            }
        } while (objA2 != t70Var);
        return t70Var;
    }

    public static final Object b(qd qdVar, Float f, pd pdVar, boolean z, hq0 hq0Var, y50 y50Var) {
        Object objA = a(qdVar, new wv2(pdVar, qdVar.a, qdVar.b.getValue(), f, qdVar.c), z ? qdVar.e : Long.MIN_VALUE, hq0Var, y50Var);
        return objA == t70.a ? objA : q43.a;
    }

    public static /* synthetic */ Object c(qd qdVar, Float f, vq2 vq2Var, boolean z, hq0 hq0Var, y50 y50Var, int i) {
        if ((i & 2) != 0) {
            vq2Var = ie4.d(7, null);
        }
        vq2 vq2Var2 = vq2Var;
        if ((i & 8) != 0) {
            hq0Var = new xn2(6);
        }
        return b(qdVar, f, vq2Var2, z, hq0Var, y50Var);
    }

    public static final void d(od odVar, long j, float f, md mdVar, qd qdVar, hq0 hq0Var) {
        long jB = f == 0.0f ? mdVar.b() : (long) ((j - odVar.c) / f);
        odVar.g = j;
        odVar.e.setValue(mdVar.a(jB));
        odVar.f = mdVar.e(jB);
        if (mdVar.f(jB)) {
            odVar.h = odVar.g;
            odVar.i.setValue(Boolean.FALSE);
        }
        f(odVar, qdVar);
        hq0Var.j(odVar);
    }

    public static final float e(j70 j70Var) {
        nk1 nk1Var = (nk1) j70Var.v(su0.i);
        float fE = nk1Var != null ? nk1Var.E() : 1.0f;
        if (fE >= 0.0f) {
            return fE;
        }
        fz1.b("negative scale factor");
        return fE;
    }

    public static final void f(od odVar, qd qdVar) {
        qdVar.b.setValue(odVar.e.getValue());
        vd vdVar = qdVar.c;
        vd vdVar2 = odVar.f;
        int iB = vdVar.b();
        for (int i = 0; i < iB; i++) {
            vdVar.e(vdVar2.a(i), i);
        }
        qdVar.f = odVar.h;
        qdVar.e = odVar.g;
        qdVar.i = ((Boolean) odVar.i.getValue()).booleanValue();
    }
}
