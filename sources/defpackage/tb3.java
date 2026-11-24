package defpackage;

import android.graphics.Path;
import android.os.Build;
import android.view.View;
import com.project.sonic.R;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tb3 {
    public static final WeakHashMap v = new WeakHashMap();
    public final yc a;
    public final yc b;
    public final yc c;
    public final yc d;
    public final yc e;
    public final yc f;
    public final yc g;
    public final yc h;
    public final yc i;
    public final i63 j;
    public final ku1 k;
    public final i63 l;
    public final i63 m;
    public final i63 n;
    public final i63 o;
    public final i63 p;
    public final i63 q;
    public final i63 r;
    public final boolean s;
    public int t;
    public final t11 u;

    public tb3(View view) {
        yc ycVarH = qs4.h(4, "captionBar");
        this.a = ycVarH;
        yc ycVarH2 = qs4.h(128, "displayCutout");
        this.b = ycVarH2;
        yc ycVarH3 = qs4.h(8, "ime");
        this.c = ycVarH3;
        yc ycVarH4 = qs4.h(32, "mandatorySystemGestures");
        this.d = ycVarH4;
        yc ycVarH5 = qs4.h(2, "navigationBars");
        this.e = ycVarH5;
        yc ycVarH6 = qs4.h(1, "statusBars");
        this.f = ycVarH6;
        yc ycVarH7 = qs4.h(519, "systemBars");
        this.g = ycVarH7;
        yc ycVarH8 = qs4.h(16, "systemGestures");
        this.h = ycVarH8;
        yc ycVarH9 = qs4.h(64, "tappableElement");
        this.i = ycVarH9;
        i63 i63Var = new i63(new v11(0, 0, 0, 0), "waterfall");
        this.j = i63Var;
        this.k = o44.g(null);
        new p43(new p43(ycVarH7, ycVarH3), ycVarH2);
        new p43(new p43(new p43(ycVarH9, ycVarH4), ycVarH8), i63Var);
        this.l = qs4.l(4, "captionBarIgnoringVisibility");
        this.m = qs4.l(2, "navigationBarsIgnoringVisibility");
        this.n = qs4.l(1, "statusBarsIgnoringVisibility");
        this.o = qs4.l(519, "systemBarsIgnoringVisibility");
        this.p = qs4.l(64, "tappableElementIgnoringVisibility");
        this.q = new i63(new v11(0, 0, 0, 0), "imeAnimationTarget");
        this.r = new i63(new v11(0, 0, 0, 0), "imeAnimationSource");
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        Object tag = view2 != null ? view2.getTag(R.id.consume_window_insets_tag) : null;
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        this.s = bool != null ? bool.booleanValue() : false;
        this.u = new t11(this);
        int i = u73.a;
        pb3 pb3VarA = p73.a(view);
        if (pb3VarA != null) {
            lb3 lb3Var = pb3VarA.a;
            ycVarH.f(lb3Var.o(4));
            ycVarH2.f(lb3Var.o(128));
            ycVarH3.f(lb3Var.o(8));
            ycVarH4.f(lb3Var.o(32));
            ycVarH5.f(lb3Var.o(2));
            ycVarH6.f(lb3Var.o(1));
            ycVarH7.f(lb3Var.o(519));
            ycVarH8.f(lb3Var.o(16));
            ycVarH9.f(lb3Var.o(64));
        }
    }

    public static void a(tb3 tb3Var, pb3 pb3Var) {
        boolean z = false;
        tb3Var.a.g(pb3Var, 0);
        tb3Var.c.g(pb3Var, 0);
        tb3Var.b.g(pb3Var, 0);
        tb3Var.e.g(pb3Var, 0);
        tb3Var.f.g(pb3Var, 0);
        tb3Var.g.g(pb3Var, 0);
        tb3Var.h.g(pb3Var, 0);
        tb3Var.i.g(pb3Var, 0);
        tb3Var.d.g(pb3Var, 0);
        tb3Var.l.f(uf4.c(pb3Var.a.g(4)));
        tb3Var.m.f(uf4.c(pb3Var.a.g(2)));
        tb3Var.n.f(uf4.c(pb3Var.a.g(1)));
        tb3Var.o.f(uf4.c(pb3Var.a.g(519)));
        tb3Var.p.f(uf4.c(pb3Var.a.g(64)));
        md0 md0VarE = pb3Var.a.e();
        tb3Var.j.f(uf4.c(md0VarE != null ? md0VarE.a() : q11.e));
        na naVar = null;
        if (md0VarE != null) {
            Path pathB = Build.VERSION.SDK_INT >= 31 ? le.b(md0VarE.a) : null;
            if (pathB != null) {
                naVar = new na(pathB);
            }
        }
        tb3Var.k.setValue(naVar);
        synchronized (im2.c) {
            hm1 hm1Var = im2.j.h;
            if (hm1Var != null && hm1Var.h()) {
                z = true;
            }
        }
        if (z) {
            im2.a();
        }
    }
}
