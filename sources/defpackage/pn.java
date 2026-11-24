package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pn implements j93 {
    public Object a = wn.p;
    public yv b;
    public final /* synthetic */ un c;

    public pn(un unVar) {
        this.c = unVar;
    }

    @Override // defpackage.j93
    public final void a(af2 af2Var, int i) {
        yv yvVar = this.b;
        if (yvVar != null) {
            yvVar.a(af2Var, i);
        }
    }

    public final Object b(y50 y50Var) throws Throwable {
        nx nxVarQ;
        Object obj = this.a;
        boolean z = true;
        if (obj == wn.p || obj == wn.l) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = un.j;
            un unVar = this.c;
            nx nxVar = (nx) atomicReferenceFieldUpdater.get(unVar);
            while (!unVar.C()) {
                long andIncrement = un.c.getAndIncrement(unVar);
                long j = wn.b;
                long j2 = andIncrement / j;
                int i = (int) (andIncrement % j);
                if (nxVar.f != j2) {
                    nxVarQ = unVar.q(j2, nxVar);
                    if (nxVarQ == null) {
                        continue;
                    }
                } else {
                    nxVarQ = nxVar;
                }
                Object objR = unVar.R(nxVarQ, i, andIncrement, null);
                py0 py0Var = wn.m;
                if (objR == py0Var) {
                    og.n("unreachable");
                    return null;
                }
                py0 py0Var2 = wn.o;
                if (objR == py0Var2) {
                    if (andIncrement < unVar.w()) {
                        nxVarQ.a();
                    }
                    nxVar = nxVarQ;
                } else {
                    if (objR == wn.n) {
                        un unVar2 = this.c;
                        yv yvVarA = zg4.a(fp4.b(y50Var));
                        try {
                            this.b = yvVarA;
                            Object objR2 = unVar2.R(nxVarQ, i, andIncrement, this);
                            if (objR2 != py0Var) {
                                if (objR2 == py0Var2) {
                                    if (andIncrement < unVar2.w()) {
                                        nxVarQ.a();
                                    }
                                    nx nxVar2 = (nx) un.j.get(unVar2);
                                    while (true) {
                                        if (unVar2.C()) {
                                            yv yvVar = this.b;
                                            yvVar.getClass();
                                            this.b = null;
                                            this.a = wn.l;
                                            Throwable thT = unVar.t();
                                            if (thT != null) {
                                                yvVar.h(new h72(thT));
                                                break;
                                            }
                                            yvVar.h(Boolean.FALSE);
                                            break;
                                        }
                                        long andIncrement2 = un.c.getAndIncrement(unVar2);
                                        long j3 = wn.b;
                                        long j4 = andIncrement2 / j3;
                                        int i2 = (int) (andIncrement2 % j3);
                                        if (nxVar2.f != j4) {
                                            nx nxVarQ2 = unVar2.q(j4, nxVar2);
                                            if (nxVarQ2 != null) {
                                                nxVar2 = nxVarQ2;
                                            }
                                        }
                                        Object objR3 = unVar2.R(nxVar2, i2, andIncrement2, this);
                                        if (objR3 == wn.m) {
                                            a(nxVar2, i2);
                                            break;
                                        }
                                        if (objR3 == wn.o) {
                                            if (andIncrement2 < unVar2.w()) {
                                                nxVar2.a();
                                            }
                                        } else {
                                            if (objR3 == wn.n) {
                                                throw new IllegalStateException("unexpected");
                                            }
                                            nxVar2.a();
                                            this.a = objR3;
                                            this.b = null;
                                        }
                                    }
                                } else {
                                    nxVarQ.a();
                                    this.a = objR2;
                                    this.b = null;
                                }
                                yvVarA.i(Boolean.TRUE, null);
                                break;
                            }
                            a(nxVarQ, i);
                            return yvVarA.v();
                        } catch (Throwable th) {
                            yvVarA.E();
                            throw th;
                        }
                    }
                    nxVarQ.a();
                    this.a = objR;
                }
            }
            this.a = wn.l;
            Throwable thT2 = unVar.t();
            if (thT2 != null) {
                int i3 = xq2.a;
                throw thT2;
            }
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public final Object c() throws Throwable {
        Object obj = this.a;
        py0 py0Var = wn.p;
        if (obj == py0Var) {
            og.n("`hasNext()` has not been invoked");
            return null;
        }
        this.a = py0Var;
        if (obj != wn.l) {
            return obj;
        }
        Throwable thU = this.c.u();
        int i = xq2.a;
        throw thU;
    }
}
