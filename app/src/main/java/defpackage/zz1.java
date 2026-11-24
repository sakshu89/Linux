package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zz1 implements jc0 {
    public final /* synthetic */ jc0 a;
    public boolean b;
    public boolean c;
    public final an1 e = new an1();

    public zz1(jc0 jc0Var) {
        this.a = jc0Var;
    }

    @Override // defpackage.jc0
    public final float I(long j) {
        return this.a.I(j);
    }

    @Override // defpackage.jc0
    public final int R(float f) {
        return this.a.R(f);
    }

    public final void a() {
        this.b = true;
        an1 an1Var = this.e;
        if (an1Var.d()) {
            an1Var.h(null);
        }
    }

    @Override // defpackage.jc0
    public final long a0(long j) {
        return this.a.a0(j);
    }

    @Override // defpackage.jc0
    public final float b() {
        return this.a.b();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object d(y50 y50Var) {
        xz1 xz1Var;
        if (y50Var instanceof xz1) {
            xz1Var = (xz1) y50Var;
            int i = xz1Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                xz1Var.i = i - Integer.MIN_VALUE;
            } else {
                xz1Var = new xz1(this, y50Var);
            }
        } else {
            xz1Var = new xz1(this, y50Var);
        }
        Object obj = xz1Var.e;
        int i2 = xz1Var.i;
        if (i2 == 0) {
            bz3.g(obj);
            xz1Var.i = 1;
            Object objE = this.e.e(xz1Var);
            t70 t70Var = t70.a;
            if (objE == t70Var) {
                return t70Var;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(obj);
        }
        this.b = false;
        this.c = false;
        return q43.a;
    }

    @Override // defpackage.jc0
    public final float d0(long j) {
        return this.a.d0(j);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e(y50 y50Var) {
        yz1 yz1Var;
        if (y50Var instanceof yz1) {
            yz1Var = (yz1) y50Var;
            int i = yz1Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                yz1Var.i = i - Integer.MIN_VALUE;
            } else {
                yz1Var = new yz1(this, y50Var);
            }
        } else {
            yz1Var = new yz1(this, y50Var);
        }
        Object obj = yz1Var.e;
        int i2 = yz1Var.i;
        an1 an1Var = this.e;
        if (i2 == 0) {
            bz3.g(obj);
            if (!this.b && !this.c) {
                yz1Var.i = 1;
                Object objE = an1Var.e(yz1Var);
                t70 t70Var = t70.a;
                if (objE == t70Var) {
                    return t70Var;
                }
            }
            return Boolean.valueOf(this.b);
        }
        if (i2 != 1) {
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        bz3.g(obj);
        an1Var.h(null);
        return Boolean.valueOf(this.b);
    }

    @Override // defpackage.jc0
    public final float l() {
        return this.a.l();
    }

    @Override // defpackage.jc0
    public final long l0(float f) {
        return this.a.l0(f);
    }

    @Override // defpackage.jc0
    public final float r0(int i) {
        return this.a.r0(i);
    }

    @Override // defpackage.jc0
    public final float u0(float f) {
        return this.a.u0(f);
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
        return this.a.x(f);
    }
}
