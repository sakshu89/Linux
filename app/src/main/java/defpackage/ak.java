package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ak implements sv {
    public final yj[] a;

    public ak(yj[] yjVarArr) {
        this.a = yjVarArr;
    }

    public final void a() {
        for (yj yjVar : this.a) {
            rd0 rd0Var = yjVar.n;
            if (rd0Var == null) {
                g31.f("handle");
                throw null;
            }
            rd0Var.a();
        }
    }

    @Override // defpackage.sv
    public final void b(Throwable th) {
        a();
    }

    public final String toString() {
        return "DisposeHandlersOnCancel[" + this.a + ']';
    }
}
