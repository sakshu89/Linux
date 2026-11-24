package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b43 implements xf {
    public final Object a;
    public final ArrayList b = new ArrayList();
    public Object c;

    public b43(n71 n71Var) {
        this.a = n71Var;
        this.c = n71Var;
    }

    @Override // defpackage.xf
    public final void a(int i, Object obj) {
        ((n71) this.c).B(i, (n71) obj);
    }

    @Override // defpackage.xf
    public final void b(Object obj) {
        this.b.add(this.c);
        this.c = obj;
    }

    @Override // defpackage.xf
    public final void c() {
        n42 rectManager;
        s6 s6Var;
        n42 rectManager2;
        n71 n71Var = (n71) this.c;
        zn1 zn1Var = n71Var.o0;
        if (!n71Var.H()) {
            z01.a("onReuse is only expected on attached node");
        }
        b81 b81Var = n71Var.q0;
        if (b81Var != null) {
            b81Var.i(false);
        }
        n71Var.c0 = false;
        if (n71Var.x0) {
            n71Var.x0 = false;
        } else {
            dk1 dk1Var = n71Var.o0.e;
            for (dk1 dk1Var2 = dk1Var; dk1Var2 != null; dk1Var2 = dk1Var2.f) {
                if (dk1Var2.w) {
                    dk1Var2.D0();
                }
            }
            for (dk1 dk1Var3 = dk1Var; dk1Var3 != null; dk1Var3 = dk1Var3.f) {
                if (dk1Var3.w) {
                    dk1Var3.F0();
                }
            }
            while (dk1Var != null) {
                if (dk1Var.w) {
                    dk1Var.z0();
                }
                dk1Var = dk1Var.f;
            }
        }
        int i = n71Var.b;
        it1 it1Var = n71Var.x;
        if (it1Var != null && (rectManager2 = ((r7) it1Var).getRectManager()) != null) {
            rectManager2.h(n71Var);
        }
        n71Var.b = dg2.a.addAndGet(1);
        it1 it1Var2 = n71Var.x;
        if (it1Var2 != null) {
            r7 r7Var = (r7) it1Var2;
            r7Var.getLayoutNodes().g(i);
            r7Var.getLayoutNodes().h(n71Var.b, n71Var);
        }
        for (dk1 dk1Var4 = zn1Var.f; dk1Var4 != null; dk1Var4 = dk1Var4.i) {
            dk1Var4.y0();
        }
        zn1Var.e();
        if (zn1Var.d(8)) {
            n71Var.F();
        }
        n71.W(n71Var);
        it1 it1Var3 = n71Var.x;
        if (it1Var3 != null && (s6Var = ((r7) it1Var3).w0) != null) {
            r7 r7Var2 = s6Var.c;
            wj1 wj1Var = s6Var.a;
            nl1 nl1Var = s6Var.k;
            if (nl1Var.e(i)) {
                wj1Var.n(r7Var2, i, false);
            }
            cg2 cg2VarW = n71Var.w();
            if (cg2VarW != null && cg2VarW.a.b(kg2.q)) {
                nl1Var.a(n71Var.b);
                wj1Var.n(r7Var2, n71Var.b, true);
            }
        }
        it1 it1Var4 = n71Var.x;
        if (it1Var4 == null || (rectManager = ((r7) it1Var4).getRectManager()) == null) {
            return;
        }
        rectManager.f(n71Var, true);
    }

    @Override // defpackage.xf
    public final /* bridge */ /* synthetic */ void d(int i, Object obj) {
    }

    @Override // defpackage.xf
    public final void e() {
        it1 it1Var = ((n71) this.a).x;
        if (it1Var != null) {
            ((r7) it1Var).s();
        }
    }

    @Override // defpackage.xf
    public final void f(int i, int i2, int i3) {
        ((n71) this.c).L(i, i2, i3);
    }

    @Override // defpackage.xf
    public final Object g() {
        return this.c;
    }

    @Override // defpackage.xf
    public final void h(int i, int i2) {
        ((n71) this.c).Q(i, i2);
    }

    @Override // defpackage.xf
    public final void j() {
        ArrayList arrayList = this.b;
        this.c = arrayList.remove(arrayList.size() - 1);
    }

    public final void k() {
        this.b.clear();
        this.c = this.a;
        ((n71) this.a).P();
    }
}
