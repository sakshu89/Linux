package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class su2 implements jc0, x50 {
    public final /* synthetic */ tu2 a;
    public final yv b;
    public yv c;
    public hy1 e = hy1.b;
    public final gi0 f = gi0.a;
    public final /* synthetic */ tu2 i;

    public su2(tu2 tu2Var, yv yvVar) {
        this.i = tu2Var;
        this.a = tu2Var;
        this.b = yvVar;
    }

    @Override // defpackage.jc0
    public final float I(long j) {
        return this.a.I(j);
    }

    @Override // defpackage.jc0
    public final int R(float f) {
        return this.a.R(f);
    }

    public final Object a(hy1 hy1Var, pk pkVar) {
        yv yvVar = new yv(1, fp4.b(pkVar));
        yvVar.x();
        this.e = hy1Var;
        this.c = yvVar;
        return yvVar.v();
    }

    @Override // defpackage.jc0
    public final long a0(long j) {
        return this.a.a0(j);
    }

    @Override // defpackage.jc0
    public final float b() {
        return this.a.b();
    }

    public final long d() {
        tu2 tu2Var = this.i;
        long jA0 = tu2Var.a0(cm4.g(tu2Var).j0.g());
        long j = tu2Var.g0;
        return (((long) Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (jA0 >> 32)) - ((int) (j >> 32))) / 2.0f)) << 32) | (((long) Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (jA0 & 4294967295L)) - ((int) (j & 4294967295L))) / 2.0f)) & 4294967295L);
    }

    @Override // defpackage.jc0
    public final float d0(long j) {
        return this.a.d0(j);
    }

    public final w73 e() {
        return cm4.g(this.i).j0;
    }

    @Override // defpackage.x50
    public final j70 f() {
        return this.f;
    }

    @Override // defpackage.x50
    public final void h(Object obj) {
        tu2 tu2Var = this.i;
        synchronized (tu2Var.d0) {
            tu2Var.c0.k(this);
        }
        this.b.h(obj);
    }

    @Override // defpackage.jc0
    public final float l() {
        return this.a.l();
    }

    @Override // defpackage.jc0
    public final long l0(float f) {
        return this.a.l0(f);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object n(long j, vq0 vq0Var, y50 y50Var) {
        qu2 qu2Var;
        Throwable th;
        yq2 yq2Var;
        yv yvVar;
        if (y50Var instanceof qu2) {
            qu2Var = (qu2) y50Var;
            int i = qu2Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                qu2Var.j = i - Integer.MIN_VALUE;
            } else {
                qu2Var = new qu2(this, y50Var);
            }
        } else {
            qu2Var = new qu2(this, y50Var);
        }
        Object objE = qu2Var.f;
        int i2 = qu2Var.j;
        if (i2 != 0) {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            yq2Var = qu2Var.e;
            try {
                bz3.g(objE);
                yq2Var.e(uv.b);
                return objE;
            } catch (Throwable th2) {
                th = th2;
                yq2Var.e(uv.b);
                throw th;
            }
        }
        bz3.g(objE);
        if (j <= 0 && (yvVar = this.c) != null) {
            yvVar.h(new h72(new iy1(j)));
        }
        yq2 yq2VarB = uf4.b(this.i.w0(), null, new yf2(j, this, (x50) null), 3);
        try {
            qu2Var.e = yq2VarB;
            qu2Var.j = 1;
            objE = vq0Var.e(this, qu2Var);
            Object obj = t70.a;
            if (objE == obj) {
                return obj;
            }
            yq2Var = yq2VarB;
            yq2Var.e(uv.b);
            return objE;
        } catch (Throwable th3) {
            th = th3;
            yq2Var = yq2VarB;
            yq2Var.e(uv.b);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object o(long j, vq0 vq0Var, pk pkVar) {
        ru2 ru2Var;
        if (pkVar instanceof ru2) {
            ru2Var = (ru2) pkVar;
            int i = ru2Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                ru2Var.i = i - Integer.MIN_VALUE;
            } else {
                ru2Var = new ru2(this, pkVar);
            }
        } else {
            ru2Var = new ru2(this, pkVar);
        }
        Object obj = ru2Var.e;
        int i2 = ru2Var.i;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    bz3.g(obj);
                    return obj;
                }
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(obj);
            ru2Var.i = 1;
            Object objN = n(j, vq0Var, ru2Var);
            Object obj2 = t70.a;
            return objN == obj2 ? obj2 : objN;
        } catch (iy1 unused) {
            return null;
        }
    }

    @Override // defpackage.jc0
    public final float r0(int i) {
        return this.a.r0(i);
    }

    @Override // defpackage.jc0
    public final float u0(float f) {
        return f / this.a.b();
    }

    @Override // defpackage.jc0
    public final long v(float f) {
        return this.a.v(f);
    }

    @Override // defpackage.jc0
    public final long w(long j) {
        return this.a.w(j);
    }

    @Override // defpackage.jc0
    public final float x(float f) {
        return this.a.b() * f;
    }
}
