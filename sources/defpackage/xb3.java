package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class xb3 {
    public static final ml1 a;
    public static final vb3[] b;

    static {
        ml1 ml1Var = new ml1(8);
        vb3.a.getClass();
        wb3 wb3Var = ub3.g;
        ml1Var.h(1, wb3Var);
        wb3 wb3Var2 = ub3.f;
        ml1Var.h(2, wb3Var2);
        wb3 wb3Var3 = ub3.b;
        ml1Var.h(4, wb3Var3);
        wb3 wb3Var4 = ub3.d;
        ml1Var.h(8, wb3Var4);
        wb3 wb3Var5 = ub3.h;
        ml1Var.h(16, wb3Var5);
        wb3 wb3Var6 = ub3.e;
        ml1Var.h(32, wb3Var6);
        wb3 wb3Var7 = ub3.i;
        ml1Var.h(64, wb3Var7);
        wb3 wb3Var8 = ub3.c;
        ml1Var.h(128, wb3Var8);
        a = ml1Var;
        b = new vb3[]{wb3Var, wb3Var2, wb3Var3, wb3Var7, wb3Var5, wb3Var6, wb3Var4, ub3.j, wb3Var8};
    }

    public static final void a(jf1 jf1Var, g11 g11Var, long j, int i, int i2) {
        if (oe4.a(j, -1L)) {
            return;
        }
        jf1Var.a(g11Var.b(), (int) ((j >>> 48) & 65535));
        jf1Var.a(g11Var.d(), (int) ((j >>> 32) & 65535));
        jf1Var.a(g11Var.c(), i - ((int) ((j >>> 16) & 65535)));
        jf1Var.a(g11Var.a(), i2 - ((int) (j & 65535)));
    }
}
