package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vp extends w1 {
    public final /* synthetic */ wp k;

    public vp(wp wpVar) {
        this.k = wpVar;
    }

    @Override // defpackage.w1
    public final String g() {
        tp tpVar = (tp) this.k.a.get();
        if (tpVar == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        return "tag=[" + tpVar.a + "]";
    }
}
