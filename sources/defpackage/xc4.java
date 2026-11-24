package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class xc4 {
    public static final int a(np0 np0Var, int i) {
        boolean z = g31.b(np0Var.a, np0.b.a) >= 0;
        boolean z2 = i == 1;
        if (z2 && z) {
            return 3;
        }
        if (z) {
            return 1;
        }
        return z2 ? 2 : 0;
    }

    public static final Object b(w03 w03Var, vq0 vq0Var) {
        hp4.d(w03Var, true, new ud0(bm4.c(w03Var.i.f()).A(w03Var.j, w03Var, w03Var.f)));
        return ee4.b(w03Var, false, w03Var, vq0Var);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object c(long j, vq0 vq0Var, y50 y50Var) {
        x03 x03Var;
        t42 t42Var;
        if (y50Var instanceof x03) {
            x03Var = (x03) y50Var;
            int i = x03Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                x03Var.i = i - Integer.MIN_VALUE;
            } else {
                x03Var = new x03(y50Var);
            }
        } else {
            x03Var = new x03(y50Var);
        }
        Object obj = x03Var.f;
        int i2 = x03Var.i;
        if (i2 == 0) {
            bz3.g(obj);
            if (j > 0) {
                t42 t42Var2 = new t42();
                try {
                    x03Var.e = t42Var2;
                    x03Var.i = 1;
                    w03 w03Var = new w03(j, x03Var);
                    t42Var2.a = w03Var;
                    Object objB = b(w03Var, vq0Var);
                    t70 t70Var = t70.a;
                    return objB == t70Var ? t70Var : objB;
                } catch (v03 e) {
                    e = e;
                    t42Var = t42Var2;
                }
            }
            return null;
        }
        if (i2 != 1) {
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        t42Var = x03Var.e;
        try {
            bz3.g(obj);
            return obj;
        } catch (v03 e2) {
            e = e2;
        }
        if (e.a != t42Var.a) {
            throw e;
        }
        return null;
    }
}
