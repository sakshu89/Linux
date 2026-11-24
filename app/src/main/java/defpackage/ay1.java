package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ay1 {
    public static final sr2 a = new sr2(k30.t);

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final void a(pa1 pa1Var, aa aaVar, y50 y50Var) {
        yx1 yx1Var;
        if (y50Var instanceof yx1) {
            yx1Var = (yx1) y50Var;
            int i = yx1Var.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                yx1Var.f = i - Integer.MIN_VALUE;
            } else {
                yx1Var = new yx1(y50Var);
            }
        } else {
            yx1Var = new yx1(y50Var);
        }
        Object obj = yx1Var.e;
        int i2 = yx1Var.f;
        if (i2 != 0) {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return;
            } else {
                bz3.g(obj);
                og.k();
                return;
            }
        }
        bz3.g(obj);
        if (!pa1Var.a.w) {
            og.i("establishTextInputSession called from an unattached node");
            return;
        }
        it1 it1VarH = cm4.h(pa1Var);
        gw1 gw1Var = (gw1) cm4.g(pa1Var).k0;
        gw1Var.getClass();
        if (mj4.a(gw1Var, a) != null) {
            dk0.t();
        } else {
            yx1Var.f = 1;
            b(it1VarH, aaVar, yx1Var);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final void b(it1 it1Var, vq0 vq0Var, y50 y50Var) {
        zx1 zx1Var;
        if (y50Var instanceof zx1) {
            zx1Var = (zx1) y50Var;
            int i = zx1Var.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                zx1Var.f = i - Integer.MIN_VALUE;
            } else {
                zx1Var = new zx1(y50Var);
            }
        } else {
            zx1Var = new zx1(y50Var);
        }
        Object obj = zx1Var.e;
        int i2 = zx1Var.f;
        if (i2 == 0) {
            bz3.g(obj);
            zx1Var.f = 1;
            ((r7) it1Var).E(vq0Var, zx1Var);
        } else if (i2 == 1) {
            bz3.g(obj);
            og.k();
        } else if (i2 != 2) {
            og.n("call to 'resume' before 'invoke' with coroutine");
        } else {
            bz3.g(obj);
            og.k();
        }
    }
}
