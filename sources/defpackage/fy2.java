package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fy2 {
    public static final q91 g;
    public final gu1 a;
    public final gu1 b = new gu1(0.0f);
    public final hu1 c = new hu1(0);
    public l42 d = l42.e;
    public long e = oz2.b;
    public final ku1 f;

    static {
        ra2 ra2Var = new ra2(19);
        xn2 xn2Var = new xn2(14);
        ha haVar = new ha(5, ra2Var);
        h33.c(1, xn2Var);
        g = new q91(26, haVar, xn2Var);
    }

    public fy2(js1 js1Var, float f) {
        this.a = new gu1(f);
        this.f = new ku1(js1Var, su0.k);
    }

    public final void a(js1 js1Var, l42 l42Var, int i, int i2) {
        float f;
        float f2 = i2 - i;
        this.b.h(f2);
        float f3 = l42Var.a;
        float f4 = l42Var.b;
        l42 l42Var2 = this.d;
        float f5 = l42Var2.a;
        gu1 gu1Var = this.a;
        if (f3 != f5 || f4 != l42Var2.b) {
            boolean z = js1Var == js1.a;
            if (z) {
                f3 = f4;
            }
            float f6 = z ? l42Var.d : l42Var.c;
            float fG = gu1Var.g();
            float f7 = i;
            float f8 = fG + f7;
            if (f6 <= f8 && (f3 >= fG || f6 - f3 <= f7)) {
                f = (f3 >= fG || f6 - f3 > f7) ? 0.0f : f3 - fG;
            } else {
                f = f6 - f8;
            }
            gu1Var.h(gu1Var.g() + f);
            this.d = l42Var;
        }
        gu1Var.h(ky3.b(gu1Var.g(), 0.0f, f2));
        this.c.h(i);
    }
}
