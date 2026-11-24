package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class uq implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ kf b;

    public /* synthetic */ uq(kf kfVar, int i) {
        this.a = i;
        this.b = kfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        kf kfVar = this.b;
        switch (i) {
            case 0:
                int i2 = 1;
                if (!((AtomicBoolean) kfVar.c).getAndSet(true)) {
                    ((yq) ((l11) kfVar.e).c).c.execute(new uq(kfVar, i2));
                    break;
                }
                break;
            default:
                int i3 = ((yq) ((l11) kfVar.e).c).q0;
                l11 l11Var = (l11) kfVar.e;
                if (i3 == 8) {
                    ((yq) l11Var.c).t("Camera onError timeout, reopen it.");
                    ((yq) ((l11) kfVar.e).c).E(7);
                    ((yq) ((l11) kfVar.e).c).k.b();
                } else {
                    yq yqVar = (yq) l11Var.c;
                    yqVar.t("Camera skip reopen at state: ".concat(cq.y(yqVar.q0)));
                }
                break;
        }
    }
}
