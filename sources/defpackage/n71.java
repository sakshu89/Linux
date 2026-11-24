package defpackage;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n71 implements d20, jt1, o20 {
    public int H;
    public boolean X;
    public boolean Y;
    public cg2 Z;
    public final boolean a;
    public int b;
    public boolean c;
    public boolean c0;
    public final pm1 d0;
    public long e;
    public boolean e0;
    public long f;
    public oh1 f0;
    public l11 g0;
    public jc0 h0;
    public long i;
    public z61 i0;
    public boolean j;
    public w73 j0;
    public boolean k;
    public j30 k0;
    public l71 l0;
    public l71 m0;
    public n71 n;
    public boolean n0;
    public final zn1 o0;
    public final r71 p0;
    public b81 q0;
    public co1 r0;
    public int s;
    public boolean s0;
    public final q91 t;
    public ek1 t0;
    public pm1 u;
    public ek1 u0;
    public boolean v;
    public boolean v0;
    public n71 w;
    public int w0;
    public it1 x;
    public boolean x0;
    public static final p82 y0 = new p82("Undefined intrinsics block and it is required", 1);
    public static final i71 z0 = new i71();
    public static final gb A0 = new gb(4);

    public n71(boolean z, int i) {
        this.a = z;
        this.b = i;
        this.e = 9223372034707292159L;
        this.f = 0L;
        this.i = 9223372034707292159L;
        this.j = true;
        this.t = new q91(10, new pm1(new n71[16]), new ta(8, this));
        this.d0 = new pm1(new n71[16]);
        this.e0 = true;
        this.f0 = y0;
        this.h0 = q71.a;
        this.i0 = z61.a;
        this.j0 = z0;
        j30.q.getClass();
        this.k0 = i30.b;
        l71 l71Var = l71.c;
        this.l0 = l71Var;
        this.m0 = l71Var;
        this.o0 = new zn1(this);
        this.p0 = new r71(this);
        this.s0 = true;
        this.t0 = bk1.a;
    }

    public static void T(n71 n71Var, boolean z, int i) {
        n71 n71VarU;
        if ((i & 1) != 0) {
            z = false;
        }
        boolean z2 = (i & 2) != 0;
        boolean z3 = (i & 4) != 0;
        if (n71Var.n == null) {
            z01.b("Lookahead measure cannot be requested on a node that is not a part of the LookaheadScope");
        }
        it1 it1Var = n71Var.x;
        if (it1Var == null || n71Var.X || n71Var.a) {
            return;
        }
        ((r7) it1Var).u(n71Var, true, z, z2);
        if (z3) {
            sf1 sf1Var = n71Var.p0.q;
            sf1Var.getClass();
            r71 r71Var = sf1Var.i;
            n71 n71VarU2 = r71Var.a.u();
            l71 l71Var = r71Var.a.l0;
            if (n71VarU2 == null || l71Var == l71.c) {
                return;
            }
            while (n71VarU2.l0 == l71Var && (n71VarU = n71VarU2.u()) != null) {
                n71VarU2 = n71VarU;
            }
            int iOrdinal = l71Var.ordinal();
            if (iOrdinal == 0) {
                if (n71VarU2.n != null) {
                    T(n71VarU2, z, 6);
                    return;
                } else {
                    V(n71VarU2, z, 6);
                    return;
                }
            }
            if (iOrdinal != 1) {
                og.n("Intrinsics isn't used by the parent");
            } else if (n71VarU2.n != null) {
                n71VarU2.S(z);
            } else {
                n71VarU2.U(z);
            }
        }
    }

    public static void V(n71 n71Var, boolean z, int i) {
        it1 it1Var;
        n71 n71VarU;
        if ((i & 1) != 0) {
            z = false;
        }
        boolean z2 = (i & 2) != 0;
        boolean z3 = (i & 4) != 0;
        if (n71Var.X || n71Var.a || (it1Var = n71Var.x) == null) {
            return;
        }
        ((r7) it1Var).u(n71Var, false, z, z2);
        if (z3) {
            r71 r71Var = n71Var.p0.p.i;
            n71 n71VarU2 = r71Var.a.u();
            l71 l71Var = r71Var.a.l0;
            if (n71VarU2 == null || l71Var == l71.c) {
                return;
            }
            while (n71VarU2.l0 == l71Var && (n71VarU = n71VarU2.u()) != null) {
                n71VarU2 = n71VarU;
            }
            int iOrdinal = l71Var.ordinal();
            if (iOrdinal == 0) {
                V(n71VarU2, z, 6);
            } else if (iOrdinal == 1) {
                n71VarU2.U(z);
            } else {
                og.n("Intrinsics isn't used by the parent");
            }
        }
    }

    public static void W(n71 n71Var) {
        int i = m71.a[n71Var.p0.d.ordinal()];
        r71 r71Var = n71Var.p0;
        if (i != 1) {
            dk0.x(r71Var.d, "Unexpected state ");
            return;
        }
        if (r71Var.e) {
            T(n71Var, true, 6);
            return;
        }
        if (r71Var.f) {
            n71Var.S(true);
        }
        if (n71Var.q()) {
            V(n71Var, true, 6);
        } else if (n71Var.p()) {
            n71Var.U(true);
        }
    }

    private final String j(n71 n71Var) {
        StringBuilder sb = new StringBuilder("Cannot insert ");
        sb.append(n71Var);
        sb.append(" because it already has a parent or an owner. This tree: ");
        sb.append(g(0));
        sb.append(" Other tree: ");
        n71 n71Var2 = n71Var.w;
        sb.append(n71Var2 != null ? n71Var2.g(0) : null);
        return sb.toString();
    }

    public final void A(long j, pw0 pw0Var, int i, boolean z) {
        zn1 zn1Var = this.o0;
        co1 co1Var = zn1Var.d;
        r72 r72Var = co1.v0;
        zn1Var.d.a1(co1.y0, co1Var.S0(j), pw0Var, i, z);
    }

    public final void B(int i, n71 n71Var) {
        if (n71Var.w != null && n71Var.x != null) {
            z01.b(j(n71Var));
        }
        n71Var.w = this;
        q91 q91Var = this.t;
        ((pm1) q91Var.b).a(i, n71Var);
        ((ta) q91Var.c).a();
        O();
        if (n71Var.a) {
            this.s++;
        }
        G();
        it1 it1Var = this.x;
        if (it1Var != null) {
            n71Var.d(it1Var);
        }
        if (n71Var.p0.l > 0) {
            r71 r71Var = this.p0;
            r71Var.d(r71Var.l + 1);
        }
        if (n71Var.w0 > 0) {
            a0(this.w0 + 1);
        }
    }

    public final void C() {
        if (this.s0) {
            zn1 zn1Var = this.o0;
            co1 co1Var = zn1Var.c;
            co1 co1Var2 = zn1Var.d.X;
            this.r0 = null;
            while (!g31.a(co1Var, co1Var2)) {
                if ((co1Var != null ? co1Var.u0 : null) != null) {
                    this.r0 = co1Var;
                    break;
                }
                co1Var = co1Var != null ? co1Var.X : null;
            }
        }
        co1 co1Var3 = this.r0;
        if (co1Var3 != null && co1Var3.u0 == null) {
            throw cq.e("layer was not set");
        }
        if (co1Var3 != null) {
            co1Var3.c1();
            return;
        }
        n71 n71VarU = u();
        if (n71VarU != null) {
            n71VarU.C();
        }
    }

    public final void D() {
        zn1 zn1Var = this.o0;
        co1 co1Var = zn1Var.d;
        f11 f11Var = zn1Var.c;
        while (co1Var != f11Var) {
            co1Var.getClass();
            h71 h71Var = (h71) co1Var;
            ht1 ht1Var = h71Var.u0;
            if (ht1Var != null) {
                ((yu0) ht1Var).c();
            }
            co1Var = h71Var.H;
        }
        ht1 ht1Var2 = zn1Var.c.u0;
        if (ht1Var2 != null) {
            ((yu0) ht1Var2).c();
        }
    }

    public final void E() {
        if (this.a) {
            n71 n71VarU = u();
            if (n71VarU != null) {
                n71VarU.E();
                return;
            }
            return;
        }
        if (this.n != null) {
            T(this, false, 7);
        } else {
            V(this, false, 7);
        }
    }

    public final void F() {
        if (this.c0) {
            return;
        }
        if (this.o0.b.i != null || this.u0 != null) {
            this.Y = true;
            return;
        }
        cg2 cg2Var = this.Z;
        this.c0 = true;
        t42 t42Var = new t42();
        t42Var.a = new cg2();
        lt1 snapshotObserver = ((r7) q71.a(this)).getSnapshotObserver();
        h7 h7Var = new h7(6, this, t42Var);
        snapshotObserver.a.c(this, snapshotObserver.d, h7Var);
        this.c0 = false;
        this.Z = (cg2) t42Var.a;
        this.Y = false;
        r7 r7Var = (r7) q71.a(this);
        r7Var.getSemanticsOwner().b(this, cg2Var);
        r7Var.w();
    }

    public final void G() {
        n71 n71Var;
        if (this.s > 0) {
            this.v = true;
        }
        if (!this.a || (n71Var = this.w) == null) {
            return;
        }
        n71Var.G();
    }

    public final boolean H() {
        return this.x != null;
    }

    public final boolean I() {
        return this.p0.p.Y;
    }

    public final Boolean J() {
        sf1 sf1Var = this.p0.q;
        if (sf1Var != null) {
            return Boolean.valueOf(sf1Var.H != qf1.c);
        }
        return null;
    }

    public final void K() {
        n71 n71VarU;
        if (this.l0 == l71.c) {
            f();
        }
        sf1 sf1Var = this.p0.q;
        sf1Var.getClass();
        boolean z = true;
        try {
            sf1Var.j = true;
            if (!sf1Var.t) {
                z01.b("replace() called on item that was not placed");
            }
            sf1Var.j0 = false;
            if (sf1Var.H == qf1.c) {
                z = false;
            }
            sf1Var.A0(sf1Var.w, sf1Var.x);
            if (z && !sf1Var.j0 && (n71VarU = sf1Var.i.a.u()) != null) {
                n71VarU.S(false);
            }
        } finally {
            sf1Var.j = false;
        }
    }

    public final void L(int i, int i2, int i3) {
        if (i == i2) {
            return;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i > i2 ? i + i4 : i;
            int i6 = i > i2 ? i2 + i4 : (i2 + i3) - 2;
            q91 q91Var = this.t;
            pm1 pm1Var = (pm1) q91Var.b;
            ta taVar = (ta) q91Var.c;
            Object objL = pm1Var.l(i5);
            taVar.a();
            ((pm1) q91Var.b).a(i6, (n71) objL);
            taVar.a();
        }
        O();
        G();
        E();
    }

    public final void M(n71 n71Var) {
        if (n71Var.p0.l > 0) {
            r71 r71Var = this.p0;
            r71Var.d(r71Var.l - 1);
        }
        if (this.x != null) {
            n71Var.h();
        }
        n71Var.w = null;
        if (n71Var.w0 > 0) {
            a0(this.w0 - 1);
        }
        n71Var.o0.d.X = null;
        if (n71Var.a) {
            this.s--;
            pm1 pm1Var = (pm1) n71Var.t.b;
            Object[] objArr = pm1Var.a;
            int i = pm1Var.c;
            for (int i2 = 0; i2 < i; i2++) {
                ((n71) objArr[i2]).o0.d.X = null;
            }
        }
        G();
        O();
    }

    public final void N() {
        n42 rectManager;
        this.j = true;
        it1 it1Var = this.x;
        if (it1Var == null || (rectManager = ((r7) it1Var).getRectManager()) == null) {
            return;
        }
        rectManager.e(this);
    }

    public final void O() {
        if (!this.a) {
            this.e0 = true;
            return;
        }
        n71 n71VarU = u();
        if (n71VarU != null) {
            n71VarU.O();
        }
    }

    public final void P() {
        q91 q91Var = this.t;
        int i = ((pm1) q91Var.b).c;
        while (true) {
            i--;
            pm1 pm1Var = (pm1) q91Var.b;
            if (-1 >= i) {
                pm1Var.h();
                ((ta) q91Var.c).a();
                return;
            }
            M((n71) pm1Var.a[i]);
        }
    }

    public final void Q(int i, int i2) {
        if (i2 < 0) {
            z01.a("count (" + i2 + ") must be greater than 0");
        }
        int i3 = (i2 + i) - 1;
        if (i > i3) {
            return;
        }
        while (true) {
            q91 q91Var = this.t;
            M((n71) ((pm1) q91Var.b).a[i3]);
            Object objL = ((pm1) q91Var.b).l(i3);
            ((ta) q91Var.c).a();
            if (i3 == i) {
                return;
            } else {
                i3--;
            }
        }
    }

    public final void R() {
        n71 n71VarU;
        if (this.l0 == l71.c) {
            f();
        }
        nh1 nh1Var = this.p0.p;
        r71 r71Var = nh1Var.i;
        try {
            nh1Var.j = true;
            if (!nh1Var.t) {
                z01.b("replace called on unplaced item");
            }
            boolean z = nh1Var.Y;
            nh1Var.A0(nh1Var.v, nh1Var.x, nh1Var.w);
            if (z && !nh1Var.n0 && (n71VarU = r71Var.a.u()) != null) {
                n71VarU.U(false);
            }
            nh1Var.j = false;
        } catch (Throwable th) {
            try {
                r71Var.a.Y(th);
                throw null;
            } catch (Throwable th2) {
                nh1Var.j = false;
                throw th2;
            }
        }
    }

    public final void S(boolean z) {
        it1 it1Var;
        if (this.a || (it1Var = this.x) == null) {
            return;
        }
        ((r7) it1Var).v(this, true, z);
    }

    public final void U(boolean z) {
        it1 it1Var;
        if (this.a || (it1Var = this.x) == null) {
            return;
        }
        ((r7) it1Var).v(this, false, z);
    }

    public final void X() {
        pm1 pm1VarZ = z();
        Object[] objArr = pm1VarZ.a;
        int i = pm1VarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            n71 n71Var = (n71) objArr[i2];
            l71 l71Var = n71Var.m0;
            n71Var.l0 = l71Var;
            if (l71Var != l71.c) {
                n71Var.X();
            }
        }
    }

    public final void Y(Throwable th) {
        j30 j30Var = this.k0;
        sr2 sr2Var = f30.a;
        gw1 gw1Var = (gw1) j30Var;
        gw1Var.getClass();
        e30 e30Var = (e30) mj4.a(gw1Var, sr2Var);
        if (e30Var == null) {
            throw th;
        }
        ej4.b(th, new zb(4, e30Var, this));
        throw th;
    }

    public final void Z(jc0 jc0Var) {
        if (g31.a(this.h0, jc0Var)) {
            return;
        }
        this.h0 = jc0Var;
        E();
        n71 n71VarU = u();
        if (n71VarU != null) {
            n71VarU.C();
        }
        D();
        for (dk1 dk1Var = this.o0.f; dk1Var != null; dk1Var = dk1Var.i) {
            dk1Var.a();
        }
    }

    @Override // defpackage.d20
    public final void a() {
        b81 b81Var = this.q0;
        if (b81Var != null) {
            b81Var.a();
        }
        zn1 zn1Var = this.o0;
        co1 co1Var = zn1Var.c.H;
        for (co1 co1Var2 = zn1Var.d; !g31.a(co1Var2, co1Var) && co1Var2 != null; co1Var2 = co1Var2.H) {
            co1Var2.h1();
        }
    }

    public final void a0(int i) {
        n71 n71VarU;
        n71 n71VarU2;
        int i2 = this.w0;
        if (i2 != i) {
            if (i > 0 && i2 == 0 && (n71VarU2 = u()) != null) {
                n71VarU2.a0(n71VarU2.w0 + 1);
            }
            if (i == 0 && this.w0 > 0 && (n71VarU = u()) != null) {
                n71VarU.a0(n71VarU.w0 - 1);
            }
            this.w0 = i;
        }
    }

    @Override // defpackage.d20
    public final void b() {
        s6 s6Var;
        b81 b81Var = this.q0;
        if (b81Var != null) {
            b81Var.i(true);
        }
        this.x0 = true;
        dk1 dk1Var = this.o0.e;
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
        if (H()) {
            this.Z = null;
            this.Y = false;
        }
        it1 it1Var = this.x;
        if (it1Var == null || (s6Var = ((r7) it1Var).w0) == null || !s6Var.k.e(this.b)) {
            return;
        }
        s6Var.a.n(s6Var.c, this.b, false);
    }

    public final void b0(n71 n71Var) {
        if (g31.a(n71Var, this.n)) {
            return;
        }
        this.n = n71Var;
        r71 r71Var = this.p0;
        if (n71Var != null) {
            if (r71Var.q == null) {
                r71Var.q = new sf1(r71Var);
            }
            zn1 zn1Var = this.o0;
            co1 co1Var = zn1Var.c.H;
            for (co1 co1Var2 = zn1Var.d; !g31.a(co1Var2, co1Var) && co1Var2 != null; co1Var2 = co1Var2.H) {
                co1Var2.Q0();
            }
        } else {
            r71Var.q = null;
            r71Var.f = false;
            r71Var.e = false;
        }
        E();
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 5381. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final void c(defpackage.ek1 r20) {
        /*
            Method dump skipped, instruction units count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n71.c(ek1):void");
    }

    public final void c0(oh1 oh1Var) {
        if (g31.a(this.f0, oh1Var)) {
            return;
        }
        this.f0 = oh1Var;
        l11 l11Var = this.g0;
        if (l11Var != null) {
            ((ku1) l11Var.c).setValue(oh1Var);
        }
        E();
    }

    public final void d(it1 it1Var) {
        n71 n71Var;
        cg2 cg2VarW;
        if (this.x != null) {
            z01.b("Cannot attach " + this + " as it already is attached.  Tree: " + g(0));
        }
        n71 n71Var2 = this.w;
        if (n71Var2 != null && !g31.a(n71Var2.x, it1Var)) {
            StringBuilder sb = new StringBuilder("Attaching to a different owner(");
            sb.append(it1Var);
            sb.append(") than the parent's owner(");
            n71 n71VarU = u();
            sb.append(n71VarU != null ? n71VarU.x : null);
            sb.append("). This tree: ");
            sb.append(g(0));
            sb.append(" Parent tree: ");
            n71 n71Var3 = this.w;
            sb.append(n71Var3 != null ? n71Var3.g(0) : null);
            z01.b(sb.toString());
        }
        n71 n71VarU2 = u();
        r71 r71Var = this.p0;
        if (n71VarU2 == null) {
            r71Var.p.Y = true;
            ((r7) it1Var).getRectManager().f(this, false);
            sf1 sf1Var = r71Var.q;
            if (sf1Var != null) {
                sf1Var.H = qf1.a;
            }
        }
        zn1 zn1Var = this.o0;
        zn1Var.d.X = n71VarU2 != null ? n71VarU2.o0.c : null;
        this.x = it1Var;
        this.H = (n71VarU2 != null ? n71VarU2.H : -1) + 1;
        ek1 ek1Var = this.u0;
        if (ek1Var != null) {
            c(ek1Var);
        }
        this.u0 = null;
        ((r7) it1Var).getLayoutNodes().h(this.b, this);
        n71 n71Var4 = this.w;
        if (n71Var4 == null || (n71Var = n71Var4.n) == null) {
            n71Var = this.n;
        }
        b0(n71Var);
        if (this.n == null && zn1Var.d(512)) {
            b0(this);
        }
        if (!this.x0) {
            for (dk1 dk1Var = zn1Var.f; dk1Var != null; dk1Var = dk1Var.i) {
                dk1Var.y0();
            }
        }
        pm1 pm1Var = (pm1) this.t.b;
        Object[] objArr = pm1Var.a;
        int i = pm1Var.c;
        for (int i2 = 0; i2 < i; i2++) {
            ((n71) objArr[i2]).d(it1Var);
        }
        if (!this.x0) {
            zn1Var.e();
        }
        E();
        if (n71VarU2 != null) {
            n71VarU2.E();
        }
        r71Var.j();
        if (!this.x0 && zn1Var.d(8)) {
            F();
        }
        s6 s6Var = ((r7) it1Var).w0;
        if (s6Var == null || (cg2VarW = w()) == null || !cg2VarW.a.b(kg2.q)) {
            return;
        }
        s6Var.k.a(this.b);
        s6Var.a.n(s6Var.c, this.b, true);
    }

    public final void d0(ek1 ek1Var) {
        if (this.a && this.t0 != bk1.a) {
            z01.a("Modifiers are not supported on virtual LayoutNodes");
        }
        if (this.x0) {
            z01.a("modifier is updated when deactivated");
        }
        if (!H()) {
            this.u0 = ek1Var;
            return;
        }
        c(ek1Var);
        if (this.Y) {
            F();
        }
    }

    public final void e() {
        this.m0 = this.l0;
        l71 l71Var = l71.c;
        this.l0 = l71Var;
        pm1 pm1VarZ = z();
        Object[] objArr = pm1VarZ.a;
        int i = pm1VarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            n71 n71Var = (n71) objArr[i2];
            if (n71Var.l0 != l71Var) {
                n71Var.e();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [dk1] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [dk1] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [pm1] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final void e0(w73 w73Var) {
        if (g31.a(this.j0, w73Var)) {
            return;
        }
        this.j0 = w73Var;
        dk1 dk1Var = this.o0.f;
        if ((dk1Var.e & 16) != 0) {
            while (dk1Var != null) {
                if ((dk1Var.c & 16) != 0) {
                    ?? B = dk1Var;
                    ?? pm1Var = 0;
                    while (B != 0) {
                        if (B instanceof qy1) {
                            ((qy1) B).b0();
                        } else if ((B.c & 16) != 0 && (B instanceof zb0)) {
                            dk1 dk1Var2 = ((zb0) B).H;
                            int i = 0;
                            B = B;
                            pm1Var = pm1Var;
                            while (dk1Var2 != null) {
                                if ((dk1Var2.c & 16) != 0) {
                                    i++;
                                    pm1Var = pm1Var;
                                    if (i == 1) {
                                        B = dk1Var2;
                                    } else {
                                        if (pm1Var == 0) {
                                            pm1Var = new pm1(new dk1[16]);
                                        }
                                        if (B != 0) {
                                            pm1Var.b(B);
                                            B = 0;
                                        }
                                        pm1Var.b(dk1Var2);
                                    }
                                }
                                dk1Var2 = dk1Var2.i;
                                B = B;
                                pm1Var = pm1Var;
                            }
                            if (i == 1) {
                            }
                        }
                        B = cm4.b(pm1Var);
                    }
                }
                if ((dk1Var.e & 16) == 0) {
                    return;
                } else {
                    dk1Var = dk1Var.i;
                }
            }
        }
    }

    public final void f() {
        this.m0 = this.l0;
        this.l0 = l71.c;
        pm1 pm1VarZ = z();
        Object[] objArr = pm1VarZ.a;
        int i = pm1VarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            n71 n71Var = (n71) objArr[i2];
            if (n71Var.l0 == l71.b) {
                n71Var.f();
            }
        }
    }

    public final void f0() {
        if (this.s <= 0 || !this.v) {
            return;
        }
        this.v = false;
        pm1 pm1Var = this.u;
        if (pm1Var == null) {
            pm1Var = new pm1(new n71[16]);
            this.u = pm1Var;
        }
        pm1Var.h();
        pm1 pm1Var2 = (pm1) this.t.b;
        Object[] objArr = pm1Var2.a;
        int i = pm1Var2.c;
        for (int i2 = 0; i2 < i; i2++) {
            n71 n71Var = (n71) objArr[i2];
            if (n71Var.a) {
                pm1Var.d(pm1Var.c, n71Var.z());
            } else {
                pm1Var.b(n71Var);
            }
        }
        r71 r71Var = this.p0;
        r71Var.p.h0 = true;
        sf1 sf1Var = r71Var.q;
        if (sf1Var != null) {
            sf1Var.Z = true;
        }
    }

    public final String g(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
        sb.append("|-");
        sb.append(toString());
        sb.append('\n');
        pm1 pm1VarZ = z();
        Object[] objArr = pm1VarZ.a;
        int i3 = pm1VarZ.c;
        for (int i4 = 0; i4 < i3; i4++) {
            sb.append(((n71) objArr[i4]).g(i + 1));
        }
        String string = sb.toString();
        return i == 0 ? string.substring(0, string.length() - 1) : string;
    }

    public final void h() {
        o71 o71Var;
        it1 it1Var = this.x;
        if (it1Var == null) {
            StringBuilder sb = new StringBuilder("Cannot detach node that is already detached!  Tree: ");
            n71 n71VarU = u();
            sb.append(n71VarU != null ? n71VarU.g(0) : null);
            z01.c(sb.toString());
            og.k();
            return;
        }
        n71 n71VarU2 = u();
        r71 r71Var = this.p0;
        if (n71VarU2 != null) {
            n71VarU2.C();
            n71VarU2.E();
            nh1 nh1Var = r71Var.p;
            l71 l71Var = l71.c;
            nh1Var.u = l71Var;
            sf1 sf1Var = r71Var.q;
            if (sf1Var != null) {
                sf1Var.s = l71Var;
            }
        }
        o71 o71Var2 = r71Var.p.f0;
        o71Var2.b = true;
        o71Var2.c = false;
        o71Var2.d = false;
        o71Var2.e = false;
        o71Var2.f = null;
        sf1 sf1Var2 = r71Var.q;
        if (sf1Var2 != null && (o71Var = sf1Var2.X) != null) {
            o71Var.b = true;
            o71Var.c = false;
            o71Var.d = false;
            o71Var.e = false;
            o71Var.f = null;
        }
        zn1 zn1Var = this.o0;
        dk1 dk1Var = zn1Var.e;
        co1 co1Var = zn1Var.c.H;
        for (co1 co1Var2 = zn1Var.d; !g31.a(co1Var2, co1Var) && co1Var2 != null; co1Var2 = co1Var2.H) {
            co1Var2.n1();
            if (co1Var2.x.I()) {
                co1Var2.i1();
            }
        }
        for (dk1 dk1Var2 = dk1Var; dk1Var2 != null; dk1Var2 = dk1Var2.f) {
            if (dk1Var2.w) {
                dk1Var2.F0();
            }
        }
        this.X = true;
        pm1 pm1Var = (pm1) this.t.b;
        Object[] objArr = pm1Var.a;
        int i = pm1Var.c;
        for (int i2 = 0; i2 < i; i2++) {
            ((n71) objArr[i2]).h();
        }
        this.X = false;
        while (dk1Var != null) {
            if (dk1Var.w) {
                dk1Var.z0();
            }
            dk1Var = dk1Var.f;
        }
        r7 r7Var = (r7) it1Var;
        r7Var.getLayoutNodes().g(this.b);
        lh1 lh1Var = r7Var.F0;
        kf kfVar = lh1Var.b;
        ((uf1) kfVar.b).w(this);
        ((uf1) kfVar.c).w(this);
        ((uf1) kfVar.e).w(this);
        ((pm1) lh1Var.e.b).k(this);
        r7Var.x0 = true;
        s6 s6Var = r7Var.w0;
        if (s6Var != null && s6Var.k.e(this.b)) {
            s6Var.a.n(s6Var.c, this.b, false);
        }
        r7Var.getRectManager().h(this);
        this.x = null;
        b0(null);
        this.H = 0;
        nh1 nh1Var2 = r71Var.p;
        nh1Var2.n = Integer.MAX_VALUE;
        nh1Var2.k = Integer.MAX_VALUE;
        nh1Var2.Y = false;
        sf1 sf1Var3 = r71Var.q;
        if (sf1Var3 != null) {
            sf1Var3.n = Integer.MAX_VALUE;
            sf1Var3.k = Integer.MAX_VALUE;
            sf1Var3.H = qf1.c;
        }
        if (zn1Var.d(8)) {
            cg2 cg2Var = this.Z;
            this.Z = null;
            this.Y = false;
            r7Var.getSemanticsOwner().b(this, cg2Var);
            r7Var.w();
        }
    }

    public final void i(cw cwVar, vu0 vu0Var) {
        try {
            this.o0.d.O0(cwVar, vu0Var);
        } catch (Throwable th) {
            Y(th);
            throw null;
        }
    }

    public final void k() {
        if (this.n != null) {
            T(this, false, 5);
        } else {
            V(this, false, 5);
        }
        nh1 nh1Var = this.p0.p;
        q40 q40Var = nh1Var.s ? new q40(nh1Var.e) : null;
        it1 it1Var = this.x;
        if (q40Var != null) {
            if (it1Var != null) {
                ((r7) it1Var).r(this, q40Var.a);
            }
        } else if (it1Var != null) {
            ((r7) it1Var).q(true);
        }
    }

    public final List l() {
        sf1 sf1Var = this.p0.q;
        sf1Var.getClass();
        pm1 pm1Var = sf1Var.Y;
        r71 r71Var = sf1Var.i;
        r71Var.a.n();
        if (!sf1Var.Z) {
            return pm1Var.g();
        }
        n71 n71Var = r71Var.a;
        pm1 pm1VarZ = n71Var.z();
        Object[] objArr = pm1VarZ.a;
        int i = pm1VarZ.c;
        for (int i2 = 0; i2 < i; i2++) {
            n71 n71Var2 = (n71) objArr[i2];
            if (pm1Var.c <= i2) {
                sf1 sf1Var2 = n71Var2.p0.q;
                sf1Var2.getClass();
                pm1Var.b(sf1Var2);
            } else {
                sf1 sf1Var3 = n71Var2.p0.q;
                sf1Var3.getClass();
                Object[] objArr2 = pm1Var.a;
                Object obj = objArr2[i2];
                objArr2[i2] = sf1Var3;
            }
        }
        pm1Var.m(((pm1) ((wl1) n71Var.n()).b).c, pm1Var.c);
        sf1Var.Z = false;
        return pm1Var.g();
    }

    public final List m() {
        return this.p0.p.s0();
    }

    public final List n() {
        return z().g();
    }

    public final List o() {
        return ((pm1) this.t.b).g();
    }

    public final boolean p() {
        return this.p0.p.d0;
    }

    public final boolean q() {
        return this.p0.p.c0;
    }

    public final l71 r() {
        return this.p0.p.u;
    }

    public final l71 s() {
        l71 l71Var;
        sf1 sf1Var = this.p0.q;
        return (sf1Var == null || (l71Var = sf1Var.s) == null) ? l71.c : l71Var;
    }

    public final l11 t() {
        l11 l11Var = this.g0;
        if (l11Var != null) {
            return l11Var;
        }
        l11 l11Var2 = new l11(this, this.f0);
        this.g0 = l11Var2;
        return l11Var2;
    }

    public final String toString() {
        return ip4.a(this) + " children: " + ((pm1) ((wl1) n()).b).c + " measurePolicy: " + this.f0 + " deactivated: " + this.x0;
    }

    public final n71 u() {
        n71 n71Var = this.w;
        while (n71Var != null && n71Var.a) {
            n71Var = n71Var.w;
        }
        return n71Var;
    }

    public final int v() {
        return this.p0.p.n;
    }

    public final cg2 w() {
        if (H() && !this.x0 && this.o0.d(8)) {
            return this.Z;
        }
        return null;
    }

    public final pm1 x() {
        boolean z = this.e0;
        pm1 pm1Var = this.d0;
        if (z) {
            pm1Var.h();
            pm1Var.d(pm1Var.c, z());
            Arrays.sort(pm1Var.a, 0, pm1Var.c, A0);
            this.e0 = false;
        }
        return pm1Var;
    }

    @Override // defpackage.jt1
    public final boolean y() {
        return H();
    }

    public final pm1 z() {
        f0();
        if (this.s == 0) {
            return (pm1) this.t.b;
        }
        pm1 pm1Var = this.u;
        pm1Var.getClass();
        return pm1Var;
    }

    public n71(int i) {
        this((i & 1) == 0, dg2.a.addAndGet(1));
    }
}
