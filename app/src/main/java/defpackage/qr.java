package defpackage;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qr implements ch, up {
    public final /* synthetic */ int a;
    public final /* synthetic */ rr b;

    public /* synthetic */ qr(rr rrVar, int i) {
        this.a = i;
        this.b = rrVar;
    }

    @Override // defpackage.ch
    /* JADX INFO: renamed from: apply */
    public wc1 mo28apply(Object obj) {
        int i = this.a;
        rr rrVar = this.b;
        switch (i) {
            case 0:
                return rrVar.a.h.b(true);
            case 1:
                return hg4.a(new qr(rrVar, 4));
            case 2:
                return rrVar.a.h.c();
            default:
                ScheduledExecutorService scheduledExecutorService = rrVar.c;
                kq kqVar = rrVar.a;
                or orVar = new or(new og(14));
                kqVar.j(orVar);
                o8 o8Var = new o8(9, kqVar, orVar);
                ch2 ch2Var = kqVar.c;
                wp wpVar = orVar.b;
                wpVar.b.a(o8Var, ch2Var);
                return hg4.a(new kr0(wpVar, scheduledExecutorService, 2000L, 1));
        }
    }

    @Override // defpackage.up
    public Object d(tp tpVar) {
        rr rrVar = this.b;
        if (!rrVar.e.q()) {
            tpVar.a(null);
            return "EnableTorchInternal";
        }
        xq4.c(3, "Camera2CapturePipeline");
        rrVar.a.l(true);
        tpVar.a(null);
        return "EnableTorchInternal";
    }
}
