package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fy0 {
    public float a;
    public float b;

    public final long a(long j, float f, rn2 rn2Var, float f2) {
        rn2Var.getClass();
        float f3 = f - this.a;
        this.a = f;
        float f4 = ((((f3 * (rn2Var.a() ? 2.0f : 1.0f)) * ((f2 * 1.5f) + 1.0f)) / 6.0f) + this.b) % 1.0f;
        this.b = f4;
        return ki4.f(j, sz.c(j, ki4.c(4281236479L)) ? ki4.c(4278248959L) : ki4.f(j, sz.c, 0.25f), (((float) Math.sin((f4 * 6.2831855f) - 1.5707964f)) + 1.0f) / 2.0f);
    }
}
