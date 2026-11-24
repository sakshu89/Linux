package defpackage;

import android.view.Choreographer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sc implements h70 {
    public final /* synthetic */ int a;
    public final Object b;
    public final Object c;

    public sc(sc scVar) {
        this.a = 2;
        this.b = scVar;
        this.c = new a50(1);
    }

    @Override // defpackage.j70
    public final j70 D(i70 i70Var) {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
        }
        return pl4.b(this, i70Var);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0019  */
    public final Object a(hq0 hq0Var, x50 x50Var) {
        jv1 jv1Var;
        boolean z;
        Object objV;
        switch (this.a) {
            case 0:
                qc qcVar = (qc) this.c;
                yv yvVar = new yv(1, fp4.b(x50Var));
                yvVar.x();
                rc rcVar = new rc(yvVar, this, hq0Var);
                if (g31.a(qcVar.c, (Choreographer) this.b)) {
                    synchronized (qcVar.f) {
                        qcVar.j.add(rcVar);
                        if (!qcVar.s) {
                            qcVar.s = true;
                            qcVar.c.postFrameCallback(qcVar.t);
                        }
                        break;
                    }
                    yvVar.z(new k8(5, qcVar, rcVar));
                } else {
                    ((Choreographer) this.b).postFrameCallback(rcVar);
                    yvVar.z(new k8(6, this, rcVar));
                }
                return yvVar.v();
            case 1:
                yv yvVar2 = new yv(1, fp4.b(x50Var));
                yvVar2.x();
                cj cjVar = (cj) this.c;
                fn fnVar = new fn();
                fnVar.a = yvVar2;
                fnVar.b = hq0Var;
                yvVar2.z(new gn(0, cjVar.e(fnVar, (b42) this.b)));
                return yvVar2.v();
            default:
                if (x50Var instanceof jv1) {
                    jv1Var = (jv1) x50Var;
                    int i = jv1Var.j;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        jv1Var.j = i - Integer.MIN_VALUE;
                    } else {
                        jv1Var = new jv1(this, x50Var);
                    }
                } else {
                    jv1Var = new jv1(this, x50Var);
                }
                Object obj = jv1Var.f;
                t70 t70Var = t70.a;
                int i2 = jv1Var.j;
                int i3 = 2;
                if (i2 == 0) {
                    bz3.g(obj);
                    a50 a50Var = (a50) this.c;
                    jv1Var.e = hq0Var;
                    jv1Var.j = 1;
                    synchronized (a50Var.c) {
                        z = a50Var.b;
                    }
                    if (z) {
                        objV = q43.a;
                    } else {
                        yv yvVar3 = new yv(1, fp4.b(jv1Var));
                        yvVar3.x();
                        synchronized (a50Var.c) {
                            ((ArrayList) a50Var.d).add(yvVar3);
                        }
                        yvVar3.z(new b70(i3, a50Var, yvVar3));
                        objV = yvVar3.v();
                        if (objV != t70Var) {
                            objV = q43.a;
                        }
                    }
                    if (objV != t70Var) {
                    }
                    return t70Var;
                }
                if (i2 != 1) {
                    if (i2 == 2) {
                        bz3.g(obj);
                        return obj;
                    }
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                hq0Var = jv1Var.e;
                bz3.g(obj);
                sc scVar = (sc) this.b;
                jv1Var.e = null;
                jv1Var.j = 2;
                Object objA = scVar.a(hq0Var, jv1Var);
                if (objA != t70Var) {
                    return objA;
                }
                return t70Var;
        }
    }

    @Override // defpackage.h70
    public i70 getKey() {
        return xy.X;
    }

    @Override // defpackage.j70
    public final j70 r(j70 j70Var) {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
        }
        return pl4.c(this, j70Var);
    }

    @Override // defpackage.j70
    public final h70 v(i70 i70Var) {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
        }
        return pl4.a(this, i70Var);
    }

    @Override // defpackage.j70
    public final Object y(vq0 vq0Var, Object obj) {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
        }
        return vq0Var.e(obj, this);
    }

    public sc(Choreographer choreographer, qc qcVar) {
        this.a = 0;
        this.b = choreographer;
        this.c = qcVar;
    }

    public sc(b42 b42Var) {
        this.a = 1;
        this.b = b42Var;
        this.c = new cj(2);
    }
}
