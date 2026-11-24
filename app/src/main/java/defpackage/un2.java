package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class un2 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ un2(boolean z, int i) {
        this.a = i;
        this.b = z;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.a;
        q43 q43Var = q43.a;
        boolean z = this.b;
        og2 og2Var = (og2) obj;
        switch (i) {
            case 0:
                og2Var.getClass();
                mg2.b(og2Var, z ? "Open settings" : "Back to Sonic");
                break;
            default:
                og2Var.getClass();
                mg2.b(og2Var, z ? "Unmute Sonic" : "Mute Sonic");
                break;
        }
        return q43Var;
    }
}
