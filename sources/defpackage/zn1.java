package defpackage;

import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zn1 {
    public final n71 a;
    public final yn1 b;
    public final f11 c;
    public co1 d;
    public final jv2 e;
    public dk1 f;
    public pm1 g;
    public pm1 h;
    public final pm1 i;
    public nm1 j;

    public zn1(n71 n71Var) {
        this.a = n71Var;
        yn1 yn1Var = new yn1();
        yn1Var.e = -1;
        this.b = yn1Var;
        f11 f11Var = new f11(n71Var);
        this.c = f11Var;
        this.d = f11Var;
        jv2 jv2Var = f11Var.A0;
        this.e = jv2Var;
        this.f = jv2Var;
        this.i = new pm1(new ek1[16]);
    }

    public static final void a(zn1 zn1Var, dk1 dk1Var, co1 co1Var) {
        for (dk1 dk1Var2 = dk1Var.f; dk1Var2 != null; dk1Var2 = dk1Var2.f) {
            if (dk1Var2 == zn1Var.b) {
                n71 n71VarU = zn1Var.a.u();
                co1Var.X = n71VarU != null ? n71VarU.o0.c : null;
                zn1Var.d = co1Var;
                return;
            } else {
                if ((dk1Var2.c & 2) != 0) {
                    return;
                }
                dk1Var2.H0(co1Var);
            }
        }
    }

    public static dk1 b(ck1 ck1Var, dk1 dk1Var) {
        dk1 dk1VarE;
        if (ck1Var instanceof ik1) {
            dk1VarE = ((ik1) ck1Var).e();
            dk1VarE.c = do1.f(dk1VarE);
        } else {
            ok okVar = new ok();
            okVar.c = do1.d(ck1Var);
            okVar.x = ck1Var;
            new HashSet();
            dk1VarE = okVar;
        }
        if (dk1VarE.w) {
            z01.b("A ModifierNodeElement cannot return an already attached node from create() ");
        }
        dk1VarE.n = true;
        dk1 dk1Var2 = dk1Var.i;
        if (dk1Var2 != null) {
            dk1Var2.f = dk1VarE;
            dk1VarE.i = dk1Var2;
        }
        dk1Var.i = dk1VarE;
        dk1VarE.f = dk1Var;
        return dk1VarE;
    }

    public static dk1 c(dk1 dk1Var) {
        boolean z = dk1Var.w;
        if (z) {
            ul1 ul1Var = do1.a;
            if (!z) {
                z01.b("autoInvalidateRemovedNode called on unattached node");
            }
            do1.a(dk1Var, -1, 2);
            dk1Var.F0();
            dk1Var.z0();
        }
        dk1 dk1Var2 = dk1Var.i;
        dk1 dk1Var3 = dk1Var.f;
        if (dk1Var2 != null) {
            dk1Var2.f = dk1Var3;
            dk1Var.i = null;
        }
        if (dk1Var3 != null) {
            dk1Var3.i = dk1Var2;
            dk1Var.f = null;
        }
        dk1Var3.getClass();
        return dk1Var3;
    }

    public static void h(ck1 ck1Var, ck1 ck1Var2, dk1 dk1Var) {
        if ((ck1Var instanceof ik1) && (ck1Var2 instanceof ik1)) {
            dk1Var.getClass();
            ((ik1) ck1Var2).f(dk1Var);
            if (dk1Var.w) {
                do1.c(dk1Var);
                return;
            } else {
                dk1Var.s = true;
                return;
            }
        }
        if (!(dk1Var instanceof ok)) {
            z01.b("Unknown Modifier.Node type");
            return;
        }
        ok okVar = (ok) dk1Var;
        boolean z = okVar.w;
        if (z) {
            if (!z) {
                z01.b("unInitializeModifier called on unattached node");
            }
            if ((okVar.c & 8) != 0) {
                ((r7) cm4.h(okVar)).w();
            }
        }
        okVar.x = ck1Var2;
        okVar.c = do1.d(ck1Var2);
        if (okVar.w) {
            okVar.I0(false);
        }
        if (dk1Var.w) {
            do1.c(dk1Var);
        } else {
            dk1Var.s = true;
        }
    }

    public final boolean d(int i) {
        return (this.f.e & i) != 0;
    }

    public final void e() {
        for (dk1 dk1Var = this.f; dk1Var != null; dk1Var = dk1Var.i) {
            dk1Var.E0();
            if (dk1Var.n) {
                ul1 ul1Var = do1.a;
                if (!dk1Var.w) {
                    z01.b("autoInvalidateInsertedNode called on unattached node");
                }
                do1.a(dk1Var, -1, 1);
            }
            if (dk1Var.s) {
                do1.c(dk1Var);
            }
            dk1Var.n = false;
            dk1Var.s = false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:174:0x0142 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:34:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:36:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:37:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:40:0x010b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:46:0x011e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0128  */
    /* JADX WARN: Code duplicated, block: B:53:0x0140  */
    /* JADX WARN: Code duplicated, block: B:72:0x018a  */
    /* JADX WARN: Code duplicated, block: B:73:0x018d  */
    /* JADX WARN: Code duplicated, block: B:75:0x0191  */
    /* JADX WARN: Code duplicated, block: B:76:0x0194  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:78:0x01a0
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
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final void f(int r32, defpackage.pm1 r33, defpackage.pm1 r34, defpackage.dk1 r35, boolean r36) {
        /*
            Method dump skipped, instruction units count: 953
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zn1.f(int, pm1, pm1, dk1, boolean):void");
    }

    public final void g() {
        n71 n71Var;
        h71 h71Var;
        ht1 ht1Var;
        dk1 dk1Var = this.e.f;
        co1 co1Var = this.c;
        while (true) {
            n71Var = this.a;
            if (dk1Var == null) {
                break;
            }
            f71 f71VarC = cm4.c(dk1Var);
            if (f71VarC != null) {
                co1 co1Var2 = dk1Var.k;
                if (co1Var2 != null) {
                    h71Var = (h71) co1Var2;
                    f71 f71Var = h71Var.A0;
                    h71Var.w1(f71VarC);
                    if (f71Var != dk1Var && (ht1Var = h71Var.u0) != null) {
                        ((yu0) ht1Var).c();
                    }
                } else {
                    h71Var = new h71(n71Var, f71VarC);
                    dk1Var.H0(h71Var);
                }
                co1Var.X = h71Var;
                h71Var.H = co1Var;
                co1Var = h71Var;
            } else {
                dk1Var.H0(co1Var);
            }
            dk1Var = dk1Var.f;
        }
        n71 n71VarU = n71Var.u();
        co1Var.X = n71VarU != null ? n71VarU.o0.c : null;
        this.d = co1Var;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        dk1 dk1Var = this.f;
        jv2 jv2Var = this.e;
        if (dk1Var == jv2Var) {
            sb.append("]");
        } else {
            while (dk1Var != null && dk1Var != jv2Var) {
                sb.append(String.valueOf(dk1Var));
                if (dk1Var.i == jv2Var) {
                    sb.append("]");
                    break;
                }
                sb.append(",");
                dk1Var = dk1Var.i;
            }
        }
        return sb.toString();
    }
}
