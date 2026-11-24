package defpackage;

import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nq implements up {
    public final /* synthetic */ int a;
    public final /* synthetic */ yq b;

    public /* synthetic */ nq(yq yqVar, int i) {
        this.a = i;
        this.b = yqVar;
    }

    @Override // defpackage.up
    public Object d(tp tpVar) {
        int i = this.a;
        yq yqVar = this.b;
        switch (i) {
            case 0:
                try {
                    yqVar.c.execute(new o8(6, yqVar, tpVar));
                    return "isMeteringRepeatingAttached";
                } catch (RejectedExecutionException unused) {
                    tpVar.b(new RuntimeException("Unable to check if MeteringRepeating is attached. Camera executor shut down."));
                    return "isMeteringRepeatingAttached";
                }
            default:
                try {
                    ArrayList arrayList = new ArrayList(yqVar.a.a().b().c);
                    arrayList.add((mt) yqVar.g0.g);
                    arrayList.add(new rq(yqVar, tpVar));
                    yqVar.b.a.D(yqVar.n.a, yqVar.c, lg4.a(arrayList));
                    return "configAndCloseTask";
                } catch (ds | SecurityException e) {
                    yqVar.t("Unable to open camera for configAndClose: " + e.getMessage());
                    tpVar.b(e);
                    return "configAndCloseTask";
                }
        }
    }
}
