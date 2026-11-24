package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class id1 {
    public final dp1 a;
    public boolean b;
    public int c = -1;
    public final /* synthetic */ jd1 d;

    public id1(jd1 jd1Var, dp1 dp1Var) {
        this.d = jd1Var;
        this.a = dp1Var;
    }

    public final void a(boolean z) {
        if (z == this.b) {
            return;
        }
        this.b = z;
        int i = z ? 1 : -1;
        jd1 jd1Var = this.d;
        int i2 = jd1Var.c;
        jd1Var.c = i + i2;
        if (!jd1Var.d) {
            jd1Var.d = true;
            while (true) {
                try {
                    int i3 = jd1Var.c;
                    if (i2 == i3) {
                        break;
                    }
                    boolean z2 = i2 == 0 && i3 > 0;
                    boolean z3 = i2 > 0 && i3 == 0;
                    if (z2) {
                        jd1Var.e();
                    } else if (z3) {
                        jd1Var.f();
                    }
                    i2 = i3;
                } catch (Throwable th) {
                    jd1Var.d = false;
                    throw th;
                }
            }
            jd1Var.d = false;
        }
        if (this.b) {
            jd1Var.b(this);
        }
    }
}
