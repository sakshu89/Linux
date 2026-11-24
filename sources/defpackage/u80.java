package defpackage;

import java.util.Collections;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class u80 implements b22 {
    public final /* synthetic */ int a;
    public final v80 b;
    public final int c;

    public /* synthetic */ u80(v80 v80Var, int i, int i2) {
        this.a = i2;
        this.b = v80Var;
        this.c = i;
    }

    @Override // defpackage.c22
    public final Object get() {
        Object in2Var;
        Object up2Var;
        int i = this.a;
        int i2 = 1;
        int i3 = this.c;
        v80 v80Var = this.b;
        switch (i) {
            case 0:
                switch (i3) {
                    case 0:
                        return new zv1(v80Var.a.a);
                    case 1:
                        return new tt(v80Var.a.a);
                    case 2:
                        return new co2(v80Var.a.a, (xx1) v80Var.e.get(), (sn1) v80Var.f.get());
                    case 3:
                        return new xx1(v80Var.a.a);
                    case 4:
                        return new sn1(v80Var.a.a);
                    case 5:
                        return new f0(v80Var.a.a);
                    case 6:
                        return new j5(v80Var.a.a);
                    case 7:
                        return new h61(v80Var.a.a);
                    case 8:
                        v80Var.getClass();
                        sg1 sg1Var = new sg1(2);
                        sg1Var.e(v80Var.k.get(), "offline");
                        sg1Var.e(v80Var.m.get(), "gemini");
                        LinkedHashMap linkedHashMap = sg1Var.a;
                        return new n(linkedHashMap.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(linkedHashMap), (f0) v80Var.h.get(), (ip1) v80Var.k.get());
                    case 9:
                        return new ip1();
                    case 10:
                        return new ms0((h61) v80Var.j.get(), (f0) v80Var.h.get(), (f40) v80Var.l.get(), v80Var.n);
                    case 11:
                        return new f40(v80Var.a.a);
                    case 12:
                        return new tt0(v80Var.m, (f0) v80Var.h.get());
                    case 13:
                        return new mt0(v80Var.a.a, (h61) v80Var.j.get(), (f0) v80Var.h.get(), (j5) v80Var.i.get(), (in2) v80Var.Q0.get(), (co2) v80Var.g.get(), (xv1) v80Var.A.get(), (ps0) v80Var.R0.get(), (he1) v80Var.L.get(), (bd1) v80Var.o0.get(), (bh) v80Var.c0.get());
                    case 14:
                        in2Var = new in2((he1) v80Var.L.get(), (ll2) v80Var.J0.get(), (aw1) v80Var.L0.get(), (u30) v80Var.M0.get(), (d62) v80Var.N0.get(), (k72) v80Var.O0.get(), (a60) v80Var.P0.get(), (n) v80Var.o.get(), (f40) v80Var.l.get(), (j5) v80Var.i.get(), (e40) v80Var.w.get(), (bh) v80Var.c0.get());
                        return in2Var;
                    case 15:
                        v80Var.getClass();
                        cq0 cq0Var = new cq0(16);
                        cq0Var.a(v80Var.s.get());
                        cq0Var.a(v80Var.t.get());
                        cq0Var.a(v80Var.u.get());
                        cq0Var.a(v80Var.v.get());
                        cq0Var.a(v80Var.x.get());
                        cq0Var.a(v80Var.y.get());
                        cq0Var.a(v80Var.z.get());
                        cq0Var.a(v80Var.B.get());
                        cq0Var.a(v80Var.C.get());
                        cq0Var.a(v80Var.D.get());
                        cq0Var.a(v80Var.E.get());
                        cq0Var.a(v80Var.F.get());
                        cq0Var.a(v80Var.G.get());
                        cq0Var.a(v80Var.H.get());
                        cq0Var.a(v80Var.I.get());
                        cq0Var.a(v80Var.J.get());
                        return new he1(cq0Var.b(), (mz2) v80Var.K.get());
                    case 16:
                        return new cj1((ii1) v80Var.r.get());
                    case 17:
                        return new ii1(v80Var.a.a, (zv1) v80Var.c.get(), (ue) v80Var.q.get());
                    case 18:
                        return new ue(v80Var.a.a, (n21) v80Var.p.get());
                    case 19:
                        return new n21(v80Var.a.a);
                    case 20:
                        return new bp();
                    case 21:
                        return new a63();
                    case 22:
                        return new r03();
                    case 23:
                        return new rc0((e40) v80Var.w.get());
                    case 24:
                        return new e40();
                    case 25:
                        return new u00();
                    case 26:
                        return new bi1();
                    case 27:
                        return new rp2((xv1) v80Var.A.get());
                    case 28:
                        return new xv1();
                    case 29:
                        return new eu();
                    case 30:
                        return new dx1();
                    case 31:
                        return new o93();
                    case 32:
                        return new nk0();
                    case 33:
                        return new tb2();
                    case 34:
                        return new je2();
                    case 35:
                        return new yb2();
                    case 36:
                        return new tf();
                    case 37:
                        return new mz2();
                    case 38:
                        v80Var.getClass();
                        cq0 cq0Var2 = new cq0(22);
                        cq0Var2.a(v80Var.N.get());
                        cq0Var2.a(v80Var.P.get());
                        cq0Var2.a(v80Var.R.get());
                        cq0Var2.a(v80Var.T.get());
                        cq0Var2.a(v80Var.V.get());
                        cq0Var2.a(v80Var.W.get());
                        cq0Var2.a(v80Var.Y.get());
                        cq0Var2.a(v80Var.h0.get());
                        cq0Var2.a(v80Var.i0.get());
                        cq0Var2.a(v80Var.j0.get());
                        cq0Var2.a(v80Var.n0.get());
                        cq0Var2.a(v80Var.r0.get());
                        cq0Var2.a(v80Var.x0.get());
                        cq0Var2.a(v80Var.u0.get());
                        cq0Var2.a(v80Var.y0.get());
                        cq0Var2.a(v80Var.A0.get());
                        cq0Var2.a(v80Var.C0.get());
                        cq0Var2.a(v80Var.E0.get());
                        cq0Var2.a(v80Var.F0.get());
                        cq0Var2.a(v80Var.G0.get());
                        cq0Var2.a(v80Var.I0.get());
                        cq0Var2.a(v80Var.K0.get());
                        return new ll2(cq0Var2.b());
                    case 39:
                        return new b6((j13) v80Var.M.get());
                    case 40:
                        return new j13(v80Var.a.a);
                    case 41:
                        return new uy((c93) v80Var.O.get(), (zv1) v80Var.c.get());
                    case 42:
                        return new c93(v80Var.a.a, (zv1) v80Var.c.get());
                    case 43:
                        return new b6((fl) v80Var.Q.get());
                    case 44:
                        return new fl(v80Var.a.a);
                    case 45:
                        return new b6((nm) v80Var.S.get());
                    case 46:
                        return new nm(v80Var.a.a, (zv1) v80Var.c.get());
                    case 47:
                        return new uy((r2) v80Var.U.get(), (zv1) v80Var.c.get());
                    case 48:
                        return new r2(v80Var.a.a);
                    case 49:
                        return new dd2(v80Var.a.a, (r2) v80Var.U.get(), (zv1) v80Var.c.get());
                    case 50:
                        return new ci2(v80Var.a.a, (n21) v80Var.p.get(), (si2) v80Var.X.get(), (e40) v80Var.w.get());
                    case 51:
                        return new si2((r2) v80Var.U.get(), v80Var.a.a);
                    case 52:
                        in2Var = new vc2((r2) v80Var.U.get(), (xb2) v80Var.Z.get(), (nb2) v80Var.b0.get(), (dt1) v80Var.d0.get(), (j5) v80Var.i.get(), (zv1) v80Var.c.get(), (xj1) v80Var.e0.get(), (uv1) v80Var.f0.get(), (xc2) v80Var.g0.get());
                        return in2Var;
                    case 53:
                        return new xb2((r2) v80Var.U.get(), v80Var.a.a);
                    case 54:
                        return new nb2((r2) v80Var.U.get(), v80Var.a.a, (dd3) v80Var.a0.get());
                    case 55:
                        return new dd3();
                    case 56:
                        return new dt1(v80Var.a.a, (bh) v80Var.c0.get());
                    case 57:
                        return new bh();
                    case 58:
                        return new xj1();
                    case 59:
                        return new uv1();
                    case 60:
                        return new xc2();
                    case 61:
                        return new nf((ue) v80Var.q.get(), (r2) v80Var.U.get(), (j5) v80Var.i.get());
                    case 62:
                        return new uy((ii1) v80Var.r.get(), (nb2) v80Var.b0.get());
                    case 63:
                        in2Var = new gi1((n21) v80Var.p.get(), (ii1) v80Var.r.get(), (nb2) v80Var.b0.get(), (xv1) v80Var.A.get(), (up2) v80Var.l0.get(), (qq2) v80Var.m0.get());
                        return in2Var;
                    case 64:
                        up2Var = new up2((r2) v80Var.U.get(), (dt1) v80Var.d0.get(), (xp2) v80Var.k0.get(), (xj1) v80Var.e0.get(), (nb2) v80Var.b0.get());
                        return up2Var;
                    case 65:
                        return new xp2();
                    case 66:
                        return new qq2((r2) v80Var.U.get(), (ii1) v80Var.r.get(), (j5) v80Var.i.get());
                    case 67:
                        return new np((dp) v80Var.p0.get(), (b50) v80Var.q0.get());
                    case 68:
                        return new dp(v80Var.a.a, (zv1) v80Var.c.get(), (n21) v80Var.p.get(), (bd1) v80Var.o0.get());
                    case 69:
                        return new bd1(v80Var.a.a);
                    case 70:
                        return new b50(v80Var.a.a, (zv1) v80Var.c.get());
                    case 71:
                        in2Var = new bj1((oi1) v80Var.s0.get(), (b50) v80Var.q0.get(), (ja3) v80Var.u0.get(), (zl2) v80Var.v0.get(), (vv1) v80Var.w0.get(), (j5) v80Var.i.get());
                        return in2Var;
                    case 72:
                        return new oi1(v80Var.a.a, (n21) v80Var.p.get());
                    case 73:
                        up2Var = new ja3((b50) v80Var.q0.get(), (vw1) v80Var.t0.get(), (n21) v80Var.p.get(), (r2) v80Var.U.get(), (j5) v80Var.i.get(), (bh) v80Var.c0.get());
                        return up2Var;
                    case 74:
                        return new vw1(v80Var.a.a);
                    case 75:
                        return new zl2((r2) v80Var.U.get());
                    case 76:
                        vv1 vv1Var = new vv1();
                        vv1Var.a = new tv1(i2);
                        return vv1Var;
                    case 77:
                        return new uy((b50) v80Var.q0.get());
                    case 78:
                        return new b6((s5) v80Var.z0.get());
                    case 79:
                        return new s5(v80Var.a.a, (n21) v80Var.p.get());
                    case 80:
                        in2Var = new u93((n21) v80Var.p.get(), (bd3) v80Var.B0.get(), (ii1) v80Var.r.get(), (nb2) v80Var.b0.get(), (j5) v80Var.i.get(), (r2) v80Var.U.get());
                        return in2Var;
                    case 81:
                        return new bd3((h61) v80Var.j.get(), (f40) v80Var.l.get());
                    case 82:
                        return new np(v80Var.a.a, (n21) v80Var.p.get(), (hv) v80Var.D0.get());
                    case 83:
                        return new hv((r2) v80Var.U.get(), (nb2) v80Var.b0.get(), (j5) v80Var.i.get());
                    case 84:
                        return new uy((n21) v80Var.p.get());
                    case 85:
                        return new cp();
                    case 86:
                        return new uy((vy) v80Var.H0.get());
                    case 87:
                        return new vy(v80Var.a.a);
                    case 88:
                        return new k0(v80Var.J0);
                    case 89:
                        return new aw1((zv1) v80Var.c.get());
                    case 90:
                        return new u30();
                    case 91:
                        return new d62((xv1) v80Var.A.get());
                    case 92:
                        return new k72();
                    case 93:
                        return new a60();
                    case 94:
                        return new ps0((ms0) v80Var.m.get(), (f0) v80Var.h.get());
                    case 95:
                        return new pn2(v80Var.a.a);
                    case 96:
                        return new l93();
                    case 97:
                        return new oj1();
                    case 98:
                        return new h60((pn2) v80Var.T0.get(), (co2) v80Var.g.get());
                    case 99:
                        return new yg(v80Var.a.a, (j5) v80Var.i.get());
                    default:
                        throw new AssertionError(i3);
                }
            default:
                wf wfVar = v80Var.a;
                if (i3 == 0) {
                    return new oj2(wfVar.a, (f0) v80Var.h.get(), (j5) v80Var.i.get(), (h61) v80Var.j.get(), (co2) v80Var.g.get(), (n) v80Var.o.get(), (zv1) v80Var.c.get(), (mt0) v80Var.S0.get(), (ps0) v80Var.R0.get());
                }
                if (i3 == 1) {
                    return new sj2(wfVar.a, (zv1) v80Var.c.get(), (j5) v80Var.i.get(), (co2) v80Var.g.get());
                }
                if (i3 == 2) {
                    return new so2((in2) v80Var.Q0.get(), (pn2) v80Var.T0.get(), (co2) v80Var.g.get(), (l93) v80Var.U0.get(), (f40) v80Var.l.get(), (zv1) v80Var.c.get(), (j5) v80Var.i.get(), (oj1) v80Var.V0.get(), (r2) v80Var.U.get(), (mt0) v80Var.S0.get(), (h60) v80Var.W0.get(), (bh) v80Var.c0.get(), (ii1) v80Var.r.get());
                }
                throw new AssertionError(i3);
        }
    }
}
