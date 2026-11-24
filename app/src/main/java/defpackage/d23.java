package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d23 implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ j23 b;

    public /* synthetic */ d23(j23 j23Var, int i) {
        this.a = i;
        this.b = j23Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        int i = this.a;
        j23 j23Var = this.b;
        switch (i) {
            case 0:
                return Boolean.valueOf((g31.a(j23Var.d.getValue(), j23Var.c()) && j23Var.g.g() == Long.MIN_VALUE && !((Boolean) j23Var.h.getValue()).booleanValue()) ? false : true);
            default:
                return Long.valueOf(j23Var.b());
        }
    }
}
