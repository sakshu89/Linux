package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zp implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ bq b;
    public final /* synthetic */ tp c;

    public /* synthetic */ zp(bq bqVar, tp tpVar, int i) {
        this.a = i;
        this.b = bqVar;
        this.c = tpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        tp tpVar = this.c;
        bq bqVar = this.b;
        switch (i) {
            case 0:
                bqVar.b = true;
                dt dtVar = new dt("Camera2CameraControl was updated with new options.");
                tp tpVar2 = bqVar.g;
                if (tpVar2 != null) {
                    tpVar2.b(dtVar);
                    bqVar.g = null;
                }
                bqVar.g = tpVar;
                if (bqVar.a) {
                    bqVar.c.t().a(new s7(3, bqVar), bqVar.d);
                    bqVar.b = false;
                }
                break;
            default:
                bqVar.b = true;
                dt dtVar2 = new dt("Camera2CameraControl was updated with new options.");
                tp tpVar3 = bqVar.g;
                if (tpVar3 != null) {
                    tpVar3.b(dtVar2);
                    bqVar.g = null;
                }
                bqVar.g = tpVar;
                if (bqVar.a) {
                    bqVar.c.t().a(new s7(3, bqVar), bqVar.d);
                    bqVar.b = false;
                }
                break;
        }
    }
}
