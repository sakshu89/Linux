package defpackage;

import android.graphics.Rect;
import android.view.Choreographer;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zy2 implements by1 {
    public final View a;
    public final kf b;
    public final az2 c;
    public boolean d;
    public hq0 e;
    public hq0 f;
    public ty2 g;
    public kz0 h;
    public final ArrayList i;
    public final f81 j;
    public Rect k;
    public final j80 l;
    public final pm1 m;
    public s7 n;

    public zy2(View view, r7 r7Var) {
        kf kfVar = new kf(view);
        az2 az2Var = new az2(Choreographer.getInstance());
        this.a = view;
        this.b = kfVar;
        this.c = az2Var;
        this.e = kt1.x;
        this.f = kt1.H;
        this.g = new ty2(4, oz2.b, "");
        this.h = kz0.g;
        this.i = new ArrayList();
        this.j = yp4.a(new ta(17, this));
        this.l = new j80(r7Var, kfVar);
        this.m = new pm1(new yy2[16]);
    }

    @Override // defpackage.by1
    public final void a(ty2 ty2Var, mp1 mp1Var, gz2 gz2Var, gn gnVar, l42 l42Var, l42 l42Var2) {
        j80 j80Var = this.l;
        synchronized (j80Var.c) {
            try {
                j80Var.j = ty2Var;
                j80Var.l = mp1Var;
                j80Var.k = gz2Var;
                j80Var.m = gnVar;
                j80Var.n = l42Var;
                j80Var.o = l42Var2;
                if (j80Var.e || j80Var.d) {
                    j80Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.by1
    public final void b() {
        i(yy2.a);
    }

    @Override // defpackage.by1
    public final void c(ty2 ty2Var, ty2 ty2Var2) {
        boolean z = (oz2.b(this.g.b, ty2Var2.b) && g31.a(this.g.c, ty2Var2.c)) ? false : true;
        this.g = ty2Var2;
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            h42 h42Var = (h42) ((WeakReference) this.i.get(i)).get();
            if (h42Var != null) {
                h42Var.d = ty2Var2;
            }
        }
        j80 j80Var = this.l;
        synchronized (j80Var.c) {
            j80Var.j = null;
            j80Var.l = null;
            j80Var.k = null;
            j80Var.m = j7.H;
            j80Var.n = null;
            j80Var.o = null;
        }
        if (g31.a(ty2Var, ty2Var2)) {
            if (z) {
                kf kfVar = this.b;
                int iF = oz2.f(ty2Var2.b);
                int iE = oz2.e(ty2Var2.b);
                oz2 oz2Var = this.g.c;
                int iF2 = oz2Var != null ? oz2.f(oz2Var.a) : -1;
                oz2 oz2Var2 = this.g.c;
                ((InputMethodManager) ((f81) kfVar.c).getValue()).updateSelection((View) kfVar.b, iF, iE, iF2, oz2Var2 != null ? oz2.e(oz2Var2.a) : -1);
                return;
            }
            return;
        }
        if (ty2Var != null && (!g31.a(ty2Var.a.b, ty2Var2.a.b) || (oz2.b(ty2Var.b, ty2Var2.b) && !g31.a(ty2Var.c, ty2Var2.c)))) {
            kf kfVar2 = this.b;
            ((InputMethodManager) ((f81) kfVar2.c).getValue()).restartInput((View) kfVar2.b);
            return;
        }
        int size2 = this.i.size();
        for (int i2 = 0; i2 < size2; i2++) {
            h42 h42Var2 = (h42) ((WeakReference) this.i.get(i2)).get();
            if (h42Var2 != null) {
                ty2 ty2Var3 = this.g;
                kf kfVar3 = this.b;
                if (h42Var2.h) {
                    h42Var2.d = ty2Var3;
                    if (h42Var2.f) {
                        ((InputMethodManager) ((f81) kfVar3.c).getValue()).updateExtractedText((View) kfVar3.b, h42Var2.e, zo4.a(ty2Var3));
                    }
                    oz2 oz2Var3 = ty2Var3.c;
                    long j = ty2Var3.b;
                    int iF3 = oz2Var3 != null ? oz2.f(oz2Var3.a) : -1;
                    oz2 oz2Var4 = ty2Var3.c;
                    ((InputMethodManager) ((f81) kfVar3.c).getValue()).updateSelection((View) kfVar3.b, oz2.f(j), oz2.e(j), iF3, oz2Var4 != null ? oz2.e(oz2Var4.a) : -1);
                }
            }
        }
    }

    @Override // defpackage.by1
    public final void d() {
        i(yy2.c);
    }

    @Override // defpackage.by1
    public final void e() {
        i(yy2.e);
    }

    @Override // defpackage.by1
    public final void f() {
        this.d = false;
        this.e = kt1.X;
        this.f = kt1.Y;
        this.k = null;
        i(yy2.b);
    }

    @Override // defpackage.by1
    public final void g(l42 l42Var) {
        Rect rect;
        this.k = new Rect(hh1.f(l42Var.a), hh1.f(l42Var.b), hh1.f(l42Var.c), hh1.f(l42Var.d));
        if (!this.i.isEmpty() || (rect = this.k) == null) {
            return;
        }
        this.a.requestRectangleOnScreen(new Rect(rect));
    }

    @Override // defpackage.by1
    public final void h(ty2 ty2Var, kz0 kz0Var, e2 e2Var, q60 q60Var) {
        this.d = true;
        this.g = ty2Var;
        this.h = kz0Var;
        this.e = e2Var;
        this.f = q60Var;
        i(yy2.a);
    }

    public final void i(yy2 yy2Var) {
        this.m.b(yy2Var);
        if (this.n == null) {
            s7 s7Var = new s7(29, this);
            this.c.execute(s7Var);
            this.n = s7Var;
        }
    }
}
