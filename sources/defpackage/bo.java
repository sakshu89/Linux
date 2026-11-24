package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class bo {
    public static final qt1 a;
    public static final float b;
    public static final float c;

    static {
        float f = af4.a;
        float f2 = af4.b;
        a = new qt1(f, 8.0f, f2, 8.0f);
        if (!((f2 >= 0.0f) & (16.0f >= 0.0f) & (8.0f >= 0.0f) & (8.0f >= 0.0f))) {
            x01.a("Padding must be non-negative");
        }
        if (!((12.0f >= 0.0f) & (8.0f >= 0.0f) & (12.0f >= 0.0f) & (8.0f >= 0.0f))) {
            x01.a("Padding must be non-negative");
        }
        if (!((16.0f >= 0.0f) & (12.0f >= 0.0f) & (8.0f >= 0.0f) & (8.0f >= 0.0f))) {
            x01.a("Padding must be non-negative");
        }
        b = 58.0f;
        c = 40.0f;
    }

    public static ao a(long j, long j2, x20 x20Var) {
        ao aoVar;
        long j3 = sz.g;
        yz yzVar = (yz) x20Var.j(a00.a);
        ao aoVar2 = yzVar.W;
        if (aoVar2 == null) {
            ao aoVar3 = new ao(a00.a(yzVar, hz3.a), a00.a(yzVar, hz3.g), sz.b(hz3.c, a00.a(yzVar, hz3.b)), sz.b(hz3.e, a00.a(yzVar, hz3.d)));
            yzVar.W = aoVar3;
            aoVar = aoVar3;
        } else {
            aoVar = aoVar2;
        }
        return aoVar.a(j, j2, j3, j3);
    }

    public static ao b(yz yzVar) {
        ao aoVar = yzVar.X;
        if (aoVar != null) {
            return aoVar;
        }
        long j = sz.f;
        ao aoVar2 = new ao(j, a00.a(yzVar, a34.c), j, sz.b(a34.b, a00.a(yzVar, a34.a)));
        yzVar.X = aoVar2;
        return aoVar2;
    }

    public static ao c(long j, long j2, x20 x20Var, int i) {
        if ((i & 1) != 0) {
            j = sz.g;
        }
        long j3 = j;
        long j4 = sz.g;
        return b((yz) x20Var.j(a00.a)).a(j3, j2, j4, j4);
    }
}
