package defpackage;

import android.graphics.Rect;
import android.view.View;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ba implements by1 {
    public pa1 a;
    public yq2 b;
    public wa1 c;
    public hk2 d;

    @Override // defpackage.by1
    public final void a(ty2 ty2Var, mp1 mp1Var, gz2 gz2Var, gn gnVar, l42 l42Var, l42 l42Var2) {
        wa1 wa1Var = this.c;
        if (wa1Var != null) {
            qa1 qa1Var = wa1Var.m;
            synchronized (qa1Var.c) {
                try {
                    qa1Var.j = ty2Var;
                    qa1Var.l = mp1Var;
                    qa1Var.k = gz2Var;
                    qa1Var.m = l42Var;
                    qa1Var.n = l42Var2;
                    if (qa1Var.e || qa1Var.d) {
                        qa1Var.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // defpackage.by1
    public final void b() {
        j(null);
    }

    @Override // defpackage.by1
    public final void c(ty2 ty2Var, ty2 ty2Var2) {
        wa1 wa1Var = this.c;
        if (wa1Var != null) {
            boolean z = (oz2.b(wa1Var.h.b, ty2Var2.b) && g31.a(wa1Var.h.c, ty2Var2.c)) ? false : true;
            wa1Var.h = ty2Var2;
            int size = wa1Var.j.size();
            for (int i = 0; i < size; i++) {
                i42 i42Var = (i42) ((WeakReference) wa1Var.j.get(i)).get();
                if (i42Var != null) {
                    i42Var.g = ty2Var2;
                }
            }
            qa1 qa1Var = wa1Var.m;
            synchronized (qa1Var.c) {
                qa1Var.j = null;
                qa1Var.l = null;
                qa1Var.k = null;
                qa1Var.m = null;
                qa1Var.n = null;
            }
            if (g31.a(ty2Var, ty2Var2)) {
                if (z) {
                    l11 l11Var = wa1Var.b;
                    int iF = oz2.f(ty2Var2.b);
                    int iE = oz2.e(ty2Var2.b);
                    oz2 oz2Var = wa1Var.h.c;
                    int iF2 = oz2Var != null ? oz2.f(oz2Var.a) : -1;
                    oz2 oz2Var2 = wa1Var.h.c;
                    l11Var.y().updateSelection((View) l11Var.b, iF, iE, iF2, oz2Var2 != null ? oz2.e(oz2Var2.a) : -1);
                    return;
                }
                return;
            }
            if (ty2Var != null && (!g31.a(ty2Var.a.b, ty2Var2.a.b) || (oz2.b(ty2Var.b, ty2Var2.b) && !g31.a(ty2Var.c, ty2Var2.c)))) {
                l11 l11Var2 = wa1Var.b;
                l11Var2.y().restartInput((View) l11Var2.b);
                return;
            }
            int size2 = wa1Var.j.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i42 i42Var2 = (i42) ((WeakReference) wa1Var.j.get(i2)).get();
                if (i42Var2 != null) {
                    ty2 ty2Var3 = wa1Var.h;
                    l11 l11Var3 = wa1Var.b;
                    if (i42Var2.k) {
                        i42Var2.g = ty2Var3;
                        if (i42Var2.i) {
                            l11Var3.y().updateExtractedText((View) l11Var3.b, i42Var2.h, oy3.a(ty2Var3));
                        }
                        oz2 oz2Var3 = ty2Var3.c;
                        long j = ty2Var3.b;
                        int iF3 = oz2Var3 != null ? oz2.f(oz2Var3.a) : -1;
                        oz2 oz2Var4 = ty2Var3.c;
                        l11Var3.y().updateSelection((View) l11Var3.b, oz2.f(j), oz2.e(j), iF3, oz2Var4 != null ? oz2.e(oz2Var4.a) : -1);
                    }
                }
            }
        }
    }

    @Override // defpackage.by1
    public final void d() {
        zm2 zm2Var;
        pa1 pa1Var = this.a;
        if (pa1Var == null || (zm2Var = (zm2) ij4.a(pa1Var, l30.p)) == null) {
            return;
        }
        ((ac0) zm2Var).b();
    }

    @Override // defpackage.by1
    public final void e() {
        zm2 zm2Var;
        pa1 pa1Var = this.a;
        if (pa1Var == null || (zm2Var = (zm2) ij4.a(pa1Var, l30.p)) == null) {
            return;
        }
        ((ac0) zm2Var).a();
    }

    @Override // defpackage.by1
    public final void f() throws IllegalAccessException, InvocationTargetException {
        yq2 yq2Var = this.b;
        if (yq2Var != null) {
            yq2Var.e(null);
        }
        this.b = null;
        km1 km1VarI = i();
        if (km1VarI != null) {
            hk2 hk2Var = (hk2) km1VarI;
            synchronized (hk2Var) {
                hk2Var.u(hk2Var.o() + ((long) hk2Var.t), hk2Var.s, hk2Var.o() + ((long) hk2Var.t), hk2Var.o() + ((long) hk2Var.t) + ((long) hk2Var.u));
            }
        }
    }

    @Override // defpackage.by1
    public final void g(l42 l42Var) {
        Rect rect;
        wa1 wa1Var = this.c;
        if (wa1Var != null) {
            wa1Var.l = new Rect(hh1.f(l42Var.a), hh1.f(l42Var.b), hh1.f(l42Var.c), hh1.f(l42Var.d));
            if (!wa1Var.j.isEmpty() || (rect = wa1Var.l) == null) {
                return;
            }
            wa1Var.a.requestRectangleOnScreen(new Rect(rect));
        }
    }

    @Override // defpackage.by1
    public final void h(ty2 ty2Var, kz0 kz0Var, e2 e2Var, q60 q60Var) {
        j(new w9(ty2Var, this, kz0Var, e2Var, q60Var, 0));
    }

    public final km1 i() {
        hk2 hk2Var = this.d;
        if (hk2Var != null) {
            return hk2Var;
        }
        if (!ns2.a) {
            return null;
        }
        hk2 hk2VarA = s44.a(0, 2, nn.c);
        this.d = hk2VarA;
        return hk2VarA;
    }

    public final void j(w9 w9Var) {
        pa1 pa1Var = this.a;
        if (pa1Var == null) {
            return;
        }
        yq2 yq2Var = null;
        this.b = pa1Var.w ? uf4.b(pa1Var.w0(), null, new p0(pa1Var, new aa(w9Var, this, pa1Var, yq2Var, 0), yq2Var, 21), 1) : null;
    }

    public final void k(pa1 pa1Var) {
        if (!(this.a == pa1Var)) {
            c11.c("Expected textInputModifierNode to be " + pa1Var + " but was " + this.a);
        }
        this.a = null;
    }
}
