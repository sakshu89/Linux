package defpackage;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ar extends pl1 {
    public v92 l = new v92();
    public jd1 m;
    public final vh n;

    public ar(vh vhVar) {
        this.n = vhVar;
    }

    @Override // defpackage.jd1
    public final Object c() {
        jd1 jd1Var = this.m;
        return jd1Var == null ? this.n : jd1Var.c();
    }

    @Override // defpackage.jd1
    public final void e() {
        Iterator it = this.l.iterator();
        while (true) {
            r92 r92Var = (r92) it;
            if (!r92Var.hasNext()) {
                return;
            } else {
                ((ki1) ((Map.Entry) r92Var.next()).getValue()).a();
            }
        }
    }

    @Override // defpackage.jd1
    public final void f() {
        Iterator it = this.l.iterator();
        while (true) {
            r92 r92Var = (r92) it;
            if (!r92Var.hasNext()) {
                return;
            }
            ki1 ki1Var = (ki1) ((Map.Entry) r92Var.next()).getValue();
            ki1Var.a.g(ki1Var);
        }
    }

    public final void j(pl1 pl1Var) {
        Object obj;
        ki1 ki1Var;
        v92 v92Var = this.l;
        jd1 jd1Var = this.m;
        if (jd1Var != null && (ki1Var = (ki1) v92Var.b(jd1Var)) != null) {
            ki1Var.a.g(ki1Var);
        }
        this.m = pl1Var;
        zq zqVar = new zq(0, this);
        if (pl1Var == null) {
            dk0.n("source cannot be null");
            return;
        }
        ki1 ki1Var2 = new ki1(pl1Var, zqVar);
        s92 s92VarA = v92Var.a(pl1Var);
        if (s92VarA != null) {
            obj = s92VarA.b;
        } else {
            s92 s92Var = new s92(pl1Var, ki1Var2);
            v92Var.e++;
            s92 s92Var2 = v92Var.b;
            if (s92Var2 == null) {
                v92Var.a = s92Var;
                v92Var.b = s92Var;
            } else {
                s92Var2.c = s92Var;
                s92Var.e = s92Var2;
                v92Var.b = s92Var;
            }
            obj = null;
        }
        ki1 ki1Var3 = (ki1) obj;
        if (ki1Var3 != null && ki1Var3.b != zqVar) {
            og.i("This source was already added with the different observer");
        } else if (ki1Var3 == null && this.c > 0) {
            ki1Var2.a();
        }
    }
}
