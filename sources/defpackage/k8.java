package defpackage;

import android.content.Context;
import android.view.Choreographer;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class k8 extends k61 implements hq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k8(int i, Object obj, Object obj2) {
        super(1);
        this.b = i;
        this.c = obj;
        this.e = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.hq0
    public final Object j(Object obj) {
        i42 i42Var;
        q43 q43Var;
        int i = 1;
        int i2 = 0;
        switch (this.b) {
            case 0:
                Context context = (Context) this.c;
                Context applicationContext = context.getApplicationContext();
                l8 l8Var = (l8) this.e;
                applicationContext.registerComponentCallbacks(l8Var);
                return new j8(i2, context, l8Var);
            case 1:
                Context context2 = (Context) this.c;
                Context applicationContext2 = context2.getApplicationContext();
                m8 m8Var = (m8) this.e;
                applicationContext2.registerComponentCallbacks(m8Var);
                return new j8(i, context2, m8Var);
            case 2:
                return new m11((wa1) this.c, new ta(0, (ua) this.e));
            case 3:
                m11 m11Var = (m11) this.c;
                synchronized (m11Var.c) {
                    try {
                        m11Var.e = true;
                        pm1 pm1Var = m11Var.d;
                        Object[] objArr = pm1Var.a;
                        int i3 = pm1Var.c;
                        while (i2 < i3) {
                            to1 to1Var = (to1) ((m93) objArr[i2]).get();
                            if (to1Var != null && (i42Var = to1Var.b) != null) {
                                i42Var.closeConnection();
                                to1Var.b = null;
                            }
                            i2++;
                        }
                        m11Var.d.h();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                xy2 xy2Var = ((ua) this.e).b;
                xy2Var.b.set(null);
                xy2Var.a.f();
                return q43.a;
            case 4:
                yy1 yy1Var = (yy1) this.c;
                yy1Var.setPositionProvider((az1) this.e);
                yy1Var.l();
                return new ya(0);
            case 5:
                qc qcVar = (qc) this.c;
                rc rcVar = (rc) this.e;
                synchronized (qcVar.f) {
                    qcVar.j.remove(rcVar);
                }
                return q43.a;
            case 6:
                ((Choreographer) ((sc) this.c).b).removeFrameCallback((rc) this.e);
                return q43.a;
            case 7:
                yw1.n((yw1) obj, (zw1) this.c, ((pl) this.e).x);
                return q43.a;
            case 8:
                q43 q43Var2 = q43.a;
                Throwable th2 = (Throwable) obj;
                ((h6) this.c).j(th2);
                un unVar = (un) ((p6) this.e).c;
                unVar.i(th2, false);
                do {
                    Object objA = mx.a(unVar.p());
                    if (objA != null) {
                        ((li1) objA).b.t0(th2 == null ? new CancellationException("DataStore scope was cancelled before updateData could complete") : th2);
                        q43Var = q43Var2;
                    } else {
                        q43Var = null;
                    }
                } while (q43Var != null);
                return q43Var2;
            case 9:
                yw1.n((yw1) obj, (zw1) this.c, ((qk2) this.e).i0);
                return q43.a;
            default:
                f7 f7Var = (f7) obj;
                vq0 vq0Var = (vq0) this.e;
                pc3 pc3Var = (pc3) this.c;
                if (!pc3Var.c) {
                    qb1 qb1VarF = f7Var.a.f();
                    pc3Var.f = vq0Var;
                    if (pc3Var.e == null) {
                        pc3Var.e = qb1VarF;
                        qb1VarF.a(pc3Var);
                    } else if (qb1VarF.d.compareTo(eb1.c) >= 0) {
                        pc3Var.b.B(new w10(1330788943, true, new oc3(pc3Var, vq0Var, i)));
                    }
                }
                return q43.a;
        }
    }
}
