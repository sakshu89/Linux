package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class y03 implements q72 {
    public final long b;
    public final q72 c;

    public y03(long j, q72 q72Var) {
        hh1.a("Timeout must be non-negative.", j >= 0);
        this.b = j;
        this.c = q72Var;
    }

    @Override // defpackage.q72
    public final p72 a(gu guVar) {
        p72 p72VarA = this.c.a(guVar);
        long j = this.b;
        return (j <= 0 || guVar.b < j - p72VarA.a) ? p72VarA : p72.d;
    }

    @Override // defpackage.q72
    public final long b() {
        return this.b;
    }
}
