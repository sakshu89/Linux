package defpackage;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ut2 implements vq0 {
    public final /* synthetic */ ek1 a;
    public final /* synthetic */ yj2 b;
    public final /* synthetic */ long c;
    public final /* synthetic */ float e;
    public final /* synthetic */ w10 f;

    public ut2(ek1 ek1Var, yj2 yj2Var, long j, float f, w10 w10Var) {
        this.a = ek1Var;
        this.b = yj2Var;
        this.c = j;
        this.e = f;
        this.f = w10Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        x20 x20Var = (x20) obj;
        int iIntValue = ((Number) obj2).intValue();
        boolean zO = x20Var.O(iIntValue & 1, (iIntValue & 3) != 2);
        q43 q43Var = q43.a;
        if (!zO) {
            x20Var.R();
            return q43Var;
        }
        ek1 ek1VarA = wt2.a(this.a, this.b, wt2.b(this.c, this.e, x20Var), null, ((jc0) x20Var.j(l30.h)).x(0.0f));
        Object objL = x20Var.L();
        xy xyVar = r20.a;
        if (objL == xyVar) {
            objL = new xn2(5);
            x20Var.g0(objL);
        }
        AtomicInteger atomicInteger = dg2.a;
        ek1 ek1VarC = ek1VarA.c(new uf((hq0) objL, false));
        Object objL2 = x20Var.L();
        if (objL2 == xyVar) {
            objL2 = tt2.a;
            x20Var.g0(objL2);
        }
        ek1 ek1VarA2 = pu2.a(ek1VarC, q43Var, (PointerInputEventHandler) objL2);
        oh1 oh1VarD = gm.d(xy.b, true);
        int iHashCode = Long.hashCode(x20Var.T);
        gw1 gw1VarL = x20Var.l();
        ek1 ek1VarC2 = gj4.c(x20Var, ek1VarA2);
        o20.p.getClass();
        k30 k30Var = n20.b;
        x20Var.Z();
        if (x20Var.S) {
            x20Var.k(k30Var);
        } else {
            x20Var.j0();
        }
        ie4.c(x20Var, n20.f, oh1VarD);
        ie4.c(x20Var, n20.e, gw1VarL);
        jd jdVar = n20.g;
        if (x20Var.S || !g31.a(x20Var.L(), Integer.valueOf(iHashCode))) {
            x20Var.g0(Integer.valueOf(iHashCode));
            x20Var.b(jdVar, Integer.valueOf(iHashCode));
        }
        ie4.c(x20Var, n20.d, ek1VarC2);
        this.f.e(x20Var, 0);
        x20Var.p(true);
        return q43Var;
    }
}
