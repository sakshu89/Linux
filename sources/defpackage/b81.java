package defpackage;

import android.os.Handler;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b81 implements d20 {
    public final String H;
    public final n71 a;
    public a30 b;
    public zs2 c;
    public int e;
    public int f;
    public final gm1 i;
    public final gm1 j;
    public final v71 k;
    public final s71 n;
    public final gm1 s;
    public final ys2 t;
    public final gm1 u;
    public final pm1 v;
    public int w;
    public int x;

    public b81(n71 n71Var, zs2 zs2Var) {
        this.a = n71Var;
        this.c = zs2Var;
        long[] jArr = ya2.a;
        this.i = new gm1();
        this.j = new gm1();
        this.k = new v71(this);
        this.n = new s71(this);
        this.s = new gm1();
        this.t = new ys2();
        this.u = new gm1();
        this.v = new pm1(new Object[16]);
        this.H = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";
    }

    public static final void c(b81 b81Var, Object obj) {
        n71 n71Var = b81Var.a;
        b81Var.h();
        n71 n71Var2 = (n71) b81Var.s.k(obj);
        if (n71Var2 != null) {
            if (b81Var.x <= 0) {
                z01.b("No pre-composed items to dispose");
            }
            int iJ = ((pm1) ((wl1) n71Var.o()).b).j(n71Var2);
            if (iJ < ((pm1) ((wl1) n71Var.o()).b).c - b81Var.x) {
                z01.b("Item is not in pre-composed item range");
            }
            b81Var.w++;
            b81Var.x--;
            t71 t71Var = (t71) b81Var.i.g(n71Var2);
            if (t71Var != null) {
                e(t71Var);
            }
            int i = (((pm1) ((wl1) n71Var.o()).b).c - b81Var.x) - b81Var.w;
            b81Var.j(iJ, i);
            b81Var.g(i);
        }
        if (b81Var.v.i(obj)) {
            n71.V(n71Var, true, 6);
        }
    }

    public static void e(t71 t71Var) {
        hm1 hm1Var;
        kv1 kv1Var = t71Var.f;
        if (kv1Var != null) {
            kv1Var.h.set(mv1.b);
            i52 i52Var = kv1Var.k;
            if (((hm1) i52Var.g).h()) {
                hm1Var = (hm1) i52Var.g;
                hm1 hm1Var2 = za2.a;
                i52Var.g = new hm1();
                ((pm1) i52Var.c).h();
            } else {
                hm1Var = null;
            }
            i52Var.b();
            g30 g30Var = kv1Var.a;
            g30Var.X = null;
            if (hm1Var != null) {
                g30Var.d0.i = hm1Var;
                g30Var.f0 = 2;
            }
            t71Var.f = null;
            g30 g30Var2 = t71Var.c;
            if (g30Var2 != null) {
                g30Var2.m();
            }
            t71Var.c = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x004f A[LOOP:0: B:5:0x0014->B:17:0x004f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x0052 A[EDGE_INSN: B:21:0x0052->B:18:0x0052 BREAK  A[LOOP:0: B:5:0x0014->B:17:0x004f], SYNTHETIC] */
    @Override // defpackage.d20
    public final void a() {
        g30 g30Var;
        n71 n71Var = this.a;
        n71Var.X = true;
        gm1 gm1Var = this.i;
        Object[] objArr = gm1Var.c;
        long[] jArr = gm1Var.a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128 && (g30Var = ((t71) objArr[(i << 3) + i3]).c) != null) {
                            g30Var.m();
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    } else if (i != length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        n71Var.P();
        n71Var.X = false;
        gm1Var.a();
        this.j.a();
        this.x = 0;
        this.w = 0;
        this.s.a();
        h();
    }

    @Override // defpackage.d20
    public final void b() {
        i(true);
    }

    public final void d(t71 t71Var, boolean z) {
        kv1 kv1Var = t71Var.f;
        if (kv1Var != null) {
            bm2 bm2VarA = i44.a();
            hq0 hq0VarE = bm2VarA != null ? bm2VarA.e() : null;
            bm2 bm2VarB = i44.b(bm2VarA);
            try {
                n71 n71Var = this.a;
                n71Var.X = true;
                if (z) {
                    while (!kv1Var.c()) {
                        try {
                            kv1Var.e(new dk0(6));
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                kv1Var.a();
                t71Var.f = null;
                n71Var.X = false;
                i44.e(bm2VarA, bm2VarB, hq0VarE);
            } catch (Throwable th2) {
                i44.e(bm2VarA, bm2VarB, hq0VarE);
                throw th2;
            }
        }
    }

    public final us2 f(Object obj) {
        return !this.a.H() ? new y71() : new z71(this, obj);
    }

    public final void g(int i) {
        boolean z;
        boolean z2 = false;
        this.w = 0;
        List listO = this.a.o();
        wl1 wl1Var = (wl1) listO;
        int i2 = (((pm1) wl1Var.b).c - this.x) - 1;
        if (i <= i2) {
            this.t.clear();
            if (i <= i2) {
                int i3 = i;
                while (true) {
                    Object objG = this.i.g((n71) wl1Var.get(i3));
                    objG.getClass();
                    ((am1) this.t.b).a(((t71) objG).a);
                    if (i3 == i2) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            this.c.h(this.t);
            bm2 bm2VarA = i44.a();
            hq0 hq0VarE = bm2VarA != null ? bm2VarA.e() : null;
            bm2 bm2VarB = i44.b(bm2VarA);
            z = false;
            while (i2 >= i) {
                try {
                    n71 n71Var = (n71) ((wl1) listO).get(i2);
                    Object objG2 = this.i.g(n71Var);
                    objG2.getClass();
                    t71 t71Var = (t71) objG2;
                    Object obj = t71Var.a;
                    if (((am1) this.t.b).c(obj)) {
                        this.w++;
                        if (((Boolean) t71Var.g.getValue()).booleanValue()) {
                            r71 r71Var = n71Var.p0;
                            nh1 nh1Var = r71Var.p;
                            l71 l71Var = l71.c;
                            nh1Var.u = l71Var;
                            sf1 sf1Var = r71Var.q;
                            if (sf1Var != null) {
                                sf1Var.s = l71Var;
                            }
                            l(t71Var, false);
                            if (t71Var.h) {
                                z = true;
                            }
                        }
                    } else {
                        n71 n71Var2 = this.a;
                        n71Var2.X = true;
                        this.i.k(n71Var);
                        g30 g30Var = t71Var.c;
                        if (g30Var != null) {
                            g30Var.m();
                        }
                        this.a.Q(i2, 1);
                        n71Var2.X = false;
                    }
                    this.j.k(obj);
                    i2--;
                } catch (Throwable th) {
                    i44.e(bm2VarA, bm2VarB, hq0VarE);
                    throw th;
                }
            }
            i44.e(bm2VarA, bm2VarB, hq0VarE);
        } else {
            z = false;
        }
        if (z) {
            synchronized (im2.c) {
                hm1 hm1Var = im2.j.h;
                if (hm1Var != null && hm1Var.h()) {
                    z2 = true;
                }
            }
            if (z2) {
                im2.a();
            }
        }
        h();
    }

    public final void h() {
        int i = ((pm1) ((wl1) this.a.o()).b).c;
        gm1 gm1Var = this.i;
        if (gm1Var.e != i) {
            z01.a("Inconsistency between the count of nodes tracked by the state (" + gm1Var.e + ") and the children count on the SubcomposeLayout (" + i + "). Are you trying to use the state of the disposed SubcomposeLayout?");
        }
        if ((i - this.w) - this.x < 0) {
            StringBuilder sbP = ky0.p("Incorrect state. Total children ", i, ". Reusable children ");
            sbP.append(this.w);
            sbP.append(". Precomposed children ");
            sbP.append(this.x);
            z01.a(sbP.toString());
        }
        gm1 gm1Var2 = this.s;
        if (gm1Var2.e == this.x) {
            return;
        }
        z01.a("Incorrect state. Precomposed children " + this.x + ". Map size " + gm1Var2.e);
    }

    public final void i(boolean z) {
        this.x = 0;
        this.s.a();
        List listO = this.a.o();
        int i = ((pm1) ((wl1) listO).b).c;
        if (this.w != i) {
            this.w = i;
            bm2 bm2VarA = i44.a();
            hq0 hq0VarE = bm2VarA != null ? bm2VarA.e() : null;
            bm2 bm2VarB = i44.b(bm2VarA);
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    n71 n71Var = (n71) ((wl1) listO).get(i2);
                    t71 t71Var = (t71) this.i.g(n71Var);
                    if (t71Var != null && ((Boolean) t71Var.g.getValue()).booleanValue()) {
                        r71 r71Var = n71Var.p0;
                        nh1 nh1Var = r71Var.p;
                        l71 l71Var = l71.c;
                        nh1Var.u = l71Var;
                        sf1 sf1Var = r71Var.q;
                        if (sf1Var != null) {
                            sf1Var.s = l71Var;
                        }
                        l(t71Var, z);
                        t71Var.a = na4.a;
                    }
                } catch (Throwable th) {
                    i44.e(bm2VarA, bm2VarB, hq0VarE);
                    throw th;
                }
            }
            i44.e(bm2VarA, bm2VarB, hq0VarE);
            this.j.a();
        }
        h();
    }

    public final void j(int i, int i2) {
        n71 n71Var = this.a;
        n71Var.X = true;
        n71Var.L(i, i2, 1);
        n71Var.X = false;
    }

    public final void k(Object obj, vq0 vq0Var, boolean z) {
        n71 n71Var = this.a;
        if (n71Var.H()) {
            h();
            if (this.j.c(obj)) {
                return;
            }
            this.u.k(obj);
            gm1 gm1Var = this.s;
            Object objG = gm1Var.g(obj);
            if (objG == null) {
                objG = n(obj);
                if (objG != null) {
                    j(((pm1) ((wl1) n71Var.o()).b).j(objG), ((pm1) ((wl1) n71Var.o()).b).c);
                    this.x++;
                } else {
                    int i = ((pm1) ((wl1) n71Var.o()).b).c;
                    n71 n71Var2 = new n71(2);
                    n71Var.X = true;
                    n71Var.B(i, n71Var2);
                    n71Var.X = false;
                    this.x++;
                    objG = n71Var2;
                }
                gm1Var.m(obj, objG);
            }
            m((n71) objG, obj, z, vq0Var);
        }
    }

    public final void l(t71 t71Var, boolean z) {
        g30 g30Var;
        if (z || !t71Var.h) {
            t71Var.g = o44.g(Boolean.FALSE);
        } else {
            t71Var.g.setValue(Boolean.FALSE);
        }
        if (t71Var.f != null) {
            e(t71Var);
            return;
        }
        if (z) {
            g30 g30Var2 = t71Var.c;
            if (g30Var2 != null) {
                g30Var2.l();
                return;
            }
            return;
        }
        ks1 outOfFrameExecutor = ((r7) q71.a(this.a)).getOutOfFrameExecutor();
        if (outOfFrameExecutor == null) {
            if (t71Var.h || (g30Var = t71Var.c) == null) {
                return;
            }
            g30Var.l();
            return;
        }
        ta taVar = new ta(9, t71Var);
        r7 r7Var = (r7) outOfFrameExecutor;
        hg hgVar = r7Var.k;
        boolean zIsEmpty = hgVar.isEmpty();
        hgVar.addLast(taVar);
        if (zIsEmpty) {
            Handler handler = r7Var.getHandler();
            if (handler != null) {
                handler.postAtFrontOfQueue(r7Var.n);
            } else {
                og.i("schedule is called when outOfFrameExecutor is not available (view is detached)");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0092 A[Catch: all -> 0x008d, TryCatch #0 {all -> 0x008d, blocks: (B:44:0x0076, B:47:0x0082, B:59:0x00ad, B:61:0x00bf, B:64:0x00d4, B:66:0x00d8, B:72:0x010e, B:67:0x00e5, B:68:0x00f0, B:70:0x00f4, B:71:0x010b, B:62:0x00c2, B:56:0x0092, B:58:0x00a0, B:75:0x0118, B:76:0x0122), top: B:79:0x0076 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0 A[Catch: all -> 0x008d, TryCatch #0 {all -> 0x008d, blocks: (B:44:0x0076, B:47:0x0082, B:59:0x00ad, B:61:0x00bf, B:64:0x00d4, B:66:0x00d8, B:72:0x010e, B:67:0x00e5, B:68:0x00f0, B:70:0x00f4, B:71:0x010b, B:62:0x00c2, B:56:0x0092, B:58:0x00a0, B:75:0x0118, B:76:0x0122), top: B:79:0x0076 }] */
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
    public final void m(n71 n71Var, Object obj, boolean z, vq0 vq0Var) {
        boolean z2;
        g30 g30Var;
        gm1 gm1Var = this.i;
        Object objG = gm1Var.g(n71Var);
        Object obj2 = objG;
        if (objG == null) {
            w10 w10Var = a20.a;
            t71 t71Var = new t71();
            t71Var.a = obj;
            t71Var.b = w10Var;
            t71Var.c = null;
            t71Var.g = o44.g(Boolean.TRUE);
            gm1Var.m(n71Var, t71Var);
            obj2 = t71Var;
        }
        t71 t71Var2 = (t71) obj2;
        boolean z3 = t71Var2.b != vq0Var;
        if (t71Var2.f != null) {
            if (z3) {
                e(t71Var2);
            } else if (z) {
                return;
            } else {
                d(t71Var2, true);
            }
        }
        g30 g30Var2 = t71Var2.c;
        if (g30Var2 != null) {
            synchronized (g30Var2.e) {
                z2 = g30Var2.w.e > 0;
            }
        } else {
            z2 = true;
        }
        if (z3 || z2 || t71Var2.d) {
            t71Var2.b = vq0Var;
            if (t71Var2.f != null) {
                z01.a("new subcompose call while paused composition is still active");
            }
            bm2 bm2VarA = i44.a();
            hq0 hq0VarE = bm2VarA != null ? bm2VarA.e() : null;
            bm2 bm2VarB = i44.b(bm2VarA);
            try {
                n71 n71Var2 = this.a;
                n71Var2.X = true;
                g30 g30Var3 = t71Var2.c;
                a30 a30Var = this.b;
                if (a30Var == null) {
                    z01.c("parent composition reference not set");
                    throw new b10();
                }
                if (g30Var3 == null) {
                    if (z) {
                        ViewGroup.LayoutParams layoutParams = rc3.a;
                        g30Var = new g30(a30Var, new b43(n71Var));
                    } else {
                        ViewGroup.LayoutParams layoutParams2 = rc3.a;
                        g30Var = new g30(a30Var, new b43(n71Var));
                    }
                    g30Var3 = g30Var;
                } else {
                    if (g30Var3.f0 == 3) {
                        if (z) {
                            ViewGroup.LayoutParams layoutParams3 = rc3.a;
                            g30Var = new g30(a30Var, new b43(n71Var));
                        } else {
                            ViewGroup.LayoutParams layoutParams4 = rc3.a;
                            g30Var = new g30(a30Var, new b43(n71Var));
                        }
                        g30Var3 = g30Var;
                    }
                }
                t71Var2.c = g30Var3;
                vq0 w10Var2 = t71Var2.b;
                if (((r7) q71.a(this.a)).getOutOfFrameExecutor() != null) {
                    t71Var2.h = false;
                } else {
                    t71Var2.h = true;
                    w10Var2 = new w10(1524156494, true, new i8(2, t71Var2, w10Var2));
                }
                if (z) {
                    if (t71Var2.e) {
                        g30Var3.i();
                        g30Var3.q();
                        t71Var2.f = g30Var3.k(true, w10Var2);
                    } else {
                        t71Var2.f = g30Var3.k(g30Var3.i(), w10Var2);
                    }
                } else if (t71Var2.e) {
                    g30Var3.i();
                    g30Var3.q();
                    x20 x20Var = g30Var3.e0;
                    x20Var.z = 100;
                    x20Var.y = true;
                    g30Var3.a.a(g30Var3, w10Var2);
                    x20Var.s();
                } else {
                    g30Var3.B(w10Var2);
                }
                t71Var2.e = false;
                n71Var2.X = false;
                i44.e(bm2VarA, bm2VarB, hq0VarE);
                t71Var2.d = false;
            } catch (Throwable th) {
                i44.e(bm2VarA, bm2VarB, hq0VarE);
                throw th;
            }
        }
    }

    public final n71 n(Object obj) {
        gm1 gm1Var;
        int i;
        if (this.w == 0) {
            return null;
        }
        wl1 wl1Var = (wl1) this.a.o();
        int i2 = ((pm1) wl1Var.b).c - this.x;
        int i3 = i2 - this.w;
        int i4 = i2 - 1;
        int i5 = i4;
        while (true) {
            gm1Var = this.i;
            if (i5 < i3) {
                i = -1;
                break;
            }
            Object objG = gm1Var.g((n71) wl1Var.get(i5));
            objG.getClass();
            if (((t71) objG).a.equals(obj)) {
                i = i5;
                break;
            }
            i5--;
        }
        if (i == -1) {
            while (true) {
                if (i4 < i3) {
                    i5 = i4;
                    break;
                }
                Object objG2 = gm1Var.g((n71) wl1Var.get(i4));
                objG2.getClass();
                t71 t71Var = (t71) objG2;
                Object obj2 = t71Var.a;
                if (obj2 == na4.a || this.c.p(obj, obj2)) {
                    t71Var.a = obj;
                    i5 = i4;
                    i = i5;
                    break;
                }
                i4--;
            }
        }
        if (i == -1) {
            return null;
        }
        if (i5 != i3) {
            j(i5, i3);
        }
        this.w--;
        n71 n71Var = (n71) wl1Var.get(i3);
        Object objG3 = gm1Var.g(n71Var);
        objG3.getClass();
        t71 t71Var2 = (t71) objG3;
        t71Var2.g = o44.g(Boolean.TRUE);
        t71Var2.e = true;
        t71Var2.d = true;
        return n71Var;
    }
}
