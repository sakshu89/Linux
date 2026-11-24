package defpackage;

import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lc extends TextPaint {
    public fa a;
    public sx2 b;
    public int c;
    public vj2 d;
    public sz e;
    public hn f;
    public qc0 g;
    public xk2 h;
    public wm4 i;

    public final fa a() {
        fa faVar = this.a;
        if (faVar != null) {
            return faVar;
        }
        fa faVar2 = new fa(this);
        this.a = faVar2;
        return faVar2;
    }

    public final void b(int i) {
        if (i == this.c) {
            return;
        }
        a().d(i);
        this.c = i;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0037  */
    /* JADX WARN: Code duplicated, block: B:21:0x0040  */
    public final void c(final hn hnVar, final long j, float f) {
        if (hnVar == null) {
            this.g = null;
            this.f = null;
            this.h = null;
            setShader(null);
            return;
        }
        if (hnVar instanceof cn2) {
            d(ob4.a(f, ((cn2) hnVar).a));
            return;
        }
        if (!(hnVar instanceof tj2)) {
            dk0.l();
            return;
        }
        if (g31.a(this.f, hnVar)) {
            xk2 xk2Var = this.h;
            if (!(xk2Var == null ? false : xk2.a(xk2Var.a, j))) {
                if (j != 9205357640488583168L) {
                    this.f = hnVar;
                    this.h = new xk2(j);
                    this.g = o44.b(new fq0() { // from class: kc
                        @Override // defpackage.fq0
                        public final Object a() {
                            return ((tj2) hnVar).b(j);
                        }
                    });
                }
            }
        } else if (j != 9205357640488583168L) {
            this.f = hnVar;
            this.h = new xk2(j);
            this.g = o44.b(new fq0() { // from class: kc
                @Override // defpackage.fq0
                public final Object a() {
                    return ((tj2) hnVar).b(j);
                }
            });
        }
        fa faVarA = a();
        qc0 qc0Var = this.g;
        faVarA.h(qc0Var != null ? (Shader) qc0Var.getValue() : null);
        this.e = null;
        ee4.a(this, f);
    }

    public final void d(long j) {
        sz szVar = this.e;
        if ((szVar == null ? false : sz.c(szVar.a, j)) || j == 16) {
            return;
        }
        this.e = new sz(j);
        setColor(ki4.g(j));
        this.g = null;
        this.f = null;
        this.h = null;
        setShader(null);
    }

    public final void e(wm4 wm4Var) {
        if (wm4Var == null || g31.a(this.i, wm4Var)) {
            return;
        }
        this.i = wm4Var;
        if (wm4Var.equals(ql0.a)) {
            setStyle(Paint.Style.FILL);
            return;
        }
        if (!(wm4Var instanceof ks2)) {
            dk0.l();
            return;
        }
        a().l(1);
        ks2 ks2Var = (ks2) wm4Var;
        a().k(ks2Var.a);
        fa faVarA = a();
        faVarA.a.setStrokeMiter(ks2Var.b);
        a().j(ks2Var.d);
        a().i(ks2Var.c);
        a().a.setPathEffect(null);
    }

    public final void f(vj2 vj2Var) {
        if (vj2Var == null || g31.a(this.d, vj2Var)) {
            return;
        }
        this.d = vj2Var;
        if (vj2Var.equals(vj2.d)) {
            clearShadowLayer();
            return;
        }
        vj2 vj2Var2 = this.d;
        float f = vj2Var2.c;
        if (f == 0.0f) {
            f = Float.MIN_VALUE;
        }
        setShadowLayer(f, Float.intBitsToFloat((int) (vj2Var2.b >> 32)), Float.intBitsToFloat((int) (this.d.b & 4294967295L)), ki4.g(this.d.a));
    }

    public final void g(sx2 sx2Var) {
        if (sx2Var == null || g31.a(this.b, sx2Var)) {
            return;
        }
        this.b = sx2Var;
        int i = sx2Var.a;
        setUnderlineText((i | 1) == i);
        int i2 = this.b.a;
        setStrikeThruText((i2 | 2) == i2);
    }
}
