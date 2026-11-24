package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ww0 extends dk1 implements t23, qy1, h30 {
    public va H;
    public boolean X;
    public he0 x;

    public ww0(va vaVar, he0 he0Var) {
        this.x = he0Var;
        this.H = vaVar;
    }

    @Override // defpackage.dk1
    public final void B0() {
        M0();
    }

    @Override // defpackage.qy1
    public final void H(gy1 gy1Var, hy1 hy1Var, long j) {
        if (hy1Var == hy1.b) {
            List list = gy1Var.a;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (L0(((ny1) list.get(i)).i)) {
                    int i2 = gy1Var.f;
                    if (i2 == 4) {
                        this.X = true;
                        K0();
                        return;
                    } else {
                        if (i2 == 5) {
                            M0();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public final void I0() {
        va vaVar;
        t42 t42Var = new t42();
        jd4.c(this, new kt1(18, t42Var));
        ww0 ww0Var = (ww0) t42Var.a;
        if (ww0Var == null || (vaVar = ww0Var.H) == null) {
            vaVar = this.H;
        }
        J0(vaVar);
    }

    public abstract void J0(ly1 ly1Var);

    public final void K0() {
        o42 o42Var = new o42();
        o42Var.a = true;
        jd4.e(this, new je0(o42Var));
        if (o42Var.a) {
            I0();
        }
    }

    public abstract boolean L0(int i);

    public final void M0() {
        if (this.X) {
            this.X = false;
            if (this.w) {
                t42 t42Var = new t42();
                jd4.c(this, new i7(1, t42Var));
                ww0 ww0Var = (ww0) t42Var.a;
                if (ww0Var != null) {
                    ww0Var.I0();
                } else {
                    J0(null);
                }
            }
        }
    }

    @Override // defpackage.qy1
    public final void h0() {
        M0();
    }

    @Override // defpackage.qy1
    public final long q() {
        if (this.x == null) {
            return q13.a;
        }
        jc0 jc0Var = cm4.g(this).h0;
        int i = q13.b;
        return xy.r(jc0Var.R(10.0f), jc0Var.R(40.0f), jc0Var.R(10.0f), jc0Var.R(40.0f));
    }
}
