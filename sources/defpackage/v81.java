package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class v81 {
    public final y92 a;
    public final hc b;
    public final gm1 c;

    public v81(y92 y92Var, hc hcVar) {
        this.a = y92Var;
        this.b = hcVar;
        long[] jArr = ya2.a;
        this.c = new gm1();
    }

    public final vq0 a(int i, Object obj, Object obj2) {
        gm1 gm1Var = this.c;
        u81 u81Var = (u81) gm1Var.g(obj);
        int i2 = 6;
        if (u81Var != null && u81Var.c == i && g31.a(u81Var.b, obj2)) {
            w10 w10Var = u81Var.d;
            if (w10Var != null) {
                return w10Var;
            }
            w10 w10Var2 = new w10(818252804, true, new km(i2, u81Var.e, u81Var));
            u81Var.d = w10Var2;
            return w10Var2;
        }
        u81 u81Var2 = new u81(this, i, obj, obj2);
        gm1Var.m(obj, u81Var2);
        w10 w10Var3 = u81Var2.d;
        if (w10Var3 != null) {
            return w10Var3;
        }
        w10 w10Var4 = new w10(818252804, true, new km(i2, this, u81Var2));
        u81Var2.d = w10Var4;
        return w10Var4;
    }

    public final Object b(Object obj) {
        if (obj != null) {
            u81 u81Var = (u81) this.c.g(obj);
            if (u81Var != null) {
                return u81Var.b;
            }
            t91 t91Var = (t91) this.b.a();
            int iC = t91Var.d.c(obj);
            if (iC != -1) {
                t91Var.b(iC);
            }
        }
        return null;
    }
}
