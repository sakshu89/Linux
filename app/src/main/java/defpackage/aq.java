package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class aq implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Object c;

    public /* synthetic */ aq(Object obj, boolean z, int i) {
        this.a = i;
        this.c = obj;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                bq bqVar = (bq) this.c;
                boolean z = this.b;
                if (bqVar.a != z) {
                    bqVar.a = z;
                    if (!z) {
                        dt dtVar = new dt("The camera control has became inactive.");
                        tp tpVar = bqVar.g;
                        if (tpVar != null) {
                            tpVar.b(dtVar);
                            bqVar.g = null;
                        }
                    } else if (bqVar.b) {
                        bqVar.c.t().a(new s7(3, bqVar), bqVar.d);
                        bqVar.b = false;
                    }
                    break;
                }
                break;
            default:
                yq yqVar = (yq) this.c;
                boolean z2 = this.b;
                yqVar.l0 = z2;
                if (z2 && yqVar.q0 == 4) {
                    yqVar.I(false);
                    break;
                }
                break;
        }
    }
}
