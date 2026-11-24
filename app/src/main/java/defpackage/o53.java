package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class o53 {
    public r53 d;
    public final r53 e;
    public r53 f;
    public fj g;
    public r53 h;
    public Rect i;
    public wt k;
    public wt l;
    public final HashSet a = new HashSet();
    public final Object b = new Object();
    public int c = 2;
    public Matrix j = new Matrix();
    public kh2 m = kh2.a();
    public kh2 n = kh2.a();

    public o53(r53 r53Var) {
        this.e = r53Var;
        this.f = r53Var;
    }

    public final void a(wt wtVar, wt wtVar2, r53 r53Var, r53 r53Var2) {
        synchronized (this.b) {
            this.k = wtVar;
            this.l = wtVar2;
            this.a.add(wtVar);
            if (wtVar2 != null) {
                this.a.add(wtVar2);
            }
        }
        this.d = r53Var;
        this.h = r53Var2;
        this.f = l(wtVar.i(), this.d, this.h);
        p();
    }

    public final wt b() {
        wt wtVar;
        synchronized (this.b) {
            wtVar = this.k;
        }
        return wtVar;
    }

    public final gt c() {
        synchronized (this.b) {
            try {
                wt wtVar = this.k;
                if (wtVar == null) {
                    return gt.a;
                }
                return wtVar.l();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String d() {
        wt wtVarB = b();
        hh1.d(wtVarB, "No camera attached to use case: " + this);
        return wtVarB.i().c();
    }

    public abstract r53 e(boolean z, u53 u53Var);

    public final String f() {
        String str = (String) this.f.d(yv2.M, "<UnknownUseCase-" + hashCode() + ">");
        Objects.requireNonNull(str);
        return str;
    }

    public final int g(wt wtVar, boolean z) {
        int iF = wtVar.i().f(((xy0) this.f).i());
        return (wtVar.g() || !z) ? iF : z13.g(-iF);
    }

    public final wt h() {
        wt wtVar;
        synchronized (this.b) {
            wtVar = this.l;
        }
        return wtVar;
    }

    public abstract HashSet i();

    public abstract q53 j(s30 s30Var);

    public final boolean k(wt wtVar) {
        int iIntValue = ((Integer) ((xy0) this.f).d(xy0.C, -1)).intValue();
        if (iIntValue == -1 || iIntValue == 0) {
            return false;
        }
        if (iIntValue == 1) {
            return true;
        }
        if (iIntValue == 2) {
            return wtVar.i().b() == 0;
        }
        og.m(ky0.h(iIntValue, "Unknown mirrorMode: "));
        return false;
    }

    public final r53 l(ut utVar, r53 r53Var, r53 r53Var2) {
        zl1 zl1VarM;
        if (r53Var2 != null) {
            zl1VarM = zl1.o(r53Var2);
            zl1VarM.a.remove(yv2.M);
        } else {
            zl1VarM = zl1.m();
        }
        TreeMap treeMap = zl1VarM.a;
        bi biVar = xy0.z;
        r53 r53Var3 = this.e;
        if (r53Var3.a(biVar) || r53Var3.a(xy0.D)) {
            bi biVar2 = xy0.I;
            if (treeMap.containsKey(biVar2)) {
                treeMap.remove(biVar2);
            }
        }
        bi biVar3 = xy0.I;
        if (r53Var3.a(biVar3)) {
            bi biVar4 = xy0.F;
            if (treeMap.containsKey(biVar4) && ((l62) r53Var3.f(biVar3)).b != null) {
                treeMap.remove(biVar4);
            }
        }
        Iterator it = r53Var3.e().iterator();
        while (it.hasNext()) {
            s30.r(zl1VarM, zl1VarM, r53Var3, (bi) it.next());
        }
        if (r53Var != null) {
            for (bi biVar5 : r53Var.e()) {
                if (!biVar5.a.equals(yv2.M.a)) {
                    s30.r(zl1VarM, zl1VarM, r53Var, biVar5);
                }
            }
        }
        if (treeMap.containsKey(xy0.D)) {
            bi biVar6 = xy0.z;
            if (treeMap.containsKey(biVar6)) {
                treeMap.remove(biVar6);
            }
        }
        bi biVar7 = xy0.I;
        if (treeMap.containsKey(biVar7) && ((l62) zl1VarM.f(biVar7)).c != 0) {
            zl1VarM.v(r53.U, Boolean.TRUE);
        }
        return r(utVar, j(zl1VarM));
    }

    public final void m() {
        this.c = 1;
        o();
    }

    public final void n() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((n53) it.next()).c(this);
        }
    }

    public final void o() {
        int iX = cq.x(this.c);
        HashSet hashSet = this.a;
        if (iX == 0) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((n53) it.next()).j(this);
            }
        } else {
            if (iX != 1) {
                return;
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                ((n53) it2.next()).m(this);
            }
        }
    }

    public abstract r53 r(ut utVar, q53 q53Var);

    public abstract fj u(s30 s30Var);

    public abstract fj v(fj fjVar, fj fjVar2);

    public abstract void w();

    public void x(Rect rect) {
        this.i = rect;
    }

    public final void y(wt wtVar) {
        w();
        synchronized (this.b) {
            try {
                wt wtVar2 = this.k;
                if (wtVar == wtVar2) {
                    this.a.remove(wtVar2);
                    this.k = null;
                }
                wt wtVar3 = this.l;
                if (wtVar == wtVar3) {
                    this.a.remove(wtVar3);
                    this.l = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.g = null;
        this.i = null;
        this.f = this.e;
        this.d = null;
        this.h = null;
    }

    public final void z(List list) {
        if (list.isEmpty()) {
            return;
        }
        this.m = (kh2) list.get(0);
        if (list.size() > 1) {
            this.n = (kh2) list.get(1);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            for (ob0 ob0Var : ((kh2) it.next()).b()) {
                if (ob0Var.j == null) {
                    ob0Var.j = getClass();
                }
            }
        }
    }

    public void p() {
    }

    public void q() {
    }

    public void s() {
    }

    public void t() {
    }
}
