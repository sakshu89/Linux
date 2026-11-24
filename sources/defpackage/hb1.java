package defpackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hb1 implements nb1 {
    public final cj a;
    public final ob1 b;

    public hb1(ob1 ob1Var, cj cjVar) {
        this.b = ob1Var;
        this.a = cjVar;
    }

    @hq1(db1.ON_DESTROY)
    public void onDestroy(ob1 ob1Var) {
        cj cjVar = this.a;
        synchronized (cjVar.b) {
            try {
                hb1 hb1VarR = cjVar.r(ob1Var);
                if (hb1VarR == null) {
                    return;
                }
                cjVar.G(ob1Var);
                Iterator it = ((Set) ((HashMap) cjVar.e).get(hb1VarR)).iterator();
                while (it.hasNext()) {
                    ((HashMap) cjVar.c).remove((oi) it.next());
                }
                ((HashMap) cjVar.e).remove(hb1VarR);
                hb1VarR.b.f().f(hb1VarR);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @hq1(db1.ON_START)
    public void onStart(ob1 ob1Var) {
        this.a.F(ob1Var);
    }

    @hq1(db1.ON_STOP)
    public void onStop(ob1 ob1Var) {
        this.a.G(ob1Var);
    }
}
