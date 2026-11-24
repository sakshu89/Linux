package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class jj0 extends l70 {
    public static final /* synthetic */ int i = 0;
    public long c;
    public boolean e;
    public hg f;

    public final void P(boolean z) {
        long j = this.c - (z ? 4294967296L : 1L);
        this.c = j;
        if (j <= 0 && this.e) {
            shutdown();
        }
    }

    public final void Q(jd0 jd0Var) {
        hg hgVar = this.f;
        if (hgVar == null) {
            hgVar = new hg();
            this.f = hgVar;
        }
        hgVar.addLast(jd0Var);
    }

    public final void R(boolean z) {
        this.c = (z ? 4294967296L : 1L) + this.c;
        if (z) {
            return;
        }
        this.e = true;
    }

    public abstract long S();

    public final boolean T() {
        hg hgVar = this.f;
        if (hgVar == null) {
            return false;
        }
        jd0 jd0Var = (jd0) (hgVar.isEmpty() ? null : hgVar.removeFirst());
        if (jd0Var == null) {
            return false;
        }
        jd0Var.run();
        return true;
    }

    public abstract void shutdown();
}
