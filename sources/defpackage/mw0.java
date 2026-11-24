package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mw0 {
    public final y61 a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final yl1 f = new yl1();
    public final ho1 g = new ho1();
    public final rl1 h = new rl1(10);

    public mw0(y61 y61Var) {
        this.a = y61Var;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0076  */
    /* JADX WARN: Code duplicated, block: B:30:0x007c  */
    public final void a(long j, List list, boolean z) {
        rl1 rl1Var;
        long[] jArr;
        xn1 xn1Var;
        Object objD;
        Object obj;
        int size = list.size();
        ho1 ho1Var = this.g;
        ho1 ho1Var2 = ho1Var;
        boolean z2 = true;
        int i = 0;
        while (true) {
            rl1Var = this.h;
            if (i >= size) {
                break;
            }
            dk1 dk1Var = (dk1) list.get(i);
            if (dk1Var.w) {
                dk1Var.v = new h7(5, this, dk1Var);
                if (z2) {
                    pm1 pm1Var = ho1Var2.a;
                    Object[] objArr = pm1Var.a;
                    int i2 = pm1Var.c;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= i2) {
                            obj = null;
                            break;
                        }
                        obj = objArr[i3];
                        if (g31.a(((xn1) obj).c, dk1Var)) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    xn1Var = (xn1) obj;
                    if (xn1Var != null) {
                        xn1Var.i = true;
                        xn1Var.d.b(j);
                        if (z) {
                            Object objD2 = rl1Var.d(j);
                            if (objD2 == null) {
                                objD2 = new yl1();
                                rl1Var.f(j, objD2);
                            }
                            ((yl1) objD2).a(xn1Var);
                        }
                    } else {
                        z2 = false;
                        xn1Var = new xn1(dk1Var);
                        xn1Var.d.b(j);
                        if (z) {
                            objD = rl1Var.d(j);
                            if (objD == null) {
                                objD = new yl1();
                                rl1Var.f(j, objD);
                            }
                            ((yl1) objD).a(xn1Var);
                        }
                        ho1Var2.a.b(xn1Var);
                    }
                } else {
                    xn1Var = new xn1(dk1Var);
                    xn1Var.d.b(j);
                    if (z) {
                        objD = rl1Var.d(j);
                        if (objD == null) {
                            objD = new yl1();
                            rl1Var.f(j, objD);
                        }
                        ((yl1) objD).a(xn1Var);
                    }
                    ho1Var2.a.b(xn1Var);
                }
                ho1Var2 = xn1Var;
            }
            i++;
        }
        if (z) {
            long[] jArr2 = rl1Var.b;
            Object[] objArr2 = rl1Var.c;
            long[] jArr3 = rl1Var.a;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i4 = 0;
                while (true) {
                    long j2 = jArr3[i4];
                    if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i5 = 8;
                        int i6 = 8 - ((~(i4 - length)) >>> 31);
                        int i7 = 0;
                        while (i7 < i6) {
                            if ((255 & j2) < 128) {
                                int i8 = (i4 << 3) + i7;
                                long j3 = jArr2[i8];
                                yl1 yl1Var = (yl1) objArr2[i8];
                                pm1 pm1Var2 = ho1Var.a;
                                Object[] objArr3 = pm1Var2.a;
                                int i9 = pm1Var2.c;
                                for (int i10 = 0; i10 < i9; i10++) {
                                    ((xn1) objArr3[i10]).f(j3, yl1Var);
                                }
                            }
                            j2 >>= i5;
                            i7++;
                            i5 = i5;
                            jArr2 = jArr2;
                        }
                        jArr = jArr2;
                        if (i6 != i5) {
                            break;
                        }
                    } else {
                        jArr = jArr2;
                    }
                    if (i4 == length) {
                        break;
                    }
                    i4++;
                    jArr2 = jArr;
                }
            }
        }
        rl1Var.a();
    }

    public final boolean b(l11 l11Var, boolean z) {
        if1 if1Var = (if1) l11Var.b;
        y61 y61Var = this.a;
        ho1 ho1Var = this.g;
        boolean zA = ho1Var.a(if1Var, y61Var, l11Var, z);
        pm1 pm1Var = ho1Var.a;
        if (!zA) {
            return false;
        }
        boolean z2 = true;
        this.b = true;
        Object[] objArr = pm1Var.a;
        int i = pm1Var.c;
        boolean z3 = false;
        for (int i2 = 0; i2 < i; i2++) {
            z3 = ((xn1) objArr[i2]).e(l11Var, z) || z3;
        }
        Object[] objArr2 = pm1Var.a;
        int i3 = pm1Var.c;
        boolean z4 = false;
        for (int i4 = 0; i4 < i3; i4++) {
            z4 = ((xn1) objArr2[i4]).d(l11Var) || z4;
        }
        ho1Var.b(l11Var);
        if (!z4 && !z3) {
            z2 = false;
        }
        this.b = false;
        if (this.e) {
            this.e = false;
            yl1 yl1Var = this.f;
            int i5 = yl1Var.b;
            for (int i6 = 0; i6 < i5; i6++) {
                d((dk1) yl1Var.f(i6));
            }
            yl1Var.d();
        }
        if (this.c) {
            this.c = false;
            c();
        }
        if (this.d) {
            this.d = false;
            ho1Var.a.h();
        }
        return z2;
    }

    public final void c() {
        if (this.b) {
            this.c = true;
            return;
        }
        ho1 ho1Var = this.g;
        pm1 pm1Var = ho1Var.a;
        Object[] objArr = pm1Var.a;
        int i = pm1Var.c;
        for (int i2 = 0; i2 < i; i2++) {
            ((xn1) objArr[i2]).c();
        }
        if (this.d) {
            this.d = true;
        } else {
            ho1Var.a.h();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void d(dk1 dk1Var) {
        if (this.b) {
            this.e = true;
            this.f.a(dk1Var);
            return;
        }
        ho1 ho1Var = this.g;
        yl1 yl1Var = ho1Var.b;
        yl1Var.d();
        yl1Var.a(ho1Var);
        while (yl1Var.i()) {
            ho1 ho1Var2 = (ho1) yl1Var.k(yl1Var.b - 1);
            int i = 0;
            while (true) {
                pm1 pm1Var = ho1Var2.a;
                if (i < pm1Var.c) {
                    xn1 xn1Var = (xn1) pm1Var.a[i];
                    if (g31.a(xn1Var.c, dk1Var)) {
                        ho1Var2.a.k(xn1Var);
                        xn1Var.c();
                    } else {
                        yl1Var.a(xn1Var);
                        i++;
                    }
                }
            }
        }
    }
}
