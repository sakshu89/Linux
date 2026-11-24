package defpackage;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nm1 implements cp1 {
    public int a;
    public boolean b;
    public Object c;
    public Object e;
    public Object f;
    public final Object i;

    public nm1(Object obj) {
        this.c = new Object();
        this.a = 0;
        this.b = false;
        this.f = new HashMap();
        this.i = new CopyOnWriteArraySet();
        this.e = new AtomicReference(obj);
    }

    public boolean a(int i, int i2) {
        pm1 pm1Var = (pm1) this.e;
        int i3 = this.a;
        ck1 ck1Var = (ck1) pm1Var.a[i + i3];
        ck1 ck1Var2 = (ck1) ((pm1) this.f).a[i3 + i2];
        return g31.a(ck1Var, ck1Var2) || ck1Var.getClass() == ck1Var2.getClass();
    }

    @Override // defpackage.cp1
    public void f(Executor executor, bp1 bp1Var) {
        pr2 pr2Var;
        synchronized (this.c) {
            pr2 pr2Var2 = (pr2) ((HashMap) this.f).remove(bp1Var);
            if (pr2Var2 != null) {
                pr2Var2.c.set(false);
                ((CopyOnWriteArraySet) this.i).remove(pr2Var2);
            }
            pr2Var = new pr2((AtomicReference) this.e, executor, bp1Var);
            ((HashMap) this.f).put(bp1Var, pr2Var);
            ((CopyOnWriteArraySet) this.i).add(pr2Var);
        }
        pr2Var.a(0);
    }

    @Override // defpackage.cp1
    public void o(bp1 bp1Var) {
        synchronized (this.c) {
            pr2 pr2Var = (pr2) ((HashMap) this.f).remove(bp1Var);
            if (pr2Var != null) {
                pr2Var.c.set(false);
                ((CopyOnWriteArraySet) this.i).remove(pr2Var);
            }
        }
    }

    public nm1(zn1 zn1Var, dk1 dk1Var, int i, pm1 pm1Var, pm1 pm1Var2, boolean z) {
        this.i = zn1Var;
        this.c = dk1Var;
        this.a = i;
        this.e = pm1Var;
        this.f = pm1Var2;
        this.b = z;
    }
}
