package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ts0 implements fq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ mt0 b;

    public /* synthetic */ ts0(mt0 mt0Var, int i) {
        this.a = i;
        this.b = mt0Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        Object value;
        Object value2;
        ee1 ee1Var;
        String str;
        boolean z = true;
        switch (this.a) {
            case 0:
                this.b.o();
                return q43.a;
            case 1:
                mt0 mt0Var = this.b;
                mt0Var.x = true;
                mt0Var.g(false);
                mt0Var.j();
                jr2 jr2Var = mt0Var.k;
                do {
                    value = jr2Var.getValue();
                } while (!jr2Var.h(value, ee1.a((ee1) value, false, null, null, "Another app is using audio output. I'm still listening.", 47)));
                return q43.a;
            case 2:
                mt0 mt0Var2 = this.b;
                mt0Var2.x = false;
                jr2 jr2Var2 = mt0Var2.k;
                do {
                    value2 = jr2Var2.getValue();
                    ee1Var = (ee1) value2;
                    str = ee1Var.e;
                } while (!jr2Var2.h(value2, ee1.a(ee1Var, false, null, null, (str == null || !cs2.n(str, "audio output", false)) ? ee1Var.e : null, 47)));
                ym ymVar = mt0Var2.I;
                if (ymVar != null) {
                    ymVar.a();
                }
                return q43.a;
            case 3:
                return Long.valueOf(this.b.T);
            default:
                mt0 mt0Var3 = this.b;
                if (!((Boolean) mt0Var3.f.f.getValue()).booleanValue() && !mt0Var3.v && !mt0Var3.w && !mt0Var3.x && mt0Var3.J) {
                    z = false;
                }
                return Boolean.valueOf(z);
        }
    }
}
