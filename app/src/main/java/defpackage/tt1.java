package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class tt1 {
    public fa a;
    public nl b;
    public float c = 1.0f;
    public z61 d = z61.a;

    public abstract void a(float f);

    public abstract void b(nl nlVar);

    public final void c(p71 p71Var, long j, float f, nl nlVar) {
        ew ewVar = p71Var.a;
        if (this.c != f) {
            a(f);
            this.c = f;
        }
        if (!g31.a(this.b, nlVar)) {
            b(nlVar);
            this.b = nlVar;
        }
        z61 layoutDirection = p71Var.getLayoutDirection();
        if (this.d != layoutDirection) {
            this.d = layoutDirection;
        }
        int i = (int) (j >> 32);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (ewVar.c() >> 32)) - Float.intBitsToFloat(i);
        int i2 = (int) (j & 4294967295L);
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (ewVar.c() & 4294967295L)) - Float.intBitsToFloat(i2);
        ((q82) ewVar.b.b).F(0.0f, 0.0f, fIntBitsToFloat, fIntBitsToFloat2);
        if (f > 0.0f) {
            try {
                if (Float.intBitsToFloat(i) > 0.0f && Float.intBitsToFloat(i2) > 0.0f) {
                    e(p71Var);
                }
            } finally {
                ((q82) ewVar.b.b).F(-0.0f, -0.0f, -fIntBitsToFloat, -fIntBitsToFloat2);
            }
        }
    }

    public abstract long d();

    public abstract void e(p71 p71Var);
}
