package defpackage;

import android.os.Trace;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xz2 extends dk1 implements f71, qf0, eg2 {
    public yz2 H;
    public qo0 X;
    public int Y;
    public boolean Z;
    public int c0;
    public int d0;
    public HashMap e0;
    public du1 f0;
    public vz2 g0;
    public wz2 h0;
    public String x;

    /* JADX WARN: Code duplicated, block: B:11:0x0010  */
    @Override // defpackage.f71
    public final int B(mf1 mf1Var, jh1 jh1Var, int i) {
        du1 du1VarI0;
        wz2 wz2Var = this.h0;
        if (wz2Var == null) {
            du1VarI0 = I0();
        } else {
            if (!wz2Var.c) {
                wz2Var = null;
            }
            if (wz2Var == null || (du1VarI0 = wz2Var.d) == null) {
                du1VarI0 = I0();
            }
        }
        du1VarI0.d(mf1Var);
        return du1VarI0.a(i, mf1Var.getLayoutDirection());
    }

    public final du1 I0() {
        if (this.f0 == null) {
            this.f0 = new du1(this.x, this.H, this.X, this.Y, this.Z, this.c0, this.d0);
        }
        du1 du1Var = this.f0;
        du1Var.getClass();
        return du1Var;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0016  */
    @Override // defpackage.qf0
    public final void N(p71 p71Var) {
        du1 du1VarI0;
        if (this.w) {
            wz2 wz2Var = this.h0;
            if (wz2Var == null) {
                du1VarI0 = I0();
            } else {
                if (!wz2Var.c) {
                    wz2Var = null;
                }
                if (wz2Var == null || (du1VarI0 = wz2Var.d) == null) {
                    du1VarI0 = I0();
                }
            }
            ia iaVar = du1VarI0.j;
            if (iaVar == null) {
                c11.b("Internal Error: ParagraphLayoutCache could not provide a Paragraph during the draw phase. Please report this bug on the official Issue Tracker with the following diagnostic information: (layoutCache=" + this.f0 + ", textSubstitution=" + this.h0 + ')');
                og.k();
                return;
            }
            cw cwVarM = p71Var.a.b.m();
            boolean z = du1VarI0.k;
            if (z) {
                long j = du1VarI0.l;
                cwVarM.m();
                cwVarM.f(0.0f, 0.0f, (int) (j >> 32), (int) (j & 4294967295L), 1);
            }
            try {
                hp2 hp2Var = this.H.a;
                sx2 sx2Var = hp2Var.m;
                if (sx2Var == null) {
                    sx2Var = sx2.b;
                }
                sx2 sx2Var2 = sx2Var;
                vj2 vj2Var = hp2Var.n;
                if (vj2Var == null) {
                    vj2Var = vj2.d;
                }
                vj2 vj2Var2 = vj2Var;
                wm4 wm4Var = hp2Var.o;
                if (wm4Var == null) {
                    wm4Var = ql0.a;
                }
                wm4 wm4Var2 = wm4Var;
                hn hnVarD = hp2Var.a.d();
                if (hnVarD != null) {
                    iaVar.g(cwVarM, hnVarD, this.H.a.a.a(), vj2Var2, sx2Var2, wm4Var2);
                } else {
                    long jB = sz.g;
                    if (jB == 16) {
                        jB = this.H.b() != 16 ? this.H.b() : sz.b;
                    }
                    iaVar.f(cwVarM, jB, vj2Var2, sx2Var2, wm4Var2);
                }
            } finally {
                if (z) {
                    cwVarM.j();
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0010  */
    @Override // defpackage.f71
    public final int S(mf1 mf1Var, jh1 jh1Var, int i) {
        du1 du1VarI0;
        wz2 wz2Var = this.h0;
        if (wz2Var == null) {
            du1VarI0 = I0();
        } else {
            if (!wz2Var.c) {
                wz2Var = null;
            }
            if (wz2Var == null || (du1VarI0 = wz2Var.d) == null) {
                du1VarI0 = I0();
            }
        }
        du1VarI0.d(mf1Var);
        return mb4.a(du1VarI0.e(mf1Var.getLayoutDirection()).a());
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0015 A[Catch: all -> 0x0097, TryCatch #0 {all -> 0x0097, blocks: (B:3:0x0005, B:5:0x0009, B:10:0x0011, B:13:0x0019, B:15:0x0028, B:16:0x002b, B:18:0x0036, B:20:0x0042, B:21:0x0049, B:22:0x0070, B:12:0x0015), top: B:28:0x0005 }] */
    @Override // defpackage.f71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        du1 du1VarI0;
        Trace.beginSection("TextStringSimpleNode::measure");
        try {
            wz2 wz2Var = this.h0;
            if (wz2Var == null) {
                du1VarI0 = I0();
            } else {
                if (!wz2Var.c) {
                    wz2Var = null;
                }
                if (wz2Var == null || (du1VarI0 = wz2Var.d) == null) {
                    du1VarI0 = I0();
                }
            }
            du1VarI0.d(qh1Var);
            boolean zB = du1VarI0.b(j, qh1Var.getLayoutDirection());
            cu1 cu1Var = du1VarI0.n;
            if (cu1Var != null) {
                cu1Var.b();
            }
            ia iaVar = du1VarI0.j;
            iaVar.getClass();
            ez2 ez2Var = iaVar.d;
            long j2 = du1VarI0.l;
            if (zB) {
                cm4.e(this, 2).c1();
                HashMap map = this.e0;
                if (map == null) {
                    map = new HashMap(2);
                    this.e0 = map;
                }
                map.put(g6.a, Integer.valueOf(Math.round(ez2Var.d(0))));
                map.put(g6.b, Integer.valueOf(Math.round(ez2Var.d(ez2Var.g - 1))));
            }
            int i = (int) (j2 >> 32);
            int i2 = (int) (j2 & 4294967295L);
            zw1 zw1VarE = jh1Var.e(wk4.b(i, i, i2, i2));
            HashMap map2 = this.e0;
            map2.getClass();
            return qh1Var.j0(i, i2, map2, new sl0(zw1VarE, 5));
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0010  */
    @Override // defpackage.f71
    public final int e(mf1 mf1Var, jh1 jh1Var, int i) {
        du1 du1VarI0;
        wz2 wz2Var = this.h0;
        if (wz2Var == null) {
            du1VarI0 = I0();
        } else {
            if (!wz2Var.c) {
                wz2Var = null;
            }
            if (wz2Var == null || (du1VarI0 = wz2Var.d) == null) {
                du1VarI0 = I0();
            }
        }
        du1VarI0.d(mf1Var);
        return mb4.a(du1VarI0.e(mf1Var.getLayoutDirection()).c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [hq0] */
    /* JADX WARN: Type inference failed for: r0v2, types: [vz2] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    @Override // defpackage.eg2
    public final void e0(og2 og2Var) {
        vz2 vz2Var = this.g0;
        var r0 = vz2Var;
        if (vz2Var == null) {
            final int i = 0;
            var r1 = new hq0(this) { // from class: vz2
                public final /* synthetic */ xz2 b;

                {
                    this.b = this;
                }

                /* JADX WARN: Code duplicated, block: B:23:0x00bb  */
                @Override // defpackage.hq0
                public final Object j(Object obj) {
                    jc0 jc0Var;
                    gz2 gz2Var;
                    int i2 = i;
                    boolean z = true;
                    xz2 xz2Var = this.b;
                    switch (i2) {
                        case 0:
                            List list = (List) obj;
                            du1 du1VarI0 = xz2Var.I0();
                            yz2 yz2VarE = yz2.e(xz2Var.H, sz.g, 0L, null, null, 0L, 0, 0L, 16777214);
                            z61 z61Var = du1VarI0.o;
                            gz2 gz2Var2 = null;
                            if (z61Var == null || (jc0Var = du1VarI0.i) == null) {
                                gz2Var = null;
                            } else {
                                be beVar = new be(du1VarI0.a);
                                if (du1VarI0.j == null || du1VarI0.n == null) {
                                    gz2Var = null;
                                } else {
                                    long j = du1VarI0.p & (-8589934589L);
                                    int i3 = du1VarI0.f;
                                    boolean z2 = du1VarI0.e;
                                    int i4 = du1VarI0.d;
                                    qo0 qo0Var = du1VarI0.c;
                                    ii0 ii0Var = ii0.a;
                                    gz2Var = new gz2(new fz2(beVar, yz2VarE, ii0Var, i3, z2, i4, jc0Var, z61Var, qo0Var, j), new fl1(new cj(beVar, yz2VarE, ii0Var, jc0Var, qo0Var), j, du1VarI0.f, du1VarI0.d), du1VarI0.l);
                                }
                            }
                            if (gz2Var != null) {
                                list.add(gz2Var);
                                gz2Var2 = gz2Var;
                            }
                            return Boolean.valueOf(gz2Var2 != null);
                        case 1:
                            String str = ((be) obj).b;
                            wz2 wz2Var = xz2Var.h0;
                            if (wz2Var == null) {
                                wz2 wz2Var2 = new wz2(xz2Var.x, str);
                                du1 du1Var = new du1(str, xz2Var.H, xz2Var.X, xz2Var.Y, xz2Var.Z, xz2Var.c0, xz2Var.d0);
                                du1Var.d(xz2Var.I0().i);
                                wz2Var2.d = du1Var;
                                xz2Var.h0 = wz2Var2;
                            } else if (!g31.a(str, wz2Var.b)) {
                                wz2Var.b = str;
                                du1 du1Var2 = wz2Var.d;
                                if (du1Var2 != null) {
                                    yz2 yz2Var = xz2Var.H;
                                    qo0 qo0Var2 = xz2Var.X;
                                    int i5 = xz2Var.Y;
                                    boolean z3 = xz2Var.Z;
                                    int i6 = xz2Var.c0;
                                    int i7 = xz2Var.d0;
                                    du1Var2.a = str;
                                    du1Var2.b = yz2Var;
                                    du1Var2.c = qo0Var2;
                                    du1Var2.d = i5;
                                    du1Var2.e = z3;
                                    du1Var2.f = i6;
                                    du1Var2.g = i7;
                                    du1Var2.s = (du1Var2.s << 2) | 2;
                                    du1Var2.c();
                                }
                            }
                            a34.a(xz2Var);
                            up4.a(xz2Var);
                            vm4.a(xz2Var);
                            return Boolean.TRUE;
                        default:
                            boolean zBooleanValue = ((Boolean) obj).booleanValue();
                            wz2 wz2Var3 = xz2Var.h0;
                            if (wz2Var3 == null) {
                                z = false;
                            } else {
                                wz2Var3.c = zBooleanValue;
                                a34.a(xz2Var);
                                up4.a(xz2Var);
                                vm4.a(xz2Var);
                            }
                            return Boolean.valueOf(z);
                    }
                }
            };
            this.g0 = r1;
            r0 = r1;
        }
        be beVar = new be(this.x);
        c51[] c51VarArr = mg2.a;
        og2Var.a(kg2.A, nz.h(beVar));
        wz2 wz2Var = this.h0;
        if (wz2Var != null) {
            boolean z = wz2Var.c;
            ng2 ng2Var = kg2.C;
            c51[] c51VarArr2 = mg2.a;
            c51 c51Var = c51VarArr2[17];
            og2Var.a(ng2Var, Boolean.valueOf(z));
            be beVar2 = new be(wz2Var.b);
            ng2 ng2Var2 = kg2.B;
            c51 c51Var2 = c51VarArr2[16];
            og2Var.a(ng2Var2, beVar2);
        }
        final int i2 = 1;
        og2Var.a(bg2.l, new b2(null, new hq0(this) { // from class: vz2
            public final /* synthetic */ xz2 b;

            {
                this.b = this;
            }

            /* JADX WARN: Code duplicated, block: B:23:0x00bb  */
            @Override // defpackage.hq0
            public final Object j(Object obj) {
                jc0 jc0Var;
                gz2 gz2Var;
                int i3 = i2;
                boolean z2 = true;
                xz2 xz2Var = this.b;
                switch (i3) {
                    case 0:
                        List list = (List) obj;
                        du1 du1VarI0 = xz2Var.I0();
                        yz2 yz2VarE = yz2.e(xz2Var.H, sz.g, 0L, null, null, 0L, 0, 0L, 16777214);
                        z61 z61Var = du1VarI0.o;
                        gz2 gz2Var2 = null;
                        if (z61Var == null || (jc0Var = du1VarI0.i) == null) {
                            gz2Var = null;
                        } else {
                            be beVar3 = new be(du1VarI0.a);
                            if (du1VarI0.j == null || du1VarI0.n == null) {
                                gz2Var = null;
                            } else {
                                long j = du1VarI0.p & (-8589934589L);
                                int i4 = du1VarI0.f;
                                boolean z3 = du1VarI0.e;
                                int i5 = du1VarI0.d;
                                qo0 qo0Var = du1VarI0.c;
                                ii0 ii0Var = ii0.a;
                                gz2Var = new gz2(new fz2(beVar3, yz2VarE, ii0Var, i4, z3, i5, jc0Var, z61Var, qo0Var, j), new fl1(new cj(beVar3, yz2VarE, ii0Var, jc0Var, qo0Var), j, du1VarI0.f, du1VarI0.d), du1VarI0.l);
                            }
                        }
                        if (gz2Var != null) {
                            list.add(gz2Var);
                            gz2Var2 = gz2Var;
                        }
                        return Boolean.valueOf(gz2Var2 != null);
                    case 1:
                        String str = ((be) obj).b;
                        wz2 wz2Var2 = xz2Var.h0;
                        if (wz2Var2 == null) {
                            wz2 wz2Var3 = new wz2(xz2Var.x, str);
                            du1 du1Var = new du1(str, xz2Var.H, xz2Var.X, xz2Var.Y, xz2Var.Z, xz2Var.c0, xz2Var.d0);
                            du1Var.d(xz2Var.I0().i);
                            wz2Var3.d = du1Var;
                            xz2Var.h0 = wz2Var3;
                        } else if (!g31.a(str, wz2Var2.b)) {
                            wz2Var2.b = str;
                            du1 du1Var2 = wz2Var2.d;
                            if (du1Var2 != null) {
                                yz2 yz2Var = xz2Var.H;
                                qo0 qo0Var2 = xz2Var.X;
                                int i6 = xz2Var.Y;
                                boolean z4 = xz2Var.Z;
                                int i7 = xz2Var.c0;
                                int i8 = xz2Var.d0;
                                du1Var2.a = str;
                                du1Var2.b = yz2Var;
                                du1Var2.c = qo0Var2;
                                du1Var2.d = i6;
                                du1Var2.e = z4;
                                du1Var2.f = i7;
                                du1Var2.g = i8;
                                du1Var2.s = (du1Var2.s << 2) | 2;
                                du1Var2.c();
                            }
                        }
                        a34.a(xz2Var);
                        up4.a(xz2Var);
                        vm4.a(xz2Var);
                        return Boolean.TRUE;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        wz2 wz2Var4 = xz2Var.h0;
                        if (wz2Var4 == null) {
                            z2 = false;
                        } else {
                            wz2Var4.c = zBooleanValue;
                            a34.a(xz2Var);
                            up4.a(xz2Var);
                            vm4.a(xz2Var);
                        }
                        return Boolean.valueOf(z2);
                }
            }
        }));
        final int i3 = 2;
        og2Var.a(bg2.m, new b2(null, new hq0(this) { // from class: vz2
            public final /* synthetic */ xz2 b;

            {
                this.b = this;
            }

            /* JADX WARN: Code duplicated, block: B:23:0x00bb  */
            @Override // defpackage.hq0
            public final Object j(Object obj) {
                jc0 jc0Var;
                gz2 gz2Var;
                int i4 = i3;
                boolean z2 = true;
                xz2 xz2Var = this.b;
                switch (i4) {
                    case 0:
                        List list = (List) obj;
                        du1 du1VarI0 = xz2Var.I0();
                        yz2 yz2VarE = yz2.e(xz2Var.H, sz.g, 0L, null, null, 0L, 0, 0L, 16777214);
                        z61 z61Var = du1VarI0.o;
                        gz2 gz2Var2 = null;
                        if (z61Var == null || (jc0Var = du1VarI0.i) == null) {
                            gz2Var = null;
                        } else {
                            be beVar3 = new be(du1VarI0.a);
                            if (du1VarI0.j == null || du1VarI0.n == null) {
                                gz2Var = null;
                            } else {
                                long j = du1VarI0.p & (-8589934589L);
                                int i5 = du1VarI0.f;
                                boolean z3 = du1VarI0.e;
                                int i6 = du1VarI0.d;
                                qo0 qo0Var = du1VarI0.c;
                                ii0 ii0Var = ii0.a;
                                gz2Var = new gz2(new fz2(beVar3, yz2VarE, ii0Var, i5, z3, i6, jc0Var, z61Var, qo0Var, j), new fl1(new cj(beVar3, yz2VarE, ii0Var, jc0Var, qo0Var), j, du1VarI0.f, du1VarI0.d), du1VarI0.l);
                            }
                        }
                        if (gz2Var != null) {
                            list.add(gz2Var);
                            gz2Var2 = gz2Var;
                        }
                        return Boolean.valueOf(gz2Var2 != null);
                    case 1:
                        String str = ((be) obj).b;
                        wz2 wz2Var2 = xz2Var.h0;
                        if (wz2Var2 == null) {
                            wz2 wz2Var3 = new wz2(xz2Var.x, str);
                            du1 du1Var = new du1(str, xz2Var.H, xz2Var.X, xz2Var.Y, xz2Var.Z, xz2Var.c0, xz2Var.d0);
                            du1Var.d(xz2Var.I0().i);
                            wz2Var3.d = du1Var;
                            xz2Var.h0 = wz2Var3;
                        } else if (!g31.a(str, wz2Var2.b)) {
                            wz2Var2.b = str;
                            du1 du1Var2 = wz2Var2.d;
                            if (du1Var2 != null) {
                                yz2 yz2Var = xz2Var.H;
                                qo0 qo0Var2 = xz2Var.X;
                                int i7 = xz2Var.Y;
                                boolean z4 = xz2Var.Z;
                                int i8 = xz2Var.c0;
                                int i9 = xz2Var.d0;
                                du1Var2.a = str;
                                du1Var2.b = yz2Var;
                                du1Var2.c = qo0Var2;
                                du1Var2.d = i7;
                                du1Var2.e = z4;
                                du1Var2.f = i8;
                                du1Var2.g = i9;
                                du1Var2.s = (du1Var2.s << 2) | 2;
                                du1Var2.c();
                            }
                        }
                        a34.a(xz2Var);
                        up4.a(xz2Var);
                        vm4.a(xz2Var);
                        return Boolean.TRUE;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        wz2 wz2Var4 = xz2Var.h0;
                        if (wz2Var4 == null) {
                            z2 = false;
                        } else {
                            wz2Var4.c = zBooleanValue;
                            a34.a(xz2Var);
                            up4.a(xz2Var);
                            vm4.a(xz2Var);
                        }
                        return Boolean.valueOf(z2);
                }
            }
        }));
        og2Var.a(bg2.n, new b2(null, new kb(24, this)));
        mg2.a(og2Var, r0);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0010  */
    @Override // defpackage.f71
    public final int n(mf1 mf1Var, jh1 jh1Var, int i) {
        du1 du1VarI0;
        wz2 wz2Var = this.h0;
        if (wz2Var == null) {
            du1VarI0 = I0();
        } else {
            if (!wz2Var.c) {
                wz2Var = null;
            }
            if (wz2Var == null || (du1VarI0 = wz2Var.d) == null) {
                du1VarI0 = I0();
            }
        }
        du1VarI0.d(mf1Var);
        return du1VarI0.a(i, mf1Var.getLayoutDirection());
    }

    @Override // defpackage.dk1
    public final boolean x0() {
        return false;
    }
}
