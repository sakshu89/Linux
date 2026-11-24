package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g02 extends o53 {
    public static final e02 v = new e02();
    public static final xv0 w = xg4.c();
    public f02 o;
    public Executor p;
    public gh2 q;
    public nz0 r;
    public st2 s;
    public fu2 t;
    public hh2 u;

    public final void A() {
        hh2 hh2Var = this.u;
        if (hh2Var != null) {
            hh2Var.b();
            this.u = null;
        }
        nz0 nz0Var = this.r;
        if (nz0Var != null) {
            nz0Var.a();
            this.r = null;
        }
        st2 st2Var = this.s;
        if (st2Var != null) {
            st2Var.b();
            this.s = null;
        }
        this.t = null;
    }

    public final void B(f02 f02Var) {
        vc4.b();
        if (f02Var == null) {
            this.o = null;
            this.c = 2;
            o();
            return;
        }
        this.o = f02Var;
        this.p = w;
        fj fjVar = this.g;
        if ((fjVar != null ? fjVar.a : null) != null) {
            C((h02) this.f, fjVar);
            n();
        }
        m();
    }

    public final void C(h02 h02Var, fj fjVar) {
        vc4.b();
        wt wtVarB = b();
        Objects.requireNonNull(wtVarB);
        A();
        hh1.e(null, this.s == null);
        Matrix matrix = this.j;
        boolean zG = wtVarB.g();
        Size size = fjVar.a;
        Rect rect = this.i;
        if (rect == null) {
            rect = size != null ? new Rect(0, 0, size.getWidth(), size.getHeight()) : null;
        }
        Objects.requireNonNull(rect);
        int iG = g(wtVarB, k(wtVarB));
        xy0 xy0Var = (xy0) this.f;
        bi biVar = xy0.B;
        st2 st2Var = new st2(1, 34, fjVar, matrix, zG, rect, iG, ((Integer) xy0Var.d(biVar, -1)).intValue(), wtVarB.g() && k(wtVarB));
        this.s = st2Var;
        s7 s7Var = new s7(22, this);
        vc4.b();
        st2Var.a();
        st2Var.m.add(s7Var);
        fu2 fu2VarC = this.s.c(wtVarB, true);
        this.t = fu2VarC;
        this.r = fu2VarC.k;
        if (this.o != null) {
            wt wtVarB2 = b();
            st2 st2Var2 = this.s;
            if (wtVarB2 != null && st2Var2 != null) {
                vc4.d(new pt2(st2Var2, g(wtVarB2, k(wtVarB2)), ((Integer) ((xy0) this.f).d(biVar, -1)).intValue()));
            }
            f02 f02Var = this.o;
            f02Var.getClass();
            fu2 fu2Var = this.t;
            fu2Var.getClass();
            this.p.execute(new o8(24, f02Var, fu2Var));
        }
        gh2 gh2VarD = gh2.d(h02Var, fjVar.a);
        ur urVar = gh2VarD.b;
        Range range = fjVar.c;
        urVar.getClass();
        ((zl1) urVar.e).v(lw.k, range);
        int iQ = h02Var.q();
        if (iQ != 0) {
            urVar.getClass();
            if (iQ != 0) {
                ((zl1) urVar.e).v(r53.a0, Integer.valueOf(iQ));
            }
        }
        s30 s30Var = fjVar.d;
        if (s30Var != null) {
            urVar.c(s30Var);
        }
        if (this.o != null) {
            gh2VarD.b(this.r, fjVar.b, ((Integer) ((xy0) this.f).d(xy0.C, -1)).intValue());
        }
        hh2 hh2Var = this.u;
        if (hh2Var != null) {
            hh2Var.b();
        }
        hh2 hh2Var2 = new hh2(new ny0(2, this));
        this.u = hh2Var2;
        gh2VarD.f = hh2Var2;
        this.q = gh2VarD;
        Object[] objArr = {gh2VarD.c()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        z(Collections.unmodifiableList(arrayList));
    }

    @Override // defpackage.o53
    public final r53 e(boolean z, u53 u53Var) {
        v.getClass();
        h02 h02Var = e02.a;
        s30 s30VarA = u53Var.a(h02Var.j(), 1);
        if (z) {
            s30VarA = s30.t(s30VarA, h02Var);
        }
        if (s30VarA == null) {
            return null;
        }
        return new h02(gs1.l(((yr) j(s30VarA)).b));
    }

    @Override // defpackage.o53
    public final HashSet i() {
        HashSet hashSet = new HashSet();
        hashSet.add(1);
        return hashSet;
    }

    @Override // defpackage.o53
    public final q53 j(s30 s30Var) {
        return new yr(zl1.o(s30Var), 3);
    }

    @Override // defpackage.o53
    public final r53 r(ut utVar, q53 q53Var) {
        q53Var.a().v(wy0.r, 34);
        return q53Var.b();
    }

    public final String toString() {
        return "Preview:".concat(f());
    }

    @Override // defpackage.o53
    public final fj u(s30 s30Var) {
        this.q.a(s30Var);
        Object[] objArr = {this.q.c()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        z(Collections.unmodifiableList(arrayList));
        cj cjVarA = this.g.a();
        cjVarA.e = s30Var;
        return cjVarA.i();
    }

    @Override // defpackage.o53
    public final fj v(fj fjVar, fj fjVar2) {
        C((h02) this.f, fjVar);
        return fjVar;
    }

    @Override // defpackage.o53
    public final void w() {
        A();
    }

    @Override // defpackage.o53
    public final void x(Rect rect) {
        this.i = rect;
        wt wtVarB = b();
        st2 st2Var = this.s;
        if (wtVarB == null || st2Var == null) {
            return;
        }
        vc4.d(new pt2(st2Var, g(wtVarB, k(wtVarB)), ((Integer) ((xy0) this.f).d(xy0.B, -1)).intValue()));
    }
}
