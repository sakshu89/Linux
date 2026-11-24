package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class m30 extends z12 {
    public final /* synthetic */ int b = 1;
    public final Object c;

    public m30(hq0 hq0Var) {
        super(new e4(7));
        this.c = new n30(hq0Var);
    }

    @Override // defpackage.z12
    public final a22 a(Object obj) {
        switch (this.b) {
            case 0:
                return new a22(this, obj, obj == null, null, true);
            default:
                return new a22(this, obj, obj == null, (om2) this.c, true);
        }
    }

    @Override // defpackage.z12
    public h63 b() {
        switch (this.b) {
            case 0:
                return (n30) this.c;
            default:
                return super.b();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m30(fq0 fq0Var) {
        super(fq0Var);
        su0 su0Var = su0.k;
        this.c = su0Var;
    }
}
