package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i12 implements mm1, s70 {
    public final /* synthetic */ mm1 a;
    public final j70 b;

    public i12(mm1 mm1Var, j70 j70Var) {
        this.a = mm1Var;
        this.b = j70Var;
    }

    @Override // defpackage.gr2
    public final Object getValue() {
        return this.a.getValue();
    }

    @Override // defpackage.s70
    public final j70 o() {
        return this.b;
    }

    @Override // defpackage.mm1
    public final void setValue(Object obj) {
        this.a.setValue(obj);
    }
}
