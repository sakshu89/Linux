package defpackage;

import android.os.Looper;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class jd1 {
    public static final Object k = new Object();
    public final Object a;
    public final v92 b;
    public int c;
    public boolean d;
    public volatile Object e;
    public volatile Object f;
    public int g;
    public boolean h;
    public boolean i;
    public final o7 j;

    public jd1() {
        this.a = new Object();
        this.b = new v92();
        this.c = 0;
        Object obj = k;
        this.f = obj;
        this.j = new o7(6, this);
        this.e = obj;
        this.g = -1;
    }

    public static void a(String str) {
        zf.a().j.getClass();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        og.n(cq.v("Cannot invoke ", str, " on a background thread"));
    }

    public final void b(id1 id1Var) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (id1Var != null) {
                if (id1Var.b) {
                    int i = id1Var.c;
                    int i2 = this.g;
                    if (i < i2) {
                        id1Var.c = i2;
                        id1Var.a.u(this.e);
                    }
                }
                id1Var = null;
            } else {
                v92 v92Var = this.b;
                v92Var.getClass();
                t92 t92Var = new t92(v92Var);
                v92Var.c.put(t92Var, Boolean.FALSE);
                while (t92Var.hasNext()) {
                    id1 id1Var2 = (id1) ((Map.Entry) t92Var.next()).getValue();
                    if (id1Var2.b) {
                        int i3 = id1Var2.c;
                        int i4 = this.g;
                        if (i3 < i4) {
                            id1Var2.c = i4;
                            id1Var2.a.u(this.e);
                        }
                    }
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.h = false;
    }

    public Object c() {
        Object obj = this.e;
        if (obj != k) {
            return obj;
        }
        return null;
    }

    public final void d(dp1 dp1Var) {
        Object obj;
        a("observeForever");
        id1 id1Var = new id1(this, dp1Var);
        v92 v92Var = this.b;
        s92 s92VarA = v92Var.a(dp1Var);
        if (s92VarA != null) {
            obj = s92VarA.b;
        } else {
            s92 s92Var = new s92(dp1Var, id1Var);
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
        if (((id1) obj) != null) {
            return;
        }
        id1Var.a(true);
    }

    public final void g(dp1 dp1Var) {
        a("removeObserver");
        id1 id1Var = (id1) this.b.b(dp1Var);
        if (id1Var == null) {
            return;
        }
        id1Var.a(false);
    }

    public abstract void h(Object obj);

    public void e() {
    }

    public void f() {
    }

    public jd1(Object obj) {
        this.a = new Object();
        this.b = new v92();
        this.c = 0;
        this.f = k;
        this.j = new o7(6, this);
        this.e = obj;
        this.g = 0;
    }
}
