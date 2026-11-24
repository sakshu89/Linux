package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class st2 {
    public final int a;
    public final Matrix b;
    public final boolean c;
    public final Rect d;
    public final boolean e;
    public final int f;
    public final fj g;
    public int h;
    public int i;
    public fu2 k;
    public rt2 l;
    public boolean j = false;
    public final HashSet m = new HashSet();
    public boolean n = false;
    public final ArrayList o = new ArrayList();

    public st2(int i, int i2, fj fjVar, Matrix matrix, boolean z, Rect rect, int i3, int i4, boolean z2) {
        this.f = i;
        this.a = i2;
        this.g = fjVar;
        this.b = matrix;
        this.c = z;
        this.d = rect;
        this.i = i3;
        this.h = i4;
        this.e = z2;
        this.l = new rt2(fjVar.a, i2);
    }

    public final void a() {
        hh1.e("Edge is already closed.", !this.n);
    }

    public final void b() {
        vc4.b();
        this.l.a();
        this.n = true;
    }

    public final fu2 c(wt wtVar, boolean z) {
        vc4.b();
        a();
        fj fjVar = this.g;
        Size size = fjVar.a;
        ig0 ig0Var = fjVar.b;
        int i = 0;
        fu2 fu2Var = new fu2(size, wtVar, z, ig0Var, new mt2(this, 0));
        try {
            nz0 nz0Var = fu2Var.k;
            rt2 rt2Var = this.l;
            Objects.requireNonNull(rt2Var);
            if (rt2Var.g(nz0Var, new nt2(rt2Var, i))) {
                oz3.e(rt2Var.e).a(new ot2(nz0Var, 0), xg4.a());
            }
            this.k = fu2Var;
            e();
            return fu2Var;
        } catch (RuntimeException e) {
            fu2Var.c();
            throw e;
        } catch (nb0 e2) {
            throw new AssertionError("Surface is somehow already closed", e2);
        }
    }

    public final void d() {
        boolean z;
        vc4.b();
        a();
        rt2 rt2Var = this.l;
        rt2Var.getClass();
        vc4.b();
        if (rt2Var.q == null) {
            synchronized (rt2Var.a) {
                z = rt2Var.c;
            }
            if (!z) {
                return;
            }
        }
        this.j = false;
        this.l.a();
        this.l = new rt2(this.g.a, this.a);
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public final void e() {
        eu2 eu2Var;
        Executor executor;
        vc4.b();
        lj ljVar = new lj(this.d, this.i, this.h, this.c, this.b, this.e);
        fu2 fu2Var = this.k;
        int i = 0;
        if (fu2Var != null) {
            synchronized (fu2Var.a) {
                fu2Var.l = ljVar;
                eu2Var = fu2Var.m;
                executor = fu2Var.n;
            }
            if (eu2Var != null && executor != null) {
                executor.execute(new au2(eu2Var, ljVar, 0));
            }
        }
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((s40) obj).accept(ljVar);
        }
    }
}
