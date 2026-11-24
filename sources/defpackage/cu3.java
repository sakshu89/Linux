package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class cu3 extends au3 {
    @Override // defpackage.au3
    public final gu3 b() {
        boolean zG = ((du3) this.b).g();
        gu3 gu3Var = this.b;
        if (!zG) {
            return (du3) gu3Var;
        }
        ((du3) gu3Var).zbb.d();
        return (du3) super.b();
    }

    @Override // defpackage.au3
    public final jt3 c() {
        boolean zG = ((du3) this.b).g();
        gu3 gu3Var = this.b;
        if (!zG) {
            return (du3) gu3Var;
        }
        ((du3) gu3Var).zbb.d();
        return (du3) super.b();
    }

    @Override // defpackage.au3
    public final void e() {
        super.e();
        gu3 gu3Var = this.b;
        if (((du3) gu3Var).zbb != wt3.c) {
            du3 du3Var = (du3) gu3Var;
            du3Var.zbb = du3Var.zbb.clone();
        }
    }
}
