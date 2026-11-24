package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lr extends es {
    public final /* synthetic */ int a;
    public final /* synthetic */ tp b;

    public /* synthetic */ lr(tp tpVar, int i) {
        this.a = i;
        this.b = tpVar;
    }

    @Override // defpackage.es
    public final void a(int i) {
        int i2 = this.a;
        tp tpVar = this.b;
        switch (i2) {
            case 0:
                tpVar.b(new ty0("Capture request is cancelled because camera is closed", null));
                break;
            default:
                tpVar.b(new dt("Camera is closed"));
                break;
        }
    }

    @Override // defpackage.es
    public final void b(int i, ls lsVar) {
        int i2 = this.a;
        tp tpVar = this.b;
        switch (i2) {
            case 0:
                tpVar.a(null);
                break;
            default:
                xq4.c(3, "FocusMeteringControl");
                tpVar.a(null);
                break;
        }
    }

    @Override // defpackage.es
    public final void c(int i, el1 el1Var) {
        int i2 = this.a;
        tp tpVar = this.b;
        switch (i2) {
            case 0:
                tpVar.b(new ty0("Capture request failed with reason ".concat("ERROR"), null));
                break;
            default:
                tpVar.b(new dt());
                break;
        }
    }
}
