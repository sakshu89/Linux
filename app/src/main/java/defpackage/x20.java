package defpackage;

import android.os.Trace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x20 {
    public int A;
    public int B;
    public boolean C;
    public final w20 D;
    public final ArrayList E;
    public boolean F;
    public nl2 G;
    public ol2 H;
    public rl2 I;
    public boolean J;
    public gw1 K;
    public yw L;
    public final s20 M;
    public j6 N;
    public bm0 O;
    public mk2 P;
    public final e30 Q;
    public final j70 R;
    public boolean S;
    public long T;
    public d30 U;
    public final b43 a;
    public final a30 b;
    public final ol2 c;
    public final jm1 d;
    public final yw e;
    public final yw f;
    public final q82 g;
    public final g30 h;
    public nv1 j;
    public int k;
    public int l;
    public int m;
    public int[] o;
    public kl1 p;
    public boolean q;
    public boolean r;
    public ml1 v;
    public boolean w;
    public boolean y;
    public final ArrayList i = new ArrayList();
    public final m21 n = new m21();
    public final ArrayList s = new ArrayList();
    public final m21 t = new m21();
    public gw1 u = gw1.e;
    public final m21 x = new m21();
    public int z = -1;

    public x20(b43 b43Var, a30 a30Var, ol2 ol2Var, jm1 jm1Var, yw ywVar, yw ywVar2, q82 q82Var, g30 g30Var) {
        this.a = b43Var;
        this.b = a30Var;
        this.c = ol2Var;
        this.d = jm1Var;
        this.e = ywVar;
        this.f = ywVar2;
        this.g = q82Var;
        this.h = g30Var;
        this.C = a30Var.f() || a30Var.d();
        this.D = new w20(0, this);
        this.E = new ArrayList();
        nl2 nl2VarD = ol2Var.d();
        nl2VarD.c();
        this.G = nl2VarD;
        ol2 ol2Var2 = new ol2();
        if (a30Var.f()) {
            ol2Var2.b();
        }
        if (a30Var.d()) {
            ol2Var2.t = new ml1();
        }
        this.H = ol2Var2;
        rl2 rl2VarF = ol2Var2.f();
        rl2VarF.e(true);
        this.I = rl2VarF;
        this.M = new s20(this, ywVar);
        nl2 nl2VarD2 = this.H.d();
        try {
            j6 j6VarA = nl2VarD2.a(0);
            nl2VarD2.c();
            this.N = j6VarA;
            this.O = new bm0();
            this.Q = new e30(this);
            j70 j70VarJ = a30Var.j();
            j70 j70VarZ = z();
            this.R = j70VarJ.r(j70VarZ == null ? gi0.a : j70VarZ);
        } catch (Throwable th) {
            nl2VarD2.c();
            throw th;
        }
    }

    public static final int N(x20 x20Var, int i, boolean z, int i2) {
        nl2 nl2Var = x20Var.G;
        if (nl2Var.j(i)) {
            int i3 = nl2Var.i(i);
            Object objP = nl2Var.p(i, nl2Var.b);
            if (i3 == 206 && g31.a(objP, y20.e)) {
                Object objH = nl2Var.h(i, 0);
                k52 k52Var = objH instanceof k52 ? (k52) objH : null;
                j52 j52Var = k52Var != null ? k52Var.a : null;
                u20 u20Var = j52Var instanceof u20 ? (u20) j52Var : null;
                if (u20Var != null) {
                    for (x20 x20Var2 : u20Var.a.e) {
                        ol2 ol2Var = x20Var2.c;
                        if (ol2Var.b > 0 && (ol2Var.a[1] & 67108864) != 0) {
                            g30 g30Var = x20Var2.h;
                            synchronized (g30Var.e) {
                                g30Var.p();
                                gm1 gm1Var = g30Var.w;
                                g30Var.w = tz3.b();
                                try {
                                    g30Var.e0.c0(gm1Var);
                                } catch (Throwable th) {
                                    g30Var.w = gm1Var;
                                    throw th;
                                }
                            }
                            yw ywVar = new yw();
                            x20Var2.L = ywVar;
                            nl2 nl2VarD = x20Var2.c.d();
                            try {
                                x20Var2.G = nl2VarD;
                                s20 s20Var = x20Var2.M;
                                yw ywVar2 = s20Var.b;
                                try {
                                    s20Var.b = ywVar;
                                    x20Var2.M(0);
                                    s20 s20Var2 = x20Var2.M;
                                    s20Var2.b();
                                    if (s20Var2.c) {
                                        s20Var2.b.a.e(sr1.c);
                                        if (s20Var2.c) {
                                            s20Var2.d(false);
                                            s20Var2.d(false);
                                            s20Var2.b.a.e(cr1.c);
                                            s20Var2.c = false;
                                        }
                                    }
                                    s20Var.b = ywVar2;
                                    nl2VarD.c();
                                } catch (Throwable th2) {
                                    s20Var.b = ywVar2;
                                    throw th2;
                                }
                            } catch (Throwable th3) {
                                nl2VarD.c();
                                throw th3;
                            }
                        }
                        x20Var.b.r(x20Var2.h);
                    }
                }
                return nl2Var.o(i);
            }
            if (!nl2Var.l(i)) {
                return nl2Var.o(i);
            }
        } else if (nl2Var.d(i)) {
            int i4 = nl2Var.b[(i * 5) + 3] + i;
            int iN = 0;
            for (int i5 = i + 1; i5 < i4; i5 += nl2Var.b[(i5 * 5) + 3]) {
                boolean zL = nl2Var.l(i5);
                if (zL) {
                    x20Var.M.c();
                    s20 s20Var3 = x20Var.M;
                    Object objN = nl2Var.n(i5);
                    s20Var3.c();
                    s20Var3.h.add(objN);
                }
                iN += N(x20Var, i5, zL || z, zL ? 0 : i2 + iN);
                if (zL) {
                    x20Var.M.c();
                    x20Var.M.a();
                }
            }
            if (!nl2Var.l(i)) {
                return iN;
            }
        } else if (!nl2Var.l(i)) {
            return nl2Var.o(i);
        }
        return 1;
    }

    public final boolean A() {
        a42 a42VarX;
        return (this.S || this.y || this.w || (a42VarX = x()) == null || (a42VarX.b & 8) != 0) ? false : true;
    }

    public final void B(ArrayList arrayList) {
        yw ywVar = this.f;
        s20 s20Var = this.M;
        yw ywVar2 = s20Var.b;
        try {
            s20Var.b = ywVar;
            ywVar.a.e(qr1.c);
            if (arrayList.size() <= 0) {
                s20Var.b();
                s20Var.b.a.e(dr1.c);
                s20Var.f = 0;
                s20Var.b = ywVar2;
                return;
            }
            wt1 wt1Var = (wt1) arrayList.get(0);
            bl1 bl1Var = (bl1) wt1Var.a;
            bl1Var.getClass();
            throw null;
        } catch (Throwable th) {
            s20Var.b = ywVar2;
            throw th;
        }
    }

    public final void C(gw1 gw1Var, Object obj) {
        S(126665345, 0, null, null);
        D();
        h0(obj);
        long j = this.T;
        try {
            this.T = 126665345L;
            if (this.S) {
                rl2.z(this.I);
            }
            boolean z = (this.S || g31.a(this.G.f(), gw1Var)) ? false : true;
            if (z) {
                J(gw1Var);
            }
            S(202, 0, y20.c, gw1Var);
            this.K = null;
            this.w = z;
            throw null;
        } catch (Throwable th) {
            try {
                ej4.b(th, new t20(this, 2));
                throw th;
            } catch (Throwable th2) {
                p(false);
                this.K = null;
                this.T = j;
                p(false);
                throw th2;
            }
        }
    }

    public final Object D() {
        boolean z = this.S;
        xy xyVar = r20.a;
        if (!z) {
            Object objM = this.G.m();
            if (!this.y || (objM instanceof s72)) {
                return objM;
            }
        } else if (this.r) {
            y20.a("A call to createNode(), emitNode() or useNode() expected");
            return xyVar;
        }
        return xyVar;
    }

    public final List E() {
        a30 a30Var = this.b;
        z20 z20VarH = a30Var.h();
        g30 g30Var = z20VarH != null ? (g30) z20VarH : null;
        if (g30Var != null) {
            ol2 ol2Var = g30Var.i;
            nl2 nl2VarD = ol2Var.d();
            try {
                Integer numB = cj4.b(nl2VarD, a30Var, 0, nl2VarD.c);
                nl2VarD.c();
                if (numB != null) {
                    nl2 nl2VarD2 = ol2Var.d();
                    try {
                        return mz.G(cj4.c(nl2VarD2, numB.intValue(), 0), g30Var.e0.E());
                    } finally {
                        nl2VarD2.c();
                    }
                }
            } catch (Throwable th) {
                nl2VarD.c();
                throw th;
            }
        }
        return ii0.a;
    }

    public final int F(int i) {
        int iQ = this.G.q(i) + 1;
        int i2 = 0;
        while (iQ < i) {
            if (!this.G.k(iQ)) {
                i2++;
            }
            iQ += this.G.b[(iQ * 5) + 3];
        }
        return i2;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0055 A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #0 {all -> 0x0024, blocks: (B:3:0x0005, B:6:0x0012, B:8:0x0020, B:12:0x0029, B:11:0x0026, B:15:0x0030, B:20:0x003c, B:22:0x0044, B:24:0x004a, B:25:0x004e, B:26:0x004f, B:28:0x0055, B:21:0x0040), top: B:33:0x0005, inners: #1 }] */
    public final Object G(g30 g30Var, g30 g30Var2, Integer num, List list, fq0 fq0Var) {
        Object objA;
        boolean z = this.F;
        int i = this.k;
        try {
            this.F = true;
            this.k = 0;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                wt1 wt1Var = (wt1) list.get(i2);
                a42 a42Var = (a42) wt1Var.a;
                Object obj = wt1Var.b;
                if (obj != null) {
                    b0(a42Var, obj);
                } else {
                    b0(a42Var, null);
                }
            }
            if (g30Var == null) {
                objA = fq0Var.a();
            } else {
                int iIntValue = num != null ? num.intValue() : -1;
                if (g30Var2 == null || g30Var2 == g30Var || iIntValue < 0) {
                    objA = fq0Var.a();
                } else {
                    g30Var.Y = g30Var2;
                    g30Var.Z = iIntValue;
                    try {
                        objA = fq0Var.a();
                        g30Var.Y = null;
                        g30Var.Z = 0;
                    } catch (Throwable th) {
                        g30Var.Y = null;
                        g30Var.Z = 0;
                        throw th;
                    }
                }
                if (objA == null) {
                    objA = fq0Var.a();
                }
            }
            this.F = z;
            this.k = i;
            return objA;
        } catch (Throwable th2) {
            this.F = z;
            this.k = i;
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x003e  */
    /* JADX WARN: Code duplicated, block: B:200:0x0131 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x0120 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x0122 A[LOOP:7: B:37:0x00cb->B:56:0x0122, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x012b  */
    /* JADX WARN: Code duplicated, block: B:61:0x0139  */
    /* JADX WARN: Code duplicated, block: B:68:0x0164  */
    /* JADX WARN: Code duplicated, block: B:69:0x0166  */
    /* JADX WARN: Code duplicated, block: B:72:0x016b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:73:0x0177
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final void H() {
        /*
            Method dump skipped, instruction units count: 887
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x20.H():void");
    }

    public final void I() {
        int i;
        M(this.G.g);
        s20 s20Var = this.M;
        s20Var.d(false);
        m21 m21Var = s20Var.d;
        x20 x20Var = s20Var.a;
        nl2 nl2Var = x20Var.G;
        if (nl2Var.c > 0 && m21Var.a(-2) != (i = nl2Var.i)) {
            if (!s20Var.c && s20Var.e) {
                s20Var.d(false);
                s20Var.b.a.e(gr1.c);
                s20Var.c = true;
            }
            if (i > 0) {
                j6 j6VarA = nl2Var.a(i);
                m21Var.c(i);
                s20Var.d(false);
                bs1 bs1Var = s20Var.b.a;
                bs1Var.e(fr1.c);
                yr4.a(bs1Var, 0, j6VarA);
                s20Var.c = true;
            }
        }
        s20Var.b.a.e(or1.c);
        int i2 = s20Var.f;
        nl2 nl2Var2 = x20Var.G;
        s20Var.f = nl2Var2.b[(nl2Var2.g * 5) + 3] + i2;
    }

    public final void J(gw1 gw1Var) {
        ml1 ml1Var = this.v;
        if (ml1Var == null) {
            ml1Var = new ml1();
            this.v = ml1Var;
        }
        ml1Var.h(this.G.g, gw1Var);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001a  */
    public final void K(int i, int i2, int i3) {
        nl2 nl2Var = this.G;
        if (i == i2) {
            i3 = i;
        } else if (i != i3 && i2 != i3) {
            if (nl2Var.q(i) == i2) {
                i3 = i2;
            } else if (nl2Var.q(i2) == i) {
                i3 = i;
            } else if (nl2Var.q(i) == nl2Var.q(i2)) {
                i3 = nl2Var.q(i);
            } else {
                int iQ = i;
                int i4 = 0;
                while (iQ > 0 && iQ != i3) {
                    iQ = nl2Var.q(iQ);
                    i4++;
                }
                int iQ2 = i2;
                int i5 = 0;
                while (iQ2 > 0 && iQ2 != i3) {
                    iQ2 = nl2Var.q(iQ2);
                    i5++;
                }
                int i6 = i4 - i5;
                int iQ3 = i;
                for (int i7 = 0; i7 < i6; i7++) {
                    iQ3 = nl2Var.q(iQ3);
                }
                int i8 = i5 - i4;
                int iQ4 = i2;
                for (int i9 = 0; i9 < i8; i9++) {
                    iQ4 = nl2Var.q(iQ4);
                }
                i3 = iQ3;
                for (int iQ5 = iQ4; i3 != iQ5; iQ5 = nl2Var.q(iQ5)) {
                    i3 = nl2Var.q(i3);
                }
            }
        }
        while (i > 0 && i != i3) {
            if (nl2Var.l(i)) {
                this.M.a();
            }
            i = nl2Var.q(i);
        }
        o(i2, i3);
    }

    public final Object L() {
        boolean z = this.S;
        xy xyVar = r20.a;
        if (!z) {
            Object objM = this.G.m();
            if (!this.y || (objM instanceof s72)) {
                return objM instanceof k52 ? ((k52) objM).a : objM;
            }
        } else if (this.r) {
            y20.a("A call to createNode(), emitNode() or useNode() expected");
            return xyVar;
        }
        return xyVar;
    }

    public final void M(int i) {
        boolean zL = this.G.l(i);
        s20 s20Var = this.M;
        if (zL) {
            s20Var.c();
            Object objN = this.G.n(i);
            s20Var.c();
            s20Var.h.add(objN);
        }
        N(this, i, zL, 0);
        s20Var.c();
        if (zL) {
            s20Var.a();
        }
    }

    public final boolean O(int i, boolean z) {
        a42 a42VarX;
        if ((i & 1) == 0 && (this.S || this.y)) {
            mk2 mk2Var = this.P;
            if (mk2Var != null && (a42VarX = x()) != null && mk2Var.a()) {
                int i2 = a42VarX.b;
                if ((i2 & 512) != 0) {
                    return true;
                }
                int i3 = i2 | 1;
                a42VarX.b = i3;
                a42VarX.b = (this.y ? i2 | 129 : i3 & (-129)) | 256;
                bs1 bs1Var = this.M.b.a;
                bs1Var.e(nr1.c);
                yr4.a(bs1Var, 0, a42VarX);
                this.b.q(a42VarX);
                return false;
            }
        } else if (!z && A()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0093  */
    /* JADX WARN: Code duplicated, block: B:30:0x009f  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ea  */
    public final void P() {
        long jRotateLeft;
        if (this.s.isEmpty()) {
            this.l = this.G.s() + this.l;
            return;
        }
        nl2 nl2Var = this.G;
        int iG = nl2Var.g();
        int[] iArr = nl2Var.b;
        int i = nl2Var.g;
        Object objP = i < nl2Var.h ? nl2Var.p(i, iArr) : null;
        Object objF = nl2Var.f();
        int i2 = this.m;
        xy xyVar = r20.a;
        if (objP == null) {
            if (objF == null || iG != 207 || objF.equals(xyVar)) {
                jRotateLeft = Long.rotateLeft(Long.rotateLeft(this.T, 3) ^ ((long) iG), 3) ^ ((long) i2);
            } else {
                this.T = Long.rotateLeft(Long.rotateLeft(this.T, 3) ^ ((long) objF.hashCode()), 3) ^ ((long) i2);
            }
            V(null, (iArr[(nl2Var.g * 5) + 1] & 1073741824) != 0);
            H();
            nl2Var.e();
            if (objP != null) {
                if (objP instanceof Enum) {
                    this.T = Long.rotateRight(Long.rotateRight(this.T, 3) ^ ((long) ((Enum) objP).ordinal()), 3);
                } else {
                    this.T = Long.rotateRight(Long.rotateRight(this.T, 3) ^ ((long) objP.hashCode()), 3);
                }
            }
            if (objF == null && iG == 207 && !objF.equals(xyVar)) {
                this.T = Long.rotateRight(Long.rotateRight(this.T ^ ((long) i2), 3) ^ ((long) objF.hashCode()), 3);
                return;
            } else {
                this.T = Long.rotateRight(((long) iG) ^ Long.rotateRight(this.T ^ ((long) i2), 3), 3);
            }
        }
        jRotateLeft = Long.rotateLeft(Long.rotateLeft(this.T, 3) ^ ((long) (objP instanceof Enum ? ((Enum) objP).ordinal() : objP.hashCode())), 3);
        this.T = jRotateLeft;
        V(null, (iArr[(nl2Var.g * 5) + 1] & 1073741824) != 0);
        H();
        nl2Var.e();
        if (objP != null) {
            if (objF == null) {
            }
            this.T = Long.rotateRight(((long) iG) ^ Long.rotateRight(this.T ^ ((long) i2), 3), 3);
        } else if (objP instanceof Enum) {
            this.T = Long.rotateRight(Long.rotateRight(this.T, 3) ^ ((long) ((Enum) objP).ordinal()), 3);
        } else {
            this.T = Long.rotateRight(Long.rotateRight(this.T, 3) ^ ((long) objP.hashCode()), 3);
        }
    }

    public final void Q() {
        nl2 nl2Var = this.G;
        int i = nl2Var.i;
        this.l = i >= 0 ? nl2Var.b[(i * 5) + 1] & 67108863 : 0;
        nl2Var.t();
    }

    public final void R() {
        if (this.l != 0) {
            y20.a("No nodes can be emitted before calling skipAndEndGroup");
        }
        if (this.S) {
            return;
        }
        a42 a42VarX = x();
        if (a42VarX != null) {
            int i = a42VarX.b;
            if ((i & 128) == 0) {
                a42VarX.b = i | 16;
            }
        }
        if (this.s.isEmpty()) {
            Q();
        } else {
            H();
        }
    }

    /* JADX WARN: Code duplicated, block: B:173:0x0326  */
    /* JADX WARN: Code duplicated, block: B:176:0x033c  */
    /* JADX WARN: Code duplicated, block: B:179:0x0357  */
    /* JADX WARN: Code duplicated, block: B:180:0x035d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:181:0x035f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:183:0x0363  */
    /* JADX WARN: Code duplicated, block: B:185:0x036a  */
    /* JADX WARN: Code duplicated, block: B:187:0x036d  */
    /* JADX WARN: Code duplicated, block: B:188:0x036f  */
    /* JADX WARN: Code duplicated, block: B:192:0x039d  */
    /* JADX WARN: Code duplicated, block: B:193:0x039f  */
    /* JADX WARN: Code duplicated, block: B:22:0x0072  */
    /* JADX WARN: Code duplicated, block: B:25:0x007a  */
    /* JADX WARN: Code duplicated, block: B:26:0x007c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0083  */
    /* JADX WARN: Code duplicated, block: B:31:0x0090  */
    /* JADX WARN: Code duplicated, block: B:32:0x0094 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x0096 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x0098  */
    /* JADX WARN: Code duplicated, block: B:36:0x009d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x009f  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:66:0x010b  */
    /* JADX WARN: Code duplicated, block: B:69:0x0111  */
    /* JADX WARN: Code duplicated, block: B:71:0x0125  */
    /* JADX WARN: Code duplicated, block: B:72:0x0129  */
    /* JADX WARN: Code duplicated, block: B:77:0x014d  */
    /* JADX WARN: Code duplicated, block: B:79:0x0155  */
    /* JADX WARN: Code duplicated, block: B:80:0x015f  */
    /* JADX WARN: Code duplicated, block: B:83:0x0173  */
    /* JADX WARN: Code duplicated, block: B:84:0x0175  */
    /* JADX WARN: Code duplicated, block: B:86:0x0179  */
    /* JADX WARN: Code duplicated, block: B:88:0x0186  */
    /* JADX WARN: Code duplicated, block: B:91:0x018e  */
    /* JADX WARN: Code duplicated, block: B:93:0x0197  */
    public final void S(int i, int i2, Object obj, Object obj2) {
        long jRotateLeft;
        boolean z;
        boolean z2;
        boolean z3;
        nv1 nv1Var;
        nv1 nv1Var2;
        ArrayList arrayList;
        ml1 ml1Var;
        int i3;
        Object objValueOf;
        gm1 gm1Var;
        Object objG;
        yl1 yl1Var;
        rl2 rl2Var;
        int i4;
        Object obj3;
        int i5;
        int i6;
        Object[] objArr;
        Object[] objArr2;
        int i7;
        int i8;
        int i9;
        nl2 nl2Var;
        int[] iArr;
        ArrayList arrayList2;
        int i10;
        int i11;
        int i12;
        nl2 nl2Var2;
        int i13;
        Object objP;
        rl2 rl2Var2;
        int i14;
        nv1 nv1Var3;
        Object obj4 = obj;
        if (this.r) {
            y20.a("A call to createNode(), emitNode() or useNode() expected");
        }
        int i15 = this.m;
        Object obj5 = r20.a;
        if (obj4 == null) {
            if (obj2 == null || i != 207 || obj2.equals(obj5)) {
                jRotateLeft = Long.rotateLeft(Long.rotateLeft(this.T, 3) ^ ((long) i), 3) ^ ((long) i15);
            } else {
                this.T = Long.rotateLeft(Long.rotateLeft(this.T, 3) ^ ((long) obj2.hashCode()), 3) ^ ((long) i15);
            }
            if (obj4 == null) {
                this.m++;
            }
            if (i2 != 0) {
                z = true;
            } else {
                z = false;
            }
            if (this.S) {
                this.G.k++;
                rl2Var2 = this.I;
                i14 = rl2Var2.t;
                if (z) {
                    rl2Var2.Q(i, obj5, obj5, true);
                } else if (obj2 != null) {
                    if (obj4 == null) {
                        obj4 = obj5;
                    }
                    rl2Var2.Q(i, obj4, obj2, false);
                } else {
                    if (obj4 == null) {
                        obj4 = obj5;
                    }
                    rl2Var2.Q(i, obj4, obj5, false);
                }
                nv1Var3 = this.j;
                if (nv1Var3 != null) {
                    int i16 = (-2) - i14;
                    i51 i51Var = new i51(-1, i, i16, -1);
                    nv1Var3.e.h(i16, new lv0(-1, this.k - nv1Var3.b, 0));
                    nv1Var3.d.add(i51Var);
                }
                u(z, null);
                return;
            }
            if (i2 != 1 && this.y) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.j == null) {
                int iG = this.G.g();
                if (!z2 && iG == i) {
                    nl2Var2 = this.G;
                    i13 = nl2Var2.g;
                    if (i13 < nl2Var2.h) {
                        objP = nl2Var2.p(i13, nl2Var2.b);
                    } else {
                        objP = null;
                    }
                    if (g31.a(obj4, objP)) {
                        V(obj2, z);
                        z3 = z2;
                    }
                }
                nl2Var = this.G;
                iArr = nl2Var.b;
                arrayList2 = new ArrayList();
                if (nl2Var.k <= 0) {
                    i10 = nl2Var.g;
                    while (i10 < nl2Var.h) {
                        int i17 = i10 * 5;
                        int i18 = iArr[i17];
                        Object objP2 = nl2Var.p(i10, iArr);
                        i11 = iArr[i17 + 1];
                        if ((i11 & 1073741824) != 0) {
                            i12 = 1;
                        } else {
                            i12 = i11 & 67108863;
                        }
                        arrayList2.add(new i51(objP2, i18, i10, i12));
                        i10 += iArr[i17 + 3];
                        z2 = z2;
                    }
                }
                z3 = z2;
                this.j = new nv1(this.k, arrayList2);
            } else {
                z3 = z2;
            }
            nv1Var = this.j;
            if (nv1Var != null) {
                arrayList = nv1Var.d;
                ml1Var = nv1Var.e;
                i3 = nv1Var.b;
                if (obj4 != null) {
                    objValueOf = new q41(Integer.valueOf(i), obj4);
                } else {
                    objValueOf = Integer.valueOf(i);
                }
                gm1Var = ((hl1) nv1Var.f.getValue()).a;
                objG = gm1Var.g(objValueOf);
                if (objG == null) {
                    objG = null;
                } else if (objG instanceof yl1) {
                    yl1Var = (yl1) objG;
                    Object objK = yl1Var.k(0);
                    if (yl1Var.h()) {
                        gm1Var.k(objValueOf);
                    }
                    if (yl1Var.b == 1) {
                        gm1Var.m(objValueOf, yl1Var.e());
                    }
                    objG = objK;
                } else {
                    gm1Var.k(objValueOf);
                }
                i51 i51Var2 = (i51) objG;
                if (!z3 || i51Var2 == null) {
                    this.G.k++;
                    this.S = true;
                    this.K = null;
                    if (this.I.w) {
                        rl2 rl2VarF = this.H.f();
                        this.I = rl2VarF;
                        rl2VarF.M();
                        this.J = false;
                        this.K = null;
                    }
                    this.I.d();
                    rl2Var = this.I;
                    int i19 = rl2Var.t;
                    if (z) {
                        rl2Var.Q(i, obj5, obj5, true);
                        i4 = 0;
                    } else if (obj2 != null) {
                        if (obj != null) {
                            obj5 = obj;
                        }
                        i4 = 0;
                        rl2Var.Q(i, obj5, obj2, false);
                    } else {
                        i4 = 0;
                        if (obj == null) {
                            obj3 = obj5;
                        } else {
                            obj3 = obj;
                        }
                        rl2Var.Q(i, obj3, obj5, false);
                    }
                    this.N = this.I.b(i19);
                    int i20 = (-2) - i19;
                    i51 i51Var3 = new i51(-1, i, i20, -1);
                    ml1Var.h(i20, new lv0(-1, this.k - i3, i4));
                    arrayList.add(i51Var3);
                    ArrayList arrayList3 = new ArrayList();
                    if (z) {
                        i5 = i4;
                    } else {
                        i5 = this.k;
                    }
                    nv1Var2 = new nv1(i5, arrayList3);
                } else {
                    int i21 = i51Var2.c;
                    arrayList.add(i51Var2);
                    lv0 lv0Var = (lv0) ml1Var.b(i21);
                    this.k = (lv0Var != null ? lv0Var.b : -1) + i3;
                    lv0 lv0Var2 = (lv0) ml1Var.b(i21);
                    int i22 = lv0Var2 != null ? lv0Var2.a : -1;
                    int i23 = nv1Var.c;
                    int i24 = i22 - i23;
                    int i25 = 8;
                    if (i22 <= i23) {
                        i6 = i24;
                        if (i23 > i22) {
                            Object[] objArr3 = ml1Var.c;
                            long[] jArr = ml1Var.a;
                            int length = jArr.length - 2;
                            if (length >= 0) {
                                int i26 = 0;
                                while (true) {
                                    long j = jArr[i26];
                                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i27 = 8 - ((~(i26 - length)) >>> 31);
                                        int i28 = 0;
                                        while (i28 < i27) {
                                            if ((j & 255) >= 128) {
                                                objArr2 = objArr3;
                                            } else {
                                                lv0 lv0Var3 = (lv0) objArr3[(i26 << 3) + i28];
                                                int i29 = lv0Var3.a;
                                                if (i29 == i22) {
                                                    lv0Var3.a = i23;
                                                    objArr2 = objArr3;
                                                } else {
                                                    objArr2 = objArr3;
                                                    if (i22 + 1 <= i29 && i29 < i23) {
                                                        lv0Var3.a = i29 - 1;
                                                    }
                                                }
                                            }
                                            j >>= 8;
                                            i28++;
                                            objArr3 = objArr2;
                                        }
                                        objArr = objArr3;
                                        if (i27 != 8) {
                                            break;
                                        }
                                    } else {
                                        objArr = objArr3;
                                    }
                                    if (i26 == length) {
                                        break;
                                    }
                                    i26++;
                                    objArr3 = objArr;
                                }
                            }
                        }
                    } else {
                        Object[] objArr4 = ml1Var.c;
                        long[] jArr2 = ml1Var.a;
                        int length2 = jArr2.length - 2;
                        if (length2 >= 0) {
                            int i30 = 0;
                            while (true) {
                                long j2 = jArr2[i30];
                                if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i31 = 8 - ((~(i30 - length2)) >>> 31);
                                    int i32 = 0;
                                    while (i32 < i31) {
                                        if ((j2 & 255) < 128) {
                                            i9 = i25;
                                            lv0 lv0Var4 = (lv0) objArr4[(i30 << 3) + i32];
                                            i8 = i24;
                                            int i33 = lv0Var4.a;
                                            if (i33 == i22) {
                                                lv0Var4.a = i23;
                                            } else if (i23 <= i33 && i33 < i22) {
                                                lv0Var4.a = i33 + 1;
                                            }
                                        } else {
                                            i8 = i24;
                                            i9 = i25;
                                        }
                                        j2 >>= i9;
                                        i32++;
                                        i24 = i8;
                                        i25 = i9;
                                    }
                                    i6 = i24;
                                    if (i31 != i25) {
                                        break;
                                    }
                                } else {
                                    i6 = i24;
                                }
                                if (i30 == length2) {
                                    break;
                                }
                                i30++;
                                i24 = i6;
                                i25 = 8;
                            }
                        } else {
                            i6 = i24;
                        }
                    }
                    s20 s20Var = this.M;
                    int i34 = s20Var.f;
                    x20 x20Var = s20Var.a;
                    s20Var.f = (i21 - x20Var.G.g) + i34;
                    this.G.r(i21);
                    if (i6 > 0) {
                        s20Var.d(false);
                        m21 m21Var = s20Var.d;
                        nl2 nl2Var3 = x20Var.G;
                        if (nl2Var3.c > 0 && m21Var.a(-2) != (i7 = nl2Var3.i)) {
                            if (!s20Var.c && s20Var.e) {
                                s20Var.d(false);
                                s20Var.b.a.e(gr1.c);
                                s20Var.c = true;
                            }
                            if (i7 > 0) {
                                j6 j6VarA = nl2Var3.a(i7);
                                m21Var.c(i7);
                                s20Var.d(false);
                                bs1 bs1Var = s20Var.b.a;
                                bs1Var.e(fr1.c);
                                yr4.a(bs1Var, 0, j6VarA);
                                s20Var.c = true;
                            }
                        }
                        bs1 bs1Var2 = s20Var.b.a;
                        bs1Var2.e(kr1.c);
                        bs1Var2.c[bs1Var2.d - bs1Var2.a[bs1Var2.b - 1].a] = i6;
                    }
                    V(obj2, z);
                    nv1Var2 = null;
                }
            } else {
                nv1Var2 = null;
            }
            u(z, nv1Var2);
        }
        jRotateLeft = Long.rotateLeft(Long.rotateLeft(this.T, 3) ^ ((long) (obj4 instanceof Enum ? ((Enum) obj4).ordinal() : obj4.hashCode())), 3);
        this.T = jRotateLeft;
        if (obj4 == null) {
            this.m++;
        }
        if (i2 != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.S) {
            this.G.k++;
            rl2Var2 = this.I;
            i14 = rl2Var2.t;
            if (z) {
                rl2Var2.Q(i, obj5, obj5, true);
            } else if (obj2 != null) {
                if (obj4 == null) {
                    obj4 = obj5;
                }
                rl2Var2.Q(i, obj4, obj2, false);
            } else {
                if (obj4 == null) {
                    obj4 = obj5;
                }
                rl2Var2.Q(i, obj4, obj5, false);
            }
            nv1Var3 = this.j;
            if (nv1Var3 != null) {
                int i110 = (-2) - i14;
                i51 i51Var4 = new i51(-1, i, i110, -1);
                nv1Var3.e.h(i110, new lv0(-1, this.k - nv1Var3.b, 0));
                nv1Var3.d.add(i51Var4);
            }
            u(z, null);
            return;
        }
        if (i2 != 1) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (this.j == null) {
            int iG2 = this.G.g();
            if (!z2) {
                nl2Var2 = this.G;
                i13 = nl2Var2.g;
                if (i13 < nl2Var2.h) {
                    objP = nl2Var2.p(i13, nl2Var2.b);
                } else {
                    objP = null;
                }
                if (g31.a(obj4, objP)) {
                    V(obj2, z);
                    z3 = z2;
                }
            }
            nl2Var = this.G;
            iArr = nl2Var.b;
            arrayList2 = new ArrayList();
            if (nl2Var.k <= 0) {
                i10 = nl2Var.g;
                while (i10 < nl2Var.h) {
                    int i111 = i10 * 5;
                    int i112 = iArr[i111];
                    Object objP3 = nl2Var.p(i10, iArr);
                    i11 = iArr[i111 + 1];
                    if ((i11 & 1073741824) != 0) {
                        i12 = 1;
                    } else {
                        i12 = i11 & 67108863;
                    }
                    arrayList2.add(new i51(objP3, i112, i10, i12));
                    i10 += iArr[i111 + 3];
                    z2 = z2;
                }
            }
            z3 = z2;
            this.j = new nv1(this.k, arrayList2);
        } else {
            z3 = z2;
        }
        nv1Var = this.j;
        if (nv1Var != null) {
            arrayList = nv1Var.d;
            ml1Var = nv1Var.e;
            i3 = nv1Var.b;
            if (obj4 != null) {
                objValueOf = new q41(Integer.valueOf(i), obj4);
            } else {
                objValueOf = Integer.valueOf(i);
            }
            gm1Var = ((hl1) nv1Var.f.getValue()).a;
            objG = gm1Var.g(objValueOf);
            if (objG == null) {
                objG = null;
            } else if (objG instanceof yl1) {
                yl1Var = (yl1) objG;
                Object objK2 = yl1Var.k(0);
                if (yl1Var.h()) {
                    gm1Var.k(objValueOf);
                }
                if (yl1Var.b == 1) {
                    gm1Var.m(objValueOf, yl1Var.e());
                }
                objG = objK2;
            } else {
                gm1Var.k(objValueOf);
            }
            i51 i51Var5 = (i51) objG;
            if (z3) {
            }
            this.G.k++;
            this.S = true;
            this.K = null;
            if (this.I.w) {
                rl2 rl2VarF2 = this.H.f();
                this.I = rl2VarF2;
                rl2VarF2.M();
                this.J = false;
                this.K = null;
            }
            this.I.d();
            rl2Var = this.I;
            int i113 = rl2Var.t;
            if (z) {
                rl2Var.Q(i, obj5, obj5, true);
                i4 = 0;
            } else if (obj2 != null) {
                if (obj != null) {
                    obj5 = obj;
                }
                i4 = 0;
                rl2Var.Q(i, obj5, obj2, false);
            } else {
                i4 = 0;
                if (obj == null) {
                    obj3 = obj5;
                } else {
                    obj3 = obj;
                }
                rl2Var.Q(i, obj3, obj5, false);
            }
            this.N = this.I.b(i113);
            int i210 = (-2) - i113;
            i51 i51Var6 = new i51(-1, i, i210, -1);
            ml1Var.h(i210, new lv0(-1, this.k - i3, i4));
            arrayList.add(i51Var6);
            ArrayList arrayList4 = new ArrayList();
            if (z) {
                i5 = i4;
            } else {
                i5 = this.k;
            }
            nv1Var2 = new nv1(i5, arrayList4);
        } else {
            nv1Var2 = null;
        }
        u(z, nv1Var2);
    }

    public final void T() {
        S(-127, 0, null, null);
    }

    public final void U(int i, pq1 pq1Var) {
        S(i, 0, pq1Var, null);
    }

    public final void V(Object obj, boolean z) {
        if (z) {
            nl2 nl2Var = this.G;
            if (nl2Var.k <= 0) {
                if ((nl2Var.b[(nl2Var.g * 5) + 1] & 1073741824) == 0) {
                    dz1.a("Expected a node group");
                }
                nl2Var.u();
                return;
            }
            return;
        }
        if (obj != null && this.G.f() != obj) {
            s20 s20Var = this.M;
            s20Var.getClass();
            s20Var.d(false);
            bs1 bs1Var = s20Var.b.a;
            bs1Var.e(vr1.c);
            yr4.a(bs1Var, 0, obj);
        }
        this.G.u();
    }

    public final void W(int i) {
        int i2;
        int i3;
        if (this.j != null) {
            S(i, 0, null, null);
            return;
        }
        if (this.r) {
            y20.a("A call to createNode(), emitNode() or useNode() expected");
        }
        this.T = Long.rotateLeft(Long.rotateLeft(this.T, 3) ^ ((long) i), 3) ^ ((long) this.m);
        this.m++;
        nl2 nl2Var = this.G;
        boolean z = this.S;
        xy xyVar = r20.a;
        if (z) {
            nl2Var.k++;
            this.I.Q(i, xyVar, xyVar, false);
            u(false, null);
            return;
        }
        if (nl2Var.g() == i && ((i3 = nl2Var.g) >= nl2Var.h || (nl2Var.b[(i3 * 5) + 1] & 536870912) == 0)) {
            nl2Var.u();
            u(false, null);
            return;
        }
        if (nl2Var.k <= 0 && (i2 = nl2Var.g) != nl2Var.h) {
            int i4 = this.k;
            I();
            this.M.e(i4, nl2Var.s());
            jy3.a(this.s, i2, nl2Var.g);
        }
        nl2Var.k++;
        this.S = true;
        this.K = null;
        if (this.I.w) {
            rl2 rl2VarF = this.H.f();
            this.I = rl2VarF;
            rl2VarF.M();
            this.J = false;
            this.K = null;
        }
        rl2 rl2Var = this.I;
        rl2Var.d();
        int i5 = rl2Var.t;
        rl2Var.Q(i, xyVar, xyVar, false);
        this.N = rl2Var.b(i5);
        u(false, null);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006e  */
    public final x20 X(int i) {
        a42 a42Var;
        boolean z;
        W(i);
        boolean z2 = this.S;
        q82 q82Var = this.g;
        ArrayList arrayList = this.E;
        g30 g30Var = this.h;
        if (z2) {
            a42 a42Var2 = new a42(g30Var);
            arrayList.add(a42Var2);
            h0(a42Var2);
            a42Var2.e = this.B;
            a42Var2.b &= -17;
            q82Var.w();
            return this;
        }
        int i2 = this.G.i;
        ArrayList arrayList2 = this.s;
        int iD = jy3.d(i2, arrayList2);
        r31 r31Var = iD >= 0 ? (r31) arrayList2.remove(iD) : null;
        Object objM = this.G.m();
        if (g31.a(objM, r20.a)) {
            a42Var = new a42(g30Var);
            h0(a42Var);
        } else {
            objM.getClass();
            a42Var = (a42) objM;
        }
        if (r31Var == null) {
            int i3 = a42Var.b;
            boolean z3 = (i3 & 64) != 0;
            if (z3) {
                a42Var.b = i3 & (-65);
            }
            if (z3) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = true;
        }
        int i4 = a42Var.b;
        a42Var.b = z ? i4 | 8 : i4 & (-9);
        arrayList.add(a42Var);
        a42Var.e = this.B;
        a42Var.b &= -17;
        q82Var.w();
        int i5 = a42Var.b;
        if ((i5 & 256) != 0) {
            a42Var.b = (i5 & (-257)) | 512;
            bs1 bs1Var = this.M.b.a;
            bs1Var.e(tr1.c);
            yr4.a(bs1Var, 0, a42Var);
            if (!this.y) {
                int i6 = a42Var.b;
                if ((i6 & 128) != 0) {
                    this.y = true;
                    a42Var.b = i6 | 1024;
                }
            }
        }
        return this;
    }

    public final void Y(Object obj) {
        if (!this.S && this.G.g() == 207 && !g31.a(this.G.f(), obj) && this.z < 0) {
            this.z = this.G.g;
            this.y = true;
        }
        S(207, 0, null, obj);
    }

    public final void Z() {
        S(125, 2, null, null);
        this.r = true;
    }

    public final void a() {
        i();
        this.i.clear();
        this.n.b = 0;
        this.t.b = 0;
        this.x.b = 0;
        this.v = null;
        bm0 bm0Var = this.O;
        bm0Var.b.a();
        bm0Var.a.a();
        this.T = 0L;
        this.A = 0;
        this.r = false;
        this.S = false;
        this.y = false;
        this.F = false;
        this.z = -1;
        nl2 nl2Var = this.G;
        if (!nl2Var.f) {
            nl2Var.c();
        }
        if (this.I.w) {
            return;
        }
        v();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a0() {
        this.m = 0;
        this.G = this.c.d();
        S(100, 0, null, null);
        a30 a30Var = this.b;
        a30Var.t();
        gw1 gw1VarI = a30Var.i();
        this.x.c(this.w ? 1 : 0);
        this.w = f(gw1VarI);
        this.K = null;
        if (!this.q) {
            this.q = a30Var.e();
        }
        if (!this.C) {
            this.C = a30Var.f();
        }
        if (this.C) {
            sr2 sr2Var = f30.a;
            sr2Var.getClass();
            gw1VarI = gw1VarI.b(sr2Var, new tr2(z()));
        }
        this.u = gw1VarI;
        Set set = (Set) mj4.a(gw1VarI, w11.a);
        if (set != null) {
            set.add(w());
            a30Var.o(set);
        }
        S(Long.hashCode(a30Var.g()), 0, null, null);
    }

    public final void b(vq0 vq0Var, Object obj) {
        if (this.S) {
            bs1 bs1Var = this.O.a;
            bs1Var.e(wr1.c);
            yr4.a(bs1Var, 0, obj);
            vq0Var.getClass();
            h33.c(2, vq0Var);
            yr4.a(bs1Var, 1, vq0Var);
            return;
        }
        s20 s20Var = this.M;
        s20Var.b();
        bs1 bs1Var2 = s20Var.b.a;
        bs1Var2.e(wr1.c);
        vq0Var.getClass();
        h33.c(2, vq0Var);
        yr4.b(bs1Var2, 0, obj, 1, vq0Var);
    }

    public final boolean b0(a42 a42Var, Object obj) {
        j6 j6Var = a42Var.c;
        if (j6Var == null) {
            return false;
        }
        int iA = this.G.a.a(j6Var);
        if (!this.F || iA < this.G.g) {
            return false;
        }
        ArrayList arrayList = this.s;
        int iD = jy3.d(iA, arrayList);
        if (iD < 0) {
            int i = -(iD + 1);
            if (!(obj instanceof qc0)) {
                obj = null;
            }
            arrayList.add(i, new r31(a42Var, iA, obj));
            return true;
        }
        r31 r31Var = (r31) arrayList.get(iD);
        if (!(obj instanceof qc0)) {
            r31Var.c = null;
            return true;
        }
        Object obj2 = r31Var.c;
        if (obj2 == null) {
            r31Var.c = obj;
            return true;
        }
        if (obj2 instanceof hm1) {
            ((hm1) obj2).a(obj);
            return true;
        }
        hm1 hm1Var = za2.a;
        hm1 hm1Var2 = new hm1(2);
        hm1Var2.k(obj2);
        hm1Var2.k(obj);
        r31Var.c = hm1Var2;
        return true;
    }

    public final boolean c(float f) {
        Object objD = D();
        if ((objD instanceof Float) && f == ((Number) objD).floatValue()) {
            return false;
        }
        h0(Float.valueOf(f));
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0081 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0083 A[LOOP:1: B:17:0x0037->B:32:0x0083, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:40:0x0086 A[EDGE_INSN: B:40:0x0086->B:33:0x0086 BREAK  A[LOOP:1: B:17:0x0037->B:32:0x0083], SYNTHETIC] */
    public final void c0(gm1 gm1Var) {
        ArrayList arrayList = this.s;
        for (int iG = nz.g(arrayList); -1 < iG; iG--) {
            r31 r31Var = (r31) arrayList.get(iG);
            j6 j6Var = r31Var.a.c;
            if (j6Var == null || !j6Var.a()) {
                arrayList.remove(iG);
            } else {
                int i = r31Var.b;
                int i2 = j6Var.a;
                if (i != i2) {
                    r31Var.b = i2;
                }
            }
        }
        Object[] objArr = gm1Var.b;
        Object[] objArr2 = gm1Var.c;
        long[] jArr = gm1Var.a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i3 = 0;
            while (true) {
                long j = jArr[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i3 != length) {
                        break;
                        break;
                    }
                    i3++;
                } else {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128) {
                            int i6 = (i3 << 3) + i5;
                            Object obj = objArr[i6];
                            Object obj2 = objArr2[i6];
                            obj.getClass();
                            a42 a42Var = (a42) obj;
                            j6 j6Var2 = a42Var.c;
                            if (j6Var2 != null) {
                                int i7 = j6Var2.a;
                                if (obj2 == fl4.k) {
                                    obj2 = null;
                                }
                                arrayList.add(new r31(a42Var, i7, obj2));
                            }
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        break;
                    } else if (i3 != length) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        qz.p(arrayList, jy3.a);
    }

    public final boolean d(int i) {
        Object objD = D();
        if ((objD instanceof Integer) && i == ((Number) objD).intValue()) {
            return false;
        }
        h0(Integer.valueOf(i));
        return true;
    }

    public final void d0(int i, int i2) {
        if (i0(i) != i2) {
            if (i < 0) {
                kl1 kl1Var = this.p;
                if (kl1Var == null) {
                    kl1Var = new kl1();
                    this.p = kl1Var;
                }
                kl1Var.f(i, i2);
                return;
            }
            int[] iArr = this.o;
            if (iArr == null) {
                int i3 = this.G.c;
                int[] iArr2 = new int[i3];
                Arrays.fill(iArr2, 0, i3, -1);
                this.o = iArr2;
                iArr = iArr2;
            }
            iArr[i] = i2;
        }
    }

    public final boolean e(long j) {
        Object objD = D();
        if ((objD instanceof Long) && j == ((Number) objD).longValue()) {
            return false;
        }
        h0(Long.valueOf(j));
        return true;
    }

    public final void e0(int i, int i2) {
        int iI0 = i0(i);
        if (iI0 != i2) {
            int i3 = i2 - iI0;
            ArrayList arrayList = this.i;
            int size = arrayList.size() - 1;
            while (i != -1) {
                int iI1 = i0(i) + i3;
                d0(i, iI1);
                for (int i4 = size; -1 < i4; i4--) {
                    nv1 nv1Var = (nv1) arrayList.get(i4);
                    if (nv1Var != null && nv1Var.a(i, iI1)) {
                        size = i4 - 1;
                        break;
                    }
                }
                nl2 nl2Var = this.G;
                if (i < 0) {
                    i = nl2Var.i;
                } else if (nl2Var.l(i)) {
                    return;
                } else {
                    i = this.G.q(i);
                }
            }
        }
    }

    public final boolean f(Object obj) {
        if (g31.a(D(), obj)) {
            return false;
        }
        h0(obj);
        return true;
    }

    public final gw1 f0(gw1 gw1Var, gw1 gw1Var2) {
        gw1Var.getClass();
        fw1 fw1Var = new fw1(gw1Var);
        fw1Var.putAll(gw1Var2);
        gw1 gw1VarA = fw1Var.a();
        U(204, y20.d);
        D();
        h0(gw1VarA);
        D();
        h0(gw1Var2);
        p(false);
        return gw1VarA;
    }

    public final boolean g(boolean z) {
        Object objD = D();
        if ((objD instanceof Boolean) && z == ((Boolean) objD).booleanValue()) {
            return false;
        }
        h0(Boolean.valueOf(z));
        return true;
    }

    public final void g0(Object obj) {
        if (obj instanceof j52) {
            k52 k52Var = new k52((j52) obj, this.m - 1);
            if (this.S) {
                bs1 bs1Var = this.M.b.a;
                bs1Var.e(mr1.c);
                yr4.a(bs1Var, 0, k52Var);
            }
            this.d.add(obj);
            obj = k52Var;
        }
        h0(obj);
    }

    public final boolean h(Object obj) {
        if (D() == obj) {
            return false;
        }
        h0(obj);
        return true;
    }

    public final void h0(Object obj) {
        if (this.S) {
            rl2 rl2Var = this.I;
            if (rl2Var.n <= 0 || rl2Var.i == rl2Var.k) {
                rl2Var.F(obj);
                return;
            }
            ml1 ml1Var = rl2Var.s;
            if (ml1Var == null) {
                ml1Var = new ml1();
            }
            rl2Var.s = ml1Var;
            int i = rl2Var.v;
            Object objB = ml1Var.b(i);
            if (objB == null) {
                objB = new yl1();
                ml1Var.h(i, objB);
            }
            ((yl1) objB).a(obj);
            return;
        }
        nl2 nl2Var = this.G;
        boolean z = nl2Var.n;
        s20 s20Var = this.M;
        if (!z) {
            j6 j6VarA = nl2Var.a(nl2Var.i);
            bs1 bs1Var = s20Var.b.a;
            bs1Var.e(uq1.c);
            yr4.b(bs1Var, 0, j6VarA, 1, obj);
            return;
        }
        int iB = (nl2Var.l - ql2.b(nl2Var.i, nl2Var.b)) - 1;
        if (s20Var.a.G.i - s20Var.f >= 0) {
            s20Var.d(true);
            bs1 bs1Var2 = s20Var.b.a;
            bs1Var2.e(hr1.g);
            yr4.a(bs1Var2, 0, obj);
            bs1Var2.c[bs1Var2.d - bs1Var2.a[bs1Var2.b - 1].a] = iB;
            return;
        }
        nl2 nl2Var2 = this.G;
        j6 j6VarA2 = nl2Var2.a(nl2Var2.i);
        bs1 bs1Var3 = s20Var.b.a;
        bs1Var3.e(hr1.f);
        yr4.b(bs1Var3, 0, obj, 1, j6VarA2);
        bs1Var3.c[bs1Var3.d - bs1Var3.a[bs1Var3.b - 1].a] = iB;
    }

    public final void i() {
        this.j = null;
        this.k = 0;
        this.l = 0;
        this.T = 0L;
        this.r = false;
        s20 s20Var = this.M;
        s20Var.c = false;
        s20Var.d.b = 0;
        s20Var.f = 0;
        s20Var.e = true;
        s20Var.g = 0;
        s20Var.h.clear();
        s20Var.i = -1;
        s20Var.j = -1;
        s20Var.k = -1;
        s20Var.l = 0;
        this.E.clear();
        this.o = null;
        this.p = null;
    }

    public final int i0(int i) {
        int i2;
        if (i >= 0) {
            int[] iArr = this.o;
            return (iArr == null || (i2 = iArr[i]) < 0) ? this.G.o(i) : i2;
        }
        kl1 kl1Var = this.p;
        if (kl1Var != null && kl1Var.c(i) >= 0) {
            int iC = kl1Var.c(i);
            if (iC >= 0) {
                return kl1Var.c[iC];
            }
            kf2.g(ky0.h(i, "Cannot find value for key "));
        }
        return 0;
    }

    public final Object j(z12 z12Var) {
        return mj4.a(l(), z12Var);
    }

    public final void j0() {
        if (!this.r) {
            y20.a("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.r = false;
        if (this.S) {
            y20.a("useNode() called while inserting");
        }
        nl2 nl2Var = this.G;
        Object objN = nl2Var.n(nl2Var.i);
        s20 s20Var = this.M;
        s20Var.c();
        s20Var.h.add(objN);
        if (this.y && (objN instanceof d20)) {
            s20Var.b();
            s20Var.b.a.e(yr1.c);
        }
    }

    public final void k(fq0 fq0Var) {
        if (!this.r) {
            y20.a("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.r = false;
        if (!this.S) {
            y20.a("createNode() can only be called when inserting");
        }
        m21 m21Var = this.n;
        int i = m21Var.a[m21Var.b - 1];
        rl2 rl2Var = this.I;
        j6 j6VarB = rl2Var.b(rl2Var.v);
        this.l++;
        bm0 bm0Var = this.O;
        bs1 bs1Var = bm0Var.a;
        bs1Var.e(hr1.d);
        yr4.a(bs1Var, 0, fq0Var);
        bs1Var.c[bs1Var.d - bs1Var.a[bs1Var.b - 1].a] = i;
        yr4.a(bs1Var, 1, j6VarB);
        bs1 bs1Var2 = bm0Var.b;
        bs1Var2.e(hr1.e);
        bs1Var2.c[bs1Var2.d - bs1Var2.a[bs1Var2.b - 1].a] = i;
        yr4.a(bs1Var2, 0, j6VarB);
    }

    public final gw1 l() {
        gw1 gw1Var;
        gw1 gw1Var2 = this.K;
        if (gw1Var2 != null) {
            return gw1Var2;
        }
        int iQ = this.G.i;
        boolean z = this.S;
        pq1 pq1Var = y20.c;
        if (z && this.J) {
            int iE = this.I.v;
            while (iE > 0) {
                if (this.I.s(iE) == 202 && g31.a(this.I.t(iE), pq1Var)) {
                    Object objQ = this.I.q(iE);
                    objQ.getClass();
                    gw1 gw1Var3 = (gw1) objQ;
                    this.K = gw1Var3;
                    return gw1Var3;
                }
                rl2 rl2Var = this.I;
                iE = rl2Var.E(iE, rl2Var.b);
            }
        }
        if (this.G.c > 0) {
            while (iQ > 0) {
                if (this.G.i(iQ) == 202) {
                    nl2 nl2Var = this.G;
                    if (g31.a(nl2Var.p(iQ, nl2Var.b), pq1Var)) {
                        ml1 ml1Var = this.v;
                        if (ml1Var == null || (gw1Var = (gw1) ml1Var.b(iQ)) == null) {
                            nl2 nl2Var2 = this.G;
                            Object objB = nl2Var2.b(iQ, nl2Var2.b);
                            objB.getClass();
                            gw1Var = (gw1) objB;
                        }
                        this.K = gw1Var;
                        return gw1Var;
                    }
                }
                iQ = this.G.q(iQ);
            }
        }
        gw1 gw1Var4 = this.u;
        this.K = gw1Var4;
        return gw1Var4;
    }

    public final l20 m() {
        Collection collection;
        if (!this.b.k()) {
            return null;
        }
        qc1 qc1VarE = nz.e();
        rl2 rl2Var = this.I;
        qc1VarE.addAll(cj4.a(rl2Var, null, rl2Var.t, null));
        nl2 nl2Var = this.G;
        boolean z = nl2Var.f;
        int[] iArr = nl2Var.b;
        if (z || nl2Var.c == 0) {
            collection = ii0.a;
        } else {
            y22 y22Var = new y22(nl2Var);
            int iQ = nl2Var.i;
            Object objValueOf = Integer.valueOf(nl2Var.l - ql2.b(iQ, iArr));
            while (iQ >= 0) {
                y22Var.e(nl2Var.i(iQ), nl2Var.k(iQ) ? nl2Var.p(iQ, iArr) : r20.a, nl2Var.a.h(iQ), objValueOf);
                objValueOf = nl2Var.a(iQ);
                iQ = nl2Var.q(iQ);
            }
            collection = (ArrayList) y22Var.a;
        }
        qc1VarE.addAll(collection);
        qc1VarE.addAll(E());
        return new l20(nz.c(qc1VarE));
    }

    public final void n(gm1 gm1Var, vq0 vq0Var) {
        ArrayList arrayList = this.s;
        if (this.F) {
            y20.a("Reentrant composition is not supported");
        }
        this.g.w();
        Trace.beginSection("Compose:recompose");
        try {
            this.B = Long.hashCode(im2.j().g());
            this.v = null;
            c0(gm1Var);
            this.k = 0;
            this.F = true;
            try {
                a0();
                Object objD = D();
                if (objD != vq0Var && vq0Var != null) {
                    h0(vq0Var);
                }
                w20 w20Var = this.D;
                pm1 pm1VarA = o44.a();
                try {
                    pm1VarA.b(w20Var);
                    pq1 pq1Var = y20.a;
                    if (vq0Var != null) {
                        U(200, pq1Var);
                        h33.c(2, vq0Var);
                        vq0Var.e(this, 1);
                        p(false);
                    } else if (!this.w || objD == null || objD.equals(r20.a)) {
                        P();
                    } else {
                        U(200, pq1Var);
                        h33.c(2, objD);
                        vq0 vq0Var2 = (vq0) objD;
                        h33.c(2, vq0Var2);
                        vq0Var2.e(this, 1);
                        p(false);
                    }
                    pm1VarA.l(pm1VarA.c - 1);
                    t();
                    this.F = false;
                    arrayList.clear();
                    if (!this.I.w) {
                        y20.a("Check failed");
                    }
                    v();
                    Trace.endSection();
                } catch (Throwable th) {
                    pm1VarA.l(pm1VarA.c - 1);
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    ej4.b(th2, new t20(this, 1));
                    throw th2;
                } catch (Throwable th3) {
                    this.F = false;
                    arrayList.clear();
                    a();
                    if (!this.I.w) {
                        y20.a("Check failed");
                    }
                    v();
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            Trace.endSection();
            throw th4;
        }
    }

    public final void o(int i, int i2) {
        if (i <= 0 || i == i2) {
            return;
        }
        o(this.G.q(i), i2);
        if (this.G.l(i)) {
            Object objN = this.G.n(i);
            s20 s20Var = this.M;
            s20Var.c();
            s20Var.h.add(objN);
        }
    }

    /* JADX WARN: Code duplicated, block: B:150:0x0398  */
    /* JADX WARN: Code duplicated, block: B:201:0x050b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v29, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v32 */
    public final void p(boolean z) {
        long jRotateRight;
        m21 m21Var;
        ArrayList arrayList;
        int i;
        Object r3;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        m21 m21Var2;
        int i7;
        LinkedHashSet linkedHashSet;
        int i8;
        int i9;
        ArrayList arrayList2;
        ArrayList arrayList3;
        HashSet hashSet;
        int i10;
        int i11;
        Object[] objArr;
        long[] jArr;
        int i12;
        Object[] objArr2;
        long[] jArr2;
        int i13;
        Object[] objArr3;
        long[] jArr3;
        int i14;
        Object[] objArr4;
        long[] jArr4;
        long jRotateRight2;
        m21 m21Var3 = this.n;
        int i15 = m21Var3.a[m21Var3.b - 2] - 1;
        boolean z2 = this.S;
        xy xyVar = r20.a;
        if (z2) {
            rl2 rl2Var = this.I;
            int i16 = rl2Var.v;
            int iS = rl2Var.s(i16);
            Object objT = this.I.t(i16);
            Object objQ = this.I.q(i16);
            if (objT != null) {
                jRotateRight2 = Long.rotateRight(this.T, 3) ^ ((long) (objT instanceof Enum ? ((Enum) objT).ordinal() : objT.hashCode()));
            } else if (objQ == null || iS != 207 || objQ.equals(xyVar)) {
                jRotateRight2 = Long.rotateRight(this.T ^ ((long) i15), 3) ^ ((long) iS);
            } else {
                this.T = Long.rotateRight(Long.rotateRight(this.T ^ ((long) i15), 3) ^ ((long) objQ.hashCode()), 3);
            }
            this.T = Long.rotateRight(jRotateRight2, 3);
        } else {
            nl2 nl2Var = this.G;
            int i17 = nl2Var.i;
            int i18 = nl2Var.i(i17);
            nl2 nl2Var2 = this.G;
            Object objP = nl2Var2.p(i17, nl2Var2.b);
            nl2 nl2Var3 = this.G;
            Object objB = nl2Var3.b(i17, nl2Var3.b);
            if (objP != null) {
                jRotateRight = Long.rotateRight(this.T, 3) ^ ((long) (objP instanceof Enum ? ((Enum) objP).ordinal() : objP.hashCode()));
            } else if (objB == null || i18 != 207 || objB.equals(xyVar)) {
                jRotateRight = Long.rotateRight(this.T ^ ((long) i15), 3) ^ ((long) i18);
            } else {
                this.T = Long.rotateRight(Long.rotateRight(this.T ^ ((long) i15), 3) ^ ((long) objB.hashCode()), 3);
            }
            this.T = Long.rotateRight(jRotateRight, 3);
        }
        int i19 = this.l;
        nv1 nv1Var = this.j;
        ArrayList arrayList4 = this.s;
        s20 s20Var = this.M;
        if (nv1Var != null) {
            ml1 ml1Var = nv1Var.e;
            int i20 = nv1Var.b;
            ArrayList arrayList5 = nv1Var.a;
            if (arrayList5.size() > 0) {
                ArrayList arrayList6 = nv1Var.d;
                HashSet hashSet2 = new HashSet(arrayList6.size());
                int size = arrayList6.size();
                for (int i21 = 0; i21 < size; i21++) {
                    hashSet2.add(arrayList6.get(i21));
                }
                i = -1;
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                int size2 = arrayList6.size();
                int size3 = arrayList5.size();
                int i22 = 0;
                int i23 = 0;
                int i24 = 0;
                while (i22 < size3) {
                    i51 i51Var = (i51) arrayList5.get(i22);
                    if (hashSet2.contains(i51Var)) {
                        m21Var2 = m21Var3;
                        i7 = i22;
                        if (!linkedHashSet2.contains(i51Var)) {
                            int i25 = i23;
                            if (i25 < size2) {
                                i51 i51Var2 = (i51) arrayList6.get(i25);
                                if (i51Var2 != i51Var) {
                                    lv0 lv0Var = (lv0) ml1Var.b(i51Var2.c);
                                    int i26 = lv0Var != null ? lv0Var.b : -1;
                                    linkedHashSet2.add(i51Var2);
                                    i10 = i24;
                                    if (i26 != i10) {
                                        lv0 lv0Var2 = (lv0) ml1Var.b(i51Var2.c);
                                        int i27 = lv0Var2 != null ? lv0Var2.c : i51Var2.d;
                                        linkedHashSet = linkedHashSet2;
                                        int i28 = i26 + i20;
                                        i8 = size2;
                                        int i29 = i10 + i20;
                                        if (i27 > 0) {
                                            i9 = i20;
                                            int i30 = s20Var.l;
                                            if (i30 > 0) {
                                                arrayList2 = arrayList5;
                                                if (s20Var.j == i28 - i30 && s20Var.k == i29 - i30) {
                                                    s20Var.l = i30 + i27;
                                                }
                                            } else {
                                                arrayList2 = arrayList5;
                                            }
                                            s20Var.c();
                                            s20Var.j = i28;
                                            s20Var.k = i29;
                                            s20Var.l = i27;
                                        } else {
                                            i9 = i20;
                                            arrayList2 = arrayList5;
                                            s20Var.getClass();
                                        }
                                        if (i26 <= i10) {
                                            int i31 = i27;
                                            arrayList4 = arrayList4;
                                            arrayList3 = arrayList6;
                                            hashSet = hashSet2;
                                            if (i10 > i26) {
                                                Object[] objArr5 = ml1Var.c;
                                                long[] jArr5 = ml1Var.a;
                                                int length = jArr5.length - 2;
                                                if (length >= 0) {
                                                    int i32 = 0;
                                                    while (true) {
                                                        long j = jArr5[i32];
                                                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                                            int i33 = 8 - ((~(i32 - length)) >>> 31);
                                                            int i34 = 0;
                                                            while (i34 < i33) {
                                                                if ((j & 255) < 128) {
                                                                    objArr2 = objArr5;
                                                                    lv0 lv0Var3 = (lv0) objArr5[(i32 << 3) + i34];
                                                                    jArr2 = jArr5;
                                                                    int i35 = lv0Var3.b;
                                                                    i13 = i26;
                                                                    if (i26 <= i35 && i35 < i13 + i31) {
                                                                        lv0Var3.b = (i35 - i13) + i10;
                                                                    } else if (i13 + 1 <= i35 && i35 < i10) {
                                                                        lv0Var3.b = i35 - i31;
                                                                    }
                                                                } else {
                                                                    objArr2 = objArr5;
                                                                    jArr2 = jArr5;
                                                                    i13 = i26;
                                                                }
                                                                j >>= 8;
                                                                i34++;
                                                                jArr5 = jArr2;
                                                                objArr5 = objArr2;
                                                                i26 = i13;
                                                            }
                                                            objArr = objArr5;
                                                            jArr = jArr5;
                                                            i12 = i26;
                                                            if (i33 != 8) {
                                                                break;
                                                            }
                                                        } else {
                                                            objArr = objArr5;
                                                            jArr = jArr5;
                                                            i12 = i26;
                                                        }
                                                        if (i32 == length) {
                                                            break;
                                                        }
                                                        i32++;
                                                        jArr5 = jArr;
                                                        objArr5 = objArr;
                                                        i26 = i12;
                                                    }
                                                }
                                            }
                                        } else {
                                            Object[] objArr6 = ml1Var.c;
                                            long[] jArr6 = ml1Var.a;
                                            int length2 = jArr6.length - 2;
                                            if (length2 >= 0) {
                                                arrayList3 = arrayList6;
                                                hashSet = hashSet2;
                                                int i36 = 0;
                                                while (true) {
                                                    long j2 = jArr6[i36];
                                                    int i37 = i27;
                                                    arrayList4 = arrayList4;
                                                    if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i38 = 8 - ((~(i36 - length2)) >>> 31);
                                                        int i39 = 0;
                                                        while (i39 < i38) {
                                                            if ((j2 & 255) < 128) {
                                                                i14 = i39;
                                                                lv0 lv0Var4 = (lv0) objArr6[(i36 << 3) + i39];
                                                                objArr4 = objArr6;
                                                                int i40 = lv0Var4.b;
                                                                jArr4 = jArr6;
                                                                if (i26 <= i40 && i40 < i26 + i37) {
                                                                    lv0Var4.b = (i40 - i26) + i10;
                                                                } else if (i10 <= i40 && i40 < i26) {
                                                                    lv0Var4.b = i40 + i37;
                                                                }
                                                            } else {
                                                                i14 = i39;
                                                                objArr4 = objArr6;
                                                                jArr4 = jArr6;
                                                            }
                                                            j2 >>= 8;
                                                            i39 = i14 + 1;
                                                            objArr6 = objArr4;
                                                            jArr6 = jArr4;
                                                        }
                                                        objArr3 = objArr6;
                                                        jArr3 = jArr6;
                                                        if (i38 != 8) {
                                                            break;
                                                        }
                                                    } else {
                                                        objArr3 = objArr6;
                                                        jArr3 = jArr6;
                                                    }
                                                    if (i36 == length2) {
                                                        break;
                                                    }
                                                    i36++;
                                                    arrayList4 = arrayList4;
                                                    i27 = i37;
                                                    objArr6 = objArr3;
                                                    jArr6 = jArr3;
                                                }
                                            }
                                        }
                                        i11 = i7;
                                    } else {
                                        linkedHashSet = linkedHashSet2;
                                        i8 = size2;
                                        i9 = i20;
                                        arrayList2 = arrayList5;
                                    }
                                    arrayList3 = arrayList6;
                                    hashSet = hashSet2;
                                    i11 = i7;
                                } else {
                                    arrayList4 = arrayList4;
                                    linkedHashSet = linkedHashSet2;
                                    i8 = size2;
                                    i9 = i20;
                                    arrayList2 = arrayList5;
                                    arrayList3 = arrayList6;
                                    hashSet = hashSet2;
                                    i10 = i24;
                                    i11 = i7 + 1;
                                }
                                i23 = i25 + 1;
                                lv0 lv0Var5 = (lv0) ml1Var.b(i51Var2.c);
                                int i41 = i10 + (lv0Var5 != null ? lv0Var5.c : i51Var2.d);
                                i22 = i11;
                                nv1Var = nv1Var;
                                linkedHashSet2 = linkedHashSet;
                                size2 = i8;
                                i20 = i9;
                                arrayList5 = arrayList2;
                                arrayList6 = arrayList3;
                                hashSet2 = hashSet;
                                arrayList4 = arrayList4;
                                i24 = i41;
                                m21Var3 = m21Var2;
                            } else {
                                i23 = i25;
                                m21Var3 = m21Var2;
                                i22 = i7;
                            }
                        }
                    } else {
                        m21Var2 = m21Var3;
                        lv0 lv0Var6 = (lv0) ml1Var.b(i51Var.c);
                        int i42 = lv0Var6 != null ? lv0Var6.b : -1;
                        int i43 = i51Var.c;
                        i7 = i22;
                        s20Var.e(i42 + i20, i51Var.d);
                        nv1Var.a(i43, 0);
                        s20Var.f = (i43 - s20Var.a.G.g) + s20Var.f;
                        this.G.r(i43);
                        I();
                        this.G.s();
                        jy3.a(arrayList4, i43, this.G.b[(i43 * 5) + 3] + i43);
                    }
                    i22 = i7 + 1;
                    m21Var3 = m21Var2;
                }
                m21Var = m21Var3;
                arrayList = arrayList4;
                s20Var.c();
                if (arrayList5.size() > 0) {
                    nl2 nl2Var4 = this.G;
                    s20Var.f = (nl2Var4.h - s20Var.a.G.g) + s20Var.f;
                    nl2Var4.t();
                }
            } else {
                m21Var = m21Var3;
                arrayList = arrayList4;
                i = -1;
            }
        } else {
            m21Var = m21Var3;
            arrayList = arrayList4;
            i = -1;
        }
        boolean z3 = this.S;
        if (!z3) {
            nl2 nl2Var5 = this.G;
            int i44 = nl2Var5.m - nl2Var5.l;
            if (i44 > 0) {
                if (i44 > 0) {
                    s20Var.d(false);
                    m21 m21Var4 = s20Var.d;
                    nl2 nl2Var6 = s20Var.a.G;
                    if (nl2Var6.c > 0 && m21Var4.a(-2) != (i6 = nl2Var6.i)) {
                        if (!s20Var.c && s20Var.e) {
                            s20Var.d(false);
                            s20Var.b.a.e(gr1.c);
                            s20Var.c = true;
                        }
                        if (i6 > 0) {
                            j6 j6VarA = nl2Var6.a(i6);
                            m21Var4.c(i6);
                            s20Var.d(false);
                            bs1 bs1Var = s20Var.b.a;
                            bs1Var.e(fr1.c);
                            yr4.a(bs1Var, 0, j6VarA);
                            s20Var.c = true;
                        }
                    }
                    bs1 bs1Var2 = s20Var.b.a;
                    bs1Var2.e(ur1.c);
                    bs1Var2.c[bs1Var2.d - bs1Var2.a[bs1Var2.b - 1].a] = i44;
                } else {
                    s20Var.getClass();
                }
            }
        }
        int i45 = this.k;
        while (true) {
            nl2 nl2Var7 = this.G;
            if (nl2Var7.k > 0 || (i5 = nl2Var7.g) == nl2Var7.h) {
                break;
            }
            I();
            s20Var.e(i45, this.G.s());
            jy3.a(arrayList, i5, this.G.g);
        }
        if (z3) {
            if (z) {
                bm0 bm0Var = this.O;
                bs1 bs1Var3 = bm0Var.b;
                if (!bs1Var3.d()) {
                    y20.a("Cannot end node insertion, there are no pending operations that can be realized.");
                }
                bs1 bs1Var4 = bm0Var.a;
                zr1[] zr1VarArr = bs1Var3.a;
                int i46 = bs1Var3.b - 1;
                bs1Var3.b = i46;
                zr1 zr1Var = zr1VarArr[i46];
                zr1VarArr[i46] = null;
                bs1Var4.e(zr1Var);
                Object[] objArr7 = bs1Var3.e;
                Object[] objArr8 = bs1Var4.e;
                int i47 = bs1Var4.f;
                int i48 = zr1Var.b;
                int i49 = bs1Var3.f;
                int i50 = i49 - i48;
                System.arraycopy(objArr7, i50, objArr8, i47 - i48, i49 - i50);
                Object[] objArr9 = bs1Var3.e;
                int i51 = bs1Var3.f;
                Arrays.fill(objArr9, i51 - i48, i51, (Object) null);
                int[] iArr = bs1Var3.c;
                int[] iArr2 = bs1Var4.c;
                int i52 = bs1Var4.d;
                int i53 = zr1Var.a;
                int i54 = bs1Var3.d;
                qg.e(iArr, i52 - i53, iArr2, i54 - i53, i54);
                bs1Var3.f -= i48;
                bs1Var3.d -= i53;
                i19 = 1;
            }
            nl2 nl2Var8 = this.G;
            if (nl2Var8.k <= 0) {
                dz1.a("Unbalanced begin/end empty");
            }
            nl2Var8.k--;
            rl2 rl2Var2 = this.I;
            int i55 = rl2Var2.v;
            rl2Var2.j();
            if (this.G.k <= 0) {
                int i56 = (-2) - i55;
                this.I.k();
                this.I.e(true);
                j6 j6Var = this.N;
                boolean zC = this.O.a.c();
                ol2 ol2Var = this.H;
                if (zC) {
                    s20Var.b();
                    s20Var.d(false);
                    m21 m21Var5 = s20Var.d;
                    nl2 nl2Var9 = s20Var.a.G;
                    if (nl2Var9.c <= 0 || m21Var5.a(-2) == (i4 = nl2Var9.i)) {
                        i3 = 1;
                    } else {
                        if (!s20Var.c && s20Var.e) {
                            s20Var.d(false);
                            s20Var.b.a.e(gr1.c);
                            s20Var.c = true;
                        }
                        if (i4 > 0) {
                            j6 j6VarA2 = nl2Var9.a(i4);
                            m21Var5.c(i4);
                            s20Var.d(false);
                            bs1 bs1Var5 = s20Var.b.a;
                            bs1Var5.e(fr1.c);
                            yr4.a(bs1Var5, 0, j6VarA2);
                            i3 = 1;
                            s20Var.c = true;
                        } else {
                            i3 = 1;
                        }
                    }
                    s20Var.c();
                    bs1 bs1Var6 = s20Var.b.a;
                    bs1Var6.e(ir1.c);
                    yr4.b(bs1Var6, 0, j6Var, i3, ol2Var);
                    r3 = 0;
                } else {
                    bm0 bm0Var2 = this.O;
                    s20Var.b();
                    s20Var.d(false);
                    m21 m21Var6 = s20Var.d;
                    nl2 nl2Var10 = s20Var.a.G;
                    if (nl2Var10.c > 0 && m21Var6.a(-2) != (i2 = nl2Var10.i)) {
                        if (!s20Var.c && s20Var.e) {
                            s20Var.d(false);
                            s20Var.b.a.e(gr1.c);
                            s20Var.c = true;
                        }
                        if (i2 > 0) {
                            j6 j6VarA3 = nl2Var10.a(i2);
                            m21Var6.c(i2);
                            s20Var.d(false);
                            bs1 bs1Var7 = s20Var.b.a;
                            bs1Var7.e(fr1.c);
                            yr4.a(bs1Var7, 0, j6VarA3);
                            s20Var.c = true;
                        }
                    }
                    s20Var.c();
                    bs1 bs1Var8 = s20Var.b.a;
                    bs1Var8.e(jr1.c);
                    int i57 = bs1Var8.f - bs1Var8.a[bs1Var8.b - 1].b;
                    Object[] objArr10 = bs1Var8.e;
                    objArr10[i57] = j6Var;
                    objArr10[i57 + 1] = ol2Var;
                    objArr10[i57 + 2] = bm0Var2;
                    this.O = new bm0();
                    r3 = 0;
                }
                this.S = r3;
                if (this.c.b != 0) {
                    d0(i56, r3);
                    e0(i56, i19);
                }
            }
        } else {
            if (z) {
                s20Var.a();
            }
            int i58 = s20Var.a.G.i;
            m21 m21Var7 = s20Var.d;
            int i59 = i;
            if (m21Var7.a(i59) > i58) {
                y20.a("Missed recording an endGroup");
            }
            if (m21Var7.a(i59) == i58) {
                s20Var.d(false);
                m21Var7.b();
                s20Var.b.a.e(cr1.c);
            }
            int i60 = this.G.i;
            if (i19 != i0(i60)) {
                e0(i60, i19);
            }
            if (z) {
                i19 = 1;
            }
            this.G.e();
            s20Var.c();
        }
        ArrayList arrayList7 = this.i;
        nv1 nv1Var2 = (nv1) arrayList7.remove(arrayList7.size() - 1);
        if (nv1Var2 != null && !z3) {
            nv1Var2.c++;
        }
        this.j = nv1Var2;
        this.k = m21Var.b() + i19;
        this.m = m21Var.b();
        this.l = m21Var.b() + i19;
    }

    public final void q() {
        p(false);
        a42 a42VarX = x();
        if (a42VarX != null) {
            int i = a42VarX.b;
            if ((i & 1) != 0) {
                a42VarX.b = i | 2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0081 A[LOOP:0: B:16:0x003f->B:28:0x0081, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x0085 A[EDGE_INSN: B:29:0x0085->B:30:0x0086 BREAK  A[LOOP:0: B:16:0x003f->B:28:0x0081]] */
    /* JADX WARN: Code duplicated, block: B:55:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:60:0x0085 A[SYNTHETIC] */
    public final a42 r() {
        a42 a42Var;
        j6 j6VarA;
        z32 z32Var;
        ArrayList arrayList = this.E;
        a42 a42Var2 = !arrayList.isEmpty() ? (a42) arrayList.remove(arrayList.size() - 1) : null;
        int i = 0;
        if (a42Var2 != null) {
            a42Var2.b &= -9;
            this.g.w();
            int i2 = this.B;
            ul1 ul1Var = a42Var2.f;
            if (ul1Var == null || (a42Var2.b & 16) != 0) {
                z32Var = null;
                break;
            }
            Object[] objArr = ul1Var.b;
            int[] iArr = ul1Var.c;
            long[] jArr = ul1Var.a;
            int length = jArr.length - 2;
            if (length < 0) {
                z32Var = null;
                break;
            }
            int i3 = 0;
            loop0: while (true) {
                long j = jArr[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((j & 255) < 128) {
                            int i6 = (i3 << 3) + i5;
                            Object obj = objArr[i6];
                            if (iArr[i6] != i2) {
                                z32Var = new z32(i2, i, a42Var2, ul1Var);
                                break loop0;
                            }
                        }
                        j >>= 8;
                    }
                    if (i4 == 8) {
                        if (i3 == length) {
                            i3++;
                        }
                    }
                    z32Var = null;
                    break;
                }
                if (i3 == length) {
                    z32Var = null;
                    break;
                }
                i3++;
            }
            s20 s20Var = this.M;
            if (z32Var != null) {
                bs1 bs1Var = s20Var.b.a;
                bs1Var.e(br1.c);
                yr4.b(bs1Var, 0, z32Var, 1, this.h);
            }
            int i7 = a42Var2.b;
            if ((i7 & 512) != 0) {
                a42Var2.b = i7 & (-513);
                bs1 bs1Var2 = s20Var.b.a;
                bs1Var2.e(er1.c);
                yr4.a(bs1Var2, 0, a42Var2);
                int i8 = a42Var2.b;
                a42Var2.b = i8 & (-129);
                if ((i8 & 1024) != 0) {
                    a42Var2.b = i8 & (-1153);
                    this.y = false;
                }
            }
        }
        if (a42Var2 != null) {
            int i9 = a42Var2.b;
            if ((i9 & 16) == 0 && ((i9 & 1) != 0 || this.q)) {
                if (a42Var2.c == null) {
                    if (this.S) {
                        rl2 rl2Var = this.I;
                        j6VarA = rl2Var.b(rl2Var.v);
                    } else {
                        nl2 nl2Var = this.G;
                        j6VarA = nl2Var.a(nl2Var.i);
                    }
                    a42Var2.c = j6VarA;
                }
                a42Var2.b &= -5;
                a42Var = a42Var2;
            } else {
                a42Var = null;
            }
        } else {
            a42Var = null;
        }
        p(false);
        return a42Var;
    }

    public final void s() {
        if (this.F || this.z != 100) {
            dz1.a("Cannot disable reuse from root if it was caused by other groups");
        }
        this.z = -1;
        this.y = false;
    }

    public final void t() {
        p(false);
        this.b.c();
        p(false);
        s20 s20Var = this.M;
        if (s20Var.c) {
            s20Var.d(false);
            s20Var.d(false);
            s20Var.b.a.e(cr1.c);
            s20Var.c = false;
        }
        s20Var.b();
        if (s20Var.d.b != 0) {
            y20.a("Missed recording an endGroup()");
        }
        if (!this.i.isEmpty()) {
            y20.a("Start/end imbalance");
        }
        i();
        this.G.c();
        this.w = this.x.b() != 0;
    }

    public final void u(boolean z, nv1 nv1Var) {
        this.i.add(this.j);
        this.j = nv1Var;
        int i = this.l;
        m21 m21Var = this.n;
        m21Var.c(i);
        m21Var.c(this.m);
        m21Var.c(this.k);
        if (z) {
            this.k = 0;
        }
        this.l = 0;
        this.m = 0;
    }

    public final void v() {
        ol2 ol2Var = new ol2();
        if (this.C) {
            ol2Var.b();
        }
        if (this.b.d()) {
            ol2Var.t = new ml1();
        }
        this.H = ol2Var;
        rl2 rl2VarF = ol2Var.f();
        rl2VarF.e(true);
        this.I = rl2VarF;
    }

    public final c30 w() {
        d30 d30Var = this.U;
        if (d30Var != null) {
            return d30Var;
        }
        d30 d30Var2 = new d30(this.h);
        this.U = d30Var2;
        return d30Var2;
    }

    public final a42 x() {
        if (this.A != 0) {
            return null;
        }
        ArrayList arrayList = this.E;
        if (arrayList.isEmpty()) {
            return null;
        }
        return (a42) arrayList.get(arrayList.size() - 1);
    }

    public final boolean y() {
        if (!A() || this.w) {
            return true;
        }
        a42 a42VarX = x();
        return (a42VarX == null || (a42VarX.b & 4) == 0) ? false : true;
    }

    public final e30 z() {
        if (this.b.k()) {
            return this.Q;
        }
        return null;
    }
}
