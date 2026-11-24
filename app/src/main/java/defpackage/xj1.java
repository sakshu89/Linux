package defpackage;

import android.graphics.Bitmap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xj1 {
    public static Object a(Bitmap bitmap, y50 y50Var) {
        yv yvVar = new yv(1, fp4.b(y50Var));
        yvVar.x();
        try {
            nl4 nl4VarA = jc4.a(qz2.c);
            int i = 0;
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
            yvVar.z(new vj1(atomicBoolean2, atomicBoolean, nl4VarA));
            try {
                et4 et4VarE = nl4VarA.e(k11.a(bitmap));
                wj1 wj1Var = new wj1(i, new o2(yvVar, atomicBoolean2));
                et4VarE.getClass();
                s9 s9Var = et4VarE.b;
                w31 w31Var = jw2.a;
                s9Var.o(new xd4(w31Var, wj1Var));
                et4VarE.i();
                s9Var.o(new xd4((Executor) w31Var, (eq1) new q91(6, atomicBoolean2, yvVar)));
                et4VarE.i();
                s9Var.o(new xd4((Executor) w31Var, (cq1) new q91(7, atomicBoolean, nl4VarA)));
                et4VarE.i();
            } catch (Throwable unused) {
                if (atomicBoolean.compareAndSet(false, true)) {
                    nl4VarA.close();
                }
                if (atomicBoolean2.compareAndSet(false, true)) {
                    yvVar.h(null);
                }
            }
        } catch (Exception unused2) {
            yvVar.h(null);
        }
        return yvVar.v();
    }
}
