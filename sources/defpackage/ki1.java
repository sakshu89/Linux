package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ki1 implements dp1 {
    public final jd1 a;
    public final zq b;
    public int c = -1;

    public ki1(jd1 jd1Var, zq zqVar) {
        this.a = jd1Var;
        this.b = zqVar;
    }

    public final void a() {
        this.a.d(this);
    }

    @Override // defpackage.dp1
    public final void u(Object obj) {
        int i = this.c;
        int i2 = this.a.g;
        if (i != i2) {
            this.c = i2;
            this.b.u(obj);
        }
    }
}
