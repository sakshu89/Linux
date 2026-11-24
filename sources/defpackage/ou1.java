package defpackage;

import android.graphics.Path;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ou1 extends d63 {
    public hn b;
    public float c = 1.0f;
    public List d;
    public float e;
    public float f;
    public hn g;
    public int h;
    public int i;
    public float j;
    public float k;
    public float l;
    public float m;
    public boolean n;
    public boolean o;
    public boolean p;
    public ks2 q;
    public final na r;
    public na s;
    public na t;
    public final f81 u;

    public ou1() {
        int i = o63.a;
        this.d = ii0.a;
        this.e = 1.0f;
        this.h = 0;
        this.i = 0;
        this.j = 4.0f;
        this.l = 1.0f;
        this.n = true;
        this.o = true;
        na naVarA = pa.a();
        this.r = naVarA;
        this.s = naVarA;
        this.u = yp4.a(k30.n);
    }

    @Override // defpackage.d63
    public final void a(rf0 rf0Var) {
        rf0 rf0Var2;
        ks2 ks2Var;
        if (this.n) {
            sg.c(this.d, this.r);
            e();
        } else if (this.p) {
            e();
        }
        this.n = false;
        this.p = false;
        hn hnVar = this.b;
        if (hnVar != null) {
            rf0Var2 = rf0Var;
            rf0.t(rf0Var2, this.s, hnVar, this.c, null, 56);
        } else {
            rf0Var2 = rf0Var;
        }
        hn hnVar2 = this.g;
        if (hnVar2 != null) {
            ks2 ks2Var2 = this.q;
            if (this.o || ks2Var2 == null) {
                ks2 ks2Var3 = new ks2(this.f, this.j, this.h, this.i, 16);
                this.q = ks2Var3;
                this.o = false;
                ks2Var = ks2Var3;
            } else {
                ks2Var = ks2Var2;
            }
            rf0.t(rf0Var2, this.s, hnVar2, this.e, ks2Var, 48);
        }
    }

    public final void e() {
        float f = this.k;
        na naVar = this.r;
        if (f == 0.0f && this.l == 1.0f) {
            this.s = naVar;
            return;
        }
        if (g31.a(this.s, naVar)) {
            this.s = pa.a();
        } else {
            Path.FillType fillType = this.s.a.getFillType();
            Path.FillType fillType2 = Path.FillType.EVEN_ODD;
            boolean z = fillType == fillType2;
            this.s.a.rewind();
            Path path = this.s.a;
            if (!z) {
                fillType2 = Path.FillType.WINDING;
            }
            path.setFillType(fillType2);
        }
        f81 f81Var = this.u;
        ((oa) f81Var.getValue()).a.setPath(naVar != null ? naVar.a : null, false);
        float length = ((oa) f81Var.getValue()).a.getLength();
        float f2 = this.k;
        float f3 = this.m;
        float f4 = ((f2 + f3) % 1.0f) * length;
        float f5 = ((this.l + f3) % 1.0f) * length;
        if (f4 <= f5) {
            ((oa) f81Var.getValue()).a(f4, f5, this.s);
            return;
        }
        na naVarA = this.t;
        if (naVarA == null) {
            naVarA = pa.a();
            this.t = naVarA;
        }
        naVarA.f();
        ((oa) f81Var.getValue()).a(f4, length, naVarA);
        na.a(this.s, naVarA);
        naVarA.f();
        ((oa) f81Var.getValue()).a(0.0f, f5, naVarA);
        na.a(this.s, naVarA);
    }

    public final String toString() {
        return this.r.toString();
    }
}
