package defpackage;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f42 extends a30 {
    public final sc a;
    public final kf b;
    public final Object c;
    public f41 d;
    public Throwable e;
    public final ArrayList f;
    public List g;
    public hm1 h;
    public final pm1 i;
    public final ArrayList j;
    public final ArrayList k;
    public final gm1 l;
    public final q91 m;
    public final gm1 n;
    public final gm1 o;
    public ArrayList p;
    public LinkedHashSet q;
    public yv r;
    public wj1 s;
    public boolean t;
    public final jr2 u;
    public final kf v;
    public final h41 w;
    public final j70 x;
    public final fl4 y;
    public static final jr2 z = o54.a(pw1.e);
    public static final AtomicReference A = new AtomicReference(Boolean.FALSE);

    public f42(j70 j70Var) {
        sc scVar = new sc(new b42(this, 0));
        this.a = scVar;
        this.b = new kf(new b42(this, 1));
        this.c = new Object();
        this.f = new ArrayList();
        this.h = new hm1();
        this.i = new pm1(new g30[16]);
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new gm1();
        this.m = new q91(11);
        this.n = new gm1();
        this.o = new gm1();
        this.u = o54.a(c42.c);
        this.v = new kf(26);
        h41 h41Var = new h41((f41) j70Var.v(nr4.k));
        h41Var.C(new x0(22, this));
        this.w = h41Var;
        this.x = j70Var.r(scVar).r(h41Var);
        this.y = new fl4(17);
    }

    public static final void G(ArrayList arrayList, f42 f42Var, g30 g30Var) {
        arrayList.clear();
        synchronized (f42Var.c) {
            Iterator it = f42Var.k.iterator();
            if (it.hasNext()) {
                ((bl1) it.next()).getClass();
                throw null;
            }
        }
    }

    public static void w(lm1 lm1Var) {
        try {
            if (lm1Var.w() instanceof cm2) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.");
            }
            lm1Var.c();
        } catch (Throwable th) {
            lm1Var.c();
            throw th;
        }
    }

    public final boolean A() {
        return this.i.c != 0 || z() || B() || this.l.j();
    }

    public final boolean B() {
        return !this.t && (((hh) ((cj) this.b.c).e).get() & 134217727) > 0;
    }

    public final boolean C() {
        boolean z2;
        synchronized (this.c) {
            z2 = this.h.h() || this.i.c != 0 || z() || B();
        }
        return z2;
    }

    public final List D() {
        List list = this.g;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = this.f;
        List arrayList2 = arrayList.isEmpty() ? ii0.a : new ArrayList(arrayList);
        this.g = arrayList2;
        return arrayList2;
    }

    public final void E() {
        wv wvVarY;
        synchronized (this.c) {
            wvVarY = y();
            if (((c42) this.u.getValue()).compareTo(c42.b) <= 0) {
                Throwable th = this.e;
                CancellationException cancellationException = new CancellationException("Recomposer shutdown; frame clock awaiter will never resume");
                cancellationException.initCause(th);
                throw cancellationException;
            }
        }
        if (wvVarY != null) {
            ((yv) wvVarY).h(q43.a);
        }
    }

    public final void F(g30 g30Var) {
        synchronized (this.c) {
            ArrayList arrayList = this.k;
            if (arrayList.size() > 0) {
                ((bl1) arrayList.get(0)).getClass();
                throw null;
            }
        }
    }

    public final List H(List list, hm1 hm1Var) {
        lm1 lm1VarC;
        ArrayList arrayList;
        HashMap map = new HashMap(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            ((bl1) obj).getClass();
            Object arrayList2 = map.get(null);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                map.put(null, arrayList2);
            }
            ((ArrayList) arrayList2).add(obj);
        }
        for (Map.Entry entry : map.entrySet()) {
            g30 g30Var = (g30) entry.getKey();
            List list2 = (List) entry.getValue();
            if (g30Var.e0.F) {
                y20.a("Check failed");
            }
            x0 x0Var = new x0(21, g30Var);
            o0 o0Var = new o0(15, g30Var, hm1Var);
            bm2 bm2VarJ = im2.j();
            lm1 lm1Var = bm2VarJ instanceof lm1 ? (lm1) bm2VarJ : null;
            if (lm1Var == null || (lm1VarC = lm1Var.C(x0Var, o0Var)) == null) {
                og.n("Cannot create a mutable snapshot of an read-only snapshot");
                return null;
            }
            try {
                bm2 bm2VarJ2 = lm1VarC.j();
                try {
                    synchronized (this.c) {
                        try {
                            arrayList = new ArrayList(list2.size());
                            int size2 = list2.size();
                            for (int i2 = 0; i2 < size2; i2++) {
                                bl1 bl1Var = (bl1) list2.get(i2);
                                gm1 gm1Var = this.l;
                                bl1Var.getClass();
                                Object objA = hl1.a(gm1Var);
                                arrayList.add(new wt1(bl1Var, objA));
                            }
                            int size3 = arrayList.size();
                            for (int i3 = 0; i3 < size3; i3++) {
                                wt1 wt1Var = (wt1) arrayList.get(i3);
                                if (wt1Var.b == null) {
                                    q91 q91Var = this.m;
                                    ((bl1) wt1Var.a).getClass();
                                    if (((gm1) q91Var.b).b(null)) {
                                        ArrayList arrayList3 = new ArrayList(arrayList.size());
                                        int size4 = arrayList.size();
                                        for (int i4 = 0; i4 < size4; i4++) {
                                            wt1 wt1Var2 = (wt1) arrayList.get(i4);
                                            if (wt1Var2.b == null) {
                                                q91 q91Var2 = this.m;
                                                ((bl1) wt1Var2.a).getClass();
                                                gm1 gm1Var2 = (gm1) q91Var2.b;
                                                if (gm1Var2.i()) {
                                                    ((gm1) q91Var2.c).a();
                                                }
                                            }
                                            arrayList3.add(wt1Var2);
                                        }
                                        arrayList = arrayList3;
                                        break;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    int size5 = arrayList.size();
                    for (int i5 = 0; i5 < size5; i5++) {
                        if (((wt1) arrayList.get(i5)).b != null) {
                            int size6 = arrayList.size();
                            for (int i6 = 0; i6 < size6; i6++) {
                                if (((wt1) arrayList.get(i6)).b == null) {
                                    ArrayList arrayList4 = new ArrayList(arrayList.size());
                                    int size7 = arrayList.size();
                                    for (int i7 = 0; i7 < size7; i7++) {
                                        wt1 wt1Var3 = (wt1) arrayList.get(i7);
                                        if (wt1Var3.b == null) {
                                        }
                                    }
                                    synchronized (this.c) {
                                        rz.q(arrayList4, this.k);
                                    }
                                    ArrayList arrayList5 = new ArrayList(arrayList.size());
                                    int size8 = arrayList.size();
                                    for (int i8 = 0; i8 < size8; i8++) {
                                        Object obj2 = arrayList.get(i8);
                                        if (((wt1) obj2).b != null) {
                                            arrayList5.add(obj2);
                                        }
                                    }
                                    arrayList = arrayList5;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    g30Var.r(arrayList);
                    bm2.q(bm2VarJ2);
                    w(lm1VarC);
                } catch (Throwable th2) {
                    bm2.q(bm2VarJ2);
                    throw th2;
                }
            } catch (Throwable th3) {
                w(lm1VarC);
                throw th3;
            }
        }
        return mz.O(map.keySet());
    }

    public final g30 I(g30 g30Var, hm1 hm1Var) {
        lm1 lm1VarC;
        if (g30Var.e0.F || g30Var.f0 == 3) {
            return null;
        }
        LinkedHashSet linkedHashSet = this.q;
        if (linkedHashSet == null || !linkedHashSet.contains(g30Var)) {
            x0 x0Var = new x0(21, g30Var);
            o0 o0Var = new o0(15, g30Var, hm1Var);
            bm2 bm2VarJ = im2.j();
            lm1 lm1Var = bm2VarJ instanceof lm1 ? (lm1) bm2VarJ : null;
            if (lm1Var == null || (lm1VarC = lm1Var.C(x0Var, o0Var)) == null) {
                og.n("Cannot create a mutable snapshot of an read-only snapshot");
            } else {
                try {
                    bm2 bm2VarJ2 = lm1VarC.j();
                    if (hm1Var != null) {
                        try {
                            if (hm1Var.h()) {
                                zb zbVar = new zb(13, hm1Var, g30Var);
                                x20 x20Var = g30Var.e0;
                                if (x20Var.F) {
                                    y20.a("Preparing a composition while composing is not supported");
                                }
                                x20Var.F = true;
                                try {
                                    zbVar.a();
                                    x20Var.F = false;
                                } catch (Throwable th) {
                                    x20Var.F = false;
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            bm2.q(bm2VarJ2);
                            throw th2;
                        }
                    }
                    boolean zX = g30Var.x();
                    bm2.q(bm2VarJ2);
                    w(lm1VarC);
                    if (zX) {
                        return g30Var;
                    }
                } catch (Throwable th3) {
                    w(lm1VarC);
                    throw th3;
                }
            }
        }
        return null;
    }

    public final void J(Throwable th, g30 g30Var) throws Throwable {
        int i = 5;
        if (!((Boolean) A.get()).booleanValue() || (th instanceof g20)) {
            synchronized (this.c) {
                Log.e("ComposeInternal", "Error was captured in composition.", th);
                wj1 wj1Var = this.s;
                if (wj1Var != null) {
                    throw ((Throwable) wj1Var.b);
                }
                this.s = new wj1(i, th);
            }
            throw th;
        }
        synchronized (this.c) {
            try {
                Log.e("ComposeInternal", "Error was captured in composition while live edit was enabled.", th);
                this.j.clear();
                this.i.h();
                this.h = new hm1();
                this.k.clear();
                this.l.a();
                this.n.a();
                this.s = new wj1(i, th);
                if (g30Var != null) {
                    L(g30Var);
                }
                y();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean K() {
        boolean zA;
        synchronized (this.c) {
            if (this.h.g()) {
                return A();
            }
            List listD = D();
            ab2 ab2Var = new ab2(this.h);
            this.h = new hm1();
            try {
                int size = listD.size();
                for (int i = 0; i < size; i++) {
                    ((g30) listD.get(i)).y(ab2Var);
                    if (((c42) this.u.getValue()).compareTo(c42.b) <= 0) {
                        break;
                    }
                }
                synchronized (this.c) {
                    if (y() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
                    }
                    zA = A();
                }
                return zA;
            } catch (Throwable th) {
                synchronized (this.c) {
                    hm1 hm1Var = this.h;
                    hm1Var.getClass();
                    Iterator<E> it = ab2Var.iterator();
                    while (it.hasNext()) {
                        hm1Var.k(it.next());
                    }
                    throw th;
                }
            }
        }
    }

    public final void L(g30 g30Var) {
        ArrayList arrayList = this.p;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.p = arrayList;
        }
        if (!arrayList.contains(g30Var)) {
            arrayList.add(g30Var);
        }
        if (this.f.remove(g30Var)) {
            this.g = null;
        }
    }

    @Override // defpackage.a30
    public final void a(g30 g30Var, vq0 vq0Var) throws Throwable {
        c42 c42Var;
        boolean zContains;
        lm1 lm1VarC;
        boolean z2 = g30Var.e0.F;
        synchronized (this.c) {
            c42 c42Var2 = (c42) this.u.getValue();
            c42Var = c42.b;
            zContains = c42Var2.compareTo(c42Var) > 0 ? true ^ D().contains(g30Var) : true;
        }
        try {
            x0 x0Var = new x0(21, g30Var);
            o0 o0Var = new o0(15, g30Var, null);
            bm2 bm2VarJ = im2.j();
            lm1 lm1Var = bm2VarJ instanceof lm1 ? (lm1) bm2VarJ : null;
            if (lm1Var == null || (lm1VarC = lm1Var.C(x0Var, o0Var)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            try {
                bm2 bm2VarJ2 = lm1VarC.j();
                try {
                    g30Var.j(vq0Var);
                    bm2.q(bm2VarJ2);
                    w(lm1VarC);
                    synchronized (this.c) {
                        if (((c42) this.u.getValue()).compareTo(c42Var) > 0 && !D().contains(g30Var)) {
                            this.f.add(g30Var);
                            this.g = null;
                        }
                    }
                    if (!z2) {
                        im2.j().m();
                    }
                    try {
                        F(g30Var);
                        try {
                            g30Var.d();
                            g30Var.f();
                            if (z2) {
                                return;
                            }
                            im2.j().m();
                        } catch (Throwable th) {
                            J(th, null);
                        }
                    } catch (Throwable th2) {
                        J(th2, g30Var);
                    }
                } catch (Throwable th3) {
                    bm2.q(bm2VarJ2);
                    throw th3;
                }
            } catch (Throwable th4) {
                w(lm1VarC);
                throw th4;
            }
        } catch (Throwable th5) {
            if (zContains) {
                synchronized (this.c) {
                }
            }
            J(th5, g30Var);
        }
    }

    @Override // defpackage.a30
    public final hm1 b(g30 g30Var, mk2 mk2Var, vq0 vq0Var) {
        kf kfVar = this.v;
        try {
            mk2 mk2Var2 = g30Var.H;
            g30Var.H = mk2Var;
            try {
                a(g30Var, vq0Var);
                hm1 hm1Var = (hm1) kfVar.l();
                if (hm1Var == null) {
                    hm1Var = za2.a;
                    hm1Var.getClass();
                }
                g30Var.H = mk2Var2;
                kfVar.C(null);
                return hm1Var;
            } catch (Throwable th) {
                g30Var.H = mk2Var2;
                throw th;
            }
        } catch (Throwable th2) {
            kfVar.C(null);
            throw th2;
        }
    }

    @Override // defpackage.a30
    public final boolean d() {
        return ((Boolean) A.get()).booleanValue();
    }

    @Override // defpackage.a30
    public final boolean e() {
        return false;
    }

    @Override // defpackage.a30
    public final boolean f() {
        return false;
    }

    @Override // defpackage.a30
    public final long g() {
        return 1000L;
    }

    @Override // defpackage.a30
    public final z20 h() {
        return null;
    }

    @Override // defpackage.a30
    public final j70 j() {
        return this.x;
    }

    @Override // defpackage.a30
    public final boolean k() {
        return false;
    }

    @Override // defpackage.a30
    public final void l(g30 g30Var) {
        wv wvVarY;
        synchronized (this.c) {
            if (this.i.i(g30Var)) {
                wvVarY = null;
            } else {
                this.i.b(g30Var);
                wvVarY = y();
            }
        }
        if (wvVarY != null) {
            ((yv) wvVarY).h(q43.a);
        }
    }

    @Override // defpackage.a30
    public final al1 m(bl1 bl1Var) {
        al1 al1Var;
        synchronized (this.c) {
            al1Var = (al1) this.n.k(bl1Var);
        }
        return al1Var;
    }

    @Override // defpackage.a30
    public final hm1 n(g30 g30Var, mk2 mk2Var, hm1 hm1Var) {
        kf kfVar = this.v;
        try {
            K();
            g30Var.y(new ab2(hm1Var));
            mk2 mk2Var2 = g30Var.H;
            g30Var.H = mk2Var;
            try {
                g30 g30VarI = I(g30Var, null);
                if (g30VarI != null) {
                    F(g30Var);
                    g30VarI.d();
                    g30VarI.f();
                }
                hm1 hm1Var2 = (hm1) kfVar.l();
                if (hm1Var2 == null) {
                    hm1Var2 = za2.a;
                    hm1Var2.getClass();
                }
                g30Var.H = mk2Var2;
                kfVar.C(null);
                return hm1Var2;
            } catch (Throwable th) {
                g30Var.H = mk2Var2;
                throw th;
            }
        } catch (Throwable th2) {
            kfVar.C(null);
            throw th2;
        }
    }

    @Override // defpackage.a30
    public final void q(a42 a42Var) {
        kf kfVar = this.v;
        hm1 hm1Var = (hm1) kfVar.l();
        if (hm1Var == null) {
            hm1 hm1Var2 = za2.a;
            hm1Var = new hm1();
            kfVar.C(hm1Var);
        }
        hm1Var.a(a42Var);
    }

    @Override // defpackage.a30
    public final void r(g30 g30Var) {
        synchronized (this.c) {
            try {
                LinkedHashSet linkedHashSet = this.q;
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                    this.q = linkedHashSet;
                }
                linkedHashSet.add(g30Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.a30
    public final zv s(ta taVar) {
        kf kfVar = this.b;
        cj cjVar = (cj) kfVar.c;
        vn1 vn1Var = new vn1();
        vn1Var.a = taVar;
        return cjVar.e(vn1Var, (zb) kfVar.e);
    }

    @Override // defpackage.a30
    public final void v(g30 g30Var) {
        synchronized (this.c) {
            if (this.f.remove(g30Var)) {
                this.g = null;
            }
            this.i.k(g30Var);
            this.j.remove(g30Var);
        }
    }

    public final void x() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.c) {
            if (((c42) this.u.getValue()).compareTo(c42.f) >= 0) {
                jr2 jr2Var = this.u;
                c42 c42Var = c42.b;
                jr2Var.getClass();
                jr2Var.j(null, c42Var);
            }
        }
        this.w.e(null);
    }

    public final wv y() {
        jr2 jr2Var = this.u;
        int iCompareTo = ((c42) jr2Var.getValue()).compareTo(c42.b);
        ArrayList arrayList = this.k;
        ArrayList arrayList2 = this.j;
        pm1 pm1Var = this.i;
        if (iCompareTo > 0) {
            wj1 wj1Var = this.s;
            c42 c42Var = c42.i;
            c42 c42Var2 = c42.c;
            if (wj1Var == null) {
                if (this.d == null) {
                    this.h = new hm1();
                    pm1Var.h();
                    if (z() || B()) {
                        c42Var2 = c42.e;
                    }
                } else {
                    c42Var2 = (pm1Var.c != 0 || this.h.h() || !arrayList2.isEmpty() || !arrayList.isEmpty() || z() || B() || this.l.j()) ? c42Var : c42.f;
                }
            }
            jr2Var.j(null, c42Var2);
            if (c42Var2 != c42Var) {
                return null;
            }
            yv yvVar = this.r;
            this.r = null;
            return yvVar;
        }
        List listD = D();
        int size = listD.size();
        for (int i = 0; i < size; i++) {
        }
        this.f.clear();
        this.g = ii0.a;
        this.h = new hm1();
        pm1Var.h();
        arrayList2.clear();
        arrayList.clear();
        this.p = null;
        yv yvVar2 = this.r;
        if (yvVar2 != null) {
            yvVar2.m(null);
        }
        this.r = null;
        this.s = null;
        return null;
    }

    public final boolean z() {
        return !this.t && (((hh) ((cj) this.a.c).e).get() & 134217727) > 0;
    }

    @Override // defpackage.a30
    public final void o(Set set) {
    }
}
