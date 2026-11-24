package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ea1 implements be2 {
    public static final q91 x;
    public final sa0 a;
    public boolean b;
    public x91 c;
    public boolean d;
    public final ux e;
    public final ku1 f;
    public final ol1 g;
    public float h;
    public final bb0 i;
    public final boolean j;
    public n71 k;
    public final ca1 l;
    public final dk m;
    public final t81 n;
    public final tm o;
    public final f91 p;
    public final py0 q;
    public final c91 r;
    public final mm1 s;
    public final ku1 t;
    public final ku1 u;
    public final mm1 v;
    public final l11 w;

    static {
        ag agVar = new ag(7);
        j jVar = new j(27);
        ha haVar = new ha(5, agVar);
        h33.c(1, jVar);
        x = new q91(26, haVar, jVar);
    }

    public ea1(int i, int i2) {
        sa0 sa0Var = new sa0();
        sa0Var.a = -1;
        sa0Var.d = -1;
        this.a = sa0Var;
        ux uxVar = new ux();
        uxVar.b = new hu1(i);
        uxVar.c = new hu1(i2);
        uxVar.e = new z81(i);
        this.e = uxVar;
        x91 x91Var = ga1.a;
        el1 el1Var = el1.f;
        this.f = new ku1(x91Var, el1Var);
        this.g = new ol1();
        this.i = new bb0(new x0(16, this));
        this.j = true;
        this.l = new ca1(this);
        this.m = new dk();
        this.n = new t81();
        this.o = new tm(1);
        this.p = new f91(new aa1(this, i));
        this.q = new py0(3, this);
        this.r = new c91();
        q43 q43Var = q43.a;
        this.s = new ku1(q43Var, el1Var);
        Boolean bool = Boolean.FALSE;
        this.t = o44.g(bool);
        this.u = o44.g(bool);
        this.v = new ku1(q43Var, el1Var);
        l11 l11Var = new l11(29, false);
        Float fValueOf = Float.valueOf(0.0f);
        g33 g33Var = eb4.a;
        l11Var.c = new qd(g33Var, fValueOf, (vd) g33Var.a.j(fValueOf), Long.MIN_VALUE, Long.MIN_VALUE, false);
        this.w = l11Var;
    }

    @Override // defpackage.be2
    public final boolean a() {
        return ((Boolean) this.u.getValue()).booleanValue();
    }

    @Override // defpackage.be2
    public final boolean b() {
        return this.i.b();
    }

    @Override // defpackage.be2
    public final boolean c() {
        return ((Boolean) this.t.getValue()).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
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
    @Override // defpackage.be2
    public final Object d(rm1 rm1Var, vq0 vq0Var, y50 y50Var) throws Throwable {
        da1 da1Var;
        if (y50Var instanceof da1) {
            da1Var = (da1) y50Var;
            int i = da1Var.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                da1Var.k = i - Integer.MIN_VALUE;
            } else {
                da1Var = new da1(this, y50Var);
            }
        } else {
            da1Var = new da1(this, y50Var);
        }
        Object obj = da1Var.i;
        int i2 = da1Var.k;
        Object obj2 = q43.a;
        Object obj3 = t70.a;
        if (i2 == 0) {
            bz3.g(obj);
            if (this.f.getValue() == ga1.a) {
                da1Var.e = rm1Var;
                da1Var.f = (nu2) vq0Var;
                da1Var.k = 1;
                dk dkVar = this.m;
                x00 x00VarA = dkVar.b;
                if (x00VarA == null) {
                    x00VarA = ui4.a();
                    dkVar.b = x00VarA;
                    ck ckVar = dkVar.a;
                    if (ckVar != null && ckVar.w) {
                        ckVar.I0();
                    }
                }
                Object objS0 = x00VarA.s0(da1Var);
                if (objS0 != obj3) {
                    objS0 = obj2;
                }
                if (objS0 != obj3) {
                }
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                bz3.g(obj);
                return obj2;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        vq0Var = (vq0) da1Var.f;
        rm1Var = da1Var.e;
        bz3.g(obj);
        da1Var.e = null;
        da1Var.f = null;
        da1Var.k = 2;
        return this.i.d(rm1Var, vq0Var, da1Var) == obj3 ? obj3 : obj2;
    }

    @Override // defpackage.be2
    public final float e(float f) {
        return this.i.e(f);
    }

    public final void f(x91 x91Var, boolean z, boolean z2) {
        List list = x91Var.k;
        int i = x91Var.n;
        int i2 = x91Var.b;
        y91 y91Var = x91Var.a;
        this.p.e = list.size();
        g33 g33Var = eb4.a;
        l11 l11Var = this.w;
        ux uxVar = this.e;
        x50 x50Var = null;
        if (!z && this.b) {
            this.c = x91Var;
            bm2 bm2VarA = i44.a();
            hq0 hq0VarE = bm2VarA != null ? bm2VarA.e() : null;
            bm2 bm2VarB = i44.b(bm2VarA);
            try {
                if (((Number) ((qd) l11Var.c).b.getValue()).floatValue() != 0.0f && y91Var != null && y91Var.a == ((hu1) uxVar.b).g() && i2 == ((hu1) uxVar.c).g()) {
                    yq2 yq2Var = (yq2) l11Var.b;
                    if (yq2Var != null) {
                        yq2Var.e(null);
                    }
                    l11Var.c = new qd(g33Var, Float.valueOf(0.0f), null, 60);
                }
                return;
            } finally {
                i44.e(bm2VarA, bm2VarB, hq0VarE);
            }
        }
        if (z) {
            this.b = true;
        }
        this.u.setValue(Boolean.valueOf(((y91Var != null ? y91Var.a : 0) == 0 && i2 == 0) ? false : true));
        this.t.setValue(Boolean.valueOf(x91Var.c));
        this.h -= x91Var.d;
        this.f.setValue(x91Var);
        if (z2) {
            uxVar.getClass();
            if (i2 < 0.0f) {
                c11.c("scrollOffset should be non-negative");
            }
            ((hu1) uxVar.c).h(i2);
        } else {
            y91 y91Var2 = (y91) mz.y(list);
            y91 y91Var3 = (y91) mz.E(list);
            ge4.a(y91Var2 != null ? y91Var2.a : -1L, "firstVisibleItem:index");
            ge4.a(y91Var3 != null ? y91Var3.a : -1L, "lastVisibleItem:index");
            uxVar.getClass();
            uxVar.d = y91Var != null ? y91Var.g : null;
            if (uxVar.a || i > 0) {
                uxVar.a = true;
                if (i2 < 0.0f) {
                    c11.c("scrollOffset should be non-negative");
                }
                uxVar.f(y91Var != null ? y91Var.a : 0, i2);
            }
            if (this.j) {
                sa0 sa0Var = this.a;
                int i3 = sa0Var.a;
                boolean z3 = sa0Var.c;
                if (i3 != -1 && !list.isEmpty() && i3 != sa0.a(x91Var, z3)) {
                    sa0Var.a = -1;
                    e91 e91Var = sa0Var.b;
                    if (e91Var != null) {
                        e91Var.cancel();
                    }
                    sa0Var.b = null;
                }
                int i4 = sa0Var.d;
                if (i4 != -1 && sa0Var.e != 0.0f && i4 != i && !list.isEmpty()) {
                    int iA = sa0.a(x91Var, sa0Var.e < 0.0f);
                    if (iA >= 0 && iA < i) {
                        sa0Var.a = iA;
                        sa0Var.b = py0.h(this.q, iA);
                    }
                }
                sa0Var.d = i;
            }
        }
        if (z) {
            float f = x91Var.f;
            jc0 jc0Var = x91Var.i;
            s70 s70Var = x91Var.h;
            l11Var.getClass();
            if (f <= jc0Var.x(1.0f)) {
                return;
            }
            bm2 bm2VarA2 = i44.a();
            hq0 hq0VarE2 = bm2VarA2 != null ? bm2VarA2.e() : null;
            bm2 bm2VarB2 = i44.b(bm2VarA2);
            try {
                float fFloatValue = ((Number) ((qd) l11Var.c).b.getValue()).floatValue();
                yq2 yq2Var2 = (yq2) l11Var.b;
                if (yq2Var2 != null) {
                    yq2Var2.e(null);
                }
                qd qdVar = (qd) l11Var.c;
                if (qdVar.i) {
                    l11Var.c = ke4.b(qdVar, fFloatValue - f);
                } else {
                    l11Var.c = new qd(g33Var, Float.valueOf(-f), null, 60);
                }
                l11Var.b = uf4.b(s70Var, null, new l2(l11Var, x50Var, 8), 3);
            } finally {
                i44.e(bm2VarA2, bm2VarB2, hq0VarE2);
            }
        }
    }

    public final int g() {
        return ((hu1) this.e.b).g();
    }

    public final int h() {
        return ((hu1) this.e.c).g();
    }

    public final x91 i() {
        return (x91) this.f.getValue();
    }

    public final void j(float f, x91 x91Var) {
        e91 e91Var;
        e91 e91Var2;
        if (this.j) {
            boolean zIsEmpty = x91Var.k.isEmpty();
            sa0 sa0Var = this.a;
            if (!zIsEmpty) {
                boolean z = f < 0.0f;
                int iA = sa0.a(x91Var, z);
                if (iA >= 0 && iA < x91Var.n) {
                    if (iA != sa0Var.a) {
                        if (sa0Var.c != z) {
                            sa0Var.a = -1;
                            e91 e91Var3 = sa0Var.b;
                            if (e91Var3 != null) {
                                e91Var3.cancel();
                            }
                            sa0Var.b = null;
                        }
                        sa0Var.c = z;
                        sa0Var.a = iA;
                        sa0Var.b = py0.h(this.q, iA);
                    }
                    List list = x91Var.k;
                    if (z) {
                        y91 y91Var = (y91) mz.D(list);
                        if (((y91Var.j + y91Var.k) + x91Var.q) - x91Var.m < (-f) && (e91Var2 = sa0Var.b) != null) {
                            e91Var2.a();
                        }
                    } else if (x91Var.l - ((y91) mz.x(list)).j < f && (e91Var = sa0Var.b) != null) {
                        e91Var.a();
                    }
                }
            }
            sa0Var.e = f;
        }
    }

    public final void k(int i) {
        ux uxVar = this.e;
        if (((hu1) uxVar.b).g() != i || ((hu1) uxVar.c).g() != 0) {
            t81 t81Var = this.n;
            t81Var.c();
            t81Var.b = null;
        }
        uxVar.f(i, 0);
        uxVar.d = null;
        n71 n71Var = this.k;
        if (n71Var != null) {
            n71Var.k();
        }
    }
}
