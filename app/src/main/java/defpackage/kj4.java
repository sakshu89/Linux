package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class kj4 {
    /* JADX WARN: Code duplicated, block: B:46:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:51:? A[RETURN, SYNTHETIC] */
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
    public static final void a(a22 a22Var, w10 w10Var, x20 x20Var, int i) {
        h63 h63Var;
        boolean z;
        a42 a42VarR;
        x20Var.X(-149765515);
        m21 m21Var = x20Var.x;
        gw1 gw1VarL = x20Var.l();
        x20Var.U(201, y20.b);
        Object objL = x20Var.L();
        if (g31.a(objL, r20.a)) {
            h63Var = null;
        } else {
            objL.getClass();
            h63Var = (h63) objL;
        }
        z12 z12Var = (z12) a22Var.d;
        h63 h63VarC = z12Var.c(a22Var, h63Var);
        boolean zEquals = h63VarC.equals(h63Var);
        if (!zEquals) {
            x20Var.g0(h63VarC);
        }
        if (!x20Var.S) {
            nl2 nl2Var = x20Var.G;
            Object objB = nl2Var.b(nl2Var.g, nl2Var.b);
            objB.getClass();
            gw1 gw1Var = (gw1) objB;
            if (!(x20Var.A() && zEquals) && (a22Var.c || !gw1VarL.containsKey(z12Var))) {
                gw1VarL = gw1VarL.b(z12Var, h63VarC);
            } else if ((zEquals && !x20Var.w) || !x20Var.w) {
                gw1VarL = gw1Var;
            }
            if (x20Var.y || gw1Var != gw1VarL) {
                z = true;
            }
            if (z && !x20Var.S) {
                x20Var.J(gw1VarL);
            }
            m21Var.c(x20Var.w ? 1 : 0);
            x20Var.w = z;
            x20Var.K = gw1VarL;
            x20Var.S(202, 0, y20.c, gw1VarL);
            w10Var.e(x20Var, Integer.valueOf((i >> 3) & 14));
            x20Var.p(false);
            x20Var.p(false);
            x20Var.w = m21Var.b() != 0;
            x20Var.K = null;
            a42VarR = x20Var.r();
            if (a42VarR != null) {
                a42VarR.d = new gw(i, 2, a22Var, w10Var);
            }
        }
        if (a22Var.c || !gw1VarL.containsKey(z12Var)) {
            gw1VarL = gw1VarL.b(z12Var, h63VarC);
        }
        x20Var.J = true;
        z = false;
        if (z) {
            x20Var.J(gw1VarL);
        }
        m21Var.c(x20Var.w ? 1 : 0);
        x20Var.w = z;
        x20Var.K = gw1VarL;
        x20Var.S(202, 0, y20.c, gw1VarL);
        w10Var.e(x20Var, Integer.valueOf((i >> 3) & 14));
        x20Var.p(false);
        x20Var.p(false);
        x20Var.w = m21Var.b() != 0;
        x20Var.K = null;
        a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new gw(i, 2, a22Var, w10Var);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:29:0x00af  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
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
    public static final void b(a22[] a22VarArr, vq0 vq0Var, x20 x20Var, int i) {
        gw1 gw1VarF0;
        boolean z;
        a42 a42VarR;
        x20Var.X(415205898);
        m21 m21Var = x20Var.x;
        gw1 gw1VarL = x20Var.l();
        x20Var.U(201, y20.b);
        if (x20Var.S) {
            gw1VarF0 = x20Var.f0(gw1VarL, mj4.b(a22VarArr, gw1VarL, gw1.e));
            x20Var.J = true;
        } else {
            nl2 nl2Var = x20Var.G;
            Object objH = nl2Var.h(nl2Var.g, 0);
            objH.getClass();
            gw1 gw1Var = (gw1) objH;
            nl2 nl2Var2 = x20Var.G;
            Object objH2 = nl2Var2.h(nl2Var2.g, 1);
            objH2.getClass();
            gw1 gw1Var2 = (gw1) objH2;
            gw1 gw1VarB = mj4.b(a22VarArr, gw1VarL, gw1Var2);
            if (!x20Var.A() || x20Var.y || !gw1Var2.equals(gw1VarB)) {
                gw1VarF0 = x20Var.f0(gw1VarL, gw1VarB);
                if (x20Var.y || !g31.a(gw1VarF0, gw1Var)) {
                    z = true;
                }
                if (z && !x20Var.S) {
                    x20Var.J(gw1VarF0);
                }
                m21Var.c(x20Var.w ? 1 : 0);
                x20Var.w = z;
                x20Var.K = gw1VarF0;
                x20Var.S(202, 0, y20.c, gw1VarF0);
                vq0Var.e(x20Var, Integer.valueOf((i >> 3) & 14));
                x20Var.p(false);
                x20Var.p(false);
                x20Var.w = m21Var.b() != 0;
                x20Var.K = null;
                a42VarR = x20Var.r();
                if (a42VarR != null) {
                    a42VarR.d = new gw(i, 3, a22VarArr, vq0Var);
                }
            }
            x20Var.l = x20Var.G.s() + x20Var.l;
            gw1VarF0 = gw1Var;
        }
        z = false;
        if (z) {
            x20Var.J(gw1VarF0);
        }
        m21Var.c(x20Var.w ? 1 : 0);
        x20Var.w = z;
        x20Var.K = gw1VarF0;
        x20Var.S(202, 0, y20.c, gw1VarF0);
        vq0Var.e(x20Var, Integer.valueOf((i >> 3) & 14));
        x20Var.p(false);
        x20Var.p(false);
        x20Var.w = m21Var.b() != 0;
        x20Var.K = null;
        a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new gw(i, 3, a22VarArr, vq0Var);
        }
    }
}
