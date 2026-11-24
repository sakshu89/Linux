package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bd {
    public final g33 a;
    public final Object b;
    public final qd c;
    public final ku1 d;
    public final ku1 e;
    public final ym1 f;
    public final vd g;
    public final vd h;
    public final vd i;
    public final vd j;

    public bd(Object obj, g33 g33Var, Object obj2) {
        this.a = g33Var;
        this.b = obj2;
        qd qdVar = new qd(g33Var, obj, null, 60);
        this.c = qdVar;
        this.d = o44.g(Boolean.FALSE);
        this.e = o44.g(obj);
        this.f = new ym1();
        new vq2(obj2);
        vd vdVar = qdVar.c;
        boolean z = vdVar instanceof rd;
        vd vdVar2 = z ? y11.g : vdVar instanceof sd ? y11.h : vdVar instanceof td ? y11.i : y11.j;
        this.g = vdVar2;
        vd vdVar3 = z ? y11.c : vdVar instanceof sd ? y11.d : vdVar instanceof td ? y11.e : y11.f;
        this.h = vdVar3;
        this.i = vdVar2;
        this.j = vdVar3;
    }

    public static final Object a(bd bdVar, Object obj) {
        g33 g33Var = bdVar.a;
        vd vdVar = bdVar.j;
        vd vdVar2 = bdVar.i;
        if (!g31.a(vdVar2, bdVar.g) || !g31.a(vdVar, bdVar.h)) {
            vd vdVar3 = (vd) g33Var.a.j(obj);
            int iB = vdVar3.b();
            boolean z = false;
            for (int i = 0; i < iB; i++) {
                if (vdVar3.a(i) < vdVar2.a(i) || vdVar3.a(i) > vdVar.a(i)) {
                    vdVar3.e(ky3.b(vdVar3.a(i), vdVar2.a(i), vdVar.a(i)), i);
                    z = true;
                }
            }
            if (z) {
                return g33Var.b.j(vdVar3);
            }
        }
        return obj;
    }

    public static final void b(bd bdVar) {
        qd qdVar = bdVar.c;
        qdVar.c.d();
        qdVar.e = Long.MIN_VALUE;
        bdVar.d.setValue(Boolean.FALSE);
    }

    public static Object c(bd bdVar, Object obj, pd pdVar, hq0 hq0Var, nu2 nu2Var, int i) {
        Object objJ = bdVar.a.b.j(bdVar.c.c);
        hq0 hq0Var2 = (i & 8) != 0 ? null : hq0Var;
        Object objD = bdVar.d();
        g33 g33Var = bdVar.a;
        return ym1.a(bdVar.f, new zc(bdVar, objJ, new wv2(pdVar, g33Var, objD, obj, (vd) g33Var.a.j(objJ)), bdVar.c.e, hq0Var2, null), nu2Var);
    }

    public final Object d() {
        return this.c.b.getValue();
    }

    public final Object e(x50 x50Var, Object obj) {
        Object objA = ym1.a(this.f, new ad(this, obj, null), x50Var);
        return objA == t70.a ? objA : q43.a;
    }

    public /* synthetic */ bd(Object obj, g33 g33Var, Object obj2, int i) {
        this(obj, g33Var, (i & 4) != 0 ? null : obj2);
    }
}
