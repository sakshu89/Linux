package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tv2 extends g72 implements vq0 {
    public Object c;
    public Object e;
    public int f;
    public /* synthetic */ Object i;
    public final /* synthetic */ s70 j;
    public final /* synthetic */ wq0 k;
    public final /* synthetic */ v60 n;
    public final /* synthetic */ zz1 s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tv2(s70 s70Var, wq0 wq0Var, v60 v60Var, zz1 zz1Var, x50 x50Var) {
        super(x50Var);
        this.j = s70Var;
        this.k = wq0Var;
        this.n = v60Var;
        this.s = zz1Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((tv2) q((x50) obj2, (su2) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        tv2 tv2Var = new tv2(this.j, this.k, this.n, this.s, x50Var);
        tv2Var.i = obj;
        return tv2Var;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00be  */
    /* JADX WARN: Code duplicated, block: B:35:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:58:0x0154  */
    /* JADX WARN: Code duplicated, block: B:62:0x016a  */
    /* JADX WARN: Code duplicated, block: B:65:0x0170  */
    /* JADX WARN: Code duplicated, block: B:66:0x0179  */
    /* JADX WARN: Code duplicated, block: B:68:0x0187  */
    @Override // defpackage.pk
    public final Object s(Object obj) {
        t70 t70Var;
        su2 su2Var;
        Object objA;
        ny1 ny1Var;
        yq2 yq2VarB;
        Object objE;
        f41 f41Var;
        Object objE2;
        f41 f41Var2;
        ny1 ny1Var2;
        ny2 ny2Var = this.n.b;
        int i = this.f;
        ny1 ny1Var3 = null;
        hy1 hy1Var = hy1.b;
        s70 s70Var = this.j;
        cf1 cf1Var = cf1.a;
        wq0 wq0Var = this.k;
        q43 q43Var = q43.a;
        zz1 zz1Var = this.s;
        x50 x50Var = null;
        t70 t70Var2 = t70.a;
        switch (i) {
            case 0:
                t70Var = t70Var2;
                bz3.g(obj);
                su2Var = (su2) this.i;
                this.i = su2Var;
                this.f = 1;
                objA = vv2.a(su2Var, (2 & 1) != 0, hy1.b, this);
                if (objA != t70Var) {
                    ny1Var = (ny1) objA;
                    ny1Var.a();
                    nv2 nv2Var = vv2.a;
                    yq2VarB = uf4.b(s70Var, null, new rv2(zz1Var, null, 1), 1);
                    if (wq0Var != vv2.a) {
                        vv2.d(s70Var, yq2VarB, new pv2(wq0Var, zz1Var, ny1Var, null, 1));
                    }
                    this.i = su2Var;
                    this.c = yq2VarB;
                    this.f = 2;
                    objE = vv2.e(su2Var, hy1Var, this);
                    if (objE != t70Var) {
                        f41Var = yq2VarB;
                        ny1Var3 = (ny1) objE;
                        if (ny1Var3 == null) {
                            vv2.d(s70Var, f41Var, new qv2(zz1Var, null, 3));
                        } else {
                            ny1Var3.a();
                            vv2.d(s70Var, f41Var, new qv2(zz1Var, null, 4));
                        }
                        if (ny1Var3 != null) {
                            ny2Var.r();
                        }
                        return q43Var;
                    }
                }
                return t70Var;
            case 1:
                t70Var = t70Var2;
                su2Var = (su2) this.i;
                bz3.g(obj);
                objA = obj;
                ny1Var = (ny1) objA;
                ny1Var.a();
                nv2 nv2Var2 = vv2.a;
                yq2VarB = uf4.b(s70Var, null, new rv2(zz1Var, null, 1), 1);
                if (wq0Var != vv2.a) {
                    vv2.d(s70Var, yq2VarB, new pv2(wq0Var, zz1Var, ny1Var, null, 1));
                }
                this.i = su2Var;
                this.c = yq2VarB;
                this.f = 2;
                objE = vv2.e(su2Var, hy1Var, this);
                if (objE != t70Var) {
                    f41Var = yq2VarB;
                    ny1Var3 = (ny1) objE;
                    if (ny1Var3 == null) {
                        vv2.d(s70Var, f41Var, new qv2(zz1Var, null, 3));
                    } else {
                        ny1Var3.a();
                        vv2.d(s70Var, f41Var, new qv2(zz1Var, null, 4));
                    }
                    if (ny1Var3 != null) {
                        ny2Var.r();
                    }
                    return q43Var;
                }
                return t70Var;
            case 2:
                f41Var = (f41) this.c;
                bz3.g(obj);
                objE = obj;
                ny1Var3 = (ny1) objE;
                if (ny1Var3 == null) {
                    vv2.d(s70Var, f41Var, new qv2(zz1Var, null, 3));
                } else {
                    ny1Var3.a();
                    vv2.d(s70Var, f41Var, new qv2(zz1Var, null, 4));
                }
                if (ny1Var3 != null) {
                    ny2Var.r();
                }
                return q43Var;
            case 3:
                f41Var = (f41) this.e;
                ny1 ny1Var4 = (ny1) this.c;
                bz3.g(obj);
                df1 df1Var = (df1) obj;
                if (g31.a(df1Var, cf1Var)) {
                    long j = ny1Var4.c;
                    throw null;
                }
                if (!(df1Var instanceof bf1) && !(df1Var instanceof af1)) {
                    dk0.l();
                    return null;
                }
                if (ny1Var3 == null) {
                    vv2.d(s70Var, f41Var, new qv2(zz1Var, null, 3));
                } else {
                    ny1Var3.a();
                    vv2.d(s70Var, f41Var, new qv2(zz1Var, null, 4));
                }
                if (ny1Var3 != null) {
                    ny2Var.r();
                }
                return q43Var;
            case 4:
                f41 f41Var3 = (f41) this.i;
                bz3.g(obj);
                vv2.d(s70Var, f41Var3, new qv2(zz1Var, null, 2));
                return q43Var;
            case 5:
                f41 f41Var4 = (f41) this.e;
                ny1 ny1Var5 = (ny1) this.c;
                su2 su2Var2 = (su2) this.i;
                bz3.g(obj);
                t70Var = t70Var2;
                ny1 ny1Var6 = (ny1) obj;
                if (ny1Var6 == null) {
                    long j2 = ny1Var5.c;
                    ny2Var.r();
                    return q43Var;
                }
                nv2 nv2Var3 = vv2.a;
                yq2 yq2VarB2 = uf4.b(s70Var, null, new sc2(f41Var4, zz1Var, x50Var, 12), 1);
                if (wq0Var != vv2.a) {
                    vv2.d(s70Var, yq2VarB2, new pv2(wq0Var, zz1Var, ny1Var6, null, 2));
                }
                this.i = yq2VarB2;
                this.c = ny1Var5;
                this.e = null;
                this.f = 6;
                objE2 = vv2.e(su2Var2, hy1Var, this);
                if (objE2 != t70Var) {
                    f41Var2 = yq2VarB2;
                    ny1Var2 = ny1Var5;
                    ny1Var3 = (ny1) objE2;
                    if (ny1Var3 != null) {
                        ny1Var3.a();
                        vv2.d(s70Var, f41Var2, new qv2(zz1Var, null, 5));
                        throw null;
                    }
                    vv2.d(s70Var, f41Var2, new qv2(zz1Var, null, 6));
                    long j3 = ny1Var2.c;
                    ny2Var.r();
                    return q43Var;
                }
                return t70Var;
            case 6:
                ny1Var2 = (ny1) this.c;
                f41 f41Var5 = (f41) this.i;
                bz3.g(obj);
                f41Var2 = f41Var5;
                objE2 = obj;
                ny1Var3 = (ny1) objE2;
                if (ny1Var3 != null) {
                    ny1Var3.a();
                    vv2.d(s70Var, f41Var2, new qv2(zz1Var, null, 5));
                    throw null;
                }
                vv2.d(s70Var, f41Var2, new qv2(zz1Var, null, 6));
                long j4 = ny1Var2.c;
                ny2Var.r();
                return q43Var;
            case 7:
                ny1Var2 = (ny1) this.e;
                f41Var2 = (f41) this.c;
                bz3.g(obj);
                df1 df1Var2 = (df1) obj;
                if (g31.a(df1Var2, cf1Var)) {
                    throw null;
                }
                if (!(df1Var2 instanceof bf1)) {
                    if (!(df1Var2 instanceof af1)) {
                        dk0.l();
                        return null;
                    }
                    ny1Var3 = null;
                }
                if (ny1Var3 != null) {
                    ny1Var3.a();
                    vv2.d(s70Var, f41Var2, new qv2(zz1Var, null, 5));
                    throw null;
                }
                vv2.d(s70Var, f41Var2, new qv2(zz1Var, null, 6));
                long j5 = ny1Var2.c;
                ny2Var.r();
                return q43Var;
            case 8:
                f41 f41Var6 = (f41) this.i;
                bz3.g(obj);
                vv2.d(s70Var, f41Var6, new qv2(zz1Var, null, 7));
                return q43Var;
            default:
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
